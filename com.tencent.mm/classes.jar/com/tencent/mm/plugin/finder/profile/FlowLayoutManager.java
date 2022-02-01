package com.tencent.mm.plugin.finder.profile;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allItemFrames", "Landroid/util/SparseArray;", "Landroid/graphics/Rect;", "horizontalSpace", "", "getHorizontalSpace", "()I", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "(I)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "left", "lineRows", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "right", "row", "self", "getSelf", "()Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "top", "totalHeight", "getTotalHeight", "setTotalHeight", "usedMaxWidth", "verticalScrollOffset", "verticalSpace", "getVerticalSpace", "canScrollVertically", "", "fillLayout", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "formatAboveRow", "generateDefaultLayoutParams", "Landroid/support/v7/widget/RecyclerView$LayoutParams;", "onLayoutChildren", "scrollVerticallyBy", "dy", "Item", "Row", "plugin-finder_release"})
public final class FlowLayoutManager
  extends RecyclerView.LayoutManager
{
  private final String TAG;
  private int left;
  private int right;
  private int top;
  private final List<b> uZA;
  private final SparseArray<Rect> uZB;
  private final FlowLayoutManager uZt;
  private int uZu;
  private int uZv;
  private int uZw;
  private int uZx;
  private int uZy;
  private b uZz;
  
  public FlowLayoutManager()
  {
    AppMethodBeat.i(250010);
    this.TAG = "Finder.FlowLayoutManager";
    setAutoMeasureEnabled(true);
    this.uZt = ((FlowLayoutManager)this);
    this.uZz = new b();
    this.uZA = ((List)new ArrayList());
    this.uZB = new SparseArray();
    AppMethodBeat.o(250010);
  }
  
  private final void dmb()
  {
    AppMethodBeat.i(250007);
    List localList = this.uZz.uZF;
    int j = ((Collection)localList).size();
    int i = 0;
    a locala;
    View localView;
    int k;
    float f1;
    Object localObject;
    if (i < j)
    {
      locala = (a)localList.get(i);
      localView = locala.view;
      k = getPosition(localView);
      f1 = ((Rect)this.uZB.get(k)).top;
      float f2 = this.uZz.uZE;
      if (f1 < (this.uZz.maxHeight - ((a)localList.get(i)).uZC) / 2.0F + f2)
      {
        localObject = (Rect)this.uZB.get(k);
        if (localObject != null) {
          break label369;
        }
        localObject = new Rect();
      }
    }
    label369:
    for (;;)
    {
      int m = ((Rect)this.uZB.get(k)).left;
      f1 = this.uZz.uZE;
      int n = (int)((this.uZz.maxHeight - ((a)localList.get(i)).uZC) / 2.0F + f1);
      int i1 = ((Rect)this.uZB.get(k)).right;
      f1 = this.uZz.uZE;
      ((Rect)localObject).set(m, n, i1, (int)((this.uZz.maxHeight - ((a)localList.get(i)).uZC) / 2.0F + f1 + getDecoratedMeasuredHeight(localView)));
      this.uZB.put(k, localObject);
      p.h(localObject, "<set-?>");
      locala.rect = ((Rect)localObject);
      localList.set(i, locala);
      i += 1;
      break;
      localObject = this.uZz;
      p.h(localList, "<set-?>");
      ((b)localObject).uZF = localList;
      this.uZA.add(this.uZz);
      this.uZz = new b();
      AppMethodBeat.o(250007);
      return;
    }
  }
  
  private final int dmc()
  {
    AppMethodBeat.i(250009);
    int i = this.uZt.getHeight();
    int j = this.uZt.getPaddingBottom();
    int k = this.uZt.getPaddingTop();
    AppMethodBeat.o(250009);
    return i - j - k;
  }
  
  private final void g(RecyclerView.s params)
  {
    AppMethodBeat.i(250006);
    if ((params.lL()) || (getItemCount() == 0))
    {
      AppMethodBeat.o(250006);
      return;
    }
    new Rect(getPaddingLeft(), getPaddingTop() + this.uZx, getWidth() - getPaddingRight(), this.uZx + (getHeight() - getPaddingBottom()));
    int k = ((Collection)this.uZA).size();
    int i = 0;
    while (i < k)
    {
      params = ((b)this.uZA.get(i)).uZF;
      int m = ((Collection)params).size();
      int j = 0;
      while (j < m)
      {
        View localView = ((a)params.get(j)).view;
        measureChildWithMargins(localView, 0, 0);
        addView(localView);
        Rect localRect = ((a)params.get(j)).rect;
        layoutDecoratedWithMargins(localView, localRect.left, localRect.top - this.uZx, localRect.right, localRect.bottom - this.uZx);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(250006);
  }
  
  public final boolean canScrollVertically()
  {
    return true;
  }
  
  public final RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(250004);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(250004);
    return localLayoutParams;
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(250005);
    p.h(paramn, "recycler");
    p.h(params, "state");
    Log.d(this.TAG, "onLayoutChildren");
    this.uZy = 0;
    int i = this.top;
    int k = 0;
    int j = 0;
    this.uZz = new b();
    this.uZA.clear();
    this.uZB.clear();
    removeAllViews();
    if (getItemCount() == 0)
    {
      detachAndScrapAttachedViews(paramn);
      this.uZx = 0;
      AppMethodBeat.o(250005);
      return;
    }
    if ((getChildCount() == 0) && (params.lL()))
    {
      AppMethodBeat.o(250005);
      return;
    }
    detachAndScrapAttachedViews(paramn);
    if (getChildCount() == 0)
    {
      this.uZu = getWidth();
      this.uZv = getHeight();
      this.left = getPaddingLeft();
      this.right = getPaddingRight();
      this.top = getPaddingTop();
      this.uZw = (this.uZu - this.left - this.right);
    }
    int i3 = getItemCount();
    int n = 0;
    View localView;
    int i1;
    int m;
    int i2;
    Rect localRect2;
    Rect localRect1;
    if (n < i3)
    {
      Log.d(this.TAG, "index:".concat(String.valueOf(n)));
      localView = paramn.cp(n);
      p.g(localView, "recycler.getViewForPosition(i)");
      if (8 == localView.getVisibility()) {
        break label674;
      }
      measureChildWithMargins(localView, 0, 0);
      i1 = getDecoratedMeasuredWidth(localView);
      m = getDecoratedMeasuredHeight(localView);
      if (k + i1 <= this.uZw)
      {
        i2 = this.left + k;
        localRect2 = (Rect)this.uZB.get(n);
        localRect1 = localRect2;
        if (localRect2 == null) {
          localRect1 = new Rect();
        }
        localRect1.set(i2, i, i2 + i1, i + m);
        this.uZB.put(n, localRect1);
        k += i1;
        j = Math.max(j, m);
        this.uZz.a(new a(m, localView, localRect1));
        this.uZz.uZE = i;
        this.uZz.maxHeight = j;
        m = i;
        i = j;
        label417:
        j = i;
        i1 = k;
        i2 = m;
        if (n == getItemCount() - 1)
        {
          dmb();
          this.uZy += i;
          i2 = m;
          i1 = k;
          j = i;
        }
      }
    }
    for (;;)
    {
      n += 1;
      k = i1;
      i = i2;
      break;
      dmb();
      i2 = i + j;
      this.uZy += j;
      i = this.left;
      localRect2 = (Rect)this.uZB.get(n);
      localRect1 = localRect2;
      if (localRect2 == null) {
        localRect1 = new Rect();
      }
      localRect1.set(i, i2, i + i1, i2 + m);
      this.uZB.put(n, localRect1);
      this.uZz.a(new a(m, localView, localRect1));
      this.uZz.uZE = i2;
      this.uZz.maxHeight = m;
      i = m;
      k = i1;
      m = i2;
      break label417;
      this.uZy = Math.max(this.uZy, dmc());
      Log.d(this.TAG, "onLayoutChildren totalHeight:" + this.uZy);
      g(params);
      AppMethodBeat.o(250005);
      return;
      label674:
      i1 = k;
      i2 = i;
    }
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(250008);
    p.h(paramn, "recycler");
    p.h(params, "state");
    Log.d("TAG", "totalHeight:" + this.uZy);
    int i;
    if (this.uZx + paramInt < 0) {
      i = -this.uZx;
    }
    for (;;)
    {
      this.uZx += i;
      offsetChildrenVertical(-i);
      g(params);
      AppMethodBeat.o(250008);
      return i;
      i = paramInt;
      if (this.uZx + paramInt > this.uZy - dmc()) {
        i = this.uZy - dmc() - this.uZx;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "", "useHeight", "", "view", "Landroid/view/View;", "rect", "Landroid/graphics/Rect;", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;ILandroid/view/View;Landroid/graphics/Rect;)V", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getUseHeight", "()I", "setUseHeight", "(I)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "plugin-finder_release"})
  public final class a
  {
    Rect rect;
    int uZC;
    View view;
    
    public a(View paramView, Rect paramRect)
    {
      AppMethodBeat.i(250001);
      this.uZC = paramView;
      this.view = paramRect;
      this.rect = localObject;
      AppMethodBeat.o(250001);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;)V", "cuTop", "", "getCuTop", "()F", "setCuTop", "(F)V", "maxHeight", "getMaxHeight", "setMaxHeight", "views", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "getViews", "()Ljava/util/List;", "setViews", "(Ljava/util/List;)V", "addViews", "", "view", "plugin-finder_release"})
  public final class b
  {
    float maxHeight;
    float uZE;
    List<FlowLayoutManager.a> uZF;
    
    public b()
    {
      AppMethodBeat.i(250003);
      this.uZF = ((List)new ArrayList());
      AppMethodBeat.o(250003);
    }
    
    public final void a(FlowLayoutManager.a parama)
    {
      AppMethodBeat.i(250002);
      p.h(parama, "view");
      this.uZF.add(parama);
      AppMethodBeat.o(250002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FlowLayoutManager
 * JD-Core Version:    0.7.0.1
 */