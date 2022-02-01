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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.z;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "emptyClickListener", "Lkotlin/Function0;", "", "failedLayout", "Landroid/view/View;", "filledClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "isVerifyState", "", "()Z", "setVerifyState", "(Z)V", "value", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "normalLayout", "succLayout", "succTv", "Landroid/widget/TextView;", "tipsClickListener", "Lkotlin/Function2;", "title", "tipsLayout", "tipsLink", "getTipsLink", "setTipsLink", "tipsTitle", "getTipsTitle", "setTipsTitle", "tipsTv", "getTitle", "setTitle", "verifyingLayout", "setFailedState", "setListeners", "setOriginState", "setSuccState", "setVerifyingState", "updateVerifiedTips", "plugin-finder_release"})
public final class FinderExtendReadingView
  extends LinearLayout
{
  private final String TAG;
  private String link;
  private final TextView nNp;
  private final View rLO;
  public a<y> rWQ;
  public b<? super String, y> rWR;
  public m<? super String, ? super String, y> rWS;
  private String rWT;
  private String rWU;
  private final View rWV;
  private final View rWW;
  private final View rWX;
  private final View rWY;
  private final TextView rWZ;
  public boolean rXa;
  private String title;
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168331);
    this.TAG = "Finder.FinderExtendReadingView";
    setOrientation(1);
    paramContext = z.jD(getContext()).inflate(2131494031, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299625);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.rWV = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299632);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.rWW = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299623);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.rWX = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299627);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.rWY = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299628);
    k.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.rLO = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299629);
    k.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.nNp = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299630);
    k.g(paramContext, "view.findViewById(R.id.extend_reading_title_tv)");
    this.rWZ = ((TextView)paramContext);
    cEQ();
    AppMethodBeat.o(168331);
  }
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168332);
    this.TAG = "Finder.FinderExtendReadingView";
    setOrientation(1);
    paramContext = z.jD(getContext()).inflate(2131494031, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299625);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.rWV = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299632);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.rWW = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299623);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.rWX = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299627);
    k.g(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.rWY = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299628);
    k.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.rLO = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299629);
    k.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.nNp = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299630);
    k.g(paramContext, "view.findViewById(R.id.extend_reading_title_tv)");
    this.rWZ = ((TextView)paramContext);
    cEQ();
    AppMethodBeat.o(168332);
  }
  
  public final void cEQ()
  {
    AppMethodBeat.i(168327);
    this.rXa = false;
    this.rWV.setVisibility(0);
    this.rWW.setVisibility(8);
    this.rWX.setVisibility(8);
    this.rWY.setVisibility(8);
    gr(this.rWU, this.rWT);
    this.rWV.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(168327);
  }
  
  public final String getLink()
  {
    return this.link;
  }
  
  public final String getTipsLink()
  {
    return this.rWT;
  }
  
  public final String getTipsTitle()
  {
    return this.rWU;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void gq(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(168329);
    k.h(paramString1, "title");
    k.h(paramString2, "link");
    this.rXa = false;
    this.rWV.setVisibility(8);
    this.rWW.setVisibility(8);
    this.rWX.setVisibility(8);
    this.rWY.setVisibility(0);
    this.rLO.setVisibility(8);
    setTitle(paramString1);
    setLink(paramString2);
    this.rWZ.setText((CharSequence)paramString1);
    this.rWY.setOnClickListener((View.OnClickListener)new b(this, paramString2));
    AppMethodBeat.o(168329);
  }
  
  public final void gr(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(168330);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      this.rLO.setVisibility(8);
      AppMethodBeat.o(168330);
      return;
    }
    if (this.rWV.getVisibility() != 0) {
      this.rLO.setVisibility(8);
    }
    for (;;)
    {
      setTipsLink(paramString2);
      setTipsTitle(paramString1);
      this.nNp.setText((CharSequence)getContext().getString(2131759203, new Object[] { paramString1 }));
      this.nNp.setOnClickListener((View.OnClickListener)new d(this, paramString1, paramString2));
      AppMethodBeat.o(168330);
      return;
      this.rLO.setVisibility(0);
    }
  }
  
  public final void setLink(String paramString)
  {
    AppMethodBeat.i(168325);
    ac.i(this.TAG, "set link ".concat(String.valueOf(paramString)));
    this.link = paramString;
    AppMethodBeat.o(168325);
  }
  
  public final void setTipsLink(String paramString)
  {
    AppMethodBeat.i(168323);
    ac.i(this.TAG, "set tipsLink ".concat(String.valueOf(paramString)));
    this.rWT = paramString;
    AppMethodBeat.o(168323);
  }
  
  public final void setTipsTitle(String paramString)
  {
    AppMethodBeat.i(168324);
    ac.i(this.TAG, "set tipsTitle ".concat(String.valueOf(paramString)));
    this.rWU = paramString;
    AppMethodBeat.o(168324);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(168326);
    ac.i(this.TAG, "set title ".concat(String.valueOf(paramString)));
    this.title = paramString;
    AppMethodBeat.o(168326);
  }
  
  public final void setVerifyState(boolean paramBoolean)
  {
    this.rXa = paramBoolean;
  }
  
  public final void setVerifyingState(final String paramString)
  {
    AppMethodBeat.i(168328);
    k.h(paramString, "link");
    this.rXa = true;
    this.rWV.setVisibility(8);
    this.rWW.setVisibility(0);
    this.rWX.setVisibility(8);
    this.rWY.setVisibility(8);
    this.rLO.setVisibility(8);
    setLink(paramString);
    this.rWW.setOnClickListener((View.OnClickListener)new c(this, paramString));
    AppMethodBeat.o(168328);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingView paramFinderExtendReadingView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168319);
      paramView = FinderExtendReadingView.a(this.rXb);
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(168319);
        return;
      }
      AppMethodBeat.o(168319);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168320);
      paramView = FinderExtendReadingView.b(this.rXb);
      if (paramView != null)
      {
        paramView.ay(paramString2);
        AppMethodBeat.o(168320);
        return;
      }
      AppMethodBeat.o(168320);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168321);
      paramView = FinderExtendReadingView.b(this.rXb);
      if (paramView != null)
      {
        paramView.ay(paramString);
        AppMethodBeat.o(168321);
        return;
      }
      AppMethodBeat.o(168321);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderExtendReadingView paramFinderExtendReadingView, String paramString1, String paramString2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168322);
      paramView = FinderExtendReadingView.c(this.rXb);
      if (paramView != null)
      {
        String str1 = paramString1;
        if (str1 == null) {
          k.fOy();
        }
        String str2 = paramString2;
        if (str2 == null) {
          k.fOy();
        }
        paramView.n(str1, str2);
        AppMethodBeat.o(168322);
        return;
      }
      AppMethodBeat.o(168322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingView
 * JD-Core Version:    0.7.0.1
 */