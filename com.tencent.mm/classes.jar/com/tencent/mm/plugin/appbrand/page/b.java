package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$AbsNavResetStyleListener;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "hidden", "", "navStyleApplied", "getNavAreaLeftMarginResourceId", "", "isNavStyleInvisible", "onBackButtonClicked", "view", "Landroid/view/View;", "resetNavStyle", "", "navButton", "Landroid/widget/ImageView;", "navArea", "navContainer", "Companion", "luggage-wxa-app_release"})
public class b
  extends com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
{
  @Deprecated
  public static final a nnr;
  public boolean nno;
  public boolean nnp;
  private final ac nnq;
  
  static
  {
    AppMethodBeat.i(219689);
    nnr = new a((byte)0);
    AppMethodBeat.o(219689);
  }
  
  public b(ac paramac)
  {
    AppMethodBeat.i(219688);
    this.nnq = paramac;
    AppMethodBeat.o(219688);
  }
  
  public final void a(ImageView paramImageView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(219686);
    this.nnp = true;
    Object localObject;
    if (paramImageView != null)
    {
      localObject = paramImageView.getLayoutParams();
      if (localObject == null)
      {
        paramImageView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(219686);
        throw paramImageView;
      }
      localObject = (LinearLayout.LayoutParams)localObject;
      Context localContext = paramImageView.getContext();
      p.g(localContext, "navButton.context");
      i = localContext.getResources().getDimensionPixelOffset(2131165765);
      ((LinearLayout.LayoutParams)localObject).height = i;
      ((LinearLayout.LayoutParams)localObject).width = i;
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(android.support.v4.content.b.l(paramImageView.getContext(), 2131230968));
      localObject = this.nnq.bRi();
      p.g(localObject, "pageView.actionBar");
      paramImageView.setColorFilter(((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
      paramImageView.setBackgroundResource(2131230980);
      localObject = paramImageView.getContext();
      p.g(localObject, "navButton.context");
      i = ((Context)localObject).getResources().getDimensionPixelOffset(2131165586);
      paramImageView.setPadding(i, paramImageView.getPaddingTop(), i, paramImageView.getPaddingBottom());
    }
    if (paramView1 != null)
    {
      paramImageView = paramView1.getLayoutParams();
      if (paramImageView == null)
      {
        paramImageView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(219686);
        throw paramImageView;
      }
      paramImageView = (LinearLayout.LayoutParams)paramImageView;
      localObject = paramView1.getContext();
      p.g(localObject, "navArea.context");
      i = ((Context)localObject).getResources().getDimensionPixelOffset(2131165762);
      paramImageView.height = i;
      paramImageView.width = i;
      paramImageView.gravity = 17;
      localObject = paramView1.getContext();
      p.g(localObject, "navArea.context");
      paramImageView.leftMargin = ((Context)localObject).getResources().getDimensionPixelOffset(2131165763);
      localObject = paramView1.getContext();
      p.g(localObject, "navArea.context");
      paramImageView.rightMargin = ((Context)localObject).getResources().getDimensionPixelOffset(2131165764);
      paramView1.setLayoutParams((ViewGroup.LayoutParams)paramImageView);
      paramImageView = this.nnq.bRi();
      p.g(paramImageView, "pageView.actionBar");
      if (paramImageView.getForegroundColor() != -1) {
        break label405;
      }
    }
    label405:
    for (int i = 2131231007;; i = 2131231008)
    {
      paramView1.setBackgroundResource(i);
      if (paramView2 == null) {
        break;
      }
      paramView2.setOnTouchListener((View.OnTouchListener)new b.b(paramView1));
      AppMethodBeat.o(219686);
      return;
    }
    AppMethodBeat.o(219686);
  }
  
  public final int bQz()
  {
    return 2131165763;
  }
  
  public boolean cz(View paramView)
  {
    AppMethodBeat.i(219687);
    p.h(paramView, "view");
    Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button");
    paramView = this.nnq.bRi();
    p.g(paramView, "pageView.actionBar");
    if (paramView.cae()) {
      Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button, but nav area is hidden");
    }
    for (;;)
    {
      AppMethodBeat.o(219687);
      return true;
      paramView = this.nnq.getRuntime();
      p.g(paramView, "pageView.runtime");
      paramView = paramView.brh();
      if (paramView != null) {
        paramView.bQR();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */