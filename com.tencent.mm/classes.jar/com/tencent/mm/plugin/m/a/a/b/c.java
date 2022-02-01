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
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/WxaFlutterRenderView;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "Landroid/widget/FrameLayout;", "Lio/flutter/embedding/engine/renderer/FlutterUiDisplayListener;", "context", "Landroid/content/Context;", "viewId", "", "engineProvider", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "(Landroid/content/Context;JLcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;)V", "appBrandWebView", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "background", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterViewAttached", "flutterViewContainer", "flutterViewForeground", "Lio/flutter/embedding/android/FlutterView;", "flutterViewIdle", "inStack", "onForegroundTime", "pendingAttachFlutterView", "Ljava/lang/Runnable;", "getPendingAttachFlutterView", "()Ljava/lang/Runnable;", "setPendingAttachFlutterView", "(Ljava/lang/Runnable;)V", "addLabel", "", "addLayoutChangeListener", "listener", "Landroid/view/View$OnLayoutChangeListener;", "attachFlutterView", "lastForegroundView", "detachFlutterView", "enterFullScreen", "exitFullScreen", "getView", "Landroid/view/View;", "getViewId", "onBackground", "onDestroy", "onFlutterUiDisplayed", "onFlutterUiNoLongerDisplayed", "onForeground", "onShow", "onStackPop", "onStackPush", "removeLayoutChangeListener", "setWxaWebView", "view", "Companion", "luggage-native-view_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends FrameLayout
  implements a, io.flutter.embedding.engine.b.b
{
  public static final c.a vOP;
  private final long sJM;
  private io.flutter.embedding.engine.a tti;
  private final com.tencent.mm.plugin.m.a.a.b vOE;
  private boolean vOG;
  private ax vOH;
  private boolean vOI;
  private boolean vOJ;
  private FlutterView vOK;
  private FlutterView vOL;
  private FrameLayout vOM;
  private long vON;
  private Runnable vOO;
  
  static
  {
    AppMethodBeat.i(123868);
    vOP = new c.a((byte)0);
    AppMethodBeat.o(123868);
  }
  
  public c(Context paramContext, long paramLong, com.tencent.mm.plugin.m.a.a.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(123867);
    this.sJM = paramLong;
    this.vOE = paramb;
    this.vOG = true;
    this.vOK = new FlutterView(paramContext, FlutterView.b.MZa);
    this.vOL = new FlutterView(paramContext, FlutterView.b.MZa);
    setBackgroundColor(-1);
    this.vOK.setBackgroundColor(-1);
    this.vOL.setBackgroundColor(-1);
    this.vOL.a((io.flutter.embedding.engine.b.b)this);
    this.vOK.a((io.flutter.embedding.engine.b.b)this);
    if ((bv.fpR()) || (j.IS_FLAVOR_RED))
    {
      this.vOM = new FrameLayout(getContext());
      addView((View)this.vOM, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
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
      this.vOM.addView((View)this.vOK, new ViewGroup.LayoutParams(-1, -1));
      this.vOM.addView((View)this.vOL, new ViewGroup.LayoutParams(-1, -1));
      AppMethodBeat.o(123867);
      return;
      this.vOM = ((FrameLayout)this);
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
    if (this.vOI)
    {
      AppMethodBeat.o(123860);
      return;
    }
    io.flutter.embedding.engine.a locala = this.vOE.fP(getContext());
    ae.i("WxaFlutterRenderView", "attachFlutterView " + this.sJM);
    if (parama != null) {
      parama.dmS();
    }
    if (parama != null)
    {
      this.vOK.c(locala);
      p.g(locala, "flutterEngine");
      locala.gjd().gjA();
      this.tti = locala;
      this.vOO = ((Runnable)new b(this));
    }
    for (;;)
    {
      this.vOL.requestFocus();
      this.vOI = true;
      AppMethodBeat.o(123860);
      return;
      this.vOL.c(locala);
      p.g(locala, "flutterEngine");
      locala.gjd().gjA();
      this.tti = locala;
    }
  }
  
  public final void bnT()
  {
    AppMethodBeat.i(123854);
    ar.f((Runnable)new c(this));
    AppMethodBeat.o(123854);
  }
  
  public final void cSR()
  {
    AppMethodBeat.i(209908);
    ae.i("WxaFlutterRenderView", "onFirstFrameRendered " + this.sJM);
    AppMethodBeat.o(209908);
  }
  
  public final void cSS()
  {
    AppMethodBeat.i(209909);
    ae.i("WxaFlutterRenderView", "onFlutterUiNoLongerDisplayed " + this.sJM);
    AppMethodBeat.o(209909);
  }
  
  public final void diF()
  {
    AppMethodBeat.i(123855);
    Object localObject = this.vOH;
    if (localObject != null)
    {
      localObject = ((ax)localObject).getFullscreenImpl();
      if (localObject != null)
      {
        ((d)localObject).aYo();
        AppMethodBeat.o(123855);
        return;
      }
    }
    AppMethodBeat.o(123855);
  }
  
  public final void dmS()
  {
    AppMethodBeat.i(123857);
    if (!this.vOI)
    {
      AppMethodBeat.o(123857);
      return;
    }
    ae.i("WxaFlutterRenderView", "detachFlutterView " + this.sJM);
    this.vOG = true;
    this.vOL.giZ();
    this.vOI = false;
    Object localObject = this.tti;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).gjd();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).gjC();
      }
    }
    this.tti = null;
    AppMethodBeat.o(123857);
  }
  
  public final void dmT()
  {
    AppMethodBeat.i(123863);
    this.vOJ = false;
    ae.i("WxaFlutterRenderView", "onStackPop " + this.sJM);
    AppMethodBeat.o(123863);
  }
  
  public final void dmU()
  {
    AppMethodBeat.i(123862);
    this.vOJ = true;
    ae.i("WxaFlutterRenderView", "onStackPush " + this.sJM);
    AppMethodBeat.o(123862);
  }
  
  public final Runnable getPendingAttachFlutterView()
  {
    return this.vOO;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final long getViewId()
  {
    return this.sJM;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(123856);
    ae.i("WxaFlutterRenderView", "onBackground " + this.sJM);
    Object localObject = this.tti;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).gjd();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).gjC();
      }
    }
    localObject = this.tti;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).gjd();
      if (localObject != null)
      {
        ((io.flutter.embedding.engine.c.c)localObject).gjA();
        AppMethodBeat.o(123856);
        return;
      }
    }
    AppMethodBeat.o(123856);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123861);
    ae.i("WxaFlutterRenderView", "onDestroy " + this.sJM);
    removeAllViewsInLayout();
    this.vOL.removeAllViewsInLayout();
    this.vOK.removeAllViewsInLayout();
    this.vOM.removeAllViewsInLayout();
    this.vOH = null;
    AppMethodBeat.o(123861);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(123858);
    com.tencent.mm.plugin.m.a.c.c localc = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.aqn("onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.hU("inject_js_Start", "onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.hU("ui_create", "onForeground");
    this.vON = System.currentTimeMillis();
    ae.i("WxaFlutterRenderView", "onForeground " + this.sJM);
    this.vOG = false;
    AppMethodBeat.o(123858);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(123859);
    Object localObject = com.tencent.mm.plugin.m.a.c.c.vPc;
    localObject = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.aqn(com.tencent.mm.plugin.m.a.c.c.dmV());
    localObject = com.tencent.mm.plugin.m.a.c.c.vPc;
    localObject = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.hU("ui_create", com.tencent.mm.plugin.m.a.c.c.dmV());
    localObject = com.tencent.mm.plugin.m.a.c.c.vPc;
    com.tencent.mm.plugin.m.a.c.c.clear();
    ae.i("WxaFlutterRenderView", "onShow " + this.sJM);
    localObject = this.tti;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).gjd();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).gjB();
      }
    }
    localObject = this.vOO;
    if (localObject != null) {
      ar.o((Runnable)localObject, 30L);
    }
    this.vOO = null;
    AppMethodBeat.o(123859);
  }
  
  public final void setPendingAttachFlutterView(Runnable paramRunnable)
  {
    this.vOO = paramRunnable;
  }
  
  public final void setWxaWebView(ax paramax)
  {
    this.vOH = paramax;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123852);
      c.b(this.vOQ).bringChildToFront((View)c.c(this.vOQ));
      FlutterView localFlutterView = c.d(this.vOQ);
      c.b(this.vOQ, c.c(this.vOQ));
      c.a(this.vOQ, localFlutterView);
      AppMethodBeat.o(123852);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123853);
      Object localObject = c.a(this.vOQ);
      if (localObject != null)
      {
        localObject = ((ax)localObject).getFullscreenImpl();
        if (localObject != null)
        {
          ((d)localObject).O((View)this.vOQ, 90);
          AppMethodBeat.o(123853);
          return;
        }
      }
      AppMethodBeat.o(123853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */