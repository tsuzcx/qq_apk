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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.ao;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", "listener", "Lkotlin/Function0;", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class aa
  extends o
{
  public static final a nYJ;
  private com.tencent.mm.plugin.appbrand.q kGW;
  private final kotlin.f nYI;
  
  static
  {
    AppMethodBeat.i(229552);
    nYJ = new a((byte)0);
    AppMethodBeat.o(229552);
  }
  
  public aa(final Context paramContext, final Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    AppMethodBeat.i(229551);
    this.nYI = kotlin.g.ah((kotlin.g.a.a)new b(this));
    setPromptVisible(false);
    paramBitmap = new aj(paramContext);
    final com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(paramContext);
    locald.addView((View)paramBitmap);
    addView((View)locald, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    locald.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(229542);
        paramBitmap.setCloseButtonClickListener((View.OnClickListener)new a(this));
        paramBitmap.setMainTitle((CharSequence)paramContext.getString(2131755619));
        aj localaj = paramBitmap;
        int i;
        if (ao.isDarkMode())
        {
          paramAnonymousView = "white";
          localaj.setForegroundStyle(paramAnonymousView);
          paramBitmap.setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100898));
          paramBitmap.setLoadingIconVisibility(true);
          paramAnonymousView = locald;
          i = paramBitmap.getBackgroundColor();
          if (ao.isDarkMode()) {
            break label126;
          }
        }
        label126:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.S(i, bool);
          AppMethodBeat.o(229542);
          return;
          paramAnonymousView = "black";
          break;
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      
      @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(aa.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(229541);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramView = this.nYN.nYK.getRuntime();
          if (paramView != null) {
            paramView.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(229541);
        }
      }
    });
    AppMethodBeat.o(229551);
  }
  
  private final aa.b.1 getKeyEventInterceptor()
  {
    AppMethodBeat.i(229547);
    aa.b.1 local1 = (aa.b.1)this.nYI.getValue();
    AppMethodBeat.o(229547);
    return local1;
  }
  
  public static final void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(229553);
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", paramBoolean);
      AppMethodBeat.o(229553);
      return;
    }
    AppMethodBeat.o(229553);
  }
  
  public final com.tencent.mm.plugin.appbrand.q getRuntime()
  {
    return this.kGW;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(229550);
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.appbrand.q localq = this.kGW;
    if (localq != null)
    {
      localq.a((al)getKeyEventInterceptor());
      AppMethodBeat.o(229550);
      return;
    }
    AppMethodBeat.o(229550);
  }
  
  public final void setRuntime(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(229548);
    this.kGW = paramq;
    if (paramq != null)
    {
      paramq.a(4, 1, (al)getKeyEventInterceptor());
      AppMethodBeat.o(229548);
      return;
    }
    AppMethodBeat.o(229548);
  }
  
  public final void z(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(229549);
    l.a((ab)this);
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(229549);
      return;
    }
    AppMethodBeat.o(229549);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$Companion;", "", "()V", "KEY", "", "setCanShowAlphaCover", "", "can", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<1>
  {
    b(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aa
 * JD-Core Version:    0.7.0.1
 */