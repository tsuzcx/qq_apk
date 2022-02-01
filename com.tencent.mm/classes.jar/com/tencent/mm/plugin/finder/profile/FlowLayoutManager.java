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
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "()V", "allItemFrames", "Landroid/util/SparseArray;", "Landroid/graphics/Rect;", "horizontalSpace", "", "getHorizontalSpace", "()I", "isFold", "", "()Z", "setFold", "(Z)V", "left", "lineRows", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "right", "row", "self", "getSelf", "()Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "top", "totalHeight", "getTotalHeight", "setTotalHeight", "(I)V", "usedMaxWidth", "verticalScrollOffset", "verticalSpace", "getVerticalSpace", "canScrollVertically", "fillLayout", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "formatAboveRow", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getRowItemCount", "rowIndex", "onLayoutChildren", "scrollVerticallyBy", "dy", "Companion", "Item", "Row", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FlowLayoutManager
  extends RecyclerView.LayoutManager
{
  public static final FlowLayoutManager.a FaN;
  private final FlowLayoutManager FaO;
  private int FaP;
  private int FaQ;
  int FaR;
  private c FaS;
  private final List<c> FaT;
  private final SparseArray<Rect> FaU;
  boolean evb;
  private int left;
  private int right;
  private int top;
  
  static
  {
    AppMethodBeat.i(348265);
    FaN = new FlowLayoutManager.a((byte)0);
    AppMethodBeat.o(348265);
  }
  
  public FlowLayoutManager()
  {
    AppMethodBeat.i(348223);
    setAutoMeasureEnabled(true);
    this.FaO = this;
    this.FaS = new c();
    this.FaT = ((List)new ArrayList());
    this.FaU = new SparseArray();
    AppMethodBeat.o(348223);
  }
  
  private final void eIB()
  {
    AppMethodBeat.i(348250);
    List localList = this.FaS.FaY;
    int k = localList.size() - 1;
    int i;
    int j;
    b localb;
    View localView;
    int m;
    float f1;
    Object localObject;
    if (k >= 0)
    {
      i = 0;
      j = i + 1;
      localb = (b)localList.get(i);
      localView = localb.view;
      m = getPosition(localView);
      f1 = ((Rect)this.FaU.get(m)).top;
      float f2 = this.FaS.FaX;
      if (f1 < (this.FaS.maxHeight - ((b)localList.get(i)).FaV) / 2.0F + f2)
      {
        localObject = (Rect)this.FaU.get(m);
        if (localObject != null) {
          break label378;
        }
        localObject = new Rect();
      }
    }
    label378:
    for (;;)
    {
      int n = ((Rect)this.FaU.get(m)).left;
      f1 = this.FaS.FaX;
      int i1 = (int)((this.FaS.maxHeight - ((b)localList.get(i)).FaV) / 2.0F + f1);
      int i2 = ((Rect)this.FaU.get(m)).right;
      f1 = this.FaS.FaX;
      ((Rect)localObject).set(n, i1, i2, (int)((this.FaS.maxHeight - ((b)localList.get(i)).FaV) / 2.0F + f1 + getDecoratedMeasuredHeight(localView)));
      this.FaU.put(m, localObject);
      s.u(localObject, "<set-?>");
      localb.rect = ((Rect)localObject);
      localList.set(i, localb);
      if (j > k)
      {
        localObject = this.FaS;
        s.u(localList, "<set-?>");
        ((c)localObject).FaY = localList;
        this.FaT.add(this.FaS);
        this.FaS = new c();
        AppMethodBeat.o(348250);
        return;
      }
      i = j;
      break;
    }
  }
  
  private final int eIC()
  {
    AppMethodBeat.i(348256);
    int i = this.FaO.getHeight();
    int j = this.FaO.getPaddingBottom();
    int k = this.FaO.getPaddingTop();
    AppMethodBeat.o(348256);
    return i - j - k;
  }
  
  private final void g(RecyclerView.s params)
  {
    AppMethodBeat.i(348235);
    if ((params.caw) || (getItemCount() == 0))
    {
      AppMethodBeat.o(348235);
      return;
    }
    int m = this.FaT.size() - 1;
    int j;
    int n;
    if (m >= 0)
    {
      i = 0;
      j = i + 1;
      params = ((c)this.FaT.get(i)).FaY;
      n = params.size() - 1;
      if (n < 0) {}
    }
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      View localView = ((b)params.get(i)).view;
      measureChildWithMargins(localView, 0, 0);
      addView(localView);
      Rect localRect = ((b)params.get(i)).rect;
      layoutDecoratedWithMargins(localView, localRect.left, localRect.top - this.FaQ, localRect.right, localRect.bottom - this.FaQ);
      if (k > n)
      {
        if (j > m)
        {
          AppMethodBeat.o(348235);
          return;
        }
        i = j;
        break;
      }
    }
  }
  
  public final boolean canScrollVertically()
  {
    return true;
  }
  
  public final int eID()
  {
    AppMethodBeat.i(348329);
    if (this.FaT.size() > 0)
    {
      int i = ((c)this.FaT.get(0)).FaY.size();
      AppMethodBeat.o(348329);
      return i;
    }
    AppMethodBeat.o(348329);
    return 0;
  }
  
  public final RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(348274);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(348274);
    return localLayoutParams;
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(348303);
    s.u(paramn, "recycler");
    s.u(params, "state");
    int i = this.top;
    int k = 0;
    this.FaR = 0;
    this.FaS = new c();
    this.FaT.clear();
    this.FaU.clear();
    removeAllViews();
    if (getItemCount() == 0)
    {
      detachAndScrapAttachedViews(paramn);
      this.FaQ = 0;
      AppMethodBeat.o(348303);
      return;
    }
    if ((getChildCount() == 0) && (params.caw))
    {
      AppMethodBeat.o(348303);
      return;
    }
    detachAndScrapAttachedViews(paramn);
    if (getChildCount() == 0)
    {
      this.left = getPaddingLeft();
      this.right = getPaddingRight();
      this.top = getPaddingTop();
      this.FaP = (getWidth() - this.left - this.right);
    }
    int i7 = getItemCount();
    int i5;
    int j;
    if (i7 > 0)
    {
      i5 = 0;
      j = 0;
    }
    int i6;
    int m;
    int n;
    int i1;
    label847:
    for (;;)
    {
      i6 = i5 + 1;
      m = j;
      n = k;
      i1 = i;
      try
      {
        Log.d("Finder.FlowLayoutManager", s.X("index:", Integer.valueOf(i5)));
        m = j;
        n = k;
        i1 = i;
        localView = paramn.gb(i5);
        m = j;
        n = k;
        i1 = i;
        s.s(localView, "recycler.getViewForPosition(i)");
        m = j;
        n = k;
        i1 = i;
        i4 = j;
        i3 = k;
        i2 = i;
        if (8 == localView.getVisibility()) {
          break label847;
        }
        m = j;
        n = k;
        i1 = i;
        measureChildWithMargins(localView, 0, 0);
        m = j;
        n = k;
        i1 = i;
        i3 = getDecoratedMeasuredWidth(localView);
        m = j;
        n = k;
        i1 = i;
        i4 = getDecoratedMeasuredHeight(localView);
        m = j;
        n = k;
        i1 = i;
        if (k + i3 > this.FaP) {
          break label724;
        }
        m = j;
        n = k;
        i1 = i;
        i2 = this.left + k;
        m = j;
        n = k;
        i1 = i;
        localRect3 = (Rect)this.FaU.get(i5);
        Rect localRect1 = localRect3;
        if (localRect3 == null)
        {
          m = j;
          n = k;
          i1 = i;
          localRect1 = new Rect();
        }
        m = j;
        n = k;
        i1 = i;
        localRect1.set(i2, i, i2 + i3, i + i4);
        m = j;
        n = k;
        i1 = i;
        this.FaU.put(i5, localRect1);
        k += i3;
        m = j;
        n = k;
        i1 = i;
        i2 = Math.max(j, i4);
        m = i2;
        n = k;
        i1 = i;
        this.FaS.a(new b(i4, localView, localRect1));
        m = i2;
        n = k;
        i1 = i;
        this.FaS.FaX = i;
        m = i2;
        n = k;
        i1 = i;
        this.FaS.maxHeight = i2;
        j = i;
        i = k;
        k = i2;
      }
      catch (Exception localException1)
      {
        int i2;
        for (;;)
        {
          View localView;
          Log.e("Finder.FlowLayoutManager", "onLayoutChildren e = " + localException1.getMessage() + ", i = " + i5 + " itemCount = " + getItemCount());
          i2 = i1;
          int i3 = n;
          int i4 = m;
          j = i4;
          i = i3;
          continue;
          m = j;
          n = k;
          i1 = i;
          eIB();
          i2 = i + j;
          m = j;
          n = k;
          i1 = i2;
          this.FaR += j;
          m = j;
          n = k;
          i1 = i2;
          i = this.left;
          m = j;
          n = k;
          i1 = i2;
          Rect localRect3 = (Rect)this.FaU.get(i5);
          Rect localRect2 = localRect3;
          if (localRect3 == null)
          {
            m = j;
            n = k;
            i1 = i2;
            localRect2 = new Rect();
          }
          m = j;
          n = k;
          i1 = i2;
          localRect2.set(i, i2, i + i3, i2 + i4);
          m = j;
          n = k;
          i1 = i2;
          this.FaU.put(i5, localRect2);
          try
          {
            this.FaS.a(new b(i4, localView, localRect2));
            this.FaS.FaX = i2;
            this.FaS.maxHeight = i4;
            k = i4;
            i = i3;
            j = i2;
          }
          catch (Exception localException2)
          {
            m = i4;
            n = i3;
            i1 = i2;
          }
        }
        i5 = i6;
        k = i;
        i = i2;
      }
      m = k;
      n = i;
      i1 = j;
      i4 = k;
      i3 = i;
      i2 = j;
      if (i5 == getItemCount() - 1)
      {
        m = k;
        n = i;
        i1 = j;
        eIB();
        m = k;
        n = i;
        i1 = j;
        this.FaR += k;
        i2 = j;
        j = k;
        if (i6 < i7) {
          break label1098;
        }
        for (;;)
        {
          this.FaR = Math.max(this.FaR, eIC());
          Log.d("Finder.FlowLayoutManager", s.X("onLayoutChildren totalHeight:", Integer.valueOf(this.FaR)));
          g(params);
          AppMethodBeat.o(348303);
          return;
          label724:
          m = j;
          n = k;
          i1 = i;
          if (!this.evb) {
            break;
          }
          m = j;
          n = k;
          i1 = i;
          eIB();
          m = j;
          n = k;
          i1 = i;
          this.FaR += j;
        }
      }
    }
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(348319);
    s.u(paramn, "recycler");
    s.u(params, "state");
    Log.d("Finder.FlowLayoutManager", s.X("totalHeight:", Integer.valueOf(this.FaR)));
    int i;
    if (this.FaQ + paramInt < 0) {
      i = -this.FaQ;
    }
    for (;;)
    {
      this.FaQ += i;
      offsetChildrenVertical(-i);
      g(params);
      AppMethodBeat.o(348319);
      return i;
      i = paramInt;
      if (this.FaQ + paramInt > this.FaR - eIC()) {
        i = this.FaR - eIC() - this.FaQ;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "", "useHeight", "", "view", "Landroid/view/View;", "rect", "Landroid/graphics/Rect;", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;ILandroid/view/View;Landroid/graphics/Rect;)V", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getUseHeight", "()I", "setUseHeight", "(I)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    int FaV;
    Rect rect;
    View view;
    
    public b(View paramView, Rect paramRect)
    {
      AppMethodBeat.i(348306);
      this.FaV = paramView;
      this.view = paramRect;
      this.rect = localObject;
      AppMethodBeat.o(348306);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;)V", "cuTop", "", "getCuTop", "()F", "setCuTop", "(F)V", "maxHeight", "getMaxHeight", "setMaxHeight", "views", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "getViews", "()Ljava/util/List;", "setViews", "(Ljava/util/List;)V", "addViews", "", "view", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
  {
    float FaX;
    List<FlowLayoutManager.b> FaY;
    float maxHeight;
    
    public c()
    {
      AppMethodBeat.i(348311);
      this.FaY = ((List)new ArrayList());
      AppMethodBeat.o(348311);
    }
    
    public final void a(FlowLayoutManager.b paramb)
    {
      AppMethodBeat.i(348324);
      s.u(paramb, "view");
      this.FaY.add(paramb);
      AppMethodBeat.o(348324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FlowLayoutManager
 * JD-Core Version:    0.7.0.1
 */