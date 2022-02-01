package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.i.b;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager
  extends RecyclerView.i
  implements RecyclerView.r.b, a
{
  private static final Rect bBB;
  private int anA;
  private boolean anB;
  private aj ant;
  private int anz;
  private RecyclerView.o aoV;
  private RecyclerView.s apT;
  private boolean bBC;
  private b bBD;
  private a bBE;
  private aj bBF;
  private SavedState bBG;
  private int bBH;
  private int bBI;
  private SparseArray<View> bBJ;
  private View bBK;
  private int bBL;
  private List<b> bBd;
  private int bBf;
  private int bBg;
  private int bBh;
  private int bBi;
  private int bBk;
  private final c bBt;
  private c.a bBu;
  private final Context mContext;
  private boolean mIsRtl;
  
  static
  {
    AppMethodBeat.i(62405);
    if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bBB = new Rect();
      AppMethodBeat.o(62405);
      return;
    }
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62330);
    this.bBk = -1;
    this.bBd = new ArrayList();
    this.bBt = new c(this);
    this.bBE = new a((byte)0);
    this.anz = -1;
    this.anA = -2147483648;
    this.bBH = -2147483648;
    this.bBI = -2147483648;
    this.bBJ = new SparseArray();
    this.bBL = -1;
    this.bBu = new c.a();
    paramAttributeSet = c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    switch (paramAttributeSet.orientation)
    {
    }
    for (;;)
    {
      if (this.bBg != 1)
      {
        if (this.bBg == 0)
        {
          removeAllViews();
          ww();
        }
        this.bBg = 1;
        this.ant = null;
        this.bBF = null;
        requestLayout();
      }
      if (this.bBi != 4)
      {
        removeAllViews();
        ww();
        this.bBi = 4;
        requestLayout();
      }
      this.aqA = true;
      this.mContext = paramContext;
      AppMethodBeat.o(62330);
      return;
      if (paramAttributeSet.aqJ)
      {
        setFlexDirection(1);
      }
      else
      {
        setFlexDirection(0);
        continue;
        if (paramAttributeSet.aqJ) {
          setFlexDirection(3);
        } else {
          setFlexDirection(2);
        }
      }
    }
  }
  
  private View A(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62361);
    wv();
    jH();
    int j = this.ant.kd();
    int k = this.ant.ke();
    int i;
    Object localObject1;
    Object localObject2;
    label45:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label163;
      }
      localView = getChildAt(paramInt1);
      int m = bB(localView);
      if ((m < 0) || (m >= paramInt3)) {
        break label184;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aqL.isRemoved()) {
        break label115;
      }
      if (localObject2 != null) {
        break label184;
      }
      localObject2 = localView;
    }
    label163:
    label184:
    for (;;)
    {
      paramInt1 += i;
      break label45;
      i = -1;
      break;
      label115:
      if ((this.ant.bn(localView) < j) || (this.ant.bo(localView) > k))
      {
        if (localObject1 == null) {
          localObject1 = localView;
        }
      }
      else
      {
        AppMethodBeat.o(62361);
        return localView;
        if (localObject1 != null)
        {
          AppMethodBeat.o(62361);
          return localObject1;
        }
        AppMethodBeat.o(62361);
        return localObject2;
      }
    }
  }
  
  private boolean K(View paramView, int paramInt)
  {
    AppMethodBeat.i(62366);
    if ((!wk()) && (this.mIsRtl))
    {
      if (this.ant.getEnd() - this.ant.bn(paramView) <= paramInt)
      {
        AppMethodBeat.o(62366);
        return true;
      }
      AppMethodBeat.o(62366);
      return false;
    }
    if (this.ant.bo(paramView) <= paramInt)
    {
      AppMethodBeat.o(62366);
      return true;
    }
    AppMethodBeat.o(62366);
    return false;
  }
  
  private boolean L(View paramView, int paramInt)
  {
    AppMethodBeat.i(62368);
    if ((!wk()) && (this.mIsRtl))
    {
      if (this.ant.bo(paramView) <= paramInt)
      {
        AppMethodBeat.o(62368);
        return true;
      }
      AppMethodBeat.o(62368);
      return false;
    }
    if (this.ant.bn(paramView) >= this.ant.getEnd() - paramInt)
    {
      AppMethodBeat.o(62368);
      return true;
    }
    AppMethodBeat.o(62368);
    return false;
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(62357);
    int i;
    if ((!wk()) && (this.mIsRtl))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
      i = paramInt - this.ant.kd();
      if (i <= 0) {
        break label99;
      }
      i = d(i, paramo, params);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramInt = this.ant.ke() - (paramInt + i);
        if (paramInt > 0)
        {
          this.ant.cf(paramInt);
          AppMethodBeat.o(62357);
          return i + paramInt;
          i = 0;
          break;
          label99:
          AppMethodBeat.o(62357);
          return 0;
          label106:
          i = this.ant.ke() - paramInt;
          if (i > 0)
          {
            i = -d(-i, paramo, params);
          }
          else
          {
            AppMethodBeat.o(62357);
            return 0;
          }
        }
      }
    }
    AppMethodBeat.o(62357);
    return i;
  }
  
  private int a(RecyclerView.o paramo, RecyclerView.s params, b paramb)
  {
    AppMethodBeat.i(62363);
    if (paramb.anL != -2147483648)
    {
      if (paramb.amZ < 0) {
        paramb.anL += paramb.amZ;
      }
      a(paramo, paramb);
    }
    int i2 = paramb.amZ;
    int j = paramb.amZ;
    boolean bool = wk();
    int k = 0;
    Object localObject;
    int i;
    int n;
    int i3;
    int m;
    if ((j > 0) || (this.bBD.anf))
    {
      localObject = this.bBd;
      if ((paramb.mPosition >= 0) && (paramb.mPosition < params.getItemCount()) && (paramb.bBM >= 0) && (paramb.bBM < ((List)localObject).size())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = (b)this.bBd.get(paramb.bBM);
          paramb.mPosition = ((b)localObject).bAX;
          if (wk())
          {
            if ((!$assertionsDisabled) && (this.bBt.bBb == null))
            {
              paramo = new AssertionError();
              AppMethodBeat.o(62363);
              throw paramo;
              i = 0;
              continue;
            }
            i = getPaddingLeft();
            n = getPaddingRight();
            i3 = this.mWidth;
            m = paramb.LZ;
            if (paramb.mLayoutDirection != -1) {
              break label1167;
            }
            m -= ((b)localObject).bAQ;
          }
        }
      }
    }
    label1164:
    label1167:
    for (;;)
    {
      int i1 = paramb.mPosition;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      label348:
      float f4;
      label400:
      View localView;
      label446:
      int i4;
      switch (this.bBh)
      {
      default: 
        paramo = new IllegalStateException("Invalid justifyContent is set: " + this.bBh);
        AppMethodBeat.o(62363);
        throw paramo;
      case 0: 
        f1 = i;
        f2 = i3 - n;
        f4 = a.i(this.bBE);
        f2 -= a.i(this.bBE);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i3 = ((b)localObject).ars;
        f1 -= f4;
        n = i1;
        if (n < i1 + i3)
        {
          localView = ft(n);
          if (localView == null) {
            break label1164;
          }
          if (paramb.mLayoutDirection == 1)
          {
            f(localView, bBB);
            addView(localView);
            long l = this.bBt.bBb[n];
            i4 = c.ax(l);
            int i5 = c.ay(l);
            LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (b(localView, i4, i5, localLayoutParams)) {
              localView.measure(i4, i5);
            }
            f1 += localLayoutParams.leftMargin + bM(localView);
            f2 -= localLayoutParams.rightMargin + bN(localView);
            i4 = m + bK(localView);
            if (!this.mIsRtl) {
              break label938;
            }
            this.bBt.a(localView, (b)localObject, Math.round(f2) - localView.getMeasuredWidth(), i4, Math.round(f2), localView.getMeasuredHeight() + i4);
            label594:
            float f5 = localView.getMeasuredWidth() + localLayoutParams.rightMargin + bN(localView);
            i4 = localView.getMeasuredWidth();
            i5 = localLayoutParams.leftMargin;
            f4 = bM(localView) + (i4 + i5);
            f1 = f5 + f3 + f1;
            f2 -= f4 + f3;
          }
        }
        break;
      }
      for (;;)
      {
        n += 1;
        break label400;
        f1 = i3 - ((b)localObject).bAO + n;
        f2 = ((b)localObject).bAO - i;
        break label348;
        f1 = i + (i3 - ((b)localObject).bAO) / 2.0F;
        f2 = i3 - n - (i3 - ((b)localObject).bAO) / 2.0F;
        break label348;
        f3 = f1;
        if (((b)localObject).ars != 0) {
          f3 = (i3 - ((b)localObject).bAO) / ((b)localObject).ars;
        }
        f1 = i + f3 / 2.0F;
        f2 = i3 - n - f3 / 2.0F;
        break label348;
        f2 = i;
        if (((b)localObject).ars != 1) {}
        for (f1 = ((b)localObject).ars - 1;; f1 = 1.0F)
        {
          f3 = (i3 - ((b)localObject).bAO) / f1;
          f4 = i3 - n;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (((b)localObject).ars != 0) {
          f3 = (i3 - ((b)localObject).bAO) / (((b)localObject).ars + 1);
        }
        f1 = i + f3;
        f2 = i3 - n - f3;
        break label348;
        f(localView, bBB);
        addView(localView, i);
        i += 1;
        break label446;
        label938:
        this.bBt.a(localView, (b)localObject, Math.round(f1), i4, Math.round(f1) + localView.getMeasuredWidth(), localView.getMeasuredHeight() + i4);
        break label594;
        paramb.bBM += this.bBD.mLayoutDirection;
        i = ((b)localObject).bAQ;
        label1001:
        if ((!bool) && (this.mIsRtl)) {}
        for (paramb.LZ -= ((b)localObject).bAQ * paramb.mLayoutDirection;; paramb.LZ += ((b)localObject).bAQ * paramb.mLayoutDirection)
        {
          m = ((b)localObject).bAQ;
          k = i + k;
          j -= m;
          break;
          i = a((b)localObject, paramb);
          break label1001;
        }
        paramb.amZ -= k;
        if (paramb.anL != -2147483648)
        {
          paramb.anL += k;
          if (paramb.amZ < 0) {
            paramb.anL += paramb.amZ;
          }
          a(paramo, paramb);
        }
        i = paramb.amZ;
        AppMethodBeat.o(62363);
        return i2 - i;
      }
    }
  }
  
  private int a(b paramb, b paramb1)
  {
    AppMethodBeat.i(62370);
    if ((!$assertionsDisabled) && (this.bBt.bBb == null))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(62370);
      throw paramb;
    }
    int i = getPaddingTop();
    int m = getPaddingBottom();
    int i1 = this.mHeight;
    int k = paramb1.LZ;
    int j = paramb1.LZ;
    int n;
    if (paramb1.mLayoutDirection == -1)
    {
      n = paramb.bAQ;
      j += paramb.bAQ;
      k -= n;
    }
    for (;;)
    {
      n = paramb1.mPosition;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      float f4;
      label253:
      View localView;
      int i2;
      int i3;
      switch (this.bBh)
      {
      default: 
        paramb = new IllegalStateException("Invalid justifyContent is set: " + this.bBh);
        AppMethodBeat.o(62370);
        throw paramb;
      case 0: 
        f1 = i;
        f2 = i1 - m;
        f4 = f1 - a.i(this.bBE);
        f1 = f2 - a.i(this.bBE);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i1 = paramb.ars;
        m = n;
        f2 = f4;
        if (m < n + i1)
        {
          localView = ft(m);
          if (localView == null) {
            break label980;
          }
          long l = this.bBt.bBb[m];
          i2 = c.ax(l);
          i3 = c.ay(l);
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (b(localView, i2, i3, localLayoutParams)) {
            localView.measure(i2, i3);
          }
          f2 += localLayoutParams.topMargin + bK(localView);
          f1 -= localLayoutParams.rightMargin + bL(localView);
          if (paramb1.mLayoutDirection == 1)
          {
            f(localView, bBB);
            addView(localView);
            label391:
            i2 = k + bM(localView);
            i3 = j - bN(localView);
            if (!this.mIsRtl) {
              break label838;
            }
            if (!this.bBC) {
              break label775;
            }
            this.bBt.a(localView, paramb, this.mIsRtl, i3 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i3, Math.round(f1));
            label463:
            f2 = localView.getMeasuredHeight() + localLayoutParams.topMargin + bL(localView) + f3 + f2;
            i2 = localView.getMeasuredHeight();
            i3 = localLayoutParams.bottomMargin;
            f1 -= bK(localView) + (i2 + i3) + f3;
          }
        }
        break;
      }
      label775:
      label838:
      label980:
      for (;;)
      {
        m += 1;
        break label253;
        f1 = i1 - paramb.bAO + m;
        f2 = paramb.bAO - i;
        break;
        f1 = i + (i1 - paramb.bAO) / 2.0F;
        f2 = i1 - m - (i1 - paramb.bAO) / 2.0F;
        break;
        f3 = f1;
        if (paramb.ars != 0) {
          f3 = (i1 - paramb.bAO) / paramb.ars;
        }
        f1 = i + f3 / 2.0F;
        f2 = i1 - m - f3 / 2.0F;
        break;
        f2 = i;
        if (paramb.ars != 1) {}
        for (f1 = paramb.ars - 1;; f1 = 1.0F)
        {
          f3 = (i1 - paramb.bAO) / f1;
          f4 = i1 - m;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (paramb.ars != 0) {
          f3 = (i1 - paramb.bAO) / (paramb.ars + 1);
        }
        f1 = i + f3;
        f2 = i1 - m - f3;
        break;
        f(localView, bBB);
        addView(localView, i);
        i += 1;
        break label391;
        c localc = this.bBt;
        boolean bool = this.mIsRtl;
        i2 = localView.getMeasuredWidth();
        int i4 = Math.round(f2);
        int i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i3 - i2, i4, i3, localView.getMeasuredHeight() + i5);
        break label463;
        if (this.bBC)
        {
          this.bBt.a(localView, paramb, this.mIsRtl, i2, Math.round(f1) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f1));
          break label463;
        }
        localc = this.bBt;
        bool = this.mIsRtl;
        i3 = Math.round(f2);
        i4 = localView.getMeasuredWidth();
        i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i2, i3, i2 + i4, localView.getMeasuredHeight() + i5);
        break label463;
        paramb1.bBM += this.bBD.mLayoutDirection;
        i = paramb.bAQ;
        AppMethodBeat.o(62370);
        return i;
      }
    }
  }
  
  private View a(View paramView, b paramb)
  {
    AppMethodBeat.i(62387);
    boolean bool = wk();
    int j = paramb.ars;
    int i = 1;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.ant.bo(paramView) >= this.ant.bo(localView)) {
            break label115;
          }
          paramb = localView;
        }
      }
      for (;;)
      {
        i += 1;
        paramView = paramb;
        break;
        paramb = localView;
        if (this.ant.bn(paramView) <= this.ant.bn(localView)) {
          label115:
          paramb = paramView;
        }
      }
    }
    AppMethodBeat.o(62387);
    return paramView;
  }
  
  private void a(RecyclerView.o paramo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62369);
    while (paramInt2 >= paramInt1)
    {
      a(paramInt2, paramo);
      paramInt2 -= 1;
    }
    AppMethodBeat.o(62369);
  }
  
  private void a(RecyclerView.o paramo, b paramb)
  {
    AppMethodBeat.i(62364);
    if (!paramb.bBQ)
    {
      AppMethodBeat.o(62364);
      return;
    }
    if (paramb.mLayoutDirection == -1)
    {
      c(paramo, paramb);
      AppMethodBeat.o(62364);
      return;
    }
    b(paramo, paramb);
    AppMethodBeat.o(62364);
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62371);
    if (paramBoolean2)
    {
      wu();
      if ((wk()) || (!this.mIsRtl)) {
        break label212;
      }
    }
    label212:
    for (this.bBD.amZ = (a.j(parama) - getPaddingRight());; this.bBD.amZ = (this.ant.ke() - a.j(parama)))
    {
      this.bBD.mPosition = a.e(parama);
      this.bBD.anb = 1;
      this.bBD.mLayoutDirection = 1;
      this.bBD.LZ = a.j(parama);
      this.bBD.anL = -2147483648;
      this.bBD.bBM = a.f(parama);
      if ((paramBoolean1) && (this.bBd.size() > 1) && (a.f(parama) >= 0) && (a.f(parama) < this.bBd.size() - 1))
      {
        parama = (b)this.bBd.get(a.f(parama));
        b.a(this.bBD);
        b localb = this.bBD;
        int i = localb.mPosition;
        localb.mPosition = (parama.ars + i);
      }
      AppMethodBeat.o(62371);
      return;
      this.bBD.anf = false;
      break;
    }
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(62356);
    int i;
    if ((!wk()) && (this.mIsRtl))
    {
      i = this.ant.ke() - paramInt;
      if (i > 0) {
        i = d(-i, paramo, params);
      }
    }
    while (paramBoolean)
    {
      paramInt = paramInt + i - this.ant.kd();
      if (paramInt > 0)
      {
        this.ant.cf(-paramInt);
        AppMethodBeat.o(62356);
        return i - paramInt;
        AppMethodBeat.o(62356);
        return 0;
        i = paramInt - this.ant.kd();
        if (i > 0)
        {
          i = -d(i, paramo, params);
        }
        else
        {
          AppMethodBeat.o(62356);
          return 0;
        }
      }
    }
    AppMethodBeat.o(62356);
    return i;
  }
  
  private View b(View paramView, b paramb)
  {
    AppMethodBeat.i(62388);
    boolean bool = wk();
    int i = getChildCount();
    int j = getChildCount();
    int k = paramb.ars;
    i -= 2;
    if (i > j - k - 1)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.ant.bn(paramView) <= this.ant.bn(localView)) {
            break label133;
          }
          paramb = localView;
        }
      }
      for (;;)
      {
        i -= 1;
        paramView = paramb;
        break;
        paramb = localView;
        if (this.ant.bo(paramView) >= this.ant.bo(localView)) {
          label133:
          paramb = paramView;
        }
      }
    }
    AppMethodBeat.o(62388);
    return paramView;
  }
  
  private void b(RecyclerView.o paramo, b paramb)
  {
    int j = -1;
    AppMethodBeat.i(62365);
    if (paramb.anL < 0)
    {
      AppMethodBeat.o(62365);
      return;
    }
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      paramo = new AssertionError();
      AppMethodBeat.o(62365);
      throw paramo;
    }
    int n = getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(62365);
      return;
    }
    Object localObject1 = getChildAt(0);
    int k = this.bBt.bBa[bB(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62365);
      return;
    }
    localObject1 = (b)this.bBd.get(k);
    int i = 0;
    for (;;)
    {
      m = j;
      if (i >= n) {
        break label243;
      }
      View localView = getChildAt(i);
      m = j;
      if (!K(localView, paramb.anL)) {
        break label243;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).Zp == bB(localView))
      {
        if (k >= this.bBd.size() - 1) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bBd.get(m);
        j = i;
      }
      i += 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label243:
    a(paramo, 0, m);
    AppMethodBeat.o(62365);
  }
  
  private void b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62372);
    if (paramBoolean2)
    {
      wu();
      if ((wk()) || (!this.mIsRtl)) {
        break label204;
      }
    }
    label204:
    for (this.bBD.amZ = (this.bBK.getWidth() - a.j(parama) - this.ant.kd());; this.bBD.amZ = (a.j(parama) - this.ant.kd()))
    {
      this.bBD.mPosition = a.e(parama);
      this.bBD.anb = 1;
      this.bBD.mLayoutDirection = -1;
      this.bBD.LZ = a.j(parama);
      this.bBD.anL = -2147483648;
      this.bBD.bBM = a.f(parama);
      if ((paramBoolean1) && (a.f(parama) > 0) && (this.bBd.size() > a.f(parama)))
      {
        parama = (b)this.bBd.get(a.f(parama));
        b.b(this.bBD);
        b localb = this.bBD;
        localb.mPosition -= parama.ars;
      }
      AppMethodBeat.o(62372);
      return;
      this.bBD.anf = false;
      break;
    }
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62398);
    if ((paramView.isLayoutRequested()) || (!this.aqB) || (!n(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(62398);
      return true;
    }
    AppMethodBeat.o(62398);
    return false;
  }
  
  private void bv(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(62386);
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(62386);
      throw ((Throwable)localObject1);
    }
    this.bBD.mLayoutDirection = paramInt1;
    boolean bool = wk();
    int k = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.aqF);
    int m = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.aqG);
    int i;
    Object localObject2;
    if ((!bool) && (this.mIsRtl))
    {
      i = 1;
      if (paramInt1 != 1) {
        break label560;
      }
      localObject1 = getChildAt(getChildCount() - 1);
      this.bBD.LZ = this.ant.bo((View)localObject1);
      paramInt1 = bB((View)localObject1);
      j = this.bBt.bBa[paramInt1];
      localObject1 = b((View)localObject1, (b)this.bBd.get(j));
      this.bBD.anb = 1;
      localObject2 = this.bBD;
      ((b)localObject2).mPosition = (((b)localObject2).anb + paramInt1);
      if (this.bBt.bBa.length > this.bBD.mPosition) {
        break label457;
      }
      this.bBD.bBM = -1;
      label221:
      if (i == 0) {
        break label487;
      }
      this.bBD.LZ = this.ant.bn((View)localObject1);
      this.bBD.anL = (-this.ant.bn((View)localObject1) + this.ant.kd());
      localObject1 = this.bBD;
      if (this.bBD.anL < 0) {
        break label482;
      }
      paramInt1 = this.bBD.anL;
      label290:
      ((b)localObject1).anL = paramInt1;
      label296:
      if (((this.bBD.bBM == -1) || (this.bBD.bBM > this.bBd.size() - 1)) && (this.bBD.mPosition <= getFlexItemCount()))
      {
        paramInt1 = paramInt2 - this.bBD.anL;
        this.bBu.reset();
        if (paramInt1 > 0)
        {
          if (!bool) {
            break label530;
          }
          this.bBt.a(this.bBu, k, m, paramInt1, this.bBD.mPosition, this.bBd);
        }
      }
    }
    for (;;)
    {
      this.bBt.y(k, m, this.bBD.mPosition);
      this.bBt.fx(this.bBD.mPosition);
      localObject1 = this.bBD;
      ((b)localObject1).amZ = (paramInt2 - ((b)localObject1).anL);
      AppMethodBeat.o(62386);
      return;
      i = 0;
      break;
      label457:
      this.bBD.bBM = this.bBt.bBa[this.bBD.mPosition];
      break label221;
      label482:
      paramInt1 = 0;
      break label290;
      label487:
      this.bBD.LZ = this.ant.bo((View)localObject1);
      this.bBD.anL = (this.ant.bo((View)localObject1) - this.ant.ke());
      break label296;
      label530:
      this.bBt.c(this.bBu, k, m, paramInt1, this.bBD.mPosition, this.bBd);
    }
    label560:
    Object localObject1 = getChildAt(0);
    this.bBD.LZ = this.ant.bn((View)localObject1);
    k = bB((View)localObject1);
    paramInt1 = this.bBt.bBa[k];
    localObject1 = a((View)localObject1, (b)this.bBd.get(paramInt1));
    this.bBD.anb = 1;
    paramInt1 = this.bBt.bBa[k];
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        localObject2 = (b)this.bBd.get(paramInt1 - 1);
        this.bBD.mPosition = (k - ((b)localObject2).ars);
        label684:
        localObject2 = this.bBD;
        if (paramInt1 <= 0) {
          break label795;
        }
        paramInt1 -= 1;
      }
      for (;;)
      {
        ((b)localObject2).bBM = paramInt1;
        if (i == 0) {
          break label800;
        }
        this.bBD.LZ = this.ant.bo((View)localObject1);
        this.bBD.anL = (this.ant.bo((View)localObject1) - this.ant.ke());
        localObject1 = this.bBD;
        paramInt1 = j;
        if (this.bBD.anL >= 0) {
          paramInt1 = this.bBD.anL;
        }
        ((b)localObject1).anL = paramInt1;
        break;
        this.bBD.mPosition = -1;
        break label684;
        label795:
        paramInt1 = 0;
      }
      label800:
      this.bBD.LZ = this.ant.bn((View)localObject1);
      this.bBD.anL = (-this.ant.bn((View)localObject1) + this.ant.kd());
      break;
    }
  }
  
  private View bw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62404);
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (ck(localView))
      {
        AppMethodBeat.o(62404);
        return localView;
        i = -1;
      }
      else
      {
        paramInt1 += i;
      }
    }
    AppMethodBeat.o(62404);
    return null;
  }
  
  private void c(RecyclerView.o paramo, b paramb)
  {
    AppMethodBeat.i(62367);
    if (paramb.anL < 0)
    {
      AppMethodBeat.o(62367);
      return;
    }
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      paramo = new AssertionError();
      AppMethodBeat.o(62367);
      throw paramo;
    }
    int n = getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(62367);
      return;
    }
    Object localObject1 = getChildAt(n - 1);
    int k = this.bBt.bBa[bB(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62367);
      return;
    }
    localObject1 = (b)this.bBd.get(k);
    int i = n - 1;
    int j = n;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break label237;
      }
      View localView = getChildAt(i);
      m = j;
      if (!L(localView, paramb.anL)) {
        break label237;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).bAX == bB(localView))
      {
        if (k <= 0) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bBd.get(m);
        j = i;
      }
      i -= 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label237:
    a(paramo, m, n - 1);
    AppMethodBeat.o(62367);
  }
  
  private boolean ck(View paramView)
  {
    AppMethodBeat.i(62401);
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int i4 = this.mWidth;
    int i5 = getPaddingRight();
    int k = this.mHeight;
    int m = getPaddingBottom();
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i6 = bG(paramView);
    int i7 = localLayoutParams.leftMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int n = bH(paramView);
    int i1 = localLayoutParams.topMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i8 = bI(paramView);
    int i9 = localLayoutParams.rightMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i2 = bJ(paramView);
    int i3 = localLayoutParams.bottomMargin;
    if ((i6 - i7 >= i4 - i5) || (i8 + i9 >= i)) {}
    for (i = 1;; i = 0)
    {
      if ((n - i1 >= k - m) || (i3 + i2 >= j)) {}
      for (j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0))
        {
          AppMethodBeat.o(62401);
          return true;
        }
        AppMethodBeat.o(62401);
        return false;
      }
    }
  }
  
  private int d(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    int i = 1;
    AppMethodBeat.i(62384);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62384);
      return 0;
    }
    wv();
    this.bBD.bBQ = true;
    int j;
    if ((!wk()) && (this.mIsRtl))
    {
      j = 1;
      if (j == 0) {
        break label125;
      }
      if (paramInt >= 0) {
        break label119;
      }
    }
    int k;
    int m;
    for (;;)
    {
      k = Math.abs(paramInt);
      bv(i, k);
      m = this.bBD.anL + a(paramo, params, this.bBD);
      if (m >= 0) {
        break label135;
      }
      AppMethodBeat.o(62384);
      return 0;
      j = 0;
      break;
      label119:
      i = -1;
      continue;
      label125:
      if (paramInt <= 0) {
        i = -1;
      }
    }
    label135:
    if (j != 0) {
      if (k > m) {
        paramInt = -i * m;
      }
    }
    for (;;)
    {
      this.ant.cf(-paramInt);
      this.bBD.anO = paramInt;
      AppMethodBeat.o(62384);
      return paramInt;
      if (k > m) {
        paramInt = i * m;
      }
    }
  }
  
  private void fF(int paramInt)
  {
    AppMethodBeat.i(62354);
    int i = jO();
    int j = jQ();
    if (paramInt >= j)
    {
      AppMethodBeat.o(62354);
      return;
    }
    int k = getChildCount();
    this.bBt.fz(k);
    this.bBt.fy(k);
    this.bBt.fA(k);
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62354);
      throw ((Throwable)localObject);
    }
    if (paramInt >= this.bBt.bBa.length)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.bBL = paramInt;
    Object localObject = jK();
    if (localObject == null)
    {
      AppMethodBeat.o(62354);
      return;
    }
    if ((i <= paramInt) && (paramInt <= j))
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.anz = bB((View)localObject);
    if ((!wk()) && (this.mIsRtl))
    {
      this.anA = (this.ant.bo((View)localObject) + this.ant.getEndPadding());
      AppMethodBeat.o(62354);
      return;
    }
    this.anA = (this.ant.bn((View)localObject) - this.ant.kd());
    AppMethodBeat.o(62354);
  }
  
  private View fG(int paramInt)
  {
    AppMethodBeat.i(62359);
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62359);
      throw ((Throwable)localObject);
    }
    Object localObject = A(0, getChildCount(), paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    paramInt = bB((View)localObject);
    paramInt = this.bBt.bBa[paramInt];
    if (paramInt == -1)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    localObject = a((View)localObject, (b)this.bBd.get(paramInt));
    AppMethodBeat.o(62359);
    return localObject;
  }
  
  private View fH(int paramInt)
  {
    AppMethodBeat.i(62360);
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62360);
      throw ((Throwable)localObject);
    }
    Object localObject = A(getChildCount() - 1, -1, paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62360);
      return null;
    }
    paramInt = bB((View)localObject);
    paramInt = this.bBt.bBa[paramInt];
    localObject = b((View)localObject, (b)this.bBd.get(paramInt));
    AppMethodBeat.o(62360);
    return localObject;
  }
  
  private int fI(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(62385);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62385);
      return 0;
    }
    wv();
    boolean bool = wk();
    int i;
    int j;
    if (bool)
    {
      i = this.bBK.getWidth();
      if (!bool) {
        break label127;
      }
      j = this.mWidth;
      label61:
      if (t.Y(this.akA) == 1) {
        k = 1;
      }
      if (k == 0) {
        break label161;
      }
      k = Math.abs(paramInt);
      if (paramInt >= 0) {
        break label135;
      }
      i = -Math.min(j + a.i(this.bBE) - i, k);
    }
    for (;;)
    {
      AppMethodBeat.o(62385);
      return i;
      i = this.bBK.getHeight();
      break;
      label127:
      j = this.mHeight;
      break label61;
      label135:
      i = paramInt;
      if (a.i(this.bBE) + paramInt > 0)
      {
        i = -a.i(this.bBE);
        continue;
        label161:
        if (paramInt > 0)
        {
          i = Math.min(j - a.i(this.bBE) - i, paramInt);
        }
        else
        {
          i = paramInt;
          if (a.i(this.bBE) + paramInt < 0) {
            i = -a.i(this.bBE);
          }
        }
      }
    }
  }
  
  private int j(RecyclerView.s params)
  {
    AppMethodBeat.i(62394);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = fG(i);
    View localView2 = fH(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(62394);
      throw params;
    }
    int k = bB(localView1);
    int j = bB(localView2);
    i = Math.abs(this.ant.bo(localView2) - this.ant.bn(localView1));
    k = this.bBt.bBa[k];
    if ((k == 0) || (k == -1))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    j = this.bBt.bBa[j];
    i = Math.round(i / (j - k + 1) * k + (this.ant.kd() - this.ant.bn(localView1)));
    AppMethodBeat.o(62394);
    return i;
  }
  
  private void jH()
  {
    AppMethodBeat.i(62375);
    if (this.bBD == null) {
      this.bBD = new b((byte)0);
    }
    AppMethodBeat.o(62375);
  }
  
  private View jK()
  {
    AppMethodBeat.i(202383);
    View localView = getChildAt(0);
    AppMethodBeat.o(202383);
    return localView;
  }
  
  private int jO()
  {
    AppMethodBeat.i(62402);
    View localView = bw(0, getChildCount());
    if (localView == null)
    {
      AppMethodBeat.o(62402);
      return -1;
    }
    int i = bB(localView);
    AppMethodBeat.o(62402);
    return i;
  }
  
  private int jQ()
  {
    AppMethodBeat.i(62403);
    View localView = bw(getChildCount() - 1, -1);
    if (localView == null)
    {
      AppMethodBeat.o(62403);
      return -1;
    }
    int i = bB(localView);
    AppMethodBeat.o(62403);
    return i;
  }
  
  private int k(RecyclerView.s params)
  {
    AppMethodBeat.i(62391);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62391);
      return 0;
    }
    int i = params.getItemCount();
    wv();
    View localView1 = fG(i);
    View localView2 = fH(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62391);
      return 0;
    }
    i = this.ant.bo(localView2);
    int j = this.ant.bn(localView1);
    i = Math.min(this.ant.kf(), i - j);
    AppMethodBeat.o(62391);
    return i;
  }
  
  private int l(RecyclerView.s params)
  {
    AppMethodBeat.i(62397);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62397);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = fG(i);
    View localView2 = fH(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62397);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bBt.bBa == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(62397);
      throw params;
    }
    i = jO();
    int j = jQ();
    i = (int)(Math.abs(this.ant.bo(localView2) - this.ant.bn(localView1)) / (j - i + 1) * params.getItemCount());
    AppMethodBeat.o(62397);
    return i;
  }
  
  private static boolean n(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62399);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((paramInt3 > 0) && (paramInt1 != paramInt3))
    {
      AppMethodBeat.o(62399);
      return false;
    }
    switch (i)
    {
    default: 
      AppMethodBeat.o(62399);
      return false;
    case 0: 
      AppMethodBeat.o(62399);
      return true;
    case -2147483648: 
      if (paramInt2 >= paramInt1)
      {
        AppMethodBeat.o(62399);
        return true;
      }
      AppMethodBeat.o(62399);
      return false;
    }
    if (paramInt2 == paramInt1)
    {
      AppMethodBeat.o(62399);
      return true;
    }
    AppMethodBeat.o(62399);
    return false;
  }
  
  private void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62331);
    if (this.bBf != paramInt)
    {
      removeAllViews();
      this.bBf = paramInt;
      this.ant = null;
      this.bBF = null;
      ww();
      requestLayout();
    }
    AppMethodBeat.o(62331);
  }
  
  private void wu()
  {
    AppMethodBeat.i(62373);
    int i;
    b localb;
    if (wk())
    {
      i = this.aqG;
      localb = this.bBD;
      if ((i != 0) && (i != -2147483648)) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      localb.anf = bool;
      AppMethodBeat.o(62373);
      return;
      i = this.aqF;
      break;
    }
  }
  
  private void wv()
  {
    AppMethodBeat.i(62374);
    if (this.ant != null)
    {
      AppMethodBeat.o(62374);
      return;
    }
    if (wk())
    {
      if (this.bBg != 0)
      {
        this.ant = aj.e(this);
        this.bBF = aj.d(this);
        AppMethodBeat.o(62374);
      }
    }
    else if (this.bBg == 0)
    {
      this.ant = aj.e(this);
      this.bBF = aj.d(this);
      AppMethodBeat.o(62374);
      return;
    }
    this.ant = aj.d(this);
    this.bBF = aj.e(this);
    AppMethodBeat.o(62374);
  }
  
  private void ww()
  {
    AppMethodBeat.i(62400);
    this.bBd.clear();
    a.b(this.bBE);
    a.d(this.bBE, 0);
    AppMethodBeat.o(62400);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(62382);
    if (!wk())
    {
      paramInt = d(paramInt, paramo, params);
      this.bBJ.clear();
      AppMethodBeat.o(62382);
      return paramInt;
    }
    paramInt = fI(paramInt);
    paramo = this.bBE;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bBF.cf(-paramInt);
    AppMethodBeat.o(62382);
    return paramInt;
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(62345);
    paramContext = new LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(62345);
    return paramContext;
  }
  
  public final void a(int paramInt, View paramView)
  {
    AppMethodBeat.i(62342);
    this.bBJ.put(paramInt, paramView);
    AppMethodBeat.o(62342);
  }
  
  public final void a(RecyclerView.s params)
  {
    AppMethodBeat.i(62358);
    super.a(params);
    this.bBG = null;
    this.anz = -1;
    this.anA = -2147483648;
    this.bBL = -1;
    a.b(this.bBE);
    this.bBJ.clear();
    AppMethodBeat.o(62358);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62353);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    fF(Math.min(paramInt1, paramInt2));
    AppMethodBeat.o(62353);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(62350);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramObject);
    fF(paramInt1);
    AppMethodBeat.o(62350);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    AppMethodBeat.i(62379);
    super.a(paramRecyclerView, paramo);
    if (this.anB)
    {
      d(paramo);
      paramo.clear();
    }
    AppMethodBeat.o(62379);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(62377);
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.ard = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(62377);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62334);
    f(paramView, bBB);
    if (wk())
    {
      paramInt1 = bM(paramView) + bN(paramView);
      paramb.bAO += paramInt1;
      paramb.bAP = (paramInt1 + paramb.bAP);
      AppMethodBeat.o(62334);
      return;
    }
    paramInt1 = bK(paramView) + bL(paramView);
    paramb.bAO += paramInt1;
    paramb.bAP = (paramInt1 + paramb.bAP);
    AppMethodBeat.o(62334);
  }
  
  public final void a(b paramb) {}
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(62383);
    if (wk())
    {
      paramInt = d(paramInt, paramo, params);
      this.bBJ.clear();
      AppMethodBeat.o(62383);
      return paramInt;
    }
    paramInt = fI(paramInt);
    paramo = this.bBE;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bBF.cf(-paramInt);
    AppMethodBeat.o(62383);
    return paramInt;
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(62343);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62343);
      return null;
    }
    if (paramInt < bB(getChildAt(0))) {}
    for (paramInt = -1; wk(); paramInt = 1)
    {
      localPointF = new PointF(0.0F, paramInt);
      AppMethodBeat.o(62343);
      return localPointF;
    }
    PointF localPointF = new PointF(paramInt, 0.0F);
    AppMethodBeat.o(62343);
    return localPointF;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(62355);
    this.aoV = paramo;
    this.apT = params;
    int k = params.getItemCount();
    if ((k == 0) && (params.aru))
    {
      AppMethodBeat.o(62355);
      return;
    }
    int i = t.Y(this.akA);
    a locala;
    Object localObject;
    boolean bool;
    switch (this.bBf)
    {
    default: 
      this.mIsRtl = false;
      this.bBC = false;
      wv();
      jH();
      this.bBt.fz(k);
      this.bBt.fy(k);
      this.bBt.fA(k);
      this.bBD.bBQ = false;
      if ((this.bBG != null) && (SavedState.c(this.bBG, k))) {
        this.anz = SavedState.b(this.bBG);
      }
      if ((a.a(this.bBE)) && (this.anz == -1) && (this.bBG == null)) {
        break label623;
      }
      a.b(this.bBE);
      locala = this.bBE;
      localObject = this.bBG;
      if ((!$assertionsDisabled) && (this.bBt.bBa == null))
      {
        paramo = new AssertionError();
        AppMethodBeat.o(62355);
        throw paramo;
      }
      label401:
      label445:
      break;
    case 0: 
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bBg != 2) {
          break label283;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bBC = bool;
        break;
        bool = false;
        break label251;
      }
    case 1: 
      if (i != 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bBg != 2) {
          break label329;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bBC = bool;
        break;
        bool = false;
        break label297;
      }
    case 2: 
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bBg == 2) {
          if (this.mIsRtl) {
            break label387;
          }
        }
      }
      label387:
      for (bool = true;; bool = false)
      {
        this.mIsRtl = bool;
        this.bBC = false;
        break;
        bool = false;
        break label343;
      }
    case 3: 
      label251:
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bBg == 2) {
          if (this.mIsRtl) {
            break label445;
          }
        }
      }
      label283:
      label297:
      label329:
      label343:
      for (bool = true;; bool = false)
      {
        this.mIsRtl = bool;
        this.bBC = true;
        break;
        bool = false;
        break label401;
      }
    }
    label497:
    int m;
    label563:
    label583:
    label592:
    label623:
    int n;
    label648:
    int i1;
    int i2;
    if ((params.aru) || (this.anz == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (getChildCount() == 0) {
          break label1266;
        }
        if (!a.d(locala)) {
          break label1237;
        }
        localObject = fH(params.getItemCount());
        if (localObject == null) {
          break label1266;
        }
        a.a(locala, (View)localObject);
        if ((!params.aru) && (jC()))
        {
          if ((this.ant.bn((View)localObject) < this.ant.ke()) && (this.ant.bo((View)localObject) >= this.ant.kd())) {
            break label1250;
          }
          i = 1;
          if (i != 0)
          {
            if (!a.d(locala)) {
              break label1255;
            }
            i = this.ant.ke();
            a.c(locala, i);
          }
        }
        i = 1;
        if (i == 0)
        {
          a.g(locala);
          a.b(locala, 0);
          a.a(locala, 0);
        }
      }
      a.c(this.bBE);
      b(paramo);
      if (!a.d(this.bBE)) {
        break label1271;
      }
      b(this.bBE, false, true);
      m = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.aqF);
      n = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.aqG);
      i1 = this.mWidth;
      i2 = this.mHeight;
      if (!wk()) {
        break label1301;
      }
      if ((this.bBH == -2147483648) || (this.bBH == i1)) {
        break label1284;
      }
      i = 1;
      label713:
      if (!this.bBD.anf) {
        break label1289;
      }
    }
    label1284:
    label1289:
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = this.bBD.amZ)
    {
      this.bBH = i1;
      this.bBI = i2;
      if ((this.bBL != -1) || ((this.anz == -1) && (i == 0))) {
        break label1607;
      }
      if (a.d(this.bBE)) {
        break label1474;
      }
      this.bBd.clear();
      if (($assertionsDisabled) || (this.bBt.bBa != null)) {
        break label1366;
      }
      paramo = new AssertionError();
      AppMethodBeat.o(62355);
      throw paramo;
      if ((this.anz < 0) || (this.anz >= params.getItemCount()))
      {
        this.anz = -1;
        this.anA = -2147483648;
        i = 0;
        break;
      }
      a.b(locala, this.anz);
      a.a(locala, this.bBt.bBa[a.e(locala)]);
      if ((this.bBG != null) && (SavedState.c(this.bBG, params.getItemCount())))
      {
        i = this.ant.kd();
        a.c(locala, SavedState.c((SavedState)localObject) + i);
        a.h(locala);
        a.a(locala, -1);
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.anA == -2147483648)
        {
          localObject = bY(this.anz);
          if (localObject != null)
          {
            if (this.ant.br((View)localObject) > this.ant.kf())
            {
              a.g(locala);
            }
            else if (this.ant.bn((View)localObject) - this.ant.kd() < 0)
            {
              a.c(locala, this.ant.kd());
              a.a(locala, false);
            }
            else if (this.ant.ke() - this.ant.bo((View)localObject) < 0)
            {
              a.c(locala, this.ant.ke());
              a.a(locala, true);
            }
            else
            {
              if (a.d(locala)) {}
              for (i = this.ant.bo((View)localObject) + this.ant.kc();; i = this.ant.bn((View)localObject))
              {
                a.c(locala, i);
                i = 1;
                break;
              }
            }
          }
          else
          {
            if (getChildCount() > 0)
            {
              i = bB(getChildAt(0));
              if (this.anz >= i) {
                break label1175;
              }
            }
            label1175:
            for (bool = true;; bool = false)
            {
              a.a(locala, bool);
              a.g(locala);
              break;
            }
          }
        }
        else if ((!wk()) && (this.mIsRtl))
        {
          a.c(locala, this.anA - this.ant.getEndPadding());
        }
        else
        {
          a.c(locala, this.ant.kd() + this.anA);
        }
      }
      label1237:
      localObject = fG(params.getItemCount());
      break label497;
      label1250:
      i = 0;
      break label563;
      label1255:
      i = this.ant.kd();
      break label583;
      label1266:
      i = 0;
      break label592;
      label1271:
      a(this.bBE, false, true);
      break label648;
      i = 0;
      break label713;
    }
    label1301:
    if ((this.bBI != -2147483648) && (this.bBI != i2))
    {
      i = 1;
      label1321:
      if (!this.bBD.anf) {
        break label1354;
      }
    }
    label1354:
    for (j = this.mContext.getResources().getDisplayMetrics().widthPixels;; j = this.bBD.amZ)
    {
      break;
      i = 0;
      break label1321;
    }
    label1366:
    this.bBu.reset();
    if (wk())
    {
      this.bBt.b(this.bBu, m, n, j, a.e(this.bBE), this.bBd);
      this.bBd = this.bBu.bBd;
      this.bBt.br(m, n);
      this.bBt.ws();
      a.a(this.bBE, this.bBt.bBa[a.e(this.bBE)]);
      this.bBD.bBM = a.f(this.bBE);
      label1474:
      if (!a.d(this.bBE)) {
        break label1866;
      }
      a(paramo, params, this.bBD);
      j = this.bBD.LZ;
      a(this.bBE, true, false);
      a(paramo, params, this.bBD);
      i = this.bBD.LZ;
    }
    for (;;)
    {
      if (getChildCount() > 0)
      {
        if (a.d(this.bBE))
        {
          b(a(i, paramo, params, true) + j, paramo, params, false);
          AppMethodBeat.o(62355);
          return;
          this.bBt.d(this.bBu, m, n, j, a.e(this.bBE), this.bBd);
          break;
          label1607:
          if (this.bBL != -1)
          {
            i = Math.min(this.bBL, a.e(this.bBE));
            label1630:
            this.bBu.reset();
            if (!wk()) {
              break label1776;
            }
            if (this.bBd.size() <= 0) {
              break label1742;
            }
            this.bBt.c(this.bBd, i);
            this.bBt.a(this.bBu, m, n, j, i, a.e(this.bBE), this.bBd);
          }
          for (;;)
          {
            this.bBd = this.bBu.bBd;
            this.bBt.y(m, n, i);
            this.bBt.fx(i);
            break;
            i = a.e(this.bBE);
            break label1630;
            label1742:
            this.bBt.fA(k);
            this.bBt.a(this.bBu, m, n, j, 0, this.bBd);
            continue;
            label1776:
            if (this.bBd.size() > 0)
            {
              this.bBt.c(this.bBd, i);
              this.bBt.a(this.bBu, n, m, j, i, a.e(this.bBE), this.bBd);
            }
            else
            {
              this.bBt.fA(k);
              this.bBt.c(this.bBu, m, n, j, 0, this.bBd);
            }
          }
          label1866:
          a(paramo, params, this.bBD);
          i = this.bBD.LZ;
          b(this.bBE, true, false);
          a(paramo, params, this.bBD);
          j = this.bBD.LZ;
          continue;
        }
        a(i + b(j, paramo, params, true), paramo, params, false);
      }
    }
    AppMethodBeat.o(62355);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62349);
    super.c(paramRecyclerView, paramInt1, paramInt2);
    fF(paramInt1);
    AppMethodBeat.o(62349);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(62376);
    this.anz = paramInt;
    this.anA = -2147483648;
    if (this.bBG != null) {
      SavedState.a(this.bBG);
    }
    requestLayout();
    AppMethodBeat.o(62376);
  }
  
  public final int cj(View paramView)
  {
    AppMethodBeat.i(62333);
    if (wk())
    {
      i = bK(paramView);
      j = bL(paramView);
      AppMethodBeat.o(62333);
      return i + j;
    }
    int i = bM(paramView);
    int j = bN(paramView);
    AppMethodBeat.o(62333);
    return i + j;
  }
  
  public final int d(RecyclerView.s params)
  {
    AppMethodBeat.i(62392);
    j(params);
    int i = j(params);
    AppMethodBeat.o(62392);
    return i;
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62352);
    super.d(paramRecyclerView, paramInt1, paramInt2);
    fF(paramInt1);
    AppMethodBeat.o(62352);
  }
  
  public final int e(RecyclerView.s params)
  {
    AppMethodBeat.i(62393);
    int i = j(params);
    AppMethodBeat.o(62393);
    return i;
  }
  
  public final int f(RecyclerView.s params)
  {
    AppMethodBeat.i(62389);
    int i = k(params);
    AppMethodBeat.o(62389);
    return i;
  }
  
  public final View ft(int paramInt)
  {
    AppMethodBeat.i(62336);
    View localView = (View)this.bBJ.get(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(62336);
      return localView;
    }
    localView = this.aoV.cv(paramInt);
    AppMethodBeat.o(62336);
    return localView;
  }
  
  public final View fu(int paramInt)
  {
    AppMethodBeat.i(62337);
    View localView = ft(paramInt);
    AppMethodBeat.o(62337);
    return localView;
  }
  
  public final int g(RecyclerView.s params)
  {
    AppMethodBeat.i(62390);
    int i = k(params);
    AppMethodBeat.o(62390);
    return i;
  }
  
  public final void g(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(62378);
    super.g(paramRecyclerView);
    this.bBK = ((View)paramRecyclerView.getParent());
    AppMethodBeat.o(62378);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62351);
    super.g(paramRecyclerView, paramInt1, paramInt2);
    fF(paramInt1);
    AppMethodBeat.o(62351);
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.bBi;
  }
  
  public int getFlexDirection()
  {
    return this.bBf;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(62335);
    int i = this.apT.getItemCount();
    AppMethodBeat.o(62335);
    return i;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bBd;
  }
  
  public int getFlexWrap()
  {
    return this.bBg;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62340);
    if (this.bBd.size() == 0)
    {
      AppMethodBeat.o(62340);
      return 0;
    }
    int j = -2147483648;
    int k = this.bBd.size();
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, ((b)this.bBd.get(i)).bAO);
      i += 1;
    }
    AppMethodBeat.o(62340);
    return j;
  }
  
  public int getMaxLine()
  {
    return this.bBk;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62341);
    int k = this.bBd.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((b)this.bBd.get(i)).bAQ;
      i += 1;
    }
    AppMethodBeat.o(62341);
    return j;
  }
  
  public final int h(RecyclerView.s params)
  {
    AppMethodBeat.i(62395);
    int i = l(params);
    AppMethodBeat.o(62395);
    return i;
  }
  
  public final int i(RecyclerView.s params)
  {
    AppMethodBeat.i(62396);
    int i = l(params);
    AppMethodBeat.o(62396);
    return i;
  }
  
  public final boolean jE()
  {
    AppMethodBeat.i(62380);
    if ((!wk()) || (this.mWidth > this.bBK.getWidth()))
    {
      AppMethodBeat.o(62380);
      return true;
    }
    AppMethodBeat.o(62380);
    return false;
  }
  
  public final boolean jF()
  {
    AppMethodBeat.i(62381);
    if ((wk()) || (this.mHeight > this.bBK.getHeight()))
    {
      AppMethodBeat.o(62381);
      return true;
    }
    AppMethodBeat.o(62381);
    return false;
  }
  
  public final RecyclerView.LayoutParams jy()
  {
    AppMethodBeat.i(62344);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(62344);
    return localLayoutParams;
  }
  
  public final void kY()
  {
    AppMethodBeat.i(62346);
    removeAllViews();
    AppMethodBeat.o(62346);
  }
  
  public final int m(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62332);
    if (wk())
    {
      paramInt1 = bM(paramView);
      paramInt2 = bN(paramView);
      AppMethodBeat.o(62332);
      return paramInt1 + paramInt2;
    }
    paramInt1 = bK(paramView);
    paramInt2 = bL(paramView);
    AppMethodBeat.o(62332);
    return paramInt1 + paramInt2;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62348);
    if ((paramParcelable instanceof SavedState))
    {
      this.bBG = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(62348);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(62347);
    if (this.bBG != null)
    {
      localSavedState = new SavedState(this.bBG, (byte)0);
      AppMethodBeat.o(62347);
      return localSavedState;
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      SavedState.a(localSavedState, bB(localView));
      SavedState.b(localSavedState, this.ant.bn(localView) - this.ant.kd());
    }
    for (;;)
    {
      AppMethodBeat.o(62347);
      return localSavedState;
      SavedState.a(localSavedState);
    }
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bBd = paramList;
  }
  
  public final int w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62338);
    paramInt1 = b(this.mWidth, this.aqF, paramInt2, paramInt3, jE());
    AppMethodBeat.o(62338);
    return paramInt1;
  }
  
  public final boolean wk()
  {
    return (this.bBf == 0) || (this.bBf == 1);
  }
  
  public final int x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62339);
    paramInt1 = b(this.mHeight, this.aqG, paramInt2, paramInt3, jF());
    AppMethodBeat.o(62339);
    return paramInt1;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private boolean bBA;
    private float bBw;
    private float bBx;
    private int bBy;
    private float bBz;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mMinHeight;
    private int mMinWidth;
    
    static
    {
      AppMethodBeat.i(62323);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(62323);
    }
    
    public LayoutParams()
    {
      super(-2);
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(-2);
      AppMethodBeat.i(62322);
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bBw = paramParcel.readFloat();
      this.bBx = paramParcel.readFloat();
      this.bBy = paramParcel.readInt();
      this.bBz = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bBA = bool;
        this.bottomMargin = paramParcel.readInt();
        this.leftMargin = paramParcel.readInt();
        this.rightMargin = paramParcel.readInt();
        this.topMargin = paramParcel.readInt();
        this.height = paramParcel.readInt();
        this.width = paramParcel.readInt();
        AppMethodBeat.o(62322);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final float getFlexGrow()
    {
      return this.bBw;
    }
    
    public final float getFlexShrink()
    {
      return this.bBx;
    }
    
    public final int getHeight()
    {
      return this.height;
    }
    
    public final int getMarginBottom()
    {
      return this.bottomMargin;
    }
    
    public final int getMaxHeight()
    {
      return this.mMaxHeight;
    }
    
    public final int getMaxWidth()
    {
      return this.mMaxWidth;
    }
    
    public final int getMinHeight()
    {
      return this.mMinHeight;
    }
    
    public final int getMinWidth()
    {
      return this.mMinWidth;
    }
    
    public final int getOrder()
    {
      return 1;
    }
    
    public final int getWidth()
    {
      return this.width;
    }
    
    public final int wl()
    {
      return this.bBy;
    }
    
    public final boolean wm()
    {
      return this.bBA;
    }
    
    public final float wn()
    {
      return this.bBz;
    }
    
    public final int wo()
    {
      return this.leftMargin;
    }
    
    public final int wp()
    {
      return this.topMargin;
    }
    
    public final int wq()
    {
      return this.rightMargin;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62321);
      paramParcel.writeFloat(this.bBw);
      paramParcel.writeFloat(this.bBx);
      paramParcel.writeInt(this.bBy);
      paramParcel.writeFloat(this.bBz);
      paramParcel.writeInt(this.mMinWidth);
      paramParcel.writeInt(this.mMinHeight);
      paramParcel.writeInt(this.mMaxWidth);
      paramParcel.writeInt(this.mMaxHeight);
      if (this.bBA) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.bottomMargin);
        paramParcel.writeInt(this.leftMargin);
        paramParcel.writeInt(this.rightMargin);
        paramParcel.writeInt(this.topMargin);
        paramParcel.writeInt(this.height);
        paramParcel.writeInt(this.width);
        AppMethodBeat.o(62321);
        return;
      }
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int anQ;
    private int anR;
    
    static
    {
      AppMethodBeat.i(62329);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(62329);
    }
    
    SavedState() {}
    
    private SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(62327);
      this.anQ = paramParcel.readInt();
      this.anR = paramParcel.readInt();
      AppMethodBeat.o(62327);
    }
    
    private SavedState(SavedState paramSavedState)
    {
      this.anQ = paramSavedState.anQ;
      this.anR = paramSavedState.anR;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(62328);
      String str = "SavedState{mAnchorPosition=" + this.anQ + ", mAnchorOffset=" + this.anR + '}';
      AppMethodBeat.o(62328);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62326);
      paramParcel.writeInt(this.anQ);
      paramParcel.writeInt(this.anR);
      AppMethodBeat.o(62326);
    }
  }
  
  final class a
  {
    private int anG;
    private boolean anH;
    private boolean anI;
    private int bBM;
    private int bBN = 0;
    private boolean bBO;
    private int mPosition;
    
    static
    {
      AppMethodBeat.i(62319);
      if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(62319);
        return;
      }
    }
    
    private a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(62315);
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bBM + ", mCoordinate=" + this.anG + ", mPerpendicularCoordinate=" + this.bBN + ", mLayoutFromEnd=" + this.anH + ", mValid=" + this.anI + ", mAssignedFromSavedState=" + this.bBO + '}';
      AppMethodBeat.o(62315);
      return str;
    }
  }
  
  static final class b
  {
    int LZ;
    int amZ;
    int anL;
    int anO;
    int anb = 1;
    boolean anf;
    int bBM;
    boolean bBQ;
    int mLayoutDirection = 1;
    int mPosition;
    
    public final String toString()
    {
      AppMethodBeat.i(62324);
      String str = "LayoutState{mAvailable=" + this.amZ + ", mFlexLinePosition=" + this.bBM + ", mPosition=" + this.mPosition + ", mOffset=" + this.LZ + ", mScrollingOffset=" + this.anL + ", mLastScrollDelta=" + this.anO + ", mItemDirection=" + this.anb + ", mLayoutDirection=" + this.mLayoutDirection + '}';
      AppMethodBeat.o(62324);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager
 * JD-Core Version:    0.7.0.1
 */