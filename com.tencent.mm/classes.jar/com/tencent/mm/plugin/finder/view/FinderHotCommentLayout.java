package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan.Standard;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderHotCommentLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hotCommentContentTv", "Lcom/tencent/mm/plugin/finder/view/HotCommentSpacingTextView;", "kotlin.jvm.PlatformType", "getHotCommentContentTv", "()Lcom/tencent/mm/plugin/finder/view/HotCommentSpacingTextView;", "hotCommentContentTv$delegate", "Lkotlin/Lazy;", "hotCommentLikeCountTv", "Landroid/widget/TextView;", "getHotCommentLikeCountTv", "()Landroid/widget/TextView;", "hotCommentLikeCountTv$delegate", "hotCommentLikeFrame", "Landroid/view/View;", "getHotCommentLikeFrame", "()Landroid/view/View;", "hotCommentLikeFrame$delegate", "hotCommentTagTv", "getHotCommentTagTv", "hotCommentTagTv$delegate", "likeFrameWidth", "tagWidth", "bindData", "", "content", "", "likeCount", "setExtraSpace", "setMargin", "getMeasurements", "Landroid/graphics/Point;", "parent", "getWidthInAdvance", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderHotCommentLayout
  extends FrameLayout
{
  public static final a GzR;
  private final j GzS;
  private final j GzT;
  private final j GzU;
  private final j GzV;
  public int GzW;
  public int GzX;
  
  static
  {
    AppMethodBeat.i(344968);
    GzR = new a((byte)0);
    AppMethodBeat.o(344968);
  }
  
  public FinderHotCommentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344949);
    this.GzS = k.cm((a)new e(this));
    this.GzT = k.cm((a)new b(this));
    this.GzU = k.cm((a)new d(this));
    this.GzV = k.cm((a)new c(this));
    AppMethodBeat.o(344949);
  }
  
  public FinderHotCommentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344955);
    this.GzS = k.cm((a)new e(this));
    this.GzT = k.cm((a)new b(this));
    this.GzU = k.cm((a)new d(this));
    this.GzV = k.cm((a)new c(this));
    AppMethodBeat.o(344955);
  }
  
  public static int gW(View paramView)
  {
    AppMethodBeat.i(344961);
    int i = paramView.getMeasuredWidth();
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      if ((i > 0) || (localObject == null)) {
        break label87;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getWidth(), 0), View.MeasureSpec.makeMeasureSpec(((View)localObject).getHeight(), 1073741824));
      i = new Point(paramView.getMeasuredWidth(), paramView.getMeasuredHeight()).x;
    }
    label87:
    for (;;)
    {
      AppMethodBeat.o(344961);
      return i;
      localObject = null;
      break;
    }
  }
  
  public final HotCommentSpacingTextView getHotCommentContentTv()
  {
    AppMethodBeat.i(344977);
    HotCommentSpacingTextView localHotCommentSpacingTextView = (HotCommentSpacingTextView)this.GzT.getValue();
    AppMethodBeat.o(344977);
    return localHotCommentSpacingTextView;
  }
  
  public final TextView getHotCommentLikeCountTv()
  {
    AppMethodBeat.i(344986);
    TextView localTextView = (TextView)this.GzV.getValue();
    AppMethodBeat.o(344986);
    return localTextView;
  }
  
  public final View getHotCommentLikeFrame()
  {
    AppMethodBeat.i(344982);
    View localView = (View)this.GzU.getValue();
    AppMethodBeat.o(344982);
    return localView;
  }
  
  public final View getHotCommentTagTv()
  {
    AppMethodBeat.i(344975);
    View localView = (View)this.GzS.getValue();
    AppMethodBeat.o(344975);
    return localView;
  }
  
  public final void setMargin(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(344993);
    LeadingMarginSpan.Standard localStandard = new LeadingMarginSpan.Standard(this.GzW + getContext().getResources().getDimensionPixelSize(e.c.Edge_0_5_A), 0);
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    if (paramCharSequence.length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localSpannableString.setSpan(localStandard, 0, 1, 17);
      }
      getHotCommentContentTv().setText((CharSequence)localSpannableString);
      AppMethodBeat.o(344993);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderHotCommentLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/HotCommentSpacingTextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<HotCommentSpacingTextView>
  {
    b(FinderHotCommentLayout paramFinderHotCommentLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<TextView>
  {
    c(FinderHotCommentLayout paramFinderHotCommentLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<View>
  {
    d(FinderHotCommentLayout paramFinderHotCommentLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<View>
  {
    e(FinderHotCommentLayout paramFinderHotCommentLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderHotCommentLayout
 * JD-Core Version:    0.7.0.1
 */