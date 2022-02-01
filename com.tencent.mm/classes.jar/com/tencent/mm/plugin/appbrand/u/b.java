package com.tencent.mm.plugin.appbrand.u;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/nfc/WxaNFCDiscoverableForegroundDispatchImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCDiscoverableForegroundDispatchImpl;", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Ljava/lang/String;Landroid/app/Activity;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "mCurRunningState", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "mOnRunningStateChangedListener", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "mPendingDispatchIntent", "Landroid/content/Intent;", "getOnRunningStateChangedListener", "getRunningStateController", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController;", "realTryDispatchNfcTagDiscovered", "", "intent", "requireOnRunningStateChangedListener", "setRequireCallbackOnForeground", "requireCallbackOnForeground", "", "stopListenRunningStateChangeIfNeed", "tryDispatchNfcTagDiscovered", "tryListenRunningStateChange", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public static final b.a tqh;
  private final f rot;
  private volatile com.tencent.mm.plugin.appbrand.b.b tqi;
  private c.a tqj;
  private Intent tqk;
  
  static
  {
    AppMethodBeat.i(317061);
    tqh = new b.a((byte)0);
    AppMethodBeat.o(317061);
  }
  
  public b(String paramString, Activity paramActivity, f paramf)
  {
    super(paramString, paramActivity);
    AppMethodBeat.i(317032);
    this.rot = paramf;
    this.tqi = com.tencent.mm.plugin.appbrand.b.b.qKw;
    jE(true);
    AppMethodBeat.o(317032);
  }
  
  private final void N(Intent paramIntent)
  {
    AppMethodBeat.i(317044);
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "realTryDispatchNfcTagDiscovered");
    super.I(paramIntent);
    AppMethodBeat.o(317044);
  }
  
  private final void O(f paramf)
  {
    AppMethodBeat.i(317036);
    paramf = Q(paramf);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "tryListenRunningStateChange, runningStateController is null");
      AppMethodBeat.o(317036);
      return;
    }
    com.tencent.mm.plugin.appbrand.b.b localb = paramf.qKC.chD();
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", s.X("tryListenRunningStateChange, curRunningState: ", localb));
    this.tqi = localb;
    paramf.a(cCU());
    AppMethodBeat.o(317036);
  }
  
  private final void P(f paramf)
  {
    AppMethodBeat.i(317041);
    c.a locala = cCT();
    if (locala == null)
    {
      Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "stopListenRunningStateChangeIfNeed, not need");
      AppMethodBeat.o(317041);
      return;
    }
    paramf = Q(paramf);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "stopListenRunningStateChangeIfNeed, runningStateController is null");
      AppMethodBeat.o(317041);
      return;
    }
    this.tqi = com.tencent.mm.plugin.appbrand.b.b.qKw;
    paramf.b(locala);
    AppMethodBeat.o(317041);
  }
  
  private static c Q(f paramf)
  {
    AppMethodBeat.i(317055);
    if (!(paramf instanceof k))
    {
      Log.w("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "getRunningStateController, component is not AppBrandComponentWithExtra");
      AppMethodBeat.o(317055);
      return null;
    }
    paramf = ((k)paramf).getRuntime();
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "getRunningStateController, runtime is null");
      AppMethodBeat.o(317055);
      return null;
    }
    paramf = paramf.qsB;
    AppMethodBeat.o(317055);
    return paramf;
  }
  
  private static final void a(b paramb, String paramString, com.tencent.mm.plugin.appbrand.b.b paramb1)
  {
    AppMethodBeat.i(317058);
    s.u(paramb, "this$0");
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "onRunningStateChanged, appId: %s, state: %s", new Object[] { paramString, paramb1 });
    if (!s.p(paramString, paramb.getAppId()))
    {
      AppMethodBeat.o(317058);
      return;
    }
    paramb.tqi = paramb1;
    paramString = paramb.tqk;
    if ((paramString != null) && (com.tencent.mm.plugin.appbrand.b.b.qKw == paramb1))
    {
      paramb.N(paramString);
      paramb.tqk = null;
    }
    AppMethodBeat.o(317058);
  }
  
  private final c.a cCT()
  {
    try
    {
      c.a locala = this.tqj;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final c.a cCU()
  {
    try
    {
      AppMethodBeat.i(317053);
      c.a locala = this.tqj;
      Object localObject1 = locala;
      if (locala == null)
      {
        localObject1 = new b..ExternalSyntheticLambda0(this);
        this.tqj = ((c.a)localObject1);
      }
      AppMethodBeat.o(317053);
      return localObject1;
    }
    finally {}
  }
  
  public final void I(Intent paramIntent)
  {
    AppMethodBeat.i(317072);
    s.u(paramIntent, "intent");
    com.tencent.mm.plugin.appbrand.b.b localb = this.tqi;
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", s.X("tryDispatchNfcTagDiscovered, curRunningState: ", localb));
    if (com.tencent.mm.plugin.appbrand.b.b.qKw == localb)
    {
      N(paramIntent);
      AppMethodBeat.o(317072);
      return;
    }
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", "tryDispatchNfcTagDiscovered, dispatch pending");
    this.tqk = paramIntent;
    AppMethodBeat.o(317072);
  }
  
  public final void jE(boolean paramBoolean)
  {
    AppMethodBeat.i(317068);
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableForegroundDispatchImpl", s.X("setRequireCallbackOnForeground, requireCallbackOnForeground: ", Boolean.valueOf(paramBoolean)));
    super.jE(paramBoolean);
    if (paramBoolean)
    {
      O(this.rot);
      AppMethodBeat.o(317068);
      return;
    }
    P(this.rot);
    AppMethodBeat.o(317068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b
 * JD-Core Version:    0.7.0.1
 */