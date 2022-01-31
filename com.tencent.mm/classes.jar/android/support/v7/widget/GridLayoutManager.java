package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.a;
import android.support.v4.view.a.a.c;
import android.support.v4.view.q;
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
  boolean adq = false;
  int adr = -1;
  int[] ads;
  View[] adt;
  final SparseIntArray adu = new SparseIntArray();
  final SparseIntArray adv = new SparseIntArray();
  public GridLayoutManager.b adw = new GridLayoutManager.a();
  final Rect adx = new Rect();
  
  public GridLayoutManager()
  {
    super(1);
    bz(4);
  }
  
  public GridLayoutManager(int paramInt)
  {
    bz(paramInt);
  }
  
  private int R(int paramInt1, int paramInt2)
  {
    if ((this.adN == 1) && (gE())) {
      return this.ads[(this.adr - paramInt1)] - this.ads[(this.adr - paramInt1 - paramInt2)];
    }
    return this.ads[(paramInt1 + paramInt2)] - this.ads[paramInt1];
  }
  
  private int a(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    if (!params.ahQ) {
      return this.adw.U(paramInt, this.adr);
    }
    paramInt = paramo.bU(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.adw.U(paramInt, this.adr);
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
      View localView = this.adt[paramInt];
      GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.adz = c(paramo, params, bl(localView));
      localLayoutParams.ady = k;
      k += localLayoutParams.adz;
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
    if (paramBoolean) {
      if ((!this.ahb) || (!RecyclerView.i.l(paramView.getMeasuredWidth(), paramInt1, localLayoutParams.width)) || (!RecyclerView.i.l(paramView.getMeasuredHeight(), paramInt2, localLayoutParams.height))) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
      paramBoolean = false;
      continue;
      paramBoolean = a(paramView, paramInt1, paramInt2, localLayoutParams);
    }
  }
  
  private int b(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    int i;
    if (!params.ahQ) {
      i = this.adw.T(paramInt, this.adr);
    }
    int j;
    do
    {
      return i;
      j = this.adv.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.bU(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.adw.T(paramInt, this.adr);
  }
  
  private void b(View paramView, int paramInt, boolean paramBoolean)
  {
    GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.adx;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = R(localLayoutParams.ady, localLayoutParams.adz);
    if (this.adN == 1)
    {
      i = c(k, paramInt, i, localLayoutParams.width, false);
      paramInt = c(this.adZ.hj(), this.ahg, j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      return;
      paramInt = c(k, paramInt, j, localLayoutParams.height, false);
      i = c(this.adZ.hj(), this.ahf, i, localLayoutParams.width, true);
    }
  }
  
  private void by(int paramInt)
  {
    int[] arrayOfInt2 = this.ads;
    int n = this.adr;
    int[] arrayOfInt1;
    if ((arrayOfInt2 != null) && (arrayOfInt2.length == n + 1))
    {
      arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2[(arrayOfInt2.length - 1)] == paramInt) {}
    }
    else
    {
      arrayOfInt1 = new int[n + 1];
    }
    arrayOfInt1[0] = 0;
    int m = paramInt / n;
    int i1 = paramInt % n;
    int i = 1;
    paramInt = 0;
    int j = 0;
    int k;
    if (i <= n)
    {
      paramInt += i1;
      if ((paramInt <= 0) || (n - paramInt >= i1)) {
        break label133;
      }
      k = m + 1;
      paramInt -= n;
    }
    for (;;)
    {
      j += k;
      arrayOfInt1[i] = j;
      i += 1;
      break;
      this.ads = arrayOfInt1;
      return;
      label133:
      k = m;
    }
  }
  
  private void bz(int paramInt)
  {
    if (paramInt == this.adr) {
      return;
    }
    this.adq = true;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
    }
    this.adr = paramInt;
    this.adw.adA.clear();
    requestLayout();
  }
  
  private int c(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    int i;
    if (!params.ahQ) {
      i = this.adw.bA(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.adu.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.bU(paramInt);
    if (paramInt == -1) {
      return 1;
    }
    return this.adw.bA(paramInt);
  }
  
  private void gK()
  {
    if (this.adN == 1) {}
    for (int i = this.mWidth - getPaddingRight() - getPaddingLeft();; i = this.mHeight - getPaddingBottom() - getPaddingTop())
    {
      by(i);
      return;
    }
  }
  
  private void gL()
  {
    if ((this.adt == null) || (this.adt.length != this.adr)) {
      this.adt = new View[this.adr];
    }
  }
  
  public final void N(int paramInt1, int paramInt2)
  {
    this.adw.adA.clear();
  }
  
  public final void O(int paramInt1, int paramInt2)
  {
    this.adw.adA.clear();
  }
  
  public final void P(int paramInt1, int paramInt2)
  {
    this.adw.adA.clear();
  }
  
  public final void Q(int paramInt1, int paramInt2)
  {
    this.adw.adA.clear();
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    gK();
    gL();
    return super.a(paramInt, paramo, params);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.adN == 0) {
      return this.adr;
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
    gR();
    int j = this.adZ.hh();
    int k = this.adZ.hi();
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
      int m = bl(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramo, params, m) != 0)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).ahi.isRemoved()) {
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
      if (this.adZ.aX(localView) < k)
      {
        localObject3 = localView;
        if (this.adZ.aY(localView) >= j) {}
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
    View localView3 = bd(paramView);
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
      i6 = ((GridLayoutManager.LayoutParams)localObject).ady;
      i7 = ((GridLayoutManager.LayoutParams)localObject).ady + ((GridLayoutManager.LayoutParams)localObject).adz;
      if (super.a(paramView, paramInt, paramo, params) == null) {
        return null;
      }
      int i12;
      int k;
      if (bF(paramInt) == 1)
      {
        i12 = 1;
        if (i12 == this.aec) {
          break label213;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label218;
        }
        paramInt = getChildCount() - 1;
        m = -1;
        k = -1;
        if ((this.adN != 1) || (!gE())) {
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
      i9 = localLayoutParams.ady;
      i10 = localLayoutParams.ady + localLayoutParams.adz;
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
      i2 = localLayoutParams.ady;
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
      if ((this.agW.bE(paramView)) && (this.agX.bE(paramView)))
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
      i = localLayoutParams.ady;
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
    if (this.ads == null) {
      super.a(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.adN == 1)
    {
      i = k(paramInt2, k + paramRect.height(), q.X(this.acI));
      paramInt2 = k(paramInt1, j + this.ads[(this.ads.length - 1)], q.W(this.acI));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = k(paramInt1, j + paramRect.width(), q.W(this.acI));
      paramInt1 = k(paramInt2, k + this.ads[(this.ads.length - 1)], q.X(this.acI));
      paramInt2 = i;
    }
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    super.a(paramo, params, parama, paramInt);
    gK();
    if ((params.getItemCount() > 0) && (!params.ahQ))
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
    gL();
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.adZ.hk();
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
      k = this.ads[this.adr];
      if (j != 0) {
        gK();
      }
      if (paramc.adF != 1) {
        break label218;
      }
      bool = true;
      m = 0;
      i = this.adr;
      n = m;
      if (!bool)
      {
        i = b(paramo, params, paramc.adE) + c(paramo, params, paramc.adE);
        n = m;
      }
    }
    int i1;
    label212:
    label218:
    Object localObject;
    for (;;)
    {
      if ((n >= this.adr) || (!paramc.b(params)) || (i <= 0)) {
        break label266;
      }
      m = paramc.adE;
      i1 = c(paramo, params, m);
      if (i1 > this.adr)
      {
        throw new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.adr + " spans.");
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
      this.adt[n] = localObject;
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
    label331:
    int i2;
    if (m < n)
    {
      paramo = this.adt[m];
      if (paramc.aev == null) {
        if (bool)
        {
          super.c(paramo, -1, false);
          g(paramo, this.adx);
          b(paramo, i3, false);
          i2 = this.adZ.bb(paramo);
          i1 = i;
          if (i2 > i) {
            i1 = i2;
          }
          params = (GridLayoutManager.LayoutParams)paramo.getLayoutParams();
          float f2 = this.adZ.bc(paramo) * 1.0F / params.adz;
          if (f2 <= f1) {
            break label1156;
          }
          f1 = f2;
        }
      }
    }
    label1153:
    label1156:
    for (;;)
    {
      m += 1;
      i = i1;
      break;
      super.c(paramo, 0, false);
      break label331;
      if (bool)
      {
        super.c(paramo, -1, true);
        break label331;
      }
      super.c(paramo, 0, true);
      break label331;
      if (j != 0)
      {
        by(Math.max(Math.round(this.adr * f1), k));
        i = 0;
        k = 0;
        j = i;
        if (k >= n) {
          break label553;
        }
        paramo = this.adt[k];
        b(paramo, 1073741824, true);
        j = this.adZ.bb(paramo);
        if (j <= i) {
          break label1153;
        }
        i = j;
      }
      for (;;)
      {
        k += 1;
        break;
        j = i;
        label553:
        i = 0;
        if (i < n)
        {
          paramo = this.adt[i];
          if (this.adZ.bb(paramo) != j)
          {
            params = (GridLayoutManager.LayoutParams)paramo.getLayoutParams();
            localObject = params.adx;
            m = ((Rect)localObject).top + ((Rect)localObject).bottom + params.topMargin + params.bottomMargin;
            k = ((Rect)localObject).left;
            k = ((Rect)localObject).right + k + params.leftMargin + params.rightMargin;
            i1 = R(params.ady, params.adz);
            if (this.adN != 1) {
              break label719;
            }
            k = c(i1, 1073741824, k, params.width, false);
          }
          for (m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);; m = c(i1, 1073741824, m, params.height, false))
          {
            a(paramo, k, m, true);
            i += 1;
            break;
            label719:
            k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          }
        }
        paramb.aep = j;
        i1 = 0;
        m = 0;
        k = 0;
        if (this.adN == 1) {
          if (paramc.kO == -1)
          {
            i = paramc.El;
            k = i - j;
            j = i1;
            i1 = 0;
            i2 = j;
            j = i;
            i = k;
            k = i2;
            label820:
            if (i1 >= n) {
              break label1144;
            }
            paramo = this.adt[i1];
            params = (GridLayoutManager.LayoutParams)paramo.getLayoutParams();
            if (this.adN != 1) {
              break label1104;
            }
            if (!gE()) {
              break label1056;
            }
            k = getPaddingLeft();
            m = this.ads[(this.adr - params.ady)] + k;
            i2 = m - this.adZ.bc(paramo);
            k = i;
            i = i2;
          }
        }
        for (;;)
        {
          h(paramo, i, k, m, j);
          if ((params.ahi.isRemoved()) || (params.ahi.ip())) {
            paramb.aeq = true;
          }
          paramb.SV |= paramo.hasFocusable();
          i2 = i1 + 1;
          i1 = k;
          k = i;
          i = i1;
          i1 = i2;
          break label820;
          k = paramc.El;
          i = j + k;
          j = i1;
          break;
          if (paramc.kO == -1)
          {
            m = paramc.El;
            j = m - j;
            i = 0;
            break;
          }
          i = paramc.El;
          m = i + j;
          i1 = 0;
          j = i;
          i = i1;
          break;
          label1056:
          m = getPaddingLeft() + this.ads[params.ady];
          i2 = this.adZ.bc(paramo);
          k = i;
          i2 += m;
          i = m;
          m = i2;
          continue;
          label1104:
          i2 = getPaddingTop() + this.ads[params.ady];
          j = i2 + this.adZ.bc(paramo);
          i = k;
          k = i2;
        }
        label1144:
        Arrays.fill(this.adt, null);
        return;
      }
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, a parama)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof GridLayoutManager.LayoutParams))
    {
      super.b(paramView, parama);
      return;
    }
    paramView = (GridLayoutManager.LayoutParams)localLayoutParams;
    int i = a(paramo, params, paramView.ahi.ic());
    if (this.adN == 0)
    {
      j = paramView.ady;
      k = paramView.adz;
      if ((this.adr > 1) && (paramView.adz == this.adr)) {}
      for (bool1 = true;; bool1 = false)
      {
        parama.H(a.c.b(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.ady;
    int k = paramView.adz;
    boolean bool1 = bool2;
    if (this.adr > 1)
    {
      bool1 = bool2;
      if (paramView.adz == this.adr) {
        bool1 = true;
      }
    }
    parama.H(a.c.b(i, 1, j, k, bool1));
  }
  
  public final void a(RecyclerView.s params)
  {
    super.a(params);
    this.adq = false;
  }
  
  final void a(RecyclerView.s params, LinearLayoutManager.c paramc, RecyclerView.i.a parama)
  {
    int j = this.adr;
    int i = 0;
    while ((i < this.adr) && (paramc.b(params)) && (j > 0))
    {
      int k = paramc.adE;
      parama.M(k, Math.max(0, paramc.aer));
      j -= this.adw.bA(k);
      paramc.adE += paramc.adF;
      i += 1;
    }
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    gK();
    gL();
    return super.b(paramInt, paramo, params);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.adN == 1) {
      return this.adr;
    }
    if (params.getItemCount() <= 0) {
      return 0;
    }
    return a(paramo, params, params.getItemCount() - 1) + 1;
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (params.ahQ)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.ahi.ic();
        this.adu.put(k, localLayoutParams.adz);
        this.adv.put(k, localLayoutParams.ady);
        i += 1;
      }
    }
    super.c(paramo, params);
    this.adu.clear();
    this.adv.clear();
  }
  
  public final RecyclerView.LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new GridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new GridLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  public final void gI()
  {
    this.adw.adA.clear();
  }
  
  public final RecyclerView.LayoutParams gJ()
  {
    if (this.adN == 0) {
      return new GridLayoutManager.LayoutParams(-2, -1);
    }
    return new GridLayoutManager.LayoutParams(-1, -2);
  }
  
  public final boolean gM()
  {
    return (this.aei == null) && (!this.adq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */