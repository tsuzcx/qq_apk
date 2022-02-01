package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.t;
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
  private List<b> bBd;
  private int bBf;
  private int bBg;
  private int bBh;
  private int bBi;
  private int bBj;
  private int bBk;
  private Drawable bBl;
  private Drawable bBm;
  private int bBn;
  private int bBo;
  private int bBp;
  private int bBq;
  private int[] bBr;
  private SparseIntArray bBs;
  private c bBt;
  private c.a bBu;
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62270);
    this.bBk = -1;
    this.bBt = new c(this);
    this.bBd = new ArrayList();
    this.bBu = new c.a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout, paramInt, 0);
    this.bBf = paramContext.getInt(5, 0);
    this.bBg = paramContext.getInt(6, 0);
    this.bBh = paramContext.getInt(7, 0);
    this.bBi = paramContext.getInt(1, 4);
    this.bBj = paramContext.getInt(0, 5);
    this.bBk = paramContext.getInt(8, -1);
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
      this.bBo = paramInt;
      this.bBn = paramInt;
    }
    paramInt = paramContext.getInt(11, 0);
    if (paramInt != 0) {
      this.bBo = paramInt;
    }
    paramInt = paramContext.getInt(10, 0);
    if (paramInt != 0) {
      this.bBn = paramInt;
    }
    paramContext.recycle();
    AppMethodBeat.o(62270);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62287);
    if (this.bBm == null)
    {
      AppMethodBeat.o(62287);
      return;
    }
    this.bBm.setBounds(paramInt1, paramInt2, this.bBq + paramInt1, paramInt2 + paramInt3);
    this.bBm.draw(paramCanvas);
    AppMethodBeat.o(62287);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62285);
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.bBd.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bBd.get(i);
      int j = 0;
      if (j < localb.ars)
      {
        int k = localb.bAX + j;
        View localView = fB(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bt(k, j))
          {
            if (!paramBoolean1) {
              break label240;
            }
            k = localView.getRight() + localLayoutParams.rightMargin;
            label154:
            a(paramCanvas, k, localb.xp, localb.bAQ);
          }
          if ((j == localb.ars - 1) && ((this.bBo & 0x4) > 0)) {
            if (!paramBoolean1) {
              break label261;
            }
          }
        }
        for (k = localView.getLeft() - localLayoutParams.leftMargin - this.bBq;; k = localLayoutParams.rightMargin + k)
        {
          a(paramCanvas, k, localb.xp, localb.bAQ);
          j += 1;
          break;
          label240:
          k = localView.getLeft() - localLayoutParams.leftMargin - this.bBq;
          break label154;
          label261:
          k = localView.getRight();
        }
      }
      if (fC(i))
      {
        if (paramBoolean2)
        {
          j = localb.xr;
          label301:
          b(paramCanvas, m, j, n);
        }
      }
      else if ((fE(i)) && ((this.bBn & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label381;
        }
      }
      label381:
      for (j = localb.xp - this.bBp;; j = localb.xr)
      {
        b(paramCanvas, m, j, n);
        i += 1;
        break;
        j = localb.xp - this.bBp;
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
    int i2 = this.bBd.size();
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
    LayoutParams localLayoutParams;
    int k;
    if (paramInt3 < i2)
    {
      localObject = (b)this.bBd.get(paramInt3);
      paramInt4 = paramInt1;
      i = paramInt2;
      if (fC(paramInt3))
      {
        i = paramInt2 + this.bBq;
        paramInt4 = paramInt1 - this.bBq;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bBh)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bBh);
        AppMethodBeat.o(62283);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).ars)
        {
          j = ((b)localObject).bAX + paramInt1;
          localView = fB(j);
          f2 = f3;
          f4 = f1;
          if (localView != null)
          {
            f2 = f3;
            f4 = f1;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)localView.getLayoutParams();
              f2 = f3 + localLayoutParams.topMargin;
              f1 -= localLayoutParams.bottomMargin;
              paramInt2 = 0;
              k = 0;
              if (!bt(j, paramInt1)) {
                break label932;
              }
              paramInt2 = this.bBp;
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
      if (paramInt1 == ((b)localObject).ars - 1)
      {
        j = k;
        if ((this.bBn & 0x4) > 0) {
          j = this.bBp;
        }
      }
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.bBt.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
          label442:
          f2 += localView.getMeasuredHeight() + f5 + localLayoutParams.bottomMargin;
          f1 -= localView.getMeasuredHeight() + f5 + localLayoutParams.topMargin;
          if (!paramBoolean2) {
            break label874;
          }
          ((b)localObject).m(localView, 0, j, 0, paramInt2);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        f3 = f2;
        break label231;
        f2 = i1 - ((b)localObject).bAO + n;
        f1 = ((b)localObject).bAO - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bAO) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bAO) / 2.0F;
        break;
        paramInt1 = ((b)localObject).wr();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bAO) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).wr();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bAO) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).wr();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bAO) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bBt.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        if (paramBoolean2)
        {
          this.bBt.a(localView, (b)localObject, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          break label442;
        }
        this.bBt.a(localView, (b)localObject, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        label874:
        ((b)localObject).m(localView, 0, paramInt2, 0, j);
        f4 = f1;
        f1 = f4;
      }
      paramInt2 = i + ((b)localObject).bAQ;
      paramInt1 = paramInt4 - ((b)localObject).bAQ;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62283);
      return;
    }
  }
  
  private void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62277);
    this.bBd.clear();
    this.bBu.reset();
    this.bBt.a(this.bBu, paramInt1, paramInt2, 2147483647, 0, -1, null);
    this.bBd = this.bBu.bBd;
    this.bBt.y(paramInt1, paramInt2, 0);
    if (this.bBi == 3)
    {
      Iterator localIterator = this.bBd.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        int j = 0;
        int k = -2147483648;
        if (j < localb.ars)
        {
          View localView = fB(localb.bAX + j);
          int i = k;
          LayoutParams localLayoutParams;
          int m;
          if (localView != null)
          {
            i = k;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)localView.getLayoutParams();
              if (this.bBg == 2) {
                break label229;
              }
              i = Math.max(localb.bAU - localView.getBaseline(), localLayoutParams.topMargin);
              m = localView.getMeasuredHeight();
            }
          }
          for (i = Math.max(k, localLayoutParams.bottomMargin + (m + i));; i = Math.max(k, localLayoutParams.topMargin + m + i))
          {
            j += 1;
            k = i;
            break;
            label229:
            i = Math.max(localb.bAU - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
            m = localView.getMeasuredHeight();
          }
        }
        localb.bAQ = k;
      }
    }
    this.bBt.z(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
    this.bBt.fx(0);
    o(this.bBf, paramInt1, paramInt2, this.bBu.bBe);
    AppMethodBeat.o(62277);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62288);
    if (this.bBl == null)
    {
      AppMethodBeat.o(62288);
      return;
    }
    this.bBl.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.bBp + paramInt2);
    this.bBl.draw(paramCanvas);
    AppMethodBeat.o(62288);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62286);
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.bBd.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bBd.get(i);
      int j = 0;
      if (j < localb.ars)
      {
        int k = localb.bAX + j;
        View localView = fB(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bt(k, j))
          {
            if (!paramBoolean2) {
              break label241;
            }
            k = localView.getBottom() + localLayoutParams.bottomMargin;
            label155:
            b(paramCanvas, localb.xo, k, localb.bAQ);
          }
          if ((j == localb.ars - 1) && ((this.bBn & 0x4) > 0)) {
            if (!paramBoolean2) {
              break label262;
            }
          }
        }
        for (k = localView.getTop() - localLayoutParams.topMargin - this.bBp;; k = localLayoutParams.bottomMargin + k)
        {
          b(paramCanvas, localb.xo, k, localb.bAQ);
          j += 1;
          break;
          label241:
          k = localView.getTop() - localLayoutParams.topMargin - this.bBp;
          break label155;
          label262:
          k = localView.getBottom();
        }
      }
      if (fC(i))
      {
        if (paramBoolean1)
        {
          j = localb.xq;
          label302:
          a(paramCanvas, j, m, n);
        }
      }
      else if ((fE(i)) && ((this.bBo & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label382;
        }
      }
      label382:
      for (j = localb.xo - this.bBq;; j = localb.xq)
      {
        a(paramCanvas, j, m, n);
        i += 1;
        break;
        j = localb.xo - this.bBq;
        break label302;
      }
    }
    AppMethodBeat.o(62286);
  }
  
  private boolean bt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62309);
    if (bu(paramInt1, paramInt2))
    {
      if (wk())
      {
        if ((this.bBo & 0x1) != 0)
        {
          AppMethodBeat.o(62309);
          return true;
        }
        AppMethodBeat.o(62309);
        return false;
      }
      if ((this.bBn & 0x1) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if (wk())
    {
      if ((this.bBo & 0x2) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if ((this.bBn & 0x2) != 0)
    {
      AppMethodBeat.o(62309);
      return true;
    }
    AppMethodBeat.o(62309);
    return false;
  }
  
  private boolean bu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62310);
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = fB(paramInt1 - i);
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
  
  private void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62282);
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2 - getPaddingBottom();
    paramInt1 = getPaddingTop();
    int i2 = this.bBd.size();
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
    LayoutParams localLayoutParams;
    int k;
    if (paramInt3 < i2)
    {
      localObject = (b)this.bBd.get(paramInt3);
      paramInt4 = paramInt2;
      i = paramInt1;
      if (fC(paramInt3))
      {
        paramInt4 = paramInt2 - this.bBp;
        i = paramInt1 + this.bBp;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bBh)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bBh);
        AppMethodBeat.o(62282);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).ars)
        {
          j = ((b)localObject).bAX + paramInt1;
          localView = fB(j);
          f2 = f3;
          f4 = f1;
          if (localView != null)
          {
            f2 = f3;
            f4 = f1;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)localView.getLayoutParams();
              f2 = f3 + localLayoutParams.leftMargin;
              f1 -= localLayoutParams.rightMargin;
              paramInt2 = 0;
              k = 0;
              if (!bt(j, paramInt1)) {
                break label919;
              }
              paramInt2 = this.bBq;
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
      if (paramInt1 == ((b)localObject).ars - 1)
      {
        j = k;
        if ((this.bBo & 0x4) > 0) {
          j = this.bBq;
        }
      }
      if (this.bBg == 2) {
        if (paramBoolean)
        {
          this.bBt.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), paramInt4 - localView.getMeasuredHeight(), Math.round(f1), paramInt4);
          label434:
          f2 += localView.getMeasuredWidth() + f5 + localLayoutParams.rightMargin;
          f1 -= localView.getMeasuredWidth() + f5 + localLayoutParams.leftMargin;
          if (!paramBoolean) {
            break label862;
          }
          ((b)localObject).m(localView, j, 0, paramInt2, 0);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        f3 = f2;
        break label224;
        f2 = i1 - ((b)localObject).bAO + n;
        f1 = ((b)localObject).bAO - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bAO) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bAO) / 2.0F;
        break;
        paramInt1 = ((b)localObject).wr();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bAO) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).wr();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bAO) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).wr();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bAO) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bBt.a(localView, (b)localObject, Math.round(f2), paramInt4 - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), paramInt4);
        break label434;
        if (paramBoolean)
        {
          this.bBt.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), i, Math.round(f1), i + localView.getMeasuredHeight());
          break label434;
        }
        this.bBt.a(localView, (b)localObject, Math.round(f2), i, Math.round(f2) + localView.getMeasuredWidth(), i + localView.getMeasuredHeight());
        break label434;
        label862:
        ((b)localObject).m(localView, paramInt2, 0, j, 0);
        f4 = f1;
        f1 = f4;
      }
      paramInt1 = i + ((b)localObject).bAQ;
      paramInt2 = paramInt4 - ((b)localObject).bAQ;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62282);
      return;
    }
  }
  
  private View fB(int paramInt)
  {
    AppMethodBeat.i(62274);
    if ((paramInt < 0) || (paramInt >= this.bBr.length))
    {
      AppMethodBeat.o(62274);
      return null;
    }
    View localView = getChildAt(this.bBr[paramInt]);
    AppMethodBeat.o(62274);
    return localView;
  }
  
  private boolean fC(int paramInt)
  {
    AppMethodBeat.i(62311);
    if ((paramInt < 0) || (paramInt >= this.bBd.size()))
    {
      AppMethodBeat.o(62311);
      return false;
    }
    if (fD(paramInt))
    {
      if (wk())
      {
        if ((this.bBn & 0x1) != 0)
        {
          AppMethodBeat.o(62311);
          return true;
        }
        AppMethodBeat.o(62311);
        return false;
      }
      if ((this.bBo & 0x1) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if (wk())
    {
      if ((this.bBn & 0x2) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if ((this.bBo & 0x2) != 0)
    {
      AppMethodBeat.o(62311);
      return true;
    }
    AppMethodBeat.o(62311);
    return false;
  }
  
  private boolean fD(int paramInt)
  {
    AppMethodBeat.i(62312);
    int i = 0;
    while (i < paramInt)
    {
      if (((b)this.bBd.get(i)).wr() > 0)
      {
        AppMethodBeat.o(62312);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(62312);
    return true;
  }
  
  private boolean fE(int paramInt)
  {
    AppMethodBeat.i(62313);
    if ((paramInt < 0) || (paramInt >= this.bBd.size()))
    {
      AppMethodBeat.o(62313);
      return false;
    }
    paramInt += 1;
    while (paramInt < this.bBd.size())
    {
      if (((b)this.bBd.get(paramInt)).wr() > 0)
      {
        AppMethodBeat.o(62313);
        return false;
      }
      paramInt += 1;
    }
    if (wk())
    {
      if ((this.bBn & 0x4) != 0)
      {
        AppMethodBeat.o(62313);
        return true;
      }
      AppMethodBeat.o(62313);
      return false;
    }
    if ((this.bBo & 0x4) != 0)
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
  
  private void wt()
  {
    AppMethodBeat.i(62308);
    if ((this.bBl == null) && (this.bBm == null))
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
    if (bt(paramInt1, paramInt2))
    {
      if (wk())
      {
        paramb.bAO += this.bBq;
        paramb.bAP += this.bBq;
        AppMethodBeat.o(62301);
        return;
      }
      paramb.bAO += this.bBp;
      paramb.bAP += this.bBp;
    }
    AppMethodBeat.o(62301);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(62298);
    if (wk())
    {
      if ((this.bBo & 0x4) > 0)
      {
        paramb.bAO += this.bBq;
        paramb.bAP += this.bBq;
        AppMethodBeat.o(62298);
      }
    }
    else if ((this.bBn & 0x4) > 0)
    {
      paramb.bAO += this.bBp;
      paramb.bAP += this.bBp;
    }
    AppMethodBeat.o(62298);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62276);
    if (this.bBs == null) {
      this.bBs = new SparseIntArray(getChildCount());
    }
    this.bBr = this.bBt.a(paramView, paramInt, paramLayoutParams, this.bBs);
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(62276);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final int cj(View paramView)
  {
    return 0;
  }
  
  public final View ft(int paramInt)
  {
    AppMethodBeat.i(62273);
    View localView = getChildAt(paramInt);
    AppMethodBeat.o(62273);
    return localView;
  }
  
  public final View fu(int paramInt)
  {
    AppMethodBeat.i(62275);
    View localView = fB(paramInt);
    AppMethodBeat.o(62275);
    return localView;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62289);
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      AppMethodBeat.o(62289);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(62289);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(62289);
    return paramLayoutParams;
  }
  
  public int getAlignContent()
  {
    return this.bBj;
  }
  
  public int getAlignItems()
  {
    return this.bBi;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.bBl;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.bBm;
  }
  
  public int getFlexDirection()
  {
    return this.bBf;
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
    ArrayList localArrayList = new ArrayList(this.bBd.size());
    Iterator localIterator = this.bBd.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.wr() != 0) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(62296);
    return localArrayList;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bBd;
  }
  
  public int getFlexWrap()
  {
    return this.bBg;
  }
  
  public int getJustifyContent()
  {
    return this.bBh;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62279);
    Iterator localIterator = this.bBd.iterator();
    for (int i = -2147483648; localIterator.hasNext(); i = Math.max(i, ((b)localIterator.next()).bAO)) {}
    AppMethodBeat.o(62279);
    return i;
  }
  
  public int getMaxLine()
  {
    return this.bBk;
  }
  
  public int getShowDividerHorizontal()
  {
    return this.bBn;
  }
  
  public int getShowDividerVertical()
  {
    return this.bBo;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62280);
    int m = this.bBd.size();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      b localb = (b)this.bBd.get(k);
      int i = j;
      if (fC(k))
      {
        if (wk()) {
          i = j + this.bBp;
        }
      }
      else
      {
        label66:
        j = i;
        if (fE(k)) {
          if (!wk()) {
            break label115;
          }
        }
      }
      label115:
      for (j = i + this.bBp;; j = i + this.bBq)
      {
        j += localb.bAQ;
        k += 1;
        break;
        i = j + this.bBq;
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
    if (wk())
    {
      if (bt(paramInt1, paramInt2)) {
        i = this.bBq + 0;
      }
      paramInt1 = i;
      if ((this.bBo & 0x4) > 0) {
        paramInt1 = i + this.bBq;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62297);
      return paramInt1;
      i = j;
      if (bt(paramInt1, paramInt2)) {
        i = this.bBp + 0;
      }
      paramInt1 = i;
      if ((this.bBn & 0x4) > 0) {
        paramInt1 = i + this.bBp;
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
    if ((this.bBm == null) && (this.bBl == null))
    {
      AppMethodBeat.o(62284);
      return;
    }
    if ((this.bBn == 0) && (this.bBo == 0))
    {
      AppMethodBeat.o(62284);
      return;
    }
    int i = t.Y(this);
    boolean bool1;
    switch (this.bBf)
    {
    default: 
      AppMethodBeat.o(62284);
      return;
    case 0: 
      if (i == 1)
      {
        bool1 = true;
        label114:
        if (this.bBg != 2) {
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
        if (this.bBg != 2) {
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
          if (this.bBg != 2) {
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
            if (this.bBg != 2) {
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
    int i = t.Y(this);
    switch (this.bBf)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.bBf);
      AppMethodBeat.o(62281);
      throw localIllegalStateException;
    case 0: 
      if (i == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(62281);
        return;
      }
    case 1: 
      if (i != 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(62281);
        return;
      }
    case 2: 
      if (i == 1)
      {
        paramBoolean = true;
        if (this.bBg != 2) {
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
        if (this.bBg != 2) {
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
    if (this.bBs == null) {
      this.bBs = new SparseIntArray(getChildCount());
    }
    if (this.bBt.b(this.bBs)) {
      this.bBr = this.bBt.a(this.bBs);
    }
    switch (this.bBf)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.bBf);
      AppMethodBeat.o(62271);
      throw localIllegalStateException;
    case 0: 
    case 1: 
      ac(paramInt1, paramInt2);
      AppMethodBeat.o(62271);
      return;
    }
    this.bBd.clear();
    this.bBu.reset();
    this.bBt.a(this.bBu, paramInt1, paramInt2);
    this.bBd = this.bBu.bBd;
    this.bBt.br(paramInt1, paramInt2);
    this.bBt.z(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.bBt.ws();
    o(this.bBf, paramInt1, paramInt2, this.bBu.bBe);
    AppMethodBeat.o(62271);
  }
  
  public void setAlignContent(int paramInt)
  {
    AppMethodBeat.i(62294);
    if (this.bBj != paramInt)
    {
      this.bBj = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62294);
  }
  
  public void setAlignItems(int paramInt)
  {
    AppMethodBeat.i(62293);
    if (this.bBi != paramInt)
    {
      this.bBi = paramInt;
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
    if (paramDrawable == this.bBl)
    {
      AppMethodBeat.o(62303);
      return;
    }
    this.bBl = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bBp = paramDrawable.getIntrinsicHeight();; this.bBp = 0)
    {
      wt();
      requestLayout();
      AppMethodBeat.o(62303);
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(62304);
    if (paramDrawable == this.bBm)
    {
      AppMethodBeat.o(62304);
      return;
    }
    this.bBm = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bBq = paramDrawable.getIntrinsicWidth();; this.bBq = 0)
    {
      wt();
      requestLayout();
      AppMethodBeat.o(62304);
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62290);
    if (this.bBf != paramInt)
    {
      this.bBf = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62290);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bBd = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(62291);
    if (this.bBg != paramInt)
    {
      this.bBg = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62291);
  }
  
  public void setJustifyContent(int paramInt)
  {
    AppMethodBeat.i(62292);
    if (this.bBh != paramInt)
    {
      this.bBh = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62292);
  }
  
  public void setMaxLine(int paramInt)
  {
    AppMethodBeat.i(62295);
    if (this.bBk != paramInt)
    {
      this.bBk = paramInt;
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
    if (paramInt != this.bBn)
    {
      this.bBn = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62307);
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(62306);
    if (paramInt != this.bBo)
    {
      this.bBo = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62306);
  }
  
  public final int w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62299);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62299);
    return paramInt1;
  }
  
  public final boolean wk()
  {
    return (this.bBf == 0) || (this.bBf == 1);
  }
  
  public final int x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62300);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62300);
    return paramInt1;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private boolean bBA;
    private int bBv;
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
      AppMethodBeat.i(62269);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(62269);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(62266);
      this.bBv = 1;
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout_Layout);
      this.bBv = paramContext.getInt(8, 1);
      this.bBw = paramContext.getFloat(2, 0.0F);
      this.bBx = paramContext.getFloat(3, 1.0F);
      this.bBy = paramContext.getInt(0, -1);
      this.bBz = paramContext.getFraction(1, 1, 1, -1.0F);
      this.mMinWidth = paramContext.getDimensionPixelSize(7, 0);
      this.mMinHeight = paramContext.getDimensionPixelSize(6, 0);
      this.mMaxWidth = paramContext.getDimensionPixelSize(5, 16777215);
      this.mMaxHeight = paramContext.getDimensionPixelSize(4, 16777215);
      this.bBA = paramContext.getBoolean(9, false);
      paramContext.recycle();
      AppMethodBeat.o(62266);
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(0);
      AppMethodBeat.i(62268);
      this.bBv = 1;
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bBv = paramParcel.readInt();
      this.bBw = paramParcel.readFloat();
      this.bBx = paramParcel.readFloat();
      this.bBy = paramParcel.readInt();
      this.bBz = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.bBA = bool;
        this.bottomMargin = paramParcel.readInt();
        this.leftMargin = paramParcel.readInt();
        this.rightMargin = paramParcel.readInt();
        this.topMargin = paramParcel.readInt();
        this.height = paramParcel.readInt();
        this.width = paramParcel.readInt();
        AppMethodBeat.o(62268);
        return;
        bool = false;
      }
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.bBv = 1;
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.bBv = 1;
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.bBv = 1;
      this.bBw = 0.0F;
      this.bBx = 1.0F;
      this.bBy = -1;
      this.bBz = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bBv = paramLayoutParams.bBv;
      this.bBw = paramLayoutParams.bBw;
      this.bBx = paramLayoutParams.bBx;
      this.bBy = paramLayoutParams.bBy;
      this.bBz = paramLayoutParams.bBz;
      this.mMinWidth = paramLayoutParams.mMinWidth;
      this.mMinHeight = paramLayoutParams.mMinHeight;
      this.mMaxWidth = paramLayoutParams.mMaxWidth;
      this.mMaxHeight = paramLayoutParams.mMaxHeight;
      this.bBA = paramLayoutParams.bBA;
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
      return this.bBv;
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
      AppMethodBeat.i(62267);
      paramParcel.writeInt(this.bBv);
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
        AppMethodBeat.o(62267);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout
 * JD-Core Version:    0.7.0.1
 */