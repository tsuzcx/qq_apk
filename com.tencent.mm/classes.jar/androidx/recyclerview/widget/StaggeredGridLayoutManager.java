package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;
import androidx.core.g.a.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b
{
  public int bWl;
  boolean bXA;
  boolean bXB;
  private boolean bXD;
  int bXE;
  int bXF;
  private final Rect byy;
  b[] cbh;
  s cbi;
  s cbj;
  private int cbk;
  private final n cbl;
  private BitSet cbm;
  LazySpanLookup cbn;
  private int cbo;
  private boolean cbp;
  private boolean cbq;
  private SavedState cbr;
  private int cbs;
  private final a cbt;
  private boolean cbu;
  private int[] cbv;
  private final Runnable cbw;
  public int mOrientation;
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194704);
    this.bWl = -1;
    this.bXA = false;
    this.bXB = false;
    this.bXE = -1;
    this.bXF = -2147483648;
    this.cbn = new LazySpanLookup();
    this.cbo = 2;
    this.byy = new Rect();
    this.cbt = new a();
    this.cbu = false;
    this.bXD = true;
    this.cbw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195243);
        StaggeredGridLayoutManager.this.KZ();
        AppMethodBeat.o(195243);
      }
    };
    this.mOrientation = paramInt2;
    fI(paramInt1);
    this.cbl = new n();
    KY();
    AppMethodBeat.o(194704);
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194684);
    this.bWl = -1;
    this.bXA = false;
    this.bXB = false;
    this.bXE = -1;
    this.bXF = -2147483648;
    this.cbn = new LazySpanLookup();
    this.cbo = 2;
    this.byy = new Rect();
    this.cbt = new a();
    this.cbu = false;
    this.bXD = true;
    this.cbw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195243);
        StaggeredGridLayoutManager.this.KZ();
        AppMethodBeat.o(195243);
      }
    };
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = paramContext.orientation;
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      paramContext = new IllegalArgumentException("invalid orientation.");
      AppMethodBeat.o(194684);
      throw paramContext;
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt1 != this.mOrientation)
    {
      this.mOrientation = paramInt1;
      paramAttributeSet = this.cbi;
      this.cbi = this.cbj;
      this.cbj = paramAttributeSet;
      requestLayout();
    }
    fI(paramContext.spanCount);
    aZ(paramContext.agn);
    this.cbl = new n();
    KY();
    AppMethodBeat.o(194684);
  }
  
  private boolean Ja()
  {
    AppMethodBeat.i(194809);
    if (getLayoutDirection() == 1)
    {
      AppMethodBeat.o(194809);
      return true;
    }
    AppMethodBeat.o(194809);
    return false;
  }
  
  private void Jn()
  {
    boolean bool = true;
    AppMethodBeat.i(194796);
    if ((this.mOrientation == 1) || (!Ja())) {
      bool = this.bXA;
    }
    for (;;)
    {
      this.bXB = bool;
      AppMethodBeat.o(194796);
      return;
      if (this.bXA) {
        bool = false;
      }
    }
  }
  
  private void KY()
  {
    AppMethodBeat.i(194716);
    this.cbi = s.a(this, this.mOrientation);
    this.cbj = s.a(this, 1 - this.mOrientation);
    AppMethodBeat.o(194716);
  }
  
  private View La()
  {
    AppMethodBeat.i(194743);
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.bWl);
    localBitSet.set(0, this.bWl, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (Ja()))
    {
      j = 1;
      if (!this.bXB) {
        break label138;
      }
      k = -1;
      label62:
      if (i >= k) {
        break label153;
      }
    }
    int n;
    View localView;
    LayoutParams localLayoutParams;
    label138:
    label153:
    for (int m = 1;; m = -1)
    {
      n = i;
      if (n == k) {
        break label374;
      }
      localView = getChildAt(n);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.cbA.mIndex)) {
        break label172;
      }
      if (!a(localLayoutParams.cbA)) {
        break label159;
      }
      AppMethodBeat.o(194743);
      return localView;
      j = -1;
      break;
      k = 0;
      m = i + 1;
      i = k;
      k = m;
      break label62;
    }
    label159:
    localBitSet.clear(localLayoutParams.cbA.mIndex);
    label172:
    Object localObject;
    int i1;
    if ((!localLayoutParams.cbB) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.bXB)
      {
        i = this.cbi.bt(localView);
        i1 = this.cbi.bt((View)localObject);
        if (i < i1)
        {
          AppMethodBeat.o(194743);
          return localView;
        }
        if (i != i1) {
          break label381;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.cbA.mIndex - ((LayoutParams)localObject).cbA.mIndex < 0)
        {
          i = 1;
          label286:
          if (j >= 0) {
            break label358;
          }
        }
        label358:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label364;
          }
          AppMethodBeat.o(194743);
          return localView;
          i = this.cbi.bs(localView);
          i1 = this.cbi.bs((View)localObject);
          if (i > i1)
          {
            AppMethodBeat.o(194743);
            return localView;
          }
          if (i != i1) {
            break label381;
          }
          i = 1;
          break;
          i = 0;
          break label286;
        }
      }
      label364:
      n += m;
      break;
      label374:
      AppMethodBeat.o(194743);
      return null;
      label381:
      i = 0;
    }
  }
  
  private boolean Ld()
  {
    AppMethodBeat.i(195144);
    int j = this.cbh[0].gC(-2147483648);
    int i = 1;
    while (i < this.bWl)
    {
      if (this.cbh[i].gC(-2147483648) != j)
      {
        AppMethodBeat.o(195144);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(195144);
    return true;
  }
  
  private boolean Le()
  {
    AppMethodBeat.i(195159);
    int j = this.cbh[0].gB(-2147483648);
    int i = 1;
    while (i < this.bWl)
    {
      if (this.cbh[i].gB(-2147483648) != j)
      {
        AppMethodBeat.o(195159);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(195159);
    return true;
  }
  
  private int Lf()
  {
    AppMethodBeat.i(195260);
    int i = getChildCount();
    if (i == 0)
    {
      AppMethodBeat.o(195260);
      return 0;
    }
    i = getPosition(getChildAt(i - 1));
    AppMethodBeat.o(195260);
    return i;
  }
  
  private int Lg()
  {
    AppMethodBeat.i(195271);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(195271);
      return 0;
    }
    int i = getPosition(getChildAt(0));
    AppMethodBeat.o(195271);
    return i;
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195252);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(195252);
      return 0;
    }
    b(paramInt, params);
    int j = a(paramn, this.cbl, params);
    int i = paramInt;
    if (this.cbl.bXq >= j) {
      if (paramInt >= 0) {
        break label111;
      }
    }
    label111:
    for (i = -j;; i = j)
    {
      this.cbi.fQ(-i);
      this.cbp = this.bXB;
      this.cbl.bXq = 0;
      a(paramn, this.cbl);
      AppMethodBeat.o(195252);
      return i;
    }
  }
  
  private int a(RecyclerView.n paramn, n paramn1, RecyclerView.s params)
  {
    AppMethodBeat.i(195031);
    this.cbm.set(0, this.bWl, true);
    int i;
    int m;
    label68:
    int j;
    label71:
    View localView;
    LayoutParams localLayoutParams;
    int i2;
    int i1;
    label146:
    b localb;
    label167:
    label178:
    label199:
    label231:
    int n;
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int k;
    if (this.cbl.bXw) {
      if (paramn1.mLayoutDirection == 1)
      {
        i = 2147483647;
        bJ(paramn1.mLayoutDirection, i);
        if (!this.bXB) {
          break label560;
        }
        m = this.cbi.JF();
        j = 0;
        if ((!paramn1.a(params)) || ((!this.cbl.bXw) && (this.cbm.isEmpty()))) {
          break label877;
        }
        localView = paramn1.a(paramn);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.bXh.KI();
        j = this.cbn.gv(i2);
        if (j != -1) {
          break label572;
        }
        i1 = 1;
        if (i1 == 0) {
          break label588;
        }
        if (!localLayoutParams.cbB) {
          break label578;
        }
        localb = this.cbh[0];
        this.cbn.a(i2, localb);
        localLayoutParams.cbA = localb;
        if (paramn1.mLayoutDirection != 1) {
          break label600;
        }
        addView(localView);
        a(localView, localLayoutParams);
        if (paramn1.mLayoutDirection != 1) {
          break label622;
        }
        if (!localLayoutParams.cbB) {
          break label610;
        }
        j = gp(m);
        n = j + this.cbi.bw(localView);
        if ((i1 == 0) || (!localLayoutParams.cbB)) {
          break label984;
        }
        localFullSpanItem = gk(j);
        localFullSpanItem.cbE = -1;
        localFullSpanItem.mPosition = i2;
        this.cbn.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.cbB) && (paramn1.bXs == -1))
      {
        if (i1 == 0)
        {
          if (paramn1.mLayoutDirection != 1) {
            break label720;
          }
          if (Ld()) {
            break label714;
          }
          j = 1;
          label331:
          if (j == 0) {
            break label363;
          }
          localFullSpanItem = this.cbn.gz(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.cbG = true;
          }
        }
        this.cbu = true;
      }
      label363:
      a(localView, localLayoutParams, paramn1);
      if ((Ja()) && (this.mOrientation == 1)) {
        if (localLayoutParams.cbB)
        {
          j = this.cbj.JF();
          label404:
          i2 = j - this.cbj.bw(localView);
          i1 = j;
          j = i2;
          if (this.mOrientation != 1) {
            break label826;
          }
          layoutDecoratedWithMargins(localView, j, k, i1, n);
          label448:
          if (!localLayoutParams.cbB) {
            break label843;
          }
          bJ(this.cbl.mLayoutDirection, i);
          label469:
          a(paramn, this.cbl);
          if ((this.cbl.bXv) && (localView.hasFocusable()))
          {
            if (!localLayoutParams.cbB) {
              break label861;
            }
            this.cbm.clear();
          }
        }
      }
      for (;;)
      {
        j = 1;
        break label71;
        i = -2147483648;
        break;
        if (paramn1.mLayoutDirection == 1)
        {
          i = paramn1.bXu + paramn1.bXq;
          break;
        }
        i = paramn1.bXt - paramn1.bXq;
        break;
        label560:
        m = this.cbi.JE();
        break label68;
        label572:
        i1 = 0;
        break label146;
        label578:
        localb = a(paramn1);
        break label167;
        label588:
        localb = this.cbh[j];
        break label178;
        label600:
        addView(localView, 0);
        break label199;
        label610:
        j = localb.gC(m);
        break label231;
        label622:
        if (localLayoutParams.cbB) {}
        for (j = gn(m);; j = localb.gB(m))
        {
          k = j - this.cbi.bw(localView);
          if ((i1 != 0) && (localLayoutParams.cbB))
          {
            localFullSpanItem = gl(j);
            localFullSpanItem.cbE = 1;
            localFullSpanItem.mPosition = i2;
            this.cbn.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        label714:
        j = 0;
        break label331;
        label720:
        if (!Le())
        {
          j = 1;
          break label331;
        }
        j = 0;
        break label331;
        j = this.cbj.JF() - (this.bWl - 1 - localb.mIndex) * this.cbk;
        break label404;
        if (localLayoutParams.cbB) {}
        for (j = this.cbj.JE();; j = localb.mIndex * this.cbk + this.cbj.JE())
        {
          i1 = j + this.cbj.bw(localView);
          break;
        }
        label826:
        layoutDecoratedWithMargins(localView, k, j, n, i1);
        break label448;
        label843:
        a(localb, this.cbl.mLayoutDirection, i);
        break label469;
        label861:
        this.cbm.set(localb.mIndex, false);
      }
      label877:
      if (j == 0) {
        a(paramn, this.cbl);
      }
      if (this.cbl.mLayoutDirection == -1) {
        i = gn(this.cbi.JE());
      }
      for (i = this.cbi.JE() - i; i > 0; i = gp(this.cbi.JF()) - this.cbi.JF())
      {
        i = Math.min(paramn1.bXq, i);
        AppMethodBeat.o(195031);
        return i;
      }
      AppMethodBeat.o(195031);
      return 0;
      label984:
      k = j;
    }
  }
  
  private b a(n paramn)
  {
    Object localObject = null;
    b localb = null;
    AppMethodBeat.i(195227);
    int i;
    int j;
    int k;
    int n;
    int i1;
    int m;
    if (gr(paramn.mLayoutDirection))
    {
      i = this.bWl - 1;
      j = -1;
      k = -1;
      if (paramn.mLayoutDirection != 1) {
        break label133;
      }
      n = 2147483647;
      i1 = this.cbi.JE();
      m = i;
      paramn = localb;
      i = n;
      label66:
      if (m == k) {
        break label125;
      }
      localb = this.cbh[m];
      n = localb.gC(i1);
      if (n >= i) {
        break label212;
      }
      paramn = localb;
      i = n;
    }
    label133:
    label209:
    label212:
    for (;;)
    {
      m += j;
      break label66;
      i = 0;
      k = this.bWl;
      j = 1;
      break;
      label125:
      AppMethodBeat.o(195227);
      return paramn;
      n = -2147483648;
      i1 = this.cbi.JF();
      m = i;
      paramn = localObject;
      i = n;
      if (m != k)
      {
        localb = this.cbh[m];
        n = localb.gB(i1);
        if (n <= i) {
          break label209;
        }
        paramn = localb;
        i = n;
      }
      for (;;)
      {
        m += j;
        break;
        AppMethodBeat.o(195227);
        return paramn;
      }
    }
  }
  
  private void a(int paramInt, RecyclerView.s params)
  {
    boolean bool2 = false;
    AppMethodBeat.i(194979);
    this.cbl.bXq = 0;
    this.cbl.bXr = paramInt;
    int i;
    boolean bool1;
    if (isSmoothScrolling())
    {
      i = params.cag;
      if (i != -1)
      {
        boolean bool3 = this.bXB;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label183;
          }
          paramInt = this.cbi.JG();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label73:
      if (getClipToPadding())
      {
        this.cbl.bXt = (this.cbi.JE() - i);
        this.cbl.bXu = (paramInt + this.cbi.JF());
      }
      for (;;)
      {
        this.cbl.bXv = false;
        this.cbl.bXp = true;
        params = this.cbl;
        bool1 = bool2;
        if (this.cbi.getMode() == 0)
        {
          bool1 = bool2;
          if (this.cbi.getEnd() == 0) {
            bool1 = true;
          }
        }
        params.bXw = bool1;
        AppMethodBeat.o(194979);
        return;
        bool1 = false;
        break;
        label183:
        i = this.cbi.JG();
        paramInt = 0;
        break label73;
        this.cbl.bXu = (paramInt + this.cbi.getEnd());
        this.cbl.bXt = (-i);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194881);
    if (paramLayoutParams.cbB)
    {
      if (this.mOrientation == 1)
      {
        i(paramView, this.cbs, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
        AppMethodBeat.o(194881);
        return;
      }
      i(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.cbs);
      AppMethodBeat.o(194881);
      return;
    }
    if (this.mOrientation == 1)
    {
      i(paramView, getChildMeasureSpec(this.cbk, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
      AppMethodBeat.o(194881);
      return;
    }
    i(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), getChildMeasureSpec(this.cbk, getHeightMode(), 0, paramLayoutParams.height, false));
    AppMethodBeat.o(194881);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, n paramn)
  {
    AppMethodBeat.i(195057);
    if (paramn.mLayoutDirection == 1)
    {
      if (paramLayoutParams.cbB)
      {
        bK(paramView);
        AppMethodBeat.o(195057);
        return;
      }
      paramLayoutParams.cbA.bN(paramView);
      AppMethodBeat.o(195057);
      return;
    }
    if (paramLayoutParams.cbB)
    {
      bL(paramView);
      AppMethodBeat.o(195057);
      return;
    }
    paramLayoutParams.cbA.bM(paramView);
    AppMethodBeat.o(195057);
  }
  
  private void a(RecyclerView.n paramn, int paramInt)
  {
    AppMethodBeat.i(195196);
    while (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      if ((this.cbi.bt(localView) <= paramInt) && (this.cbi.bu(localView) <= paramInt))
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.cbB)
        {
          int i = 0;
          while (i < this.bWl)
          {
            if (this.cbh[i].cbM.size() == 1)
            {
              AppMethodBeat.o(195196);
              return;
            }
            i += 1;
          }
          i = 0;
          while (i < this.bWl)
          {
            this.cbh[i].Lo();
            i += 1;
          }
        }
        if (localLayoutParams.cbA.cbM.size() == 1)
        {
          AppMethodBeat.o(195196);
          return;
        }
        localLayoutParams.cbA.Lo();
        removeAndRecycleView(localView, paramn);
      }
      else
      {
        AppMethodBeat.o(195196);
        return;
      }
    }
    AppMethodBeat.o(195196);
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(194948);
    int i = gp(-2147483648);
    if (i == -2147483648)
    {
      AppMethodBeat.o(194948);
      return;
    }
    i = this.cbi.JF() - i;
    if (i > 0)
    {
      i -= -a(-i, paramn, params);
      if ((paramBoolean) && (i > 0)) {
        this.cbi.fQ(i);
      }
      AppMethodBeat.o(194948);
      return;
    }
    AppMethodBeat.o(194948);
  }
  
  private void a(RecyclerView.n paramn, n paramn1)
  {
    AppMethodBeat.i(195067);
    if ((!paramn1.bXp) || (paramn1.bXw))
    {
      AppMethodBeat.o(195067);
      return;
    }
    if (paramn1.bXq == 0)
    {
      if (paramn1.mLayoutDirection == -1)
      {
        b(paramn, paramn1.bXu);
        AppMethodBeat.o(195067);
        return;
      }
      a(paramn, paramn1.bXt);
      AppMethodBeat.o(195067);
      return;
    }
    if (paramn1.mLayoutDirection == -1)
    {
      i = paramn1.bXt - gm(paramn1.bXt);
      if (i < 0) {}
      for (i = paramn1.bXu;; i = paramn1.bXu - Math.min(i, paramn1.bXq))
      {
        b(paramn, i);
        AppMethodBeat.o(195067);
        return;
      }
    }
    int i = gq(paramn1.bXu) - paramn1.bXu;
    if (i < 0) {}
    int j;
    for (i = paramn1.bXt;; i = Math.min(i, paramn1.bXq) + j)
    {
      a(paramn, i);
      AppMethodBeat.o(195067);
      return;
      j = paramn1.bXt;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195102);
    int i = paramb.cbP;
    if (paramInt1 == -1)
    {
      if (i + paramb.Lk() <= paramInt2) {
        this.cbm.set(paramb.mIndex, false);
      }
      AppMethodBeat.o(195102);
      return;
    }
    if (paramb.Lm() - i >= paramInt2) {
      this.cbm.set(paramb.mIndex, false);
    }
    AppMethodBeat.o(195102);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(194758);
    if (this.bXB)
    {
      if (paramb.Lm() < this.cbi.JF())
      {
        if (!((LayoutParams)((View)paramb.cbM.get(paramb.cbM.size() - 1)).getLayoutParams()).cbB)
        {
          AppMethodBeat.o(194758);
          return true;
        }
        AppMethodBeat.o(194758);
        return false;
      }
    }
    else if (paramb.Lk() > this.cbi.JE())
    {
      if (!((LayoutParams)((View)paramb.cbM.get(0)).getLayoutParams()).cbB)
      {
        AppMethodBeat.o(194758);
        return true;
      }
      AppMethodBeat.o(194758);
      return false;
    }
    AppMethodBeat.o(194758);
    return false;
  }
  
  private void aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(194781);
    assertNotInLayoutOrScroll(null);
    if ((this.cbr != null) && (this.cbr.bXA != paramBoolean)) {
      this.cbr.bXA = paramBoolean;
    }
    this.bXA = paramBoolean;
    requestLayout();
    AppMethodBeat.o(194781);
  }
  
  private void b(int paramInt, RecyclerView.s params)
  {
    AppMethodBeat.i(195246);
    int i;
    int j;
    if (paramInt > 0)
    {
      i = Lf();
      j = 1;
    }
    for (;;)
    {
      this.cbl.bXp = true;
      a(i, params);
      gj(j);
      params = this.cbl;
      params.bXr = (i + params.bXs);
      this.cbl.bXq = Math.abs(paramInt);
      AppMethodBeat.o(195246);
      return;
      j = -1;
      i = Lg();
    }
  }
  
  private void b(RecyclerView.n paramn, int paramInt)
  {
    AppMethodBeat.i(195207);
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if ((this.cbi.bs(localView) >= paramInt) && (this.cbi.bv(localView) >= paramInt))
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.cbB)
        {
          int j = 0;
          while (j < this.bWl)
          {
            if (this.cbh[j].cbM.size() == 1)
            {
              AppMethodBeat.o(195207);
              return;
            }
            j += 1;
          }
          j = 0;
          while (j < this.bWl)
          {
            this.cbh[j].Ln();
            j += 1;
          }
        }
        if (localLayoutParams.cbA.cbM.size() == 1)
        {
          AppMethodBeat.o(195207);
          return;
        }
        localLayoutParams.cbA.Ln();
        removeAndRecycleView(localView, paramn);
        i -= 1;
      }
      else
      {
        AppMethodBeat.o(195207);
        return;
      }
    }
    AppMethodBeat.o(195207);
  }
  
  private void b(RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(194964);
    int i = gn(2147483647);
    if (i == 2147483647)
    {
      AppMethodBeat.o(194964);
      return;
    }
    i -= this.cbi.JE();
    if (i > 0)
    {
      i -= a(i, paramn, params);
      if ((paramBoolean) && (i > 0)) {
        this.cbi.fQ(-i);
      }
      AppMethodBeat.o(194964);
      return;
    }
    AppMethodBeat.o(194964);
  }
  
  private void bJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195092);
    int i = 0;
    while (i < this.bWl)
    {
      if (!this.cbh[i].cbM.isEmpty()) {
        a(this.cbh[i], paramInt1, paramInt2);
      }
      i += 1;
    }
    AppMethodBeat.o(195092);
  }
  
  private void bK(View paramView)
  {
    AppMethodBeat.i(195077);
    int i = this.bWl - 1;
    while (i >= 0)
    {
      this.cbh[i].bN(paramView);
      i -= 1;
    }
    AppMethodBeat.o(195077);
  }
  
  private void bL(View paramView)
  {
    AppMethodBeat.i(195086);
    int i = this.bWl - 1;
    while (i >= 0)
    {
      this.cbh[i].bM(paramView);
      i -= 1;
    }
    AppMethodBeat.o(195086);
  }
  
  private View bh(boolean paramBoolean)
  {
    AppMethodBeat.i(194921);
    int j = this.cbi.JE();
    int k = this.cbi.JF();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.cbi.bs(localView);
      if ((this.cbi.bt(localView) <= j) || (n >= k)) {
        break label122;
      }
      if ((n >= j) || (!paramBoolean))
      {
        AppMethodBeat.o(194921);
        return localView;
      }
      if (localObject != null) {
        break label122;
      }
      localObject = localView;
    }
    label122:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(194921);
      return localObject;
    }
  }
  
  private View bi(boolean paramBoolean)
  {
    AppMethodBeat.i(194938);
    int j = this.cbi.JE();
    int k = this.cbi.JF();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.cbi.bs(localView);
      int n = this.cbi.bt(localView);
      if ((n <= j) || (m >= k)) {
        break label124;
      }
      if ((n <= k) || (!paramBoolean))
      {
        AppMethodBeat.o(194938);
        return localView;
      }
      if (localObject != null) {
        break label124;
      }
      localObject = localView;
    }
    label124:
    for (;;)
    {
      i -= 1;
      break;
      AppMethodBeat.o(194938);
      return localObject;
    }
  }
  
  private int c(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(194837);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(194837);
      return 0;
    }
    s locals = this.cbi;
    View localView;
    if (!this.bXD)
    {
      bool1 = true;
      localView = bh(bool1);
      if (this.bXD) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = v.a(params, locals, localView, bi(bool1), this, this.bXD, this.bXB);
      AppMethodBeat.o(194837);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private int d(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(194849);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(194849);
      return 0;
    }
    s locals = this.cbi;
    View localView;
    if (!this.bXD)
    {
      bool1 = true;
      localView = bh(bool1);
      if (this.bXD) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = v.a(params, locals, localView, bi(bool1), this, this.bXD);
      AppMethodBeat.o(194849);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private int e(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(194864);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(194864);
      return 0;
    }
    s locals = this.cbi;
    View localView;
    if (!this.bXD)
    {
      bool1 = true;
      localView = bh(bool1);
      if (this.bXD) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = v.b(params, locals, localView, bi(bool1), this, this.bXD);
      AppMethodBeat.o(194864);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private void fI(int paramInt)
  {
    AppMethodBeat.i(194771);
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.bWl)
    {
      this.cbn.clear();
      requestLayout();
      this.bWl = paramInt;
      this.cbm = new BitSet(this.bWl);
      this.cbh = new b[this.bWl];
      paramInt = 0;
      while (paramInt < this.bWl)
      {
        this.cbh[paramInt] = new b(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
    AppMethodBeat.o(194771);
  }
  
  private void gi(int paramInt)
  {
    AppMethodBeat.i(194822);
    this.cbk = (paramInt / this.bWl);
    this.cbs = View.MeasureSpec.makeMeasureSpec(paramInt, this.cbj.getMode());
    AppMethodBeat.o(194822);
  }
  
  private void gj(int paramInt)
  {
    int i = 1;
    this.cbl.mLayoutDirection = paramInt;
    n localn = this.cbl;
    boolean bool2 = this.bXB;
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
      localn.bXs = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem gk(int paramInt)
  {
    AppMethodBeat.i(195041);
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.cbF = new int[this.bWl];
    int i = 0;
    while (i < this.bWl)
    {
      localFullSpanItem.cbF[i] = (paramInt - this.cbh[i].gC(paramInt));
      i += 1;
    }
    AppMethodBeat.o(195041);
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem gl(int paramInt)
  {
    AppMethodBeat.i(195047);
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.cbF = new int[this.bWl];
    int i = 0;
    while (i < this.bWl)
    {
      localFullSpanItem.cbF[i] = (this.cbh[i].gB(paramInt) - paramInt);
      i += 1;
    }
    AppMethodBeat.o(195047);
    return localFullSpanItem;
  }
  
  private int gm(int paramInt)
  {
    AppMethodBeat.i(195115);
    int j = this.cbh[0].gB(paramInt);
    int i = 1;
    while (i < this.bWl)
    {
      int m = this.cbh[i].gB(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(195115);
    return j;
  }
  
  private int gn(int paramInt)
  {
    AppMethodBeat.i(195125);
    int j = this.cbh[0].gB(paramInt);
    int i = 1;
    while (i < this.bWl)
    {
      int m = this.cbh[i].gB(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(195125);
    return j;
  }
  
  private int gp(int paramInt)
  {
    AppMethodBeat.i(195172);
    int j = this.cbh[0].gC(paramInt);
    int i = 1;
    while (i < this.bWl)
    {
      int m = this.cbh[i].gC(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(195172);
    return j;
  }
  
  private int gq(int paramInt)
  {
    AppMethodBeat.i(195185);
    int j = this.cbh[0].gC(paramInt);
    int i = 1;
    while (i < this.bWl)
    {
      int m = this.cbh[i].gC(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(195185);
    return j;
  }
  
  private boolean gr(int paramInt)
  {
    AppMethodBeat.i(195220);
    if (this.mOrientation == 0)
    {
      if (paramInt == -1) {}
      for (i = 1; i != this.bXB; i = 0)
      {
        AppMethodBeat.o(195220);
        return true;
      }
      AppMethodBeat.o(195220);
      return false;
    }
    if (paramInt == -1)
    {
      i = 1;
      if (i != this.bXB) {
        break label87;
      }
    }
    label87:
    for (int i = 1;; i = 0)
    {
      if (i != Ja()) {
        break label92;
      }
      AppMethodBeat.o(195220);
      return true;
      i = 0;
      break;
    }
    label92:
    AppMethodBeat.o(195220);
    return false;
  }
  
  private int gs(int paramInt)
  {
    AppMethodBeat.i(195235);
    if (getChildCount() == 0)
    {
      if (this.bXB)
      {
        AppMethodBeat.o(195235);
        return 1;
      }
      AppMethodBeat.o(195235);
      return -1;
    }
    if (paramInt < Lg()) {}
    for (int i = 1; i != this.bXB; i = 0)
    {
      AppMethodBeat.o(195235);
      return -1;
    }
    AppMethodBeat.o(195235);
    return 1;
  }
  
  private void i(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194893);
    calculateItemDecorationsForChild(paramView, this.byy);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = y(paramInt1, localLayoutParams.leftMargin + this.byy.left, localLayoutParams.rightMargin + this.byy.right);
    paramInt2 = y(paramInt2, localLayoutParams.topMargin + this.byy.top, localLayoutParams.bottomMargin + this.byy.bottom);
    if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(194893);
  }
  
  private static int y(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194904);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      AppMethodBeat.o(194904);
      return paramInt1;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i == -2147483648) || (i == 1073741824))
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
      AppMethodBeat.o(194904);
      return paramInt1;
    }
    AppMethodBeat.o(194904);
    return paramInt1;
  }
  
  private void z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195007);
    int k;
    int j;
    int i;
    if (this.bXB)
    {
      k = Lf();
      if (paramInt3 != 8) {
        break label118;
      }
      if (paramInt1 >= paramInt2) {
        break label107;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label38:
      this.cbn.gu(i);
      switch (paramInt3)
      {
      }
    }
    for (;;)
    {
      if (j > k) {
        break label174;
      }
      AppMethodBeat.o(195007);
      return;
      k = Lg();
      break;
      label107:
      j = paramInt1 + 1;
      i = paramInt2;
      break label38;
      label118:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label38;
      this.cbn.bM(paramInt1, paramInt2);
      continue;
      this.cbn.bK(paramInt1, paramInt2);
      continue;
      this.cbn.bK(paramInt1, 1);
      this.cbn.bM(paramInt2, 1);
    }
    label174:
    if (this.bXB) {}
    for (paramInt1 = Lg();; paramInt1 = Lf())
    {
      if (i <= paramInt1) {
        requestLayout();
      }
      AppMethodBeat.o(195007);
      return;
    }
  }
  
  final boolean KZ()
  {
    AppMethodBeat.i(195291);
    if ((getChildCount() == 0) || (this.cbo == 0) || (!isAttachedToWindow()))
    {
      AppMethodBeat.o(195291);
      return false;
    }
    int j;
    if (this.bXB) {
      j = Lf();
    }
    for (int i = Lg(); (j == 0) && (La() != null); i = Lf())
    {
      this.cbn.clear();
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      AppMethodBeat.o(195291);
      return true;
      j = Lg();
    }
    if (!this.cbu)
    {
      AppMethodBeat.o(195291);
      return false;
    }
    if (this.bXB) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.cbn.A(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.cbu = false;
      this.cbn.gt(i + 1);
      AppMethodBeat.o(195291);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.cbn.A(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.cbn.gt(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      AppMethodBeat.o(195291);
      return true;
      this.cbn.gt(localFullSpanItem2.mPosition + 1);
    }
  }
  
  public final int[] Lb()
  {
    AppMethodBeat.i(195421);
    int[] arrayOfInt = new int[this.bWl];
    int i = 0;
    if (i < this.bWl)
    {
      b localb = this.cbh[i];
      if (localb.cbx.bXA) {}
      for (int j = localb.h(localb.cbM.size() - 1, -1, true);; j = localb.h(0, localb.cbM.size(), true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(195421);
    return arrayOfInt;
  }
  
  public final int[] Lc()
  {
    AppMethodBeat.i(195440);
    int[] arrayOfInt = new int[this.bWl];
    int i = 0;
    if (i < this.bWl)
    {
      b localb = this.cbh[i];
      if (localb.cbx.bXA) {}
      for (int j = localb.h(0, localb.cbM.size(), true);; j = localb.h(localb.cbM.size() - 1, -1, true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(195440);
    return arrayOfInt;
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(195320);
    if (this.cbr == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
    AppMethodBeat.o(195320);
  }
  
  public void bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195797);
    if (this.cbr != null) {
      this.cbr.Li();
    }
    this.bXE = paramInt1;
    this.bXF = paramInt2;
    requestLayout();
    AppMethodBeat.o(195797);
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
    AppMethodBeat.i(195820);
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      AppMethodBeat.o(195820);
      return;
      paramInt1 = paramInt2;
    }
    b(paramInt1, params);
    if ((this.cbv == null) || (this.cbv.length < this.bWl)) {
      this.cbv = new int[this.bWl];
    }
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt2 < this.bWl)
    {
      if (this.cbl.bXs == -1) {}
      for (int j = this.cbl.bXt - this.cbh[paramInt2].gB(this.cbl.bXt);; j = this.cbh[paramInt2].gC(this.cbl.bXu) - this.cbl.bXu)
      {
        int i = paramInt1;
        if (j >= 0)
        {
          this.cbv[paramInt1] = j;
          i = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = i;
        break;
      }
    }
    Arrays.sort(this.cbv, 0, paramInt1);
    paramInt2 = k;
    while ((paramInt2 < paramInt1) && (this.cbl.a(params)))
    {
      parama.bd(this.cbl.bXr, this.cbv[paramInt2]);
      n localn = this.cbl;
      localn.bXr += this.cbl.bXs;
      paramInt2 += 1;
    }
    AppMethodBeat.o(195820);
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(195480);
    int i = d(params);
    AppMethodBeat.o(195480);
    return i;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(195456);
    int i = c(params);
    AppMethodBeat.o(195456);
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(195506);
    int i = e(params);
    AppMethodBeat.o(195506);
    return i;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(195493);
    int i = d(params);
    AppMethodBeat.o(195493);
    return i;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(195468);
    int i = c(params);
    AppMethodBeat.o(195468);
    return i;
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(195519);
    int i = e(params);
    AppMethodBeat.o(195519);
    return i;
  }
  
  public final PointF fM(int paramInt)
  {
    AppMethodBeat.i(195744);
    paramInt = gs(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0)
    {
      AppMethodBeat.o(195744);
      return null;
    }
    if (this.mOrientation == 0) {
      localPointF.x = paramInt;
    }
    for (localPointF.y = 0.0F;; localPointF.y = paramInt)
    {
      AppMethodBeat.o(195744);
      return localPointF;
      localPointF.x = 0.0F;
    }
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(195836);
    if (this.mOrientation == 0)
    {
      localLayoutParams = new LayoutParams(-2, -1);
      AppMethodBeat.o(195836);
      return localLayoutParams;
    }
    LayoutParams localLayoutParams = new LayoutParams(-1, -2);
    AppMethodBeat.o(195836);
    return localLayoutParams;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(195853);
    paramContext = new LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(195853);
    return paramContext;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(195867);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(195867);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(195867);
    return paramLayoutParams;
  }
  
  public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195607);
    if (this.mOrientation == 1)
    {
      i = this.bWl;
      AppMethodBeat.o(195607);
      return i;
    }
    int i = super.getColumnCountForAccessibility(paramn, params);
    AppMethodBeat.o(195607);
    return i;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195596);
    if (this.mOrientation == 0)
    {
      i = this.bWl;
      AppMethodBeat.o(195596);
      return i;
    }
    int i = super.getRowCountForAccessibility(paramn, params);
    AppMethodBeat.o(195596);
    return i;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return this.cbo != 0;
  }
  
  public final int[] n(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195413);
    int[] arrayOfInt;
    int i;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = new int[this.bWl];
      i = 0;
      label20:
      if (i >= this.bWl) {
        break label149;
      }
      paramArrayOfInt = this.cbh[i];
      if (!paramArrayOfInt.cbx.bXA) {
        break label132;
      }
    }
    label132:
    for (int j = paramArrayOfInt.h(paramArrayOfInt.cbM.size() - 1, -1, false);; j = paramArrayOfInt.h(0, paramArrayOfInt.cbM.size(), false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label20;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.bWl) {
        break;
      }
      paramArrayOfInt = new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.bWl + ", array size:" + paramArrayOfInt.length);
      AppMethodBeat.o(195413);
      throw paramArrayOfInt;
    }
    label149:
    AppMethodBeat.o(195413);
    return arrayOfInt;
  }
  
  public final int[] o(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195431);
    int[] arrayOfInt;
    int i;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = new int[this.bWl];
      i = 0;
      label20:
      if (i >= this.bWl) {
        break label149;
      }
      paramArrayOfInt = this.cbh[i];
      if (!paramArrayOfInt.cbx.bXA) {
        break label130;
      }
    }
    label130:
    for (int j = paramArrayOfInt.h(0, paramArrayOfInt.cbM.size(), false);; j = paramArrayOfInt.h(paramArrayOfInt.cbM.size() - 1, -1, false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label20;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.bWl) {
        break;
      }
      paramArrayOfInt = new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.bWl + ", array size:" + paramArrayOfInt.length);
      AppMethodBeat.o(195431);
      throw paramArrayOfInt;
    }
    label149:
    AppMethodBeat.o(195431);
    return arrayOfInt;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    AppMethodBeat.i(195618);
    super.offsetChildrenHorizontal(paramInt);
    int i = 0;
    while (i < this.bWl)
    {
      this.cbh[i].gD(paramInt);
      i += 1;
    }
    AppMethodBeat.o(195618);
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    AppMethodBeat.i(195630);
    super.offsetChildrenVertical(paramInt);
    int i = 0;
    while (i < this.bWl)
    {
      this.cbh[i].gD(paramInt);
      i += 1;
    }
    AppMethodBeat.o(195630);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(195312);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    removeCallbacks(this.cbw);
    int i = 0;
    while (i < this.bWl)
    {
      this.cbh[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
    AppMethodBeat.o(195312);
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195908);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(195908);
      return null;
    }
    paramView = findContainingItemView(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(195908);
      return null;
    }
    Jn();
    switch (paramInt)
    {
    default: 
      paramInt = -2147483648;
    }
    while (paramInt == -2147483648)
    {
      AppMethodBeat.o(195908);
      return null;
      if (this.mOrientation == 1)
      {
        paramInt = -1;
      }
      else if (Ja())
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
        else if (Ja())
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
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    boolean bool = ((LayoutParams)localObject).cbB;
    localObject = ((LayoutParams)localObject).cbA;
    if (paramInt == 1) {}
    for (int i = Lf();; i = Lg())
    {
      a(i, params);
      gj(paramInt);
      n localn = this.cbl;
      localn.bXr = (localn.bXs + i);
      this.cbl.bXq = ((int)(0.3333333F * this.cbi.JG()));
      this.cbl.bXv = true;
      this.cbl.bXp = false;
      a(paramn, this.cbl, params);
      this.cbp = this.bXB;
      if (bool) {
        break;
      }
      paramn = ((b)localObject).bP(i, paramInt);
      if ((paramn == null) || (paramn == paramView)) {
        break;
      }
      AppMethodBeat.o(195908);
      return paramn;
    }
    if (gr(paramInt))
    {
      j = this.bWl - 1;
      while (j >= 0)
      {
        paramn = this.cbh[j].bP(i, paramInt);
        if ((paramn != null) && (paramn != paramView))
        {
          AppMethodBeat.o(195908);
          return paramn;
        }
        j -= 1;
      }
    }
    int j = 0;
    while (j < this.bWl)
    {
      paramn = this.cbh[j].bP(i, paramInt);
      if ((paramn != null) && (paramn != paramView))
      {
        AppMethodBeat.o(195908);
        return paramn;
      }
      j += 1;
    }
    if (!this.bXA)
    {
      i = 1;
      if (paramInt != -1) {
        break label605;
      }
      j = 1;
      label548:
      if (i != j) {
        break label611;
      }
      i = 1;
      label558:
      if (bool) {
        break label627;
      }
      if (i == 0) {
        break label617;
      }
    }
    label605:
    label611:
    label617:
    for (j = ((b)localObject).Lp();; j = ((b)localObject).Lq())
    {
      paramn = findViewByPosition(j);
      if ((paramn == null) || (paramn == paramView)) {
        break label627;
      }
      AppMethodBeat.o(195908);
      return paramn;
      i = 0;
      break;
      j = 0;
      break label548;
      i = 0;
      break label558;
    }
    label627:
    if (gr(paramInt))
    {
      paramInt = this.bWl - 1;
      while (paramInt >= 0)
      {
        if (paramInt != ((b)localObject).mIndex)
        {
          if (i != 0) {}
          for (j = this.cbh[paramInt].Lp();; j = this.cbh[paramInt].Lq())
          {
            paramn = findViewByPosition(j);
            if ((paramn == null) || (paramn == paramView)) {
              break;
            }
            AppMethodBeat.o(195908);
            return paramn;
          }
        }
        paramInt -= 1;
      }
    }
    paramInt = 0;
    while (paramInt < this.bWl)
    {
      if (i != 0) {}
      for (j = this.cbh[paramInt].Lp();; j = this.cbh[paramInt].Lq())
      {
        paramn = findViewByPosition(j);
        if ((paramn == null) || (paramn == paramView)) {
          break;
        }
        AppMethodBeat.o(195908);
        return paramn;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(195908);
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195583);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      View localView1 = bh(false);
      View localView2 = bi(false);
      if ((localView1 == null) || (localView2 == null))
      {
        AppMethodBeat.o(195583);
        return;
      }
      int i = getPosition(localView1);
      int j = getPosition(localView2);
      if (i < j)
      {
        paramAccessibilityEvent.setFromIndex(i);
        paramAccessibilityEvent.setToIndex(j);
        AppMethodBeat.o(195583);
        return;
      }
      paramAccessibilityEvent.setFromIndex(j);
      paramAccessibilityEvent.setToIndex(i);
    }
    AppMethodBeat.o(195583);
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, d paramd)
  {
    int k = 1;
    AppMethodBeat.i(195569);
    paramn = paramView.getLayoutParams();
    if (!(paramn instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramd);
      AppMethodBeat.o(195569);
      return;
    }
    paramn = (LayoutParams)paramn;
    int i;
    int j;
    int m;
    if (this.mOrientation == 0)
    {
      i = paramn.Lh();
      if (paramn.cbB)
      {
        j = this.bWl;
        k = -1;
        m = -1;
      }
    }
    for (;;)
    {
      paramd.aC(d.c.a(i, j, m, k, paramn.cbB, false));
      AppMethodBeat.o(195569);
      return;
      j = 1;
      break;
      m = paramn.Lh();
      if (paramn.cbB)
      {
        k = this.bWl;
        j = -1;
        i = -1;
      }
      else
      {
        j = -1;
        i = -1;
      }
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195656);
    z(paramInt1, paramInt2, 1);
    AppMethodBeat.o(195656);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(195668);
    this.cbn.clear();
    requestLayout();
    AppMethodBeat.o(195668);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195679);
    z(paramInt1, paramInt2, 8);
    AppMethodBeat.o(195679);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195645);
    z(paramInt1, paramInt2, 2);
    AppMethodBeat.o(195645);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(195688);
    z(paramInt1, paramInt2, 4);
    AppMethodBeat.o(195688);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195378);
    int j = 1;
    a locala = this.cbt;
    if (((this.cbr != null) || (this.bXE != -1)) && (params.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      locala.reset();
      AppMethodBeat.o(195378);
      return;
    }
    int k;
    int m;
    label124:
    int n;
    if ((!locala.Nl) || (this.bXE != -1) || (this.cbr != null))
    {
      k = 1;
      if (k == 0) {
        break label476;
      }
      locala.reset();
      if (this.cbr == null) {
        break label627;
      }
      if (this.cbr.cbI <= 0) {
        break label280;
      }
      if (this.cbr.cbI != this.bWl) {
        break label230;
      }
      m = 0;
      if (m >= this.bWl) {
        break label280;
      }
      this.cbh[m].clear();
      n = this.cbr.cbJ[m];
      i = n;
      if (n != -2147483648) {
        if (!this.cbr.bXW) {
          break label215;
        }
      }
    }
    label215:
    for (int i = n + this.cbi.JF();; i = n + this.cbi.JE())
    {
      this.cbh[m].setLine(i);
      m += 1;
      break label124;
      k = 0;
      break;
    }
    label230:
    Object localObject1 = this.cbr;
    ((SavedState)localObject1).cbJ = null;
    ((SavedState)localObject1).cbI = 0;
    ((SavedState)localObject1).cbK = 0;
    ((SavedState)localObject1).cbL = null;
    ((SavedState)localObject1).cbD = null;
    this.cbr.bXU = this.cbr.cbH;
    label280:
    this.cbq = this.cbr.cbq;
    aZ(this.cbr.bXA);
    Jn();
    if (this.cbr.bXU != -1)
    {
      this.bXE = this.cbr.bXU;
      locala.bXM = this.cbr.bXW;
      if (this.cbr.cbK > 1)
      {
        this.cbn.cbC = this.cbr.cbL;
        this.cbn.cbD = this.cbr.cbD;
      }
      label379:
      if ((!params.caw) && (this.bXE != -1)) {
        break label643;
      }
      i = 0;
      label397:
      if (i == 0)
      {
        if (!this.cbp) {
          break label1162;
        }
        n = params.getItemCount();
        i = getChildCount() - 1;
        label423:
        if (i < 0) {
          break label1156;
        }
        m = getPosition(getChildAt(i));
        if ((m < 0) || (m >= n)) {
          break label1147;
        }
        i = m;
      }
    }
    label476:
    label627:
    boolean bool;
    label643:
    label734:
    label866:
    label1004:
    label1147:
    int i1;
    for (;;)
    {
      locala.mPosition = i;
      locala.Sc = -2147483648;
      locala.Nl = true;
      if ((this.cbr == null) && (this.bXE == -1) && ((locala.bXM != this.cbp) || (Ja() != this.cbq)))
      {
        this.cbn.clear();
        locala.cby = true;
      }
      if ((getChildCount() <= 0) || ((this.cbr != null) && (this.cbr.cbI > 0))) {
        break label1539;
      }
      if (!locala.cby) {
        break label1227;
      }
      i = 0;
      while (i < this.bWl)
      {
        this.cbh[i].clear();
        if (locala.Sc != -2147483648) {
          this.cbh[i].setLine(locala.Sc);
        }
        i += 1;
      }
      locala.bXM = this.bXB;
      break;
      Jn();
      locala.bXM = this.bXB;
      break label379;
      if ((this.bXE < 0) || (this.bXE >= params.getItemCount()))
      {
        this.bXE = -1;
        this.bXF = -2147483648;
        i = 0;
        break label397;
      }
      if ((this.cbr == null) || (this.cbr.bXU == -1) || (this.cbr.cbI <= 0))
      {
        localObject1 = findViewByPosition(this.bXE);
        if (localObject1 != null)
        {
          if (this.bXB)
          {
            i = Lf();
            locala.mPosition = i;
            if (this.bXF == -2147483648) {
              break label830;
            }
            if (!locala.bXM) {
              break label800;
            }
          }
          label800:
          for (locala.Sc = (this.cbi.JF() - this.bXF - this.cbi.bt((View)localObject1));; locala.Sc = (this.cbi.JE() + this.bXF - this.cbi.bs((View)localObject1)))
          {
            i = 1;
            break;
            i = Lg();
            break label734;
          }
          label830:
          if (this.cbi.bw((View)localObject1) > this.cbi.JG()) {
            if (locala.bXM)
            {
              i = this.cbi.JF();
              locala.Sc = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.cbi.JE();
        break label866;
        i = this.cbi.bs((View)localObject1) - this.cbi.JE();
        if (i < 0)
        {
          locala.Sc = (-i);
        }
        else
        {
          i = this.cbi.JF() - this.cbi.bt((View)localObject1);
          if (i < 0)
          {
            locala.Sc = i;
          }
          else
          {
            locala.Sc = -2147483648;
            continue;
            locala.mPosition = this.bXE;
            if (this.bXF == -2147483648) {
              if (gs(locala.mPosition) == 1)
              {
                bool = true;
                locala.bXM = bool;
                if (!locala.bXM) {
                  break label1054;
                }
                i = locala.cbx.cbi.JF();
                label1032:
                locala.Sc = i;
              }
            }
            for (;;)
            {
              locala.cby = true;
              break;
              bool = false;
              break label1004;
              label1054:
              i = locala.cbx.cbi.JE();
              break label1032;
              i = this.bXF;
              if (locala.bXM) {
                locala.Sc = (locala.cbx.cbi.JF() - i);
              } else {
                locala.Sc = (i + locala.cbx.cbi.JE());
              }
            }
            locala.Sc = -2147483648;
            locala.mPosition = this.bXE;
          }
        }
      }
      i -= 1;
      break label423;
      label1156:
      i = 0;
      continue;
      label1162:
      i1 = params.getItemCount();
      int i2 = getChildCount();
      m = 0;
      for (;;)
      {
        if (m >= i2) {
          break label1221;
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
      label1221:
      i = 0;
    }
    label1227:
    label1365:
    Object localObject2;
    if ((k != 0) || (this.cbt.cbz == null))
    {
      k = 0;
      if (k < this.bWl)
      {
        localObject1 = this.cbh[k];
        bool = this.bXB;
        n = locala.Sc;
        if (bool)
        {
          i = ((b)localObject1).gC(-2147483648);
          label1290:
          ((b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((b)localObject1).cbx.cbi.JF())) && ((bool) || (i <= ((b)localObject1).cbx.cbi.JE()))) {
            break label1365;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = ((b)localObject1).gB(-2147483648);
          break label1290;
          m = i;
          if (n != -2147483648) {
            m = i + n;
          }
          ((b)localObject1).cbO = m;
          ((b)localObject1).cbN = m;
        }
      }
      localObject1 = this.cbt;
      localObject2 = this.cbh;
      k = localObject2.length;
      if ((((a)localObject1).cbz == null) || (((a)localObject1).cbz.length < k)) {
        ((a)localObject1).cbz = new int[((a)localObject1).cbx.cbh.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((a)localObject1).cbz[i] = localObject2[i].gB(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.bWl)
      {
        localObject1 = this.cbh[i];
        ((b)localObject1).clear();
        ((b)localObject1).setLine(this.cbt.cbz[i]);
        i += 1;
      }
    }
    label1539:
    detachAndScrapAttachedViews(paramn);
    this.cbl.bXp = false;
    this.cbu = false;
    gi(this.cbj.JG());
    a(locala.mPosition, params);
    label1638:
    float f1;
    if (locala.bXM)
    {
      gj(-1);
      a(paramn, this.cbl, params);
      gj(1);
      this.cbl.bXr = (locala.mPosition + this.cbl.bXs);
      a(paramn, this.cbl, params);
      if (this.cbj.getMode() == 1073741824) {
        break label2024;
      }
      f1 = 0.0F;
      m = getChildCount();
      i = 0;
      label1662:
      if (i >= m) {
        break label1793;
      }
      localObject1 = getChildAt(i);
      float f2 = this.cbj.bw((View)localObject1);
      if (f2 < f1) {
        break label2220;
      }
      if (!((LayoutParams)((View)localObject1).getLayoutParams()).cbB) {
        break label2217;
      }
      f2 = 1.0F * f2 / this.bWl;
      label1722:
      f1 = Math.max(f1, f2);
    }
    label1793:
    label1962:
    label2220:
    for (;;)
    {
      i += 1;
      break label1662;
      gj(1);
      a(paramn, this.cbl, params);
      gj(-1);
      this.cbl.bXr = (locala.mPosition + this.cbl.bXs);
      a(paramn, this.cbl, params);
      break label1638;
      n = this.cbk;
      k = Math.round(this.bWl * f1);
      i = k;
      if (this.cbj.getMode() == -2147483648) {
        i = Math.min(k, this.cbj.JG());
      }
      gi(i);
      if (this.cbk != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (!((LayoutParams)localObject2).cbB)
          {
            if ((!Ja()) || (this.mOrientation != 1)) {
              break label1962;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.bWl - 1 - ((LayoutParams)localObject2).cbA.mIndex) * this.cbk - -(this.bWl - 1 - ((LayoutParams)localObject2).cbA.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            k = ((LayoutParams)localObject2).cbA.mIndex * this.cbk;
            i1 = ((LayoutParams)localObject2).cbA.mIndex * n;
            if (this.mOrientation == 1) {
              ((View)localObject1).offsetLeftAndRight(k - i1);
            } else {
              ((View)localObject1).offsetTopAndBottom(k - i1);
            }
          }
        }
      }
      label2024:
      if (getChildCount() > 0)
      {
        if (this.bXB)
        {
          a(paramn, params, true);
          b(paramn, params, false);
        }
      }
      else
      {
        k = 0;
        i = k;
        if (j != 0)
        {
          i = k;
          if (!params.caw) {
            if ((this.cbo == 0) || (getChildCount() <= 0) || ((!this.cbu) && (La() == null))) {
              break label2204;
            }
          }
        }
      }
      for (j = 1;; j = 0)
      {
        i = k;
        if (j != 0)
        {
          removeCallbacks(this.cbw);
          i = k;
          if (KZ()) {
            i = 1;
          }
        }
        if (params.caw) {
          this.cbt.reset();
        }
        this.cbp = locala.bXM;
        this.cbq = Ja();
        if (i == 0) {
          break label2210;
        }
        this.cbt.reset();
        j = 0;
        break;
        b(paramn, params, true);
        a(paramn, params, false);
        break label2052;
      }
      AppMethodBeat.o(195378);
      return;
      break label1722;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(195391);
    super.onLayoutCompleted(params);
    this.bXE = -1;
    this.bXF = -2147483648;
    this.cbr = null;
    this.cbt.reset();
    AppMethodBeat.o(195391);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(195536);
    if ((paramParcelable instanceof SavedState))
    {
      this.cbr = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(195536);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(195558);
    Object localObject;
    if (this.cbr != null)
    {
      localObject = new SavedState(this.cbr);
      AppMethodBeat.o(195558);
      return localObject;
    }
    SavedState localSavedState = new SavedState();
    localSavedState.bXA = this.bXA;
    localSavedState.bXW = this.cbp;
    localSavedState.cbq = this.cbq;
    int i;
    label142:
    label162:
    label169:
    int j;
    label197:
    int k;
    if ((this.cbn != null) && (this.cbn.cbC != null))
    {
      localSavedState.cbL = this.cbn.cbC;
      localSavedState.cbK = localSavedState.cbL.length;
      localSavedState.cbD = this.cbn.cbD;
      if (getChildCount() <= 0) {
        break label327;
      }
      if (!this.cbp) {
        break label266;
      }
      i = Lf();
      localSavedState.bXU = i;
      if (!this.bXB) {
        break label274;
      }
      localObject = bi(true);
      if (localObject != null) {
        break label284;
      }
      i = -1;
      localSavedState.cbH = i;
      localSavedState.cbI = this.bWl;
      localSavedState.cbJ = new int[this.bWl];
      j = 0;
      if (j >= this.bWl) {
        break label345;
      }
      if (!this.cbp) {
        break label294;
      }
      k = this.cbh[j].gC(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.cbi.JF();
      }
    }
    for (;;)
    {
      localSavedState.cbJ[j] = i;
      j += 1;
      break label197;
      localSavedState.cbK = 0;
      break;
      label266:
      i = Lg();
      break label142;
      label274:
      localObject = bh(true);
      break label162;
      label284:
      i = getPosition((View)localObject);
      break label169;
      label294:
      k = this.cbh[j].gB(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.cbi.JE();
      }
    }
    label327:
    localSavedState.bXU = -1;
    localSavedState.cbH = -1;
    localSavedState.cbI = 0;
    label345:
    AppMethodBeat.o(195558);
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(195301);
    if (paramInt == 0) {
      KZ();
    }
    AppMethodBeat.o(195301);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195718);
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(195718);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(195778);
    if ((this.cbr != null) && (this.cbr.bXU != paramInt)) {
      this.cbr.Li();
    }
    this.bXE = paramInt;
    this.bXF = -2147483648;
    requestLayout();
    AppMethodBeat.o(195778);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195729);
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(195729);
    return paramInt;
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195329);
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.cbk * this.bWl, getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(195329);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.cbk * this.bWl, getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(195763);
    paramRecyclerView = new o(paramRecyclerView.getContext());
    paramRecyclerView.cag = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(195763);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return this.cbr == null;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b cbA;
    public boolean cbB;
    
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
    
    public final int Lh()
    {
      if (this.cbA == null) {
        return -1;
      }
      return this.cbA.mIndex;
    }
  }
  
  static final class LazySpanLookup
  {
    int[] cbC;
    List<FullSpanItem> cbD;
    
    private void bL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195289);
      if (this.cbD == null)
      {
        AppMethodBeat.o(195289);
        return;
      }
      int i = this.cbD.size() - 1;
      if (i >= 0)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.cbD.get(i);
        if (localFullSpanItem.mPosition >= paramInt1)
        {
          if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
            break label87;
          }
          this.cbD.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          label87:
          localFullSpanItem.mPosition -= paramInt2;
        }
      }
      AppMethodBeat.o(195289);
    }
    
    private void bN(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195295);
      if (this.cbD == null)
      {
        AppMethodBeat.o(195295);
        return;
      }
      int i = this.cbD.size() - 1;
      while (i >= 0)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.cbD.get(i);
        if (localFullSpanItem.mPosition >= paramInt1) {
          localFullSpanItem.mPosition += paramInt2;
        }
        i -= 1;
      }
      AppMethodBeat.o(195295);
    }
    
    private int gw(int paramInt)
    {
      int i = this.cbC.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    private void gx(int paramInt)
    {
      AppMethodBeat.i(195283);
      if (this.cbC == null)
      {
        this.cbC = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(this.cbC, -1);
        AppMethodBeat.o(195283);
        return;
      }
      if (paramInt >= this.cbC.length)
      {
        int[] arrayOfInt = this.cbC;
        this.cbC = new int[gw(paramInt)];
        System.arraycopy(arrayOfInt, 0, this.cbC, 0, arrayOfInt.length);
        Arrays.fill(this.cbC, arrayOfInt.length, this.cbC.length, -1);
      }
      AppMethodBeat.o(195283);
    }
    
    private int gy(int paramInt)
    {
      AppMethodBeat.i(195305);
      if (this.cbD == null)
      {
        AppMethodBeat.o(195305);
        return -1;
      }
      FullSpanItem localFullSpanItem = gz(paramInt);
      if (localFullSpanItem != null) {
        this.cbD.remove(localFullSpanItem);
      }
      int j = this.cbD.size();
      int i = 0;
      if (i < j) {
        if (((FullSpanItem)this.cbD.get(i)).mPosition < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)this.cbD.get(i);
          this.cbD.remove(i);
          paramInt = localFullSpanItem.mPosition;
          AppMethodBeat.o(195305);
          return paramInt;
          i += 1;
          break;
        }
        AppMethodBeat.o(195305);
        return -1;
        i = -1;
      }
    }
    
    public final FullSpanItem A(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195368);
      if (this.cbD == null)
      {
        AppMethodBeat.o(195368);
        return null;
      }
      int j = this.cbD.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.cbD.get(i);
        if (localFullSpanItem.mPosition >= paramInt2)
        {
          AppMethodBeat.o(195368);
          return null;
        }
        if ((localFullSpanItem.mPosition >= paramInt1) && ((paramInt3 == 0) || (localFullSpanItem.cbE == paramInt3) || (localFullSpanItem.cbG)))
        {
          AppMethodBeat.o(195368);
          return localFullSpanItem;
        }
        i += 1;
      }
      AppMethodBeat.o(195368);
      return null;
    }
    
    final void a(int paramInt, StaggeredGridLayoutManager.b paramb)
    {
      AppMethodBeat.i(195325);
      gx(paramInt);
      this.cbC[paramInt] = paramb.mIndex;
      AppMethodBeat.o(195325);
    }
    
    public final void a(FullSpanItem paramFullSpanItem)
    {
      AppMethodBeat.i(195354);
      if (this.cbD == null) {
        this.cbD = new ArrayList();
      }
      int j = this.cbD.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.cbD.get(i);
        if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
          this.cbD.remove(i);
        }
        if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
        {
          this.cbD.add(i, paramFullSpanItem);
          AppMethodBeat.o(195354);
          return;
        }
        i += 1;
      }
      this.cbD.add(paramFullSpanItem);
      AppMethodBeat.o(195354);
    }
    
    final void bK(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195340);
      if ((this.cbC == null) || (paramInt1 >= this.cbC.length))
      {
        AppMethodBeat.o(195340);
        return;
      }
      gx(paramInt1 + paramInt2);
      int[] arrayOfInt1 = this.cbC;
      int[] arrayOfInt2 = this.cbC;
      System.arraycopy(arrayOfInt1, paramInt1 + paramInt2, arrayOfInt2, paramInt1, arrayOfInt2.length - paramInt1 - paramInt2);
      Arrays.fill(this.cbC, this.cbC.length - paramInt2, this.cbC.length, -1);
      bL(paramInt1, paramInt2);
      AppMethodBeat.o(195340);
    }
    
    final void bM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195347);
      if ((this.cbC == null) || (paramInt1 >= this.cbC.length))
      {
        AppMethodBeat.o(195347);
        return;
      }
      gx(paramInt1 + paramInt2);
      int[] arrayOfInt = this.cbC;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + paramInt2, this.cbC.length - paramInt1 - paramInt2);
      Arrays.fill(this.cbC, paramInt1, paramInt1 + paramInt2, -1);
      bN(paramInt1, paramInt2);
      AppMethodBeat.o(195347);
    }
    
    final void clear()
    {
      AppMethodBeat.i(195332);
      if (this.cbC != null) {
        Arrays.fill(this.cbC, -1);
      }
      this.cbD = null;
      AppMethodBeat.o(195332);
    }
    
    final int gt(int paramInt)
    {
      AppMethodBeat.i(195310);
      if (this.cbD != null)
      {
        int i = this.cbD.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.cbD.get(i)).mPosition >= paramInt) {
            this.cbD.remove(i);
          }
          i -= 1;
        }
      }
      paramInt = gu(paramInt);
      AppMethodBeat.o(195310);
      return paramInt;
    }
    
    final int gu(int paramInt)
    {
      AppMethodBeat.i(195315);
      if (this.cbC == null)
      {
        AppMethodBeat.o(195315);
        return -1;
      }
      if (paramInt >= this.cbC.length)
      {
        AppMethodBeat.o(195315);
        return -1;
      }
      int i = gy(paramInt);
      if (i == -1)
      {
        int[] arrayOfInt = this.cbC;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        paramInt = this.cbC.length;
        AppMethodBeat.o(195315);
        return paramInt;
      }
      Arrays.fill(this.cbC, paramInt, i + 1, -1);
      AppMethodBeat.o(195315);
      return i + 1;
    }
    
    final int gv(int paramInt)
    {
      if ((this.cbC == null) || (paramInt >= this.cbC.length)) {
        return -1;
      }
      return this.cbC[paramInt];
    }
    
    public final FullSpanItem gz(int paramInt)
    {
      AppMethodBeat.i(195361);
      if (this.cbD == null)
      {
        AppMethodBeat.o(195361);
        return null;
      }
      int i = this.cbD.size() - 1;
      while (i >= 0)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.cbD.get(i);
        if (localFullSpanItem.mPosition == paramInt)
        {
          AppMethodBeat.o(195361);
          return localFullSpanItem;
        }
        i -= 1;
      }
      AppMethodBeat.o(195361);
      return null;
    }
    
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR;
      int cbE;
      int[] cbF;
      boolean cbG;
      int mPosition;
      
      static
      {
        AppMethodBeat.i(194633);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(194633);
      }
      
      FullSpanItem() {}
      
      FullSpanItem(Parcel paramParcel)
      {
        AppMethodBeat.i(194618);
        this.mPosition = paramParcel.readInt();
        this.cbE = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.cbG = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.cbF = new int[i];
            paramParcel.readIntArray(this.cbF);
          }
          AppMethodBeat.o(194618);
          return;
          bool = false;
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      final int gA(int paramInt)
      {
        if (this.cbF == null) {
          return 0;
        }
        return this.cbF[paramInt];
      }
      
      public String toString()
      {
        AppMethodBeat.i(194672);
        String str = "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.cbE + ", mHasUnwantedGapAfter=" + this.cbG + ", mGapPerSpan=" + Arrays.toString(this.cbF) + '}';
        AppMethodBeat.o(194672);
        return str;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(194665);
        paramParcel.writeInt(this.mPosition);
        paramParcel.writeInt(this.cbE);
        if (this.cbG) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.cbF == null) || (this.cbF.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.cbF.length);
          paramParcel.writeIntArray(this.cbF);
          AppMethodBeat.o(194665);
          return;
        }
        paramParcel.writeInt(0);
        AppMethodBeat.o(194665);
      }
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean bXA;
    int bXU;
    boolean bXW;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> cbD;
    int cbH;
    int cbI;
    int[] cbJ;
    int cbK;
    int[] cbL;
    boolean cbq;
    
    static
    {
      AppMethodBeat.i(195215);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195215);
    }
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(195202);
      this.bXU = paramParcel.readInt();
      this.cbH = paramParcel.readInt();
      this.cbI = paramParcel.readInt();
      if (this.cbI > 0)
      {
        this.cbJ = new int[this.cbI];
        paramParcel.readIntArray(this.cbJ);
      }
      this.cbK = paramParcel.readInt();
      if (this.cbK > 0)
      {
        this.cbL = new int[this.cbK];
        paramParcel.readIntArray(this.cbL);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.bXA = bool1;
        if (paramParcel.readInt() != 1) {
          break label162;
        }
        bool1 = true;
        label118:
        this.bXW = bool1;
        if (paramParcel.readInt() != 1) {
          break label167;
        }
      }
      label162:
      label167:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.cbq = bool1;
        this.cbD = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        AppMethodBeat.o(195202);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label118;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.cbI = paramSavedState.cbI;
      this.bXU = paramSavedState.bXU;
      this.cbH = paramSavedState.cbH;
      this.cbJ = paramSavedState.cbJ;
      this.cbK = paramSavedState.cbK;
      this.cbL = paramSavedState.cbL;
      this.bXA = paramSavedState.bXA;
      this.bXW = paramSavedState.bXW;
      this.cbq = paramSavedState.cbq;
      this.cbD = paramSavedState.cbD;
    }
    
    final void Li()
    {
      this.cbJ = null;
      this.cbI = 0;
      this.bXU = -1;
      this.cbH = -1;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(195229);
      paramParcel.writeInt(this.bXU);
      paramParcel.writeInt(this.cbH);
      paramParcel.writeInt(this.cbI);
      if (this.cbI > 0) {
        paramParcel.writeIntArray(this.cbJ);
      }
      paramParcel.writeInt(this.cbK);
      if (this.cbK > 0) {
        paramParcel.writeIntArray(this.cbL);
      }
      if (this.bXA)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.bXW) {
          break label130;
        }
        paramInt = 1;
        label92:
        paramParcel.writeInt(paramInt);
        if (!this.cbq) {
          break label135;
        }
      }
      label130:
      label135:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.cbD);
        AppMethodBeat.o(195229);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label92;
      }
    }
  }
  
  final class a
  {
    boolean Nl;
    int Sc;
    boolean bXM;
    boolean cby;
    int[] cbz;
    int mPosition;
    
    a()
    {
      AppMethodBeat.i(195074);
      reset();
      AppMethodBeat.o(195074);
    }
    
    final void reset()
    {
      AppMethodBeat.i(195082);
      this.mPosition = -1;
      this.Sc = -2147483648;
      this.bXM = false;
      this.cby = false;
      this.Nl = false;
      if (this.cbz != null) {
        Arrays.fill(this.cbz, -1);
      }
      AppMethodBeat.o(195082);
    }
  }
  
  final class b
  {
    ArrayList<View> cbM;
    int cbN;
    int cbO;
    int cbP;
    final int mIndex;
    
    b(int paramInt)
    {
      AppMethodBeat.i(195071);
      this.cbM = new ArrayList();
      this.cbN = -2147483648;
      this.cbO = -2147483648;
      this.cbP = 0;
      this.mIndex = paramInt;
      AppMethodBeat.o(195071);
    }
    
    private void Lj()
    {
      AppMethodBeat.i(195080);
      Object localObject = (View)this.cbM.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.cbN = StaggeredGridLayoutManager.this.cbi.bs((View)localObject);
      if (localLayoutParams.cbB)
      {
        localObject = StaggeredGridLayoutManager.this.cbn.gz(localLayoutParams.bXh.KI());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cbE == -1)) {
          this.cbN -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).gA(this.mIndex);
        }
      }
      AppMethodBeat.o(195080);
    }
    
    private void Ll()
    {
      AppMethodBeat.i(195087);
      Object localObject = (View)this.cbM.get(this.cbM.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.cbO = StaggeredGridLayoutManager.this.cbi.bt((View)localObject);
      if (localLayoutParams.cbB)
      {
        localObject = StaggeredGridLayoutManager.this.cbn.gz(localLayoutParams.bXh.KI());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).cbE == 1))
        {
          int i = this.cbO;
          this.cbO = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).gA(this.mIndex) + i);
        }
      }
      AppMethodBeat.o(195087);
    }
    
    private int a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(195100);
      int m = StaggeredGridLayoutManager.this.cbi.JE();
      int n = StaggeredGridLayoutManager.this.cbi.JF();
      int j;
      int k;
      if (paramInt2 > paramInt1)
      {
        j = 1;
        k = paramInt1;
      }
      while (k != paramInt2)
      {
        View localView = (View)this.cbM.get(k);
        int i1 = StaggeredGridLayoutManager.this.cbi.bs(localView);
        int i2 = StaggeredGridLayoutManager.this.cbi.bt(localView);
        label102:
        int i;
        if (paramBoolean3) {
          if (i1 <= n)
          {
            paramInt1 = 1;
            if (!paramBoolean3) {
              break label203;
            }
            if (i2 < m) {
              break label197;
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
                break label275;
              }
              paramInt1 = StaggeredGridLayoutManager.this.getPosition(localView);
              AppMethodBeat.o(195100);
              return paramInt1;
              j = -1;
              k = paramInt1;
              break;
              paramInt1 = 0;
              break label102;
              if (i1 < n)
              {
                paramInt1 = 1;
                break label102;
              }
              paramInt1 = 0;
              break label102;
              label197:
              i = 0;
              continue;
              label203:
              if (i2 > m)
              {
                i = 1;
                continue;
              }
              i = 0;
              continue;
            }
            if (paramBoolean2)
            {
              paramInt1 = StaggeredGridLayoutManager.this.getPosition(localView);
              AppMethodBeat.o(195100);
              return paramInt1;
            }
            if ((i1 < m) || (i2 > n))
            {
              paramInt1 = StaggeredGridLayoutManager.this.getPosition(localView);
              AppMethodBeat.o(195100);
              return paramInt1;
            }
          }
        }
        label275:
        k += j;
      }
      AppMethodBeat.o(195100);
      return -1;
    }
    
    private int bO(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195110);
      paramInt1 = a(paramInt1, paramInt2, false, false, true);
      AppMethodBeat.o(195110);
      return paramInt1;
    }
    
    private void co()
    {
      this.cbN = -2147483648;
      this.cbO = -2147483648;
    }
    
    final int Lk()
    {
      AppMethodBeat.i(195122);
      if (this.cbN != -2147483648)
      {
        i = this.cbN;
        AppMethodBeat.o(195122);
        return i;
      }
      Lj();
      int i = this.cbN;
      AppMethodBeat.o(195122);
      return i;
    }
    
    final int Lm()
    {
      AppMethodBeat.i(195135);
      if (this.cbO != -2147483648)
      {
        i = this.cbO;
        AppMethodBeat.o(195135);
        return i;
      }
      Ll();
      int i = this.cbO;
      AppMethodBeat.o(195135);
      return i;
    }
    
    final void Ln()
    {
      AppMethodBeat.i(195182);
      int i = this.cbM.size();
      View localView = (View)this.cbM.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.cbA = null;
      if ((localLayoutParams.bXh.isRemoved()) || (localLayoutParams.bXh.KW())) {
        this.cbP -= StaggeredGridLayoutManager.this.cbi.bw(localView);
      }
      if (i == 1) {
        this.cbN = -2147483648;
      }
      this.cbO = -2147483648;
      AppMethodBeat.o(195182);
    }
    
    final void Lo()
    {
      AppMethodBeat.i(195191);
      View localView = (View)this.cbM.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.cbA = null;
      if (this.cbM.size() == 0) {
        this.cbO = -2147483648;
      }
      if ((localLayoutParams.bXh.isRemoved()) || (localLayoutParams.bXh.KW())) {
        this.cbP -= StaggeredGridLayoutManager.this.cbi.bw(localView);
      }
      this.cbN = -2147483648;
      AppMethodBeat.o(195191);
    }
    
    public final int Lp()
    {
      AppMethodBeat.i(195200);
      if (StaggeredGridLayoutManager.this.bXA)
      {
        i = bO(this.cbM.size() - 1, -1);
        AppMethodBeat.o(195200);
        return i;
      }
      int i = bO(0, this.cbM.size());
      AppMethodBeat.o(195200);
      return i;
    }
    
    public final int Lq()
    {
      AppMethodBeat.i(195208);
      if (StaggeredGridLayoutManager.this.bXA)
      {
        i = bO(0, this.cbM.size());
        AppMethodBeat.o(195208);
        return i;
      }
      int i = bO(this.cbM.size() - 1, -1);
      AppMethodBeat.o(195208);
      return i;
    }
    
    final void bM(View paramView)
    {
      AppMethodBeat.i(195146);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.cbA = this;
      this.cbM.add(0, paramView);
      this.cbN = -2147483648;
      if (this.cbM.size() == 1) {
        this.cbO = -2147483648;
      }
      if ((localLayoutParams.bXh.isRemoved()) || (localLayoutParams.bXh.KW())) {
        this.cbP += StaggeredGridLayoutManager.this.cbi.bw(paramView);
      }
      AppMethodBeat.o(195146);
    }
    
    final void bN(View paramView)
    {
      AppMethodBeat.i(195155);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.cbA = this;
      this.cbM.add(paramView);
      this.cbO = -2147483648;
      if (this.cbM.size() == 1) {
        this.cbN = -2147483648;
      }
      if ((localLayoutParams.bXh.isRemoved()) || (localLayoutParams.bXh.KW())) {
        this.cbP += StaggeredGridLayoutManager.this.cbi.bw(paramView);
      }
      AppMethodBeat.o(195155);
    }
    
    public final View bP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195222);
      View localView2 = null;
      View localView1 = null;
      if (paramInt2 == -1)
      {
        int i = this.cbM.size();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView2 = (View)this.cbM.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.bXA) && (StaggeredGridLayoutManager.this.getPosition(localView2) <= paramInt1)) || ((!StaggeredGridLayoutManager.this.bXA) && (StaggeredGridLayoutManager.this.getPosition(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 += 1;
          localView1 = localView2;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(195222);
        return localView1;
        paramInt2 = this.cbM.size() - 1;
        for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
        {
          localView2 = (View)this.cbM.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.bXA) && (StaggeredGridLayoutManager.this.getPosition(localView2) >= paramInt1)) || ((!StaggeredGridLayoutManager.this.bXA) && (StaggeredGridLayoutManager.this.getPosition(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 -= 1;
        }
      }
    }
    
    final void clear()
    {
      AppMethodBeat.i(195165);
      this.cbM.clear();
      co();
      this.cbP = 0;
      AppMethodBeat.o(195165);
    }
    
    final int gB(int paramInt)
    {
      AppMethodBeat.i(195114);
      if (this.cbN != -2147483648)
      {
        paramInt = this.cbN;
        AppMethodBeat.o(195114);
        return paramInt;
      }
      if (this.cbM.size() == 0)
      {
        AppMethodBeat.o(195114);
        return paramInt;
      }
      Lj();
      paramInt = this.cbN;
      AppMethodBeat.o(195114);
      return paramInt;
    }
    
    final int gC(int paramInt)
    {
      AppMethodBeat.i(195128);
      if (this.cbO != -2147483648)
      {
        paramInt = this.cbO;
        AppMethodBeat.o(195128);
        return paramInt;
      }
      if (this.cbM.size() == 0)
      {
        AppMethodBeat.o(195128);
        return paramInt;
      }
      Ll();
      paramInt = this.cbO;
      AppMethodBeat.o(195128);
      return paramInt;
    }
    
    final void gD(int paramInt)
    {
      if (this.cbN != -2147483648) {
        this.cbN += paramInt;
      }
      if (this.cbO != -2147483648) {
        this.cbO += paramInt;
      }
    }
    
    final int h(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(195216);
      paramInt1 = a(paramInt1, paramInt2, paramBoolean, true, false);
      AppMethodBeat.o(195216);
      return paramInt1;
    }
    
    final void setLine(int paramInt)
    {
      this.cbN = paramInt;
      this.cbO = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */