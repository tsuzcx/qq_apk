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
import com.tencent.mm.plugin.appbrand.aj;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.ui.al;
import d.f;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", "listener", "Lkotlin/Function0;", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class v
  extends m
{
  public static final v.a mLB;
  private p jFm;
  private final f mLA;
  
  static
  {
    AppMethodBeat.i(223900);
    mLB = new v.a((byte)0);
    AppMethodBeat.o(223900);
  }
  
  public v(final Context paramContext, final Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    AppMethodBeat.i(223899);
    this.mLA = d.g.O((d.g.a.a)new b(this));
    setPromptVisible(false);
    paramBitmap = new ad(paramContext);
    final com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(paramContext);
    locald.addView((View)paramBitmap);
    addView((View)locald, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    locald.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(223889);
        paramBitmap.setCloseButtonClickListener((View.OnClickListener)new a(this));
        paramBitmap.setMainTitle((CharSequence)paramContext.getString(2131755576));
        ad localad = paramBitmap;
        int i;
        if (al.isDarkMode())
        {
          paramAnonymousView = "white";
          localad.setForegroundStyle(paramAnonymousView);
          paramBitmap.setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100705));
          paramBitmap.setLoadingIconVisibility(true);
          paramAnonymousView = locald;
          i = paramBitmap.getBackgroundColor();
          if (al.isDarkMode()) {
            break label126;
          }
        }
        label126:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.M(i, bool);
          AppMethodBeat.o(223889);
          return;
          paramAnonymousView = "black";
          break;
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(v.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(223888);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramView = this.mLF.mLC.getRuntime();
          if (paramView != null) {
            paramView.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223888);
        }
      }
    });
    AppMethodBeat.o(223899);
  }
  
  private final v.b.1 getKeyEventInterceptor()
  {
    AppMethodBeat.i(223895);
    v.b.1 local1 = (v.b.1)this.mLA.getValue();
    AppMethodBeat.o(223895);
    return local1;
  }
  
  public static final void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(223901);
    v.a.setCanShowAlphaCover(paramBoolean);
    AppMethodBeat.o(223901);
  }
  
  public final p getRuntime()
  {
    return this.jFm;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(223898);
    super.onDetachedFromWindow();
    p localp = this.jFm;
    if (localp != null)
    {
      localp.a((aj)getKeyEventInterceptor());
      AppMethodBeat.o(223898);
      return;
    }
    AppMethodBeat.o(223898);
  }
  
  public final void setRuntime(p paramp)
  {
    AppMethodBeat.i(223896);
    this.jFm = paramp;
    if (paramp != null)
    {
      paramp.a(4, 1, (aj)getKeyEventInterceptor());
      AppMethodBeat.o(223896);
      return;
    }
    AppMethodBeat.o(223896);
  }
  
  public final void v(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223897);
    j.a((w)this);
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(223897);
      return;
    }
    AppMethodBeat.o(223897);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;"})
  static final class b
    extends q
    implements d.g.a.a<1>
  {
    b(v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.v
 * JD-Core Version:    0.7.0.1
 */