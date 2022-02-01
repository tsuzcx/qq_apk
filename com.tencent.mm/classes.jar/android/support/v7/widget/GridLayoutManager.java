package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.c;
import android.support.v4.view.a.c.c;
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
  public int apA = -1;
  int[] apB;
  View[] apC;
  final SparseIntArray apD = new SparseIntArray();
  final SparseIntArray apE = new SparseIntArray();
  public b apF = new a();
  final Rect apG = new Rect();
  boolean apz = false;
  
  public GridLayoutManager(int paramInt)
  {
    bV(paramInt);
  }
  
  public GridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt2);
    bV(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    bV(c(paramContext, paramAttributeSet, paramInt1, paramInt2).atv);
  }
  
  private int Y(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (jy())) {
      return this.apB[(this.apA - paramInt1)] - this.apB[(this.apA - paramInt1 - paramInt2)];
    }
    return this.apB[(paramInt1 + paramInt2)] - this.apB[paramInt1];
  }
  
  private int a(RecyclerView.o paramo, RecyclerView.t paramt, int paramInt)
  {
    if (!paramt.aug) {
      return this.apF.ab(paramInt, this.apA);
    }
    paramInt = paramo.ct(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.apF.ab(paramInt, this.apA);
  }
  
  private void a(RecyclerView.o paramo, RecyclerView.t paramt, int paramInt, boolean paramBoolean)
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
      View localView = this.apC[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localLayoutParams.apI = c(paramo, paramt, bB(localView));
      localLayoutParams.apH = k;
      k += localLayoutParams.apI;
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
  
  private int b(RecyclerView.o paramo, RecyclerView.t paramt, int paramInt)
  {
    int i;
    if (!paramt.aug) {
      i = this.apF.aa(paramInt, this.apA);
    }
    int j;
    do
    {
      return i;
      j = this.apE.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.ct(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.apF.aa(paramInt, this.apA);
  }
  
  private void b(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.apG;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = Y(localLayoutParams.apH, localLayoutParams.apI);
    if (this.mOrientation == 1)
    {
      i = b(k, paramInt, i, localLayoutParams.width, false);
      paramInt = b(this.aqg.kD(), this.att, j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      return;
      paramInt = b(k, paramInt, j, localLayoutParams.height, false);
      i = b(this.aqg.kD(), this.ats, i, localLayoutParams.width, true);
    }
  }
  
  private void bU(int paramInt)
  {
    this.apB = d(this.apB, this.apA, paramInt);
  }
  
  private int c(RecyclerView.o paramo, RecyclerView.t paramt, int paramInt)
  {
    int i;
    if (!paramt.aug) {
      i = this.apF.bW(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.apD.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.ct(paramInt);
    if (paramInt == -1) {
      return 1;
    }
    return this.apF.bW(paramInt);
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
  
  private void jX()
  {
    if (getOrientation() == 1) {}
    for (int i = this.mWidth - getPaddingRight() - getPaddingLeft();; i = this.mHeight - getPaddingBottom() - getPaddingTop())
    {
      bU(i);
      return;
    }
  }
  
  private void jY()
  {
    if ((this.apC == null) || (this.apC.length != this.apA)) {
      this.apC = new View[this.apA];
    }
  }
  
  public int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    jX();
    jY();
    return super.a(paramInt, paramo, paramt);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 0) {
      return this.apA;
    }
    if (paramt.getItemCount() <= 0) {
      return 0;
    }
    return a(paramo, paramt, paramt.getItemCount() - 1) + 1;
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  final View a(RecyclerView.o paramo, RecyclerView.t paramt, int paramInt1, int paramInt2, int paramInt3)
  {
    kf();
    int j = this.aqg.kB();
    int k = this.aqg.kC();
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
      int m = bB(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramo, paramt, m) != 0)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aty.isRemoved()) {
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
      if (this.aqg.bn(localView) < k)
      {
        localObject3 = localView;
        if (this.aqg.bo(localView) >= j) {}
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
  
  public final View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    View localView3 = bt(paramView);
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
      i6 = ((LayoutParams)localObject).apH;
      i7 = ((LayoutParams)localObject).apH + ((LayoutParams)localObject).apI;
      if (super.a(paramView, paramInt, paramo, paramt) == null) {
        return null;
      }
      int i12;
      int k;
      if (cc(paramInt) == 1)
      {
        i12 = 1;
        if (i12 == this.aqj) {
          break label213;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label218;
        }
        paramInt = getChildCount() - 1;
        m = -1;
        k = -1;
        if ((this.mOrientation != 1) || (!jy())) {
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
        int i8 = a(paramo, paramt, paramInt);
        i1 = paramInt;
        if (i1 != k)
        {
          paramInt = a(paramo, paramt, i1);
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
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      i9 = localLayoutParams.apH;
      i10 = localLayoutParams.apH + localLayoutParams.apI;
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
      i2 = localLayoutParams.apH;
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
      if ((this.atj.cf(paramView)) && (this.atk.cf(paramView)))
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
      i = localLayoutParams.apH;
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
    if (this.apB == null) {
      super.a(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = m(paramInt2, k + paramRect.height(), t.af(this.anl));
      paramInt2 = m(paramInt1, j + this.apB[(this.apB.length - 1)], t.ae(this.anl));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = m(paramInt1, j + paramRect.width(), t.ae(this.anl));
      paramInt1 = m(paramInt2, k + this.apB[(this.apB.length - 1)], t.af(this.anl));
      paramInt2 = i;
    }
  }
  
  public final void a(b paramb)
  {
    this.apF = paramb;
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.t paramt, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    super.a(paramo, paramt, parama, paramInt);
    jX();
    if ((paramt.getItemCount() > 0) && (!paramt.aug))
    {
      if (paramInt == 1) {}
      for (paramInt = i;; paramInt = 0)
      {
        i = b(paramo, paramt, parama.mPosition);
        if (paramInt == 0) {
          break;
        }
        while ((i > 0) && (parama.mPosition > 0))
        {
          parama.mPosition -= 1;
          i = b(paramo, paramt, parama.mPosition);
        }
      }
      int k = paramt.getItemCount();
      paramInt = parama.mPosition;
      while (paramInt < k - 1)
      {
        int j = b(paramo, paramt, paramInt + 1);
        if (j <= i) {
          break;
        }
        paramInt += 1;
        i = j;
      }
      parama.mPosition = paramInt;
    }
    jY();
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.t paramt, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.aqg.kE();
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
      k = this.apB[this.apA];
      if (j != 0) {
        jX();
      }
      if (paramc.apO != 1) {
        break label218;
      }
      bool = true;
      m = 0;
      i = this.apA;
      n = m;
      if (!bool)
      {
        i = b(paramo, paramt, paramc.apN) + c(paramo, paramt, paramc.apN);
        n = m;
      }
    }
    int i1;
    label212:
    label218:
    Object localObject;
    for (;;)
    {
      if ((n >= this.apA) || (!paramc.b(paramt)) || (i <= 0)) {
        break label266;
      }
      m = paramc.apN;
      i1 = c(paramo, paramt, m);
      if (i1 > this.apA)
      {
        throw new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.apA + " spans.");
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
      this.apC[n] = localObject;
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
    a(paramo, paramt, n, bool);
    int m = 0;
    label330:
    int i2;
    if (m < n)
    {
      paramo = this.apC[m];
      if (paramc.aqC == null) {
        if (bool)
        {
          addView(paramo, -1);
          f(paramo, this.apG);
          b(paramo, i3, false);
          i2 = this.aqg.br(paramo);
          i1 = i;
          if (i2 > i) {
            i1 = i2;
          }
          paramt = (LayoutParams)paramo.getLayoutParams();
          float f2 = this.aqg.bs(paramo) * 1.0F / paramt.apI;
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
        G(paramo, -1);
        break label330;
      }
      G(paramo, 0);
      break label330;
      if (j != 0)
      {
        bU(Math.max(Math.round(this.apA * f1), k));
        i = 0;
        k = 0;
        j = i;
        if (k >= n) {
          break label549;
        }
        paramo = this.apC[k];
        b(paramo, 1073741824, true);
        j = this.aqg.br(paramo);
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
          paramo = this.apC[i];
          if (this.aqg.br(paramo) != j)
          {
            paramt = (LayoutParams)paramo.getLayoutParams();
            localObject = paramt.apG;
            m = ((Rect)localObject).top + ((Rect)localObject).bottom + paramt.topMargin + paramt.bottomMargin;
            k = ((Rect)localObject).left;
            k = ((Rect)localObject).right + k + paramt.leftMargin + paramt.rightMargin;
            i1 = Y(paramt.apH, paramt.apI);
            if (this.mOrientation != 1) {
              break label715;
            }
            k = b(i1, 1073741824, k, paramt.width, false);
          }
          for (m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);; m = b(i1, 1073741824, m, paramt.height, false))
          {
            a(paramo, k, m, true);
            i += 1;
            break;
            k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          }
        }
        paramb.aqw = j;
        i1 = 0;
        m = 0;
        k = 0;
        if (this.mOrientation == 1) {
          if (paramc.mLayoutDirection == -1)
          {
            i = paramc.fq;
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
            paramo = this.apC[i1];
            paramt = (LayoutParams)paramo.getLayoutParams();
            if (this.mOrientation != 1) {
              break label1100;
            }
            if (!jy()) {
              break label1052;
            }
            k = getPaddingLeft();
            m = this.apB[(this.apA - paramt.apH)] + k;
            i2 = m - this.aqg.bs(paramo);
            k = i;
            i = i2;
          }
        }
        for (;;)
        {
          k(paramo, i, k, m, j);
          if ((paramt.aty.isRemoved()) || (paramt.aty.md())) {
            paramb.aqx = true;
          }
          paramb.adu |= paramo.hasFocusable();
          i2 = i1 + 1;
          i1 = k;
          k = i;
          i = i1;
          i1 = i2;
          break label816;
          k = paramc.fq;
          i = j + k;
          j = i1;
          break;
          if (paramc.mLayoutDirection == -1)
          {
            m = paramc.fq;
            j = m - j;
            i = 0;
            break;
          }
          i = paramc.fq;
          m = i + j;
          i1 = 0;
          j = i;
          i = i1;
          break;
          m = getPaddingLeft() + this.apB[paramt.apH];
          i2 = this.aqg.bs(paramo);
          k = i;
          i2 += m;
          i = m;
          m = i2;
          continue;
          i2 = getPaddingTop() + this.apB[paramt.apH];
          j = i2 + this.aqg.bs(paramo);
          i = k;
          k = i2;
        }
        Arrays.fill(this.apC, null);
        return;
      }
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.t paramt, View paramView, c paramc)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.a(paramView, paramc);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = a(paramo, paramt, paramView.aty.lM());
    if (this.mOrientation == 0)
    {
      j = paramView.apH;
      k = paramView.apI;
      if ((this.apA > 1) && (paramView.apI == this.apA)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramc.H(c.c.a(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.apH;
    int k = paramView.apI;
    boolean bool1 = bool2;
    if (this.apA > 1)
    {
      bool1 = bool2;
      if (paramView.apI == this.apA) {
        bool1 = true;
      }
    }
    paramc.H(c.c.a(i, 1, j, k, bool1));
  }
  
  public final void a(RecyclerView.t paramt)
  {
    super.a(paramt);
    this.apz = false;
  }
  
  final void a(RecyclerView.t paramt, LinearLayoutManager.c paramc, RecyclerView.i.a parama)
  {
    int j = this.apA;
    int i = 0;
    while ((i < this.apA) && (paramc.b(paramt)) && (j > 0))
    {
      int k = paramc.apN;
      parama.S(k, Math.max(0, paramc.aqy));
      j -= this.apF.bW(k);
      paramc.apN += paramc.apO;
      i += 1;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    this.apF.apJ.clear();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.apF.apJ.clear();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.apF.apJ.clear();
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final void ao(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    super.ao(false);
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    jX();
    jY();
    return super.b(paramInt, paramo, paramt);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 1) {
      return this.apA;
    }
    if (paramt.getItemCount() <= 0) {
      return 0;
    }
    return a(paramo, paramt, paramt.getItemCount() - 1) + 1;
  }
  
  public final void bV(int paramInt)
  {
    if (paramInt == this.apA) {
      return;
    }
    this.apz = true;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(paramInt)));
    }
    this.apA = paramInt;
    this.apF.apJ.clear();
    requestLayout();
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (paramt.aug)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.aty.lM();
        this.apD.put(k, localLayoutParams.apI);
        this.apE.put(k, localLayoutParams.apH);
        i += 1;
      }
    }
    super.c(paramo, paramt);
    this.apD.clear();
    this.apE.clear();
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.apF.apJ.clear();
  }
  
  public final RecyclerView.LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.apF.apJ.clear();
  }
  
  public final RecyclerView.LayoutParams jW()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public final int jZ()
  {
    return this.apA;
  }
  
  public boolean ka()
  {
    return (this.aqp == null) && (!this.apz);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public int apH = -1;
    public int apI = 0;
    
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
  }
  
  public static final class a
    extends GridLayoutManager.b
  {
    public final int Z(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public final int bW(int paramInt)
    {
      return 1;
    }
  }
  
  public static abstract class b
  {
    final SparseIntArray apJ = new SparseIntArray();
    private boolean apK = false;
    
    public int Z(int paramInt1, int paramInt2)
    {
      int n = bW(paramInt1);
      if (n == paramInt2) {
        return 0;
      }
      int j;
      int i;
      int k;
      if ((this.apK) && (this.apJ.size() > 0))
      {
        j = this.apJ.size() - 1;
        i = 0;
        while (i <= j)
        {
          k = i + j >>> 1;
          if (this.apJ.keyAt(k) < paramInt1) {
            i = k + 1;
          } else {
            j = k - 1;
          }
        }
        i -= 1;
        if ((i >= 0) && (i < this.apJ.size()))
        {
          i = this.apJ.keyAt(i);
          if (i < 0) {
            break label216;
          }
          j = this.apJ.get(i) + bW(i);
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
          k = bW(j);
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
    
    final int aa(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.apK) {
        i = Z(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = this.apJ.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = Z(paramInt1, paramInt2);
      this.apJ.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public final int ab(int paramInt1, int paramInt2)
    {
      int n = bW(paramInt1);
      int k = 0;
      int i = 0;
      int j = 0;
      int m;
      if (k < paramInt1)
      {
        m = bW(k);
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
    
    public abstract int bW(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */