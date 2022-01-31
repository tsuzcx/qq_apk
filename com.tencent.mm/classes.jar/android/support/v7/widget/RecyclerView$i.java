package android.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.c;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class RecyclerView$i
{
  protected RecyclerView adt;
  s ahR;
  private final bf.b ajk = new RecyclerView.i.1(this);
  private final bf.b ajl = new RecyclerView.i.2(this);
  bf ajm = new bf(this.ajk);
  bf ajn = new bf(this.ajl);
  RecyclerView.r ajo;
  public boolean ajp = false;
  protected boolean ajq = false;
  protected boolean ajr = true;
  boolean ajs = true;
  int ajt;
  boolean aju;
  protected int ajv;
  protected int ajw;
  boolean iA = false;
  public int mHeight;
  public int mWidth;
  
  private void D(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    RecyclerView.v localv = RecyclerView.bp(paramView);
    if (localv.isRemoved()) {
      this.adt.ahS.J(localv);
    }
    for (;;)
    {
      this.ahR.a(paramView, paramInt, localLayoutParams, localv.isRemoved());
      return;
      this.adt.ahS.K(localv);
    }
  }
  
  private void a(RecyclerView.o paramo, int paramInt, View paramView)
  {
    RecyclerView.v localv = RecyclerView.bp(paramView);
    if (localv.jL()) {
      return;
    }
    if ((localv.jU()) && (!localv.isRemoved()) && (!this.adt.Tg.ajc))
    {
      removeViewAt(paramInt);
      paramo.s(localv);
      return;
    }
    bU(paramInt);
    paramo.bM(paramView);
    this.adt.ahS.K(localv);
  }
  
  private void ay(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1);
    if (localView == null) {
      throw new IllegalArgumentException("Cannot move a child from non-existing index:" + paramInt1 + this.adt.toString());
    }
    bU(paramInt1);
    D(localView, paramInt2);
  }
  
  public static int bA(View paramView)
  {
    return paramView.getTop() - bD(paramView);
  }
  
  public static int bB(View paramView)
  {
    return paramView.getRight() + bG(paramView);
  }
  
  public static int bC(View paramView)
  {
    return paramView.getBottom() + bE(paramView);
  }
  
  public static int bD(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM.top;
  }
  
  public static int bE(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM.bottom;
  }
  
  public static int bF(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM.left;
  }
  
  public static int bG(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM.right;
  }
  
  private void bU(int paramInt)
  {
    getChildAt(paramInt);
    this.ahR.detachViewFromParent(paramInt);
  }
  
  public static int bv(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ajy.jM();
  }
  
  public static int bx(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM;
    int i = paramView.getMeasuredWidth();
    int j = localRect.left;
    return localRect.right + (i + j);
  }
  
  public static int by(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM;
    int i = paramView.getMeasuredHeight();
    int j = localRect.top;
    return localRect.bottom + (i + j);
  }
  
  public static int bz(View paramView)
  {
    return paramView.getLeft() - bF(paramView);
  }
  
  public static int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = Math.max(0, paramInt1 - paramInt3);
    if (paramBoolean) {
      if (paramInt4 >= 0)
      {
        paramInt1 = 1073741824;
        paramInt3 = paramInt4;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
      if (paramInt4 == -1)
      {
        paramInt3 = i;
        paramInt1 = paramInt2;
        switch (paramInt2)
        {
        }
        paramInt1 = 0;
        paramInt3 = 0;
      }
      else if (paramInt4 == -2)
      {
        paramInt3 = 0;
        do
        {
          paramInt1 = 0;
          break;
          if (paramInt4 >= 0)
          {
            paramInt1 = 1073741824;
            paramInt3 = paramInt4;
            break;
          }
          paramInt3 = i;
          paramInt1 = paramInt2;
          if (paramInt4 == -1) {
            break;
          }
          if (paramInt4 != -2) {
            break label150;
          }
          if (paramInt2 == -2147483648) {
            break label140;
          }
          paramInt3 = i;
        } while (paramInt2 != 1073741824);
        label140:
        paramInt1 = -2147483648;
        paramInt3 = i;
      }
      else
      {
        label150:
        paramInt1 = 0;
        paramInt3 = 0;
      }
    }
  }
  
  private void c(View paramView, int paramInt, boolean paramBoolean)
  {
    RecyclerView.v localv = RecyclerView.bp(paramView);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramBoolean) || (localv.isRemoved()))
    {
      this.adt.ahS.J(localv);
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localv.jR()) && (!localv.jP())) {
        break label128;
      }
      if (!localv.jP()) {
        break label120;
      }
      localv.jQ();
      label68:
      this.ahR.a(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (localLayoutParams.ajA)
      {
        localv.aku.invalidate();
        localLayoutParams.ajA = false;
      }
      return;
      this.adt.ahS.K(localv);
      break;
      label120:
      localv.jS();
      break label68;
      label128:
      if (paramView.getParent() == this.adt)
      {
        int j = this.ahR.indexOfChild(paramView);
        int i = paramInt;
        if (paramInt == -1) {
          i = this.ahR.getChildCount();
        }
        if (j == -1) {
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.adt.indexOfChild(paramView) + this.adt.iM());
        }
        if (j != i) {
          this.adt.ahW.ay(j, i);
        }
      }
      else
      {
        this.ahR.a(paramView, paramInt, false);
        localLayoutParams.ajz = true;
        if ((this.ajo != null) && (this.ajo.ajS)) {
          this.ajo.bN(paramView);
        }
      }
    }
  }
  
  public static void d(View paramView, Rect paramRect)
  {
    RecyclerView.e(paramView, paramRect);
  }
  
  private boolean f(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = paramRecyclerView.getFocusedChild();
    if (paramRecyclerView == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    Rect localRect;
    do
    {
      return false;
      i = getPaddingLeft();
      j = getPaddingTop();
      k = this.mWidth;
      m = getPaddingRight();
      n = this.mHeight;
      i1 = getPaddingBottom();
      localRect = this.adt.mTempRect;
      RecyclerView.e(paramRecyclerView, localRect);
    } while ((localRect.left - paramInt1 >= k - m) || (localRect.right - paramInt1 <= i) || (localRect.top - paramInt2 >= n - i1) || (localRect.bottom - paramInt2 <= j));
    return true;
  }
  
  private int[] h(View paramView, Rect paramRect)
  {
    int i2 = getPaddingLeft();
    int m = getPaddingTop();
    int i3 = this.mWidth - getPaddingRight();
    int i1 = this.mHeight;
    int i6 = getPaddingBottom();
    int i4 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
    int n = paramView.getTop() + paramRect.top - paramView.getScrollY();
    int i5 = i4 + paramRect.width();
    int i7 = paramRect.height();
    int i = Math.min(0, i4 - i2);
    int j = Math.min(0, n - m);
    int k = Math.max(0, i5 - i3);
    i1 = Math.max(0, n + i7 - (i1 - i6));
    if (t.T(this.adt) == 1) {
      if (k != 0)
      {
        i = k;
        if (j == 0) {
          break label202;
        }
      }
    }
    for (;;)
    {
      return new int[] { i, j };
      i = Math.max(i, i5 - i3);
      break;
      if (i != 0) {
        break;
      }
      for (;;)
      {
        i = Math.min(i4 - i2, k);
      }
      label202:
      j = Math.min(n - m, i1);
    }
  }
  
  public static void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM;
    paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  public static int k(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = i;
    switch (j)
    {
    default: 
      paramInt1 = Math.max(paramInt2, paramInt3);
    case 1073741824: 
      return paramInt1;
    }
    return Math.min(i, Math.max(paramInt2, paramInt3));
  }
  
  public static void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.afM;
    paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
  }
  
  private static boolean l(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {}
    do
    {
      do
      {
        return false;
        switch (i)
        {
        default: 
          return false;
        }
      } while (paramInt2 < paramInt1);
      return true;
      return true;
    } while (paramInt2 != paramInt1);
    return true;
  }
  
  private void removeView(View paramView)
  {
    s locals = this.ahR;
    int i = locals.abS.indexOfChild(paramView);
    if (i >= 0)
    {
      if (locals.abT.bu(i)) {
        locals.aZ(paramView);
      }
      locals.abS.removeViewAt(i);
    }
  }
  
  private void removeViewAt(int paramInt)
  {
    if (getChildAt(paramInt) != null) {
      this.ahR.removeViewAt(paramInt);
    }
  }
  
  public final void C(View paramView, int paramInt)
  {
    c(paramView, paramInt, true);
  }
  
  public void S(String paramString)
  {
    if (this.adt != null) {
      this.adt.S(paramString);
    }
  }
  
  public int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return 0;
  }
  
  public int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((this.adt == null) || (this.adt.Tg == null)) {}
    while (!ik()) {
      return 1;
    }
    return this.adt.Tg.getItemCount();
  }
  
  public RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.i.a parama) {}
  
  public void a(int paramInt, RecyclerView.i.a parama) {}
  
  public final void a(int paramInt, RecyclerView.o paramo)
  {
    View localView = getChildAt(paramInt);
    removeViewAt(paramInt);
    paramo.bK(localView);
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = paramRect.width();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = paramRect.height();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    setMeasuredDimension(k(paramInt1, i + j + k, t.Z(this.adt)), k(paramInt2, m + n + i1, t.aa(this.adt)));
  }
  
  public void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, b paramb)
  {
    int i;
    if (ik())
    {
      i = bv(paramView);
      if (!ij()) {
        break label48;
      }
    }
    label48:
    for (int j = bv(paramView);; j = 0)
    {
      paramb.F(b.c.b(i, 1, j, 1, false));
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(RecyclerView.r paramr)
  {
    if ((this.ajo != null) && (paramr != this.ajo) && (this.ajo.ajS)) {
      this.ajo.stop();
    }
    this.ajo = paramr;
    paramr = this.ajo;
    paramr.adt = this.adt;
    paramr.ahB = this;
    if (paramr.ajQ == -1) {
      throw new IllegalArgumentException("Invalid target position");
    }
    paramr.adt.aiK.ajQ = paramr.ajQ;
    paramr.ajS = true;
    paramr.ajR = true;
    int i = paramr.ajQ;
    paramr.ajT = paramr.adt.ahW.bH(i);
    paramr.adt.aiH.jI();
  }
  
  public void a(RecyclerView.s params) {}
  
  public void a(RecyclerView paramRecyclerView) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    g(paramRecyclerView, paramInt1, paramInt2);
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo) {}
  
  final void a(View paramView, b paramb)
  {
    RecyclerView.v localv = RecyclerView.bp(paramView);
    if ((localv != null) && (!localv.isRemoved()) && (!this.ahR.ba(localv.aku))) {
      a(this.adt.ahO, this.adt.aiK, paramView, paramb);
    }
  }
  
  public final void a(View paramView, RecyclerView.o paramo)
  {
    removeView(paramView);
    paramo.bK(paramView);
  }
  
  public boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams != null;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    paramView = h(paramView, paramRect);
    int i = paramView[0];
    int j = paramView[1];
    if (paramBoolean2)
    {
      paramBoolean2 = bool;
      if (!f(paramRecyclerView, i, j)) {}
    }
    else if (i == 0)
    {
      paramBoolean2 = bool;
      if (j == 0) {}
    }
    else
    {
      if (!paramBoolean1) {
        break label74;
      }
      paramRecyclerView.scrollBy(i, j);
    }
    for (;;)
    {
      paramBoolean2 = true;
      return paramBoolean2;
      label74:
      paramRecyclerView.a(i, j, null);
    }
  }
  
  public boolean a(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  final boolean a(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (!this.ajr) || (!l(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!l(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
  }
  
  public final void addView(View paramView)
  {
    c(paramView, -1, false);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    c(paramView, paramInt, false);
  }
  
  public final void ao(boolean paramBoolean)
  {
    if (paramBoolean != this.ajs)
    {
      this.ajs = paramBoolean;
      this.ajt = 0;
      if (this.adt != null) {
        this.adt.ahO.jF();
      }
    }
  }
  
  final void aw(int paramInt1, int paramInt2)
  {
    this.mWidth = View.MeasureSpec.getSize(paramInt1);
    this.ajv = View.MeasureSpec.getMode(paramInt1);
    if ((this.ajv == 0) && (!RecyclerView.ahH)) {
      this.mWidth = 0;
    }
    this.mHeight = View.MeasureSpec.getSize(paramInt2);
    this.ajw = View.MeasureSpec.getMode(paramInt2);
    if ((this.ajw == 0) && (!RecyclerView.ahH)) {
      this.mHeight = 0;
    }
  }
  
  final void ax(int paramInt1, int paramInt2)
  {
    int i5 = getChildCount();
    if (i5 == 0)
    {
      this.adt.aj(paramInt1, paramInt2);
      return;
    }
    int i = 0;
    int j = -2147483648;
    int n = -2147483648;
    int k = 2147483647;
    int i3 = 2147483647;
    while (i < i5)
    {
      View localView = getChildAt(i);
      Rect localRect = this.adt.mTempRect;
      RecyclerView.e(localView, localRect);
      int m = i3;
      if (localRect.left < i3) {
        m = localRect.left;
      }
      int i1 = n;
      if (localRect.right > n) {
        i1 = localRect.right;
      }
      int i2 = k;
      if (localRect.top < k) {
        i2 = localRect.top;
      }
      int i4 = j;
      if (localRect.bottom > j) {
        i4 = localRect.bottom;
      }
      i += 1;
      i3 = m;
      n = i1;
      k = i2;
      j = i4;
    }
    this.adt.mTempRect.set(i3, k, n, j);
    a(this.adt.mTempRect, paramInt1, paramInt2);
  }
  
  public final void az(int paramInt1, int paramInt2)
  {
    this.adt.aj(paramInt1, paramInt2);
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return 0;
  }
  
  public int b(RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((this.adt == null) || (this.adt.Tg == null)) {}
    while (!ij()) {
      return 1;
    }
    return this.adt.Tg.getItemCount();
  }
  
  public final void b(RecyclerView.o paramo)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      a(paramo, i, getChildAt(i));
      i -= 1;
    }
  }
  
  final void b(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    this.iA = false;
    a(paramRecyclerView, paramo);
  }
  
  final boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (paramView.isLayoutRequested()) || (!this.ajr) || (!l(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!l(paramView.getHeight(), paramInt2, paramLayoutParams.height));
  }
  
  public View bH(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      RecyclerView.v localv = RecyclerView.bp(localView);
      if ((localv != null) && (localv.jM() == paramInt) && (!localv.jL()) && ((this.adt.aiK.akg) || (!localv.isRemoved()))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void bJ(int paramInt) {}
  
  public void bV(int paramInt)
  {
    if (this.adt != null)
    {
      RecyclerView localRecyclerView = this.adt;
      int j = localRecyclerView.ahR.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.ahR.getChildAt(i).offsetLeftAndRight(paramInt);
        i += 1;
      }
    }
  }
  
  public void bW(int paramInt)
  {
    if (this.adt != null)
    {
      RecyclerView localRecyclerView = this.adt;
      int j = localRecyclerView.ahR.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.ahR.getChildAt(i).offsetTopAndBottom(paramInt);
        i += 1;
      }
    }
  }
  
  public void bX(int paramInt) {}
  
  public final View bn(View paramView)
  {
    if (this.adt == null) {}
    do
    {
      return null;
      paramView = this.adt.bn(paramView);
    } while ((paramView == null) || (this.ahR.ba(paramView)));
    return paramView;
  }
  
  public final void bw(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = this.adt.bs(paramView);
    int k = localRect.left;
    int m = localRect.right;
    int i = localRect.top;
    int j = localRect.bottom;
    k = c(this.mWidth, this.ajv, k + m + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, ij());
    i = c(this.mHeight, this.ajw, j + i + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, ik());
    if (b(paramView, k, i, localLayoutParams)) {
      paramView.measure(k, i);
    }
  }
  
  final void c(RecyclerView.o paramo)
  {
    int j = paramo.ajH.size();
    int i = j - 1;
    while (i >= 0)
    {
      View localView = ((RecyclerView.v)paramo.ajH.get(i)).aku;
      RecyclerView.v localv = RecyclerView.bp(localView);
      if (!localv.jL())
      {
        localv.ap(false);
        if (localv.jW()) {
          this.adt.removeDetachedView(localView, false);
        }
        if (this.adt.aiv != null) {
          this.adt.aiv.d(localv);
        }
        localv.ap(true);
        paramo.bL(localView);
      }
      i -= 1;
    }
    paramo.ajH.clear();
    if (paramo.ajI != null) {
      paramo.ajI.clear();
    }
    if (j > 0) {
      this.adt.invalidate();
    }
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params) {}
  
  public void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public int d(RecyclerView.s params)
  {
    return 0;
  }
  
  public RecyclerView.LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
      return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new RecyclerView.LayoutParams(paramLayoutParams);
  }
  
  public final void d(RecyclerView.o paramo)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      if (!RecyclerView.bp(getChildAt(i)).jL()) {
        a(i, paramo);
      }
      i -= 1;
    }
  }
  
  public void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public int e(RecyclerView.s params)
  {
    return 0;
  }
  
  final void e(RecyclerView paramRecyclerView)
  {
    this.iA = true;
    f(paramRecyclerView);
  }
  
  public int f(RecyclerView.s params)
  {
    return 0;
  }
  
  public void f(RecyclerView paramRecyclerView) {}
  
  public final void f(View paramView, Rect paramRect)
  {
    Object localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).afM;
    int i = -((Rect)localObject).left;
    int j = -((Rect)localObject).top;
    int k = paramView.getWidth();
    int m = ((Rect)localObject).right;
    int n = paramView.getHeight();
    paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
    if (this.adt != null)
    {
      localObject = paramView.getMatrix();
      if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
      {
        RectF localRectF = this.adt.ahV;
        localRectF.set(paramRect);
        ((Matrix)localObject).mapRect(localRectF);
        paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
      }
    }
    paramRect.offset(paramView.getLeft(), paramView.getTop());
  }
  
  public int g(RecyclerView.s params)
  {
    return 0;
  }
  
  final void g(RecyclerView paramRecyclerView)
  {
    aw(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
  }
  
  public void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public final void g(View paramView, Rect paramRect)
  {
    if (this.adt == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(this.adt.bs(paramView));
  }
  
  public final View getChildAt(int paramInt)
  {
    if (this.ahR != null) {
      return this.ahR.getChildAt(paramInt);
    }
    return null;
  }
  
  public final int getChildCount()
  {
    if (this.ahR != null) {
      return this.ahR.getChildCount();
    }
    return 0;
  }
  
  public final boolean getClipToPadding()
  {
    return (this.adt != null) && (this.adt.ahT);
  }
  
  public final View getFocusedChild()
  {
    if (this.adt == null) {}
    View localView;
    do
    {
      return null;
      localView = this.adt.getFocusedChild();
    } while ((localView == null) || (this.ahR.ba(localView)));
    return localView;
  }
  
  public final int getHeight()
  {
    return this.mHeight;
  }
  
  public final int getItemCount()
  {
    if (this.adt != null) {}
    for (RecyclerView.a locala = this.adt.getAdapter(); locala != null; locala = null) {
      return locala.getItemCount();
    }
    return 0;
  }
  
  public int getPaddingBottom()
  {
    if (this.adt != null) {
      return this.adt.getPaddingBottom();
    }
    return 0;
  }
  
  public int getPaddingEnd()
  {
    if (this.adt != null) {
      return t.X(this.adt);
    }
    return 0;
  }
  
  public int getPaddingLeft()
  {
    if (this.adt != null) {
      return this.adt.getPaddingLeft();
    }
    return 0;
  }
  
  public int getPaddingRight()
  {
    if (this.adt != null) {
      return this.adt.getPaddingRight();
    }
    return 0;
  }
  
  public int getPaddingStart()
  {
    if (this.adt != null) {
      return t.W(this.adt);
    }
    return 0;
  }
  
  public int getPaddingTop()
  {
    if (this.adt != null) {
      return this.adt.getPaddingTop();
    }
    return 0;
  }
  
  public final int getWidth()
  {
    return this.mWidth;
  }
  
  public int h(RecyclerView.s params)
  {
    return 0;
  }
  
  public int i(RecyclerView.s params)
  {
    return 0;
  }
  
  public abstract RecyclerView.LayoutParams ic();
  
  public boolean ih()
  {
    return false;
  }
  
  public boolean ii()
  {
    return this.ajq;
  }
  
  public boolean ij()
  {
    return false;
  }
  
  public boolean ik()
  {
    return false;
  }
  
  boolean io()
  {
    return false;
  }
  
  public void jA() {}
  
  final void jB()
  {
    if (this.ajo != null) {
      this.ajo.stop();
    }
  }
  
  @Deprecated
  public final void jy()
  {
    this.ajq = true;
  }
  
  public final boolean jz()
  {
    return (this.ajo != null) && (this.ajo.ajS);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = true;
    if ((this.adt == null) || (paramAccessibilityEvent == null)) {
      return;
    }
    boolean bool1 = bool2;
    if (!this.adt.canScrollVertically(1))
    {
      bool1 = bool2;
      if (!this.adt.canScrollVertically(-1))
      {
        bool1 = bool2;
        if (!this.adt.canScrollHorizontally(-1)) {
          if (!this.adt.canScrollHorizontally(1)) {
            break label96;
          }
        }
      }
    }
    label96:
    for (bool1 = bool2;; bool1 = false)
    {
      paramAccessibilityEvent.setScrollable(bool1);
      if (this.adt.Tg == null) {
        break;
      }
      paramAccessibilityEvent.setItemCount(this.adt.Tg.getItemCount());
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final void removeAllViews()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      this.ahR.removeViewAt(i);
      i -= 1;
    }
  }
  
  public final boolean removeCallbacks(Runnable paramRunnable)
  {
    if (this.adt != null) {
      return this.adt.removeCallbacks(paramRunnable);
    }
    return false;
  }
  
  public final void requestLayout()
  {
    if (this.adt != null) {
      this.adt.requestLayout();
    }
  }
  
  public final void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    RecyclerView.e(this.adt, paramInt1, paramInt2);
  }
  
  final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      this.adt = null;
      this.ahR = null;
      this.mWidth = 0;
    }
    for (this.mHeight = 0;; this.mHeight = paramRecyclerView.getHeight())
    {
      this.ajv = 1073741824;
      this.ajw = 1073741824;
      return;
      this.adt = paramRecyclerView;
      this.ahR = paramRecyclerView.ahR;
      this.mWidth = paramRecyclerView.getWidth();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.i
 * JD-Core Version:    0.7.0.1
 */