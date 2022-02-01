package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curIndex", "indicator", "Landroid/view/View;", "longTabWidth", "shortTabWidth", "tab1Group", "tab1RedDot", "tab1Tv", "Landroid/widget/TextView;", "tab2Group", "tab2RedDot", "tab2Tv", "tabOnclickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getTabOnclickListener", "()Lkotlin/jvm/functions/Function1;", "setTabOnclickListener", "(Lkotlin/jvm/functions/Function1;)V", "hideRedDotTip", "onDisplay", "onHide", "onScrollStateChanged", "newState", "onScrolling", "dx", "dy", "showRedDotTip", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLinkIndicator
  extends FrameLayout
{
  private final View DNY;
  private final TextView DNZ;
  private final View DOa;
  private final TextView DOb;
  private final View DOc;
  private final View DOd;
  private final View DOe;
  private kotlin.g.a.b<? super Integer, ah> DOf;
  
  public FinderLiveLinkIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(358171);
    AppMethodBeat.o(358171);
  }
  
  public FinderLiveLinkIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358168);
    View.inflate(paramContext, p.f.Ceo, (ViewGroup)this);
    paramContext = findViewById(p.e.BMR);
    s.s(paramContext, "findViewById(R.id.finder_live_link_indicator)");
    this.DNY = paramContext;
    paramContext = findViewById(p.e.BNi);
    s.s(paramContext, "findViewById(R.id.finder_live_link_tab1_tv)");
    this.DNZ = ((TextView)paramContext);
    paramContext = findViewById(p.e.BNh);
    s.s(paramContext, "findViewById(R.id.finder_live_link_tab1_red_dot)");
    this.DOa = paramContext;
    paramContext = findViewById(p.e.BNk);
    s.s(paramContext, "findViewById(R.id.finder_live_link_tab2_tv)");
    this.DOb = ((TextView)paramContext);
    paramContext = findViewById(p.e.BNj);
    s.s(paramContext, "findViewById(R.id.finder_live_link_tab2_red_dot)");
    this.DOc = paramContext;
    paramContext = findViewById(p.e.BMS);
    s.s(paramContext, "findViewById(R.id.finder…ink_indicator_tab1_group)");
    this.DOd = paramContext;
    paramContext = findViewById(p.e.BMT);
    s.s(paramContext, "findViewById(R.id.finder…ink_indicator_tab2_group)");
    this.DOe = paramContext;
    this.DNY.post(new FinderLiveLinkIndicator..ExternalSyntheticLambda2(this));
    this.DOd.setOnClickListener(new FinderLiveLinkIndicator..ExternalSyntheticLambda1(this));
    this.DOe.setOnClickListener(new FinderLiveLinkIndicator..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(358168);
  }
  
  private static final void a(FinderLiveLinkIndicator paramFinderLiveLinkIndicator)
  {
    AppMethodBeat.i(358176);
    s.u(paramFinderLiveLinkIndicator, "this$0");
    paramFinderLiveLinkIndicator.DNY.getLayoutParams().width = paramFinderLiveLinkIndicator.DNZ.getMeasuredWidth();
    paramFinderLiveLinkIndicator.DNY.requestLayout();
    AppMethodBeat.o(358176);
  }
  
  private static final void a(FinderLiveLinkIndicator paramFinderLiveLinkIndicator, View paramView)
  {
    AppMethodBeat.i(358185);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveLinkIndicator);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveLinkIndicator, "this$0");
    paramFinderLiveLinkIndicator = paramFinderLiveLinkIndicator.getTabOnclickListener();
    if (paramFinderLiveLinkIndicator != null) {
      paramFinderLiveLinkIndicator.invoke(Integer.valueOf(0));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358185);
  }
  
  private static final void b(FinderLiveLinkIndicator paramFinderLiveLinkIndicator, View paramView)
  {
    AppMethodBeat.i(358191);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveLinkIndicator);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveLinkIndicator, "this$0");
    paramFinderLiveLinkIndicator = paramFinderLiveLinkIndicator.getTabOnclickListener();
    if (paramFinderLiveLinkIndicator != null) {
      paramFinderLiveLinkIndicator.invoke(Integer.valueOf(1));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358191);
  }
  
  public final kotlin.g.a.b<Integer, ah> getTabOnclickListener()
  {
    return this.DOf;
  }
  
  public final void setTabOnclickListener(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.DOf = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLinkIndicator
 * JD-Core Version:    0.7.0.1
 */