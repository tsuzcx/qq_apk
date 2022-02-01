package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "flag", "getFlag", "()I", "setFlag", "(I)V", "onFlagChangedListener", "Lkotlin/Function1;", "", "getOnFlagChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFlagChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "tipTv", "Landroid/widget/TextView;", "getTipTv", "()Landroid/widget/TextView;", "setTipTv", "(Landroid/widget/TextView;)V", "refreshView", "setOriginalFlag", "original", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderChooseOriginalView
  extends LinearLayout
{
  private kotlin.g.a.b<? super Integer, ah> Gxq;
  private final String TAG;
  private int eQp;
  private TextView pls;
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344062);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.eQp = 1;
    setOrientation(1);
    af.mU(getContext()).inflate(e.f.finder_choose_original_view, (ViewGroup)this, true);
    paramContext = findViewById(e.e.original_tip_tv);
    s.s(paramContext, "findViewById(R.id.original_tip_tv)");
    this.pls = ((TextView)paramContext);
    setOnClickListener(new FinderChooseOriginalView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(344062);
  }
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344073);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.eQp = 1;
    setOrientation(1);
    af.mU(getContext()).inflate(e.f.finder_choose_original_view, (ViewGroup)this, true);
    paramContext = findViewById(e.e.original_tip_tv);
    s.s(paramContext, "findViewById(R.id.original_tip_tv)");
    this.pls = ((TextView)paramContext);
    setOnClickListener(new FinderChooseOriginalView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(344073);
  }
  
  private static final void a(FinderChooseOriginalView paramFinderChooseOriginalView, View paramView)
  {
    AppMethodBeat.i(344123);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderChooseOriginalView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderChooseOriginalView, "this$0");
    paramView = new d(paramFinderChooseOriginalView.getContext());
    paramView.UD(e.f.finder_original_type_bottom_sheet);
    aw.a((Paint)((TextView)paramView.rootView.findViewById(e.e.original_type_title)).getPaint(), 0.8F);
    localObject1 = paramView.rootView.findViewById(e.e.original_type_yes_iv);
    localObject2 = paramView.rootView.findViewById(e.e.original_type_no_iv);
    if (paramFinderChooseOriginalView.getFlag() == 1)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(8);
      localObject1 = ac.Ghd;
      int i = ac.feZ();
      ((TextView)paramView.rootView.findViewById(e.e.no_original_desc_tv)).setText((CharSequence)paramFinderChooseOriginalView.getContext().getString(e.h.finder_original_type_no_desc, new Object[] { String.valueOf(i) }));
      if (i <= 0) {
        break label305;
      }
      paramView.rootView.findViewById(e.e.original_no_layout).setOnClickListener(new FinderChooseOriginalView..ExternalSyntheticLambda3(paramFinderChooseOriginalView, paramView));
    }
    for (;;)
    {
      paramView.rootView.findViewById(e.e.original_yes_layout).setOnClickListener(new FinderChooseOriginalView..ExternalSyntheticLambda1(paramFinderChooseOriginalView, paramView));
      paramView.rootView.findViewById(e.e.original_type_help).setOnClickListener(new FinderChooseOriginalView..ExternalSyntheticLambda2(paramFinderChooseOriginalView, paramView));
      paramView.dDn();
      a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344123);
      return;
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(0);
      break;
      label305:
      paramView.rootView.findViewById(e.e.original_no_layout).setClickable(false);
      ((TextView)paramView.rootView.findViewById(e.e.no_original_title_tv)).setTextColor(paramFinderChooseOriginalView.getContext().getResources().getColor(e.b.BW_70));
    }
  }
  
  private static final void a(FinderChooseOriginalView paramFinderChooseOriginalView, d paramd, View paramView)
  {
    AppMethodBeat.i(344079);
    s.u(paramFinderChooseOriginalView, "this$0");
    s.u(paramd, "$this_apply");
    paramFinderChooseOriginalView.setOriginalFlag(2);
    paramd.cyW();
    AppMethodBeat.o(344079);
  }
  
  private static final void b(FinderChooseOriginalView paramFinderChooseOriginalView, d paramd, View paramView)
  {
    AppMethodBeat.i(344089);
    s.u(paramFinderChooseOriginalView, "this$0");
    s.u(paramd, "$this_apply");
    paramFinderChooseOriginalView.setOriginalFlag(1);
    paramd.cyW();
    AppMethodBeat.o(344089);
  }
  
  private static final void c(FinderChooseOriginalView paramFinderChooseOriginalView, d paramd, View paramView)
  {
    AppMethodBeat.i(344109);
    s.u(paramFinderChooseOriginalView, "this$0");
    s.u(paramd, "$this_apply");
    paramFinderChooseOriginalView = new d(paramFinderChooseOriginalView.getContext());
    paramFinderChooseOriginalView.UD(e.f.finder_original_define_bottom_sheet);
    paramFinderChooseOriginalView.rootView.findViewById(e.e.close_bottom_sheet_layout).setOnClickListener(new FinderChooseOriginalView..ExternalSyntheticLambda4(paramFinderChooseOriginalView));
    paramFinderChooseOriginalView.dDn();
    paramd.cyW();
    AppMethodBeat.o(344109);
  }
  
  private static final void k(d paramd, View paramView)
  {
    AppMethodBeat.i(344099);
    s.u(paramd, "$this_apply");
    paramd.cyW();
    AppMethodBeat.o(344099);
  }
  
  public final int getFlag()
  {
    return this.eQp;
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnFlagChangedListener()
  {
    return this.Gxq;
  }
  
  public final TextView getTipTv()
  {
    return this.pls;
  }
  
  public final void setFlag(int paramInt)
  {
    this.eQp = paramInt;
  }
  
  public final void setOnFlagChangedListener(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.Gxq = paramb;
  }
  
  public final void setOriginalFlag(int paramInt)
  {
    AppMethodBeat.i(344187);
    this.eQp = paramInt;
    if (this.eQp == 1) {
      this.pls.setText(e.h.finder_original_feed_tip);
    }
    for (;;)
    {
      kotlin.g.a.b localb = this.Gxq;
      if (localb != null) {
        localb.invoke(Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(344187);
      return;
      if (this.eQp == 2) {
        this.pls.setText(e.h.finder_no_original_feed_tip);
      } else {
        this.pls.setText((CharSequence)"");
      }
    }
  }
  
  public final void setTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(344164);
    s.u(paramTextView, "<set-?>");
    this.pls = paramTextView;
    AppMethodBeat.o(344164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseOriginalView
 * JD-Core Version:    0.7.0.1
 */