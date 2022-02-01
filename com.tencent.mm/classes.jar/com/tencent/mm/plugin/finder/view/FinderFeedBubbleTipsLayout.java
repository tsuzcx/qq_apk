package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedBubbleTipsLayout;", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "temLocation1", "", "temLocation2", "getView", "T", "Landroid/view/View;", "viewId", "(I)Landroid/view/View;", "moveViewAboveLikeTargetView", "", "tipsView", "targetView", "isCenterAlign", "", "onLayout", "changed", "left", "top", "right", "bottom", "onViewRemoved", "child", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedBubbleTipsLayout
  extends SimpleTouchableLayout
{
  public static final a GyK;
  private final int[] GyL;
  private final int[] GyM;
  
  static
  {
    AppMethodBeat.i(344815);
    GyK = new a((byte)0);
    AppMethodBeat.o(344815);
  }
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344791);
    this.GyL = new int[2];
    this.GyM = new int[2];
    AppMethodBeat.o(344791);
  }
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344797);
    this.GyL = new int[2];
    this.GyM = new int[2];
    AppMethodBeat.o(344797);
  }
  
  private <T extends View> T UH(int paramInt)
  {
    AppMethodBeat.i(344809);
    View localView = findViewById(paramInt);
    if (localView == null)
    {
      AppMethodBeat.o(344809);
      return null;
    }
    AppMethodBeat.o(344809);
    return localView;
  }
  
  private final void o(View paramView1, View paramView2)
  {
    AppMethodBeat.i(344805);
    int i;
    if (paramView1 != null)
    {
      if (paramView1.getVisibility() != 0) {
        break label122;
      }
      i = 1;
      if (i == 0) {
        break label127;
      }
    }
    for (;;)
    {
      if ((paramView1 != null) && (paramView2 != null))
      {
        paramView2.getLocationInWindow(this.GyL);
        getLocationInWindow(this.GyM);
        i = this.GyL[1] - this.GyM[1];
        int j = this.GyL[0] + paramView2.getMeasuredWidth() / 2;
        int k = paramView1.getMeasuredWidth() / 2;
        int m = paramView1.getMeasuredWidth() / 2;
        if (i > 0) {
          paramView1.layout(j - k, i - paramView1.getHeight(), j + m, i);
        }
      }
      AppMethodBeat.o(344805);
      return;
      label122:
      i = 0;
      break;
      label127:
      paramView1 = null;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(344830);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView1 = UH(e.e.profile_timeline_like_posting);
    View localView2;
    if (localView1 != null)
    {
      localView2 = UH(e.e.profile_upload_tip_container);
      if ((localView2 != null) && (localView2.getVisibility() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label145;
        }
        label61:
        if (localView1 == null) {
          break label169;
        }
      }
    }
    for (;;)
    {
      if (localView1 == null)
      {
        localView2 = ((FinderFeedBubbleTipsLayout)this).UH(e.e.awesome_icon_container);
        if (localView2 != null) {
          if (localView2.getVisibility() == 0)
          {
            paramInt1 = i;
            label99:
            if (paramInt1 == 0) {
              break label156;
            }
            label103:
            if (localView2 == null) {
              break label162;
            }
          }
        }
      }
      for (;;)
      {
        o(UH(e.e.finder_self_feed_like_tips_layout), localView2);
        o(UH(e.e.finder_private_feed_like_tips_layout), localView2);
        AppMethodBeat.o(344830);
        return;
        paramInt1 = 0;
        break;
        label145:
        localView1 = null;
        break label61;
        paramInt1 = 0;
        break label99;
        label156:
        localView2 = null;
        break label103;
        label162:
        localView2 = localView1;
      }
      label169:
      localView1 = null;
    }
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(344823);
    s.u(paramView, "child");
    super.onViewRemoved(paramView);
    if (Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId())
    {
      Log.e("Finder.FeedBubbleTipsLayout", "[onViewRemoved] in other thread. child=" + paramView + ' ' + c.getStack() + ' ');
      AppMethodBeat.o(344823);
      return;
    }
    if (isInLayout()) {
      Log.e("Finder.FeedBubbleTipsLayout", "[onViewRemoved] isInLayout child=" + paramView + ' ' + c.getStack() + ' ');
    }
    AppMethodBeat.o(344823);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedBubbleTipsLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedBubbleTipsLayout
 * JD-Core Version:    0.7.0.1
 */