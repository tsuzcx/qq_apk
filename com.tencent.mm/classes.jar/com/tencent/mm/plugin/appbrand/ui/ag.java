package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.sdk.h.e;
import com.tencent.luggage.sdk.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimeRestartLoadingSplash;", "context", "Landroid/content/Context;", "snapshot", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "keyEventInterceptor", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1", "getKeyEventInterceptor", "()Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1;", "keyEventInterceptor$delegate", "Lkotlin/Lazy;", "value", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "runtime", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "animateHide", "", "listener", "Lkotlin/Function0;", "onDetachedFromWindow", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends p
{
  public static final ag.a ugm;
  private w qxC;
  private final j ugn;
  
  static
  {
    AppMethodBeat.i(322055);
    ugm = new ag.a((byte)0);
    AppMethodBeat.o(322055);
  }
  
  public ag(final Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    AppMethodBeat.i(322039);
    this.ugn = k.cm((kotlin.g.a.a)new b(this));
    setPromptVisible(false);
    paramBitmap = new ar(paramContext);
    final d locald = new d(paramContext);
    locald.addView((View)paramBitmap);
    addView((View)locald, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    locald.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      private static final void a(ag paramAnonymousag, View paramAnonymousView)
      {
        AppMethodBeat.i(322591);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousag);
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
        s.u(paramAnonymousag, "this$0");
        paramAnonymousag = paramAnonymousag.getRuntime();
        if (paramAnonymousag != null) {
          paramAnonymousag.finish();
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(322591);
      }
      
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(322615);
        this.ugo.setCloseButtonClickListener(new ag.1..ExternalSyntheticLambda0(jdField_this));
        this.ugo.setMainTitle((CharSequence)paramContext.getString(ba.i.app_brand_plugin_splash_loading_plain_text));
        ar localar = this.ugo;
        int i;
        if (aw.isDarkMode())
        {
          paramAnonymousView = "white";
          localar.setForegroundStyle(paramAnonymousView);
          this.ugo.setBackgroundColor(androidx.core.content.a.w(paramContext, ba.c.normal_actionbar_color));
          this.ugo.setLoadingIconVisibility(true);
          paramAnonymousView = locald;
          i = this.ugo.getBackgroundColor();
          if (aw.isDarkMode()) {
            break label128;
          }
        }
        label128:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.aj(i, bool);
          AppMethodBeat.o(322615);
          return;
          paramAnonymousView = "black";
          break;
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView) {}
    });
    AppMethodBeat.o(322039);
  }
  
  private final ag.b.1 getKeyEventInterceptor()
  {
    AppMethodBeat.i(322045);
    ag.b.1 local1 = (ag.b.1)this.ugn.getValue();
    AppMethodBeat.o(322045);
    return local1;
  }
  
  public static final void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(322051);
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", paramBoolean);
    }
    AppMethodBeat.o(322051);
  }
  
  public final void as(kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322067);
    i.a((ah)this);
    if (parama != null) {
      parama.invoke();
    }
    AppMethodBeat.o(322067);
  }
  
  public final w getRuntime()
  {
    return this.qxC;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(322071);
    super.onDetachedFromWindow();
    w localw = this.qxC;
    if (localw != null) {
      localw.a((com.tencent.mm.plugin.appbrand.ar)getKeyEventInterceptor());
    }
    AppMethodBeat.o(322071);
  }
  
  public final void setRuntime(w paramw)
  {
    AppMethodBeat.i(322063);
    this.qxC = paramw;
    if (paramw != null) {
      paramw.a(4, 1, (com.tencent.mm.plugin.appbrand.ar)getKeyEventInterceptor());
    }
    AppMethodBeat.o(322063);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$keyEventInterceptor$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<1>
  {
    b(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ag
 * JD-Core Version:    0.7.0.1
 */