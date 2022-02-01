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
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b, a
{
  private static final Rect dna;
  private int bXE;
  private int bXF;
  private boolean bXG;
  private s bXy;
  private RecyclerView.n bYt;
  private RecyclerView.s bZn;
  private List<b> dmC;
  private int dmE;
  private int dmF;
  private int dmG;
  private int dmH;
  private int dmJ;
  private final c dmS;
  private c.a dmT;
  private boolean dnb;
  private b dnc;
  private a dnd;
  private s dne;
  private SavedState dnf;
  private int dng;
  private int dnh;
  private SparseArray<View> dni;
  private View dnj;
  private int dnk;
  private final Context mContext;
  private boolean uK;
  
  static
  {
    AppMethodBeat.i(62405);
    if (!FlexboxLayoutManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      dna = new Rect();
      AppMethodBeat.o(62405);
      return;
    }
  }
  
  public FlexboxLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62330);
    this.dmJ = -1;
    this.dmC = new ArrayList();
    this.dmS = new c(this);
    this.dnd = new a((byte)0);
    this.bXE = -1;
    this.bXF = -2147483648;
    this.dng = -2147483648;
    this.dnh = -2147483648;
    this.dni = new SparseArray();
    this.dnk = -1;
    this.dmT = new c.a();
    paramAttributeSet = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    switch (paramAttributeSet.orientation)
    {
    }
    for (;;)
    {
      if (this.dmF != 1)
      {
        if (this.dmF == 0)
        {
          removeAllViews();
          Vq();
        }
        this.dmF = 1;
        this.bXy = null;
        this.dne = null;
        requestLayout();
      }
      if (this.dmH != 4)
      {
        removeAllViews();
        Vq();
        this.dmH = 4;
        requestLayout();
      }
      this.mContext = paramContext;
      AppMethodBeat.o(62330);
      return;
      if (paramAttributeSet.agn)
      {
        setFlexDirection(1);
      }
      else
      {
        setFlexDirection(0);
        continue;
        if (paramAttributeSet.agn) {
          setFlexDirection(3);
        } else {
          setFlexDirection(2);
        }
      }
    }
  }
  
  private void Jo()
  {
    AppMethodBeat.i(62375);
    if (this.dnc == null) {
      this.dnc = new b((byte)0);
    }
    AppMethodBeat.o(62375);
  }
  
  private int Ju()
  {
    AppMethodBeat.i(62402);
    View localView = cs(0, getChildCount());
    if (localView == null)
    {
      AppMethodBeat.o(62402);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(62402);
    return i;
  }
  
  private int Jw()
  {
    AppMethodBeat.i(62403);
    View localView = cs(getChildCount() - 1, -1);
    if (localView == null)
    {
      AppMethodBeat.o(62403);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(62403);
    return i;
  }
  
  private View M(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62361);
    Vp();
    Jo();
    int j = this.bXy.JE();
    int k = this.bXy.JF();
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
        break label169;
      }
      localView = getChildAt(paramInt1);
      if (localView == null) {
        break label190;
      }
      int m = getPosition(localView);
      if ((m < 0) || (m >= paramInt3)) {
        break label190;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).bXh.isRemoved()) {
        break label121;
      }
      if (localObject2 != null) {
        break label190;
      }
      localObject2 = localView;
    }
    label169:
    label190:
    for (;;)
    {
      paramInt1 += i;
      break label45;
      i = -1;
      break;
      label121:
      if ((this.bXy.bs(localView) < j) || (this.bXy.bt(localView) > k))
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
  
  private boolean N(View paramView, int paramInt)
  {
    AppMethodBeat.i(62366);
    if ((!Ve()) && (this.uK))
    {
      if (this.bXy.getEnd() - this.bXy.bs(paramView) <= paramInt)
      {
        AppMethodBeat.o(62366);
        return true;
      }
      AppMethodBeat.o(62366);
      return false;
    }
    if (this.bXy.bt(paramView) <= paramInt)
    {
      AppMethodBeat.o(62366);
      return true;
    }
    AppMethodBeat.o(62366);
    return false;
  }
  
  private boolean O(View paramView, int paramInt)
  {
    AppMethodBeat.i(62368);
    if ((!Ve()) && (this.uK))
    {
      if (this.bXy.bt(paramView) <= paramInt)
      {
        AppMethodBeat.o(62368);
        return true;
      }
      AppMethodBeat.o(62368);
      return false;
    }
    if (this.bXy.bs(paramView) >= this.bXy.getEnd() - paramInt)
    {
      AppMethodBeat.o(62368);
      return true;
    }
    AppMethodBeat.o(62368);
    return false;
  }
  
  private void Vo()
  {
    AppMethodBeat.i(62373);
    int i;
    b localb;
    if (Ve())
    {
      i = getHeightMode();
      localb = this.dnc;
      if ((i != 0) && (i != -2147483648)) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      localb.bXw = bool;
      AppMethodBeat.o(62373);
      return;
      i = getWidthMode();
      break;
    }
  }
  
  private void Vp()
  {
    AppMethodBeat.i(62374);
    if (this.bXy != null)
    {
      AppMethodBeat.o(62374);
      return;
    }
    if (Ve())
    {
      if (this.dmF != 0)
      {
        this.bXy = s.e(this);
        this.dne = s.d(this);
        AppMethodBeat.o(62374);
      }
    }
    else if (this.dmF == 0)
    {
      this.bXy = s.e(this);
      this.dne = s.d(this);
      AppMethodBeat.o(62374);
      return;
    }
    this.bXy = s.d(this);
    this.dne = s.e(this);
    AppMethodBeat.o(62374);
  }
  
  private void Vq()
  {
    AppMethodBeat.i(62400);
    this.dmC.clear();
    a.b(this.dnd);
    a.k(this.dnd);
    AppMethodBeat.o(62400);
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(208910);
    int i;
    if ((!Ve()) && (this.uK))
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      i = paramInt - this.bXy.JE();
      if (i <= 0) {
        break label101;
      }
      i = b(i, paramn, params);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramInt = this.bXy.JF() - (paramInt + i);
        if (paramInt > 0)
        {
          this.bXy.fQ(paramInt);
          AppMethodBeat.o(208910);
          return i + paramInt;
          i = 0;
          break;
          label101:
          AppMethodBeat.o(208910);
          return 0;
          label109:
          i = this.bXy.JF() - paramInt;
          if (i > 0)
          {
            i = -b(-i, paramn, params);
          }
          else
          {
            AppMethodBeat.o(208910);
            return 0;
          }
        }
      }
    }
    AppMethodBeat.o(208910);
    return i;
  }
  
  private int a(RecyclerView.n paramn, RecyclerView.s params, b paramb)
  {
    AppMethodBeat.i(208926);
    if (paramb.bXP != -2147483648)
    {
      if (paramb.bXq < 0) {
        b.a(paramb, paramb.bXq);
      }
      a(paramn, paramb);
    }
    int i2 = paramb.bXq;
    int j = paramb.bXq;
    boolean bool = Ve();
    int k = 0;
    Object localObject;
    int i;
    int n;
    int i3;
    int m;
    if ((j > 0) || (this.dnc.bXw))
    {
      localObject = this.dmC;
      if ((paramb.mPosition >= 0) && (paramb.mPosition < params.getItemCount()) && (paramb.dnl >= 0) && (paramb.dnl < ((List)localObject).size())) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = (b)this.dmC.get(paramb.dnl);
          paramb.mPosition = ((b)localObject).dmu;
          if (Ve())
          {
            if ((!$assertionsDisabled) && (this.dmS.dmA == null))
            {
              paramn = new AssertionError();
              AppMethodBeat.o(208926);
              throw paramn;
              i = 0;
              continue;
            }
            i = getPaddingLeft();
            n = getPaddingRight();
            i3 = getWidth();
            m = paramb.Sc;
            if (paramb.mLayoutDirection != -1) {
              break label1166;
            }
            m -= ((b)localObject).dmn;
          }
        }
      }
    }
    label397:
    label1166:
    for (;;)
    {
      int i1 = paramb.mPosition;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      label345:
      float f4;
      View localView;
      label443:
      int i4;
      switch (this.dmG)
      {
      default: 
        paramn = new IllegalStateException("Invalid justifyContent is set: " + this.dmG);
        AppMethodBeat.o(208926);
        throw paramn;
      case 0: 
        f1 = i;
        f2 = i3 - n;
        f4 = a.i(this.dnd);
        f2 -= a.i(this.dnd);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i3 = ((b)localObject).cau;
        f1 -= f4;
        n = i1;
        if (n < i1 + i3)
        {
          localView = iR(n);
          if (localView == null) {
            break label1163;
          }
          if (paramb.mLayoutDirection == 1)
          {
            calculateItemDecorationsForChild(localView, dna);
            addView(localView);
            long l = this.dmS.dmA[n];
            i4 = c.cL(l);
            int i5 = c.cM(l);
            LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (shouldMeasureChild(localView, i4, i5, localLayoutParams)) {
              localView.measure(i4, i5);
            }
            f1 += localLayoutParams.leftMargin + getLeftDecorationWidth(localView);
            f2 -= localLayoutParams.rightMargin + getRightDecorationWidth(localView);
            i4 = m + getTopDecorationHeight(localView);
            if (!this.uK) {
              break label940;
            }
            this.dmS.a(localView, (b)localObject, Math.round(f2) - localView.getMeasuredWidth(), i4, Math.round(f2), localView.getMeasuredHeight() + i4);
            label594:
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
        break label397;
        f1 = i3 - ((b)localObject).dml + n;
        f2 = ((b)localObject).dml - i;
        break label345;
        f1 = i + (i3 - ((b)localObject).dml) / 2.0F;
        f2 = i3 - n - (i3 - ((b)localObject).dml) / 2.0F;
        break label345;
        f3 = f1;
        if (((b)localObject).cau != 0) {
          f3 = (i3 - ((b)localObject).dml) / ((b)localObject).cau;
        }
        f1 = i + f3 / 2.0F;
        f2 = i3 - n - f3 / 2.0F;
        break label345;
        f2 = i;
        if (((b)localObject).cau != 1) {}
        for (f1 = ((b)localObject).cau - 1;; f1 = 1.0F)
        {
          f3 = (i3 - ((b)localObject).dml) / f1;
          f4 = i3 - n;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (((b)localObject).cau != 0) {
          f3 = (i3 - ((b)localObject).dml) / (((b)localObject).cau + 1);
        }
        f1 = i + f3;
        f2 = i3 - n - f3;
        break label345;
        calculateItemDecorationsForChild(localView, dna);
        addView(localView, i);
        i += 1;
        break label443;
        label940:
        this.dmS.a(localView, (b)localObject, Math.round(f1), i4, Math.round(f1) + localView.getMeasuredWidth(), localView.getMeasuredHeight() + i4);
        break label594;
        b.b(paramb, this.dnc.mLayoutDirection);
        i = ((b)localObject).dmn;
        label999:
        if ((!bool) && (this.uK))
        {
          m = ((b)localObject).dmn;
          n = paramb.mLayoutDirection;
        }
        for (paramb.Sc -= m * n;; paramb.Sc = (((b)localObject).dmn * paramb.mLayoutDirection + paramb.Sc))
        {
          m = ((b)localObject).dmn;
          k = i + k;
          j -= m;
          break;
          i = a((b)localObject, paramb);
          break label999;
        }
        paramb.bXq -= k;
        if (paramb.bXP != -2147483648)
        {
          b.a(paramb, k);
          if (paramb.bXq < 0) {
            b.a(paramb, paramb.bXq);
          }
          a(paramn, paramb);
        }
        i = paramb.bXq;
        AppMethodBeat.o(208926);
        return i2 - i;
      }
    }
  }
  
  private int a(b paramb, b paramb1)
  {
    AppMethodBeat.i(62370);
    if ((!$assertionsDisabled) && (this.dmS.dmA == null))
    {
      paramb = new AssertionError();
      AppMethodBeat.o(62370);
      throw paramb;
    }
    int i = getPaddingTop();
    int m = getPaddingBottom();
    int i1 = getHeight();
    int k = paramb1.Sc;
    int j = paramb1.Sc;
    int n;
    if (paramb1.mLayoutDirection == -1)
    {
      n = paramb.dmn;
      j += paramb.dmn;
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
      switch (this.dmG)
      {
      default: 
        paramb = new IllegalStateException("Invalid justifyContent is set: " + this.dmG);
        AppMethodBeat.o(62370);
        throw paramb;
      case 0: 
        f1 = i;
        f2 = i1 - m;
        f4 = f1 - a.i(this.dnd);
        f1 = f2 - a.i(this.dnd);
        f3 = Math.max(f3, 0.0F);
        i = 0;
        i1 = paramb.cau;
        m = n;
        f2 = f4;
        if (m < n + i1)
        {
          localView = iR(m);
          if (localView == null) {
            break label982;
          }
          long l = this.dmS.dmA[m];
          i2 = c.cL(l);
          i3 = c.cM(l);
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (shouldMeasureChild(localView, i2, i3, localLayoutParams)) {
            localView.measure(i2, i3);
          }
          f2 += localLayoutParams.topMargin + getTopDecorationHeight(localView);
          f1 -= localLayoutParams.rightMargin + getBottomDecorationHeight(localView);
          if (paramb1.mLayoutDirection == 1)
          {
            calculateItemDecorationsForChild(localView, dna);
            addView(localView);
            label393:
            i2 = k + getLeftDecorationWidth(localView);
            i3 = j - getRightDecorationWidth(localView);
            if (!this.uK) {
              break label844;
            }
            if (!this.dnb) {
              break label781;
            }
            this.dmS.a(localView, paramb, this.uK, i3 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), i3, Math.round(f1));
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
      label982:
      for (;;)
      {
        m += 1;
        break label253;
        f1 = i1 - paramb.dml + m;
        f2 = paramb.dml - i;
        break;
        f1 = i + (i1 - paramb.dml) / 2.0F;
        f2 = i1 - m - (i1 - paramb.dml) / 2.0F;
        break;
        f3 = f1;
        if (paramb.cau != 0) {
          f3 = (i1 - paramb.dml) / paramb.cau;
        }
        f1 = i + f3 / 2.0F;
        f2 = i1 - m - f3 / 2.0F;
        break;
        f2 = i;
        if (paramb.cau != 1) {}
        for (f1 = paramb.cau - 1;; f1 = 1.0F)
        {
          f3 = (i1 - paramb.dml) / f1;
          f4 = i1 - m;
          f1 = f2;
          f2 = f4;
          break;
        }
        f3 = f2;
        if (paramb.cau != 0) {
          f3 = (i1 - paramb.dml) / (paramb.cau + 1);
        }
        f1 = i + f3;
        f2 = i1 - m - f3;
        break;
        calculateItemDecorationsForChild(localView, dna);
        addView(localView, i);
        i += 1;
        break label393;
        c localc = this.dmS;
        boolean bool = this.uK;
        i2 = localView.getMeasuredWidth();
        int i4 = Math.round(f2);
        int i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i3 - i2, i4, i3, localView.getMeasuredHeight() + i5);
        break label467;
        if (this.dnb)
        {
          this.dmS.a(localView, paramb, this.uK, i2, Math.round(f1) - localView.getMeasuredHeight(), i2 + localView.getMeasuredWidth(), Math.round(f1));
          break label467;
        }
        localc = this.dmS;
        bool = this.uK;
        i3 = Math.round(f2);
        i4 = localView.getMeasuredWidth();
        i5 = Math.round(f2);
        localc.a(localView, paramb, bool, i2, i3, i2 + i4, localView.getMeasuredHeight() + i5);
        break label467;
        b.b(paramb1, this.dnc.mLayoutDirection);
        i = paramb.dmn;
        AppMethodBeat.o(62370);
        return i;
      }
    }
  }
  
  private View a(View paramView, b paramb)
  {
    AppMethodBeat.i(62387);
    boolean bool = Ve();
    int j = paramb.cau;
    int i = 1;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.uK) && (!bool))
        {
          if (this.bXy.bt(paramView) >= this.bXy.bt(localView)) {
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
        if (this.bXy.bs(paramView) <= this.bXy.bs(localView)) {
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
    AppMethodBeat.i(208955);
    while (paramInt2 >= paramInt1)
    {
      removeAndRecycleViewAt(paramInt2, paramn);
      paramInt2 -= 1;
    }
    AppMethodBeat.o(208955);
  }
  
  private void a(RecyclerView.n paramn, b paramb)
  {
    AppMethodBeat.i(208930);
    if (!paramb.dnp)
    {
      AppMethodBeat.o(208930);
      return;
    }
    if (paramb.mLayoutDirection == -1)
    {
      c(paramn, paramb);
      AppMethodBeat.o(208930);
      return;
    }
    b(paramn, paramb);
    AppMethodBeat.o(208930);
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62371);
    if (paramBoolean2)
    {
      Vo();
      if ((Ve()) || (!this.uK)) {
        break label199;
      }
    }
    label199:
    for (this.dnc.bXq = (a.j(parama) - getPaddingRight());; this.dnc.bXq = (this.bXy.JF() - a.j(parama)))
    {
      this.dnc.mPosition = a.e(parama);
      this.dnc.bXs = 1;
      this.dnc.mLayoutDirection = 1;
      this.dnc.Sc = a.j(parama);
      this.dnc.bXP = -2147483648;
      this.dnc.dnl = a.f(parama);
      if ((paramBoolean1) && (this.dmC.size() > 1) && (a.f(parama) >= 0) && (a.f(parama) < this.dmC.size() - 1))
      {
        parama = (b)this.dmC.get(a.f(parama));
        b.a(this.dnc);
        b.c(this.dnc, parama.cau);
      }
      AppMethodBeat.o(62371);
      return;
      this.dnc.bXw = false;
      break;
    }
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int i = 1;
    AppMethodBeat.i(208995);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(208995);
      return 0;
    }
    Vp();
    this.dnc.dnp = true;
    int j;
    if ((!Ve()) && (this.uK))
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
      cr(i, k);
      m = this.dnc.bXP + a(paramn, params, this.dnc);
      if (m >= 0) {
        break label135;
      }
      AppMethodBeat.o(208995);
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
      this.bXy.fQ(-paramInt);
      this.dnc.bXS = paramInt;
      AppMethodBeat.o(208995);
      return paramInt;
      if (k > m) {
        paramInt = i * m;
      }
    }
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(208909);
    int i;
    if ((!Ve()) && (this.uK))
    {
      i = this.bXy.JF() - paramInt;
      if (i > 0) {
        i = b(-i, paramn, params);
      }
    }
    while (paramBoolean)
    {
      paramInt = paramInt + i - this.bXy.JE();
      if (paramInt > 0)
      {
        this.bXy.fQ(-paramInt);
        AppMethodBeat.o(208909);
        return i - paramInt;
        AppMethodBeat.o(208909);
        return 0;
        i = paramInt - this.bXy.JE();
        if (i > 0)
        {
          i = -b(i, paramn, params);
        }
        else
        {
          AppMethodBeat.o(208909);
          return 0;
        }
      }
    }
    AppMethodBeat.o(208909);
    return i;
  }
  
  private View b(View paramView, b paramb)
  {
    AppMethodBeat.i(62388);
    boolean bool = Ve();
    int i = getChildCount();
    int j = getChildCount();
    int k = paramb.cau;
    i -= 2;
    if (i > j - k - 1)
    {
      View localView = getChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8)) {
        if ((this.uK) && (!bool))
        {
          if (this.bXy.bs(paramView) <= this.bXy.bs(localView)) {
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
        if (this.bXy.bt(paramView) >= this.bXy.bt(localView)) {
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
    AppMethodBeat.i(208934);
    if (paramb.bXP < 0)
    {
      AppMethodBeat.o(208934);
      return;
    }
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      paramn = new AssertionError();
      AppMethodBeat.o(208934);
      throw paramn;
    }
    int i1 = getChildCount();
    if (i1 == 0)
    {
      AppMethodBeat.o(208934);
      return;
    }
    Object localObject1 = getChildAt(0);
    if (localObject1 == null)
    {
      AppMethodBeat.o(208934);
      return;
    }
    int k = this.dmS.dmz[getPosition(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(208934);
      return;
    }
    localObject1 = (b)this.dmC.get(k);
    int i = 0;
    for (;;)
    {
      m = j;
      if (i >= i1) {
        break label282;
      }
      View localView = getChildAt(i);
      Object localObject2 = localObject1;
      int n = j;
      m = k;
      if (localView != null)
      {
        m = j;
        if (!N(localView, paramb.bXP)) {
          break label282;
        }
        localObject2 = localObject1;
        n = j;
        m = k;
        if (((b)localObject1).jQ == getPosition(localView))
        {
          if (k >= this.dmC.size() - 1) {
            break;
          }
          m = k + paramb.mLayoutDirection;
          localObject2 = (b)this.dmC.get(m);
          n = i;
        }
      }
      i += 1;
      localObject1 = localObject2;
      j = n;
      k = m;
    }
    int m = i;
    label282:
    a(paramn, 0, m);
    AppMethodBeat.o(208934);
  }
  
  private void b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62372);
    if (paramBoolean2)
    {
      Vo();
      if ((Ve()) || (!this.uK)) {
        break label195;
      }
    }
    label195:
    for (this.dnc.bXq = (this.dnj.getWidth() - a.j(parama) - this.bXy.JE());; this.dnc.bXq = (a.j(parama) - this.bXy.JE()))
    {
      this.dnc.mPosition = a.e(parama);
      this.dnc.bXs = 1;
      this.dnc.mLayoutDirection = -1;
      this.dnc.Sc = a.j(parama);
      this.dnc.bXP = -2147483648;
      this.dnc.dnl = a.f(parama);
      if ((paramBoolean1) && (a.f(parama) > 0) && (this.dmC.size() > a.f(parama)))
      {
        parama = (b)this.dmC.get(a.f(parama));
        b.b(this.dnc);
        b.d(this.dnc, parama.cau);
      }
      AppMethodBeat.o(62372);
      return;
      this.dnc.bXw = false;
      break;
    }
  }
  
  private int c(RecyclerView.s params)
  {
    AppMethodBeat.i(209045);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(209045);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = je(i);
    View localView2 = jf(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(209045);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(209045);
      throw params;
    }
    int k = getPosition(localView1);
    int j = getPosition(localView2);
    i = Math.abs(this.bXy.bt(localView2) - this.bXy.bs(localView1));
    k = this.dmS.dmz[k];
    if ((k == 0) || (k == -1))
    {
      AppMethodBeat.o(209045);
      return 0;
    }
    j = this.dmS.dmz[j];
    i = Math.round(i / (j - k + 1) * k + (this.bXy.JE() - this.bXy.bs(localView1)));
    AppMethodBeat.o(209045);
    return i;
  }
  
  private void c(RecyclerView.n paramn, b paramb)
  {
    AppMethodBeat.i(208945);
    if (paramb.bXP < 0)
    {
      AppMethodBeat.o(208945);
      return;
    }
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      paramn = new AssertionError();
      AppMethodBeat.o(208945);
      throw paramn;
    }
    int j = getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(208945);
      return;
    }
    Object localObject1 = getChildAt(j - 1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(208945);
      return;
    }
    int k = this.dmS.dmz[getPosition(localObject1)];
    if (k == -1)
    {
      AppMethodBeat.o(208945);
      return;
    }
    int i1 = j - 1;
    localObject1 = (b)this.dmC.get(k);
    int i = i1;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break label276;
      }
      View localView = getChildAt(i);
      Object localObject2 = localObject1;
      int n = k;
      m = j;
      if (localView != null)
      {
        m = j;
        if (!O(localView, paramb.bXP)) {
          break label276;
        }
        localObject2 = localObject1;
        n = k;
        m = j;
        if (((b)localObject1).dmu == getPosition(localView))
        {
          if (k <= 0) {
            break;
          }
          n = k + paramb.mLayoutDirection;
          localObject2 = (b)this.dmC.get(n);
          m = i;
        }
      }
      i -= 1;
      localObject1 = localObject2;
      k = n;
      j = m;
    }
    int m = i;
    label276:
    a(paramn, m, i1);
    AppMethodBeat.o(208945);
  }
  
  private boolean co(View paramView)
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
  
  private void cr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62386);
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      localObject1 = new AssertionError();
      AppMethodBeat.o(62386);
      throw ((Throwable)localObject1);
    }
    this.dnc.mLayoutDirection = paramInt1;
    boolean bool = Ve();
    int j = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
    int k = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
    int i;
    if ((!bool) && (this.uK)) {
      i = 1;
    }
    Object localObject2;
    while (paramInt1 == 1)
    {
      localObject1 = getChildAt(getChildCount() - 1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(62386);
        return;
        i = 0;
      }
      else
      {
        this.dnc.Sc = this.bXy.bt((View)localObject1);
        paramInt1 = getPosition((View)localObject1);
        int m = this.dmS.dmz[paramInt1];
        localObject1 = b((View)localObject1, (b)this.dmC.get(m));
        this.dnc.bXs = 1;
        localObject2 = this.dnc;
        ((b)localObject2).mPosition = (((b)localObject2).bXs + paramInt1);
        if (this.dmS.dmz.length <= this.dnc.mPosition)
        {
          this.dnc.dnl = -1;
          if (i == 0) {
            break label480;
          }
          this.dnc.Sc = this.bXy.bs((View)localObject1);
          this.dnc.bXP = (-this.bXy.bs((View)localObject1) + this.bXy.JE());
          this.dnc.bXP = Math.max(this.dnc.bXP, 0);
          label299:
          if (((this.dnc.dnl == -1) || (this.dnc.dnl > this.dmC.size() - 1)) && (this.dnc.mPosition <= getFlexItemCount()))
          {
            paramInt1 = paramInt2 - this.dnc.bXP;
            this.dmT.reset();
            if (paramInt1 > 0)
            {
              if (!bool) {
                break label523;
              }
              this.dmS.a(this.dmT, j, k, paramInt1, this.dnc.mPosition, this.dmC);
            }
          }
        }
        for (;;)
        {
          this.dmS.K(j, k, this.dnc.mPosition);
          this.dmS.iV(this.dnc.mPosition);
          localObject1 = this.dnc;
          ((b)localObject1).bXq = (paramInt2 - ((b)localObject1).bXP);
          AppMethodBeat.o(62386);
          return;
          this.dnc.dnl = this.dmS.dmz[this.dnc.mPosition];
          break;
          label480:
          this.dnc.Sc = this.bXy.bt((View)localObject1);
          this.dnc.bXP = (this.bXy.bt((View)localObject1) - this.bXy.JF());
          break label299;
          label523:
          this.dmS.c(this.dmT, j, k, paramInt1, this.dnc.mPosition, this.dmC);
        }
      }
    }
    Object localObject1 = getChildAt(0);
    if (localObject1 == null)
    {
      AppMethodBeat.o(62386);
      return;
    }
    this.dnc.Sc = this.bXy.bs((View)localObject1);
    j = getPosition((View)localObject1);
    paramInt1 = this.dmS.dmz[j];
    localObject1 = a((View)localObject1, (b)this.dmC.get(paramInt1));
    this.dnc.bXs = 1;
    paramInt1 = this.dmS.dmz[j];
    if (paramInt1 == -1) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        localObject2 = (b)this.dmC.get(paramInt1 - 1);
        this.dnc.mPosition = (j - ((b)localObject2).cau);
        label690:
        localObject2 = this.dnc;
        if (paramInt1 <= 0) {
          break label786;
        }
        paramInt1 -= 1;
      }
      for (;;)
      {
        ((b)localObject2).dnl = paramInt1;
        if (i == 0) {
          break label791;
        }
        this.dnc.Sc = this.bXy.bt((View)localObject1);
        this.dnc.bXP = (this.bXy.bt((View)localObject1) - this.bXy.JF());
        this.dnc.bXP = Math.max(this.dnc.bXP, 0);
        break;
        this.dnc.mPosition = -1;
        break label690;
        label786:
        paramInt1 = 0;
      }
      label791:
      this.dnc.Sc = this.bXy.bs((View)localObject1);
      this.dnc.bXP = (-this.bXy.bs((View)localObject1) + this.bXy.JE());
      break;
    }
  }
  
  private View cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62404);
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (co(localView))
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
  
  private int d(RecyclerView.s params)
  {
    AppMethodBeat.i(209034);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(209034);
      return 0;
    }
    int i = params.getItemCount();
    Vp();
    View localView1 = je(i);
    View localView2 = jf(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(209034);
      return 0;
    }
    i = this.bXy.bt(localView2);
    int j = this.bXy.bs(localView1);
    i = Math.min(this.bXy.JG(), i - j);
    AppMethodBeat.o(209034);
    return i;
  }
  
  private int e(RecyclerView.s params)
  {
    AppMethodBeat.i(209051);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(209051);
      return 0;
    }
    int i = params.getItemCount();
    View localView1 = je(i);
    View localView2 = jf(i);
    if ((params.getItemCount() == 0) || (localView1 == null) || (localView2 == null))
    {
      AppMethodBeat.o(209051);
      return 0;
    }
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      params = new AssertionError();
      AppMethodBeat.o(209051);
      throw params;
    }
    i = Ju();
    int j = Jw();
    i = (int)(Math.abs(this.bXy.bt(localView2) - this.bXy.bs(localView1)) / (j - i + 1) * params.getItemCount());
    AppMethodBeat.o(209051);
    return i;
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
  
  private void jd(int paramInt)
  {
    AppMethodBeat.i(62354);
    if (paramInt >= Jw())
    {
      AppMethodBeat.o(62354);
      return;
    }
    int i = getChildCount();
    this.dmS.iX(i);
    this.dmS.iW(i);
    this.dmS.iY(i);
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62354);
      throw ((Throwable)localObject);
    }
    if (paramInt >= this.dmS.dmz.length)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.dnk = paramInt;
    Object localObject = getChildAt(0);
    if (localObject == null)
    {
      AppMethodBeat.o(62354);
      return;
    }
    this.bXE = getPosition((View)localObject);
    if ((!Ve()) && (this.uK))
    {
      this.bXF = (this.bXy.bt((View)localObject) + this.bXy.JH());
      AppMethodBeat.o(62354);
      return;
    }
    this.bXF = (this.bXy.bs((View)localObject) - this.bXy.JE());
    AppMethodBeat.o(62354);
  }
  
  private View je(int paramInt)
  {
    AppMethodBeat.i(62359);
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62359);
      throw ((Throwable)localObject);
    }
    Object localObject = M(0, getChildCount(), paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    paramInt = getPosition((View)localObject);
    paramInt = this.dmS.dmz[paramInt];
    if (paramInt == -1)
    {
      AppMethodBeat.o(62359);
      return null;
    }
    localObject = a((View)localObject, (b)this.dmC.get(paramInt));
    AppMethodBeat.o(62359);
    return localObject;
  }
  
  private View jf(int paramInt)
  {
    AppMethodBeat.i(62360);
    if ((!$assertionsDisabled) && (this.dmS.dmz == null))
    {
      localObject = new AssertionError();
      AppMethodBeat.o(62360);
      throw ((Throwable)localObject);
    }
    Object localObject = M(getChildCount() - 1, -1, paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(62360);
      return null;
    }
    paramInt = getPosition((View)localObject);
    paramInt = this.dmS.dmz[paramInt];
    localObject = b((View)localObject, (b)this.dmC.get(paramInt));
    AppMethodBeat.o(62360);
    return localObject;
  }
  
  private int jg(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(209004);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(209004);
      return 0;
    }
    Vp();
    boolean bool = Ve();
    int i;
    int j;
    if (bool)
    {
      i = this.dnj.getWidth();
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
      i = -Math.min(j + a.i(this.dnd) - i, k);
    }
    for (;;)
    {
      AppMethodBeat.o(209004);
      return i;
      i = this.dnj.getHeight();
      break;
      label124:
      j = getHeight();
      break label61;
      label132:
      i = paramInt;
      if (a.i(this.dnd) + paramInt > 0)
      {
        i = -a.i(this.dnd);
        continue;
        label158:
        if (paramInt > 0)
        {
          i = Math.min(j - a.i(this.dnd) - i, paramInt);
        }
        else
        {
          i = paramInt;
          if (a.i(this.dnd) + paramInt < 0) {
            i = -a.i(this.dnd);
          }
        }
      }
    }
  }
  
  private void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62331);
    if (this.dmE != paramInt)
    {
      removeAllViews();
      this.dmE = paramInt;
      this.bXy = null;
      this.dne = null;
      Vq();
      requestLayout();
    }
    AppMethodBeat.o(62331);
  }
  
  private boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209060);
    if ((paramView.isLayoutRequested()) || (!isMeasurementCacheEnabled()) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height)))
    {
      AppMethodBeat.o(209060);
      return true;
    }
    AppMethodBeat.o(209060);
    return false;
  }
  
  public final int I(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62338);
    paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), paramInt2, paramInt3, canScrollHorizontally());
    AppMethodBeat.o(62338);
    return paramInt1;
  }
  
  public final int J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62339);
    paramInt1 = getChildMeasureSpec(getHeight(), getHeightMode(), paramInt2, paramInt3, canScrollVertically());
    AppMethodBeat.o(62339);
    return paramInt1;
  }
  
  public final boolean Ve()
  {
    return (this.dmE == 0) || (this.dmE == 1);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62334);
    calculateItemDecorationsForChild(paramView, dna);
    if (Ve())
    {
      paramInt1 = getLeftDecorationWidth(paramView) + getRightDecorationWidth(paramView);
      paramb.dml += paramInt1;
      paramb.dmm = (paramInt1 + paramb.dmm);
      AppMethodBeat.o(62334);
      return;
    }
    paramInt1 = getTopDecorationHeight(paramView) + getBottomDecorationHeight(paramView);
    paramb.dml += paramInt1;
    paramb.dmm = (paramInt1 + paramb.dmm);
    AppMethodBeat.o(62334);
  }
  
  public final void a(b paramb) {}
  
  public final void b(int paramInt, View paramView)
  {
    AppMethodBeat.i(62342);
    this.dni.put(paramInt, paramView);
    AppMethodBeat.o(62342);
  }
  
  public boolean canScrollHorizontally()
  {
    AppMethodBeat.i(62380);
    if (this.dmF == 0)
    {
      boolean bool = Ve();
      AppMethodBeat.o(62380);
      return bool;
    }
    int j;
    if (Ve())
    {
      j = getWidth();
      if (this.dnj == null) {
        break label66;
      }
    }
    label66:
    for (int i = this.dnj.getWidth(); j > i; i = 0)
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
    if (this.dmF == 0)
    {
      if (!Ve())
      {
        AppMethodBeat.o(62381);
        return true;
      }
      AppMethodBeat.o(62381);
      return false;
    }
    int j;
    if (!Ve())
    {
      j = getHeight();
      if (this.dnj == null) {
        break label76;
      }
    }
    label76:
    for (int i = this.dnj.getHeight(); j > i; i = 0)
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
  
  public final int cn(View paramView)
  {
    AppMethodBeat.i(62333);
    if (Ve())
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
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(209523);
    int i = d(params);
    AppMethodBeat.o(209523);
    return i;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(209537);
    int i = c(params);
    AppMethodBeat.o(209537);
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(209553);
    int i = e(params);
    AppMethodBeat.o(209553);
    return i;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(209531);
    int i = d(params);
    AppMethodBeat.o(209531);
    return i;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(209546);
    int i = c(params);
    AppMethodBeat.o(209546);
    return i;
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(209562);
    int i = e(params);
    AppMethodBeat.o(209562);
    return i;
  }
  
  public final PointF fM(int paramInt)
  {
    AppMethodBeat.i(62343);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(62343);
      return null;
    }
    Object localObject = getChildAt(0);
    if (localObject == null)
    {
      AppMethodBeat.o(62343);
      return null;
    }
    if (paramInt < getPosition((View)localObject)) {}
    for (paramInt = -1; Ve(); paramInt = 1)
    {
      localObject = new PointF(0.0F, paramInt);
      AppMethodBeat.o(62343);
      return localObject;
    }
    localObject = new PointF(paramInt, 0.0F);
    AppMethodBeat.o(62343);
    return localObject;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(209320);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(209320);
    return localLayoutParams;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(209329);
    paramContext = new LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(209329);
    return paramContext;
  }
  
  public int getAlignContent()
  {
    return 5;
  }
  
  public int getAlignItems()
  {
    return this.dmH;
  }
  
  public int getFlexDirection()
  {
    return this.dmE;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(62335);
    int i = this.bZn.getItemCount();
    AppMethodBeat.o(62335);
    return i;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.dmC;
  }
  
  public int getFlexWrap()
  {
    return this.dmF;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62340);
    if (this.dmC.size() == 0)
    {
      AppMethodBeat.o(62340);
      return 0;
    }
    int j = -2147483648;
    int k = this.dmC.size();
    int i = 0;
    while (i < k)
    {
      j = Math.max(j, ((b)this.dmC.get(i)).dml);
      i += 1;
    }
    AppMethodBeat.o(62340);
    return j;
  }
  
  public int getMaxLine()
  {
    return this.dmJ;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62341);
    int k = this.dmC.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((b)this.dmC.get(i)).dmn;
      i += 1;
    }
    AppMethodBeat.o(62341);
    return j;
  }
  
  public final View iR(int paramInt)
  {
    AppMethodBeat.i(62336);
    View localView = (View)this.dni.get(paramInt);
    if (localView != null)
    {
      AppMethodBeat.o(62336);
      return localView;
    }
    localView = this.bYt.gb(paramInt);
    AppMethodBeat.o(62336);
    return localView;
  }
  
  public final View iS(int paramInt)
  {
    AppMethodBeat.i(62337);
    View localView = iR(paramInt);
    AppMethodBeat.o(62337);
    return localView;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  public final int k(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62332);
    if (Ve())
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
    AppMethodBeat.i(209337);
    removeAllViews();
    AppMethodBeat.o(209337);
  }
  
  public void onAttachedToWindow(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(209475);
    super.onAttachedToWindow(paramRecyclerView);
    this.dnj = ((View)paramRecyclerView.getParent());
    AppMethodBeat.o(209475);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(209485);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.bXG)
    {
      removeAndRecycleAllViews(paramn);
      paramn.clear();
    }
    AppMethodBeat.o(209485);
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209361);
    super.onItemsAdded(paramRecyclerView, paramInt1, paramInt2);
    jd(paramInt1);
    AppMethodBeat.o(209361);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209404);
    super.onItemsMoved(paramRecyclerView, paramInt1, paramInt2, paramInt3);
    jd(Math.min(paramInt1, paramInt2));
    AppMethodBeat.o(209404);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209397);
    super.onItemsRemoved(paramRecyclerView, paramInt1, paramInt2);
    jd(paramInt1);
    AppMethodBeat.o(209397);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209386);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    jd(paramInt1);
    AppMethodBeat.o(209386);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(209375);
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2, paramObject);
    jd(paramInt1);
    AppMethodBeat.o(209375);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(209434);
    this.bYt = paramn;
    this.bZn = params;
    int k = params.getItemCount();
    if ((k == 0) && (params.caw))
    {
      AppMethodBeat.o(209434);
      return;
    }
    int i = getLayoutDirection();
    a locala;
    Object localObject;
    boolean bool;
    switch (this.dmE)
    {
    default: 
      this.uK = false;
      this.dnb = false;
      Vp();
      Jo();
      this.dmS.iX(k);
      this.dmS.iW(k);
      this.dmS.iY(k);
      this.dnc.dnp = false;
      if ((this.dnf != null) && (SavedState.c(this.dnf, k))) {
        this.bXE = SavedState.b(this.dnf);
      }
      if ((a.a(this.dnd)) && (this.bXE == -1) && (this.dnf == null)) {
        break label619;
      }
      a.b(this.dnd);
      locala = this.dnd;
      localObject = this.dnf;
      if ((!$assertionsDisabled) && (this.dmS.dmz == null))
      {
        paramn = new AssertionError();
        AppMethodBeat.o(209434);
        throw paramn;
      }
      label397:
      label441:
      break;
    case 0: 
      if (i == 1)
      {
        bool = true;
        this.uK = bool;
        if (this.dmF != 2) {
          break label279;
        }
      }
      for (bool = true;; bool = false)
      {
        this.dnb = bool;
        break;
        bool = false;
        break label247;
      }
    case 1: 
      if (i != 1)
      {
        bool = true;
        this.uK = bool;
        if (this.dmF != 2) {
          break label325;
        }
      }
      for (bool = true;; bool = false)
      {
        this.dnb = bool;
        break;
        bool = false;
        break label293;
      }
    case 2: 
      if (i == 1)
      {
        bool = true;
        this.uK = bool;
        if (this.dmF == 2) {
          if (this.uK) {
            break label383;
          }
        }
      }
      for (bool = true;; bool = false)
      {
        this.uK = bool;
        this.dnb = false;
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
        this.uK = bool;
        if (this.dmF == 2) {
          if (this.uK) {
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
        this.uK = bool;
        this.dnb = true;
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
    if ((params.caw) || (this.bXE == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (getChildCount() == 0) {
          break label1272;
        }
        if (!a.d(locala)) {
          break label1243;
        }
        localObject = jf(params.getItemCount());
        if (localObject == null) {
          break label1272;
        }
        a.a(locala, (View)localObject);
        if ((!params.caw) && (supportsPredictiveItemAnimations()))
        {
          if ((this.bXy.bs((View)localObject) < this.bXy.JF()) && (this.bXy.bt((View)localObject) >= this.bXy.JE())) {
            break label1256;
          }
          i = 1;
          if (i != 0)
          {
            if (!a.d(locala)) {
              break label1261;
            }
            i = this.bXy.JF();
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
      a.c(this.dnd);
      detachAndScrapAttachedViews(paramn);
      if (!a.d(this.dnd)) {
        break label1277;
      }
      b(this.dnd, false, true);
      m = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
      n = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
      i1 = getWidth();
      i2 = getHeight();
      if (!Ve()) {
        break label1307;
      }
      if ((this.dng == -2147483648) || (this.dng == i1)) {
        break label1290;
      }
      i = 1;
      label709:
      if (!this.dnc.bXw) {
        break label1295;
      }
    }
    label1290:
    label1295:
    for (int j = this.mContext.getResources().getDisplayMetrics().heightPixels;; j = this.dnc.bXq)
    {
      this.dng = i1;
      this.dnh = i2;
      if ((this.dnk != -1) || ((this.bXE == -1) && (i == 0))) {
        break label1613;
      }
      if (a.d(this.dnd)) {
        break label1480;
      }
      this.dmC.clear();
      if (($assertionsDisabled) || (this.dmS.dmz != null)) {
        break label1372;
      }
      paramn = new AssertionError();
      AppMethodBeat.o(209434);
      throw paramn;
      if ((this.bXE < 0) || (this.bXE >= params.getItemCount()))
      {
        this.bXE = -1;
        this.bXF = -2147483648;
        i = 0;
        break;
      }
      a.b(locala, this.bXE);
      a.a(locala, this.dmS.dmz[a.e(locala)]);
      if ((this.dnf != null) && (SavedState.c(this.dnf, params.getItemCount())))
      {
        i = this.bXy.JE();
        a.c(locala, SavedState.c((SavedState)localObject) + i);
        a.h(locala);
        a.a(locala, -1);
      }
      for (;;)
      {
        i = 1;
        break;
        if (this.bXF == -2147483648)
        {
          localObject = findViewByPosition(this.bXE);
          if (localObject != null)
          {
            if (this.bXy.bw((View)localObject) > this.bXy.JG())
            {
              a.g(locala);
            }
            else if (this.bXy.bs((View)localObject) - this.bXy.JE() < 0)
            {
              a.c(locala, this.bXy.JE());
              a.a(locala, false);
            }
            else if (this.bXy.JF() - this.bXy.bt((View)localObject) < 0)
            {
              a.c(locala, this.bXy.JF());
              a.a(locala, true);
            }
            else
            {
              if (a.d(locala)) {}
              for (i = this.bXy.bt((View)localObject) + this.bXy.JD();; i = this.bXy.bs((View)localObject))
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
              localObject = getChildAt(0);
              if (localObject != null)
              {
                i = getPosition((View)localObject);
                if (this.bXE >= i) {
                  break label1181;
                }
              }
            }
            label1181:
            for (bool = true;; bool = false)
            {
              a.a(locala, bool);
              a.g(locala);
              break;
            }
          }
        }
        else if ((!Ve()) && (this.uK))
        {
          a.c(locala, this.bXF - this.bXy.JH());
        }
        else
        {
          a.c(locala, this.bXy.JE() + this.bXF);
        }
      }
      label1243:
      localObject = je(params.getItemCount());
      break label493;
      label1256:
      i = 0;
      break label559;
      label1261:
      i = this.bXy.JE();
      break label579;
      label1272:
      i = 0;
      break label588;
      label1277:
      a(this.dnd, false, true);
      break label644;
      i = 0;
      break label709;
    }
    label1307:
    if ((this.dnh != -2147483648) && (this.dnh != i2))
    {
      i = 1;
      label1327:
      if (!this.dnc.bXw) {
        break label1360;
      }
    }
    label1360:
    for (j = this.mContext.getResources().getDisplayMetrics().widthPixels;; j = this.dnc.bXq)
    {
      break;
      i = 0;
      break label1327;
    }
    label1372:
    this.dmT.reset();
    if (Ve())
    {
      this.dmS.b(this.dmT, m, n, j, a.e(this.dnd), this.dmC);
      this.dmC = this.dmT.dmC;
      this.dmS.cn(m, n);
      this.dmS.Vm();
      a.a(this.dnd, this.dmS.dmz[a.e(this.dnd)]);
      this.dnc.dnl = a.f(this.dnd);
      label1480:
      a(paramn, params, this.dnc);
      if (!a.d(this.dnd)) {
        break label1872;
      }
      j = this.dnc.Sc;
      a(this.dnd, true, false);
      a(paramn, params, this.dnc);
      i = this.dnc.Sc;
    }
    for (;;)
    {
      if (getChildCount() > 0)
      {
        if (a.d(this.dnd))
        {
          b(a(i, paramn, params, true) + j, paramn, params, false);
          AppMethodBeat.o(209434);
          return;
          this.dmS.d(this.dmT, m, n, j, a.e(this.dnd), this.dmC);
          break;
          label1613:
          if (this.dnk != -1)
          {
            i = Math.min(this.dnk, a.e(this.dnd));
            label1636:
            this.dmT.reset();
            if (!Ve()) {
              break label1782;
            }
            if (this.dmC.size() <= 0) {
              break label1748;
            }
            this.dmS.k(this.dmC, i);
            this.dmS.a(this.dmT, m, n, j, i, a.e(this.dnd), this.dmC);
          }
          for (;;)
          {
            this.dmC = this.dmT.dmC;
            this.dmS.K(m, n, i);
            this.dmS.iV(i);
            break;
            i = a.e(this.dnd);
            break label1636;
            label1748:
            this.dmS.iY(k);
            this.dmS.a(this.dmT, m, n, j, 0, this.dmC);
            continue;
            label1782:
            if (this.dmC.size() > 0)
            {
              this.dmS.k(this.dmC, i);
              this.dmS.a(this.dmT, n, m, j, i, a.e(this.dnd), this.dmC);
            }
            else
            {
              this.dmS.iY(k);
              this.dmS.c(this.dmT, m, n, j, 0, this.dmC);
            }
          }
          label1872:
          i = this.dnc.Sc;
          b(this.dnd, true, false);
          a(paramn, params, this.dnc);
          j = this.dnc.Sc;
          continue;
        }
        a(i + b(j, paramn, params, true), paramn, params, false);
      }
    }
    AppMethodBeat.o(209434);
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(209441);
    super.onLayoutCompleted(params);
    this.dnf = null;
    this.bXE = -1;
    this.bXF = -2147483648;
    this.dnk = -1;
    a.b(this.dnd);
    this.dni.clear();
    AppMethodBeat.o(209441);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(62348);
    if ((paramParcelable instanceof SavedState))
    {
      this.dnf = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(62348);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(62347);
    if (this.dnf != null)
    {
      localSavedState = new SavedState(this.dnf, (byte)0);
      AppMethodBeat.o(62347);
      return localSavedState;
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      SavedState.a(localSavedState, getPosition(localView));
      SavedState.b(localSavedState, this.bXy.bs(localView) - this.bXy.JE());
    }
    for (;;)
    {
      AppMethodBeat.o(62347);
      return localSavedState;
      SavedState.a(localSavedState);
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(209507);
    if ((!Ve()) || (this.dmF == 0))
    {
      paramInt = b(paramInt, paramn, params);
      this.dni.clear();
      AppMethodBeat.o(209507);
      return paramInt;
    }
    paramInt = jg(paramInt);
    a.d(this.dnd, paramInt);
    this.dne.fQ(-paramInt);
    AppMethodBeat.o(209507);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(62376);
    this.bXE = paramInt;
    this.bXF = -2147483648;
    if (this.dnf != null) {
      SavedState.a(this.dnf);
    }
    requestLayout();
    AppMethodBeat.o(62376);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(209516);
    if ((Ve()) || ((this.dmF == 0) && (!Ve())))
    {
      paramInt = b(paramInt, paramn, params);
      this.dni.clear();
      AppMethodBeat.o(209516);
      return paramInt;
    }
    paramInt = jg(paramInt);
    a.d(this.dnd, paramInt);
    this.dne.fQ(-paramInt);
    AppMethodBeat.o(209516);
    return paramInt;
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.dmC = paramList;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(209465);
    paramRecyclerView = new o(paramRecyclerView.getContext());
    paramRecyclerView.cag = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(209465);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private int biW;
    private int bkR;
    private float dmV;
    private float dmW;
    private int dmX;
    private float dmY;
    private boolean dmZ;
    private int mf;
    private int vF;
    
    static
    {
      AppMethodBeat.i(62323);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(62323);
    }
    
    public LayoutParams()
    {
      super(-2);
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.vF = 16777215;
      this.bkR = 16777215;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.vF = 16777215;
      this.bkR = 16777215;
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(-2);
      AppMethodBeat.i(62322);
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.vF = 16777215;
      this.bkR = 16777215;
      this.dmV = paramParcel.readFloat();
      this.dmW = paramParcel.readFloat();
      this.dmX = paramParcel.readInt();
      this.dmY = paramParcel.readFloat();
      this.mf = paramParcel.readInt();
      this.biW = paramParcel.readInt();
      this.vF = paramParcel.readInt();
      this.bkR = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.dmZ = bool;
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
    
    public final int Vf()
    {
      return this.dmX;
    }
    
    public final boolean Vg()
    {
      return this.dmZ;
    }
    
    public final float Vh()
    {
      return this.dmY;
    }
    
    public final int Vi()
    {
      return this.leftMargin;
    }
    
    public final int Vj()
    {
      return this.topMargin;
    }
    
    public final int Vk()
    {
      return this.rightMargin;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final float getFlexGrow()
    {
      return this.dmV;
    }
    
    public final float getFlexShrink()
    {
      return this.dmW;
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
      return this.bkR;
    }
    
    public final int getMaxWidth()
    {
      return this.vF;
    }
    
    public final int getMinHeight()
    {
      return this.biW;
    }
    
    public final int getMinWidth()
    {
      return this.mf;
    }
    
    public final int getOrder()
    {
      return 1;
    }
    
    public final int getWidth()
    {
      return this.width;
    }
    
    public final void setMinHeight(int paramInt)
    {
      this.biW = paramInt;
    }
    
    public final void setMinWidth(int paramInt)
    {
      this.mf = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62321);
      paramParcel.writeFloat(this.dmV);
      paramParcel.writeFloat(this.dmW);
      paramParcel.writeInt(this.dmX);
      paramParcel.writeFloat(this.dmY);
      paramParcel.writeInt(this.mf);
      paramParcel.writeInt(this.biW);
      paramParcel.writeInt(this.vF);
      paramParcel.writeInt(this.bkR);
      if (this.dmZ) {}
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
    private int bXU;
    private int bXV;
    
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
      this.bXU = paramParcel.readInt();
      this.bXV = paramParcel.readInt();
      AppMethodBeat.o(62327);
    }
    
    private SavedState(SavedState paramSavedState)
    {
      this.bXU = paramSavedState.bXU;
      this.bXV = paramSavedState.bXV;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(62328);
      String str = "SavedState{mAnchorPosition=" + this.bXU + ", mAnchorOffset=" + this.bXV + '}';
      AppMethodBeat.o(62328);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62326);
      paramParcel.writeInt(this.bXU);
      paramParcel.writeInt(this.bXV);
      AppMethodBeat.o(62326);
    }
  }
  
  final class a
  {
    private boolean Nl;
    private int bXL;
    private boolean bXM;
    private int dnl;
    private int dnm = 0;
    private boolean dnn;
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
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.dnl + ", mCoordinate=" + this.bXL + ", mPerpendicularCoordinate=" + this.dnm + ", mLayoutFromEnd=" + this.bXM + ", mValid=" + this.Nl + ", mAssignedFromSavedState=" + this.dnn + '}';
      AppMethodBeat.o(62315);
      return str;
    }
  }
  
  static final class b
  {
    int Sc;
    int bXP;
    int bXS;
    int bXq;
    int bXs = 1;
    boolean bXw;
    int dnl;
    boolean dnp;
    int mLayoutDirection = 1;
    int mPosition;
    
    public final String toString()
    {
      AppMethodBeat.i(62324);
      String str = "LayoutState{mAvailable=" + this.bXq + ", mFlexLinePosition=" + this.dnl + ", mPosition=" + this.mPosition + ", mOffset=" + this.Sc + ", mScrollingOffset=" + this.bXP + ", mLastScrollDelta=" + this.bXS + ", mItemDirection=" + this.bXs + ", mLayoutDirection=" + this.mLayoutDirection + '}';
      AppMethodBeat.o(62324);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayoutManager
 * JD-Core Version:    0.7.0.1
 */