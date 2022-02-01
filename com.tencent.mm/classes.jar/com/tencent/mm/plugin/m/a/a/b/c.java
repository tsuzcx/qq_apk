package com.tencent.mm.plugin.m.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.r.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import d.g.b.p;
import d.l;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/WxaFlutterRenderView;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "Landroid/widget/FrameLayout;", "Lio/flutter/embedding/engine/renderer/FlutterUiDisplayListener;", "context", "Landroid/content/Context;", "viewId", "", "engineProvider", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "(Landroid/content/Context;JLcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;)V", "appBrandWebView", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "background", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterViewAttached", "flutterViewContainer", "flutterViewForeground", "Lio/flutter/embedding/android/FlutterView;", "flutterViewIdle", "inStack", "onForegroundTime", "pendingAttachFlutterView", "Ljava/lang/Runnable;", "getPendingAttachFlutterView", "()Ljava/lang/Runnable;", "setPendingAttachFlutterView", "(Ljava/lang/Runnable;)V", "addLabel", "", "addLayoutChangeListener", "listener", "Landroid/view/View$OnLayoutChangeListener;", "attachFlutterView", "lastForegroundView", "detachFlutterView", "enterFullScreen", "exitFullScreen", "getView", "Landroid/view/View;", "getViewId", "onBackground", "onDestroy", "onFlutterUiDisplayed", "onFlutterUiNoLongerDisplayed", "onForeground", "onShow", "onStackPop", "onStackPush", "removeLayoutChangeListener", "setWxaWebView", "view", "Companion", "luggage-native-view_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends FrameLayout
  implements a, io.flutter.embedding.engine.b.b
{
  public static final c.a vCL;
  private final long syV;
  private io.flutter.embedding.engine.a tiq;
  private final com.tencent.mm.plugin.m.a.a.b vCA;
  private boolean vCC;
  private ay vCD;
  private boolean vCE;
  private boolean vCF;
  private FlutterView vCG;
  private FlutterView vCH;
  private FrameLayout vCI;
  private long vCJ;
  private Runnable vCK;
  
  static
  {
    AppMethodBeat.i(123868);
    vCL = new c.a((byte)0);
    AppMethodBeat.o(123868);
  }
  
  public c(Context paramContext, long paramLong, com.tencent.mm.plugin.m.a.a.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(123867);
    this.syV = paramLong;
    this.vCA = paramb;
    this.vCC = true;
    this.vCG = new FlutterView(paramContext, FlutterView.b.MBV);
    this.vCH = new FlutterView(paramContext, FlutterView.b.MBV);
    setBackgroundColor(-1);
    this.vCG.setBackgroundColor(-1);
    this.vCH.setBackgroundColor(-1);
    this.vCH.a((io.flutter.embedding.engine.b.b)this);
    this.vCG.a((io.flutter.embedding.engine.b.b)this);
    if ((bu.flW()) || (i.IS_FLAVOR_RED))
    {
      this.vCI = new FrameLayout(getContext());
      addView((View)this.vCI, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramContext = new TextView(getContext());
      paramContext.setText((CharSequence)"Flutter");
      paramContext.setTextSize(10.0F);
      paramb = paramContext.getPaint();
      p.g(paramb, "label.paint");
      paramb.setFakeBoldText(true);
      paramContext.setBackgroundColor(-65536);
      paramContext.setTextColor(-1);
      paramContext.setGravity(17);
      double d = Math.ceil(80.0D * Math.sqrt(2.0D)) + 120.0D;
      paramContext.setWidth((int)d);
      d = Math.ceil(d / 2.0D - 40.0D);
      paramContext.setRotation(45.0F);
      paramb = new FrameLayout.LayoutParams(-2, -2);
      paramb.gravity = 5;
      paramb.topMargin = 40;
      paramb.rightMargin = (-(int)d);
      addView((View)paramContext, (ViewGroup.LayoutParams)paramb);
    }
    for (;;)
    {
      this.vCI.addView((View)this.vCG, new ViewGroup.LayoutParams(-1, -1));
      this.vCI.addView((View)this.vCH, new ViewGroup.LayoutParams(-1, -1));
      AppMethodBeat.o(123867);
      return;
      this.vCI = ((FrameLayout)this);
    }
  }
  
  public final void a(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(123865);
    p.h(paramOnLayoutChangeListener, "listener");
    addOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(123865);
  }
  
  public final void b(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(123866);
    p.h(paramOnLayoutChangeListener, "listener");
    removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(123866);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(123860);
    if (this.vCE)
    {
      AppMethodBeat.o(123860);
      return;
    }
    io.flutter.embedding.engine.a locala = this.vCA.fJ(getContext());
    ad.i("WxaFlutterRenderView", "attachFlutterView " + this.syV);
    if (parama != null) {
      parama.djT();
    }
    if (parama != null)
    {
      this.vCG.c(locala);
      p.g(locala, "flutterEngine");
      locala.geB().geY();
      this.tiq = locala;
      this.vCK = ((Runnable)new b(this));
    }
    for (;;)
    {
      this.vCH.requestFocus();
      this.vCE = true;
      AppMethodBeat.o(123860);
      return;
      this.vCH.c(locala);
      p.g(locala, "flutterEngine");
      locala.geB().geY();
      this.tiq = locala;
    }
  }
  
  public final void bnj()
  {
    AppMethodBeat.i(123854);
    aq.f((Runnable)new c(this));
    AppMethodBeat.o(123854);
  }
  
  public final void cQm()
  {
    AppMethodBeat.i(217403);
    ad.i("WxaFlutterRenderView", "onFirstFrameRendered " + this.syV);
    AppMethodBeat.o(217403);
  }
  
  public final void cQn()
  {
    AppMethodBeat.i(217404);
    ad.i("WxaFlutterRenderView", "onFlutterUiNoLongerDisplayed " + this.syV);
    AppMethodBeat.o(217404);
  }
  
  public final void dfI()
  {
    AppMethodBeat.i(123855);
    Object localObject = this.vCD;
    if (localObject != null)
    {
      localObject = ((ay)localObject).getFullscreenImpl();
      if (localObject != null)
      {
        ((d)localObject).aXV();
        AppMethodBeat.o(123855);
        return;
      }
    }
    AppMethodBeat.o(123855);
  }
  
  public final void djT()
  {
    AppMethodBeat.i(123857);
    if (!this.vCE)
    {
      AppMethodBeat.o(123857);
      return;
    }
    ad.i("WxaFlutterRenderView", "detachFlutterView " + this.syV);
    this.vCC = true;
    this.vCH.gex();
    this.vCE = false;
    Object localObject = this.tiq;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).geB();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).gfa();
      }
    }
    this.tiq = null;
    AppMethodBeat.o(123857);
  }
  
  public final void djU()
  {
    AppMethodBeat.i(123863);
    this.vCF = false;
    ad.i("WxaFlutterRenderView", "onStackPop " + this.syV);
    AppMethodBeat.o(123863);
  }
  
  public final void djV()
  {
    AppMethodBeat.i(123862);
    this.vCF = true;
    ad.i("WxaFlutterRenderView", "onStackPush " + this.syV);
    AppMethodBeat.o(123862);
  }
  
  public final Runnable getPendingAttachFlutterView()
  {
    return this.vCK;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final long getViewId()
  {
    return this.syV;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(123856);
    ad.i("WxaFlutterRenderView", "onBackground " + this.syV);
    Object localObject = this.tiq;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).geB();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).gfa();
      }
    }
    localObject = this.tiq;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).geB();
      if (localObject != null)
      {
        ((io.flutter.embedding.engine.c.c)localObject).geY();
        AppMethodBeat.o(123856);
        return;
      }
    }
    AppMethodBeat.o(123856);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123861);
    ad.i("WxaFlutterRenderView", "onDestroy " + this.syV);
    removeAllViewsInLayout();
    this.vCH.removeAllViewsInLayout();
    this.vCG.removeAllViewsInLayout();
    this.vCI.removeAllViewsInLayout();
    this.vCD = null;
    AppMethodBeat.o(123861);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(123858);
    com.tencent.mm.plugin.m.a.c.c localc = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.api("onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.hN("inject_js_Start", "onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.hN("ui_create", "onForeground");
    this.vCJ = System.currentTimeMillis();
    ad.i("WxaFlutterRenderView", "onForeground " + this.syV);
    this.vCC = false;
    AppMethodBeat.o(123858);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(123859);
    Object localObject = com.tencent.mm.plugin.m.a.c.c.vCY;
    localObject = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.api(com.tencent.mm.plugin.m.a.c.c.djW());
    localObject = com.tencent.mm.plugin.m.a.c.c.vCY;
    localObject = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.hN("ui_create", com.tencent.mm.plugin.m.a.c.c.djW());
    localObject = com.tencent.mm.plugin.m.a.c.c.vCY;
    com.tencent.mm.plugin.m.a.c.c.clear();
    ad.i("WxaFlutterRenderView", "onShow " + this.syV);
    localObject = this.tiq;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).geB();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).geZ();
      }
    }
    localObject = this.vCK;
    if (localObject != null) {
      aq.o((Runnable)localObject, 30L);
    }
    this.vCK = null;
    AppMethodBeat.o(123859);
  }
  
  public final void setPendingAttachFlutterView(Runnable paramRunnable)
  {
    this.vCK = paramRunnable;
  }
  
  public final void setWxaWebView(ay paramay)
  {
    this.vCD = paramay;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123852);
      c.b(this.vCM).bringChildToFront((View)c.c(this.vCM));
      FlutterView localFlutterView = c.d(this.vCM);
      c.b(this.vCM, c.c(this.vCM));
      c.a(this.vCM, localFlutterView);
      AppMethodBeat.o(123852);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123853);
      Object localObject = c.a(this.vCM);
      if (localObject != null)
      {
        localObject = ((ay)localObject).getFullscreenImpl();
        if (localObject != null)
        {
          ((d)localObject).O((View)this.vCM, 90);
          AppMethodBeat.o(123853);
          return;
        }
      }
      AppMethodBeat.o(123853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */