package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "line", "Landroid/view/View;", "onTabSelectedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "getOnTabSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "tab1Group", "tab1RedDot", "value", "", "tab1Text", "getTab1Text", "()Ljava/lang/String;", "setTab1Text", "(Ljava/lang/String;)V", "tab1Tv", "Landroid/widget/TextView;", "tab2Group", "tab2RedDot", "tab2Text", "getTab2Text", "setTab2Text", "tab2Tv", "onAttachedToWindow", "onClick", "v", "onScroll", "dx", "dy", "totalX", "totalY", "runLineAnimation", "runTabColorAnimation", "showTab1RedDot", "show", "", "showTab2RedDot", "Companion", "plugin-finder_release"})
public final class FinderLiveTextIndicator
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String TAG = "Finder.FinderLiveTextIndicator";
  public static final a yVJ;
  public final TextView yUG;
  public final View yUH;
  public final TextView yUI;
  private final View yUJ;
  private final View yUK;
  public final View yUL;
  public final View yVH;
  private kotlin.g.a.b<? super Integer, x> yVI;
  
  static
  {
    AppMethodBeat.i(287905);
    yVJ = new a((byte)0);
    TAG = "Finder.FinderLiveTextIndicator";
    AppMethodBeat.o(287905);
  }
  
  public FinderLiveTextIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287904);
    AppMethodBeat.o(287904);
  }
  
  public FinderLiveTextIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287903);
    View.inflate(paramContext, b.g.finder_live_text_indicator_ui, (ViewGroup)this);
    View localView = findViewById(b.f.finder_live_text_indicator_tab1);
    p.j(localView, "findViewById(R.id.finder_live_text_indicator_tab1)");
    this.yUG = ((TextView)localView);
    localView = findViewById(b.f.finder_live_text_indicator_tab2);
    p.j(localView, "findViewById(R.id.finder_live_text_indicator_tab2)");
    this.yUI = ((TextView)localView);
    localView = findViewById(b.f.finder_live_text_indicator_tab1_red_dot);
    p.j(localView, "findViewById(R.id.finder…t_indicator_tab1_red_dot)");
    this.yUH = localView;
    localView = findViewById(b.f.finder_live_text_indicator_tab2_red_dot);
    p.j(localView, "findViewById(R.id.finder…t_indicator_tab2_red_dot)");
    this.yUJ = localView;
    localView = findViewById(b.f.finder_live_text_indicator_tab1_group);
    p.j(localView, "findViewById(R.id.finder…ext_indicator_tab1_group)");
    this.yUK = localView;
    localView = findViewById(b.f.finder_live_text_indicator_tab2_group);
    p.j(localView, "findViewById(R.id.finder…ext_indicator_tab2_group)");
    this.yUL = localView;
    localView = findViewById(b.f.finder_live_text_indicator_line);
    p.j(localView, "findViewById(R.id.finder_live_text_indicator_line)");
    this.yVH = localView;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.FinderLiveTextIndicator);
      p.j(paramContext, "context.obtainStyledAttr….FinderLiveTextIndicator)");
      this.yUG.setText((CharSequence)paramContext.getString(b.l.FinderLiveTextIndicator_tab1_text));
      this.yUI.setText((CharSequence)paramContext.getString(b.l.FinderLiveTextIndicator_tab2_text));
      paramContext.recycle();
    }
    this.yUG.setAlpha(0.8F);
    this.yUG.setOnClickListener((View.OnClickListener)this);
    this.yUI.setOnClickListener((View.OnClickListener)this);
    this.yVH.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278947);
        Log.i(FinderLiveTextIndicator.access$getTAG$cp(), "post tab1Tv.measuredWidth:" + FinderLiveTextIndicator.a(this.yVK).getMeasuredWidth());
        FinderLiveTextIndicator.b(this.yVK).getLayoutParams().width = FinderLiveTextIndicator.a(this.yVK).getMeasuredWidth();
        AppMethodBeat.o(278947);
      }
    });
    AppMethodBeat.o(287903);
  }
  
  public final kotlin.g.a.b<Integer, x> getOnTabSelectedListener()
  {
    return this.yVI;
  }
  
  public final String getTab1Text()
  {
    AppMethodBeat.i(287895);
    Object localObject = this.yUG.getText();
    if (localObject != null)
    {
      String str = localObject.toString();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(287895);
    return localObject;
  }
  
  public final String getTab2Text()
  {
    AppMethodBeat.i(287897);
    Object localObject = this.yUI.getText();
    if (localObject != null)
    {
      String str = localObject.toString();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(287897);
    return localObject;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(287901);
    super.onAttachedToWindow();
    Log.i(TAG, "onAttachedToWindow tab1Tv.measuredWidth:" + this.yUG.getMeasuredWidth());
    AppMethodBeat.o(287901);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(287902);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_text_indicator_tab1;
      if (paramView != null) {
        break label95;
      }
      label59:
      i = b.f.finder_live_text_indicator_tab2;
      if (paramView != null) {
        break label126;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287902);
      return;
      paramView = null;
      break;
      label95:
      if (paramView.intValue() != i) {
        break label59;
      }
      paramView = this.yVI;
      if (paramView != null)
      {
        paramView.invoke(Integer.valueOf(0));
        continue;
        label126:
        if (paramView.intValue() == i)
        {
          paramView = this.yVI;
          if (paramView != null) {
            paramView.invoke(Integer.valueOf(1));
          }
        }
      }
    }
  }
  
  public final void pw(boolean paramBoolean)
  {
    AppMethodBeat.i(287899);
    View localView = this.yUH;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(287899);
      return;
    }
  }
  
  public final void px(boolean paramBoolean)
  {
    AppMethodBeat.i(287900);
    View localView = this.yUJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(287900);
      return;
    }
  }
  
  public final void setOnTabSelectedListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.yVI = paramb;
  }
  
  public final void setTab1Text(String paramString)
  {
    AppMethodBeat.i(287896);
    p.k(paramString, "value");
    this.yUG.setText((CharSequence)paramString);
    AppMethodBeat.o(287896);
  }
  
  public final void setTab2Text(String paramString)
  {
    AppMethodBeat.i(287898);
    p.k(paramString, "value");
    this.yUI.setText((CharSequence)paramString);
    AppMethodBeat.o(287898);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveTextIndicator$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveTextIndicator
 * JD-Core Version:    0.7.0.1
 */