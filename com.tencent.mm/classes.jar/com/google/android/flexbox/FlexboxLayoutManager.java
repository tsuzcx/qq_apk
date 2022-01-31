package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
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
import java.util.List;

public class FlexboxLayoutManager
  extends RecyclerView.i
  implements RecyclerView.r.b, a
{
  private static final Rect bdB;
  private aj agm;
  private int ags;
  private int agt;
  private boolean agu;
  private RecyclerView.o ahO;
  private RecyclerView.s aiK;
  private boolean bdC;
  private b bdD;
  private a bdE;
  private aj bdF;
  private FlexboxLayoutManager.SavedState bdG;
  private int bdH;
  private int bdI;
  private SparseArray<View> bdJ;
  private View bdK;
  private int bdL;
  private List<b> bdd;
  private int bdf;
  private int bdg;
  private int bdh;
  private int bdi;
  private int bdk;
  private final c bdt;
  private c.a bdu;
  private final Context mContext;
  private boolean mIsRtl;
  
  static
  {
    AppMethodBeat.i(54865);
    if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      bdB = new Rect();
      AppMethodBeat.o(54865);
      return;
    }
  }
  
  private boolean G(View paramView, int paramInt)
  {
    AppMethodBeat.i(54827);
    if ((!rl()) && (this.mIsRtl))
    {
      if (this.agm.getEnd() - this.agm.bh(paramView) <= paramInt)
      {
        AppMethodBeat.o(54827);
        return true;
      }
      AppMethodBeat.o(54827);
      return false;
    }
    if (this.agm.bi(paramView) <= paramInt)
    {
      AppMethodBeat.o(54827);
      return true;
    }
    AppMethodBeat.o(54827);
    return false;
  }
  
  private boolean H(View paramView, int paramInt)
  {
    AppMethodBeat.i(54829);
    if ((!rl()) && (this.mIsRtl))
    {
      if (this.agm.bi(paramView) <= paramInt)
      {
        AppMethodBeat.o(54829);
        return true;
      }
      AppMethodBeat.o(54829);
      return false;
    }
    if (this.agm.bh(paramView) >= this.agm.getEnd() - paramInt)
    {
      AppMethodBeat.o(54829);
      return true;
    }
    AppMethodBeat.o(54829);
    return false;
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(54818);
    int i;
    if ((!rl()) && (this.mIsRtl))
    {
      i = 1;
      if (i == 0) {
        break label106;
      }
      i = paramInt - this.agm.iI();
      if (i <= 0) {
        break label99;
      }
      i = d(i, paramo, params);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramInt = this.agm.iJ() - (paramInt + i);
        if (paramInt > 0)
        {
          this.agm.bN(paramInt);
          AppMethodBeat.o(54818);
          return i + paramInt;
          i = 0;
          break;
          label99:
          AppMethodBeat.o(54818);
          return 0;
          label106:
          i = this.agm.iJ() - paramInt;
          if (i > 0)
          {
            i = -d(-i, paramo, params);
          }
          else
          {
            AppMethodBeat.o(54818);
            return 0;
          }
        }
      }
    }
    AppMethodBeat.o(54818);
    return i;
  }
  
  private int a(RecyclerView.o paramo, RecyclerView.s params, b paramb)
  {
    AppMethodBeat.i(54824);
    if (paramb.agE != -2147483648)
    {
      if (paramb.afS < 0) {
        paramb.agE += paramb.afS;
      }
      a(paramo, paramb);
    }
    int i2 = paramb.afS;
    int j = paramb.afS;
    boolean bool = rl();
    int k = 0;
    Object localObject;
    int i;
    int n;
    int i3;
    int m;
    if ((j > 0) || (this.bdD.afY))
    {
      localObject = this.bdd;
      if ((paramb.mPosition >= 0) && (paramb.mPosition < params.getItemCount()) && (paramb.bdM >= 0) && (paramb.bdM < ((List)localObject).size())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = (b)this.bdd.get(paramb.bdM);
          paramb.mPosition = ((b)localObject).bcX;
          if (rl())
          {
            if ((!$assertionsDisabled) && (this.bdt.bdb == null))
            {
              paramo = new AssertionError();
              AppMethodBeat.o(54824);
              throw paramo;
              i = 0;
              continue;
            }
            i = getPaddingLeft();
            n = getPaddingRight();
            i3 = this.mWidth;
            m = paramb.Fb;
            if (paramb.mLayoutDirection != -1) {
              break label1166;
            }
            m -= ((b)localObject).bcQ;
          }
        }
      }
    }
    label1163:
    label1166:
    for (;;)
    {
      int i1 = paramb.mPosition;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      label347:
      float f4;
      label399:
      View localView;
      label445:
      int i4;
      switch (this.bdh)
      {
      default: 
        paramo = new IllegalStateException("Invalid justifyContent is set: " + this.bdh);
        AppMethodBeat.o(54824);
        throw paramo;
      case 0: 
        f1 = i;
        f2 = i3 - n;
        f4 = a.i(this.bdE);
        f2 -= a.i(this.bdE);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i3 = ((b)localObject).ake;
        f1 -= f4;
        n = i1;
        if (n < i1 + i3)
        {
          localView = ev(n);
          if (localView == null) {
            break label1163;
          }
          if (paramb.mLayoutDirection == 1)
          {
            g(localView, bdB);
            addView(localView);
            long l = this.bdt.bdb[n];
            i4 = c.am(l);
            int i5 = c.an(l);
            FlexboxLayoutManager.LayoutParams localLayoutParams = (FlexboxLayoutManager.LayoutParams)localView.getLayoutParams();
            if (b(localView, i4, i5, localLayoutParams)) {
              localView.measure(i4, i5);
            }
            f1 += localLayoutParams.leftMargin + bF(localView);
            f2 -= localLayoutParams.rightMargin + bG(localView);
            i4 = m + bD(localView);
            if (!this.mIsRtl) {
              break label937;
            }
            this.bdt.a(localView, (b)localObject, Math.round(f2) - localView.getMeasuredWidth(), i4, Math.round(f2), localView.getMeasuredHeight() + i4);
            label593:
            float f5 = localView.getMeasuredWidth() + localLayoutParams.rightMargin + bG(localView);
            i4 = localView.getMeasuredWidth();
            i5 = localLayoutParams.leftMargin;
            f4 = bF(localView) + (i4 + i5);
            f1 = f5 + f3 + f1;
            f2 -= f4 + f3;
          }
        }
        break;
      }
      for (;;)
      {
        n += 1;
        break label399;
        f1 = i3 - ((b)localObject).bcO + n;
        f2 = ((b)localObject).bcO - i;
        break label347;
        f1 = i + (i3 - ((b)localObject).bcO) / 2.0F;
        f2 = i3 - n - (i3 - ((b)localObject).bcO) / 2.0F;
        break label347;
        f3 = f1;
        if (((b)localObject).ake != 0) {
          f3 = (i3 - ((b)localObject).bcO) / ((b)localObject).ake;
        }
        f1 = i + f3 / 2.0F;
        f2 = i3 - n - f3 / 2.0F;
        break label347;
        f2 = i;
        if (((b)localObject).ake != 1) {}
        for (f1 = ((b)localObject).ake - 1;; f1 = 1.0F)
        {
          f3 = (i3 - ((b)localObject).bcO) / f1;
          f4 = i3 - n;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (((b)localObject).ake != 0) {
          f3 = (i3 - ((b)localObject).bcO) / (((b)localObject).ake + 1);
        }
        f1 = i + f3;
        f2 = i3 - n - f3;
        break label347;
        g(localView, bdB);
        addView(localView, i);
        i += 1;
        break label445;
        label937:
        this.bdt.a(localView, (b)localObject, Math.round(f1), i4, Math.round(f1) + localView.getMeasuredWidth(), localView.getMeasuredHeight() + i4);
        break label593;
        paramb.bdM += this.bdD.mLayoutDirection;
        i = ((b)localObject).bcQ;
        label1000:
        if ((!bool) && (this.mIsRtl)) {}
        for (paramb.Fb -= ((b)localObject).bcQ * paramb.mLayoutDirection;; paramb.Fb += ((b)localObject).bcQ * paramb.mLayoutDirection)
        {
          m = ((b)localObject).bcQ;
          k = i + k;
          j -= m;
          break;
          i = a((b)localObject, paramb);
          break label1000;
        }
        paramb.afS -= k;
        if (paramb.agE != -2147483648)
        {
          paramb.agE += k;
          if (paramb.afS < 0) {
            paramb.agE += paramb.afS;
          }
          a(paramo, paramb);
        }
        i = paramb.afS;
        AppMethodBeat.o(54824);
        return i2 - i;
      }
    }
  }
  
  private int a(b paramb, b paramb1)
  {
    AppMethodBeat.i(54831);
    if ((!$assertionsDisabled) && (this.bdt.bdb == null))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(54831);
      throw paramb;
    }
    int i = getPaddingTop();
    int m = getPaddingBottom();
    int i1 = this.mHeight;
    int k = paramb1.Fb;
    int j = paramb1.Fb;
    int n;
    if (paramb1.mLayoutDirection == -1)
    {
      n = paramb.bcQ;
      j += paramb.bcQ;
      k -= n;
    }
    for (;;)
    {
      n = paramb1.mPosition;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      float f4;
      label252:
      View localView;
      int i2;
      int i3;
      switch (this.bdh)
      {
      default: 
        paramb = new IllegalStateException("Invalid justifyContent is set: " + this.bdh);
        AppMethodBeat.o(54831);
        throw paramb;
      case 0: 
        f1 = i;
        f2 = i1 - m;
        f4 = f1 - a.i(this.bdE);
        f1 = f2 - a.i(this.bdE);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i1 = paramb.ake;
        m = n;
        f2 = f4;
        if (m < n + i1)
        {
          localView = ev(m);
          if (localView == null) {
            break label979;
          }
          long l = this.bdt.bdb[m];
          i2 = c.am(l);
          i3 = c.an(l);
          FlexboxLayoutManager.LayoutParams localLayoutParams = (FlexboxLayoutManager.LayoutParams)localView.getLayoutParams();
          if (b(localView, i2, i3, localLayoutParams)) {
            localView.measure(i2, i3);
          }
          f2 += localLayoutParams.topMargin + bD(localView);
          f1 -= localLayoutParams.rightMargin + bE(localView);
          if (paramb1.mLayoutDirection == 1)
          {
            g(localView, bdB);
            addView(localView);
            label390:
            i2 = k + bF(localView);
            i3 = j - bG(localView);
            if (!this.mIsRtl) {
              break label837;
            }
            if (!this.bdC) {
              break label774;
            }
            this.bdt.a(localView, paramb, this.mIsRtl, i3 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i3, Math.round(f1));
            label462:
            f2 = localView.getMeasuredHeight() + localLayoutParams.topMargin + bE(localView) + f3 + f2;
            i2 = localView.getMeasuredHeight();
            i3 = localLayoutParams.bottomMargin;
            f1 -= bD(localView) + (i2 + i3) + f3;
          }
        }
        break;
      }
      label774:
      label837:
      label979:
      for (;;)
      {
        m += 1;
        break label252;
        f1 = i1 - paramb.bcO + m;
        f2 = paramb.bcO - i;
        break;
        f1 = i + (i1 - paramb.bcO) / 2.0F;
        f2 = i1 - m - (i1 - paramb.bcO) / 2.0F;
        break;
        f3 = f1;
        if (paramb.ake != 0) {
          f3 = (i1 - paramb.bcO) / paramb.ake;
        }
        f1 = i + f3 / 2.0F;
        f2 = i1 - m - f3 / 2.0F;
        break;
        f2 = i;
        if (paramb.ake != 1) {}
        for (f1 = paramb.ake - 1;; f1 = 1.0F)
        {
          f3 = (i1 - paramb.bcO) / f1;
          f4 = i1 - m;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (paramb.ake != 0) {
          f3 = (i1 - paramb.bcO) / (paramb.ake + 1);
        }
        f1 = i + f3;
        f2 = i1 - m - f3;
        break;
        g(localView, bdB);
        addView(localView, i);
        i += 1;
        break label390;
        c localc = this.bdt;
        boolean bool = this.mIsRtl;
        i2 = localView.getMeasuredWidth();
        int i4 = Math.round(f2);
        int i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i3 - i2, i4, i3, localView.getMeasuredHeight() + i5);
        break label462;
        if (this.bdC)
        {
          this.bdt.a(localView, paramb, this.mIsRtl, i2, Math.round(f1) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f1));
          break label462;
        }
        localc = this.bdt;
        bool = this.mIsRtl;
        i3 = Math.round(f2);
        i4 = localView.getMeasuredWidth();
        i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i2, i3, i2 + i4, localView.getMeasuredHeight() + i5);
        break label462;
        paramb1.bdM += this.bdD.mLayoutDirection;
        i = paramb.bcQ;
        AppMethodBeat.o(54831);
        return i;
      }
    }
  }
  
  private View a(View paramView, b paramb)
  {
    AppMethodBeat.i(54848);
    boolean bool = rl();
    int j = paramb.ake;
    int i = 1;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.agm.bi(paramView) >= this.agm.bi(localView)) {
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
        if (this.agm.bh(paramView) <= this.agm.bh(localView)) {
          label115:
          paramb = paramView;
        }
      }
    }
    AppMethodBeat.o(54848);
    return paramView;
  }
  
  private void a(RecyclerView.o paramo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54830);
    while (paramInt2 >= paramInt1)
    {
      a(paramInt2, paramo);
      paramInt2 -= 1;
    }
    AppMethodBeat.o(54830);
  }
  
  private void a(RecyclerView.o paramo, b paramb)
  {
    AppMethodBeat.i(54825);
    if (!paramb.bdQ)
    {
      AppMethodBeat.o(54825);
      return;
    }
    if (paramb.mLayoutDirection == -1)
    {
      c(paramo, paramb);
      AppMethodBeat.o(54825);
      return;
    }
    b(paramo, paramb);
    AppMethodBeat.o(54825);
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54832);
    if (paramBoolean2)
    {
      rv();
      if ((rl()) || (!this.mIsRtl)) {
        break label212;
      }
    }
    label212:
    for (this.bdD.afS = (a.j(parama) - getPaddingRight());; this.bdD.afS = (this.agm.iJ() - a.j(parama)))
    {
      this.bdD.mPosition = a.e(parama);
      this.bdD.afU = 1;
      this.bdD.mLayoutDirection = 1;
      this.bdD.Fb = a.j(parama);
      this.bdD.agE = -2147483648;
      this.bdD.bdM = a.f(parama);
      if ((paramBoolean1) && (this.bdd.size() > 1) && (a.f(parama) >= 0) && (a.f(parama) < this.bdd.size() - 1))
      {
        parama = (b)this.bdd.get(a.f(parama));
        b.a(this.bdD);
        b localb = this.bdD;
        int i = localb.mPosition;
        localb.mPosition = (parama.ake + i);
      }
      AppMethodBeat.o(54832);
      return;
      this.bdD.afY = false;
      break;
    }
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(54817);
    int i;
    if ((!rl()) && (this.mIsRtl))
    {
      i = this.agm.iJ() - paramInt;
      if (i > 0) {
        i = d(-i, paramo, params);
      }
    }
    while (paramBoolean)
    {
      paramInt = paramInt + i - this.agm.iI();
      if (paramInt > 0)
      {
        this.agm.bN(-paramInt);
        AppMethodBeat.o(54817);
        return i - paramInt;
        AppMethodBeat.o(54817);
        return 0;
        i = paramInt - this.agm.iI();
        if (i > 0)
        {
          i = -d(i, paramo, params);
        }
        else
        {
          AppMethodBeat.o(54817);
          return 0;
        }
      }
    }
    AppMethodBeat.o(54817);
    return i;
  }
  
  private View b(View paramView, b paramb)
  {
    AppMethodBeat.i(54849);
    boolean bool = rl();
    int i = getChildCount();
    int j = getChildCount();
    int k = paramb.ake;
    i -= 2;
    if (i > j - k - 1)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.mIsRtl) && (!bool))
        {
          if (this.agm.bh(paramView) <= this.agm.bh(localView)) {
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
        if (this.agm.bi(paramView) >= this.agm.bi(localView)) {
          label133:
          paramb = paramView;
        }
      }
    }
    AppMethodBeat.o(54849);
    return paramView;
  }
  
  private void b(RecyclerView.o paramo, b paramb)
  {
    int j = -1;
    AppMethodBeat.i(54826);
    if (paramb.agE < 0)
    {
      AppMethodBeat.o(54826);
      return;
    }
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      paramo = new AssertionError();
      AppMethodBeat.o(54826);
      throw paramo;
    }
    int n = getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(54826);
      return;
    }
    Object localObject1 = getChildAt(0);
    int k = this.bdt.bda[bv(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(54826);
      return;
    }
    localObject1 = (b)this.bdd.get(k);
    int i = 0;
    for (;;)
    {
      m = j;
      if (i >= n) {
        break label243;
      }
      View localView = getChildAt(i);
      m = j;
      if (!G(localView, paramb.agE)) {
        break label243;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).Sm == bv(localView))
      {
        if (k >= this.bdd.size() - 1) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bdd.get(m);
        j = i;
      }
      i += 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label243:
    a(paramo, 0, m);
    AppMethodBeat.o(54826);
  }
  
  private void b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54833);
    if (paramBoolean2)
    {
      rv();
      if ((rl()) || (!this.mIsRtl)) {
        break label204;
      }
    }
    label204:
    for (this.bdD.afS = (this.bdK.getWidth() - a.j(parama) - this.agm.iI());; this.bdD.afS = (a.j(parama) - this.agm.iI()))
    {
      this.bdD.mPosition = a.e(parama);
      this.bdD.afU = 1;
      this.bdD.mLayoutDirection = -1;
      this.bdD.Fb = a.j(parama);
      this.bdD.agE = -2147483648;
      this.bdD.bdM = a.f(parama);
      if ((paramBoolean1) && (a.f(parama) > 0) && (this.bdd.size() > a.f(parama)))
      {
        parama = (b)this.bdd.get(a.f(parama));
        b.b(this.bdD);
        b localb = this.bdD;
        localb.mPosition -= parama.ake;
      }
      AppMethodBeat.o(54833);
      return;
      this.bdD.afY = false;
      break;
    }
  }
  
  private boolean b(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(54859);
    if ((paramView.isLayoutRequested()) || (!this.ajr) || (!l(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!l(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(54859);
      return true;
    }
    AppMethodBeat.o(54859);
    return false;
  }
  
  private void bh(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(54847);
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(54847);
      throw ((Throwable)localObject1);
    }
    this.bdD.mLayoutDirection = paramInt1;
    boolean bool = rl();
    int k = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.ajv);
    int m = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.ajw);
    int i;
    Object localObject2;
    if ((!bool) && (this.mIsRtl))
    {
      i = 1;
      if (paramInt1 != 1) {
        break label560;
      }
      localObject1 = getChildAt(getChildCount() - 1);
      this.bdD.Fb = this.agm.bi((View)localObject1);
      paramInt1 = bv((View)localObject1);
      j = this.bdt.bda[paramInt1];
      localObject1 = b((View)localObject1, (b)this.bdd.get(j));
      this.bdD.afU = 1;
      localObject2 = this.bdD;
      ((b)localObject2).mPosition = (((b)localObject2).afU + paramInt1);
      if (this.bdt.bda.length > this.bdD.mPosition) {
        break label457;
      }
      this.bdD.bdM = -1;
      label221:
      if (i == 0) {
        break label487;
      }
      this.bdD.Fb = this.agm.bh((View)localObject1);
      this.bdD.agE = (-this.agm.bh((View)localObject1) + this.agm.iI());
      localObject1 = this.bdD;
      if (this.bdD.agE < 0) {
        break label482;
      }
      paramInt1 = this.bdD.agE;
      label290:
      ((b)localObject1).agE = paramInt1;
      label296:
      if (((this.bdD.bdM == -1) || (this.bdD.bdM > this.bdd.size() - 1)) && (this.bdD.mPosition <= getFlexItemCount()))
      {
        paramInt1 = paramInt2 - this.bdD.agE;
        this.bdu.reset();
        if (paramInt1 > 0)
        {
          if (!bool) {
            break label530;
          }
          this.bdt.a(this.bdu, k, m, paramInt1, this.bdD.mPosition, this.bdd);
        }
      }
    }
    for (;;)
    {
      this.bdt.w(k, m, this.bdD.mPosition);
      this.bdt.ez(this.bdD.mPosition);
      localObject1 = this.bdD;
      ((b)localObject1).afS = (paramInt2 - ((b)localObject1).agE);
      AppMethodBeat.o(54847);
      return;
      i = 0;
      break;
      label457:
      this.bdD.bdM = this.bdt.bda[this.bdD.mPosition];
      break label221;
      label482:
      paramInt1 = 0;
      break label290;
      label487:
      this.bdD.Fb = this.agm.bi((View)localObject1);
      this.bdD.agE = (this.agm.bi((View)localObject1) - this.agm.iJ());
      break label296;
      label530:
      this.bdt.c(this.bdu, k, m, paramInt1, this.bdD.mPosition, this.bdd);
    }
    label560:
    Object localObject1 = getChildAt(0);
    this.bdD.Fb = this.agm.bh((View)localObject1);
    k = bv((View)localObject1);
    paramInt1 = this.bdt.bda[k];
    localObject1 = a((View)localObject1, (b)this.bdd.get(paramInt1));
    this.bdD.afU = 1;
    paramInt1 = this.bdt.bda[k];
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        localObject2 = (b)this.bdd.get(paramInt1 - 1);
        this.bdD.mPosition = (k - ((b)localObject2).ake);
        label684:
        localObject2 = this.bdD;
        if (paramInt1 <= 0) {
          break label795;
        }
        paramInt1 -= 1;
      }
      for (;;)
      {
        ((b)localObject2).bdM = paramInt1;
        if (i == 0) {
          break label800;
        }
        this.bdD.Fb = this.agm.bi((View)localObject1);
        this.bdD.agE = (this.agm.bi((View)localObject1) - this.agm.iJ());
        localObject1 = this.bdD;
        paramInt1 = j;
        if (this.bdD.agE >= 0) {
          paramInt1 = this.bdD.agE;
        }
        ((b)localObject1).agE = paramInt1;
        break;
        this.bdD.mPosition = -1;
        break label684;
        label795:
        paramInt1 = 0;
      }
      label800:
      this.bdD.Fb = this.agm.bh((View)localObject1);
      this.bdD.agE = (-this.agm.bh((View)localObject1) + this.agm.iI());
      break;
    }
  }
  
  private View bi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54864);
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (cd(localView))
      {
        AppMethodBeat.o(54864);
        return localView;
        i = -1;
      }
      else
      {
        paramInt1 += i;
      }
    }
    AppMethodBeat.o(54864);
    return null;
  }
  
  private void c(RecyclerView.o paramo, b paramb)
  {
    AppMethodBeat.i(54828);
    if (paramb.agE < 0)
    {
      AppMethodBeat.o(54828);
      return;
    }
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      paramo = new AssertionError();
      AppMethodBeat.o(54828);
      throw paramo;
    }
    int n = getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(54828);
      return;
    }
    Object localObject1 = getChildAt(n - 1);
    int k = this.bdt.bda[bv(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(54828);
      return;
    }
    localObject1 = (b)this.bdd.get(k);
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
      if (!H(localView, paramb.agE)) {
        break label237;
      }
      Object localObject2 = localObject1;
      m = k;
      if (((b)localObject1).bcX == bv(localView))
      {
        if (k <= 0) {
          break;
        }
        m = k + paramb.mLayoutDirection;
        localObject2 = (b)this.bdd.get(m);
        j = i;
      }
      i -= 1;
      localObject1 = localObject2;
      k = m;
    }
    int m = i;
    label237:
    a(paramo, m, n - 1);
    AppMethodBeat.o(54828);
  }
  
  private boolean cd(View paramView)
  {
    AppMethodBeat.i(54861);
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int i4 = this.mWidth;
    int i5 = getPaddingRight();
    int k = this.mHeight;
    int m = getPaddingBottom();
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i6 = bz(paramView);
    int i7 = localLayoutParams.leftMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int n = bA(paramView);
    int i1 = localLayoutParams.topMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i8 = bB(paramView);
    int i9 = localLayoutParams.rightMargin;
    localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i2 = bC(paramView);
    int i3 = localLayoutParams.bottomMargin;
    if ((i6 - i7 >= i4 - i5) || (i8 + i9 >= i)) {}
    for (i = 1;; i = 0)
    {
      if ((n - i1 >= k - m) || (i3 + i2 >= j)) {}
      for (j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0))
        {
          AppMethodBeat.o(54861);
          return true;
        }
        AppMethodBeat.o(54861);
        return false;
      }
    }
  }
  
  private int d(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    int i = 1;
    AppMethodBeat.i(54845);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(54845);
      return 0;
    }
    rw();
    this.bdD.bdQ = true;
    int j;
    if ((!rl()) && (this.mIsRtl))
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
      bh(i, k);
      m = this.bdD.agE + a(paramo, params, this.bdD);
      if (m >= 0) {
        break label135;
      }
      AppMethodBeat.o(54845);
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
      this.agm.bN(-paramInt);
      this.bdD.agH = paramInt;
      AppMethodBeat.o(54845);
      return paramInt;
      if (k > m) {
        paramInt = i * m;
      }
    }
  }
  
  private void eH(int paramInt)
  {
    AppMethodBeat.i(54815);
    int i = it();
    int j = iv();
    if (paramInt >= j)
    {
      AppMethodBeat.o(54815);
      return;
    }
    int k = getChildCount();
    this.bdt.eB(k);
    this.bdt.eA(k);
    this.bdt.eC(k);
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(54815);
      throw ((Throwable)localObject);
    }
    if (paramInt >= this.bdt.bda.length)
    {
      AppMethodBeat.o(54815);
      return;
    }
    this.bdL = paramInt;
    Object localObject = ip();
    if (localObject == null)
    {
      AppMethodBeat.o(54815);
      return;
    }
    if ((i <= paramInt) && (paramInt <= j))
    {
      AppMethodBeat.o(54815);
      return;
    }
    this.ags = bv((View)localObject);
    if ((!rl()) && (this.mIsRtl))
    {
      this.agt = (this.agm.bi((View)localObject) + this.agm.getEndPadding());
      AppMethodBeat.o(54815);
      return;
    }
    this.agt = (this.agm.bh((View)localObject) - this.agm.iI());
    AppMethodBeat.o(54815);
  }
  
  private View eI(int paramInt)
  {
    AppMethodBeat.i(54820);
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(54820);
      throw ((Throwable)localObject);
    }
    Object localObject = y(0, getChildCount(), paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(54820);
      return null;
    }
    paramInt = bv((View)localObject);
    paramInt = this.bdt.bda[paramInt];
    if (paramInt == -1)
    {
      AppMethodBeat.o(54820);
      return null;
    }
    localObject = a((View)localObject, (b)this.bdd.get(paramInt));
    AppMethodBeat.o(54820);
    return localObject;
  }
  
  private View eJ(int paramInt)
  {
    AppMethodBeat.i(54821);
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(54821);
      throw ((Throwable)localObject);
    }
    Object localObject = y(getChildCount() - 1, -1, paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(54821);
      return null;
    }
    paramInt = bv((View)localObject);
    paramInt = this.bdt.bda[paramInt];
    localObject = b((View)localObject, (b)this.bdd.get(paramInt));
    AppMethodBeat.o(54821);
    return localObject;
  }
  
  private int eK(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(54846);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(54846);
      return 0;
    }
    rw();
    boolean bool = rl();
    int i;
    int j;
    if (bool)
    {
      i = this.bdK.getWidth();
      if (!bool) {
        break label127;
      }
      j = this.mWidth;
      label61:
      if (t.T(this.adt) == 1) {
        k = 1;
      }
      if (k == 0) {
        break label161;
      }
      k = Math.abs(paramInt);
      if (paramInt >= 0) {
        break label135;
      }
      i = -Math.min(j + a.i(this.bdE) - i, k);
    }
    for (;;)
    {
      AppMethodBeat.o(54846);
      return i;
      i = this.bdK.getHeight();
      break;
      label127:
      j = this.mHeight;
      break label61;
      label135:
      i = paramInt;
      if (a.i(this.bdE) + paramInt > 0)
      {
        i = -a.i(this.bdE);
        continue;
        label161:
        if (paramInt > 0)
        {
          i = Math.min(j - a.i(this.bdE) - i, paramInt);
        }
        else
        {
          i = paramInt;
          if (a.i(this.bdE) + paramInt < 0) {
            i = -a.i(this.bdE);
          }
        }
      }
    }
  }
  
  private void im()
  {
    AppMethodBeat.i(54836);
    if (this.bdD == null) {
      this.bdD = new b((byte)0);
    }
    AppMethodBeat.o(54836);
  }
  
  private View ip()
  {
    AppMethodBeat.i(156768);
    View localView = getChildAt(0);
    AppMethodBeat.o(156768);
    return localView;
  }
  
  private int it()
  {
    AppMethodBeat.i(54862);
    View localView = bi(0, getChildCount());
    if (localView == null)
    {
      AppMethodBeat.o(54862);
      return -1;
    }
    int i = bv(localView);
    AppMethodBeat.o(54862);
    return i;
  }
  
  private int iv()
  {
    AppMethodBeat.i(54863);
    View localView = bi(getChildCount() - 1, -1);
    if (localView == null)
    {
      AppMethodBeat.o(54863);
      return -1;
    }
    int i = bv(localView);
    AppMethodBeat.o(54863);
    return i;
  }
  
  private int j(RecyclerView.s params)
  {
    AppMethodBeat.i(54855);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(54855);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = eI(i);
    View localView2 = eJ(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(54855);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(54855);
      throw params;
    }
    int k = bv(localView1);
    int j = bv(localView2);
    i = Math.abs(this.agm.bi(localView2) - this.agm.bh(localView1));
    k = this.bdt.bda[k];
    if ((k == 0) || (k == -1))
    {
      AppMethodBeat.o(54855);
      return 0;
    }
    j = this.bdt.bda[j];
    i = Math.round(i / (j - k + 1) * k + (this.agm.iI() - this.agm.bh(localView1)));
    AppMethodBeat.o(54855);
    return i;
  }
  
  private int k(RecyclerView.s params)
  {
    AppMethodBeat.i(54852);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(54852);
      return 0;
    }
    int i = params.getItemCount();
    rw();
    View localView1 = eI(i);
    View localView2 = eJ(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(54852);
      return 0;
    }
    i = this.agm.bi(localView2);
    int j = this.agm.bh(localView1);
    i = Math.min(this.agm.iK(), i - j);
    AppMethodBeat.o(54852);
    return i;
  }
  
  private int l(RecyclerView.s params)
  {
    AppMethodBeat.i(54858);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(54858);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = eI(i);
    View localView2 = eJ(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(54858);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.bdt.bda == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(54858);
      throw params;
    }
    i = it();
    int j = iv();
    i = (int)(Math.abs(this.agm.bi(localView2) - this.agm.bh(localView1)) / (j - i + 1) * params.getItemCount());
    AppMethodBeat.o(54858);
    return i;
  }
  
  private static boolean l(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54860);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((paramInt3 > 0) && (paramInt1 != paramInt3))
    {
      AppMethodBeat.o(54860);
      return false;
    }
    switch (i)
    {
    default: 
      AppMethodBeat.o(54860);
      return false;
    case 0: 
      AppMethodBeat.o(54860);
      return true;
    case -2147483648: 
      if (paramInt2 >= paramInt1)
      {
        AppMethodBeat.o(54860);
        return true;
      }
      AppMethodBeat.o(54860);
      return false;
    }
    if (paramInt2 == paramInt1)
    {
      AppMethodBeat.o(54860);
      return true;
    }
    AppMethodBeat.o(54860);
    return false;
  }
  
  private void rv()
  {
    AppMethodBeat.i(54834);
    int i;
    b localb;
    if (rl())
    {
      i = this.ajw;
      localb = this.bdD;
      if ((i != 0) && (i != -2147483648)) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      localb.afY = bool;
      AppMethodBeat.o(54834);
      return;
      i = this.ajv;
      break;
    }
  }
  
  private void rw()
  {
    AppMethodBeat.i(54835);
    if (this.agm != null)
    {
      AppMethodBeat.o(54835);
      return;
    }
    if (rl())
    {
      if (this.bdg != 0)
      {
        this.agm = aj.e(this);
        this.bdF = aj.d(this);
        AppMethodBeat.o(54835);
      }
    }
    else if (this.bdg == 0)
    {
      this.agm = aj.e(this);
      this.bdF = aj.d(this);
      AppMethodBeat.o(54835);
      return;
    }
    this.agm = aj.d(this);
    this.bdF = aj.e(this);
    AppMethodBeat.o(54835);
  }
  
  private View y(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54822);
    rw();
    im();
    int j = this.agm.iI();
    int k = this.agm.iJ();
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
        break label165;
      }
      localView = getChildAt(paramInt1);
      int m = bv(localView);
      if ((m < 0) || (m >= paramInt3)) {
        break label188;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).ajy.isRemoved()) {
        break label116;
      }
      if (localObject2 != null) {
        break label188;
      }
      localObject2 = localView;
    }
    label165:
    label188:
    for (;;)
    {
      paramInt1 += i;
      break label46;
      i = -1;
      break;
      label116:
      if ((this.agm.bh(localView) < j) || (this.agm.bi(localView) > k))
      {
        if (localObject1 == null) {
          localObject1 = localView;
        }
      }
      else
      {
        AppMethodBeat.o(54822);
        return localView;
        if (localObject1 != null)
        {
          AppMethodBeat.o(54822);
          return localObject1;
        }
        AppMethodBeat.o(54822);
        return localObject2;
      }
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(54843);
    if (!rl())
    {
      paramInt = d(paramInt, paramo, params);
      this.bdJ.clear();
      AppMethodBeat.o(54843);
      return paramInt;
    }
    paramInt = eK(paramInt);
    paramo = this.bdE;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bdF.bN(-paramInt);
    AppMethodBeat.o(54843);
    return paramInt;
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(54806);
    paramContext = new FlexboxLayoutManager.LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(54806);
    return paramContext;
  }
  
  public final void a(int paramInt, View paramView)
  {
    AppMethodBeat.i(54803);
    this.bdJ.put(paramInt, paramView);
    AppMethodBeat.o(54803);
  }
  
  public final void a(RecyclerView.s params)
  {
    AppMethodBeat.i(54819);
    super.a(params);
    this.bdG = null;
    this.ags = -1;
    this.agt = -2147483648;
    this.bdL = -1;
    a.b(this.bdE);
    this.bdJ.clear();
    AppMethodBeat.o(54819);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(54838);
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.ajQ = paramInt;
    a(paramRecyclerView);
    AppMethodBeat.o(54838);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54814);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    eH(Math.min(paramInt1, paramInt2));
    AppMethodBeat.o(54814);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(54811);
    super.a(paramRecyclerView, paramInt1, paramInt2, paramObject);
    eH(paramInt1);
    AppMethodBeat.o(54811);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    AppMethodBeat.i(54840);
    super.a(paramRecyclerView, paramo);
    if (this.agu)
    {
      d(paramo);
      paramo.clear();
    }
    AppMethodBeat.o(54840);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(54795);
    g(paramView, bdB);
    if (rl())
    {
      paramInt1 = bF(paramView) + bG(paramView);
      paramb.bcO += paramInt1;
      paramb.bcP = (paramInt1 + paramb.bcP);
      AppMethodBeat.o(54795);
      return;
    }
    paramInt1 = bD(paramView) + bE(paramView);
    paramb.bcO += paramInt1;
    paramb.bcP = (paramInt1 + paramb.bcP);
    AppMethodBeat.o(54795);
  }
  
  public final void a(b paramb) {}
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FlexboxLayoutManager.LayoutParams;
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(54844);
    if (rl())
    {
      paramInt = d(paramInt, paramo, params);
      this.bdJ.clear();
      AppMethodBeat.o(54844);
      return paramInt;
    }
    paramInt = eK(paramInt);
    paramo = this.bdE;
    a.d(paramo, a.i(paramo) + paramInt);
    this.bdF.bN(-paramInt);
    AppMethodBeat.o(54844);
    return paramInt;
  }
  
  public final PointF bI(int paramInt)
  {
    AppMethodBeat.i(54804);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(54804);
      return null;
    }
    if (paramInt < bv(getChildAt(0))) {}
    for (paramInt = -1; rl(); paramInt = 1)
    {
      localPointF = new PointF(0.0F, paramInt);
      AppMethodBeat.o(54804);
      return localPointF;
    }
    PointF localPointF = new PointF(paramInt, 0.0F);
    AppMethodBeat.o(54804);
    return localPointF;
  }
  
  public final void bJ(int paramInt)
  {
    AppMethodBeat.i(54837);
    this.ags = paramInt;
    this.agt = -2147483648;
    if (this.bdG != null) {
      FlexboxLayoutManager.SavedState.a(this.bdG);
    }
    requestLayout();
    AppMethodBeat.o(54837);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(54816);
    this.ahO = paramo;
    this.aiK = params;
    int k = params.getItemCount();
    if ((k == 0) && (params.akg))
    {
      AppMethodBeat.o(54816);
      return;
    }
    int i = t.T(this.adt);
    a locala;
    Object localObject;
    boolean bool;
    switch (this.bdf)
    {
    default: 
      this.mIsRtl = false;
      this.bdC = false;
      rw();
      im();
      this.bdt.eB(k);
      this.bdt.eA(k);
      this.bdt.eC(k);
      this.bdD.bdQ = false;
      if ((this.bdG != null) && (FlexboxLayoutManager.SavedState.c(this.bdG, k))) {
        this.ags = FlexboxLayoutManager.SavedState.b(this.bdG);
      }
      if ((a.a(this.bdE)) && (this.ags == -1) && (this.bdG == null)) {
        break label623;
      }
      a.b(this.bdE);
      locala = this.bdE;
      localObject = this.bdG;
      if ((!$assertionsDisabled) && (this.bdt.bda == null))
      {
        paramo = new AssertionError();
        AppMethodBeat.o(54816);
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
        if (this.bdg != 2) {
          break label283;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bdC = bool;
        break;
        bool = false;
        break label251;
      }
    case 1: 
      if (i != 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bdg != 2) {
          break label329;
        }
      }
      for (bool = true;; bool = false)
      {
        this.bdC = bool;
        break;
        bool = false;
        break label297;
      }
    case 2: 
      if (i == 1)
      {
        bool = true;
        this.mIsRtl = bool;
        if (this.bdg == 2) {
          if (this.mIsRtl) {
            break label387;
          }
        }
      }
      label387:
      for (bool = true;; bool = false)
      {
        this.mIsRtl = bool;
        this.bdC = false;
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
        if (this.bdg == 2) {
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
        this.bdC = true;
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
    if ((params.akg) || (this.ags == -1))
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
        localObject = eJ(params.getItemCount());
        if (localObject == null) {
          break label1266;
        }
        a.a(locala, (View)localObject);
        if ((!params.akg) && (ih()))
        {
          if ((this.agm.bh((View)localObject) < this.agm.iJ()) && (this.agm.bi((View)localObject) >= this.agm.iI())) {
            break label1250;
          }
          i = 1;
          if (i != 0)
          {
            if (!a.d(locala)) {
              break label1255;
            }
            i = this.agm.iJ();
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
      a.c(this.bdE);
      b(paramo);
      if (!a.d(this.bdE)) {
        break label1271;
      }
      b(this.bdE, false, true);
      m = View.MeasureSpec.makeMeasureSpec(this.mWidth, this.ajv);
      n = View.MeasureSpec.makeMeasureSpec(this.mHeight, this.ajw);
      i1 = this.mWidth;
      i2 = this.mHeight;
      if (!rl()) {
        break label1301;
      }
      if ((this.bdH == -2147483648) || (this.bdH == i1)) {
        break label1284;
      }
      i = 1;
      label713:
      if (!this.bdD.afY) {
        break label1289;
      }
    }
    label1284:
    label1289:
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = this.bdD.afS)
    {
      this.bdH = i1;
      this.bdI = i2;
      if ((this.bdL != -1) || ((this.ags == -1) && (i == 0))) {
        break label1607;
      }
      if (a.d(this.bdE)) {
        break label1474;
      }
      this.bdd.clear();
      if (($assertionsDisabled) || (this.bdt.bda != null)) {
        break label1366;
      }
      paramo = new AssertionError();
      AppMethodBeat.o(54816);
      throw paramo;
      if ((this.ags < 0) || (this.ags >= params.getItemCount()))
      {
        this.ags = -1;
        this.agt = -2147483648;
        i = 0;
        break;
      }
      a.b(locala, this.ags);
      a.a(locala, this.bdt.bda[a.e(locala)]);
      if ((this.bdG != null) && (FlexboxLayoutManager.SavedState.c(this.bdG, params.getItemCount())))
      {
        i = this.agm.iI();
        a.c(locala, FlexboxLayoutManager.SavedState.c((FlexboxLayoutManager.SavedState)localObject) + i);
        a.h(locala);
        a.a(locala, -1);
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.agt == -2147483648)
        {
          localObject = bH(this.ags);
          if (localObject != null)
          {
            if (this.agm.bl((View)localObject) > this.agm.iK())
            {
              a.g(locala);
            }
            else if (this.agm.bh((View)localObject) - this.agm.iI() < 0)
            {
              a.c(locala, this.agm.iI());
              a.a(locala, false);
            }
            else if (this.agm.iJ() - this.agm.bi((View)localObject) < 0)
            {
              a.c(locala, this.agm.iJ());
              a.a(locala, true);
            }
            else
            {
              if (a.d(locala)) {}
              for (i = this.agm.bi((View)localObject) + this.agm.iH();; i = this.agm.bh((View)localObject))
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
              i = bv(getChildAt(0));
              if (this.ags >= i) {
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
        else if ((!rl()) && (this.mIsRtl))
        {
          a.c(locala, this.agt - this.agm.getEndPadding());
        }
        else
        {
          a.c(locala, this.agm.iI() + this.agt);
        }
      }
      label1237:
      localObject = eI(params.getItemCount());
      break label497;
      label1250:
      i = 0;
      break label563;
      label1255:
      i = this.agm.iI();
      break label583;
      label1266:
      i = 0;
      break label592;
      label1271:
      a(this.bdE, false, true);
      break label648;
      i = 0;
      break label713;
    }
    label1301:
    if ((this.bdI != -2147483648) && (this.bdI != i2))
    {
      i = 1;
      label1321:
      if (!this.bdD.afY) {
        break label1354;
      }
    }
    label1354:
    for (j = this.mContext.getResources().getDisplayMetrics().widthPixels;; j = this.bdD.afS)
    {
      break;
      i = 0;
      break label1321;
    }
    label1366:
    this.bdu.reset();
    if (rl())
    {
      this.bdt.b(this.bdu, m, n, j, a.e(this.bdE), this.bdd);
      this.bdd = this.bdu.bdd;
      this.bdt.bd(m, n);
      this.bdt.rt();
      a.a(this.bdE, this.bdt.bda[a.e(this.bdE)]);
      this.bdD.bdM = a.f(this.bdE);
      label1474:
      if (!a.d(this.bdE)) {
        break label1866;
      }
      a(paramo, params, this.bdD);
      j = this.bdD.Fb;
      a(this.bdE, true, false);
      a(paramo, params, this.bdD);
      i = this.bdD.Fb;
    }
    for (;;)
    {
      if (getChildCount() > 0)
      {
        if (a.d(this.bdE))
        {
          b(a(i, paramo, params, true) + j, paramo, params, false);
          AppMethodBeat.o(54816);
          return;
          this.bdt.d(this.bdu, m, n, j, a.e(this.bdE), this.bdd);
          break;
          label1607:
          if (this.bdL != -1)
          {
            i = Math.min(this.bdL, a.e(this.bdE));
            label1630:
            this.bdu.reset();
            if (!rl()) {
              break label1776;
            }
            if (this.bdd.size() <= 0) {
              break label1742;
            }
            this.bdt.d(this.bdd, i);
            this.bdt.a(this.bdu, m, n, j, i, a.e(this.bdE), this.bdd);
          }
          for (;;)
          {
            this.bdd = this.bdu.bdd;
            this.bdt.w(m, n, i);
            this.bdt.ez(i);
            break;
            i = a.e(this.bdE);
            break label1630;
            label1742:
            this.bdt.eC(k);
            this.bdt.a(this.bdu, m, n, j, 0, this.bdd);
            continue;
            label1776:
            if (this.bdd.size() > 0)
            {
              this.bdt.d(this.bdd, i);
              this.bdt.a(this.bdu, n, m, j, i, a.e(this.bdE), this.bdd);
            }
            else
            {
              this.bdt.eC(k);
              this.bdt.c(this.bdu, m, n, j, 0, this.bdd);
            }
          }
          label1866:
          a(paramo, params, this.bdD);
          i = this.bdD.Fb;
          b(this.bdE, true, false);
          a(paramo, params, this.bdD);
          j = this.bdD.Fb;
          continue;
        }
        a(i + b(j, paramo, params, true), paramo, params, false);
      }
    }
    AppMethodBeat.o(54816);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54810);
    super.c(paramRecyclerView, paramInt1, paramInt2);
    eH(paramInt1);
    AppMethodBeat.o(54810);
  }
  
  public final int cc(View paramView)
  {
    AppMethodBeat.i(54794);
    if (rl())
    {
      i = bD(paramView);
      j = bE(paramView);
      AppMethodBeat.o(54794);
      return i + j;
    }
    int i = bF(paramView);
    int j = bG(paramView);
    AppMethodBeat.o(54794);
    return i + j;
  }
  
  public final int d(RecyclerView.s params)
  {
    AppMethodBeat.i(54853);
    j(params);
    int i = j(params);
    AppMethodBeat.o(54853);
    return i;
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54813);
    super.d(paramRecyclerView, paramInt1, paramInt2);
    eH(paramInt1);
    AppMethodBeat.o(54813);
  }
  
  public final int e(RecyclerView.s params)
  {
    AppMethodBeat.i(54854);
    int i = j(params);
    AppMethodBeat.o(54854);
    return i;
  }
  
  public final View ev(int paramInt)
  {
    AppMethodBeat.i(54797);
    View localView = (View)this.bdJ.get(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(54797);
      return localView;
    }
    localView = this.ahO.cb(paramInt);
    AppMethodBeat.o(54797);
    return localView;
  }
  
  public final View ew(int paramInt)
  {
    AppMethodBeat.i(54798);
    View localView = ev(paramInt);
    AppMethodBeat.o(54798);
    return localView;
  }
  
  public final int f(RecyclerView.s params)
  {
    AppMethodBeat.i(54850);
    int i = k(params);
    AppMethodBeat.o(54850);
    return i;
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(54839);
    super.f(paramRecyclerView);
    this.bdK = ((View)paramRecyclerView.getParent());
    AppMethodBeat.o(54839);
  }
  
  public final int g(RecyclerView.s params)
  {
    AppMethodBeat.i(54851);
    int i = k(params);
    AppMethodBeat.o(54851);
    return i;
  }
  
  public final void g(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54812);
    super.g(paramRecyclerView, paramInt1, paramInt2);
    eH(paramInt1);
    AppMethodBeat.o(54812);
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.bdi;
  }
  
  public int getFlexDirection()
  {
    return this.bdf;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(54796);
    int i = this.aiK.getItemCount();
    AppMethodBeat.o(54796);
    return i;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bdd;
  }
  
  public int getFlexWrap()
  {
    return this.bdg;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(54801);
    if (this.bdd.size() == 0)
    {
      AppMethodBeat.o(54801);
      return 0;
    }
    int j = -2147483648;
    int k = this.bdd.size();
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, ((b)this.bdd.get(i)).bcO);
      i += 1;
    }
    AppMethodBeat.o(54801);
    return j;
  }
  
  public int getMaxLine()
  {
    return this.bdk;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(54802);
    int k = this.bdd.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((b)this.bdd.get(i)).bcQ;
      i += 1;
    }
    AppMethodBeat.o(54802);
    return j;
  }
  
  public final int h(RecyclerView.s params)
  {
    AppMethodBeat.i(54856);
    int i = l(params);
    AppMethodBeat.o(54856);
    return i;
  }
  
  public final int i(RecyclerView.s params)
  {
    AppMethodBeat.i(54857);
    int i = l(params);
    AppMethodBeat.o(54857);
    return i;
  }
  
  public final RecyclerView.LayoutParams ic()
  {
    AppMethodBeat.i(54805);
    FlexboxLayoutManager.LayoutParams localLayoutParams = new FlexboxLayoutManager.LayoutParams();
    AppMethodBeat.o(54805);
    return localLayoutParams;
  }
  
  public final boolean ij()
  {
    AppMethodBeat.i(54841);
    if ((!rl()) || (this.mWidth > this.bdK.getWidth()))
    {
      AppMethodBeat.o(54841);
      return true;
    }
    AppMethodBeat.o(54841);
    return false;
  }
  
  public final boolean ik()
  {
    AppMethodBeat.i(54842);
    if ((rl()) || (this.mHeight > this.bdK.getHeight()))
    {
      AppMethodBeat.o(54842);
      return true;
    }
    AppMethodBeat.o(54842);
    return false;
  }
  
  public final void jA()
  {
    AppMethodBeat.i(54807);
    removeAllViews();
    AppMethodBeat.o(54807);
  }
  
  public final int n(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54793);
    if (rl())
    {
      paramInt1 = bF(paramView);
      paramInt2 = bG(paramView);
      AppMethodBeat.o(54793);
      return paramInt1 + paramInt2;
    }
    paramInt1 = bD(paramView);
    paramInt2 = bE(paramView);
    AppMethodBeat.o(54793);
    return paramInt1 + paramInt2;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(54809);
    if ((paramParcelable instanceof FlexboxLayoutManager.SavedState))
    {
      this.bdG = ((FlexboxLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(54809);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(54808);
    if (this.bdG != null)
    {
      localSavedState = new FlexboxLayoutManager.SavedState(this.bdG, (byte)0);
      AppMethodBeat.o(54808);
      return localSavedState;
    }
    FlexboxLayoutManager.SavedState localSavedState = new FlexboxLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FlexboxLayoutManager.SavedState.a(localSavedState, bv(localView));
      FlexboxLayoutManager.SavedState.b(localSavedState, this.agm.bh(localView) - this.agm.iI());
    }
    for (;;)
    {
      AppMethodBeat.o(54808);
      return localSavedState;
      FlexboxLayoutManager.SavedState.a(localSavedState);
    }
  }
  
  public final boolean rl()
  {
    return (this.bdf == 0) || (this.bdf == 1);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bdd = paramList;
  }
  
  public final int u(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54799);
    paramInt1 = c(this.mWidth, this.ajv, paramInt2, paramInt3, ij());
    AppMethodBeat.o(54799);
    return paramInt1;
  }
  
  public final int v(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54800);
    paramInt1 = c(this.mHeight, this.ajw, paramInt2, paramInt3, ik());
    AppMethodBeat.o(54800);
    return paramInt1;
  }
  
  final class a
  {
    private boolean agA;
    private boolean agB;
    private int agz;
    private int bdM;
    private int bdN;
    private boolean bdO;
    private int mPosition;
    
    static
    {
      AppMethodBeat.i(54782);
      if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(54782);
        return;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(54778);
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bdM + ", mCoordinate=" + this.agz + ", mPerpendicularCoordinate=" + this.bdN + ", mLayoutFromEnd=" + this.agA + ", mValid=" + this.agB + ", mAssignedFromSavedState=" + this.bdO + '}';
      AppMethodBeat.o(54778);
      return str;
    }
  }
  
  static final class b
  {
    int Fb;
    int afS;
    int afU = 1;
    boolean afY;
    int agE;
    int agH;
    int bdM;
    boolean bdQ;
    int mLayoutDirection = 1;
    int mPosition;
    
    public final String toString()
    {
      AppMethodBeat.i(54787);
      String str = "LayoutState{mAvailable=" + this.afS + ", mFlexLinePosition=" + this.bdM + ", mPosition=" + this.mPosition + ", mOffset=" + this.Fb + ", mScrollingOffset=" + this.agE + ", mLastScrollDelta=" + this.agH + ", mItemDirection=" + this.afU + ", mLayoutDirection=" + this.mLayoutDirection + '}';
      AppMethodBeat.o(54787);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager
 * JD-Core Version:    0.7.0.1
 */