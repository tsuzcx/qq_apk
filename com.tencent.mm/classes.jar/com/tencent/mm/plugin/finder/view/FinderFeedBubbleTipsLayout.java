package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedBubbleTipsLayout;", "Lcom/tencent/mm/plugin/finder/view/SimpleTouchableLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "temLocation1", "", "temLocation2", "getView", "T", "Landroid/view/View;", "viewId", "(I)Landroid/view/View;", "moveViewAboveLikeTargetView", "", "tipsView", "targetView", "onLayout", "changed", "", "left", "top", "right", "bottom", "onViewRemoved", "child", "Companion", "plugin-finder_release"})
public final class FinderFeedBubbleTipsLayout
  extends SimpleTouchableLayout
{
  public static final a AXi;
  private final int[] AXg;
  private final int[] AXh;
  
  static
  {
    AppMethodBeat.i(277723);
    AXi = new a((byte)0);
    AppMethodBeat.o(277723);
  }
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(277720);
    this.AXg = new int[2];
    this.AXh = new int[2];
    AppMethodBeat.o(277720);
  }
  
  public FinderFeedBubbleTipsLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(277721);
    this.AXg = new int[2];
    this.AXh = new int[2];
    AppMethodBeat.o(277721);
  }
  
  private <T extends View> T RD(int paramInt)
  {
    AppMethodBeat.i(277719);
    View localView = findViewById(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(277719);
      return localView;
    }
    AppMethodBeat.o(277719);
    return null;
  }
  
  private final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(277718);
    if (paramView1 != null)
    {
      int i;
      if (paramView1.getVisibility() == 0)
      {
        i = 1;
        if (i == 0) {
          break label163;
        }
      }
      for (;;)
      {
        if (paramView1 != null)
        {
          if (paramView2 != null)
          {
            paramView2.getLocationInWindow(this.AXg);
            getLocationInWindow(this.AXh);
            i = this.AXg[1] - this.AXh[1];
            if (i > 0)
            {
              d locald = d.AjH;
              if (((Number)d.dXx().aSr()).intValue() == 1)
              {
                int j = (paramView2.getHeight() - paramView1.getHeight()) / 2;
                int k = (int)paramView1.getResources().getDimension(b.d.Edge_2A);
                paramView1.layout(paramView1.getLeft() - paramView2.getWidth() - k, i + j, paramView1.getRight() - paramView2.getWidth() - k, j + i + paramView1.getHeight());
                AppMethodBeat.o(277718);
                return;
                i = 0;
                break;
                label163:
                paramView1 = null;
                continue;
              }
              paramView1.layout(paramView1.getLeft(), i - paramView1.getHeight(), paramView1.getRight(), i);
            }
            AppMethodBeat.o(277718);
            return;
          }
          AppMethodBeat.o(277718);
          return;
        }
      }
    }
    AppMethodBeat.o(277718);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(277717);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView1 = RD(b.f.profile_timeline_like_posting);
    View localView2;
    if (localView1 != null)
    {
      localView2 = RD(b.f.profile_upload_tip_container);
      if ((localView2 != null) && (localView2.getVisibility() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label145;
        }
        label61:
        if (localView1 == null) {
          break label151;
        }
        label66:
        if (localView1 != null) {
          break label168;
        }
        localView2 = ((FinderFeedBubbleTipsLayout)this).RD(b.f.awesome_icon_container);
        if (localView2 == null) {
          break label168;
        }
        if (localView2.getVisibility() != 0) {
          break label157;
        }
        paramInt1 = i;
        label99:
        if (paramInt1 == 0) {
          break label162;
        }
        label103:
        if (localView2 == null) {
          break label168;
        }
      }
    }
    for (;;)
    {
      k(RD(b.f.finder_self_feed_like_tips_layout), localView2);
      k(RD(b.f.finder_private_feed_like_tips_layout), localView2);
      AppMethodBeat.o(277717);
      return;
      paramInt1 = 0;
      break;
      label145:
      localView1 = null;
      break label61;
      label151:
      localView1 = null;
      break label66;
      label157:
      paramInt1 = 0;
      break label99;
      label162:
      localView2 = null;
      break label103;
      label168:
      localView2 = localView1;
    }
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(277716);
    p.k(paramView, "child");
    super.onViewRemoved(paramView);
    Object localObject = Looper.getMainLooper();
    p.j(localObject, "Looper.getMainLooper()");
    localObject = ((Looper)localObject).getThread();
    p.j(localObject, "Looper.getMainLooper().thread");
    long l = ((Thread)localObject).getId();
    localObject = Thread.currentThread();
    p.j(localObject, "Thread.currentThread()");
    if (l != ((Thread)localObject).getId())
    {
      Log.e("Finder.FeedBubbleTipsLayout", "[onViewRemoved] in other thread. child=" + paramView + ' ' + com.tencent.matrix.trace.g.b.getStack() + ' ');
      AppMethodBeat.o(277716);
      return;
    }
    if (isInLayout()) {
      Log.e("Finder.FeedBubbleTipsLayout", "[onViewRemoved] isInLayout child=" + paramView + ' ' + com.tencent.matrix.trace.g.b.getStack() + ' ');
    }
    AppMethodBeat.o(277716);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedBubbleTipsLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedBubbleTipsLayout
 * JD-Core Version:    0.7.0.1
 */