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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/WxaFlutterRenderView;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/IWxaRenderView;", "Landroid/widget/FrameLayout;", "Lio/flutter/embedding/engine/renderer/FlutterUiDisplayListener;", "context", "Landroid/content/Context;", "viewId", "", "engineProvider", "Lcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;", "(Landroid/content/Context;JLcom/tencent/mm/plugin/luggage/natives/flutter/IFlutterEngineProvider;)V", "appBrandWebView", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "background", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "flutterViewAttached", "flutterViewContainer", "flutterViewForeground", "Lio/flutter/embedding/android/FlutterView;", "flutterViewIdle", "inStack", "onForegroundTime", "pendingAttachFlutterView", "Ljava/lang/Runnable;", "getPendingAttachFlutterView", "()Ljava/lang/Runnable;", "setPendingAttachFlutterView", "(Ljava/lang/Runnable;)V", "addLabel", "", "addLayoutChangeListener", "listener", "Landroid/view/View$OnLayoutChangeListener;", "attachFlutterView", "lastForegroundView", "detachFlutterView", "enterFullScreen", "exitFullScreen", "getView", "Landroid/view/View;", "getViewId", "onBackground", "onDestroy", "onFlutterUiDisplayed", "onFlutterUiNoLongerDisplayed", "onForeground", "onShow", "onStackPop", "onStackPush", "removeLayoutChangeListener", "setWxaWebView", "view", "Companion", "luggage-native-view_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends FrameLayout
  implements a, io.flutter.embedding.engine.b.b
{
  public static final a uAi;
  private final long rEi;
  private io.flutter.embedding.engine.a slN;
  private ay uAa;
  private boolean uAb;
  private boolean uAc;
  private FlutterView uAd;
  private FlutterView uAe;
  private FrameLayout uAf;
  private long uAg;
  private Runnable uAh;
  private final com.tencent.mm.plugin.m.a.a.b uzX;
  private boolean uzZ;
  
  static
  {
    AppMethodBeat.i(123868);
    uAi = new a((byte)0);
    AppMethodBeat.o(123868);
  }
  
  public c(Context paramContext, long paramLong, com.tencent.mm.plugin.m.a.a.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(123867);
    this.rEi = paramLong;
    this.uzX = paramb;
    this.uzZ = true;
    this.uAd = new FlutterView(paramContext, FlutterView.b.KLe);
    this.uAe = new FlutterView(paramContext, FlutterView.b.KLe);
    setBackgroundColor(-1);
    this.uAd.setBackgroundColor(-1);
    this.uAe.setBackgroundColor(-1);
    this.uAe.a((io.flutter.embedding.engine.b.b)this);
    this.uAd.a((io.flutter.embedding.engine.b.b)this);
    if ((bt.eWm()) || (h.IS_FLAVOR_RED))
    {
      this.uAf = new FrameLayout(getContext());
      addView((View)this.uAf, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
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
      this.uAf.addView((View)this.uAd, new ViewGroup.LayoutParams(-1, -1));
      this.uAf.addView((View)this.uAe, new ViewGroup.LayoutParams(-1, -1));
      AppMethodBeat.o(123867);
      return;
      this.uAf = ((FrameLayout)this);
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
  
  public final void b(a parama)
  {
    AppMethodBeat.i(123860);
    if (this.uAb)
    {
      AppMethodBeat.o(123860);
      return;
    }
    io.flutter.embedding.engine.a locala = this.uzX.fE(getContext());
    ac.i("WxaFlutterRenderView", "attachFlutterView " + this.rEi);
    if (parama != null) {
      parama.daG();
    }
    if (parama != null)
    {
      this.uAd.c(locala);
      k.g(locala, "flutterEngine");
      locala.fNb().fNz();
      this.slN = locala;
      this.uAh = ((Runnable)new b(this));
    }
    for (;;)
    {
      this.uAe.requestFocus();
      this.uAb = true;
      AppMethodBeat.o(123860);
      return;
      this.uAe.c(locala);
      k.g(locala, "flutterEngine");
      locala.fNb().fNz();
      this.slN = locala;
    }
  }
  
  public final void bjx()
  {
    AppMethodBeat.i(123854);
    ap.f((Runnable)new c(this));
    AppMethodBeat.o(123854);
  }
  
  public final void cHX()
  {
    AppMethodBeat.i(205636);
    ac.i("WxaFlutterRenderView", "onFirstFrameRendered " + this.rEi);
    AppMethodBeat.o(205636);
  }
  
  public final void cHY()
  {
    AppMethodBeat.i(205637);
    ac.i("WxaFlutterRenderView", "onFlutterUiNoLongerDisplayed " + this.rEi);
    AppMethodBeat.o(205637);
  }
  
  public final void cWw()
  {
    AppMethodBeat.i(123855);
    Object localObject = this.uAa;
    if (localObject != null)
    {
      localObject = ((ay)localObject).getFullscreenImpl();
      if (localObject != null)
      {
        ((d)localObject).aUJ();
        AppMethodBeat.o(123855);
        return;
      }
    }
    AppMethodBeat.o(123855);
  }
  
  public final void daG()
  {
    AppMethodBeat.i(123857);
    if (!this.uAb)
    {
      AppMethodBeat.o(123857);
      return;
    }
    ac.i("WxaFlutterRenderView", "detachFlutterView " + this.rEi);
    this.uzZ = true;
    this.uAe.fMX();
    this.uAb = false;
    Object localObject = this.slN;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fNb();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).fNB();
      }
    }
    this.slN = null;
    AppMethodBeat.o(123857);
  }
  
  public final void daH()
  {
    AppMethodBeat.i(123863);
    this.uAc = false;
    ac.i("WxaFlutterRenderView", "onStackPop " + this.rEi);
    AppMethodBeat.o(123863);
  }
  
  public final void daI()
  {
    AppMethodBeat.i(123862);
    this.uAc = true;
    ac.i("WxaFlutterRenderView", "onStackPush " + this.rEi);
    AppMethodBeat.o(123862);
  }
  
  public final Runnable getPendingAttachFlutterView()
  {
    return this.uAh;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final long getViewId()
  {
    return this.rEi;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(123856);
    ac.i("WxaFlutterRenderView", "onBackground " + this.rEi);
    Object localObject = this.slN;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fNb();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).fNB();
      }
    }
    localObject = this.slN;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fNb();
      if (localObject != null)
      {
        ((io.flutter.embedding.engine.c.c)localObject).fNz();
        AppMethodBeat.o(123856);
        return;
      }
    }
    AppMethodBeat.o(123856);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123861);
    ac.i("WxaFlutterRenderView", "onDestroy " + this.rEi);
    removeAllViewsInLayout();
    this.uAe.removeAllViewsInLayout();
    this.uAd.removeAllViewsInLayout();
    this.uAf.removeAllViewsInLayout();
    this.uAa = null;
    AppMethodBeat.o(123861);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(123858);
    com.tencent.mm.plugin.m.a.c.c localc = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.akv("onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.hB("inject_js_Start", "onForeground");
    localc = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.hB("ui_create", "onForeground");
    this.uAg = System.currentTimeMillis();
    ac.i("WxaFlutterRenderView", "onForeground " + this.rEi);
    this.uzZ = false;
    AppMethodBeat.o(123858);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(123859);
    Object localObject = com.tencent.mm.plugin.m.a.c.c.uAv;
    localObject = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.akv(com.tencent.mm.plugin.m.a.c.c.daJ());
    localObject = com.tencent.mm.plugin.m.a.c.c.uAv;
    localObject = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.hB("ui_create", com.tencent.mm.plugin.m.a.c.c.daJ());
    localObject = com.tencent.mm.plugin.m.a.c.c.uAv;
    com.tencent.mm.plugin.m.a.c.c.clear();
    ac.i("WxaFlutterRenderView", "onShow " + this.rEi);
    localObject = this.slN;
    if (localObject != null)
    {
      localObject = ((io.flutter.embedding.engine.a)localObject).fNb();
      if (localObject != null) {
        ((io.flutter.embedding.engine.c.c)localObject).fNA();
      }
    }
    localObject = this.uAh;
    if (localObject != null) {
      ap.n((Runnable)localObject, 30L);
    }
    this.uAh = null;
    AppMethodBeat.o(123859);
  }
  
  public final void setPendingAttachFlutterView(Runnable paramRunnable)
  {
    this.uAh = paramRunnable;
  }
  
  public final void setWxaWebView(ay paramay)
  {
    this.uAa = paramay;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/WxaFlutterRenderView$Companion;", "", "()V", "TAG", "", "luggage-native-view_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123852);
      c.b(this.uAj).bringChildToFront((View)c.c(this.uAj));
      FlutterView localFlutterView = c.d(this.uAj);
      c.b(this.uAj, c.c(this.uAj));
      c.a(this.uAj, localFlutterView);
      AppMethodBeat.o(123852);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(123853);
      Object localObject = c.a(this.uAj);
      if (localObject != null)
      {
        localObject = ((ay)localObject).getFullscreenImpl();
        if (localObject != null)
        {
          ((d)localObject).O((View)this.uAj, 90);
          AppMethodBeat.o(123853);
          return;
        }
      }
      AppMethodBeat.o(123853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */