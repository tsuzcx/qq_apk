package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l.b;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "backgroundSupportStateListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IListener;", "myTag", "", "isSupportFloatBallMenu", "", "isSupportSwipeToFloatBall", "onBackgroundSupportStateChange", "", "isEnabled", "onClose", "way", "", "onClosePermissionAllowed", "onCreate", "floatBallType", "floatBallKey", "onDestroy", "onEnterPage", "onExitPage", "onReceivedBallInfoRemovedEvent", "onReceivedFinishWhenSwitchBallEvent", "requireBackgroundSupportStateListener", "updateBallInfoWithInitConfig", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.ball.service.e
{
  public static final a roH;
  final String djQ;
  final AppBrandRuntime qzz;
  private volatile l.b roI;
  
  static
  {
    AppMethodBeat.i(318294);
    roH = new a((byte)0);
    AppMethodBeat.o(318294);
  }
  
  public b(f paramf, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramf);
    AppMethodBeat.i(318236);
    this.qzz = paramAppBrandRuntime;
    paramf = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.rKk;
    this.djQ = s.X("MicroMsg.AppBrand.AppBrandBluetoothFloatBallHelper#", e.a.ah(this.qzz));
    AppMethodBeat.o(318236);
  }
  
  private static final void a(b paramb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(318258);
    s.u(paramb, "this$0");
    Log.i(paramb.djQ, s.X("onCheckResult#onClose, isOk: ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      paramb.zZ(paramInt);
      AppMethodBeat.o(318258);
      return;
    }
    paramb.cYp();
    paramb.vkT.iR(true);
    paramb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.rKk.af(paramb.qzz);
    if (paramb != null) {
      paramb.cqI();
    }
    AppMethodBeat.o(318258);
  }
  
  private final void zZ(int paramInt)
  {
    AppMethodBeat.i(318248);
    cYv().opType = FK(paramInt);
    cYr();
    c.a(this.vkT, this.vjX.getBallPosition(), (a)new b(this));
    AppMethodBeat.o(318248);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(318327);
    Log.i(this.djQ, "onCreate, floatBallType: " + paramString + ", floatBallKey: " + paramString);
    super.J(paramInt, paramString);
    l locall = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.rKk.ae(this.qzz);
    l.b localb = this.roI;
    paramString = localb;
    if (localb == null)
    {
      Log.i(this.djQ, "requireBackgroundSupportStateListener, create");
      paramString = (l.b)new c(this);
      this.roI = paramString;
    }
    locall.a(paramString);
    AppMethodBeat.o(318327);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(318320);
    Log.i(this.djQ, "onReceivedFinishWhenSwitchBallEvent");
    this.vkT.iR(true);
    AppMethodBeat.o(318320);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(318316);
    Log.i(this.djQ, "onExitPage");
    if (cYl() != null) {
      E(true);
    }
    AppMethodBeat.o(318316);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(318312);
    Log.i(this.djQ, "onEnterPage");
    if (cYl() != null) {
      E(false);
    }
    AppMethodBeat.o(318312);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(318342);
    Log.i(this.djQ, "onReceivedBallInfoRemovedEvent");
    super.coj();
    l locall = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.rKk.af(this.qzz);
    if (locall != null) {
      locall.cqI();
    }
    AppMethodBeat.o(318342);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(318334);
    Log.i(this.djQ, "onDestroy");
    super.onDestroy();
    l.b localb = this.roI;
    if (localb == null)
    {
      AppMethodBeat.o(318334);
      return;
    }
    l locall = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.rKk.af(this.qzz);
    if (locall != null) {
      locall.b(localb);
    }
    AppMethodBeat.o(318334);
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(318340);
    Log.i(this.djQ, s.X("onClose, way: ", Integer.valueOf(paramInt)));
    if (cYo())
    {
      Context localContext = this.qzz.mContext;
      s.s(localContext, "runtime.appContext");
      if (com.tencent.mm.compatible.e.b.dh(localContext))
      {
        zZ(paramInt);
        AppMethodBeat.o(318340);
        return true;
      }
      AppBrandFloatBallPermissionHelper.a(localContext, 33, new b..ExternalSyntheticLambda0(this, paramInt));
      AppMethodBeat.o(318340);
      return true;
    }
    AppMethodBeat.o(318340);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void a(AppBrandRuntime paramAppBrandRuntime, b paramb)
    {
      AppMethodBeat.i(318212);
      s.u(paramAppBrandRuntime, "$runtime");
      s.u(paramb, "$this_apply");
      e.a locala = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e.rKk;
      if (!e.a.ai(paramAppBrandRuntime)) {
        paramb.coi();
      }
      AppMethodBeat.o(318212);
    }
    
    public static b ab(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(318208);
      s.u(paramAppBrandRuntime, "runtime");
      if (!(paramAppBrandRuntime instanceof w))
      {
        Log.w("MicroMsg.AppBrand.AppBrandBluetoothFloatBallHelper", "create, runtime is not AppBrandRuntimeWC");
        AppMethodBeat.o(318208);
        return null;
      }
      b localb = new b((f)new e(AndroidContextUtil.castActivityOrNull(((w)paramAppBrandRuntime).mContext), (w)paramAppBrandRuntime), paramAppBrandRuntime);
      localb.J(33, com.tencent.mm.plugin.ball.f.b.dx(((w)paramAppBrandRuntime).mAppId, ((w)paramAppBrandRuntime).qsh.eul));
      AppBrandInitConfig localAppBrandInitConfig = (AppBrandInitConfig)((w)paramAppBrandRuntime).getInitConfig();
      Log.i(localb.djQ, s.X("updateBallInfoWithInitConfig, initConfig: ", localAppBrandInitConfig));
      BallInfo localBallInfo1;
      BallInfo localBallInfo2;
      String str;
      if (localAppBrandInitConfig != null)
      {
        localBallInfo1 = localb.vjV;
        localBallInfo1.icon = localAppBrandInitConfig.iconUrl;
        localBallInfo1.name = localAppBrandInitConfig.hEy;
        localBallInfo2 = localb.vjV;
        switch (localb.qzz.qsh.eul)
        {
        default: 
          str = null;
        }
      }
      for (;;)
      {
        localBallInfo2.tag = str;
        d.a((FloatBallHelper)localb, localAppBrandInitConfig);
        localBallInfo1.vjI.mUU = 20;
        localb.cYr();
        paramAppBrandRuntime.U(new b.a..ExternalSyntheticLambda0(paramAppBrandRuntime, localb));
        AppMethodBeat.o(318208);
        return localb;
        str = localb.qzz.mContext.getString(ba.i.app_brand_app_debug_type_testing);
        continue;
        str = localb.qzz.mContext.getString(ba.i.app_brand_app_debug_type_previewing);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper$onClosePermissionAllowed$1", "Lcom/tencent/mm/plugin/ball/listener/OnFloatBallTransformationListener;", "onAnimationCancel", "", "onAnimationEnd", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a
  {
    b(b paramb) {}
    
    public final void aXe()
    {
      AppMethodBeat.i(318206);
      Log.i(b.a(this.roJ), "onAnimationCancel#onClosePermissionAllowed");
      b.b(this.roJ).iR(true);
      AppMethodBeat.o(318206);
    }
    
    public final void onAnimationEnd()
    {
      AppMethodBeat.i(318200);
      Log.i(b.a(this.roJ), "onAnimationEnd#onClosePermissionAllowed");
      b.b(this.roJ).iR(false);
      AppMethodBeat.o(318200);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper$requireBackgroundSupportStateListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IListener;", "debugName", "", "getDebugName", "()Ljava/lang/String;", "onStateChange", "", "isEnabled", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements l.b
  {
    private final String roK;
    
    c(b paramb)
    {
      AppMethodBeat.i(318195);
      this.roK = b.a(this.roJ);
      AppMethodBeat.o(318195);
    }
    
    public final String com()
    {
      return this.roK;
    }
    
    public final void iQ(boolean paramBoolean)
    {
      AppMethodBeat.i(318203);
      Log.i(b.a(this.roJ), s.X("onStateChange, isEnabled: ", Boolean.valueOf(paramBoolean)));
      b.a(this.roJ, paramBoolean);
      AppMethodBeat.o(318203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.b
 * JD-Core Version:    0.7.0.1
 */