package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.c;
import android.support.v4.view.t;
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
  boolean afF = false;
  int afG = -1;
  int[] afH;
  View[] afI;
  final SparseIntArray afJ = new SparseIntArray();
  final SparseIntArray afK = new SparseIntArray();
  public GridLayoutManager.b afL = new GridLayoutManager.a();
  final Rect afM = new Rect();
  
  public GridLayoutManager(int paramInt)
  {
    bE(paramInt);
  }
  
  public GridLayoutManager(int paramInt, byte paramByte)
  {
    super(1);
    bE(paramInt);
  }
  
  private int V(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (hE())) {
      return this.afH[(this.afG - paramInt1)] - this.afH[(this.afG - paramInt1 - paramInt2)];
    }
    return this.afH[(paramInt1 + paramInt2)] - this.afH[paramInt1];
  }
  
  private int a(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    if (!params.akg) {
      return this.afL.Y(paramInt, this.afG);
    }
    paramInt = paramo.ca(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.afL.Y(paramInt, this.afG);
  }
  
  private void a(RecyclerView.o paramo, RecyclerView.s params, int paramInt, boolean paramBoolean)
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
      View localView = this.afI[paramInt];
      GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.afO = c(paramo, params, bv(localView));
      localLayoutParams.afN = k;
      k += localLayoutParams.afO;
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
    for (paramBoolean = a(paramView, paramInt1, paramInt2, localLayoutParams);; paramBoolean = b(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private int b(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    int i;
    if (!params.akg) {
      i = this.afL.X(paramInt, this.afG);
    }
    int j;
    do
    {
      return i;
      j = this.afK.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.ca(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.afL.X(paramInt, this.afG);
  }
  
  private void b(View paramView, int paramInt, boolean paramBoolean)
  {
    GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.afM;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = V(localLayoutParams.afN, localLayoutParams.afO);
    if (this.mOrientation == 1)
    {
      i = c(k, paramInt, i, localLayoutParams.width, false);
      paramInt = c(this.agm.iK(), this.ajw, j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      return;
      paramInt = c(k, paramInt, j, localLayoutParams.height, false);
      i = c(this.agm.iK(), this.ajv, i, localLayoutParams.width, true);
    }
  }
  
  private void bD(int paramInt)
  {
    this.afH = d(this.afH, this.afG, paramInt);
  }
  
  private int c(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    int i;
    if (!params.akg) {
      i = this.afL.bF(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.afJ.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.ca(paramInt);
    if (paramInt == -1) {
      return 1;
    }
    return this.afL.bF(paramInt);
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
  
  private void ie()
  {
    if (getOrientation() == 1) {}
    for (int i = this.mWidth - getPaddingRight() - getPaddingLeft();; i = this.mHeight - getPaddingBottom() - getPaddingTop())
    {
      bD(i);
      return;
    }
  }
  
  private void jdMethod_if()
  {
    if ((this.afI == null) || (this.afI.length != this.afG)) {
      this.afI = new View[this.afG];
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    ie();
    jdMethod_if();
    return super.a(paramInt, paramo, params);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return this.afG;
    }
    if (params.getItemCount() <= 0) {
      return 0;
    }
    return a(paramo, params, params.getItemCount() - 1) + 1;
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new GridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  final View a(RecyclerView.o paramo, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    im();
    int j = this.agm.iI();
    int k = this.agm.iJ();
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
        break label164;
      }
      localView = getChildAt(paramInt1);
      int m = bv(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramo, params, m) != 0)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).ajy.isRemoved()) {
        break label120;
      }
      if (localObject2 != null) {
        break label179;
      }
      localObject2 = localView;
    }
    label164:
    label176:
    label179:
    for (;;)
    {
      paramInt1 += i;
      break label37;
      i = -1;
      break;
      label120:
      Object localObject3;
      if (this.agm.bh(localView) < k)
      {
        localObject3 = localView;
        if (this.agm.bi(localView) >= j) {}
      }
      else
      {
        if (localObject1 != null) {
          break label179;
        }
        localObject1 = localView;
        continue;
        if (localObject1 == null) {
          break label176;
        }
        localObject3 = localObject1;
      }
      return localObject3;
      return localObject2;
    }
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    View localView3 = bn(paramView);
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
    GridLayoutManager.LayoutParams localLayoutParams;
    int i9;
    int i10;
    do
    {
      return localView2;
      localObject = (GridLayoutManager.LayoutParams)localView3.getLayoutParams();
      i6 = ((GridLayoutManager.LayoutParams)localObject).afN;
      i7 = ((GridLayoutManager.LayoutParams)localObject).afN + ((GridLayoutManager.LayoutParams)localObject).afO;
      if (super.a(paramView, paramInt, paramo, params) == null) {
        return null;
      }
      int i12;
      int k;
      if (bK(paramInt) == 1)
      {
        i12 = 1;
        if (i12 == this.agp) {
          break label213;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label218;
        }
        paramInt = getChildCount() - 1;
        m = -1;
        k = -1;
        if ((this.mOrientation != 1) || (!hE())) {
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
        int i8 = a(paramo, params, paramInt);
        i1 = paramInt;
        if (i1 != k)
        {
          paramInt = a(paramo, params, i1);
          paramView = getChildAt(i1);
          if (paramView != localView3)
          {
            if ((!paramView.hasFocusable()) || (paramInt == i8)) {
              break label238;
            }
            if (localObject == null) {
              break label596;
            }
          }
        }
        if (localObject == null) {
          break label593;
        }
        return localObject;
        i12 = 0;
        break;
        paramInt = 0;
        break label85;
        paramInt = 0;
        m = 1;
        k = getChildCount();
        break label102;
      }
      localLayoutParams = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      i9 = localLayoutParams.afN;
      i10 = localLayoutParams.afN + localLayoutParams.afO;
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
        break label596;
      }
      if (!paramView.hasFocusable()) {
        break label564;
      }
      i2 = localLayoutParams.afN;
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
      int i11 = Math.min(i10, i7) - paramInt;
      if (paramView.hasFocusable())
      {
        if (i11 > i3)
        {
          paramInt = 1;
          break label320;
        }
        paramInt = i5;
        if (i11 != i3) {
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
      if ((this.ajm.bX(paramView)) && (this.ajn.bX(paramView)))
      {
        paramInt = 1;
        label485:
        if (paramInt != 0) {
          break label517;
        }
      }
      label517:
      for (int i4 = 1;; i4 = 0)
      {
        paramInt = i5;
        if (i4 == 0) {
          break;
        }
        if (i11 <= j) {
          break label523;
        }
        paramInt = 1;
        break;
        paramInt = 0;
        break label485;
      }
      label523:
      paramInt = i5;
      if (i11 != j) {
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
      label564:
      i = localLayoutParams.afN;
      paramInt = Math.min(i10, i7) - Math.max(i9, i6);
      localView1 = paramView;
      continue;
      label593:
      return localView1;
      label596:
      paramInt = j;
    }
  }
  
  public final void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.afH == null) {
      super.a(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = k(paramInt2, k + paramRect.height(), t.aa(this.adt));
      paramInt2 = k(paramInt1, j + this.afH[(this.afH.length - 1)], t.Z(this.adt));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = k(paramInt1, j + paramRect.width(), t.Z(this.adt));
      paramInt1 = k(paramInt2, k + this.afH[(this.afH.length - 1)], t.aa(this.adt));
      paramInt2 = i;
    }
  }
  
  public final void a(GridLayoutManager.b paramb)
  {
    this.afL = paramb;
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    super.a(paramo, params, parama, paramInt);
    ie();
    if ((params.getItemCount() > 0) && (!params.akg))
    {
      if (paramInt == 1) {}
      for (paramInt = i;; paramInt = 0)
      {
        i = b(paramo, params, parama.mPosition);
        if (paramInt == 0) {
          break;
        }
        while ((i > 0) && (parama.mPosition > 0))
        {
          parama.mPosition -= 1;
          i = b(paramo, params, parama.mPosition);
        }
      }
      int k = params.getItemCount();
      paramInt = parama.mPosition;
      while (paramInt < k - 1)
      {
        int j = b(paramo, params, paramInt + 1);
        if (j <= i) {
          break;
        }
        paramInt += 1;
        i = j;
      }
      parama.mPosition = paramInt;
    }
    jdMethod_if();
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.agm.iL();
    int j;
    int k;
    label38:
    boolean bool;
    label58:
    int n;
    if (i3 != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0) {
        break label212;
      }
      k = this.afH[this.afG];
      if (j != 0) {
        ie();
      }
      if (paramc.afU != 1) {
        break label218;
      }
      bool = true;
      m = 0;
      i = this.afG;
      n = m;
      if (!bool)
      {
        i = b(paramo, params, paramc.afT) + c(paramo, params, paramc.afT);
        n = m;
      }
    }
    int i1;
    label212:
    label218:
    Object localObject;
    for (;;)
    {
      if ((n >= this.afG) || (!paramc.b(params)) || (i <= 0)) {
        break label266;
      }
      m = paramc.afT;
      i1 = c(paramo, params, m);
      if (i1 > this.afG)
      {
        throw new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.afG + " spans.");
        j = 0;
        break;
        k = 0;
        break label38;
        bool = false;
        break label58;
      }
      i -= i1;
      if (i < 0) {
        break label266;
      }
      localObject = paramc.a(paramo);
      if (localObject == null) {
        break label266;
      }
      this.afI[n] = localObject;
      n += 1;
    }
    label266:
    if (n == 0)
    {
      paramb.mFinished = true;
      return;
    }
    int i = 0;
    float f1 = 0.0F;
    a(paramo, params, n, bool);
    int m = 0;
    label330:
    int i2;
    if (m < n)
    {
      paramo = this.afI[m];
      if (paramc.agI == null) {
        if (bool)
        {
          addView(paramo, -1);
          g(paramo, this.afM);
          b(paramo, i3, false);
          i2 = this.agm.bl(paramo);
          i1 = i;
          if (i2 > i) {
            i1 = i2;
          }
          params = (GridLayoutManager.LayoutParams)paramo.getLayoutParams();
          float f2 = this.agm.bm(paramo) * 1.0F / params.afO;
          if (f2 <= f1) {
            break label1152;
          }
          f1 = f2;
        }
      }
    }
    label549:
    label816:
    for (;;)
    {
      m += 1;
      i = i1;
      break;
      addView(paramo, 0);
      break label330;
      if (bool)
      {
        C(paramo, -1);
        break label330;
      }
      C(paramo, 0);
      break label330;
      if (j != 0)
      {
        bD(Math.max(Math.round(this.afG * f1), k));
        i = 0;
        k = 0;
        j = i;
        if (k >= n) {
          break label549;
        }
        paramo = this.afI[k];
        b(paramo, 1073741824, true);
        j = this.agm.bl(paramo);
        if (j <= i) {
          break label1149;
        }
        i = j;
      }
      label715:
      label1100:
      label1140:
      label1149:
      for (;;)
      {
        k += 1;
        break;
        j = i;
        i = 0;
        if (i < n)
        {
          paramo = this.afI[i];
          if (this.agm.bl(paramo) != j)
          {
            params = (GridLayoutManager.LayoutParams)paramo.getLayoutParams();
            localObject = params.afM;
            m = ((Rect)localObject).top + ((Rect)localObject).bottom + params.topMargin + params.bottomMargin;
            k = ((Rect)localObject).left;
            k = ((Rect)localObject).right + k + params.leftMargin + params.rightMargin;
            i1 = V(params.afN, params.afO);
            if (this.mOrientation != 1) {
              break label715;
            }
            k = c(i1, 1073741824, k, params.width, false);
          }
          for (m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);; m = c(i1, 1073741824, m, params.height, false))
          {
            a(paramo, k, m, true);
            i += 1;
            break;
            k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          }
        }
        paramb.agC = j;
        i1 = 0;
        m = 0;
        k = 0;
        if (this.mOrientation == 1) {
          if (paramc.mLayoutDirection == -1)
          {
            i = paramc.Fb;
            k = i - j;
            j = i1;
            i1 = 0;
            i2 = j;
            j = i;
            i = k;
            k = i2;
            if (i1 >= n) {
              break label1140;
            }
            paramo = this.afI[i1];
            params = (GridLayoutManager.LayoutParams)paramo.getLayoutParams();
            if (this.mOrientation != 1) {
              break label1100;
            }
            if (!hE()) {
              break label1052;
            }
            k = getPaddingLeft();
            m = this.afH[(this.afG - params.afN)] + k;
            i2 = m - this.agm.bm(paramo);
            k = i;
            i = i2;
          }
        }
        for (;;)
        {
          k(paramo, i, k, m, j);
          if ((params.ajy.isRemoved()) || (params.ajy.kb())) {
            paramb.agD = true;
          }
          paramb.TF |= paramo.hasFocusable();
          i2 = i1 + 1;
          i1 = k;
          k = i;
          i = i1;
          i1 = i2;
          break label816;
          k = paramc.Fb;
          i = j + k;
          j = i1;
          break;
          if (paramc.mLayoutDirection == -1)
          {
            m = paramc.Fb;
            j = m - j;
            i = 0;
            break;
          }
          i = paramc.Fb;
          m = i + j;
          i1 = 0;
          j = i;
          i = i1;
          break;
          m = getPaddingLeft() + this.afH[params.afN];
          i2 = this.agm.bm(paramo);
          k = i;
          i2 += m;
          i = m;
          m = i2;
          continue;
          i2 = getPaddingTop() + this.afH[params.afN];
          j = i2 + this.agm.bm(paramo);
          i = k;
          k = i2;
        }
        Arrays.fill(this.afI, null);
        return;
      }
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, b paramb)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof GridLayoutManager.LayoutParams))
    {
      super.a(paramView, paramb);
      return;
    }
    paramView = (GridLayoutManager.LayoutParams)localLayoutParams;
    int i = a(paramo, params, paramView.ajy.jM());
    if (this.mOrientation == 0)
    {
      j = paramView.afN;
      k = paramView.afO;
      if ((this.afG > 1) && (paramView.afO == this.afG)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramb.F(b.c.b(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.afN;
    int k = paramView.afO;
    boolean bool1 = bool2;
    if (this.afG > 1)
    {
      bool1 = bool2;
      if (paramView.afO == this.afG) {
        bool1 = true;
      }
    }
    paramb.F(b.c.b(i, 1, j, k, bool1));
  }
  
  public final void a(RecyclerView.s params)
  {
    super.a(params);
    this.afF = false;
  }
  
  final void a(RecyclerView.s params, LinearLayoutManager.c paramc, RecyclerView.i.a parama)
  {
    int j = this.afG;
    int i = 0;
    while ((i < this.afG) && (paramc.b(params)) && (j > 0))
    {
      int k = paramc.afT;
      parama.P(k, Math.max(0, paramc.agE));
      j -= this.afL.bF(k);
      paramc.afT += paramc.afU;
      i += 1;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    this.afL.afP.clear();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.afL.afP.clear();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.afL.afP.clear();
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    ie();
    jdMethod_if();
    return super.b(paramInt, paramo, params);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return this.afG;
    }
    if (params.getItemCount() <= 0) {
      return 0;
    }
    return a(paramo, params, params.getItemCount() - 1) + 1;
  }
  
  public final void bE(int paramInt)
  {
    if (paramInt == this.afG) {
      return;
    }
    this.afF = true;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(paramInt)));
    }
    this.afG = paramInt;
    this.afL.afP.clear();
    requestLayout();
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (params.akg)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.ajy.jM();
        this.afJ.put(k, localLayoutParams.afO);
        this.afK.put(k, localLayoutParams.afN);
        i += 1;
      }
    }
    super.c(paramo, params);
    this.afJ.clear();
    this.afK.clear();
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.afL.afP.clear();
  }
  
  public final RecyclerView.LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new GridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new GridLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.afL.afP.clear();
  }
  
  public final RecyclerView.LayoutParams ic()
  {
    if (this.mOrientation == 0) {
      return new GridLayoutManager.LayoutParams(-2, -1);
    }
    return new GridLayoutManager.LayoutParams(-1, -2);
  }
  
  public final int ig()
  {
    return this.afG;
  }
  
  public boolean ih()
  {
    return (this.agv == null) && (!this.afF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */