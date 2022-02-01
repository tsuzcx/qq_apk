package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.k.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$ScrollVectorProvider;", "()V", "TAG", "", "bannerDataCount", "", "enableScroll", "", "getEnableScroll", "()Z", "setEnableScroll", "(Z)V", "hasLayout", "itemIntervalPx", "getItemIntervalPx", "()I", "setItemIntervalPx", "(I)V", "itemWidth", "loop", "getLoop", "setLoop", "mOrientationHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "smoothScrollTime", "getSmoothScrollTime", "setSmoothScrollTime", "addLeftItemView", "", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "canScrollHorizontally", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "target", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getCurrentPosition", "getItemTop", "item", "Landroid/view/View;", "getTotalHeight", "handleItemWhenScrollHorizontally", "layoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "layoutItem", "viewForPosition", "offsetX", "layoutLeftItem", "offsetDx", "onLayoutChildren", "scrollHorizontallyBy", "scrollToLeft", "scrollToRight", "smoothScrollToPosition", "recyclerView", "position", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3BannerLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b
{
  private final String TAG;
  private final androidx.recyclerview.widget.s bXy;
  boolean loop;
  boolean vqv;
  private int wLI;
  int yaX;
  int yaY;
  private boolean yaZ;
  private int yba;
  
  public EmojiStoreV3BannerLayoutManager()
  {
    AppMethodBeat.i(270559);
    androidx.recyclerview.widget.s locals = androidx.recyclerview.widget.s.d((RecyclerView.LayoutManager)this);
    kotlin.g.b.s.s(locals, "createHorizontalHelper(this)");
    this.bXy = locals;
    this.yaX = 2000;
    this.loop = true;
    this.TAG = "MicroMsg.EmojiStoreV3BannerLayoutManager";
    this.vqv = true;
    this.yba = 2147483647;
    AppMethodBeat.o(270559);
  }
  
  private final int a(int paramInt, RecyclerView.n paramn)
  {
    AppMethodBeat.i(270576);
    int k;
    do
    {
      for (;;)
      {
        localObject1 = getChildAt(0);
        if (localObject1 == null) {
          Log.i(this.TAG, "scrollToRight stopped, child null, pos:0");
        }
        while (getDecoratedLeft((View)localObject1) + Math.abs(paramInt) <= getPaddingLeft())
        {
          localObject1 = getChildAt(0);
          if (localObject1 != null) {
            break;
          }
          Log.i(this.TAG, "scrollToRight failed, firstChild null");
          AppMethodBeat.o(270576);
          return 0;
        }
        kotlin.g.b.s.u(paramn, "recycler");
        localObject1 = getChildAt(0);
        if (localObject1 != null) {
          break;
        }
        Log.i(this.TAG, "addLeftItemView failed, child null, pos:0");
      }
      j = getDecoratedLeft((View)localObject1);
      k = getPosition((View)localObject1);
    } while ((!this.loop) && (k == 0));
    if (this.loop) {}
    for (int i = (k - 1 + getItemCount()) % getItemCount();; i = k - 1)
    {
      localObject1 = paramn.gb(i);
      kotlin.g.b.s.s(localObject1, "recycler.getViewForPosition(addPosition)");
      addView((View)localObject1, 0);
      measureChildWithMargins((View)localObject1, 0, 0);
      Log.v(this.TAG, "scrollToRight, new item ,left + abs(dx):" + (Math.abs(paramInt) + j) + ",paddingLeft:" + getPaddingLeft() + ", dx:" + paramInt + ", position:" + k + ", addPos:" + i + ", left:" + (j - getDecoratedMeasuredWidth((View)localObject1) - this.yaY) + ", right:" + (j - this.yaY));
      i = getDecoratedMeasuredWidth((View)localObject1);
      k = this.yaY;
      int m = eY((View)localObject1);
      int n = this.yaY;
      int i1 = eY((View)localObject1);
      layoutDecoratedWithMargins((View)localObject1, j - i - k, m, j - n, getDecoratedMeasuredHeight((View)localObject1) + i1);
      break;
    }
    int j = getDecoratedRight((View)localObject1);
    i = paramInt;
    if (getPosition((View)localObject1) == 0)
    {
      i = paramInt;
      if (Math.abs(paramInt) + j > this.bXy.JG()) {
        i = -(this.bXy.JG() - j);
      }
    }
    offsetChildrenHorizontal(-i);
    Object localObject2 = (Iterable)new g(0, getChildCount());
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      View localView = getChildAt(((ah)localObject2).Zo());
      if (localView != null) {
        ((Collection)localObject1).add(localView);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (paramInt < 0) {
        p.kkW();
      }
      localObject2 = (View)localObject2;
      Log.d(this.TAG, "---printLocate, view, index:" + paramInt + ", left:" + getDecoratedLeft((View)localObject2) + ", right:" + getDecoratedRight((View)localObject2));
      if (getDecoratedLeft((View)localObject2) > this.bXy.JG()) {
        removeAndRecycleView((View)localObject2, paramn);
      }
      paramInt += 1;
    }
    AppMethodBeat.o(270576);
    return i;
  }
  
  private final int dCT()
  {
    AppMethodBeat.i(270582);
    int i = getHeight();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(270582);
    return i - j - k;
  }
  
  private final int eY(View paramView)
  {
    AppMethodBeat.i(270589);
    int i = (dCT() - getDecoratedMeasuredHeight(paramView)) / 2;
    int j = getPaddingTop();
    AppMethodBeat.o(270589);
    return i + j;
  }
  
  public final boolean canScrollHorizontally()
  {
    return this.vqv;
  }
  
  public final PointF fM(int paramInt)
  {
    return null;
  }
  
  public final RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(270596);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-1, -2);
    AppMethodBeat.o(270596);
    return localLayoutParams;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(270632);
    int i = 0;
    int k = getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = getChildAt(i);
      if ((localView != null) && (getDecoratedLeft(localView) >= 0) && (getDecoratedRight(localView) <= this.bXy.JG()))
      {
        i = getPosition(localView);
        AppMethodBeat.o(270632);
        return i;
      }
      if (j >= k)
      {
        AppMethodBeat.o(270632);
        return -1;
      }
      i = j;
    }
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(270604);
    kotlin.g.b.s.u(paramn, "recycler");
    kotlin.g.b.s.u(params, "state");
    if ((getItemCount() == 0) || (params.caw))
    {
      removeAndRecycleAllViews(paramn);
      AppMethodBeat.o(270604);
      return;
    }
    int m;
    int j;
    int i;
    if (!this.yaZ)
    {
      detachAndScrapAttachedViews(paramn);
      params = paramn.gb(0);
      kotlin.g.b.s.s(params, "recycler.getViewForPosition(0)");
      measureChildWithMargins(params, 0, 0);
      this.wLI = getDecoratedMeasuredWidth(params);
      m = getItemCount();
      if (m > 0)
      {
        j = 0;
        i = 0;
      }
    }
    for (;;)
    {
      int k = j + 1;
      int n;
      int i1;
      if (i <= this.bXy.JG())
      {
        params = paramn.gb(j);
        kotlin.g.b.s.s(params, "recycler.getViewForPosition(i)");
        addView(params);
        measureChildWithMargins(params, 0, 0);
        j = i + this.yaY;
        Log.v(this.TAG, kotlin.g.b.s.X("layoutItem, offsetX:", Integer.valueOf(j)));
        n = eY(params);
        i1 = this.wLI;
        int i2 = eY(params);
        layoutDecoratedWithMargins(params, j, n, j + i1, getDecoratedMeasuredHeight(params) + i2);
        n = this.wLI;
        i1 = this.yaY;
        if (k < m) {}
      }
      else
      {
        if ((getItemCount() >= 3) && (this.loop))
        {
          Log.d(this.TAG, "layoutItem, with recycler");
          params = getChildAt(getChildCount() - 2);
          if (params != null)
          {
            paramn = paramn.gb(getItemCount() - 1);
            kotlin.g.b.s.s(paramn, "recycler.getViewForPosition(itemCount - 1)");
            addView(paramn, 0);
            measureChildWithMargins(paramn, 0, 0);
            i = eY(paramn);
            j = getDecoratedLeft(params) - this.wLI;
            layoutDecoratedWithMargins(paramn, j - (this.wLI + j), i, 0, i + getDecoratedMeasuredHeight(paramn));
          }
        }
        this.yaZ = true;
        AppMethodBeat.o(270604);
        return;
      }
      j = k;
      i += n + i1;
    }
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(270621);
    if (paramn == null)
    {
      AppMethodBeat.o(270621);
      return 0;
    }
    label47:
    int i;
    if (paramInt > 0)
    {
      params = getChildAt(getChildCount() - 1);
      if (params == null)
      {
        Log.i(this.TAG, "scrollToLeft stopped, rightView null");
        params = getChildAt(getChildCount() - 1);
        if (params != null) {
          break label350;
        }
        Log.i(this.TAG, "scrollToLeft failed, lastChild null");
        i = 0;
      }
    }
    for (;;)
    {
      if (paramInt < 0) {
        i = a(paramInt, paramn);
      }
      AppMethodBeat.o(270621);
      return i;
      int j = getDecoratedRight(params);
      if (j - paramInt >= this.bXy.JG()) {
        break label47;
      }
      int k = getPosition(params);
      if ((!this.loop) && (k == getItemCount() - 1)) {
        break label47;
      }
      if (this.loop) {}
      Object localObject1;
      Object localObject2;
      for (i = (k + 1) % getItemCount();; i = k + 1)
      {
        params = paramn.gb(i);
        kotlin.g.b.s.s(params, "recycler.getViewForPosition(addPosition)");
        addView(params);
        measureChildWithMargins(params, 0, 0);
        int m = this.yaY;
        int n = eY(params);
        int i1 = this.yaY;
        int i2 = getDecoratedMeasuredWidth(params);
        int i3 = eY(params);
        layoutDecoratedWithMargins(params, j + m, n, i2 + (i1 + j), getDecoratedMeasuredHeight(params) + i3);
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("scrollToLeft, new item , dx:").append(paramInt).append(", position:").append(k).append(", addPos:").append(i).append(", left:").append(this.yaY + j).append(", right:");
        i = this.yaY;
        Log.v((String)localObject1, getDecoratedMeasuredWidth(params) + (i + j));
        break;
      }
      label350:
      j = getDecoratedLeft(params);
      if ((getPosition(params) == getItemCount() - 1) && (j - paramInt < 0)) {}
      for (;;)
      {
        offsetChildrenHorizontal(-j);
        localObject1 = (Iterable)new g(0, getChildCount());
        params = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = getChildAt(((ah)localObject1).Zo());
          if (localObject2 != null) {
            params.add(localObject2);
          }
        }
        params = ((Iterable)params).iterator();
        for (;;)
        {
          i = j;
          if (!params.hasNext()) {
            break;
          }
          localObject1 = (View)params.next();
          if (getDecoratedRight((View)localObject1) < 0) {
            removeAndRecycleView((View)localObject1, paramn);
          }
        }
        j = paramInt;
      }
      i = paramInt;
    }
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(270640);
    if ((getItemCount() <= 0) || ((!this.loop) && ((paramInt < 0) || (paramInt > getItemCount() - 1))))
    {
      AppMethodBeat.o(270640);
      return;
    }
    int i;
    if (!this.loop)
    {
      i = paramInt;
      if (getItemCount() <= 0) {}
    }
    else
    {
      i = (paramInt % getItemCount() + getItemCount()) % getItemCount();
    }
    if (paramRecyclerView != null) {
      paramRecyclerView.requestFocus();
    }
    int j = getCurrentPosition();
    if ((j == getItemCount() - 1) && (i == 0) && (this.loop)) {}
    for (paramInt = this.wLI + this.yaY;; paramInt = (i - j) * (this.wLI + this.yaY))
    {
      if (paramRecyclerView != null) {
        paramRecyclerView.a(paramInt, 0, null);
      }
      Log.v(this.TAG, "smoothScrollToPosition, currentPosition:" + j + ", targetPos:" + i + ", offset:" + paramInt + ", state:" + params + ',');
      AppMethodBeat.o(270640);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.EmojiStoreV3BannerLayoutManager
 * JD-Core Version:    0.7.0.1
 */