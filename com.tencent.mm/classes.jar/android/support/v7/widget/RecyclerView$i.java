package android.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.a.c;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class RecyclerView$i
{
  RecyclerView acI;
  u afB;
  private final bd.b agU = new RecyclerView.i.1(this);
  private final bd.b agV = new RecyclerView.i.2(this);
  bd agW = new bd(this.agU);
  bd agX = new bd(this.agV);
  RecyclerView.r agY;
  public boolean agZ = false;
  boolean aha = false;
  boolean ahb = true;
  boolean ahc = true;
  int ahd;
  boolean ahe;
  int ahf;
  int ahg;
  boolean hD = false;
  int mHeight;
  int mWidth;
  
  private void bO(int paramInt)
  {
    getChildAt(paramInt);
    this.afB.detachViewFromParent(paramInt);
  }
  
  public static int bl(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ahi.ic();
  }
  
  public static int bm(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).adx;
    int i = paramView.getMeasuredWidth();
    int j = localRect.left;
    return localRect.right + (i + j);
  }
  
  public static int bn(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).adx;
    int i = paramView.getMeasuredHeight();
    int j = localRect.top;
    return localRect.bottom + (i + j);
  }
  
  public static int bo(View paramView)
  {
    return paramView.getLeft() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).adx.left;
  }
  
  public static int bp(View paramView)
  {
    return paramView.getTop() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).adx.top;
  }
  
  public static int bq(View paramView)
  {
    int i = paramView.getRight();
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).adx.right + i;
  }
  
  public static int br(View paramView)
  {
    int i = paramView.getBottom();
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).adx.bottom + i;
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
            break label148;
          }
          if (paramInt2 == -2147483648) {
            break label139;
          }
          paramInt3 = i;
        } while (paramInt2 != 1073741824);
        label139:
        paramInt1 = -2147483648;
        paramInt3 = i;
      }
      else
      {
        label148:
        paramInt1 = 0;
        paramInt3 = 0;
      }
    }
  }
  
  public static void d(View paramView, Rect paramRect)
  {
    RecyclerView.e(paramView, paramRect);
  }
  
  public static void h(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.adx;
    paramView.layout(localRect.left + paramInt1 + localLayoutParams.leftMargin, localRect.top + paramInt2 + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
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
  
  static boolean l(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void removeViewAt(int paramInt)
  {
    if (getChildAt(paramInt) != null)
    {
      u localu = this.afB;
      paramInt = localu.bs(paramInt);
      View localView = localu.abh.getChildAt(paramInt);
      if (localView != null)
      {
        if (localu.abi.bu(paramInt)) {
          localu.aR(localView);
        }
        localu.abh.removeViewAt(paramInt);
      }
    }
  }
  
  public void N(int paramInt1, int paramInt2) {}
  
  public void O(int paramInt1, int paramInt2) {}
  
  public void P(int paramInt1, int paramInt2) {}
  
  public void Q(int paramInt1, int paramInt2) {}
  
  public void Q(String paramString)
  {
    if (this.acI != null) {
      this.acI.Q(paramString);
    }
  }
  
  public int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return 0;
  }
  
  public int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((this.acI == null) || (this.acI.Sw == null)) {}
    while (!gP()) {
      return 1;
    }
    return this.acI.Sw.getItemCount();
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
    paramo.bv(localView);
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = paramRect.width();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = paramRect.height();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    setMeasuredDimension(k(paramInt1, i + j + k, q.W(this.acI)), k(paramInt2, m + n + i1, q.X(this.acI)));
  }
  
  public void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, a parama)
  {
    int i;
    if (gP())
    {
      i = bl(paramView);
      if (!gO()) {
        break label48;
      }
    }
    label48:
    for (int j = bl(paramView);; j = 0)
    {
      parama.H(a.c.b(i, 1, j, 1, false));
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(RecyclerView.r paramr)
  {
    if ((this.agY != null) && (paramr != this.agY) && (this.agY.ahC)) {
      this.agY.stop();
    }
    this.agY = paramr;
    paramr = this.agY;
    paramr.acI = this.acI;
    paramr.afm = this;
    if (paramr.ahA == -1) {
      throw new IllegalArgumentException("Invalid target position");
    }
    paramr.acI.agu.ahA = paramr.ahA;
    paramr.ahC = true;
    paramr.ahB = true;
    int i = paramr.ahA;
    paramr.ahD = paramr.acI.afG.bC(i);
    paramr.acI.agr.hZ();
  }
  
  public void a(RecyclerView.s params) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt) {}
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo) {}
  
  public final void a(View paramView, RecyclerView.o paramo)
  {
    u localu = this.afB;
    int i = localu.abh.indexOfChild(paramView);
    if (i >= 0)
    {
      if (localu.abi.bu(i)) {
        localu.aR(paramView);
      }
      localu.abh.removeViewAt(i);
    }
    paramo.bv(paramView);
  }
  
  public boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams != null;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    int[] arrayOfInt = new int[2];
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
    if (q.Q(this.acI) == 1) {
      if (k != 0)
      {
        i = k;
        if (j == 0) {
          break label271;
        }
        label162:
        arrayOfInt[0] = i;
        arrayOfInt[1] = j;
        j = arrayOfInt[0];
        k = arrayOfInt[1];
        if (paramBoolean2)
        {
          paramView = paramRecyclerView.getFocusedChild();
          if (paramView != null) {
            break label286;
          }
          i = 0;
          label203:
          if (i == 0) {
            break label412;
          }
        }
        if ((j == 0) && (k == 0)) {
          break label412;
        }
        if (!paramBoolean1) {
          break label401;
        }
        paramRecyclerView.scrollBy(j, k);
      }
    }
    for (;;)
    {
      return true;
      i = Math.max(i, i5 - i3);
      break;
      if (i != 0) {
        break;
      }
      for (;;)
      {
        i = Math.min(i4 - i2, k);
      }
      label271:
      j = Math.min(n - m, i1);
      break label162;
      label286:
      i = getPaddingLeft();
      m = getPaddingTop();
      n = this.mWidth;
      i1 = getPaddingRight();
      i2 = this.mHeight;
      i3 = getPaddingBottom();
      paramRect = this.acI.ec;
      RecyclerView.e(paramView, paramRect);
      if ((paramRect.left - j >= n - i1) || (paramRect.right - j <= i) || (paramRect.top - k >= i2 - i3) || (paramRect.bottom - k <= m))
      {
        i = 0;
        break label203;
      }
      i = 1;
      break label203;
      label401:
      paramRecyclerView.smoothScrollBy(j, k);
    }
    label412:
    return false;
  }
  
  final boolean a(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (paramView.isLayoutRequested()) || (!this.ahb) || (!l(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!l(paramView.getHeight(), paramInt2, paramLayoutParams.height));
  }
  
  public final void af(boolean paramBoolean)
  {
    if (paramBoolean != this.ahc)
    {
      this.ahc = paramBoolean;
      this.ahd = 0;
      if (this.acI != null) {
        this.acI.afy.hW();
      }
    }
  }
  
  final void aq(int paramInt1, int paramInt2)
  {
    this.mWidth = View.MeasureSpec.getSize(paramInt1);
    this.ahf = View.MeasureSpec.getMode(paramInt1);
    if ((this.ahf == 0) && (!RecyclerView.afr)) {
      this.mWidth = 0;
    }
    this.mHeight = View.MeasureSpec.getSize(paramInt2);
    this.ahg = View.MeasureSpec.getMode(paramInt2);
    if ((this.ahg == 0) && (!RecyclerView.afr)) {
      this.mHeight = 0;
    }
  }
  
  final void ar(int paramInt1, int paramInt2)
  {
    int i5 = getChildCount();
    if (i5 == 0)
    {
      this.acI.af(paramInt1, paramInt2);
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
      Rect localRect = this.acI.ec;
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
    this.acI.ec.set(i3, k, n, j);
    a(this.acI.ec, paramInt1, paramInt2);
  }
  
  public final void as(int paramInt1, int paramInt2)
  {
    this.acI.af(paramInt1, paramInt2);
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return 0;
  }
  
  public int b(RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((this.acI == null) || (this.acI.Sw == null)) {}
    while (!gO()) {
      return 1;
    }
    return this.acI.Sw.getItemCount();
  }
  
  public final void b(RecyclerView.o paramo)
  {
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      RecyclerView.v localv = RecyclerView.bf(localView);
      if (!localv.ib())
      {
        if ((!localv.ij()) || (localv.isRemoved()) || (this.acI.Sw.agM)) {
          break label78;
        }
        removeViewAt(i);
        paramo.o(localv);
      }
      for (;;)
      {
        i -= 1;
        break;
        label78:
        bO(i);
        paramo.bx(localView);
        this.acI.afC.E(localv);
      }
    }
  }
  
  final void b(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    this.hD = false;
    a(paramRecyclerView, paramo);
  }
  
  final void b(View paramView, a parama)
  {
    RecyclerView.v localv = RecyclerView.bf(paramView);
    if ((localv != null) && (!localv.isRemoved()) && (!this.afB.aS(localv.aie))) {
      a(this.acI.afy, this.acI.agu, paramView, parama);
    }
  }
  
  public View bC(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      RecyclerView.v localv = RecyclerView.bf(localView);
      if ((localv != null) && (localv.ic() == paramInt) && (!localv.ib()) && ((this.acI.agu.ahQ) || (!localv.isRemoved()))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void bE(int paramInt) {}
  
  public void bP(int paramInt)
  {
    if (this.acI != null)
    {
      RecyclerView localRecyclerView = this.acI;
      int j = localRecyclerView.afB.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.afB.getChildAt(i).offsetLeftAndRight(paramInt);
        i += 1;
      }
    }
  }
  
  public void bQ(int paramInt)
  {
    if (this.acI != null)
    {
      RecyclerView localRecyclerView = this.acI;
      int j = localRecyclerView.afB.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.afB.getChildAt(i).offsetTopAndBottom(paramInt);
        i += 1;
      }
    }
  }
  
  public void bR(int paramInt) {}
  
  public final View bd(View paramView)
  {
    if (this.acI == null) {}
    do
    {
      return null;
      paramView = this.acI.bd(paramView);
    } while ((paramView == null) || (this.afB.aS(paramView)));
    return paramView;
  }
  
  final void c(RecyclerView.o paramo)
  {
    int j = paramo.ahr.size();
    int i = j - 1;
    while (i >= 0)
    {
      View localView = ((RecyclerView.v)paramo.ahr.get(i)).aie;
      RecyclerView.v localv = RecyclerView.bf(localView);
      if (!localv.ib())
      {
        localv.ag(false);
        if (localv.il()) {
          this.acI.removeDetachedView(localView, false);
        }
        if (this.acI.agf != null) {
          this.acI.agf.d(localv);
        }
        localv.ag(true);
        paramo.bw(localView);
      }
      i -= 1;
    }
    paramo.ahr.clear();
    if (paramo.ahs != null) {
      paramo.ahs.clear();
    }
    if (j > 0) {
      this.acI.invalidate();
    }
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params) {}
  
  final void c(View paramView, int paramInt, boolean paramBoolean)
  {
    RecyclerView.v localv1 = RecyclerView.bf(paramView);
    RecyclerView.LayoutParams localLayoutParams1;
    if ((paramBoolean) || (localv1.isRemoved()))
    {
      this.acI.afC.D(localv1);
      localLayoutParams1 = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localv1.ig()) && (!localv1.ie())) {
        break label128;
      }
      if (!localv1.ie()) {
        break label120;
      }
      localv1.jdMethod_if();
      label68:
      this.afB.a(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (localLayoutParams1.ahk)
      {
        localv1.aie.invalidate();
        localLayoutParams1.ahk = false;
      }
      return;
      this.acI.afC.E(localv1);
      break;
      label120:
      localv1.ih();
      break label68;
      label128:
      Object localObject;
      if (paramView.getParent() == this.acI)
      {
        int j = this.afB.indexOfChild(paramView);
        int i = paramInt;
        if (paramInt == -1) {
          i = this.afB.getChildCount();
        }
        if (j == -1) {
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.acI.indexOfChild(paramView) + this.acI.hl());
        }
        if (j != i)
        {
          paramView = this.acI.afG;
          localObject = paramView.getChildAt(j);
          if (localObject == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j + paramView.acI.toString());
          }
          paramView.bO(j);
          RecyclerView.LayoutParams localLayoutParams2 = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
          RecyclerView.v localv2 = RecyclerView.bf((View)localObject);
          if (localv2.isRemoved()) {
            paramView.acI.afC.D(localv2);
          }
          for (;;)
          {
            paramView.afB.a((View)localObject, i, localLayoutParams2, localv2.isRemoved());
            break;
            paramView.acI.afC.E(localv2);
          }
        }
      }
      else
      {
        this.afB.a(paramView, paramInt, false);
        localLayoutParams1.ahj = true;
        if ((this.agY != null) && (this.agY.ahC))
        {
          localObject = this.agY;
          if (RecyclerView.bh(paramView) == ((RecyclerView.r)localObject).ahA) {
            ((RecyclerView.r)localObject).ahD = paramView;
          }
        }
      }
    }
  }
  
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
      if (!RecyclerView.bf(getChildAt(i)).ib()) {
        a(i, paramo);
      }
      i -= 1;
    }
  }
  
  final void d(RecyclerView paramRecyclerView)
  {
    aq(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
  }
  
  public int e(RecyclerView.s params)
  {
    return 0;
  }
  
  public int f(RecyclerView.s params)
  {
    return 0;
  }
  
  public final void f(View paramView, Rect paramRect)
  {
    Object localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).adx;
    int i = -((Rect)localObject).left;
    int j = -((Rect)localObject).top;
    int k = paramView.getWidth();
    int m = ((Rect)localObject).right;
    int n = paramView.getHeight();
    paramRect.set(i, j, k + m, ((Rect)localObject).bottom + n);
    if (this.acI != null)
    {
      localObject = paramView.getMatrix();
      if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
      {
        RectF localRectF = this.acI.afF;
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
  
  public final void g(View paramView, Rect paramRect)
  {
    if (this.acI == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(this.acI.bi(paramView));
  }
  
  public void gI() {}
  
  public abstract RecyclerView.LayoutParams gJ();
  
  public boolean gM()
  {
    return false;
  }
  
  public boolean gN()
  {
    return this.aha;
  }
  
  public boolean gO()
  {
    return false;
  }
  
  public boolean gP()
  {
    return false;
  }
  
  boolean gT()
  {
    return false;
  }
  
  public final View getChildAt(int paramInt)
  {
    if (this.afB != null) {
      return this.afB.getChildAt(paramInt);
    }
    return null;
  }
  
  public final int getChildCount()
  {
    if (this.afB != null) {
      return this.afB.getChildCount();
    }
    return 0;
  }
  
  public final boolean getClipToPadding()
  {
    return (this.acI != null) && (this.acI.afD);
  }
  
  public final View getFocusedChild()
  {
    if (this.acI == null) {}
    View localView;
    do
    {
      return null;
      localView = this.acI.getFocusedChild();
    } while ((localView == null) || (this.afB.aS(localView)));
    return localView;
  }
  
  public final int getItemCount()
  {
    if (this.acI != null) {}
    for (RecyclerView.a locala = this.acI.getAdapter(); locala != null; locala = null) {
      return locala.getItemCount();
    }
    return 0;
  }
  
  public final int getPaddingBottom()
  {
    if (this.acI != null) {
      return this.acI.getPaddingBottom();
    }
    return 0;
  }
  
  public final int getPaddingLeft()
  {
    if (this.acI != null) {
      return this.acI.getPaddingLeft();
    }
    return 0;
  }
  
  public final int getPaddingRight()
  {
    if (this.acI != null) {
      return this.acI.getPaddingRight();
    }
    return 0;
  }
  
  public final int getPaddingTop()
  {
    if (this.acI != null) {
      return this.acI.getPaddingTop();
    }
    return 0;
  }
  
  public int h(RecyclerView.s params)
  {
    return 0;
  }
  
  public final boolean hR()
  {
    return (this.agY != null) && (this.agY.ahC);
  }
  
  final void hS()
  {
    if (this.agY != null) {
      this.agY.stop();
    }
  }
  
  public int i(RecyclerView.s params)
  {
    return 0;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = true;
    Object localObject = this.acI.afy;
    localObject = this.acI.agu;
    if ((this.acI == null) || (paramAccessibilityEvent == null)) {
      return;
    }
    boolean bool1 = bool2;
    if (!this.acI.canScrollVertically(1))
    {
      bool1 = bool2;
      if (!this.acI.canScrollVertically(-1))
      {
        bool1 = bool2;
        if (!this.acI.canScrollHorizontally(-1)) {
          if (!this.acI.canScrollHorizontally(1)) {
            break label114;
          }
        }
      }
    }
    label114:
    for (bool1 = bool2;; bool1 = false)
    {
      paramAccessibilityEvent.setScrollable(bool1);
      if (this.acI.Sw == null) {
        break;
      }
      paramAccessibilityEvent.setItemCount(this.acI.Sw.getItemCount());
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final boolean removeCallbacks(Runnable paramRunnable)
  {
    if (this.acI != null) {
      return this.acI.removeCallbacks(paramRunnable);
    }
    return false;
  }
  
  public final void requestLayout()
  {
    if (this.acI != null) {
      this.acI.requestLayout();
    }
  }
  
  public final void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    RecyclerView.c(this.acI, paramInt1, paramInt2);
  }
  
  final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      this.acI = null;
      this.afB = null;
      this.mWidth = 0;
    }
    for (this.mHeight = 0;; this.mHeight = paramRecyclerView.getHeight())
    {
      this.ahf = 1073741824;
      this.ahg = 1073741824;
      return;
      this.acI = paramRecyclerView;
      this.afB = paramRecyclerView.afB;
      this.mWidth = paramRecyclerView.getWidth();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.i
 * JD-Core Version:    0.7.0.1
 */