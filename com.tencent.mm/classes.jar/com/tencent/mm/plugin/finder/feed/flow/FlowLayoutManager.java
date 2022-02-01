package com.tencent.mm.plugin.finder.feed.flow;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.flow.cache.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlowLayoutManager
  extends RecyclerView.LayoutManager
{
  int BcE;
  RecyclerView.n BcF;
  b BcG;
  b BcH;
  d BcI;
  a BcJ;
  e BcK;
  public int BcL;
  public FlowLayoutManager.a BcM;
  public FlowLayoutManager.b BcN;
  int BcO;
  private ViewTreeObserver.OnGlobalLayoutListener aRD;
  public int maxLines;
  RecyclerView mkw;
  
  public FlowLayoutManager()
  {
    AppMethodBeat.i(363611);
    this.BcE = 0;
    this.maxLines = 2147483647;
    this.BcL = 0;
    this.BcM = null;
    this.BcN = null;
    this.BcO = 0;
    this.BcG = new b();
    this.BcH = b.a(this.BcG);
    setAutoMeasureEnabled(true);
    this.BcK = new e(this);
    AppMethodBeat.o(363611);
  }
  
  private int NO(int paramInt)
  {
    AppMethodBeat.i(363661);
    View localView = getChildAt(paramInt);
    int j = getDecoratedMeasuredHeight(localView);
    int i1 = getDecoratedMeasuredHeight(localView);
    int i = paramInt;
    int k = paramInt;
    int m;
    while ((i >= 0) && (!NR(i)))
    {
      localView = getChildAt(i);
      m = j;
      if (getDecoratedMeasuredHeight(localView) > j)
      {
        m = getDecoratedMeasuredHeight(localView);
        k = i;
      }
      i -= 1;
      j = m;
    }
    if (j < getDecoratedMeasuredHeight(getChildAt(i)))
    {
      k = getDecoratedMeasuredHeight(getChildAt(i));
      m = i;
    }
    for (;;)
    {
      int n = paramInt;
      i = i1;
      j = paramInt;
      paramInt = n;
      while ((paramInt < getChildCount()) && (!NS(paramInt)))
      {
        localView = getChildAt(paramInt);
        n = i;
        if (getDecoratedMeasuredHeight(localView) > i)
        {
          n = getDecoratedMeasuredHeight(localView);
          j = paramInt;
        }
        paramInt += 1;
        i = n;
      }
      if (i < getDecoratedMeasuredHeight(getChildAt(paramInt))) {
        i = getDecoratedMeasuredHeight(getChildAt(paramInt));
      }
      for (;;)
      {
        if (k >= i)
        {
          AppMethodBeat.o(363661);
          return m;
        }
        AppMethodBeat.o(363661);
        return paramInt;
        paramInt = j;
      }
      m = k;
      k = j;
    }
  }
  
  private int NP(int paramInt)
  {
    AppMethodBeat.i(363667);
    paramInt = bA(getChildAt(paramInt));
    AppMethodBeat.o(363667);
    return paramInt;
  }
  
  private boolean NQ(int paramInt)
  {
    AppMethodBeat.i(363681);
    View localView = getChildAt(NO(paramInt));
    boolean bool = Rect.intersects(new Rect(getPaddingLeft(), getPaddingTop(), edo(), edp()), new Rect(getPaddingLeft(), getDecoratedTop(localView), edo(), getDecoratedBottom(localView)));
    AppMethodBeat.o(363681);
    return bool;
  }
  
  private boolean NR(int paramInt)
  {
    AppMethodBeat.i(363723);
    boolean bool = a(paramInt, c.b(this.BcG));
    AppMethodBeat.o(363723);
    return bool;
  }
  
  private boolean NS(int paramInt)
  {
    AppMethodBeat.i(363736);
    boolean bool = b(paramInt, c.b(this.BcG));
    AppMethodBeat.o(363736);
    return bool;
  }
  
  private static int a(int paramInt, Rect paramRect, c paramc)
  {
    AppMethodBeat.i(363716);
    switch (4.BcS[paramc.BcW.BcU.ordinal()])
    {
    default: 
      i = paramRect.width();
      AppMethodBeat.o(363716);
      return i + paramInt;
    }
    int i = paramRect.width();
    AppMethodBeat.o(363716);
    return paramInt - i;
  }
  
  private Point a(Rect paramRect, c paramc)
  {
    AppMethodBeat.i(363708);
    switch (4.BcS[paramc.BcW.BcU.ordinal()])
    {
    default: 
      paramRect = new Point(getPaddingLeft() + paramRect.width(), paramRect.top);
      AppMethodBeat.o(363708);
      return paramRect;
    }
    paramRect = new Point(edo() - paramRect.width(), paramRect.top);
    AppMethodBeat.o(363708);
    return paramRect;
  }
  
  private boolean a(int paramInt, c paramc)
  {
    AppMethodBeat.i(363730);
    if (paramInt == 0)
    {
      AppMethodBeat.o(363730);
      return true;
    }
    switch (4.BcS[paramc.BcW.BcU.ordinal()])
    {
    default: 
      if (getDecoratedLeft(getChildAt(paramInt)) <= getPaddingLeft())
      {
        AppMethodBeat.o(363730);
        return true;
      }
      break;
    case 1: 
      if (getDecoratedRight(getChildAt(paramInt)) >= edo())
      {
        AppMethodBeat.o(363730);
        return true;
      }
      AppMethodBeat.o(363730);
      return false;
    }
    AppMethodBeat.o(363730);
    return false;
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2, int paramInt3, c paramc, Rect paramRect, c paramc1)
  {
    AppMethodBeat.i(363703);
    measureChildWithMargins(paramView, 0, 0);
    int i = getDecoratedMeasuredWidth(paramView);
    int j = getDecoratedMeasuredHeight(paramView);
    if (this.BcM != null) {
      paramc1.BcT += this.BcM.computeExtraSpace(paramView, i);
    }
    boolean bool;
    switch (4.BcS[paramc.BcW.BcU.ordinal()])
    {
    default: 
      if (d.a(paramInt1, i, getPaddingLeft(), edo(), paramc1.BcT, paramc))
      {
        bool = true;
        paramRect.left = getPaddingLeft();
        paramRect.top = (paramInt2 + paramInt3);
        paramRect.right = (i + paramRect.left);
        paramRect.bottom = (paramRect.top + j);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(363703);
      return bool;
      if (d.a(paramInt1, i, getPaddingLeft(), edo(), paramc1.BcT, paramc))
      {
        bool = true;
        paramRect.left = (edo() - i);
        paramRect.top = (paramInt2 + paramInt3);
        paramRect.right = edo();
        paramRect.bottom = (paramRect.top + j);
      }
      else
      {
        bool = false;
        paramRect.left = (paramInt1 - i);
        paramRect.top = paramInt2;
        paramRect.right = paramInt1;
        paramRect.bottom = (paramRect.top + j);
        continue;
        bool = false;
        paramRect.left = paramInt1;
        paramRect.top = paramInt2;
        paramRect.right = (i + paramRect.left);
        paramRect.bottom = (paramRect.top + j);
      }
    }
  }
  
  private int b(int paramInt, RecyclerView.n paramn)
  {
    AppMethodBeat.i(363639);
    Object localObject1 = getChildAt(NO(0));
    int j = getPaddingTop() - getDecoratedTop((View)localObject1);
    int i = j;
    if (j > Math.abs(paramInt))
    {
      offsetChildrenVertical(-paramInt);
      AppMethodBeat.o(363639);
      return paramInt;
    }
    do
    {
      if (NP(0) <= 0) {
        break label825;
      }
      int i1 = edq().x;
      int i2 = getDecoratedTop(getChildAt(NO(0)));
      int k = 0;
      localObject1 = new LinkedList();
      int i3 = NP(0);
      Rect localRect = new Rect();
      int m = 1;
      Object localObject2 = c.b(this.BcG);
      int n = NP(0);
      Object localObject3 = this.BcJ;
      if (((a)localObject3).boj())
      {
        j = ((a)localObject3).NT(n);
        if ((j != -1) && (j > 0)) {
          j = 1;
        }
      }
      while (j != 0)
      {
        j = this.BcJ.NT(n) - 1;
        localObject2 = this.BcJ.NW(j);
        k = this.BcJ.NV(j);
        j = 0;
        for (;;)
        {
          if (j < ((com.tencent.mm.plugin.finder.feed.flow.cache.b)localObject2).bUo)
          {
            localObject3 = paramn.gb(k + j);
            addView((View)localObject3, j);
            ((List)localObject1).add(localObject3);
            j += 1;
            continue;
            j = 0;
            break;
          }
        }
        m = ((com.tencent.mm.plugin.finder.feed.flow.cache.b)localObject2).maxHeight;
      }
      do
      {
        n = edq().x;
        localObject2 = c.b(this.BcG);
        localObject3 = new c();
        k = 0;
        j = 1;
        while (k < ((List)localObject1).size())
        {
          localView = (View)((List)localObject1).get(k);
          bool = a(localView, n, i2 - m, m, (c)localObject2, localRect, (c)localObject3);
          if (bool) {
            ((c)localObject3).BcT = 0;
          }
          if ((!bool) || (j == 0)) {
            break label822;
          }
          j = localRect.height();
          localRect.top -= j;
          localRect.bottom -= j;
          j = 0;
          layoutDecorated(localView, localRect.left, localRect.top, localRect.right, localRect.bottom);
          n = a(n, localRect, (c)localObject2);
          k += 1;
        }
        localObject3 = new c();
        n = 0;
        j = m;
        m = k;
      } while (n > i3 - 1);
      View localView = paramn.gb(n);
      boolean bool = a(localView, i1, 0, k, (c)localObject2, localRect, (c)localObject3);
      this.BcJ.a(n, new Point(localRect.width(), localRect.height()));
      addView(localView, ((List)localObject1).size());
      if (bool) {
        ((c)localObject3).BcT = 0;
      }
      if ((bool) && (j == 0))
      {
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext()) {
          removeAndRecycleView((View)localIterator.next(), paramn);
        }
        ((List)localObject1).clear();
        i1 = a(edq().x, localRect, (c)localObject2);
        k = localRect.height();
        ((c)localObject2).BcX = 1;
        m = j;
        j = i1;
      }
      for (;;)
      {
        ((List)localObject1).add(localView);
        n += 1;
        i1 = j;
        j = m;
        break;
        j = a(i1, localRect, (c)localObject2);
        k = Math.max(k, localRect.height());
        m = 0;
        ((c)localObject2).BcX += 1;
      }
      j = getDecoratedMeasuredHeight(getChildAt(NO(0))) + i;
      i = j;
    } while (j < Math.abs(paramInt));
    for (;;)
    {
      i = paramInt;
      if (j < Math.abs(paramInt)) {
        i = -j;
      }
      offsetChildrenVertical(-i);
      while (!NQ(getChildCount() - 1)) {
        c(getChildCount() - 1, paramn);
      }
      this.BcE = NP(0);
      AppMethodBeat.o(363639);
      return i;
      label822:
      break;
      label825:
      j = i;
    }
  }
  
  private void b(RecyclerView.n paramn)
  {
    AppMethodBeat.i(363621);
    detachAndScrapAttachedViews(paramn);
    Object localObject1 = edq();
    int k = ((Point)localObject1).x;
    int n = ((Point)localObject1).y;
    int i2 = getItemCount();
    int j = 0;
    localObject1 = new Rect();
    c localc = c.b(this.BcG);
    int i = 1;
    c localc1 = new c();
    this.BcL = 0;
    int m = this.BcE;
    if (m < i2)
    {
      Object localObject2 = paramn.gb(m);
      boolean bool2 = a((View)localObject2, k, n, j, localc, (Rect)localObject1, localc1);
      if (bool2) {
        localc1.BcT = 0;
      }
      if ((!bool2) || (i < this.maxLines))
      {
        if (this.mkw.getLayoutParams().height == -2) {}
        for (boolean bool1 = true; !bool1; bool1 = Rect.intersects(new Rect(getPaddingLeft(), getPaddingTop(), edo(), edp()), (Rect)localObject1))
        {
          paramn.bH((View)localObject2);
          AppMethodBeat.o(363621);
          return;
        }
        this.BcL += 1;
        addView((View)localObject2);
        layoutDecorated((View)localObject2, ((Rect)localObject1).left, ((Rect)localObject1).top, ((Rect)localObject1).right, ((Rect)localObject1).bottom);
        this.BcJ.a(m, new Point(((Rect)localObject1).width(), ((Rect)localObject1).height()));
        if (bool2)
        {
          k = i + 1;
          localObject2 = a((Rect)localObject1, c.b(this.BcG));
          i = ((Point)localObject2).x;
          n = ((Point)localObject2).y;
          j = ((Rect)localObject1).height();
          localc.BcX = 1;
        }
        for (;;)
        {
          int i1 = m + 1;
          m = k;
          k = i;
          i = m;
          m = i1;
          break;
          i1 = a(k, (Rect)localObject1, localc);
          j = Math.max(j, ((Rect)localObject1).height());
          localc.BcX += 1;
          k = i;
          i = i1;
        }
      }
    }
    AppMethodBeat.o(363621);
  }
  
  private boolean b(int paramInt, c paramc)
  {
    AppMethodBeat.i(363742);
    if ((d.c(paramc.BcW)) && (paramc.BcX == paramc.BcW.BcV))
    {
      AppMethodBeat.o(363742);
      return true;
    }
    if ((getChildCount() == 0) || (paramInt == getChildCount() - 1))
    {
      AppMethodBeat.o(363742);
      return true;
    }
    boolean bool = a(paramInt + 1, paramc);
    AppMethodBeat.o(363742);
    return bool;
  }
  
  private static int bA(View paramView)
  {
    AppMethodBeat.i(363674);
    if (paramView == null)
    {
      AppMethodBeat.o(363674);
      return -1;
    }
    int i = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bXh.KJ();
    AppMethodBeat.o(363674);
    return i;
  }
  
  private int c(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(363711);
    paramInt = a(paramInt, paramRect, c.b(this.BcG));
    AppMethodBeat.o(363711);
    return paramInt;
  }
  
  private void c(int paramInt, RecyclerView.n paramn)
  {
    AppMethodBeat.i(363685);
    while (!NR(paramInt)) {
      paramInt -= 1;
    }
    Object localObject = new LinkedList();
    ((List)localObject).add(getChildAt(paramInt));
    paramInt += 1;
    while ((paramInt < getChildCount()) && (!NR(paramInt)))
    {
      ((List)localObject).add(getChildAt(paramInt));
      paramInt += 1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      removeAndRecycleView((View)((Iterator)localObject).next(), paramn);
    }
    AppMethodBeat.o(363685);
  }
  
  private int edo()
  {
    AppMethodBeat.i(363646);
    int i = getWidth();
    int j = getPaddingRight();
    AppMethodBeat.o(363646);
    return i - j;
  }
  
  private int edp()
  {
    AppMethodBeat.i(363651);
    int i = getHeight();
    int j = getPaddingBottom();
    AppMethodBeat.o(363651);
    return i - j;
  }
  
  private Point edq()
  {
    AppMethodBeat.i(363720);
    Point localPoint = this.BcI.a(c.b(this.BcG));
    AppMethodBeat.o(363720);
    return localPoint;
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    AppMethodBeat.i(363794);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(363794);
      return false;
    }
    View localView1 = getChildAt(0);
    View localView2 = getChildAt(getChildCount() - 1);
    View localView3 = getChildAt(NO(0));
    View localView4 = getChildAt(NO(getChildCount() - 1));
    if ((bA(localView1) == 0) && (getDecoratedTop(localView3) >= getPaddingTop())) {}
    for (int i = 1;; i = 0)
    {
      if ((bA(localView2) == this.mkw.getAdapter().getItemCount() - 1) && (getDecoratedBottom(localView4) <= edp())) {}
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (j == 0))
        {
          AppMethodBeat.o(363794);
          return true;
        }
        AppMethodBeat.o(363794);
        return false;
      }
    }
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(363763);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(363763);
    return localLayoutParams;
  }
  
  public void onAdapterChanged(RecyclerView.a parama1, RecyclerView.a parama2)
  {
    AppMethodBeat.i(363902);
    if ((parama1 != null) && (this.BcK.isRegistered)) {}
    try
    {
      this.BcK.isRegistered = false;
      parama1.b(this.BcK);
      label36:
      if (parama2 != null)
      {
        this.BcK.isRegistered = true;
        parama2.a(this.BcK);
      }
      removeAllViews();
      AppMethodBeat.o(363902);
      return;
    }
    catch (IllegalStateException parama1)
    {
      break label36;
    }
  }
  
  public void onAttachedToWindow(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(363866);
    super.onAttachedToWindow(paramRecyclerView);
    this.mkw = paramRecyclerView;
    this.BcI = new d(this, this.mkw);
    this.BcJ = new a(this.BcG.BcV, this.BcI.edr());
    if (this.BcI.edr() == 0)
    {
      if (this.aRD == null) {
        this.aRD = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(363613);
            paramRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            FlowLayoutManager.a(FlowLayoutManager.this);
            FlowLayoutManager.this.BcJ.NX(FlowLayoutManager.this.BcI.edr());
            AppMethodBeat.o(363613);
          }
        };
      }
      paramRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.aRD);
    }
    AppMethodBeat.o(363866);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(363870);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.aRD != null)
    {
      paramRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.aRD);
      this.aRD = null;
    }
    AppMethodBeat.o(363870);
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363824);
    a locala = this.BcJ;
    if (locala.boj())
    {
      locala.NY(paramInt1);
      int i = locala.Bdi.size() - 1;
      while (i >= paramInt1)
      {
        locala.Bdi.put(i + paramInt2, (Point)locala.Bdi.get(i));
        i -= 1;
      }
      i = paramInt1;
      while (i < paramInt1 + paramInt2)
      {
        locala.Bdi.remove(i);
        i += 1;
      }
      locala.eds();
    }
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    AppMethodBeat.o(363824);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(363818);
    this.BcG = b.a(this.BcH);
    if (this.BcJ != null)
    {
      a locala = this.BcJ;
      locala.Bdi.clear();
      locala.Bdj.clear();
    }
    this.BcJ = new a(this.BcG.BcV, this.BcI.edr());
    super.onItemsChanged(paramRecyclerView);
    AppMethodBeat.o(363818);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(363860);
    a locala = this.BcJ;
    Point[] arrayOfPoint;
    int i;
    int j;
    int k;
    if (locala.boj())
    {
      locala.NY(Math.min(paramInt1, paramInt2));
      arrayOfPoint = new Point[paramInt3];
      i = paramInt1;
      while (i < paramInt1 + paramInt3)
      {
        arrayOfPoint[(i - paramInt1)] = ((Point)locala.Bdi.get(i));
        i += 1;
      }
      if (paramInt1 - paramInt2 > 0)
      {
        j = 1;
        k = Math.abs(paramInt1 - paramInt2);
        if (j != 0) {
          break label291;
        }
        k -= paramInt3;
      }
    }
    label291:
    for (;;)
    {
      if (j != 0)
      {
        i = paramInt1 - 1;
        label117:
        if (j == 0) {
          break label203;
        }
      }
      label203:
      for (int m = -1;; m = 1)
      {
        int i1 = 0;
        int n = i;
        i = i1;
        while (i < k)
        {
          locala.Bdi.put(n - m * paramInt3, (Point)locala.Bdi.get(n));
          n += m;
          i += 1;
        }
        j = 0;
        break;
        i = paramInt1 + paramInt3;
        break label117;
      }
      if (j == 0) {}
      for (i = paramInt1 + k;; i = paramInt2)
      {
        j = 0;
        while (j < paramInt3)
        {
          Point localPoint = arrayOfPoint[j];
          locala.Bdi.put(i, localPoint);
          j += 1;
          i += 1;
        }
        locala.eds();
        super.onItemsMoved(paramRecyclerView, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(363860);
        return;
      }
    }
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363835);
    Object localObject = this.BcJ;
    if (((a)localObject).boj())
    {
      ((a)localObject).NY(paramInt1);
      int j = ((a)localObject).hx(paramInt1, paramInt2);
      int i = 0;
      while (i < j)
      {
        ((a)localObject).Bdi.remove(paramInt1 + i);
        i += 1;
      }
      i = paramInt1 + j;
      while (i < ((a)localObject).Bdi.size() + j)
      {
        Point localPoint = (Point)((a)localObject).Bdi.get(i);
        ((a)localObject).Bdi.remove(i);
        ((a)localObject).Bdi.put(i - j, localPoint);
        i += 1;
      }
      ((a)localObject).eds();
    }
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
    localObject = this.BcK;
    ((e)localObject).BcY.postOnAnimation(new e.1((e)localObject, paramRecyclerView));
    AppMethodBeat.o(363835);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363845);
    this.BcJ.hw(paramInt1, paramInt2);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    AppMethodBeat.o(363845);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(363852);
    this.BcJ.hw(paramInt1, paramInt2);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2, paramObject);
    AppMethodBeat.o(363852);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(363783);
    if ((!this.BcJ.boj()) && (getChildCount() != 0))
    {
      AppMethodBeat.o(363783);
      return;
    }
    if (this.BcJ.Bdh != this.BcI.edr()) {
      this.BcJ.NX(this.BcI.edr());
    }
    this.BcF = paramn;
    int j;
    if (params.caw)
    {
      j = NP(0);
      if (j == -1) {
        detachAndScrapAttachedViews(paramn);
      }
    }
    for (;;)
    {
      if (!params.cay)
      {
        paramn = this.BcK;
        paramn.Bdb = paramn.BcY.getWidth();
        paramn.Bdd = paramn.BcY.getHeight();
      }
      AppMethodBeat.o(363783);
      return;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      Object localObject = this.BcI.a(c.b(this.BcG));
      int i1 = ((Point)localObject).x;
      j = ((Point)localObject).y;
      int n = 0;
      int i5 = ((Point)localObject).x;
      int i3 = ((Point)localObject).y;
      int i4 = 0;
      localObject = new Rect();
      Rect localRect = new Rect();
      detachAndScrapAttachedViews(paramn);
      c localc1 = c.b(this.BcG);
      c localc2 = new c();
      localc2.BcX = localc1.BcX;
      localc2.BcW = b.a(localc1.BcW);
      localc2.BcW.BcV = this.BcH.BcV;
      c localc3 = new c();
      c localc4 = new c();
      int k = 1;
      int i2 = i;
      i = j;
      View localView;
      boolean bool2;
      label419:
      int m;
      int i6;
      if (i2 < params.getItemCount())
      {
        localView = paramn.gb(i2);
        bool2 = ((RecyclerView.LayoutParams)localView.getLayoutParams()).bXh.isRemoved();
        bool1 = a(localView, i1, i, n, localc1, (Rect)localObject, localc3);
        if ((!bool1) || (k < this.maxLines))
        {
          if (!bool1) {
            break label557;
          }
          i1 = k + 1;
          Point localPoint = a((Rect)localObject, localc1);
          i = localPoint.x;
          k = localPoint.y;
          n = ((Rect)localObject).height();
          localc1.BcX = 1;
          localc3.BcT = 0;
          m = i5;
          i6 = i3;
          j = i4;
          if (!bool2)
          {
            if (!a(localView, i5, i3, i4, localc2, localRect, localc4)) {
              break label605;
            }
            localPoint = a(localRect, localc2);
            m = localPoint.x;
            i6 = localPoint.y;
            j = localRect.height();
            localc2.BcX = 1;
            localc4.BcT = 0;
          }
          label500:
          i3 = ((Rect)localObject).width();
          i4 = ((Rect)localObject).height();
          if (this.mkw.getLayoutParams().height != -2) {
            break label647;
          }
        }
      }
      label647:
      for (boolean bool1 = true;; bool1 = Rect.intersects(new Rect(getPaddingLeft(), getPaddingTop(), edo(), edp()), new Rect(m, i6, i3 + m, i4 + i6)))
      {
        if (bool1) {
          break label699;
        }
        paramn.bH(localView);
        this.BcG = b.a(this.BcH);
        break;
        label557:
        j = a(i1, (Rect)localObject, localc1);
        n = Math.max(n, ((Rect)localObject).height());
        localc1.BcX += 1;
        i1 = k;
        k = i;
        i = j;
        break label419;
        label605:
        m = a(i5, localRect, localc2);
        j = Math.max(i4, localRect.height());
        localc2.BcX += 1;
        i6 = i3;
        break label500;
      }
      label699:
      if (bool2) {
        addDisappearingView(localView);
      }
      for (;;)
      {
        layoutDecorated(localView, ((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
        i3 = i1;
        i2 += 1;
        i1 = i;
        i = k;
        k = i3;
        i5 = m;
        i3 = i6;
        i4 = j;
        break;
        addView(localView);
      }
      this.BcJ.Bdk = true;
      b(paramn);
      paramn = this.BcJ;
      paramn.Bdk = false;
      paramn.Bdj.clear();
      paramn.eds();
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(363878);
    this.BcE = paramInt;
    requestLayout();
    AppMethodBeat.o(363878);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(363811);
    if (paramInt == 0)
    {
      AppMethodBeat.o(363811);
      return 0;
    }
    if (getItemCount() == 0)
    {
      AppMethodBeat.o(363811);
      return 0;
    }
    params = getChildAt(0);
    Object localObject1 = getChildAt(getChildCount() - 1);
    Object localObject2 = getChildAt(NO(0));
    View localView = getChildAt(NO(getChildCount() - 1));
    int j = 0;
    int k = 0;
    int i = j;
    if (bA(params) == 0)
    {
      i = j;
      if (getDecoratedTop((View)localObject2) >= getPaddingTop()) {
        i = 1;
      }
    }
    j = k;
    if (bA((View)localObject1) == this.mkw.getAdapter().getItemCount() - 1)
    {
      j = k;
      if (getDecoratedBottom(localView) <= edp()) {
        j = 1;
      }
    }
    if ((paramInt > 0) && (j != 0))
    {
      AppMethodBeat.o(363811);
      return 0;
    }
    if ((paramInt < 0) && (i != 0))
    {
      AppMethodBeat.o(363811);
      return 0;
    }
    int m;
    if (paramInt > 0)
    {
      j = getDecoratedBottom(getChildAt(NO(getChildCount() - 1))) - edp();
      i = j;
      if (j >= paramInt)
      {
        offsetChildrenVertical(-paramInt);
        AppMethodBeat.o(363811);
        return paramInt;
      }
      for (;;)
      {
        if (NP(getChildCount() - 1) < getItemCount() - 1)
        {
          k = edq().x;
          int n = getDecoratedBottom(getChildAt(NO(getChildCount() - 1)));
          j = NP(getChildCount() - 1) + 1;
          if (j != getItemCount())
          {
            params = new Rect();
            localObject1 = c.b(this.BcG);
            localObject2 = new c();
            m = 1;
            if (j < getItemCount())
            {
              localView = paramn.gb(j);
              boolean bool = a(localView, k, n, 0, (c)localObject1, params, (c)localObject2);
              this.BcJ.a(j, new Point(params.width(), params.height()));
              if (bool) {
                ((c)localObject2).BcT = 0;
              }
              if ((!bool) || (m != 0)) {
                break;
              }
              paramn.bH(localView);
              ((c)localObject1).BcX = 1;
            }
          }
          j = getDecoratedMeasuredHeight(getChildAt(NO(getChildCount() - 1))) + i;
          i = j;
          if (j >= paramInt) {
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      j = paramInt;
      if (i < paramInt) {
        j = i;
      }
      offsetChildrenVertical(-j);
      for (;;)
      {
        if (!NQ(0))
        {
          c(0, paramn);
          continue;
          addView(localView);
          layoutDecorated(localView, params.left, params.top, params.right, params.bottom);
          k = a(k, params, (c)localObject1);
          ((c)localObject1).BcX += 1;
          m = 0;
          j += 1;
          break;
        }
      }
      this.BcE = NP(0);
      AppMethodBeat.o(363811);
      return j;
      paramInt = b(paramInt, paramn);
      AppMethodBeat.o(363811);
      return paramInt;
    }
  }
  
  public void setAutoMeasureEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(363890);
    super.setAutoMeasureEnabled(paramBoolean);
    AppMethodBeat.o(363890);
  }
  
  public void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363894);
    e locale = this.BcK;
    if (locale.BcZ) {
      locale.pyq = Math.max(paramInt1, locale.Bda.intValue());
    }
    for (locale.pyp = Math.max(paramInt2, locale.Bdc.intValue());; locale.pyp = paramInt2)
    {
      super.setMeasuredDimension(this.BcK.pyq, this.BcK.pyp);
      paramInt1 = this.BcK.pyp;
      if ((this.BcN != null) && (paramInt1 != this.BcO)) {
        this.mkw.post(new FlowLayoutManager.3(this, paramInt1));
      }
      AppMethodBeat.o(363894);
      return;
      locale.pyq = paramInt1;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(363883);
    paramRecyclerView = new o(paramRecyclerView.getContext())
    {
      public final PointF fM(int paramAnonymousInt)
      {
        AppMethodBeat.i(363619);
        Object localObject = FlowLayoutManager.this;
        localObject = new PointF(0.0F, FlowLayoutManager.a((FlowLayoutManager)localObject, paramAnonymousInt, ((FlowLayoutManager)localObject).BcF));
        AppMethodBeat.o(363619);
        return localObject;
      }
    };
    paramRecyclerView.cag = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(363883);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return true;
  }
  
  final class c
  {
    int BcT = 0;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.flow.FlowLayoutManager
 * JD-Core Version:    0.7.0.1
 */