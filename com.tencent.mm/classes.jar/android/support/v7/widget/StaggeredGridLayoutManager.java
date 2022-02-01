package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.c;
import android.support.v4.view.a.c.c;
import android.support.v4.view.t;
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
  extends RecyclerView.i
  implements RecyclerView.s.b
{
  private final Rect TW = new Rect();
  public int apA = -1;
  boolean aqi = false;
  boolean aqj = false;
  private boolean aql = true;
  int aqm = -1;
  int aqn = -2147483648;
  b[] awO;
  aj awP;
  aj awQ;
  private int awR;
  private final ad awS;
  private BitSet awT;
  LazySpanLookup awU = new LazySpanLookup();
  private int awV = 2;
  private boolean awW;
  private boolean awX;
  private SavedState awY;
  private int awZ;
  private final a axa = new a();
  private boolean axb = false;
  private int[] axc;
  private final Runnable axd = new Runnable()
  {
    public final void run()
    {
      StaggeredGridLayoutManager.this.mx();
    }
  };
  public int mOrientation;
  
  public StaggeredGridLayoutManager(int paramInt)
  {
    this.mOrientation = 1;
    bV(paramInt);
    this.awS = new ad();
    mw();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = paramContext.orientation;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    F(null);
    if (paramInt1 != this.mOrientation)
    {
      this.mOrientation = paramInt1;
      paramAttributeSet = this.awP;
      this.awP = this.awQ;
      this.awQ = paramAttributeSet;
      requestLayout();
    }
    bV(paramContext.atv);
    ap(paramContext.atw);
    this.awS = new ad();
    mw();
  }
  
  private int a(RecyclerView.o paramo, ad paramad, RecyclerView.t paramt)
  {
    this.awT.set(0, this.apA, true);
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
    if (this.awS.apS) {
      if (paramad.mLayoutDirection == 1)
      {
        i = 2147483647;
        aJ(paramad.mLayoutDirection, i);
        if (!this.aqj) {
          break label552;
        }
        m = this.awP.kC();
        j = 0;
        if ((!paramad.b(paramt)) || ((!this.awS.apS) && (this.awT.isEmpty()))) {
          break label868;
        }
        localView = paramad.a(paramo);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.aty.lM();
        j = this.awU.cQ(i2);
        if (j != -1) {
          break label564;
        }
        i1 = 1;
        if (i1 == 0) {
          break label580;
        }
        if (!localLayoutParams.axi) {
          break label570;
        }
        localb = this.awO[0];
        this.awU.a(i2, localb);
        localLayoutParams.axh = localb;
        if (paramad.mLayoutDirection != 1) {
          break label592;
        }
        addView(localView);
        a(localView, localLayoutParams);
        if (paramad.mLayoutDirection != 1) {
          break label614;
        }
        if (!localLayoutParams.axi) {
          break label602;
        }
        j = cK(m);
        n = this.awP.br(localView) + j;
        if ((i1 == 0) || (!localLayoutParams.axi)) {
          break label959;
        }
        localFullSpanItem = cG(j);
        localFullSpanItem.axk = -1;
        localFullSpanItem.mPosition = i2;
        this.awU.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.axi) && (paramad.apO == -1))
      {
        if (i1 == 0)
        {
          if (paramad.mLayoutDirection != 1) {
            break label712;
          }
          if (mC()) {
            break label706;
          }
          j = 1;
          label324:
          if (j == 0) {
            break label356;
          }
          localFullSpanItem = this.awU.cU(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.axm = true;
          }
        }
        this.axb = true;
      }
      label356:
      a(localView, localLayoutParams, paramad);
      if ((jy()) && (this.mOrientation == 1)) {
        if (localLayoutParams.axi)
        {
          j = this.awQ.kC();
          label397:
          i2 = j - this.awQ.br(localView);
          i1 = j;
          j = i2;
          if (this.mOrientation != 1) {
            break label818;
          }
          k(localView, j, k, i1, n);
          label440:
          if (!localLayoutParams.axi) {
            break label834;
          }
          aJ(this.awS.mLayoutDirection, i);
          label461:
          a(paramo, this.awS);
          if ((this.awS.apR) && (localView.hasFocusable()))
          {
            if (!localLayoutParams.axi) {
              break label852;
            }
            this.awT.clear();
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
          i = paramad.apQ + paramad.apM;
          break;
        }
        i = paramad.apP - paramad.apM;
        break;
        label552:
        m = this.awP.kB();
        break label61;
        label564:
        i1 = 0;
        break label139;
        label570:
        localb = a(paramad);
        break label160;
        label580:
        localb = this.awO[j];
        break label171;
        label592:
        addView(localView, 0);
        break label192;
        label602:
        j = localb.cX(m);
        break label224;
        label614:
        if (localLayoutParams.axi) {}
        for (j = cJ(m);; j = localb.cW(m))
        {
          k = j - this.awP.br(localView);
          if ((i1 != 0) && (localLayoutParams.axi))
          {
            localFullSpanItem = cH(j);
            localFullSpanItem.axk = 1;
            localFullSpanItem.mPosition = i2;
            this.awU.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        label706:
        j = 0;
        break label324;
        label712:
        if (!mD())
        {
          j = 1;
          break label324;
        }
        j = 0;
        break label324;
        j = this.awQ.kC() - (this.apA - 1 - localb.mIndex) * this.awR;
        break label397;
        if (localLayoutParams.axi) {}
        for (j = this.awQ.kB();; j = localb.mIndex * this.awR + this.awQ.kB())
        {
          i1 = j + this.awQ.br(localView);
          break;
        }
        label818:
        k(localView, k, j, n, i1);
        break label440;
        label834:
        a(localb, this.awS.mLayoutDirection, i);
        break label461;
        label852:
        this.awT.set(localb.mIndex, false);
      }
      label868:
      if (j == 0) {
        a(paramo, this.awS);
      }
      if (this.awS.mLayoutDirection == -1) {
        i = cJ(this.awP.kB());
      }
      for (i = this.awP.kB() - i; i > 0; i = cK(this.awP.kC()) - this.awP.kC()) {
        return Math.min(paramad.apM, i);
      }
      return 0;
      label959:
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
    if (cM(paramad.mLayoutDirection))
    {
      i = this.apA - 1;
      j = -1;
      k = -1;
      if (paramad.mLayoutDirection != 1) {
        break label121;
      }
      n = 2147483647;
      i1 = this.awP.kB();
      m = i;
      paramad = (ad)localObject1;
      i = n;
      label59:
      localObject1 = paramad;
      if (m == k) {
        break label192;
      }
      localObject1 = this.awO[m];
      n = ((b)localObject1).cX(i1);
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
      k = this.apA;
      j = 1;
      break;
      label121:
      n = -2147483648;
      i1 = this.awP.kC();
      m = i;
      paramad = localObject2;
      i = n;
      localObject1 = paramad;
      if (m != k)
      {
        localObject1 = this.awO[m];
        n = ((b)localObject1).cW(i1);
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
  
  private void a(int paramInt, RecyclerView.t paramt)
  {
    boolean bool2 = false;
    this.awS.apM = 0;
    this.awS.apN = paramInt;
    int i;
    boolean bool1;
    if (lx())
    {
      i = paramt.atQ;
      if (i != -1)
      {
        boolean bool3 = this.aqj;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.awP.kD();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.awS.apP = (this.awP.kB() - i);
        this.awS.apQ = (paramInt + this.awP.kC());
      }
      for (;;)
      {
        this.awS.apR = false;
        this.awS.apL = true;
        paramt = this.awS;
        bool1 = bool2;
        if (this.awP.getMode() == 0)
        {
          bool1 = bool2;
          if (this.awP.getEnd() == 0) {
            bool1 = true;
          }
        }
        paramt.apS = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i = this.awP.kD();
        paramInt = 0;
        break label67;
        this.awS.apQ = (paramInt + this.awP.getEnd());
        this.awS.apP = (-i);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private void a(RecyclerView.o paramo, int paramInt)
  {
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if ((this.awP.bo(localView) <= paramInt) && (this.awP.bp(localView) <= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.axi) {
            break label118;
          }
          i = 0;
          if (i >= this.apA) {
            break label92;
          }
          if (this.awO[i].axs.size() != 1) {
            break label85;
          }
        }
      }
      label85:
      label92:
      label118:
      while (localLayoutParams.axh.axs.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.apA)
        {
          this.awO[i].mO();
          i += 1;
        }
      }
      localLayoutParams.axh.mO();
      a(localView, paramo);
    }
  }
  
  private void a(RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    int i = cK(-2147483648);
    if (i == -2147483648) {}
    do
    {
      do
      {
        return;
        i = this.awP.kC() - i;
      } while (i <= 0);
      i -= -c(-i, paramo, paramt);
    } while ((!paramBoolean) || (i <= 0));
    this.awP.cf(i);
  }
  
  private void a(RecyclerView.o paramo, ad paramad)
  {
    if ((!paramad.apL) || (paramad.apS)) {
      return;
    }
    if (paramad.apM == 0)
    {
      if (paramad.mLayoutDirection == -1)
      {
        b(paramo, paramad.apQ);
        return;
      }
      a(paramo, paramad.apP);
      return;
    }
    if (paramad.mLayoutDirection == -1)
    {
      i = paramad.apP - cI(paramad.apP);
      if (i < 0) {}
      for (i = paramad.apQ;; i = paramad.apQ - Math.min(i, paramad.apM))
      {
        b(paramo, i);
        return;
      }
    }
    int i = cL(paramad.apQ) - paramad.apQ;
    if (i < 0) {}
    int j;
    for (i = paramad.apP;; i = Math.min(i, paramad.apM) + j)
    {
      a(paramo, i);
      return;
      j = paramad.apP;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.axv;
    if (paramInt1 == -1) {
      if (i + paramb.mK() <= paramInt2) {
        this.awT.set(paramb.mIndex, false);
      }
    }
    while (paramb.mM() - i < paramInt2) {
      return;
    }
    this.awT.set(paramb.mIndex, false);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.axi)
    {
      if (this.mOrientation == 1)
      {
        l(paramView, this.awZ, b(this.mHeight, this.att, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
        return;
      }
      l(paramView, b(this.mWidth, this.ats, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.awZ);
      return;
    }
    if (this.mOrientation == 1)
    {
      l(paramView, b(this.awR, this.ats, 0, paramLayoutParams.width, false), b(this.mHeight, this.att, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
      return;
    }
    l(paramView, b(this.mWidth, this.ats, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), b(this.awR, this.att, 0, paramLayoutParams.height, false));
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, ad paramad)
  {
    if (paramad.mLayoutDirection == 1)
    {
      if (paramLayoutParams.axi)
      {
        bW(paramView);
        return;
      }
      paramLayoutParams.axh.bZ(paramView);
      return;
    }
    if (paramLayoutParams.axi)
    {
      bX(paramView);
      return;
    }
    paramLayoutParams.axh.bY(paramView);
  }
  
  private boolean a(b paramb)
  {
    if (this.aqj)
    {
      if (paramb.mM() < this.awP.kC()) {
        return !((LayoutParams)((View)paramb.axs.get(paramb.axs.size() - 1)).getLayoutParams()).axi;
      }
    }
    else if (paramb.mK() > this.awP.kB()) {
      return !((LayoutParams)((View)paramb.axs.get(0)).getLayoutParams()).axi;
    }
    return false;
  }
  
  private View aC(boolean paramBoolean)
  {
    int j = this.awP.kB();
    int k = this.awP.kC();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.awP.bn(localView);
      if ((this.awP.bo(localView) <= j) || (n >= k)) {
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
  
  private View aD(boolean paramBoolean)
  {
    int j = this.awP.kB();
    int k = this.awP.kC();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.awP.bn(localView);
      int n = this.awP.bo(localView);
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
  
  private void aJ(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.apA)
    {
      if (!this.awO[i].axs.isEmpty()) {
        a(this.awO[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private void ap(boolean paramBoolean)
  {
    F(null);
    if ((this.awY != null) && (this.awY.aqi != paramBoolean)) {
      this.awY.aqi = paramBoolean;
    }
    this.aqi = paramBoolean;
    requestLayout();
  }
  
  private void b(int paramInt, RecyclerView.t paramt)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = mE();
      j = 1;
    }
    for (;;)
    {
      this.awS.apL = true;
      a(i, paramt);
      cF(j);
      paramt = this.awS;
      paramt.apN = (i + paramt.apO);
      this.awS.apM = Math.abs(paramInt);
      return;
      j = -1;
      i = mF();
    }
  }
  
  private void b(RecyclerView.o paramo, int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        if ((this.awP.bn(localView) >= paramInt) && (this.awP.bq(localView) >= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.axi) {
            break label132;
          }
          j = 0;
          if (j >= this.apA) {
            break label101;
          }
          if (this.awO[j].axs.size() != 1) {
            break label92;
          }
        }
      }
      label92:
      label101:
      while (localLayoutParams.axh.axs.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.apA)
        {
          this.awO[j].mN();
          j += 1;
        }
      }
      label132:
      localLayoutParams.axh.mN();
      a(localView, paramo);
      i -= 1;
    }
  }
  
  private void b(RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    int i = cJ(2147483647);
    if (i == 2147483647) {}
    do
    {
      do
      {
        return;
        i -= this.awP.kB();
      } while (i <= 0);
      i -= c(i, paramo, paramt);
    } while ((!paramBoolean) || (i <= 0));
    this.awP.cf(-i);
  }
  
  private void bV(int paramInt)
  {
    F(null);
    if (paramInt != this.apA)
    {
      this.awU.clear();
      requestLayout();
      this.apA = paramInt;
      this.awT = new BitSet(this.apA);
      this.awO = new b[this.apA];
      paramInt = 0;
      while (paramInt < this.apA)
      {
        this.awO[paramInt] = new b(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  private void bW(View paramView)
  {
    int i = this.apA - 1;
    while (i >= 0)
    {
      this.awO[i].bZ(paramView);
      i -= 1;
    }
  }
  
  private void bX(View paramView)
  {
    int i = this.apA - 1;
    while (i >= 0)
    {
      this.awO[i].bY(paramView);
      i -= 1;
    }
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    b(paramInt, paramt);
    int j = a(paramo, this.awS, paramt);
    int i = paramInt;
    if (this.awS.apM >= j) {
      if (paramInt >= 0) {
        break label93;
      }
    }
    label93:
    for (i = -j;; i = j)
    {
      this.awP.cf(-i);
      this.awW = this.aqj;
      this.awS.apM = 0;
      a(paramo, this.awS);
      return i;
    }
  }
  
  private void cE(int paramInt)
  {
    this.awR = (paramInt / this.apA);
    this.awZ = View.MeasureSpec.makeMeasureSpec(paramInt, this.awQ.getMode());
  }
  
  private void cF(int paramInt)
  {
    int i = 1;
    this.awS.mLayoutDirection = paramInt;
    ad localad = this.awS;
    boolean bool2 = this.aqj;
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
      localad.apO = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cG(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.axl = new int[this.apA];
    int i = 0;
    while (i < this.apA)
    {
      localFullSpanItem.axl[i] = (paramInt - this.awO[i].cX(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cH(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.axl = new int[this.apA];
    int i = 0;
    while (i < this.apA)
    {
      localFullSpanItem.axl[i] = (this.awO[i].cW(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private int cI(int paramInt)
  {
    int j = this.awO[0].cW(paramInt);
    int i = 1;
    while (i < this.apA)
    {
      int m = this.awO[i].cW(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cJ(int paramInt)
  {
    int j = this.awO[0].cW(paramInt);
    int i = 1;
    while (i < this.apA)
    {
      int m = this.awO[i].cW(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cK(int paramInt)
  {
    int j = this.awO[0].cX(paramInt);
    int i = 1;
    while (i < this.apA)
    {
      int m = this.awO[i].cX(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cL(int paramInt)
  {
    int j = this.awO[0].cX(paramInt);
    int i = 1;
    while (i < this.apA)
    {
      int m = this.awO[i].cX(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private boolean cM(int paramInt)
  {
    int i;
    if (this.mOrientation == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.aqj) {
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
        if (i != this.aqj) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == jy()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private int cN(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.aqj) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < mF()) {}
      for (int i = 1; i != this.aqj; i = 0) {
        return -1;
      }
    }
  }
  
  private int j(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.awP;
    View localView;
    if (!this.aql)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.aql) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, aD(bool1), this, this.aql, this.aqj);
      bool1 = false;
      break;
    }
  }
  
  private boolean jy()
  {
    return t.Y(this.anl) == 1;
  }
  
  private int k(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.awP;
    View localView;
    if (!this.aql)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.aql) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, aD(bool1), this, this.aql);
      bool1 = false;
      break;
    }
  }
  
  private void ke()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!jy())) {
      bool = this.aqi;
    }
    for (;;)
    {
      this.aqj = bool;
      return;
      if (this.aqi) {
        bool = false;
      }
    }
  }
  
  private int l(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.awP;
    View localView;
    if (!this.aql)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.aql) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(paramt, localaj, localView, aD(bool1), this, this.aql);
      bool1 = false;
      break;
    }
  }
  
  private void l(View paramView, int paramInt1, int paramInt2)
  {
    f(paramView, this.TW);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = p(paramInt1, localLayoutParams.leftMargin + this.TW.left, localLayoutParams.rightMargin + this.TW.right);
    paramInt2 = p(paramInt2, localLayoutParams.topMargin + this.TW.top, localLayoutParams.bottomMargin + this.TW.bottom);
    if (b(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private boolean mC()
  {
    boolean bool2 = true;
    int j = this.awO[0].cX(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.apA)
      {
        if (this.awO[i].cX(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean mD()
  {
    boolean bool2 = true;
    int j = this.awO[0].cW(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.apA)
      {
        if (this.awO[i].cW(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int mE()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return bB(getChildAt(i - 1));
  }
  
  private int mF()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return bB(getChildAt(0));
  }
  
  private void mw()
  {
    this.awP = aj.a(this, this.mOrientation);
    this.awQ = aj.a(this, 1 - this.mOrientation);
  }
  
  private View my()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.apA);
    localBitSet.set(0, this.apA, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (jy()))
    {
      j = 1;
      if (!this.aqj) {
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
      if (!localBitSet.get(localLayoutParams.axh.mIndex)) {
        break label162;
      }
      if (!a(localLayoutParams.axh)) {
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
    localBitSet.clear(localLayoutParams.axh.mIndex);
    label162:
    Object localObject;
    int i1;
    if ((!localLayoutParams.axi) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.aqj)
      {
        i = this.awP.bo(localView);
        i1 = this.awP.bo((View)localObject);
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
        if (localLayoutParams.axh.mIndex - ((LayoutParams)localObject).axh.mIndex < 0)
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
          i = this.awP.bn(localView);
          i1 = this.awP.bn((View)localObject);
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
  
  private static int p(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void q(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (this.aqj)
    {
      k = mE();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.awU.cP(i);
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
      k = mF();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.awU.aM(paramInt1, paramInt2);
      break label76;
      this.awU.aK(paramInt1, paramInt2);
      break label76;
      this.awU.aK(paramInt1, 1);
      this.awU.aM(paramInt2, 1);
      break label76;
      if (this.aqj) {}
      for (paramInt1 = mF(); i <= paramInt1; paramInt1 = mE())
      {
        requestLayout();
        return;
      }
    }
  }
  
  public final void F(String paramString)
  {
    if (this.awY == null) {
      super.F(paramString);
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    return c(paramInt, paramo, paramt);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 0) {
      return this.apA;
    }
    return super.a(paramo, paramt);
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
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
      localView = bt(paramView);
      if (localView == null) {
        return null;
      }
      ke();
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
        else if (jy())
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
          else if (jy())
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
      boolean bool = paramView.axi;
      localb = paramView.axh;
      if (paramInt == 1) {}
      for (i = mE();; i = mF())
      {
        a(i, paramt);
        cF(paramInt);
        paramView = this.awS;
        paramView.apN = (paramView.apO + i);
        this.awS.apM = ((int)(0.3333333F * this.awP.kD()));
        this.awS.apR = true;
        this.awS.apL = false;
        a(paramo, this.awS, paramt);
        this.awW = this.aqj;
        if (bool) {
          break;
        }
        paramView = localb.aP(i, paramInt);
        if ((paramView == null) || (paramView == localView)) {
          break;
        }
        return paramView;
      }
      if (cM(paramInt))
      {
        j = this.apA - 1;
        while (j >= 0)
        {
          paramView = this.awO[j].aP(i, paramInt);
          if ((paramView != null) && (paramView != localView)) {
            return paramView;
          }
          j -= 1;
        }
      }
      j = 0;
      while (j < this.apA)
      {
        paramView = this.awO[j].aP(i, paramInt);
        if ((paramView != null) && (paramView != localView)) {
          return paramView;
        }
        j += 1;
      }
      if (this.aqi) {
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
      j = localb.mP();
      paramo = bY(j);
      if (paramo == null) {
        break;
      }
      paramView = paramo;
    } while (paramo != localView);
    label516:
    label533:
    if (cM(paramInt))
    {
      paramInt = this.apA - 1;
      label567:
      if (paramInt >= 0)
      {
        if (paramInt != localb.mIndex) {
          if (i == 0) {
            break label650;
          }
        }
        for (j = this.awO[paramInt].mP();; j = this.awO[paramInt].mQ())
        {
          paramo = bY(j);
          if (paramo != null)
          {
            paramView = paramo;
            if (paramo != localView) {
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
          j = localb.mQ();
          break label533;
        }
      }
    }
    else
    {
      paramInt = 0;
      while (paramInt < this.apA)
      {
        if (i != 0) {}
        for (j = this.awO[paramInt].mP();; j = this.awO[paramInt].mQ())
        {
          paramView = bY(j);
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
  
  public final void a(int paramInt1, int paramInt2, RecyclerView.t paramt, RecyclerView.i.a parama)
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
      b(paramInt1, paramt);
      if ((this.axc == null) || (this.axc.length < this.apA)) {
        this.axc = new int[this.apA];
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramInt2 < this.apA)
      {
        if (this.awS.apO == -1) {}
        for (int j = this.awS.apP - this.awO[paramInt2].cW(this.awS.apP);; j = this.awO[paramInt2].cX(this.awS.apQ) - this.awS.apQ)
        {
          int i = paramInt1;
          if (j >= 0)
          {
            this.axc[paramInt1] = j;
            i = paramInt1 + 1;
          }
          paramInt2 += 1;
          paramInt1 = i;
          break;
        }
      }
      Arrays.sort(this.axc, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.awS.b(paramt)))
      {
        parama.S(this.awS.apN, this.axc[paramInt2]);
        ad localad = this.awS;
        localad.apN += this.awS.apO;
        paramInt2 += 1;
      }
    }
  }
  
  public final void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = m(paramInt2, k + paramRect.height(), t.af(this.anl));
      paramInt2 = m(paramInt1, j + this.awR * this.apA, t.ae(this.anl));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = m(paramInt1, j + paramRect.width(), t.ae(this.anl));
      paramInt1 = m(paramInt2, k + this.awR * this.apA, t.af(this.anl));
      paramInt2 = i;
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.t paramt, View paramView, c paramc)
  {
    int i = 1;
    paramo = paramView.getLayoutParams();
    if (!(paramo instanceof LayoutParams))
    {
      super.a(paramView, paramc);
      return;
    }
    paramo = (LayoutParams)paramo;
    int k;
    int m;
    int j;
    if (this.mOrientation == 0)
    {
      k = paramo.mH();
      if (paramo.axi) {
        i = this.apA;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      paramc.H(c.c.a(k, j, m, i, paramo.axi));
      return;
      m = paramo.mH();
      if (paramo.axi)
      {
        i = this.apA;
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
  
  public final void a(RecyclerView.t paramt)
  {
    super.a(paramt);
    this.aqm = -1;
    this.aqn = -2147483648;
    this.awY = null;
    this.axa.reset();
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    this.awU.clear();
    requestLayout();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    q(paramInt1, paramInt2, 8);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    q(paramInt1, paramInt2, 4);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    removeCallbacks(this.axd);
    int i = 0;
    while (i < this.apA)
    {
      this.awO[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.atQ = paramInt;
    a(paramRecyclerView);
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void ag(int paramInt1, int paramInt2)
  {
    if (this.awY != null) {
      this.awY.mI();
    }
    this.aqm = paramInt1;
    this.aqn = paramInt2;
    requestLayout();
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    return c(paramInt, paramo, paramt);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 1) {
      return this.apA;
    }
    return super.b(paramo, paramt);
  }
  
  public final PointF bZ(int paramInt)
  {
    paramInt = cN(paramInt);
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
  
  public void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    int j = 1;
    a locala = this.axa;
    if (((this.awY != null) || (this.aqm != -1)) && (paramt.getItemCount() == 0))
    {
      d(paramo);
      locala.reset();
      label41:
      return;
    }
    int k;
    int m;
    label112:
    int n;
    if ((!locala.aqv) || (this.aqm != -1) || (this.awY != null))
    {
      k = 1;
      if (k == 0) {
        break label463;
      }
      locala.reset();
      if (this.awY == null) {
        break label614;
      }
      if (this.awY.axo <= 0) {
        break label268;
      }
      if (this.awY.axo != this.apA) {
        break label218;
      }
      m = 0;
      if (m >= this.apA) {
        break label268;
      }
      this.awO[m].clear();
      n = this.awY.axp[m];
      i = n;
      if (n != -2147483648) {
        if (!this.awY.aqF) {
          break label203;
        }
      }
    }
    label203:
    for (int i = n + this.awP.kC();; i = n + this.awP.kB())
    {
      this.awO[m].cY(i);
      m += 1;
      break label112;
      k = 0;
      break;
    }
    label218:
    Object localObject1 = this.awY;
    ((SavedState)localObject1).axp = null;
    ((SavedState)localObject1).axo = 0;
    ((SavedState)localObject1).axq = 0;
    ((SavedState)localObject1).axr = null;
    ((SavedState)localObject1).axj = null;
    this.awY.aqD = this.awY.axn;
    label268:
    this.awX = this.awY.awX;
    ap(this.awY.aqi);
    ke();
    if (this.awY.aqD != -1)
    {
      this.aqm = this.awY.aqD;
      locala.aqu = this.awY.aqF;
      if (this.awY.axq > 1)
      {
        this.awU.mData = this.awY.axr;
        this.awU.axj = this.awY.axj;
      }
      label367:
      if ((!paramt.aug) && (this.aqm != -1)) {
        break label630;
      }
      i = 0;
      label385:
      if (i == 0)
      {
        if (!this.awW) {
          break label1149;
        }
        n = paramt.getItemCount();
        i = getChildCount() - 1;
        label411:
        if (i < 0) {
          break label1143;
        }
        m = bB(getChildAt(i));
        if ((m < 0) || (m >= n)) {
          break label1134;
        }
        i = m;
      }
    }
    label463:
    label614:
    label630:
    boolean bool;
    label721:
    label853:
    label991:
    label1019:
    label1149:
    int i1;
    for (;;)
    {
      locala.mPosition = i;
      locala.fq = -2147483648;
      locala.aqv = true;
      if ((this.awY == null) && (this.aqm == -1) && ((locala.aqu != this.awW) || (jy() != this.awX)))
      {
        this.awU.clear();
        locala.axf = true;
      }
      if ((getChildCount() <= 0) || ((this.awY != null) && (this.awY.axo > 0))) {
        break label1525;
      }
      if (!locala.axf) {
        break label1213;
      }
      i = 0;
      while (i < this.apA)
      {
        this.awO[i].clear();
        if (locala.fq != -2147483648) {
          this.awO[i].cY(locala.fq);
        }
        i += 1;
      }
      locala.aqu = this.aqj;
      break;
      ke();
      locala.aqu = this.aqj;
      break label367;
      if ((this.aqm < 0) || (this.aqm >= paramt.getItemCount()))
      {
        this.aqm = -1;
        this.aqn = -2147483648;
        i = 0;
        break label385;
      }
      if ((this.awY == null) || (this.awY.aqD == -1) || (this.awY.axo <= 0))
      {
        localObject1 = bY(this.aqm);
        if (localObject1 != null)
        {
          if (this.aqj)
          {
            i = mE();
            locala.mPosition = i;
            if (this.aqn == -2147483648) {
              break label817;
            }
            if (!locala.aqu) {
              break label787;
            }
          }
          label787:
          for (locala.fq = (this.awP.kC() - this.aqn - this.awP.bo((View)localObject1));; locala.fq = (this.awP.kB() + this.aqn - this.awP.bn((View)localObject1)))
          {
            i = 1;
            break;
            i = mF();
            break label721;
          }
          label817:
          if (this.awP.br((View)localObject1) > this.awP.kD()) {
            if (locala.aqu)
            {
              i = this.awP.kC();
              locala.fq = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.awP.kB();
        break label853;
        i = this.awP.bn((View)localObject1) - this.awP.kB();
        if (i < 0)
        {
          locala.fq = (-i);
        }
        else
        {
          i = this.awP.kC() - this.awP.bo((View)localObject1);
          if (i < 0)
          {
            locala.fq = i;
          }
          else
          {
            locala.fq = -2147483648;
            continue;
            locala.mPosition = this.aqm;
            if (this.aqn == -2147483648) {
              if (cN(locala.mPosition) == 1)
              {
                bool = true;
                locala.aqu = bool;
                if (!locala.aqu) {
                  break label1041;
                }
                i = locala.axe.awP.kC();
                locala.fq = i;
              }
            }
            for (;;)
            {
              locala.axf = true;
              break;
              bool = false;
              break label991;
              label1041:
              i = locala.axe.awP.kB();
              break label1019;
              i = this.aqn;
              if (locala.aqu) {
                locala.fq = (locala.axe.awP.kC() - i);
              } else {
                locala.fq = (i + locala.axe.awP.kB());
              }
            }
            locala.fq = -2147483648;
            locala.mPosition = this.aqm;
          }
        }
      }
      label1134:
      i -= 1;
      break label411;
      label1143:
      i = 0;
      continue;
      i1 = paramt.getItemCount();
      int i2 = getChildCount();
      m = 0;
      for (;;)
      {
        if (m >= i2) {
          break label1207;
        }
        n = bB(getChildAt(m));
        if (n >= 0)
        {
          i = n;
          if (n < i1) {
            break;
          }
        }
        m += 1;
      }
      label1207:
      i = 0;
    }
    label1213:
    label1276:
    Object localObject2;
    if ((k != 0) || (this.axa.axg == null))
    {
      k = 0;
      if (k < this.apA)
      {
        localObject1 = this.awO[k];
        bool = this.aqj;
        n = locala.fq;
        if (bool)
        {
          i = ((b)localObject1).cX(-2147483648);
          ((b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((b)localObject1).axe.awP.kC())) && ((bool) || (i <= ((b)localObject1).axe.awP.kB()))) {
            break label1351;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = ((b)localObject1).cW(-2147483648);
          break label1276;
          label1351:
          m = i;
          if (n != -2147483648) {
            m = i + n;
          }
          ((b)localObject1).axu = m;
          ((b)localObject1).axt = m;
        }
      }
      localObject1 = this.axa;
      localObject2 = this.awO;
      k = localObject2.length;
      if ((((a)localObject1).axg == null) || (((a)localObject1).axg.length < k)) {
        ((a)localObject1).axg = new int[((a)localObject1).axe.awO.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((a)localObject1).axg[i] = localObject2[i].cW(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.apA)
      {
        localObject1 = this.awO[i];
        ((b)localObject1).clear();
        ((b)localObject1).cY(this.axa.axg[i]);
        i += 1;
      }
    }
    label1525:
    b(paramo);
    this.awS.apL = false;
    this.axb = false;
    cE(this.awQ.kD());
    a(locala.mPosition, paramt);
    label1624:
    float f1;
    if (locala.aqu)
    {
      cF(-1);
      a(paramo, this.awS, paramt);
      cF(1);
      this.awS.apN = (locala.mPosition + this.awS.apO);
      a(paramo, this.awS, paramt);
      if (this.awQ.getMode() == 1073741824) {
        break label2010;
      }
      f1 = 0.0F;
      m = getChildCount();
      i = 0;
      label1648:
      if (i >= m) {
        break label1779;
      }
      localObject1 = getChildAt(i);
      float f2 = this.awQ.br((View)localObject1);
      if (f2 < f1) {
        break label2199;
      }
      if (!((LayoutParams)((View)localObject1).getLayoutParams()).axi) {
        break label2196;
      }
      f2 = 1.0F * f2 / this.apA;
      label1708:
      f1 = Math.max(f1, f2);
    }
    label2190:
    label2196:
    label2199:
    for (;;)
    {
      i += 1;
      break label1648;
      cF(1);
      a(paramo, this.awS, paramt);
      cF(-1);
      this.awS.apN = (locala.mPosition + this.awS.apO);
      a(paramo, this.awS, paramt);
      break label1624;
      label1779:
      n = this.awR;
      k = Math.round(this.apA * f1);
      i = k;
      if (this.awQ.getMode() == -2147483648) {
        i = Math.min(k, this.awQ.kD());
      }
      cE(i);
      if (this.awR != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (!((LayoutParams)localObject2).axi)
          {
            if ((!jy()) || (this.mOrientation != 1)) {
              break label1948;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.apA - 1 - ((LayoutParams)localObject2).axh.mIndex) * this.awR - -(this.apA - 1 - ((LayoutParams)localObject2).axh.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            label1948:
            k = ((LayoutParams)localObject2).axh.mIndex * this.awR;
            i1 = ((LayoutParams)localObject2).axh.mIndex * n;
            if (this.mOrientation == 1) {
              ((View)localObject1).offsetLeftAndRight(k - i1);
            } else {
              ((View)localObject1).offsetTopAndBottom(k - i1);
            }
          }
        }
      }
      label2010:
      if (getChildCount() > 0)
      {
        if (this.aqj)
        {
          a(paramo, paramt, true);
          b(paramo, paramt, false);
        }
      }
      else
      {
        label2038:
        k = 0;
        i = k;
        if (j != 0)
        {
          i = k;
          if (!paramt.aug) {
            if ((this.awV == 0) || (getChildCount() <= 0) || ((!this.axb) && (my() == null))) {
              break label2190;
            }
          }
        }
      }
      for (j = 1;; j = 0)
      {
        i = k;
        if (j != 0)
        {
          removeCallbacks(this.axd);
          i = k;
          if (mx()) {
            i = 1;
          }
        }
        if (paramt.aug) {
          this.axa.reset();
        }
        this.awW = locala.aqu;
        this.awX = jy();
        if (i == 0) {
          break label41;
        }
        this.axa.reset();
        j = 0;
        break;
        b(paramo, paramt, true);
        a(paramo, paramt, false);
        break label2038;
      }
      break label1708;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    q(paramInt1, paramInt2, 1);
  }
  
  public void ca(int paramInt)
  {
    if ((this.awY != null) && (this.awY.aqD != paramInt)) {
      this.awY.mI();
    }
    this.aqm = paramInt;
    this.aqn = -2147483648;
    requestLayout();
  }
  
  public final void cn(int paramInt)
  {
    super.cn(paramInt);
    int i = 0;
    while (i < this.apA)
    {
      this.awO[i].cZ(paramInt);
      i += 1;
    }
  }
  
  public final void co(int paramInt)
  {
    super.co(paramInt);
    int i = 0;
    while (i < this.apA)
    {
      this.awO[i].cZ(paramInt);
      i += 1;
    }
  }
  
  public final void cp(int paramInt)
  {
    if (paramInt == 0) {
      mx();
    }
  }
  
  public final int d(RecyclerView.t paramt)
  {
    return j(paramt);
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
    q(paramInt1, paramInt2, 2);
  }
  
  public final int e(RecyclerView.t paramt)
  {
    return j(paramt);
  }
  
  public final int f(RecyclerView.t paramt)
  {
    return k(paramt);
  }
  
  public final int g(RecyclerView.t paramt)
  {
    return k(paramt);
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int h(RecyclerView.t paramt)
  {
    return l(paramt);
  }
  
  public final int i(RecyclerView.t paramt)
  {
    return l(paramt);
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
  
  public final boolean ka()
  {
    return this.awY == null;
  }
  
  public final boolean kb()
  {
    return this.awV != 0;
  }
  
  public final boolean kc()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean kd()
  {
    return this.mOrientation == 1;
  }
  
  public final int[] mA()
  {
    int[] arrayOfInt = new int[this.apA];
    int i = 0;
    if (i < this.apA)
    {
      b localb = this.awO[i];
      if (localb.axe.aqi) {}
      for (int j = localb.f(0, localb.axs.size(), false);; j = localb.f(localb.axs.size() - 1, -1, false))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public final int[] mB()
  {
    int[] arrayOfInt = new int[this.apA];
    int i = 0;
    if (i < this.apA)
    {
      b localb = this.awO[i];
      if (localb.axe.aqi) {}
      for (int j = localb.f(0, localb.axs.size(), true);; j = localb.f(localb.axs.size() - 1, -1, true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  final boolean mx()
  {
    if ((getChildCount() == 0) || (this.awV == 0) || (!this.qm)) {
      return false;
    }
    int j;
    if (this.aqj) {
      j = mE();
    }
    for (int i = mF(); (j == 0) && (my() != null); i = mE())
    {
      this.awU.clear();
      lA();
      requestLayout();
      return true;
      j = mF();
    }
    if (!this.axb) {
      return false;
    }
    if (this.aqj) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.awU.r(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.axb = false;
      this.awU.cO(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.awU.r(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.awU.cO(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      lA();
      requestLayout();
      return true;
      this.awU.cO(localFullSpanItem2.mPosition + 1);
    }
  }
  
  public final int[] mz()
  {
    int[] arrayOfInt = new int[this.apA];
    int i = 0;
    if (i < this.apA)
    {
      b localb = this.awO[i];
      if (localb.axe.aqi) {}
      for (int j = localb.f(localb.axs.size() - 1, -1, true);; j = localb.f(0, localb.axs.size(), true))
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
      arrayOfInt = new int[this.apA];
      i = 0;
      label14:
      if (i >= this.apA) {
        break label135;
      }
      paramArrayOfInt = this.awO[i];
      if (!paramArrayOfInt.axe.aqi) {
        break label118;
      }
    }
    label118:
    for (int j = paramArrayOfInt.f(paramArrayOfInt.axs.size() - 1, -1, false);; j = paramArrayOfInt.f(0, paramArrayOfInt.axs.size(), false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label14;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.apA) {
        break;
      }
      throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.apA + ", array size:" + paramArrayOfInt.length);
    }
    label135:
    return arrayOfInt;
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      localView1 = aC(false);
      localView2 = aD(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = bB(localView1);
    int j = bB(localView2);
    if (i < j)
    {
      paramAccessibilityEvent.setFromIndex(i);
      paramAccessibilityEvent.setToIndex(j);
      return;
    }
    paramAccessibilityEvent.setFromIndex(j);
    paramAccessibilityEvent.setToIndex(i);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.awY = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.awY != null) {
      return new SavedState(this.awY);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.aqi = this.aqi;
    localSavedState.aqF = this.awW;
    localSavedState.awX = this.awX;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((this.awU != null) && (this.awU.mData != null))
    {
      localSavedState.axr = this.awU.mData;
      localSavedState.axq = localSavedState.axr.length;
      localSavedState.axj = this.awU.axj;
      if (getChildCount() <= 0) {
        break label310;
      }
      if (!this.awW) {
        break label250;
      }
      i = mE();
      localSavedState.aqD = i;
      if (!this.aqj) {
        break label258;
      }
      localView = aD(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      localSavedState.axn = i;
      localSavedState.axo = this.apA;
      localSavedState.axp = new int[this.apA];
      j = 0;
      if (j >= this.apA) {
        break label328;
      }
      if (!this.awW) {
        break label277;
      }
      k = this.awO[j].cX(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.awP.kC();
      }
    }
    for (;;)
    {
      localSavedState.axp[j] = i;
      j += 1;
      break label181;
      localSavedState.axq = 0;
      break;
      label250:
      i = mF();
      break label126;
      label258:
      localView = aC(true);
      break label146;
      label268:
      i = bB(localView);
      break label153;
      label277:
      k = this.awO[j].cW(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.awP.kB();
      }
    }
    label310:
    localSavedState.aqD = -1;
    localSavedState.axn = -1;
    localSavedState.axo = 0;
    label328:
    return localSavedState;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b axh;
    boolean axi;
    
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
    
    public final void aE(boolean paramBoolean)
    {
      this.axi = paramBoolean;
    }
    
    public final boolean mG()
    {
      return this.axi;
    }
    
    public final int mH()
    {
      if (this.axh == null) {
        return -1;
      }
      return this.axh.mIndex;
    }
  }
  
  static final class LazySpanLookup
  {
    List<FullSpanItem> axj;
    int[] mData;
    
    private void aL(int paramInt1, int paramInt2)
    {
      if (this.axj == null) {
        return;
      }
      int i = this.axj.size() - 1;
      label20:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.axj.get(i);
        if (localFullSpanItem.mPosition >= paramInt1)
        {
          if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
            break label77;
          }
          this.axj.remove(i);
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
    
    private void aN(int paramInt1, int paramInt2)
    {
      if (this.axj == null) {}
      for (;;)
      {
        return;
        int i = this.axj.size() - 1;
        while (i >= 0)
        {
          FullSpanItem localFullSpanItem = (FullSpanItem)this.axj.get(i);
          if (localFullSpanItem.mPosition >= paramInt1) {
            localFullSpanItem.mPosition += paramInt2;
          }
          i -= 1;
        }
      }
    }
    
    private int cR(int paramInt)
    {
      int i = this.mData.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    private void cS(int paramInt)
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
      this.mData = new int[cR(paramInt)];
      System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
      Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
    }
    
    private int cT(int paramInt)
    {
      if (this.axj == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = cU(paramInt);
      if (localFullSpanItem != null) {
        this.axj.remove(localFullSpanItem);
      }
      int j = this.axj.size();
      int i = 0;
      if (i < j) {
        if (((FullSpanItem)this.axj.get(i)).mPosition < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)this.axj.get(i);
          this.axj.remove(i);
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
      cS(paramInt);
      this.mData[paramInt] = paramb.mIndex;
    }
    
    public final void a(FullSpanItem paramFullSpanItem)
    {
      if (this.axj == null) {
        this.axj = new ArrayList();
      }
      int j = this.axj.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.axj.get(i);
        if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
          this.axj.remove(i);
        }
        if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
        {
          this.axj.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.axj.add(paramFullSpanItem);
    }
    
    final void aK(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
        return;
      }
      cS(paramInt1 + paramInt2);
      int[] arrayOfInt1 = this.mData;
      int[] arrayOfInt2 = this.mData;
      System.arraycopy(arrayOfInt1, paramInt1 + paramInt2, arrayOfInt2, paramInt1, arrayOfInt2.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
      aL(paramInt1, paramInt2);
    }
    
    final void aM(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
        return;
      }
      cS(paramInt1 + paramInt2);
      int[] arrayOfInt = this.mData;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      aN(paramInt1, paramInt2);
    }
    
    final int cO(int paramInt)
    {
      if (this.axj != null)
      {
        int i = this.axj.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.axj.get(i)).mPosition >= paramInt) {
            this.axj.remove(i);
          }
          i -= 1;
        }
      }
      return cP(paramInt);
    }
    
    final int cP(int paramInt)
    {
      if (this.mData == null) {}
      while (paramInt >= this.mData.length) {
        return -1;
      }
      int i = cT(paramInt);
      if (i == -1)
      {
        int[] arrayOfInt = this.mData;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        return this.mData.length;
      }
      Arrays.fill(this.mData, paramInt, i + 1, -1);
      return i + 1;
    }
    
    final int cQ(int paramInt)
    {
      if ((this.mData == null) || (paramInt >= this.mData.length)) {
        return -1;
      }
      return this.mData[paramInt];
    }
    
    public final FullSpanItem cU(int paramInt)
    {
      Object localObject;
      if (this.axj == null)
      {
        localObject = null;
        return localObject;
      }
      int i = this.axj.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label61;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.axj.get(i);
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
      this.axj = null;
    }
    
    public final FullSpanItem r(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if (this.axj == null)
      {
        localObject = null;
        return localObject;
      }
      int j = this.axj.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label112;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.axj.get(i);
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
          if (localFullSpanItem.axk == paramInt3) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.axm) {
            break;
          }
        }
        i += 1;
      }
      label112:
      return null;
    }
    
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator() {};
      int axk;
      int[] axl;
      boolean axm;
      int mPosition;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        this.mPosition = paramParcel.readInt();
        this.axk = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.axm = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.axl = new int[i];
            paramParcel.readIntArray(this.axl);
          }
          return;
          bool = false;
        }
      }
      
      final int cV(int paramInt)
      {
        if (this.axl == null) {
          return 0;
        }
        return this.axl[paramInt];
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.axk + ", mHasUnwantedGapAfter=" + this.axm + ", mGapPerSpan=" + Arrays.toString(this.axl) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.axk);
        if (this.axm) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.axl == null) || (this.axl.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.axl.length);
          paramParcel.writeIntArray(this.axl);
          return;
        }
        paramParcel.writeInt(0);
      }
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int aqD;
    boolean aqF;
    boolean aqi;
    boolean awX;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> axj;
    int axn;
    int axo;
    int[] axp;
    int axq;
    int[] axr;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.aqD = paramParcel.readInt();
      this.axn = paramParcel.readInt();
      this.axo = paramParcel.readInt();
      if (this.axo > 0)
      {
        this.axp = new int[this.axo];
        paramParcel.readIntArray(this.axp);
      }
      this.axq = paramParcel.readInt();
      if (this.axq > 0)
      {
        this.axr = new int[this.axq];
        paramParcel.readIntArray(this.axr);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.aqi = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        this.aqF = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.awX = bool1;
        this.axj = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.axo = paramSavedState.axo;
      this.aqD = paramSavedState.aqD;
      this.axn = paramSavedState.axn;
      this.axp = paramSavedState.axp;
      this.axq = paramSavedState.axq;
      this.axr = paramSavedState.axr;
      this.aqi = paramSavedState.aqi;
      this.aqF = paramSavedState.aqF;
      this.awX = paramSavedState.awX;
      this.axj = paramSavedState.axj;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void mI()
    {
      this.axp = null;
      this.axo = 0;
      this.aqD = -1;
      this.axn = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(this.aqD);
      paramParcel.writeInt(this.axn);
      paramParcel.writeInt(this.axo);
      if (this.axo > 0) {
        paramParcel.writeIntArray(this.axp);
      }
      paramParcel.writeInt(this.axq);
      if (this.axq > 0) {
        paramParcel.writeIntArray(this.axr);
      }
      if (this.aqi)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.aqF) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!this.awX) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.axj);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label87;
      }
    }
  }
  
  final class a
  {
    boolean aqu;
    boolean aqv;
    boolean axf;
    int[] axg;
    int fq;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.fq = -2147483648;
      this.aqu = false;
      this.axf = false;
      this.aqv = false;
      if (this.axg != null) {
        Arrays.fill(this.axg, -1);
      }
    }
  }
  
  final class b
  {
    ArrayList<View> axs = new ArrayList();
    int axt = -2147483648;
    int axu = -2147483648;
    int axv = 0;
    final int mIndex;
    
    b(int paramInt)
    {
      this.mIndex = paramInt;
    }
    
    private int a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int m = StaggeredGridLayoutManager.this.awP.kB();
      int n = StaggeredGridLayoutManager.this.awP.kC();
      int j;
      int k;
      if (paramInt2 > paramInt1)
      {
        j = 1;
        k = paramInt1;
      }
      while (k != paramInt2)
      {
        View localView = (View)this.axs.get(k);
        int i1 = StaggeredGridLayoutManager.this.awP.bn(localView);
        int i2 = StaggeredGridLayoutManager.this.awP.bo(localView);
        label97:
        int i;
        if (paramBoolean3) {
          if (i1 <= n)
          {
            paramInt1 = 1;
            if (!paramBoolean3) {
              break label187;
            }
            if (i2 < m) {
              break label181;
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
                break label237;
              }
              return StaggeredGridLayoutManager.bB(localView);
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
              label181:
              i = 0;
              continue;
              label187:
              if (i2 > m)
              {
                i = 1;
                continue;
              }
              i = 0;
              continue;
            }
            if (paramBoolean2) {
              return StaggeredGridLayoutManager.bB(localView);
            }
            if ((i1 < m) || (i2 > n)) {
              return StaggeredGridLayoutManager.bB(localView);
            }
          }
        }
        label237:
        k += j;
      }
      return -1;
    }
    
    private int aO(int paramInt1, int paramInt2)
    {
      return a(paramInt1, paramInt2, false, false, true);
    }
    
    private void hn()
    {
      this.axt = -2147483648;
      this.axu = -2147483648;
    }
    
    private void mJ()
    {
      Object localObject = (View)this.axs.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.axt = StaggeredGridLayoutManager.this.awP.bn((View)localObject);
      if (localLayoutParams.axi)
      {
        localObject = StaggeredGridLayoutManager.this.awU.cU(localLayoutParams.aty.lM());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).axk == -1)) {
          this.axt -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cV(this.mIndex);
        }
      }
    }
    
    private void mL()
    {
      Object localObject = (View)this.axs.get(this.axs.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.axu = StaggeredGridLayoutManager.this.awP.bo((View)localObject);
      if (localLayoutParams.axi)
      {
        localObject = StaggeredGridLayoutManager.this.awU.cU(localLayoutParams.aty.lM());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).axk == 1))
        {
          int i = this.axu;
          this.axu = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cV(this.mIndex) + i);
        }
      }
    }
    
    public final View aP(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      if (paramInt2 == -1)
      {
        int i = this.axs.size();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView2 = (View)this.axs.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.aqi) && (StaggeredGridLayoutManager.bB(localView2) <= paramInt1)) || ((!StaggeredGridLayoutManager.this.aqi) && (StaggeredGridLayoutManager.bB(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 += 1;
          localView1 = localView2;
        }
        return localView1;
      }
      paramInt2 = this.axs.size() - 1;
      for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
      {
        localView2 = (View)this.axs.get(paramInt2);
        if (((StaggeredGridLayoutManager.this.aqi) && (StaggeredGridLayoutManager.bB(localView2) >= paramInt1)) || ((!StaggeredGridLayoutManager.this.aqi) && (StaggeredGridLayoutManager.bB(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
          break;
        }
        paramInt2 -= 1;
      }
      return localView1;
    }
    
    final void bY(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.axh = this;
      this.axs.add(0, paramView);
      this.axt = -2147483648;
      if (this.axs.size() == 1) {
        this.axu = -2147483648;
      }
      if ((localLayoutParams.aty.isRemoved()) || (localLayoutParams.aty.md())) {
        this.axv += StaggeredGridLayoutManager.this.awP.br(paramView);
      }
    }
    
    final void bZ(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.axh = this;
      this.axs.add(paramView);
      this.axu = -2147483648;
      if (this.axs.size() == 1) {
        this.axt = -2147483648;
      }
      if ((localLayoutParams.aty.isRemoved()) || (localLayoutParams.aty.md())) {
        this.axv += StaggeredGridLayoutManager.this.awP.br(paramView);
      }
    }
    
    final int cW(int paramInt)
    {
      if (this.axt != -2147483648) {
        paramInt = this.axt;
      }
      while (this.axs.size() == 0) {
        return paramInt;
      }
      mJ();
      return this.axt;
    }
    
    final int cX(int paramInt)
    {
      if (this.axu != -2147483648) {
        paramInt = this.axu;
      }
      while (this.axs.size() == 0) {
        return paramInt;
      }
      mL();
      return this.axu;
    }
    
    final void cY(int paramInt)
    {
      this.axt = paramInt;
      this.axu = paramInt;
    }
    
    final void cZ(int paramInt)
    {
      if (this.axt != -2147483648) {
        this.axt += paramInt;
      }
      if (this.axu != -2147483648) {
        this.axu += paramInt;
      }
    }
    
    final void clear()
    {
      this.axs.clear();
      hn();
      this.axv = 0;
    }
    
    final int f(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return a(paramInt1, paramInt2, paramBoolean, true, false);
    }
    
    final int mK()
    {
      if (this.axt != -2147483648) {
        return this.axt;
      }
      mJ();
      return this.axt;
    }
    
    final int mM()
    {
      if (this.axu != -2147483648) {
        return this.axu;
      }
      mL();
      return this.axu;
    }
    
    final void mN()
    {
      int i = this.axs.size();
      View localView = (View)this.axs.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.axh = null;
      if ((localLayoutParams.aty.isRemoved()) || (localLayoutParams.aty.md())) {
        this.axv -= StaggeredGridLayoutManager.this.awP.br(localView);
      }
      if (i == 1) {
        this.axt = -2147483648;
      }
      this.axu = -2147483648;
    }
    
    final void mO()
    {
      View localView = (View)this.axs.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.axh = null;
      if (this.axs.size() == 0) {
        this.axu = -2147483648;
      }
      if ((localLayoutParams.aty.isRemoved()) || (localLayoutParams.aty.md())) {
        this.axv -= StaggeredGridLayoutManager.this.awP.br(localView);
      }
      this.axt = -2147483648;
    }
    
    public final int mP()
    {
      if (StaggeredGridLayoutManager.this.aqi) {
        return aO(this.axs.size() - 1, -1);
      }
      return aO(0, this.axs.size());
    }
    
    public final int mQ()
    {
      if (StaggeredGridLayoutManager.this.aqi) {
        return aO(0, this.axs.size());
      }
      return aO(this.axs.size() - 1, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */