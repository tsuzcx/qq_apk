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
  boolean amM = false;
  public int amN = -1;
  int[] amO;
  View[] amP;
  final SparseIntArray amQ = new SparseIntArray();
  final SparseIntArray amR = new SparseIntArray();
  public GridLayoutManager.b amS = new a();
  final Rect amT = new Rect();
  
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
    bV(c(paramContext, paramAttributeSet, paramInt1, paramInt2).aqI);
  }
  
  private int X(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (ja())) {
      return this.amO[(this.amN - paramInt1)] - this.amO[(this.amN - paramInt1 - paramInt2)];
    }
    return this.amO[(paramInt1 + paramInt2)] - this.amO[paramInt1];
  }
  
  private int a(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    if (!params.aru) {
      return this.amS.aa(paramInt, this.amN);
    }
    paramInt = paramo.cu(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.amS.aa(paramInt, this.amN);
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
      View localView = this.amP[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localLayoutParams.amV = c(paramo, params, bB(localView));
      localLayoutParams.amU = k;
      k += localLayoutParams.amV;
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
    if (!params.aru) {
      i = this.amS.Z(paramInt, this.amN);
    }
    int j;
    do
    {
      return i;
      j = this.amR.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.cu(paramInt);
    if (paramInt == -1) {
      return 0;
    }
    return this.amS.Z(paramInt, this.amN);
  }
  
  private void b(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.amT;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = X(localLayoutParams.amU, localLayoutParams.amV);
    if (this.mOrientation == 1)
    {
      i = b(k, paramInt, i, localLayoutParams.width, false);
      paramInt = b(this.ant.kf(), this.aqG, j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      return;
      paramInt = b(k, paramInt, j, localLayoutParams.height, false);
      i = b(this.ant.kf(), this.aqF, i, localLayoutParams.width, true);
    }
  }
  
  private void bU(int paramInt)
  {
    this.amO = d(this.amO, this.amN, paramInt);
  }
  
  private int c(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    int i;
    if (!params.aru) {
      i = this.amS.bW(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.amQ.get(paramInt, -1);
      i = j;
    } while (j != -1);
    paramInt = paramo.cu(paramInt);
    if (paramInt == -1) {
      return 1;
    }
    return this.amS.bW(paramInt);
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
  
  private void jA()
  {
    if ((this.amP == null) || (this.amP.length != this.amN)) {
      this.amP = new View[this.amN];
    }
  }
  
  private void jz()
  {
    if (getOrientation() == 1) {}
    for (int i = this.mWidth - getPaddingRight() - getPaddingLeft();; i = this.mHeight - getPaddingBottom() - getPaddingTop())
    {
      bU(i);
      return;
    }
  }
  
  public int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    jz();
    jA();
    return super.a(paramInt, paramo, params);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return this.amN;
    }
    if (params.getItemCount() <= 0) {
      return 0;
    }
    return a(paramo, params, params.getItemCount() - 1) + 1;
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  final View a(RecyclerView.o paramo, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    jH();
    int j = this.ant.kd();
    int k = this.ant.ke();
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
      if ((m < 0) || (m >= paramInt3) || (b(paramo, params, m) != 0)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aqL.isRemoved()) {
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
      if (this.ant.bn(localView) < k)
      {
        localObject3 = localView;
        if (this.ant.bo(localView) >= j) {}
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
      i6 = ((LayoutParams)localObject).amU;
      i7 = ((LayoutParams)localObject).amU + ((LayoutParams)localObject).amV;
      if (super.a(paramView, paramInt, paramo, params) == null) {
        return null;
      }
      int i12;
      int k;
      if (cc(paramInt) == 1)
      {
        i12 = 1;
        if (i12 == this.anw) {
          break label213;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label218;
        }
        paramInt = getChildCount() - 1;
        m = -1;
        k = -1;
        if ((this.mOrientation != 1) || (!ja())) {
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
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      i9 = localLayoutParams.amU;
      i10 = localLayoutParams.amU + localLayoutParams.amV;
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
      i2 = localLayoutParams.amU;
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
      if ((this.aqw.cf(paramView)) && (this.aqx.cf(paramView)))
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
      i = localLayoutParams.amU;
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
    if (this.amO == null) {
      super.a(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = m(paramInt2, k + paramRect.height(), t.af(this.akA));
      paramInt2 = m(paramInt1, j + this.amO[(this.amO.length - 1)], t.ae(this.akA));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = m(paramInt1, j + paramRect.width(), t.ae(this.akA));
      paramInt1 = m(paramInt2, k + this.amO[(this.amO.length - 1)], t.af(this.akA));
      paramInt2 = i;
    }
  }
  
  public final void a(GridLayoutManager.b paramb)
  {
    this.amS = paramb;
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    super.a(paramo, params, parama, paramInt);
    jz();
    if ((params.getItemCount() > 0) && (!params.aru))
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
    jA();
  }
  
  final void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    int i3 = this.ant.kg();
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
      k = this.amO[this.amN];
      if (j != 0) {
        jz();
      }
      if (paramc.anb != 1) {
        break label218;
      }
      bool = true;
      m = 0;
      i = this.amN;
      n = m;
      if (!bool)
      {
        i = b(paramo, params, paramc.ana) + c(paramo, params, paramc.ana);
        n = m;
      }
    }
    int i1;
    label212:
    label218:
    Object localObject;
    for (;;)
    {
      if ((n >= this.amN) || (!paramc.b(params)) || (i <= 0)) {
        break label266;
      }
      m = paramc.ana;
      i1 = c(paramo, params, m);
      if (i1 > this.amN)
      {
        throw new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.amN + " spans.");
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
      this.amP[n] = localObject;
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
      paramo = this.amP[m];
      if (paramc.anP == null) {
        if (bool)
        {
          addView(paramo, -1);
          f(paramo, this.amT);
          b(paramo, i3, false);
          i2 = this.ant.br(paramo);
          i1 = i;
          if (i2 > i) {
            i1 = i2;
          }
          params = (LayoutParams)paramo.getLayoutParams();
          float f2 = this.ant.bs(paramo) * 1.0F / params.amV;
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
        bU(Math.max(Math.round(this.amN * f1), k));
        i = 0;
        k = 0;
        j = i;
        if (k >= n) {
          break label549;
        }
        paramo = this.amP[k];
        b(paramo, 1073741824, true);
        j = this.ant.br(paramo);
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
          paramo = this.amP[i];
          if (this.ant.br(paramo) != j)
          {
            params = (LayoutParams)paramo.getLayoutParams();
            localObject = params.amT;
            m = ((Rect)localObject).top + ((Rect)localObject).bottom + params.topMargin + params.bottomMargin;
            k = ((Rect)localObject).left;
            k = ((Rect)localObject).right + k + params.leftMargin + params.rightMargin;
            i1 = X(params.amU, params.amV);
            if (this.mOrientation != 1) {
              break label715;
            }
            k = b(i1, 1073741824, k, params.width, false);
          }
          for (m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);; m = b(i1, 1073741824, m, params.height, false))
          {
            a(paramo, k, m, true);
            i += 1;
            break;
            k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          }
        }
        paramb.anJ = j;
        i1 = 0;
        m = 0;
        k = 0;
        if (this.mOrientation == 1) {
          if (paramc.mLayoutDirection == -1)
          {
            i = paramc.LZ;
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
            paramo = this.amP[i1];
            params = (LayoutParams)paramo.getLayoutParams();
            if (this.mOrientation != 1) {
              break label1100;
            }
            if (!ja()) {
              break label1052;
            }
            k = getPaddingLeft();
            m = this.amO[(this.amN - params.amU)] + k;
            i2 = m - this.ant.bs(paramo);
            k = i;
            i = i2;
          }
        }
        for (;;)
        {
          k(paramo, i, k, m, j);
          if ((params.aqL.isRemoved()) || (params.aqL.lC())) {
            paramb.anK = true;
          }
          paramb.aaI |= paramo.hasFocusable();
          i2 = i1 + 1;
          i1 = k;
          k = i;
          i = i1;
          i1 = i2;
          break label816;
          k = paramc.LZ;
          i = j + k;
          j = i1;
          break;
          if (paramc.mLayoutDirection == -1)
          {
            m = paramc.LZ;
            j = m - j;
            i = 0;
            break;
          }
          i = paramc.LZ;
          m = i + j;
          i1 = 0;
          j = i;
          i = i1;
          break;
          m = getPaddingLeft() + this.amO[params.amU];
          i2 = this.ant.bs(paramo);
          k = i;
          i2 += m;
          i = m;
          m = i2;
          continue;
          i2 = getPaddingTop() + this.amO[params.amU];
          j = i2 + this.ant.bs(paramo);
          i = k;
          k = i2;
        }
        Arrays.fill(this.amP, null);
        return;
      }
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, c paramc)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.a(paramView, paramc);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = a(paramo, params, paramView.aqL.lm());
    if (this.mOrientation == 0)
    {
      j = paramView.amU;
      k = paramView.amV;
      if ((this.amN > 1) && (paramView.amV == this.amN)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramc.E(c.c.a(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.amU;
    int k = paramView.amV;
    boolean bool1 = bool2;
    if (this.amN > 1)
    {
      bool1 = bool2;
      if (paramView.amV == this.amN) {
        bool1 = true;
      }
    }
    paramc.E(c.c.a(i, 1, j, k, bool1));
  }
  
  public final void a(RecyclerView.s params)
  {
    super.a(params);
    this.amM = false;
  }
  
  final void a(RecyclerView.s params, LinearLayoutManager.c paramc, RecyclerView.i.a parama)
  {
    int j = this.amN;
    int i = 0;
    while ((i < this.amN) && (paramc.b(params)) && (j > 0))
    {
      int k = paramc.ana;
      parama.R(k, Math.max(0, paramc.anL));
      j -= this.amS.bW(k);
      paramc.ana += paramc.anb;
      i += 1;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    this.amS.amW.clear();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.amS.amW.clear();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.amS.amW.clear();
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
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    jz();
    jA();
    return super.b(paramInt, paramo, params);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return this.amN;
    }
    if (params.getItemCount() <= 0) {
      return 0;
    }
    return a(paramo, params, params.getItemCount() - 1) + 1;
  }
  
  public final void bV(int paramInt)
  {
    if (paramInt == this.amN) {
      return;
    }
    this.amM = true;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(paramInt)));
    }
    this.amN = paramInt;
    this.amS.amW.clear();
    requestLayout();
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (params.aru)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.aqL.lm();
        this.amQ.put(k, localLayoutParams.amV);
        this.amR.put(k, localLayoutParams.amU);
        i += 1;
      }
    }
    super.c(paramo, params);
    this.amQ.clear();
    this.amR.clear();
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.amS.amW.clear();
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
    this.amS.amW.clear();
  }
  
  public final int jB()
  {
    return this.amN;
  }
  
  public boolean jC()
  {
    return (this.anC == null) && (!this.amM);
  }
  
  public final RecyclerView.LayoutParams jy()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public int amU = -1;
    public int amV = 0;
    
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
    public final int Y(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public final int bW(int paramInt)
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */