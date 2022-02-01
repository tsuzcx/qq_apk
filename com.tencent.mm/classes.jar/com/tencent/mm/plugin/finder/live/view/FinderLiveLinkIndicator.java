package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curIndex", "indicator", "Landroid/view/View;", "longTabWidth", "shortTabWidth", "tab1Group", "tab1RedDot", "tab1Tv", "Landroid/widget/TextView;", "tab2Group", "tab2RedDot", "tab2Tv", "tabOnclickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getTabOnclickListener", "()Lkotlin/jvm/functions/Function1;", "setTabOnclickListener", "(Lkotlin/jvm/functions/Function1;)V", "hideRedDotTip", "onDisplay", "onHide", "onScrollStateChanged", "newState", "onScrolling", "dx", "dy", "showRedDotTip", "plugin-finder_release"})
public final class FinderLiveLinkIndicator
  extends FrameLayout
{
  private final View uyM;
  private final TextView uyN;
  private final View uyO;
  private final TextView uyP;
  private final View uyQ;
  private final View uyR;
  private final View uyS;
  private kotlin.g.a.b<? super Integer, x> uyT;
  
  public FinderLiveLinkIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(247474);
    AppMethodBeat.o(247474);
  }
  
  public FinderLiveLinkIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247473);
    View.inflate(paramContext, 2131494414, (ViewGroup)this);
    paramContext = findViewById(2131301073);
    p.g(paramContext, "findViewById(R.id.finder_live_link_indicator)");
    this.uyM = paramContext;
    paramContext = findViewById(2131301133);
    p.g(paramContext, "findViewById(R.id.finder_live_link_tab1_tv)");
    this.uyN = ((TextView)paramContext);
    paramContext = findViewById(2131301132);
    p.g(paramContext, "findViewById(R.id.finder_live_link_tab1_red_dot)");
    this.uyO = paramContext;
    paramContext = findViewById(2131301135);
    p.g(paramContext, "findViewById(R.id.finder_live_link_tab2_tv)");
    this.uyP = ((TextView)paramContext);
    paramContext = findViewById(2131301134);
    p.g(paramContext, "findViewById(R.id.finder_live_link_tab2_red_dot)");
    this.uyQ = paramContext;
    paramContext = findViewById(2131301074);
    p.g(paramContext, "findViewById(R.id.finder…ink_indicator_tab1_group)");
    this.uyR = paramContext;
    paramContext = findViewById(2131301075);
    p.g(paramContext, "findViewById(R.id.finder…ink_indicator_tab2_group)");
    this.uyS = paramContext;
    this.uyM.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247470);
        FinderLiveLinkIndicator.b(this.uyU).getLayoutParams().width = FinderLiveLinkIndicator.a(this.uyU).getMeasuredWidth();
        FinderLiveLinkIndicator.b(this.uyU).requestLayout();
        AppMethodBeat.o(247470);
      }
    });
    this.uyR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247471);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.uyU.getTabOnclickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247471);
      }
    });
    this.uyS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247472);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.uyU.getTabOnclickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247472);
      }
    });
    AppMethodBeat.o(247473);
  }
  
  public final kotlin.g.a.b<Integer, x> getTabOnclickListener()
  {
    return this.uyT;
  }
  
  public final void setTabOnclickListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.uyT = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLinkIndicator
 * JD-Core Version:    0.7.0.1
 */