package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.d.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandFixSizeWebView;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "verticalLimitlessLayout", "Lcom/tencent/mm/plugin/appbrand/page/view/AppBrandWebViewFixedSizeWrapper;", "getWrapperView", "Landroid/view/View;", "resetContext", "", "setFixSizeEnable", "enable", "", "plugin-appbrand-integration_release"})
public final class j
  extends an
{
  private final a qpv;
  
  public j(Context paramContext)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(272516);
    this.qpv = new a((Context)new MutableContextWrapper(paramContext));
    setFixSizeEnable(false);
    AppMethodBeat.o(272516);
  }
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(272515);
    p.k(paramContext, "context");
    super.aD(paramContext);
    Context localContext = this.qpv.getContext();
    if (localContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.content.MutableContextWrapper");
      AppMethodBeat.o(272515);
      throw paramContext;
    }
    ((MutableContextWrapper)localContext).setBaseContext(paramContext);
    AppMethodBeat.o(272515);
  }
  
  public final View getWrapperView()
  {
    AppMethodBeat.i(272513);
    View localView = super.getWrapperView();
    if (this.qpv.getChildAt(0) != localView)
    {
      this.qpv.removeAllViews();
      this.qpv.addView(localView);
      this.qpv.setLayoutParams((ViewGroup.LayoutParams)new SlidingPaneLayout.LayoutParams((byte)0));
    }
    localView = (View)this.qpv;
    AppMethodBeat.o(272513);
    return localView;
  }
  
  public final void setFixSizeEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(272514);
    if (supportSetWebContentsSize()) {
      this.qpv.setEnableFixSize(paramBoolean);
    }
    AppMethodBeat.o(272514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */