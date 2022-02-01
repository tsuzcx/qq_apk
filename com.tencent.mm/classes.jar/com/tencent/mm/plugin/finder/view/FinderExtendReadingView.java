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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "emptyClickListener", "Lkotlin/Function0;", "", "failedLayout", "Landroid/view/View;", "filledClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "isVerifyState", "", "()Z", "setVerifyState", "(Z)V", "value", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "normalLayout", "succLayout", "succTv", "Landroid/widget/TextView;", "tipsClickListener", "Lkotlin/Function2;", "title", "tipsLayout", "tipsLink", "getTipsLink", "setTipsLink", "tipsTitle", "getTipsTitle", "setTipsTitle", "tipsTv", "getTitle", "setTitle", "verifyingLayout", "setFailedState", "setListeners", "setOriginState", "setSuccState", "setVerifyingState", "updateVerifiedTips", "plugin-finder_release"})
public final class FinderExtendReadingView
  extends LinearLayout
{
  private final String TAG;
  private String link;
  private final TextView pJV;
  private String title;
  private final View uNf;
  public kotlin.g.a.a<x> wlL;
  public kotlin.g.a.b<? super String, x> wlM;
  public m<? super String, ? super String, x> wlN;
  private String wlO;
  private String wlP;
  private final View wlQ;
  private final View wlR;
  private final View wlS;
  private final View wlT;
  private final TextView wlU;
  public boolean wlV;
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168331);
    this.TAG = "Finder.FinderExtendReadingView";
    setOrientation(1);
    paramContext = aa.jQ(getContext()).inflate(2131494245, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131300259);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.wlQ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300266);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.wlR = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300257);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.wlS = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300261);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.wlT = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300262);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.uNf = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300263);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.pJV = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131300264);
    p.g(paramContext, "view.findViewById(R.id.extend_reading_title_tv)");
    this.wlU = ((TextView)paramContext);
    dGG();
    AppMethodBeat.o(168331);
  }
  
  public FinderExtendReadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168332);
    this.TAG = "Finder.FinderExtendReadingView";
    setOrientation(1);
    paramContext = aa.jQ(getContext()).inflate(2131494245, null);
    addView(paramContext, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    paramAttributeSet = paramContext.findViewById(2131300259);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_normal_state_layout)");
    this.wlQ = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300266);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…g_verifying_state_layout)");
    this.wlR = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300257);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…ding_failed_state_layout)");
    this.wlS = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300261);
    p.g(paramAttributeSet, "view.findViewById(R.id.e…eading_succ_state_layout)");
    this.wlT = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300262);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_layout)");
    this.uNf = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300263);
    p.g(paramAttributeSet, "view.findViewById(R.id.extend_reading_tips_tv)");
    this.pJV = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131300264);
    p.g(paramContext, "view.findViewById(R.id.extend_reading_title_tv)");
    this.wlU = ((TextView)paramContext);
    dGG();
    AppMethodBeat.o(168332);
  }
  
  public final void dGG()
  {
    AppMethodBeat.i(168327);
    this.wlV = false;
    this.wlQ.setVisibility(0);
    this.wlR.setVisibility(8);
    this.wlS.setVisibility(8);
    this.wlT.setVisibility(8);
    hm(this.wlP, this.wlO);
    this.wlQ.setOnClickListener((View.OnClickListener)new a(this));
    AppMethodBeat.o(168327);
  }
  
  public final String getLink()
  {
    return this.link;
  }
  
  public final String getTipsLink()
  {
    return this.wlO;
  }
  
  public final String getTipsTitle()
  {
    return this.wlP;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void hl(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(168329);
    p.h(paramString1, "title");
    p.h(paramString2, "link");
    this.wlV = false;
    this.wlQ.setVisibility(8);
    this.wlR.setVisibility(8);
    this.wlS.setVisibility(8);
    this.wlT.setVisibility(0);
    this.uNf.setVisibility(8);
    setTitle(paramString1);
    setLink(paramString2);
    this.wlU.setText((CharSequence)paramString1);
    this.wlT.setOnClickListener((View.OnClickListener)new b(this, paramString2));
    AppMethodBeat.o(168329);
  }
  
  public final void hm(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(168330);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      this.uNf.setVisibility(8);
      AppMethodBeat.o(168330);
      return;
    }
    if (this.wlQ.getVisibility() != 0) {
      this.uNf.setVisibility(8);
    }
    for (;;)
    {
      setTipsLink(paramString2);
      setTipsTitle(paramString1);
      this.pJV.setText((CharSequence)getContext().getString(2131759696, new Object[] { paramString1 }));
      this.pJV.setOnClickListener((View.OnClickListener)new d(this, paramString1, paramString2));
      AppMethodBeat.o(168330);
      return;
      this.uNf.setVisibility(0);
    }
  }
  
  public final void setLink(String paramString)
  {
    AppMethodBeat.i(168325);
    Log.i(this.TAG, "set link ".concat(String.valueOf(paramString)));
    this.link = paramString;
    AppMethodBeat.o(168325);
  }
  
  public final void setTipsLink(String paramString)
  {
    AppMethodBeat.i(168323);
    Log.i(this.TAG, "set tipsLink ".concat(String.valueOf(paramString)));
    this.wlO = paramString;
    AppMethodBeat.o(168323);
  }
  
  public final void setTipsTitle(String paramString)
  {
    AppMethodBeat.i(168324);
    Log.i(this.TAG, "set tipsTitle ".concat(String.valueOf(paramString)));
    this.wlP = paramString;
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
    this.wlV = paramBoolean;
  }
  
  public final void setVerifyingState(final String paramString)
  {
    AppMethodBeat.i(168328);
    p.h(paramString, "link");
    this.wlV = true;
    this.wlQ.setVisibility(8);
    this.wlR.setVisibility(0);
    this.wlS.setVisibility(8);
    this.wlT.setVisibility(8);
    this.uNf.setVisibility(8);
    setLink(paramString);
    this.wlR.setOnClickListener((View.OnClickListener)new c(this, paramString));
    AppMethodBeat.o(168328);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingView paramFinderExtendReadingView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168319);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = FinderExtendReadingView.a(this.wlW);
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setOriginState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168319);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168320);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = FinderExtendReadingView.b(this.wlW);
      if (paramView != null) {
        paramView.invoke(paramString2);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setSuccState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168320);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderExtendReadingView paramFinderExtendReadingView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168321);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = FinderExtendReadingView.b(this.wlW);
      if (paramView != null) {
        paramView.invoke(paramString);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$setVerifyingState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168321);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderExtendReadingView paramFinderExtendReadingView, String paramString1, String paramString2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168322);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = FinderExtendReadingView.c(this.wlW);
      if (paramView != null)
      {
        localObject = paramString1;
        if (localObject == null) {
          p.hyc();
        }
        String str = paramString2;
        if (str == null) {
          p.hyc();
        }
        paramView.invoke(localObject, str);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingView$updateVerifiedTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingView
 * JD-Core Version:    0.7.0.1
 */