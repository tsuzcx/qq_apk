package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.c;
import android.support.v4.view.a.c.c;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b
{
  private final Rect Ui = new Rect();
  public int apM = -1;
  boolean aqu = false;
  boolean aqv = false;
  private boolean aqx = true;
  int aqy = -1;
  int aqz = -2147483648;
  b[] awM;
  aj awN;
  aj awO;
  private int awP;
  private final ad awQ;
  private BitSet awR;
  LazySpanLookup awS = new LazySpanLookup();
  private int awT = 2;
  private boolean awU;
  private boolean awV;
  private StaggeredGridLayoutManager.SavedState awW;
  private int awX;
  private final a awY = new a();
  private boolean awZ = false;
  private int[] axa;
  private final Runnable axb = new Runnable()
  {
    public final void run()
    {
      StaggeredGridLayoutManager.this.mB();
    }
  };
  public int mOrientation;
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    this.mOrientation = 1;
    bW(paramInt1);
    this.awQ = new ad();
    mA();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = paramContext.orientation;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt1 != this.mOrientation)
    {
      this.mOrientation = paramInt1;
      paramAttributeSet = this.awN;
      this.awN = this.awO;
      this.awO = paramAttributeSet;
      requestLayout();
    }
    bW(paramContext.att);
    ao(paramContext.atu);
    this.awQ = new ad();
    mA();
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    b(paramInt, params);
    int j = a(paramn, this.awQ, params);
    int i = paramInt;
    if (this.awQ.apY >= j) {
      if (paramInt >= 0) {
        break label93;
      }
    }
    label93:
    for (i = -j;; i = j)
    {
      this.awN.ce(-i);
      this.awU = this.aqv;
      this.awQ.apY = 0;
      a(paramn, this.awQ);
      return i;
    }
  }
  
  private int a(RecyclerView.n paramn, ad paramad, RecyclerView.s params)
  {
    this.awR.set(0, this.apM, true);
    int i;
    int m;
    label61:
    int j;
    label64:
    View localView;
    LayoutParams localLayoutParams;
    int i2;
    int i1;
    label139:
    b localb;
    label160:
    label171:
    label192:
    label224:
    int n;
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int k;
    if (this.awQ.aqe) {
      if (paramad.mLayoutDirection == 1)
      {
        i = 2147483647;
        aD(paramad.mLayoutDirection, i);
        if (!this.aqv) {
          break label553;
        }
        m = this.awN.kI();
        j = 0;
        if ((!paramad.a(params)) || ((!this.awQ.aqe) && (this.awR.isEmpty()))) {
          break label870;
        }
        localView = paramad.a(paramn);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.atw.lQ();
        j = this.awS.cK(i2);
        if (j != -1) {
          break label565;
        }
        i1 = 1;
        if (i1 == 0) {
          break label581;
        }
        if (!localLayoutParams.axg) {
          break label571;
        }
        localb = this.awM[0];
        this.awS.a(i2, localb);
        localLayoutParams.axf = localb;
        if (paramad.mLayoutDirection != 1) {
          break label593;
        }
        addView(localView);
        a(localView, localLayoutParams);
        if (paramad.mLayoutDirection != 1) {
          break label615;
        }
        if (!localLayoutParams.axg) {
          break label603;
        }
        j = cE(m);
        n = j + this.awN.bs(localView);
        if ((i1 == 0) || (!localLayoutParams.axg)) {
          break label961;
        }
        localFullSpanItem = cA(j);
        localFullSpanItem.axi = -1;
        localFullSpanItem.mPosition = i2;
        this.awS.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.axg) && (paramad.aqa == -1))
      {
        if (i1 == 0)
        {
          if (paramad.mLayoutDirection != 1) {
            break label713;
          }
          if (mF()) {
            break label707;
          }
          j = 1;
          label324:
          if (j == 0) {
            break label356;
          }
          localFullSpanItem = this.awS.cO(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.axk = true;
          }
        }
        this.awZ = true;
      }
      label356:
      a(localView, localLayoutParams, paramad);
      if ((jH()) && (this.mOrientation == 1)) {
        if (localLayoutParams.axg)
        {
          j = this.awO.kI();
          label397:
          i2 = j - this.awO.bs(localView);
          i1 = j;
          j = i2;
          if (this.mOrientation != 1) {
            break label819;
          }
          layoutDecoratedWithMargins(localView, j, k, i1, n);
          label441:
          if (!localLayoutParams.axg) {
            break label836;
          }
          aD(this.awQ.mLayoutDirection, i);
          label462:
          a(paramn, this.awQ);
          if ((this.awQ.aqd) && (localView.hasFocusable()))
          {
            if (!localLayoutParams.axg) {
              break label854;
            }
            this.awR.clear();
          }
        }
      }
      for (;;)
      {
        j = 1;
        break label64;
        i = -2147483648;
        break;
        if (paramad.mLayoutDirection == 1)
        {
          i = paramad.aqc + paramad.apY;
          break;
        }
        i = paramad.aqb - paramad.apY;
        break;
        label553:
        m = this.awN.kH();
        break label61;
        label565:
        i1 = 0;
        break label139;
        label571:
        localb = a(paramad);
        break label160;
        label581:
        localb = this.awM[j];
        break label171;
        label593:
        addView(localView, 0);
        break label192;
        label603:
        j = localb.cR(m);
        break label224;
        label615:
        if (localLayoutParams.axg) {}
        for (j = cD(m);; j = localb.cQ(m))
        {
          k = j - this.awN.bs(localView);
          if ((i1 != 0) && (localLayoutParams.axg))
          {
            localFullSpanItem = cB(j);
            localFullSpanItem.axi = 1;
            localFullSpanItem.mPosition = i2;
            this.awS.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        label707:
        j = 0;
        break label324;
        label713:
        if (!mG())
        {
          j = 1;
          break label324;
        }
        j = 0;
        break label324;
        j = this.awO.kI() - (this.apM - 1 - localb.mIndex) * this.awP;
        break label397;
        if (localLayoutParams.axg) {}
        for (j = this.awO.kH();; j = localb.mIndex * this.awP + this.awO.kH())
        {
          i1 = j + this.awO.bs(localView);
          break;
        }
        label819:
        layoutDecoratedWithMargins(localView, k, j, n, i1);
        break label441;
        label836:
        a(localb, this.awQ.mLayoutDirection, i);
        break label462;
        label854:
        this.awR.set(localb.mIndex, false);
      }
      label870:
      if (j == 0) {
        a(paramn, this.awQ);
      }
      if (this.awQ.mLayoutDirection == -1) {
        i = cD(this.awN.kH());
      }
      for (i = this.awN.kH() - i; i > 0; i = cE(this.awN.kI()) - this.awN.kI()) {
        return Math.min(paramad.apY, i);
      }
      return 0;
      label961:
      k = j;
    }
  }
  
  private b a(ad paramad)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    int j;
    int k;
    int n;
    int i1;
    int m;
    if (cG(paramad.mLayoutDirection))
    {
      i = this.apM - 1;
      j = -1;
      k = -1;
      if (paramad.mLayoutDirection != 1) {
        break label121;
      }
      n = 2147483647;
      i1 = this.awN.kH();
      m = i;
      paramad = (ad)localObject1;
      i = n;
      label59:
      localObject1 = paramad;
      if (m == k) {
        break label192;
      }
      localObject1 = this.awM[m];
      n = ((b)localObject1).cR(i1);
      if (n >= i) {
        break label198;
      }
      paramad = (ad)localObject1;
      i = n;
    }
    label192:
    label195:
    label198:
    for (;;)
    {
      m += j;
      break label59;
      i = 0;
      k = this.apM;
      j = 1;
      break;
      label121:
      n = -2147483648;
      i1 = this.awN.kI();
      m = i;
      paramad = localObject2;
      i = n;
      localObject1 = paramad;
      if (m != k)
      {
        localObject1 = this.awM[m];
        n = ((b)localObject1).cQ(i1);
        if (n <= i) {
          break label195;
        }
        paramad = (ad)localObject1;
        i = n;
      }
      for (;;)
      {
        m += j;
        break;
        return localObject1;
      }
    }
  }
  
  private void a(int paramInt, RecyclerView.s params)
  {
    boolean bool2 = false;
    this.awQ.apY = 0;
    this.awQ.apZ = paramInt;
    int i;
    boolean bool1;
    if (isSmoothScrolling())
    {
      i = params.atO;
      if (i != -1)
      {
        boolean bool3 = this.aqv;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.awN.kJ();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.awQ.aqb = (this.awN.kH() - i);
        this.awQ.aqc = (paramInt + this.awN.kI());
      }
      for (;;)
      {
        this.awQ.aqd = false;
        this.awQ.apX = true;
        params = this.awQ;
        bool1 = bool2;
        if (this.awN.getMode() == 0)
        {
          bool1 = bool2;
          if (this.awN.getEnd() == 0) {
            bool1 = true;
          }
        }
        params.aqe = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i = this.awN.kJ();
        paramInt = 0;
        break label67;
        this.awQ.aqc = (paramInt + this.awN.getEnd());
        this.awQ.aqb = (-i);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private void a(RecyclerView.n paramn, int paramInt)
  {
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if ((this.awN.bp(localView) <= paramInt) && (this.awN.bq(localView) <= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.axg) {
            break label118;
          }
          i = 0;
          if (i >= this.apM) {
            break label92;
          }
          if (this.awM[i].axq.size() != 1) {
            break label85;
          }
        }
      }
      label85:
      label92:
      label118:
      while (localLayoutParams.axf.axq.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.apM)
        {
          this.awM[i].mQ();
          i += 1;
        }
      }
      localLayoutParams.axf.mQ();
      removeAndRecycleView(localView, paramn);
    }
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    int i = cE(-2147483648);
    if (i == -2147483648) {}
    do
    {
      do
      {
        return;
        i = this.awN.kI() - i;
      } while (i <= 0);
      i -= -a(-i, paramn, params);
    } while ((!paramBoolean) || (i <= 0));
    this.awN.ce(i);
  }
  
  private void a(RecyclerView.n paramn, ad paramad)
  {
    if ((!paramad.apX) || (paramad.aqe)) {
      return;
    }
    if (paramad.apY == 0)
    {
      if (paramad.mLayoutDirection == -1)
      {
        b(paramn, paramad.aqc);
        return;
      }
      a(paramn, paramad.aqb);
      return;
    }
    if (paramad.mLayoutDirection == -1)
    {
      i = paramad.aqb - cC(paramad.aqb);
      if (i < 0) {}
      for (i = paramad.aqc;; i = paramad.aqc - Math.min(i, paramad.apY))
      {
        b(paramn, i);
        return;
      }
    }
    int i = cF(paramad.aqc) - paramad.aqc;
    if (i < 0) {}
    int j;
    for (i = paramad.aqb;; i = Math.min(i, paramad.apY) + j)
    {
      a(paramn, i);
      return;
      j = paramad.aqb;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.axt;
    if (paramInt1 == -1) {
      if (i + paramb.mM() <= paramInt2) {
        this.awR.set(paramb.mIndex, false);
      }
    }
    while (paramb.mO() - i < paramInt2) {
      return;
    }
    this.awR.set(paramb.mIndex, false);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.axg)
    {
      if (this.mOrientation == 1)
      {
        l(paramView, this.awX, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
        return;
      }
      l(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.awX);
      return;
    }
    if (this.mOrientation == 1)
    {
      l(paramView, getChildMeasureSpec(this.awP, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
      return;
    }
    l(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), getChildMeasureSpec(this.awP, getHeightMode(), 0, paramLayoutParams.height, false));
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, ad paramad)
  {
    if (paramad.mLayoutDirection == 1)
    {
      if (paramLayoutParams.axg)
      {
        bI(paramView);
        return;
      }
      paramLayoutParams.axf.bL(paramView);
      return;
    }
    if (paramLayoutParams.axg)
    {
      bJ(paramView);
      return;
    }
    paramLayoutParams.axf.bK(paramView);
  }
  
  private boolean a(b paramb)
  {
    if (this.aqv)
    {
      if (paramb.mO() < this.awN.kI()) {
        return !((LayoutParams)((View)paramb.axq.get(paramb.axq.size() - 1)).getLayoutParams()).axg;
      }
    }
    else if (paramb.mM() > this.awN.kH()) {
      return !((LayoutParams)((View)paramb.axq.get(0)).getLayoutParams()).axg;
    }
    return false;
  }
  
  private View aA(boolean paramBoolean)
  {
    int j = this.awN.kH();
    int k = this.awN.kI();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.awN.bo(localView);
      if ((this.awN.bp(localView) <= j) || (n >= k)) {
        break label104;
      }
      if ((n >= j) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label104;
      }
      localObject = localView;
    }
    label104:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  private View aB(boolean paramBoolean)
  {
    int j = this.awN.kH();
    int k = this.awN.kI();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.awN.bo(localView);
      int n = this.awN.bp(localView);
      if ((n <= j) || (m >= k)) {
        break label106;
      }
      if ((n <= k) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label106;
      }
      localObject = localView;
    }
    label106:
    for (;;)
    {
      i -= 1;
      break;
      return localObject;
    }
  }
  
  private void aD(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.apM)
    {
      if (!this.awM[i].axq.isEmpty()) {
        a(this.awM[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private void ao(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if ((this.awW != null) && (this.awW.aqu != paramBoolean)) {
      this.awW.aqu = paramBoolean;
    }
    this.aqu = paramBoolean;
    requestLayout();
  }
  
  private void b(int paramInt, RecyclerView.s params)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = mH();
      j = 1;
    }
    for (;;)
    {
      this.awQ.apX = true;
      a(i, params);
      cz(j);
      params = this.awQ;
      params.apZ = (i + params.aqa);
      this.awQ.apY = Math.abs(paramInt);
      return;
      j = -1;
      i = mI();
    }
  }
  
  private void b(RecyclerView.n paramn, int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        if ((this.awN.bo(localView) >= paramInt) && (this.awN.br(localView) >= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.axg) {
            break label132;
          }
          j = 0;
          if (j >= this.apM) {
            break label101;
          }
          if (this.awM[j].axq.size() != 1) {
            break label92;
          }
        }
      }
      label92:
      label101:
      while (localLayoutParams.axf.axq.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.apM)
        {
          this.awM[j].mP();
          j += 1;
        }
      }
      label132:
      localLayoutParams.axf.mP();
      removeAndRecycleView(localView, paramn);
      i -= 1;
    }
  }
  
  private void b(RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    int i = cD(2147483647);
    if (i == 2147483647) {}
    do
    {
      do
      {
        return;
        i -= this.awN.kH();
      } while (i <= 0);
      i -= a(i, paramn, params);
    } while ((!paramBoolean) || (i <= 0));
    this.awN.ce(-i);
  }
  
  private void bI(View paramView)
  {
    int i = this.apM - 1;
    while (i >= 0)
    {
      this.awM[i].bL(paramView);
      i -= 1;
    }
  }
  
  private void bJ(View paramView)
  {
    int i = this.apM - 1;
    while (i >= 0)
    {
      this.awM[i].bK(paramView);
      i -= 1;
    }
  }
  
  private void bW(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.apM)
    {
      this.awS.clear();
      requestLayout();
      this.apM = paramInt;
      this.awR = new BitSet(this.apM);
      this.awM = new b[this.apM];
      paramInt = 0;
      while (paramInt < this.apM)
      {
        this.awM[paramInt] = new b(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  private int c(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.awN;
    View localView;
    if (!this.aqx)
    {
      bool1 = true;
      localView = aA(bool1);
      if (this.aqx) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, aB(bool1), this, this.aqx, this.aqv);
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cA(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.axj = new int[this.apM];
    int i = 0;
    while (i < this.apM)
    {
      localFullSpanItem.axj[i] = (paramInt - this.awM[i].cR(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cB(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.axj = new int[this.apM];
    int i = 0;
    while (i < this.apM)
    {
      localFullSpanItem.axj[i] = (this.awM[i].cQ(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private int cC(int paramInt)
  {
    int j = this.awM[0].cQ(paramInt);
    int i = 1;
    while (i < this.apM)
    {
      int m = this.awM[i].cQ(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cD(int paramInt)
  {
    int j = this.awM[0].cQ(paramInt);
    int i = 1;
    while (i < this.apM)
    {
      int m = this.awM[i].cQ(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cE(int paramInt)
  {
    int j = this.awM[0].cR(paramInt);
    int i = 1;
    while (i < this.apM)
    {
      int m = this.awM[i].cR(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cF(int paramInt)
  {
    int j = this.awM[0].cR(paramInt);
    int i = 1;
    while (i < this.apM)
    {
      int m = this.awM[i].cR(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private boolean cG(int paramInt)
  {
    int i;
    if (this.mOrientation == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.aqv) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i = 1;
        if (i != this.aqv) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == jH()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private int cH(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.aqv) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < mI()) {}
      for (int i = 1; i != this.aqv; i = 0) {
        return -1;
      }
    }
  }
  
  private void cy(int paramInt)
  {
    this.awP = (paramInt / this.apM);
    this.awX = View.MeasureSpec.makeMeasureSpec(paramInt, this.awO.getMode());
  }
  
  private void cz(int paramInt)
  {
    int i = 1;
    this.awQ.mLayoutDirection = paramInt;
    ad localad = this.awQ;
    boolean bool2 = this.aqv;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label49;
      }
    }
    label49:
    for (paramInt = i;; paramInt = -1)
    {
      localad.aqa = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private int d(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.awN;
    View localView;
    if (!this.aqx)
    {
      bool1 = true;
      localView = aA(bool1);
      if (this.aqx) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, aB(bool1), this, this.aqx);
      bool1 = false;
      break;
    }
  }
  
  private int e(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.awN;
    View localView;
    if (!this.aqx)
    {
      bool1 = true;
      localView = aA(bool1);
      if (this.aqx) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(params, localaj, localView, aB(bool1), this, this.aqx);
      bool1 = false;
      break;
    }
  }
  
  private boolean jH()
  {
    return getLayoutDirection() == 1;
  }
  
  private void kl()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!jH())) {
      bool = this.aqu;
    }
    for (;;)
    {
      this.aqv = bool;
      return;
      if (this.aqu) {
        bool = false;
      }
    }
  }
  
  private void l(View paramView, int paramInt1, int paramInt2)
  {
    calculateItemDecorationsForChild(paramView, this.Ui);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = m(paramInt1, localLayoutParams.leftMargin + this.Ui.left, localLayoutParams.rightMargin + this.Ui.right);
    paramInt2 = m(paramInt2, localLayoutParams.topMargin + this.Ui.top, localLayoutParams.bottomMargin + this.Ui.bottom);
    if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private static int m(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != -2147483648) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  private void mA()
  {
    this.awN = aj.a(this, this.mOrientation);
    this.awO = aj.a(this, 1 - this.mOrientation);
  }
  
  private View mC()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.apM);
    localBitSet.set(0, this.apM, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (jH()))
    {
      j = 1;
      if (!this.aqv) {
        break label128;
      }
      k = -1;
      label57:
      if (i >= k) {
        break label143;
      }
    }
    int n;
    View localView;
    LayoutParams localLayoutParams;
    label128:
    label143:
    for (int m = 1;; m = -1)
    {
      n = i;
      if (n == k) {
        break label349;
      }
      localView = getChildAt(n);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.axf.mIndex)) {
        break label162;
      }
      if (!a(localLayoutParams.axf)) {
        break label149;
      }
      return localView;
      j = -1;
      break;
      k = 0;
      m = i + 1;
      i = k;
      k = m;
      break label57;
    }
    label149:
    localBitSet.clear(localLayoutParams.axf.mIndex);
    label162:
    Object localObject;
    int i1;
    if ((!localLayoutParams.axg) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.aqv)
      {
        i = this.awN.bp(localView);
        i1 = this.awN.bp((View)localObject);
        if (i < i1) {
          return localView;
        }
        if (i != i1) {
          break label351;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.axf.mIndex - ((LayoutParams)localObject).axf.mIndex < 0)
        {
          i = 1;
          label271:
          if (j >= 0) {
            break label333;
          }
        }
        label333:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label339;
          }
          return localView;
          i = this.awN.bo(localView);
          i1 = this.awN.bo((View)localObject);
          if (i > i1) {
            return localView;
          }
          if (i != i1) {
            break label351;
          }
          i = 1;
          break;
          i = 0;
          break label271;
        }
      }
      label339:
      n += m;
      break;
      label349:
      return null;
      label351:
      i = 0;
    }
  }
  
  private boolean mF()
  {
    boolean bool2 = true;
    int j = this.awM[0].cR(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.apM)
      {
        if (this.awM[i].cR(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean mG()
  {
    boolean bool2 = true;
    int j = this.awM[0].cQ(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.apM)
      {
        if (this.awM[i].cQ(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int mH()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return getPosition(getChildAt(i - 1));
  }
  
  private int mI()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getPosition(getChildAt(0));
  }
  
  private void n(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (this.aqv)
    {
      k = mH();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.awS.cJ(i);
      switch (paramInt3)
      {
      default: 
        label76:
        if (j > k) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      k = mI();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.awS.aG(paramInt1, paramInt2);
      break label76;
      this.awS.aE(paramInt1, paramInt2);
      break label76;
      this.awS.aE(paramInt1, 1);
      this.awS.aG(paramInt2, 1);
      break label76;
      if (this.aqv) {}
      for (paramInt1 = mI(); i <= paramInt1; paramInt1 = mH())
      {
        requestLayout();
        return;
      }
    }
  }
  
  public void ah(int paramInt1, int paramInt2)
  {
    if (this.awW != null) {
      this.awW.mK();
    }
    this.aqy = paramInt1;
    this.aqz = paramInt2;
    requestLayout();
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.awW == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public final PointF bZ(int paramInt)
  {
    paramInt = cH(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (this.mOrientation == 0)
    {
      localPointF.x = paramInt;
      localPointF.y = 0.0F;
      return localPointF;
    }
    localPointF.x = 0.0F;
    localPointF.y = paramInt;
    return localPointF;
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.LayoutManager.a parama)
  {
    int k = 0;
    if (this.mOrientation == 0) {
      if ((getChildCount() != 0) && (paramInt1 != 0)) {
        break label27;
      }
    }
    for (;;)
    {
      return;
      paramInt1 = paramInt2;
      break;
      label27:
      b(paramInt1, params);
      if ((this.axa == null) || (this.axa.length < this.apM)) {
        this.axa = new int[this.apM];
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramInt2 < this.apM)
      {
        if (this.awQ.aqa == -1) {}
        for (int j = this.awQ.aqb - this.awM[paramInt2].cQ(this.awQ.aqb);; j = this.awM[paramInt2].cR(this.awQ.aqc) - this.awQ.aqc)
        {
          int i = paramInt1;
          if (j >= 0)
          {
            this.axa[paramInt1] = j;
            i = paramInt1 + 1;
          }
          paramInt2 += 1;
          paramInt1 = i;
          break;
        }
      }
      Arrays.sort(this.axa, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.awQ.a(params)))
      {
        parama.S(this.awQ.apZ, this.axa[paramInt2]);
        ad localad = this.awQ;
        localad.apZ += this.awQ.aqa;
        paramInt2 += 1;
      }
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    return d(params);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    return c(params);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    return e(params);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    return d(params);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    return c(params);
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    return e(params);
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
    return super.getColumnCountForAccessibility(paramn, params);
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return this.apM;
    }
    return super.getRowCountForAccessibility(paramn, params);
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return this.awT != 0;
  }
  
  public final int ki()
  {
    return this.apM;
  }
  
  final boolean mB()
  {
    if ((getChildCount() == 0) || (this.awT == 0) || (!isAttachedToWindow())) {
      return false;
    }
    int j;
    if (this.aqv) {
      j = mH();
    }
    for (int i = mI(); (j == 0) && (mC() != null); i = mH())
    {
      this.awS.clear();
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
      j = mI();
    }
    if (!this.awZ) {
      return false;
    }
    if (this.aqv) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.awS.o(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.awZ = false;
      this.awS.cI(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.awS.o(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.awS.cI(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
      this.awS.cI(localFullSpanItem2.mPosition + 1);
    }
  }
  
  public final int[] mD()
  {
    int[] arrayOfInt = new int[this.apM];
    int i = 0;
    if (i < this.apM)
    {
      b localb = this.awM[i];
      if (localb.axc.aqu) {}
      for (int j = localb.f(localb.axq.size() - 1, -1, true);; j = localb.f(0, localb.axq.size(), true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public final int[] mE()
  {
    int[] arrayOfInt = new int[this.apM];
    int i = 0;
    if (i < this.apM)
    {
      b localb = this.awM[i];
      if (localb.axc.aqu) {}
      for (int j = localb.f(0, localb.axq.size(), true);; j = localb.f(localb.axq.size() - 1, -1, true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public final int[] n(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    int i;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = new int[this.apM];
      i = 0;
      label14:
      if (i >= this.apM) {
        break label135;
      }
      paramArrayOfInt = this.awM[i];
      if (!paramArrayOfInt.axc.aqu) {
        break label118;
      }
    }
    label118:
    for (int j = paramArrayOfInt.f(paramArrayOfInt.axq.size() - 1, -1, false);; j = paramArrayOfInt.f(0, paramArrayOfInt.axq.size(), false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label14;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.apM) {
        break;
      }
      throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.apM + ", array size:" + paramArrayOfInt.length);
    }
    label135:
    return arrayOfInt;
  }
  
  public final int[] o(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    int i;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = new int[this.apM];
      i = 0;
      label14:
      if (i >= this.apM) {
        break label135;
      }
      paramArrayOfInt = this.awM[i];
      if (!paramArrayOfInt.axc.aqu) {
        break label116;
      }
    }
    label116:
    for (int j = paramArrayOfInt.f(0, paramArrayOfInt.axq.size(), false);; j = paramArrayOfInt.f(paramArrayOfInt.axq.size() - 1, -1, false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label14;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.apM) {
        break;
      }
      throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.apM + ", array size:" + paramArrayOfInt.length);
    }
    label135:
    return arrayOfInt;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    int i = 0;
    while (i < this.apM)
    {
      this.awM[i].cT(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    int i = 0;
    while (i < this.apM)
    {
      this.awM[i].cT(paramInt);
      i += 1;
    }
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    removeCallbacks(this.axb);
    int i = 0;
    while (i < this.apM)
    {
      this.awM[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if (getChildCount() == 0) {
      paramView = null;
    }
    View localView;
    b localb;
    int i;
    int j;
    label498:
    label506:
    do
    {
      return paramView;
      localView = findContainingItemView(paramView);
      if (localView == null) {
        return null;
      }
      kl();
      switch (paramInt)
      {
      default: 
        paramInt = -2147483648;
      }
      while (paramInt == -2147483648)
      {
        return null;
        if (this.mOrientation == 1)
        {
          paramInt = -1;
        }
        else if (jH())
        {
          paramInt = 1;
        }
        else
        {
          paramInt = -1;
          continue;
          if (this.mOrientation == 1)
          {
            paramInt = 1;
          }
          else if (jH())
          {
            paramInt = -1;
          }
          else
          {
            paramInt = 1;
            continue;
            if (this.mOrientation == 1)
            {
              paramInt = -1;
            }
            else
            {
              paramInt = -2147483648;
              continue;
              if (this.mOrientation == 1)
              {
                paramInt = 1;
              }
              else
              {
                paramInt = -2147483648;
                continue;
                if (this.mOrientation == 0)
                {
                  paramInt = -1;
                }
                else
                {
                  paramInt = -2147483648;
                  continue;
                  if (this.mOrientation == 0) {
                    paramInt = 1;
                  } else {
                    paramInt = -2147483648;
                  }
                }
              }
            }
          }
        }
      }
      paramView = (LayoutParams)localView.getLayoutParams();
      boolean bool = paramView.axg;
      localb = paramView.axf;
      if (paramInt == 1) {}
      for (i = mH();; i = mI())
      {
        a(i, params);
        cz(paramInt);
        paramView = this.awQ;
        paramView.apZ = (paramView.aqa + i);
        this.awQ.apY = ((int)(0.3333333F * this.awN.kJ()));
        this.awQ.aqd = true;
        this.awQ.apX = false;
        a(paramn, this.awQ, params);
        this.awU = this.aqv;
        if (bool) {
          break;
        }
        paramView = localb.aJ(i, paramInt);
        if ((paramView == null) || (paramView == localView)) {
          break;
        }
        return paramView;
      }
      if (cG(paramInt))
      {
        j = this.apM - 1;
        while (j >= 0)
        {
          paramView = this.awM[j].aJ(i, paramInt);
          if ((paramView != null) && (paramView != localView)) {
            return paramView;
          }
          j -= 1;
        }
      }
      j = 0;
      while (j < this.apM)
      {
        paramView = this.awM[j].aJ(i, paramInt);
        if ((paramView != null) && (paramView != localView)) {
          return paramView;
        }
        j += 1;
      }
      if (this.aqu) {
        break label622;
      }
      i = 1;
      if (paramInt != -1) {
        break label628;
      }
      j = 1;
      if (i != j) {
        break label634;
      }
      i = 1;
      if (bool) {
        break;
      }
      if (i == 0) {
        break label640;
      }
      j = localb.mR();
      paramn = findViewByPosition(j);
      if (paramn == null) {
        break;
      }
      paramView = paramn;
    } while (paramn != localView);
    label516:
    label533:
    if (cG(paramInt))
    {
      paramInt = this.apM - 1;
      label567:
      if (paramInt >= 0)
      {
        if (paramInt != localb.mIndex) {
          if (i == 0) {
            break label650;
          }
        }
        for (j = this.awM[paramInt].mR();; j = this.awM[paramInt].mS())
        {
          paramn = findViewByPosition(j);
          if (paramn != null)
          {
            paramView = paramn;
            if (paramn != localView) {
              break;
            }
          }
          paramInt -= 1;
          break label567;
          label622:
          i = 0;
          break label498;
          label628:
          j = 0;
          break label506;
          label634:
          i = 0;
          break label516;
          j = localb.mS();
          break label533;
        }
      }
    }
    else
    {
      paramInt = 0;
      while (paramInt < this.apM)
      {
        if (i != 0) {}
        for (j = this.awM[paramInt].mR();; j = this.awM[paramInt].mS())
        {
          paramView = findViewByPosition(j);
          if ((paramView == null) || (paramView == localView)) {
            break;
          }
          return paramView;
        }
        paramInt += 1;
      }
    }
    label640:
    label650:
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      localView1 = aA(false);
      localView2 = aB(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = getPosition(localView1);
    int j = getPosition(localView2);
    if (i < j)
    {
      paramAccessibilityEvent.setFromIndex(i);
      paramAccessibilityEvent.setToIndex(j);
      return;
    }
    paramAccessibilityEvent.setFromIndex(j);
    paramAccessibilityEvent.setToIndex(i);
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, c paramc)
  {
    int i = 1;
    paramn = paramView.getLayoutParams();
    if (!(paramn instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramc);
      return;
    }
    paramn = (LayoutParams)paramn;
    int k;
    int m;
    int j;
    if (this.mOrientation == 0)
    {
      k = paramn.kj();
      if (paramn.axg) {
        i = this.apM;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      paramc.H(c.c.a(k, j, m, i, paramn.axg));
      return;
      m = paramn.kj();
      if (paramn.axg)
      {
        i = this.apM;
        j = -1;
        k = -1;
      }
      else
      {
        i = 1;
        j = -1;
        k = -1;
      }
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    n(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.awS.clear();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    n(paramInt1, paramInt2, 8);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    n(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    n(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    int j = 1;
    a locala = this.awY;
    if (((this.awW != null) || (this.aqy != -1)) && (params.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      locala.reset();
      label41:
      return;
    }
    int k;
    int m;
    label112:
    int n;
    if ((!locala.aqH) || (this.aqy != -1) || (this.awW != null))
    {
      k = 1;
      if (k == 0) {
        break label464;
      }
      locala.reset();
      if (this.awW == null) {
        break label615;
      }
      if (this.awW.axm <= 0) {
        break label268;
      }
      if (this.awW.axm != this.apM) {
        break label218;
      }
      m = 0;
      if (m >= this.apM) {
        break label268;
      }
      this.awM[m].clear();
      n = this.awW.axn[m];
      i = n;
      if (n != -2147483648) {
        if (!this.awW.aqR) {
          break label203;
        }
      }
    }
    label203:
    for (int i = n + this.awN.kI();; i = n + this.awN.kH())
    {
      this.awM[m].cS(i);
      m += 1;
      break label112;
      k = 0;
      break;
    }
    label218:
    Object localObject1 = this.awW;
    ((StaggeredGridLayoutManager.SavedState)localObject1).axn = null;
    ((StaggeredGridLayoutManager.SavedState)localObject1).axm = 0;
    ((StaggeredGridLayoutManager.SavedState)localObject1).axo = 0;
    ((StaggeredGridLayoutManager.SavedState)localObject1).axp = null;
    ((StaggeredGridLayoutManager.SavedState)localObject1).axh = null;
    this.awW.aqP = this.awW.axl;
    label268:
    this.awV = this.awW.awV;
    ao(this.awW.aqu);
    kl();
    if (this.awW.aqP != -1)
    {
      this.aqy = this.awW.aqP;
      locala.aqG = this.awW.aqR;
      if (this.awW.axo > 1)
      {
        this.awS.mData = this.awW.axp;
        this.awS.axh = this.awW.axh;
      }
      label367:
      if ((!params.aue) && (this.aqy != -1)) {
        break label631;
      }
      i = 0;
      label385:
      if (i == 0)
      {
        if (!this.awU) {
          break label1150;
        }
        n = params.getItemCount();
        i = getChildCount() - 1;
        label411:
        if (i < 0) {
          break label1144;
        }
        m = getPosition(getChildAt(i));
        if ((m < 0) || (m >= n)) {
          break label1135;
        }
        i = m;
      }
    }
    label464:
    label615:
    label631:
    boolean bool;
    label722:
    label854:
    label992:
    label1020:
    label1150:
    int i1;
    for (;;)
    {
      locala.mPosition = i;
      locala.fs = -2147483648;
      locala.aqH = true;
      if ((this.awW == null) && (this.aqy == -1) && ((locala.aqG != this.awU) || (jH() != this.awV)))
      {
        this.awS.clear();
        locala.axd = true;
      }
      if ((getChildCount() <= 0) || ((this.awW != null) && (this.awW.axm > 0))) {
        break label1527;
      }
      if (!locala.axd) {
        break label1215;
      }
      i = 0;
      while (i < this.apM)
      {
        this.awM[i].clear();
        if (locala.fs != -2147483648) {
          this.awM[i].cS(locala.fs);
        }
        i += 1;
      }
      locala.aqG = this.aqv;
      break;
      kl();
      locala.aqG = this.aqv;
      break label367;
      if ((this.aqy < 0) || (this.aqy >= params.getItemCount()))
      {
        this.aqy = -1;
        this.aqz = -2147483648;
        i = 0;
        break label385;
      }
      if ((this.awW == null) || (this.awW.aqP == -1) || (this.awW.axm <= 0))
      {
        localObject1 = findViewByPosition(this.aqy);
        if (localObject1 != null)
        {
          if (this.aqv)
          {
            i = mH();
            locala.mPosition = i;
            if (this.aqz == -2147483648) {
              break label818;
            }
            if (!locala.aqG) {
              break label788;
            }
          }
          label788:
          for (locala.fs = (this.awN.kI() - this.aqz - this.awN.bp((View)localObject1));; locala.fs = (this.awN.kH() + this.aqz - this.awN.bo((View)localObject1)))
          {
            i = 1;
            break;
            i = mI();
            break label722;
          }
          label818:
          if (this.awN.bs((View)localObject1) > this.awN.kJ()) {
            if (locala.aqG)
            {
              i = this.awN.kI();
              locala.fs = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.awN.kH();
        break label854;
        i = this.awN.bo((View)localObject1) - this.awN.kH();
        if (i < 0)
        {
          locala.fs = (-i);
        }
        else
        {
          i = this.awN.kI() - this.awN.bp((View)localObject1);
          if (i < 0)
          {
            locala.fs = i;
          }
          else
          {
            locala.fs = -2147483648;
            continue;
            locala.mPosition = this.aqy;
            if (this.aqz == -2147483648) {
              if (cH(locala.mPosition) == 1)
              {
                bool = true;
                locala.aqG = bool;
                if (!locala.aqG) {
                  break label1042;
                }
                i = locala.axc.awN.kI();
                locala.fs = i;
              }
            }
            for (;;)
            {
              locala.axd = true;
              break;
              bool = false;
              break label992;
              label1042:
              i = locala.axc.awN.kH();
              break label1020;
              i = this.aqz;
              if (locala.aqG) {
                locala.fs = (locala.axc.awN.kI() - i);
              } else {
                locala.fs = (i + locala.axc.awN.kH());
              }
            }
            locala.fs = -2147483648;
            locala.mPosition = this.aqy;
          }
        }
      }
      label1135:
      i -= 1;
      break label411;
      label1144:
      i = 0;
      continue;
      i1 = params.getItemCount();
      int i2 = getChildCount();
      m = 0;
      for (;;)
      {
        if (m >= i2) {
          break label1209;
        }
        n = getPosition(getChildAt(m));
        if (n >= 0)
        {
          i = n;
          if (n < i1) {
            break;
          }
        }
        m += 1;
      }
      label1209:
      i = 0;
    }
    label1215:
    label1278:
    Object localObject2;
    if ((k != 0) || (this.awY.axe == null))
    {
      k = 0;
      if (k < this.apM)
      {
        localObject1 = this.awM[k];
        bool = this.aqv;
        n = locala.fs;
        if (bool)
        {
          i = ((b)localObject1).cR(-2147483648);
          ((b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((b)localObject1).axc.awN.kI())) && ((bool) || (i <= ((b)localObject1).axc.awN.kH()))) {
            break label1353;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = ((b)localObject1).cQ(-2147483648);
          break label1278;
          label1353:
          m = i;
          if (n != -2147483648) {
            m = i + n;
          }
          ((b)localObject1).axs = m;
          ((b)localObject1).axr = m;
        }
      }
      localObject1 = this.awY;
      localObject2 = this.awM;
      k = localObject2.length;
      if ((((a)localObject1).axe == null) || (((a)localObject1).axe.length < k)) {
        ((a)localObject1).axe = new int[((a)localObject1).axc.awM.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((a)localObject1).axe[i] = localObject2[i].cQ(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.apM)
      {
        localObject1 = this.awM[i];
        ((b)localObject1).clear();
        ((b)localObject1).cS(this.awY.axe[i]);
        i += 1;
      }
    }
    label1527:
    detachAndScrapAttachedViews(paramn);
    this.awQ.apX = false;
    this.awZ = false;
    cy(this.awO.kJ());
    a(locala.mPosition, params);
    label1626:
    float f1;
    if (locala.aqG)
    {
      cz(-1);
      a(paramn, this.awQ, params);
      cz(1);
      this.awQ.apZ = (locala.mPosition + this.awQ.aqa);
      a(paramn, this.awQ, params);
      if (this.awO.getMode() == 1073741824) {
        break label2012;
      }
      f1 = 0.0F;
      m = getChildCount();
      i = 0;
      label1650:
      if (i >= m) {
        break label1781;
      }
      localObject1 = getChildAt(i);
      float f2 = this.awO.bs((View)localObject1);
      if (f2 < f1) {
        break label2201;
      }
      if (!((LayoutParams)((View)localObject1).getLayoutParams()).axg) {
        break label2198;
      }
      f2 = 1.0F * f2 / this.apM;
      label1710:
      f1 = Math.max(f1, f2);
    }
    label2192:
    label2198:
    label2201:
    for (;;)
    {
      i += 1;
      break label1650;
      cz(1);
      a(paramn, this.awQ, params);
      cz(-1);
      this.awQ.apZ = (locala.mPosition + this.awQ.aqa);
      a(paramn, this.awQ, params);
      break label1626;
      label1781:
      n = this.awP;
      k = Math.round(this.apM * f1);
      i = k;
      if (this.awO.getMode() == -2147483648) {
        i = Math.min(k, this.awO.kJ());
      }
      cy(i);
      if (this.awP != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (!((LayoutParams)localObject2).axg)
          {
            if ((!jH()) || (this.mOrientation != 1)) {
              break label1950;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.apM - 1 - ((LayoutParams)localObject2).axf.mIndex) * this.awP - -(this.apM - 1 - ((LayoutParams)localObject2).axf.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            label1950:
            k = ((LayoutParams)localObject2).axf.mIndex * this.awP;
            i1 = ((LayoutParams)localObject2).axf.mIndex * n;
            if (this.mOrientation == 1) {
              ((View)localObject1).offsetLeftAndRight(k - i1);
            } else {
              ((View)localObject1).offsetTopAndBottom(k - i1);
            }
          }
        }
      }
      label2012:
      if (getChildCount() > 0)
      {
        if (this.aqv)
        {
          a(paramn, params, true);
          b(paramn, params, false);
        }
      }
      else
      {
        label2040:
        k = 0;
        i = k;
        if (j != 0)
        {
          i = k;
          if (!params.aue) {
            if ((this.awT == 0) || (getChildCount() <= 0) || ((!this.awZ) && (mC() == null))) {
              break label2192;
            }
          }
        }
      }
      for (j = 1;; j = 0)
      {
        i = k;
        if (j != 0)
        {
          removeCallbacks(this.axb);
          i = k;
          if (mB()) {
            i = 1;
          }
        }
        if (params.aue) {
          this.awY.reset();
        }
        this.awU = locala.aqG;
        this.awV = jH();
        if (i == 0) {
          break label41;
        }
        this.awY.reset();
        j = 0;
        break;
        b(paramn, params, true);
        a(paramn, params, false);
        break label2040;
      }
      break label1710;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    super.onLayoutCompleted(params);
    this.aqy = -1;
    this.aqz = -2147483648;
    this.awW = null;
    this.awY.reset();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof StaggeredGridLayoutManager.SavedState))
    {
      this.awW = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.awW != null) {
      return new StaggeredGridLayoutManager.SavedState(this.awW);
    }
    StaggeredGridLayoutManager.SavedState localSavedState = new StaggeredGridLayoutManager.SavedState();
    localSavedState.aqu = this.aqu;
    localSavedState.aqR = this.awU;
    localSavedState.awV = this.awV;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((this.awS != null) && (this.awS.mData != null))
    {
      localSavedState.axp = this.awS.mData;
      localSavedState.axo = localSavedState.axp.length;
      localSavedState.axh = this.awS.axh;
      if (getChildCount() <= 0) {
        break label311;
      }
      if (!this.awU) {
        break label250;
      }
      i = mH();
      localSavedState.aqP = i;
      if (!this.aqv) {
        break label258;
      }
      localView = aB(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      localSavedState.axl = i;
      localSavedState.axm = this.apM;
      localSavedState.axn = new int[this.apM];
      j = 0;
      if (j >= this.apM) {
        break label329;
      }
      if (!this.awU) {
        break label278;
      }
      k = this.awM[j].cR(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.awN.kI();
      }
    }
    for (;;)
    {
      localSavedState.axn[j] = i;
      j += 1;
      break label181;
      localSavedState.axo = 0;
      break;
      label250:
      i = mI();
      break label126;
      label258:
      localView = aA(true);
      break label146;
      label268:
      i = getPosition(localView);
      break label153;
      label278:
      k = this.awM[j].cQ(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.awN.kH();
      }
    }
    label311:
    localSavedState.aqP = -1;
    localSavedState.axl = -1;
    localSavedState.axm = 0;
    label329:
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      mB();
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    return a(paramInt, paramn, params);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((this.awW != null) && (this.awW.aqP != paramInt)) {
      this.awW.mK();
    }
    this.aqy = paramInt;
    this.aqz = -2147483648;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    return a(paramInt, paramn, params);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.awP * this.apM, getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.awP * this.apM, getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.atO = paramInt;
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return this.awW == null;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b axf;
    boolean axg;
    
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
    
    public final void aC(boolean paramBoolean)
    {
      this.axg = paramBoolean;
    }
    
    public final int kj()
    {
      if (this.axf == null) {
        return -1;
      }
      return this.axf.mIndex;
    }
    
    public final boolean mJ()
    {
      return this.axg;
    }
  }
  
  static final class LazySpanLookup
  {
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> axh;
    int[] mData;
    
    private void aF(int paramInt1, int paramInt2)
    {
      if (this.axh == null) {
        return;
      }
      int i = this.axh.size() - 1;
      label20:
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i);
        if (localFullSpanItem.mPosition >= paramInt1)
        {
          if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
            break label77;
          }
          this.axh.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break label20;
        break;
        label77:
        localFullSpanItem.mPosition -= paramInt2;
      }
    }
    
    private void aH(int paramInt1, int paramInt2)
    {
      if (this.axh == null) {}
      for (;;)
      {
        return;
        int i = this.axh.size() - 1;
        while (i >= 0)
        {
          StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i);
          if (localFullSpanItem.mPosition >= paramInt1) {
            localFullSpanItem.mPosition += paramInt2;
          }
          i -= 1;
        }
      }
    }
    
    private int cL(int paramInt)
    {
      int i = this.mData.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    private void cM(int paramInt)
    {
      if (this.mData == null)
      {
        this.mData = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(this.mData, -1);
      }
      while (paramInt < this.mData.length) {
        return;
      }
      int[] arrayOfInt = this.mData;
      this.mData = new int[cL(paramInt)];
      System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
      Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
    }
    
    private int cN(int paramInt)
    {
      if (this.axh == null) {
        return -1;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = cO(paramInt);
      if (localFullSpanItem != null) {
        this.axh.remove(localFullSpanItem);
      }
      int j = this.axh.size();
      int i = 0;
      if (i < j) {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i)).mPosition < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i);
          this.axh.remove(i);
          return localFullSpanItem.mPosition;
          i += 1;
          break;
        }
        return -1;
        i = -1;
      }
    }
    
    final void a(int paramInt, StaggeredGridLayoutManager.b paramb)
    {
      cM(paramInt);
      this.mData[paramInt] = paramb.mIndex;
    }
    
    public final void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
    {
      if (this.axh == null) {
        this.axh = new ArrayList();
      }
      int j = this.axh.size();
      int i = 0;
      while (i < j)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i);
        if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
          this.axh.remove(i);
        }
        if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
        {
          this.axh.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.axh.add(paramFullSpanItem);
    }
    
    final void aE(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
        return;
      }
      cM(paramInt1 + paramInt2);
      int[] arrayOfInt1 = this.mData;
      int[] arrayOfInt2 = this.mData;
      System.arraycopy(arrayOfInt1, paramInt1 + paramInt2, arrayOfInt2, paramInt1, arrayOfInt2.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
      aF(paramInt1, paramInt2);
    }
    
    final void aG(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
        return;
      }
      cM(paramInt1 + paramInt2);
      int[] arrayOfInt = this.mData;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      aH(paramInt1, paramInt2);
    }
    
    final int cI(int paramInt)
    {
      if (this.axh != null)
      {
        int i = this.axh.size() - 1;
        while (i >= 0)
        {
          if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i)).mPosition >= paramInt) {
            this.axh.remove(i);
          }
          i -= 1;
        }
      }
      return cJ(paramInt);
    }
    
    final int cJ(int paramInt)
    {
      if (this.mData == null) {}
      while (paramInt >= this.mData.length) {
        return -1;
      }
      int i = cN(paramInt);
      if (i == -1)
      {
        int[] arrayOfInt = this.mData;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        return this.mData.length;
      }
      Arrays.fill(this.mData, paramInt, i + 1, -1);
      return i + 1;
    }
    
    final int cK(int paramInt)
    {
      if ((this.mData == null) || (paramInt >= this.mData.length)) {
        return -1;
      }
      return this.mData[paramInt];
    }
    
    public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cO(int paramInt)
    {
      Object localObject;
      if (this.axh == null)
      {
        localObject = null;
        return localObject;
      }
      int i = this.axh.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label61;
        }
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i);
        localObject = localFullSpanItem;
        if (localFullSpanItem.mPosition == paramInt) {
          break;
        }
        i -= 1;
      }
      label61:
      return null;
    }
    
    final void clear()
    {
      if (this.mData != null) {
        Arrays.fill(this.mData, -1);
      }
      this.axh = null;
    }
    
    public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem o(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if (this.axh == null)
      {
        localObject = null;
        return localObject;
      }
      int j = this.axh.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label112;
        }
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.axh.get(i);
        if (localFullSpanItem.mPosition >= paramInt2) {
          return null;
        }
        if (localFullSpanItem.mPosition >= paramInt1)
        {
          localObject = localFullSpanItem;
          if (paramInt3 == 0) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.axi == paramInt3) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.axk) {
            break;
          }
        }
        i += 1;
      }
      label112:
      return null;
    }
  }
  
  final class a
  {
    boolean aqG;
    boolean aqH;
    boolean axd;
    int[] axe;
    int fs;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.fs = -2147483648;
      this.aqG = false;
      this.axd = false;
      this.aqH = false;
      if (this.axe != null) {
        Arrays.fill(this.axe, -1);
      }
    }
  }
  
  final class b
  {
    ArrayList<View> axq = new ArrayList();
    int axr = -2147483648;
    int axs = -2147483648;
    int axt = 0;
    final int mIndex;
    
    b(int paramInt)
    {
      this.mIndex = paramInt;
    }
    
    private int a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int m = StaggeredGridLayoutManager.this.awN.kH();
      int n = StaggeredGridLayoutManager.this.awN.kI();
      int j;
      int k;
      if (paramInt2 > paramInt1)
      {
        j = 1;
        k = paramInt1;
      }
      while (k != paramInt2)
      {
        View localView = (View)this.axq.get(k);
        int i1 = StaggeredGridLayoutManager.this.awN.bo(localView);
        int i2 = StaggeredGridLayoutManager.this.awN.bp(localView);
        label97:
        int i;
        if (paramBoolean3) {
          if (i1 <= n)
          {
            paramInt1 = 1;
            if (!paramBoolean3) {
              break label191;
            }
            if (i2 < m) {
              break label185;
            }
            i = 1;
          }
        }
        for (;;)
        {
          if ((paramInt1 != 0) && (i != 0))
          {
            if ((paramBoolean1) && (paramBoolean2))
            {
              if ((i1 < m) || (i2 > n)) {
                break label249;
              }
              return StaggeredGridLayoutManager.this.getPosition(localView);
              j = -1;
              k = paramInt1;
              break;
              paramInt1 = 0;
              break label97;
              if (i1 < n)
              {
                paramInt1 = 1;
                break label97;
              }
              paramInt1 = 0;
              break label97;
              label185:
              i = 0;
              continue;
              label191:
              if (i2 > m)
              {
                i = 1;
                continue;
              }
              i = 0;
              continue;
            }
            if (paramBoolean2) {
              return StaggeredGridLayoutManager.this.getPosition(localView);
            }
            if ((i1 < m) || (i2 > n)) {
              return StaggeredGridLayoutManager.this.getPosition(localView);
            }
          }
        }
        label249:
        k += j;
      }
      return -1;
    }
    
    private int aI(int paramInt1, int paramInt2)
    {
      return a(paramInt1, paramInt2, false, false, true);
    }
    
    private void hw()
    {
      this.axr = -2147483648;
      this.axs = -2147483648;
    }
    
    private void mL()
    {
      Object localObject = (View)this.axq.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.axr = StaggeredGridLayoutManager.this.awN.bo((View)localObject);
      if (localLayoutParams.axg)
      {
        localObject = StaggeredGridLayoutManager.this.awS.cO(localLayoutParams.atw.lQ());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).axi == -1)) {
          this.axr -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cP(this.mIndex);
        }
      }
    }
    
    private void mN()
    {
      Object localObject = (View)this.axq.get(this.axq.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.axs = StaggeredGridLayoutManager.this.awN.bp((View)localObject);
      if (localLayoutParams.axg)
      {
        localObject = StaggeredGridLayoutManager.this.awS.cO(localLayoutParams.atw.lQ());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).axi == 1))
        {
          int i = this.axs;
          this.axs = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cP(this.mIndex) + i);
        }
      }
    }
    
    public final View aJ(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      if (paramInt2 == -1)
      {
        int i = this.axq.size();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView2 = (View)this.axq.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.aqu) && (StaggeredGridLayoutManager.this.getPosition(localView2) <= paramInt1)) || ((!StaggeredGridLayoutManager.this.aqu) && (StaggeredGridLayoutManager.this.getPosition(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 += 1;
          localView1 = localView2;
        }
        return localView1;
      }
      paramInt2 = this.axq.size() - 1;
      for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
      {
        localView2 = (View)this.axq.get(paramInt2);
        if (((StaggeredGridLayoutManager.this.aqu) && (StaggeredGridLayoutManager.this.getPosition(localView2) >= paramInt1)) || ((!StaggeredGridLayoutManager.this.aqu) && (StaggeredGridLayoutManager.this.getPosition(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
          break;
        }
        paramInt2 -= 1;
      }
      return localView1;
    }
    
    final void bK(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.axf = this;
      this.axq.add(0, paramView);
      this.axr = -2147483648;
      if (this.axq.size() == 1) {
        this.axs = -2147483648;
      }
      if ((localLayoutParams.atw.isRemoved()) || (localLayoutParams.atw.mh())) {
        this.axt += StaggeredGridLayoutManager.this.awN.bs(paramView);
      }
    }
    
    final void bL(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.axf = this;
      this.axq.add(paramView);
      this.axs = -2147483648;
      if (this.axq.size() == 1) {
        this.axr = -2147483648;
      }
      if ((localLayoutParams.atw.isRemoved()) || (localLayoutParams.atw.mh())) {
        this.axt += StaggeredGridLayoutManager.this.awN.bs(paramView);
      }
    }
    
    final int cQ(int paramInt)
    {
      if (this.axr != -2147483648) {
        paramInt = this.axr;
      }
      while (this.axq.size() == 0) {
        return paramInt;
      }
      mL();
      return this.axr;
    }
    
    final int cR(int paramInt)
    {
      if (this.axs != -2147483648) {
        paramInt = this.axs;
      }
      while (this.axq.size() == 0) {
        return paramInt;
      }
      mN();
      return this.axs;
    }
    
    final void cS(int paramInt)
    {
      this.axr = paramInt;
      this.axs = paramInt;
    }
    
    final void cT(int paramInt)
    {
      if (this.axr != -2147483648) {
        this.axr += paramInt;
      }
      if (this.axs != -2147483648) {
        this.axs += paramInt;
      }
    }
    
    final void clear()
    {
      this.axq.clear();
      hw();
      this.axt = 0;
    }
    
    final int f(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return a(paramInt1, paramInt2, paramBoolean, true, false);
    }
    
    final int mM()
    {
      if (this.axr != -2147483648) {
        return this.axr;
      }
      mL();
      return this.axr;
    }
    
    final int mO()
    {
      if (this.axs != -2147483648) {
        return this.axs;
      }
      mN();
      return this.axs;
    }
    
    final void mP()
    {
      int i = this.axq.size();
      View localView = (View)this.axq.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.axf = null;
      if ((localLayoutParams.atw.isRemoved()) || (localLayoutParams.atw.mh())) {
        this.axt -= StaggeredGridLayoutManager.this.awN.bs(localView);
      }
      if (i == 1) {
        this.axr = -2147483648;
      }
      this.axs = -2147483648;
    }
    
    final void mQ()
    {
      View localView = (View)this.axq.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.axf = null;
      if (this.axq.size() == 0) {
        this.axs = -2147483648;
      }
      if ((localLayoutParams.atw.isRemoved()) || (localLayoutParams.atw.mh())) {
        this.axt -= StaggeredGridLayoutManager.this.awN.bs(localView);
      }
      this.axr = -2147483648;
    }
    
    public final int mR()
    {
      if (StaggeredGridLayoutManager.this.aqu) {
        return aI(this.axq.size() - 1, -1);
      }
      return aI(0, this.axq.size());
    }
    
    public final int mS()
    {
      if (StaggeredGridLayoutManager.this.aqu) {
        return aI(0, this.axq.size());
      }
      return aI(this.axq.size() - 1, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */