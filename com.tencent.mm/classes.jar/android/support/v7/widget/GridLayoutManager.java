package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.c;
import android.support.v4.view.a.c.c;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  boolean apL = false;
  public int apM = -1;
  int[] apN;
  View[] apO;
  final SparseIntArray apP = new SparseIntArray();
  final SparseIntArray apQ = new SparseIntArray();
  public b apR = new GridLayoutManager.a();
  final Rect apS = new Rect();
  
  public GridLayoutManager(int paramInt)
  {
    bW(paramInt);
  }
  
  public GridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt2, false);
    bW(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    bW(getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).att);
  }
  
  private int Y(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (jH())) {
      return this.apN[(this.apM - paramInt1)] - this.apN[(this.apM - paramInt1 - paramInt2)];
    }
    return this.apN[(paramInt1 + paramInt2)] - this.apN[paramInt1];
  }
  
  private int a(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    if (!params.aue) {
      return this.apR.ac(paramInt, this.apM);
    }
    paramInt = paramn.co(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.apR.ac(paramInt, this.apM);
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.s params, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int i;
    int j;
    if (paramBoolean)
    {
      i = 1;
      int m = 0;
      j = paramInt;
      paramInt = m;
    }
    while (paramInt != j)
    {
      View localView = this.apO[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localLayoutParams.apU = c(paramn, params, getPosition(localView));
      localLayoutParams.apT = k;
      k += localLayoutParams.apU;
      paramInt += i;
      continue;
      paramInt -= 1;
      i = -1;
      j = -1;
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {}
    for (paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);; paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private int b(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    int i;
    if (!params.aue) {
      i = this.apR.ab(paramInt, this.apM);
    }
    int j;
    do
    {
      return i;
      j = this.apQ.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramn.co(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.apR.ab(paramInt, this.apM);
  }
  
  private void b(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.apS;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = Y(localLayoutParams.apT, localLayoutParams.apU);
    if (this.mOrientation == 1)
    {
      i = getChildMeasureSpec(k, paramInt, i, localLayoutParams.width, false);
      paramInt = getChildMeasureSpec(this.aqs.kJ(), getHeightMode(), j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      return;
      paramInt = getChildMeasureSpec(k, paramInt, j, localLayoutParams.height, false);
      i = getChildMeasureSpec(this.aqs.kJ(), getWidthMode(), i, localLayoutParams.width, true);
    }
  }
  
  private void bV(int paramInt)
  {
    this.apN = d(this.apN, this.apM, paramInt);
  }
  
  private int c(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    int i;
    if (!params.aue) {
      i = this.apR.bX(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.apP.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramn.co(paramInt);
    if (paramInt == -1) {
      return 1;
    }
    return this.apR.bX(paramInt);
  }
  
  private static int[] d(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 1;
    paramInt2 = 0;
    int j = 0;
    int k;
    if (i <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 <= 0) || (paramInt1 - paramInt2 >= n)) {
        break label109;
      }
      k = m + 1;
      paramInt2 -= paramInt1;
    }
    for (;;)
    {
      j += k;
      arrayOfInt[i] = j;
      i += 1;
      break;
      return arrayOfInt;
      label109:
      k = m;
    }
  }
  
  private void kg()
  {
    if (getOrientation() == 1) {}
    for (int i = getWidth() - getPaddingRight() - getPaddingLeft();; i = getHeight() - getPaddingBottom() - getPaddingTop())
    {
      bV(i);
      return;
    }
  }
  
  private void kh()
  {
    if ((this.apO == null) || (this.apO.length != this.apM)) {
      this.apO = new View[this.apM];
    }
  }
  
  final View a(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    km();
    int j = this.aqs.kH();
    int k = this.aqs.kI();
    int i;
    Object localObject1;
    Object localObject2;
    label37:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label165;
      }
      localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramn, params, m) != 0)) {
        break label180;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).atw.isRemoved()) {
        break label121;
      }
      if (localObject2 != null) {
        break label180;
      }
      localObject2 = localView;
    }
    label165:
    label177:
    label180:
    for (;;)
    {
      paramInt1 += i;
      break label37;
      i = -1;
      break;
      label121:
      Object localObject3;
      if (this.aqs.bo(localView) < k)
      {
        localObject3 = localView;
        if (this.aqs.bp(localView) >= j) {}
      }
      else
      {
        if (localObject1 != null) {
          break label180;
        }
        localObject1 = localView;
        continue;
        if (localObject1 == null) {
          break label177;
        }
        localObject3 = localObject1;
      }
      return localObject3;
      return localObject2;
    }
  }
  
  public final void a(b paramb)
  {
    this.apR = paramb;
  }
  
  final void a(RecyclerView.n paramn, RecyclerView.s params, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    super.a(paramn, params, parama, paramInt);
    kg();
    if ((params.getItemCount() > 0) && (!params.aue))
    {
      if (paramInt == 1) {}
      for (paramInt = i;; paramInt = 0)
      {
        i = b(paramn, params, parama.mPosition);
        if (paramInt == 0) {
          break;
        }
        while ((i > 0) && (parama.mPosition > 0))
        {
          parama.mPosition -= 1;
          i = b(paramn, params, parama.mPosition);
        }
      }
      int k = params.getItemCount();
      paramInt = parama.mPosition;
      while (paramInt < k - 1)
      {
        int j = b(paramn, params, paramInt + 1);
        if (j <= i) {
          break;
        }
        paramInt += 1;
        i = j;
      }
      parama.mPosition = paramInt;
    }
    kh();
  }
  
  final void a(RecyclerView.n paramn, RecyclerView.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.aqs.kK();
    int j;
    int k;
    label38:
    boolean bool;
    label58:
    int i;
    int n;
    if (i3 != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0) {
        break label204;
      }
      k = this.apN[this.apM];
      if (j != 0) {
        kg();
      }
      if (paramc.aqa != 1) {
        break label210;
      }
      bool = true;
      i = this.apM;
      if (bool) {
        break label1114;
      }
      i = b(paramn, params, paramc.apZ) + c(paramn, params, paramc.apZ);
      n = 0;
    }
    label539:
    label1059:
    for (;;)
    {
      int i1;
      label204:
      label210:
      Object localObject;
      if ((n < this.apM) && (paramc.a(params)) && (i > 0))
      {
        m = paramc.apZ;
        i1 = c(paramn, params, m);
        if (i1 > this.apM)
        {
          throw new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.apM + " spans.");
          j = 0;
          break;
          k = 0;
          break label38;
          bool = false;
          break label58;
        }
        i -= i1;
        if (i >= 0)
        {
          localObject = paramc.a(paramn);
          if (localObject != null)
          {
            this.apO[n] = localObject;
            n += 1;
            continue;
          }
        }
      }
      if (n == 0)
      {
        paramb.mFinished = true;
        return;
      }
      i = 0;
      float f1 = 0.0F;
      a(paramn, params, n, bool);
      int m = 0;
      label321:
      int i2;
      if (m < n)
      {
        paramn = this.apO[m];
        if (paramc.aqO == null) {
          if (bool)
          {
            addView(paramn);
            calculateItemDecorationsForChild(paramn, this.apS);
            b(paramn, i3, false);
            i2 = this.aqs.bs(paramn);
            i1 = i;
            if (i2 > i) {
              i1 = i2;
            }
            params = (LayoutParams)paramn.getLayoutParams();
            float f2 = this.aqs.bt(paramn) * 1.0F / params.apU;
            if (f2 <= f1) {
              break label1111;
            }
            f1 = f2;
          }
        }
      }
      label705:
      label1099:
      label1108:
      label1111:
      for (;;)
      {
        m += 1;
        i = i1;
        break;
        addView(paramn, 0);
        break label321;
        if (bool)
        {
          addDisappearingView(paramn);
          break label321;
        }
        addDisappearingView(paramn, 0);
        break label321;
        if (j != 0)
        {
          bV(Math.max(Math.round(this.apM * f1), k));
          i = 0;
          k = 0;
          j = i;
          if (k >= n) {
            break label539;
          }
          paramn = this.apO[k];
          b(paramn, 1073741824, true);
          j = this.aqs.bs(paramn);
          if (j <= i) {
            break label1108;
          }
          i = j;
        }
        for (;;)
        {
          k += 1;
          break;
          j = i;
          i = 0;
          if (i < n)
          {
            paramn = this.apO[i];
            if (this.aqs.bs(paramn) != j)
            {
              params = (LayoutParams)paramn.getLayoutParams();
              localObject = params.apS;
              m = ((Rect)localObject).top + ((Rect)localObject).bottom + params.topMargin + params.bottomMargin;
              k = ((Rect)localObject).left;
              k = ((Rect)localObject).right + k + params.leftMargin + params.rightMargin;
              i1 = Y(params.apT, params.apU);
              if (this.mOrientation != 1) {
                break label705;
              }
              k = getChildMeasureSpec(i1, 1073741824, k, params.width, false);
            }
            for (m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);; m = getChildMeasureSpec(i1, 1073741824, m, params.height, false))
            {
              a(paramn, k, m, true);
              i += 1;
              break;
              k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
            }
          }
          paramb.aqI = j;
          k = 0;
          m = 0;
          i1 = 0;
          if (this.mOrientation == 1) {
            if (paramc.mLayoutDirection == -1)
            {
              i = paramc.fs;
              j = i - j;
              i1 = 0;
              i3 = k;
              k = i1;
              i1 = i;
              i2 = m;
              m = j;
              i = i3;
              if (k >= n) {
                break label1099;
              }
              paramn = this.apO[k];
              params = (LayoutParams)paramn.getLayoutParams();
              if (this.mOrientation != 1) {
                break label1059;
              }
              if (!jH()) {
                break label1023;
              }
              j = getPaddingLeft() + this.apN[(this.apM - params.apT)];
              i = j - this.aqs.bt(paramn);
            }
          }
          for (;;)
          {
            layoutDecoratedWithMargins(paramn, i, m, j, i1);
            if ((params.atw.isRemoved()) || (params.atw.mh())) {
              paramb.aqJ = true;
            }
            paramb.adH |= paramn.hasFocusable();
            k += 1;
            i2 = j;
            break label810;
            i1 = paramc.fs;
            i = j + i1;
            j = i1;
            break;
            if (paramc.mLayoutDirection == -1)
            {
              m = paramc.fs;
              k = m - j;
              i = 0;
              j = i1;
              break;
            }
            k = paramc.fs;
            m = k + j;
            i = 0;
            j = i1;
            break;
            label1023:
            i = getPaddingLeft();
            i = this.apN[params.apT] + i;
            j = i + this.aqs.bt(paramn);
            continue;
            j = getPaddingTop();
            m = this.apN[params.apT] + j;
            i1 = m + this.aqs.bt(paramn);
            j = i2;
          }
          Arrays.fill(this.apO, null);
          return;
        }
      }
      label810:
      label1114:
      n = 0;
    }
  }
  
  final void a(RecyclerView.s params, LinearLayoutManager.c paramc, RecyclerView.LayoutManager.a parama)
  {
    int j = this.apM;
    int i = 0;
    while ((i < this.apM) && (paramc.a(params)) && (j > 0))
    {
      int k = paramc.apZ;
      parama.S(k, Math.max(0, paramc.aqK));
      j -= this.apR.bX(k);
      paramc.apZ += paramc.aqa;
      i += 1;
    }
  }
  
  public final void an(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    super.an(false);
  }
  
  public final void bW(int paramInt)
  {
    if (paramInt == this.apM) {
      return;
    }
    this.apL = true;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(paramInt)));
    }
    this.apM = paramInt;
    this.apR.apV.clear();
    requestLayout();
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return this.apM;
    }
    if (params.getItemCount() <= 0) {
      return 0;
    }
    return a(paramn, params, params.getItemCount() - 1) + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return this.apM;
    }
    if (params.getItemCount() <= 0) {
      return 0;
    }
    return a(paramn, params, params.getItemCount() - 1) + 1;
  }
  
  public final b kf()
  {
    return this.apR;
  }
  
  public final int ki()
  {
    return this.apM;
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    View localView3 = findContainingItemView(paramView);
    View localView2;
    if (localView3 == null) {
      localView2 = null;
    }
    Object localObject;
    int i6;
    int i7;
    label85:
    int m;
    label102:
    int n;
    int i2;
    int i3;
    View localView1;
    int i;
    int j;
    int i1;
    label213:
    label218:
    label232:
    label238:
    LayoutParams localLayoutParams;
    int i9;
    int i10;
    do
    {
      return localView2;
      localObject = (LayoutParams)localView3.getLayoutParams();
      i6 = ((LayoutParams)localObject).apT;
      i7 = ((LayoutParams)localObject).apT + ((LayoutParams)localObject).apU;
      if (super.onFocusSearchFailed(paramView, paramInt, paramn, params) == null) {
        return null;
      }
      int i11;
      int k;
      if (cb(paramInt) == 1)
      {
        i11 = 1;
        if (i11 == this.aqv) {
          break label213;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label218;
        }
        paramInt = getChildCount() - 1;
        m = -1;
        k = -1;
        if ((this.mOrientation != 1) || (!jH())) {
          break label232;
        }
      }
      for (n = 1;; n = 0)
      {
        localObject = null;
        i2 = -1;
        i3 = 0;
        localView1 = null;
        i = -1;
        j = 0;
        int i8 = a(paramn, params, paramInt);
        i1 = paramInt;
        if (i1 != k)
        {
          paramInt = a(paramn, params, i1);
          paramView = getChildAt(i1);
          if (paramView != localView3)
          {
            if ((!paramView.hasFocusable()) || (paramInt == i8)) {
              break label238;
            }
            if (localObject == null) {
              break label559;
            }
          }
        }
        if (localObject == null) {
          break label556;
        }
        return localObject;
        i11 = 0;
        break;
        paramInt = 0;
        break label85;
        paramInt = 0;
        m = 1;
        k = getChildCount();
        break label102;
      }
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      i9 = localLayoutParams.apT;
      i10 = localLayoutParams.apT + localLayoutParams.apU;
      if ((!paramView.hasFocusable()) || (i9 != i6)) {
        break;
      }
      localView2 = paramView;
    } while (i10 == i7);
    int i5 = 0;
    if (((paramView.hasFocusable()) && (localObject == null)) || ((!paramView.hasFocusable()) && (localView1 == null)))
    {
      paramInt = 1;
      label320:
      if (paramInt == 0) {
        break label559;
      }
      if (!paramView.hasFocusable()) {
        break label527;
      }
      i2 = localLayoutParams.apT;
      i3 = Math.min(i10, i7) - Math.max(i9, i6);
      paramInt = j;
      localObject = paramView;
    }
    for (;;)
    {
      i1 += m;
      j = paramInt;
      break;
      paramInt = Math.max(i9, i6);
      int i4 = Math.min(i10, i7) - paramInt;
      if (paramView.hasFocusable())
      {
        if (i4 > i3)
        {
          paramInt = 1;
          break label320;
        }
        paramInt = i5;
        if (i4 != i3) {
          break label320;
        }
        if (i9 > i2) {}
        for (i4 = 1;; i4 = 0)
        {
          paramInt = i5;
          if (n != i4) {
            break;
          }
          paramInt = 1;
          break;
        }
      }
      paramInt = i5;
      if (localObject != null) {
        break label320;
      }
      paramInt = i5;
      if (!isViewPartiallyVisible(paramView, false, true)) {
        break label320;
      }
      if (i4 > j)
      {
        paramInt = 1;
        break label320;
      }
      paramInt = i5;
      if (i4 != j) {
        break label320;
      }
      if (i9 > i) {}
      for (i4 = 1;; i4 = 0)
      {
        paramInt = i5;
        if (n != i4) {
          break;
        }
        paramInt = 1;
        break;
      }
      label527:
      i = localLayoutParams.apT;
      paramInt = Math.min(i10, i7) - Math.max(i9, i6);
      localView1 = paramView;
      continue;
      label556:
      return localView1;
      label559:
      paramInt = j;
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, c paramc)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramc);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = a(paramn, params, paramView.atw.lQ());
    if (this.mOrientation == 0)
    {
      j = paramView.apT;
      k = paramView.apU;
      if ((this.apM > 1) && (paramView.apU == this.apM)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramc.H(c.c.a(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.apT;
    int k = paramView.apU;
    boolean bool1 = bool2;
    if (this.apM > 1)
    {
      bool1 = bool2;
      if (paramView.apU == this.apM) {
        bool1 = true;
      }
    }
    paramc.H(c.c.a(i, 1, j, k, bool1));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.apR.apV.clear();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.apR.apV.clear();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.apR.apV.clear();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.apR.apV.clear();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.apR.apV.clear();
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    if (params.aue)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.atw.lQ();
        this.apP.put(k, localLayoutParams.apU);
        this.apQ.put(k, localLayoutParams.apT);
        i += 1;
      }
    }
    super.onLayoutChildren(paramn, params);
    this.apP.clear();
    this.apQ.clear();
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    super.onLayoutCompleted(params);
    this.apL = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    kg();
    kh();
    return super.scrollHorizontallyBy(paramInt, paramn, params);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    kg();
    kh();
    return super.scrollVerticallyBy(paramInt, paramn, params);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.apN == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.apN[(this.apN.length - 1)], getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.apN[(this.apN.length - 1)], getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.aqB == null) && (!this.apL);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public int apT = -1;
    public int apU = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public final int kj()
    {
      return this.apT;
    }
    
    public final int kk()
    {
      return this.apU;
    }
  }
  
  public static abstract class b
  {
    final SparseIntArray apV = new SparseIntArray();
    private boolean apW = false;
    
    public int Z(int paramInt1, int paramInt2)
    {
      int n = bX(paramInt1);
      if (n == paramInt2) {
        return 0;
      }
      int j;
      int i;
      int k;
      if ((this.apW) && (this.apV.size() > 0))
      {
        j = this.apV.size() - 1;
        i = 0;
        while (i <= j)
        {
          k = i + j >>> 1;
          if (this.apV.keyAt(k) < paramInt1) {
            i = k + 1;
          } else {
            j = k - 1;
          }
        }
        i -= 1;
        if ((i >= 0) && (i < this.apV.size()))
        {
          i = this.apV.keyAt(i);
          if (i < 0) {
            break label216;
          }
          j = this.apV.get(i) + bX(i);
          k = i + 1;
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        label149:
        if (j < paramInt1)
        {
          k = bX(j);
          int m = i + k;
          if (m == paramInt2) {
            i = 0;
          }
          for (;;)
          {
            j += 1;
            break label149;
            i = -1;
            break;
            i = k;
            if (m <= paramInt2) {
              i = m;
            }
          }
        }
        if (i + n > paramInt2) {
          break;
        }
        return i;
        label216:
        j = 0;
        i = 0;
      }
    }
    
    final int ab(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.apW) {
        i = Z(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = this.apV.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = Z(paramInt1, paramInt2);
      this.apV.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public final int ac(int paramInt1, int paramInt2)
    {
      int n = bX(paramInt1);
      int k = 0;
      int i = 0;
      int j = 0;
      int m;
      if (k < paramInt1)
      {
        m = bX(k);
        j += m;
        if (j == paramInt2)
        {
          j = i + 1;
          i = 0;
        }
      }
      for (;;)
      {
        k += 1;
        m = i;
        i = j;
        j = m;
        break;
        if (j > paramInt2)
        {
          j = i + 1;
          i = m;
          continue;
          paramInt1 = i;
          if (j + n > paramInt2) {
            paramInt1 = i + 1;
          }
          return paramInt1;
        }
        else
        {
          m = j;
          j = i;
          i = m;
        }
      }
    }
    
    public abstract int bX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */