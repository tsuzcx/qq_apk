package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b, a
{
  private static final Rect btx;
  private u aiT;
  private int aiZ;
  private RecyclerView.n ajQ;
  private int aja;
  private boolean ajb;
  private RecyclerView.s akL;
  private List<b> bsY;
  private a btA;
  private u btB;
  private SavedState btC;
  private int btD;
  private int btE;
  private SparseArray<View> btF;
  private View btG;
  private int btH;
  private int bta;
  private int btb;
  private int btc;
  private int btd;
  private int btf;
  private final c btp;
  private c.a btq;
  private boolean bty;
  private b btz;
  private final Context mContext;
  private boolean tL;
  
  static
  {
    AppMethodBeat.i(62405);
    if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      btx = new Rect();
      AppMethodBeat.o(62405);
      return;
    }
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62330);
    this.btf = -1;
    this.bsY = new ArrayList();
    this.btp = new c(this);
    this.btA = new a((byte)0);
    this.aiZ = -1;
    this.aja = -2147483648;
    this.btD = -2147483648;
    this.btE = -2147483648;
    this.btF = new SparseArray();
    this.btH = -1;
    this.btq = new c.a();
    paramAttributeSet = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    switch (paramAttributeSet.FO)
    {
    }
    for (;;)
    {
      if (this.btb != 1)
      {
        if (this.btb == 0)
        {
          removeAllViews();
          vR();
        }
        this.btb = 1;
        this.aiT = null;
        this.btB = null;
        requestLayout();
      }
      if (this.btd != 4)
      {
        removeAllViews();
        vR();
        this.btd = 4;
        requestLayout();
      }
      setAutoMeasureEnabled(true);
      this.mContext = paramContext;
      AppMethodBeat.o(62330);
      return;
      if (paramAttributeSet.aln)
      {
        setFlexDirection(1);
      }
      else
      {
        setFlexDirection(0);
        continue;
        if (paramAttributeSet.aln) {
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
    if ((!vF()) && (this.tL))
    {
      if (this.aiT.getEnd() - this.aiT.aZ(paramView) <= paramInt)
      {
        AppMethodBeat.o(62366);
        return true;
      }
      AppMethodBeat.o(62366);
      return false;
    }
    if (this.aiT.ba(paramView) <= paramInt)
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
    if ((!vF()) && (this.tL))
    {
      if (this.aiT.ba(paramView) <= paramInt)
      {
        AppMethodBeat.o(62368);
        return true;
      }
      AppMethodBeat.o(62368);
      return false;
    }
    if (this.aiT.aZ(paramView) >= this.aiT.getEnd() - paramInt)
    {
      AppMethodBeat.o(62368);
      return true;
    }
    AppMethodBeat.o(62368);
    return false;
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(187986);
    int i;
    if ((!vF()) && (this.tL))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
      i = paramInt - this.aiT.kT();
      if (i <= 0) {
        break label99;
      }
      i = b(i, paramn, params);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramInt = this.aiT.kU() - (paramInt + i);
        if (paramInt > 0)
        {
          this.aiT.cG(paramInt);
          AppMethodBeat.o(187986);
          return i + paramInt;
          i = 0;
          break;
          label99:
          AppMethodBeat.o(187986);
          return 0;
          label106:
          i = this.aiT.kU() - paramInt;
          if (i > 0)
          {
            i = -b(-i, paramn, params);
          }
          else
          {
            AppMethodBeat.o(187986);
            return 0;
          }
        }
      }
    }
    AppMethodBeat.o(187986);
    return i;
  }
  
  private int a(RecyclerView.n paramn, RecyclerView.s params, b paramb)
  {
    AppMethodBeat.i(187997);
    if (paramb.ajl != -2147483648)
    {
      if (paramb.aiL < 0) {
        paramb.ajl += paramb.aiL;
      }
      a(paramn, paramb);
    }
    int i2 = paramb.aiL;
    int j = paramb.aiL;
    boolean bool = vF();
    int k = 0;
    Object localObject;
    int i;
    int n;
    int i3;
    int m;
    if ((j > 0) || (this.btz.aiR))
    {
      localObject = this.bsY;
      if ((paramb.mPosition >= 0) && (paramb.mPosition < params.getItemCount()) && (paramb.btI >= 0) && (paramb.btI < ((List)localObject).size())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = (b)this.bsY.get(paramb.btI);
          paramb.mPosition = ((b)localObject).bsS;
          if (vF())
          {
            if ((!$assertionsDisabled) && (this.btp.bsW == null))
            {
              paramn = new AssertionError();
              AppMethodBeat.o(187997);
              throw paramn;
              i = 0;
              continue;
            }
            i = getPaddingLeft();
            n = getPaddingRight();
            i3 = getWidth();
            m = paramb.zP;
            if (paramb.mLayoutDirection != -1) {
              break label1172;
            }
            m -= ((b)localObject).bsL;
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
      switch (this.btc)
      {
      default: 
        paramn = new IllegalStateException("Invalid justifyContent is set: " + this.btc);
        AppMethodBeat.o(187997);
        throw paramn;
      case 0: 
        f1 = i;
        f2 = i3 - n;
        f4 = a.i(this.btA);
        f2 -= a.i(this.btA);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i3 = ((b)localObject).alU;
        f1 -= f4;
        n = i1;
        if (n < i1 + i3)
        {
          localView = fC(n);
          if (localView == null) {
            break label1169;
          }
          if (paramb.mLayoutDirection == 1)
          {
            calculateItemDecorationsForChild(localView, btx);
            addView(localView);
            long l = this.btp.bsW[n];
            i4 = c.ax(l);
            int i5 = c.ay(l);
            LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (shouldMeasureChild(localView, i4, i5, localLayoutParams)) {
              localView.measure(i4, i5);
            }
            f1 += localLayoutParams.leftMargin + getLeftDecorationWidth(localView);
            f2 -= localLayoutParams.rightMargin + getRightDecorationWidth(localView);
            i4 = m + getTopDecorationHeight(localView);
            if (!this.tL) {
              break label943;
            }
            this.btp.a(localView, (b)localObject, Math.round(f2) - localView.getMeasuredWidth(), i4, Math.round(f2), localView.getMeasuredHeight() + i4);
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
        f1 = i3 - ((b)localObject).bsJ + n;
        f2 = ((b)localObject).bsJ - i;
        break label348;
        f1 = i + (i3 - ((b)localObject).bsJ) / 2.0F;
        f2 = i3 - n - (i3 - ((b)localObject).bsJ) / 2.0F;
        break label348;
        f3 = f1;
        if (((b)localObject).alU != 0) {
          f3 = (i3 - ((b)localObject).bsJ) / ((b)localObject).alU;
        }
        f1 = i + f3 / 2.0F;
        f2 = i3 - n - f3 / 2.0F;
        break label348;
        f2 = i;
        if (((b)localObject).alU != 1) {}
        for (f1 = ((b)localObject).alU - 1;; f1 = 1.0F)
        {
          f3 = (i3 - ((b)localObject).bsJ) / f1;
          f4 = i3 - n;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (((b)localObject).alU != 0) {
          f3 = (i3 - ((b)localObject).bsJ) / (((b)localObject).alU + 1);
        }
        f1 = i + f3;
        f2 = i3 - n - f3;
        break label348;
        calculateItemDecorationsForChild(localView, btx);
        addView(localView, i);
        i += 1;
        break label446;
        label943:
        this.btp.a(localView, (b)localObject, Math.round(f1), i4, Math.round(f1) + localView.getMeasuredWidth(), localView.getMeasuredHeight() + i4);
        break label597;
        paramb.btI += this.btz.mLayoutDirection;
        i = ((b)localObject).bsL;
        label1006:
        if ((!bool) && (this.tL)) {}
        for (paramb.zP -= ((b)localObject).bsL * paramb.mLayoutDirection;; paramb.zP += ((b)localObject).bsL * paramb.mLayoutDirection)
        {
          m = ((b)localObject).bsL;
          k = i + k;
          j -= m;
          break;
          i = a((b)localObject, paramb);
          break label1006;
        }
        paramb.aiL -= k;
        if (paramb.ajl != -2147483648)
        {
          paramb.ajl += k;
          if (paramb.aiL < 0) {
            paramb.ajl += paramb.aiL;
          }
          a(paramn, paramb);
        }
        i = paramb.aiL;
        AppMethodBeat.o(187997);
        return i2 - i;
      }
    }
  }
  
  private int a(b paramb, b paramb1)
  {
    AppMethodBeat.i(62370);
    if ((!$assertionsDisabled) && (this.btp.bsW == null))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(62370);
      throw paramb;
    }
    int i = getPaddingTop();
    int m = getPaddingBottom();
    int i1 = getHeight();
    int k = paramb1.zP;
    int j = paramb1.zP;
    int n;
    if (paramb1.mLayoutDirection == -1)
    {
      n = paramb.bsL;
      j += paramb.bsL;
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
      switch (this.btc)
      {
      default: 
        paramb = new IllegalStateException("Invalid justifyContent is set: " + this.btc);
        AppMethodBeat.o(62370);
        throw paramb;
      case 0: 
        f1 = i;
        f2 = i1 - m;
        f4 = f1 - a.i(this.btA);
        f1 = f2 - a.i(this.btA);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i1 = paramb.alU;
        m = n;
        f2 = f4;
        if (m < n + i1)
        {
          localView = fC(m);
          if (localView == null) {
            break label986;
          }
          long l = this.btp.bsW[m];
          i2 = c.ax(l);
          i3 = c.ay(l);
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (shouldMeasureChild(localView, i2, i3, localLayoutParams)) {
            localView.measure(i2, i3);
          }
          f2 += localLayoutParams.topMargin + getTopDecorationHeight(localView);
          f1 -= localLayoutParams.rightMargin + getBottomDecorationHeight(localView);
          if (paramb1.mLayoutDirection == 1)
          {
            calculateItemDecorationsForChild(localView, btx);
            addView(localView);
            label393:
            i2 = k + getLeftDecorationWidth(localView);
            i3 = j - getRightDecorationWidth(localView);
            if (!this.tL) {
              break label844;
            }
            if (!this.bty) {
              break label781;
            }
            this.btp.a(localView, paramb, this.tL, i3 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i3, Math.round(f1));
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
        f1 = i1 - paramb.bsJ + m;
        f2 = paramb.bsJ - i;
        break;
        f1 = i + (i1 - paramb.bsJ) / 2.0F;
        f2 = i1 - m - (i1 - paramb.bsJ) / 2.0F;
        break;
        f3 = f1;
        if (paramb.alU != 0) {
          f3 = (i1 - paramb.bsJ) / paramb.alU;
        }
        f1 = i + f3 / 2.0F;
        f2 = i1 - m - f3 / 2.0F;
        break;
        f2 = i;
        if (paramb.alU != 1) {}
        for (f1 = paramb.alU - 1;; f1 = 1.0F)
        {
          f3 = (i1 - paramb.bsJ) / f1;
          f4 = i1 - m;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (paramb.alU != 0) {
          f3 = (i1 - paramb.bsJ) / (paramb.alU + 1);
        }
        f1 = i + f3;
        f2 = i1 - m - f3;
        break;
        calculateItemDecorationsForChild(localView, btx);
        addView(localView, i);
        i += 1;
        break label393;
        c localc = this.btp;
        boolean bool = this.tL;
        i2 = localView.getMeasuredWidth();
        int i4 = Math.round(f2);
        int i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i3 - i2, i4, i3, localView.getMeasuredHeight() + i5);
        break label467;
        if (this.bty)
        {
          this.btp.a(localView, paramb, this.tL, i2, Math.round(f1) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f1));
          break label467;
        }
        localc = this.btp;
        bool = this.tL;
        i3 = Math.round(f2);
        i4 = localView.getMeasuredWidth();
        i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i2, i3, i2 + i4, localView.getMeasuredHeight() + i5);
        break label467;
        paramb1.btI += this.btz.mLayoutDirection;
        i = paramb.bsL;
        AppMethodBeat.o(62370);
        return i;
      }
    }
  }
  
  private View a(View paramView, b paramb)
  {
    AppMethodBeat.i(62387);
    boolean bool = vF();
    int j = paramb.alU;
    int i = 1;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.tL) && (!bool))
        {
          if (this.aiT.ba(paramView) >= this.aiT.ba(localView)) {
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
        if (this.aiT.aZ(paramView) <= this.aiT.aZ(localView)) {
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
    AppMethodBeat.i(188018);
    while (paramInt2 >= paramInt1)
    {
      removeAndRecycleViewAt(paramInt2, paramn);
      paramInt2 -= 1;
    }
    AppMethodBeat.o(188018);
  }
  
  private void a(RecyclerView.n paramn, b paramb)
  {
    AppMethodBeat.i(188000);
    if (!paramb.btM)
    {
      AppMethodBeat.o(188000);
      return;
    }
    if (paramb.mLayoutDirection == -1)
    {
      c(paramn, paramb);
      AppMethodBeat.o(188000);
      return;
    }
    b(paramn, paramb);
    AppMethodBeat.o(188000);
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62371);
    if (paramBoolean2)
    {
      vP();
      if ((vF()) || (!this.tL)) {
        break label212;
      }
    }
    label212:
    for (this.btz.aiL = (a.j(parama) - getPaddingRight());; this.btz.aiL = (this.aiT.kU() - a.j(parama)))
    {
      this.btz.mPosition = a.e(parama);
      this.btz.aiN = 1;
      this.btz.mLayoutDirection = 1;
      this.btz.zP = a.j(parama);
      this.btz.ajl = -2147483648;
      this.btz.btI = a.f(parama);
      if ((paramBoolean1) && (this.bsY.size() > 1) && (a.f(parama) >= 0) && (a.f(parama) < this.bsY.size() - 1))
      {
        parama = (b)this.bsY.get(a.f(parama));
        b.a(this.btz);
        b localb = this.btz;
        int i = localb.mPosition;
        localb.mPosition = (parama.alU + i);
      }
      AppMethodBeat.o(62371);
      return;
      this.btz.aiR = false;
      break;
    }
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int i = 1;
    AppMethodBeat.i(188085);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(188085);
      return 0;
    }
    vQ();
    this.btz.btM = true;
    int j;
    if ((!vF()) && (this.tL))
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
      bw(i, k);
      m = this.btz.ajl + a(paramn, params, this.btz);
      if (m >= 0) {
        break label135;
      }
      AppMethodBeat.o(188085);
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
      this.aiT.cG(-paramInt);
      this.btz.ajo = paramInt;
      AppMethodBeat.o(188085);
      return paramInt;
      if (k > m) {
        paramInt = i * m;
      }
    }
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(187985);
    int i;
    if ((!vF()) && (this.tL))
    {
      i = this.aiT.kU() - paramInt;
      if (i > 0) {
        i = b(-i, paramn, params);
      }
    }
    while (paramBoolean)
    {
      paramInt = paramInt + i - this.aiT.kT();
      if (paramInt > 0)
      {
        this.aiT.cG(-paramInt);
        AppMethodBeat.o(187985);
        return i - paramInt;
        AppMethodBeat.o(187985);
        return 0;
        i = paramInt - this.aiT.kT();
        if (i > 0)
        {
          i = -b(i, paramn, params);
        }
        else
        {
          AppMethodBeat.o(187985);
          return 0;
        }
      }
    }
    AppMethodBeat.o(187985);
    return i;
  }
  
  private View b(View paramView, b paramb)
  {
    AppMethodBeat.i(62388);
    boolean bool = vF();
    int i = getChildCount();
    int j = getChildCount();
    int k = paramb.alU;
    i -= 2;
    if (i > j - k - 1)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.tL) && (!bool))
        {
          if (this.aiT.aZ(paramView) <= this.aiT.aZ(localView)) {
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
        if (this.aiT.ba(paramView) >= this.aiT.ba(localView)) {
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
    AppMethodBeat.i(188006);
    if (paramb.ajl < 0)
    {
      AppMethodBeat.o(188006);
      return;
    }
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      paramn = new AssertionError();
      AppMethodBeat.o(188006);
      throw paramn;
    }
    int n = getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(188006);
      return;
    }
    Object localObject1 = getChildAt(0);
    int k = this.btp.bsV[getPosition(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(188006);
      return;
    }
    localObject1 = (b)this.bsY.get(k);
    int i = 0;
    for (;;)
    {
      m = j;
      if (i >= n) {
        break label245;
      }
      View localView = getChildAt(i);
      m = j;
      if (!I(localView, paramb.ajl)) {
        break label245;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).iV == getPosition(localView))
      {
        if (k >= this.bsY.size() - 1) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bsY.get(m);
        j = i;
      }
      i += 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label245:
    a(paramn, 0, m);
    AppMethodBeat.o(188006);
  }
  
  private void b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62372);
    if (paramBoolean2)
    {
      vP();
      if ((vF()) || (!this.tL)) {
        break label204;
      }
    }
    label204:
    for (this.btz.aiL = (this.btG.getWidth() - a.j(parama) - this.aiT.kT());; this.btz.aiL = (a.j(parama) - this.aiT.kT()))
    {
      this.btz.mPosition = a.e(parama);
      this.btz.aiN = 1;
      this.btz.mLayoutDirection = -1;
      this.btz.zP = a.j(parama);
      this.btz.ajl = -2147483648;
      this.btz.btI = a.f(parama);
      if ((paramBoolean1) && (a.f(parama) > 0) && (this.bsY.size() > a.f(parama)))
      {
        parama = (b)this.bsY.get(a.f(parama));
        b.b(this.btz);
        b localb = this.btz;
        localb.mPosition -= parama.alU;
      }
      AppMethodBeat.o(62372);
      return;
      this.btz.aiR = false;
      break;
    }
  }
  
  private boolean bS(View paramView)
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
  
  private void bw(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(62386);
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(62386);
      throw ((Throwable)localObject1);
    }
    this.btz.mLayoutDirection = paramInt1;
    boolean bool = vF();
    int k = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
    int m = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
    int i;
    Object localObject2;
    if ((!bool) && (this.tL))
    {
      i = 1;
      if (paramInt1 != 1) {
        break label561;
      }
      localObject1 = getChildAt(getChildCount() - 1);
      this.btz.zP = this.aiT.ba((View)localObject1);
      paramInt1 = getPosition((View)localObject1);
      j = this.btp.bsV[paramInt1];
      localObject1 = b((View)localObject1, (b)this.bsY.get(j));
      this.btz.aiN = 1;
      localObject2 = this.btz;
      ((b)localObject2).mPosition = (((b)localObject2).aiN + paramInt1);
      if (this.btp.bsV.length > this.btz.mPosition) {
        break label458;
      }
      this.btz.btI = -1;
      label222:
      if (i == 0) {
        break label488;
      }
      this.btz.zP = this.aiT.aZ((View)localObject1);
      this.btz.ajl = (-this.aiT.aZ((View)localObject1) + this.aiT.kT());
      localObject1 = this.btz;
      if (this.btz.ajl < 0) {
        break label483;
      }
      paramInt1 = this.btz.ajl;
      label291:
      ((b)localObject1).ajl = paramInt1;
      label297:
      if (((this.btz.btI == -1) || (this.btz.btI > this.bsY.size() - 1)) && (this.btz.mPosition <= getFlexItemCount()))
      {
        paramInt1 = paramInt2 - this.btz.ajl;
        this.btq.reset();
        if (paramInt1 > 0)
        {
          if (!bool) {
            break label531;
          }
          this.btp.a(this.btq, k, m, paramInt1, this.btz.mPosition, this.bsY);
        }
      }
    }
    for (;;)
    {
      this.btp.u(k, m, this.btz.mPosition);
      this.btp.fG(this.btz.mPosition);
      localObject1 = this.btz;
      ((b)localObject1).aiL = (paramInt2 - ((b)localObject1).ajl);
      AppMethodBeat.o(62386);
      return;
      i = 0;
      break;
      label458:
      this.btz.btI = this.btp.bsV[this.btz.mPosition];
      break label222;
      label483:
      paramInt1 = 0;
      break label291;
      label488:
      this.btz.zP = this.aiT.ba((View)localObject1);
      this.btz.ajl = (this.aiT.ba((View)localObject1) - this.aiT.kU());
      break label297;
      label531:
      this.btp.c(this.btq, k, m, paramInt1, this.btz.mPosition, this.bsY);
    }
    label561:
    Object localObject1 = getChildAt(0);
    this.btz.zP = this.aiT.aZ((View)localObject1);
    k = getPosition((View)localObject1);
    paramInt1 = this.btp.bsV[k];
    localObject1 = a((View)localObject1, (b)this.bsY.get(paramInt1));
    this.btz.aiN = 1;
    paramInt1 = this.btp.bsV[k];
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        localObject2 = (b)this.bsY.get(paramInt1 - 1);
        this.btz.mPosition = (k - ((b)localObject2).alU);
        label686:
        localObject2 = this.btz;
        if (paramInt1 <= 0) {
          break label797;
        }
        paramInt1 -= 1;
      }
      for (;;)
      {
        ((b)localObject2).btI = paramInt1;
        if (i == 0) {
          break label802;
        }
        this.btz.zP = this.aiT.ba((View)localObject1);
        this.btz.ajl = (this.aiT.ba((View)localObject1) - this.aiT.kU());
        localObject1 = this.btz;
        paramInt1 = j;
        if (this.btz.ajl >= 0) {
          paramInt1 = this.btz.ajl;
        }
        ((b)localObject1).ajl = paramInt1;
        break;
        this.btz.mPosition = -1;
        break label686;
        label797:
        paramInt1 = 0;
      }
      label802:
      this.btz.zP = this.aiT.aZ((View)localObject1);
      this.btz.ajl = (-this.aiT.aZ((View)localObject1) + this.aiT.kT());
      break;
    }
  }
  
  private View bx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62404);
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (bS(localView))
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
    AppMethodBeat.i(188113);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(188113);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = fP(i);
    View localView2 = fQ(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(188113);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(188113);
      throw params;
    }
    int k = getPosition(localView1);
    int j = getPosition(localView2);
    i = Math.abs(this.aiT.ba(localView2) - this.aiT.aZ(localView1));
    k = this.btp.bsV[k];
    if ((k == 0) || (k == -1))
    {
      AppMethodBeat.o(188113);
      return 0;
    }
    j = this.btp.bsV[j];
    i = Math.round(i / (j - k + 1) * k + (this.aiT.kT() - this.aiT.aZ(localView1)));
    AppMethodBeat.o(188113);
    return i;
  }
  
  private void c(RecyclerView.n paramn, b paramb)
  {
    AppMethodBeat.i(188011);
    if (paramb.ajl < 0)
    {
      AppMethodBeat.o(188011);
      return;
    }
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      paramn = new AssertionError();
      AppMethodBeat.o(188011);
      throw paramn;
    }
    this.aiT.getEnd();
    int j = getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(188011);
      return;
    }
    Object localObject1 = getChildAt(j - 1);
    int k = this.btp.bsV[getPosition(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(188011);
      return;
    }
    int n = j - 1;
    localObject1 = (b)this.bsY.get(k);
    int i = n;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break label247;
      }
      View localView = getChildAt(i);
      m = j;
      if (!J(localView, paramb.ajl)) {
        break label247;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).bsS == getPosition(localView))
      {
        if (k <= 0) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bsY.get(m);
        j = i;
      }
      i -= 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label247:
    a(paramn, m, n);
    AppMethodBeat.o(188011);
  }
  
  private int d(RecyclerView.s params)
  {
    AppMethodBeat.i(188103);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(188103);
      return 0;
    }
    int i = params.getItemCount();
    vQ();
    View localView1 = fP(i);
    View localView2 = fQ(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(188103);
      return 0;
    }
    i = this.aiT.ba(localView2);
    int j = this.aiT.aZ(localView1);
    i = Math.min(this.aiT.kV(), i - j);
    AppMethodBeat.o(188103);
    return i;
  }
  
  private int e(RecyclerView.s params)
  {
    AppMethodBeat.i(188120);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(188120);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = fP(i);
    View localView2 = fQ(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(188120);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(188120);
      throw params;
    }
    i = kJ();
    int j = kL();
    i = (int)(Math.abs(this.aiT.ba(localView2) - this.aiT.aZ(localView1)) / (j - i + 1) * params.getItemCount());
    AppMethodBeat.o(188120);
    return i;
  }
  
  private void fO(int paramInt)
  {
    AppMethodBeat.i(62354);
    if (paramInt >= kL())
    {
      AppMethodBeat.o(62354);
      return;
    }
    int i = getChildCount();
    this.btp.fI(i);
    this.btp.fH(i);
    this.btp.fJ(i);
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62354);
      throw ((Throwable)localObject);
    }
    if (paramInt >= this.btp.bsV.length)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.btH = paramInt;
    Object localObject = getChildAt(0);
    if (localObject == null)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.aiZ = getPosition((View)localObject);
    if ((!vF()) && (this.tL))
    {
      this.aja = (this.aiT.ba((View)localObject) + this.aiT.kW());
      AppMethodBeat.o(62354);
      return;
    }
    this.aja = (this.aiT.aZ((View)localObject) - this.aiT.kT());
    AppMethodBeat.o(62354);
  }
  
  private View fP(int paramInt)
  {
    AppMethodBeat.i(62359);
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62359);
      throw ((Throwable)localObject);
    }
    Object localObject = w(0, getChildCount(), paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    paramInt = getPosition((View)localObject);
    paramInt = this.btp.bsV[paramInt];
    if (paramInt == -1)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    localObject = a((View)localObject, (b)this.bsY.get(paramInt));
    AppMethodBeat.o(62359);
    return localObject;
  }
  
  private View fQ(int paramInt)
  {
    AppMethodBeat.i(62360);
    if ((!$assertionsDisabled) && (this.btp.bsV == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62360);
      throw ((Throwable)localObject);
    }
    Object localObject = w(getChildCount() - 1, -1, paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62360);
      return null;
    }
    paramInt = getPosition((View)localObject);
    paramInt = this.btp.bsV[paramInt];
    localObject = b((View)localObject, (b)this.bsY.get(paramInt));
    AppMethodBeat.o(62360);
    return localObject;
  }
  
  private int fR(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(62385);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(62385);
      return 0;
    }
    vQ();
    boolean bool = vF();
    int i;
    int j;
    if (bool)
    {
      i = this.btG.getWidth();
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
      i = -Math.min(j + a.i(this.btA) - i, k);
    }
    for (;;)
    {
      AppMethodBeat.o(62385);
      return i;
      i = this.btG.getHeight();
      break;
      label124:
      j = getHeight();
      break label61;
      label132:
      i = paramInt;
      if (a.i(this.btA) + paramInt > 0)
      {
        i = -a.i(this.btA);
        continue;
        label158:
        if (paramInt > 0)
        {
          i = Math.min(j - a.i(this.btA) - i, paramInt);
        }
        else
        {
          i = paramInt;
          if (a.i(this.btA) + paramInt < 0) {
            i = -a.i(this.btA);
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
  
  private void kD()
  {
    AppMethodBeat.i(62375);
    if (this.btz == null) {
      this.btz = new b((byte)0);
    }
    AppMethodBeat.o(62375);
  }
  
  private int kJ()
  {
    AppMethodBeat.i(62402);
    View localView = bx(0, getChildCount());
    if (localView == null)
    {
      AppMethodBeat.o(62402);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(62402);
    return i;
  }
  
  private int kL()
  {
    AppMethodBeat.i(62403);
    View localView = bx(getChildCount() - 1, -1);
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
    if (this.bta != paramInt)
    {
      removeAllViews();
      this.bta = paramInt;
      this.aiT = null;
      this.btB = null;
      vR();
      requestLayout();
    }
    AppMethodBeat.o(62331);
  }
  
  private boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(188122);
    if ((paramView.isLayoutRequested()) || (!isMeasurementCacheEnabled()) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(188122);
      return true;
    }
    AppMethodBeat.o(188122);
    return false;
  }
  
  private void vP()
  {
    AppMethodBeat.i(62373);
    int i;
    b localb;
    if (vF())
    {
      i = getHeightMode();
      localb = this.btz;
      if ((i != 0) && (i != -2147483648)) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      localb.aiR = bool;
      AppMethodBeat.o(62373);
      return;
      i = getWidthMode();
      break;
    }
  }
  
  private void vQ()
  {
    AppMethodBeat.i(62374);
    if (this.aiT != null)
    {
      AppMethodBeat.o(62374);
      return;
    }
    if (vF())
    {
      if (this.btb != 0)
      {
        this.aiT = u.e(this);
        this.btB = u.d(this);
        AppMethodBeat.o(62374);
      }
    }
    else if (this.btb == 0)
    {
      this.aiT = u.e(this);
      this.btB = u.d(this);
      AppMethodBeat.o(62374);
      return;
    }
    this.aiT = u.d(this);
    this.btB = u.e(this);
    AppMethodBeat.o(62374);
  }
  
  private void vR()
  {
    AppMethodBeat.i(62400);
    this.bsY.clear();
    a.b(this.btA);
    a.d(this.btA, 0);
    AppMethodBeat.o(62400);
  }
  
  private View w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62361);
    vQ();
    kD();
    int j = this.aiT.kT();
    int k = this.aiT.kU();
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
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aiC.isRemoved()) {
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
      if ((this.aiT.aZ(localView) < j) || (this.aiT.ba(localView) > k))
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
  
  public final void a(int paramInt, View paramView)
  {
    AppMethodBeat.i(62342);
    this.btF.put(paramInt, paramView);
    AppMethodBeat.o(62342);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62334);
    calculateItemDecorationsForChild(paramView, btx);
    if (vF())
    {
      paramInt1 = getLeftDecorationWidth(paramView) + getRightDecorationWidth(paramView);
      paramb.bsJ += paramInt1;
      paramb.bsK = (paramInt1 + paramb.bsK);
      AppMethodBeat.o(62334);
      return;
    }
    paramInt1 = getTopDecorationHeight(paramView) + getBottomDecorationHeight(paramView);
    paramb.bsJ += paramInt1;
    paramb.bsK = (paramInt1 + paramb.bsK);
    AppMethodBeat.o(62334);
  }
  
  public final void a(b paramb) {}
  
  public final int bR(View paramView)
  {
    AppMethodBeat.i(62333);
    if (vF())
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
  
  public final PointF cB(int paramInt)
  {
    AppMethodBeat.i(62343);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62343);
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {}
    for (paramInt = -1; vF(); paramInt = 1)
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
    if ((!vF()) || (getWidth() > this.btG.getWidth()))
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
    if ((vF()) || (getHeight() > this.btG.getHeight()))
    {
      AppMethodBeat.o(62381);
      return true;
    }
    AppMethodBeat.o(62381);
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(188098);
    int i = d(params);
    AppMethodBeat.o(188098);
    return i;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(188109);
    int i = c(params);
    AppMethodBeat.o(188109);
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(188115);
    int i = e(params);
    AppMethodBeat.o(188115);
    return i;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(188100);
    int i = d(params);
    AppMethodBeat.o(188100);
    return i;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(188111);
    int i = c(params);
    AppMethodBeat.o(188111);
    return i;
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(188117);
    int i = e(params);
    AppMethodBeat.o(188117);
    return i;
  }
  
  public final View fC(int paramInt)
  {
    AppMethodBeat.i(62336);
    View localView = (View)this.btF.get(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(62336);
      return localView;
    }
    localView = this.ajQ.cR(paramInt);
    AppMethodBeat.o(62336);
    return localView;
  }
  
  public final View fD(int paramInt)
  {
    AppMethodBeat.i(62337);
    View localView = fC(paramInt);
    AppMethodBeat.o(62337);
    return localView;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(187923);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(187923);
    return localLayoutParams;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(187927);
    paramContext = new LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(187927);
    return paramContext;
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.btd;
  }
  
  public int getFlexDirection()
  {
    return this.bta;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(62335);
    int i = this.akL.getItemCount();
    AppMethodBeat.o(62335);
    return i;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bsY;
  }
  
  public int getFlexWrap()
  {
    return this.btb;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62340);
    if (this.bsY.size() == 0)
    {
      AppMethodBeat.o(62340);
      return 0;
    }
    int j = -2147483648;
    int k = this.bsY.size();
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, ((b)this.bsY.get(i)).bsJ);
      i += 1;
    }
    AppMethodBeat.o(62340);
    return j;
  }
  
  public int getMaxLine()
  {
    return this.btf;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62341);
    int k = this.bsY.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((b)this.bsY.get(i)).bsL;
      i += 1;
    }
    AppMethodBeat.o(62341);
    return j;
  }
  
  public final int k(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62332);
    if (vF())
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
    AppMethodBeat.i(187929);
    removeAllViews();
    AppMethodBeat.o(187929);
  }
  
  public void onAttachedToWindow(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(188066);
    super.onAttachedToWindow(paramRecyclerView);
    this.btG = ((View)paramRecyclerView.getParent());
    AppMethodBeat.o(188066);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(188068);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.ajb)
    {
      removeAndRecycleAllViews(paramn);
      paramn.clear();
    }
    AppMethodBeat.o(188068);
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187941);
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    fO(paramInt1);
    AppMethodBeat.o(187941);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187959);
    super.onItemsMoved(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    fO(Math.min(paramInt1, paramInt2));
    AppMethodBeat.o(187959);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187954);
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
    fO(paramInt1);
    AppMethodBeat.o(187954);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187951);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    fO(paramInt1);
    AppMethodBeat.o(187951);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(187943);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2, paramObject);
    fO(paramInt1);
    AppMethodBeat.o(187943);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(187981);
    this.ajQ = paramn;
    this.akL = params;
    int k = params.getItemCount();
    if ((k == 0) && (params.alW))
    {
      AppMethodBeat.o(187981);
      return;
    }
    int i = getLayoutDirection();
    a locala;
    Object localObject;
    boolean bool;
    switch (this.bta)
    {
    default: 
      this.tL = false;
      this.bty = false;
      vQ();
      kD();
      this.btp.fI(k);
      this.btp.fH(k);
      this.btp.fJ(k);
      this.btz.btM = false;
      if ((this.btC != null) && (SavedState.c(this.btC, k))) {
        this.aiZ = SavedState.b(this.btC);
      }
      if ((a.a(this.btA)) && (this.aiZ == -1) && (this.btC == null)) {
        break label619;
      }
      a.b(this.btA);
      locala = this.btA;
      localObject = this.btC;
      if ((!$assertionsDisabled) && (this.btp.bsV == null))
      {
        paramn = new AssertionError();
        AppMethodBeat.o(187981);
        throw paramn;
      }
      label397:
      label441:
      break;
    case 0: 
      if (i == 1)
      {
        bool = true;
        this.tL = bool;
        if (this.btb != 2) {
          break label279;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bty = bool;
        break;
        bool = false;
        break label247;
      }
    case 1: 
      if (i != 1)
      {
        bool = true;
        this.tL = bool;
        if (this.btb != 2) {
          break label325;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bty = bool;
        break;
        bool = false;
        break label293;
      }
    case 2: 
      if (i == 1)
      {
        bool = true;
        this.tL = bool;
        if (this.btb == 2) {
          if (this.tL) {
            break label383;
          }
        }
      }
      for (bool = true;; bool = false)
      {
        this.tL = bool;
        this.bty = false;
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
        this.tL = bool;
        if (this.btb == 2) {
          if (this.tL) {
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
        this.tL = bool;
        this.bty = true;
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
    if ((params.alW) || (this.aiZ == -1))
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
        localObject = fQ(params.getItemCount());
        if (localObject == null) {
          break label1263;
        }
        a.a(locala, (View)localObject);
        if ((!params.alW) && (supportsPredictiveItemAnimations()))
        {
          if ((this.aiT.aZ((View)localObject) < this.aiT.kU()) && (this.aiT.ba((View)localObject) >= this.aiT.kT())) {
            break label1247;
          }
          i = 1;
          if (i != 0)
          {
            if (!a.d(locala)) {
              break label1252;
            }
            i = this.aiT.kU();
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
      a.c(this.btA);
      detachAndScrapAttachedViews(paramn);
      if (!a.d(this.btA)) {
        break label1268;
      }
      b(this.btA, false, true);
      m = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
      n = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
      i1 = getWidth();
      i2 = getHeight();
      if (!vF()) {
        break label1298;
      }
      if ((this.btD == -2147483648) || (this.btD == i1)) {
        break label1281;
      }
      i = 1;
      label709:
      if (!this.btz.aiR) {
        break label1286;
      }
    }
    label1281:
    label1286:
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = this.btz.aiL)
    {
      this.btD = i1;
      this.btE = i2;
      if ((this.btH != -1) || ((this.aiZ == -1) && (i == 0))) {
        break label1604;
      }
      if (a.d(this.btA)) {
        break label1471;
      }
      this.bsY.clear();
      if (($assertionsDisabled) || (this.btp.bsV != null)) {
        break label1363;
      }
      paramn = new AssertionError();
      AppMethodBeat.o(187981);
      throw paramn;
      if ((this.aiZ < 0) || (this.aiZ >= params.getItemCount()))
      {
        this.aiZ = -1;
        this.aja = -2147483648;
        i = 0;
        break;
      }
      a.b(locala, this.aiZ);
      a.a(locala, this.btp.bsV[a.e(locala)]);
      if ((this.btC != null) && (SavedState.c(this.btC, params.getItemCount())))
      {
        i = this.aiT.kT();
        a.c(locala, SavedState.c((SavedState)localObject) + i);
        a.h(locala);
        a.a(locala, -1);
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.aja == -2147483648)
        {
          localObject = findViewByPosition(this.aiZ);
          if (localObject != null)
          {
            if (this.aiT.bd((View)localObject) > this.aiT.kV())
            {
              a.g(locala);
            }
            else if (this.aiT.aZ((View)localObject) - this.aiT.kT() < 0)
            {
              a.c(locala, this.aiT.kT());
              a.a(locala, false);
            }
            else if (this.aiT.kU() - this.aiT.ba((View)localObject) < 0)
            {
              a.c(locala, this.aiT.kU());
              a.a(locala, true);
            }
            else
            {
              if (a.d(locala)) {}
              for (i = this.aiT.ba((View)localObject) + this.aiT.kS();; i = this.aiT.aZ((View)localObject))
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
              if (this.aiZ >= i) {
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
        else if ((!vF()) && (this.tL))
        {
          a.c(locala, this.aja - this.aiT.kW());
        }
        else
        {
          a.c(locala, this.aiT.kT() + this.aja);
        }
      }
      label1234:
      localObject = fP(params.getItemCount());
      break label493;
      label1247:
      i = 0;
      break label559;
      label1252:
      i = this.aiT.kT();
      break label579;
      label1263:
      i = 0;
      break label588;
      label1268:
      a(this.btA, false, true);
      break label644;
      i = 0;
      break label709;
    }
    label1298:
    if ((this.btE != -2147483648) && (this.btE != i2))
    {
      i = 1;
      label1318:
      if (!this.btz.aiR) {
        break label1351;
      }
    }
    label1351:
    for (j = this.mContext.getResources().getDisplayMetrics().widthPixels;; j = this.btz.aiL)
    {
      break;
      i = 0;
      break label1318;
    }
    label1363:
    this.btq.reset();
    if (vF())
    {
      this.btp.b(this.btq, m, n, j, a.e(this.btA), this.bsY);
      this.bsY = this.btq.bsY;
      this.btp.bs(m, n);
      this.btp.vN();
      a.a(this.btA, this.btp.bsV[a.e(this.btA)]);
      this.btz.btI = a.f(this.btA);
      label1471:
      if (!a.d(this.btA)) {
        break label1863;
      }
      a(paramn, params, this.btz);
      j = this.btz.zP;
      a(this.btA, true, false);
      a(paramn, params, this.btz);
      i = this.btz.zP;
    }
    for (;;)
    {
      if (getChildCount() > 0)
      {
        if (a.d(this.btA))
        {
          b(a(i, paramn, params, true) + j, paramn, params, false);
          AppMethodBeat.o(187981);
          return;
          this.btp.d(this.btq, m, n, j, a.e(this.btA), this.bsY);
          break;
          label1604:
          if (this.btH != -1)
          {
            i = Math.min(this.btH, a.e(this.btA));
            label1627:
            this.btq.reset();
            if (!vF()) {
              break label1773;
            }
            if (this.bsY.size() <= 0) {
              break label1739;
            }
            this.btp.c(this.bsY, i);
            this.btp.a(this.btq, m, n, j, i, a.e(this.btA), this.bsY);
          }
          for (;;)
          {
            this.bsY = this.btq.bsY;
            this.btp.u(m, n, i);
            this.btp.fG(i);
            break;
            i = a.e(this.btA);
            break label1627;
            label1739:
            this.btp.fJ(k);
            this.btp.a(this.btq, m, n, j, 0, this.bsY);
            continue;
            label1773:
            if (this.bsY.size() > 0)
            {
              this.btp.c(this.bsY, i);
              this.btp.a(this.btq, n, m, j, i, a.e(this.btA), this.bsY);
            }
            else
            {
              this.btp.fJ(k);
              this.btp.c(this.btq, m, n, j, 0, this.bsY);
            }
          }
          label1863:
          a(paramn, params, this.btz);
          i = this.btz.zP;
          b(this.btA, true, false);
          a(paramn, params, this.btz);
          j = this.btz.zP;
          continue;
        }
        a(i + b(j, paramn, params, true), paramn, params, false);
      }
    }
    AppMethodBeat.o(187981);
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(187989);
    super.onLayoutCompleted(params);
    this.btC = null;
    this.aiZ = -1;
    this.aja = -2147483648;
    this.btH = -1;
    a.b(this.btA);
    this.btF.clear();
    AppMethodBeat.o(187989);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62348);
    if ((paramParcelable instanceof SavedState))
    {
      this.btC = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(62348);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(62347);
    if (this.btC != null)
    {
      localSavedState = new SavedState(this.btC, (byte)0);
      AppMethodBeat.o(62347);
      return localSavedState;
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      SavedState.a(localSavedState, getPosition(localView));
      SavedState.b(localSavedState, this.aiT.aZ(localView) - this.aiT.kT());
    }
    for (;;)
    {
      AppMethodBeat.o(62347);
      return localSavedState;
      SavedState.a(localSavedState);
    }
  }
  
  public final int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62338);
    paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), paramInt2, paramInt3, canScrollHorizontally());
    AppMethodBeat.o(62338);
    return paramInt1;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(188077);
    if (!vF())
    {
      paramInt = b(paramInt, paramn, params);
      this.btF.clear();
      AppMethodBeat.o(188077);
      return paramInt;
    }
    paramInt = fR(paramInt);
    paramn = this.btA;
    a.d(paramn, a.i(paramn) + paramInt);
    this.btB.cG(-paramInt);
    AppMethodBeat.o(188077);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(62376);
    this.aiZ = paramInt;
    this.aja = -2147483648;
    if (this.btC != null) {
      SavedState.a(this.btC);
    }
    requestLayout();
    AppMethodBeat.o(62376);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(188083);
    if (vF())
    {
      paramInt = b(paramInt, paramn, params);
      this.btF.clear();
      AppMethodBeat.o(188083);
      return paramInt;
    }
    paramInt = fR(paramInt);
    paramn = this.btA;
    a.d(paramn, a.i(paramn) + paramInt);
    this.btB.cG(-paramInt);
    AppMethodBeat.o(188083);
    return paramInt;
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bsY = paramList;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(188049);
    paramRecyclerView = new p(paramRecyclerView.getContext());
    paramRecyclerView.alG = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(188049);
  }
  
  public final int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62339);
    paramInt1 = getChildMeasureSpec(getHeight(), getHeightMode(), paramInt2, paramInt3, canScrollVertically());
    AppMethodBeat.o(62339);
    return paramInt1;
  }
  
  public final boolean vF()
  {
    return (this.bta == 0) || (this.bta == 1);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private int CO;
    private int EK;
    private float bts;
    private float btt;
    private int btu;
    private float btv;
    private boolean btw;
    private int lj;
    private int uJ;
    
    static
    {
      AppMethodBeat.i(62323);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(62323);
    }
    
    public LayoutParams()
    {
      super(-2);
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(-2);
      AppMethodBeat.i(62322);
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
      this.bts = paramParcel.readFloat();
      this.btt = paramParcel.readFloat();
      this.btu = paramParcel.readInt();
      this.btv = paramParcel.readFloat();
      this.lj = paramParcel.readInt();
      this.CO = paramParcel.readInt();
      this.uJ = paramParcel.readInt();
      this.EK = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.btw = bool;
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
      return this.bts;
    }
    
    public final float getFlexShrink()
    {
      return this.btt;
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
      return this.EK;
    }
    
    public final int getMaxWidth()
    {
      return this.uJ;
    }
    
    public final int getMinHeight()
    {
      return this.CO;
    }
    
    public final int getMinWidth()
    {
      return this.lj;
    }
    
    public final int getOrder()
    {
      return 1;
    }
    
    public final int getWidth()
    {
      return this.width;
    }
    
    public final int vG()
    {
      return this.btu;
    }
    
    public final boolean vH()
    {
      return this.btw;
    }
    
    public final float vI()
    {
      return this.btv;
    }
    
    public final int vJ()
    {
      return this.leftMargin;
    }
    
    public final int vK()
    {
      return this.topMargin;
    }
    
    public final int vL()
    {
      return this.rightMargin;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62321);
      paramParcel.writeFloat(this.bts);
      paramParcel.writeFloat(this.btt);
      paramParcel.writeInt(this.btu);
      paramParcel.writeFloat(this.btv);
      paramParcel.writeInt(this.lj);
      paramParcel.writeInt(this.CO);
      paramParcel.writeInt(this.uJ);
      paramParcel.writeInt(this.EK);
      if (this.btw) {}
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
    private int ajq;
    private int ajr;
    
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
      this.ajq = paramParcel.readInt();
      this.ajr = paramParcel.readInt();
      AppMethodBeat.o(62327);
    }
    
    private SavedState(SavedState paramSavedState)
    {
      this.ajq = paramSavedState.ajq;
      this.ajr = paramSavedState.ajr;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(62328);
      String str = "SavedState{mAnchorPosition=" + this.ajq + ", mAnchorOffset=" + this.ajr + '}';
      AppMethodBeat.o(62328);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62326);
      paramParcel.writeInt(this.ajq);
      paramParcel.writeInt(this.ajr);
      AppMethodBeat.o(62326);
    }
  }
  
  final class a
  {
    private int ajg;
    private boolean ajh;
    private boolean aji;
    private int btI;
    private int btJ = 0;
    private boolean btK;
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
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.btI + ", mCoordinate=" + this.ajg + ", mPerpendicularCoordinate=" + this.btJ + ", mLayoutFromEnd=" + this.ajh + ", mValid=" + this.aji + ", mAssignedFromSavedState=" + this.btK + '}';
      AppMethodBeat.o(62315);
      return str;
    }
  }
  
  static final class b
  {
    int aiL;
    int aiN = 1;
    boolean aiR;
    int ajl;
    int ajo;
    int btI;
    boolean btM;
    int mLayoutDirection = 1;
    int mPosition;
    int zP;
    
    public final String toString()
    {
      AppMethodBeat.i(62324);
      String str = "LayoutState{mAvailable=" + this.aiL + ", mFlexLinePosition=" + this.btI + ", mPosition=" + this.mPosition + ", mOffset=" + this.zP + ", mScrollingOffset=" + this.ajl + ", mLastScrollDelta=" + this.ajo + ", mItemDirection=" + this.aiN + ", mLayoutDirection=" + this.mLayoutDirection + '}';
      AppMethodBeat.o(62324);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager
 * JD-Core Version:    0.7.0.1
 */