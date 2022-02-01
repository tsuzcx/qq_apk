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
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.ai;
import d.f;
import d.g.a.a;
import d.g.b.w;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class u
  extends k
{
  public static final a lEc;
  private o joZ;
  private final f lEb;
  
  static
  {
    AppMethodBeat.i(196449);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(u.class), "keyEventInterceptor", "getKeyEventInterceptor()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;")) };
    lEc = new a((byte)0);
    AppMethodBeat.o(196449);
  }
  
  public u(final Context paramContext, final Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    AppMethodBeat.i(196454);
    this.lEb = d.g.E((a)new b(this));
    setPromptVisible(false);
    paramBitmap = new ab(paramContext);
    final com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(paramContext);
    locald.addView((View)paramBitmap);
    addView((View)locald, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    locald.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(196443);
        paramBitmap.setCloseButtonClickListener((View.OnClickListener)new a(this));
        paramBitmap.setMainTitle((CharSequence)paramContext.getString(2131755576));
        ab localab = paramBitmap;
        int i;
        if (ai.Eq())
        {
          paramAnonymousView = "white";
          localab.setForegroundStyle(paramAnonymousView);
          paramBitmap.setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100705));
          paramBitmap.setLoadingIconVisibility(true);
          paramAnonymousView = locald;
          i = paramBitmap.getBackgroundColor();
          if (ai.Eq()) {
            break label126;
          }
        }
        label126:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.L(i, bool);
          AppMethodBeat.o(196443);
          return;
          paramAnonymousView = "black";
          break;
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(u.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(196442);
          paramView = this.lEg.lEd.getRuntime();
          if (paramView != null)
          {
            paramView.finish();
            AppMethodBeat.o(196442);
            return;
          }
          AppMethodBeat.o(196442);
        }
      }
    });
    AppMethodBeat.o(196454);
  }
  
  private final u.b.1 getKeyEventInterceptor()
  {
    AppMethodBeat.i(196450);
    u.b.1 local1 = (u.b.1)this.lEb.getValue();
    AppMethodBeat.o(196450);
    return local1;
  }
  
  public static final void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(196455);
    a.setCanShowAlphaCover(paramBoolean);
    AppMethodBeat.o(196455);
  }
  
  public final void bhu()
  {
    AppMethodBeat.i(196452);
    h.a((v)this);
    AppMethodBeat.o(196452);
  }
  
  public final o getRuntime()
  {
    return this.joZ;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(196453);
    super.onDetachedFromWindow();
    o localo = this.joZ;
    if (localo != null)
    {
      localo.a((aj)getKeyEventInterceptor());
      AppMethodBeat.o(196453);
      return;
    }
    AppMethodBeat.o(196453);
  }
  
  public final void setRuntime(o paramo)
  {
    AppMethodBeat.i(196451);
    this.joZ = paramo;
    if (paramo != null)
    {
      paramo.a(4, 1, (aj)getKeyEventInterceptor());
      AppMethodBeat.o(196451);
      return;
    }
    AppMethodBeat.o(196451);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$Companion;", "", "()V", "KEY", "", "setCanShowAlphaCover", "", "can", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void setCanShowAlphaCover(boolean paramBoolean)
    {
      AppMethodBeat.i(196444);
      Object localObject = com.tencent.mm.plugin.appbrand.app.d.iJD;
      localObject = com.tencent.mm.plugin.appbrand.app.d.Km();
      if (localObject != null)
      {
        ((ax)localObject).putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", paramBoolean);
        AppMethodBeat.o(196444);
        return;
      }
      AppMethodBeat.o(196444);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;"})
  static final class b
    extends d.g.b.l
    implements a<1>
  {
    b(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u
 * JD-Core Version:    0.7.0.1
 */