package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "()V", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isSupportOpenInComputer", "", "mod", "modFromBallInfo", "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "sendOpenRequest", "syncUserStatus", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "uploadFail", "arg", "uploadStart", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "AddHandOffFromBallTask", "AddTask", "AddWindowFromBallTask", "AllListTask", "CancelUploadTask", "Companion", "DelAllFloatingWindowTask", "DelTask", "FixHandOffTask", "GetCacheTask", "GetHandOffByIdTask", "GetHandOffByKeyTask", "ModFromBallInfoTask", "ModTask", "OnFileCreateTask", "OnFileDestroyTask", "OnWebViewCreateTask", "OnWebViewDestroyTask", "SendOpenRequestTask", "SetCacheTask", "SyncUserStatusTask", "UploadFail", "UploadSuccessCDNTask", "UploadSuccessCGITask", "UploadingTask", "UpsertTask", "plugin-handoff_release"})
public final class g
  implements a
{
  public static final g.d Dsy;
  private GetOnLineInfoInfoResult Dsk;
  
  static
  {
    AppMethodBeat.i(10428);
    Dsy = new g.d((byte)0);
    AppMethodBeat.o(10428);
  }
  
  public g()
  {
    AppMethodBeat.i(248485);
    this.Dsk = new GetOnLineInfoInfoResult();
    eCa();
    AppMethodBeat.o(248485);
  }
  
  private final void eCa()
  {
    AppMethodBeat.i(248460);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), p.class, (f)new ag(this));
    AppMethodBeat.o(248460);
  }
  
  public final void P(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10412);
    p.k(paramBallInfo, "ballInfo");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramBallInfo, a.class, (f)v.Dsz);
    AppMethodBeat.o(10412);
  }
  
  public final void a(GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult)
  {
    AppMethodBeat.i(248474);
    p.k(paramGetOnLineInfoInfoResult, "onlineInfo");
    Log.i("HandOffServiceProxy", "notifyUserStatusChange: ".concat(String.valueOf(paramGetOnLineInfoInfoResult)));
    this.Dsk = paramGetOnLineInfoInfoResult;
    AppMethodBeat.o(248474);
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10407);
    p.k(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, l.class, (f)ad.DsH);
    AppMethodBeat.o(10407);
  }
  
  public final boolean a(String paramString, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(10417);
    p.k(paramString, "id");
    p.k(paramc, "info");
    Log.w("HandOffServiceProxy", "uploadStart should only be called in MM process!");
    AppMethodBeat.o(10417);
    return false;
  }
  
  public final boolean aA(String paramString, long paramLong)
  {
    AppMethodBeat.i(10418);
    p.k(paramString, "id");
    paramString = b.ip("id", paramString);
    p.k("uploadedSize", "$this$bundleTo");
    paramString = b.a(new c[] { paramString, new c((kotlin.g.a.b)new b.b("uploadedSize", paramLong)) });
    boolean bool = ((IPCBoolean)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString, t.class)).value;
    AppMethodBeat.o(10418);
    return bool;
  }
  
  public final HandOff aLl(String paramString)
  {
    AppMethodBeat.i(248467);
    p.k(paramString, "key");
    paramString = (HandOff)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), i.class);
    AppMethodBeat.o(248467);
    return paramString;
  }
  
  public final HandOff aLm(String paramString)
  {
    AppMethodBeat.i(10411);
    p.k(paramString, "id");
    paramString = (HandOff)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), h.class);
    AppMethodBeat.o(10411);
    return paramString;
  }
  
  public final void aLn(String paramString)
  {
    AppMethodBeat.i(248470);
    p.k(paramString, "key");
    AppMethodBeat.o(248470);
  }
  
  public final void aLo(String paramString)
  {
    AppMethodBeat.i(10422);
    p.k(paramString, "id");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), c.class, (f)y.DsC);
    AppMethodBeat.o(10422);
  }
  
  public final void ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10420);
    p.k(paramString1, "id");
    p.k(paramString2, "cdnURL");
    p.k(paramString3, "aesKey");
    paramString1 = b.a(new c[] { b.ip("id", paramString1), b.ip("cdnURL", paramString2), b.ip("aesKey", paramString3) });
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString1, r.class, (f)ai.DsM);
    AppMethodBeat.o(10420);
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10408);
    p.k(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, m.class, (f)ae.DsI);
    AppMethodBeat.o(10408);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10409);
    p.k(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, j.class, (f)ab.DsF);
    AppMethodBeat.o(10409);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10410);
    p.k(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, k.class, (f)ac.DsG);
    AppMethodBeat.o(10410);
  }
  
  public final void d(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248468);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(248468);
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10415);
    p.k(paramString, "key");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), e.class, (f)z.DsD);
    AppMethodBeat.o(10415);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10414);
    p.k(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, u.class, (f)ak.DsO);
    AppMethodBeat.o(10414);
  }
  
  public final void e(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248469);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(248469);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10421);
    p.k(paramString1, "id");
    p.k(paramString2, "appId");
    p.k(paramString3, "mediaId");
    paramString1 = b.ip("id", paramString1);
    paramString2 = b.ip("appId", paramString2);
    p.k("sdkVersion", "$this$bundleTo");
    paramString1 = b.a(new c[] { paramString1, paramString2, new c((kotlin.g.a.b)new b.a("sdkVersion", paramInt)), b.ip("mediaId", paramString3) });
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString1, s.class, (f)aj.DsN);
    AppMethodBeat.o(10421);
  }
  
  public final void eBH()
  {
    AppMethodBeat.i(10405);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), f.class, (f)aa.DsE);
    AppMethodBeat.o(10405);
  }
  
  public final void eBI()
  {
    AppMethodBeat.i(10416);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), b.class, (f)w.DsA);
    AppMethodBeat.o(10416);
  }
  
  public final boolean eBJ()
  {
    AppMethodBeat.i(248475);
    if (this.Dsk.lZO == 0) {
      eCa();
    }
    if ((this.Dsk.nwq) && (this.Dsk.lZO >= 1661009920))
    {
      AppMethodBeat.o(248475);
      return true;
    }
    AppMethodBeat.o(248475);
    return false;
  }
  
  public final HandOff eBK()
  {
    AppMethodBeat.i(10424);
    HandOff localHandOff = (HandOff)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), g.class);
    AppMethodBeat.o(10424);
    return localHandOff;
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(248472);
    p.k(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, n.class, (f)af.DsJ);
    AppMethodBeat.o(248472);
  }
  
  public final void fA(List<? extends MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(248462);
    p.k(paramList, "multiTaskInfoList");
    AppMethodBeat.o(248462);
  }
  
  public final void fz(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10406);
    p.k(paramList, "ballInfoList");
    AppMethodBeat.o(10406);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10423);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, o.class, (f)x.DsB);
    AppMethodBeat.o(10423);
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10425);
    p.k(paramHandOff, "handOff");
    AppMethodBeat.o(10425);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10426);
    p.k(paramHandOff, "handOff");
    AppMethodBeat.o(10426);
  }
  
  public final void io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10419);
    p.k(paramString1, "id");
    p.k(paramString2, "arg");
    paramString1 = b.a(new c[] { b.ip("id", paramString1), b.ip("arg", paramString2) });
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString1, q.class, (f)ah.DsL);
    AppMethodBeat.o(10419);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10427);
    p.k(paramHandOff, "handOff");
    AppMethodBeat.o(10427);
  }
  
  public final void processRequest(String paramString)
  {
    AppMethodBeat.i(248484);
    p.k(paramString, "message");
    AppMethodBeat.o(248484);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AddWindowFromBallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class a
    implements d<BallInfo, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class aa<T>
    implements f<ResultType>
  {
    public static final aa DsE;
    
    static
    {
      AppMethodBeat.i(10395);
      DsE = new aa();
      AppMethodBeat.o(10395);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ab<T>
    implements f<ResultType>
  {
    public static final ab DsF;
    
    static
    {
      AppMethodBeat.i(10397);
      DsF = new ab();
      AppMethodBeat.o(10397);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ac<T>
    implements f<ResultType>
  {
    public static final ac DsG;
    
    static
    {
      AppMethodBeat.i(10398);
      DsG = new ac();
      AppMethodBeat.o(10398);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ad<T>
    implements f<ResultType>
  {
    public static final ad DsH;
    
    static
    {
      AppMethodBeat.i(10399);
      DsH = new ad();
      AppMethodBeat.o(10399);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ae<T>
    implements f<ResultType>
  {
    public static final ae DsI;
    
    static
    {
      AppMethodBeat.i(10400);
      DsI = new ae();
      AppMethodBeat.o(10400);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class af<T>
    implements f<ResultType>
  {
    public static final af DsJ;
    
    static
    {
      AppMethodBeat.i(248558);
      DsJ = new af();
      AppMethodBeat.o(248558);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ag<T>
    implements f<ResultType>
  {
    ag(g paramg) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ah<T>
    implements f<ResultType>
  {
    public static final ah DsL;
    
    static
    {
      AppMethodBeat.i(10401);
      DsL = new ah();
      AppMethodBeat.o(10401);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ai<T>
    implements f<ResultType>
  {
    public static final ai DsM;
    
    static
    {
      AppMethodBeat.i(10402);
      DsM = new ai();
      AppMethodBeat.o(10402);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class aj<T>
    implements f<ResultType>
  {
    public static final aj DsN;
    
    static
    {
      AppMethodBeat.i(10403);
      DsN = new aj();
      AppMethodBeat.o(10403);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ak<T>
    implements f<ResultType>
  {
    public static final ak DsO;
    
    static
    {
      AppMethodBeat.i(10404);
      DsO = new ak();
      AppMethodBeat.o(10404);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AllListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class b
    implements d<IPCVoid, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$CancelUploadTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "id", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class c
    implements d<IPCString, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$DelTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "key", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class e
    implements d<IPCString, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$FixHandOffTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class f
    implements d<IPCVoid, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class g
    implements m<IPCVoid, HandOff>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByIdTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "id", "plugin-handoff_release"})
  public static final class h
    implements m<IPCString, HandOff>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByKeyTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "key", "plugin-handoff_release"})
  public static final class i
    implements m<IPCString, HandOff>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class j
    implements d<HandOff, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class k
    implements d<HandOff, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class l
    implements d<HandOff, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class m
    implements d<HandOff, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SendOpenRequestTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class n
    implements d<HandOff, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class o
    implements d<HandOff, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SyncUserStatusTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class p
    implements d<IPCVoid, GetOnLineInfoInfoResult>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadFail;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class q
    implements d<Bundle, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCDNTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class r
    implements d<Bundle, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCGITask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class s
    implements d<Bundle, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadingTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class t
    implements m<Bundle, IPCBoolean>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UpsertTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class u
    implements d<HandOff, IPCVoid>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class v<T>
    implements f<ResultType>
  {
    public static final v Dsz;
    
    static
    {
      AppMethodBeat.i(10390);
      Dsz = new v();
      AppMethodBeat.o(10390);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class w<T>
    implements f<ResultType>
  {
    public static final w DsA;
    
    static
    {
      AppMethodBeat.i(10391);
      DsA = new w();
      AppMethodBeat.o(10391);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class x<T>
    implements f<ResultType>
  {
    public static final x DsB;
    
    static
    {
      AppMethodBeat.i(10392);
      DsB = new x();
      AppMethodBeat.o(10392);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class y<T>
    implements f<ResultType>
  {
    public static final y DsC;
    
    static
    {
      AppMethodBeat.i(10393);
      DsC = new y();
      AppMethodBeat.o(10393);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class z<T>
    implements f<ResultType>
  {
    public static final z DsD;
    
    static
    {
      AppMethodBeat.i(10394);
      DsD = new z();
      AppMethodBeat.o(10394);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.g
 * JD-Core Version:    0.7.0.1
 */