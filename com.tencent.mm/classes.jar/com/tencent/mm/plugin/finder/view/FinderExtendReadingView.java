package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.h;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "emptyClickListener", "Lkotlin/Function0;", "", "failedLayout", "Landroid/view/View;", "filledClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "isVerifyState", "", "()Z", "setVerifyState", "(Z)V", "value", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "normalLayout", "style", "getStyle", "()Ljava/lang/Integer;", "setStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "succIocn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "succLayout", "succTv", "Landroid/widget/TextView;", "tipsClickListener", "Lkotlin/Function4;", "title", "html5Style", "tipsLayout", "tipsLink", "getTipsLink", "setTipsLink", "tipsTitle", "getTipsTitle", "setTipsTitle", "tipsTv", "getTitle", "setTitle", "verifyingLayout", "setFailedState", "setListeners", "setOriginState", "setSuccState", "setVerifyingState", "updateVerifiedTips", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderExtendReadingView
  extends LinearLayout
{
  private final TextView DMt;
  private final View EBQ;
  private final View EtB;
  private final View GyA;
  private final TextView GyB;
  private final WeImageView GyC;
  public boolean GyD;
  public kotlin.g.a.a<ah> Gys;
  public kotlin.g.a.b<? super String, ah> Gyt;
  public r<? super String, ? super String, ? super Integer, ? super Integer, ah> Gyu;
  private String Gyv;
  private String Gyw;
  private Integer Gyx;
  private final View Gyy;
  private final View Gyz;
  private final String TAG;
  private String link;
  private String title;
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168331);
    this.TAG = "Finder.FinderExtendReadingView";
    this.Gyx = Integer.valueOf(0);
    setOrientation(1);
    paramContext = af.mU(getContext()).inflate(l.f.finder_extend_reading_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_normal_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.EtB = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_verifying_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.Gyy = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_failed_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.Gyz = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_succ_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.GyA = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_tips_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.EBQ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_tips_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.DMt = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_title_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.extend_reading_title_tv)");
    this.GyB = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(l.e.extend_reading_succ_icon);
    s.s(paramContext, "view.findViewById(R.id.extend_reading_succ_icon)");
    this.GyC = ((WeImageView)paramContext);
    fkx();
    AppMethodBeat.o(168331);
  }
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168332);
    this.TAG = "Finder.FinderExtendReadingView";
    this.Gyx = Integer.valueOf(0);
    setOrientation(1);
    paramContext = af.mU(getContext()).inflate(l.f.finder_extend_reading_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_normal_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.EtB = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_verifying_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.Gyy = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_failed_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.Gyz = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_succ_state_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.GyA = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_tips_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.EBQ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_tips_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.DMt = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.extend_reading_title_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.extend_reading_title_tv)");
    this.GyB = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(l.e.extend_reading_succ_icon);
    s.s(paramContext, "view.findViewById(R.id.extend_reading_succ_icon)");
    this.GyC = ((WeImageView)paramContext);
    fkx();
    AppMethodBeat.o(168332);
  }
  
  private static final void a(FinderExtendReadingView paramFinderExtendReadingView, View paramView)
  {
    AppMethodBeat.i(345292);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingView, "this$0");
    paramFinderExtendReadingView = paramFinderExtendReadingView.Gys;
    if (paramFinderExtendReadingView != null) {
      paramFinderExtendReadingView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345292);
  }
  
  private static final void a(FinderExtendReadingView paramFinderExtendReadingView, String paramString, View paramView)
  {
    AppMethodBeat.i(345302);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingView, "this$0");
    s.u(paramString, "$link");
    paramFinderExtendReadingView = paramFinderExtendReadingView.Gyt;
    if (paramFinderExtendReadingView != null) {
      paramFinderExtendReadingView.invoke(paramString);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345302);
  }
  
  private static final void a(FinderExtendReadingView paramFinderExtendReadingView, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, View paramView)
  {
    AppMethodBeat.i(345322);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingView);
    localb.cH(paramString1);
    localb.cH(paramString2);
    localb.cH(paramInteger1);
    localb.cH(paramInteger2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingView, "this$0");
    paramFinderExtendReadingView = paramFinderExtendReadingView.Gyu;
    if (paramFinderExtendReadingView != null)
    {
      s.checkNotNull(paramString1);
      s.checkNotNull(paramString2);
      s.checkNotNull(paramInteger1);
      s.checkNotNull(paramInteger2);
      paramFinderExtendReadingView.a(paramString1, paramString2, paramInteger1, paramInteger2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345322);
  }
  
  private static final void b(FinderExtendReadingView paramFinderExtendReadingView, String paramString, View paramView)
  {
    AppMethodBeat.i(345313);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingView, "this$0");
    s.u(paramString, "$link");
    paramFinderExtendReadingView = paramFinderExtendReadingView.Gyt;
    if (paramFinderExtendReadingView != null) {
      paramFinderExtendReadingView.invoke(paramString);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345313);
  }
  
  public final void a(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(345444);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      this.EBQ.setVisibility(8);
      AppMethodBeat.o(345444);
      return;
    }
    if (this.EtB.getVisibility() != 0) {
      this.EBQ.setVisibility(8);
    }
    for (;;)
    {
      setTipsLink(paramString2);
      setTipsTitle(paramString1);
      this.DMt.setText((CharSequence)getContext().getString(l.i.finder_extend_reading_tips, new Object[] { paramString1 }));
      this.DMt.setOnClickListener(new FinderExtendReadingView..ExternalSyntheticLambda3(this, paramString1, paramString2, paramInteger1, paramInteger2));
      AppMethodBeat.o(345444);
      return;
      this.EBQ.setVisibility(0);
    }
  }
  
  public final void ac(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(345437);
    s.u(paramString1, "title");
    s.u(paramString2, "link");
    this.GyD = false;
    this.EtB.setVisibility(8);
    this.Gyy.setVisibility(8);
    this.Gyz.setVisibility(8);
    this.GyA.setVisibility(0);
    this.EBQ.setVisibility(8);
    setTitle(paramString1);
    setLink(paramString2);
    setStyle(Integer.valueOf(paramInt));
    this.GyB.setText((CharSequence)paramString1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.GyA.setOnClickListener(new FinderExtendReadingView..ExternalSyntheticLambda2(this, paramString2));
      AppMethodBeat.o(345437);
      return;
      this.GyC.setImageDrawable(bb.m(getContext(), l.h.icons_outlined_link, com.tencent.mm.cd.a.w(getContext(), l.b.Orange)));
      continue;
      this.GyC.setImageDrawable(bb.m(getContext(), l.h.icons_filled_red_envelope, com.tencent.mm.cd.a.w(getContext(), l.b.Orange)));
    }
  }
  
  public final void fkx()
  {
    AppMethodBeat.i(168327);
    this.GyD = false;
    this.EtB.setVisibility(0);
    this.Gyy.setVisibility(8);
    this.Gyz.setVisibility(8);
    this.GyA.setVisibility(8);
    a(this, this.Gyw, this.Gyv, this.Gyx);
    this.EtB.setOnClickListener(new FinderExtendReadingView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(168327);
  }
  
  public final String getLink()
  {
    return this.link;
  }
  
  public final Integer getStyle()
  {
    return this.Gyx;
  }
  
  public final String getTipsLink()
  {
    return this.Gyv;
  }
  
  public final String getTipsTitle()
  {
    return this.Gyw;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void setLink(String paramString)
  {
    AppMethodBeat.i(168325);
    Log.i(this.TAG, s.X("set link ", paramString));
    this.link = paramString;
    AppMethodBeat.o(168325);
  }
  
  public final void setStyle(Integer paramInteger)
  {
    AppMethodBeat.i(345401);
    Log.i(this.TAG, s.X("set style ", paramInteger));
    this.Gyx = paramInteger;
    AppMethodBeat.o(345401);
  }
  
  public final void setTipsLink(String paramString)
  {
    AppMethodBeat.i(168323);
    Log.i(this.TAG, s.X("set tipsLink ", paramString));
    this.Gyv = paramString;
    AppMethodBeat.o(168323);
  }
  
  public final void setTipsTitle(String paramString)
  {
    AppMethodBeat.i(168324);
    Log.i(this.TAG, s.X("set tipsTitle ", paramString));
    this.Gyw = paramString;
    AppMethodBeat.o(168324);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(168326);
    Log.i(this.TAG, s.X("set title ", paramString));
    this.title = paramString;
    AppMethodBeat.o(168326);
  }
  
  public final void setVerifyState(boolean paramBoolean)
  {
    this.GyD = paramBoolean;
  }
  
  public final void setVerifyingState(String paramString)
  {
    AppMethodBeat.i(168328);
    s.u(paramString, "link");
    this.GyD = true;
    this.EtB.setVisibility(8);
    this.Gyy.setVisibility(0);
    this.Gyz.setVisibility(8);
    this.GyA.setVisibility(8);
    this.EBQ.setVisibility(8);
    setLink(paramString);
    this.Gyy.setOnClickListener(new FinderExtendReadingView..ExternalSyntheticLambda1(this, paramString));
    AppMethodBeat.o(168328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingView
 * JD-Core Version:    0.7.0.1
 */