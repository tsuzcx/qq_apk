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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.aw;
import d.f;
import d.g.a.a;
import d.g.b.w;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class t
  extends k
{
  public static final a mfW;
  private o jPl;
  private final f mfV;
  
  static
  {
    AppMethodBeat.i(187410);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(t.class), "keyEventInterceptor", "getKeyEventInterceptor()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;")) };
    mfW = new a((byte)0);
    AppMethodBeat.o(187410);
  }
  
  public t(final Context paramContext, final Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    AppMethodBeat.i(187415);
    this.mfV = d.g.K((a)new b(this));
    setPromptVisible(false);
    paramBitmap = new aa(paramContext);
    final com.tencent.mm.plugin.appbrand.widget.actionbar.d locald = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(paramContext);
    locald.addView((View)paramBitmap);
    addView((View)locald, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    locald.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(187404);
        paramBitmap.setCloseButtonClickListener((View.OnClickListener)new a(this));
        paramBitmap.setMainTitle((CharSequence)paramContext.getString(2131755576));
        aa localaa = paramBitmap;
        int i;
        if (com.tencent.mm.ui.aj.DT())
        {
          paramAnonymousView = "white";
          localaa.setForegroundStyle(paramAnonymousView);
          paramBitmap.setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131100705));
          paramBitmap.setLoadingIconVisibility(true);
          paramAnonymousView = locald;
          i = paramBitmap.getBackgroundColor();
          if (com.tencent.mm.ui.aj.DT()) {
            break label126;
          }
        }
        label126:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.L(i, bool);
          AppMethodBeat.o(187404);
          return;
          paramAnonymousView = "black";
          break;
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
      static final class a
        implements View.OnClickListener
      {
        a(t.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(187403);
          paramView = this.mga.mfX.getRuntime();
          if (paramView != null)
          {
            paramView.finish();
            AppMethodBeat.o(187403);
            return;
          }
          AppMethodBeat.o(187403);
        }
      }
    });
    AppMethodBeat.o(187415);
  }
  
  private final t.b.1 getKeyEventInterceptor()
  {
    AppMethodBeat.i(187411);
    t.b.1 local1 = (t.b.1)this.mfV.getValue();
    AppMethodBeat.o(187411);
    return local1;
  }
  
  public static final void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(187416);
    a.setCanShowAlphaCover(paramBoolean);
    AppMethodBeat.o(187416);
  }
  
  public final void boo()
  {
    AppMethodBeat.i(187413);
    h.a((u)this);
    AppMethodBeat.o(187413);
  }
  
  public final o getRuntime()
  {
    return this.jPl;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(187414);
    super.onDetachedFromWindow();
    o localo = this.jPl;
    if (localo != null)
    {
      localo.a((com.tencent.mm.plugin.appbrand.aj)getKeyEventInterceptor());
      AppMethodBeat.o(187414);
      return;
    }
    AppMethodBeat.o(187414);
  }
  
  public final void setRuntime(o paramo)
  {
    AppMethodBeat.i(187412);
    this.jPl = paramo;
    if (paramo != null)
    {
      paramo.a(4, 1, (com.tencent.mm.plugin.appbrand.aj)getKeyEventInterceptor());
      AppMethodBeat.o(187412);
      return;
    }
    AppMethodBeat.o(187412);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$Companion;", "", "()V", "KEY", "", "setCanShowAlphaCover", "", "can", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void setCanShowAlphaCover(boolean paramBoolean)
    {
      AppMethodBeat.i(187405);
      Object localObject = com.tencent.mm.plugin.appbrand.app.d.jjJ;
      localObject = com.tencent.mm.plugin.appbrand.app.d.JW();
      if (localObject != null)
      {
        ((aw)localObject).putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", paramBoolean);
        AppMethodBeat.o(187405);
        return;
      }
      AppMethodBeat.o(187405);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;"})
  static final class b
    extends d.g.b.l
    implements a<1>
  {
    b(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.t
 * JD-Core Version:    0.7.0.1
 */