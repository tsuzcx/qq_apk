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
import android.support.v7.widget.RecyclerView.s.b;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
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
  implements RecyclerView.s.b, a
{
  private static final Rect bJx;
  private aj aqg;
  private int aqm;
  private int aqn;
  private boolean aqo;
  private RecyclerView.o arJ;
  private RecyclerView.t asG;
  private List<b> bIZ;
  private a bJA;
  private aj bJB;
  private SavedState bJC;
  private int bJD;
  private int bJE;
  private SparseArray<View> bJF;
  private View bJG;
  private int bJH;
  private int bJb;
  private int bJc;
  private int bJd;
  private int bJe;
  private int bJg;
  private final c bJp;
  private c.a bJq;
  private boolean bJy;
  private b bJz;
  private final Context mContext;
  private boolean mIsRtl;
  
  static
  {
    AppMethodBeat.i(62405);
    if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bJx = new Rect();
      AppMethodBeat.o(62405);
      return;
    }
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62330);
    this.bJg = -1;
    this.bIZ = new ArrayList();
    this.bJp = new c(this);
    this.bJA = new a((byte)0);
    this.aqm = -1;
    this.aqn = -2147483648;
    this.bJD = -2147483648;
    this.bJE = -2147483648;
    this.bJF = new SparseArray();
    this.bJH = -1;
    this.bJq = new c.a();
    paramAttributeSet = c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    switch (paramAttributeSet.orientation)
    {
    }
    for (;;)
    {
      if (this.bJc != 1)
      {
        if (this.bJc == 0)
        {
          removeAllViews();
          xG();
        }
        this.bJc = 1;
        this.aqg = null;
        this.bJB = null;
        requestLayout();
      }
      if (this.bJe != 4)
      {
        removeAllViews();
        xG();
        this.bJe = 4;
        requestLayout();
      }
      this.atn = true;
      this.mContext = paramContext;
      AppMethodBeat.o(62330);
      return;
      if (paramAttributeSet.atw)
      {
        setFlexDirection(1);
      }
      else
      {
        setFlexDirection(0);
        continue;
        if (paramAttributeSet.atw) {
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
    xF();
    kf();
    int j = this.aqg.kB();
    int k = this.aqg.kC();
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
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aty.isRemoved()) {
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
      if ((this.aqg.bn(localView) < j) || (this.aqg.bo(localView) > k))
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
    if ((!xu()) && (this.mIsRtl))
    {
      if (this.aqg.getEnd() - this.aqg.bn(paramView) <= paramInt)
      {
        AppMethodBeat.o(62366);
        return true;
      }
      AppMethodBeat.o(62366);
      return false;
    }
    if (this.aqg.bo(paramView) <= paramInt)
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
    if ((!xu()) && (this.mIsRtl))
    {
      if (this.aqg.bo(paramView) <= paramInt)
      {
        AppMethodBeat.o(62368);
        return true;
      }
      AppMethodBeat.o(62368);
      return false;
    }
    if (this.aqg.bn(paramView) >= this.aqg.getEnd() - paramInt)
    {
      AppMethodBeat.o(62368);
      return true;
    }
    AppMethodBeat.o(62368);
    return false;
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(62357);
    int i;
    if ((!xu()) && (this.mIsRtl))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
      i = paramInt - this.aqg.kB();
      if (i <= 0) {
        break label99;
      }
      i = d(i, paramo, paramt);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramInt = this.aqg.kC() - (paramInt + i);
        if (paramInt > 0)
        {
          this.aqg.cf(paramInt);
          AppMethodBeat.o(62357);
          return i + paramInt;
          i = 0;
          break;
          label99:
          AppMethodBeat.o(62357);
          return 0;
          label106:
          i = this.aqg.kC() - paramInt;
          if (i > 0)
          {
            i = -d(-i, paramo, paramt);
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
  
  private int a(RecyclerView.o paramo, RecyclerView.t paramt, b paramb)
  {
    AppMethodBeat.i(62363);
    if (paramb.aqy != -2147483648)
    {
      if (paramb.apM < 0) {
        paramb.aqy += paramb.apM;
      }
      a(paramo, paramb);
    }
    int i2 = paramb.apM;
    int j = paramb.apM;
    boolean bool = xu();
    int k = 0;
    Object localObject;
    int i;
    int n;
    int i3;
    int m;
    if ((j > 0) || (this.bJz.apS))
    {
      localObject = this.bIZ;
      if ((paramb.mPosition >= 0) && (paramb.mPosition < paramt.getItemCount()) && (paramb.bJI >= 0) && (paramb.bJI < ((List)localObject).size())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = (b)this.bIZ.get(paramb.bJI);
          paramb.mPosition = ((b)localObject).bIT;
          if (xu())
          {
            if ((!$assertionsDisabled) && (this.bJp.bIX == null))
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
            m = paramb.fq;
            if (paramb.mLayoutDirection != -1) {
              break label1167;
            }
            m -= ((b)localObject).bIM;
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
      switch (this.bJd)
      {
      default: 
        paramo = new IllegalStateException("Invalid justifyContent is set: " + this.bJd);
        AppMethodBeat.o(62363);
        throw paramo;
      case 0: 
        f1 = i;
        f2 = i3 - n;
        f4 = a.i(this.bJA);
        f2 -= a.i(this.bJA);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i3 = ((b)localObject).aue;
        f1 -= f4;
        n = i1;
        if (n < i1 + i3)
        {
          localView = fi(n);
          if (localView == null) {
            break label1164;
          }
          if (paramb.mLayoutDirection == 1)
          {
            f(localView, bJx);
            addView(localView);
            long l = this.bJp.bIX[n];
            i4 = c.at(l);
            int i5 = c.au(l);
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
            this.bJp.a(localView, (b)localObject, Math.round(f2) - localView.getMeasuredWidth(), i4, Math.round(f2), localView.getMeasuredHeight() + i4);
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
        f1 = i3 - ((b)localObject).bIK + n;
        f2 = ((b)localObject).bIK - i;
        break label348;
        f1 = i + (i3 - ((b)localObject).bIK) / 2.0F;
        f2 = i3 - n - (i3 - ((b)localObject).bIK) / 2.0F;
        break label348;
        f3 = f1;
        if (((b)localObject).aue != 0) {
          f3 = (i3 - ((b)localObject).bIK) / ((b)localObject).aue;
        }
        f1 = i + f3 / 2.0F;
        f2 = i3 - n - f3 / 2.0F;
        break label348;
        f2 = i;
        if (((b)localObject).aue != 1) {}
        for (f1 = ((b)localObject).aue - 1;; f1 = 1.0F)
        {
          f3 = (i3 - ((b)localObject).bIK) / f1;
          f4 = i3 - n;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (((b)localObject).aue != 0) {
          f3 = (i3 - ((b)localObject).bIK) / (((b)localObject).aue + 1);
        }
        f1 = i + f3;
        f2 = i3 - n - f3;
        break label348;
        f(localView, bJx);
        addView(localView, i);
        i += 1;
        break label446;
        label938:
        this.bJp.a(localView, (b)localObject, Math.round(f1), i4, Math.round(f1) + localView.getMeasuredWidth(), localView.getMeasuredHeight() + i4);
        break label594;
        paramb.bJI += this.bJz.mLayoutDirection;
        i = ((b)localObject).bIM;
        label1001:
        if ((!bool) && (this.mIsRtl)) {}
        for (paramb.fq -= ((b)localObject).bIM * paramb.mLayoutDirection;; paramb.fq += ((b)localObject).bIM * paramb.mLayoutDirection)
        {
          m = ((b)localObject).bIM;
          k = i + k;
          j -= m;
          break;
          i = a((b)localObject, paramb);
          break label1001;
        }
        paramb.apM -= k;
        if (paramb.aqy != -2147483648)
        {
          paramb.aqy += k;
          if (paramb.apM < 0) {
            paramb.aqy += paramb.apM;
          }
          a(paramo, paramb);
        }
        i = paramb.apM;
        AppMethodBeat.o(62363);
        return i2 - i;
      }
    }
  }
  
  private int a(b paramb, b paramb1)
  {
    AppMethodBeat.i(62370);
    if ((!$assertionsDisabled) && (this.bJp.bIX == null))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(62370);
      throw paramb;
    }
    int i = getPaddingTop();
    int m = getPaddingBottom();
    int i1 = this.mHeight;
    int k = paramb1.fq;
    int j = paramb1.fq;
    int n;
    if (paramb1.mLayoutDirection == -1)
    {
      n = paramb.bIM;
      j += paramb.bIM;
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
      switch (this.bJd)
      {
      default: 
        paramb = new IllegalStateException("Invalid justifyContent is set: " + this.bJd);
        AppMethodBeat.o(62370);
        throw paramb;
      case 0: 
        f1 = i;
        f2 = i1 - m;
        f4 = f1 - a.i(this.bJA);
        f1 = f2 - a.i(this.bJA);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i1 = paramb.aue;
        m = n;
        f2 = f4;
        if (m < n + i1)
        {
          localView = fi(m);
          if (localView == null) {
            break label980;
          }
          long l = this.bJp.bIX[m];
          i2 = c.at(l);
          i3 = c.au(l);
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (b(localView, i2, i3, localLayoutParams)) {
            localView.measure(i2, i3);
          }
          f2 += localLayoutParams.topMargin + bK(localView);
          f1 -= localLayoutParams.rightMargin + bL(localView);
          if (paramb1.mLayoutDirection == 1)
          {
            f(localView, bJx);
            addView(localView);
            label391:
            i2 = k + bM(localView);
            i3 = j - bN(localView);
            if (!this.mIsRtl) {
              break label838;
            }
            if (!this.bJy) {
              break label775;
            }
            this.bJp.a(localView, paramb, this.mIsRtl, i3 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i3, Math.round(f1));
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
        f1 = i1 - paramb.bIK + m;
        f2 = paramb.bIK - i;
        break;
        f1 = i + (i1 - paramb.bIK) / 2.0F;
        f2 = i1 - m - (i1 - paramb.bIK) / 2.0F;
        break;
        f3 = f1;
        if (paramb.aue != 0) {
          f3 = (i1 - paramb.bIK) / paramb.aue;
        }
        f1 = i + f3 / 2.0F;
        f2 = i1 - m - f3 / 2.0F;
        break;
        f2 = i;
        if (paramb.aue != 1) {}
        for (f1 = paramb.aue - 1;; f1 = 1.0F)
        {
          f3 = (i1 - paramb.bIK) / f1;
          f4 = i1 - m;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (paramb.aue != 0) {
          f3 = (i1 - paramb.bIK) / (paramb.aue + 1);
        }
        f1 = i + f3;
        f2 = i1 - m - f3;
        break;
        f(localView, bJx);
        addView(localView, i);
        i += 1;
        break label391;
        c localc = this.bJp;
        boolean bool = this.mIsRtl;
        i2 = localView.getMeasuredWidth();
        int i4 = Math.round(f2);
        int i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i3 - i2, i4, i3, localView.getMeasuredHeight() + i5);
        break label463;
        if (this.bJy)
        {
          this.bJp.a(localView, paramb, this.mIsRtl, i2, Math.round(f1) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f1));
          break label463;
        }
        localc = this.bJp;
        bool = this.mIsRtl;
        i3 = Math.round(f2);
        i4 = localView.getMeasuredWidth();
        i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i2, i3, i2 + i4, localView.getMeasuredHeight() + i5);
        break label463;
        paramb1.bJI += this.bJz.mLayoutDirection;
        i = paramb.bIM;
        AppMethodBeat.o(62370);
        return i;
      }
    }
  }
  
  private View a(View paramView, b paramb)
  {
    AppMethodBeat.i(62387);
    boolean bool = xu();
    int j = paramb.aue;
    int i = 1;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.aqg.bo(paramView) >= this.aqg.bo(localView)) {
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
        if (this.aqg.bn(paramView) <= this.aqg.bn(localView)) {
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
    if (!paramb.bJM)
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
      xE();
      if ((xu()) || (!this.mIsRtl)) {
        break label212;
      }
    }
    label212:
    for (this.bJz.apM = (a.j(parama) - getPaddingRight());; this.bJz.apM = (this.aqg.kC() - a.j(parama)))
    {
      this.bJz.mPosition = a.e(parama);
      this.bJz.apO = 1;
      this.bJz.mLayoutDirection = 1;
      this.bJz.fq = a.j(parama);
      this.bJz.aqy = -2147483648;
      this.bJz.bJI = a.f(parama);
      if ((paramBoolean1) && (this.bIZ.size() > 1) && (a.f(parama) >= 0) && (a.f(parama) < this.bIZ.size() - 1))
      {
        parama = (b)this.bIZ.get(a.f(parama));
        b.a(this.bJz);
        b localb = this.bJz;
        int i = localb.mPosition;
        localb.mPosition = (parama.aue + i);
      }
      AppMethodBeat.o(62371);
      return;
      this.bJz.apS = false;
      break;
    }
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(62356);
    int i;
    if ((!xu()) && (this.mIsRtl))
    {
      i = this.aqg.kC() - paramInt;
      if (i > 0) {
        i = d(-i, paramo, paramt);
      }
    }
    while (paramBoolean)
    {
      paramInt = paramInt + i - this.aqg.kB();
      if (paramInt > 0)
      {
        this.aqg.cf(-paramInt);
        AppMethodBeat.o(62356);
        return i - paramInt;
        AppMethodBeat.o(62356);
        return 0;
        i = paramInt - this.aqg.kB();
        if (i > 0)
        {
          i = -d(i, paramo, paramt);
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
    boolean bool = xu();
    int i = getChildCount();
    int j = getChildCount();
    int k = paramb.aue;
    i -= 2;
    if (i > j - k - 1)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.aqg.bn(paramView) <= this.aqg.bn(localView)) {
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
        if (this.aqg.bo(paramView) >= this.aqg.bo(localView)) {
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
    if (paramb.aqy < 0)
    {
      AppMethodBeat.o(62365);
      return;
    }
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
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
    int k = this.bJp.bIW[bB(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62365);
      return;
    }
    localObject1 = (b)this.bIZ.get(k);
    int i = 0;
    for (;;)
    {
      m = j;
      if (i >= n) {
        break label243;
      }
      View localView = getChildAt(i);
      m = j;
      if (!K(localView, paramb.aqy)) {
        break label243;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).aca == bB(localView))
      {
        if (k >= this.bIZ.size() - 1) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bIZ.get(m);
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
      xE();
      if ((xu()) || (!this.mIsRtl)) {
        break label204;
      }
    }
    label204:
    for (this.bJz.apM = (this.bJG.getWidth() - a.j(parama) - this.aqg.kB());; this.bJz.apM = (a.j(parama) - this.aqg.kB()))
    {
      this.bJz.mPosition = a.e(parama);
      this.bJz.apO = 1;
      this.bJz.mLayoutDirection = -1;
      this.bJz.fq = a.j(parama);
      this.bJz.aqy = -2147483648;
      this.bJz.bJI = a.f(parama);
      if ((paramBoolean1) && (a.f(parama) > 0) && (this.bIZ.size() > a.f(parama)))
      {
        parama = (b)this.bIZ.get(a.f(parama));
        b.b(this.bJz);
        b localb = this.bJz;
        localb.mPosition -= parama.aue;
      }
      AppMethodBeat.o(62372);
      return;
      this.bJz.apS = false;
      break;
    }
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62398);
    if ((paramView.isLayoutRequested()) || (!this.ato) || (!n(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(62398);
      return true;
    }
    AppMethodBeat.o(62398);
    return false;
  }
  
  private void bu(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(62386);
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(62386);
      throw ((Throwable)localObject1);
    }
    this.bJz.mLayoutDirection = paramInt1;
    boolean bool = xu();
    int k = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.ats);
    int m = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.att);
    int i;
    Object localObject2;
    if ((!bool) && (this.mIsRtl))
    {
      i = 1;
      if (paramInt1 != 1) {
        break label560;
      }
      localObject1 = getChildAt(getChildCount() - 1);
      this.bJz.fq = this.aqg.bo((View)localObject1);
      paramInt1 = bB((View)localObject1);
      j = this.bJp.bIW[paramInt1];
      localObject1 = b((View)localObject1, (b)this.bIZ.get(j));
      this.bJz.apO = 1;
      localObject2 = this.bJz;
      ((b)localObject2).mPosition = (((b)localObject2).apO + paramInt1);
      if (this.bJp.bIW.length > this.bJz.mPosition) {
        break label457;
      }
      this.bJz.bJI = -1;
      label221:
      if (i == 0) {
        break label487;
      }
      this.bJz.fq = this.aqg.bn((View)localObject1);
      this.bJz.aqy = (-this.aqg.bn((View)localObject1) + this.aqg.kB());
      localObject1 = this.bJz;
      if (this.bJz.aqy < 0) {
        break label482;
      }
      paramInt1 = this.bJz.aqy;
      label290:
      ((b)localObject1).aqy = paramInt1;
      label296:
      if (((this.bJz.bJI == -1) || (this.bJz.bJI > this.bIZ.size() - 1)) && (this.bJz.mPosition <= getFlexItemCount()))
      {
        paramInt1 = paramInt2 - this.bJz.aqy;
        this.bJq.reset();
        if (paramInt1 > 0)
        {
          if (!bool) {
            break label530;
          }
          this.bJp.a(this.bJq, k, m, paramInt1, this.bJz.mPosition, this.bIZ);
        }
      }
    }
    for (;;)
    {
      this.bJp.y(k, m, this.bJz.mPosition);
      this.bJp.fm(this.bJz.mPosition);
      localObject1 = this.bJz;
      ((b)localObject1).apM = (paramInt2 - ((b)localObject1).aqy);
      AppMethodBeat.o(62386);
      return;
      i = 0;
      break;
      label457:
      this.bJz.bJI = this.bJp.bIW[this.bJz.mPosition];
      break label221;
      label482:
      paramInt1 = 0;
      break label290;
      label487:
      this.bJz.fq = this.aqg.bo((View)localObject1);
      this.bJz.aqy = (this.aqg.bo((View)localObject1) - this.aqg.kC());
      break label296;
      label530:
      this.bJp.c(this.bJq, k, m, paramInt1, this.bJz.mPosition, this.bIZ);
    }
    label560:
    Object localObject1 = getChildAt(0);
    this.bJz.fq = this.aqg.bn((View)localObject1);
    k = bB((View)localObject1);
    paramInt1 = this.bJp.bIW[k];
    localObject1 = a((View)localObject1, (b)this.bIZ.get(paramInt1));
    this.bJz.apO = 1;
    paramInt1 = this.bJp.bIW[k];
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        localObject2 = (b)this.bIZ.get(paramInt1 - 1);
        this.bJz.mPosition = (k - ((b)localObject2).aue);
        label684:
        localObject2 = this.bJz;
        if (paramInt1 <= 0) {
          break label795;
        }
        paramInt1 -= 1;
      }
      for (;;)
      {
        ((b)localObject2).bJI = paramInt1;
        if (i == 0) {
          break label800;
        }
        this.bJz.fq = this.aqg.bo((View)localObject1);
        this.bJz.aqy = (this.aqg.bo((View)localObject1) - this.aqg.kC());
        localObject1 = this.bJz;
        paramInt1 = j;
        if (this.bJz.aqy >= 0) {
          paramInt1 = this.bJz.aqy;
        }
        ((b)localObject1).aqy = paramInt1;
        break;
        this.bJz.mPosition = -1;
        break label684;
        label795:
        paramInt1 = 0;
      }
      label800:
      this.bJz.fq = this.aqg.bn((View)localObject1);
      this.bJz.aqy = (-this.aqg.bn((View)localObject1) + this.aqg.kB());
      break;
    }
  }
  
  private View bv(int paramInt1, int paramInt2)
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
    if (paramb.aqy < 0)
    {
      AppMethodBeat.o(62367);
      return;
    }
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
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
    int k = this.bJp.bIW[bB(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62367);
      return;
    }
    localObject1 = (b)this.bIZ.get(k);
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
      if (!L(localView, paramb.aqy)) {
        break label237;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).bIT == bB(localView))
      {
        if (k <= 0) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bIZ.get(m);
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
  
  private int d(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    int i = 1;
    AppMethodBeat.i(62384);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62384);
      return 0;
    }
    xF();
    this.bJz.bJM = true;
    int j;
    if ((!xu()) && (this.mIsRtl))
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
      bu(i, k);
      m = this.bJz.aqy + a(paramo, paramt, this.bJz);
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
      this.aqg.cf(-paramInt);
      this.bJz.aqB = paramInt;
      AppMethodBeat.o(62384);
      return paramInt;
      if (k > m) {
        paramInt = i * m;
      }
    }
  }
  
  private void fu(int paramInt)
  {
    AppMethodBeat.i(62354);
    int i = km();
    int j = ko();
    if (paramInt >= j)
    {
      AppMethodBeat.o(62354);
      return;
    }
    int k = getChildCount();
    this.bJp.fo(k);
    this.bJp.fn(k);
    this.bJp.fp(k);
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62354);
      throw ((Throwable)localObject);
    }
    if (paramInt >= this.bJp.bIW.length)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.bJH = paramInt;
    Object localObject = ki();
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
    this.aqm = bB((View)localObject);
    if ((!xu()) && (this.mIsRtl))
    {
      this.aqn = (this.aqg.bo((View)localObject) + this.aqg.getEndPadding());
      AppMethodBeat.o(62354);
      return;
    }
    this.aqn = (this.aqg.bn((View)localObject) - this.aqg.kB());
    AppMethodBeat.o(62354);
  }
  
  private View fv(int paramInt)
  {
    AppMethodBeat.i(62359);
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
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
    paramInt = this.bJp.bIW[paramInt];
    if (paramInt == -1)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    localObject = a((View)localObject, (b)this.bIZ.get(paramInt));
    AppMethodBeat.o(62359);
    return localObject;
  }
  
  private View fw(int paramInt)
  {
    AppMethodBeat.i(62360);
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
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
    paramInt = this.bJp.bIW[paramInt];
    localObject = b((View)localObject, (b)this.bIZ.get(paramInt));
    AppMethodBeat.o(62360);
    return localObject;
  }
  
  private int fx(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(62385);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62385);
      return 0;
    }
    xF();
    boolean bool = xu();
    int i;
    int j;
    if (bool)
    {
      i = this.bJG.getWidth();
      if (!bool) {
        break label127;
      }
      j = this.mWidth;
      label61:
      if (t.Y(this.anl) == 1) {
        k = 1;
      }
      if (k == 0) {
        break label161;
      }
      k = Math.abs(paramInt);
      if (paramInt >= 0) {
        break label135;
      }
      i = -Math.min(j + a.i(this.bJA) - i, k);
    }
    for (;;)
    {
      AppMethodBeat.o(62385);
      return i;
      i = this.bJG.getHeight();
      break;
      label127:
      j = this.mHeight;
      break label61;
      label135:
      i = paramInt;
      if (a.i(this.bJA) + paramInt > 0)
      {
        i = -a.i(this.bJA);
        continue;
        label161:
        if (paramInt > 0)
        {
          i = Math.min(j - a.i(this.bJA) - i, paramInt);
        }
        else
        {
          i = paramInt;
          if (a.i(this.bJA) + paramInt < 0) {
            i = -a.i(this.bJA);
          }
        }
      }
    }
  }
  
  private int j(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62394);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    int i = paramt.getItemCount();
    View localView1 = fv(i);
    View localView2 = fw(i);
    if ((paramt.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
    {
      paramt = new AssertionError();
      AppMethodBeat.o(62394);
      throw paramt;
    }
    int k = bB(localView1);
    int j = bB(localView2);
    i = Math.abs(this.aqg.bo(localView2) - this.aqg.bn(localView1));
    k = this.bJp.bIW[k];
    if ((k == 0) || (k == -1))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    j = this.bJp.bIW[j];
    i = Math.round(i / (j - k + 1) * k + (this.aqg.kB() - this.aqg.bn(localView1)));
    AppMethodBeat.o(62394);
    return i;
  }
  
  private int k(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62391);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62391);
      return 0;
    }
    int i = paramt.getItemCount();
    xF();
    View localView1 = fv(i);
    View localView2 = fw(i);
    if ((paramt.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62391);
      return 0;
    }
    i = this.aqg.bo(localView2);
    int j = this.aqg.bn(localView1);
    i = Math.min(this.aqg.kD(), i - j);
    AppMethodBeat.o(62391);
    return i;
  }
  
  private void kf()
  {
    AppMethodBeat.i(62375);
    if (this.bJz == null) {
      this.bJz = new b((byte)0);
    }
    AppMethodBeat.o(62375);
  }
  
  private View ki()
  {
    AppMethodBeat.i(221228);
    View localView = getChildAt(0);
    AppMethodBeat.o(221228);
    return localView;
  }
  
  private int km()
  {
    AppMethodBeat.i(62402);
    View localView = bv(0, getChildCount());
    if (localView == null)
    {
      AppMethodBeat.o(62402);
      return -1;
    }
    int i = bB(localView);
    AppMethodBeat.o(62402);
    return i;
  }
  
  private int ko()
  {
    AppMethodBeat.i(62403);
    View localView = bv(getChildCount() - 1, -1);
    if (localView == null)
    {
      AppMethodBeat.o(62403);
      return -1;
    }
    int i = bB(localView);
    AppMethodBeat.o(62403);
    return i;
  }
  
  private int l(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62397);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62397);
      return 0;
    }
    int i = paramt.getItemCount();
    View localView1 = fv(i);
    View localView2 = fw(i);
    if ((paramt.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62397);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bJp.bIW == null))
    {
      paramt = new AssertionError();
      AppMethodBeat.o(62397);
      throw paramt;
    }
    i = km();
    int j = ko();
    i = (int)(Math.abs(this.aqg.bo(localView2) - this.aqg.bn(localView1)) / (j - i + 1) * paramt.getItemCount());
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
    if (this.bJb != paramInt)
    {
      removeAllViews();
      this.bJb = paramInt;
      this.aqg = null;
      this.bJB = null;
      xG();
      requestLayout();
    }
    AppMethodBeat.o(62331);
  }
  
  private void xE()
  {
    AppMethodBeat.i(62373);
    int i;
    b localb;
    if (xu())
    {
      i = this.att;
      localb = this.bJz;
      if ((i != 0) && (i != -2147483648)) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      localb.apS = bool;
      AppMethodBeat.o(62373);
      return;
      i = this.ats;
      break;
    }
  }
  
  private void xF()
  {
    AppMethodBeat.i(62374);
    if (this.aqg != null)
    {
      AppMethodBeat.o(62374);
      return;
    }
    if (xu())
    {
      if (this.bJc != 0)
      {
        this.aqg = aj.e(this);
        this.bJB = aj.d(this);
        AppMethodBeat.o(62374);
      }
    }
    else if (this.bJc == 0)
    {
      this.aqg = aj.e(this);
      this.bJB = aj.d(this);
      AppMethodBeat.o(62374);
      return;
    }
    this.aqg = aj.d(this);
    this.bJB = aj.e(this);
    AppMethodBeat.o(62374);
  }
  
  private void xG()
  {
    AppMethodBeat.i(62400);
    this.bIZ.clear();
    a.b(this.bJA);
    a.d(this.bJA, 0);
    AppMethodBeat.o(62400);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(62382);
    if (!xu())
    {
      paramInt = d(paramInt, paramo, paramt);
      this.bJF.clear();
      AppMethodBeat.o(62382);
      return paramInt;
    }
    paramInt = fx(paramInt);
    paramo = this.bJA;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bJB.cf(-paramInt);
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
    this.bJF.put(paramInt, paramView);
    AppMethodBeat.o(62342);
  }
  
  public final void a(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62358);
    super.a(paramt);
    this.bJC = null;
    this.aqm = -1;
    this.aqn = -2147483648;
    this.bJH = -1;
    a.b(this.bJA);
    this.bJF.clear();
    AppMethodBeat.o(62358);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62353);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    fu(Math.min(paramInt1, paramInt2));
    AppMethodBeat.o(62353);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(62350);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramObject);
    fu(paramInt1);
    AppMethodBeat.o(62350);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    AppMethodBeat.i(62379);
    super.a(paramRecyclerView, paramo);
    if (this.aqo)
    {
      d(paramo);
      paramo.clear();
    }
    AppMethodBeat.o(62379);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(62377);
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.atQ = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(62377);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62334);
    f(paramView, bJx);
    if (xu())
    {
      paramInt1 = bM(paramView) + bN(paramView);
      paramb.bIK += paramInt1;
      paramb.bIL = (paramInt1 + paramb.bIL);
      AppMethodBeat.o(62334);
      return;
    }
    paramInt1 = bK(paramView) + bL(paramView);
    paramb.bIK += paramInt1;
    paramb.bIL = (paramInt1 + paramb.bIL);
    AppMethodBeat.o(62334);
  }
  
  public final void a(b paramb) {}
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(62383);
    if (xu())
    {
      paramInt = d(paramInt, paramo, paramt);
      this.bJF.clear();
      AppMethodBeat.o(62383);
      return paramInt;
    }
    paramInt = fx(paramInt);
    paramo = this.bJA;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bJB.cf(-paramInt);
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
    for (paramInt = -1; xu(); paramInt = 1)
    {
      localPointF = new PointF(0.0F, paramInt);
      AppMethodBeat.o(62343);
      return localPointF;
    }
    PointF localPointF = new PointF(paramInt, 0.0F);
    AppMethodBeat.o(62343);
    return localPointF;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(62355);
    this.arJ = paramo;
    this.asG = paramt;
    int k = paramt.getItemCount();
    if ((k == 0) && (paramt.aug))
    {
      AppMethodBeat.o(62355);
      return;
    }
    int i = t.Y(this.anl);
    a locala;
    Object localObject;
    boolean bool;
    switch (this.bJb)
    {
    default: 
      this.mIsRtl = false;
      this.bJy = false;
      xF();
      kf();
      this.bJp.fo(k);
      this.bJp.fn(k);
      this.bJp.fp(k);
      this.bJz.bJM = false;
      if ((this.bJC != null) && (SavedState.c(this.bJC, k))) {
        this.aqm = SavedState.b(this.bJC);
      }
      if ((a.a(this.bJA)) && (this.aqm == -1) && (this.bJC == null)) {
        break label623;
      }
      a.b(this.bJA);
      locala = this.bJA;
      localObject = this.bJC;
      if ((!$assertionsDisabled) && (this.bJp.bIW == null))
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
        if (this.bJc != 2) {
          break label283;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bJy = bool;
        break;
        bool = false;
        break label251;
      }
    case 1: 
      if (i != 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bJc != 2) {
          break label329;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bJy = bool;
        break;
        bool = false;
        break label297;
      }
    case 2: 
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bJc == 2) {
          if (this.mIsRtl) {
            break label387;
          }
        }
      }
      label387:
      for (bool = true;; bool = false)
      {
        this.mIsRtl = bool;
        this.bJy = false;
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
        if (this.bJc == 2) {
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
        this.bJy = true;
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
    if ((paramt.aug) || (this.aqm == -1))
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
        localObject = fw(paramt.getItemCount());
        if (localObject == null) {
          break label1266;
        }
        a.a(locala, (View)localObject);
        if ((!paramt.aug) && (ka()))
        {
          if ((this.aqg.bn((View)localObject) < this.aqg.kC()) && (this.aqg.bo((View)localObject) >= this.aqg.kB())) {
            break label1250;
          }
          i = 1;
          if (i != 0)
          {
            if (!a.d(locala)) {
              break label1255;
            }
            i = this.aqg.kC();
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
      a.c(this.bJA);
      b(paramo);
      if (!a.d(this.bJA)) {
        break label1271;
      }
      b(this.bJA, false, true);
      m = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.ats);
      n = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.att);
      i1 = this.mWidth;
      i2 = this.mHeight;
      if (!xu()) {
        break label1301;
      }
      if ((this.bJD == -2147483648) || (this.bJD == i1)) {
        break label1284;
      }
      i = 1;
      label713:
      if (!this.bJz.apS) {
        break label1289;
      }
    }
    label1284:
    label1289:
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = this.bJz.apM)
    {
      this.bJD = i1;
      this.bJE = i2;
      if ((this.bJH != -1) || ((this.aqm == -1) && (i == 0))) {
        break label1607;
      }
      if (a.d(this.bJA)) {
        break label1474;
      }
      this.bIZ.clear();
      if (($assertionsDisabled) || (this.bJp.bIW != null)) {
        break label1366;
      }
      paramo = new AssertionError();
      AppMethodBeat.o(62355);
      throw paramo;
      if ((this.aqm < 0) || (this.aqm >= paramt.getItemCount()))
      {
        this.aqm = -1;
        this.aqn = -2147483648;
        i = 0;
        break;
      }
      a.b(locala, this.aqm);
      a.a(locala, this.bJp.bIW[a.e(locala)]);
      if ((this.bJC != null) && (SavedState.c(this.bJC, paramt.getItemCount())))
      {
        i = this.aqg.kB();
        a.c(locala, SavedState.c((SavedState)localObject) + i);
        a.h(locala);
        a.a(locala, -1);
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.aqn == -2147483648)
        {
          localObject = bY(this.aqm);
          if (localObject != null)
          {
            if (this.aqg.br((View)localObject) > this.aqg.kD())
            {
              a.g(locala);
            }
            else if (this.aqg.bn((View)localObject) - this.aqg.kB() < 0)
            {
              a.c(locala, this.aqg.kB());
              a.a(locala, false);
            }
            else if (this.aqg.kC() - this.aqg.bo((View)localObject) < 0)
            {
              a.c(locala, this.aqg.kC());
              a.a(locala, true);
            }
            else
            {
              if (a.d(locala)) {}
              for (i = this.aqg.bo((View)localObject) + this.aqg.kA();; i = this.aqg.bn((View)localObject))
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
              if (this.aqm >= i) {
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
        else if ((!xu()) && (this.mIsRtl))
        {
          a.c(locala, this.aqn - this.aqg.getEndPadding());
        }
        else
        {
          a.c(locala, this.aqg.kB() + this.aqn);
        }
      }
      label1237:
      localObject = fv(paramt.getItemCount());
      break label497;
      label1250:
      i = 0;
      break label563;
      label1255:
      i = this.aqg.kB();
      break label583;
      label1266:
      i = 0;
      break label592;
      label1271:
      a(this.bJA, false, true);
      break label648;
      i = 0;
      break label713;
    }
    label1301:
    if ((this.bJE != -2147483648) && (this.bJE != i2))
    {
      i = 1;
      label1321:
      if (!this.bJz.apS) {
        break label1354;
      }
    }
    label1354:
    for (j = this.mContext.getResources().getDisplayMetrics().widthPixels;; j = this.bJz.apM)
    {
      break;
      i = 0;
      break label1321;
    }
    label1366:
    this.bJq.reset();
    if (xu())
    {
      this.bJp.b(this.bJq, m, n, j, a.e(this.bJA), this.bIZ);
      this.bIZ = this.bJq.bIZ;
      this.bJp.bq(m, n);
      this.bJp.xC();
      a.a(this.bJA, this.bJp.bIW[a.e(this.bJA)]);
      this.bJz.bJI = a.f(this.bJA);
      label1474:
      if (!a.d(this.bJA)) {
        break label1866;
      }
      a(paramo, paramt, this.bJz);
      j = this.bJz.fq;
      a(this.bJA, true, false);
      a(paramo, paramt, this.bJz);
      i = this.bJz.fq;
    }
    for (;;)
    {
      if (getChildCount() > 0)
      {
        if (a.d(this.bJA))
        {
          b(a(i, paramo, paramt, true) + j, paramo, paramt, false);
          AppMethodBeat.o(62355);
          return;
          this.bJp.d(this.bJq, m, n, j, a.e(this.bJA), this.bIZ);
          break;
          label1607:
          if (this.bJH != -1)
          {
            i = Math.min(this.bJH, a.e(this.bJA));
            label1630:
            this.bJq.reset();
            if (!xu()) {
              break label1776;
            }
            if (this.bIZ.size() <= 0) {
              break label1742;
            }
            this.bJp.c(this.bIZ, i);
            this.bJp.a(this.bJq, m, n, j, i, a.e(this.bJA), this.bIZ);
          }
          for (;;)
          {
            this.bIZ = this.bJq.bIZ;
            this.bJp.y(m, n, i);
            this.bJp.fm(i);
            break;
            i = a.e(this.bJA);
            break label1630;
            label1742:
            this.bJp.fp(k);
            this.bJp.a(this.bJq, m, n, j, 0, this.bIZ);
            continue;
            label1776:
            if (this.bIZ.size() > 0)
            {
              this.bJp.c(this.bIZ, i);
              this.bJp.a(this.bJq, n, m, j, i, a.e(this.bJA), this.bIZ);
            }
            else
            {
              this.bJp.fp(k);
              this.bJp.c(this.bJq, m, n, j, 0, this.bIZ);
            }
          }
          label1866:
          a(paramo, paramt, this.bJz);
          i = this.bJz.fq;
          b(this.bJA, true, false);
          a(paramo, paramt, this.bJz);
          j = this.bJz.fq;
          continue;
        }
        a(i + b(j, paramo, paramt, true), paramo, paramt, false);
      }
    }
    AppMethodBeat.o(62355);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62349);
    super.c(paramRecyclerView, paramInt1, paramInt2);
    fu(paramInt1);
    AppMethodBeat.o(62349);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(62376);
    this.aqm = paramInt;
    this.aqn = -2147483648;
    if (this.bJC != null) {
      SavedState.a(this.bJC);
    }
    requestLayout();
    AppMethodBeat.o(62376);
  }
  
  public final int cj(View paramView)
  {
    AppMethodBeat.i(62333);
    if (xu())
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
  
  public final int d(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62392);
    j(paramt);
    int i = j(paramt);
    AppMethodBeat.o(62392);
    return i;
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62352);
    super.d(paramRecyclerView, paramInt1, paramInt2);
    fu(paramInt1);
    AppMethodBeat.o(62352);
  }
  
  public final int e(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62393);
    int i = j(paramt);
    AppMethodBeat.o(62393);
    return i;
  }
  
  public final int f(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62389);
    int i = k(paramt);
    AppMethodBeat.o(62389);
    return i;
  }
  
  public final View fi(int paramInt)
  {
    AppMethodBeat.i(62336);
    View localView = (View)this.bJF.get(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(62336);
      return localView;
    }
    localView = this.arJ.cu(paramInt);
    AppMethodBeat.o(62336);
    return localView;
  }
  
  public final View fj(int paramInt)
  {
    AppMethodBeat.i(62337);
    View localView = fi(paramInt);
    AppMethodBeat.o(62337);
    return localView;
  }
  
  public final int g(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62390);
    int i = k(paramt);
    AppMethodBeat.o(62390);
    return i;
  }
  
  public final void g(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(62378);
    super.g(paramRecyclerView);
    this.bJG = ((View)paramRecyclerView.getParent());
    AppMethodBeat.o(62378);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62351);
    super.g(paramRecyclerView, paramInt1, paramInt2);
    fu(paramInt1);
    AppMethodBeat.o(62351);
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.bJe;
  }
  
  public int getFlexDirection()
  {
    return this.bJb;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(62335);
    int i = this.asG.getItemCount();
    AppMethodBeat.o(62335);
    return i;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bIZ;
  }
  
  public int getFlexWrap()
  {
    return this.bJc;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62340);
    if (this.bIZ.size() == 0)
    {
      AppMethodBeat.o(62340);
      return 0;
    }
    int j = -2147483648;
    int k = this.bIZ.size();
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, ((b)this.bIZ.get(i)).bIK);
      i += 1;
    }
    AppMethodBeat.o(62340);
    return j;
  }
  
  public int getMaxLine()
  {
    return this.bJg;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62341);
    int k = this.bIZ.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((b)this.bIZ.get(i)).bIM;
      i += 1;
    }
    AppMethodBeat.o(62341);
    return j;
  }
  
  public final int h(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62395);
    int i = l(paramt);
    AppMethodBeat.o(62395);
    return i;
  }
  
  public final int i(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62396);
    int i = l(paramt);
    AppMethodBeat.o(62396);
    return i;
  }
  
  public final RecyclerView.LayoutParams jW()
  {
    AppMethodBeat.i(62344);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(62344);
    return localLayoutParams;
  }
  
  public final boolean kc()
  {
    AppMethodBeat.i(62380);
    if ((!xu()) || (this.mWidth > this.bJG.getWidth()))
    {
      AppMethodBeat.o(62380);
      return true;
    }
    AppMethodBeat.o(62380);
    return false;
  }
  
  public final boolean kd()
  {
    AppMethodBeat.i(62381);
    if ((xu()) || (this.mHeight > this.bJG.getHeight()))
    {
      AppMethodBeat.o(62381);
      return true;
    }
    AppMethodBeat.o(62381);
    return false;
  }
  
  public final void ly()
  {
    AppMethodBeat.i(62346);
    removeAllViews();
    AppMethodBeat.o(62346);
  }
  
  public final int m(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62332);
    if (xu())
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
      this.bJC = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(62348);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(62347);
    if (this.bJC != null)
    {
      localSavedState = new SavedState(this.bJC, (byte)0);
      AppMethodBeat.o(62347);
      return localSavedState;
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      SavedState.a(localSavedState, bB(localView));
      SavedState.b(localSavedState, this.aqg.bn(localView) - this.aqg.kB());
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
    this.bIZ = paramList;
  }
  
  public final int w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62338);
    paramInt1 = b(this.mWidth, this.ats, paramInt2, paramInt3, kc());
    AppMethodBeat.o(62338);
    return paramInt1;
  }
  
  public final int x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62339);
    paramInt1 = b(this.mHeight, this.att, paramInt2, paramInt3, kd());
    AppMethodBeat.o(62339);
    return paramInt1;
  }
  
  public final boolean xu()
  {
    return (this.bJb == 0) || (this.bJb == 1);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private float bJs;
    private float bJt;
    private int bJu;
    private float bJv;
    private boolean bJw;
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
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(-2);
      AppMethodBeat.i(62322);
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bJs = paramParcel.readFloat();
      this.bJt = paramParcel.readFloat();
      this.bJu = paramParcel.readInt();
      this.bJv = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bJw = bool;
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
      return this.bJs;
    }
    
    public final float getFlexShrink()
    {
      return this.bJt;
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
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62321);
      paramParcel.writeFloat(this.bJs);
      paramParcel.writeFloat(this.bJt);
      paramParcel.writeInt(this.bJu);
      paramParcel.writeFloat(this.bJv);
      paramParcel.writeInt(this.mMinWidth);
      paramParcel.writeInt(this.mMinHeight);
      paramParcel.writeInt(this.mMaxWidth);
      paramParcel.writeInt(this.mMaxHeight);
      if (this.bJw) {}
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
    
    public final int xA()
    {
      return this.rightMargin;
    }
    
    public final int xv()
    {
      return this.bJu;
    }
    
    public final boolean xw()
    {
      return this.bJw;
    }
    
    public final float xx()
    {
      return this.bJv;
    }
    
    public final int xy()
    {
      return this.leftMargin;
    }
    
    public final int xz()
    {
      return this.topMargin;
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int aqD;
    private int aqE;
    
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
      this.aqD = paramParcel.readInt();
      this.aqE = paramParcel.readInt();
      AppMethodBeat.o(62327);
    }
    
    private SavedState(SavedState paramSavedState)
    {
      this.aqD = paramSavedState.aqD;
      this.aqE = paramSavedState.aqE;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(62328);
      String str = "SavedState{mAnchorPosition=" + this.aqD + ", mAnchorOffset=" + this.aqE + '}';
      AppMethodBeat.o(62328);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62326);
      paramParcel.writeInt(this.aqD);
      paramParcel.writeInt(this.aqE);
      AppMethodBeat.o(62326);
    }
  }
  
  final class a
  {
    private int aqt;
    private boolean aqu;
    private boolean aqv;
    private int bJI;
    private int bJJ = 0;
    private boolean bJK;
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
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bJI + ", mCoordinate=" + this.aqt + ", mPerpendicularCoordinate=" + this.bJJ + ", mLayoutFromEnd=" + this.aqu + ", mValid=" + this.aqv + ", mAssignedFromSavedState=" + this.bJK + '}';
      AppMethodBeat.o(62315);
      return str;
    }
  }
  
  static final class b
  {
    int apM;
    int apO = 1;
    boolean apS;
    int aqB;
    int aqy;
    int bJI;
    boolean bJM;
    int fq;
    int mLayoutDirection = 1;
    int mPosition;
    
    public final String toString()
    {
      AppMethodBeat.i(62324);
      String str = "LayoutState{mAvailable=" + this.apM + ", mFlexLinePosition=" + this.bJI + ", mPosition=" + this.mPosition + ", mOffset=" + this.fq + ", mScrollingOffset=" + this.aqy + ", mLastScrollDelta=" + this.aqB + ", mItemDirection=" + this.apO + ", mLayoutDirection=" + this.mLayoutDirection + '}';
      AppMethodBeat.o(62324);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager
 * JD-Core Version:    0.7.0.1
 */