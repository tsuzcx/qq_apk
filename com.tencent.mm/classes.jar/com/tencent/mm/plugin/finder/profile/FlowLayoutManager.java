package com.tencent.mm.plugin.finder.profile;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allItemFrames", "Landroid/util/SparseArray;", "Landroid/graphics/Rect;", "horizontalSpace", "", "getHorizontalSpace", "()I", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "(I)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "left", "lineRows", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "right", "row", "self", "getSelf", "()Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "top", "totalHeight", "getTotalHeight", "setTotalHeight", "usedMaxWidth", "verticalScrollOffset", "verticalSpace", "getVerticalSpace", "canScrollVertically", "", "fillLayout", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "formatAboveRow", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onLayoutChildren", "scrollVerticallyBy", "dy", "Item", "Row", "plugin-finder_release"})
public final class FlowLayoutManager
  extends RecyclerView.LayoutManager
{
  private final String TAG;
  private int left;
  private int right;
  private int top;
  private final FlowLayoutManager zPN;
  private int zPO;
  private int zPP;
  private int zPQ;
  private int zPR;
  private int zPS;
  private b zPT;
  private final List<b> zPU;
  private final SparseArray<Rect> zPV;
  
  public FlowLayoutManager()
  {
    AppMethodBeat.i(270857);
    this.TAG = "Finder.FlowLayoutManager";
    setAutoMeasureEnabled(true);
    this.zPN = ((FlowLayoutManager)this);
    this.zPT = new b();
    this.zPU = ((List)new ArrayList());
    this.zPV = new SparseArray();
    AppMethodBeat.o(270857);
  }
  
  private final void dNg()
  {
    AppMethodBeat.i(270853);
    List localList = this.zPT.zPZ;
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
      f1 = ((Rect)this.zPV.get(k)).top;
      float f2 = this.zPT.zPY;
      if (f1 < (this.zPT.maxHeight - ((a)localList.get(i)).zPW) / 2.0F + f2)
      {
        localObject = (Rect)this.zPV.get(k);
        if (localObject != null) {
          break label369;
        }
        localObject = new Rect();
      }
    }
    label369:
    for (;;)
    {
      int m = ((Rect)this.zPV.get(k)).left;
      f1 = this.zPT.zPY;
      int n = (int)((this.zPT.maxHeight - ((a)localList.get(i)).zPW) / 2.0F + f1);
      int i1 = ((Rect)this.zPV.get(k)).right;
      f1 = this.zPT.zPY;
      ((Rect)localObject).set(m, n, i1, (int)((this.zPT.maxHeight - ((a)localList.get(i)).zPW) / 2.0F + f1 + getDecoratedMeasuredHeight(localView)));
      this.zPV.put(k, localObject);
      p.k(localObject, "<set-?>");
      locala.byG = ((Rect)localObject);
      localList.set(i, locala);
      i += 1;
      break;
      localObject = this.zPT;
      p.k(localList, "<set-?>");
      ((b)localObject).zPZ = localList;
      this.zPU.add(this.zPT);
      this.zPT = new b();
      AppMethodBeat.o(270853);
      return;
    }
  }
  
  private final int dNh()
  {
    AppMethodBeat.i(270856);
    int i = this.zPN.getHeight();
    int j = this.zPN.getPaddingBottom();
    int k = this.zPN.getPaddingTop();
    AppMethodBeat.o(270856);
    return i - j - k;
  }
  
  private final void g(RecyclerView.s params)
  {
    AppMethodBeat.i(270851);
    if ((params.lX()) || (getItemCount() == 0))
    {
      AppMethodBeat.o(270851);
      return;
    }
    new Rect(getPaddingLeft(), getPaddingTop() + this.zPR, getWidth() - getPaddingRight(), this.zPR + (getHeight() - getPaddingBottom()));
    int k = ((Collection)this.zPU).size();
    int i = 0;
    while (i < k)
    {
      params = ((b)this.zPU.get(i)).zPZ;
      int m = ((Collection)params).size();
      int j = 0;
      while (j < m)
      {
        View localView = ((a)params.get(j)).view;
        measureChildWithMargins(localView, 0, 0);
        addView(localView);
        Rect localRect = ((a)params.get(j)).byG;
        layoutDecoratedWithMargins(localView, localRect.left, localRect.top - this.zPR, localRect.right, localRect.bottom - this.zPR);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(270851);
  }
  
  public final boolean canScrollVertically()
  {
    return true;
  }
  
  public final RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(270849);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(270849);
    return localLayoutParams;
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(270850);
    p.k(paramn, "recycler");
    p.k(params, "state");
    Log.d(this.TAG, "onLayoutChildren");
    this.zPS = 0;
    int i = this.top;
    int k = 0;
    int j = 0;
    this.zPT = new b();
    this.zPU.clear();
    this.zPV.clear();
    removeAllViews();
    if (getItemCount() == 0)
    {
      detachAndScrapAttachedViews(paramn);
      this.zPR = 0;
      AppMethodBeat.o(270850);
      return;
    }
    if ((getChildCount() == 0) && (params.lX()))
    {
      AppMethodBeat.o(270850);
      return;
    }
    detachAndScrapAttachedViews(paramn);
    if (getChildCount() == 0)
    {
      this.zPO = getWidth();
      this.zPP = getHeight();
      this.left = getPaddingLeft();
      this.right = getPaddingRight();
      this.top = getPaddingTop();
      this.zPQ = (this.zPO - this.left - this.right);
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
      localView = paramn.cR(n);
      p.j(localView, "recycler.getViewForPosition(i)");
      if (8 == localView.getVisibility()) {
        break label674;
      }
      measureChildWithMargins(localView, 0, 0);
      i1 = getDecoratedMeasuredWidth(localView);
      m = getDecoratedMeasuredHeight(localView);
      if (k + i1 <= this.zPQ)
      {
        i2 = this.left + k;
        localRect2 = (Rect)this.zPV.get(n);
        localRect1 = localRect2;
        if (localRect2 == null) {
          localRect1 = new Rect();
        }
        localRect1.set(i2, i, i2 + i1, i + m);
        this.zPV.put(n, localRect1);
        k += i1;
        j = Math.max(j, m);
        this.zPT.a(new a(m, localView, localRect1));
        this.zPT.zPY = i;
        this.zPT.maxHeight = j;
        m = i;
        i = j;
        label417:
        j = i;
        i1 = k;
        i2 = m;
        if (n == getItemCount() - 1)
        {
          dNg();
          this.zPS += i;
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
      dNg();
      i2 = i + j;
      this.zPS += j;
      i = this.left;
      localRect2 = (Rect)this.zPV.get(n);
      localRect1 = localRect2;
      if (localRect2 == null) {
        localRect1 = new Rect();
      }
      localRect1.set(i, i2, i + i1, i2 + m);
      this.zPV.put(n, localRect1);
      this.zPT.a(new a(m, localView, localRect1));
      this.zPT.zPY = i2;
      this.zPT.maxHeight = m;
      i = m;
      k = i1;
      m = i2;
      break label417;
      this.zPS = Math.max(this.zPS, dNh());
      Log.d(this.TAG, "onLayoutChildren totalHeight:" + this.zPS);
      g(params);
      AppMethodBeat.o(270850);
      return;
      label674:
      i1 = k;
      i2 = i;
    }
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(270855);
    p.k(paramn, "recycler");
    p.k(params, "state");
    Log.d("TAG", "totalHeight:" + this.zPS);
    int i;
    if (this.zPR + paramInt < 0) {
      i = -this.zPR;
    }
    for (;;)
    {
      this.zPR += i;
      offsetChildrenVertical(-i);
      g(params);
      AppMethodBeat.o(270855);
      return i;
      i = paramInt;
      if (this.zPR + paramInt > this.zPS - dNh()) {
        i = this.zPS - dNh() - this.zPR;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "", "useHeight", "", "view", "Landroid/view/View;", "rect", "Landroid/graphics/Rect;", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;ILandroid/view/View;Landroid/graphics/Rect;)V", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getUseHeight", "()I", "setUseHeight", "(I)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "plugin-finder_release"})
  public final class a
  {
    Rect byG;
    View view;
    int zPW;
    
    public a(View paramView, Rect paramRect)
    {
      AppMethodBeat.i(269411);
      this.zPW = paramView;
      this.view = paramRect;
      this.byG = localObject;
      AppMethodBeat.o(269411);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;)V", "cuTop", "", "getCuTop", "()F", "setCuTop", "(F)V", "maxHeight", "getMaxHeight", "setMaxHeight", "views", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "getViews", "()Ljava/util/List;", "setViews", "(Ljava/util/List;)V", "addViews", "", "view", "plugin-finder_release"})
  public final class b
  {
    float maxHeight;
    float zPY;
    List<FlowLayoutManager.a> zPZ;
    
    public b()
    {
      AppMethodBeat.i(266605);
      this.zPZ = ((List)new ArrayList());
      AppMethodBeat.o(266605);
    }
    
    public final void a(FlowLayoutManager.a parama)
    {
      AppMethodBeat.i(266604);
      p.k(parama, "view");
      this.zPZ.add(parama);
      AppMethodBeat.o(266604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FlowLayoutManager
 * JD-Core Version:    0.7.0.1
 */