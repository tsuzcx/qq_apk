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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.m;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "emptyClickListener", "Lkotlin/Function0;", "", "failedLayout", "Landroid/view/View;", "filledClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "isVerifyState", "", "()Z", "setVerifyState", "(Z)V", "value", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "normalLayout", "succLayout", "succTv", "Landroid/widget/TextView;", "tipsClickListener", "Lkotlin/Function2;", "title", "tipsLayout", "tipsLink", "getTipsLink", "setTipsLink", "tipsTitle", "getTipsTitle", "setTipsTitle", "tipsTv", "getTitle", "setTitle", "verifyingLayout", "setFailedState", "setListeners", "setOriginState", "setSuccState", "setVerifyingState", "updateVerifiedTips", "plugin-finder_release"})
public final class FinderExtendReadingView
  extends LinearLayout
{
  private final String TAG;
  private String link;
  private final TextView owr;
  private final View sSm;
  public d.g.a.a<d.z> teR;
  public d.g.a.b<? super String, d.z> teS;
  public m<? super String, ? super String, d.z> teT;
  private String teU;
  private String teV;
  private final View teW;
  private final View teX;
  private final View teY;
  private final View teZ;
  private final TextView tfa;
  public boolean tfb;
  private String title;
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168331);
    this.TAG = "Finder.FinderExtendReadingView";
    setOrientation(1);
    paramContext = com.tencent.mm.ui.z.jV(getContext()).inflate(2131494031, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299625);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.teW = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299632);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.teX = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299623);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.teY = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299627);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.teZ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299628);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.sSm = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299629);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.owr = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299630);
    p.g(paramContext, "view.findViewById(R.id.extend_reading_title_tv)");
    this.tfa = ((TextView)paramContext);
    cPS();
    AppMethodBeat.o(168331);
  }
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168332);
    this.TAG = "Finder.FinderExtendReadingView";
    setOrientation(1);
    paramContext = com.tencent.mm.ui.z.jV(getContext()).inflate(2131494031, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131299625);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.teW = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299632);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.teX = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299623);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.teY = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299627);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.teZ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299628);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.sSm = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299629);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.owr = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299630);
    p.g(paramContext, "view.findViewById(R.id.extend_reading_title_tv)");
    this.tfa = ((TextView)paramContext);
    cPS();
    AppMethodBeat.o(168332);
  }
  
  public final void cPS()
  {
    AppMethodBeat.i(168327);
    this.tfb = false;
    this.teW.setVisibility(0);
    this.teX.setVisibility(8);
    this.teY.setVisibility(8);
    this.teZ.setVisibility(8);
    gH(this.teV, this.teU);
    this.teW.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(168327);
  }
  
  public final void gG(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(168329);
    p.h(paramString1, "title");
    p.h(paramString2, "link");
    this.tfb = false;
    this.teW.setVisibility(8);
    this.teX.setVisibility(8);
    this.teY.setVisibility(8);
    this.teZ.setVisibility(0);
    this.sSm.setVisibility(8);
    setTitle(paramString1);
    setLink(paramString2);
    this.tfa.setText((CharSequence)paramString1);
    this.teZ.setOnClickListener((View.OnClickListener)new b(this, paramString2));
    AppMethodBeat.o(168329);
  }
  
  public final void gH(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(168330);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      this.sSm.setVisibility(8);
      AppMethodBeat.o(168330);
      return;
    }
    if (this.teW.getVisibility() != 0) {
      this.sSm.setVisibility(8);
    }
    for (;;)
    {
      setTipsLink(paramString2);
      setTipsTitle(paramString1);
      this.owr.setText((CharSequence)getContext().getString(2131759203, new Object[] { paramString1 }));
      this.owr.setOnClickListener((View.OnClickListener)new d(this, paramString1, paramString2));
      AppMethodBeat.o(168330);
      return;
      this.sSm.setVisibility(0);
    }
  }
  
  public final String getLink()
  {
    return this.link;
  }
  
  public final String getTipsLink()
  {
    return this.teU;
  }
  
  public final String getTipsTitle()
  {
    return this.teV;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void setLink(String paramString)
  {
    AppMethodBeat.i(168325);
    ae.i(this.TAG, "set link ".concat(String.valueOf(paramString)));
    this.link = paramString;
    AppMethodBeat.o(168325);
  }
  
  public final void setTipsLink(String paramString)
  {
    AppMethodBeat.i(168323);
    ae.i(this.TAG, "set tipsLink ".concat(String.valueOf(paramString)));
    this.teU = paramString;
    AppMethodBeat.o(168323);
  }
  
  public final void setTipsTitle(String paramString)
  {
    AppMethodBeat.i(168324);
    ae.i(this.TAG, "set tipsTitle ".concat(String.valueOf(paramString)));
    this.teV = paramString;
    AppMethodBeat.o(168324);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(168326);
    ae.i(this.TAG, "set title ".concat(String.valueOf(paramString)));
    this.title = paramString;
    AppMethodBeat.o(168326);
  }
  
  public final void setVerifyState(boolean paramBoolean)
  {
    this.tfb = paramBoolean;
  }
  
  public final void setVerifyingState(final String paramString)
  {
    AppMethodBeat.i(168328);
    p.h(paramString, "link");
    this.tfb = true;
    this.teW.setVisibility(8);
    this.teX.setVisibility(0);
    this.teY.setVisibility(8);
    this.teZ.setVisibility(8);
    this.sSm.setVisibility(8);
    setLink(paramString);
    this.teX.setOnClickListener((View.OnClickListener)new c(this, paramString));
    AppMethodBeat.o(168328);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingView paramFinderExtendReadingView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168319);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = FinderExtendReadingView.a(this.tfc);
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168319);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168320);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = FinderExtendReadingView.b(this.tfc);
      if (paramView != null) {
        paramView.invoke(paramString2);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168320);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168321);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = FinderExtendReadingView.b(this.tfc);
      if (paramView != null) {
        paramView.invoke(paramString);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168321);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderExtendReadingView paramFinderExtendReadingView, String paramString1, String paramString2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168322);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = FinderExtendReadingView.c(this.tfc);
      if (paramView != null)
      {
        localObject = paramString1;
        if (localObject == null) {
          p.gkB();
        }
        String str = paramString2;
        if (str == null) {
          p.gkB();
        }
        paramView.p(localObject, str);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingView
 * JD-Core Version:    0.7.0.1
 */