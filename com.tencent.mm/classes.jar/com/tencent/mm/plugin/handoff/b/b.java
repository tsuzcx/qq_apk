package com.tencent.mm.plugin.handoff.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.u;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "()V", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "mod", "modFromBallInfo", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "restoreFromBallInfoList", "ballInfoList", "", "uploadFail", "arg", "uploadStart", "", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "AddHandOffFromBallTask", "AddTask", "AddWindowFromBallTask", "AllListTask", "CancelUploadTask", "Companion", "DelAllFloatingWindowTask", "DelTask", "FixHandOffTask", "GetCacheTask", "GetHandOffByIdTask", "GetHandOffByKeyTask", "ModFromBallInfoTask", "ModTask", "OnFileCreateTask", "OnFileDestroyTask", "OnWebViewCreateTask", "OnWebViewDestroyTask", "SetCacheTask", "UploadFail", "UploadSuccessCDNTask", "UploadSuccessCGITask", "UploadingTask", "UpsertTask", "plugin-handoff_release"})
public final class b
  implements a
{
  public static final d tBx;
  
  static
  {
    AppMethodBeat.i(10428);
    tBx = new d((byte)0);
    AppMethodBeat.o(10428);
  }
  
  public final void I(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10412);
    d.g.b.k.h(paramBallInfo, "ballInfo");
    h.a("com.tencent.mm", (Parcelable)paramBallInfo, a.class, (d)t.tBy);
    AppMethodBeat.o(10412);
  }
  
  public final void J(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10413);
    d.g.b.k.h(paramBallInfo, "ballInfo");
    h.a("com.tencent.mm", (Parcelable)paramBallInfo, i.class, (d)z.tBE);
    AppMethodBeat.o(10413);
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10407);
    d.g.b.k.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, l.class, (d)ac.tBH);
    AppMethodBeat.o(10407);
  }
  
  public final boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(10417);
    d.g.b.k.h(paramString, "id");
    d.g.b.k.h(paramc, "info");
    ac.w("HandOffServiceProxy", "uploadStart should only be called in MM process!");
    AppMethodBeat.o(10417);
    return false;
  }
  
  public final void ag(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10420);
    d.g.b.k.h(paramString1, "id");
    d.g.b.k.h(paramString2, "cdnURL");
    d.g.b.k.h(paramString3, "aesKey");
    Bundle localBundle = new Bundle();
    u.Q("id", paramString1);
    u.Q("cdnURL", paramString2);
    u.Q("aesKey", paramString3);
    h.a("com.tencent.mm", (Parcelable)localBundle, p.class, (d)af.tBK);
    AppMethodBeat.o(10420);
  }
  
  public final HandOff aip(String paramString)
  {
    AppMethodBeat.i(10411);
    d.g.b.k.h(paramString, "id");
    paramString = (HandOff)h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), h.class);
    AppMethodBeat.o(10411);
    return paramString;
  }
  
  public final void aiq(String paramString)
  {
    AppMethodBeat.i(10422);
    d.g.b.k.h(paramString, "id");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), c.class, (d)w.tBB);
    AppMethodBeat.o(10422);
  }
  
  public final boolean aw(String paramString, long paramLong)
  {
    AppMethodBeat.i(10418);
    d.g.b.k.h(paramString, "id");
    Bundle localBundle = new Bundle();
    u.Q("id", paramString);
    u.Q("uploadedSize", Long.valueOf(paramLong));
    boolean bool = ((IPCBoolean)h.a("com.tencent.mm", (Parcelable)localBundle, r.class)).value;
    AppMethodBeat.o(10418);
    return bool;
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10408);
    d.g.b.k.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, m.class, (d)ad.tBI);
    AppMethodBeat.o(10408);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10409);
    d.g.b.k.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, j.class, (d)aa.tBF);
    AppMethodBeat.o(10409);
  }
  
  public final void cSC()
  {
    AppMethodBeat.i(10405);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), f.class, (d)y.tBD);
    AppMethodBeat.o(10405);
  }
  
  public final void cSD()
  {
    AppMethodBeat.i(10416);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), b.class, (d)u.tBz);
    AppMethodBeat.o(10416);
  }
  
  public final HandOff cSE()
  {
    AppMethodBeat.i(10424);
    HandOff localHandOff = (HandOff)h.a("com.tencent.mm", (Parcelable)new IPCVoid(), g.class);
    AppMethodBeat.o(10424);
    return localHandOff;
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10410);
    d.g.b.k.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, k.class, (d)ab.tBG);
    AppMethodBeat.o(10410);
  }
  
  public final void dV(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10406);
    d.g.b.k.h(paramList, "ballInfoList");
    AppMethodBeat.o(10406);
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10415);
    d.g.b.k.h(paramString, "key");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), e.class, (d)x.tBC);
    AppMethodBeat.o(10415);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10414);
    d.g.b.k.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, s.class, (d)ah.tBM);
    AppMethodBeat.o(10414);
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(10423);
    h.a("com.tencent.mm", (Parcelable)paramHandOff, n.class, (d)v.tBA);
    AppMethodBeat.o(10423);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10421);
    d.g.b.k.h(paramString1, "id");
    d.g.b.k.h(paramString2, "appId");
    d.g.b.k.h(paramString3, "mediaId");
    Bundle localBundle = new Bundle();
    u.Q("id", paramString1);
    u.Q("appId", paramString2);
    u.Q("sdkVersion", Integer.valueOf(paramInt));
    u.Q("mediaId", paramString3);
    h.a("com.tencent.mm", (Parcelable)localBundle, q.class, (d)ag.tBL);
    AppMethodBeat.o(10421);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10425);
    d.g.b.k.h(paramHandOff, "handOff");
    AppMethodBeat.o(10425);
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10426);
    d.g.b.k.h(paramHandOff, "handOff");
    AppMethodBeat.o(10426);
  }
  
  public final void hf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10419);
    d.g.b.k.h(paramString1, "id");
    d.g.b.k.h(paramString2, "arg");
    Bundle localBundle = new Bundle();
    u.Q("id", paramString1);
    u.Q("arg", paramString2);
    h.a("com.tencent.mm", (Parcelable)localBundle, o.class, (d)ae.tBJ);
    AppMethodBeat.o(10419);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10427);
    d.g.b.k.h(paramHandOff, "handOff");
    AppMethodBeat.o(10427);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AddWindowFromBallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class a
    implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class aa<T>
    implements d<ResultType>
  {
    public static final aa tBF;
    
    static
    {
      AppMethodBeat.i(10397);
      tBF = new aa();
      AppMethodBeat.o(10397);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ab<T>
    implements d<ResultType>
  {
    public static final ab tBG;
    
    static
    {
      AppMethodBeat.i(10398);
      tBG = new ab();
      AppMethodBeat.o(10398);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ac<T>
    implements d<ResultType>
  {
    public static final ac tBH;
    
    static
    {
      AppMethodBeat.i(10399);
      tBH = new ac();
      AppMethodBeat.o(10399);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ad<T>
    implements d<ResultType>
  {
    public static final ad tBI;
    
    static
    {
      AppMethodBeat.i(10400);
      tBI = new ad();
      AppMethodBeat.o(10400);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ae<T>
    implements d<ResultType>
  {
    public static final ae tBJ;
    
    static
    {
      AppMethodBeat.i(10401);
      tBJ = new ae();
      AppMethodBeat.o(10401);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class af<T>
    implements d<ResultType>
  {
    public static final af tBK;
    
    static
    {
      AppMethodBeat.i(10402);
      tBK = new af();
      AppMethodBeat.o(10402);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ag<T>
    implements d<ResultType>
  {
    public static final ag tBL;
    
    static
    {
      AppMethodBeat.i(10403);
      tBL = new ag();
      AppMethodBeat.o(10403);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ah<T>
    implements d<ResultType>
  {
    public static final ah tBM;
    
    static
    {
      AppMethodBeat.i(10404);
      tBM = new ah();
      AppMethodBeat.o(10404);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AllListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class b
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$CancelUploadTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "id", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class c
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-handoff_release"})
  public static final class d {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$DelTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "key", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class e
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$FixHandOffTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class f
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class g
    implements com.tencent.mm.ipcinvoker.k<IPCVoid, HandOff>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByIdTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "id", "plugin-handoff_release"})
  public static final class h
    implements com.tencent.mm.ipcinvoker.k<IPCString, HandOff>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$ModFromBallInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class i
    implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class j
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class k
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class l
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class m
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class n
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadFail;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class o
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCDNTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class p
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCGITask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class q
    implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadingTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class r
    implements com.tencent.mm.ipcinvoker.k<Bundle, IPCBoolean>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UpsertTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class s
    implements com.tencent.mm.ipcinvoker.b<HandOff, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class t<T>
    implements d<ResultType>
  {
    public static final t tBy;
    
    static
    {
      AppMethodBeat.i(10390);
      tBy = new t();
      AppMethodBeat.o(10390);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class u<T>
    implements d<ResultType>
  {
    public static final u tBz;
    
    static
    {
      AppMethodBeat.i(10391);
      tBz = new u();
      AppMethodBeat.o(10391);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class v<T>
    implements d<ResultType>
  {
    public static final v tBA;
    
    static
    {
      AppMethodBeat.i(10392);
      tBA = new v();
      AppMethodBeat.o(10392);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class w<T>
    implements d<ResultType>
  {
    public static final w tBB;
    
    static
    {
      AppMethodBeat.i(10393);
      tBB = new w();
      AppMethodBeat.o(10393);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class x<T>
    implements d<ResultType>
  {
    public static final x tBC;
    
    static
    {
      AppMethodBeat.i(10394);
      tBC = new x();
      AppMethodBeat.o(10394);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class y<T>
    implements d<ResultType>
  {
    public static final y tBD;
    
    static
    {
      AppMethodBeat.i(10395);
      tBD = new y();
      AppMethodBeat.o(10395);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class z<T>
    implements d<ResultType>
  {
    public static final z tBE;
    
    static
    {
      AppMethodBeat.i(10396);
      tBE = new z();
      AppMethodBeat.o(10396);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.b
 * JD-Core Version:    0.7.0.1
 */