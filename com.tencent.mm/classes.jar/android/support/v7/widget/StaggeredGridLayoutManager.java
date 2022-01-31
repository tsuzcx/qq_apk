package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.a;
import android.support.v4.view.a.a.c;
import android.support.v4.view.q;
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
  private int adN;
  private int adr;
  boolean aeb;
  boolean aec;
  private boolean aee;
  int aef;
  int aeg;
  StaggeredGridLayoutManager.b[] akj;
  aj akk;
  aj akl;
  private int akm;
  private final ae akn;
  private BitSet ako;
  StaggeredGridLayoutManager.LazySpanLookup akp;
  private int akq;
  private boolean akr;
  private boolean aks;
  private StaggeredGridLayoutManager.SavedState akt;
  private int aku;
  private final StaggeredGridLayoutManager.a akv;
  private boolean akw;
  private int[] akx;
  private final Runnable aky;
  private final Rect hc;
  
  private int a(RecyclerView.o paramo, ae paramae, RecyclerView.s params)
  {
    this.ako.set(0, this.adr, true);
    int i;
    int n;
    label61:
    int j;
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    int i4;
    label163:
    int i1;
    if (this.akn.adJ) {
      if (paramae.kO == 1)
      {
        i = 2147483647;
        aw(paramae.kO, i);
        if (!this.aec) {
          break label452;
        }
        n = this.akk.hi();
        j = 0;
        if ((!paramae.b(params)) || ((!this.akn.adJ) && (this.ako.isEmpty()))) {
          break label1661;
        }
        localView = paramo.bV(paramae.adE);
        paramae.adE += paramae.adF;
        localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
        i4 = localLayoutParams.ahi.ic();
        localObject1 = this.akp;
        if ((((StaggeredGridLayoutManager.LazySpanLookup)localObject1).mData != null) && (i4 < ((StaggeredGridLayoutManager.LazySpanLookup)localObject1).mData.length)) {
          break label464;
        }
        j = -1;
        if (j != -1) {
          break label477;
        }
        i1 = 1;
        label172:
        if (i1 == 0) {
          break label687;
        }
        if (!localLayoutParams.akD) {
          break label483;
        }
        localObject1 = this.akj[0];
      }
    }
    label193:
    Object localObject2;
    label219:
    label242:
    int k;
    label294:
    label318:
    int m;
    label452:
    label464:
    label477:
    label483:
    label508:
    int i5;
    int i2;
    label540:
    do
    {
      localObject2 = this.akp;
      ((StaggeredGridLayoutManager.LazySpanLookup)localObject2).ck(i4);
      ((StaggeredGridLayoutManager.LazySpanLookup)localObject2).mData[i4] = ((StaggeredGridLayoutManager.b)localObject1).mIndex;
      localLayoutParams.akC = ((StaggeredGridLayoutManager.b)localObject1);
      if (paramae.kO != 1) {
        break label699;
      }
      super.c(localView, -1, false);
      if (!localLayoutParams.akD) {
        break label749;
      }
      if (this.adN != 1) {
        break label710;
      }
      h(localView, this.aku, c(this.mHeight, this.ahg, getPaddingTop() + getPaddingBottom(), localLayoutParams.height, true));
      if (paramae.kO != 1) {
        break label1065;
      }
      if (!localLayoutParams.akD) {
        break label863;
      }
      j = cf(n);
      k = j + this.akk.bb(localView);
      if ((i1 == 0) || (!localLayoutParams.akD)) {
        break label1752;
      }
      localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
      ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).akG = new int[this.adr];
      m = 0;
      while (m < this.adr)
      {
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).akG[m] = (j - this.akj[m].co(j));
        m += 1;
      }
      i = -2147483648;
      break;
      if (paramae.kO == 1)
      {
        i = paramae.adH + paramae.adD;
        break;
      }
      i = paramae.adG - paramae.adD;
      break;
      n = this.akk.hh();
      break label61;
      j = localObject1.mData[i4];
      break label163;
      i1 = 0;
      break label172;
      if (!cg(paramae.kO)) {
        break label594;
      }
      j = this.adr - 1;
      m = -1;
      k = -1;
      if (paramae.kO != 1) {
        break label609;
      }
      localObject2 = null;
      i3 = 2147483647;
      i5 = this.akk.hh();
      i2 = j;
      j = i3;
      localObject1 = localObject2;
    } while (i2 == m);
    Object localObject1 = this.akj[i2];
    int i3 = ((StaggeredGridLayoutManager.b)localObject1).co(i5);
    if (i3 < j) {
      j = i3;
    }
    for (;;)
    {
      i2 += k;
      localObject2 = localObject1;
      break label540;
      label594:
      j = 0;
      m = this.adr;
      k = 1;
      break label508;
      label609:
      localObject2 = null;
      i3 = -2147483648;
      i5 = this.akk.hi();
      i2 = j;
      j = i3;
      label633:
      localObject1 = localObject2;
      if (i2 == m) {
        break label193;
      }
      localObject1 = this.akj[i2];
      i3 = ((StaggeredGridLayoutManager.b)localObject1).cn(i5);
      if (i3 > j) {
        j = i3;
      }
      for (;;)
      {
        i2 += k;
        localObject2 = localObject1;
        break label633;
        label687:
        localObject1 = this.akj[j];
        break label219;
        label699:
        super.c(localView, 0, false);
        break label242;
        label710:
        h(localView, c(this.mWidth, this.ahf, getPaddingLeft() + getPaddingRight(), localLayoutParams.width, true), this.aku);
        break label294;
        label749:
        if (this.adN == 1)
        {
          h(localView, c(this.akm, this.ahf, 0, localLayoutParams.width, false), c(this.mHeight, this.ahg, getPaddingTop() + getPaddingBottom(), localLayoutParams.height, true));
          break label294;
        }
        h(localView, c(this.mWidth, this.ahf, getPaddingLeft() + getPaddingRight(), localLayoutParams.width, true), c(this.akm, this.ahg, 0, localLayoutParams.height, false));
        break label294;
        label863:
        j = ((StaggeredGridLayoutManager.b)localObject1).co(n);
        break label318;
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).akF = -1;
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).mPosition = i4;
        this.akp.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
        m = j;
        for (;;)
        {
          if ((localLayoutParams.akD) && (paramae.adF == -1)) {
            if (i1 == 0)
            {
              if (paramae.kO != 1) {
                break label1238;
              }
              i1 = this.akj[0].co(-2147483648);
              j = 1;
              label946:
              if (j >= this.adr) {
                break label1226;
              }
              if (this.akj[j].co(-2147483648) == i1) {
                break label1217;
              }
              j = 0;
              label975:
              if (j != 0) {
                break label1232;
              }
              j = 1;
            }
          }
          for (;;)
          {
            if (j != 0)
            {
              localObject2 = this.akp.cl(i4);
              if (localObject2 != null) {
                ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).akH = true;
              }
              this.akw = true;
            }
            if (paramae.kO != 1) {
              break label1469;
            }
            if (!localLayoutParams.akD) {
              break label1315;
            }
            j = this.adr - 1;
            while (j >= 0)
            {
              this.akj[j].bz(localView);
              j -= 1;
            }
            label1065:
            if (localLayoutParams.akD) {}
            for (j = ce(n);; j = ((StaggeredGridLayoutManager.b)localObject1).cn(n))
            {
              m = this.akk.bb(localView);
              if ((i1 == 0) || (!localLayoutParams.akD)) {
                break label1203;
              }
              localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
              ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).akG = new int[this.adr];
              k = 0;
              while (k < this.adr)
              {
                ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).akG[k] = (this.akj[k].cn(j) - j);
                k += 1;
              }
            }
            ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).akF = 1;
            ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).mPosition = i4;
            this.akp.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
            label1203:
            k = j;
            m = j - m;
            break;
            label1217:
            j += 1;
            break label946;
            label1226:
            j = 1;
            break label975;
            label1232:
            j = 0;
            continue;
            label1238:
            i1 = this.akj[0].cn(-2147483648);
            j = 1;
            label1254:
            if (j < this.adr) {
              if (this.akj[j].cn(-2147483648) == i1) {}
            }
            for (j = 0;; j = 1)
            {
              if (j != 0) {
                break label1309;
              }
              j = 1;
              break;
              j += 1;
              break label1254;
            }
            label1309:
            j = 0;
          }
          label1315:
          localLayoutParams.akC.bz(localView);
          label1325:
          if ((gE()) && (this.adN == 1)) {
            if (localLayoutParams.akD)
            {
              j = this.akl.hi();
              label1357:
              i2 = j - this.akl.bb(localView);
              i1 = j;
              j = i2;
              if (this.adN != 1) {
                break label1611;
              }
              h(localView, j, m, i1, k);
              label1400:
              if (!localLayoutParams.akD) {
                break label1627;
              }
              aw(this.akn.kO, i);
              a(paramo, this.akn);
              if ((this.akn.adI) && (localView.hasFocusable()))
              {
                if (!localLayoutParams.akD) {
                  break label1645;
                }
                this.ako.clear();
              }
            }
          }
          for (;;)
          {
            label1421:
            j = 1;
            break;
            label1469:
            if (localLayoutParams.akD)
            {
              j = this.adr - 1;
              while (j >= 0)
              {
                this.akj[j].by(localView);
                j -= 1;
              }
              break label1325;
            }
            localLayoutParams.akC.by(localView);
            break label1325;
            j = this.akl.hi() - (this.adr - 1 - ((StaggeredGridLayoutManager.b)localObject1).mIndex) * this.akm;
            break label1357;
            if (localLayoutParams.akD) {}
            for (j = this.akl.hh();; j = ((StaggeredGridLayoutManager.b)localObject1).mIndex * this.akm + this.akl.hh())
            {
              i1 = j + this.akl.bb(localView);
              break;
            }
            label1611:
            h(localView, m, j, k, i1);
            break label1400;
            label1627:
            a((StaggeredGridLayoutManager.b)localObject1, this.akn.kO, i);
            break label1421;
            label1645:
            this.ako.set(((StaggeredGridLayoutManager.b)localObject1).mIndex, false);
          }
          label1661:
          if (j == 0) {
            a(paramo, this.akn);
          }
          if (this.akn.kO == -1) {
            i = ce(this.akk.hh());
          }
          for (i = this.akk.hh() - i; i > 0; i = cf(this.akk.hi()) - this.akk.hi()) {
            return Math.min(paramae.adD, i);
          }
          return 0;
          label1752:
          m = j;
        }
        localObject1 = localObject2;
      }
      localObject1 = localObject2;
    }
  }
  
  private void a(int paramInt, RecyclerView.s params)
  {
    boolean bool2 = false;
    this.akn.adD = 0;
    this.akn.adE = paramInt;
    int i;
    boolean bool1;
    if (hR())
    {
      i = params.ahA;
      if (i != -1)
      {
        boolean bool3 = this.aec;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.akk.hj();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.akn.adG = (this.akk.hh() - i);
        this.akn.adH = (paramInt + this.akk.hi());
      }
      for (;;)
      {
        this.akn.adI = false;
        this.akn.adC = true;
        params = this.akn;
        bool1 = bool2;
        if (this.akk.getMode() == 0)
        {
          bool1 = bool2;
          if (this.akk.getEnd() == 0) {
            bool1 = true;
          }
        }
        params.adJ = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i = this.akk.hj();
        paramInt = 0;
        break label67;
        this.akn.adH = (paramInt + this.akk.getEnd());
        this.akn.adG = (-i);
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
        if ((this.akk.aY(localView) <= paramInt) && (this.akk.aZ(localView) <= paramInt))
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.akD) {
            break label118;
          }
          i = 0;
          if (i >= this.adr) {
            break label92;
          }
          if (this.akj[i].akN.size() != 1) {
            break label85;
          }
        }
      }
      label85:
      label92:
      label118:
      while (localLayoutParams.akC.akN.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.adr)
        {
          this.akj[i].iQ();
          i += 1;
        }
      }
      localLayoutParams.akC.iQ();
      a(localView, paramo);
    }
  }
  
  private void a(RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = cf(-2147483648);
    if (i == -2147483648) {}
    do
    {
      do
      {
        return;
        i = this.akk.hi() - i;
      } while (i <= 0);
      i -= -c(-i, paramo, params);
    } while ((!paramBoolean) || (i <= 0));
    this.akk.bI(i);
  }
  
  private void a(RecyclerView.o paramo, ae paramae)
  {
    int k = 1;
    int i = 1;
    if ((!paramae.adC) || (paramae.adJ)) {
      return;
    }
    if (paramae.adD == 0)
    {
      if (paramae.kO == -1)
      {
        b(paramo, paramae.adH);
        return;
      }
      a(paramo, paramae.adG);
      return;
    }
    int m;
    if (paramae.kO == -1)
    {
      n = paramae.adG;
      int i1 = paramae.adG;
      for (j = this.akj[0].cn(i1); i < this.adr; j = k)
      {
        m = this.akj[i].cn(i1);
        k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
      }
      i = n - j;
      if (i < 0) {}
      for (i = paramae.adH;; i = paramae.adH - Math.min(i, paramae.adD))
      {
        b(paramo, i);
        return;
      }
    }
    int n = paramae.adH;
    int j = this.akj[0].co(n);
    i = k;
    while (i < this.adr)
    {
      m = this.akj[i].co(n);
      k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    i = j - paramae.adH;
    if (i < 0) {}
    for (i = paramae.adG;; i = Math.min(i, paramae.adD) + j)
    {
      a(paramo, i);
      return;
      j = paramae.adG;
    }
  }
  
  private void a(StaggeredGridLayoutManager.b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.akQ;
    if (paramInt1 == -1) {
      if (i + paramb.iM() <= paramInt2) {
        this.ako.set(paramb.mIndex, false);
      }
    }
    while (paramb.iO() - i < paramInt2) {
      return;
    }
    this.ako.set(paramb.mIndex, false);
  }
  
  private View al(boolean paramBoolean)
  {
    int j = this.akk.hh();
    int k = this.akk.hi();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.akk.aX(localView);
      if ((this.akk.aY(localView) <= j) || (n >= k)) {
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
  
  private View am(boolean paramBoolean)
  {
    int j = this.akk.hh();
    int k = this.akk.hi();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.akk.aX(localView);
      int n = this.akk.aY(localView);
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
  
  private void aw(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.adr)
    {
      if (!this.akj[i].akN.isEmpty()) {
        a(this.akj[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private void b(int paramInt, RecyclerView.s params)
  {
    int j;
    int i;
    if (paramInt > 0)
    {
      j = iI();
      i = 1;
    }
    for (;;)
    {
      this.akn.adC = true;
      a(j, params);
      cd(i);
      this.akn.adE = (this.akn.adF + j);
      this.akn.adD = Math.abs(paramInt);
      return;
      i = -1;
      j = iJ();
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
        if ((this.akk.aX(localView) >= paramInt) && (this.akk.ba(localView) >= paramInt))
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.akD) {
            break label132;
          }
          j = 0;
          if (j >= this.adr) {
            break label101;
          }
          if (this.akj[j].akN.size() != 1) {
            break label92;
          }
        }
      }
      label92:
      label101:
      while (localLayoutParams.akC.akN.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.adr)
        {
          this.akj[j].iP();
          j += 1;
        }
      }
      label132:
      localLayoutParams.akC.iP();
      a(localView, paramo);
      i -= 1;
    }
  }
  
  private void b(RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = ce(2147483647);
    if (i == 2147483647) {}
    do
    {
      do
      {
        return;
        i -= this.akk.hh();
      } while (i <= 0);
      i -= c(i, paramo, params);
    } while ((!paramBoolean) || (i <= 0));
    this.akk.bI(-i);
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    b(paramInt, params);
    int j = a(paramo, this.akn, params);
    int i = paramInt;
    if (this.akn.adD >= j) {
      if (paramInt >= 0) {
        break label93;
      }
    }
    label93:
    for (i = -j;; i = j)
    {
      this.akk.bI(-i);
      this.akr = this.aec;
      this.akn.adD = 0;
      a(paramo, this.akn);
      return i;
    }
  }
  
  private void cc(int paramInt)
  {
    this.akm = (paramInt / this.adr);
    this.aku = View.MeasureSpec.makeMeasureSpec(paramInt, this.akl.getMode());
  }
  
  private void cd(int paramInt)
  {
    int i = 1;
    this.akn.kO = paramInt;
    ae localae = this.akn;
    boolean bool2 = this.aec;
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
      localae.adF = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private int ce(int paramInt)
  {
    int j = this.akj[0].cn(paramInt);
    int i = 1;
    while (i < this.adr)
    {
      int m = this.akj[i].cn(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int cf(int paramInt)
  {
    int j = this.akj[0].co(paramInt);
    int i = 1;
    while (i < this.adr)
    {
      int m = this.akj[i].co(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private boolean cg(int paramInt)
  {
    int i;
    if (this.adN == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.aec) {
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
        if (i != this.aec) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == gE()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private int ch(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.aec) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < iJ()) {}
      for (int i = 1; i != this.aec; i = 0) {
        return -1;
      }
    }
  }
  
  private boolean gE()
  {
    return q.Q(this.acI) == 1;
  }
  
  private void gQ()
  {
    boolean bool = true;
    if ((this.adN == 1) || (!gE())) {
      bool = this.aeb;
    }
    for (;;)
    {
      this.aec = bool;
      return;
      if (this.aeb) {
        bool = false;
      }
    }
  }
  
  private void h(View paramView, int paramInt1, int paramInt2)
  {
    g(paramView, this.hc);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    paramInt1 = n(paramInt1, localLayoutParams.leftMargin + this.hc.left, localLayoutParams.rightMargin + this.hc.right);
    paramInt2 = n(paramInt2, localLayoutParams.topMargin + this.hc.top, localLayoutParams.bottomMargin + this.hc.bottom);
    if (a(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private boolean iG()
  {
    if ((getChildCount() == 0) || (this.akq == 0) || (!this.hD)) {
      return false;
    }
    int j;
    if (this.aec) {
      j = iI();
    }
    for (int i = iJ(); (j == 0) && (iH() != null); i = iI())
    {
      this.akp.clear();
      this.agZ = true;
      requestLayout();
      return true;
      j = iJ();
    }
    if (!this.akw) {
      return false;
    }
    if (this.aec) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.akp.p(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.akw = false;
      this.akp.ci(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.akp.p(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.akp.ci(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      this.agZ = true;
      requestLayout();
      return true;
      this.akp.ci(localFullSpanItem2.mPosition + 1);
    }
  }
  
  private View iH()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.adr);
    localBitSet.set(0, this.adr, true);
    int j;
    int k;
    label57:
    int m;
    label65:
    int n;
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    Object localObject;
    if ((this.adN == 1) && (gE()))
    {
      j = 1;
      if (!this.aec) {
        break label184;
      }
      k = -1;
      if (i >= k) {
        break label199;
      }
      m = 1;
      n = i;
      if (n == k) {
        break label464;
      }
      localView = getChildAt(n);
      localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.akC.mIndex)) {
        break label277;
      }
      localObject = localLayoutParams.akC;
      if (!this.aec) {
        break label210;
      }
      if (((StaggeredGridLayoutManager.b)localObject).iO() >= this.akk.hi()) {
        break label259;
      }
      if (((StaggeredGridLayoutManager.LayoutParams)((View)((StaggeredGridLayoutManager.b)localObject).akN.get(((StaggeredGridLayoutManager.b)localObject).akN.size() - 1)).getLayoutParams()).akD) {
        break label205;
      }
      i = 1;
    }
    label259:
    for (;;)
    {
      if (i == 0) {
        break label264;
      }
      return localView;
      j = -1;
      break;
      label184:
      k = 0;
      m = i + 1;
      i = k;
      k = m;
      break label57;
      label199:
      m = -1;
      break label65;
      label205:
      i = 0;
      continue;
      label210:
      if (((StaggeredGridLayoutManager.b)localObject).iM() > this.akk.hh())
      {
        if (!((StaggeredGridLayoutManager.LayoutParams)((View)((StaggeredGridLayoutManager.b)localObject).akN.get(0)).getLayoutParams()).akD) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else {
        i = 0;
      }
    }
    label264:
    localBitSet.clear(localLayoutParams.akC.mIndex);
    label277:
    int i1;
    if ((!localLayoutParams.akD) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.aec)
      {
        i = this.akk.aY(localView);
        i1 = this.akk.aY((View)localObject);
        if (i < i1) {
          return localView;
        }
        if (i != i1) {
          break label466;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.akC.mIndex - ((StaggeredGridLayoutManager.LayoutParams)localObject).akC.mIndex < 0)
        {
          i = 1;
          label386:
          if (j >= 0) {
            break label448;
          }
        }
        label448:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label454;
          }
          return localView;
          i = this.akk.aX(localView);
          i1 = this.akk.aX((View)localObject);
          if (i > i1) {
            return localView;
          }
          if (i != i1) {
            break label466;
          }
          i = 1;
          break;
          i = 0;
          break label386;
        }
      }
      label454:
      n += m;
      break;
      label464:
      return null;
      label466:
      i = 0;
    }
  }
  
  private int iI()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return bl(getChildAt(i - 1));
  }
  
  private int iJ()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return bl(getChildAt(0));
  }
  
  private int j(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    aj localaj = this.akk;
    View localView;
    if (!this.aee)
    {
      bool1 = true;
      localView = al(bool1);
      if (this.aee) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(params, localaj, localView, am(bool1), this, this.aee, this.aec);
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
    aj localaj = this.akk;
    View localView;
    if (!this.aee)
    {
      bool1 = true;
      localView = al(bool1);
      if (this.aee) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(params, localaj, localView, am(bool1), this, this.aee);
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
    aj localaj = this.akk;
    View localView;
    if (!this.aee)
    {
      bool1 = true;
      localView = al(bool1);
      if (this.aee) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.b(params, localaj, localView, am(bool1), this, this.aee);
      bool1 = false;
      break;
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
    if (this.aec)
    {
      k = iI();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.akp.cj(i);
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
      k = iJ();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.akp.ay(paramInt1, paramInt2);
      break label76;
      this.akp.ax(paramInt1, paramInt2);
      break label76;
      this.akp.ax(paramInt1, 1);
      this.akp.ay(paramInt2, 1);
      break label76;
      if (this.aec) {}
      for (paramInt1 = iJ(); i <= paramInt1; paramInt1 = iI())
      {
        requestLayout();
        return;
      }
    }
  }
  
  public final void N(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2, 1);
  }
  
  public final void O(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2, 2);
  }
  
  public final void P(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2, 4);
  }
  
  public final void Q(int paramInt1, int paramInt2)
  {
    o(paramInt1, paramInt2, 8);
  }
  
  public final void Q(String paramString)
  {
    if (this.akt == null) {
      super.Q(paramString);
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return c(paramInt, paramo, params);
  }
  
  public final int a(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.adN == 0) {
      return this.adr;
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
    label499:
    label507:
    do
    {
      return paramView;
      localView = bd(paramView);
      if (localView == null) {
        return null;
      }
      gQ();
      switch (paramInt)
      {
      default: 
        paramInt = -2147483648;
      }
      while (paramInt == -2147483648)
      {
        return null;
        if (this.adN == 1)
        {
          paramInt = -1;
        }
        else if (gE())
        {
          paramInt = 1;
        }
        else
        {
          paramInt = -1;
          continue;
          if (this.adN == 1)
          {
            paramInt = 1;
          }
          else if (gE())
          {
            paramInt = -1;
          }
          else
          {
            paramInt = 1;
            continue;
            if (this.adN == 1)
            {
              paramInt = -1;
            }
            else
            {
              paramInt = -2147483648;
              continue;
              if (this.adN == 1)
              {
                paramInt = 1;
              }
              else
              {
                paramInt = -2147483648;
                continue;
                if (this.adN == 0)
                {
                  paramInt = -1;
                }
                else
                {
                  paramInt = -2147483648;
                  continue;
                  if (this.adN == 0) {
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
      boolean bool = paramView.akD;
      localb = paramView.akC;
      if (paramInt == 1) {}
      for (i = iI();; i = iJ())
      {
        a(i, params);
        cd(paramInt);
        this.akn.adE = (this.akn.adF + i);
        this.akn.adD = ((int)(0.3333333F * this.akk.hj()));
        this.akn.adI = true;
        this.akn.adC = false;
        a(paramo, this.akn, params);
        this.akr = this.aec;
        if (bool) {
          break;
        }
        paramView = localb.aA(i, paramInt);
        if ((paramView == null) || (paramView == localView)) {
          break;
        }
        return paramView;
      }
      if (cg(paramInt))
      {
        j = this.adr - 1;
        while (j >= 0)
        {
          paramView = this.akj[j].aA(i, paramInt);
          if ((paramView != null) && (paramView != localView)) {
            return paramView;
          }
          j -= 1;
        }
      }
      j = 0;
      while (j < this.adr)
      {
        paramView = this.akj[j].aA(i, paramInt);
        if ((paramView != null) && (paramView != localView)) {
          return paramView;
        }
        j += 1;
      }
      if (this.aeb) {
        break label623;
      }
      i = 1;
      if (paramInt != -1) {
        break label629;
      }
      j = 1;
      if (i != j) {
        break label635;
      }
      i = 1;
      if (bool) {
        break;
      }
      if (i == 0) {
        break label641;
      }
      j = localb.iR();
      paramo = bC(j);
      if (paramo == null) {
        break;
      }
      paramView = paramo;
    } while (paramo != localView);
    label517:
    label534:
    if (cg(paramInt))
    {
      paramInt = this.adr - 1;
      label568:
      if (paramInt >= 0)
      {
        if (paramInt != localb.mIndex) {
          if (i == 0) {
            break label651;
          }
        }
        for (j = this.akj[paramInt].iR();; j = this.akj[paramInt].iS())
        {
          paramo = bC(j);
          if (paramo != null)
          {
            paramView = paramo;
            if (paramo != localView) {
              break;
            }
          }
          paramInt -= 1;
          break label568;
          label623:
          i = 0;
          break label499;
          label629:
          j = 0;
          break label507;
          label635:
          i = 0;
          break label517;
          j = localb.iS();
          break label534;
        }
      }
    }
    else
    {
      paramInt = 0;
      while (paramInt < this.adr)
      {
        if (i != 0) {}
        for (j = this.akj[paramInt].iR();; j = this.akj[paramInt].iS())
        {
          paramView = bC(j);
          if ((paramView == null) || (paramView == localView)) {
            break;
          }
          return paramView;
        }
        paramInt += 1;
      }
    }
    label641:
    label651:
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.i.a parama)
  {
    int k = 0;
    if (this.adN == 0) {
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
      if ((this.akx == null) || (this.akx.length < this.adr)) {
        this.akx = new int[this.adr];
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramInt2 < this.adr)
      {
        if (this.akn.adF == -1) {}
        for (int j = this.akn.adG - this.akj[paramInt2].cn(this.akn.adG);; j = this.akj[paramInt2].co(this.akn.adH) - this.akn.adH)
        {
          int i = paramInt1;
          if (j >= 0)
          {
            this.akx[paramInt1] = j;
            i = paramInt1 + 1;
          }
          paramInt2 += 1;
          paramInt1 = i;
          break;
        }
      }
      Arrays.sort(this.akx, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.akn.b(params)))
      {
        parama.M(this.akn.adE, this.akx[paramInt2]);
        ae localae = this.akn;
        localae.adE += this.akn.adF;
        paramInt2 += 1;
      }
    }
  }
  
  public final void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.adN == 1)
    {
      i = k(paramInt2, k + paramRect.height(), q.X(this.acI));
      paramInt2 = k(paramInt1, j + this.akm * this.adr, q.W(this.acI));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = k(paramInt1, j + paramRect.width(), q.W(this.acI));
      paramInt1 = k(paramInt2, k + this.akm * this.adr, q.X(this.acI));
      paramInt2 = i;
    }
  }
  
  public final void a(RecyclerView.o paramo, RecyclerView.s params, View paramView, a parama)
  {
    int i = 1;
    paramo = paramView.getLayoutParams();
    if (!(paramo instanceof StaggeredGridLayoutManager.LayoutParams))
    {
      super.b(paramView, parama);
      return;
    }
    paramo = (StaggeredGridLayoutManager.LayoutParams)paramo;
    int k;
    int m;
    int j;
    if (this.adN == 0)
    {
      k = paramo.iK();
      if (paramo.akD) {
        i = this.adr;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      parama.H(a.c.b(k, j, m, i, paramo.akD));
      return;
      m = paramo.iK();
      if (paramo.akD)
      {
        i = this.adr;
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
    this.aef = -1;
    this.aeg = -2147483648;
    this.akt = null;
    this.akv.reset();
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new af(paramRecyclerView.getContext());
    paramRecyclerView.ahA = paramInt;
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    removeCallbacks(this.aky);
    int i = 0;
    while (i < this.adr)
    {
      this.akj[i].clear();
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
    if (this.adN == 1) {
      return this.adr;
    }
    return super.b(paramo, params);
  }
  
  public final PointF bD(int paramInt)
  {
    paramInt = ch(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (this.adN == 0)
    {
      localPointF.x = paramInt;
      localPointF.y = 0.0F;
      return localPointF;
    }
    localPointF.x = 0.0F;
    localPointF.y = paramInt;
    return localPointF;
  }
  
  public final void bE(int paramInt)
  {
    if ((this.akt != null) && (this.akt.aew != paramInt))
    {
      StaggeredGridLayoutManager.SavedState localSavedState = this.akt;
      localSavedState.akK = null;
      localSavedState.akJ = 0;
      localSavedState.aew = -1;
      localSavedState.akI = -1;
    }
    this.aef = paramInt;
    this.aeg = -2147483648;
    requestLayout();
  }
  
  public final void bP(int paramInt)
  {
    super.bP(paramInt);
    int i = 0;
    while (i < this.adr)
    {
      this.akj[i].cq(paramInt);
      i += 1;
    }
  }
  
  public final void bQ(int paramInt)
  {
    super.bQ(paramInt);
    int i = 0;
    while (i < this.adr)
    {
      this.akj[i].cq(paramInt);
      i += 1;
    }
  }
  
  public final void bR(int paramInt)
  {
    if (paramInt == 0) {
      iG();
    }
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    int j = 1;
    StaggeredGridLayoutManager.a locala = this.akv;
    if (((this.akt != null) || (this.aef != -1)) && (params.getItemCount() == 0))
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
    if ((!locala.aeo) || (this.aef != -1) || (this.akt != null))
    {
      k = 1;
      if (k == 0) {
        break label504;
      }
      locala.reset();
      if (this.akt == null) {
        break label655;
      }
      if (this.akt.akJ <= 0) {
        break label268;
      }
      if (this.akt.akJ != this.adr) {
        break label218;
      }
      m = 0;
      if (m >= this.adr) {
        break label268;
      }
      this.akj[m].clear();
      n = this.akt.akK[m];
      i = n;
      if (n != -2147483648) {
        if (!this.akt.aey) {
          break label203;
        }
      }
    }
    label203:
    for (int i = n + this.akk.hi();; i = n + this.akk.hh())
    {
      this.akj[m].cp(i);
      m += 1;
      break label112;
      k = 0;
      break;
    }
    label218:
    Object localObject1 = this.akt;
    ((StaggeredGridLayoutManager.SavedState)localObject1).akK = null;
    ((StaggeredGridLayoutManager.SavedState)localObject1).akJ = 0;
    ((StaggeredGridLayoutManager.SavedState)localObject1).akL = 0;
    ((StaggeredGridLayoutManager.SavedState)localObject1).akM = null;
    ((StaggeredGridLayoutManager.SavedState)localObject1).akE = null;
    this.akt.aew = this.akt.akI;
    label268:
    this.aks = this.akt.aks;
    boolean bool = this.akt.aeb;
    Q(null);
    if ((this.akt != null) && (this.akt.aeb != bool)) {
      this.akt.aeb = bool;
    }
    this.aeb = bool;
    requestLayout();
    gQ();
    if (this.akt.aew != -1)
    {
      this.aef = this.akt.aew;
      locala.aen = this.akt.aey;
      if (this.akt.akL > 1)
      {
        this.akp.mData = this.akt.akM;
        this.akp.akE = this.akt.akE;
      }
      label408:
      if ((!params.ahQ) && (this.aef != -1)) {
        break label671;
      }
      i = 0;
      label426:
      if (i == 0)
      {
        if (!this.akr) {
          break label1190;
        }
        n = params.getItemCount();
        i = getChildCount() - 1;
        label452:
        if (i < 0) {
          break label1184;
        }
        m = bl(getChildAt(i));
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
      locala.El = -2147483648;
      locala.aeo = true;
      if ((this.akt == null) && (this.aef == -1) && ((locala.aen != this.akr) || (gE() != this.aks)))
      {
        this.akp.clear();
        locala.akz = true;
      }
      if ((getChildCount() <= 0) || ((this.akt != null) && (this.akt.akJ > 0))) {
        break label1566;
      }
      if (!locala.akz) {
        break label1254;
      }
      i = 0;
      while (i < this.adr)
      {
        this.akj[i].clear();
        if (locala.El != -2147483648) {
          this.akj[i].cp(locala.El);
        }
        i += 1;
      }
      locala.aen = this.aec;
      break;
      label655:
      gQ();
      locala.aen = this.aec;
      break label408;
      label671:
      if ((this.aef < 0) || (this.aef >= params.getItemCount()))
      {
        this.aef = -1;
        this.aeg = -2147483648;
        i = 0;
        break label426;
      }
      if ((this.akt == null) || (this.akt.aew == -1) || (this.akt.akJ <= 0))
      {
        localObject1 = bC(this.aef);
        if (localObject1 != null)
        {
          if (this.aec)
          {
            i = iI();
            locala.mPosition = i;
            if (this.aeg == -2147483648) {
              break label858;
            }
            if (!locala.aen) {
              break label828;
            }
          }
          label828:
          for (locala.El = (this.akk.hi() - this.aeg - this.akk.aY((View)localObject1));; locala.El = (this.akk.hh() + this.aeg - this.akk.aX((View)localObject1)))
          {
            i = 1;
            break;
            i = iJ();
            break label762;
          }
          label858:
          if (this.akk.bb((View)localObject1) > this.akk.hj()) {
            if (locala.aen)
            {
              i = this.akk.hi();
              locala.El = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.akk.hh();
        break label894;
        i = this.akk.aX((View)localObject1) - this.akk.hh();
        if (i < 0)
        {
          locala.El = (-i);
        }
        else
        {
          i = this.akk.hi() - this.akk.aY((View)localObject1);
          if (i < 0)
          {
            locala.El = i;
          }
          else
          {
            locala.El = -2147483648;
            continue;
            locala.mPosition = this.aef;
            if (this.aeg == -2147483648) {
              if (ch(locala.mPosition) == 1)
              {
                bool = true;
                label1032:
                locala.aen = bool;
                if (!locala.aen) {
                  break label1082;
                }
                i = locala.akB.akk.hi();
                label1060:
                locala.El = i;
              }
            }
            for (;;)
            {
              locala.akz = true;
              break;
              bool = false;
              break label1032;
              label1082:
              i = locala.akB.akk.hh();
              break label1060;
              i = this.aeg;
              if (locala.aen) {
                locala.El = (locala.akB.akk.hi() - i);
              } else {
                locala.El = (i + locala.akB.akk.hh());
              }
            }
            locala.El = -2147483648;
            locala.mPosition = this.aef;
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
        n = bl(getChildAt(m));
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
    if ((k != 0) || (this.akv.akA == null))
    {
      k = 0;
      if (k < this.adr)
      {
        localObject1 = this.akj[k];
        bool = this.aec;
        n = locala.El;
        if (bool)
        {
          i = ((StaggeredGridLayoutManager.b)localObject1).co(-2147483648);
          label1317:
          ((StaggeredGridLayoutManager.b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((StaggeredGridLayoutManager.b)localObject1).akB.akk.hi())) && ((bool) || (i <= ((StaggeredGridLayoutManager.b)localObject1).akB.akk.hh()))) {
            break label1392;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = ((StaggeredGridLayoutManager.b)localObject1).cn(-2147483648);
          break label1317;
          m = i;
          if (n != -2147483648) {
            m = i + n;
          }
          ((StaggeredGridLayoutManager.b)localObject1).akP = m;
          ((StaggeredGridLayoutManager.b)localObject1).akO = m;
        }
      }
      localObject1 = this.akv;
      localObject2 = this.akj;
      k = localObject2.length;
      if ((((StaggeredGridLayoutManager.a)localObject1).akA == null) || (((StaggeredGridLayoutManager.a)localObject1).akA.length < k)) {
        ((StaggeredGridLayoutManager.a)localObject1).akA = new int[((StaggeredGridLayoutManager.a)localObject1).akB.akj.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((StaggeredGridLayoutManager.a)localObject1).akA[i] = localObject2[i].cn(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.adr)
      {
        localObject1 = this.akj[i];
        ((StaggeredGridLayoutManager.b)localObject1).clear();
        ((StaggeredGridLayoutManager.b)localObject1).cp(this.akv.akA[i]);
        i += 1;
      }
    }
    label1566:
    b(paramo);
    this.akn.adC = false;
    this.akw = false;
    cc(this.akl.hj());
    a(locala.mPosition, params);
    label1665:
    float f1;
    if (locala.aen)
    {
      cd(-1);
      a(paramo, this.akn, params);
      cd(1);
      this.akn.adE = (locala.mPosition + this.akn.adF);
      a(paramo, this.akn, params);
      if (this.akl.getMode() == 1073741824) {
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
      float f2 = this.akl.bb((View)localObject1);
      if (f2 < f1) {
        break label2240;
      }
      if (!((StaggeredGridLayoutManager.LayoutParams)((View)localObject1).getLayoutParams()).akD) {
        break label2237;
      }
      f2 = 1.0F * f2 / this.adr;
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
      cd(1);
      a(paramo, this.akn, params);
      cd(-1);
      this.akn.adE = (locala.mPosition + this.akn.adF);
      a(paramo, this.akn, params);
      break label1665;
      n = this.akm;
      k = Math.round(this.adr * f1);
      i = k;
      if (this.akl.getMode() == -2147483648) {
        i = Math.min(k, this.akl.hj());
      }
      cc(i);
      if (this.akm != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (StaggeredGridLayoutManager.LayoutParams)((View)localObject1).getLayoutParams();
          if (!((StaggeredGridLayoutManager.LayoutParams)localObject2).akD)
          {
            if ((!gE()) || (this.adN != 1)) {
              break label1989;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.adr - 1 - ((StaggeredGridLayoutManager.LayoutParams)localObject2).akC.mIndex) * this.akm - -(this.adr - 1 - ((StaggeredGridLayoutManager.LayoutParams)localObject2).akC.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            label1989:
            k = ((StaggeredGridLayoutManager.LayoutParams)localObject2).akC.mIndex * this.akm;
            i1 = ((StaggeredGridLayoutManager.LayoutParams)localObject2).akC.mIndex * n;
            if (this.adN == 1) {
              ((View)localObject1).offsetLeftAndRight(k - i1);
            } else {
              ((View)localObject1).offsetTopAndBottom(k - i1);
            }
          }
        }
      }
      if (getChildCount() > 0)
      {
        if (this.aec)
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
          if (!params.ahQ) {
            if ((this.akq == 0) || (getChildCount() <= 0) || ((!this.akw) && (iH() == null))) {
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
          removeCallbacks(this.aky);
          i = k;
          if (iG()) {
            i = 1;
          }
        }
        if (params.ahQ) {
          this.akv.reset();
        }
        this.akr = locala.aen;
        this.aks = gE();
        if (i == 0) {
          break label41;
        }
        this.akv.reset();
        j = 0;
        break;
        b(paramo, params, true);
        a(paramo, params, false);
        break label2079;
      }
      break label1749;
    }
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
  
  public final void gI()
  {
    this.akp.clear();
    requestLayout();
  }
  
  public final RecyclerView.LayoutParams gJ()
  {
    if (this.adN == 0) {
      return new StaggeredGridLayoutManager.LayoutParams(-2, -1);
    }
    return new StaggeredGridLayoutManager.LayoutParams(-1, -2);
  }
  
  public final boolean gM()
  {
    return this.akt == null;
  }
  
  public final boolean gN()
  {
    return this.akq != 0;
  }
  
  public final boolean gO()
  {
    return this.adN == 0;
  }
  
  public final boolean gP()
  {
    return this.adN == 1;
  }
  
  public final int h(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final int i(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      localView1 = al(false);
      localView2 = am(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = bl(localView1);
    int j = bl(localView2);
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
      this.akt = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.akt != null) {
      return new StaggeredGridLayoutManager.SavedState(this.akt);
    }
    StaggeredGridLayoutManager.SavedState localSavedState = new StaggeredGridLayoutManager.SavedState();
    localSavedState.aeb = this.aeb;
    localSavedState.aey = this.akr;
    localSavedState.aks = this.aks;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((this.akp != null) && (this.akp.mData != null))
    {
      localSavedState.akM = this.akp.mData;
      localSavedState.akL = localSavedState.akM.length;
      localSavedState.akE = this.akp.akE;
      if (getChildCount() <= 0) {
        break label310;
      }
      if (!this.akr) {
        break label250;
      }
      i = iI();
      localSavedState.aew = i;
      if (!this.aec) {
        break label258;
      }
      localView = am(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      localSavedState.akI = i;
      localSavedState.akJ = this.adr;
      localSavedState.akK = new int[this.adr];
      j = 0;
      if (j >= this.adr) {
        break label328;
      }
      if (!this.akr) {
        break label277;
      }
      k = this.akj[j].co(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.akk.hi();
      }
    }
    for (;;)
    {
      localSavedState.akK[j] = i;
      j += 1;
      break label181;
      localSavedState.akL = 0;
      break;
      label250:
      i = iJ();
      break label126;
      label258:
      localView = al(true);
      break label146;
      label268:
      i = bl(localView);
      break label153;
      label277:
      k = this.akj[j].cn(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.akk.hh();
      }
    }
    label310:
    localSavedState.aew = -1;
    localSavedState.akI = -1;
    localSavedState.akJ = 0;
    label328:
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */