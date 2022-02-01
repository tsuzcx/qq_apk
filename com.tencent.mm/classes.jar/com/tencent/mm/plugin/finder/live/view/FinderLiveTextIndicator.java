package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "line", "Landroid/view/View;", "onTabSelectedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnTabSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "tab1Group", "tab1RedDot", "value", "", "tab1Text", "getTab1Text", "()Ljava/lang/String;", "setTab1Text", "(Ljava/lang/String;)V", "tab1Tv", "Landroid/widget/TextView;", "tab2Group", "tab2RedDot", "tab2Text", "getTab2Text", "setTab2Text", "tab2Tv", "onAttachedToWindow", "onClick", "v", "onScroll", "dx", "dy", "totalX", "totalY", "runLineAnimation", "runTabColorAnimation", "setFixedTextSize", "showTab1RedDot", "show", "", "showTab2RedDot", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTextIndicator
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final FinderLiveTextIndicator.a DPB;
  private static final String TAG;
  public final TextView DNZ;
  public final View DOa;
  public final TextView DOb;
  private final View DOc;
  private final View DOd;
  public final View DOe;
  public final View DPC;
  private kotlin.g.a.b<? super Integer, ah> DPD;
  
  static
  {
    AppMethodBeat.i(357871);
    DPB = new FinderLiveTextIndicator.a((byte)0);
    TAG = "Finder.FinderLiveTextIndicator";
    AppMethodBeat.o(357871);
  }
  
  public FinderLiveTextIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(357857);
    AppMethodBeat.o(357857);
  }
  
  public FinderLiveTextIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357851);
    View.inflate(paramContext, p.f.CfT, (ViewGroup)this);
    View localView = findViewById(p.e.BTh);
    s.s(localView, "findViewById(R.id.finder_live_text_indicator_tab1)");
    this.DNZ = ((TextView)localView);
    localView = findViewById(p.e.BTk);
    s.s(localView, "findViewById(R.id.finder_live_text_indicator_tab2)");
    this.DOb = ((TextView)localView);
    localView = findViewById(p.e.BTj);
    s.s(localView, "findViewById(R.id.finder…t_indicator_tab1_red_dot)");
    this.DOa = localView;
    localView = findViewById(p.e.BTm);
    s.s(localView, "findViewById(R.id.finder…t_indicator_tab2_red_dot)");
    this.DOc = localView;
    localView = findViewById(p.e.BTi);
    s.s(localView, "findViewById(R.id.finder…ext_indicator_tab1_group)");
    this.DOd = localView;
    localView = findViewById(p.e.BTl);
    s.s(localView, "findViewById(R.id.finder…ext_indicator_tab2_group)");
    this.DOe = localView;
    localView = findViewById(p.e.BTg);
    s.s(localView, "findViewById(R.id.finder_live_text_indicator_line)");
    this.DPC = localView;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.j.hae);
      s.s(paramContext, "context.obtainStyledAttr….FinderLiveTextIndicator)");
      this.DNZ.setText((CharSequence)paramContext.getString(p.j.CuF));
      this.DOb.setText((CharSequence)paramContext.getString(p.j.CuG));
      paramContext.recycle();
    }
    this.DNZ.setAlpha(0.8F);
    this.DNZ.setOnClickListener((View.OnClickListener)this);
    this.DOb.setOnClickListener((View.OnClickListener)this);
    this.DPC.post(new FinderLiveTextIndicator..ExternalSyntheticLambda0(this));
    aw.a((Paint)this.DNZ.getPaint(), 0.8F);
    aw.a((Paint)this.DOb.getPaint(), 0.8F);
    AppMethodBeat.o(357851);
  }
  
  private static final void a(FinderLiveTextIndicator paramFinderLiveTextIndicator)
  {
    AppMethodBeat.i(357866);
    s.u(paramFinderLiveTextIndicator, "this$0");
    Log.i(TAG, s.X("post tab1Tv.measuredWidth:", Integer.valueOf(paramFinderLiveTextIndicator.DNZ.getMeasuredWidth())));
    paramFinderLiveTextIndicator.DPC.getLayoutParams().width = paramFinderLiveTextIndicator.DNZ.getMeasuredWidth();
    AppMethodBeat.o(357866);
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnTabSelectedListener()
  {
    return this.DPD;
  }
  
  public final String getTab1Text()
  {
    AppMethodBeat.i(357885);
    Object localObject = this.DNZ.getText();
    if (localObject == null)
    {
      AppMethodBeat.o(357885);
      return "";
    }
    localObject = localObject.toString();
    if (localObject == null)
    {
      AppMethodBeat.o(357885);
      return "";
    }
    AppMethodBeat.o(357885);
    return localObject;
  }
  
  public final String getTab2Text()
  {
    AppMethodBeat.i(357898);
    Object localObject = this.DOb.getText();
    if (localObject == null)
    {
      AppMethodBeat.o(357898);
      return "";
    }
    localObject = localObject.toString();
    if (localObject == null)
    {
      AppMethodBeat.o(357898);
      return "";
    }
    AppMethodBeat.o(357898);
    return localObject;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(357936);
    super.onAttachedToWindow();
    Log.i(TAG, s.X("onAttachedToWindow tab1Tv.measuredWidth:", Integer.valueOf(this.DNZ.getMeasuredWidth())));
    AppMethodBeat.o(357936);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(357946);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BTh;
      if (paramView != null) {
        break label95;
      }
      label53:
      i = p.e.BTk;
      if (paramView != null) {
        break label126;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357946);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label95:
      if (paramView.intValue() != i) {
        break label53;
      }
      paramView = this.DPD;
      if (paramView != null)
      {
        paramView.invoke(Integer.valueOf(0));
        continue;
        label126:
        if (paramView.intValue() == i)
        {
          paramView = this.DPD;
          if (paramView != null) {
            paramView.invoke(Integer.valueOf(1));
          }
        }
      }
    }
  }
  
  public final void sa(boolean paramBoolean)
  {
    AppMethodBeat.i(357922);
    View localView = this.DOa;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(357922);
      return;
    }
  }
  
  public final void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(357932);
    View localView = this.DOc;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(357932);
      return;
    }
  }
  
  public final void setOnTabSelectedListener(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.DPD = paramb;
  }
  
  public final void setTab1Text(String paramString)
  {
    AppMethodBeat.i(357892);
    s.u(paramString, "value");
    this.DNZ.setText((CharSequence)paramString);
    AppMethodBeat.o(357892);
  }
  
  public final void setTab2Text(String paramString)
  {
    AppMethodBeat.i(357906);
    s.u(paramString, "value");
    this.DOb.setText((CharSequence)paramString);
    AppMethodBeat.o(357906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveTextIndicator
 * JD-Core Version:    0.7.0.1
 */