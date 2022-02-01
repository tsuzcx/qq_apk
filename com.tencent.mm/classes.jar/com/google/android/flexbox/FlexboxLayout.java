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
  private List<b> bIZ;
  private int bJb;
  private int bJc;
  private int bJd;
  private int bJe;
  private int bJf;
  private int bJg;
  private Drawable bJh;
  private Drawable bJi;
  private int bJj;
  private int bJk;
  private int bJl;
  private int bJm;
  private int[] bJn;
  private SparseIntArray bJo;
  private c bJp;
  private c.a bJq;
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62270);
    this.bJg = -1;
    this.bJp = new c(this);
    this.bIZ = new ArrayList();
    this.bJq = new c.a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout, paramInt, 0);
    this.bJb = paramContext.getInt(5, 0);
    this.bJc = paramContext.getInt(6, 0);
    this.bJd = paramContext.getInt(7, 0);
    this.bJe = paramContext.getInt(1, 4);
    this.bJf = paramContext.getInt(0, 5);
    this.bJg = paramContext.getInt(8, -1);
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
      this.bJk = paramInt;
      this.bJj = paramInt;
    }
    paramInt = paramContext.getInt(11, 0);
    if (paramInt != 0) {
      this.bJk = paramInt;
    }
    paramInt = paramContext.getInt(10, 0);
    if (paramInt != 0) {
      this.bJj = paramInt;
    }
    paramContext.recycle();
    AppMethodBeat.o(62270);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62287);
    if (this.bJi == null)
    {
      AppMethodBeat.o(62287);
      return;
    }
    this.bJi.setBounds(paramInt1, paramInt2, this.bJm + paramInt1, paramInt2 + paramInt3);
    this.bJi.draw(paramCanvas);
    AppMethodBeat.o(62287);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62285);
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.bIZ.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bIZ.get(i);
      int j = 0;
      if (j < localb.aue)
      {
        int k = localb.bIT + j;
        View localView = fq(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bs(k, j))
          {
            if (!paramBoolean1) {
              break label240;
            }
            k = localView.getRight() + localLayoutParams.rightMargin;
            label154:
            a(paramCanvas, k, localb.Ag, localb.bIM);
          }
          if ((j == localb.aue - 1) && ((this.bJk & 0x4) > 0)) {
            if (!paramBoolean1) {
              break label261;
            }
          }
        }
        for (k = localView.getLeft() - localLayoutParams.leftMargin - this.bJm;; k = localLayoutParams.rightMargin + k)
        {
          a(paramCanvas, k, localb.Ag, localb.bIM);
          j += 1;
          break;
          label240:
          k = localView.getLeft() - localLayoutParams.leftMargin - this.bJm;
          break label154;
          label261:
          k = localView.getRight();
        }
      }
      if (fr(i))
      {
        if (paramBoolean2)
        {
          j = localb.Ai;
          label301:
          b(paramCanvas, m, j, n);
        }
      }
      else if ((ft(i)) && ((this.bJj & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label381;
        }
      }
      label381:
      for (j = localb.Ag - this.bJl;; j = localb.Ai)
      {
        b(paramCanvas, m, j, n);
        i += 1;
        break;
        j = localb.Ag - this.bJl;
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
    int i2 = this.bIZ.size();
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
      localObject = (b)this.bIZ.get(paramInt3);
      paramInt4 = paramInt1;
      i = paramInt2;
      if (fr(paramInt3))
      {
        i = paramInt2 + this.bJm;
        paramInt4 = paramInt1 - this.bJm;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bJd)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bJd);
        AppMethodBeat.o(62283);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).aue)
        {
          j = ((b)localObject).bIT + paramInt1;
          localView = fq(j);
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
              if (!bs(j, paramInt1)) {
                break label932;
              }
              paramInt2 = this.bJl;
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
      if (paramInt1 == ((b)localObject).aue - 1)
      {
        j = k;
        if ((this.bJj & 0x4) > 0) {
          j = this.bJl;
        }
      }
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.bJp.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
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
        f2 = i1 - ((b)localObject).bIK + n;
        f1 = ((b)localObject).bIK - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bIK) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bIK) / 2.0F;
        break;
        paramInt1 = ((b)localObject).xB();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bIK) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).xB();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bIK) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).xB();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bIK) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bJp.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        if (paramBoolean2)
        {
          this.bJp.a(localView, (b)localObject, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          break label442;
        }
        this.bJp.a(localView, (b)localObject, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        label874:
        ((b)localObject).m(localView, 0, paramInt2, 0, j);
        f4 = f1;
        f1 = f4;
      }
      paramInt2 = i + ((b)localObject).bIM;
      paramInt1 = paramInt4 - ((b)localObject).bIM;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62283);
      return;
    }
  }
  
  private void ad(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62277);
    this.bIZ.clear();
    this.bJq.reset();
    this.bJp.a(this.bJq, paramInt1, paramInt2, 2147483647, 0, -1, null);
    this.bIZ = this.bJq.bIZ;
    this.bJp.y(paramInt1, paramInt2, 0);
    if (this.bJe == 3)
    {
      Iterator localIterator = this.bIZ.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        int j = 0;
        int k = -2147483648;
        if (j < localb.aue)
        {
          View localView = fq(localb.bIT + j);
          int i = k;
          LayoutParams localLayoutParams;
          int m;
          if (localView != null)
          {
            i = k;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)localView.getLayoutParams();
              if (this.bJc == 2) {
                break label229;
              }
              i = Math.max(localb.bIQ - localView.getBaseline(), localLayoutParams.topMargin);
              m = localView.getMeasuredHeight();
            }
          }
          for (i = Math.max(k, localLayoutParams.bottomMargin + (m + i));; i = Math.max(k, localLayoutParams.topMargin + m + i))
          {
            j += 1;
            k = i;
            break;
            label229:
            i = Math.max(localb.bIQ - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
            m = localView.getMeasuredHeight();
          }
        }
        localb.bIM = k;
      }
    }
    this.bJp.z(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
    this.bJp.fm(0);
    o(this.bJb, paramInt1, paramInt2, this.bJq.bJa);
    AppMethodBeat.o(62277);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62288);
    if (this.bJh == null)
    {
      AppMethodBeat.o(62288);
      return;
    }
    this.bJh.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.bJl + paramInt2);
    this.bJh.draw(paramCanvas);
    AppMethodBeat.o(62288);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62286);
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.bIZ.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bIZ.get(i);
      int j = 0;
      if (j < localb.aue)
      {
        int k = localb.bIT + j;
        View localView = fq(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bs(k, j))
          {
            if (!paramBoolean2) {
              break label241;
            }
            k = localView.getBottom() + localLayoutParams.bottomMargin;
            label155:
            b(paramCanvas, localb.Af, k, localb.bIM);
          }
          if ((j == localb.aue - 1) && ((this.bJj & 0x4) > 0)) {
            if (!paramBoolean2) {
              break label262;
            }
          }
        }
        for (k = localView.getTop() - localLayoutParams.topMargin - this.bJl;; k = localLayoutParams.bottomMargin + k)
        {
          b(paramCanvas, localb.Af, k, localb.bIM);
          j += 1;
          break;
          label241:
          k = localView.getTop() - localLayoutParams.topMargin - this.bJl;
          break label155;
          label262:
          k = localView.getBottom();
        }
      }
      if (fr(i))
      {
        if (paramBoolean1)
        {
          j = localb.Ah;
          label302:
          a(paramCanvas, j, m, n);
        }
      }
      else if ((ft(i)) && ((this.bJk & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label382;
        }
      }
      label382:
      for (j = localb.Af - this.bJm;; j = localb.Ah)
      {
        a(paramCanvas, j, m, n);
        i += 1;
        break;
        j = localb.Af - this.bJm;
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
    int i2 = this.bIZ.size();
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
      localObject = (b)this.bIZ.get(paramInt3);
      paramInt4 = paramInt2;
      i = paramInt1;
      if (fr(paramInt3))
      {
        paramInt4 = paramInt2 - this.bJl;
        i = paramInt1 + this.bJl;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bJd)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bJd);
        AppMethodBeat.o(62282);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).aue)
        {
          j = ((b)localObject).bIT + paramInt1;
          localView = fq(j);
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
              if (!bs(j, paramInt1)) {
                break label919;
              }
              paramInt2 = this.bJm;
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
      if (paramInt1 == ((b)localObject).aue - 1)
      {
        j = k;
        if ((this.bJk & 0x4) > 0) {
          j = this.bJm;
        }
      }
      if (this.bJc == 2) {
        if (paramBoolean)
        {
          this.bJp.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), paramInt4 - localView.getMeasuredHeight(), Math.round(f1), paramInt4);
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
        f2 = i1 - ((b)localObject).bIK + n;
        f1 = ((b)localObject).bIK - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bIK) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bIK) / 2.0F;
        break;
        paramInt1 = ((b)localObject).xB();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bIK) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).xB();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bIK) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).xB();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bIK) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bJp.a(localView, (b)localObject, Math.round(f2), paramInt4 - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), paramInt4);
        break label434;
        if (paramBoolean)
        {
          this.bJp.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), i, Math.round(f1), i + localView.getMeasuredHeight());
          break label434;
        }
        this.bJp.a(localView, (b)localObject, Math.round(f2), i, Math.round(f2) + localView.getMeasuredWidth(), i + localView.getMeasuredHeight());
        break label434;
        label862:
        ((b)localObject).m(localView, paramInt2, 0, j, 0);
        f4 = f1;
        f1 = f4;
      }
      paramInt1 = i + ((b)localObject).bIM;
      paramInt2 = paramInt4 - ((b)localObject).bIM;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62282);
      return;
    }
  }
  
  private boolean bs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62309);
    if (bt(paramInt1, paramInt2))
    {
      if (xu())
      {
        if ((this.bJk & 0x1) != 0)
        {
          AppMethodBeat.o(62309);
          return true;
        }
        AppMethodBeat.o(62309);
        return false;
      }
      if ((this.bJj & 0x1) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if (xu())
    {
      if ((this.bJk & 0x2) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if ((this.bJj & 0x2) != 0)
    {
      AppMethodBeat.o(62309);
      return true;
    }
    AppMethodBeat.o(62309);
    return false;
  }
  
  private boolean bt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62310);
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = fq(paramInt1 - i);
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
  
  private View fq(int paramInt)
  {
    AppMethodBeat.i(62274);
    if ((paramInt < 0) || (paramInt >= this.bJn.length))
    {
      AppMethodBeat.o(62274);
      return null;
    }
    View localView = getChildAt(this.bJn[paramInt]);
    AppMethodBeat.o(62274);
    return localView;
  }
  
  private boolean fr(int paramInt)
  {
    AppMethodBeat.i(62311);
    if ((paramInt < 0) || (paramInt >= this.bIZ.size()))
    {
      AppMethodBeat.o(62311);
      return false;
    }
    if (fs(paramInt))
    {
      if (xu())
      {
        if ((this.bJj & 0x1) != 0)
        {
          AppMethodBeat.o(62311);
          return true;
        }
        AppMethodBeat.o(62311);
        return false;
      }
      if ((this.bJk & 0x1) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if (xu())
    {
      if ((this.bJj & 0x2) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if ((this.bJk & 0x2) != 0)
    {
      AppMethodBeat.o(62311);
      return true;
    }
    AppMethodBeat.o(62311);
    return false;
  }
  
  private boolean fs(int paramInt)
  {
    AppMethodBeat.i(62312);
    int i = 0;
    while (i < paramInt)
    {
      if (((b)this.bIZ.get(i)).xB() > 0)
      {
        AppMethodBeat.o(62312);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(62312);
    return true;
  }
  
  private boolean ft(int paramInt)
  {
    AppMethodBeat.i(62313);
    if ((paramInt < 0) || (paramInt >= this.bIZ.size()))
    {
      AppMethodBeat.o(62313);
      return false;
    }
    paramInt += 1;
    while (paramInt < this.bIZ.size())
    {
      if (((b)this.bIZ.get(paramInt)).xB() > 0)
      {
        AppMethodBeat.o(62313);
        return false;
      }
      paramInt += 1;
    }
    if (xu())
    {
      if ((this.bJj & 0x4) != 0)
      {
        AppMethodBeat.o(62313);
        return true;
      }
      AppMethodBeat.o(62313);
      return false;
    }
    if ((this.bJk & 0x4) != 0)
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
  
  private void xD()
  {
    AppMethodBeat.i(62308);
    if ((this.bJh == null) && (this.bJi == null))
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
    if (bs(paramInt1, paramInt2))
    {
      if (xu())
      {
        paramb.bIK += this.bJm;
        paramb.bIL += this.bJm;
        AppMethodBeat.o(62301);
        return;
      }
      paramb.bIK += this.bJl;
      paramb.bIL += this.bJl;
    }
    AppMethodBeat.o(62301);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(62298);
    if (xu())
    {
      if ((this.bJk & 0x4) > 0)
      {
        paramb.bIK += this.bJm;
        paramb.bIL += this.bJm;
        AppMethodBeat.o(62298);
      }
    }
    else if ((this.bJj & 0x4) > 0)
    {
      paramb.bIK += this.bJl;
      paramb.bIL += this.bJl;
    }
    AppMethodBeat.o(62298);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62276);
    if (this.bJo == null) {
      this.bJo = new SparseIntArray(getChildCount());
    }
    this.bJn = this.bJp.a(paramView, paramInt, paramLayoutParams, this.bJo);
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
  
  public final View fi(int paramInt)
  {
    AppMethodBeat.i(62273);
    View localView = getChildAt(paramInt);
    AppMethodBeat.o(62273);
    return localView;
  }
  
  public final View fj(int paramInt)
  {
    AppMethodBeat.i(62275);
    View localView = fq(paramInt);
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
    return this.bJf;
  }
  
  public int getAlignItems()
  {
    return this.bJe;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.bJh;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.bJi;
  }
  
  public int getFlexDirection()
  {
    return this.bJb;
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
    ArrayList localArrayList = new ArrayList(this.bIZ.size());
    Iterator localIterator = this.bIZ.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.xB() != 0) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(62296);
    return localArrayList;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bIZ;
  }
  
  public int getFlexWrap()
  {
    return this.bJc;
  }
  
  public int getJustifyContent()
  {
    return this.bJd;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62279);
    Iterator localIterator = this.bIZ.iterator();
    for (int i = -2147483648; localIterator.hasNext(); i = Math.max(i, ((b)localIterator.next()).bIK)) {}
    AppMethodBeat.o(62279);
    return i;
  }
  
  public int getMaxLine()
  {
    return this.bJg;
  }
  
  public int getShowDividerHorizontal()
  {
    return this.bJj;
  }
  
  public int getShowDividerVertical()
  {
    return this.bJk;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62280);
    int m = this.bIZ.size();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      b localb = (b)this.bIZ.get(k);
      int i = j;
      if (fr(k))
      {
        if (xu()) {
          i = j + this.bJl;
        }
      }
      else
      {
        label66:
        j = i;
        if (ft(k)) {
          if (!xu()) {
            break label115;
          }
        }
      }
      label115:
      for (j = i + this.bJl;; j = i + this.bJm)
      {
        j += localb.bIM;
        k += 1;
        break;
        i = j + this.bJm;
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
    if (xu())
    {
      if (bs(paramInt1, paramInt2)) {
        i = this.bJm + 0;
      }
      paramInt1 = i;
      if ((this.bJk & 0x4) > 0) {
        paramInt1 = i + this.bJm;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62297);
      return paramInt1;
      i = j;
      if (bs(paramInt1, paramInt2)) {
        i = this.bJl + 0;
      }
      paramInt1 = i;
      if ((this.bJj & 0x4) > 0) {
        paramInt1 = i + this.bJl;
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
    if ((this.bJi == null) && (this.bJh == null))
    {
      AppMethodBeat.o(62284);
      return;
    }
    if ((this.bJj == 0) && (this.bJk == 0))
    {
      AppMethodBeat.o(62284);
      return;
    }
    int i = t.Y(this);
    boolean bool1;
    switch (this.bJb)
    {
    default: 
      AppMethodBeat.o(62284);
      return;
    case 0: 
      if (i == 1)
      {
        bool1 = true;
        label114:
        if (this.bJc != 2) {
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
        if (this.bJc != 2) {
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
          if (this.bJc != 2) {
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
            if (this.bJc != 2) {
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
    switch (this.bJb)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.bJb);
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
        if (this.bJc != 2) {
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
        if (this.bJc != 2) {
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
    if (this.bJo == null) {
      this.bJo = new SparseIntArray(getChildCount());
    }
    if (this.bJp.b(this.bJo)) {
      this.bJn = this.bJp.a(this.bJo);
    }
    switch (this.bJb)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.bJb);
      AppMethodBeat.o(62271);
      throw localIllegalStateException;
    case 0: 
    case 1: 
      ad(paramInt1, paramInt2);
      AppMethodBeat.o(62271);
      return;
    }
    this.bIZ.clear();
    this.bJq.reset();
    this.bJp.a(this.bJq, paramInt1, paramInt2);
    this.bIZ = this.bJq.bIZ;
    this.bJp.bq(paramInt1, paramInt2);
    this.bJp.z(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.bJp.xC();
    o(this.bJb, paramInt1, paramInt2, this.bJq.bJa);
    AppMethodBeat.o(62271);
  }
  
  public void setAlignContent(int paramInt)
  {
    AppMethodBeat.i(62294);
    if (this.bJf != paramInt)
    {
      this.bJf = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62294);
  }
  
  public void setAlignItems(int paramInt)
  {
    AppMethodBeat.i(62293);
    if (this.bJe != paramInt)
    {
      this.bJe = paramInt;
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
    if (paramDrawable == this.bJh)
    {
      AppMethodBeat.o(62303);
      return;
    }
    this.bJh = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bJl = paramDrawable.getIntrinsicHeight();; this.bJl = 0)
    {
      xD();
      requestLayout();
      AppMethodBeat.o(62303);
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(62304);
    if (paramDrawable == this.bJi)
    {
      AppMethodBeat.o(62304);
      return;
    }
    this.bJi = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bJm = paramDrawable.getIntrinsicWidth();; this.bJm = 0)
    {
      xD();
      requestLayout();
      AppMethodBeat.o(62304);
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62290);
    if (this.bJb != paramInt)
    {
      this.bJb = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62290);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bIZ = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(62291);
    if (this.bJc != paramInt)
    {
      this.bJc = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62291);
  }
  
  public void setJustifyContent(int paramInt)
  {
    AppMethodBeat.i(62292);
    if (this.bJd != paramInt)
    {
      this.bJd = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62292);
  }
  
  public void setMaxLine(int paramInt)
  {
    AppMethodBeat.i(62295);
    if (this.bJg != paramInt)
    {
      this.bJg = paramInt;
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
    if (paramInt != this.bJj)
    {
      this.bJj = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62307);
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(62306);
    if (paramInt != this.bJk)
    {
      this.bJk = paramInt;
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
  
  public final int x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62300);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62300);
    return paramInt1;
  }
  
  public final boolean xu()
  {
    return (this.bJb == 0) || (this.bJb == 1);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private int bJr;
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
      AppMethodBeat.i(62269);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(62269);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(62266);
      this.bJr = 1;
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout_Layout);
      this.bJr = paramContext.getInt(8, 1);
      this.bJs = paramContext.getFloat(2, 0.0F);
      this.bJt = paramContext.getFloat(3, 1.0F);
      this.bJu = paramContext.getInt(0, -1);
      this.bJv = paramContext.getFraction(1, 1, 1, -1.0F);
      this.mMinWidth = paramContext.getDimensionPixelSize(7, 0);
      this.mMinHeight = paramContext.getDimensionPixelSize(6, 0);
      this.mMaxWidth = paramContext.getDimensionPixelSize(5, 16777215);
      this.mMaxHeight = paramContext.getDimensionPixelSize(4, 16777215);
      this.bJw = paramContext.getBoolean(9, false);
      paramContext.recycle();
      AppMethodBeat.o(62266);
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(0);
      AppMethodBeat.i(62268);
      this.bJr = 1;
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bJr = paramParcel.readInt();
      this.bJs = paramParcel.readFloat();
      this.bJt = paramParcel.readFloat();
      this.bJu = paramParcel.readInt();
      this.bJv = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.bJw = bool;
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
      this.bJr = 1;
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.bJr = 1;
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.bJr = 1;
      this.bJs = 0.0F;
      this.bJt = 1.0F;
      this.bJu = -1;
      this.bJv = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bJr = paramLayoutParams.bJr;
      this.bJs = paramLayoutParams.bJs;
      this.bJt = paramLayoutParams.bJt;
      this.bJu = paramLayoutParams.bJu;
      this.bJv = paramLayoutParams.bJv;
      this.mMinWidth = paramLayoutParams.mMinWidth;
      this.mMinHeight = paramLayoutParams.mMinHeight;
      this.mMaxWidth = paramLayoutParams.mMaxWidth;
      this.mMaxHeight = paramLayoutParams.mMaxHeight;
      this.bJw = paramLayoutParams.bJw;
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
      return this.bJr;
    }
    
    public final int getWidth()
    {
      return this.width;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(62267);
      paramParcel.writeInt(this.bJr);
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
        AppMethodBeat.o(62267);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout
 * JD-Core Version:    0.7.0.1
 */