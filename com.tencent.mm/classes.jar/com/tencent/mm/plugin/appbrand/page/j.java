package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.d.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandFixSizeWebView;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "verticalLimitlessLayout", "Lcom/tencent/mm/plugin/appbrand/page/view/AppBrandWebViewFixedSizeWrapper;", "getWrapperView", "Landroid/view/View;", "resetContext", "", "setFixSizeEnable", "enable", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends an
{
  private final a ttW;
  
  public j(Context paramContext)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(324891);
    this.ttW = new a((Context)new MutableContextWrapper(paramContext));
    setFixSizeEnable(false);
    AppMethodBeat.o(324891);
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(324899);
    s.u(paramContext, "context");
    super.bm(paramContext);
    Context localContext = this.ttW.getContext();
    if (localContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.content.MutableContextWrapper");
      AppMethodBeat.o(324899);
      throw paramContext;
    }
    ((MutableContextWrapper)localContext).setBaseContext(paramContext);
    AppMethodBeat.o(324899);
  }
  
  public final View getWrapperView()
  {
    AppMethodBeat.i(324893);
    View localView = super.getWrapperView();
    if (this.ttW.getChildAt(0) != localView)
    {
      this.ttW.removeAllViews();
      this.ttW.addView(localView);
      this.ttW.setLayoutParams((ViewGroup.LayoutParams)new SlidingPaneLayout.LayoutParams((byte)0));
    }
    localView = (View)this.ttW;
    AppMethodBeat.o(324893);
    return localView;
  }
  
  public final void setFixSizeEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(324897);
    if (supportSetWebContentsSize()) {
      this.ttW.setEnableFixSize(paramBoolean);
    }
    AppMethodBeat.o(324897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */