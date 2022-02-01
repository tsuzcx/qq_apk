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
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.s.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/WxaFlutterRenderView;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "Landroid/widget/FrameLayout;", "Lio/flutter/embedding/engine/renderer/OnFirstFrameRenderedListener;", "context", "Landroid/content/Context;", "viewId", "", "engineProvider", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "(Landroid/content/Context;JLcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;)V", "appBrandWebView", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "background", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterViewAttached", "flutterViewContainer", "flutterViewForeground", "Lio/flutter/embedding/android/FlutterView;", "flutterViewIdle", "inStack", "onForegroundTime", "pendingAttachFlutterView", "Ljava/lang/Runnable;", "getPendingAttachFlutterView", "()Ljava/lang/Runnable;", "setPendingAttachFlutterView", "(Ljava/lang/Runnable;)V", "addLabel", "", "addLayoutChangeListener", "listener", "Landroid/view/View$OnLayoutChangeListener;", "attachFlutterView", "lastForegroundView", "detachFlutterView", "enterFullScreen", "exitFullScreen", "getView", "Landroid/view/View;", "getViewId", "onBackground", "onDestroy", "onFirstFrameRendered", "onForeground", "onShow", "onStackPop", "onStackPush", "removeLayoutChangeListener", "setWxaWebView", "view", "Companion", "luggage-native-view_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends FrameLayout
  implements a, io.flutter.embedding.engine.b.b
{
  public static final c.a trP;
  private io.flutter.embedding.engine.a rdu;
  private final com.tencent.mm.plugin.m.a.a.b trD;
  private boolean trF;
  private bd trG;
  private boolean trH;
  private boolean trI;
  private FlutterView trJ;
  private FlutterView trK;
  private FrameLayout trL;
  private long trM;
  private Runnable trN;
  private final long trO;
  
  static
  {
    AppMethodBeat.i(123868);
    trP = new c.a((byte)0);
    AppMethodBeat.o(123868);
  }
  
  public c(Context paramContext, long paramLong, com.tencent.mm.plugin.m.a.a.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(123867);
    this.trO = paramLong;
    this.trD = paramb;
    this.trF = true;
    this.trJ = new FlutterView(paramContext, FlutterView.b.IXY);
    this.trK = new FlutterView(paramContext, FlutterView.b.IXY);
    setBackgroundColor(-1);
    this.trJ.setBackgroundColor(-1);
    this.trK.setBackgroundColor(-1);
    this.trK.addOnFirstFrameRenderedListener((io.flutter.embedding.engine.b.b)this);
    this.trJ.addOnFirstFrameRenderedListener((io.flutter.embedding.engine.b.b)this);
    if ((bu.eGR()) || (h.IS_FLAVOR_RED))
    {
      this.trL = new FrameLayout(getContext());
      addView((View)this.trL, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      paramContext = new TextView(getContext());
      paramContext.setText((CharSequence)"Flutter");
      paramContext.setTextSize(10.0F);
      paramb = paramContext.getPaint();
      k.g(paramb, "label.paint");
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
      this.trL.addView((View)this.trJ, new ViewGroup.LayoutParams(-1, -1));
      this.trL.addView((View)this.trK, new ViewGroup.LayoutParams(-1, -1));
      AppMethodBeat.o(123867);
      return;
      this.trL = ((FrameLayout)this);
    }
  }
  
  public final void a(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(123865);
    k.h(paramOnLayoutChangeListener, "listener");
    addOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(123865);
  }
  
  public final void b(View.OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    AppMethodBeat.i(123866);
    k.h(paramOnLayoutChangeListener, "listener");
    removeOnLayoutChangeListener(paramOnLayoutChangeListener);
    AppMethodBeat.o(123866);
  }
  
  public final void bcC()
  {
    AppMethodBeat.i(123854);
    aq.f((Runnable)new c(this));
    AppMethodBeat.o(123854);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(123860);
    if (this.trH)
    {
      AppMethodBeat.o(123860);
      return;
    }
    io.flutter.embedding.engine.a locala = this.trD.fs(getContext());
    ad.i("WxaFlutterRenderView", "attachFlutterView " + this.trO);
    if (parama != null) {
      parama.cMZ();
    }
    if (parama != null)
    {
      this.trJ.b(locala);
      k.g(locala, "flutterEngine");
      locala.fuB().fuV();
      this.rdu = locala;
      this.trN = ((Runnable)new b(this));
    }
    for (;;)
    {
      this.trK.requestFocus();
      this.trH = true;
      AppMethodBeat.o(123860);
      return;
      this.trK.b(locala);
      k.g(locala, "flutterEngine");
      locala.fuB().fuV();
      this.rdu = locala;
    }
  }
  
  public final void cMY()
  {
    AppMethodBeat.i(123855);
    Object localObject = this.trG;
    if (localObject != null)
    {
      localObject = ((bd)localObject).getFullscreenImpl();
      if (localObject != null)
      {
        ((d)localObject).aNT();
        AppMethodBeat.o(123855);
        return;
      }
    }
    AppMethodBeat.o(123855);
  }
  
  public final void cMZ()
  {
    AppMethodBeat.i(123857);
    if (!this.trH)
    {
      AppMethodBeat.o(123857);
      return;
    }
    ad.i("WxaFlutterRenderView", "detachFlutterView " + this.trO);
    this.trF = true;
    this.trK.fuw();
    this.trH = false;
    Object localObject = this.rdu;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fuB();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).fuX();
      }
    }
    this.rdu = null;
    AppMethodBeat.o(123857);
  }
  
  public final void cNa()
  {
    AppMethodBeat.i(123863);
    this.trI = false;
    ad.i("WxaFlutterRenderView", "onStackPop " + this.trO);
    AppMethodBeat.o(123863);
  }
  
  public final void cNb()
  {
    AppMethodBeat.i(123862);
    this.trI = true;
    ad.i("WxaFlutterRenderView", "onStackPush " + this.trO);
    AppMethodBeat.o(123862);
  }
  
  public final Runnable getPendingAttachFlutterView()
  {
    return this.trN;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final long getViewId()
  {
    return this.trO;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(123856);
    ad.i("WxaFlutterRenderView", "onBackground " + this.trO);
    Object localObject = this.rdu;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fuB();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).fuX();
      }
    }
    localObject = this.rdu;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fuB();
      if (localObject != null)
      {
        ((io.flutter.embedding.engine.c.c)localObject).fuV();
        AppMethodBeat.o(123856);
        return;
      }
    }
    AppMethodBeat.o(123856);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123861);
    ad.i("WxaFlutterRenderView", "onDestroy " + this.trO);
    removeAllViewsInLayout();
    this.trK.removeAllViewsInLayout();
    this.trJ.removeAllViewsInLayout();
    this.trL.removeAllViewsInLayout();
    this.trG = null;
    AppMethodBeat.o(123861);
  }
  
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(123864);
    ad.i("WxaFlutterRenderView", "onFirstFrameRendered " + this.trO);
    AppMethodBeat.o(123864);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(123858);
    com.tencent.mm.plugin.m.a.c.c localc = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.afB("onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.hi("inject_js_Start", "onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.hi("ui_create", "onForeground");
    this.trM = System.currentTimeMillis();
    ad.i("WxaFlutterRenderView", "onForeground " + this.trO);
    this.trF = false;
    AppMethodBeat.o(123858);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(123859);
    Object localObject = com.tencent.mm.plugin.m.a.c.c.tsc;
    localObject = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.afB(com.tencent.mm.plugin.m.a.c.c.cNc());
    localObject = com.tencent.mm.plugin.m.a.c.c.tsc;
    localObject = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.hi("ui_create", com.tencent.mm.plugin.m.a.c.c.cNc());
    localObject = com.tencent.mm.plugin.m.a.c.c.tsc;
    com.tencent.mm.plugin.m.a.c.c.clear();
    ad.i("WxaFlutterRenderView", "onShow " + this.trO);
    localObject = this.rdu;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fuB();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).fuW();
      }
    }
    localObject = this.trN;
    if (localObject != null) {
      aq.n((Runnable)localObject, 30L);
    }
    this.trN = null;
    AppMethodBeat.o(123859);
  }
  
  public final void setPendingAttachFlutterView(Runnable paramRunnable)
  {
    this.trN = paramRunnable;
  }
  
  public final void setWxaWebView(bd parambd)
  {
    this.trG = parambd;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123852);
      c.b(this.trQ).bringChildToFront((View)c.c(this.trQ));
      FlutterView localFlutterView = c.d(this.trQ);
      c.b(this.trQ, c.c(this.trQ));
      c.a(this.trQ, localFlutterView);
      AppMethodBeat.o(123852);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123853);
      Object localObject = c.a(this.trQ);
      if (localObject != null)
      {
        localObject = ((bd)localObject).getFullscreenImpl();
        if (localObject != null)
        {
          ((d)localObject).O((View)this.trQ, 90);
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