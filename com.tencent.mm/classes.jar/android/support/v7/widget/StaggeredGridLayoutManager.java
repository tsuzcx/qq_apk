package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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
import java.util.Arrays;
import java.util.BitSet;

public final class StaggeredGridLayoutManager
  extends RecyclerView.i
  implements RecyclerView.r.b
{
  private int afG;
  boolean ago;
  boolean agp;
  private boolean agr;
  int ags;
  int agt;
  StaggeredGridLayoutManager.b[] amC;
  aj amD;
  aj amE;
  private int amF;
  private final ad amG;
  private BitSet amH;
  StaggeredGridLayoutManager.LazySpanLookup amI;
  private int amJ;
  private boolean amK;
  private boolean amL;
  private StaggeredGridLayoutManager.SavedState amM;
  private int amN;
  private final StaggeredGridLayoutManager.a amO;
  private boolean amP;
  private int[] amQ;
  private final Runnable amR;
  private final Rect hV;
  private int mOrientation;
  
  private int a(RecyclerView.o paramo, ad paramad, RecyclerView.s params)
  {
    this.amH.set(0, this.afG, true);
    int i;
    int m;
    label61:
    int j;
    label64:
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    int i2;
    int i1;
    label139:
    StaggeredGridLayoutManager.b localb;
    label160:
    label171:
    label192:
    label224:
    int n;
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int k;
    if (this.amG.afY) {
      if (paramad.mLayoutDirection == 1)
      {
        i = 2147483647;
        aH(paramad.mLayoutDirection, i);
        if (!this.agp) {
          break label552;
        }
        m = this.amD.iJ();
        j = 0;
        if ((!paramad.b(params)) || ((!this.amG.afY) && (this.amH.isEmpty()))) {
          break label868;
        }
        localView = paramad.a(paramo);
        localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.ajy.jM();
        j = this.amI.cx(i2);
        if (j != -1) {
          break label564;
        }
        i1 = 1;
        if (i1 == 0) {
          break label580;
        }
        if (!localLayoutParams.amW) {
          break label570;
        }
        localb = this.amC[0];
        this.amI.a(i2, localb);
        localLayoutParams.amV = localb;
        if (paramad.mLayoutDirection != 1) {
          break label592;
        }
        addView(localView);
        a(localView, localLayoutParams);
        if (paramad.mLayoutDirection != 1) {
          break label614;
        }
        if (!localLayoutParams.amW) {
          break label602;
        }
        j = cr(m);
        n = this.amD.bl(localView) + j;
        if ((i1 == 0) || (!localLayoutParams.amW)) {
          break label959;
        }
        localFullSpanItem = cn(j);
        localFullSpanItem.amY = -1;
        localFullSpanItem.mPosition = i2;
        this.amI.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.amW) && (paramad.afU == -1))
      {
        if (i1 == 0)
        {
          if (paramad.mLayoutDirection != 1) {
            break label712;
          }
          if (kw()) {
            break label706;
          }
          j = 1;
          label324:
          if (j == 0) {
            break label356;
          }
          localFullSpanItem = this.amI.cB(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.ana = true;
          }
        }
        this.amP = true;
      }
      label356:
      a(localView, localLayoutParams, paramad);
      if ((hE()) && (this.mOrientation == 1)) {
        if (localLayoutParams.amW)
        {
          j = this.amE.iJ();
          label397:
          i2 = j - this.amE.bl(localView);
          i1 = j;
          j = i2;
          if (this.mOrientation != 1) {
            break label818;
          }
          k(localView, j, k, i1, n);
          label440:
          if (!localLayoutParams.amW) {
            break label834;
          }
          aH(this.amG.mLayoutDirection, i);
          label461:
          a(paramo, this.amG);
          if ((this.amG.afX) && (localView.hasFocusable()))
          {
            if (!localLayoutParams.amW) {
              break label852;
            }
            this.amH.clear();
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
          i = paramad.afW + paramad.afS;
          break;
        }
        i = paramad.afV - paramad.afS;
        break;
        label552:
        m = this.amD.iI();
        break label61;
        label564:
        i1 = 0;
        break label139;
        label570:
        localb = a(paramad);
        break label160;
        label580:
        localb = this.amC[j];
        break label171;
        label592:
        addView(localView, 0);
        break label192;
        label602:
        j = localb.cE(m);
        break label224;
        label614:
        if (localLayoutParams.amW) {}
        for (j = cq(m);; j = localb.cD(m))
        {
          k = j - this.amD.bl(localView);
          if ((i1 != 0) && (localLayoutParams.amW))
          {
            localFullSpanItem = co(j);
            localFullSpanItem.amY = 1;
            localFullSpanItem.mPosition = i2;
            this.amI.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        label706:
        j = 0;
        break label324;
        label712:
        if (!kx())
        {
          j = 1;
          break label324;
        }
        j = 0;
        break label324;
        j = this.amE.iJ() - (this.afG - 1 - localb.mIndex) * this.amF;
        break label397;
        if (localLayoutParams.amW) {}
        for (j = this.amE.iI();; j = localb.mIndex * this.amF + this.amE.iI())
        {
          i1 = j + this.amE.bl(localView);
          break;
        }
        label818:
        k(localView, k, j, n, i1);
        break label440;
        label834:
        a(localb, this.amG.mLayoutDirection, i);
        break label461;
        label852:
        this.amH.set(localb.mIndex, false);
      }
      label868:
      if (j == 0) {
        a(paramo, this.amG);
      }
      if (this.amG.mLayoutDirection == -1) {
        i = cq(this.amD.iI());
      }
      for (i = this.amD.iI() - i; i > 0; i = cr(this.amD.iJ()) - this.amD.iJ()) {
        return Math.min(paramad.afS, i);
      }
      return 0;
      label959:
      k = j;
    }
  }
  
  private StaggeredGridLayoutManager.b a(ad paramad)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    int j;
    int k;
    int n;
    int i1;
    int m;
    if (ct(paramad.mLayoutDirection))
    {
      i = this.afG - 1;
      j = -1;
      k = -1;
      if (paramad.mLayoutDirection != 1) {
        break label121;
      }
      n = 2147483647;
      i1 = this.amD.iI();
      m = i;
      paramad = (ad)localObject1;
      i = n;
      label59:
      localObject1 = paramad;
      if (m == k) {
        break label192;
      }
      localObject1 = this.amC[m];
      n = ((StaggeredGridLayoutManager.b)localObject1).cE(i1);
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
      k = this.afG;
      j = 1;
      break;
      label121:
      n = -2147483648;
      i1 = this.amD.iJ();
      m = i;
      paramad = localObject2;
      i = n;
      localObject1 = paramad;
      if (m != k)
      {
        localObject1 = this.amC[m];
        n = ((StaggeredGridLayoutManager.b)localObject1).cD(i1);
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
    this.amG.afS = 0;
    this.amG.afT = paramInt;
    int i;
    boolean bool1;
    if (jz())
    {
      i = params.ajQ;
      if (i != -1)
      {
        boolean bool3 = this.agp;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.amD.iK();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.amG.afV = (this.amD.iI() - i);
        this.amG.afW = (paramInt + this.amD.iJ());
      }
      for (;;)
      {
        this.amG.afX = false;
        this.amG.afR = true;
        params = this.amG;
        bool1 = bool2;
        if (this.amD.getMode() == 0)
        {
          bool1 = bool2;
          if (this.amD.getEnd() == 0) {
            bool1 = true;
          }
        }
        params.afY = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i = this.amD.iK();
        paramInt = 0;
        break label67;
        this.amG.afW = (paramInt + this.amD.getEnd());
        this.amG.afV = (-i);
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
      StaggeredGridLayoutManager.LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if ((this.amD.bi(localView) <= paramInt) && (this.amD.bj(localView) <= paramInt))
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.amW) {
            break label118;
          }
          i = 0;
          if (i >= this.afG) {
            break label92;
          }
          if (this.amC[i].ang.size() != 1) {
            break label85;
          }
        }
      }
      label85:
      label92:
      label118:
      while (localLayoutParams.amV.ang.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.afG)
        {
          this.amC[i].kG();
          i += 1;
        }
      }
      localLayoutParams.amV.kG();
      a(localView, paramo);
    }
  }
  
  private void a(RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = cr(-2147483648);
    if (i == -2147483648) {}
    do
    {
      do
      {
        return;
        i = this.amD.iJ() - i;
      } while (i <= 0);
      i -= -c(-i, paramo, params);
    } while ((!paramBoolean) || (i <= 0));
    this.amD.bN(i);
  }
  
  private void a(RecyclerView.o paramo, ad paramad)
  {
    if ((!paramad.afR) || (paramad.afY)) {
      return;
    }
    if (paramad.afS == 0)
    {
      if (paramad.mLayoutDirection == -1)
      {
        b(paramo, paramad.afW);
        return;
      }
      a(paramo, paramad.afV);
      return;
    }
    if (paramad.mLayoutDirection == -1)
    {
      i = paramad.afV - cp(paramad.afV);
      if (i < 0) {}
      for (i = paramad.afW;; i = paramad.afW - Math.min(i, paramad.afS))
      {
        b(paramo, i);
        return;
      }
    }
    int i = cs(paramad.afW) - paramad.afW;
    if (i < 0) {}
    int j;
    for (i = paramad.afV;; i = Math.min(i, paramad.afS) + j)
    {
      a(paramo, i);
      return;
      j = paramad.afV;
    }
  }
  
  private void a(StaggeredGridLayoutManager.b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.anj;
    if (paramInt1 == -1) {
      if (i + paramb.kC() <= paramInt2) {
        this.amH.set(paramb.mIndex, false);
      }
    }
    while (paramb.kE() - i < paramInt2) {
      return;
    }
    this.amH.set(paramb.mIndex, false);
  }
  
  private void a(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.amW)
    {
      if (this.mOrientation == 1)
      {
        m(paramView, this.amN, c(this.mHeight, this.ajw, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
        return;
      }
      m(paramView, c(this.mWidth, this.ajv, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.amN);
      return;
    }
    if (this.mOrientation == 1)
    {
      m(paramView, c(this.amF, this.ajv, 0, paramLayoutParams.width, false), c(this.mHeight, this.ajw, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
      return;
    }
    m(paramView, c(this.mWidth, this.ajv, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), c(this.amF, this.ajw, 0, paramLayoutParams.height, false));
  }
  
  private void a(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams, ad paramad)
  {
    if (paramad.mLayoutDirection == 1)
    {
      if (paramLayoutParams.amW)
      {
        bO(paramView);
        return;
      }
      paramLayoutParams.amV.bR(paramView);
      return;
    }
    if (paramLayoutParams.amW)
    {
      bP(paramView);
      return;
    }
    paramLayoutParams.amV.bQ(paramView);
  }
  
  private boolean a(StaggeredGridLayoutManager.b paramb)
  {
    if (this.agp)
    {
      if (paramb.kE() < this.amD.iJ()) {
        return !((StaggeredGridLayoutManager.LayoutParams)((View)paramb.ang.get(paramb.ang.size() - 1)).getLayoutParams()).amW;
      }
    }
    else if (paramb.kC() > this.amD.iI()) {
      return !((StaggeredGridLayoutManager.LayoutParams)((View)paramb.ang.get(0)).getLayoutParams()).amW;
    }
    return false;
  }
  
  private void aH(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.afG)
    {
      if (!this.amC[i].ang.isEmpty()) {
        a(this.amC[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private View au(boolean paramBoolean)
  {
    int j = this.amD.iI();
    int k = this.amD.iJ();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.amD.bh(localView);
      if ((this.amD.bi(localView) <= j) || (n >= k)) {
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
  
  private View av(boolean paramBoolean)
  {
    int j = this.amD.iI();
    int k = this.amD.iJ();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.amD.bh(localView);
      int n = this.amD.bi(localView);
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
  
  private void b(int paramInt, RecyclerView.s params)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = ky();
      j = 1;
    }
    for (;;)
    {
      this.amG.afR = true;
      a(i, params);
      cm(j);
      params = this.amG;
      params.afT = (i + params.afU);
      this.amG.afS = Math.abs(paramInt);
      return;
      j = -1;
      i = kz();
    }
  }
  
  private void b(RecyclerView.o paramo, int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      StaggeredGridLayoutManager.LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        if ((this.amD.bh(localView) >= paramInt) && (this.amD.bk(localView) >= paramInt))
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.amW) {
            break label132;
          }
          j = 0;
          if (j >= this.afG) {
            break label101;
          }
          if (this.amC[j].ang.size() != 1) {
            break label92;
          }
        }
      }
      label92:
      label101:
      while (localLayoutParams.amV.ang.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.afG)
        {
          this.amC[j].kF();
          j += 1;
        }
      }
      label132:
      localLayoutParams.amV.kF();
      a(localView, paramo);
      i -= 1;
    }
  }
  
  private void b(RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = cq(2147483647);
    if (i == 2147483647) {}
    do
    {
      do
      {
        return;
        i -= this.amD.iI();
      } while (i <= 0);
      i -= c(i, paramo, params);
    } while ((!paramBoolean) || (i <= 0));
    this.amD.bN(-i);
  }
  
  private void bO(View paramView)
  {
    int i = this.afG - 1;
    while (i >= 0)
    {
      this.amC[i].bR(paramView);
      i -= 1;
    }
  }
  
  private void bP(View paramView)
  {
    int i = this.afG - 1;
    while (i >= 0)
    {
      this.amC[i].bQ(paramView);
      i -= 1;
    }
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    b(paramInt, params);
    int j = a(paramo, this.amG, params);
    int i = paramInt;
    if (this.amG.afS >= j) {
      if (paramInt >= 0) {
        break label93;
      }
    }
    label93:
    for (i = -j;; i = j)
    {
      this.amD.bN(-i);
      this.amK = this.agp;
      this.amG.afS = 0;
      a(paramo, this.amG);
      return i;
    }
  }
  
  private void cl(int paramInt)
  {
    this.amF = (paramInt / this.afG);
    this.amN = View.MeasureSpec.makeMeasureSpec(paramInt, this.amE.getMode());
  }
  
  private void cm(int paramInt)
  {
    int i = 1;
    this.amG.mLayoutDirection = paramInt;
    ad localad = this.amG;
    boolean bool2 = this.agp;
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
      localad.afU = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cn(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.amZ = new int[this.afG];
    int i = 0;
    while (i < this.afG)
    {
      localFullSpanItem.amZ[i] = (paramInt - this.amC[i].cE(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem co(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.amZ = new int[this.afG];
    int i = 0;
    while (i < this.afG)
    {
      localFullSpanItem.amZ[i] = (this.amC[i].cD(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private int cp(int paramInt)
  {
    int j = this.amC[0].cD(paramInt);
    int i = 1;
    while (i < this.afG)
    {
      int m = this.amC[i].cD(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cq(int paramInt)
  {
    int j = this.amC[0].cD(paramInt);
    int i = 1;
    while (i < this.afG)
    {
      int m = this.amC[i].cD(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cr(int paramInt)
  {
    int j = this.amC[0].cE(paramInt);
    int i = 1;
    while (i < this.afG)
    {
      int m = this.amC[i].cE(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cs(int paramInt)
  {
    int j = this.amC[0].cE(paramInt);
    int i = 1;
    while (i < this.afG)
    {
      int m = this.amC[i].cE(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private boolean ct(int paramInt)
  {
    int i;
    if (this.mOrientation == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.agp) {
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
        if (i != this.agp) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == hE()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private int cu(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.agp) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < kz()) {}
      for (int i = 1; i != this.agp; i = 0) {
        return -1;
      }
    }
  }
  
  private boolean hE()
  {
    return t.T(this.adt) == 1;
  }
  
  private void il()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!hE())) {
      bool = this.ago;
    }
    for (;;)
    {
      this.agp = bool;
      return;
      if (this.ago) {
        bool = false;
      }
    }
  }
  
  private int j(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.amD;
    View localView;
    if (!this.agr)
    {
      bool1 = true;
      localView = au(bool1);
      if (this.agr) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, av(bool1), this, this.agr, this.agp);
      bool1 = false;
      break;
    }
  }
  
  private int k(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.amD;
    View localView;
    if (!this.agr)
    {
      bool1 = true;
      localView = au(bool1);
      if (this.agr) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, av(bool1), this, this.agr);
      bool1 = false;
      break;
    }
  }
  
  private boolean ku()
  {
    if ((getChildCount() == 0) || (this.amJ == 0) || (!this.iA)) {
      return false;
    }
    int j;
    if (this.agp) {
      j = ky();
    }
    for (int i = kz(); (j == 0) && (kv() != null); i = ky())
    {
      this.amI.clear();
      this.ajp = true;
      requestLayout();
      return true;
      j = kz();
    }
    if (!this.amP) {
      return false;
    }
    if (this.agp) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.amI.p(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.amP = false;
      this.amI.cv(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.amI.p(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.amI.cv(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      this.ajp = true;
      requestLayout();
      return true;
      this.amI.cv(localFullSpanItem2.mPosition + 1);
    }
  }
  
  private View kv()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.afG);
    localBitSet.set(0, this.afG, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (hE()))
    {
      j = 1;
      if (!this.agp) {
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
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    label128:
    label143:
    for (int m = 1;; m = -1)
    {
      n = i;
      if (n == k) {
        break label349;
      }
      localView = getChildAt(n);
      localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.amV.mIndex)) {
        break label162;
      }
      if (!a(localLayoutParams.amV)) {
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
    localBitSet.clear(localLayoutParams.amV.mIndex);
    label162:
    Object localObject;
    int i1;
    if ((!localLayoutParams.amW) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.agp)
      {
        i = this.amD.bi(localView);
        i1 = this.amD.bi((View)localObject);
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
        localObject = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.amV.mIndex - ((StaggeredGridLayoutManager.LayoutParams)localObject).amV.mIndex < 0)
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
          i = this.amD.bh(localView);
          i1 = this.amD.bh((View)localObject);
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
  
  private boolean kw()
  {
    boolean bool2 = true;
    int j = this.amC[0].cE(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.afG)
      {
        if (this.amC[i].cE(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean kx()
  {
    boolean bool2 = true;
    int j = this.amC[0].cD(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.afG)
      {
        if (this.amC[i].cD(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int ky()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return bv(getChildAt(i - 1));
  }
  
  private int kz()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return bv(getChildAt(0));
  }
  
  private int l(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.amD;
    View localView;
    if (!this.agr)
    {
      bool1 = true;
      localView = au(bool1);
      if (this.agr) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(params, localaj, localView, av(bool1), this, this.agr);
      bool1 = false;
      break;
    }
  }
  
  private void m(View paramView, int paramInt1, int paramInt2)
  {
    g(paramView, this.hV);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    paramInt1 = n(paramInt1, localLayoutParams.leftMargin + this.hV.left, localLayoutParams.rightMargin + this.hV.right);
    paramInt2 = n(paramInt2, localLayoutParams.topMargin + this.hV.top, localLayoutParams.bottomMargin + this.hV.bottom);
    if (b(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private static int n(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void o(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (this.agp)
    {
      k = ky();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.amI.cw(i);
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
      k = kz();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.amI.aK(paramInt1, paramInt2);
      break label76;
      this.amI.aI(paramInt1, paramInt2);
      break label76;
      this.amI.aI(paramInt1, 1);
      this.amI.aK(paramInt2, 1);
      break label76;
      if (this.agp) {}
      for (paramInt1 = kz(); i <= paramInt1; paramInt1 = ky())
      {
        requestLayout();
        return;
      }
    }
  }
  
  public final void S(String paramString)
  {
    if (this.amM == null) {
      super.S(paramString);
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return c(paramInt, paramo, params);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return this.afG;
    }
    return super.a(paramo, params);
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new StaggeredGridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (getChildCount() == 0) {
      paramView = null;
    }
    View localView;
    StaggeredGridLayoutManager.b localb;
    int i;
    int j;
    label498:
    label506:
    do
    {
      return paramView;
      localView = bn(paramView);
      if (localView == null) {
        return null;
      }
      il();
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
        else if (hE())
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
          else if (hE())
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
      paramView = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      boolean bool = paramView.amW;
      localb = paramView.amV;
      if (paramInt == 1) {}
      for (i = ky();; i = kz())
      {
        a(i, params);
        cm(paramInt);
        paramView = this.amG;
        paramView.afT = (paramView.afU + i);
        this.amG.afS = ((int)(0.3333333F * this.amD.iK()));
        this.amG.afX = true;
        this.amG.afR = false;
        a(paramo, this.amG, params);
        this.amK = this.agp;
        if (bool) {
          break;
        }
        paramView = localb.aN(i, paramInt);
        if ((paramView == null) || (paramView == localView)) {
          break;
        }
        return paramView;
      }
      if (ct(paramInt))
      {
        j = this.afG - 1;
        while (j >= 0)
        {
          paramView = this.amC[j].aN(i, paramInt);
          if ((paramView != null) && (paramView != localView)) {
            return paramView;
          }
          j -= 1;
        }
      }
      j = 0;
      while (j < this.afG)
      {
        paramView = this.amC[j].aN(i, paramInt);
        if ((paramView != null) && (paramView != localView)) {
          return paramView;
        }
        j += 1;
      }
      if (this.ago) {
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
      j = localb.kH();
      paramo = bH(j);
      if (paramo == null) {
        break;
      }
      paramView = paramo;
    } while (paramo != localView);
    label516:
    label533:
    if (ct(paramInt))
    {
      paramInt = this.afG - 1;
      label567:
      if (paramInt >= 0)
      {
        if (paramInt != localb.mIndex) {
          if (i == 0) {
            break label650;
          }
        }
        for (j = this.amC[paramInt].kH();; j = this.amC[paramInt].kI())
        {
          paramo = bH(j);
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
          j = localb.kI();
          break label533;
        }
      }
    }
    else
    {
      paramInt = 0;
      while (paramInt < this.afG)
      {
        if (i != 0) {}
        for (j = this.amC[paramInt].kH();; j = this.amC[paramInt].kI())
        {
          paramView = bH(j);
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
  
  public final void a(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.i.a parama)
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
      if ((this.amQ == null) || (this.amQ.length < this.afG)) {
        this.amQ = new int[this.afG];
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramInt2 < this.afG)
      {
        if (this.amG.afU == -1) {}
        for (int j = this.amG.afV - this.amC[paramInt2].cD(this.amG.afV);; j = this.amC[paramInt2].cE(this.amG.afW) - this.amG.afW)
        {
          int i = paramInt1;
          if (j >= 0)
          {
            this.amQ[paramInt1] = j;
            i = paramInt1 + 1;
          }
          paramInt2 += 1;
          paramInt1 = i;
          break;
        }
      }
      Arrays.sort(this.amQ, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.amG.b(params)))
      {
        parama.P(this.amG.afT, this.amQ[paramInt2]);
        ad localad = this.amG;
        localad.afT += this.amG.afU;
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
      i = k(paramInt2, k + paramRect.height(), t.aa(this.adt));
      paramInt2 = k(paramInt1, j + this.amF * this.afG, t.Z(this.adt));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = k(paramInt1, j + paramRect.width(), t.Z(this.adt));
      paramInt1 = k(paramInt2, k + this.amF * this.afG, t.aa(this.adt));
      paramInt2 = i;
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, b paramb)
  {
    int i = 1;
    paramo = paramView.getLayoutParams();
    if (!(paramo instanceof StaggeredGridLayoutManager.LayoutParams))
    {
      super.a(paramView, paramb);
      return;
    }
    paramo = (StaggeredGridLayoutManager.LayoutParams)paramo;
    int k;
    int m;
    int j;
    if (this.mOrientation == 0)
    {
      k = paramo.kA();
      if (paramo.amW) {
        i = this.afG;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      paramb.F(b.c.b(k, j, m, i, paramo.amW));
      return;
      m = paramo.kA();
      if (paramo.amW)
      {
        i = this.afG;
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
  
  public final void a(RecyclerView.s params)
  {
    super.a(params);
    this.ags = -1;
    this.agt = -2147483648;
    this.amM = null;
    this.amO.reset();
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    this.amI.clear();
    requestLayout();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.ajQ = paramInt;
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    o(paramInt1, paramInt2, 8);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    o(paramInt1, paramInt2, 4);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    removeCallbacks(this.amR);
    int i = 0;
    while (i < this.afG)
    {
      this.amC[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return c(paramInt, paramo, params);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return this.afG;
    }
    return super.b(paramo, params);
  }
  
  public final PointF bI(int paramInt)
  {
    paramInt = cu(paramInt);
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
  
  public final void bJ(int paramInt)
  {
    if ((this.amM != null) && (this.amM.agJ != paramInt))
    {
      StaggeredGridLayoutManager.SavedState localSavedState = this.amM;
      localSavedState.and = null;
      localSavedState.anc = 0;
      localSavedState.agJ = -1;
      localSavedState.anb = -1;
    }
    this.ags = paramInt;
    this.agt = -2147483648;
    requestLayout();
  }
  
  public final void bV(int paramInt)
  {
    super.bV(paramInt);
    int i = 0;
    while (i < this.afG)
    {
      this.amC[i].cG(paramInt);
      i += 1;
    }
  }
  
  public final void bW(int paramInt)
  {
    super.bW(paramInt);
    int i = 0;
    while (i < this.afG)
    {
      this.amC[i].cG(paramInt);
      i += 1;
    }
  }
  
  public final void bX(int paramInt)
  {
    if (paramInt == 0) {
      ku();
    }
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    int j = 1;
    StaggeredGridLayoutManager.a locala = this.amO;
    if (((this.amM != null) || (this.ags != -1)) && (params.getItemCount() == 0))
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
    if ((!locala.agB) || (this.ags != -1) || (this.amM != null))
    {
      k = 1;
      if (k == 0) {
        break label504;
      }
      locala.reset();
      if (this.amM == null) {
        break label655;
      }
      if (this.amM.anc <= 0) {
        break label268;
      }
      if (this.amM.anc != this.afG) {
        break label218;
      }
      m = 0;
      if (m >= this.afG) {
        break label268;
      }
      this.amC[m].clear();
      n = this.amM.and[m];
      i = n;
      if (n != -2147483648) {
        if (!this.amM.agL) {
          break label203;
        }
      }
    }
    label203:
    for (int i = n + this.amD.iJ();; i = n + this.amD.iI())
    {
      this.amC[m].cF(i);
      m += 1;
      break label112;
      k = 0;
      break;
    }
    label218:
    Object localObject1 = this.amM;
    ((StaggeredGridLayoutManager.SavedState)localObject1).and = null;
    ((StaggeredGridLayoutManager.SavedState)localObject1).anc = 0;
    ((StaggeredGridLayoutManager.SavedState)localObject1).ane = 0;
    ((StaggeredGridLayoutManager.SavedState)localObject1).anf = null;
    ((StaggeredGridLayoutManager.SavedState)localObject1).amX = null;
    this.amM.agJ = this.amM.anb;
    label268:
    this.amL = this.amM.amL;
    boolean bool = this.amM.ago;
    S(null);
    if ((this.amM != null) && (this.amM.ago != bool)) {
      this.amM.ago = bool;
    }
    this.ago = bool;
    requestLayout();
    il();
    if (this.amM.agJ != -1)
    {
      this.ags = this.amM.agJ;
      locala.agA = this.amM.agL;
      if (this.amM.ane > 1)
      {
        this.amI.mData = this.amM.anf;
        this.amI.amX = this.amM.amX;
      }
      label408:
      if ((!params.akg) && (this.ags != -1)) {
        break label671;
      }
      i = 0;
      label426:
      if (i == 0)
      {
        if (!this.amK) {
          break label1190;
        }
        n = params.getItemCount();
        i = getChildCount() - 1;
        label452:
        if (i < 0) {
          break label1184;
        }
        m = bv(getChildAt(i));
        if ((m < 0) || (m >= n)) {
          break label1175;
        }
        i = m;
      }
    }
    label504:
    label762:
    label894:
    int i1;
    for (;;)
    {
      locala.mPosition = i;
      locala.Fb = -2147483648;
      locala.agB = true;
      if ((this.amM == null) && (this.ags == -1) && ((locala.agA != this.amK) || (hE() != this.amL)))
      {
        this.amI.clear();
        locala.amS = true;
      }
      if ((getChildCount() <= 0) || ((this.amM != null) && (this.amM.anc > 0))) {
        break label1566;
      }
      if (!locala.amS) {
        break label1254;
      }
      i = 0;
      while (i < this.afG)
      {
        this.amC[i].clear();
        if (locala.Fb != -2147483648) {
          this.amC[i].cF(locala.Fb);
        }
        i += 1;
      }
      locala.agA = this.agp;
      break;
      label655:
      il();
      locala.agA = this.agp;
      break label408;
      label671:
      if ((this.ags < 0) || (this.ags >= params.getItemCount()))
      {
        this.ags = -1;
        this.agt = -2147483648;
        i = 0;
        break label426;
      }
      if ((this.amM == null) || (this.amM.agJ == -1) || (this.amM.anc <= 0))
      {
        localObject1 = bH(this.ags);
        if (localObject1 != null)
        {
          if (this.agp)
          {
            i = ky();
            locala.mPosition = i;
            if (this.agt == -2147483648) {
              break label858;
            }
            if (!locala.agA) {
              break label828;
            }
          }
          label828:
          for (locala.Fb = (this.amD.iJ() - this.agt - this.amD.bi((View)localObject1));; locala.Fb = (this.amD.iI() + this.agt - this.amD.bh((View)localObject1)))
          {
            i = 1;
            break;
            i = kz();
            break label762;
          }
          label858:
          if (this.amD.bl((View)localObject1) > this.amD.iK()) {
            if (locala.agA)
            {
              i = this.amD.iJ();
              locala.Fb = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.amD.iI();
        break label894;
        i = this.amD.bh((View)localObject1) - this.amD.iI();
        if (i < 0)
        {
          locala.Fb = (-i);
        }
        else
        {
          i = this.amD.iJ() - this.amD.bi((View)localObject1);
          if (i < 0)
          {
            locala.Fb = i;
          }
          else
          {
            locala.Fb = -2147483648;
            continue;
            locala.mPosition = this.ags;
            if (this.agt == -2147483648) {
              if (cu(locala.mPosition) == 1)
              {
                bool = true;
                label1032:
                locala.agA = bool;
                if (!locala.agA) {
                  break label1082;
                }
                i = locala.amU.amD.iJ();
                label1060:
                locala.Fb = i;
              }
            }
            for (;;)
            {
              locala.amS = true;
              break;
              bool = false;
              break label1032;
              label1082:
              i = locala.amU.amD.iI();
              break label1060;
              i = this.agt;
              if (locala.agA) {
                locala.Fb = (locala.amU.amD.iJ() - i);
              } else {
                locala.Fb = (i + locala.amU.amD.iI());
              }
            }
            locala.Fb = -2147483648;
            locala.mPosition = this.ags;
          }
        }
      }
      label1175:
      i -= 1;
      break label452;
      label1184:
      i = 0;
      continue;
      label1190:
      i1 = params.getItemCount();
      int i2 = getChildCount();
      m = 0;
      for (;;)
      {
        if (m >= i2) {
          break label1248;
        }
        n = bv(getChildAt(m));
        if (n >= 0)
        {
          i = n;
          if (n < i1) {
            break;
          }
        }
        m += 1;
      }
      label1248:
      i = 0;
    }
    label1254:
    label1392:
    Object localObject2;
    if ((k != 0) || (this.amO.amT == null))
    {
      k = 0;
      if (k < this.afG)
      {
        localObject1 = this.amC[k];
        bool = this.agp;
        n = locala.Fb;
        if (bool)
        {
          i = ((StaggeredGridLayoutManager.b)localObject1).cE(-2147483648);
          label1317:
          ((StaggeredGridLayoutManager.b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((StaggeredGridLayoutManager.b)localObject1).amU.amD.iJ())) && ((bool) || (i <= ((StaggeredGridLayoutManager.b)localObject1).amU.amD.iI()))) {
            break label1392;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = ((StaggeredGridLayoutManager.b)localObject1).cD(-2147483648);
          break label1317;
          m = i;
          if (n != -2147483648) {
            m = i + n;
          }
          ((StaggeredGridLayoutManager.b)localObject1).ani = m;
          ((StaggeredGridLayoutManager.b)localObject1).anh = m;
        }
      }
      localObject1 = this.amO;
      localObject2 = this.amC;
      k = localObject2.length;
      if ((((StaggeredGridLayoutManager.a)localObject1).amT == null) || (((StaggeredGridLayoutManager.a)localObject1).amT.length < k)) {
        ((StaggeredGridLayoutManager.a)localObject1).amT = new int[((StaggeredGridLayoutManager.a)localObject1).amU.amC.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((StaggeredGridLayoutManager.a)localObject1).amT[i] = localObject2[i].cD(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.afG)
      {
        localObject1 = this.amC[i];
        ((StaggeredGridLayoutManager.b)localObject1).clear();
        ((StaggeredGridLayoutManager.b)localObject1).cF(this.amO.amT[i]);
        i += 1;
      }
    }
    label1566:
    b(paramo);
    this.amG.afR = false;
    this.amP = false;
    cl(this.amE.iK());
    a(locala.mPosition, params);
    label1665:
    float f1;
    if (locala.agA)
    {
      cm(-1);
      a(paramo, this.amG, params);
      cm(1);
      this.amG.afT = (locala.mPosition + this.amG.afU);
      a(paramo, this.amG, params);
      if (this.amE.getMode() == 1073741824) {
        break label2051;
      }
      f1 = 0.0F;
      m = getChildCount();
      i = 0;
      label1689:
      if (i >= m) {
        break label1820;
      }
      localObject1 = getChildAt(i);
      float f2 = this.amE.bl((View)localObject1);
      if (f2 < f1) {
        break label2240;
      }
      if (!((StaggeredGridLayoutManager.LayoutParams)((View)localObject1).getLayoutParams()).amW) {
        break label2237;
      }
      f2 = 1.0F * f2 / this.afG;
      label1749:
      f1 = Math.max(f1, f2);
    }
    label1820:
    label2079:
    label2231:
    label2237:
    label2240:
    for (;;)
    {
      i += 1;
      break label1689;
      cm(1);
      a(paramo, this.amG, params);
      cm(-1);
      this.amG.afT = (locala.mPosition + this.amG.afU);
      a(paramo, this.amG, params);
      break label1665;
      n = this.amF;
      k = Math.round(this.afG * f1);
      i = k;
      if (this.amE.getMode() == -2147483648) {
        i = Math.min(k, this.amE.iK());
      }
      cl(i);
      if (this.amF != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (StaggeredGridLayoutManager.LayoutParams)((View)localObject1).getLayoutParams();
          if (!((StaggeredGridLayoutManager.LayoutParams)localObject2).amW)
          {
            if ((!hE()) || (this.mOrientation != 1)) {
              break label1989;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.afG - 1 - ((StaggeredGridLayoutManager.LayoutParams)localObject2).amV.mIndex) * this.amF - -(this.afG - 1 - ((StaggeredGridLayoutManager.LayoutParams)localObject2).amV.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            label1989:
            k = ((StaggeredGridLayoutManager.LayoutParams)localObject2).amV.mIndex * this.amF;
            i1 = ((StaggeredGridLayoutManager.LayoutParams)localObject2).amV.mIndex * n;
            if (this.mOrientation == 1) {
              ((View)localObject1).offsetLeftAndRight(k - i1);
            } else {
              ((View)localObject1).offsetTopAndBottom(k - i1);
            }
          }
        }
      }
      if (getChildCount() > 0)
      {
        if (this.agp)
        {
          a(paramo, params, true);
          b(paramo, params, false);
        }
      }
      else
      {
        k = 0;
        i = k;
        if (j != 0)
        {
          i = k;
          if (!params.akg) {
            if ((this.amJ == 0) || (getChildCount() <= 0) || ((!this.amP) && (kv() == null))) {
              break label2231;
            }
          }
        }
      }
      for (j = 1;; j = 0)
      {
        i = k;
        if (j != 0)
        {
          removeCallbacks(this.amR);
          i = k;
          if (ku()) {
            i = 1;
          }
        }
        if (params.akg) {
          this.amO.reset();
        }
        this.amK = locala.agA;
        this.amL = hE();
        if (i == 0) {
          break label41;
        }
        this.amO.reset();
        j = 0;
        break;
        b(paramo, params, true);
        a(paramo, params, false);
        break label2079;
      }
      break label1749;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2, 1);
  }
  
  public final int d(RecyclerView.s params)
  {
    return j(params);
  }
  
  public final RecyclerView.LayoutParams d(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new StaggeredGridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new StaggeredGridLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2, 2);
  }
  
  public final int e(RecyclerView.s params)
  {
    return j(params);
  }
  
  public final int f(RecyclerView.s params)
  {
    return k(params);
  }
  
  public final int g(RecyclerView.s params)
  {
    return k(params);
  }
  
  public final int h(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final int i(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final RecyclerView.LayoutParams ic()
  {
    if (this.mOrientation == 0) {
      return new StaggeredGridLayoutManager.LayoutParams(-2, -1);
    }
    return new StaggeredGridLayoutManager.LayoutParams(-1, -2);
  }
  
  public final boolean ih()
  {
    return this.amM == null;
  }
  
  public final boolean ii()
  {
    return this.amJ != 0;
  }
  
  public final boolean ij()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean ik()
  {
    return this.mOrientation == 1;
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      localView1 = au(false);
      localView2 = av(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = bv(localView1);
    int j = bv(localView2);
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
    if ((paramParcelable instanceof StaggeredGridLayoutManager.SavedState))
    {
      this.amM = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.amM != null) {
      return new StaggeredGridLayoutManager.SavedState(this.amM);
    }
    StaggeredGridLayoutManager.SavedState localSavedState = new StaggeredGridLayoutManager.SavedState();
    localSavedState.ago = this.ago;
    localSavedState.agL = this.amK;
    localSavedState.amL = this.amL;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((this.amI != null) && (this.amI.mData != null))
    {
      localSavedState.anf = this.amI.mData;
      localSavedState.ane = localSavedState.anf.length;
      localSavedState.amX = this.amI.amX;
      if (getChildCount() <= 0) {
        break label310;
      }
      if (!this.amK) {
        break label250;
      }
      i = ky();
      localSavedState.agJ = i;
      if (!this.agp) {
        break label258;
      }
      localView = av(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      localSavedState.anb = i;
      localSavedState.anc = this.afG;
      localSavedState.and = new int[this.afG];
      j = 0;
      if (j >= this.afG) {
        break label328;
      }
      if (!this.amK) {
        break label277;
      }
      k = this.amC[j].cE(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.amD.iJ();
      }
    }
    for (;;)
    {
      localSavedState.and[j] = i;
      j += 1;
      break label181;
      localSavedState.ane = 0;
      break;
      label250:
      i = kz();
      break label126;
      label258:
      localView = au(true);
      break label146;
      label268:
      i = bv(localView);
      break label153;
      label277:
      k = this.amC[j].cD(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.amD.iI();
      }
    }
    label310:
    localSavedState.agJ = -1;
    localSavedState.anb = -1;
    localSavedState.anc = 0;
    label328:
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */