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
  private final Rect Si;
  public int ahF;
  boolean aiV;
  boolean aiW;
  private boolean aiY;
  int aiZ;
  int aja;
  b[] amH;
  u amI;
  u amJ;
  private int amK;
  private final o amL;
  private BitSet amM;
  LazySpanLookup amN;
  private int amO;
  private boolean amP;
  private boolean amQ;
  private SavedState amR;
  private int amS;
  private final a amT;
  private boolean amU;
  private int[] amV;
  private final Runnable amW;
  public int mOrientation;
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262884);
    this.ahF = -1;
    this.aiV = false;
    this.aiW = false;
    this.aiZ = -1;
    this.aja = -2147483648;
    this.amN = new LazySpanLookup();
    this.amO = 2;
    this.Si = new Rect();
    this.amT = new a();
    this.amU = false;
    this.aiY = true;
    this.amW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262785);
        StaggeredGridLayoutManager.this.mx();
        AppMethodBeat.o(262785);
      }
    };
    this.mOrientation = 1;
    cw(paramInt1);
    this.amL = new o();
    mw();
    AppMethodBeat.o(262884);
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262883);
    this.ahF = -1;
    this.aiV = false;
    this.aiW = false;
    this.aiZ = -1;
    this.aja = -2147483648;
    this.amN = new LazySpanLookup();
    this.amO = 2;
    this.Si = new Rect();
    this.amT = new a();
    this.amU = false;
    this.aiY = true;
    this.amW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262785);
        StaggeredGridLayoutManager.this.mx();
        AppMethodBeat.o(262785);
      }
    };
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = paramContext.FO;
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      paramContext = new IllegalArgumentException("invalid orientation.");
      AppMethodBeat.o(262883);
      throw paramContext;
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt1 != this.mOrientation)
    {
      this.mOrientation = paramInt1;
      paramAttributeSet = this.amI;
      this.amI = this.amJ;
      this.amJ = paramAttributeSet;
      requestLayout();
    }
    cw(paramContext.spanCount);
    aq(paramContext.aln);
    this.amL = new o();
    mw();
    AppMethodBeat.o(262883);
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(262984);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(262984);
      return 0;
    }
    b(paramInt, params);
    int j = a(paramn, this.amL, params);
    int i = paramInt;
    if (this.amL.aiL >= j) {
      if (paramInt >= 0) {
        break label108;
      }
    }
    label108:
    for (i = -j;; i = j)
    {
      this.amI.cG(-i);
      this.amP = this.aiW;
      this.amL.aiL = 0;
      a(paramn, this.amL);
      AppMethodBeat.o(262984);
      return i;
    }
  }
  
  private int a(RecyclerView.n paramn, o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(262949);
    this.amM.set(0, this.ahF, true);
    int i;
    int m;
    label66:
    int j;
    label69:
    View localView;
    LayoutParams localLayoutParams;
    int i2;
    int i1;
    label144:
    b localb;
    label165:
    label176:
    label197:
    label229:
    int n;
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int k;
    if (this.amL.aiR) {
      if (paramo.mLayoutDirection == 1)
      {
        i = 2147483647;
        aP(paramo.mLayoutDirection, i);
        if (!this.aiW) {
          break label558;
        }
        m = this.amI.kU();
        j = 0;
        if ((!paramo.a(params)) || ((!this.amL.aiR) && (this.amM.isEmpty()))) {
          break label875;
        }
        localView = paramo.a(paramn);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.aiC.mc();
        j = this.amN.dl(i2);
        if (j != -1) {
          break label570;
        }
        i1 = 1;
        if (i1 == 0) {
          break label586;
        }
        if (!localLayoutParams.anb) {
          break label576;
        }
        localb = this.amH[0];
        this.amN.a(i2, localb);
        localLayoutParams.ana = localb;
        if (paramo.mLayoutDirection != 1) {
          break label598;
        }
        addView(localView);
        a(localView, localLayoutParams);
        if (paramo.mLayoutDirection != 1) {
          break label620;
        }
        if (!localLayoutParams.anb) {
          break label608;
        }
        j = df(m);
        n = j + this.amI.bd(localView);
        if ((i1 == 0) || (!localLayoutParams.anb)) {
          break label980;
        }
        localFullSpanItem = db(j);
        localFullSpanItem.anf = -1;
        localFullSpanItem.mPosition = i2;
        this.amN.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.anb) && (paramo.aiN == -1))
      {
        if (i1 == 0)
        {
          if (paramo.mLayoutDirection != 1) {
            break label718;
          }
          if (mB()) {
            break label712;
          }
          j = 1;
          label329:
          if (j == 0) {
            break label361;
          }
          localFullSpanItem = this.amN.dp(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.anh = true;
          }
        }
        this.amU = true;
      }
      label361:
      a(localView, localLayoutParams, paramo);
      if ((kp()) && (this.mOrientation == 1)) {
        if (localLayoutParams.anb)
        {
          j = this.amJ.kU();
          label402:
          i2 = j - this.amJ.bd(localView);
          i1 = j;
          j = i2;
          if (this.mOrientation != 1) {
            break label824;
          }
          layoutDecoratedWithMargins(localView, j, k, i1, n);
          label446:
          if (!localLayoutParams.anb) {
            break label841;
          }
          aP(this.amL.mLayoutDirection, i);
          label467:
          a(paramn, this.amL);
          if ((this.amL.aiQ) && (localView.hasFocusable()))
          {
            if (!localLayoutParams.anb) {
              break label859;
            }
            this.amM.clear();
          }
        }
      }
      for (;;)
      {
        j = 1;
        break label69;
        i = -2147483648;
        break;
        if (paramo.mLayoutDirection == 1)
        {
          i = paramo.aiP + paramo.aiL;
          break;
        }
        i = paramo.aiO - paramo.aiL;
        break;
        label558:
        m = this.amI.kT();
        break label66;
        label570:
        i1 = 0;
        break label144;
        label576:
        localb = a(paramo);
        break label165;
        label586:
        localb = this.amH[j];
        break label176;
        label598:
        addView(localView, 0);
        break label197;
        label608:
        j = localb.ds(m);
        break label229;
        label620:
        if (localLayoutParams.anb) {}
        for (j = de(m);; j = localb.dr(m))
        {
          k = j - this.amI.bd(localView);
          if ((i1 != 0) && (localLayoutParams.anb))
          {
            localFullSpanItem = dc(j);
            localFullSpanItem.anf = 1;
            localFullSpanItem.mPosition = i2;
            this.amN.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        label712:
        j = 0;
        break label329;
        label718:
        if (!mC())
        {
          j = 1;
          break label329;
        }
        j = 0;
        break label329;
        j = this.amJ.kU() - (this.ahF - 1 - localb.mIndex) * this.amK;
        break label402;
        if (localLayoutParams.anb) {}
        for (j = this.amJ.kT();; j = localb.mIndex * this.amK + this.amJ.kT())
        {
          i1 = j + this.amJ.bd(localView);
          break;
        }
        label824:
        layoutDecoratedWithMargins(localView, k, j, n, i1);
        break label446;
        label841:
        a(localb, this.amL.mLayoutDirection, i);
        break label467;
        label859:
        this.amM.set(localb.mIndex, false);
      }
      label875:
      if (j == 0) {
        a(paramn, this.amL);
      }
      if (this.amL.mLayoutDirection == -1) {
        i = de(this.amI.kT());
      }
      for (i = this.amI.kT() - i; i > 0; i = df(this.amI.kU()) - this.amI.kU())
      {
        i = Math.min(paramo.aiL, i);
        AppMethodBeat.o(262949);
        return i;
      }
      AppMethodBeat.o(262949);
      return 0;
      label980:
      k = j;
    }
  }
  
  private b a(o paramo)
  {
    Object localObject = null;
    b localb = null;
    AppMethodBeat.i(262973);
    int i;
    int j;
    int k;
    int n;
    int i1;
    int m;
    if (dh(paramo.mLayoutDirection))
    {
      i = this.ahF - 1;
      j = -1;
      k = -1;
      if (paramo.mLayoutDirection != 1) {
        break label132;
      }
      n = 2147483647;
      i1 = this.amI.kT();
      m = i;
      paramo = localb;
      i = n;
      label65:
      if (m == k) {
        break label124;
      }
      localb = this.amH[m];
      n = localb.ds(i1);
      if (n >= i) {
        break label211;
      }
      paramo = localb;
      i = n;
    }
    label132:
    label208:
    label211:
    for (;;)
    {
      m += j;
      break label65;
      i = 0;
      k = this.ahF;
      j = 1;
      break;
      label124:
      AppMethodBeat.o(262973);
      return paramo;
      n = -2147483648;
      i1 = this.amI.kU();
      m = i;
      paramo = localObject;
      i = n;
      if (m != k)
      {
        localb = this.amH[m];
        n = localb.dr(i1);
        if (n <= i) {
          break label208;
        }
        paramo = localb;
        i = n;
      }
      for (;;)
      {
        m += j;
        break;
        AppMethodBeat.o(262973);
        return paramo;
      }
    }
  }
  
  private void a(int paramInt, RecyclerView.s params)
  {
    boolean bool2 = false;
    AppMethodBeat.i(262939);
    this.amL.aiL = 0;
    this.amL.aiM = paramInt;
    int i;
    boolean bool1;
    if (isSmoothScrolling())
    {
      i = params.alG;
      if (i != -1)
      {
        boolean bool3 = this.aiW;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label183;
          }
          paramInt = this.amI.kV();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label73:
      if (getClipToPadding())
      {
        this.amL.aiO = (this.amI.kT() - i);
        this.amL.aiP = (paramInt + this.amI.kU());
      }
      for (;;)
      {
        this.amL.aiQ = false;
        this.amL.aiK = true;
        params = this.amL;
        bool1 = bool2;
        if (this.amI.getMode() == 0)
        {
          bool1 = bool2;
          if (this.amI.getEnd() == 0) {
            bool1 = true;
          }
        }
        params.aiR = bool1;
        AppMethodBeat.o(262939);
        return;
        bool1 = false;
        break;
        label183:
        i = this.amI.kV();
        paramInt = 0;
        break label73;
        this.amL.aiP = (paramInt + this.amI.getEnd());
        this.amL.aiO = (-i);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(262920);
    if (paramLayoutParams.anb)
    {
      if (this.mOrientation == 1)
      {
        i(paramView, this.amS, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
        AppMethodBeat.o(262920);
        return;
      }
      i(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.amS);
      AppMethodBeat.o(262920);
      return;
    }
    if (this.mOrientation == 1)
    {
      i(paramView, getChildMeasureSpec(this.amK, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true));
      AppMethodBeat.o(262920);
      return;
    }
    i(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), getChildMeasureSpec(this.amK, getHeightMode(), 0, paramLayoutParams.height, false));
    AppMethodBeat.o(262920);
  }
  
  private void a(View paramView, LayoutParams paramLayoutParams, o paramo)
  {
    AppMethodBeat.i(262953);
    if (paramo.mLayoutDirection == 1)
    {
      if (paramLayoutParams.anb)
      {
        br(paramView);
        AppMethodBeat.o(262953);
        return;
      }
      paramLayoutParams.ana.bu(paramView);
      AppMethodBeat.o(262953);
      return;
    }
    if (paramLayoutParams.anb)
    {
      bs(paramView);
      AppMethodBeat.o(262953);
      return;
    }
    paramLayoutParams.ana.bt(paramView);
    AppMethodBeat.o(262953);
  }
  
  private void a(RecyclerView.n paramn, int paramInt)
  {
    AppMethodBeat.i(262969);
    while (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      if ((this.amI.ba(localView) <= paramInt) && (this.amI.bb(localView) <= paramInt))
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.anb)
        {
          int i = 0;
          while (i < this.ahF)
          {
            if (this.amH[i].ann.size() == 1)
            {
              AppMethodBeat.o(262969);
              return;
            }
            i += 1;
          }
          i = 0;
          while (i < this.ahF)
          {
            this.amH[i].mM();
            i += 1;
          }
        }
        if (localLayoutParams.ana.ann.size() == 1)
        {
          AppMethodBeat.o(262969);
          return;
        }
        localLayoutParams.ana.mM();
        removeAndRecycleView(localView, paramn);
      }
      else
      {
        AppMethodBeat.o(262969);
        return;
      }
    }
    AppMethodBeat.o(262969);
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(262935);
    int i = df(-2147483648);
    if (i == -2147483648)
    {
      AppMethodBeat.o(262935);
      return;
    }
    i = this.amI.kU() - i;
    if (i > 0)
    {
      i -= -a(-i, paramn, params);
      if ((paramBoolean) && (i > 0)) {
        this.amI.cG(i);
      }
      AppMethodBeat.o(262935);
      return;
    }
    AppMethodBeat.o(262935);
  }
  
  private void a(RecyclerView.n paramn, o paramo)
  {
    AppMethodBeat.i(262954);
    if ((!paramo.aiK) || (paramo.aiR))
    {
      AppMethodBeat.o(262954);
      return;
    }
    if (paramo.aiL == 0)
    {
      if (paramo.mLayoutDirection == -1)
      {
        b(paramn, paramo.aiP);
        AppMethodBeat.o(262954);
        return;
      }
      a(paramn, paramo.aiO);
      AppMethodBeat.o(262954);
      return;
    }
    if (paramo.mLayoutDirection == -1)
    {
      i = paramo.aiO - dd(paramo.aiO);
      if (i < 0) {}
      for (i = paramo.aiP;; i = paramo.aiP - Math.min(i, paramo.aiL))
      {
        b(paramn, i);
        AppMethodBeat.o(262954);
        return;
      }
    }
    int i = dg(paramo.aiP) - paramo.aiP;
    if (i < 0) {}
    int j;
    for (i = paramo.aiO;; i = Math.min(i, paramo.aiL) + j)
    {
      a(paramn, i);
      AppMethodBeat.o(262954);
      return;
      j = paramo.aiO;
    }
  }
  
  private void a(b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262958);
    int i = paramb.anq;
    if (paramInt1 == -1)
    {
      if (i + paramb.mI() <= paramInt2) {
        this.amM.set(paramb.mIndex, false);
      }
      AppMethodBeat.o(262958);
      return;
    }
    if (paramb.mK() - i >= paramInt2) {
      this.amM.set(paramb.mIndex, false);
    }
    AppMethodBeat.o(262958);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(262891);
    if (this.aiW)
    {
      if (paramb.mK() < this.amI.kU())
      {
        if (!((LayoutParams)((View)paramb.ann.get(paramb.ann.size() - 1)).getLayoutParams()).anb)
        {
          AppMethodBeat.o(262891);
          return true;
        }
        AppMethodBeat.o(262891);
        return false;
      }
    }
    else if (paramb.mI() > this.amI.kT())
    {
      if (!((LayoutParams)((View)paramb.ann.get(0)).getLayoutParams()).anb)
      {
        AppMethodBeat.o(262891);
        return true;
      }
      AppMethodBeat.o(262891);
      return false;
    }
    AppMethodBeat.o(262891);
    return false;
  }
  
  private void aP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262957);
    int i = 0;
    while (i < this.ahF)
    {
      if (!this.amH[i].ann.isEmpty()) {
        a(this.amH[i], paramInt1, paramInt2);
      }
      i += 1;
    }
    AppMethodBeat.o(262957);
  }
  
  private void aq(boolean paramBoolean)
  {
    AppMethodBeat.i(262893);
    assertNotInLayoutOrScroll(null);
    if ((this.amR != null) && (this.amR.aiV != paramBoolean)) {
      this.amR.aiV = paramBoolean;
    }
    this.aiV = paramBoolean;
    requestLayout();
    AppMethodBeat.o(262893);
  }
  
  private View ay(boolean paramBoolean)
  {
    AppMethodBeat.i(262932);
    int j = this.amI.kT();
    int k = this.amI.kU();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.amI.aZ(localView);
      if ((this.amI.ba(localView) <= j) || (n >= k)) {
        break label122;
      }
      if ((n >= j) || (!paramBoolean))
      {
        AppMethodBeat.o(262932);
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
      AppMethodBeat.o(262932);
      return localObject;
    }
  }
  
  private View az(boolean paramBoolean)
  {
    AppMethodBeat.i(262933);
    int j = this.amI.kT();
    int k = this.amI.kU();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.amI.aZ(localView);
      int n = this.amI.ba(localView);
      if ((n <= j) || (m >= k)) {
        break label124;
      }
      if ((n <= k) || (!paramBoolean))
      {
        AppMethodBeat.o(262933);
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
      AppMethodBeat.o(262933);
      return localObject;
    }
  }
  
  private void b(int paramInt, RecyclerView.s params)
  {
    AppMethodBeat.i(262983);
    int i;
    int j;
    if (paramInt > 0)
    {
      i = mD();
      j = 1;
    }
    for (;;)
    {
      this.amL.aiK = true;
      a(i, params);
      da(j);
      params = this.amL;
      params.aiM = (i + params.aiN);
      this.amL.aiL = Math.abs(paramInt);
      AppMethodBeat.o(262983);
      return;
      j = -1;
      i = mE();
    }
  }
  
  private void b(RecyclerView.n paramn, int paramInt)
  {
    AppMethodBeat.i(262970);
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if ((this.amI.aZ(localView) >= paramInt) && (this.amI.bc(localView) >= paramInt))
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.anb)
        {
          int j = 0;
          while (j < this.ahF)
          {
            if (this.amH[j].ann.size() == 1)
            {
              AppMethodBeat.o(262970);
              return;
            }
            j += 1;
          }
          j = 0;
          while (j < this.ahF)
          {
            this.amH[j].mL();
            j += 1;
          }
        }
        if (localLayoutParams.ana.ann.size() == 1)
        {
          AppMethodBeat.o(262970);
          return;
        }
        localLayoutParams.ana.mL();
        removeAndRecycleView(localView, paramn);
        i -= 1;
      }
      else
      {
        AppMethodBeat.o(262970);
        return;
      }
    }
    AppMethodBeat.o(262970);
  }
  
  private void b(RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(262936);
    int i = de(2147483647);
    if (i == 2147483647)
    {
      AppMethodBeat.o(262936);
      return;
    }
    i -= this.amI.kT();
    if (i > 0)
    {
      i -= a(i, paramn, params);
      if ((paramBoolean) && (i > 0)) {
        this.amI.cG(-i);
      }
      AppMethodBeat.o(262936);
      return;
    }
    AppMethodBeat.o(262936);
  }
  
  private void br(View paramView)
  {
    AppMethodBeat.i(262955);
    int i = this.ahF - 1;
    while (i >= 0)
    {
      this.amH[i].bu(paramView);
      i -= 1;
    }
    AppMethodBeat.o(262955);
  }
  
  private void bs(View paramView)
  {
    AppMethodBeat.i(262956);
    int i = this.ahF - 1;
    while (i >= 0)
    {
      this.amH[i].bt(paramView);
      i -= 1;
    }
    AppMethodBeat.o(262956);
  }
  
  private int c(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(262911);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(262911);
      return 0;
    }
    u localu = this.amI;
    View localView;
    if (!this.aiY)
    {
      bool1 = true;
      localView = ay(bool1);
      if (this.aiY) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = x.a(params, localu, localView, az(bool1), this, this.aiY, this.aiW);
      AppMethodBeat.o(262911);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private void cZ(int paramInt)
  {
    AppMethodBeat.i(262901);
    this.amK = (paramInt / this.ahF);
    this.amS = View.MeasureSpec.makeMeasureSpec(paramInt, this.amJ.getMode());
    AppMethodBeat.o(262901);
  }
  
  private void cw(int paramInt)
  {
    AppMethodBeat.i(262892);
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.ahF)
    {
      this.amN.clear();
      requestLayout();
      this.ahF = paramInt;
      this.amM = new BitSet(this.ahF);
      this.amH = new b[this.ahF];
      paramInt = 0;
      while (paramInt < this.ahF)
      {
        this.amH[paramInt] = new b(paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
    AppMethodBeat.o(262892);
  }
  
  private int d(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(262914);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(262914);
      return 0;
    }
    u localu = this.amI;
    View localView;
    if (!this.aiY)
    {
      bool1 = true;
      localView = ay(bool1);
      if (this.aiY) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = x.a(params, localu, localView, az(bool1), this, this.aiY);
      AppMethodBeat.o(262914);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private void da(int paramInt)
  {
    int i = 1;
    this.amL.mLayoutDirection = paramInt;
    o localo = this.amL;
    boolean bool2 = this.aiW;
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
      localo.aiN = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem db(int paramInt)
  {
    AppMethodBeat.i(262950);
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.ang = new int[this.ahF];
    int i = 0;
    while (i < this.ahF)
    {
      localFullSpanItem.ang[i] = (paramInt - this.amH[i].ds(paramInt));
      i += 1;
    }
    AppMethodBeat.o(262950);
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem dc(int paramInt)
  {
    AppMethodBeat.i(262952);
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.ang = new int[this.ahF];
    int i = 0;
    while (i < this.ahF)
    {
      localFullSpanItem.ang[i] = (this.amH[i].dr(paramInt) - paramInt);
      i += 1;
    }
    AppMethodBeat.o(262952);
    return localFullSpanItem;
  }
  
  private int dd(int paramInt)
  {
    AppMethodBeat.i(262959);
    int j = this.amH[0].dr(paramInt);
    int i = 1;
    while (i < this.ahF)
    {
      int m = this.amH[i].dr(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(262959);
    return j;
  }
  
  private int de(int paramInt)
  {
    AppMethodBeat.i(262960);
    int j = this.amH[0].dr(paramInt);
    int i = 1;
    while (i < this.ahF)
    {
      int m = this.amH[i].dr(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(262960);
    return j;
  }
  
  private int df(int paramInt)
  {
    AppMethodBeat.i(262966);
    int j = this.amH[0].ds(paramInt);
    int i = 1;
    while (i < this.ahF)
    {
      int m = this.amH[i].ds(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(262966);
    return j;
  }
  
  private int dg(int paramInt)
  {
    AppMethodBeat.i(262967);
    int j = this.amH[0].ds(paramInt);
    int i = 1;
    while (i < this.ahF)
    {
      int m = this.amH[i].ds(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(262967);
    return j;
  }
  
  private boolean dh(int paramInt)
  {
    AppMethodBeat.i(262971);
    if (this.mOrientation == 0)
    {
      if (paramInt == -1) {}
      for (i = 1; i != this.aiW; i = 0)
      {
        AppMethodBeat.o(262971);
        return true;
      }
      AppMethodBeat.o(262971);
      return false;
    }
    if (paramInt == -1)
    {
      i = 1;
      if (i != this.aiW) {
        break label87;
      }
    }
    label87:
    for (int i = 1;; i = 0)
    {
      if (i != kp()) {
        break label92;
      }
      AppMethodBeat.o(262971);
      return true;
      i = 0;
      break;
    }
    label92:
    AppMethodBeat.o(262971);
    return false;
  }
  
  private int di(int paramInt)
  {
    AppMethodBeat.i(262977);
    if (getChildCount() == 0)
    {
      if (this.aiW)
      {
        AppMethodBeat.o(262977);
        return 1;
      }
      AppMethodBeat.o(262977);
      return -1;
    }
    if (paramInt < mE()) {}
    for (int i = 1; i != this.aiW; i = 0)
    {
      AppMethodBeat.o(262977);
      return -1;
    }
    AppMethodBeat.o(262977);
    return 1;
  }
  
  private int e(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(262917);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(262917);
      return 0;
    }
    u localu = this.amI;
    View localView;
    if (!this.aiY)
    {
      bool1 = true;
      localView = ay(bool1);
      if (this.aiY) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = x.b(params, localu, localView, az(bool1), this, this.aiY);
      AppMethodBeat.o(262917);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private void i(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262921);
    calculateItemDecorationsForChild(paramView, this.Si);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = j(paramInt1, localLayoutParams.leftMargin + this.Si.left, localLayoutParams.rightMargin + this.Si.right);
    paramInt2 = j(paramInt2, localLayoutParams.topMargin + this.Si.top, localLayoutParams.bottomMargin + this.Si.bottom);
    if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(262921);
  }
  
  private static int j(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(262922);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      AppMethodBeat.o(262922);
      return paramInt1;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i == -2147483648) || (i == 1073741824))
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
      AppMethodBeat.o(262922);
      return paramInt1;
    }
    AppMethodBeat.o(262922);
    return paramInt1;
  }
  
  private void k(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(262948);
    int k;
    int j;
    int i;
    if (this.aiW)
    {
      k = mD();
      if (paramInt3 != 8) {
        break label118;
      }
      if (paramInt1 >= paramInt2) {
        break label107;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label38:
      this.amN.dk(i);
      switch (paramInt3)
      {
      }
    }
    for (;;)
    {
      if (j > k) {
        break label174;
      }
      AppMethodBeat.o(262948);
      return;
      k = mE();
      break;
      label107:
      j = paramInt1 + 1;
      i = paramInt2;
      break label38;
      label118:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label38;
      this.amN.aS(paramInt1, paramInt2);
      continue;
      this.amN.aQ(paramInt1, paramInt2);
      continue;
      this.amN.aQ(paramInt1, 1);
      this.amN.aS(paramInt2, 1);
    }
    label174:
    if (this.aiW) {}
    for (paramInt1 = mE();; paramInt1 = mD())
    {
      if (i <= paramInt1) {
        requestLayout();
      }
      AppMethodBeat.o(262948);
      return;
    }
  }
  
  private void kC()
  {
    boolean bool = true;
    AppMethodBeat.i(262895);
    if ((this.mOrientation == 1) || (!kp())) {
      bool = this.aiV;
    }
    for (;;)
    {
      this.aiW = bool;
      AppMethodBeat.o(262895);
      return;
      if (this.aiV) {
        bool = false;
      }
    }
  }
  
  private boolean kp()
  {
    AppMethodBeat.i(262896);
    if (getLayoutDirection() == 1)
    {
      AppMethodBeat.o(262896);
      return true;
    }
    AppMethodBeat.o(262896);
    return false;
  }
  
  private boolean mB()
  {
    AppMethodBeat.i(262962);
    int j = this.amH[0].ds(-2147483648);
    int i = 1;
    while (i < this.ahF)
    {
      if (this.amH[i].ds(-2147483648) != j)
      {
        AppMethodBeat.o(262962);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(262962);
    return true;
  }
  
  private boolean mC()
  {
    AppMethodBeat.i(262965);
    int j = this.amH[0].dr(-2147483648);
    int i = 1;
    while (i < this.ahF)
    {
      if (this.amH[i].dr(-2147483648) != j)
      {
        AppMethodBeat.o(262965);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(262965);
    return true;
  }
  
  private int mD()
  {
    AppMethodBeat.i(262986);
    int i = getChildCount();
    if (i == 0)
    {
      AppMethodBeat.o(262986);
      return 0;
    }
    i = getPosition(getChildAt(i - 1));
    AppMethodBeat.o(262986);
    return i;
  }
  
  private int mE()
  {
    AppMethodBeat.i(262988);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(262988);
      return 0;
    }
    int i = getPosition(getChildAt(0));
    AppMethodBeat.o(262988);
    return i;
  }
  
  private void mw()
  {
    AppMethodBeat.i(262886);
    this.amI = u.a(this, this.mOrientation);
    this.amJ = u.a(this, 1 - this.mOrientation);
    AppMethodBeat.o(262886);
  }
  
  private View my()
  {
    AppMethodBeat.i(262890);
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.ahF);
    localBitSet.set(0, this.ahF, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (kp()))
    {
      j = 1;
      if (!this.aiW) {
        break label140;
      }
      k = -1;
      label63:
      if (i >= k) {
        break label155;
      }
    }
    int n;
    View localView;
    LayoutParams localLayoutParams;
    label140:
    label155:
    for (int m = 1;; m = -1)
    {
      n = i;
      if (n == k) {
        break label379;
      }
      localView = getChildAt(n);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.ana.mIndex)) {
        break label174;
      }
      if (!a(localLayoutParams.ana)) {
        break label161;
      }
      AppMethodBeat.o(262890);
      return localView;
      j = -1;
      break;
      k = 0;
      m = i + 1;
      i = k;
      k = m;
      break label63;
    }
    label161:
    localBitSet.clear(localLayoutParams.ana.mIndex);
    label174:
    Object localObject;
    int i1;
    if ((!localLayoutParams.anb) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.aiW)
      {
        i = this.amI.ba(localView);
        i1 = this.amI.ba((View)localObject);
        if (i < i1)
        {
          AppMethodBeat.o(262890);
          return localView;
        }
        if (i != i1) {
          break label387;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.ana.mIndex - ((LayoutParams)localObject).ana.mIndex < 0)
        {
          i = 1;
          label289:
          if (j >= 0) {
            break label363;
          }
        }
        label363:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label369;
          }
          AppMethodBeat.o(262890);
          return localView;
          i = this.amI.aZ(localView);
          i1 = this.amI.aZ((View)localObject);
          if (i > i1)
          {
            AppMethodBeat.o(262890);
            return localView;
          }
          if (i != i1) {
            break label387;
          }
          i = 1;
          break;
          i = 0;
          break label289;
        }
      }
      label369:
      n += m;
      break;
      label379:
      AppMethodBeat.o(262890);
      return null;
      label387:
      i = 0;
    }
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(262894);
    if (this.amR == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
    AppMethodBeat.o(262894);
  }
  
  public void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262981);
    if (this.amR != null) {
      this.amR.mG();
    }
    this.aiZ = paramInt1;
    this.aja = paramInt2;
    requestLayout();
    AppMethodBeat.o(262981);
  }
  
  public final PointF cB(int paramInt)
  {
    AppMethodBeat.i(262978);
    paramInt = di(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0)
    {
      AppMethodBeat.o(262978);
      return null;
    }
    if (this.mOrientation == 0) {
      localPointF.x = paramInt;
    }
    for (localPointF.y = 0.0F;; localPointF.y = paramInt)
    {
      AppMethodBeat.o(262978);
      return localPointF;
      localPointF.x = 0.0F;
    }
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
    AppMethodBeat.i(262982);
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      AppMethodBeat.o(262982);
      return;
      paramInt1 = paramInt2;
    }
    b(paramInt1, params);
    if ((this.amV == null) || (this.amV.length < this.ahF)) {
      this.amV = new int[this.ahF];
    }
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt2 < this.ahF)
    {
      if (this.amL.aiN == -1) {}
      for (int j = this.amL.aiO - this.amH[paramInt2].dr(this.amL.aiO);; j = this.amH[paramInt2].ds(this.amL.aiP) - this.amL.aiP)
      {
        int i = paramInt1;
        if (j >= 0)
        {
          this.amV[paramInt1] = j;
          i = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = i;
        break;
      }
    }
    Arrays.sort(this.amV, 0, paramInt1);
    paramInt2 = k;
    while ((paramInt2 < paramInt1) && (this.amL.a(params)))
    {
      parama.ak(this.amL.aiM, this.amV[paramInt2]);
      o localo = this.amL;
      localo.aiM += this.amL.aiN;
      paramInt2 += 1;
    }
    AppMethodBeat.o(262982);
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(262913);
    int i = d(params);
    AppMethodBeat.o(262913);
    return i;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(262910);
    int i = c(params);
    AppMethodBeat.o(262910);
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(262916);
    int i = e(params);
    AppMethodBeat.o(262916);
    return i;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(262915);
    int i = d(params);
    AppMethodBeat.o(262915);
    return i;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(262912);
    int i = c(params);
    AppMethodBeat.o(262912);
    return i;
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(262919);
    int i = e(params);
    AppMethodBeat.o(262919);
    return i;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(262991);
    if (this.mOrientation == 0)
    {
      localLayoutParams = new LayoutParams(-2, -1);
      AppMethodBeat.o(262991);
      return localLayoutParams;
    }
    LayoutParams localLayoutParams = new LayoutParams(-1, -2);
    AppMethodBeat.o(262991);
    return localLayoutParams;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(262993);
    paramContext = new LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(262993);
    return paramContext;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(262994);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(262994);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(262994);
    return paramLayoutParams;
  }
  
  public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(262931);
    if (this.mOrientation == 1)
    {
      i = this.ahF;
      AppMethodBeat.o(262931);
      return i;
    }
    int i = super.getColumnCountForAccessibility(paramn, params);
    AppMethodBeat.o(262931);
    return i;
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(262929);
    if (this.mOrientation == 0)
    {
      i = this.ahF;
      AppMethodBeat.o(262929);
      return i;
    }
    int i = super.getRowCountForAccessibility(paramn, params);
    AppMethodBeat.o(262929);
    return i;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return this.amO != 0;
  }
  
  public final int[] k(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(262903);
    int[] arrayOfInt;
    int i;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = new int[this.ahF];
      i = 0;
      label20:
      if (i >= this.ahF) {
        break label149;
      }
      paramArrayOfInt = this.amH[i];
      if (!paramArrayOfInt.amX.aiV) {
        break label132;
      }
    }
    label132:
    for (int j = paramArrayOfInt.f(paramArrayOfInt.ann.size() - 1, -1, false);; j = paramArrayOfInt.f(0, paramArrayOfInt.ann.size(), false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label20;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.ahF) {
        break;
      }
      paramArrayOfInt = new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.ahF + ", array size:" + paramArrayOfInt.length);
      AppMethodBeat.o(262903);
      throw paramArrayOfInt;
    }
    label149:
    AppMethodBeat.o(262903);
    return arrayOfInt;
  }
  
  public final int ku()
  {
    return this.ahF;
  }
  
  public final int[] l(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(262907);
    int[] arrayOfInt;
    int i;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = new int[this.ahF];
      i = 0;
      label20:
      if (i >= this.ahF) {
        break label149;
      }
      paramArrayOfInt = this.amH[i];
      if (!paramArrayOfInt.amX.aiV) {
        break label130;
      }
    }
    label130:
    for (int j = paramArrayOfInt.f(0, paramArrayOfInt.ann.size(), false);; j = paramArrayOfInt.f(paramArrayOfInt.ann.size() - 1, -1, false))
    {
      arrayOfInt[i] = j;
      i += 1;
      break label20;
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length >= this.ahF) {
        break;
      }
      paramArrayOfInt = new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.ahF + ", array size:" + paramArrayOfInt.length);
      AppMethodBeat.o(262907);
      throw paramArrayOfInt;
    }
    label149:
    AppMethodBeat.o(262907);
    return arrayOfInt;
  }
  
  public final int[] mA()
  {
    AppMethodBeat.i(262909);
    int[] arrayOfInt = new int[this.ahF];
    int i = 0;
    if (i < this.ahF)
    {
      b localb = this.amH[i];
      if (localb.amX.aiV) {}
      for (int j = localb.f(0, localb.ann.size(), true);; j = localb.f(localb.ann.size() - 1, -1, true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(262909);
    return arrayOfInt;
  }
  
  final boolean mx()
  {
    AppMethodBeat.i(262887);
    if ((getChildCount() == 0) || (this.amO == 0) || (!isAttachedToWindow()))
    {
      AppMethodBeat.o(262887);
      return false;
    }
    int j;
    if (this.aiW) {
      j = mD();
    }
    for (int i = mE(); (j == 0) && (my() != null); i = mD())
    {
      this.amN.clear();
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      AppMethodBeat.o(262887);
      return true;
      j = mE();
    }
    if (!this.amU)
    {
      AppMethodBeat.o(262887);
      return false;
    }
    if (this.aiW) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.amN.l(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.amU = false;
      this.amN.dj(i + 1);
      AppMethodBeat.o(262887);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.amN.l(j, localFullSpanItem1.mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      this.amN.dj(localFullSpanItem1.mPosition);
    }
    for (;;)
    {
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      AppMethodBeat.o(262887);
      return true;
      this.amN.dj(localFullSpanItem2.mPosition + 1);
    }
  }
  
  public final int[] mz()
  {
    AppMethodBeat.i(262905);
    int[] arrayOfInt = new int[this.ahF];
    int i = 0;
    if (i < this.ahF)
    {
      b localb = this.amH[i];
      if (localb.amX.aiV) {}
      for (int j = localb.f(localb.ann.size() - 1, -1, true);; j = localb.f(0, localb.ann.size(), true))
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(262905);
    return arrayOfInt;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    AppMethodBeat.i(262941);
    super.offsetChildrenHorizontal(paramInt);
    int i = 0;
    while (i < this.ahF)
    {
      this.amH[i].dt(paramInt);
      i += 1;
    }
    AppMethodBeat.o(262941);
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    AppMethodBeat.i(262942);
    super.offsetChildrenVertical(paramInt);
    int i = 0;
    while (i < this.ahF)
    {
      this.amH[i].dt(paramInt);
      i += 1;
    }
    AppMethodBeat.o(262942);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(262889);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    removeCallbacks(this.amW);
    int i = 0;
    while (i < this.ahF)
    {
      this.amH[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
    AppMethodBeat.o(262889);
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(262999);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(262999);
      return null;
    }
    paramView = findContainingItemView(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(262999);
      return null;
    }
    kC();
    switch (paramInt)
    {
    default: 
      paramInt = -2147483648;
    }
    while (paramInt == -2147483648)
    {
      AppMethodBeat.o(262999);
      return null;
      if (this.mOrientation == 1)
      {
        paramInt = -1;
      }
      else if (kp())
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
        else if (kp())
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
    boolean bool = ((LayoutParams)localObject).anb;
    localObject = ((LayoutParams)localObject).ana;
    if (paramInt == 1) {}
    for (int i = mD();; i = mE())
    {
      a(i, params);
      da(paramInt);
      o localo = this.amL;
      localo.aiM = (localo.aiN + i);
      this.amL.aiL = ((int)(0.3333333F * this.amI.kV()));
      this.amL.aiQ = true;
      this.amL.aiK = false;
      a(paramn, this.amL, params);
      this.amP = this.aiW;
      if (bool) {
        break;
      }
      paramn = ((b)localObject).aV(i, paramInt);
      if ((paramn == null) || (paramn == paramView)) {
        break;
      }
      AppMethodBeat.o(262999);
      return paramn;
    }
    if (dh(paramInt))
    {
      j = this.ahF - 1;
      while (j >= 0)
      {
        paramn = this.amH[j].aV(i, paramInt);
        if ((paramn != null) && (paramn != paramView))
        {
          AppMethodBeat.o(262999);
          return paramn;
        }
        j -= 1;
      }
    }
    int j = 0;
    while (j < this.ahF)
    {
      paramn = this.amH[j].aV(i, paramInt);
      if ((paramn != null) && (paramn != paramView))
      {
        AppMethodBeat.o(262999);
        return paramn;
      }
      j += 1;
    }
    if (!this.aiV)
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
    for (j = ((b)localObject).mN();; j = ((b)localObject).mO())
    {
      paramn = findViewByPosition(j);
      if ((paramn == null) || (paramn == paramView)) {
        break label627;
      }
      AppMethodBeat.o(262999);
      return paramn;
      i = 0;
      break;
      j = 0;
      break label548;
      i = 0;
      break label558;
    }
    label627:
    if (dh(paramInt))
    {
      paramInt = this.ahF - 1;
      while (paramInt >= 0)
      {
        if (paramInt != ((b)localObject).mIndex)
        {
          if (i != 0) {}
          for (j = this.amH[paramInt].mN();; j = this.amH[paramInt].mO())
          {
            paramn = findViewByPosition(j);
            if ((paramn == null) || (paramn == paramView)) {
              break;
            }
            AppMethodBeat.o(262999);
            return paramn;
          }
        }
        paramInt -= 1;
      }
    }
    paramInt = 0;
    while (paramInt < this.ahF)
    {
      if (i != 0) {}
      for (j = this.amH[paramInt].mN();; j = this.amH[paramInt].mO())
      {
        paramn = findViewByPosition(j);
        if ((paramn == null) || (paramn == paramView)) {
          break;
        }
        AppMethodBeat.o(262999);
        return paramn;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(262999);
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(262927);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      View localView1 = ay(false);
      View localView2 = az(false);
      if ((localView1 == null) || (localView2 == null))
      {
        AppMethodBeat.o(262927);
        return;
      }
      int i = getPosition(localView1);
      int j = getPosition(localView2);
      if (i < j)
      {
        paramAccessibilityEvent.setFromIndex(i);
        paramAccessibilityEvent.setToIndex(j);
        AppMethodBeat.o(262927);
        return;
      }
      paramAccessibilityEvent.setFromIndex(j);
      paramAccessibilityEvent.setToIndex(i);
    }
    AppMethodBeat.o(262927);
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, d paramd)
  {
    int i = 1;
    AppMethodBeat.i(262925);
    paramn = paramView.getLayoutParams();
    if (!(paramn instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramd);
      AppMethodBeat.o(262925);
      return;
    }
    paramn = (LayoutParams)paramn;
    int k;
    int m;
    int j;
    if (this.mOrientation == 0)
    {
      k = paramn.kv();
      if (paramn.anb) {
        i = this.ahF;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      paramd.D(d.c.a(k, j, m, i, paramn.anb));
      AppMethodBeat.o(262925);
      return;
      m = paramn.kv();
      if (paramn.anb)
      {
        i = this.ahF;
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
    AppMethodBeat.i(262944);
    k(paramInt1, paramInt2, 1);
    AppMethodBeat.o(262944);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(262945);
    this.amN.clear();
    requestLayout();
    AppMethodBeat.o(262945);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(262946);
    k(paramInt1, paramInt2, 8);
    AppMethodBeat.o(262946);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262943);
    k(paramInt1, paramInt2, 2);
    AppMethodBeat.o(262943);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(262947);
    k(paramInt1, paramInt2, 4);
    AppMethodBeat.o(262947);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(262899);
    int j = 1;
    a locala = this.amT;
    if (((this.amR != null) || (this.aiZ != -1)) && (params.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      locala.reset();
      AppMethodBeat.o(262899);
      return;
    }
    int k;
    int m;
    label124:
    int n;
    if ((!locala.aji) || (this.aiZ != -1) || (this.amR != null))
    {
      k = 1;
      if (k == 0) {
        break label476;
      }
      locala.reset();
      if (this.amR == null) {
        break label627;
      }
      if (this.amR.anj <= 0) {
        break label280;
      }
      if (this.amR.anj != this.ahF) {
        break label230;
      }
      m = 0;
      if (m >= this.ahF) {
        break label280;
      }
      this.amH[m].clear();
      n = this.amR.ank[m];
      i = n;
      if (n != -2147483648) {
        if (!this.amR.ajs) {
          break label215;
        }
      }
    }
    label215:
    for (int i = n + this.amI.kU();; i = n + this.amI.kT())
    {
      this.amH[m].setLine(i);
      m += 1;
      break label124;
      k = 0;
      break;
    }
    label230:
    Object localObject1 = this.amR;
    ((SavedState)localObject1).ank = null;
    ((SavedState)localObject1).anj = 0;
    ((SavedState)localObject1).anl = 0;
    ((SavedState)localObject1).anm = null;
    ((SavedState)localObject1).ane = null;
    this.amR.ajq = this.amR.ani;
    label280:
    this.amQ = this.amR.amQ;
    aq(this.amR.aiV);
    kC();
    if (this.amR.ajq != -1)
    {
      this.aiZ = this.amR.ajq;
      locala.ajh = this.amR.ajs;
      if (this.amR.anl > 1)
      {
        this.amN.anc = this.amR.anm;
        this.amN.ane = this.amR.ane;
      }
      label379:
      if ((!params.alW) && (this.aiZ != -1)) {
        break label643;
      }
      i = 0;
      label397:
      if (i == 0)
      {
        if (!this.amP) {
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
      locala.zP = -2147483648;
      locala.aji = true;
      if ((this.amR == null) && (this.aiZ == -1) && ((locala.ajh != this.amP) || (kp() != this.amQ)))
      {
        this.amN.clear();
        locala.amY = true;
      }
      if ((getChildCount() <= 0) || ((this.amR != null) && (this.amR.anj > 0))) {
        break label1539;
      }
      if (!locala.amY) {
        break label1227;
      }
      i = 0;
      while (i < this.ahF)
      {
        this.amH[i].clear();
        if (locala.zP != -2147483648) {
          this.amH[i].setLine(locala.zP);
        }
        i += 1;
      }
      locala.ajh = this.aiW;
      break;
      kC();
      locala.ajh = this.aiW;
      break label379;
      if ((this.aiZ < 0) || (this.aiZ >= params.getItemCount()))
      {
        this.aiZ = -1;
        this.aja = -2147483648;
        i = 0;
        break label397;
      }
      if ((this.amR == null) || (this.amR.ajq == -1) || (this.amR.anj <= 0))
      {
        localObject1 = findViewByPosition(this.aiZ);
        if (localObject1 != null)
        {
          if (this.aiW)
          {
            i = mD();
            locala.mPosition = i;
            if (this.aja == -2147483648) {
              break label830;
            }
            if (!locala.ajh) {
              break label800;
            }
          }
          label800:
          for (locala.zP = (this.amI.kU() - this.aja - this.amI.ba((View)localObject1));; locala.zP = (this.amI.kT() + this.aja - this.amI.aZ((View)localObject1)))
          {
            i = 1;
            break;
            i = mE();
            break label734;
          }
          label830:
          if (this.amI.bd((View)localObject1) > this.amI.kV()) {
            if (locala.ajh)
            {
              i = this.amI.kU();
              locala.zP = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.amI.kT();
        break label866;
        i = this.amI.aZ((View)localObject1) - this.amI.kT();
        if (i < 0)
        {
          locala.zP = (-i);
        }
        else
        {
          i = this.amI.kU() - this.amI.ba((View)localObject1);
          if (i < 0)
          {
            locala.zP = i;
          }
          else
          {
            locala.zP = -2147483648;
            continue;
            locala.mPosition = this.aiZ;
            if (this.aja == -2147483648) {
              if (di(locala.mPosition) == 1)
              {
                bool = true;
                locala.ajh = bool;
                if (!locala.ajh) {
                  break label1054;
                }
                i = locala.amX.amI.kU();
                label1032:
                locala.zP = i;
              }
            }
            for (;;)
            {
              locala.amY = true;
              break;
              bool = false;
              break label1004;
              label1054:
              i = locala.amX.amI.kT();
              break label1032;
              i = this.aja;
              if (locala.ajh) {
                locala.zP = (locala.amX.amI.kU() - i);
              } else {
                locala.zP = (i + locala.amX.amI.kT());
              }
            }
            locala.zP = -2147483648;
            locala.mPosition = this.aiZ;
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
    if ((k != 0) || (this.amT.amZ == null))
    {
      k = 0;
      if (k < this.ahF)
      {
        localObject1 = this.amH[k];
        bool = this.aiW;
        n = locala.zP;
        if (bool)
        {
          i = ((b)localObject1).ds(-2147483648);
          label1290:
          ((b)localObject1).clear();
          if ((i != -2147483648) && ((!bool) || (i >= ((b)localObject1).amX.amI.kU())) && ((bool) || (i <= ((b)localObject1).amX.amI.kT()))) {
            break label1365;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = ((b)localObject1).dr(-2147483648);
          break label1290;
          m = i;
          if (n != -2147483648) {
            m = i + n;
          }
          ((b)localObject1).anp = m;
          ((b)localObject1).ano = m;
        }
      }
      localObject1 = this.amT;
      localObject2 = this.amH;
      k = localObject2.length;
      if ((((a)localObject1).amZ == null) || (((a)localObject1).amZ.length < k)) {
        ((a)localObject1).amZ = new int[((a)localObject1).amX.amH.length];
      }
      i = 0;
    }
    while (i < k)
    {
      ((a)localObject1).amZ[i] = localObject2[i].dr(-2147483648);
      i += 1;
      continue;
      i = 0;
      while (i < this.ahF)
      {
        localObject1 = this.amH[i];
        ((b)localObject1).clear();
        ((b)localObject1).setLine(this.amT.amZ[i]);
        i += 1;
      }
    }
    label1539:
    detachAndScrapAttachedViews(paramn);
    this.amL.aiK = false;
    this.amU = false;
    cZ(this.amJ.kV());
    a(locala.mPosition, params);
    label1638:
    float f1;
    if (locala.ajh)
    {
      da(-1);
      a(paramn, this.amL, params);
      da(1);
      this.amL.aiM = (locala.mPosition + this.amL.aiN);
      a(paramn, this.amL, params);
      if (this.amJ.getMode() == 1073741824) {
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
      float f2 = this.amJ.bd((View)localObject1);
      if (f2 < f1) {
        break label2220;
      }
      if (!((LayoutParams)((View)localObject1).getLayoutParams()).anb) {
        break label2217;
      }
      f2 = 1.0F * f2 / this.ahF;
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
      da(1);
      a(paramn, this.amL, params);
      da(-1);
      this.amL.aiM = (locala.mPosition + this.amL.aiN);
      a(paramn, this.amL, params);
      break label1638;
      n = this.amK;
      k = Math.round(this.ahF * f1);
      i = k;
      if (this.amJ.getMode() == -2147483648) {
        i = Math.min(k, this.amJ.kV());
      }
      cZ(i);
      if (this.amK != n)
      {
        i = 0;
        if (i < m)
        {
          localObject1 = getChildAt(i);
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          if (!((LayoutParams)localObject2).anb)
          {
            if ((!kp()) || (this.mOrientation != 1)) {
              break label1962;
            }
            ((View)localObject1).offsetLeftAndRight(-(this.ahF - 1 - ((LayoutParams)localObject2).ana.mIndex) * this.amK - -(this.ahF - 1 - ((LayoutParams)localObject2).ana.mIndex) * n);
          }
          for (;;)
          {
            i += 1;
            break;
            k = ((LayoutParams)localObject2).ana.mIndex * this.amK;
            i1 = ((LayoutParams)localObject2).ana.mIndex * n;
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
        if (this.aiW)
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
          if (!params.alW) {
            if ((this.amO == 0) || (getChildCount() <= 0) || ((!this.amU) && (my() == null))) {
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
          removeCallbacks(this.amW);
          i = k;
          if (mx()) {
            i = 1;
          }
        }
        if (params.alW) {
          this.amT.reset();
        }
        this.amP = locala.ajh;
        this.amQ = kp();
        if (i == 0) {
          break label2210;
        }
        this.amT.reset();
        j = 0;
        break;
        b(paramn, params, true);
        a(paramn, params, false);
        break label2052;
      }
      AppMethodBeat.o(262899);
      return;
      break label1722;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(262900);
    super.onLayoutCompleted(params);
    this.aiZ = -1;
    this.aja = -2147483648;
    this.amR = null;
    this.amT.reset();
    AppMethodBeat.o(262900);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(262923);
    if ((paramParcelable instanceof SavedState))
    {
      this.amR = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(262923);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(262924);
    Object localObject;
    if (this.amR != null)
    {
      localObject = new SavedState(this.amR);
      AppMethodBeat.o(262924);
      return localObject;
    }
    SavedState localSavedState = new SavedState();
    localSavedState.aiV = this.aiV;
    localSavedState.ajs = this.amP;
    localSavedState.amQ = this.amQ;
    int i;
    label142:
    label162:
    label169:
    int j;
    label197:
    int k;
    if ((this.amN != null) && (this.amN.anc != null))
    {
      localSavedState.anm = this.amN.anc;
      localSavedState.anl = localSavedState.anm.length;
      localSavedState.ane = this.amN.ane;
      if (getChildCount() <= 0) {
        break label327;
      }
      if (!this.amP) {
        break label266;
      }
      i = mD();
      localSavedState.ajq = i;
      if (!this.aiW) {
        break label274;
      }
      localObject = az(true);
      if (localObject != null) {
        break label284;
      }
      i = -1;
      localSavedState.ani = i;
      localSavedState.anj = this.ahF;
      localSavedState.ank = new int[this.ahF];
      j = 0;
      if (j >= this.ahF) {
        break label345;
      }
      if (!this.amP) {
        break label294;
      }
      k = this.amH[j].ds(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.amI.kU();
      }
    }
    for (;;)
    {
      localSavedState.ank[j] = i;
      j += 1;
      break label197;
      localSavedState.anl = 0;
      break;
      label266:
      i = mE();
      break label142;
      label274:
      localObject = ay(true);
      break label162;
      label284:
      i = getPosition((View)localObject);
      break label169;
      label294:
      k = this.amH[j].dr(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.amI.kT();
      }
    }
    label327:
    localSavedState.ajq = -1;
    localSavedState.ani = -1;
    localSavedState.anj = 0;
    label345:
    AppMethodBeat.o(262924);
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(262888);
    if (paramInt == 0) {
      mx();
    }
    AppMethodBeat.o(262888);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(262974);
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(262974);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(262980);
    if ((this.amR != null) && (this.amR.ajq != paramInt)) {
      this.amR.mG();
    }
    this.aiZ = paramInt;
    this.aja = -2147483648;
    requestLayout();
    AppMethodBeat.o(262980);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(262976);
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(262976);
    return paramInt;
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262897);
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.amK * this.ahF, getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(262897);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.amK * this.ahF, getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(262979);
    paramRecyclerView = new p(paramRecyclerView.getContext());
    paramRecyclerView.alG = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(262979);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return this.amR == null;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    StaggeredGridLayoutManager.b ana;
    boolean anb;
    
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
    
    public final void aA(boolean paramBoolean)
    {
      this.anb = paramBoolean;
    }
    
    public final int kv()
    {
      if (this.ana == null) {
        return -1;
      }
      return this.ana.mIndex;
    }
    
    public final boolean mF()
    {
      return this.anb;
    }
  }
  
  static final class LazySpanLookup
  {
    int[] anc;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> ane;
    
    private void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262823);
      if (this.ane == null)
      {
        AppMethodBeat.o(262823);
        return;
      }
      int i = this.ane.size() - 1;
      if (i >= 0)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i);
        if (localFullSpanItem.mPosition >= paramInt1)
        {
          if (localFullSpanItem.mPosition >= paramInt1 + paramInt2) {
            break label87;
          }
          this.ane.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          label87:
          localFullSpanItem.mPosition -= paramInt2;
        }
      }
      AppMethodBeat.o(262823);
    }
    
    private void aT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262825);
      if (this.ane == null)
      {
        AppMethodBeat.o(262825);
        return;
      }
      int i = this.ane.size() - 1;
      while (i >= 0)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i);
        if (localFullSpanItem.mPosition >= paramInt1) {
          localFullSpanItem.mPosition += paramInt2;
        }
        i -= 1;
      }
      AppMethodBeat.o(262825);
    }
    
    private int dm(int paramInt)
    {
      int i = this.anc.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    private void dn(int paramInt)
    {
      AppMethodBeat.i(262820);
      if (this.anc == null)
      {
        this.anc = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(this.anc, -1);
        AppMethodBeat.o(262820);
        return;
      }
      if (paramInt >= this.anc.length)
      {
        int[] arrayOfInt = this.anc;
        this.anc = new int[dm(paramInt)];
        System.arraycopy(arrayOfInt, 0, this.anc, 0, arrayOfInt.length);
        Arrays.fill(this.anc, arrayOfInt.length, this.anc.length, -1);
      }
      AppMethodBeat.o(262820);
    }
    
    private int jdMethod_do(int paramInt)
    {
      AppMethodBeat.i(262826);
      if (this.ane == null)
      {
        AppMethodBeat.o(262826);
        return -1;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = dp(paramInt);
      if (localFullSpanItem != null) {
        this.ane.remove(localFullSpanItem);
      }
      int j = this.ane.size();
      int i = 0;
      if (i < j) {
        if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i)).mPosition < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i);
          this.ane.remove(i);
          paramInt = localFullSpanItem.mPosition;
          AppMethodBeat.o(262826);
          return paramInt;
          i += 1;
          break;
        }
        AppMethodBeat.o(262826);
        return -1;
        i = -1;
      }
    }
    
    final void a(int paramInt, StaggeredGridLayoutManager.b paramb)
    {
      AppMethodBeat.i(262819);
      dn(paramInt);
      this.anc[paramInt] = paramb.mIndex;
      AppMethodBeat.o(262819);
    }
    
    public final void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem paramFullSpanItem)
    {
      AppMethodBeat.i(262828);
      if (this.ane == null) {
        this.ane = new ArrayList();
      }
      int j = this.ane.size();
      int i = 0;
      while (i < j)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i);
        if (localFullSpanItem.mPosition == paramFullSpanItem.mPosition) {
          this.ane.remove(i);
        }
        if (localFullSpanItem.mPosition >= paramFullSpanItem.mPosition)
        {
          this.ane.add(i, paramFullSpanItem);
          AppMethodBeat.o(262828);
          return;
        }
        i += 1;
      }
      this.ane.add(paramFullSpanItem);
      AppMethodBeat.o(262828);
    }
    
    final void aQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262822);
      if ((this.anc == null) || (paramInt1 >= this.anc.length))
      {
        AppMethodBeat.o(262822);
        return;
      }
      dn(paramInt1 + paramInt2);
      int[] arrayOfInt1 = this.anc;
      int[] arrayOfInt2 = this.anc;
      System.arraycopy(arrayOfInt1, paramInt1 + paramInt2, arrayOfInt2, paramInt1, arrayOfInt2.length - paramInt1 - paramInt2);
      Arrays.fill(this.anc, this.anc.length - paramInt2, this.anc.length, -1);
      aR(paramInt1, paramInt2);
      AppMethodBeat.o(262822);
    }
    
    final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262824);
      if ((this.anc == null) || (paramInt1 >= this.anc.length))
      {
        AppMethodBeat.o(262824);
        return;
      }
      dn(paramInt1 + paramInt2);
      int[] arrayOfInt = this.anc;
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + paramInt2, this.anc.length - paramInt1 - paramInt2);
      Arrays.fill(this.anc, paramInt1, paramInt1 + paramInt2, -1);
      aT(paramInt1, paramInt2);
      AppMethodBeat.o(262824);
    }
    
    final void clear()
    {
      AppMethodBeat.i(262821);
      if (this.anc != null) {
        Arrays.fill(this.anc, -1);
      }
      this.ane = null;
      AppMethodBeat.o(262821);
    }
    
    final int dj(int paramInt)
    {
      AppMethodBeat.i(262816);
      if (this.ane != null)
      {
        int i = this.ane.size() - 1;
        while (i >= 0)
        {
          if (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i)).mPosition >= paramInt) {
            this.ane.remove(i);
          }
          i -= 1;
        }
      }
      paramInt = dk(paramInt);
      AppMethodBeat.o(262816);
      return paramInt;
    }
    
    final int dk(int paramInt)
    {
      AppMethodBeat.i(262818);
      if (this.anc == null)
      {
        AppMethodBeat.o(262818);
        return -1;
      }
      if (paramInt >= this.anc.length)
      {
        AppMethodBeat.o(262818);
        return -1;
      }
      int i = jdMethod_do(paramInt);
      if (i == -1)
      {
        int[] arrayOfInt = this.anc;
        Arrays.fill(arrayOfInt, paramInt, arrayOfInt.length, -1);
        paramInt = this.anc.length;
        AppMethodBeat.o(262818);
        return paramInt;
      }
      Arrays.fill(this.anc, paramInt, i + 1, -1);
      AppMethodBeat.o(262818);
      return i + 1;
    }
    
    final int dl(int paramInt)
    {
      if ((this.anc == null) || (paramInt >= this.anc.length)) {
        return -1;
      }
      return this.anc[paramInt];
    }
    
    public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem dp(int paramInt)
    {
      AppMethodBeat.i(262830);
      if (this.ane == null)
      {
        AppMethodBeat.o(262830);
        return null;
      }
      int i = this.ane.size() - 1;
      while (i >= 0)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i);
        if (localFullSpanItem.mPosition == paramInt)
        {
          AppMethodBeat.o(262830);
          return localFullSpanItem;
        }
        i -= 1;
      }
      AppMethodBeat.o(262830);
      return null;
    }
    
    public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262832);
      if (this.ane == null)
      {
        AppMethodBeat.o(262832);
        return null;
      }
      int j = this.ane.size();
      int i = 0;
      while (i < j)
      {
        StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.ane.get(i);
        if (localFullSpanItem.mPosition >= paramInt2)
        {
          AppMethodBeat.o(262832);
          return null;
        }
        if ((localFullSpanItem.mPosition >= paramInt1) && ((paramInt3 == 0) || (localFullSpanItem.anf == paramInt3) || (localFullSpanItem.anh)))
        {
          AppMethodBeat.o(262832);
          return localFullSpanItem;
        }
        i += 1;
      }
      AppMethodBeat.o(262832);
      return null;
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean aiV;
    int ajq;
    boolean ajs;
    boolean amQ;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> ane;
    int ani;
    int anj;
    int[] ank;
    int anl;
    int[] anm;
    
    static
    {
      AppMethodBeat.i(262841);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(262841);
    }
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(262838);
      this.ajq = paramParcel.readInt();
      this.ani = paramParcel.readInt();
      this.anj = paramParcel.readInt();
      if (this.anj > 0)
      {
        this.ank = new int[this.anj];
        paramParcel.readIntArray(this.ank);
      }
      this.anl = paramParcel.readInt();
      if (this.anl > 0)
      {
        this.anm = new int[this.anl];
        paramParcel.readIntArray(this.anm);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.aiV = bool1;
        if (paramParcel.readInt() != 1) {
          break label162;
        }
        bool1 = true;
        label118:
        this.ajs = bool1;
        if (paramParcel.readInt() != 1) {
          break label167;
        }
      }
      label162:
      label167:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.amQ = bool1;
        this.ane = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        AppMethodBeat.o(262838);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label118;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.anj = paramSavedState.anj;
      this.ajq = paramSavedState.ajq;
      this.ani = paramSavedState.ani;
      this.ank = paramSavedState.ank;
      this.anl = paramSavedState.anl;
      this.anm = paramSavedState.anm;
      this.aiV = paramSavedState.aiV;
      this.ajs = paramSavedState.ajs;
      this.amQ = paramSavedState.amQ;
      this.ane = paramSavedState.ane;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void mG()
    {
      this.ank = null;
      this.anj = 0;
      this.ajq = -1;
      this.ani = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(262840);
      paramParcel.writeInt(this.ajq);
      paramParcel.writeInt(this.ani);
      paramParcel.writeInt(this.anj);
      if (this.anj > 0) {
        paramParcel.writeIntArray(this.ank);
      }
      paramParcel.writeInt(this.anl);
      if (this.anl > 0) {
        paramParcel.writeIntArray(this.anm);
      }
      if (this.aiV)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.ajs) {
          break label130;
        }
        paramInt = 1;
        label92:
        paramParcel.writeInt(paramInt);
        if (!this.amQ) {
          break label135;
        }
      }
      label130:
      label135:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.ane);
        AppMethodBeat.o(262840);
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
    boolean ajh;
    boolean aji;
    boolean amY;
    int[] amZ;
    int mPosition;
    int zP;
    
    a()
    {
      AppMethodBeat.i(262789);
      reset();
      AppMethodBeat.o(262789);
    }
    
    final void reset()
    {
      AppMethodBeat.i(262790);
      this.mPosition = -1;
      this.zP = -2147483648;
      this.ajh = false;
      this.amY = false;
      this.aji = false;
      if (this.amZ != null) {
        Arrays.fill(this.amZ, -1);
      }
      AppMethodBeat.o(262790);
    }
  }
  
  final class b
  {
    ArrayList<View> ann;
    int ano;
    int anp;
    int anq;
    final int mIndex;
    
    b(int paramInt)
    {
      AppMethodBeat.i(262847);
      this.ann = new ArrayList();
      this.ano = -2147483648;
      this.anp = -2147483648;
      this.anq = 0;
      this.mIndex = paramInt;
      AppMethodBeat.o(262847);
    }
    
    private int a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(262867);
      int m = StaggeredGridLayoutManager.this.amI.kT();
      int n = StaggeredGridLayoutManager.this.amI.kU();
      int j;
      int k;
      if (paramInt2 > paramInt1)
      {
        j = 1;
        k = paramInt1;
      }
      while (k != paramInt2)
      {
        View localView = (View)this.ann.get(k);
        int i1 = StaggeredGridLayoutManager.this.amI.aZ(localView);
        int i2 = StaggeredGridLayoutManager.this.amI.ba(localView);
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
              AppMethodBeat.o(262867);
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
              AppMethodBeat.o(262867);
              return paramInt1;
            }
            if ((i1 < m) || (i2 > n))
            {
              paramInt1 = StaggeredGridLayoutManager.this.getPosition(localView);
              AppMethodBeat.o(262867);
              return paramInt1;
            }
          }
        }
        label275:
        k += j;
      }
      AppMethodBeat.o(262867);
      return -1;
    }
    
    private int aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262870);
      paramInt1 = a(paramInt1, paramInt2, false, false, true);
      AppMethodBeat.o(262870);
      return paramInt1;
    }
    
    private void bv()
    {
      this.ano = -2147483648;
      this.anp = -2147483648;
    }
    
    private void mH()
    {
      AppMethodBeat.i(262849);
      Object localObject = (View)this.ann.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.ano = StaggeredGridLayoutManager.this.amI.aZ((View)localObject);
      if (localLayoutParams.anb)
      {
        localObject = StaggeredGridLayoutManager.this.amN.dp(localLayoutParams.aiC.mc());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).anf == -1)) {
          this.ano -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).dq(this.mIndex);
        }
      }
      AppMethodBeat.o(262849);
    }
    
    private void mJ()
    {
      AppMethodBeat.i(262853);
      Object localObject = (View)this.ann.get(this.ann.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      this.anp = StaggeredGridLayoutManager.this.amI.ba((View)localObject);
      if (localLayoutParams.anb)
      {
        localObject = StaggeredGridLayoutManager.this.amN.dp(localLayoutParams.aiC.mc());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).anf == 1))
        {
          int i = this.anp;
          this.anp = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).dq(this.mIndex) + i);
        }
      }
      AppMethodBeat.o(262853);
    }
    
    public final View aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(262872);
      View localView2 = null;
      View localView1 = null;
      if (paramInt2 == -1)
      {
        int i = this.ann.size();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView2 = (View)this.ann.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.aiV) && (StaggeredGridLayoutManager.this.getPosition(localView2) <= paramInt1)) || ((!StaggeredGridLayoutManager.this.aiV) && (StaggeredGridLayoutManager.this.getPosition(localView2) >= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 += 1;
          localView1 = localView2;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(262872);
        return localView1;
        paramInt2 = this.ann.size() - 1;
        for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
        {
          localView2 = (View)this.ann.get(paramInt2);
          if (((StaggeredGridLayoutManager.this.aiV) && (StaggeredGridLayoutManager.this.getPosition(localView2) >= paramInt1)) || ((!StaggeredGridLayoutManager.this.aiV) && (StaggeredGridLayoutManager.this.getPosition(localView2) <= paramInt1)) || (!localView2.hasFocusable())) {
            break;
          }
          paramInt2 -= 1;
        }
      }
    }
    
    final void bt(View paramView)
    {
      AppMethodBeat.i(262855);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.ana = this;
      this.ann.add(0, paramView);
      this.ano = -2147483648;
      if (this.ann.size() == 1) {
        this.anp = -2147483648;
      }
      if ((localLayoutParams.aiC.isRemoved()) || (localLayoutParams.aiC.mt())) {
        this.anq += StaggeredGridLayoutManager.this.amI.bd(paramView);
      }
      AppMethodBeat.o(262855);
    }
    
    final void bu(View paramView)
    {
      AppMethodBeat.i(262857);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.ana = this;
      this.ann.add(paramView);
      this.anp = -2147483648;
      if (this.ann.size() == 1) {
        this.ano = -2147483648;
      }
      if ((localLayoutParams.aiC.isRemoved()) || (localLayoutParams.aiC.mt())) {
        this.anq += StaggeredGridLayoutManager.this.amI.bd(paramView);
      }
      AppMethodBeat.o(262857);
    }
    
    final void clear()
    {
      AppMethodBeat.i(262858);
      this.ann.clear();
      bv();
      this.anq = 0;
      AppMethodBeat.o(262858);
    }
    
    final int dr(int paramInt)
    {
      AppMethodBeat.i(262848);
      if (this.ano != -2147483648)
      {
        paramInt = this.ano;
        AppMethodBeat.o(262848);
        return paramInt;
      }
      if (this.ann.size() == 0)
      {
        AppMethodBeat.o(262848);
        return paramInt;
      }
      mH();
      paramInt = this.ano;
      AppMethodBeat.o(262848);
      return paramInt;
    }
    
    final int ds(int paramInt)
    {
      AppMethodBeat.i(262851);
      if (this.anp != -2147483648)
      {
        paramInt = this.anp;
        AppMethodBeat.o(262851);
        return paramInt;
      }
      if (this.ann.size() == 0)
      {
        AppMethodBeat.o(262851);
        return paramInt;
      }
      mJ();
      paramInt = this.anp;
      AppMethodBeat.o(262851);
      return paramInt;
    }
    
    final void dt(int paramInt)
    {
      if (this.ano != -2147483648) {
        this.ano += paramInt;
      }
      if (this.anp != -2147483648) {
        this.anp += paramInt;
      }
    }
    
    final int f(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(262868);
      paramInt1 = a(paramInt1, paramInt2, paramBoolean, true, false);
      AppMethodBeat.o(262868);
      return paramInt1;
    }
    
    final int mI()
    {
      AppMethodBeat.i(262850);
      if (this.ano != -2147483648)
      {
        i = this.ano;
        AppMethodBeat.o(262850);
        return i;
      }
      mH();
      int i = this.ano;
      AppMethodBeat.o(262850);
      return i;
    }
    
    final int mK()
    {
      AppMethodBeat.i(262854);
      if (this.anp != -2147483648)
      {
        i = this.anp;
        AppMethodBeat.o(262854);
        return i;
      }
      mJ();
      int i = this.anp;
      AppMethodBeat.o(262854);
      return i;
    }
    
    final void mL()
    {
      AppMethodBeat.i(262860);
      int i = this.ann.size();
      View localView = (View)this.ann.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.ana = null;
      if ((localLayoutParams.aiC.isRemoved()) || (localLayoutParams.aiC.mt())) {
        this.anq -= StaggeredGridLayoutManager.this.amI.bd(localView);
      }
      if (i == 1) {
        this.ano = -2147483648;
      }
      this.anp = -2147483648;
      AppMethodBeat.o(262860);
    }
    
    final void mM()
    {
      AppMethodBeat.i(262861);
      View localView = (View)this.ann.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.ana = null;
      if (this.ann.size() == 0) {
        this.anp = -2147483648;
      }
      if ((localLayoutParams.aiC.isRemoved()) || (localLayoutParams.aiC.mt())) {
        this.anq -= StaggeredGridLayoutManager.this.amI.bd(localView);
      }
      this.ano = -2147483648;
      AppMethodBeat.o(262861);
    }
    
    public final int mN()
    {
      AppMethodBeat.i(262863);
      if (StaggeredGridLayoutManager.this.aiV)
      {
        i = aU(this.ann.size() - 1, -1);
        AppMethodBeat.o(262863);
        return i;
      }
      int i = aU(0, this.ann.size());
      AppMethodBeat.o(262863);
      return i;
    }
    
    public final int mO()
    {
      AppMethodBeat.i(262865);
      if (StaggeredGridLayoutManager.this.aiV)
      {
        i = aU(0, this.ann.size());
        AppMethodBeat.o(262865);
        return i;
      }
      int i = aU(this.ann.size() - 1, -1);
      AppMethodBeat.o(262865);
      return i;
    }
    
    final void setLine(int paramInt)
    {
      this.ano = paramInt;
      this.anp = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */