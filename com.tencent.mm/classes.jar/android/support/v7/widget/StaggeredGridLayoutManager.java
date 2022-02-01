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
  private final Rect Sh = new Rect();
  public int anI = -1;
  boolean aoq = false;
  boolean aor = false;
  private boolean aot = true;
  int aou = -1;
  int aov = -2147483648;
  b[] auW;
  aj auX;
  aj auY;
  private int auZ;
  private final ad ava;
  private BitSet avb;
  LazySpanLookup avc = new LazySpanLookup();
  private int avd = 2;
  private boolean ave;
  private boolean avf;
  private SavedState avh;
  private int avi;
  private final a avj = new a();
  private boolean avk = false;
  private int[] avl;
  private final Runnable avm = new Runnable()
  {
    public final void run()
    {
      StaggeredGridLayoutManager.this.mf();
    }
  };
  public int mOrientation;
  
  public StaggeredGridLayoutManager(int paramInt)
  {
    this.mOrientation = 1;
    bV(paramInt);
    this.ava = new ad();
    me();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = paramContext.orientation;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    G(null);
    if (paramInt1 != this.mOrientation)
    {
      this.mOrientation = paramInt1;
      paramAttributeSet = this.auX;
      this.auX = this.auY;
      this.auY = paramAttributeSet;
      requestLayout();
    }
    bV(paramContext.arE);
    ap(paramContext.arF);
    this.ava = new ad();
    me();
  }
  
  private int a(RecyclerView.o paramo, ad paramad, RecyclerView.t paramt)
  {
    this.avb.set(0, this.anI, true);
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
    if (this.ava.aoa) {
      if (paramad.mLayoutDirection == 1)
      {
        i = 2147483647;
        aI(paramad.mLayoutDirection, i);
        if (!this.aor) {
          break label552;
        }
        m = this.auX.km();
        j = 0;
        if ((!paramad.b(paramt)) || ((!this.ava.aoa) && (this.avb.isEmpty()))) {
          break label868;
        }
        localView = paramad.a(paramo);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.arH.lu();
        j = this.avc.cQ(i2);
        if (j != -1) {
          break label564;
        }
        i1 = 1;
        if (i1 == 0) {
          break label580;
        }
        if (!localLayoutParams.avr) {
          break label570;
        }
        localb = this.auW[0];
        this.avc.a(i2, localb);
        localLayoutParams.avq = localb;
        if (paramad.mLayoutDirection != 1) {
          break label592;
        }
        addView(localView);
        a(localView, localLayoutParams);
        if (paramad.mLayoutDirection != 1) {
          break label614;
        }
        if (!localLayoutParams.avr) {
          break label602;
        }
        j = cK(m);
        n = this.auX.br(localView) + j;
        if ((i1 == 0) || (!localLayoutParams.avr)) {
          break label959;
        }
        localFullSpanItem = cG(j);
        localFullSpanItem.avt = -1;
        localFullSpanItem.mPosition = i2;
        this.avc.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.avr) && (paramad.anW == -1))
      {
        if (i1 == 0)
        {
          if (paramad.mLayoutDirection != 1) {
            break label712;
          }
          if (mk()) {
            break label706;
          }
          j = 1;
          label324:
          if (j == 0) {
            break label356;
          }
          localFullSpanItem = this.avc.cU(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.avv = true;
          }
        }
        this.avk = true;
      }
      label356:
      a(localView, localLayoutParams, paramad);
      if ((ji()) && (this.mOrientation == 1)) {
        if (localLayoutParams.avr)
        {
          j = this.auY.km();
          label397:
          i2 = j - this.auY.br(localView);
          i1 = j;
          j = i2;
          if (this.mOrientation != 1) {
            break label818;
          }
          k(localView, j, k, i1, n);
          label440:
          if (!localLayoutParams.avr) {
            break label834;
          }
          aI(this.ava.mLayoutDirection, i);
          label461:
          a(paramo, this.ava);
          if ((this.ava.anZ) && (localView.hasFocusable()))
          {
            if (!localLayoutParams.avr) {
              break label852;
            }
            this.avb.clear();
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
          i = paramad.anY + paramad.anU;
          break;
        }
        i = paramad.anX - paramad.anU;
        break;
        label552:
        m = this.auX.kl();
        break label61;
        label564:
        i1 = 0;
        break label139;
        label570:
        localb = a(paramad);
        break label160;
        label580:
        localb = this.auW[j];
        break label171;
        label592:
        addView(localView, 0);
        break label192;
        label602:
        j = localb.cX(m);
        break label224;
        label614:
        if (localLayoutParams.avr) {}
        for (j = cJ(m);; j = localb.cW(m))
        {
          k = j - this.auX.br(localView);
          if ((i1 != 0) && (localLayoutParams.avr))
          {
            localFullSpanItem = cH(j);
            localFullSpanItem.avt = 1;
            localFullSpanItem.mPosition = i2;
            this.avc.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        label706:
        j = 0;
        break label324;
        label712:
        if (!ml())
        {
          j = 1;
          break label324;
        }
        j = 0;
        break label324;
        j = this.auY.km() - (this.anI - 1 - localb.mIndex) * this.auZ;
        break label397;
        if (localLayoutParams.avr) {}
        for (j = this.auY.kl();; j = localb.mIndex * this.auZ + this.auY.kl())
        {
          i1 = j + this.auY.br(localView);
          break;
        }
        label818:
        k(localView, k, j, n, i1);
        break label440;
        label834:
        a(localb, this.ava.mLayoutDirection, i);
        break label461;
        label852:
        this.avb.set(localb.mIndex, false);
      }
      label868:
      if (j == 0) {
        a(paramo, this.ava);
      }
      if (this.ava.mLayoutDirection == -1) {
        i = cJ(this.auX.kl());
      }
      for (i = this.auX.kl() - i; i > 0; i = cK(this.auX.km()) - this.auX.km()) {
        return Math.min(paramad.anU, i);
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
      i = this.anI - 1;
      j = -1;
      k = -1;
      if (paramad.mLayoutDirection != 1) {
        break label121;
      }
      n = 2147483647;
      i1 = this.auX.kl();
      m = i;
      paramad = (ad)localObject1;
      i = n;
      label59:
      localObject1 = paramad;
      if (m == k) {
        break label192;
      }
      localObject1 = this.auW[m];
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
      k = this.anI;
      j = 1;
      break;
      label121:
      n = -2147483648;
      i1 = this.auX.km();
      m = i;
      paramad = localObject2;
      i = n;
      localObject1 = paramad;
      if (m != k)
      {
        localObject1 = this.auW[m];
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
    this.ava.anU = 0;
    this.ava.anV = paramInt;
    int i;
    boolean bool1;
    if (lf())
    {
      i = paramt.arZ;
      if (i != -1)
      {
        boolean bool3 = this.aor;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.auX.kn();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.ava.anX = (this.auX.kl() - i);
        this.ava.anY = (paramInt + this.auX.km());
      }
      for (;;)
      {
        this.ava.anZ = false;
        this.ava.anT = true;
        paramt = this.ava;
        bool1 = bool2;
        if (this.auX.getMode() == 0)
        {
          bool1 = bool2;
          if (this.auX.getEnd() == 0) {
            bool1 = true;
          }
        }
        paramt.aoa = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i = this.auX.kn();
        paramInt = 0;
        break label67;
        this.ava.anY = (paramInt + this.auX.getEnd());
        this.ava.anX = (-i);
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
        if ((this.auX.bo(localView) <= paramInt) && (this.auX.bp(localView) <= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.avr) {
            break label118;
          }
          i = 0;
          if (i >= this.anI) {
            break label92;
          }
          if (this.auW[i].avB.size() != 1) {
            break label85;
          }
        }
      }
      label85:
      label92:
      label118:
      while (localLayoutParams.avq.avB.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.anI)
        {
          this.auW[i].mw();
          i += 1;
        }
      }
      localLayoutParams.avq.mw();
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
        i = this.auX.km() - i;
      } while (i <= 0);
      i -= -c(-i, paramo, paramt);
    } while ((!paramBoolean) || (i <= 0));
    this.auX.cf(i);
  }
  
  private void a(RecyclerView.o paramo, ad paramad)
  {
    if ((!paramad.anT) || (paramad.aoa)) {
      return;
    }
    if (paramad.anU == 0)
    {
      if (paramad.mLayoutDirection == -1)
      {
        b(paramo, paramad.anY);
        return;
      }
      a(paramo, paramad.anX);
      return;
    }
    if (paramad.mLayoutDirection == -1)
    {
      i = paramad.anX - cI(paramad.anX);
      if (i < 0) {}
      for (i = paramad.anY;; i = paramad.anY - Math.min(i, paramad.anU))
      {
        b(paramo, i);
        return;
      }
    }
    int i = cL(paramad.anY) - paramad.anY;
    if (i < 0) {}
    int j;
    for (i = paramad.anX;; i = Math.min(i, paramad.anU) + j)
    {
      a(paramo, i);
      return;
      j = paramad.anX;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.avE;
    if (paramInt1 == -1) {
      if (i + paramb.ms() <= paramInt2) {
        this.avb.set(paramb.mIndex, false);
      }
    }
    while (paramb.mu() - i < paramInt2) {
      return;
    }
    this.avb.set(paramb.mIndex, false);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.avr)
    {
      if (this.mOrientation == 1)
      {
        l(paramView, this.avi, b(this.mHeight, this.arC, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
        return;
      }
      l(paramView, b(this.mWidth, this.arB, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.avi);
      return;
    }
    if (this.mOrientation == 1)
    {
      l(paramView, b(this.auZ, this.arB, 0, paramLayoutParams.width, false), b(this.mHeight, this.arC, getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
      return;
    }
    l(paramView, b(this.mWidth, this.arB, getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), b(this.auZ, this.arC, 0, paramLayoutParams.height, false));
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, ad paramad)
  {
    if (paramad.mLayoutDirection == 1)
    {
      if (paramLayoutParams.avr)
      {
        bW(paramView);
        return;
      }
      paramLayoutParams.avq.bZ(paramView);
      return;
    }
    if (paramLayoutParams.avr)
    {
      bX(paramView);
      return;
    }
    paramLayoutParams.avq.bY(paramView);
  }
  
  private boolean a(b paramb)
  {
    if (this.aor)
    {
      if (paramb.mu() < this.auX.km()) {
        return !((LayoutParams)((View)paramb.avB.get(paramb.avB.size() - 1)).getLayoutParams()).avr;
      }
    }
    else if (paramb.ms() > this.auX.kl()) {
      return !((LayoutParams)((View)paramb.avB.get(0)).getLayoutParams()).avr;
    }
    return false;
  }
  
  private View aC(boolean paramBoolean)
  {
    int j = this.auX.kl();
    int k = this.auX.km();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.auX.bn(localView);
      if ((this.auX.bo(localView) <= j) || (n >= k)) {
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
    int j = this.auX.kl();
    int k = this.auX.km();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.auX.bn(localView);
      int n = this.auX.bo(localView);
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
    while (i < this.anI)
    {
      if (!this.auW[i].avB.isEmpty()) {
        a(this.auW[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private void ap(boolean paramBoolean)
  {
    G(null);
    if ((this.avh != null) && (this.avh.aoq != paramBoolean)) {
      this.avh.aoq = paramBoolean;
    }
    this.aoq = paramBoolean;
    requestLayout();
  }
  
  private void b(int paramInt, RecyclerView.t paramt)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = mm();
      j = 1;
    }
    for (;;)
    {
      this.ava.anT = true;
      a(i, paramt);
      cF(j);
      paramt = this.ava;
      paramt.anV = (i + paramt.anW);
      this.ava.anU = Math.abs(paramInt);
      return;
      j = -1;
      i = mn();
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
        if ((this.auX.bn(localView) >= paramInt) && (this.auX.bq(localView) >= paramInt))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.avr) {
            break label132;
          }
          j = 0;
          if (j >= this.anI) {
            break label101;
          }
          if (this.auW[j].avB.size() != 1) {
            break label92;
          }
        }
      }
      label92:
      label101:
      while (localLayoutParams.avq.avB.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.anI)
        {
          this.auW[j].mv();
          j += 1;
        }
      }
      label132:
      localLayoutParams.avq.mv();
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
        i -= this.auX.kl();
      } while (i <= 0);
      i -= c(i, paramo, paramt);
    } while ((!paramBoolean) || (i <= 0));
    this.auX.cf(-i);
  }
  
  private void bV(int paramInt)
  {
    G(null);
    if (paramInt != this.anI)
    {
      this.avc.clear();
      requestLayout();
      this.anI = paramInt;
      this.avb = new BitSet(this.anI);
      this.auW = new b[this.anI];
      paramInt = 0;
      while (paramInt < this.anI)
      {
        this.auW[paramInt] = new b(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  private void bW(View paramView)
  {
    int i = this.anI - 1;
    while (i >= 0)
    {
      this.auW[i].bZ(paramView);
      i -= 1;
    }
  }
  
  private void bX(View paramView)
  {
    int i = this.anI - 1;
    while (i >= 0)
    {
      this.auW[i].bY(paramView);
      i -= 1;
    }
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    b(paramInt, paramt);
    int j = a(paramo, this.ava, paramt);
    int i = paramInt;
    if (this.ava.anU >= j) {
      if (paramInt >= 0) {
        break label93;
      }
    }
    label93:
    for (i = -j;; i = j)
    {
      this.auX.cf(-i);
      this.ave = this.aor;
      this.ava.anU = 0;
      a(paramo, this.ava);
      return i;
    }
  }
  
  private void cE(int paramInt)
  {
    this.auZ = (paramInt / this.anI);
    this.avi = View.MeasureSpec.makeMeasureSpec(paramInt, this.auY.getMode());
  }
  
  private void cF(int paramInt)
  {
    int i = 1;
    this.ava.mLayoutDirection = paramInt;
    ad localad = this.ava;
    boolean bool2 = this.aor;
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
      localad.anW = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cG(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.avu = new int[this.anI];
    int i = 0;
    while (i < this.anI)
    {
      localFullSpanItem.avu[i] = (paramInt - this.auW[i].cX(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem cH(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.avu = new int[this.anI];
    int i = 0;
    while (i < this.anI)
    {
      localFullSpanItem.avu[i] = (this.auW[i].cW(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private int cI(int paramInt)
  {
    int j = this.auW[0].cW(paramInt);
    int i = 1;
    while (i < this.anI)
    {
      int m = this.auW[i].cW(paramInt);
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
    int j = this.auW[0].cW(paramInt);
    int i = 1;
    while (i < this.anI)
    {
      int m = this.auW[i].cW(paramInt);
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
    int j = this.auW[0].cX(paramInt);
    int i = 1;
    while (i < this.anI)
    {
      int m = this.auW[i].cX(paramInt);
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
    int j = this.auW[0].cX(paramInt);
    int i = 1;
    while (i < this.anI)
    {
      int m = this.auW[i].cX(paramInt);
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
        if (i == this.aor) {
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
        if (i != this.aor) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == ji()) {
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
      if (!this.aor) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < mn()) {}
      for (int i = 1; i != this.aor; i = 0) {
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
    aj localaj = this.auX;
    View localView;
    if (!this.aot)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.aot) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, aD(bool1), this, this.aot, this.aor);
      bool1 = false;
      break;
    }
  }
  
  private void jO()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!ji())) {
      bool = this.aoq;
    }
    for (;;)
    {
      this.aor = bool;
      return;
      if (this.aoq) {
        bool = false;
      }
    }
  }
  
  private boolean ji()
  {
    return t.Y(this.alu) == 1;
  }
  
  private int k(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.auX;
    View localView;
    if (!this.aot)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.aot) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, aD(bool1), this, this.aot);
      bool1 = false;
      break;
    }
  }
  
  private int l(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.auX;
    View localView;
    if (!this.aot)
    {
      bool1 = true;
      localView = aC(bool1);
      if (this.aot) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(paramt, localaj, localView, aD(bool1), this, this.aot);
      bool1 = false;
      break;
    }
  }
  
  private void l(View paramView, int paramInt1, int paramInt2)
  {
    f(paramView, this.Sh);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = p(paramInt1, localLayoutParams.leftMargin + this.Sh.left, localLayoutParams.rightMargin + this.Sh.right);
    paramInt2 = p(paramInt2, localLayoutParams.topMargin + this.Sh.top, localLayoutParams.bottomMargin + this.Sh.bottom);
    if (b(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void me()
  {
    this.auX = aj.a(this, this.mOrientation);
    this.auY = aj.a(this, 1 - this.mOrientation);
  }
  
  private View mg()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.anI);
    localBitSet.set(0, this.anI, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (ji()))
    {
      j = 1;
      if (!this.aor) {
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
      if (!localBitSet.get(localLayoutParams.avq.mIndex)) {
        break label162;
      }
      if (!a(localLayoutParams.avq)) {
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
    localBitSet.clear(localLayoutParams.avq.mIndex);
    label162:
    Object localObject;
    int i1;
    if ((!localLayoutParams.avr) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.aor)
      {
        i = this.auX.bo(localView);
        i1 = this.auX.bo((View)localObject);
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
        if (localLayoutParams.avq.mIndex - ((LayoutParams)localObject).avq.mIndex < 0)
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
          i = this.auX.bn(localView);
          i1 = this.auX.bn((View)localObject);
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
  
  private boolean mk()
  {
    boolean bool2 = true;
    int j = this.auW[0].cX(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.anI)
      {
        if (this.auW[i].cX(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean ml()
  {
    boolean bool2 = true;
    int j = this.auW[0].cW(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.anI)
      {
        if (this.auW[i].cW(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int mm()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return bB(getChildAt(i - 1));
  }
  
  private int mn()
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
    if (this.aor)
    {
      k = mm();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.avc.cP(i);
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
      k = mn();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.avc.aL(paramInt1, paramInt2);
      break label76;
      this.avc.aJ(paramInt1, paramInt2);
      break label76;
      this.avc.aJ(paramInt1, 1);
      this.avc.aL(paramInt2, 1);
      break label76;
      if (this.aor) {}
      for (paramInt1 = mn(); i <= paramInt1; paramInt1 = mm())
      {
        requestLayout();
        return;
      }
    }
  }
  
  public final void G(String paramString)
  {
    if (this.avh == null) {
      super.G(paramString);
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    return c(paramInt, paramo, paramt);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 0) {
      return this.anI;
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
      jO();
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
        else if (ji())
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
          else if (ji())
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
      boolean bool = paramView.avr;
      localb = paramView.avq;
      if (paramInt == 1) {}
      for (i = mm();; i = mn())
      {
        a(i, paramt);
        cF(paramInt);
        paramView = this.ava;
        paramView.anV = (paramView.anW + i);
        this.ava.anU = ((int)(0.3333333F * this.auX.kn()));
        this.ava.anZ = true;
        this.ava.anT = false;
        a(paramo, this.ava, paramt);
        this.ave = this.aor;
        if (bool) {
          break;
        }
        paramView = localb.aO(i, paramInt);
        if ((paramView == null) || (paramView == localView)) {
          break;
        }
        return paramView;
      }
      if (cM(paramInt))
      {
        j = this.anI - 1;
        while (j >= 0)
        {
          paramView = this.auW[j].aO(i, paramInt);
          if ((paramView != null) && (paramView != localView)) {
            return paramView;
          }
          j -= 1;
        }
      }
      j = 0;
      while (j < this.anI)
      {
        paramView = this.auW[j].aO(i, paramInt);
        if ((paramView != null) && (paramView != localView)) {
          return paramView;
        }
        j += 1;
      }
      if (this.aoq) {
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
      j = localb.mx();
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
      paramInt = this.anI - 1;
      label567:
      if (paramInt >= 0)
      {
        if (paramInt != localb.mIndex) {
          if (i == 0) {
            break label650;
          }
        }
        for (j = this.auW[paramInt].mx();; j = this.auW[paramInt].my())
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
          j = localb.my();
          break label533;
        }
      }
    }
    else
    {
      paramInt = 0;
      while (paramInt < this.anI)
      {
        if (i != 0) {}
        for (j = this.auW[paramInt].mx();; j = this.auW[paramInt].my())
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
      if ((this.avl == null) || (this.avl.length < this.anI)) {
        this.avl = new int[this.anI];
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramInt2 < this.anI)
      {
        if (this.ava.anW == -1) {}
        for (int j = this.ava.anX - this.auW[paramInt2].cW(this.ava.anX);; j = this.auW[paramInt2].cX(this.ava.anY) - this.ava.anY)
        {
          int i = paramInt1;
          if (j >= 0)
          {
            this.avl[paramInt1] = j;
            i = paramInt1 + 1;
          }
          paramInt2 += 1;
          paramInt1 = i;
          break;
        }
      }
      Arrays.sort(this.avl, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.ava.b(paramt)))
      {
        parama.R(this.ava.anV, this.avl[paramInt2]);
        ad localad = this.ava;
        localad.anV += this.ava.anW;
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
      i = m(paramInt2, k + paramRect.height(), t.af(this.alu));
      paramInt2 = m(paramInt1, j + this.auZ * this.anI, t.ae(this.alu));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = m(paramInt1, j + paramRect.width(), t.ae(this.alu));
      paramInt1 = m(paramInt2, k + this.auZ * this.anI, t.af(this.alu));
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
      k = paramo.mp();
      if (paramo.avr) {
        i = this.anI;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      paramc.G(c.c.a(k, j, m, i, paramo.avr));
      return;
      m = paramo.mp();
      if (paramo.avr)
      {
        i = this.anI;
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
    this.aou = -1;
    this.aov = -2147483648;
    this.avh = null;
    this.avj.reset();
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    this.avc.clear();
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
    removeCallbacks(this.avm);
    int i = 0;
    while (i < this.anI)
    {
      this.auW[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.arZ = paramInt;
    a(paramRecyclerView);
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void af(int paramInt1, int paramInt2)
  {
    if (this.avh != null) {
      this.avh.mq();
    }
    this.aou = paramInt1;
    this.aov = paramInt2;
    requestLayout();
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    return c(paramInt, paramo, paramt);
  }
  
  public final int b(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 1) {
      return this.anI;
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
    a locala = this.avj;
    if (((this.avh != null) || (this.aou != -1)) && (paramt.getItemCount() == 0))
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
    if ((!locala.aoD) || (this.aou != -1) || (this.avh != null))
    {
      k = 1;
      if (k == 0) {
        break label463;
      }
      locala.reset();
      if (this.avh == null) {
        break label614;
      }
      if (this.avh.avx <= 0) {
        break label268;
      }
      if (this.avh.avx != this.anI) {
        break label218;
      }
      m = 0;
      if (m >= this.anI) {
        break label268;
      }
      this.auW[m].clear();
      n = this.avh.avy[m];
      i = n;
      if (n != -2147483648) {
        if (!this.avh.aoN) {
          break label203;
        }
      }
    }
    label203:
    for (int i = n + this.auX.km();; i = n + this.auX.kl())
    {
      this.auW[m].cY(i);
      m += 1;
      break label112;
      k = 0;
      break;
    }
    label218:
    Object localObject1 = this.avh;
    ((SavedState)localObject1).avy = null;
    ((SavedState)localObject1).avx = 0;
    ((SavedState)localObject1).avz = 0;
    ((SavedState)localObject1).avA = null;
    ((SavedState)localObject1).avs = null;
    this.avh.aoL = this.avh.avw;
    label268:
    this.avf = this.avh.avf;
    ap(this.avh.aoq);
    jO();
    if (this.avh.aoL != -1)
    {
      this.aou = this.avh.aoL;
      locala.aoC = this.avh.aoN;
      if (this.avh.avz > 1)
      {
        this.avc.mData = this.avh.avA;
        this.avc.avs = this.avh.avs;
      }
      label367:
      if ((!paramt.asp) && (this.aou != -1)) {
        break label630;
      }
      i = 0;
      label385:
      if (i == 0)
      {
        if (!this.ave) {
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
      locala.MW = -2147483648;
      locala.aoD = true;
      if ((this.avh == null) && (this.aou == -1) && ((locala.aoC != this.ave) || (ji() != this.avf)))
      {
        this.avc.clear();
        locala.avo = true;
      }
      if ((getChildCount() <= 0) || ((this.avh != null) && (this.avh.avx > 0))) {
        break label1525;
      }
      if (!locala.avo) {
        break label1213;
      }
      i = 0;
      while (i < this.anI)
      {
        this.auW[i].clear();
        if (locala.MW != -2147483648) {
          this.auW[i].cY(locala.MW);
        }
        i += 1;
      }
      locala.aoC = this.aor;
      break;
      jO();
      locala.aoC = this.aor;
      break label367;
      if ((this.aou < 0) || (this.aou >= paramt.getItemCount()))
      {
        this.aou = -1;
        this.aov = -2147483648;
        i = 0;
        break label385;
      }
      if ((this.avh == null) || (this.avh.aoL == -1) || (this.avh.avx <= 0))
      {
        localObject1 = bY(this.aou);
        if (localObject1 != null)
        {
          if (this.aor)
          {
            i = mm();
            locala.mPosition = i;
            if (this.aov == -2147483648) {
              break label817;
            }
            if (!locala.aoC) {
              break label787;
            }
          }
          label787:
          for (locala.MW = (this.auX.km() - this.aov - this.auX.bo((View)localObject1));; locala.MW = (this.auX.kl() + this.aov - this.auX.bn((View)localObject1)))
          {
            i = 1;
            break;
            i = mn();
            break label721;
          }
          label817:
          if (this.auX.br((View)localObject1) > this.auX.kn()) {
            if (locala.aoC)
            {
              i = this.auX.km();
              locala.MW = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.auX.kl();
        break label853;
        i = this.auX.bn((View)localObject1) - this.auX.kl();
        if (i < 0)
        {
          locala.MW = (-i);
        }
        else
        {
          i = this.auX.km() - this.auX.bo((View)localObject1);
          if (i < 0)
          {
            locala.MW = i;
          }
          else
          {
            locala.MW = -2147483648;
            continue;
            locala.mPosition = this.aou;
            if (this.aov == -2147483648) {
              if (cN(locala.mPosition) == 1)
              {
                bool = true;
                locala.aoC = bool;
                if (!locala.aoC) {
                  break label1041;
                }
                i = locala.avn.auX.km();
                locala.MW = i;
              }
            }
            for (;;)
            {
              locala.avo = true;
              break;
              bool = false;
              break label991;
              label1041:
              i = locala.avn.auX.kl();
              break label1019;
              i = this.aov;
              if (locala.aoC) {
                locala.MW = (locala.avn.auX.km() - i);
              } else {
                locala.MW = (i + locala.avn.auX.kl());
              }
            }
            locala.MW = -2147483648;
            locala.mPosition = this.aou;
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
    if ((k != 0) || (this.avj.avp == null))
    {
      k = 0;
      if (k < this.anI)
      {
        localObject1 = this.auW[k];
        bool = this.aor;
        n = locala.MW;
        if (bool)
        {
          i = ((b)localObject1).cX(-2147483648);
          ((b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((b)localObject1).avn.auX.km())) && ((bool) || (i <= ((b)localObject1).avn.auX.kl()))) {
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
          ((b)localObject1).avD = m;
          ((b)localObject1).avC = m;
        }
      }
      localObject1 = this.avj;
      localObject2 = this.auW;
      k = localObject2.length;
      if ((((a)localObject1).avp == null) || (((a)localObject1).avp.length < k)) {
        ((a)localObject1).avp = new int[((a)localObject1).avn.auW.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((a)localObject1).avp[i] = localObject2[i].cW(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.anI)
      {
        localObject1 = this.auW[i];
        ((b)localObject1).clear();
        ((b)localObject1).cY(this.avj.avp[i]);
        i += 1;
      }
    }
    label1525:
    b(paramo);
    this.ava.anT = false;
    this.avk = false;
    cE(this.auY.kn());
    a(locala.mPosition, paramt);
    label1624:
    float f1;
    if (locala.aoC)
    {
      cF(-1);
      a(paramo, this.ava, paramt);
      cF(1);
      this.ava.anV = (locala.mPosition + this.ava.anW);
      a(paramo, this.ava, paramt);
      if (this.auY.getMode() == 1073741824) {
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
      float f2 = this.auY.br((View)localObject1);
      if (f2 < f1) {
        break label2199;
      }
      if (!((LayoutParams)((View)localObject1).getLayoutParams()).avr) {
        break label2196;
      }
      f2 = 1.0F * f2 / this.anI;
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
      a(paramo, this.ava, paramt);
      cF(-1);
      this.ava.anV = (locala.mPosition + this.ava.anW);
      a(paramo, this.ava, paramt);
      break label1624;
      label1779:
      n = this.auZ;
      k = Math.round(this.anI * f1);
      i = k;
      if (this.auY.getMode() == -2147483648) {
        i = Math.min(k, this.auY.kn());
      }
      cE(i);
      if (this.auZ != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (!((LayoutParams)localObject2).avr)
          {
            if ((!ji()) || (this.mOrientation != 1)) {
              break label1948;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.anI - 1 - ((LayoutParams)localObject2).avq.mIndex) * this.auZ - -(this.anI - 1 - ((LayoutParams)localObject2).avq.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            label1948:
            k = ((LayoutParams)localObject2).avq.mIndex * this.auZ;
            i1 = ((LayoutParams)localObject2).avq.mIndex * n;
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
        if (this.aor)
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
          if (!paramt.asp) {
            if ((this.avd == 0) || (getChildCount() <= 0) || ((!this.avk) && (mg() == null))) {
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
          removeCallbacks(this.avm);
          i = k;
          if (mf()) {
            i = 1;
          }
        }
        if (paramt.asp) {
          this.avj.reset();
        }
        this.ave = locala.aoC;
        this.avf = ji();
        if (i == 0) {
          break label41;
        }
        this.avj.reset();
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
    if ((this.avh != null) && (this.avh.aoL != paramInt)) {
      this.avh.mq();
    }
    this.aou = paramInt;
    this.aov = -2147483648;
    requestLayout();
  }
  
  public final void cn(int paramInt)
  {
    super.cn(paramInt);
    int i = 0;
    while (i < this.anI)
    {
      this.auW[i].cZ(paramInt);
      i += 1;
    }
  }
  
  public final void co(int paramInt)
  {
    super.co(paramInt);
    int i = 0;
    while (i < this.anI)
    {
      this.auW[i].cZ(paramInt);
      i += 1;
    }
  }
  
  public final void cp(int paramInt)
  {
    if (paramInt == 0) {
      mf();
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
  
  public final RecyclerView.LayoutParams jG()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public final int jJ()
  {
    return this.anI;
  }
  
  public final boolean jK()
  {
    return this.avh == null;
  }
  
  public final boolean jL()
  {
    return this.avd != 0;
  }
  
  public final boolean jM()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean jN()
  {
    return this.mOrientation == 1;
  }
  
  final boolean mf()
  {
    if ((getChildCount() == 0) || (this.avd == 0) || (!this.ou)) {
      return false;
    }
    int j;
    if (this.aor) {
      j = mm();
    }
    for (int i = mn(); (j == 0) && (mg() != null); i = mm())
    {
      this.avc.clear();
      li();
      requestLayout();
      return true;
      j = mn();
    }
    if (!this.avk) {
      return false;
    }
    if (this.aor) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.avc.r(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.avk = false;
      this.avc.cO(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.avc.r(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.avc.cO(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      li();
      requestLayout();
      return true;
      this.avc.cO(localFullSpanItem2.mPosition + 1);
    }
  }
  
  public final int[] mh()
  {
    int[] arrayOfInt = new int[this.anI];
    int i = 0;
    if (i < this.anI)
    {
      b localb = this.auW[i];
      if (localb.avn.aoq) {}
      for (int j = localb.f(localb.avB.size() - 1, -1, true);; j = localb.f(0, localb.avB.size(), true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public final int[] mi()
  {
    int[] arrayOfInt = new int[this.anI];
    int i = 0;
    if (i < this.anI)
    {
      b localb = this.auW[i];
      if (localb.avn.aoq) {}
      for (int j = localb.f(0, localb.avB.size(), false);; j = localb.f(localb.avB.size() - 1, -1, false))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public final int[] mj()
  {
    int[] arrayOfInt = new int[this.anI];
    int i = 0;
    if (i < this.anI)
    {
      b localb = this.auW[i];
      if (localb.avn.aoq) {}
      for (int j = localb.f(0, localb.avB.size(), true);; j = localb.f(localb.avB.size() - 1, -1, true))
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
      arrayOfInt = new int[this.anI];
      i = 0;
      label14:
      if (i >= this.anI) {
        break label135;
      }
      paramArrayOfInt = this.auW[i];
      if (!paramArrayOfInt.avn.aoq) {
        break label118;
      }
    }
    label118:
    for (int j = paramArrayOfInt.f(paramArrayOfInt.avB.size() - 1, -1, false);; j = paramArrayOfInt.f(0, paramArrayOfInt.avB.size(), false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label14;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.anI) {
        break;
      }
      throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.anI + ", array size:" + paramArrayOfInt.length);
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
      this.avh = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.avh != null) {
      return new SavedState(this.avh);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.aoq = this.aoq;
    localSavedState.aoN = this.ave;
    localSavedState.avf = this.avf;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((this.avc != null) && (this.avc.mData != null))
    {
      localSavedState.avA = this.avc.mData;
      localSavedState.avz = localSavedState.avA.length;
      localSavedState.avs = this.avc.avs;
      if (getChildCount() <= 0) {
        break label310;
      }
      if (!this.ave) {
        break label250;
      }
      i = mm();
      localSavedState.aoL = i;
      if (!this.aor) {
        break label258;
      }
      localView = aD(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      localSavedState.avw = i;
      localSavedState.avx = this.anI;
      localSavedState.avy = new int[this.anI];
      j = 0;
      if (j >= this.anI) {
        break label328;
      }
      if (!this.ave) {
        break label277;
      }
      k = this.auW[j].cX(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.auX.km();
      }
    }
    for (;;)
    {
      localSavedState.avy[j] = i;
      j += 1;
      break label181;
      localSavedState.avz = 0;
      break;
      label250:
      i = mn();
      break label126;
      label258:
      localView = aC(true);
      break label146;
      label268:
      i = bB(localView);
      break label153;
      label277:
      k = this.auW[j].cW(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.auX.kl();
      }
    }
    label310:
    localSavedState.aoL = -1;
    localSavedState.avw = -1;
    localSavedState.avx = 0;
    label328:
    return localSavedState;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b avq;
    boolean avr;
    
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
      this.avr = paramBoolean;
    }
    
    public final boolean mo()
    {
      return this.avr;
    }
    
    public final int mp()
    {
      if (this.avq == null) {
        return -1;
      }
      return this.avq.mIndex;
    }
  }
  
  static final class LazySpanLookup
  {
    List<FullSpanItem> avs;
    int[] mData;
    
    private void aK(int paramInt1, int paramInt2)
    {
      if (this.avs == null) {
        return;
      }
      int i = this.avs.size() - 1;
      label20:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.avs.get(i);
        if (localFullSpanItem.mPosition >= paramInt1)
        {
          if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
            break label77;
          }
          this.avs.remove(i);
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
      if (this.avs == null) {}
      for (;;)
      {
        return;
        int i = this.avs.size() - 1;
        while (i >= 0)
        {
          FullSpanItem localFullSpanItem = (FullSpanItem)this.avs.get(i);
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
      if (this.avs == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = cU(paramInt);
      if (localFullSpanItem != null) {
        this.avs.remove(localFullSpanItem);
      }
      int j = this.avs.size();
      int i = 0;
      if (i < j) {
        if (((FullSpanItem)this.avs.get(i)).mPosition < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)this.avs.get(i);
          this.avs.remove(i);
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
      if (this.avs == null) {
        this.avs = new ArrayList();
      }
      int j = this.avs.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.avs.get(i);
        if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
          this.avs.remove(i);
        }
        if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
        {
          this.avs.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.avs.add(paramFullSpanItem);
    }
    
    final void aJ(int paramInt1, int paramInt2)
    {
      if ((this.mData == null) || (paramInt1 >= this.mData.length)) {
        return;
      }
      cS(paramInt1 + paramInt2);
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
      cS(paramInt1 + paramInt2);
      int[] arrayOfInt = this.mData;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + paramInt2, this.mData.length - paramInt1 - paramInt2);
      Arrays.fill(this.mData, paramInt1, paramInt1 + paramInt2, -1);
      aM(paramInt1, paramInt2);
    }
    
    final int cO(int paramInt)
    {
      if (this.avs != null)
      {
        int i = this.avs.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.avs.get(i)).mPosition >= paramInt) {
            this.avs.remove(i);
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
      if (this.avs == null)
      {
        localObject = null;
        return localObject;
      }
      int i = this.avs.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label61;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.avs.get(i);
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
      this.avs = null;
    }
    
    public final FullSpanItem r(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if (this.avs == null)
      {
        localObject = null;
        return localObject;
      }
      int j = this.avs.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label112;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.avs.get(i);
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
          if (localFullSpanItem.avt == paramInt3) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.avv) {
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
      int avt;
      int[] avu;
      boolean avv;
      int mPosition;
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        this.mPosition = paramParcel.readInt();
        this.avt = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.avv = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.avu = new int[i];
            paramParcel.readIntArray(this.avu);
          }
          return;
          bool = false;
        }
      }
      
      final int cV(int paramInt)
      {
        if (this.avu == null) {
          return 0;
        }
        return this.avu[paramInt];
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.avt + ", mHasUnwantedGapAfter=" + this.avv + ", mGapPerSpan=" + Arrays.toString(this.avu) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.avt);
        if (this.avv) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.avu == null) || (this.avu.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.avu.length);
          paramParcel.writeIntArray(this.avu);
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
    int aoL;
    boolean aoN;
    boolean aoq;
    int[] avA;
    boolean avf;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> avs;
    int avw;
    int avx;
    int[] avy;
    int avz;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.aoL = paramParcel.readInt();
      this.avw = paramParcel.readInt();
      this.avx = paramParcel.readInt();
      if (this.avx > 0)
      {
        this.avy = new int[this.avx];
        paramParcel.readIntArray(this.avy);
      }
      this.avz = paramParcel.readInt();
      if (this.avz > 0)
      {
        this.avA = new int[this.avz];
        paramParcel.readIntArray(this.avA);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.aoq = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        this.aoN = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.avf = bool1;
        this.avs = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.avx = paramSavedState.avx;
      this.aoL = paramSavedState.aoL;
      this.avw = paramSavedState.avw;
      this.avy = paramSavedState.avy;
      this.avz = paramSavedState.avz;
      this.avA = paramSavedState.avA;
      this.aoq = paramSavedState.aoq;
      this.aoN = paramSavedState.aoN;
      this.avf = paramSavedState.avf;
      this.avs = paramSavedState.avs;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void mq()
    {
      this.avy = null;
      this.avx = 0;
      this.aoL = -1;
      this.avw = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(this.aoL);
      paramParcel.writeInt(this.avw);
      paramParcel.writeInt(this.avx);
      if (this.avx > 0) {
        paramParcel.writeIntArray(this.avy);
      }
      paramParcel.writeInt(this.avz);
      if (this.avz > 0) {
        paramParcel.writeIntArray(this.avA);
      }
      if (this.aoq)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.aoN) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!this.avf) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.avs);
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
    int MW;
    boolean aoC;
    boolean aoD;
    boolean avo;
    int[] avp;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.MW = -2147483648;
      this.aoC = false;
      this.avo = false;
      this.aoD = false;
      if (this.avp != null) {
        Arrays.fill(this.avp, -1);
      }
    }
  }
  
  final class b
  {
    ArrayList<View> avB = new ArrayList();
    int avC = -2147483648;
    int avD = -2147483648;
    int avE = 0;
    final int mIndex;
    
    b(int paramInt)
    {
      this.mIndex = paramInt;
    }
    
    private int a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int m = StaggeredGridLayoutManager.this.auX.kl();
      int n = StaggeredGridLayoutManager.this.auX.km();
      int j;
      int k;
      if (paramInt2 > paramInt1)
      {
        j = 1;
        k = paramInt1;
      }
      while (k != paramInt2)
      {
        View localView = (View)this.avB.get(k);
        int i1 = StaggeredGridLayoutManager.this.auX.bn(localView);
        int i2 = StaggeredGridLayoutManager.this.auX.bo(localView);
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
    
    private void gW()
    {
      this.avC = -2147483648;
      this.avD = -2147483648;
    }
    
    private void mr()
    {
      Object localObject = (View)this.avB.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.avC = StaggeredGridLayoutManager.this.auX.bn((View)localObject);
      if (localLayoutParams.avr)
      {
        localObject = StaggeredGridLayoutManager.this.avc.cU(localLayoutParams.arH.lu());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).avt == -1)) {
          this.avC -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cV(this.mIndex);
        }
      }
    }
    
    private void mt()
    {
      Object localObject = (View)this.avB.get(this.avB.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.avD = StaggeredGridLayoutManager.this.auX.bo((View)localObject);
      if (localLayoutParams.avr)
      {
        localObject = StaggeredGridLayoutManager.this.avc.cU(localLayoutParams.arH.lu());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).avt == 1))
        {
          int i = this.avD;
          this.avD = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cV(this.mIndex) + i);
        }
      }
    }
    
    public final View aO(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      if (paramInt2 == -1)
      {
        int i = this.avB.size();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView2 = (View)this.avB.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.aoq) && (StaggeredGridLayoutManager.bB(localView2) <= paramInt1)) || ((!StaggeredGridLayoutManager.this.aoq) && (StaggeredGridLayoutManager.bB(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 += 1;
          localView1 = localView2;
        }
        return localView1;
      }
      paramInt2 = this.avB.size() - 1;
      for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
      {
        localView2 = (View)this.avB.get(paramInt2);
        if (((StaggeredGridLayoutManager.this.aoq) && (StaggeredGridLayoutManager.bB(localView2) >= paramInt1)) || ((!StaggeredGridLayoutManager.this.aoq) && (StaggeredGridLayoutManager.bB(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
          break;
        }
        paramInt2 -= 1;
      }
      return localView1;
    }
    
    final void bY(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.avq = this;
      this.avB.add(0, paramView);
      this.avC = -2147483648;
      if (this.avB.size() == 1) {
        this.avD = -2147483648;
      }
      if ((localLayoutParams.arH.isRemoved()) || (localLayoutParams.arH.lL())) {
        this.avE += StaggeredGridLayoutManager.this.auX.br(paramView);
      }
    }
    
    final void bZ(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.avq = this;
      this.avB.add(paramView);
      this.avD = -2147483648;
      if (this.avB.size() == 1) {
        this.avC = -2147483648;
      }
      if ((localLayoutParams.arH.isRemoved()) || (localLayoutParams.arH.lL())) {
        this.avE += StaggeredGridLayoutManager.this.auX.br(paramView);
      }
    }
    
    final int cW(int paramInt)
    {
      if (this.avC != -2147483648) {
        paramInt = this.avC;
      }
      while (this.avB.size() == 0) {
        return paramInt;
      }
      mr();
      return this.avC;
    }
    
    final int cX(int paramInt)
    {
      if (this.avD != -2147483648) {
        paramInt = this.avD;
      }
      while (this.avB.size() == 0) {
        return paramInt;
      }
      mt();
      return this.avD;
    }
    
    final void cY(int paramInt)
    {
      this.avC = paramInt;
      this.avD = paramInt;
    }
    
    final void cZ(int paramInt)
    {
      if (this.avC != -2147483648) {
        this.avC += paramInt;
      }
      if (this.avD != -2147483648) {
        this.avD += paramInt;
      }
    }
    
    final void clear()
    {
      this.avB.clear();
      gW();
      this.avE = 0;
    }
    
    final int f(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return a(paramInt1, paramInt2, paramBoolean, true, false);
    }
    
    final int ms()
    {
      if (this.avC != -2147483648) {
        return this.avC;
      }
      mr();
      return this.avC;
    }
    
    final int mu()
    {
      if (this.avD != -2147483648) {
        return this.avD;
      }
      mt();
      return this.avD;
    }
    
    final void mv()
    {
      int i = this.avB.size();
      View localView = (View)this.avB.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.avq = null;
      if ((localLayoutParams.arH.isRemoved()) || (localLayoutParams.arH.lL())) {
        this.avE -= StaggeredGridLayoutManager.this.auX.br(localView);
      }
      if (i == 1) {
        this.avC = -2147483648;
      }
      this.avD = -2147483648;
    }
    
    final void mw()
    {
      View localView = (View)this.avB.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.avq = null;
      if (this.avB.size() == 0) {
        this.avD = -2147483648;
      }
      if ((localLayoutParams.arH.isRemoved()) || (localLayoutParams.arH.lL())) {
        this.avE -= StaggeredGridLayoutManager.this.auX.br(localView);
      }
      this.avC = -2147483648;
    }
    
    public final int mx()
    {
      if (StaggeredGridLayoutManager.this.aoq) {
        return aN(this.avB.size() - 1, -1);
      }
      return aN(0, this.avB.size());
    }
    
    public final int my()
    {
      if (StaggeredGridLayoutManager.this.aoq) {
        return aN(0, this.avB.size());
      }
      return aN(this.avB.size() - 1, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */