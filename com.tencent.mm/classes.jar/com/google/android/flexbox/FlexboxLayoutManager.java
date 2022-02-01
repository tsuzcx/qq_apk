package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.b;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
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
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b, a
{
  private static final Rect bJN;
  private boolean aqA;
  private aj aqs;
  private int aqy;
  private int aqz;
  private RecyclerView.n arV;
  private RecyclerView.s asR;
  private final c bJF;
  private c.a bJG;
  private boolean bJO;
  private b bJP;
  private a bJQ;
  private aj bJR;
  private FlexboxLayoutManager.SavedState bJS;
  private int bJT;
  private int bJU;
  private SparseArray<View> bJV;
  private View bJW;
  private int bJX;
  private List<b> bJp;
  private int bJr;
  private int bJs;
  private int bJt;
  private int bJu;
  private int bJw;
  private final Context mContext;
  private boolean mIsRtl;
  
  static
  {
    AppMethodBeat.i(62405);
    if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bJN = new Rect();
      AppMethodBeat.o(62405);
      return;
    }
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62330);
    this.bJw = -1;
    this.bJp = new ArrayList();
    this.bJF = new c(this);
    this.bJQ = new a((byte)0);
    this.aqy = -1;
    this.aqz = -2147483648;
    this.bJT = -2147483648;
    this.bJU = -2147483648;
    this.bJV = new SparseArray();
    this.bJX = -1;
    this.bJG = new c.a();
    paramAttributeSet = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    switch (paramAttributeSet.orientation)
    {
    }
    for (;;)
    {
      if (this.bJs != 1)
      {
        if (this.bJs == 0)
        {
          removeAllViews();
          xO();
        }
        this.bJs = 1;
        this.aqs = null;
        this.bJR = null;
        requestLayout();
      }
      if (this.bJu != 4)
      {
        removeAllViews();
        xO();
        this.bJu = 4;
        requestLayout();
      }
      setAutoMeasureEnabled(true);
      this.mContext = paramContext;
      AppMethodBeat.o(62330);
      return;
      if (paramAttributeSet.atu)
      {
        setFlexDirection(1);
      }
      else
      {
        setFlexDirection(0);
        continue;
        if (paramAttributeSet.atu) {
          setFlexDirection(3);
        } else {
          setFlexDirection(2);
        }
      }
    }
  }
  
  private boolean I(View paramView, int paramInt)
  {
    AppMethodBeat.i(62366);
    if ((!xC()) && (this.mIsRtl))
    {
      if (this.aqs.getEnd() - this.aqs.bo(paramView) <= paramInt)
      {
        AppMethodBeat.o(62366);
        return true;
      }
      AppMethodBeat.o(62366);
      return false;
    }
    if (this.aqs.bp(paramView) <= paramInt)
    {
      AppMethodBeat.o(62366);
      return true;
    }
    AppMethodBeat.o(62366);
    return false;
  }
  
  private boolean J(View paramView, int paramInt)
  {
    AppMethodBeat.i(62368);
    if ((!xC()) && (this.mIsRtl))
    {
      if (this.aqs.bp(paramView) <= paramInt)
      {
        AppMethodBeat.o(62368);
        return true;
      }
      AppMethodBeat.o(62368);
      return false;
    }
    if (this.aqs.bo(paramView) >= this.aqs.getEnd() - paramInt)
    {
      AppMethodBeat.o(62368);
      return true;
    }
    AppMethodBeat.o(62368);
    return false;
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(62357);
    int i;
    if ((!xC()) && (this.mIsRtl))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
      i = paramInt - this.aqs.kH();
      if (i <= 0) {
        break label99;
      }
      i = b(i, paramn, params);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramInt = this.aqs.kI() - (paramInt + i);
        if (paramInt > 0)
        {
          this.aqs.ce(paramInt);
          AppMethodBeat.o(62357);
          return i + paramInt;
          i = 0;
          break;
          label99:
          AppMethodBeat.o(62357);
          return 0;
          label106:
          i = this.aqs.kI() - paramInt;
          if (i > 0)
          {
            i = -b(-i, paramn, params);
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
  
  private int a(RecyclerView.n paramn, RecyclerView.s params, b paramb)
  {
    AppMethodBeat.i(62363);
    if (paramb.aqK != -2147483648)
    {
      if (paramb.apY < 0) {
        paramb.aqK += paramb.apY;
      }
      a(paramn, paramb);
    }
    int i2 = paramb.apY;
    int j = paramb.apY;
    boolean bool = xC();
    int k = 0;
    Object localObject;
    int i;
    int n;
    int i3;
    int m;
    if ((j > 0) || (this.bJP.aqe))
    {
      localObject = this.bJp;
      if ((paramb.mPosition >= 0) && (paramb.mPosition < params.getItemCount()) && (paramb.bJY >= 0) && (paramb.bJY < ((List)localObject).size())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = (b)this.bJp.get(paramb.bJY);
          paramb.mPosition = ((b)localObject).bJj;
          if (xC())
          {
            if ((!$assertionsDisabled) && (this.bJF.bJn == null))
            {
              paramn = new AssertionError();
              AppMethodBeat.o(62363);
              throw paramn;
              i = 0;
              continue;
            }
            i = getPaddingLeft();
            n = getPaddingRight();
            i3 = getWidth();
            m = paramb.fs;
            if (paramb.mLayoutDirection != -1) {
              break label1172;
            }
            m -= ((b)localObject).bJc;
          }
        }
      }
    }
    label400:
    label1169:
    label1172:
    for (;;)
    {
      int i1 = paramb.mPosition;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      label348:
      float f4;
      View localView;
      label446:
      int i4;
      switch (this.bJt)
      {
      default: 
        paramn = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
        AppMethodBeat.o(62363);
        throw paramn;
      case 0: 
        f1 = i;
        f2 = i3 - n;
        f4 = a.i(this.bJQ);
        f2 -= a.i(this.bJQ);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i3 = ((b)localObject).auc;
        f1 -= f4;
        n = i1;
        if (n < i1 + i3)
        {
          localView = fj(n);
          if (localView == null) {
            break label1169;
          }
          if (paramb.mLayoutDirection == 1)
          {
            calculateItemDecorationsForChild(localView, bJN);
            addView(localView);
            long l = this.bJF.bJn[n];
            i4 = c.at(l);
            int i5 = c.au(l);
            FlexboxLayoutManager.LayoutParams localLayoutParams = (FlexboxLayoutManager.LayoutParams)localView.getLayoutParams();
            if (shouldMeasureChild(localView, i4, i5, localLayoutParams)) {
              localView.measure(i4, i5);
            }
            f1 += localLayoutParams.leftMargin + getLeftDecorationWidth(localView);
            f2 -= localLayoutParams.rightMargin + getRightDecorationWidth(localView);
            i4 = m + getTopDecorationHeight(localView);
            if (!this.mIsRtl) {
              break label943;
            }
            this.bJF.a(localView, (b)localObject, Math.round(f2) - localView.getMeasuredWidth(), i4, Math.round(f2), localView.getMeasuredHeight() + i4);
            label597:
            float f5 = localView.getMeasuredWidth() + localLayoutParams.rightMargin + getRightDecorationWidth(localView);
            i4 = localView.getMeasuredWidth();
            i5 = localLayoutParams.leftMargin;
            f4 = getLeftDecorationWidth(localView) + (i4 + i5);
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
        f1 = i3 - ((b)localObject).bJa + n;
        f2 = ((b)localObject).bJa - i;
        break label348;
        f1 = i + (i3 - ((b)localObject).bJa) / 2.0F;
        f2 = i3 - n - (i3 - ((b)localObject).bJa) / 2.0F;
        break label348;
        f3 = f1;
        if (((b)localObject).auc != 0) {
          f3 = (i3 - ((b)localObject).bJa) / ((b)localObject).auc;
        }
        f1 = i + f3 / 2.0F;
        f2 = i3 - n - f3 / 2.0F;
        break label348;
        f2 = i;
        if (((b)localObject).auc != 1) {}
        for (f1 = ((b)localObject).auc - 1;; f1 = 1.0F)
        {
          f3 = (i3 - ((b)localObject).bJa) / f1;
          f4 = i3 - n;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (((b)localObject).auc != 0) {
          f3 = (i3 - ((b)localObject).bJa) / (((b)localObject).auc + 1);
        }
        f1 = i + f3;
        f2 = i3 - n - f3;
        break label348;
        calculateItemDecorationsForChild(localView, bJN);
        addView(localView, i);
        i += 1;
        break label446;
        label943:
        this.bJF.a(localView, (b)localObject, Math.round(f1), i4, Math.round(f1) + localView.getMeasuredWidth(), localView.getMeasuredHeight() + i4);
        break label597;
        paramb.bJY += this.bJP.mLayoutDirection;
        i = ((b)localObject).bJc;
        label1006:
        if ((!bool) && (this.mIsRtl)) {}
        for (paramb.fs -= ((b)localObject).bJc * paramb.mLayoutDirection;; paramb.fs += ((b)localObject).bJc * paramb.mLayoutDirection)
        {
          m = ((b)localObject).bJc;
          k = i + k;
          j -= m;
          break;
          i = a((b)localObject, paramb);
          break label1006;
        }
        paramb.apY -= k;
        if (paramb.aqK != -2147483648)
        {
          paramb.aqK += k;
          if (paramb.apY < 0) {
            paramb.aqK += paramb.apY;
          }
          a(paramn, paramb);
        }
        i = paramb.apY;
        AppMethodBeat.o(62363);
        return i2 - i;
      }
    }
  }
  
  private int a(b paramb, b paramb1)
  {
    AppMethodBeat.i(62370);
    if ((!$assertionsDisabled) && (this.bJF.bJn == null))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(62370);
      throw paramb;
    }
    int i = getPaddingTop();
    int m = getPaddingBottom();
    int i1 = getHeight();
    int k = paramb1.fs;
    int j = paramb1.fs;
    int n;
    if (paramb1.mLayoutDirection == -1)
    {
      n = paramb.bJc;
      j += paramb.bJc;
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
      switch (this.bJt)
      {
      default: 
        paramb = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
        AppMethodBeat.o(62370);
        throw paramb;
      case 0: 
        f1 = i;
        f2 = i1 - m;
        f4 = f1 - a.i(this.bJQ);
        f1 = f2 - a.i(this.bJQ);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i1 = paramb.auc;
        m = n;
        f2 = f4;
        if (m < n + i1)
        {
          localView = fj(m);
          if (localView == null) {
            break label986;
          }
          long l = this.bJF.bJn[m];
          i2 = c.at(l);
          i3 = c.au(l);
          FlexboxLayoutManager.LayoutParams localLayoutParams = (FlexboxLayoutManager.LayoutParams)localView.getLayoutParams();
          if (shouldMeasureChild(localView, i2, i3, localLayoutParams)) {
            localView.measure(i2, i3);
          }
          f2 += localLayoutParams.topMargin + getTopDecorationHeight(localView);
          f1 -= localLayoutParams.rightMargin + getBottomDecorationHeight(localView);
          if (paramb1.mLayoutDirection == 1)
          {
            calculateItemDecorationsForChild(localView, bJN);
            addView(localView);
            label393:
            i2 = k + getLeftDecorationWidth(localView);
            i3 = j - getRightDecorationWidth(localView);
            if (!this.mIsRtl) {
              break label844;
            }
            if (!this.bJO) {
              break label781;
            }
            this.bJF.a(localView, paramb, this.mIsRtl, i3 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i3, Math.round(f1));
            label467:
            f2 = localView.getMeasuredHeight() + localLayoutParams.topMargin + getBottomDecorationHeight(localView) + f3 + f2;
            i2 = localView.getMeasuredHeight();
            i3 = localLayoutParams.bottomMargin;
            f1 -= getTopDecorationHeight(localView) + (i2 + i3) + f3;
          }
        }
        break;
      }
      label781:
      label844:
      label986:
      for (;;)
      {
        m += 1;
        break label253;
        f1 = i1 - paramb.bJa + m;
        f2 = paramb.bJa - i;
        break;
        f1 = i + (i1 - paramb.bJa) / 2.0F;
        f2 = i1 - m - (i1 - paramb.bJa) / 2.0F;
        break;
        f3 = f1;
        if (paramb.auc != 0) {
          f3 = (i1 - paramb.bJa) / paramb.auc;
        }
        f1 = i + f3 / 2.0F;
        f2 = i1 - m - f3 / 2.0F;
        break;
        f2 = i;
        if (paramb.auc != 1) {}
        for (f1 = paramb.auc - 1;; f1 = 1.0F)
        {
          f3 = (i1 - paramb.bJa) / f1;
          f4 = i1 - m;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (paramb.auc != 0) {
          f3 = (i1 - paramb.bJa) / (paramb.auc + 1);
        }
        f1 = i + f3;
        f2 = i1 - m - f3;
        break;
        calculateItemDecorationsForChild(localView, bJN);
        addView(localView, i);
        i += 1;
        break label393;
        c localc = this.bJF;
        boolean bool = this.mIsRtl;
        i2 = localView.getMeasuredWidth();
        int i4 = Math.round(f2);
        int i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i3 - i2, i4, i3, localView.getMeasuredHeight() + i5);
        break label467;
        if (this.bJO)
        {
          this.bJF.a(localView, paramb, this.mIsRtl, i2, Math.round(f1) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f1));
          break label467;
        }
        localc = this.bJF;
        bool = this.mIsRtl;
        i3 = Math.round(f2);
        i4 = localView.getMeasuredWidth();
        i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i2, i3, i2 + i4, localView.getMeasuredHeight() + i5);
        break label467;
        paramb1.bJY += this.bJP.mLayoutDirection;
        i = paramb.bJc;
        AppMethodBeat.o(62370);
        return i;
      }
    }
  }
  
  private View a(View paramView, b paramb)
  {
    AppMethodBeat.i(62387);
    boolean bool = xC();
    int j = paramb.auc;
    int i = 1;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.aqs.bp(paramView) >= this.aqs.bp(localView)) {
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
        if (this.aqs.bo(paramView) <= this.aqs.bo(localView)) {
          label115:
          paramb = paramView;
        }
      }
    }
    AppMethodBeat.o(62387);
    return paramView;
  }
  
  private void a(RecyclerView.n paramn, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62369);
    while (paramInt2 >= paramInt1)
    {
      removeAndRecycleViewAt(paramInt2, paramn);
      paramInt2 -= 1;
    }
    AppMethodBeat.o(62369);
  }
  
  private void a(RecyclerView.n paramn, b paramb)
  {
    AppMethodBeat.i(62364);
    if (!paramb.bKc)
    {
      AppMethodBeat.o(62364);
      return;
    }
    if (paramb.mLayoutDirection == -1)
    {
      c(paramn, paramb);
      AppMethodBeat.o(62364);
      return;
    }
    b(paramn, paramb);
    AppMethodBeat.o(62364);
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62371);
    if (paramBoolean2)
    {
      xM();
      if ((xC()) || (!this.mIsRtl)) {
        break label212;
      }
    }
    label212:
    for (this.bJP.apY = (a.j(parama) - getPaddingRight());; this.bJP.apY = (this.aqs.kI() - a.j(parama)))
    {
      this.bJP.mPosition = a.e(parama);
      this.bJP.aqa = 1;
      this.bJP.mLayoutDirection = 1;
      this.bJP.fs = a.j(parama);
      this.bJP.aqK = -2147483648;
      this.bJP.bJY = a.f(parama);
      if ((paramBoolean1) && (this.bJp.size() > 1) && (a.f(parama) >= 0) && (a.f(parama) < this.bJp.size() - 1))
      {
        parama = (b)this.bJp.get(a.f(parama));
        b.a(this.bJP);
        b localb = this.bJP;
        int i = localb.mPosition;
        localb.mPosition = (parama.auc + i);
      }
      AppMethodBeat.o(62371);
      return;
      this.bJP.aqe = false;
      break;
    }
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int i = 1;
    AppMethodBeat.i(62384);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62384);
      return 0;
    }
    xN();
    this.bJP.bKc = true;
    int j;
    if ((!xC()) && (this.mIsRtl))
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
      bo(i, k);
      m = this.bJP.aqK + a(paramn, params, this.bJP);
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
      this.aqs.ce(-paramInt);
      this.bJP.aqN = paramInt;
      AppMethodBeat.o(62384);
      return paramInt;
      if (k > m) {
        paramInt = i * m;
      }
    }
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(62356);
    int i;
    if ((!xC()) && (this.mIsRtl))
    {
      i = this.aqs.kI() - paramInt;
      if (i > 0) {
        i = b(-i, paramn, params);
      }
    }
    while (paramBoolean)
    {
      paramInt = paramInt + i - this.aqs.kH();
      if (paramInt > 0)
      {
        this.aqs.ce(-paramInt);
        AppMethodBeat.o(62356);
        return i - paramInt;
        AppMethodBeat.o(62356);
        return 0;
        i = paramInt - this.aqs.kH();
        if (i > 0)
        {
          i = -b(i, paramn, params);
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
    boolean bool = xC();
    int i = getChildCount();
    int j = getChildCount();
    int k = paramb.auc;
    i -= 2;
    if (i > j - k - 1)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.aqs.bo(paramView) <= this.aqs.bo(localView)) {
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
        if (this.aqs.bp(paramView) >= this.aqs.bp(localView)) {
          label133:
          paramb = paramView;
        }
      }
    }
    AppMethodBeat.o(62388);
    return paramView;
  }
  
  private void b(RecyclerView.n paramn, b paramb)
  {
    int j = -1;
    AppMethodBeat.i(62365);
    if (paramb.aqK < 0)
    {
      AppMethodBeat.o(62365);
      return;
    }
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      paramn = new AssertionError();
      AppMethodBeat.o(62365);
      throw paramn;
    }
    int n = getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(62365);
      return;
    }
    Object localObject1 = getChildAt(0);
    int k = this.bJF.bJm[getPosition(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62365);
      return;
    }
    localObject1 = (b)this.bJp.get(k);
    int i = 0;
    for (;;)
    {
      m = j;
      if (i >= n) {
        break label245;
      }
      View localView = getChildAt(i);
      m = j;
      if (!I(localView, paramb.aqK)) {
        break label245;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).acn == getPosition(localView))
      {
        if (k >= this.bJp.size() - 1) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bJp.get(m);
        j = i;
      }
      i += 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label245:
    a(paramn, 0, m);
    AppMethodBeat.o(62365);
  }
  
  private void b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62372);
    if (paramBoolean2)
    {
      xM();
      if ((xC()) || (!this.mIsRtl)) {
        break label204;
      }
    }
    label204:
    for (this.bJP.apY = (this.bJW.getWidth() - a.j(parama) - this.aqs.kH());; this.bJP.apY = (a.j(parama) - this.aqs.kH()))
    {
      this.bJP.mPosition = a.e(parama);
      this.bJP.aqa = 1;
      this.bJP.mLayoutDirection = -1;
      this.bJP.fs = a.j(parama);
      this.bJP.aqK = -2147483648;
      this.bJP.bJY = a.f(parama);
      if ((paramBoolean1) && (a.f(parama) > 0) && (this.bJp.size() > a.f(parama)))
      {
        parama = (b)this.bJp.get(a.f(parama));
        b.b(this.bJP);
        b localb = this.bJP;
        localb.mPosition -= parama.auc;
      }
      AppMethodBeat.o(62372);
      return;
      this.bJP.aqe = false;
      break;
    }
  }
  
  private boolean bW(View paramView)
  {
    AppMethodBeat.i(62401);
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int i4 = getWidth();
    int i5 = getPaddingRight();
    int k = getHeight();
    int m = getPaddingBottom();
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i6 = getDecoratedLeft(paramView);
    int i7 = localLayoutParams.leftMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int n = getDecoratedTop(paramView);
    int i1 = localLayoutParams.topMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i8 = getDecoratedRight(paramView);
    int i9 = localLayoutParams.rightMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i2 = getDecoratedBottom(paramView);
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
  
  private void bo(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(62386);
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(62386);
      throw ((Throwable)localObject1);
    }
    this.bJP.mLayoutDirection = paramInt1;
    boolean bool = xC();
    int k = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
    int m = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
    int i;
    Object localObject2;
    if ((!bool) && (this.mIsRtl))
    {
      i = 1;
      if (paramInt1 != 1) {
        break label561;
      }
      localObject1 = getChildAt(getChildCount() - 1);
      this.bJP.fs = this.aqs.bp((View)localObject1);
      paramInt1 = getPosition((View)localObject1);
      j = this.bJF.bJm[paramInt1];
      localObject1 = b((View)localObject1, (b)this.bJp.get(j));
      this.bJP.aqa = 1;
      localObject2 = this.bJP;
      ((b)localObject2).mPosition = (((b)localObject2).aqa + paramInt1);
      if (this.bJF.bJm.length > this.bJP.mPosition) {
        break label458;
      }
      this.bJP.bJY = -1;
      label222:
      if (i == 0) {
        break label488;
      }
      this.bJP.fs = this.aqs.bo((View)localObject1);
      this.bJP.aqK = (-this.aqs.bo((View)localObject1) + this.aqs.kH());
      localObject1 = this.bJP;
      if (this.bJP.aqK < 0) {
        break label483;
      }
      paramInt1 = this.bJP.aqK;
      label291:
      ((b)localObject1).aqK = paramInt1;
      label297:
      if (((this.bJP.bJY == -1) || (this.bJP.bJY > this.bJp.size() - 1)) && (this.bJP.mPosition <= getFlexItemCount()))
      {
        paramInt1 = paramInt2 - this.bJP.aqK;
        this.bJG.reset();
        if (paramInt1 > 0)
        {
          if (!bool) {
            break label531;
          }
          this.bJF.a(this.bJG, k, m, paramInt1, this.bJP.mPosition, this.bJp);
        }
      }
    }
    for (;;)
    {
      this.bJF.v(k, m, this.bJP.mPosition);
      this.bJF.fn(this.bJP.mPosition);
      localObject1 = this.bJP;
      ((b)localObject1).apY = (paramInt2 - ((b)localObject1).aqK);
      AppMethodBeat.o(62386);
      return;
      i = 0;
      break;
      label458:
      this.bJP.bJY = this.bJF.bJm[this.bJP.mPosition];
      break label222;
      label483:
      paramInt1 = 0;
      break label291;
      label488:
      this.bJP.fs = this.aqs.bp((View)localObject1);
      this.bJP.aqK = (this.aqs.bp((View)localObject1) - this.aqs.kI());
      break label297;
      label531:
      this.bJF.c(this.bJG, k, m, paramInt1, this.bJP.mPosition, this.bJp);
    }
    label561:
    Object localObject1 = getChildAt(0);
    this.bJP.fs = this.aqs.bo((View)localObject1);
    k = getPosition((View)localObject1);
    paramInt1 = this.bJF.bJm[k];
    localObject1 = a((View)localObject1, (b)this.bJp.get(paramInt1));
    this.bJP.aqa = 1;
    paramInt1 = this.bJF.bJm[k];
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        localObject2 = (b)this.bJp.get(paramInt1 - 1);
        this.bJP.mPosition = (k - ((b)localObject2).auc);
        label686:
        localObject2 = this.bJP;
        if (paramInt1 <= 0) {
          break label797;
        }
        paramInt1 -= 1;
      }
      for (;;)
      {
        ((b)localObject2).bJY = paramInt1;
        if (i == 0) {
          break label802;
        }
        this.bJP.fs = this.aqs.bp((View)localObject1);
        this.bJP.aqK = (this.aqs.bp((View)localObject1) - this.aqs.kI());
        localObject1 = this.bJP;
        paramInt1 = j;
        if (this.bJP.aqK >= 0) {
          paramInt1 = this.bJP.aqK;
        }
        ((b)localObject1).aqK = paramInt1;
        break;
        this.bJP.mPosition = -1;
        break label686;
        label797:
        paramInt1 = 0;
      }
      label802:
      this.bJP.fs = this.aqs.bo((View)localObject1);
      this.bJP.aqK = (-this.aqs.bo((View)localObject1) + this.aqs.kH());
      break;
    }
  }
  
  private View bp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62404);
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (bW(localView))
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
  
  private int c(RecyclerView.s params)
  {
    AppMethodBeat.i(62394);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = fw(i);
    View localView2 = fx(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(62394);
      throw params;
    }
    int k = getPosition(localView1);
    int j = getPosition(localView2);
    i = Math.abs(this.aqs.bp(localView2) - this.aqs.bo(localView1));
    k = this.bJF.bJm[k];
    if ((k == 0) || (k == -1))
    {
      AppMethodBeat.o(62394);
      return 0;
    }
    j = this.bJF.bJm[j];
    i = Math.round(i / (j - k + 1) * k + (this.aqs.kH() - this.aqs.bo(localView1)));
    AppMethodBeat.o(62394);
    return i;
  }
  
  private void c(RecyclerView.n paramn, b paramb)
  {
    AppMethodBeat.i(62367);
    if (paramb.aqK < 0)
    {
      AppMethodBeat.o(62367);
      return;
    }
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      paramn = new AssertionError();
      AppMethodBeat.o(62367);
      throw paramn;
    }
    this.aqs.getEnd();
    int j = getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(62367);
      return;
    }
    Object localObject1 = getChildAt(j - 1);
    int k = this.bJF.bJm[getPosition(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(62367);
      return;
    }
    int n = j - 1;
    localObject1 = (b)this.bJp.get(k);
    int i = n;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break label247;
      }
      View localView = getChildAt(i);
      m = j;
      if (!J(localView, paramb.aqK)) {
        break label247;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).bJj == getPosition(localView))
      {
        if (k <= 0) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bJp.get(m);
        j = i;
      }
      i -= 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label247:
    a(paramn, m, n);
    AppMethodBeat.o(62367);
  }
  
  private int d(RecyclerView.s params)
  {
    AppMethodBeat.i(62391);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62391);
      return 0;
    }
    int i = params.getItemCount();
    xN();
    View localView1 = fw(i);
    View localView2 = fx(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62391);
      return 0;
    }
    i = this.aqs.bp(localView2);
    int j = this.aqs.bo(localView1);
    i = Math.min(this.aqs.kJ(), i - j);
    AppMethodBeat.o(62391);
    return i;
  }
  
  private int e(RecyclerView.s params)
  {
    AppMethodBeat.i(62397);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62397);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = fw(i);
    View localView2 = fx(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(62397);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(62397);
      throw params;
    }
    i = ks();
    int j = ku();
    i = (int)(Math.abs(this.aqs.bp(localView2) - this.aqs.bo(localView1)) / (j - i + 1) * params.getItemCount());
    AppMethodBeat.o(62397);
    return i;
  }
  
  private void fv(int paramInt)
  {
    AppMethodBeat.i(62354);
    int i = ks();
    int j = ku();
    if (paramInt >= j)
    {
      AppMethodBeat.o(62354);
      return;
    }
    int k = getChildCount();
    this.bJF.fp(k);
    this.bJF.fo(k);
    this.bJF.fq(k);
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62354);
      throw ((Throwable)localObject);
    }
    if (paramInt >= this.bJF.bJm.length)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.bJX = paramInt;
    Object localObject = getChildAt(0);
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
    this.aqy = getPosition((View)localObject);
    if ((!xC()) && (this.mIsRtl))
    {
      this.aqz = (this.aqs.bp((View)localObject) + this.aqs.getEndPadding());
      AppMethodBeat.o(62354);
      return;
    }
    this.aqz = (this.aqs.bo((View)localObject) - this.aqs.kH());
    AppMethodBeat.o(62354);
  }
  
  private View fw(int paramInt)
  {
    AppMethodBeat.i(62359);
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62359);
      throw ((Throwable)localObject);
    }
    Object localObject = x(0, getChildCount(), paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    paramInt = getPosition((View)localObject);
    paramInt = this.bJF.bJm[paramInt];
    if (paramInt == -1)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    localObject = a((View)localObject, (b)this.bJp.get(paramInt));
    AppMethodBeat.o(62359);
    return localObject;
  }
  
  private View fx(int paramInt)
  {
    AppMethodBeat.i(62360);
    if ((!$assertionsDisabled) && (this.bJF.bJm == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62360);
      throw ((Throwable)localObject);
    }
    Object localObject = x(getChildCount() - 1, -1, paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62360);
      return null;
    }
    paramInt = getPosition((View)localObject);
    paramInt = this.bJF.bJm[paramInt];
    localObject = b((View)localObject, (b)this.bJp.get(paramInt));
    AppMethodBeat.o(62360);
    return localObject;
  }
  
  private int fy(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(62385);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62385);
      return 0;
    }
    xN();
    boolean bool = xC();
    int i;
    int j;
    if (bool)
    {
      i = this.bJW.getWidth();
      if (!bool) {
        break label124;
      }
      j = getWidth();
      label61:
      if (getLayoutDirection() == 1) {
        k = 1;
      }
      if (k == 0) {
        break label158;
      }
      k = Math.abs(paramInt);
      if (paramInt >= 0) {
        break label132;
      }
      i = -Math.min(j + a.i(this.bJQ) - i, k);
    }
    for (;;)
    {
      AppMethodBeat.o(62385);
      return i;
      i = this.bJW.getHeight();
      break;
      label124:
      j = getHeight();
      break label61;
      label132:
      i = paramInt;
      if (a.i(this.bJQ) + paramInt > 0)
      {
        i = -a.i(this.bJQ);
        continue;
        label158:
        if (paramInt > 0)
        {
          i = Math.min(j - a.i(this.bJQ) - i, paramInt);
        }
        else
        {
          i = paramInt;
          if (a.i(this.bJQ) + paramInt < 0) {
            i = -a.i(this.bJQ);
          }
        }
      }
    }
  }
  
  private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void km()
  {
    AppMethodBeat.i(62375);
    if (this.bJP == null) {
      this.bJP = new b((byte)0);
    }
    AppMethodBeat.o(62375);
  }
  
  private int ks()
  {
    AppMethodBeat.i(62402);
    View localView = bp(0, getChildCount());
    if (localView == null)
    {
      AppMethodBeat.o(62402);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(62402);
    return i;
  }
  
  private int ku()
  {
    AppMethodBeat.i(62403);
    View localView = bp(getChildCount() - 1, -1);
    if (localView == null)
    {
      AppMethodBeat.o(62403);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(62403);
    return i;
  }
  
  private void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62331);
    if (this.bJr != paramInt)
    {
      removeAllViews();
      this.bJr = paramInt;
      this.aqs = null;
      this.bJR = null;
      xO();
      requestLayout();
    }
    AppMethodBeat.o(62331);
  }
  
  private boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62398);
    if ((paramView.isLayoutRequested()) || (!isMeasurementCacheEnabled()) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(62398);
      return true;
    }
    AppMethodBeat.o(62398);
    return false;
  }
  
  private View x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62361);
    xN();
    km();
    int j = this.aqs.kH();
    int k = this.aqs.kI();
    int i;
    Object localObject1;
    Object localObject2;
    label46:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label166;
      }
      localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      if ((m < 0) || (m >= paramInt3)) {
        break label189;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).atw.isRemoved()) {
        break label117;
      }
      if (localObject2 != null) {
        break label189;
      }
      localObject2 = localView;
    }
    label166:
    label189:
    for (;;)
    {
      paramInt1 += i;
      break label46;
      i = -1;
      break;
      label117:
      if ((this.aqs.bo(localView) < j) || (this.aqs.bp(localView) > k))
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
  
  private void xM()
  {
    AppMethodBeat.i(62373);
    int i;
    b localb;
    if (xC())
    {
      i = getHeightMode();
      localb = this.bJP;
      if ((i != 0) && (i != -2147483648)) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      localb.aqe = bool;
      AppMethodBeat.o(62373);
      return;
      i = getWidthMode();
      break;
    }
  }
  
  private void xN()
  {
    AppMethodBeat.i(62374);
    if (this.aqs != null)
    {
      AppMethodBeat.o(62374);
      return;
    }
    if (xC())
    {
      if (this.bJs != 0)
      {
        this.aqs = aj.e(this);
        this.bJR = aj.d(this);
        AppMethodBeat.o(62374);
      }
    }
    else if (this.bJs == 0)
    {
      this.aqs = aj.e(this);
      this.bJR = aj.d(this);
      AppMethodBeat.o(62374);
      return;
    }
    this.aqs = aj.d(this);
    this.bJR = aj.e(this);
    AppMethodBeat.o(62374);
  }
  
  private void xO()
  {
    AppMethodBeat.i(62400);
    this.bJp.clear();
    a.b(this.bJQ);
    a.d(this.bJQ, 0);
    AppMethodBeat.o(62400);
  }
  
  public final void a(int paramInt, View paramView)
  {
    AppMethodBeat.i(62342);
    this.bJV.put(paramInt, paramView);
    AppMethodBeat.o(62342);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62334);
    calculateItemDecorationsForChild(paramView, bJN);
    if (xC())
    {
      paramInt1 = getLeftDecorationWidth(paramView) + getRightDecorationWidth(paramView);
      paramb.bJa += paramInt1;
      paramb.bJb = (paramInt1 + paramb.bJb);
      AppMethodBeat.o(62334);
      return;
    }
    paramInt1 = getTopDecorationHeight(paramView) + getBottomDecorationHeight(paramView);
    paramb.bJa += paramInt1;
    paramb.bJb = (paramInt1 + paramb.bJb);
    AppMethodBeat.o(62334);
  }
  
  public final void a(b paramb) {}
  
  public final int bV(View paramView)
  {
    AppMethodBeat.i(62333);
    if (xC())
    {
      i = getTopDecorationHeight(paramView);
      j = getBottomDecorationHeight(paramView);
      AppMethodBeat.o(62333);
      return i + j;
    }
    int i = getLeftDecorationWidth(paramView);
    int j = getRightDecorationWidth(paramView);
    AppMethodBeat.o(62333);
    return i + j;
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(62343);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62343);
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {}
    for (paramInt = -1; xC(); paramInt = 1)
    {
      localPointF = new PointF(0.0F, paramInt);
      AppMethodBeat.o(62343);
      return localPointF;
    }
    PointF localPointF = new PointF(paramInt, 0.0F);
    AppMethodBeat.o(62343);
    return localPointF;
  }
  
  public boolean canScrollHorizontally()
  {
    AppMethodBeat.i(62380);
    if ((!xC()) || (getWidth() > this.bJW.getWidth()))
    {
      AppMethodBeat.o(62380);
      return true;
    }
    AppMethodBeat.o(62380);
    return false;
  }
  
  public boolean canScrollVertically()
  {
    AppMethodBeat.i(62381);
    if ((xC()) || (getHeight() > this.bJW.getHeight()))
    {
      AppMethodBeat.o(62381);
      return true;
    }
    AppMethodBeat.o(62381);
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FlexboxLayoutManager.LayoutParams;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(62389);
    int i = d(params);
    AppMethodBeat.o(62389);
    return i;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(62392);
    c(params);
    int i = c(params);
    AppMethodBeat.o(62392);
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(62395);
    int i = e(params);
    AppMethodBeat.o(62395);
    return i;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(62390);
    int i = d(params);
    AppMethodBeat.o(62390);
    return i;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(62393);
    int i = c(params);
    AppMethodBeat.o(62393);
    return i;
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(62396);
    int i = e(params);
    AppMethodBeat.o(62396);
    return i;
  }
  
  public final View fj(int paramInt)
  {
    AppMethodBeat.i(62336);
    View localView = (View)this.bJV.get(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(62336);
      return localView;
    }
    localView = this.arV.cp(paramInt);
    AppMethodBeat.o(62336);
    return localView;
  }
  
  public final View fk(int paramInt)
  {
    AppMethodBeat.i(62337);
    View localView = fj(paramInt);
    AppMethodBeat.o(62337);
    return localView;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(62344);
    FlexboxLayoutManager.LayoutParams localLayoutParams = new FlexboxLayoutManager.LayoutParams();
    AppMethodBeat.o(62344);
    return localLayoutParams;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(62345);
    paramContext = new FlexboxLayoutManager.LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(62345);
    return paramContext;
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.bJu;
  }
  
  public int getFlexDirection()
  {
    return this.bJr;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(62335);
    int i = this.asR.getItemCount();
    AppMethodBeat.o(62335);
    return i;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bJp;
  }
  
  public int getFlexWrap()
  {
    return this.bJs;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62340);
    if (this.bJp.size() == 0)
    {
      AppMethodBeat.o(62340);
      return 0;
    }
    int j = -2147483648;
    int k = this.bJp.size();
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, ((b)this.bJp.get(i)).bJa);
      i += 1;
    }
    AppMethodBeat.o(62340);
    return j;
  }
  
  public int getMaxLine()
  {
    return this.bJw;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62341);
    int k = this.bJp.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((b)this.bJp.get(i)).bJc;
      i += 1;
    }
    AppMethodBeat.o(62341);
    return j;
  }
  
  public final int m(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62332);
    if (xC())
    {
      paramInt1 = getLeftDecorationWidth(paramView);
      paramInt2 = getRightDecorationWidth(paramView);
      AppMethodBeat.o(62332);
      return paramInt1 + paramInt2;
    }
    paramInt1 = getTopDecorationHeight(paramView);
    paramInt2 = getBottomDecorationHeight(paramView);
    AppMethodBeat.o(62332);
    return paramInt1 + paramInt2;
  }
  
  public void onAdapterChanged(RecyclerView.a parama1, RecyclerView.a parama2)
  {
    AppMethodBeat.i(187956);
    removeAllViews();
    AppMethodBeat.o(187956);
  }
  
  public void onAttachedToWindow(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(62378);
    super.onAttachedToWindow(paramRecyclerView);
    this.bJW = ((View)paramRecyclerView.getParent());
    AppMethodBeat.o(62378);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(62379);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.aqA)
    {
      removeAndRecycleAllViews(paramn);
      paramn.clear();
    }
    AppMethodBeat.o(62379);
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62349);
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    fv(paramInt1);
    AppMethodBeat.o(62349);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62353);
    super.onItemsMoved(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    fv(Math.min(paramInt1, paramInt2));
    AppMethodBeat.o(62353);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62352);
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
    fv(paramInt1);
    AppMethodBeat.o(62352);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62351);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    fv(paramInt1);
    AppMethodBeat.o(62351);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(62350);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2, paramObject);
    fv(paramInt1);
    AppMethodBeat.o(62350);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(62355);
    this.arV = paramn;
    this.asR = params;
    int k = params.getItemCount();
    if ((k == 0) && (params.aue))
    {
      AppMethodBeat.o(62355);
      return;
    }
    int i = getLayoutDirection();
    a locala;
    Object localObject;
    boolean bool;
    switch (this.bJr)
    {
    default: 
      this.mIsRtl = false;
      this.bJO = false;
      xN();
      km();
      this.bJF.fp(k);
      this.bJF.fo(k);
      this.bJF.fq(k);
      this.bJP.bKc = false;
      if ((this.bJS != null) && (FlexboxLayoutManager.SavedState.c(this.bJS, k))) {
        this.aqy = FlexboxLayoutManager.SavedState.b(this.bJS);
      }
      if ((a.a(this.bJQ)) && (this.aqy == -1) && (this.bJS == null)) {
        break label619;
      }
      a.b(this.bJQ);
      locala = this.bJQ;
      localObject = this.bJS;
      if ((!$assertionsDisabled) && (this.bJF.bJm == null))
      {
        paramn = new AssertionError();
        AppMethodBeat.o(62355);
        throw paramn;
      }
      label397:
      label441:
      break;
    case 0: 
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bJs != 2) {
          break label279;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bJO = bool;
        break;
        bool = false;
        break label247;
      }
    case 1: 
      if (i != 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bJs != 2) {
          break label325;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bJO = bool;
        break;
        bool = false;
        break label293;
      }
    case 2: 
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bJs == 2) {
          if (this.mIsRtl) {
            break label383;
          }
        }
      }
      for (bool = true;; bool = false)
      {
        this.mIsRtl = bool;
        this.bJO = false;
        break;
        bool = false;
        break label339;
      }
    case 3: 
      label247:
      label383:
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bJs == 2) {
          if (this.mIsRtl) {
            break label441;
          }
        }
      }
      label279:
      label293:
      label325:
      label339:
      for (bool = true;; bool = false)
      {
        this.mIsRtl = bool;
        this.bJO = true;
        break;
        bool = false;
        break label397;
      }
    }
    label493:
    int m;
    label559:
    label579:
    label588:
    label619:
    int n;
    label644:
    int i1;
    int i2;
    if ((params.aue) || (this.aqy == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (getChildCount() == 0) {
          break label1263;
        }
        if (!a.d(locala)) {
          break label1234;
        }
        localObject = fx(params.getItemCount());
        if (localObject == null) {
          break label1263;
        }
        a.a(locala, (View)localObject);
        if ((!params.aue) && (supportsPredictiveItemAnimations()))
        {
          if ((this.aqs.bo((View)localObject) < this.aqs.kI()) && (this.aqs.bp((View)localObject) >= this.aqs.kH())) {
            break label1247;
          }
          i = 1;
          if (i != 0)
          {
            if (!a.d(locala)) {
              break label1252;
            }
            i = this.aqs.kI();
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
      a.c(this.bJQ);
      detachAndScrapAttachedViews(paramn);
      if (!a.d(this.bJQ)) {
        break label1268;
      }
      b(this.bJQ, false, true);
      m = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
      n = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
      i1 = getWidth();
      i2 = getHeight();
      if (!xC()) {
        break label1298;
      }
      if ((this.bJT == -2147483648) || (this.bJT == i1)) {
        break label1281;
      }
      i = 1;
      label709:
      if (!this.bJP.aqe) {
        break label1286;
      }
    }
    label1281:
    label1286:
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = this.bJP.apY)
    {
      this.bJT = i1;
      this.bJU = i2;
      if ((this.bJX != -1) || ((this.aqy == -1) && (i == 0))) {
        break label1604;
      }
      if (a.d(this.bJQ)) {
        break label1471;
      }
      this.bJp.clear();
      if (($assertionsDisabled) || (this.bJF.bJm != null)) {
        break label1363;
      }
      paramn = new AssertionError();
      AppMethodBeat.o(62355);
      throw paramn;
      if ((this.aqy < 0) || (this.aqy >= params.getItemCount()))
      {
        this.aqy = -1;
        this.aqz = -2147483648;
        i = 0;
        break;
      }
      a.b(locala, this.aqy);
      a.a(locala, this.bJF.bJm[a.e(locala)]);
      if ((this.bJS != null) && (FlexboxLayoutManager.SavedState.c(this.bJS, params.getItemCount())))
      {
        i = this.aqs.kH();
        a.c(locala, FlexboxLayoutManager.SavedState.c((FlexboxLayoutManager.SavedState)localObject) + i);
        a.h(locala);
        a.a(locala, -1);
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.aqz == -2147483648)
        {
          localObject = findViewByPosition(this.aqy);
          if (localObject != null)
          {
            if (this.aqs.bs((View)localObject) > this.aqs.kJ())
            {
              a.g(locala);
            }
            else if (this.aqs.bo((View)localObject) - this.aqs.kH() < 0)
            {
              a.c(locala, this.aqs.kH());
              a.a(locala, false);
            }
            else if (this.aqs.kI() - this.aqs.bp((View)localObject) < 0)
            {
              a.c(locala, this.aqs.kI());
              a.a(locala, true);
            }
            else
            {
              if (a.d(locala)) {}
              for (i = this.aqs.bp((View)localObject) + this.aqs.kG();; i = this.aqs.bo((View)localObject))
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
              i = getPosition(getChildAt(0));
              if (this.aqy >= i) {
                break label1172;
              }
            }
            label1172:
            for (bool = true;; bool = false)
            {
              a.a(locala, bool);
              a.g(locala);
              break;
            }
          }
        }
        else if ((!xC()) && (this.mIsRtl))
        {
          a.c(locala, this.aqz - this.aqs.getEndPadding());
        }
        else
        {
          a.c(locala, this.aqs.kH() + this.aqz);
        }
      }
      label1234:
      localObject = fw(params.getItemCount());
      break label493;
      label1247:
      i = 0;
      break label559;
      label1252:
      i = this.aqs.kH();
      break label579;
      label1263:
      i = 0;
      break label588;
      label1268:
      a(this.bJQ, false, true);
      break label644;
      i = 0;
      break label709;
    }
    label1298:
    if ((this.bJU != -2147483648) && (this.bJU != i2))
    {
      i = 1;
      label1318:
      if (!this.bJP.aqe) {
        break label1351;
      }
    }
    label1351:
    for (j = this.mContext.getResources().getDisplayMetrics().widthPixels;; j = this.bJP.apY)
    {
      break;
      i = 0;
      break label1318;
    }
    label1363:
    this.bJG.reset();
    if (xC())
    {
      this.bJF.b(this.bJG, m, n, j, a.e(this.bJQ), this.bJp);
      this.bJp = this.bJG.bJp;
      this.bJF.bk(m, n);
      this.bJF.xK();
      a.a(this.bJQ, this.bJF.bJm[a.e(this.bJQ)]);
      this.bJP.bJY = a.f(this.bJQ);
      label1471:
      if (!a.d(this.bJQ)) {
        break label1863;
      }
      a(paramn, params, this.bJP);
      j = this.bJP.fs;
      a(this.bJQ, true, false);
      a(paramn, params, this.bJP);
      i = this.bJP.fs;
    }
    for (;;)
    {
      if (getChildCount() > 0)
      {
        if (a.d(this.bJQ))
        {
          b(a(i, paramn, params, true) + j, paramn, params, false);
          AppMethodBeat.o(62355);
          return;
          this.bJF.d(this.bJG, m, n, j, a.e(this.bJQ), this.bJp);
          break;
          label1604:
          if (this.bJX != -1)
          {
            i = Math.min(this.bJX, a.e(this.bJQ));
            label1627:
            this.bJG.reset();
            if (!xC()) {
              break label1773;
            }
            if (this.bJp.size() <= 0) {
              break label1739;
            }
            this.bJF.c(this.bJp, i);
            this.bJF.a(this.bJG, m, n, j, i, a.e(this.bJQ), this.bJp);
          }
          for (;;)
          {
            this.bJp = this.bJG.bJp;
            this.bJF.v(m, n, i);
            this.bJF.fn(i);
            break;
            i = a.e(this.bJQ);
            break label1627;
            label1739:
            this.bJF.fq(k);
            this.bJF.a(this.bJG, m, n, j, 0, this.bJp);
            continue;
            label1773:
            if (this.bJp.size() > 0)
            {
              this.bJF.c(this.bJp, i);
              this.bJF.a(this.bJG, n, m, j, i, a.e(this.bJQ), this.bJp);
            }
            else
            {
              this.bJF.fq(k);
              this.bJF.c(this.bJG, m, n, j, 0, this.bJp);
            }
          }
          label1863:
          a(paramn, params, this.bJP);
          i = this.bJP.fs;
          b(this.bJQ, true, false);
          a(paramn, params, this.bJP);
          j = this.bJP.fs;
          continue;
        }
        a(i + b(j, paramn, params, true), paramn, params, false);
      }
    }
    AppMethodBeat.o(62355);
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(62358);
    super.onLayoutCompleted(params);
    this.bJS = null;
    this.aqy = -1;
    this.aqz = -2147483648;
    this.bJX = -1;
    a.b(this.bJQ);
    this.bJV.clear();
    AppMethodBeat.o(62358);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62348);
    if ((paramParcelable instanceof FlexboxLayoutManager.SavedState))
    {
      this.bJS = ((FlexboxLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(62348);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(62347);
    if (this.bJS != null)
    {
      localSavedState = new FlexboxLayoutManager.SavedState(this.bJS, (byte)0);
      AppMethodBeat.o(62347);
      return localSavedState;
    }
    FlexboxLayoutManager.SavedState localSavedState = new FlexboxLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FlexboxLayoutManager.SavedState.a(localSavedState, getPosition(localView));
      FlexboxLayoutManager.SavedState.b(localSavedState, this.aqs.bo(localView) - this.aqs.kH());
    }
    for (;;)
    {
      AppMethodBeat.o(62347);
      return localSavedState;
      FlexboxLayoutManager.SavedState.a(localSavedState);
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(62382);
    if (!xC())
    {
      paramInt = b(paramInt, paramn, params);
      this.bJV.clear();
      AppMethodBeat.o(62382);
      return paramInt;
    }
    paramInt = fy(paramInt);
    paramn = this.bJQ;
    a.d(paramn, a.i(paramn) + paramInt);
    this.bJR.ce(-paramInt);
    AppMethodBeat.o(62382);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(62376);
    this.aqy = paramInt;
    this.aqz = -2147483648;
    if (this.bJS != null) {
      FlexboxLayoutManager.SavedState.a(this.bJS);
    }
    requestLayout();
    AppMethodBeat.o(62376);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(62383);
    if (xC())
    {
      paramInt = b(paramInt, paramn, params);
      this.bJV.clear();
      AppMethodBeat.o(62383);
      return paramInt;
    }
    paramInt = fy(paramInt);
    paramn = this.bJQ;
    a.d(paramn, a.i(paramn) + paramInt);
    this.bJR.ce(-paramInt);
    AppMethodBeat.o(62383);
    return paramInt;
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bJp = paramList;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(62377);
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.atO = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(62377);
  }
  
  public final int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62338);
    paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), paramInt2, paramInt3, canScrollHorizontally());
    AppMethodBeat.o(62338);
    return paramInt1;
  }
  
  public final int u(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62339);
    paramInt1 = getChildMeasureSpec(getHeight(), getHeightMode(), paramInt2, paramInt3, canScrollVertically());
    AppMethodBeat.o(62339);
    return paramInt1;
  }
  
  public final boolean xC()
  {
    return (this.bJr == 0) || (this.bJr == 1);
  }
  
  final class a
  {
    private int aqF;
    private boolean aqG;
    private boolean aqH;
    private int bJY;
    private int bJZ = 0;
    private boolean bKa;
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
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bJY + ", mCoordinate=" + this.aqF + ", mPerpendicularCoordinate=" + this.bJZ + ", mLayoutFromEnd=" + this.aqG + ", mValid=" + this.aqH + ", mAssignedFromSavedState=" + this.bKa + '}';
      AppMethodBeat.o(62315);
      return str;
    }
  }
  
  static final class b
  {
    int apY;
    int aqK;
    int aqN;
    int aqa = 1;
    boolean aqe;
    int bJY;
    boolean bKc;
    int fs;
    int mLayoutDirection = 1;
    int mPosition;
    
    public final String toString()
    {
      AppMethodBeat.i(62324);
      String str = "LayoutState{mAvailable=" + this.apY + ", mFlexLinePosition=" + this.bJY + ", mPosition=" + this.mPosition + ", mOffset=" + this.fs + ", mScrollingOffset=" + this.aqK + ", mLastScrollDelta=" + this.aqN + ", mItemDirection=" + this.aqa + ", mLayoutDirection=" + this.mLayoutDirection + '}';
      AppMethodBeat.o(62324);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager
 * JD-Core Version:    0.7.0.1
 */