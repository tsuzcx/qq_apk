package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "()V", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isSupportOpenInComputer", "", "mod", "modFromBallInfo", "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "sendOpenRequest", "syncUserStatus", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "uploadFail", "arg", "uploadStart", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "AddHandOffFromBallTask", "AddTask", "AddWindowFromBallTask", "AllListTask", "CancelUploadTask", "Companion", "DelAllFloatingWindowTask", "DelTask", "FixHandOffTask", "GetCacheTask", "GetHandOffByIdTask", "GetHandOffByKeyTask", "ModFromBallInfoTask", "ModTask", "OnFileCreateTask", "OnFileDestroyTask", "OnWebViewCreateTask", "OnWebViewDestroyTask", "SendOpenRequestTask", "SetCacheTask", "SyncUserStatusTask", "UploadFail", "UploadSuccessCDNTask", "UploadSuccessCGITask", "UploadingTask", "UpsertTask", "plugin-handoff_release"})
public final class g
  implements a
{
  public static final g.d yiw;
  private GetOnLineInfoInfoResult yii;
  
  static
  {
    AppMethodBeat.i(10428);
    yiw = new g.d((byte)0);
    AppMethodBeat.o(10428);
  }
  
  public g()
  {
    AppMethodBeat.i(199224);
    this.yii = new GetOnLineInfoInfoResult();
    dYC();
    AppMethodBeat.o(199224);
  }
  
  private final void dYC()
  {
    AppMethodBeat.i(199214);
    h.a(MainProcessIPCService.dkO, (Parcelable)new IPCVoid(), p.class, (d)new ag(this));
    AppMethodBeat.o(199214);
  }
  
  public final void O(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10412);
    p.h(paramBallInfo, "ballInfo");
    h.a(MainProcessIPCService.dkO, (Parcelable)paramBallInfo, a.class, (d)v.yix);
    AppMethodBeat.o(10412);
  }
  
  public final void a(GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult)
  {
    AppMethodBeat.i(199221);
    p.h(paramGetOnLineInfoInfoResult, "onlineInfo");
    Log.i("HandOffServiceProxy", "notifyUserStatusChange: ".concat(String.valueOf(paramGetOnLineInfoInfoResult)));
    this.yii = paramGetOnLineInfoInfoResult;
    AppMethodBeat.o(199221);
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10407);
    p.h(paramHandOff, "handOff");
    h.a(MainProcessIPCService.dkO, (Parcelable)paramHandOff, l.class, (d)ad.yiF);
    AppMethodBeat.o(10407);
  }
  
  public final boolean a(String paramString, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(10417);
    p.h(paramString, "id");
    p.h(paramc, "info");
    Log.w("HandOffServiceProxy", "uploadStart should only be called in MM process!");
    AppMethodBeat.o(10417);
    return false;
  }
  
  public final void aBA(String paramString)
  {
    AppMethodBeat.i(10422);
    p.h(paramString, "id");
    h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(paramString), c.class, (d)y.yiA);
    AppMethodBeat.o(10422);
  }
  
  public final HandOff aBx(String paramString)
  {
    AppMethodBeat.i(199216);
    p.h(paramString, "key");
    paramString = (HandOff)h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(paramString), i.class);
    AppMethodBeat.o(199216);
    return paramString;
  }
  
  public final HandOff aBy(String paramString)
  {
    AppMethodBeat.i(10411);
    p.h(paramString, "id");
    paramString = (HandOff)h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(paramString), h.class);
    AppMethodBeat.o(10411);
    return paramString;
  }
  
  public final void aBz(String paramString)
  {
    AppMethodBeat.i(199219);
    p.h(paramString, "key");
    AppMethodBeat.o(199219);
  }
  
  public final void av(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10420);
    p.h(paramString1, "id");
    p.h(paramString2, "cdnURL");
    p.h(paramString3, "aesKey");
    paramString1 = b.a(new c[] { b.ig("id", paramString1), b.ig("cdnURL", paramString2), b.ig("aesKey", paramString3) });
    h.a(MainProcessIPCService.dkO, (Parcelable)paramString1, r.class, (d)ai.yiK);
    AppMethodBeat.o(10420);
  }
  
  public final boolean az(String paramString, long paramLong)
  {
    AppMethodBeat.i(10418);
    p.h(paramString, "id");
    paramString = b.ig("id", paramString);
    p.h("uploadedSize", "$this$bundleTo");
    paramString = b.a(new c[] { paramString, new c((kotlin.g.a.b)new b.b("uploadedSize", paramLong)) });
    boolean bool = ((IPCBoolean)h.a(MainProcessIPCService.dkO, (Parcelable)paramString, t.class)).value;
    AppMethodBeat.o(10418);
    return bool;
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10408);
    p.h(paramHandOff, "handOff");
    h.a(MainProcessIPCService.dkO, (Parcelable)paramHandOff, m.class, (d)ae.yiG);
    AppMethodBeat.o(10408);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10409);
    p.h(paramHandOff, "handOff");
    h.a(MainProcessIPCService.dkO, (Parcelable)paramHandOff, j.class, (d)ab.yiD);
    AppMethodBeat.o(10409);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10410);
    p.h(paramHandOff, "handOff");
    h.a(MainProcessIPCService.dkO, (Parcelable)paramHandOff, k.class, (d)ac.yiE);
    AppMethodBeat.o(10410);
  }
  
  public final void d(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(199217);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(199217);
  }
  
  public final void dYj()
  {
    AppMethodBeat.i(10405);
    h.a(MainProcessIPCService.dkO, (Parcelable)new IPCVoid(), f.class, (d)aa.yiC);
    AppMethodBeat.o(10405);
  }
  
  public final void dYk()
  {
    AppMethodBeat.i(10416);
    h.a(MainProcessIPCService.dkO, (Parcelable)new IPCVoid(), b.class, (d)w.yiy);
    AppMethodBeat.o(10416);
  }
  
  public final boolean dYl()
  {
    AppMethodBeat.i(199222);
    if (this.yii.jjS == 0) {
      dYC();
    }
    if ((this.yii.kDf) && (this.yii.jjS >= 1661009920))
    {
      AppMethodBeat.o(199222);
      return true;
    }
    AppMethodBeat.o(199222);
    return false;
  }
  
  public final HandOff dYm()
  {
    AppMethodBeat.i(10424);
    HandOff localHandOff = (HandOff)h.a(MainProcessIPCService.dkO, (Parcelable)new IPCVoid(), g.class);
    AppMethodBeat.o(10424);
    return localHandOff;
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10415);
    p.h(paramString, "key");
    h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(paramString), e.class, (d)z.yiB);
    AppMethodBeat.o(10415);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10414);
    p.h(paramHandOff, "handOff");
    h.a(MainProcessIPCService.dkO, (Parcelable)paramHandOff, u.class, (d)ak.yiM);
    AppMethodBeat.o(10414);
  }
  
  public final void e(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(199218);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(199218);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10421);
    p.h(paramString1, "id");
    p.h(paramString2, "appId");
    p.h(paramString3, "mediaId");
    paramString1 = b.ig("id", paramString1);
    paramString2 = b.ig("appId", paramString2);
    p.h("sdkVersion", "$this$bundleTo");
    paramString1 = b.a(new c[] { paramString1, paramString2, new c((kotlin.g.a.b)new b.a("sdkVersion", paramInt)), b.ig("mediaId", paramString3) });
    h.a(MainProcessIPCService.dkO, (Parcelable)paramString1, s.class, (d)aj.yiL);
    AppMethodBeat.o(10421);
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(199220);
    p.h(paramHandOff, "handOff");
    h.a(MainProcessIPCService.dkO, (Parcelable)paramHandOff, n.class, (d)af.yiH);
    AppMethodBeat.o(199220);
  }
  
  public final void ff(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10406);
    p.h(paramList, "ballInfoList");
    AppMethodBeat.o(10406);
  }
  
  public final void fg(List<? extends MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(199215);
    p.h(paramList, "multiTaskInfoList");
    AppMethodBeat.o(199215);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10423);
    h.a(MainProcessIPCService.dkO, (Parcelable)paramHandOff, o.class, (d)x.yiz);
    AppMethodBeat.o(10423);
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10425);
    p.h(paramHandOff, "handOff");
    AppMethodBeat.o(10425);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10426);
    p.h(paramHandOff, "handOff");
    AppMethodBeat.o(10426);
  }
  
  public final void jdMethod_if(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10419);
    p.h(paramString1, "id");
    p.h(paramString2, "arg");
    paramString1 = b.a(new c[] { b.ig("id", paramString1), b.ig("arg", paramString2) });
    h.a(MainProcessIPCService.dkO, (Parcelable)paramString1, q.class, (d)ah.yiJ);
    AppMethodBeat.o(10419);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10427);
    p.h(paramHandOff, "handOff");
    AppMethodBeat.o(10427);
  }
  
  public final void processRequest(String paramString)
  {
    AppMethodBeat.i(199223);
    p.h(paramString, "message");
    AppMethodBeat.o(199223);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AddWindowFromBallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class a
    implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class aa<T>
    implements d<ResultType>
  {
    public static final aa yiC;
    
    static
    {
      AppMethodBeat.i(10395);
      yiC = new aa();
      AppMethodBeat.o(10395);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ab<T>
    implements d<ResultType>
  {
    public static final ab yiD;
    
    static
    {
      AppMethodBeat.i(10397);
      yiD = new ab();
      AppMethodBeat.o(10397);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ac<T>
    implements d<ResultType>
  {
    public static final ac yiE;
    
    static
    {
      AppMethodBeat.i(10398);
      yiE = new ac();
      AppMethodBeat.o(10398);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ad<T>
    implements d<ResultType>
  {
    public static final ad yiF;
    
    static
    {
      AppMethodBeat.i(10399);
      yiF = new ad();
      AppMethodBeat.o(10399);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ae<T>
    implements d<ResultType>
  {
    public static final ae yiG;
    
    static
    {
      AppMethodBeat.i(10400);
      yiG = new ae();
      AppMethodBeat.o(10400);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class af<T>
    implements d<ResultType>
  {
    public static final af yiH;
    
    static
    {
      AppMethodBeat.i(199212);
      yiH = new af();
      AppMethodBeat.o(199212);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ag<T>
    implements d<ResultType>
  {
    ag(g paramg) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ah<T>
    implements d<ResultType>
  {
    public static final ah yiJ;
    
    static
    {
      AppMethodBeat.i(10401);
      yiJ = new ah();
      AppMethodBeat.o(10401);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ai<T>
    implements d<ResultType>
  {
    public static final ai yiK;
    
    static
    {
      AppMethodBeat.i(10402);
      yiK = new ai();
      AppMethodBeat.o(10402);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class aj<T>
    implements d<ResultType>
  {
    public static final aj yiL;
    
    static
    {
      AppMethodBeat.i(10403);
      yiL = new aj();
      AppMethodBeat.o(10403);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ak<T>
    implements d<ResultType>
  {
    public static final ak yiM;
    
    static
    {
      AppMethodBeat.i(10404);
      yiM = new ak();
      AppMethodBeat.o(10404);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AllListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class b
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$CancelUploadTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "id", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class c
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$DelTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "key", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class e
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$FixHandOffTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class f
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class g
    implements k<IPCVoid, HandOff>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByIdTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "id", "plugin-handoff_release"})
  public static final class h
    implements k<IPCString, HandOff>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByKeyTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "key", "plugin-handoff_release"})
  public static final class i
    implements k<IPCString, HandOff>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class j
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class k
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class l
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class m
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SendOpenRequestTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class n
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class o
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SyncUserStatusTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class p
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, GetOnLineInfoInfoResult>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadFail;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class q
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCDNTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class r
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCGITask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class s
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadingTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class t
    implements k<Bundle, IPCBoolean>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UpsertTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class u
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class v<T>
    implements d<ResultType>
  {
    public static final v yix;
    
    static
    {
      AppMethodBeat.i(10390);
      yix = new v();
      AppMethodBeat.o(10390);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class w<T>
    implements d<ResultType>
  {
    public static final w yiy;
    
    static
    {
      AppMethodBeat.i(10391);
      yiy = new w();
      AppMethodBeat.o(10391);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class x<T>
    implements d<ResultType>
  {
    public static final x yiz;
    
    static
    {
      AppMethodBeat.i(10392);
      yiz = new x();
      AppMethodBeat.o(10392);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class y<T>
    implements d<ResultType>
  {
    public static final y yiA;
    
    static
    {
      AppMethodBeat.i(10393);
      yiA = new y();
      AppMethodBeat.o(10393);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class z<T>
    implements d<ResultType>
  {
    public static final z yiB;
    
    static
    {
      AppMethodBeat.i(10394);
      yiB = new z();
      AppMethodBeat.o(10394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.g
 * JD-Core Version:    0.7.0.1
 */