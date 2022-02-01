package com.tencent.mm.plugin.handoff.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffFile.a;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.k;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffService;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "FIX_DELAY", "", "MAC_MULTI_TASK_VERSION", "", "MAC_SUPPORT_VERSION", "MSG_FIX", "PC_MULTI_TASK_VERSION", "PC_SUPPORT_VERSION", "TAG", "", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "fileCache", "Landroidx/collection/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "handler", "Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "isForeground", "", "isInQB", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "getOnlineInfo", "()Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "setOnlineInfo", "(Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;)V", "qbFile", "requestProcessor", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "statusManager", "Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "wc", "add", "", "handOff", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "ballInfo2HandOff", "cache", "cancelUpload", "id", "del", "key", "delAllFloatingWindow", "doFix", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isExDeviceOnline", "isMac", "isMultiTaskVersion", "isPC", "isSupportOpenInComputer", "mod", "modFromBallInfo", "notifyQbOpenResult", "errorCode", "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onRegister", "onUnregister", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "runInHandOffThread", "block", "Lkotlin/Function0;", "sendOpenRequest", "toastOpenResult", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "updateQbMenuIfNeed", "uploadFail", "arg", "uploadStart", "info", "uploadSuccess", "appId", "sdkVersion", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "upsert", "isMpArticleFloat", "FixHandler", "NotifyUserStatusChangeTask", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b, com.tencent.mm.plugin.handoff.a.a, MStorage.IOnStorageChange
{
  public static final e JlJ;
  static HandOff JlK;
  private static HandOff JlL;
  private static ConcurrentHashMap<String, HandOff> JlM;
  private static final androidx.b.a<String, r<HandOffFile, c>> JlN;
  private static final a JlO;
  private static GetOnLineInfoInfoResult JlP;
  private static boolean JlQ;
  private static final g JlR;
  private static final d JlS;
  private static boolean ffv;
  
  static
  {
    AppMethodBeat.i(10371);
    JlJ = new e();
    JlM = new ConcurrentHashMap();
    JlN = new androidx.b.a();
    Looper localLooper = h.baH().getLooper();
    s.s(localLooper, "getPizzaWorkerThread().looper");
    JlO = new a(localLooper);
    JlP = new GetOnLineInfoInfoResult();
    ffv = true;
    localLooper = h.baH().getLooper();
    s.s(localLooper, "getPizzaWorkerThread().looper");
    JlR = new g(localLooper);
    localLooper = h.baH().getLooper();
    s.s(localLooper, "getPizzaWorkerThread().looper");
    JlS = new d(localLooper);
    AppMethodBeat.o(10371);
  }
  
  public static void bE(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(266257);
    if (s.p(Thread.currentThread(), JlO.getLooper().getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(266257);
      return;
    }
    JlO.post(new e..ExternalSyntheticLambda2(parama));
    AppMethodBeat.o(266257);
  }
  
  private static final void bF(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(266265);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(266265);
  }
  
  public static GetOnLineInfoInfoResult fJQ()
  {
    return JlP;
  }
  
  private static boolean fJR()
  {
    return JlP.qvo == 1;
  }
  
  public static boolean fJS()
  {
    AppMethodBeat.i(266249);
    if (((JlP.qvq) && (fJR()) && (JlP.qvp >= 1661075456)) || ((isMac()) && (JlP.qvp >= 302383616)))
    {
      AppMethodBeat.o(266249);
      return true;
    }
    AppMethodBeat.o(266249);
    return false;
  }
  
  public static boolean fJT()
  {
    AppMethodBeat.i(266254);
    if ((JlP.qvq) && ((fJR()) || (isMac())))
    {
      AppMethodBeat.o(266254);
      return true;
    }
    AppMethodBeat.o(266254);
    return false;
  }
  
  private static final void i(IPCVoid paramIPCVoid) {}
  
  private static boolean isMac()
  {
    return JlP.qvo == 2;
  }
  
  private static final void j(IPCVoid paramIPCVoid) {}
  
  public static void l(HandOff paramHandOff)
  {
    AppMethodBeat.i(10354);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new g(paramHandOff));
    AppMethodBeat.o(10354);
  }
  
  public final void S(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10351);
    s.u(paramBallInfo, "ballInfo");
    String str1 = null;
    Object localObject = str1;
    switch (paramBallInfo.type)
    {
    default: 
      localObject = str1;
    case 3: 
      if (localObject == null) {
        paramBallInfo = null;
      }
      break;
    }
    for (;;)
    {
      if (paramBallInfo != null) {
        JlJ.k(paramBallInfo);
      }
      AppMethodBeat.o(10351);
      return;
      String str2 = Util.nullAsNil(paramBallInfo.name);
      localObject = Util.nullAsNil(paramBallInfo.oSS.getString("handoff#shareUrl"));
      str1 = Util.nullAsNil(paramBallInfo.oSS.getString("rawUrl"));
      String str3 = Util.nullAsNil(paramBallInfo.icon);
      s.s(str2, "title");
      s.s(localObject, "shareUrl");
      int i;
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        label159:
        if (i == 0) {
          break label209;
        }
      }
      for (;;)
      {
        s.s(localObject, "if (shareUrl.isNotEmpty()) shareUrl else url");
        s.s(str3, "icon");
        localObject = (HandOff)new HandOffURL(str2, (String)localObject, str3, 2, null, null, null, 112, null);
        break;
        i = 0;
        break label159;
        label209:
        localObject = str1;
      }
      localObject = Util.nullAsNil(paramBallInfo.icon);
      str1 = Util.nullAsNil(paramBallInfo.name);
      str2 = Util.nullAsNil(paramBallInfo.oSS.getString("appId"));
      str3 = Util.nullAsNil(paramBallInfo.oSS.getString("username"));
      s.s(localObject, "icon");
      s.s(str1, "title");
      s.s(str2, "appId");
      s.s(str3, "username");
      localObject = (HandOff)new HandOffMP((String)localObject, str1, str2, "", str3, 2, null, null, null, 448, null);
      break;
      localObject = HandOffFile.Companion;
      localObject = (HandOff)HandOffFile.a.fromBallInfo(paramBallInfo);
      break;
      str1 = paramBallInfo.key;
      s.s(str1, "ballInfo.key");
      ((HandOff)localObject).setKey(str1);
      ((HandOff)localObject).setCreateTime(paramBallInfo.createTime);
      str1 = paramBallInfo.oSS.getString("handoff#id");
      paramBallInfo = (BallInfo)localObject;
      if (str1 != null)
      {
        ((HandOff)localObject).setId(str1);
        paramBallInfo = (BallInfo)localObject;
      }
    }
  }
  
  public final void a(GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult)
  {
    AppMethodBeat.i(266339);
    s.u(paramGetOnLineInfoInfoResult, "onlineInfo");
    Log.i("HandOffService", s.X("notifyUserStatusChange: ", paramGetOnLineInfoInfoResult));
    JlP = paramGetOnLineInfoInfoResult;
    j.a(ToolsProcessIPCService.PROCESS_NAME, (Parcelable)paramGetOnLineInfoInfoResult, e.b.class, e..ExternalSyntheticLambda1.INSTANCE);
    j.a(ToolsMpProcessIPCService.PROCESS_NAME, (Parcelable)paramGetOnLineInfoInfoResult, e.b.class, e..ExternalSyntheticLambda0.INSTANCE);
    Intent localIntent;
    if (JlQ)
    {
      localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", 3);
        paramGetOnLineInfoInfoResult = JlL;
        if ((paramGetOnLineInfoInfoResult instanceof HandOffFile))
        {
          paramGetOnLineInfoInfoResult = (HandOffFile)paramGetOnLineInfoInfoResult;
          break label261;
          paramGetOnLineInfoInfoResult = com.tencent.mm.vfs.y.alV(paramGetOnLineInfoInfoResult);
          if (fJL())
          {
            HandOffFile.a locala = HandOffFile.Companion;
            if (HandOffFile.a.isSupportOpenFile(paramGetOnLineInfoInfoResult))
            {
              bool = true;
              localJSONObject.put("isShow", bool);
              localJSONArray.put(localJSONObject);
              localIntent.putExtra("menuItems", localJSONArray.toString());
              MMApplicationContext.getContext().sendBroadcast(localIntent);
              AppMethodBeat.o(266339);
            }
          }
        }
        else
        {
          paramGetOnLineInfoInfoResult = null;
          break label261;
          paramGetOnLineInfoInfoResult = paramGetOnLineInfoInfoResult.getFullPath();
          continue;
        }
        boolean bool = false;
        continue;
        AppMethodBeat.o(266339);
      }
      catch (Exception paramGetOnLineInfoInfoResult)
      {
        Log.e("HandOffService", "UpdateQbMenuIfNeed() Exception:%s %s", new Object[] { paramGetOnLineInfoInfoResult.getClass().getSimpleName(), paramGetOnLineInfoInfoResult.getMessage() });
      }
      return;
      label261:
      if (paramGetOnLineInfoInfoResult == null) {
        paramGetOnLineInfoInfoResult = null;
      }
    }
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10346);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new o(paramHandOff));
    AppMethodBeat.o(10346);
  }
  
  public final boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(10358);
    s.u(paramString, "id");
    s.u(paramc, "info");
    Iterator localIterator = ((Map)JlM).entrySet().iterator();
    while (localIterator.hasNext())
    {
      HandOff localHandOff = (HandOff)((Map.Entry)localIterator.next()).getValue();
      if (((localHandOff instanceof HandOffFile)) && (s.p(localHandOff.getId(), paramString)))
      {
        ((Map)JlN).put(paramString, new r(localHandOff, paramc));
        AppMethodBeat.o(10358);
        return true;
      }
    }
    AppMethodBeat.o(10358);
    return false;
  }
  
  public final HandOff aIc(String paramString)
  {
    AppMethodBeat.i(266326);
    s.u(paramString, "key");
    paramString = (HandOff)JlM.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(266326);
      return null;
    }
    paramString = paramString.copy();
    AppMethodBeat.o(266326);
    return paramString;
  }
  
  public final HandOff aId(String paramString)
  {
    AppMethodBeat.i(10350);
    s.u(paramString, "id");
    Object localObject = JlM.values();
    s.s(localObject, "items.values");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((HandOff)localObject).getId(), paramString));
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (HandOff)paramString;
      AppMethodBeat.o(10350);
      return paramString;
    }
  }
  
  public final void aIe(String paramString)
  {
    AppMethodBeat.i(266336);
    s.u(paramString, "key");
    bE((kotlin.g.a.a)new r(paramString));
    AppMethodBeat.o(266336);
  }
  
  public final void aIf(String paramString)
  {
    AppMethodBeat.i(10363);
    s.u(paramString, "id");
    r localr = (r)JlN.get(paramString);
    if (localr != null)
    {
      ((c)localr.bsD).field_status = 105L;
      JlN.remove(paramString);
      AppMethodBeat.o(10363);
      return;
    }
    Log.e("HandOffService", "error in cancel file upload, handoff with md5 [" + paramString + "] lost!");
    AppMethodBeat.o(10363);
  }
  
  public final boolean aK(String paramString, long paramLong)
  {
    AppMethodBeat.i(10359);
    s.u(paramString, "id");
    Object localObject = (r)JlN.get(paramString);
    if (localObject != null)
    {
      paramString = JlR;
      localObject = (HandOff)((r)localObject).bsC;
      s.u(localObject, "handOff");
      paramString.a(7, (Collection)p.listOf(localObject));
      AppMethodBeat.o(10359);
      return true;
    }
    Log.w("HandOffService", "error in file uploading, handoff with id [" + paramString + "] lost!");
    AppMethodBeat.o(10359);
    return false;
  }
  
  public final void az(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10361);
    s.u(paramString1, "id");
    s.u(paramString2, "cdnURL");
    s.u(paramString3, "aesKey");
    r localr = (r)JlN.get(paramString1);
    if (localr != null)
    {
      ((HandOffFile)localr.bsC).setCdnURL(paramString2);
      ((HandOffFile)localr.bsC).setAesKey(paramString3);
      JlR.o((HandOff)localr.bsC);
      JlN.remove(paramString1);
      AppMethodBeat.o(10361);
      return;
    }
    Log.e("HandOffService", "error in file upload success, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10361);
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10347);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new p(paramHandOff));
    AppMethodBeat.o(10347);
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(10342);
    Log.i("HandOffService", "onRegister");
    AppMethodBeat.o(10342);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(10343);
    Log.i("HandOffService", "onUnregister");
    AppMethodBeat.o(10343);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10348);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new j(paramHandOff));
    AppMethodBeat.o(10348);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10349);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new k(paramHandOff));
    AppMethodBeat.o(10349);
  }
  
  public final void d(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(266332);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    bE((kotlin.g.a.a)new d(paramMultiTaskInfo));
    AppMethodBeat.o(266332);
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10356);
    s.u(paramString, "key");
    bE((kotlin.g.a.a)new f(paramString));
    AppMethodBeat.o(10356);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10355);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new v(paramHandOff));
    AppMethodBeat.o(10355);
  }
  
  public final void e(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(266334);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    bE((kotlin.g.a.a)new u(paramMultiTaskInfo));
    AppMethodBeat.o(266334);
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(266337);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new t(paramHandOff));
    AppMethodBeat.o(266337);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10362);
    s.u(paramString1, "id");
    s.u(paramString2, "appId");
    s.u(paramString3, "mediaId");
    r localr = (r)JlN.get(paramString1);
    if (localr != null)
    {
      ((HandOffFile)localr.bsC).setAppId(paramString2);
      ((HandOffFile)localr.bsC).setSdkVersion(paramInt);
      ((HandOffFile)localr.bsC).setMediaId(paramString3);
      JlR.o((HandOff)localr.bsC);
      JlN.remove(paramString1);
      AppMethodBeat.o(10362);
      return;
    }
    Log.e("HandOffService", "error in file upload success, handoff with md5 [" + paramString1 + "] lost!");
    AppMethodBeat.o(10362);
  }
  
  public final void fJJ()
  {
    AppMethodBeat.i(10344);
    JlO.removeMessages(1);
    JlO.sendEmptyMessageDelayed(1, 10000L);
    AppMethodBeat.o(10344);
  }
  
  public final void fJK()
  {
    AppMethodBeat.i(10357);
    bE((kotlin.g.a.a)e.JlW);
    AppMethodBeat.o(10357);
  }
  
  public final boolean fJL()
  {
    AppMethodBeat.i(266340);
    if ((JlP.qvq) && (((fJR()) && (JlP.qvp >= 1661009920)) || ((isMac()) && (JlP.qvp >= 318898176))))
    {
      AppMethodBeat.o(266340);
      return true;
    }
    AppMethodBeat.o(266340);
    return false;
  }
  
  public final HandOff fJM()
  {
    return JlK;
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10364);
    if (paramHandOff == null) {}
    for (paramHandOff = null;; paramHandOff = paramHandOff.copy())
    {
      JlK = paramHandOff;
      AppMethodBeat.o(10364);
      return;
    }
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10365);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new l(paramHandOff));
    AppMethodBeat.o(10365);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10366);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)m.JlZ);
    AppMethodBeat.o(10366);
  }
  
  public final void iw(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10345);
    s.u(paramList, "ballInfoList");
    AppMethodBeat.o(10345);
  }
  
  public final void ix(List<? extends MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(266322);
    s.u(paramList, "multiTaskInfoList");
    bE((kotlin.g.a.a)new s(paramList));
    AppMethodBeat.o(266322);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10367);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new n(paramHandOff));
    AppMethodBeat.o(10367);
  }
  
  public final void jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10360);
    s.u(paramString1, "id");
    s.u(paramString2, "arg");
    Object localObject = (r)JlN.get(paramString1);
    if (localObject != null)
    {
      paramString2 = JlR;
      localObject = (HandOff)((r)localObject).bsC;
      s.u(localObject, "handOff");
      paramString2.a(8, (Collection)p.listOf(localObject));
      JlN.remove(paramString1);
      AppMethodBeat.o(10360);
      return;
    }
    paramString2 = new k("opcode=\"\\d+\"").e((CharSequence)paramString2, "opcode=\"8\"");
    paramString2 = new k("seq=\"\\d+\"").e((CharSequence)paramString2, "seq=\"<![CSEQ]>\"");
    localObject = JlR;
    s.u(paramString2, "msg");
    ((g)localObject).Jmf.add(paramString2);
    ((g)localObject).fKg();
    Log.w("HandOffService", "error in file upload fail, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10360);
  }
  
  public final void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(10353);
    s.u(paramHandOff, "handOff");
    bE((kotlin.g.a.a)new c(paramHandOff, this));
    AppMethodBeat.o(10353);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(10370);
    s.u(paramString, "event");
    s.u(paramMStorageEventData, "eventData");
    com.tencent.mm.plugin.fav.a.g localg = ((com.tencent.mm.plugin.fav.a.ah)h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().mK(Long.parseLong(paramString));
    int i;
    String str;
    if ((localg != null) && (localg.field_type == 8) && (paramMStorageEventData.eventId == 3))
    {
      paramString = localg.field_favProto.vEn;
      s.s(paramString, "favItemInfo.field_favProto.dataList");
      paramMStorageEventData = (arf)p.oL((List)paramString);
      if (paramMStorageEventData != null)
      {
        paramString = (CharSequence)paramMStorageEventData.Ysw;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label309;
        }
        i = 1;
        if (i == 0)
        {
          str = paramMStorageEventData.ZyW;
          paramString = JlM.values();
          s.s(paramString, "items.values");
          Iterator localIterator = ((Iterable)paramString).iterator();
          label157:
          if (!localIterator.hasNext()) {
            break label319;
          }
          paramString = localIterator.next();
          HandOff localHandOff = (HandOff)paramString;
          if ((!(localHandOff instanceof HandOffFile)) || (!s.p(((HandOffFile)localHandOff).getMd5(), str)) || (!s.p(((HandOffFile)localHandOff).getSvrId(), "-1"))) {
            break label314;
          }
          i = 1;
          label224:
          if (i == 0) {
            break label317;
          }
        }
      }
    }
    for (;;)
    {
      paramString = (HandOff)paramString;
      if (paramString != null)
      {
        paramString = (HandOffFile)paramString;
        str = paramMStorageEventData.Ysw;
        s.s(str, "favDataItem.cdnDataUrl");
        paramString.setCdnURL(str);
        paramMStorageEventData = paramMStorageEventData.ZyH;
        s.s(paramMStorageEventData, "favDataItem.cdnDataKey");
        paramString.setAesKey(paramMStorageEventData);
        paramString.setSvrId(String.valueOf(localg.field_id));
        paramMStorageEventData = kotlin.ah.aiuX;
        l((HandOff)paramString);
      }
      AppMethodBeat.o(10370);
      return;
      label309:
      i = 0;
      break;
      label314:
      i = 0;
      break label224;
      label317:
      break label157;
      label319:
      paramString = null;
    }
  }
  
  public final void processRequest(String paramString)
  {
    AppMethodBeat.i(266342);
    s.u(paramString, "message");
    bE((kotlin.g.a.a)new q(paramString));
    AppMethodBeat.o(266342);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      paramMessage = e.JlJ;
      e.fKc();
      AppMethodBeat.o(10339);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(HandOff paramHandOff, e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public static final e JlW;
    
    static
    {
      AppMethodBeat.i(266095);
      JlW = new e();
      AppMethodBeat.o(266095);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public static final h JlX;
    
    static
    {
      AppMethodBeat.i(266098);
      JlX = new h();
      AppMethodBeat.o(266098);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public static final i JlY;
    
    static
    {
      AppMethodBeat.i(266105);
      JlY = new i();
      AppMethodBeat.o(266105);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    j(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    k(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    l(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    public static final m JlZ;
    
    static
    {
      AppMethodBeat.i(266069);
      JlZ = new m();
      AppMethodBeat.o(266069);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    n(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    o(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    p(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    q(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    r(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    s(List<? extends MultiTaskInfo> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    t(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    u(MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    v(HandOff paramHandOff)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.e
 * JD-Core Version:    0.7.0.1
 */