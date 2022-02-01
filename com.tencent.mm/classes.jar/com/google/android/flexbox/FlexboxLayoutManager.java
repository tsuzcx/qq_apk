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
  private static final Rect bzj;
  private aj aoo;
  private int aou;
  private int aov;
  private boolean aow;
  private RecyclerView.o apR;
  private RecyclerView.t aqO;
  private List<b> byL;
  private int byN;
  private int byO;
  private int byP;
  private int byQ;
  private int byS;
  private final c bzb;
  private c.a bzc;
  private boolean bzk;
  private b bzl;
  private a bzm;
  private aj bzn;
  private SavedState bzo;
  private int bzp;
  private int bzq;
  private SparseArray<View> bzr;
  private View bzs;
  private int bzt;
  private final Context mContext;
  private boolean mIsRtl;
  
  static
  {
    AppMethodBeat.i(62405);
    if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bzj = new Rect();
      AppMethodBeat.o(62405);
      return;
    }
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62330);
    this.byS = -1;
    this.byL = new ArrayList();
    this.bzb = new c(this);
    this.bzm = new a((byte)0);
    this.aou = -1;
    this.aov = -2147483648;
    this.bzp = -2147483648;
    this.bzq = -2147483648;
    this.bzr = new SparseArray();
    this.bzt = -1;
    this.bzc = new c.a();
    paramAttributeSet = c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    switch (paramAttributeSet.orientation)
    {
    }
    for (;;)
    {
      if (this.byO != 1)
      {
        if (this.byO == 0)
        {
          removeAllViews();
          wj();
        }
        this.byO = 1;
        this.aoo = null;
        this.bzn = null;
        requestLayout();
      }
      if (this.byQ != 4)
      {
        removeAllViews();
        wj();
        this.byQ = 4;
        requestLayout();
      }
      this.arw = true;
      this.mContext = paramContext;
      AppMethodBeat.o(62330);
      return;
      if (paramAttributeSet.arF)
      {
        setFlexDirection(1);
      }
      else
      {
        setFlexDirection(0);
        continue;
        if (paramAttributeSet.arF) {
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
    wi();
    jP();
    int j = this.aoo.kl();
    int k = this.aoo.km();
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
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).arH.isRemoved()) {
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
      if ((this.aoo.bn(localView) < j) || (this.aoo.bo(localView) > k))
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
    if ((!vX()) && (this.mIsRtl))
    {
      if (this.aoo.getEnd() - this.aoo.bn(paramView) <= paramInt)
      {
        AppMethodBeat.o(62366);
        return true;
      }
      AppMethodBeat.o(62366);
      return false;
    }
    if (this.aoo.bo(paramView) <= paramInt)
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
    if ((!vX()) && (this.mIsRtl))
    {
      if (this.aoo.bo(paramView) <= paramInt)
      {
        AppMethodBeat.o(62368);
        return true;
      }
      AppMethodBeat.o(62368);
      return false;
    }
    if (this.aoo.bn(paramView) >= this.aoo.getEnd() - paramInt)
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
    if ((!vX()) && (this.mIsRtl))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
      i = paramInt - this.aoo.kl();
      if (i <= 0) {
        break label99;
      }
      i = d(i, paramo, paramt);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramInt = this.aoo.km() - (paramInt + i);
        if (paramInt > 0)
        {
          this.aoo.cf(paramInt);
          AppMethodBeat.o(62357);
          return i + paramInt;
          i = 0;
          break;
          label99:
          AppMethodBeat.o(62357);
          return 0;
          label106:
          i = this.aoo.km() - paramInt;
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
    if (paramb.aoG != -2147483648)
    {
      if (paramb.anU < 0) {
        paramb.aoG += paramb.anU;
      }
      a(paramo, paramb);
    }
    int i2 = paramb.anU;
    int j = paramb.anU;
    boolean bool = vX();
    int k = 0;
    Object localObject;
    int i;
    int n;
    int i3;
    int m;
    if ((j > 0) || (this.bzl.aoa))
    {
      localObject = this.byL;
      if ((paramb.mPosition >= 0) && (paramb.mPosition < paramt.getItemCount()) && (paramb.bzu >= 0) && (paramb.bzu < ((List)localObject).size())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = (b)this.byL.get(paramb.bzu);
          paramb.mPosition = ((b)localObject).byF;
          if (vX())
          {
            if ((!$assertionsDisabled) && (this.bzb.byJ == null))
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
            m = paramb.MW;
            if (paramb.mLayoutDirection != -1) {
              break label1167;
            }
            m -= ((b)localObject).byy;
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
      switch (this.byP)
      {
      default: 
        paramo = new IllegalStateException("Invalid justifyContent is set: " + this.byP);
        AppMethodBeat.o(62363);
        throw paramo;
      case 0: 
        f1 = i;
        f2 = i3 - n;
        f4 = a.i(this.bzm);
        f2 -= a.i(this.bzm);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i3 = ((b)localObject).asn;
        f1 -= f4;
        n = i1;
        if (n < i1 + i3)
        {
          localView = ff(n);
          if (localView == null) {
            break label1164;
          }
          if (paramb.mLayoutDirection == 1)
          {
            f(localView, bzj);
            addView(localView);
            long l = this.bzb.byJ[n];
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
            this.bzb.a(localView, (b)localObject, Math.round(f2) - localView.getMeasuredWidth(), i4, Math.round(f2), localView.getMeasuredHeight() + i4);
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
        f1 = i3 - ((b)localObject).byw + n;
        f2 = ((b)localObject).byw - i;
        break label348;
        f1 = i + (i3 - ((b)localObject).byw) / 2.0F;
        f2 = i3 - n - (i3 - ((b)localObject).byw) / 2.0F;
        break label348;
        f3 = f1;
        if (((b)localObject).asn != 0) {
          f3 = (i3 - ((b)localObject).byw) / ((b)localObject).asn;
        }
        f1 = i + f3 / 2.0F;
        f2 = i3 - n - f3 / 2.0F;
        break label348;
        f2 = i;
        if (((b)localObject).asn != 1) {}
        for (f1 = ((b)localObject).asn - 1;; f1 = 1.0F)
        {
          f3 = (i3 - ((b)localObject).byw) / f1;
          f4 = i3 - n;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (((b)localObject).asn != 0) {
          f3 = (i3 - ((b)localObject).byw) / (((b)localObject).asn + 1);
        }
        f1 = i + f3;
        f2 = i3 - n - f3;
        break label348;
        f(localView, bzj);
        addView(localView, i);
        i += 1;
        break label446;
        label938:
        this.bzb.a(localView, (b)localObject, Math.round(f1), i4, Math.round(f1) + localView.getMeasuredWidth(), localView.getMeasuredHeight() + i4);
        break label594;
        paramb.bzu += this.bzl.mLayoutDirection;
        i = ((b)localObject).byy;
        label1001:
        if ((!bool) && (this.mIsRtl)) {}
        for (paramb.MW -= ((b)localObject).byy * paramb.mLayoutDirection;; paramb.MW += ((b)localObject).byy * paramb.mLayoutDirection)
        {
          m = ((b)localObject).byy;
          k = i + k;
          j -= m;
          break;
          i = a((b)localObject, paramb);
          break label1001;
        }
        paramb.anU -= k;
        if (paramb.aoG != -2147483648)
        {
          paramb.aoG += k;
          if (paramb.anU < 0) {
            paramb.aoG += paramb.anU;
          }
          a(paramo, paramb);
        }
        i = paramb.anU;
        AppMethodBeat.o(62363);
        return i2 - i;
      }
    }
  }
  
  private int a(b paramb, b paramb1)
  {
    AppMethodBeat.i(62370);
    if ((!$assertionsDisabled) && (this.bzb.byJ == null))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(62370);
      throw paramb;
    }
    int i = getPaddingTop();
    int m = getPaddingBottom();
    int i1 = this.mHeight;
    int k = paramb1.MW;
    int j = paramb1.MW;
    int n;
    if (paramb1.mLayoutDirection == -1)
    {
      n = paramb.byy;
      j += paramb.byy;
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
      switch (this.byP)
      {
      default: 
        paramb = new IllegalStateException("Invalid justifyContent is set: " + this.byP);
        AppMethodBeat.o(62370);
        throw paramb;
      case 0: 
        f1 = i;
        f2 = i1 - m;
        f4 = f1 - a.i(this.bzm);
        f1 = f2 - a.i(this.bzm);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i1 = paramb.asn;
        m = n;
        f2 = f4;
        if (m < n + i1)
        {
          localView = ff(m);
          if (localView == null) {
            break label980;
          }
          long l = this.bzb.byJ[m];
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
            f(localView, bzj);
            addView(localView);
            label391:
            i2 = k + bM(localView);
            i3 = j - bN(localView);
            if (!this.mIsRtl) {
              break label838;
            }
            if (!this.bzk) {
              break label775;
            }
            this.bzb.a(localView, paramb, this.mIsRtl, i3 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i3, Math.round(f1));
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
        f1 = i1 - paramb.byw + m;
        f2 = paramb.byw - i;
        break;
        f1 = i + (i1 - paramb.byw) / 2.0F;
        f2 = i1 - m - (i1 - paramb.byw) / 2.0F;
        break;
        f3 = f1;
        if (paramb.asn != 0) {
          f3 = (i1 - paramb.byw) / paramb.asn;
        }
        f1 = i + f3 / 2.0F;
        f2 = i1 - m - f3 / 2.0F;
        break;
        f2 = i;
        if (paramb.asn != 1) {}
        for (f1 = paramb.asn - 1;; f1 = 1.0F)
        {
          f3 = (i1 - paramb.byw) / f1;
          f4 = i1 - m;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (paramb.asn != 0) {
          f3 = (i1 - paramb.byw) / (paramb.asn + 1);
        }
        f1 = i + f3;
        f2 = i1 - m - f3;
        break;
        f(localView, bzj);
        addView(localView, i);
        i += 1;
        break label391;
        c localc = this.bzb;
        boolean bool = this.mIsRtl;
        i2 = localView.getMeasuredWidth();
        int i4 = Math.round(f2);
        int i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i3 - i2, i4, i3, localView.getMeasuredHeight() + i5);
        break label463;
        if (this.bzk)
        {
          this.bzb.a(localView, paramb, this.mIsRtl, i2, Math.round(f1) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f1));
          break label463;
        }
        localc = this.bzb;
        bool = this.mIsRtl;
        i3 = Math.round(f2);
        i4 = localView.getMeasuredWidth();
        i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i2, i3, i2 + i4, localView.getMeasuredHeight() + i5);
        break label463;
        paramb1.bzu += this.bzl.mLayoutDirection;
        i = paramb.byy;
        AppMethodBeat.o(62370);
        return i;
      }
    }
  }
  
  private View a(View paramView, b paramb)
  {
    AppMethodBeat.i(62387);
    boolean bool = vX();
    int j = paramb.asn;
    int i = 1;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.aoo.bo(paramView) >= this.aoo.bo(localView)) {
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
        if (this.aoo.bn(paramView) <= this.aoo.bn(localView)) {
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
    if (!paramb.bzy)
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
      wh();
      if ((vX()) || (!this.mIsRtl)) {
        break label212;
      }
    }
    label212:
    for (this.bzl.anU = (a.j(parama) - getPaddingRight());; this.bzl.anU = (this.aoo.km() - a.j(parama)))
    {
      this.bzl.mPosition = a.e(parama);
      this.bzl.anW = 1;
      this.bzl.mLayoutDirection = 1;
      this.bzl.MW = a.j(parama);
      this.bzl.aoG = -2147483648;
      this.bzl.bzu = a.f(parama);
      if ((paramBoolean1) && (this.byL.size() > 1) && (a.f(parama) >= 0) && (a.f(parama) < this.byL.size() - 1))
      {
        parama = (b)this.byL.get(a.f(parama));
        b.a(this.bzl);
        b localb = this.bzl;
        int i = localb.mPosition;
        localb.mPosition = (parama.asn + i);
      }
      AppMethodBeat.o(62371);
      return;
      this.bzl.aoa = false;
      break;
    }
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(62356);
    int i;
    if ((!vX()) && (this.mIsRtl))
    {
      i = this.aoo.km() - paramInt;
      if (i > 0) {
        i = d(-i, paramo, paramt);
      }
    }
    while (paramBoolean)
    {
      paramInt = paramInt + i - this.aoo.kl();
      if (paramInt > 0)
      {
        this.aoo.cf(-paramInt);
        AppMethodBeat.o(62356);
        return i - paramInt;
        AppMethodBeat.o(62356);
        return 0;
        i = paramInt - this.aoo.kl();
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
    boolean bool = vX();
    int i = getChildCount();
    int j = getChildCount();
    int k = paramb.asn;
    i -= 2;
    if (i > j - k - 1)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.aoo.bn(paramView) <= this.aoo.bn(localView)) {
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
        if (this.aoo.bo(paramView) >= this.aoo.bo(localView)) {
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
    if (paramb.aoG < 0)
    {
      AppMethodBeat.o(62365);
      return;
    }
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
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
    int k = this.bzb.byI[bB(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62365);
      return;
    }
    localObject1 = (b)this.byL.get(k);
    int i = 0;
    for (;;)
    {
      m = j;
      if (i >= n) {
        break label243;
      }
      View localView = getChildAt(i);
      m = j;
      if (!K(localView, paramb.aoG)) {
        break label243;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).aak == bB(localView))
      {
        if (k >= this.byL.size() - 1) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.byL.get(m);
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
      wh();
      if ((vX()) || (!this.mIsRtl)) {
        break label204;
      }
    }
    label204:
    for (this.bzl.anU = (this.bzs.getWidth() - a.j(parama) - this.aoo.kl());; this.bzl.anU = (a.j(parama) - this.aoo.kl()))
    {
      this.bzl.mPosition = a.e(parama);
      this.bzl.anW = 1;
      this.bzl.mLayoutDirection = -1;
      this.bzl.MW = a.j(parama);
      this.bzl.aoG = -2147483648;
      this.bzl.bzu = a.f(parama);
      if ((paramBoolean1) && (a.f(parama) > 0) && (this.byL.size() > a.f(parama)))
      {
        parama = (b)this.byL.get(a.f(parama));
        b.b(this.bzl);
        b localb = this.bzl;
        localb.mPosition -= parama.asn;
      }
      AppMethodBeat.o(62372);
      return;
      this.bzl.aoa = false;
      break;
    }
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62398);
    if ((paramView.isLayoutRequested()) || (!this.arx) || (!n(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!n(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(62398);
      return true;
    }
    AppMethodBeat.o(62398);
    return false;
  }
  
  private void bs(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(62386);
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(62386);
      throw ((Throwable)localObject1);
    }
    this.bzl.mLayoutDirection = paramInt1;
    boolean bool = vX();
    int k = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.arB);
    int m = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.arC);
    int i;
    Object localObject2;
    if ((!bool) && (this.mIsRtl))
    {
      i = 1;
      if (paramInt1 != 1) {
        break label560;
      }
      localObject1 = getChildAt(getChildCount() - 1);
      this.bzl.MW = this.aoo.bo((View)localObject1);
      paramInt1 = bB((View)localObject1);
      j = this.bzb.byI[paramInt1];
      localObject1 = b((View)localObject1, (b)this.byL.get(j));
      this.bzl.anW = 1;
      localObject2 = this.bzl;
      ((b)localObject2).mPosition = (((b)localObject2).anW + paramInt1);
      if (this.bzb.byI.length > this.bzl.mPosition) {
        break label457;
      }
      this.bzl.bzu = -1;
      label221:
      if (i == 0) {
        break label487;
      }
      this.bzl.MW = this.aoo.bn((View)localObject1);
      this.bzl.aoG = (-this.aoo.bn((View)localObject1) + this.aoo.kl());
      localObject1 = this.bzl;
      if (this.bzl.aoG < 0) {
        break label482;
      }
      paramInt1 = this.bzl.aoG;
      label290:
      ((b)localObject1).aoG = paramInt1;
      label296:
      if (((this.bzl.bzu == -1) || (this.bzl.bzu > this.byL.size() - 1)) && (this.bzl.mPosition <= getFlexItemCount()))
      {
        paramInt1 = paramInt2 - this.bzl.aoG;
        this.bzc.reset();
        if (paramInt1 > 0)
        {
          if (!bool) {
            break label530;
          }
          this.bzb.a(this.bzc, k, m, paramInt1, this.bzl.mPosition, this.byL);
        }
      }
    }
    for (;;)
    {
      this.bzb.y(k, m, this.bzl.mPosition);
      this.bzb.fj(this.bzl.mPosition);
      localObject1 = this.bzl;
      ((b)localObject1).anU = (paramInt2 - ((b)localObject1).aoG);
      AppMethodBeat.o(62386);
      return;
      i = 0;
      break;
      label457:
      this.bzl.bzu = this.bzb.byI[this.bzl.mPosition];
      break label221;
      label482:
      paramInt1 = 0;
      break label290;
      label487:
      this.bzl.MW = this.aoo.bo((View)localObject1);
      this.bzl.aoG = (this.aoo.bo((View)localObject1) - this.aoo.km());
      break label296;
      label530:
      this.bzb.c(this.bzc, k, m, paramInt1, this.bzl.mPosition, this.byL);
    }
    label560:
    Object localObject1 = getChildAt(0);
    this.bzl.MW = this.aoo.bn((View)localObject1);
    k = bB((View)localObject1);
    paramInt1 = this.bzb.byI[k];
    localObject1 = a((View)localObject1, (b)this.byL.get(paramInt1));
    this.bzl.anW = 1;
    paramInt1 = this.bzb.byI[k];
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        localObject2 = (b)this.byL.get(paramInt1 - 1);
        this.bzl.mPosition = (k - ((b)localObject2).asn);
        label684:
        localObject2 = this.bzl;
        if (paramInt1 <= 0) {
          break label795;
        }
        paramInt1 -= 1;
      }
      for (;;)
      {
        ((b)localObject2).bzu = paramInt1;
        if (i == 0) {
          break label800;
        }
        this.bzl.MW = this.aoo.bo((View)localObject1);
        this.bzl.aoG = (this.aoo.bo((View)localObject1) - this.aoo.km());
        localObject1 = this.bzl;
        paramInt1 = j;
        if (this.bzl.aoG >= 0) {
          paramInt1 = this.bzl.aoG;
        }
        ((b)localObject1).aoG = paramInt1;
        break;
        this.bzl.mPosition = -1;
        break label684;
        label795:
        paramInt1 = 0;
      }
      label800:
      this.bzl.MW = this.aoo.bn((View)localObject1);
      this.bzl.aoG = (-this.aoo.bn((View)localObject1) + this.aoo.kl());
      break;
    }
  }
  
  private View bt(int paramInt1, int paramInt2)
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
    if (paramb.aoG < 0)
    {
      AppMethodBeat.o(62367);
      return;
    }
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
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
    int k = this.bzb.byI[bB(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62367);
      return;
    }
    localObject1 = (b)this.byL.get(k);
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
      if (!L(localView, paramb.aoG)) {
        break label237;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).byF == bB(localView))
      {
        if (k <= 0) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.byL.get(m);
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
    wi();
    this.bzl.bzy = true;
    int j;
    if ((!vX()) && (this.mIsRtl))
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
      bs(i, k);
      m = this.bzl.aoG + a(paramo, paramt, this.bzl);
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
      this.aoo.cf(-paramInt);
      this.bzl.aoJ = paramInt;
      AppMethodBeat.o(62384);
      return paramInt;
      if (k > m) {
        paramInt = i * m;
      }
    }
  }
  
  private void fr(int paramInt)
  {
    AppMethodBeat.i(62354);
    int i = jW();
    int j = jY();
    if (paramInt >= j)
    {
      AppMethodBeat.o(62354);
      return;
    }
    int k = getChildCount();
    this.bzb.fl(k);
    this.bzb.fk(k);
    this.bzb.fm(k);
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62354);
      throw ((Throwable)localObject);
    }
    if (paramInt >= this.bzb.byI.length)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.bzt = paramInt;
    Object localObject = jS();
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
    this.aou = bB((View)localObject);
    if ((!vX()) && (this.mIsRtl))
    {
      this.aov = (this.aoo.bo((View)localObject) + this.aoo.getEndPadding());
      AppMethodBeat.o(62354);
      return;
    }
    this.aov = (this.aoo.bn((View)localObject) - this.aoo.kl());
    AppMethodBeat.o(62354);
  }
  
  private View fs(int paramInt)
  {
    AppMethodBeat.i(62359);
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
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
    paramInt = this.bzb.byI[paramInt];
    if (paramInt == -1)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    localObject = a((View)localObject, (b)this.byL.get(paramInt));
    AppMethodBeat.o(62359);
    return localObject;
  }
  
  private View ft(int paramInt)
  {
    AppMethodBeat.i(62360);
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
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
    paramInt = this.bzb.byI[paramInt];
    localObject = b((View)localObject, (b)this.byL.get(paramInt));
    AppMethodBeat.o(62360);
    return localObject;
  }
  
  private int fu(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(62385);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62385);
      return 0;
    }
    wi();
    boolean bool = vX();
    int i;
    int j;
    if (bool)
    {
      i = this.bzs.getWidth();
      if (!bool) {
        break label127;
      }
      j = this.mWidth;
      label61:
      if (t.Y(this.alu) == 1) {
        k = 1;
      }
      if (k == 0) {
        break label161;
      }
      k = Math.abs(paramInt);
      if (paramInt >= 0) {
        break label135;
      }
      i = -Math.min(j + a.i(this.bzm) - i, k);
    }
    for (;;)
    {
      AppMethodBeat.o(62385);
      return i;
      i = this.bzs.getHeight();
      break;
      label127:
      j = this.mHeight;
      break label61;
      label135:
      i = paramInt;
      if (a.i(this.bzm) + paramInt > 0)
      {
        i = -a.i(this.bzm);
        continue;
        label161:
        if (paramInt > 0)
        {
          i = Math.min(j - a.i(this.bzm) - i, paramInt);
        }
        else
        {
          i = paramInt;
          if (a.i(this.bzm) + paramInt < 0) {
            i = -a.i(this.bzm);
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
    View localView1 = fs(i);
    View localView2 = ft(i);
    if ((paramt.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
    {
      paramt = new AssertionError();
      AppMethodBeat.o(62394);
      throw paramt;
    }
    int k = bB(localView1);
    int j = bB(localView2);
    i = Math.abs(this.aoo.bo(localView2) - this.aoo.bn(localView1));
    k = this.bzb.byI[k];
    if ((k == 0) || (k == -1))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    j = this.bzb.byI[j];
    i = Math.round(i / (j - k + 1) * k + (this.aoo.kl() - this.aoo.bn(localView1)));
    AppMethodBeat.o(62394);
    return i;
  }
  
  private void jP()
  {
    AppMethodBeat.i(62375);
    if (this.bzl == null) {
      this.bzl = new b((byte)0);
    }
    AppMethodBeat.o(62375);
  }
  
  private View jS()
  {
    AppMethodBeat.i(210012);
    View localView = getChildAt(0);
    AppMethodBeat.o(210012);
    return localView;
  }
  
  private int jW()
  {
    AppMethodBeat.i(62402);
    View localView = bt(0, getChildCount());
    if (localView == null)
    {
      AppMethodBeat.o(62402);
      return -1;
    }
    int i = bB(localView);
    AppMethodBeat.o(62402);
    return i;
  }
  
  private int jY()
  {
    AppMethodBeat.i(62403);
    View localView = bt(getChildCount() - 1, -1);
    if (localView == null)
    {
      AppMethodBeat.o(62403);
      return -1;
    }
    int i = bB(localView);
    AppMethodBeat.o(62403);
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
    wi();
    View localView1 = fs(i);
    View localView2 = ft(i);
    if ((paramt.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62391);
      return 0;
    }
    i = this.aoo.bo(localView2);
    int j = this.aoo.bn(localView1);
    i = Math.min(this.aoo.kn(), i - j);
    AppMethodBeat.o(62391);
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
    View localView1 = fs(i);
    View localView2 = ft(i);
    if ((paramt.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62397);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bzb.byI == null))
    {
      paramt = new AssertionError();
      AppMethodBeat.o(62397);
      throw paramt;
    }
    i = jW();
    int j = jY();
    i = (int)(Math.abs(this.aoo.bo(localView2) - this.aoo.bn(localView1)) / (j - i + 1) * paramt.getItemCount());
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
    if (this.byN != paramInt)
    {
      removeAllViews();
      this.byN = paramInt;
      this.aoo = null;
      this.bzn = null;
      wj();
      requestLayout();
    }
    AppMethodBeat.o(62331);
  }
  
  private void wh()
  {
    AppMethodBeat.i(62373);
    int i;
    b localb;
    if (vX())
    {
      i = this.arC;
      localb = this.bzl;
      if ((i != 0) && (i != -2147483648)) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      localb.aoa = bool;
      AppMethodBeat.o(62373);
      return;
      i = this.arB;
      break;
    }
  }
  
  private void wi()
  {
    AppMethodBeat.i(62374);
    if (this.aoo != null)
    {
      AppMethodBeat.o(62374);
      return;
    }
    if (vX())
    {
      if (this.byO != 0)
      {
        this.aoo = aj.e(this);
        this.bzn = aj.d(this);
        AppMethodBeat.o(62374);
      }
    }
    else if (this.byO == 0)
    {
      this.aoo = aj.e(this);
      this.bzn = aj.d(this);
      AppMethodBeat.o(62374);
      return;
    }
    this.aoo = aj.d(this);
    this.bzn = aj.e(this);
    AppMethodBeat.o(62374);
  }
  
  private void wj()
  {
    AppMethodBeat.i(62400);
    this.byL.clear();
    a.b(this.bzm);
    a.d(this.bzm, 0);
    AppMethodBeat.o(62400);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(62382);
    if (!vX())
    {
      paramInt = d(paramInt, paramo, paramt);
      this.bzr.clear();
      AppMethodBeat.o(62382);
      return paramInt;
    }
    paramInt = fu(paramInt);
    paramo = this.bzm;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bzn.cf(-paramInt);
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
    this.bzr.put(paramInt, paramView);
    AppMethodBeat.o(62342);
  }
  
  public final void a(RecyclerView.t paramt)
  {
    AppMethodBeat.i(62358);
    super.a(paramt);
    this.bzo = null;
    this.aou = -1;
    this.aov = -2147483648;
    this.bzt = -1;
    a.b(this.bzm);
    this.bzr.clear();
    AppMethodBeat.o(62358);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62353);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    fr(Math.min(paramInt1, paramInt2));
    AppMethodBeat.o(62353);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(62350);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramObject);
    fr(paramInt1);
    AppMethodBeat.o(62350);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    AppMethodBeat.i(62379);
    super.a(paramRecyclerView, paramo);
    if (this.aow)
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
    paramRecyclerView.arZ = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(62377);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62334);
    f(paramView, bzj);
    if (vX())
    {
      paramInt1 = bM(paramView) + bN(paramView);
      paramb.byw += paramInt1;
      paramb.byx = (paramInt1 + paramb.byx);
      AppMethodBeat.o(62334);
      return;
    }
    paramInt1 = bK(paramView) + bL(paramView);
    paramb.byw += paramInt1;
    paramb.byx = (paramInt1 + paramb.byx);
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
    if (vX())
    {
      paramInt = d(paramInt, paramo, paramt);
      this.bzr.clear();
      AppMethodBeat.o(62383);
      return paramInt;
    }
    paramInt = fu(paramInt);
    paramo = this.bzm;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bzn.cf(-paramInt);
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
    for (paramInt = -1; vX(); paramInt = 1)
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
    this.apR = paramo;
    this.aqO = paramt;
    int k = paramt.getItemCount();
    if ((k == 0) && (paramt.asp))
    {
      AppMethodBeat.o(62355);
      return;
    }
    int i = t.Y(this.alu);
    a locala;
    Object localObject;
    boolean bool;
    switch (this.byN)
    {
    default: 
      this.mIsRtl = false;
      this.bzk = false;
      wi();
      jP();
      this.bzb.fl(k);
      this.bzb.fk(k);
      this.bzb.fm(k);
      this.bzl.bzy = false;
      if ((this.bzo != null) && (SavedState.c(this.bzo, k))) {
        this.aou = SavedState.b(this.bzo);
      }
      if ((a.a(this.bzm)) && (this.aou == -1) && (this.bzo == null)) {
        break label623;
      }
      a.b(this.bzm);
      locala = this.bzm;
      localObject = this.bzo;
      if ((!$assertionsDisabled) && (this.bzb.byI == null))
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
        if (this.byO != 2) {
          break label283;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bzk = bool;
        break;
        bool = false;
        break label251;
      }
    case 1: 
      if (i != 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.byO != 2) {
          break label329;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bzk = bool;
        break;
        bool = false;
        break label297;
      }
    case 2: 
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.byO == 2) {
          if (this.mIsRtl) {
            break label387;
          }
        }
      }
      label387:
      for (bool = true;; bool = false)
      {
        this.mIsRtl = bool;
        this.bzk = false;
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
        if (this.byO == 2) {
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
        this.bzk = true;
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
    if ((paramt.asp) || (this.aou == -1))
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
        localObject = ft(paramt.getItemCount());
        if (localObject == null) {
          break label1266;
        }
        a.a(locala, (View)localObject);
        if ((!paramt.asp) && (jK()))
        {
          if ((this.aoo.bn((View)localObject) < this.aoo.km()) && (this.aoo.bo((View)localObject) >= this.aoo.kl())) {
            break label1250;
          }
          i = 1;
          if (i != 0)
          {
            if (!a.d(locala)) {
              break label1255;
            }
            i = this.aoo.km();
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
      a.c(this.bzm);
      b(paramo);
      if (!a.d(this.bzm)) {
        break label1271;
      }
      b(this.bzm, false, true);
      m = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.arB);
      n = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.arC);
      i1 = this.mWidth;
      i2 = this.mHeight;
      if (!vX()) {
        break label1301;
      }
      if ((this.bzp == -2147483648) || (this.bzp == i1)) {
        break label1284;
      }
      i = 1;
      label713:
      if (!this.bzl.aoa) {
        break label1289;
      }
    }
    label1284:
    label1289:
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = this.bzl.anU)
    {
      this.bzp = i1;
      this.bzq = i2;
      if ((this.bzt != -1) || ((this.aou == -1) && (i == 0))) {
        break label1607;
      }
      if (a.d(this.bzm)) {
        break label1474;
      }
      this.byL.clear();
      if (($assertionsDisabled) || (this.bzb.byI != null)) {
        break label1366;
      }
      paramo = new AssertionError();
      AppMethodBeat.o(62355);
      throw paramo;
      if ((this.aou < 0) || (this.aou >= paramt.getItemCount()))
      {
        this.aou = -1;
        this.aov = -2147483648;
        i = 0;
        break;
      }
      a.b(locala, this.aou);
      a.a(locala, this.bzb.byI[a.e(locala)]);
      if ((this.bzo != null) && (SavedState.c(this.bzo, paramt.getItemCount())))
      {
        i = this.aoo.kl();
        a.c(locala, SavedState.c((SavedState)localObject) + i);
        a.h(locala);
        a.a(locala, -1);
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.aov == -2147483648)
        {
          localObject = bY(this.aou);
          if (localObject != null)
          {
            if (this.aoo.br((View)localObject) > this.aoo.kn())
            {
              a.g(locala);
            }
            else if (this.aoo.bn((View)localObject) - this.aoo.kl() < 0)
            {
              a.c(locala, this.aoo.kl());
              a.a(locala, false);
            }
            else if (this.aoo.km() - this.aoo.bo((View)localObject) < 0)
            {
              a.c(locala, this.aoo.km());
              a.a(locala, true);
            }
            else
            {
              if (a.d(locala)) {}
              for (i = this.aoo.bo((View)localObject) + this.aoo.kk();; i = this.aoo.bn((View)localObject))
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
              if (this.aou >= i) {
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
        else if ((!vX()) && (this.mIsRtl))
        {
          a.c(locala, this.aov - this.aoo.getEndPadding());
        }
        else
        {
          a.c(locala, this.aoo.kl() + this.aov);
        }
      }
      label1237:
      localObject = fs(paramt.getItemCount());
      break label497;
      label1250:
      i = 0;
      break label563;
      label1255:
      i = this.aoo.kl();
      break label583;
      label1266:
      i = 0;
      break label592;
      label1271:
      a(this.bzm, false, true);
      break label648;
      i = 0;
      break label713;
    }
    label1301:
    if ((this.bzq != -2147483648) && (this.bzq != i2))
    {
      i = 1;
      label1321:
      if (!this.bzl.aoa) {
        break label1354;
      }
    }
    label1354:
    for (j = this.mContext.getResources().getDisplayMetrics().widthPixels;; j = this.bzl.anU)
    {
      break;
      i = 0;
      break label1321;
    }
    label1366:
    this.bzc.reset();
    if (vX())
    {
      this.bzb.b(this.bzc, m, n, j, a.e(this.bzm), this.byL);
      this.byL = this.bzc.byL;
      this.bzb.bo(m, n);
      this.bzb.wf();
      a.a(this.bzm, this.bzb.byI[a.e(this.bzm)]);
      this.bzl.bzu = a.f(this.bzm);
      label1474:
      if (!a.d(this.bzm)) {
        break label1866;
      }
      a(paramo, paramt, this.bzl);
      j = this.bzl.MW;
      a(this.bzm, true, false);
      a(paramo, paramt, this.bzl);
      i = this.bzl.MW;
    }
    for (;;)
    {
      if (getChildCount() > 0)
      {
        if (a.d(this.bzm))
        {
          b(a(i, paramo, paramt, true) + j, paramo, paramt, false);
          AppMethodBeat.o(62355);
          return;
          this.bzb.d(this.bzc, m, n, j, a.e(this.bzm), this.byL);
          break;
          label1607:
          if (this.bzt != -1)
          {
            i = Math.min(this.bzt, a.e(this.bzm));
            label1630:
            this.bzc.reset();
            if (!vX()) {
              break label1776;
            }
            if (this.byL.size() <= 0) {
              break label1742;
            }
            this.bzb.c(this.byL, i);
            this.bzb.a(this.bzc, m, n, j, i, a.e(this.bzm), this.byL);
          }
          for (;;)
          {
            this.byL = this.bzc.byL;
            this.bzb.y(m, n, i);
            this.bzb.fj(i);
            break;
            i = a.e(this.bzm);
            break label1630;
            label1742:
            this.bzb.fm(k);
            this.bzb.a(this.bzc, m, n, j, 0, this.byL);
            continue;
            label1776:
            if (this.byL.size() > 0)
            {
              this.bzb.c(this.byL, i);
              this.bzb.a(this.bzc, n, m, j, i, a.e(this.bzm), this.byL);
            }
            else
            {
              this.bzb.fm(k);
              this.bzb.c(this.bzc, m, n, j, 0, this.byL);
            }
          }
          label1866:
          a(paramo, paramt, this.bzl);
          i = this.bzl.MW;
          b(this.bzm, true, false);
          a(paramo, paramt, this.bzl);
          j = this.bzl.MW;
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
    fr(paramInt1);
    AppMethodBeat.o(62349);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(62376);
    this.aou = paramInt;
    this.aov = -2147483648;
    if (this.bzo != null) {
      SavedState.a(this.bzo);
    }
    requestLayout();
    AppMethodBeat.o(62376);
  }
  
  public final int cj(View paramView)
  {
    AppMethodBeat.i(62333);
    if (vX())
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
    fr(paramInt1);
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
  
  public final View ff(int paramInt)
  {
    AppMethodBeat.i(62336);
    View localView = (View)this.bzr.get(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(62336);
      return localView;
    }
    localView = this.apR.cu(paramInt);
    AppMethodBeat.o(62336);
    return localView;
  }
  
  public final View fg(int paramInt)
  {
    AppMethodBeat.i(62337);
    View localView = ff(paramInt);
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
    this.bzs = ((View)paramRecyclerView.getParent());
    AppMethodBeat.o(62378);
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62351);
    super.g(paramRecyclerView, paramInt1, paramInt2);
    fr(paramInt1);
    AppMethodBeat.o(62351);
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.byQ;
  }
  
  public int getFlexDirection()
  {
    return this.byN;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(62335);
    int i = this.aqO.getItemCount();
    AppMethodBeat.o(62335);
    return i;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.byL;
  }
  
  public int getFlexWrap()
  {
    return this.byO;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62340);
    if (this.byL.size() == 0)
    {
      AppMethodBeat.o(62340);
      return 0;
    }
    int j = -2147483648;
    int k = this.byL.size();
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, ((b)this.byL.get(i)).byw);
      i += 1;
    }
    AppMethodBeat.o(62340);
    return j;
  }
  
  public int getMaxLine()
  {
    return this.byS;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62341);
    int k = this.byL.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((b)this.byL.get(i)).byy;
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
  
  public final RecyclerView.LayoutParams jG()
  {
    AppMethodBeat.i(62344);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(62344);
    return localLayoutParams;
  }
  
  public final boolean jM()
  {
    AppMethodBeat.i(62380);
    if ((!vX()) || (this.mWidth > this.bzs.getWidth()))
    {
      AppMethodBeat.o(62380);
      return true;
    }
    AppMethodBeat.o(62380);
    return false;
  }
  
  public final boolean jN()
  {
    AppMethodBeat.i(62381);
    if ((vX()) || (this.mHeight > this.bzs.getHeight()))
    {
      AppMethodBeat.o(62381);
      return true;
    }
    AppMethodBeat.o(62381);
    return false;
  }
  
  public final void lg()
  {
    AppMethodBeat.i(62346);
    removeAllViews();
    AppMethodBeat.o(62346);
  }
  
  public final int m(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62332);
    if (vX())
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
      this.bzo = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(62348);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(62347);
    if (this.bzo != null)
    {
      localSavedState = new SavedState(this.bzo, (byte)0);
      AppMethodBeat.o(62347);
      return localSavedState;
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      SavedState.a(localSavedState, bB(localView));
      SavedState.b(localSavedState, this.aoo.bn(localView) - this.aoo.kl());
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
    this.byL = paramList;
  }
  
  public final boolean vX()
  {
    return (this.byN == 0) || (this.byN == 1);
  }
  
  public final int w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62338);
    paramInt1 = b(this.mWidth, this.arB, paramInt2, paramInt3, jM());
    AppMethodBeat.o(62338);
    return paramInt1;
  }
  
  public final int x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62339);
    paramInt1 = b(this.mHeight, this.arC, paramInt2, paramInt3, jN());
    AppMethodBeat.o(62339);
    return paramInt1;
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private float bze;
    private float bzf;
    private int bzg;
    private float bzh;
    private boolean bzi;
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
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(-2);
      AppMethodBeat.i(62322);
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bze = paramParcel.readFloat();
      this.bzf = paramParcel.readFloat();
      this.bzg = paramParcel.readInt();
      this.bzh = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bzi = bool;
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
      return this.bze;
    }
    
    public final float getFlexShrink()
    {
      return this.bzf;
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
    
    public final int vY()
    {
      return this.bzg;
    }
    
    public final boolean vZ()
    {
      return this.bzi;
    }
    
    public final float wa()
    {
      return this.bzh;
    }
    
    public final int wb()
    {
      return this.leftMargin;
    }
    
    public final int wc()
    {
      return this.topMargin;
    }
    
    public final int wd()
    {
      return this.rightMargin;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62321);
      paramParcel.writeFloat(this.bze);
      paramParcel.writeFloat(this.bzf);
      paramParcel.writeInt(this.bzg);
      paramParcel.writeFloat(this.bzh);
      paramParcel.writeInt(this.mMinWidth);
      paramParcel.writeInt(this.mMinHeight);
      paramParcel.writeInt(this.mMaxWidth);
      paramParcel.writeInt(this.mMaxHeight);
      if (this.bzi) {}
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
    private int aoL;
    private int aoM;
    
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
      this.aoL = paramParcel.readInt();
      this.aoM = paramParcel.readInt();
      AppMethodBeat.o(62327);
    }
    
    private SavedState(SavedState paramSavedState)
    {
      this.aoL = paramSavedState.aoL;
      this.aoM = paramSavedState.aoM;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(62328);
      String str = "SavedState{mAnchorPosition=" + this.aoL + ", mAnchorOffset=" + this.aoM + '}';
      AppMethodBeat.o(62328);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62326);
      paramParcel.writeInt(this.aoL);
      paramParcel.writeInt(this.aoM);
      AppMethodBeat.o(62326);
    }
  }
  
  final class a
  {
    private int aoB;
    private boolean aoC;
    private boolean aoD;
    private int bzu;
    private int bzv = 0;
    private boolean bzw;
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
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bzu + ", mCoordinate=" + this.aoB + ", mPerpendicularCoordinate=" + this.bzv + ", mLayoutFromEnd=" + this.aoC + ", mValid=" + this.aoD + ", mAssignedFromSavedState=" + this.bzw + '}';
      AppMethodBeat.o(62315);
      return str;
    }
  }
  
  static final class b
  {
    int MW;
    int anU;
    int anW = 1;
    int aoG;
    int aoJ;
    boolean aoa;
    int bzu;
    boolean bzy;
    int mLayoutDirection = 1;
    int mPosition;
    
    public final String toString()
    {
      AppMethodBeat.i(62324);
      String str = "LayoutState{mAvailable=" + this.anU + ", mFlexLinePosition=" + this.bzu + ", mPosition=" + this.mPosition + ", mOffset=" + this.MW + ", mScrollingOffset=" + this.aoG + ", mLastScrollDelta=" + this.aoJ + ", mItemDirection=" + this.anW + ", mLayoutDirection=" + this.mLayoutDirection + '}';
      AppMethodBeat.o(62324);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager
 * JD-Core Version:    0.7.0.1
 */