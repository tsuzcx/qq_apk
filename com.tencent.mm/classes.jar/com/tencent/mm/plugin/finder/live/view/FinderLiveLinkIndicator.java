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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curIndex", "indicator", "Landroid/view/View;", "longTabWidth", "shortTabWidth", "tab1Group", "tab1RedDot", "tab1Tv", "Landroid/widget/TextView;", "tab2Group", "tab2RedDot", "tab2Tv", "tabOnclickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getTabOnclickListener", "()Lkotlin/jvm/functions/Function1;", "setTabOnclickListener", "(Lkotlin/jvm/functions/Function1;)V", "hideRedDotTip", "onDisplay", "onHide", "onScrollStateChanged", "newState", "onScrolling", "dx", "dy", "showRedDotTip", "plugin-finder_release"})
public final class FinderLiveLinkIndicator
  extends FrameLayout
{
  private final View yUF;
  private final TextView yUG;
  private final View yUH;
  private final TextView yUI;
  private final View yUJ;
  private final View yUK;
  private final View yUL;
  private kotlin.g.a.b<? super Integer, x> yUM;
  
  public FinderLiveLinkIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281514);
    AppMethodBeat.o(281514);
  }
  
  public FinderLiveLinkIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281513);
    View.inflate(paramContext, b.g.finder_live_link_indicator_layout, (ViewGroup)this);
    paramContext = findViewById(b.f.finder_live_link_indicator);
    p.j(paramContext, "findViewById(R.id.finder_live_link_indicator)");
    this.yUF = paramContext;
    paramContext = findViewById(b.f.finder_live_link_tab1_tv);
    p.j(paramContext, "findViewById(R.id.finder_live_link_tab1_tv)");
    this.yUG = ((TextView)paramContext);
    paramContext = findViewById(b.f.finder_live_link_tab1_red_dot);
    p.j(paramContext, "findViewById(R.id.finder_live_link_tab1_red_dot)");
    this.yUH = paramContext;
    paramContext = findViewById(b.f.finder_live_link_tab2_tv);
    p.j(paramContext, "findViewById(R.id.finder_live_link_tab2_tv)");
    this.yUI = ((TextView)paramContext);
    paramContext = findViewById(b.f.finder_live_link_tab2_red_dot);
    p.j(paramContext, "findViewById(R.id.finder_live_link_tab2_red_dot)");
    this.yUJ = paramContext;
    paramContext = findViewById(b.f.finder_live_link_indicator_tab1_group);
    p.j(paramContext, "findViewById(R.id.finder…ink_indicator_tab1_group)");
    this.yUK = paramContext;
    paramContext = findViewById(b.f.finder_live_link_indicator_tab2_group);
    p.j(paramContext, "findViewById(R.id.finder…ink_indicator_tab2_group)");
    this.yUL = paramContext;
    this.yUF.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222915);
        FinderLiveLinkIndicator.b(this.yUN).getLayoutParams().width = FinderLiveLinkIndicator.a(this.yUN).getMeasuredWidth();
        FinderLiveLinkIndicator.b(this.yUN).requestLayout();
        AppMethodBeat.o(222915);
      }
    });
    this.yUK.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264113);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.yUN.getTabOnclickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(0));
        }
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264113);
      }
    });
    this.yUL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(273001);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.yUN.getTabOnclickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Integer.valueOf(1));
        }
        a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(273001);
      }
    });
    AppMethodBeat.o(281513);
  }
  
  public final kotlin.g.a.b<Integer, x> getTabOnclickListener()
  {
    return this.yUM;
  }
  
  public final void setTabOnclickListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.yUM = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLinkIndicator
 * JD-Core Version:    0.7.0.1
 */