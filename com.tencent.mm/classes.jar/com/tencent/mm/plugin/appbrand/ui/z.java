package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.sdk.h.e;
import com.tencent.luggage.sdk.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.am;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.ar;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", "listener", "Lkotlin/Function0;", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class z
  extends m
{
  public static final z.a rat;
  private t nAH;
  private final kotlin.f ras;
  
  static
  {
    AppMethodBeat.i(282062);
    rat = new z.a((byte)0);
    AppMethodBeat.o(282062);
  }
  
  public z(final Context paramContext, final Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    AppMethodBeat.i(282061);
    this.ras = g.ar((kotlin.g.a.a)new b(this));
    setPromptVisible(false);
    paramBitmap = new aj(paramContext);
    final d locald = new d(paramContext);
    locald.addView((View)paramBitmap);
    addView((View)locald, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    locald.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(284629);
        paramBitmap.setCloseButtonClickListener((View.OnClickListener)new a(this));
        paramBitmap.setMainTitle((CharSequence)paramContext.getString(au.i.app_brand_plugin_splash_loading_plain_text));
        aj localaj = paramBitmap;
        int i;
        if (ar.isDarkMode())
        {
          paramAnonymousView = "white";
          localaj.setForegroundStyle(paramAnonymousView);
          paramBitmap.setBackgroundColor(androidx.core.content.a.w(paramContext, au.c.normal_actionbar_color));
          paramBitmap.setLoadingIconVisibility(true);
          paramAnonymousView = locald;
          i = paramBitmap.getBackgroundColor();
          if (ar.isDarkMode()) {
            break label128;
          }
        }
        label128:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.T(i, bool);
          AppMethodBeat.o(284629);
          return;
          paramAnonymousView = "black";
          break;
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(z.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(275225);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramView = this.rax.rau.getRuntime();
          if (paramView != null) {
            paramView.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(275225);
        }
      }
    });
    AppMethodBeat.o(282061);
  }
  
  private final z.b.1 getKeyEventInterceptor()
  {
    AppMethodBeat.i(282056);
    z.b.1 local1 = (z.b.1)this.ras.getValue();
    AppMethodBeat.o(282056);
    return local1;
  }
  
  public static final void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(282064);
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.appbrand.app.f.nCi.aal();
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", paramBoolean);
      AppMethodBeat.o(282064);
      return;
    }
    AppMethodBeat.o(282064);
  }
  
  public final t getRuntime()
  {
    return this.nAH;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(282060);
    super.onDetachedFromWindow();
    t localt = this.nAH;
    if (localt != null)
    {
      localt.a((am)getKeyEventInterceptor());
      AppMethodBeat.o(282060);
      return;
    }
    AppMethodBeat.o(282060);
  }
  
  public final void setRuntime(t paramt)
  {
    AppMethodBeat.i(282057);
    this.nAH = paramt;
    if (paramt != null)
    {
      paramt.a(4, 1, (am)getKeyEventInterceptor());
      AppMethodBeat.o(282057);
      return;
    }
    AppMethodBeat.o(282057);
  }
  
  public final void x(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(282058);
    j.a((aa)this);
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(282058);
      return;
    }
    AppMethodBeat.o(282058);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;"})
  static final class b
    extends q
    implements kotlin.g.a.a<1>
  {
    b(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.z
 * JD-Core Version:    0.7.0.1
 */