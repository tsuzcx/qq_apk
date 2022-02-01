package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlexboxLayout
  extends ViewGroup
  implements a
{
  private int bJA;
  private int bJB;
  private int bJC;
  private int[] bJD;
  private SparseIntArray bJE;
  private c bJF;
  private c.a bJG;
  private List<b> bJp;
  private int bJr;
  private int bJs;
  private int bJt;
  private int bJu;
  private int bJv;
  private int bJw;
  private Drawable bJx;
  private Drawable bJy;
  private int bJz;
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62270);
    this.bJw = -1;
    this.bJF = new c(this);
    this.bJp = new ArrayList();
    this.bJG = new c.a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout, paramInt, 0);
    this.bJr = paramContext.getInt(5, 0);
    this.bJs = paramContext.getInt(6, 0);
    this.bJt = paramContext.getInt(7, 0);
    this.bJu = paramContext.getInt(1, 4);
    this.bJv = paramContext.getInt(0, 5);
    this.bJw = paramContext.getInt(8, -1);
    paramAttributeSet = paramContext.getDrawable(2);
    if (paramAttributeSet != null)
    {
      setDividerDrawableHorizontal(paramAttributeSet);
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(3);
    if (paramAttributeSet != null) {
      setDividerDrawableHorizontal(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(4);
    if (paramAttributeSet != null) {
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramInt = paramContext.getInt(9, 0);
    if (paramInt != 0)
    {
      this.bJA = paramInt;
      this.bJz = paramInt;
    }
    paramInt = paramContext.getInt(11, 0);
    if (paramInt != 0) {
      this.bJA = paramInt;
    }
    paramInt = paramContext.getInt(10, 0);
    if (paramInt != 0) {
      this.bJz = paramInt;
    }
    paramContext.recycle();
    AppMethodBeat.o(62270);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62287);
    if (this.bJy == null)
    {
      AppMethodBeat.o(62287);
      return;
    }
    this.bJy.setBounds(paramInt1, paramInt2, this.bJC + paramInt1, paramInt2 + paramInt3);
    this.bJy.draw(paramCanvas);
    AppMethodBeat.o(62287);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62285);
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.bJp.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bJp.get(i);
      int j = 0;
      if (j < localb.auc)
      {
        int k = localb.bJj + j;
        View localView = fr(k);
        FlexboxLayout.LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
          if (bm(k, j))
          {
            if (!paramBoolean1) {
              break label240;
            }
            k = localView.getRight() + localLayoutParams.rightMargin;
            label154:
            a(paramCanvas, k, localb.Am, localb.bJc);
          }
          if ((j == localb.auc - 1) && ((this.bJA & 0x4) > 0)) {
            if (!paramBoolean1) {
              break label261;
            }
          }
        }
        for (k = localView.getLeft() - localLayoutParams.leftMargin - this.bJC;; k = localLayoutParams.rightMargin + k)
        {
          a(paramCanvas, k, localb.Am, localb.bJc);
          j += 1;
          break;
          label240:
          k = localView.getLeft() - localLayoutParams.leftMargin - this.bJC;
          break label154;
          label261:
          k = localView.getRight();
        }
      }
      if (fs(i))
      {
        if (paramBoolean2)
        {
          j = localb.Ao;
          label301:
          b(paramCanvas, m, j, n);
        }
      }
      else if ((fu(i)) && ((this.bJz & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label381;
        }
      }
      label381:
      for (j = localb.Am - this.bJB;; j = localb.Ao)
      {
        b(paramCanvas, m, j, n);
        i += 1;
        break;
        j = localb.Am - this.bJB;
        break label301;
      }
    }
    AppMethodBeat.o(62285);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62283);
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int j = getPaddingRight();
    int i = getPaddingLeft();
    int i1 = paramInt4 - paramInt2;
    paramInt1 = paramInt3 - paramInt1 - j;
    int i2 = this.bJp.size();
    paramInt3 = 0;
    paramInt2 = i;
    Object localObject;
    float f1;
    float f2;
    float f3;
    float f5;
    label231:
    View localView;
    float f4;
    FlexboxLayout.LayoutParams localLayoutParams;
    int k;
    if (paramInt3 < i2)
    {
      localObject = (b)this.bJp.get(paramInt3);
      paramInt4 = paramInt1;
      i = paramInt2;
      if (fs(paramInt3))
      {
        i = paramInt2 + this.bJC;
        paramInt4 = paramInt1 - this.bJC;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bJt)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
        AppMethodBeat.o(62283);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).auc)
        {
          j = ((b)localObject).bJj + paramInt1;
          localView = fr(j);
          f2 = f3;
          f4 = f1;
          if (localView != null)
          {
            f2 = f3;
            f4 = f1;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
              f2 = f3 + localLayoutParams.topMargin;
              f1 -= localLayoutParams.bottomMargin;
              paramInt2 = 0;
              k = 0;
              if (!bm(j, paramInt1)) {
                break label932;
              }
              paramInt2 = this.bJB;
              f3 = paramInt2;
              f1 -= paramInt2;
              f2 += f3;
            }
          }
        }
        break;
      }
    }
    label932:
    for (;;)
    {
      j = k;
      if (paramInt1 == ((b)localObject).auc - 1)
      {
        j = k;
        if ((this.bJz & 0x4) > 0) {
          j = this.bJB;
        }
      }
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.bJF.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
          label442:
          f2 += localView.getMeasuredHeight() + f5 + localLayoutParams.bottomMargin;
          f1 -= localView.getMeasuredHeight() + f5 + localLayoutParams.topMargin;
          if (!paramBoolean2) {
            break label874;
          }
          ((b)localObject).k(localView, 0, j, 0, paramInt2);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        f3 = f2;
        break label231;
        f2 = i1 - ((b)localObject).bJa + n;
        f1 = ((b)localObject).bJa - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bJa) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bJa) / 2.0F;
        break;
        paramInt1 = ((b)localObject).xJ();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bJa) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).xJ();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bJa) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).xJ();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bJa) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bJF.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        if (paramBoolean2)
        {
          this.bJF.a(localView, (b)localObject, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          break label442;
        }
        this.bJF.a(localView, (b)localObject, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        label874:
        ((b)localObject).k(localView, 0, paramInt2, 0, j);
        f4 = f1;
        f1 = f4;
      }
      paramInt2 = i + ((b)localObject).bJc;
      paramInt1 = paramInt4 - ((b)localObject).bJc;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62283);
      return;
    }
  }
  
  private void ae(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62277);
    this.bJp.clear();
    this.bJG.reset();
    this.bJF.a(this.bJG, paramInt1, paramInt2, 2147483647, 0, -1, null);
    this.bJp = this.bJG.bJp;
    this.bJF.v(paramInt1, paramInt2, 0);
    b localb;
    int i;
    int j;
    label110:
    View localView;
    FlexboxLayout.LayoutParams localLayoutParams;
    int k;
    int m;
    if (this.bJu == 3)
    {
      Iterator localIterator = this.bJp.iterator();
      if (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        i = -2147483648;
        j = 0;
        if (j < localb.auc)
        {
          localView = fr(localb.bJj + j);
          if ((localView == null) || (localView.getVisibility() == 8)) {
            break label332;
          }
          localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
          if (this.bJs != 2)
          {
            k = Math.max(localb.bJg - localView.getBaseline(), localLayoutParams.topMargin);
            m = localView.getMeasuredHeight();
            i = Math.max(i, localLayoutParams.bottomMargin + (m + k));
          }
        }
      }
    }
    label332:
    for (;;)
    {
      j += 1;
      break label110;
      k = Math.max(localb.bJg - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
      m = localView.getMeasuredHeight();
      i = Math.max(i, localLayoutParams.topMargin + m + k);
      continue;
      localb.bJc = i;
      break;
      this.bJF.w(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
      this.bJF.fn(0);
      o(this.bJr, paramInt1, paramInt2, this.bJG.bJq);
      AppMethodBeat.o(62277);
      return;
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62288);
    if (this.bJx == null)
    {
      AppMethodBeat.o(62288);
      return;
    }
    this.bJx.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.bJB + paramInt2);
    this.bJx.draw(paramCanvas);
    AppMethodBeat.o(62288);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62286);
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.bJp.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bJp.get(i);
      int j = 0;
      if (j < localb.auc)
      {
        int k = localb.bJj + j;
        View localView = fr(k);
        FlexboxLayout.LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
          if (bm(k, j))
          {
            if (!paramBoolean2) {
              break label241;
            }
            k = localView.getBottom() + localLayoutParams.bottomMargin;
            label155:
            b(paramCanvas, localb.Al, k, localb.bJc);
          }
          if ((j == localb.auc - 1) && ((this.bJz & 0x4) > 0)) {
            if (!paramBoolean2) {
              break label262;
            }
          }
        }
        for (k = localView.getTop() - localLayoutParams.topMargin - this.bJB;; k = localLayoutParams.bottomMargin + k)
        {
          b(paramCanvas, localb.Al, k, localb.bJc);
          j += 1;
          break;
          label241:
          k = localView.getTop() - localLayoutParams.topMargin - this.bJB;
          break label155;
          label262:
          k = localView.getBottom();
        }
      }
      if (fs(i))
      {
        if (paramBoolean1)
        {
          j = localb.An;
          label302:
          a(paramCanvas, j, m, n);
        }
      }
      else if ((fu(i)) && ((this.bJA & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label382;
        }
      }
      label382:
      for (j = localb.Al - this.bJC;; j = localb.An)
      {
        a(paramCanvas, j, m, n);
        i += 1;
        break;
        j = localb.Al - this.bJC;
        break label302;
      }
    }
    AppMethodBeat.o(62286);
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62282);
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2 - getPaddingBottom();
    paramInt1 = getPaddingTop();
    int i2 = this.bJp.size();
    paramInt3 = 0;
    Object localObject;
    int i;
    float f1;
    float f2;
    float f3;
    float f5;
    label224:
    int j;
    View localView;
    float f4;
    FlexboxLayout.LayoutParams localLayoutParams;
    int k;
    if (paramInt3 < i2)
    {
      localObject = (b)this.bJp.get(paramInt3);
      paramInt4 = paramInt2;
      i = paramInt1;
      if (fs(paramInt3))
      {
        paramInt4 = paramInt2 - this.bJB;
        i = paramInt1 + this.bJB;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bJt)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
        AppMethodBeat.o(62282);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).auc)
        {
          j = ((b)localObject).bJj + paramInt1;
          localView = fr(j);
          f2 = f3;
          f4 = f1;
          if (localView != null)
          {
            f2 = f3;
            f4 = f1;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
              f2 = f3 + localLayoutParams.leftMargin;
              f1 -= localLayoutParams.rightMargin;
              paramInt2 = 0;
              k = 0;
              if (!bm(j, paramInt1)) {
                break label919;
              }
              paramInt2 = this.bJC;
              f3 = paramInt2;
              f1 -= paramInt2;
              f2 += f3;
            }
          }
        }
        break;
      }
    }
    label919:
    for (;;)
    {
      j = k;
      if (paramInt1 == ((b)localObject).auc - 1)
      {
        j = k;
        if ((this.bJA & 0x4) > 0) {
          j = this.bJC;
        }
      }
      if (this.bJs == 2) {
        if (paramBoolean)
        {
          this.bJF.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), paramInt4 - localView.getMeasuredHeight(), Math.round(f1), paramInt4);
          label434:
          f2 += localView.getMeasuredWidth() + f5 + localLayoutParams.rightMargin;
          f1 -= localView.getMeasuredWidth() + f5 + localLayoutParams.leftMargin;
          if (!paramBoolean) {
            break label862;
          }
          ((b)localObject).k(localView, j, 0, paramInt2, 0);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        f3 = f2;
        break label224;
        f2 = i1 - ((b)localObject).bJa + n;
        f1 = ((b)localObject).bJa - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bJa) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bJa) / 2.0F;
        break;
        paramInt1 = ((b)localObject).xJ();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bJa) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).xJ();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bJa) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).xJ();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bJa) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bJF.a(localView, (b)localObject, Math.round(f2), paramInt4 - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), paramInt4);
        break label434;
        if (paramBoolean)
        {
          this.bJF.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), i, Math.round(f1), i + localView.getMeasuredHeight());
          break label434;
        }
        this.bJF.a(localView, (b)localObject, Math.round(f2), i, Math.round(f2) + localView.getMeasuredWidth(), i + localView.getMeasuredHeight());
        break label434;
        label862:
        ((b)localObject).k(localView, paramInt2, 0, j, 0);
        f4 = f1;
        f1 = f4;
      }
      paramInt1 = i + ((b)localObject).bJc;
      paramInt2 = paramInt4 - ((b)localObject).bJc;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62282);
      return;
    }
  }
  
  private boolean bm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62309);
    if (bn(paramInt1, paramInt2))
    {
      if (xC())
      {
        if ((this.bJA & 0x1) != 0)
        {
          AppMethodBeat.o(62309);
          return true;
        }
        AppMethodBeat.o(62309);
        return false;
      }
      if ((this.bJz & 0x1) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if (xC())
    {
      if ((this.bJA & 0x2) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if ((this.bJz & 0x2) != 0)
    {
      AppMethodBeat.o(62309);
      return true;
    }
    AppMethodBeat.o(62309);
    return false;
  }
  
  private boolean bn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62310);
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = fr(paramInt1 - i);
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        AppMethodBeat.o(62310);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(62310);
    return true;
  }
  
  private View fr(int paramInt)
  {
    AppMethodBeat.i(62274);
    if ((paramInt < 0) || (paramInt >= this.bJD.length))
    {
      AppMethodBeat.o(62274);
      return null;
    }
    View localView = getChildAt(this.bJD[paramInt]);
    AppMethodBeat.o(62274);
    return localView;
  }
  
  private boolean fs(int paramInt)
  {
    AppMethodBeat.i(62311);
    if ((paramInt < 0) || (paramInt >= this.bJp.size()))
    {
      AppMethodBeat.o(62311);
      return false;
    }
    if (ft(paramInt))
    {
      if (xC())
      {
        if ((this.bJz & 0x1) != 0)
        {
          AppMethodBeat.o(62311);
          return true;
        }
        AppMethodBeat.o(62311);
        return false;
      }
      if ((this.bJA & 0x1) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if (xC())
    {
      if ((this.bJz & 0x2) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if ((this.bJA & 0x2) != 0)
    {
      AppMethodBeat.o(62311);
      return true;
    }
    AppMethodBeat.o(62311);
    return false;
  }
  
  private boolean ft(int paramInt)
  {
    AppMethodBeat.i(62312);
    int i = 0;
    while (i < paramInt)
    {
      if (((b)this.bJp.get(i)).xJ() > 0)
      {
        AppMethodBeat.o(62312);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(62312);
    return true;
  }
  
  private boolean fu(int paramInt)
  {
    AppMethodBeat.i(62313);
    if ((paramInt < 0) || (paramInt >= this.bJp.size()))
    {
      AppMethodBeat.o(62313);
      return false;
    }
    paramInt += 1;
    while (paramInt < this.bJp.size())
    {
      if (((b)this.bJp.get(paramInt)).xJ() > 0)
      {
        AppMethodBeat.o(62313);
        return false;
      }
      paramInt += 1;
    }
    if (xC())
    {
      if ((this.bJz & 0x4) != 0)
      {
        AppMethodBeat.o(62313);
        return true;
      }
      AppMethodBeat.o(62313);
      return false;
    }
    if ((this.bJA & 0x4) != 0)
    {
      AppMethodBeat.o(62313);
      return true;
    }
    AppMethodBeat.o(62313);
    return false;
  }
  
  private void o(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62278);
    int j = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = View.MeasureSpec.getMode(paramInt3);
    int k = View.MeasureSpec.getSize(paramInt3);
    Object localObject;
    int i;
    switch (paramInt1)
    {
    default: 
      localObject = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(62278);
      throw ((Throwable)localObject);
    case 0: 
    case 1: 
      paramInt1 = getSumOfCrossSize();
      i = getPaddingTop();
      i = getPaddingBottom() + (paramInt1 + i);
    }
    for (paramInt1 = getLargestMainSize();; paramInt1 = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight()) {
      switch (j)
      {
      default: 
        localObject = new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(j)));
        AppMethodBeat.o(62278);
        throw ((Throwable)localObject);
        i = getLargestMainSize();
      }
    }
    j = paramInt4;
    if (m < paramInt1) {
      j = View.combineMeasuredStates(paramInt4, 16777216);
    }
    paramInt2 = View.resolveSizeAndState(m, paramInt2, j);
    paramInt1 = j;
    for (;;)
    {
      switch (n)
      {
      default: 
        localObject = new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(n)));
        AppMethodBeat.o(62278);
        throw ((Throwable)localObject);
        if (m < paramInt1)
        {
          paramInt4 = View.combineMeasuredStates(paramInt4, 16777216);
          paramInt1 = m;
        }
        for (;;)
        {
          paramInt2 = View.resolveSizeAndState(paramInt1, paramInt2, paramInt4);
          paramInt1 = paramInt4;
          break;
        }
        paramInt2 = View.resolveSizeAndState(paramInt1, paramInt2, paramInt4);
        paramInt1 = paramInt4;
      }
    }
    paramInt4 = paramInt1;
    if (k < i) {
      paramInt4 = View.combineMeasuredStates(paramInt1, 256);
    }
    paramInt1 = View.resolveSizeAndState(k, paramInt3, paramInt4);
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(62278);
      return;
      if (k < i) {
        paramInt1 = View.combineMeasuredStates(paramInt1, 256);
      }
      for (paramInt4 = k;; paramInt4 = i)
      {
        paramInt1 = View.resolveSizeAndState(paramInt4, paramInt3, paramInt1);
        break;
      }
      paramInt1 = View.resolveSizeAndState(i, paramInt3, paramInt1);
    }
  }
  
  private void xL()
  {
    AppMethodBeat.i(62308);
    if ((this.bJx == null) && (this.bJy == null))
    {
      setWillNotDraw(true);
      AppMethodBeat.o(62308);
      return;
    }
    setWillNotDraw(false);
    AppMethodBeat.o(62308);
  }
  
  public final void a(int paramInt, View paramView) {}
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62301);
    if (bm(paramInt1, paramInt2))
    {
      if (xC())
      {
        paramb.bJa += this.bJC;
        paramb.bJb += this.bJC;
        AppMethodBeat.o(62301);
        return;
      }
      paramb.bJa += this.bJB;
      paramb.bJb += this.bJB;
    }
    AppMethodBeat.o(62301);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(62298);
    if (xC())
    {
      if ((this.bJA & 0x4) > 0)
      {
        paramb.bJa += this.bJC;
        paramb.bJb += this.bJC;
        AppMethodBeat.o(62298);
      }
    }
    else if ((this.bJz & 0x4) > 0)
    {
      paramb.bJa += this.bJB;
      paramb.bJb += this.bJB;
    }
    AppMethodBeat.o(62298);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62276);
    if (this.bJE == null) {
      this.bJE = new SparseIntArray(getChildCount());
    }
    this.bJD = this.bJF.a(paramView, paramInt, paramLayoutParams, this.bJE);
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(62276);
  }
  
  public final int bV(View paramView)
  {
    return 0;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FlexboxLayout.LayoutParams;
  }
  
  public final View fj(int paramInt)
  {
    AppMethodBeat.i(62273);
    View localView = getChildAt(paramInt);
    AppMethodBeat.o(62273);
    return localView;
  }
  
  public final View fk(int paramInt)
  {
    AppMethodBeat.i(62275);
    View localView = fr(paramInt);
    AppMethodBeat.o(62275);
    return localView;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62289);
    if ((paramLayoutParams instanceof FlexboxLayout.LayoutParams))
    {
      paramLayoutParams = new FlexboxLayout.LayoutParams((FlexboxLayout.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(62289);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new FlexboxLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(62289);
      return paramLayoutParams;
    }
    paramLayoutParams = new FlexboxLayout.LayoutParams(paramLayoutParams);
    AppMethodBeat.o(62289);
    return paramLayoutParams;
  }
  
  public int getAlignContent()
  {
    return this.bJv;
  }
  
  public int getAlignItems()
  {
    return this.bJu;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.bJx;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.bJy;
  }
  
  public int getFlexDirection()
  {
    return this.bJr;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(62272);
    int i = getChildCount();
    AppMethodBeat.o(62272);
    return i;
  }
  
  public List<b> getFlexLines()
  {
    AppMethodBeat.i(62296);
    ArrayList localArrayList = new ArrayList(this.bJp.size());
    Iterator localIterator = this.bJp.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.xJ() != 0) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(62296);
    return localArrayList;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bJp;
  }
  
  public int getFlexWrap()
  {
    return this.bJs;
  }
  
  public int getJustifyContent()
  {
    return this.bJt;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62279);
    Iterator localIterator = this.bJp.iterator();
    for (int i = -2147483648; localIterator.hasNext(); i = Math.max(i, ((b)localIterator.next()).bJa)) {}
    AppMethodBeat.o(62279);
    return i;
  }
  
  public int getMaxLine()
  {
    return this.bJw;
  }
  
  public int getShowDividerHorizontal()
  {
    return this.bJz;
  }
  
  public int getShowDividerVertical()
  {
    return this.bJA;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62280);
    int m = this.bJp.size();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      b localb = (b)this.bJp.get(k);
      int i = j;
      if (fs(k))
      {
        if (xC()) {
          i = j + this.bJB;
        }
      }
      else
      {
        label66:
        j = i;
        if (fu(k)) {
          if (!xC()) {
            break label115;
          }
        }
      }
      label115:
      for (j = i + this.bJB;; j = i + this.bJC)
      {
        j += localb.bJc;
        k += 1;
        break;
        i = j + this.bJC;
        break label66;
      }
    }
    AppMethodBeat.o(62280);
    return j;
  }
  
  public final int m(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62297);
    int j = 0;
    int i = 0;
    if (xC())
    {
      if (bm(paramInt1, paramInt2)) {
        i = this.bJC + 0;
      }
      paramInt1 = i;
      if ((this.bJA & 0x4) > 0) {
        paramInt1 = i + this.bJC;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62297);
      return paramInt1;
      i = j;
      if (bm(paramInt1, paramInt2)) {
        i = this.bJB + 0;
      }
      paramInt1 = i;
      if ((this.bJz & 0x4) > 0) {
        paramInt1 = i + this.bJB;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool3 = true;
    AppMethodBeat.i(62284);
    if ((this.bJy == null) && (this.bJx == null))
    {
      AppMethodBeat.o(62284);
      return;
    }
    if ((this.bJz == 0) && (this.bJA == 0))
    {
      AppMethodBeat.o(62284);
      return;
    }
    int i = u.Z(this);
    boolean bool1;
    switch (this.bJr)
    {
    default: 
      AppMethodBeat.o(62284);
      return;
    case 0: 
      if (i == 1)
      {
        bool1 = true;
        label114:
        if (this.bJs != 2) {
          break label284;
        }
      }
      break;
    }
    label153:
    label284:
    for (bool2 = bool3;; bool2 = false)
    {
      a(paramCanvas, bool1, bool2);
      AppMethodBeat.o(62284);
      return;
      bool1 = false;
      break label114;
      if (i != 1)
      {
        bool1 = true;
        if (this.bJs != 2) {
          break label278;
        }
      }
      for (bool2 = bool4;; bool2 = false)
      {
        a(paramCanvas, bool1, bool2);
        AppMethodBeat.o(62284);
        return;
        bool1 = false;
        break label153;
        if (i == 1)
        {
          bool1 = true;
          label192:
          if (this.bJs != 2) {
            break label275;
          }
          if (bool1) {
            break label226;
          }
          bool1 = bool5;
        }
        for (;;)
        {
          b(paramCanvas, bool1, false);
          AppMethodBeat.o(62284);
          return;
          bool1 = false;
          break label192;
          label226:
          bool1 = false;
          continue;
          if (i == 1)
          {
            bool1 = true;
            label238:
            if (this.bJs != 2) {
              break label269;
            }
            if (bool1) {}
          }
          for (bool2 = true;; bool2 = bool1)
          {
            b(paramCanvas, bool2, true);
            break;
            bool1 = false;
            break label238;
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(62281);
    int i = u.Z(this);
    switch (this.bJr)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.bJr);
      AppMethodBeat.o(62281);
      throw localIllegalStateException;
    case 0: 
      if (i == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(62281);
        return;
      }
    case 1: 
      if (i != 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(62281);
        return;
      }
    case 2: 
      if (i == 1)
      {
        paramBoolean = true;
        if (this.bJs != 2) {
          break label258;
        }
        if (paramBoolean) {
          break label199;
        }
        paramBoolean = bool2;
      }
      break;
    }
    label258:
    for (;;)
    {
      a(paramBoolean, false, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(62281);
      return;
      paramBoolean = false;
      break;
      label199:
      paramBoolean = false;
      continue;
      if (i == 1)
      {
        paramBoolean = true;
        if (this.bJs != 2) {
          break label252;
        }
        if (paramBoolean) {}
      }
      label252:
      for (bool1 = true;; bool1 = paramBoolean)
      {
        a(bool1, true, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(62281);
        return;
        paramBoolean = false;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62271);
    if (this.bJE == null) {
      this.bJE = new SparseIntArray(getChildCount());
    }
    if (this.bJF.b(this.bJE)) {
      this.bJD = this.bJF.a(this.bJE);
    }
    switch (this.bJr)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.bJr);
      AppMethodBeat.o(62271);
      throw localIllegalStateException;
    case 0: 
    case 1: 
      ae(paramInt1, paramInt2);
      AppMethodBeat.o(62271);
      return;
    }
    this.bJp.clear();
    this.bJG.reset();
    this.bJF.a(this.bJG, paramInt1, paramInt2);
    this.bJp = this.bJG.bJp;
    this.bJF.bk(paramInt1, paramInt2);
    this.bJF.w(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.bJF.xK();
    o(this.bJr, paramInt1, paramInt2, this.bJG.bJq);
    AppMethodBeat.o(62271);
  }
  
  public void setAlignContent(int paramInt)
  {
    AppMethodBeat.i(62294);
    if (this.bJv != paramInt)
    {
      this.bJv = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62294);
  }
  
  public void setAlignItems(int paramInt)
  {
    AppMethodBeat.i(62293);
    if (this.bJu != paramInt)
    {
      this.bJu = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62293);
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(62302);
    setDividerDrawableHorizontal(paramDrawable);
    setDividerDrawableVertical(paramDrawable);
    AppMethodBeat.o(62302);
  }
  
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    AppMethodBeat.i(62303);
    if (paramDrawable == this.bJx)
    {
      AppMethodBeat.o(62303);
      return;
    }
    this.bJx = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bJB = paramDrawable.getIntrinsicHeight();; this.bJB = 0)
    {
      xL();
      requestLayout();
      AppMethodBeat.o(62303);
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(62304);
    if (paramDrawable == this.bJy)
    {
      AppMethodBeat.o(62304);
      return;
    }
    this.bJy = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bJC = paramDrawable.getIntrinsicWidth();; this.bJC = 0)
    {
      xL();
      requestLayout();
      AppMethodBeat.o(62304);
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62290);
    if (this.bJr != paramInt)
    {
      this.bJr = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62290);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bJp = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(62291);
    if (this.bJs != paramInt)
    {
      this.bJs = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62291);
  }
  
  public void setJustifyContent(int paramInt)
  {
    AppMethodBeat.i(62292);
    if (this.bJt != paramInt)
    {
      this.bJt = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62292);
  }
  
  public void setMaxLine(int paramInt)
  {
    AppMethodBeat.i(62295);
    if (this.bJw != paramInt)
    {
      this.bJw = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62295);
  }
  
  public void setShowDivider(int paramInt)
  {
    AppMethodBeat.i(62305);
    setShowDividerVertical(paramInt);
    setShowDividerHorizontal(paramInt);
    AppMethodBeat.o(62305);
  }
  
  public void setShowDividerHorizontal(int paramInt)
  {
    AppMethodBeat.i(62307);
    if (paramInt != this.bJz)
    {
      this.bJz = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62307);
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(62306);
    if (paramInt != this.bJA)
    {
      this.bJA = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62306);
  }
  
  public final int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62299);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62299);
    return paramInt1;
  }
  
  public final int u(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62300);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62300);
    return paramInt1;
  }
  
  public final boolean xC()
  {
    return (this.bJr == 0) || (this.bJr == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout
 * JD-Core Version:    0.7.0.1
 */