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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.ui.al;
import d.f;
import d.g.b.q;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", "listener", "Lkotlin/Function0;", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class u
  extends l
{
  public static final u.a mGx;
  private o jCo;
  private final f mGw;
  
  static
  {
    AppMethodBeat.i(189628);
    mGx = new u.a((byte)0);
    AppMethodBeat.o(189628);
  }
  
  public u(final Context paramContext, final Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    AppMethodBeat.i(189627);
    this.mGw = d.g.O((d.g.a.a)new b(this));
    setPromptVisible(false);
    paramBitmap = new ac(paramContext);
    final com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(paramContext);
    locald.addView((View)paramBitmap);
    addView((View)locald, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    locald.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(189617);
        paramBitmap.setCloseButtonClickListener((View.OnClickListener)new a(this));
        paramBitmap.setMainTitle((CharSequence)paramContext.getString(2131755576));
        ac localac = paramBitmap;
        int i;
        if (al.isDarkMode())
        {
          paramAnonymousView = "white";
          localac.setForegroundStyle(paramAnonymousView);
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
          paramAnonymousView.L(i, bool);
          AppMethodBeat.o(189617);
          return;
          paramAnonymousView = "black";
          break;
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      
      @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(u.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(189616);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramView = this.mGB.mGy.getRuntime();
          if (paramView != null) {
            paramView.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1$onViewAttachedToWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189616);
        }
      }
    });
    AppMethodBeat.o(189627);
  }
  
  private final u.b.1 getKeyEventInterceptor()
  {
    AppMethodBeat.i(189623);
    u.b.1 local1 = (u.b.1)this.mGw.getValue();
    AppMethodBeat.o(189623);
    return local1;
  }
  
  public static final void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(189629);
    u.a.setCanShowAlphaCover(paramBoolean);
    AppMethodBeat.o(189629);
  }
  
  public final o getRuntime()
  {
    return this.jCo;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(189626);
    super.onDetachedFromWindow();
    o localo = this.jCo;
    if (localo != null)
    {
      localo.a((aj)getKeyEventInterceptor());
      AppMethodBeat.o(189626);
      return;
    }
    AppMethodBeat.o(189626);
  }
  
  public final void setRuntime(o paramo)
  {
    AppMethodBeat.i(189624);
    this.jCo = paramo;
    if (paramo != null)
    {
      paramo.a(4, 1, (aj)getKeyEventInterceptor());
      AppMethodBeat.o(189624);
      return;
    }
    AppMethodBeat.o(189624);
  }
  
  public final void u(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(189625);
    i.a((v)this);
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(189625);
      return;
    }
    AppMethodBeat.o(189625);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;"})
  static final class b
    extends q
    implements d.g.a.a<1>
  {
    b(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u
 * JD-Core Version:    0.7.0.1
 */