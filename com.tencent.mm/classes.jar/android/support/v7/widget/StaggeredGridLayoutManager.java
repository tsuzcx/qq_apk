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
  implements RecyclerView.r.b
{
  private final Rect Rm = new Rect();
  public int amN = -1;
  int anA = -2147483648;
  boolean anv = false;
  boolean anw = false;
  private boolean any = true;
  int anz = -1;
  b[] aub;
  aj auc;
  aj aud;
  private int aue;
  private final ad auf;
  private BitSet aug;
  LazySpanLookup auh = new LazySpanLookup();
  private int aui = 2;
  private boolean auj;
  private boolean auk;
  private SavedState aul;
  private int aum;
  private final a aun = new a();
  private boolean auo = false;
  private int[] aup;
  private final Runnable auq = new Runnable()
  {
    public final void run()
    {
      StaggeredGridLayoutManager.this.lW();
    }
  };
  public int mOrientation;
  
  public StaggeredGridLayoutManager(int paramInt)
  {
    this.mOrientation = 1;
    bV(paramInt);
    this.auf = new ad();
    lV();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = paramContext.orientation;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    E(null);
    if (paramInt1 != this.mOrientation)
    {
      this.mOrientation = paramInt1;
      paramAttributeSet = this.auc;
      this.auc = this.aud;
      this.aud = paramAttributeSet;
      requestLayout();
    }
    bV(paramContext.aqI);
    ap(paramContext.aqJ);
    this.auf = new ad();
    lV();
  }
  
  private int a(RecyclerView.o paramo, ad paramad, RecyclerView.s params)
  {
    this.aug.set(0, this.amN, true);
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
    if (this.auf.anf) {
      if (paramad.mLayoutDirection == 1)
      {
        i = 2147483647;
        aI(paramad.mLayoutDirection, i);
        if (!this.anw) {
          break label552;
        }
        m = this.auc.ke();
        j = 0;
        if ((!paramad.b(params)) || ((!this.auf.anf) && (this.aug.isEmpty()))) {
          break label868;
        }
        localView = paramad.a(paramo);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.aqL.lm();
        j = this.auh.cR(i2);
        if (j != -1) {
          break label564;
        }
        i1 = 1;
        if (i1 == 0) {
          break label580;
        }
        if (!localLayoutParams.auv) {
          break label570;
        }
        localb = this.aub[0];
        this.auh.a(i2, localb);
        localLayoutParams.auu = localb;
        if (paramad.mLayoutDirection != 1) {
          break label592;
        }
        addView(localView);
        a(localView, localLayoutParams);
        if (paramad.mLayoutDirection != 1) {
          break label614;
        }
        if (!localLayoutParams.auv) {
          break label602;
        }
        j = cL(m);
        n = this.auc.br(localView) + j;
        if ((i1 == 0) || (!localLayoutParams.auv)) {
          break label959;
        }
        localFullSpanItem = cH(j);
        localFullSpanItem.aux = -1;
        localFullSpanItem.mPosition = i2;
        this.auh.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.auv) && (paramad.anb == -1))
      {
        if (i1 == 0)
        {
          if (paramad.mLayoutDirection != 1) {
            break label712;
          }
          if (mc()) {
            break label706;
          }
          j = 1;
          label324:
          if (j == 0) {
            break label356;
          }
          localFullSpanItem = this.auh.cV(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.auz = true;
          }
        }
        this.auo = true;
      }
      label356:
      a(localView, localLayoutParams, paramad);
      if ((ja()) && (this.mOrientation == 1)) {
        if (localLayoutParams.auv)
        {
          j = this.aud.ke();
          label397:
          i2 = j - this.aud.br(localView);
          i1 = j;
          j = i2;
          if (this.mOrientation != 1) {
            break label818;
          }
          k(localView, j, k, i1, n);
          label440:
          if (!localLayoutParams.auv) {
            break label834;
          }
          aI(this.auf.mLayoutDirection, i);
          label461:
          a(paramo, this.auf);
          if ((this.auf.ane) && (localView.hasFocusable()))
          {
            if (!localLayoutParams.auv) {
              break label852;
            }
            this.aug.clear();
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
          i = paramad.and + paramad.amZ;
          break;
        }
        i = paramad.anc - paramad.amZ;
        break;
        label552:
        m = this.auc.kd();
        break label61;
        label564:
        i1 = 0;
        break label139;
        label570:
        localb = a(paramad);
        break label160;
        label580:
        localb = this.aub[j];
        break label171;
        label592:
        addView(localView, 0);
        break label192;
        label602:
        j = localb.cY(m);
        break label224;
        label614:
        if (localLayoutParams.auv) {}
        for (j = cK(m);; j = localb.cX(m))
        {
          k = j - this.auc.br(localView);
          if ((i1 != 0) && (localLayoutParams.auv))
          {
            localFullSpanItem = cI(j);
            localFullSpanItem.aux = 1;
            localFullSpanItem.mPosition = i2;
            this.auh.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        label706:
        j = 0;
        break label324;
        label712:
        if (!md())
        {
          j = 1;
          break label324;
        }
        j = 0;
        break label324;
        j = this.aud.ke() - (this.amN - 1 - localb.mIndex) * this.aue;
        break label397;
        if (localLayoutParams.auv) {}
        for (j = this.aud.kd();; j = localb.mIndex * this.aue + this.aud.kd())
        {
          i1 = j + this.aud.br(localView);
          break;
        }
        label818:
        k(localView, k, j, n, i1);
        break label440;
        label834:
        a(localb, this.auf.mLayoutDirection, i);
        break label461;
        label852:
        this.aug.set(localb.mIndex, false);
      }
      label868:
      if (j == 0) {
        a(paramo, this.auf);
      }
      if (this.auf.mLayoutDirection == -1) {
        i = cK(this.auc.kd());
      }
      for (i = this.auc.kd() - i; i > 0; i = cL(this.auc.ke()) - this.auc.ke()) {
        return Math.min(paramad.amZ, i);
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
    if (cN(paramad.mLayoutDirection))
    {
      i = this.amN - 1;
      j = -1;
      k = -1;
      if (paramad.mLayoutDirection != 1) {
        break label121;
      }
      n = 2147483647;
      i1 = this.auc.kd();
      m = i;
      paramad = (ad)localObject1;
      i = n;
      label59:
      localObject1 = paramad;
      if (m == k) {
        break label192;
      }
      localObject1 = this.aub[m];
      n = ((b)localObject1).cY(i1);
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
      k = this.amN;
      j = 1;
      break;
      label121:
      n = -2147483648;
      i1 = this.auc.ke();
      m = i;
      paramad = localObject2;
      i = n;
      localObject1 = paramad;
      if (m != k)
      {
        localObject1 = this.aub[m];
        n = ((b)localObject1).cX(i1);
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
    this.auf.amZ = 0;
    this.auf.ana = paramInt;
    int i;
    boolean bool1;
    if (kX())
    {
      i = params.ard;
      if (i != -1)
      {
        boolean bool3 = this.anw;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.auc.kf();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.auf.anc = (this.auc.kd() - i);
        this.auf.and = (paramInt + this.auc.ke());
      }
      for (;;)
      {
        this.auf.ane = false;
        this.auf.amY = true;
        params = this.auf;
        bool1 = bool2;
        if (this.auc.getMode() == 0)
        {
          bool1 = bool2;
          if (this.auc.getEnd() == 0) {
            bool1 = true;
          }
        }
        params.anf = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i = this.auc.kf();
        paramInt = 0;
        break label67;
        this.auf.and = (paramInt + this.auc.getEnd());
        this.auf.anc = (-i);
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
        if ((this.auc.bo(localView) <= paramInt) && (this.auc.bp(localView) <= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.auv) {
            break label118;
          }
          i = 0;
          if (i >= this.amN) {
            break label92;
          }
          if (this.aub[i].auF.size() != 1) {
            break label85;
          }
        }
      }
      label85:
      label92:
      label118:
      while (localLayoutParams.auu.auF.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.amN)
        {
          this.aub[i].mm();
          i += 1;
        }
      }
      localLayoutParams.auu.mm();
      a(localView, paramo);
    }
  }
  
  private void a(RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = cL(-2147483648);
    if (i == -2147483648) {}
    do
    {
      do
      {
        return;
        i = this.auc.ke() - i;
      } while (i <= 0);
      i -= -c(-i, paramo, params);
    } while ((!paramBoolean) || (i <= 0));
    this.auc.cf(i);
  }
  
  private void a(RecyclerView.o paramo, ad paramad)
  {
    if ((!paramad.amY) || (paramad.anf)) {
      return;
    }
    if (paramad.amZ == 0)
    {
      if (paramad.mLayoutDirection == -1)
      {
        b(paramo, paramad.and);
        return;
      }
      a(paramo, paramad.anc);
      return;
    }
    if (paramad.mLayoutDirection == -1)
    {
      i = paramad.anc - cJ(paramad.anc);
      if (i < 0) {}
      for (i = paramad.and;; i = paramad.and - Math.min(i, paramad.amZ))
      {
        b(paramo, i);
        return;
      }
    }
    int i = cM(paramad.and) - paramad.and;
    if (i < 0) {}
    int j;
    for (i = paramad.anc;; i = Math.min(i, paramad.amZ) + j)
    {
      a(paramo, i);
      return;
      j = paramad.anc;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.auI;
    if (paramInt1 == -1) {
      if (i + paramb.mi() <= paramInt2) {
        this.aug.set(paramb.mIndex, false);
      }
    }
    while (paramb.mk() - i < paramInt2) {
      return;
    }
    this.aug.set(paramb.mIndex, false);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.auv)
    {
      if (this.mOrientation == 1)
      {
        l(paramView, this.aum, b(this.mHeight, this.aqG, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
        return;
      }
      l(paramView, b(this.mWidth, this.aqF, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.aum);
      return;
    }
    if (this.mOrientation == 1)
    {
      l(paramView, b(this.aue, this.aqF, 0, paramLayoutParams.width, false), b(this.mHeight, this.aqG, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
      return;
    }
    l(paramView, b(this.mWidth, this.aqF, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), b(this.aue, this.aqG, 0, paramLayoutParams.height, false));
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, ad paramad)
  {
    if (paramad.mLayoutDirection == 1)
    {
      if (paramLayoutParams.auv)
      {
        bW(paramView);
        return;
      }
      paramLayoutParams.auu.bZ(paramView);
      return;
    }
    if (paramLayoutParams.auv)
    {
      bX(paramView);
      return;
    }
    paramLayoutParams.auu.bY(paramView);
  }
  
  private boolean a(b paramb)
  {
    if (this.anw)
    {
      if (paramb.mk() < this.auc.ke()) {
        return !((LayoutParams)((View)paramb.auF.get(paramb.auF.size() - 1)).getLayoutParams()).auv;
      }
    }
    else if (paramb.mi() > this.auc.kd()) {
      return !((LayoutParams)((View)paramb.auF.get(0)).getLayoutParams()).auv;
    }
    return false;
  }
  
  private View aC(boolean paramBoolean)
  {
    int j = this.auc.kd();
    int k = this.auc.ke();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.auc.bn(localView);
      if ((this.auc.bo(localView) <= j) || (n >= k)) {
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
    int j = this.auc.kd();
    int k = this.auc.ke();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.auc.bn(localView);
      int n = this.auc.bo(localView);
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
  
  private void aI(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.amN)
    {
      if (!this.aub[i].auF.isEmpty()) {
        a(this.aub[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private void ap(boolean paramBoolean)
  {
    E(null);
    if ((this.aul != null) && (this.aul.anv != paramBoolean)) {
      this.aul.anv = paramBoolean;
    }
    this.anv = paramBoolean;
    requestLayout();
  }
  
  private void b(int paramInt, RecyclerView.s params)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = me();
      j = 1;
    }
    for (;;)
    {
      this.auf.amY = true;
      a(i, params);
      cG(j);
      params = this.auf;
      params.ana = (i + params.anb);
      this.auf.amZ = Math.abs(paramInt);
      return;
      j = -1;
      i = mf();
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
        if ((this.auc.bn(localView) >= paramInt) && (this.auc.bq(localView) >= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.auv) {
            break label132;
          }
          j = 0;
          if (j >= this.amN) {
            break label101;
          }
          if (this.aub[j].auF.size() != 1) {
            break label92;
          }
        }
      }
      label92:
      label101:
      while (localLayoutParams.auu.auF.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.amN)
        {
          this.aub[j].ml();
          j += 1;
        }
      }
      label132:
      localLayoutParams.auu.ml();
      a(localView, paramo);
      i -= 1;
    }
  }
  
  private void b(RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = cK(2147483647);
    if (i == 2147483647) {}
    do
    {
      do
      {
        return;
        i -= this.auc.kd();
      } while (i <= 0);
      i -= c(i, paramo, params);
    } while ((!paramBoolean) || (i <= 0));
    this.auc.cf(-i);
  }
  
  private void bV(int paramInt)
  {
    E(null);
    if (paramInt != this.amN)
    {
      this.auh.clear();
      requestLayout();
      this.amN = paramInt;
      this.aug = new BitSet(this.amN);
      this.aub = new b[this.amN];
      paramInt = 0;
      while (paramInt < this.amN)
      {
        this.aub[paramInt] = new b(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  private void bW(View paramView)
  {
    int i = this.amN - 1;
    while (i >= 0)
    {
      this.aub[i].bZ(paramView);
      i -= 1;
    }
  }
  
  private void bX(View paramView)
  {
    int i = this.amN - 1;
    while (i >= 0)
    {
      this.aub[i].bY(paramView);
      i -= 1;
    }
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    b(paramInt, params);
    int j = a(paramo, this.auf, params);
    int i = paramInt;
    if (this.auf.amZ >= j) {
      if (paramInt >= 0) {
        break label93;
      }
    }
    label93:
    for (i = -j;; i = j)
    {
      this.auc.cf(-i);
      this.auj = this.anw;
      this.auf.amZ = 0;
      a(paramo, this.auf);
      return i;
    }
  }
  
  private void cF(int paramInt)
  {
    this.aue = (paramInt / this.amN);
    this.aum = View.MeasureSpec.makeMeasureSpec(paramInt, this.aud.getMode());
  }
  
  private void cG(int paramInt)
  {
    int i = 1;
    this.auf.mLayoutDirection = paramInt;
    ad localad = this.auf;
    boolean bool2 = this.anw;
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
      localad.anb = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cH(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.auy = new int[this.amN];
    int i = 0;
    while (i < this.amN)
    {
      localFullSpanItem.auy[i] = (paramInt - this.aub[i].cY(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cI(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.auy = new int[this.amN];
    int i = 0;
    while (i < this.amN)
    {
      localFullSpanItem.auy[i] = (this.aub[i].cX(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private int cJ(int paramInt)
  {
    int j = this.aub[0].cX(paramInt);
    int i = 1;
    while (i < this.amN)
    {
      int m = this.aub[i].cX(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cK(int paramInt)
  {
    int j = this.aub[0].cX(paramInt);
    int i = 1;
    while (i < this.amN)
    {
      int m = this.aub[i].cX(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cL(int paramInt)
  {
    int j = this.aub[0].cY(paramInt);
    int i = 1;
    while (i < this.amN)
    {
      int m = this.aub[i].cY(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cM(int paramInt)
  {
    int j = this.aub[0].cY(paramInt);
    int i = 1;
    while (i < this.amN)
    {
      int m = this.aub[i].cY(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private boolean cN(int paramInt)
  {
    int i;
    if (this.mOrientation == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.anw) {
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
        if (i != this.anw) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == ja()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private int cO(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.anw) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < mf()) {}
      for (int i = 1; i != this.anw; i = 0) {
        return -1;
      }
    }
  }
  
  private int j(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.auc;
    View localView;
    if (!this.any)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.any) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, aD(bool1), this, this.any, this.anw);
      bool1 = false;
      break;
    }
  }
  
  private void jG()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!ja())) {
      bool = this.anv;
    }
    for (;;)
    {
      this.anw = bool;
      return;
      if (this.anv) {
        bool = false;
      }
    }
  }
  
  private boolean ja()
  {
    return t.Y(this.akA) == 1;
  }
  
  private int k(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.auc;
    View localView;
    if (!this.any)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.any) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, aD(bool1), this, this.any);
      bool1 = false;
      break;
    }
  }
  
  private int l(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.auc;
    View localView;
    if (!this.any)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.any) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(params, localaj, localView, aD(bool1), this, this.any);
      bool1 = false;
      break;
    }
  }
  
  private void l(View paramView, int paramInt1, int paramInt2)
  {
    f(paramView, this.Rm);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = p(paramInt1, localLayoutParams.leftMargin + this.Rm.left, localLayoutParams.rightMargin + this.Rm.right);
    paramInt2 = p(paramInt2, localLayoutParams.topMargin + this.Rm.top, localLayoutParams.bottomMargin + this.Rm.bottom);
    if (b(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void lV()
  {
    this.auc = aj.a(this, this.mOrientation);
    this.aud = aj.a(this, 1 - this.mOrientation);
  }
  
  private View lX()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.amN);
    localBitSet.set(0, this.amN, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (ja()))
    {
      j = 1;
      if (!this.anw) {
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
      if (!localBitSet.get(localLayoutParams.auu.mIndex)) {
        break label162;
      }
      if (!a(localLayoutParams.auu)) {
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
    localBitSet.clear(localLayoutParams.auu.mIndex);
    label162:
    Object localObject;
    int i1;
    if ((!localLayoutParams.auv) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.anw)
      {
        i = this.auc.bo(localView);
        i1 = this.auc.bo((View)localObject);
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
        if (localLayoutParams.auu.mIndex - ((LayoutParams)localObject).auu.mIndex < 0)
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
          i = this.auc.bn(localView);
          i1 = this.auc.bn((View)localObject);
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
  
  private boolean mc()
  {
    boolean bool2 = true;
    int j = this.aub[0].cY(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.amN)
      {
        if (this.aub[i].cY(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean md()
  {
    boolean bool2 = true;
    int j = this.aub[0].cX(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.amN)
      {
        if (this.aub[i].cX(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int me()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return bB(getChildAt(i - 1));
  }
  
  private int mf()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return bB(getChildAt(0));
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
    if (this.anw)
    {
      k = me();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.auh.cQ(i);
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
      k = mf();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.auh.aL(paramInt1, paramInt2);
      break label76;
      this.auh.aJ(paramInt1, paramInt2);
      break label76;
      this.auh.aJ(paramInt1, 1);
      this.auh.aL(paramInt2, 1);
      break label76;
      if (this.anw) {}
      for (paramInt1 = mf(); i <= paramInt1; paramInt1 = me())
      {
        requestLayout();
        return;
      }
    }
  }
  
  public final void E(String paramString)
  {
    if (this.aul == null) {
      super.E(paramString);
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return c(paramInt, paramo, params);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return this.amN;
    }
    return super.a(paramo, params);
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.s params)
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
      jG();
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
        else if (ja())
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
          else if (ja())
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
      boolean bool = paramView.auv;
      localb = paramView.auu;
      if (paramInt == 1) {}
      for (i = me();; i = mf())
      {
        a(i, params);
        cG(paramInt);
        paramView = this.auf;
        paramView.ana = (paramView.anb + i);
        this.auf.amZ = ((int)(0.3333333F * this.auc.kf()));
        this.auf.ane = true;
        this.auf.amY = false;
        a(paramo, this.auf, params);
        this.auj = this.anw;
        if (bool) {
          break;
        }
        paramView = localb.aO(i, paramInt);
        if ((paramView == null) || (paramView == localView)) {
          break;
        }
        return paramView;
      }
      if (cN(paramInt))
      {
        j = this.amN - 1;
        while (j >= 0)
        {
          paramView = this.aub[j].aO(i, paramInt);
          if ((paramView != null) && (paramView != localView)) {
            return paramView;
          }
          j -= 1;
        }
      }
      j = 0;
      while (j < this.amN)
      {
        paramView = this.aub[j].aO(i, paramInt);
        if ((paramView != null) && (paramView != localView)) {
          return paramView;
        }
        j += 1;
      }
      if (this.anv) {
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
      j = localb.mn();
      paramo = bY(j);
      if (paramo == null) {
        break;
      }
      paramView = paramo;
    } while (paramo != localView);
    label516:
    label533:
    if (cN(paramInt))
    {
      paramInt = this.amN - 1;
      label567:
      if (paramInt >= 0)
      {
        if (paramInt != localb.mIndex) {
          if (i == 0) {
            break label650;
          }
        }
        for (j = this.aub[paramInt].mn();; j = this.aub[paramInt].mo())
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
          j = localb.mo();
          break label533;
        }
      }
    }
    else
    {
      paramInt = 0;
      while (paramInt < this.amN)
      {
        if (i != 0) {}
        for (j = this.aub[paramInt].mn();; j = this.aub[paramInt].mo())
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
      if ((this.aup == null) || (this.aup.length < this.amN)) {
        this.aup = new int[this.amN];
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramInt2 < this.amN)
      {
        if (this.auf.anb == -1) {}
        for (int j = this.auf.anc - this.aub[paramInt2].cX(this.auf.anc);; j = this.aub[paramInt2].cY(this.auf.and) - this.auf.and)
        {
          int i = paramInt1;
          if (j >= 0)
          {
            this.aup[paramInt1] = j;
            i = paramInt1 + 1;
          }
          paramInt2 += 1;
          paramInt1 = i;
          break;
        }
      }
      Arrays.sort(this.aup, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.auf.b(params)))
      {
        parama.R(this.auf.ana, this.aup[paramInt2]);
        ad localad = this.auf;
        localad.ana += this.auf.anb;
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
      i = m(paramInt2, k + paramRect.height(), t.af(this.akA));
      paramInt2 = m(paramInt1, j + this.aue * this.amN, t.ae(this.akA));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = m(paramInt1, j + paramRect.width(), t.ae(this.akA));
      paramInt1 = m(paramInt2, k + this.aue * this.amN, t.af(this.akA));
      paramInt2 = i;
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, c paramc)
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
      k = paramo.mg();
      if (paramo.auv) {
        i = this.amN;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      paramc.E(c.c.a(k, j, m, i, paramo.auv));
      return;
      m = paramo.mg();
      if (paramo.auv)
      {
        i = this.amN;
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
    this.anz = -1;
    this.anA = -2147483648;
    this.aul = null;
    this.aun.reset();
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    this.auh.clear();
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
    removeCallbacks(this.auq);
    int i = 0;
    while (i < this.amN)
    {
      this.aub[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.ard = paramInt;
    a(paramRecyclerView);
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void af(int paramInt1, int paramInt2)
  {
    if (this.aul != null) {
      this.aul.tk();
    }
    this.anz = paramInt1;
    this.anA = paramInt2;
    requestLayout();
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return c(paramInt, paramo, params);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return this.amN;
    }
    return super.b(paramo, params);
  }
  
  public final PointF bZ(int paramInt)
  {
    paramInt = cO(paramInt);
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
  
  public void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    int j = 1;
    a locala = this.aun;
    if (((this.aul != null) || (this.anz != -1)) && (params.getItemCount() == 0))
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
    if ((!locala.anI) || (this.anz != -1) || (this.aul != null))
    {
      k = 1;
      if (k == 0) {
        break label463;
      }
      locala.reset();
      if (this.aul == null) {
        break label614;
      }
      if (this.aul.auB <= 0) {
        break label268;
      }
      if (this.aul.auB != this.amN) {
        break label218;
      }
      m = 0;
      if (m >= this.amN) {
        break label268;
      }
      this.aub[m].clear();
      n = this.aul.auC[m];
      i = n;
      if (n != -2147483648) {
        if (!this.aul.anS) {
          break label203;
        }
      }
    }
    label203:
    for (int i = n + this.auc.ke();; i = n + this.auc.kd())
    {
      this.aub[m].cZ(i);
      m += 1;
      break label112;
      k = 0;
      break;
    }
    label218:
    Object localObject1 = this.aul;
    ((SavedState)localObject1).auC = null;
    ((SavedState)localObject1).auB = 0;
    ((SavedState)localObject1).auD = 0;
    ((SavedState)localObject1).auE = null;
    ((SavedState)localObject1).auw = null;
    this.aul.anQ = this.aul.auA;
    label268:
    this.auk = this.aul.auk;
    ap(this.aul.anv);
    jG();
    if (this.aul.anQ != -1)
    {
      this.anz = this.aul.anQ;
      locala.anH = this.aul.anS;
      if (this.aul.auD > 1)
      {
        this.auh.mData = this.aul.auE;
        this.auh.auw = this.aul.auw;
      }
      label367:
      if ((!params.aru) && (this.anz != -1)) {
        break label630;
      }
      i = 0;
      label385:
      if (i == 0)
      {
        if (!this.auj) {
          break label1149;
        }
        n = params.getItemCount();
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
      locala.LZ = -2147483648;
      locala.anI = true;
      if ((this.aul == null) && (this.anz == -1) && ((locala.anH != this.auj) || (ja() != this.auk)))
      {
        this.auh.clear();
        locala.aus = true;
      }
      if ((getChildCount() <= 0) || ((this.aul != null) && (this.aul.auB > 0))) {
        break label1525;
      }
      if (!locala.aus) {
        break label1213;
      }
      i = 0;
      while (i < this.amN)
      {
        this.aub[i].clear();
        if (locala.LZ != -2147483648) {
          this.aub[i].cZ(locala.LZ);
        }
        i += 1;
      }
      locala.anH = this.anw;
      break;
      jG();
      locala.anH = this.anw;
      break label367;
      if ((this.anz < 0) || (this.anz >= params.getItemCount()))
      {
        this.anz = -1;
        this.anA = -2147483648;
        i = 0;
        break label385;
      }
      if ((this.aul == null) || (this.aul.anQ == -1) || (this.aul.auB <= 0))
      {
        localObject1 = bY(this.anz);
        if (localObject1 != null)
        {
          if (this.anw)
          {
            i = me();
            locala.mPosition = i;
            if (this.anA == -2147483648) {
              break label817;
            }
            if (!locala.anH) {
              break label787;
            }
          }
          label787:
          for (locala.LZ = (this.auc.ke() - this.anA - this.auc.bo((View)localObject1));; locala.LZ = (this.auc.kd() + this.anA - this.auc.bn((View)localObject1)))
          {
            i = 1;
            break;
            i = mf();
            break label721;
          }
          label817:
          if (this.auc.br((View)localObject1) > this.auc.kf()) {
            if (locala.anH)
            {
              i = this.auc.ke();
              locala.LZ = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.auc.kd();
        break label853;
        i = this.auc.bn((View)localObject1) - this.auc.kd();
        if (i < 0)
        {
          locala.LZ = (-i);
        }
        else
        {
          i = this.auc.ke() - this.auc.bo((View)localObject1);
          if (i < 0)
          {
            locala.LZ = i;
          }
          else
          {
            locala.LZ = -2147483648;
            continue;
            locala.mPosition = this.anz;
            if (this.anA == -2147483648) {
              if (cO(locala.mPosition) == 1)
              {
                bool = true;
                locala.anH = bool;
                if (!locala.anH) {
                  break label1041;
                }
                i = locala.aur.auc.ke();
                locala.LZ = i;
              }
            }
            for (;;)
            {
              locala.aus = true;
              break;
              bool = false;
              break label991;
              label1041:
              i = locala.aur.auc.kd();
              break label1019;
              i = this.anA;
              if (locala.anH) {
                locala.LZ = (locala.aur.auc.ke() - i);
              } else {
                locala.LZ = (i + locala.aur.auc.kd());
              }
            }
            locala.LZ = -2147483648;
            locala.mPosition = this.anz;
          }
        }
      }
      label1134:
      i -= 1;
      break label411;
      label1143:
      i = 0;
      continue;
      i1 = params.getItemCount();
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
    if ((k != 0) || (this.aun.aut == null))
    {
      k = 0;
      if (k < this.amN)
      {
        localObject1 = this.aub[k];
        bool = this.anw;
        n = locala.LZ;
        if (bool)
        {
          i = ((b)localObject1).cY(-2147483648);
          ((b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((b)localObject1).aur.auc.ke())) && ((bool) || (i <= ((b)localObject1).aur.auc.kd()))) {
            break label1351;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = ((b)localObject1).cX(-2147483648);
          break label1276;
          label1351:
          m = i;
          if (n != -2147483648) {
            m = i + n;
          }
          ((b)localObject1).auH = m;
          ((b)localObject1).auG = m;
        }
      }
      localObject1 = this.aun;
      localObject2 = this.aub;
      k = localObject2.length;
      if ((((a)localObject1).aut == null) || (((a)localObject1).aut.length < k)) {
        ((a)localObject1).aut = new int[((a)localObject1).aur.aub.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((a)localObject1).aut[i] = localObject2[i].cX(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.amN)
      {
        localObject1 = this.aub[i];
        ((b)localObject1).clear();
        ((b)localObject1).cZ(this.aun.aut[i]);
        i += 1;
      }
    }
    label1525:
    b(paramo);
    this.auf.amY = false;
    this.auo = false;
    cF(this.aud.kf());
    a(locala.mPosition, params);
    label1624:
    float f1;
    if (locala.anH)
    {
      cG(-1);
      a(paramo, this.auf, params);
      cG(1);
      this.auf.ana = (locala.mPosition + this.auf.anb);
      a(paramo, this.auf, params);
      if (this.aud.getMode() == 1073741824) {
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
      float f2 = this.aud.br((View)localObject1);
      if (f2 < f1) {
        break label2199;
      }
      if (!((LayoutParams)((View)localObject1).getLayoutParams()).auv) {
        break label2196;
      }
      f2 = 1.0F * f2 / this.amN;
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
      cG(1);
      a(paramo, this.auf, params);
      cG(-1);
      this.auf.ana = (locala.mPosition + this.auf.anb);
      a(paramo, this.auf, params);
      break label1624;
      label1779:
      n = this.aue;
      k = Math.round(this.amN * f1);
      i = k;
      if (this.aud.getMode() == -2147483648) {
        i = Math.min(k, this.aud.kf());
      }
      cF(i);
      if (this.aue != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (!((LayoutParams)localObject2).auv)
          {
            if ((!ja()) || (this.mOrientation != 1)) {
              break label1948;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.amN - 1 - ((LayoutParams)localObject2).auu.mIndex) * this.aue - -(this.amN - 1 - ((LayoutParams)localObject2).auu.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            label1948:
            k = ((LayoutParams)localObject2).auu.mIndex * this.aue;
            i1 = ((LayoutParams)localObject2).auu.mIndex * n;
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
        if (this.anw)
        {
          a(paramo, params, true);
          b(paramo, params, false);
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
          if (!params.aru) {
            if ((this.aui == 0) || (getChildCount() <= 0) || ((!this.auo) && (lX() == null))) {
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
          removeCallbacks(this.auq);
          i = k;
          if (lW()) {
            i = 1;
          }
        }
        if (params.aru) {
          this.aun.reset();
        }
        this.auj = locala.anH;
        this.auk = ja();
        if (i == 0) {
          break label41;
        }
        this.aun.reset();
        j = 0;
        break;
        b(paramo, params, true);
        a(paramo, params, false);
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
    if ((this.aul != null) && (this.aul.anQ != paramInt)) {
      this.aul.tk();
    }
    this.anz = paramInt;
    this.anA = -2147483648;
    requestLayout();
  }
  
  public final void co(int paramInt)
  {
    super.co(paramInt);
    int i = 0;
    while (i < this.amN)
    {
      this.aub[i].da(paramInt);
      i += 1;
    }
  }
  
  public final void cp(int paramInt)
  {
    super.cp(paramInt);
    int i = 0;
    while (i < this.amN)
    {
      this.aub[i].da(paramInt);
      i += 1;
    }
  }
  
  public final void cq(int paramInt)
  {
    if (paramInt == 0) {
      lW();
    }
  }
  
  public final int d(RecyclerView.s params)
  {
    return j(params);
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
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int h(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final int i(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final int jB()
  {
    return this.amN;
  }
  
  public final boolean jC()
  {
    return this.aul == null;
  }
  
  public final boolean jD()
  {
    return this.aui != 0;
  }
  
  public final boolean jE()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean jF()
  {
    return this.mOrientation == 1;
  }
  
  public final RecyclerView.LayoutParams jy()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  final boolean lW()
  {
    if ((getChildCount() == 0) || (this.aui == 0) || (!this.nt)) {
      return false;
    }
    int j;
    if (this.anw) {
      j = me();
    }
    for (int i = mf(); (j == 0) && (lX() != null); i = me())
    {
      this.auh.clear();
      la();
      requestLayout();
      return true;
      j = mf();
    }
    if (!this.auo) {
      return false;
    }
    if (this.anw) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.auh.r(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.auo = false;
      this.auh.cP(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.auh.r(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.auh.cP(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      la();
      requestLayout();
      return true;
      this.auh.cP(localFullSpanItem2.mPosition + 1);
    }
  }
  
  public final int[] lZ()
  {
    int[] arrayOfInt = new int[this.amN];
    int i = 0;
    if (i < this.amN)
    {
      b localb = this.aub[i];
      if (localb.aur.anv) {}
      for (int j = localb.f(localb.auF.size() - 1, -1, true);; j = localb.f(0, localb.auF.size(), true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public final int[] ma()
  {
    int[] arrayOfInt = new int[this.amN];
    int i = 0;
    if (i < this.amN)
    {
      b localb = this.aub[i];
      if (localb.aur.anv) {}
      for (int j = localb.f(0, localb.auF.size(), false);; j = localb.f(localb.auF.size() - 1, -1, false))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public final int[] mb()
  {
    int[] arrayOfInt = new int[this.amN];
    int i = 0;
    if (i < this.amN)
    {
      b localb = this.aub[i];
      if (localb.aur.anv) {}
      for (int j = localb.f(0, localb.auF.size(), true);; j = localb.f(localb.auF.size() - 1, -1, true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
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
      this.aul = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.aul != null) {
      return new SavedState(this.aul);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.anv = this.anv;
    localSavedState.anS = this.auj;
    localSavedState.auk = this.auk;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((this.auh != null) && (this.auh.mData != null))
    {
      localSavedState.auE = this.auh.mData;
      localSavedState.auD = localSavedState.auE.length;
      localSavedState.auw = this.auh.auw;
      if (getChildCount() <= 0) {
        break label310;
      }
      if (!this.auj) {
        break label250;
      }
      i = me();
      localSavedState.anQ = i;
      if (!this.anw) {
        break label258;
      }
      localView = aD(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      localSavedState.auA = i;
      localSavedState.auB = this.amN;
      localSavedState.auC = new int[this.amN];
      j = 0;
      if (j >= this.amN) {
        break label328;
      }
      if (!this.auj) {
        break label277;
      }
      k = this.aub[j].cY(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.auc.ke();
      }
    }
    for (;;)
    {
      localSavedState.auC[j] = i;
      j += 1;
      break label181;
      localSavedState.auD = 0;
      break;
      label250:
      i = mf();
      break label126;
      label258:
      localView = aC(true);
      break label146;
      label268:
      i = bB(localView);
      break label153;
      label277:
      k = this.aub[j].cX(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.auc.kd();
      }
    }
    label310:
    localSavedState.anQ = -1;
    localSavedState.auA = -1;
    localSavedState.auB = 0;
    label328:
    return localSavedState;
  }
  
  public final int[] x(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    int i;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = new int[this.amN];
      i = 0;
      label14:
      if (i >= this.amN) {
        break label135;
      }
      paramArrayOfInt = this.aub[i];
      if (!paramArrayOfInt.aur.anv) {
        break label118;
      }
    }
    label118:
    for (int j = paramArrayOfInt.f(paramArrayOfInt.auF.size() - 1, -1, false);; j = paramArrayOfInt.f(0, paramArrayOfInt.auF.size(), false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label14;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.amN) {
        break;
      }
      throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.amN + ", array size:" + paramArrayOfInt.length);
    }
    label135:
    return arrayOfInt;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b auu;
    boolean auv;
    
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
      this.auv = paramBoolean;
    }
    
    public final boolean lY()
    {
      return this.auv;
    }
    
    public final int mg()
    {
      if (this.auu == null) {
        return -1;
      }
      return this.auu.mIndex;
    }
  }
  
  static final class LazySpanLookup
  {
    List<FullSpanItem> auw;
    int[] mData;
    
    private void aK(int paramInt1, int paramInt2)
    {
      if (this.auw == null) {
        return;
      }
      int i = this.auw.size() - 1;
      label20:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.auw.get(i);
        if (localFullSpanItem.mPosition >= paramInt1)
        {
          if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
            break label77;
          }
          this.auw.remove(i);
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
    
    private void aM(int paramInt1, int paramInt2)
    {
      if (this.auw == null) {}
      for (;;)
      {
        return;
        int i = this.auw.size() - 1;
        while (i >= 0)
        {
          FullSpanItem localFullSpanItem = (FullSpanItem)this.auw.get(i);
          if (localFullSpanItem.mPosition >= paramInt1) {
            localFullSpanItem.mPosition += paramInt2;
          }
          i -= 1;
        }
      }
    }
    
    private int cS(int paramInt)
    {
      int i = this.mData.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    private void cT(int paramInt)
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
      this.mData = new int[cS(paramInt)];
      System.arraycopy(arrayOfInt, 0, this.mData, 0, arrayOfInt.length);
      Arrays.fill(this.mData, arrayOfInt.length, this.mData.length, -1);
    }
    
    private int cU(int paramInt)
    {
      if (this.auw == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = cV(paramInt);
      if (localFullSpanItem != null) {
        this.auw.remove(localFullSpanItem);
      }
      int j = this.auw.size();
      int i = 0;
      if (i < j) {
        if (((FullSpanItem)this.auw.get(i)).mPosition < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)this.auw.get(i);
          this.auw.remove(i);
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
      cT(paramInt);
      this.mData[paramInt] = paramb.mIndex;
    }
    
    public final void a(FullSpanItem paramFullSpanItem)
    {
      if (this.auw == null) {
        this.auw = new ArrayList();
      }
      int j = this.auw.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.auw.get(i);
        if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
          this.auw.remove(i);
        }
        if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
        {
          this.auw.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.auw.add(paramFullSpanItem);
    }
    
    final void aJ(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
        return;
      }
      cT(paramInt1 + paramInt2);
      int[] arrayOfInt1 = this.mData;
      int[] arrayOfInt2 = this.mData;
      System.arraycopy(arrayOfInt1, paramInt1 + paramInt2, arrayOfInt2, paramInt1, arrayOfInt2.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, this.mData.length - paramInt2, this.mData.length, -1);
      aK(paramInt1, paramInt2);
    }
    
    final void aL(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
        return;
      }
      cT(paramInt1 + paramInt2);
      int[] arrayOfInt = this.mData;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      aM(paramInt1, paramInt2);
    }
    
    final int cP(int paramInt)
    {
      if (this.auw != null)
      {
        int i = this.auw.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.auw.get(i)).mPosition >= paramInt) {
            this.auw.remove(i);
          }
          i -= 1;
        }
      }
      return cQ(paramInt);
    }
    
    final int cQ(int paramInt)
    {
      if (this.mData == null) {}
      while (paramInt >= this.mData.length) {
        return -1;
      }
      int i = cU(paramInt);
      if (i == -1)
      {
        int[] arrayOfInt = this.mData;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        return this.mData.length;
      }
      Arrays.fill(this.mData, paramInt, i + 1, -1);
      return i + 1;
    }
    
    final int cR(int paramInt)
    {
      if ((this.mData == null) || (paramInt >= this.mData.length)) {
        return -1;
      }
      return this.mData[paramInt];
    }
    
    public final FullSpanItem cV(int paramInt)
    {
      Object localObject;
      if (this.auw == null)
      {
        localObject = null;
        return localObject;
      }
      int i = this.auw.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label61;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.auw.get(i);
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
      this.auw = null;
    }
    
    public final FullSpanItem r(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if (this.auw == null)
      {
        localObject = null;
        return localObject;
      }
      int j = this.auw.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label112;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.auw.get(i);
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
          if (localFullSpanItem.aux == paramInt3) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.auz) {
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
      int aux;
      int[] auy;
      boolean auz;
      int mPosition;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        this.mPosition = paramParcel.readInt();
        this.aux = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.auz = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.auy = new int[i];
            paramParcel.readIntArray(this.auy);
          }
          return;
          bool = false;
        }
      }
      
      final int cW(int paramInt)
      {
        if (this.auy == null) {
          return 0;
        }
        return this.auy[paramInt];
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.aux + ", mHasUnwantedGapAfter=" + this.auz + ", mGapPerSpan=" + Arrays.toString(this.auy) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.aux);
        if (this.auz) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.auy == null) || (this.auy.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.auy.length);
          paramParcel.writeIntArray(this.auy);
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
    int anQ;
    boolean anS;
    boolean anv;
    int auA;
    int auB;
    int[] auC;
    int auD;
    int[] auE;
    boolean auk;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> auw;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.anQ = paramParcel.readInt();
      this.auA = paramParcel.readInt();
      this.auB = paramParcel.readInt();
      if (this.auB > 0)
      {
        this.auC = new int[this.auB];
        paramParcel.readIntArray(this.auC);
      }
      this.auD = paramParcel.readInt();
      if (this.auD > 0)
      {
        this.auE = new int[this.auD];
        paramParcel.readIntArray(this.auE);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.anv = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        this.anS = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.auk = bool1;
        this.auw = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.auB = paramSavedState.auB;
      this.anQ = paramSavedState.anQ;
      this.auA = paramSavedState.auA;
      this.auC = paramSavedState.auC;
      this.auD = paramSavedState.auD;
      this.auE = paramSavedState.auE;
      this.anv = paramSavedState.anv;
      this.anS = paramSavedState.anS;
      this.auk = paramSavedState.auk;
      this.auw = paramSavedState.auw;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void tk()
    {
      this.auC = null;
      this.auB = 0;
      this.anQ = -1;
      this.auA = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(this.anQ);
      paramParcel.writeInt(this.auA);
      paramParcel.writeInt(this.auB);
      if (this.auB > 0) {
        paramParcel.writeIntArray(this.auC);
      }
      paramParcel.writeInt(this.auD);
      if (this.auD > 0) {
        paramParcel.writeIntArray(this.auE);
      }
      if (this.anv)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.anS) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!this.auk) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.auw);
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
    int LZ;
    boolean anH;
    boolean anI;
    boolean aus;
    int[] aut;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.LZ = -2147483648;
      this.anH = false;
      this.aus = false;
      this.anI = false;
      if (this.aut != null) {
        Arrays.fill(this.aut, -1);
      }
    }
  }
  
  final class b
  {
    ArrayList<View> auF = new ArrayList();
    int auG = -2147483648;
    int auH = -2147483648;
    int auI = 0;
    final int mIndex;
    
    b(int paramInt)
    {
      this.mIndex = paramInt;
    }
    
    private int a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int m = StaggeredGridLayoutManager.this.auc.kd();
      int n = StaggeredGridLayoutManager.this.auc.ke();
      int j;
      int k;
      if (paramInt2 > paramInt1)
      {
        j = 1;
        k = paramInt1;
      }
      while (k != paramInt2)
      {
        View localView = (View)this.auF.get(k);
        int i1 = StaggeredGridLayoutManager.this.auc.bn(localView);
        int i2 = StaggeredGridLayoutManager.this.auc.bo(localView);
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
    
    private int aN(int paramInt1, int paramInt2)
    {
      return a(paramInt1, paramInt2, false, false, true);
    }
    
    private void gO()
    {
      this.auG = -2147483648;
      this.auH = -2147483648;
    }
    
    private void mh()
    {
      Object localObject = (View)this.auF.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.auG = StaggeredGridLayoutManager.this.auc.bn((View)localObject);
      if (localLayoutParams.auv)
      {
        localObject = StaggeredGridLayoutManager.this.auh.cV(localLayoutParams.aqL.lm());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).aux == -1)) {
          this.auG -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cW(this.mIndex);
        }
      }
    }
    
    private void mj()
    {
      Object localObject = (View)this.auF.get(this.auF.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.auH = StaggeredGridLayoutManager.this.auc.bo((View)localObject);
      if (localLayoutParams.auv)
      {
        localObject = StaggeredGridLayoutManager.this.auh.cV(localLayoutParams.aqL.lm());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).aux == 1))
        {
          int i = this.auH;
          this.auH = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cW(this.mIndex) + i);
        }
      }
    }
    
    public final View aO(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      if (paramInt2 == -1)
      {
        int i = this.auF.size();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView2 = (View)this.auF.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.anv) && (StaggeredGridLayoutManager.bB(localView2) <= paramInt1)) || ((!StaggeredGridLayoutManager.this.anv) && (StaggeredGridLayoutManager.bB(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 += 1;
          localView1 = localView2;
        }
        return localView1;
      }
      paramInt2 = this.auF.size() - 1;
      for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
      {
        localView2 = (View)this.auF.get(paramInt2);
        if (((StaggeredGridLayoutManager.this.anv) && (StaggeredGridLayoutManager.bB(localView2) >= paramInt1)) || ((!StaggeredGridLayoutManager.this.anv) && (StaggeredGridLayoutManager.bB(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
          break;
        }
        paramInt2 -= 1;
      }
      return localView1;
    }
    
    final void bY(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.auu = this;
      this.auF.add(0, paramView);
      this.auG = -2147483648;
      if (this.auF.size() == 1) {
        this.auH = -2147483648;
      }
      if ((localLayoutParams.aqL.isRemoved()) || (localLayoutParams.aqL.lC())) {
        this.auI += StaggeredGridLayoutManager.this.auc.br(paramView);
      }
    }
    
    final void bZ(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.auu = this;
      this.auF.add(paramView);
      this.auH = -2147483648;
      if (this.auF.size() == 1) {
        this.auG = -2147483648;
      }
      if ((localLayoutParams.aqL.isRemoved()) || (localLayoutParams.aqL.lC())) {
        this.auI += StaggeredGridLayoutManager.this.auc.br(paramView);
      }
    }
    
    final int cX(int paramInt)
    {
      if (this.auG != -2147483648) {
        paramInt = this.auG;
      }
      while (this.auF.size() == 0) {
        return paramInt;
      }
      mh();
      return this.auG;
    }
    
    final int cY(int paramInt)
    {
      if (this.auH != -2147483648) {
        paramInt = this.auH;
      }
      while (this.auF.size() == 0) {
        return paramInt;
      }
      mj();
      return this.auH;
    }
    
    final void cZ(int paramInt)
    {
      this.auG = paramInt;
      this.auH = paramInt;
    }
    
    final void clear()
    {
      this.auF.clear();
      gO();
      this.auI = 0;
    }
    
    final void da(int paramInt)
    {
      if (this.auG != -2147483648) {
        this.auG += paramInt;
      }
      if (this.auH != -2147483648) {
        this.auH += paramInt;
      }
    }
    
    final int f(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return a(paramInt1, paramInt2, paramBoolean, true, false);
    }
    
    final int mi()
    {
      if (this.auG != -2147483648) {
        return this.auG;
      }
      mh();
      return this.auG;
    }
    
    final int mk()
    {
      if (this.auH != -2147483648) {
        return this.auH;
      }
      mj();
      return this.auH;
    }
    
    final void ml()
    {
      int i = this.auF.size();
      View localView = (View)this.auF.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.auu = null;
      if ((localLayoutParams.aqL.isRemoved()) || (localLayoutParams.aqL.lC())) {
        this.auI -= StaggeredGridLayoutManager.this.auc.br(localView);
      }
      if (i == 1) {
        this.auG = -2147483648;
      }
      this.auH = -2147483648;
    }
    
    final void mm()
    {
      View localView = (View)this.auF.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.auu = null;
      if (this.auF.size() == 0) {
        this.auH = -2147483648;
      }
      if ((localLayoutParams.aqL.isRemoved()) || (localLayoutParams.aqL.lC())) {
        this.auI -= StaggeredGridLayoutManager.this.auc.br(localView);
      }
      this.auG = -2147483648;
    }
    
    public final int mn()
    {
      if (StaggeredGridLayoutManager.this.anv) {
        return aN(this.auF.size() - 1, -1);
      }
      return aN(0, this.auF.size());
    }
    
    public final int mo()
    {
      if (StaggeredGridLayoutManager.this.anv) {
        return aN(0, this.auF.size());
      }
      return aN(this.auF.size() - 1, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */