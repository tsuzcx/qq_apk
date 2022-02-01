package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "emptyClickListener", "Lkotlin/Function0;", "", "failedLayout", "Landroid/view/View;", "filledClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "isVerifyState", "", "()Z", "setVerifyState", "(Z)V", "value", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "normalLayout", "style", "getStyle", "()Ljava/lang/Integer;", "setStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "succIocn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "succLayout", "succTv", "Landroid/widget/TextView;", "tipsClickListener", "Lkotlin/Function3;", "title", "tipsLayout", "tipsLink", "getTipsLink", "setTipsLink", "tipsTitle", "getTipsTitle", "setTipsTitle", "tipsTv", "getTitle", "setTitle", "verifyingLayout", "setFailedState", "setListeners", "setOriginState", "setSuccState", "setVerifyingState", "updateVerifiedTips", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-finder_release"})
public final class FinderExtendReadingView
  extends LinearLayout
{
  private final TextView AWF;
  public kotlin.g.a.a<x> AWK;
  public kotlin.g.a.b<? super String, x> AWL;
  public q<? super String, ? super String, ? super Integer, x> AWM;
  private String AWN;
  private String AWO;
  private Integer AWP;
  private final View AWQ;
  private final View AWR;
  private final View AWS;
  private final View AWT;
  private final TextView AWU;
  private final WeImageView AWV;
  public boolean AWW;
  private final String TAG;
  private String link;
  private String title;
  private final View zzB;
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168331);
    this.TAG = "Finder.FinderExtendReadingView";
    this.AWP = Integer.valueOf(0);
    setOrientation(1);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_extend_reading_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_normal_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.AWQ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_verifying_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.AWR = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_failed_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.AWS = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_succ_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.AWT = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_tips_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.zzB = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_tips_tv);
    p.j(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.AWF = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_title_tv);
    p.j(paramAttributeSet, "view.findViewById(R.id.extend_reading_title_tv)");
    this.AWU = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(b.f.extend_reading_succ_icon);
    p.j(paramContext, "view.findViewById(R.id.extend_reading_succ_icon)");
    this.AWV = ((WeImageView)paramContext);
    eiF();
    AppMethodBeat.o(168331);
  }
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168332);
    this.TAG = "Finder.FinderExtendReadingView";
    this.AWP = Integer.valueOf(0);
    setOrientation(1);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_extend_reading_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_normal_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.AWQ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_verifying_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.AWR = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_failed_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.AWS = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_succ_state_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.AWT = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_tips_layout);
    p.j(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.zzB = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_tips_tv);
    p.j(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.AWF = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.extend_reading_title_tv);
    p.j(paramAttributeSet, "view.findViewById(R.id.extend_reading_title_tv)");
    this.AWU = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(b.f.extend_reading_succ_icon);
    p.j(paramContext, "view.findViewById(R.id.extend_reading_succ_icon)");
    this.AWV = ((WeImageView)paramContext);
    eiF();
    AppMethodBeat.o(168332);
  }
  
  public final void U(String paramString1, final String paramString2, int paramInt)
  {
    AppMethodBeat.i(285368);
    p.k(paramString1, "title");
    p.k(paramString2, "link");
    this.AWW = false;
    this.AWQ.setVisibility(8);
    this.AWR.setVisibility(8);
    this.AWS.setVisibility(8);
    this.AWT.setVisibility(0);
    this.zzB.setVisibility(8);
    setTitle(paramString1);
    setLink(paramString2);
    setStyle(Integer.valueOf(paramInt));
    this.AWU.setText((CharSequence)paramString1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.AWT.setOnClickListener((View.OnClickListener)new b(this, paramString2));
      AppMethodBeat.o(285368);
      return;
      this.AWV.setImageDrawable(au.o(getContext(), b.i.icons_outlined_link, com.tencent.mm.ci.a.w(getContext(), b.c.Orange)));
      continue;
      this.AWV.setImageDrawable(au.o(getContext(), b.i.icons_filled_red_envelope, com.tencent.mm.ci.a.w(getContext(), b.c.Orange)));
    }
  }
  
  public final void b(final String paramString1, final String paramString2, final Integer paramInteger)
  {
    AppMethodBeat.i(285369);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      this.zzB.setVisibility(8);
      AppMethodBeat.o(285369);
      return;
    }
    if (this.AWQ.getVisibility() != 0) {
      this.zzB.setVisibility(8);
    }
    for (;;)
    {
      setTipsLink(paramString2);
      setTipsTitle(paramString1);
      this.AWF.setText((CharSequence)getContext().getString(b.j.finder_extend_reading_tips, new Object[] { paramString1 }));
      this.AWF.setOnClickListener((View.OnClickListener)new d(this, paramString1, paramString2, paramInteger));
      AppMethodBeat.o(285369);
      return;
      this.zzB.setVisibility(0);
    }
  }
  
  public final void eiF()
  {
    AppMethodBeat.i(168327);
    this.AWW = false;
    this.AWQ.setVisibility(0);
    this.AWR.setVisibility(8);
    this.AWS.setVisibility(8);
    this.AWT.setVisibility(8);
    b(this.AWO, this.AWN, this.AWP);
    this.AWQ.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(168327);
  }
  
  public final String getLink()
  {
    return this.link;
  }
  
  public final Integer getStyle()
  {
    return this.AWP;
  }
  
  public final String getTipsLink()
  {
    return this.AWN;
  }
  
  public final String getTipsTitle()
  {
    return this.AWO;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void setLink(String paramString)
  {
    AppMethodBeat.i(168325);
    Log.i(this.TAG, "set link ".concat(String.valueOf(paramString)));
    this.link = paramString;
    AppMethodBeat.o(168325);
  }
  
  public final void setStyle(Integer paramInteger)
  {
    AppMethodBeat.i(285367);
    Log.i(this.TAG, "set style ".concat(String.valueOf(paramInteger)));
    this.AWP = paramInteger;
    AppMethodBeat.o(285367);
  }
  
  public final void setTipsLink(String paramString)
  {
    AppMethodBeat.i(168323);
    Log.i(this.TAG, "set tipsLink ".concat(String.valueOf(paramString)));
    this.AWN = paramString;
    AppMethodBeat.o(168323);
  }
  
  public final void setTipsTitle(String paramString)
  {
    AppMethodBeat.i(168324);
    Log.i(this.TAG, "set tipsTitle ".concat(String.valueOf(paramString)));
    this.AWO = paramString;
    AppMethodBeat.o(168324);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(168326);
    Log.i(this.TAG, "set title ".concat(String.valueOf(paramString)));
    this.title = paramString;
    AppMethodBeat.o(168326);
  }
  
  public final void setVerifyState(boolean paramBoolean)
  {
    this.AWW = paramBoolean;
  }
  
  public final void setVerifyingState(final String paramString)
  {
    AppMethodBeat.i(168328);
    p.k(paramString, "link");
    this.AWW = true;
    this.AWQ.setVisibility(8);
    this.AWR.setVisibility(0);
    this.AWS.setVisibility(8);
    this.AWT.setVisibility(8);
    this.zzB.setVisibility(8);
    setLink(paramString);
    this.AWR.setOnClickListener((View.OnClickListener)new c(this, paramString));
    AppMethodBeat.o(168328);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingView paramFinderExtendReadingView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168319);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = FinderExtendReadingView.a(this.AWX);
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168319);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168320);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = FinderExtendReadingView.b(this.AWX);
      if (paramView != null) {
        paramView.invoke(paramString2);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168320);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168321);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = FinderExtendReadingView.b(this.AWX);
      if (paramView != null) {
        paramView.invoke(paramString);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168321);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderExtendReadingView paramFinderExtendReadingView, String paramString1, String paramString2, Integer paramInteger) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168322);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = FinderExtendReadingView.c(this.AWX);
      if (paramView != null)
      {
        localObject = paramString1;
        if (localObject == null) {
          p.iCn();
        }
        String str = paramString2;
        if (str == null) {
          p.iCn();
        }
        Integer localInteger = paramInteger;
        if (localInteger == null) {
          p.iCn();
        }
        paramView.c(localObject, str, localInteger);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingView
 * JD-Core Version:    0.7.0.1
 */