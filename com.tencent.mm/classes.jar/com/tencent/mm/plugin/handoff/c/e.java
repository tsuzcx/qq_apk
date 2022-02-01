package com.tencent.mm.plugin.handoff.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffFile.a;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.k;
import kotlin.o;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffService;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "FIX_DELAY", "", "MAC_MULTI_TASK_VERSION", "", "MSG_FIX", "PC_MULTI_TASK_VERSION", "PC_SUPPORT_VERSION", "TAG", "", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "fileCache", "Landroid/support/v4/util/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "handler", "Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "isForeground", "", "isInQB", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "getOnlineInfo", "()Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "setOnlineInfo", "(Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;)V", "qbFile", "requestProcessor", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "statusManager", "Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "wc", "add", "", "handOff", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "ballInfo2HandOff", "cache", "cancelUpload", "id", "del", "key", "delAllFloatingWindow", "doFix", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isMac", "isMultiTaskVersion", "isPC", "isSupportOpenInComputer", "mod", "modFromBallInfo", "notifyQbOpenResult", "errorCode", "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onRegister", "onUnregister", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "runInHandOffThread", "block", "Lkotlin/Function0;", "sendOpenRequest", "toastOpenResult", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "updateQbMenuIfNeed", "uploadFail", "arg", "uploadStart", "info", "uploadSuccess", "appId", "sdkVersion", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "upsert", "FixHandler", "NotifyUserStatusChangeTask", "plugin-handoff_release"})
public final class e
  implements com.tencent.mm.kernel.c.b, com.tencent.mm.plugin.handoff.a.a, MStorage.IOnStorageChange
{
  private static boolean cQp;
  static HandOff yid;
  private static HandOff yie;
  private static ConcurrentHashMap<String, HandOff> yif;
  private static final android.support.v4.e.a<String, o<HandOffFile, c>> yig;
  private static final a yih;
  private static GetOnLineInfoInfoResult yii;
  private static boolean yij;
  private static final h yik;
  private static final d yil;
  public static final e yim;
  
  static
  {
    AppMethodBeat.i(10371);
    yim = new e();
    yif = new ConcurrentHashMap();
    yig = new android.support.v4.e.a();
    Object localObject = com.tencent.mm.kernel.g.aAk();
    p.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getLooper();
    p.g(localObject, "MMKernel.getPizzaWorkerThread().looper");
    yih = new a((Looper)localObject);
    yii = new GetOnLineInfoInfoResult();
    cQp = true;
    localObject = com.tencent.mm.kernel.g.aAk();
    p.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getLooper();
    p.g(localObject, "MMKernel.getPizzaWorkerThread().looper");
    yik = new h((Looper)localObject);
    localObject = com.tencent.mm.kernel.g.aAk();
    p.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getLooper();
    p.g(localObject, "MMKernel.getPizzaWorkerThread().looper");
    yil = new d((Looper)localObject);
    AppMethodBeat.o(10371);
  }
  
  @SuppressLint({"SwitchIntDef"})
  private static final HandOff P(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10341);
    String str1 = null;
    Object localObject = str1;
    switch (paramBallInfo.type)
    {
    default: 
      localObject = str1;
    }
    while (localObject != null)
    {
      str1 = paramBallInfo.key;
      p.g(str1, "ballInfo.key");
      ((HandOff)localObject).setKey(str1);
      ((HandOff)localObject).setCreateTime(paramBallInfo.createTime);
      paramBallInfo = paramBallInfo.jkf.getString("handoff#id");
      if (paramBallInfo != null)
      {
        p.g(paramBallInfo, "it");
        ((HandOff)localObject).setId(paramBallInfo);
      }
      AppMethodBeat.o(10341);
      return localObject;
      String str2 = Util.nullAsNil(paramBallInfo.name);
      localObject = Util.nullAsNil(paramBallInfo.jkf.getString("handoff#shareUrl"));
      str1 = Util.nullAsNil(paramBallInfo.jkf.getString("rawUrl"));
      String str3 = Util.nullAsNil(paramBallInfo.icon);
      p.g(str2, "title");
      p.g(localObject, "shareUrl");
      int i;
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        label189:
        if (i == 0) {
          break label239;
        }
      }
      for (;;)
      {
        p.g(localObject, "if (shareUrl.isNotEmpty()) shareUrl else url");
        p.g(str3, "icon");
        localObject = (HandOff)new HandOffURL(str2, (String)localObject, str3, 2, null, null, null, 112, null);
        break;
        i = 0;
        break label189;
        label239:
        localObject = str1;
      }
      localObject = Util.nullAsNil(paramBallInfo.icon);
      str1 = Util.nullAsNil(paramBallInfo.name);
      str2 = Util.nullAsNil(paramBallInfo.jkf.getString("appId"));
      str3 = Util.nullAsNil(paramBallInfo.jkf.getString("username"));
      p.g(localObject, "icon");
      p.g(str1, "title");
      p.g(str2, "appId");
      p.g(str3, "username");
      localObject = (HandOff)new HandOffMP((String)localObject, str1, str2, "", str3, 2, null, null, null, 448, null);
      continue;
      localObject = HandOffFile.Companion;
      localObject = (HandOff)HandOffFile.a.fromBallInfo(paramBallInfo);
    }
    AppMethodBeat.o(10341);
    return null;
  }
  
  public static void T(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(199205);
    Object localObject = Thread.currentThread();
    Looper localLooper = yih.getLooper();
    p.g(localLooper, "handler.looper");
    if (p.j(localObject, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(199205);
      return;
    }
    localObject = yih;
    if (parama != null) {
      parama = new f(parama);
    }
    for (;;)
    {
      ((a)localObject).post((Runnable)parama);
      AppMethodBeat.o(199205);
      return;
    }
  }
  
  public static GetOnLineInfoInfoResult dYq()
  {
    return yii;
  }
  
  private static boolean dYr()
  {
    return yii.jjN == 1;
  }
  
  public static void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(10353);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new c(paramHandOff));
    AppMethodBeat.o(10353);
  }
  
  public static void l(HandOff paramHandOff)
  {
    AppMethodBeat.i(10354);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new g(paramHandOff));
    AppMethodBeat.o(10354);
  }
  
  public final void O(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10351);
    p.h(paramBallInfo, "ballInfo");
    paramBallInfo = P(paramBallInfo);
    if (paramBallInfo != null)
    {
      k(paramBallInfo);
      AppMethodBeat.o(10351);
      return;
    }
    AppMethodBeat.o(10351);
  }
  
  public final void a(GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult)
  {
    AppMethodBeat.i(199202);
    p.h(paramGetOnLineInfoInfoResult, "onlineInfo");
    Log.i("HandOffService", "notifyUserStatusChange: ".concat(String.valueOf(paramGetOnLineInfoInfoResult)));
    yii = paramGetOnLineInfoInfoResult;
    com.tencent.mm.ipcinvoker.h.a(ToolsProcessIPCService.dkO, (Parcelable)paramGetOnLineInfoInfoResult, b.class, (com.tencent.mm.ipcinvoker.d)h.yip);
    com.tencent.mm.ipcinvoker.h.a(ToolsMpProcessIPCService.dkO, (Parcelable)paramGetOnLineInfoInfoResult, b.class, (com.tencent.mm.ipcinvoker.d)i.yiq);
    if (yij)
    {
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", 3);
        Object localObject = yie;
        paramGetOnLineInfoInfoResult = (GetOnLineInfoInfoResult)localObject;
        if (!(localObject instanceof HandOffFile)) {
          paramGetOnLineInfoInfoResult = null;
        }
        paramGetOnLineInfoInfoResult = (HandOffFile)paramGetOnLineInfoInfoResult;
        if (paramGetOnLineInfoInfoResult != null)
        {
          paramGetOnLineInfoInfoResult = paramGetOnLineInfoInfoResult.getFullPath();
          paramGetOnLineInfoInfoResult = com.tencent.mm.vfs.s.akC(paramGetOnLineInfoInfoResult);
          if (!dYl()) {
            break label232;
          }
          localObject = HandOffFile.Companion;
          if (!HandOffFile.a.isSupportOpenFile(paramGetOnLineInfoInfoResult)) {
            break label232;
          }
        }
        label232:
        for (boolean bool = true;; bool = false)
        {
          localJSONObject.put("isShow", bool);
          localJSONArray.put(localJSONObject);
          localIntent.putExtra("menuItems", localJSONArray.toString());
          MMApplicationContext.getContext().sendBroadcast(localIntent);
          AppMethodBeat.o(199202);
          return;
          paramGetOnLineInfoInfoResult = null;
          break;
        }
        AppMethodBeat.o(199202);
      }
      catch (Exception paramGetOnLineInfoInfoResult)
      {
        Log.e("HandOffService", "UpdateQbMenuIfNeed() Exception:%s %s", new Object[] { paramGetOnLineInfoInfoResult.getClass().getSimpleName(), paramGetOnLineInfoInfoResult.getMessage() });
      }
    }
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10346);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new q(paramHandOff));
    AppMethodBeat.o(10346);
  }
  
  public final boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(10358);
    p.h(paramString, "id");
    p.h(paramc, "info");
    Iterator localIterator = ((Map)yif).entrySet().iterator();
    while (localIterator.hasNext())
    {
      HandOff localHandOff = (HandOff)((Map.Entry)localIterator.next()).getValue();
      if (((localHandOff instanceof HandOffFile)) && (p.j(localHandOff.getId(), paramString)))
      {
        ((Map)yig).put(paramString, new o(localHandOff, paramc));
        AppMethodBeat.o(10358);
        return true;
      }
    }
    AppMethodBeat.o(10358);
    return false;
  }
  
  public final void aBA(String paramString)
  {
    AppMethodBeat.i(10363);
    p.h(paramString, "id");
    o localo = (o)yig.get(paramString);
    if (localo != null)
    {
      ((c)localo.second).field_status = 105L;
      yig.remove(paramString);
      AppMethodBeat.o(10363);
      return;
    }
    Log.e("HandOffService", "error in cancel file upload, handoff with md5 [" + paramString + "] lost!");
    AppMethodBeat.o(10363);
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(10342);
    Log.i("HandOffService", "onRegister");
    AppMethodBeat.o(10342);
  }
  
  public final void aBd()
  {
    AppMethodBeat.i(10343);
    Log.i("HandOffService", "onUnregister");
    AppMethodBeat.o(10343);
  }
  
  public final HandOff aBx(String paramString)
  {
    AppMethodBeat.i(199197);
    p.h(paramString, "key");
    paramString = (HandOff)yif.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.copy();
      AppMethodBeat.o(199197);
      return paramString;
    }
    AppMethodBeat.o(199197);
    return null;
  }
  
  public final HandOff aBy(String paramString)
  {
    AppMethodBeat.i(10350);
    p.h(paramString, "id");
    Object localObject = yif.values();
    p.g(localObject, "items.values");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.j(((HandOff)localObject).getId(), paramString));
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (HandOff)paramString;
      AppMethodBeat.o(10350);
      return paramString;
    }
  }
  
  public final void aBz(String paramString)
  {
    AppMethodBeat.i(199200);
    p.h(paramString, "key");
    T((kotlin.g.a.a)new t(paramString));
    AppMethodBeat.o(199200);
  }
  
  public final void av(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10361);
    p.h(paramString1, "id");
    p.h(paramString2, "cdnURL");
    p.h(paramString3, "aesKey");
    o localo = (o)yig.get(paramString1);
    if (localo != null)
    {
      ((HandOffFile)localo.first).setCdnURL(paramString2);
      ((HandOffFile)localo.first).setAesKey(paramString3);
      yik.o((HandOff)localo.first);
      yig.remove(paramString1);
      AppMethodBeat.o(10361);
      return;
    }
    Log.e("HandOffService", "error in file upload success, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10361);
  }
  
  public final boolean az(String paramString, long paramLong)
  {
    AppMethodBeat.i(10359);
    p.h(paramString, "id");
    Object localObject = (o)yig.get(paramString);
    if (localObject != null)
    {
      paramString = yik;
      localObject = (HandOff)((o)localObject).first;
      p.h(localObject, "handOff");
      paramString.a(7, (Collection)j.listOf(localObject));
      AppMethodBeat.o(10359);
      return true;
    }
    Log.w("HandOffService", "error in file uploading, handoff with id [" + paramString + "] lost!");
    AppMethodBeat.o(10359);
    return false;
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10347);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new r(paramHandOff));
    AppMethodBeat.o(10347);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10348);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new l(paramHandOff));
    AppMethodBeat.o(10348);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10349);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new m(paramHandOff));
    AppMethodBeat.o(10349);
  }
  
  public final void d(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(199198);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    T((kotlin.g.a.a)new d(paramMultiTaskInfo));
    AppMethodBeat.o(199198);
  }
  
  public final void dYj()
  {
    AppMethodBeat.i(10344);
    yih.removeMessages(1);
    yih.sendEmptyMessageDelayed(1, 10000L);
    AppMethodBeat.o(10344);
  }
  
  public final void dYk()
  {
    AppMethodBeat.i(10357);
    T((kotlin.g.a.a)e.yio);
    AppMethodBeat.o(10357);
  }
  
  public final boolean dYl()
  {
    AppMethodBeat.i(199203);
    if ((dYr()) && (yii.kDf) && (yii.jjS >= 1661009920))
    {
      AppMethodBeat.o(199203);
      return true;
    }
    AppMethodBeat.o(199203);
    return false;
  }
  
  public final HandOff dYm()
  {
    return yid;
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10356);
    p.h(paramString, "key");
    T((kotlin.g.a.a)new f(paramString));
    AppMethodBeat.o(10356);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10355);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new x(paramHandOff));
    AppMethodBeat.o(10355);
  }
  
  public final void e(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(199199);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    T((kotlin.g.a.a)new w(paramMultiTaskInfo));
    AppMethodBeat.o(199199);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10362);
    p.h(paramString1, "id");
    p.h(paramString2, "appId");
    p.h(paramString3, "mediaId");
    o localo = (o)yig.get(paramString1);
    if (localo != null)
    {
      ((HandOffFile)localo.first).setAppId(paramString2);
      ((HandOffFile)localo.first).setSdkVersion(paramInt);
      ((HandOffFile)localo.first).setMediaId(paramString3);
      yik.o((HandOff)localo.first);
      yig.remove(paramString1);
      AppMethodBeat.o(10362);
      return;
    }
    Log.e("HandOffService", "error in file upload success, handoff with md5 [" + paramString1 + "] lost!");
    AppMethodBeat.o(10362);
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(199201);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new v(paramHandOff));
    AppMethodBeat.o(199201);
  }
  
  public final void ff(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10345);
    p.h(paramList, "ballInfoList");
    Log.i("HandOffService", "restore from ballInfoList");
    yif.clear();
    yig.clear();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    HandOff localHandOff;
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = P((BallInfo)((Iterator)localObject).next());
      if (localHandOff != null) {
        paramList.add(localHandOff);
      }
    }
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = (HandOff)((Iterator)localObject).next();
      paramList.add(kotlin.s.U(localHandOff.getKey(), localHandOff));
    }
    ae.a((Iterable)paramList, (Map)yif);
    try
    {
      com.tencent.mm.kernel.g.aAf();
      if (com.tencent.mm.kernel.a.azo())
      {
        paramList = yik;
        localObject = yif.values();
        p.g(localObject, "items.values");
        paramList.l((Collection)localObject);
        AppMethodBeat.o(10345);
        return;
      }
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("HandOffService", (Throwable)paramList, "restoreFromBallInfoList fail, exp:%s", new Object[] { paramList });
      AppMethodBeat.o(10345);
    }
  }
  
  public final void fg(List<? extends MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(199196);
    p.h(paramList, "multiTaskInfoList");
    T((kotlin.g.a.a)new u(paramList));
    AppMethodBeat.o(199196);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10364);
    if (paramHandOff != null) {}
    for (paramHandOff = paramHandOff.copy();; paramHandOff = null)
    {
      yid = paramHandOff;
      AppMethodBeat.o(10364);
      return;
    }
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10365);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new n(paramHandOff));
    AppMethodBeat.o(10365);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10366);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)o.yit);
    AppMethodBeat.o(10366);
  }
  
  public final void jdMethod_if(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10360);
    p.h(paramString1, "id");
    p.h(paramString2, "arg");
    Object localObject = (o)yig.get(paramString1);
    if (localObject != null)
    {
      paramString2 = yik;
      localObject = (HandOff)((o)localObject).first;
      p.h(localObject, "handOff");
      paramString2.a(8, (Collection)j.listOf(localObject));
      yig.remove(paramString1);
      AppMethodBeat.o(10360);
      return;
    }
    paramString2 = new k("opcode=\"\\d+\"").e((CharSequence)paramString2, "opcode=\"8\"");
    paramString2 = new k("seq=\"\\d+\"").e((CharSequence)paramString2, "seq=\"<![CSEQ]>\"");
    localObject = yik;
    p.h(paramString2, "msg");
    ((h)localObject).yiO.add(paramString2);
    ((h)localObject).dYG();
    Log.w("HandOffService", "error in file upload fail, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10360);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10367);
    p.h(paramHandOff, "handOff");
    T((kotlin.g.a.a)new p(paramHandOff));
    AppMethodBeat.o(10367);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(10370);
    p.h(paramString, "event");
    p.h(paramMStorageEventData, "eventData");
    Object localObject = com.tencent.mm.kernel.g.ah(af.class);
    p.g(localObject, "MMKernel.plugin(IPluginFav::class.java)");
    localObject = ((af)localObject).getFavItemInfoStorage().DY(Long.parseLong(paramString));
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_type == 8) && (paramMStorageEventData.eventId == 3))
    {
      paramString = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.ppH;
      p.g(paramString, "favItemInfo.field_favProto.dataList");
      paramMStorageEventData = (aml)j.kt((List)paramString);
      if (paramMStorageEventData != null)
      {
        paramString = (CharSequence)paramMStorageEventData.gtW();
        int i;
        if ((paramString == null) || (paramString.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label355;
          }
          str = paramMStorageEventData.gua();
          paramString = yif.values();
          p.g(paramString, "items.values");
          Iterator localIterator = ((Iterable)paramString).iterator();
          label169:
          if (!localIterator.hasNext()) {
            break label282;
          }
          paramString = localIterator.next();
          HandOff localHandOff = (HandOff)paramString;
          if ((!(localHandOff instanceof HandOffFile)) || (!p.j(((HandOffFile)localHandOff).getMd5(), str)) || (!p.j(((HandOffFile)localHandOff).getSvrId(), "-1"))) {
            break label277;
          }
          i = 1;
          label236:
          if (i == 0) {
            break label280;
          }
        }
        for (;;)
        {
          paramString = (HandOff)paramString;
          if (paramString == null) {
            break label355;
          }
          if (paramString != null) {
            break label287;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.handoff.model.HandOffFile");
          AppMethodBeat.o(10370);
          throw paramString;
          i = 0;
          break;
          label277:
          i = 0;
          break label236;
          label280:
          break label169;
          label282:
          paramString = null;
        }
        label287:
        paramString = (HandOffFile)paramString;
        String str = paramMStorageEventData.gtW();
        p.g(str, "favDataItem.cdnDataUrl");
        paramString.setCdnURL(str);
        paramMStorageEventData = paramMStorageEventData.gtX();
        p.g(paramMStorageEventData, "favDataItem.cdnDataKey");
        paramString.setAesKey(paramMStorageEventData);
        paramString.setSvrId(String.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject).field_id));
        l((HandOff)paramString);
        AppMethodBeat.o(10370);
        return;
      }
    }
    label355:
    AppMethodBeat.o(10370);
  }
  
  public final void processRequest(String paramString)
  {
    AppMethodBeat.i(199204);
    p.h(paramString, "message");
    T((kotlin.g.a.a)new s(paramString));
    AppMethodBeat.o(199204);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  public static final class a
    extends MMHandler
  {
    public a(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(10340);
      AppMethodBeat.o(10340);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(10339);
      paramMessage = e.yim;
      e.dYs();
      AppMethodBeat.o(10339);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffService$NotifyUserStatusChangeTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class b
    implements com.tencent.mm.ipcinvoker.b<GetOnLineInfoInfoResult, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    c(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final e yio;
    
    static
    {
      AppMethodBeat.i(199172);
      yio = new e();
      AppMethodBeat.o(199172);
    }
    
    e()
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(199169);
        int i = kotlin.b.a.a((Comparable)Long.valueOf(-((HandOff)paramT1).getCreateTime()), (Comparable)Long.valueOf(-((HandOff)paramT2).getCreateTime()));
        AppMethodBeat.o(199169);
        return i;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class b<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(199170);
        int i = kotlin.b.a.a((Comparable)Long.valueOf(-((HandOff)paramT1).getCreateTime()), (Comparable)Long.valueOf(-((HandOff)paramT2).getCreateTime()));
        AppMethodBeat.o(199170);
        return i;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    f(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    g(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class h<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    public static final h yip;
    
    static
    {
      AppMethodBeat.i(199175);
      yip = new h();
      AppMethodBeat.o(199175);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class i<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    public static final i yiq;
    
    static
    {
      AppMethodBeat.i(199176);
      yiq = new i();
      AppMethodBeat.o(199176);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class j
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final j yir;
    
    static
    {
      AppMethodBeat.i(199178);
      yir = new j();
      AppMethodBeat.o(199178);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class k
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final k yis;
    
    static
    {
      AppMethodBeat.i(199180);
      yis = new k();
      AppMethodBeat.o(199180);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    l(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    m(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    n(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final o yit;
    
    static
    {
      AppMethodBeat.i(199185);
      yit = new o();
      AppMethodBeat.o(199185);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    p(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    q(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    r(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    s(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    t(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    u(List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    v(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    w(MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    x(HandOff paramHandOff)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.e
 * JD-Core Version:    0.7.0.1
 */