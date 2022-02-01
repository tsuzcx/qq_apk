package com.tencent.mm.plugin.handoff.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffFile.a;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.k;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffService;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "FIX_DELAY", "", "MAC_MULTI_TASK_VERSION", "", "MSG_FIX", "PC_MULTI_TASK_VERSION", "PC_SUPPORT_VERSION", "TAG", "", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "fileCache", "Landroidx/collection/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "handler", "Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "isForeground", "", "isInQB", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "getOnlineInfo", "()Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "setOnlineInfo", "(Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;)V", "qbFile", "requestProcessor", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "statusManager", "Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "wc", "add", "", "handOff", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "ballInfo2HandOff", "cache", "cancelUpload", "id", "del", "key", "delAllFloatingWindow", "doFix", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isMac", "isMultiTaskVersion", "isPC", "isSupportOpenInComputer", "mod", "modFromBallInfo", "notifyQbOpenResult", "errorCode", "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onRegister", "onUnregister", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "runInHandOffThread", "block", "Lkotlin/Function0;", "sendOpenRequest", "toastOpenResult", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "updateQbMenuIfNeed", "uploadFail", "arg", "uploadStart", "info", "uploadSuccess", "appId", "sdkVersion", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "upsert", "FixHandler", "NotifyUserStatusChangeTask", "plugin-handoff_release"})
public final class e
  implements com.tencent.mm.kernel.c.b, com.tencent.mm.plugin.handoff.a.a, MStorage.IOnStorageChange
{
  static HandOff Dsf;
  private static HandOff Dsg;
  private static ConcurrentHashMap<String, HandOff> Dsh;
  private static final androidx.b.a<String, o<HandOffFile, c>> Dsi;
  private static final a Dsj;
  private static GetOnLineInfoInfoResult Dsk;
  private static boolean Dsl;
  private static final h Dsm;
  private static final d Dsn;
  public static final e Dso;
  private static boolean dgo;
  
  static
  {
    AppMethodBeat.i(10371);
    Dso = new e();
    Dsh = new ConcurrentHashMap();
    Dsi = new androidx.b.a();
    Object localObject = com.tencent.mm.kernel.h.aHJ();
    p.j(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getLooper();
    p.j(localObject, "MMKernel.getPizzaWorkerThread().looper");
    Dsj = new a((Looper)localObject);
    Dsk = new GetOnLineInfoInfoResult();
    dgo = true;
    localObject = com.tencent.mm.kernel.h.aHJ();
    p.j(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getLooper();
    p.j(localObject, "MMKernel.getPizzaWorkerThread().looper");
    Dsm = new h((Looper)localObject);
    localObject = com.tencent.mm.kernel.h.aHJ();
    p.j(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getLooper();
    p.j(localObject, "MMKernel.getPizzaWorkerThread().looper");
    Dsn = new d((Looper)localObject);
    AppMethodBeat.o(10371);
  }
  
  @SuppressLint({"SwitchIntDef"})
  private static final HandOff Q(BallInfo paramBallInfo)
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
      p.j(str1, "ballInfo.key");
      ((HandOff)localObject).setKey(str1);
      ((HandOff)localObject).setCreateTime(paramBallInfo.createTime);
      paramBallInfo = paramBallInfo.mab.getString("handoff#id");
      if (paramBallInfo != null)
      {
        p.j(paramBallInfo, "it");
        ((HandOff)localObject).setId(paramBallInfo);
      }
      AppMethodBeat.o(10341);
      return localObject;
      String str2 = Util.nullAsNil(paramBallInfo.name);
      localObject = Util.nullAsNil(paramBallInfo.mab.getString("handoff#shareUrl"));
      str1 = Util.nullAsNil(paramBallInfo.mab.getString("rawUrl"));
      String str3 = Util.nullAsNil(paramBallInfo.icon);
      p.j(str2, "title");
      p.j(localObject, "shareUrl");
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
        p.j(localObject, "if (shareUrl.isNotEmpty()) shareUrl else url");
        p.j(str3, "icon");
        localObject = (HandOff)new HandOffURL(str2, (String)localObject, str3, 2, null, null, null, 112, null);
        break;
        i = 0;
        break label189;
        label239:
        localObject = str1;
      }
      localObject = Util.nullAsNil(paramBallInfo.icon);
      str1 = Util.nullAsNil(paramBallInfo.name);
      str2 = Util.nullAsNil(paramBallInfo.mab.getString("appId"));
      str3 = Util.nullAsNil(paramBallInfo.mab.getString("username"));
      p.j(localObject, "icon");
      p.j(str1, "title");
      p.j(str2, "appId");
      p.j(str3, "username");
      localObject = (HandOff)new HandOffMP((String)localObject, str1, str2, "", str3, 2, null, null, null, 448, null);
      continue;
      localObject = HandOffFile.Companion;
      localObject = (HandOff)HandOffFile.a.fromBallInfo(paramBallInfo);
    }
    AppMethodBeat.o(10341);
    return null;
  }
  
  public static void W(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(248351);
    Object localObject = Thread.currentThread();
    Looper localLooper = Dsj.getLooper();
    p.j(localLooper, "handler.looper");
    if (p.h(localObject, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(248351);
      return;
    }
    localObject = Dsj;
    if (parama != null) {
      parama = new f(parama);
    }
    for (;;)
    {
      ((a)localObject).post((Runnable)parama);
      AppMethodBeat.o(248351);
      return;
    }
  }
  
  public static GetOnLineInfoInfoResult eBO()
  {
    return Dsk;
  }
  
  private static boolean eBP()
  {
    return Dsk.lZJ == 1;
  }
  
  public static void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(10353);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new c(paramHandOff));
    AppMethodBeat.o(10353);
  }
  
  public static void l(HandOff paramHandOff)
  {
    AppMethodBeat.i(10354);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new g(paramHandOff));
    AppMethodBeat.o(10354);
  }
  
  public final void P(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10351);
    p.k(paramBallInfo, "ballInfo");
    paramBallInfo = Q(paramBallInfo);
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
    AppMethodBeat.i(248334);
    p.k(paramGetOnLineInfoInfoResult, "onlineInfo");
    Log.i("HandOffService", "notifyUserStatusChange: ".concat(String.valueOf(paramGetOnLineInfoInfoResult)));
    Dsk = paramGetOnLineInfoInfoResult;
    com.tencent.mm.ipcinvoker.j.a(ToolsProcessIPCService.PROCESS_NAME, (Parcelable)paramGetOnLineInfoInfoResult, e.b.class, (com.tencent.mm.ipcinvoker.f)h.Dsr);
    com.tencent.mm.ipcinvoker.j.a(ToolsMpProcessIPCService.PROCESS_NAME, (Parcelable)paramGetOnLineInfoInfoResult, e.b.class, (com.tencent.mm.ipcinvoker.f)i.Dss);
    if (Dsl)
    {
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", 3);
        Object localObject = Dsg;
        paramGetOnLineInfoInfoResult = (GetOnLineInfoInfoResult)localObject;
        if (!(localObject instanceof HandOffFile)) {
          paramGetOnLineInfoInfoResult = null;
        }
        paramGetOnLineInfoInfoResult = (HandOffFile)paramGetOnLineInfoInfoResult;
        if (paramGetOnLineInfoInfoResult != null)
        {
          paramGetOnLineInfoInfoResult = paramGetOnLineInfoInfoResult.getFullPath();
          paramGetOnLineInfoInfoResult = u.asq(paramGetOnLineInfoInfoResult);
          if (!eBJ()) {
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
          AppMethodBeat.o(248334);
          return;
          paramGetOnLineInfoInfoResult = null;
          break;
        }
        AppMethodBeat.o(248334);
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
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new q(paramHandOff));
    AppMethodBeat.o(10346);
  }
  
  public final boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(10358);
    p.k(paramString, "id");
    p.k(paramc, "info");
    Iterator localIterator = ((Map)Dsh).entrySet().iterator();
    while (localIterator.hasNext())
    {
      HandOff localHandOff = (HandOff)((Map.Entry)localIterator.next()).getValue();
      if (((localHandOff instanceof HandOffFile)) && (p.h(localHandOff.getId(), paramString)))
      {
        ((Map)Dsi).put(paramString, new o(localHandOff, paramc));
        AppMethodBeat.o(10358);
        return true;
      }
    }
    AppMethodBeat.o(10358);
    return false;
  }
  
  public final boolean aA(String paramString, long paramLong)
  {
    AppMethodBeat.i(10359);
    p.k(paramString, "id");
    Object localObject = (o)Dsi.get(paramString);
    if (localObject != null)
    {
      paramString = Dsm;
      localObject = (HandOff)((o)localObject).Mx;
      p.k(localObject, "handOff");
      paramString.a(7, (Collection)kotlin.a.j.listOf(localObject));
      AppMethodBeat.o(10359);
      return true;
    }
    Log.w("HandOffService", "error in file uploading, handoff with id [" + paramString + "] lost!");
    AppMethodBeat.o(10359);
    return false;
  }
  
  public final void aIF()
  {
    AppMethodBeat.i(10342);
    Log.i("HandOffService", "onRegister");
    AppMethodBeat.o(10342);
  }
  
  public final void aIG()
  {
    AppMethodBeat.i(10343);
    Log.i("HandOffService", "onUnregister");
    AppMethodBeat.o(10343);
  }
  
  public final HandOff aLl(String paramString)
  {
    AppMethodBeat.i(248319);
    p.k(paramString, "key");
    paramString = (HandOff)Dsh.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.copy();
      AppMethodBeat.o(248319);
      return paramString;
    }
    AppMethodBeat.o(248319);
    return null;
  }
  
  public final HandOff aLm(String paramString)
  {
    AppMethodBeat.i(10350);
    p.k(paramString, "id");
    Object localObject = Dsh.values();
    p.j(localObject, "items.values");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h(((HandOff)localObject).getId(), paramString));
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (HandOff)paramString;
      AppMethodBeat.o(10350);
      return paramString;
    }
  }
  
  public final void aLn(String paramString)
  {
    AppMethodBeat.i(248327);
    p.k(paramString, "key");
    W((kotlin.g.a.a)new t(paramString));
    AppMethodBeat.o(248327);
  }
  
  public final void aLo(String paramString)
  {
    AppMethodBeat.i(10363);
    p.k(paramString, "id");
    o localo = (o)Dsi.get(paramString);
    if (localo != null)
    {
      ((c)localo.My).field_status = 105L;
      Dsi.remove(paramString);
      AppMethodBeat.o(10363);
      return;
    }
    Log.e("HandOffService", "error in cancel file upload, handoff with md5 [" + paramString + "] lost!");
    AppMethodBeat.o(10363);
  }
  
  public final void ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10361);
    p.k(paramString1, "id");
    p.k(paramString2, "cdnURL");
    p.k(paramString3, "aesKey");
    o localo = (o)Dsi.get(paramString1);
    if (localo != null)
    {
      ((HandOffFile)localo.Mx).setCdnURL(paramString2);
      ((HandOffFile)localo.Mx).setAesKey(paramString3);
      Dsm.o((HandOff)localo.Mx);
      Dsi.remove(paramString1);
      AppMethodBeat.o(10361);
      return;
    }
    Log.e("HandOffService", "error in file upload success, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10361);
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10347);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new r(paramHandOff));
    AppMethodBeat.o(10347);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10348);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new l(paramHandOff));
    AppMethodBeat.o(10348);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10349);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new m(paramHandOff));
    AppMethodBeat.o(10349);
  }
  
  public final void d(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248322);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    W((kotlin.g.a.a)new d(paramMultiTaskInfo));
    AppMethodBeat.o(248322);
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10356);
    p.k(paramString, "key");
    W((kotlin.g.a.a)new f(paramString));
    AppMethodBeat.o(10356);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10355);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new x(paramHandOff));
    AppMethodBeat.o(10355);
  }
  
  public final void e(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248324);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    W((kotlin.g.a.a)new w(paramMultiTaskInfo));
    AppMethodBeat.o(248324);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10362);
    p.k(paramString1, "id");
    p.k(paramString2, "appId");
    p.k(paramString3, "mediaId");
    o localo = (o)Dsi.get(paramString1);
    if (localo != null)
    {
      ((HandOffFile)localo.Mx).setAppId(paramString2);
      ((HandOffFile)localo.Mx).setSdkVersion(paramInt);
      ((HandOffFile)localo.Mx).setMediaId(paramString3);
      Dsm.o((HandOff)localo.Mx);
      Dsi.remove(paramString1);
      AppMethodBeat.o(10362);
      return;
    }
    Log.e("HandOffService", "error in file upload success, handoff with md5 [" + paramString1 + "] lost!");
    AppMethodBeat.o(10362);
  }
  
  public final void eBH()
  {
    AppMethodBeat.i(10344);
    Dsj.removeMessages(1);
    Dsj.sendEmptyMessageDelayed(1, 10000L);
    AppMethodBeat.o(10344);
  }
  
  public final void eBI()
  {
    AppMethodBeat.i(10357);
    W((kotlin.g.a.a)e.Dsq);
    AppMethodBeat.o(10357);
  }
  
  public final boolean eBJ()
  {
    AppMethodBeat.i(248336);
    if ((eBP()) && (Dsk.nwq) && (Dsk.lZO >= 1661009920))
    {
      AppMethodBeat.o(248336);
      return true;
    }
    AppMethodBeat.o(248336);
    return false;
  }
  
  public final HandOff eBK()
  {
    return Dsf;
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(248333);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new v(paramHandOff));
    AppMethodBeat.o(248333);
  }
  
  public final void fA(List<? extends MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(248316);
    p.k(paramList, "multiTaskInfoList");
    W((kotlin.g.a.a)new u(paramList));
    AppMethodBeat.o(248316);
  }
  
  public final void fz(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10345);
    p.k(paramList, "ballInfoList");
    Log.i("HandOffService", "restore from ballInfoList");
    Dsh.clear();
    Dsi.clear();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    HandOff localHandOff;
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = Q((BallInfo)((Iterator)localObject).next());
      if (localHandOff != null) {
        paramList.add(localHandOff);
      }
    }
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = (HandOff)((Iterator)localObject).next();
      paramList.add(s.M(localHandOff.getKey(), localHandOff));
    }
    ae.a((Iterable)paramList, (Map)Dsh);
    try
    {
      com.tencent.mm.kernel.h.aHE();
      if (com.tencent.mm.kernel.b.aGL())
      {
        paramList = Dsm;
        localObject = Dsh.values();
        p.j(localObject, "items.values");
        paramList.k((Collection)localObject);
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
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10364);
    if (paramHandOff != null) {}
    for (paramHandOff = paramHandOff.copy();; paramHandOff = null)
    {
      Dsf = paramHandOff;
      AppMethodBeat.o(10364);
      return;
    }
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10365);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new n(paramHandOff));
    AppMethodBeat.o(10365);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10366);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)o.Dsv);
    AppMethodBeat.o(10366);
  }
  
  public final void io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10360);
    p.k(paramString1, "id");
    p.k(paramString2, "arg");
    Object localObject = (o)Dsi.get(paramString1);
    if (localObject != null)
    {
      paramString2 = Dsm;
      localObject = (HandOff)((o)localObject).Mx;
      p.k(localObject, "handOff");
      paramString2.a(8, (Collection)kotlin.a.j.listOf(localObject));
      Dsi.remove(paramString1);
      AppMethodBeat.o(10360);
      return;
    }
    paramString2 = new k("opcode=\"\\d+\"").e((CharSequence)paramString2, "opcode=\"8\"");
    paramString2 = new k("seq=\"\\d+\"").e((CharSequence)paramString2, "seq=\"<![CSEQ]>\"");
    localObject = Dsm;
    p.k(paramString2, "msg");
    ((h)localObject).DsQ.add(paramString2);
    ((h)localObject).eCe();
    Log.w("HandOffService", "error in file upload fail, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10360);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10367);
    p.k(paramHandOff, "handOff");
    W((kotlin.g.a.a)new p(paramHandOff));
    AppMethodBeat.o(10367);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(10370);
    p.k(paramString, "event");
    p.k(paramMStorageEventData, "eventData");
    Object localObject = com.tencent.mm.kernel.h.ag(ag.class);
    p.j(localObject, "MMKernel.plugin(IPluginFav::class.java)");
    localObject = ((ag)localObject).getFavItemInfoStorage().Km(Long.parseLong(paramString));
    if ((localObject != null) && (((g)localObject).field_type == 8) && (paramMStorageEventData.eventId == 3))
    {
      paramString = ((g)localObject).field_favProto.syG;
      p.j(paramString, "favItemInfo.field_favProto.dataList");
      paramMStorageEventData = (anm)kotlin.a.j.lp((List)paramString);
      if (paramMStorageEventData != null)
      {
        paramString = (CharSequence)paramMStorageEventData.hpn();
        int i;
        if ((paramString == null) || (paramString.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label355;
          }
          str = paramMStorageEventData.hpr();
          paramString = Dsh.values();
          p.j(paramString, "items.values");
          Iterator localIterator = ((Iterable)paramString).iterator();
          label169:
          if (!localIterator.hasNext()) {
            break label282;
          }
          paramString = localIterator.next();
          HandOff localHandOff = (HandOff)paramString;
          if ((!(localHandOff instanceof HandOffFile)) || (!p.h(((HandOffFile)localHandOff).getMd5(), str)) || (!p.h(((HandOffFile)localHandOff).getSvrId(), "-1"))) {
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
        String str = paramMStorageEventData.hpn();
        p.j(str, "favDataItem.cdnDataUrl");
        paramString.setCdnURL(str);
        paramMStorageEventData = paramMStorageEventData.hpo();
        p.j(paramMStorageEventData, "favDataItem.cdnDataKey");
        paramString.setAesKey(paramMStorageEventData);
        paramString.setSvrId(String.valueOf(((g)localObject).field_id));
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
    AppMethodBeat.i(248348);
    p.k(paramString, "message");
    W((kotlin.g.a.a)new s(paramString));
    AppMethodBeat.o(248348);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
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
      paramMessage = e.Dso;
      e.eBQ();
      AppMethodBeat.o(10339);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final e Dsq;
    
    static
    {
      AppMethodBeat.i(248170);
      Dsq = new e();
      AppMethodBeat.o(248170);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class h<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    public static final h Dsr;
    
    static
    {
      AppMethodBeat.i(248618);
      Dsr = new h();
      AppMethodBeat.o(248618);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class i<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    public static final i Dss;
    
    static
    {
      AppMethodBeat.i(248393);
      Dss = new i();
      AppMethodBeat.o(248393);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final j Dst;
    
    static
    {
      AppMethodBeat.i(248530);
      Dst = new j();
      AppMethodBeat.o(248530);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final k Dsu;
    
    static
    {
      AppMethodBeat.i(248595);
      Dsu = new k();
      AppMethodBeat.o(248595);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final o Dsv;
    
    static
    {
      AppMethodBeat.i(248373);
      Dsv = new o();
      AppMethodBeat.o(248373);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<x>
  {
    r(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<x>
  {
    s(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<x>
  {
    t(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<x>
  {
    u(List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<x>
  {
    v(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<x>
  {
    w(MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.a<x>
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