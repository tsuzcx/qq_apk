package com.tencent.mm.plugin.handoff.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.u;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "()V", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "mod", "modFromBallInfo", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "restoreFromBallInfoList", "ballInfoList", "", "sendOpenRequest", "uploadFail", "arg", "uploadStart", "", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "AddHandOffFromBallTask", "AddTask", "AddWindowFromBallTask", "AllListTask", "CancelUploadTask", "Companion", "DelAllFloatingWindowTask", "DelTask", "FixHandOffTask", "GetCacheTask", "GetHandOffByIdTask", "GetHandOffByKeyTask", "ModFromBallInfoTask", "ModTask", "OnFileCreateTask", "OnFileDestroyTask", "OnWebViewCreateTask", "OnWebViewDestroyTask", "SendOpenRequestTask", "SetCacheTask", "UploadFail", "UploadSuccessCDNTask", "UploadSuccessCGITask", "UploadingTask", "UpsertTask", "plugin-handoff_release"})
public final class c
  implements a
{
  public static final d uPS;
  
  static
  {
    AppMethodBeat.i(10428);
    uPS = new d((byte)0);
    AppMethodBeat.o(10428);
  }
  
  public final void L(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10412);
    p.h(paramBallInfo, "ballInfo");
    h.a("com.tencent.mm", (Parcelable)paramBallInfo, a.class, (d)u.uPT);
    AppMethodBeat.o(10412);
  }
  
  public final void M(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10413);
    p.h(paramBallInfo, "ballInfo");
    h.a("com.tencent.mm", (Parcelable)paramBallInfo, i.class, (d)aa.uPZ);
    AppMethodBeat.o(10413);
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10407);
    p.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, l.class, (d)ad.uQc);
    AppMethodBeat.o(10407);
  }
  
  public final boolean a(String paramString, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(10417);
    p.h(paramString, "id");
    p.h(paramc, "info");
    ae.w("HandOffServiceProxy", "uploadStart should only be called in MM process!");
    AppMethodBeat.o(10417);
    return false;
  }
  
  public final void an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10420);
    p.h(paramString1, "id");
    p.h(paramString2, "cdnURL");
    p.h(paramString3, "aesKey");
    Bundle localBundle = new Bundle();
    u.R("id", paramString1);
    u.R("cdnURL", paramString2);
    u.R("aesKey", paramString3);
    h.a("com.tencent.mm", (Parcelable)localBundle, q.class, (d)ah.uQg);
    AppMethodBeat.o(10420);
  }
  
  public final HandOff aod(String paramString)
  {
    AppMethodBeat.i(10411);
    p.h(paramString, "id");
    paramString = (HandOff)h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), h.class);
    AppMethodBeat.o(10411);
    return paramString;
  }
  
  public final void aoe(String paramString)
  {
    AppMethodBeat.i(10422);
    p.h(paramString, "id");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), c.class, (d)x.uPW);
    AppMethodBeat.o(10422);
  }
  
  public final boolean az(String paramString, long paramLong)
  {
    AppMethodBeat.i(10418);
    p.h(paramString, "id");
    Bundle localBundle = new Bundle();
    u.R("id", paramString);
    u.R("uploadedSize", Long.valueOf(paramLong));
    boolean bool = ((IPCBoolean)h.a("com.tencent.mm", (Parcelable)localBundle, s.class)).value;
    AppMethodBeat.o(10418);
    return bool;
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10408);
    p.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, m.class, (d)ae.uQd);
    AppMethodBeat.o(10408);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10409);
    p.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, j.class, (d)ab.uQa);
    AppMethodBeat.o(10409);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10410);
    p.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, k.class, (d)ac.uQb);
    AppMethodBeat.o(10410);
  }
  
  public final void deA()
  {
    AppMethodBeat.i(10405);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), f.class, (d)z.uPY);
    AppMethodBeat.o(10405);
  }
  
  public final void deB()
  {
    AppMethodBeat.i(10416);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), b.class, (d)v.uPU);
    AppMethodBeat.o(10416);
  }
  
  public final HandOff deC()
  {
    AppMethodBeat.i(10424);
    HandOff localHandOff = (HandOff)h.a("com.tencent.mm", (Parcelable)new IPCVoid(), g.class);
    AppMethodBeat.o(10424);
    return localHandOff;
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10415);
    p.h(paramString, "key");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), e.class, (d)y.uPX);
    AppMethodBeat.o(10415);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10414);
    p.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, t.class, (d)aj.uQi);
    AppMethodBeat.o(10414);
  }
  
  public final void em(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10406);
    p.h(paramList, "ballInfoList");
    AppMethodBeat.o(10406);
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(188392);
    p.h(paramHandOff, "handOff");
    h.a("com.tencent.mm", (Parcelable)paramHandOff, n.class, (d)af.uQe);
    AppMethodBeat.o(188392);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10421);
    p.h(paramString1, "id");
    p.h(paramString2, "appId");
    p.h(paramString3, "mediaId");
    Bundle localBundle = new Bundle();
    u.R("id", paramString1);
    u.R("appId", paramString2);
    u.R("sdkVersion", Integer.valueOf(paramInt));
    u.R("mediaId", paramString3);
    h.a("com.tencent.mm", (Parcelable)localBundle, r.class, (d)ai.uQh);
    AppMethodBeat.o(10421);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10423);
    h.a("com.tencent.mm", (Parcelable)paramHandOff, o.class, (d)w.uPV);
    AppMethodBeat.o(10423);
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10425);
    p.h(paramHandOff, "handOff");
    AppMethodBeat.o(10425);
  }
  
  public final void hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10419);
    p.h(paramString1, "id");
    p.h(paramString2, "arg");
    Bundle localBundle = new Bundle();
    u.R("id", paramString1);
    u.R("arg", paramString2);
    h.a("com.tencent.mm", (Parcelable)localBundle, p.class, (d)ag.uQf);
    AppMethodBeat.o(10419);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10426);
    p.h(paramHandOff, "handOff");
    AppMethodBeat.o(10426);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10427);
    p.h(paramHandOff, "handOff");
    AppMethodBeat.o(10427);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AddWindowFromBallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class a
    implements b<BallInfo, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class aa<T>
    implements d<ResultType>
  {
    public static final aa uPZ;
    
    static
    {
      AppMethodBeat.i(10396);
      uPZ = new aa();
      AppMethodBeat.o(10396);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ab<T>
    implements d<ResultType>
  {
    public static final ab uQa;
    
    static
    {
      AppMethodBeat.i(10397);
      uQa = new ab();
      AppMethodBeat.o(10397);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ac<T>
    implements d<ResultType>
  {
    public static final ac uQb;
    
    static
    {
      AppMethodBeat.i(10398);
      uQb = new ac();
      AppMethodBeat.o(10398);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ad<T>
    implements d<ResultType>
  {
    public static final ad uQc;
    
    static
    {
      AppMethodBeat.i(10399);
      uQc = new ad();
      AppMethodBeat.o(10399);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ae<T>
    implements d<ResultType>
  {
    public static final ae uQd;
    
    static
    {
      AppMethodBeat.i(10400);
      uQd = new ae();
      AppMethodBeat.o(10400);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class af<T>
    implements d<ResultType>
  {
    public static final af uQe;
    
    static
    {
      AppMethodBeat.i(188391);
      uQe = new af();
      AppMethodBeat.o(188391);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ag<T>
    implements d<ResultType>
  {
    public static final ag uQf;
    
    static
    {
      AppMethodBeat.i(10401);
      uQf = new ag();
      AppMethodBeat.o(10401);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ah<T>
    implements d<ResultType>
  {
    public static final ah uQg;
    
    static
    {
      AppMethodBeat.i(10402);
      uQg = new ah();
      AppMethodBeat.o(10402);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class ai<T>
    implements d<ResultType>
  {
    public static final ai uQh;
    
    static
    {
      AppMethodBeat.i(10403);
      uQh = new ai();
      AppMethodBeat.o(10403);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class aj<T>
    implements d<ResultType>
  {
    public static final aj uQi;
    
    static
    {
      AppMethodBeat.i(10404);
      uQi = new aj();
      AppMethodBeat.o(10404);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AllListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class b
    implements b<IPCVoid, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$CancelUploadTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "id", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class c
    implements b<IPCString, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$Companion;", "", "()V", "TAG", "", "plugin-handoff_release"})
  public static final class d {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$DelTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "key", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class e
    implements b<IPCString, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$FixHandOffTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class f
    implements b<IPCVoid, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class g
    implements k<IPCVoid, HandOff>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByIdTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "id", "plugin-handoff_release"})
  public static final class h
    implements k<IPCString, HandOff>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$ModFromBallInfoTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class i
    implements b<BallInfo, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class j
    implements b<HandOff, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class k
    implements b<HandOff, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class l
    implements b<HandOff, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class m
    implements b<HandOff, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SendOpenRequestTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class n
    implements b<HandOff, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class o
    implements b<HandOff, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadFail;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class p
    implements b<Bundle, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCDNTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class q
    implements b<Bundle, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCGITask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class r
    implements b<Bundle, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadingTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "plugin-handoff_release"})
  public static final class s
    implements k<Bundle, IPCBoolean>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UpsertTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"})
  public static final class t
    implements b<HandOff, IPCVoid>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class u<T>
    implements d<ResultType>
  {
    public static final u uPT;
    
    static
    {
      AppMethodBeat.i(10390);
      uPT = new u();
      AppMethodBeat.o(10390);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class v<T>
    implements d<ResultType>
  {
    public static final v uPU;
    
    static
    {
      AppMethodBeat.i(10391);
      uPU = new v();
      AppMethodBeat.o(10391);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class w<T>
    implements d<ResultType>
  {
    public static final w uPV;
    
    static
    {
      AppMethodBeat.i(10392);
      uPV = new w();
      AppMethodBeat.o(10392);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class x<T>
    implements d<ResultType>
  {
    public static final x uPW;
    
    static
    {
      AppMethodBeat.i(10393);
      uPW = new x();
      AppMethodBeat.o(10393);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class y<T>
    implements d<ResultType>
  {
    public static final y uPX;
    
    static
    {
      AppMethodBeat.i(10394);
      uPX = new y();
      AppMethodBeat.o(10394);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class z<T>
    implements d<ResultType>
  {
    public static final z uPY;
    
    static
    {
      AppMethodBeat.i(10395);
      uPY = new z();
      AppMethodBeat.o(10395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.c
 * JD-Core Version:    0.7.0.1
 */