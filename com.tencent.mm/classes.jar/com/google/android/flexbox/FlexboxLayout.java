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
  private List<b> byL;
  private int byN;
  private int byO;
  private int byP;
  private int byQ;
  private int byR;
  private int byS;
  private Drawable byT;
  private Drawable byU;
  private int byV;
  private int byW;
  private int byX;
  private int byY;
  private int[] byZ;
  private SparseIntArray bza;
  private c bzb;
  private c.a bzc;
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62270);
    this.byS = -1;
    this.bzb = new c(this);
    this.byL = new ArrayList();
    this.bzc = new c.a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout, paramInt, 0);
    this.byN = paramContext.getInt(5, 0);
    this.byO = paramContext.getInt(6, 0);
    this.byP = paramContext.getInt(7, 0);
    this.byQ = paramContext.getInt(1, 4);
    this.byR = paramContext.getInt(0, 5);
    this.byS = paramContext.getInt(8, -1);
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
      this.byW = paramInt;
      this.byV = paramInt;
    }
    paramInt = paramContext.getInt(11, 0);
    if (paramInt != 0) {
      this.byW = paramInt;
    }
    paramInt = paramContext.getInt(10, 0);
    if (paramInt != 0) {
      this.byV = paramInt;
    }
    paramContext.recycle();
    AppMethodBeat.o(62270);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62287);
    if (this.byU == null)
    {
      AppMethodBeat.o(62287);
      return;
    }
    this.byU.setBounds(paramInt1, paramInt2, this.byY + paramInt1, paramInt2 + paramInt3);
    this.byU.draw(paramCanvas);
    AppMethodBeat.o(62287);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62285);
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.byL.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.byL.get(i);
      int j = 0;
      if (j < localb.asn)
      {
        int k = localb.byF + j;
        View localView = fn(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bq(k, j))
          {
            if (!paramBoolean1) {
              break label240;
            }
            k = localView.getRight() + localLayoutParams.rightMargin;
            label154:
            a(paramCanvas, k, localb.yn, localb.byy);
          }
          if ((j == localb.asn - 1) && ((this.byW & 0x4) > 0)) {
            if (!paramBoolean1) {
              break label261;
            }
          }
        }
        for (k = localView.getLeft() - localLayoutParams.leftMargin - this.byY;; k = localLayoutParams.rightMargin + k)
        {
          a(paramCanvas, k, localb.yn, localb.byy);
          j += 1;
          break;
          label240:
          k = localView.getLeft() - localLayoutParams.leftMargin - this.byY;
          break label154;
          label261:
          k = localView.getRight();
        }
      }
      if (fo(i))
      {
        if (paramBoolean2)
        {
          j = localb.yp;
          label301:
          b(paramCanvas, m, j, n);
        }
      }
      else if ((fq(i)) && ((this.byV & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label381;
        }
      }
      label381:
      for (j = localb.yn - this.byX;; j = localb.yp)
      {
        b(paramCanvas, m, j, n);
        i += 1;
        break;
        j = localb.yn - this.byX;
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
    int i2 = this.byL.size();
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
      localObject = (b)this.byL.get(paramInt3);
      paramInt4 = paramInt1;
      i = paramInt2;
      if (fo(paramInt3))
      {
        i = paramInt2 + this.byY;
        paramInt4 = paramInt1 - this.byY;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.byP)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.byP);
        AppMethodBeat.o(62283);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).asn)
        {
          j = ((b)localObject).byF + paramInt1;
          localView = fn(j);
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
              if (!bq(j, paramInt1)) {
                break label932;
              }
              paramInt2 = this.byX;
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
      if (paramInt1 == ((b)localObject).asn - 1)
      {
        j = k;
        if ((this.byV & 0x4) > 0) {
          j = this.byX;
        }
      }
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.bzb.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
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
        f2 = i1 - ((b)localObject).byw + n;
        f1 = ((b)localObject).byw - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).byw) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).byw) / 2.0F;
        break;
        paramInt1 = ((b)localObject).we();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).byw) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).we();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).byw) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).we();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).byw) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bzb.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        if (paramBoolean2)
        {
          this.bzb.a(localView, (b)localObject, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          break label442;
        }
        this.bzb.a(localView, (b)localObject, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        label874:
        ((b)localObject).m(localView, 0, paramInt2, 0, j);
        f4 = f1;
        f1 = f4;
      }
      paramInt2 = i + ((b)localObject).byy;
      paramInt1 = paramInt4 - ((b)localObject).byy;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62283);
      return;
    }
  }
  
  private void ac(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62277);
    this.byL.clear();
    this.bzc.reset();
    this.bzb.a(this.bzc, paramInt1, paramInt2, 2147483647, 0, -1, null);
    this.byL = this.bzc.byL;
    this.bzb.y(paramInt1, paramInt2, 0);
    if (this.byQ == 3)
    {
      Iterator localIterator = this.byL.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        int j = 0;
        int k = -2147483648;
        if (j < localb.asn)
        {
          View localView = fn(localb.byF + j);
          int i = k;
          LayoutParams localLayoutParams;
          int m;
          if (localView != null)
          {
            i = k;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (LayoutParams)localView.getLayoutParams();
              if (this.byO == 2) {
                break label229;
              }
              i = Math.max(localb.byC - localView.getBaseline(), localLayoutParams.topMargin);
              m = localView.getMeasuredHeight();
            }
          }
          for (i = Math.max(k, localLayoutParams.bottomMargin + (m + i));; i = Math.max(k, localLayoutParams.topMargin + m + i))
          {
            j += 1;
            k = i;
            break;
            label229:
            i = Math.max(localb.byC - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
            m = localView.getMeasuredHeight();
          }
        }
        localb.byy = k;
      }
    }
    this.bzb.z(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
    this.bzb.fj(0);
    o(this.byN, paramInt1, paramInt2, this.bzc.byM);
    AppMethodBeat.o(62277);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62288);
    if (this.byT == null)
    {
      AppMethodBeat.o(62288);
      return;
    }
    this.byT.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.byX + paramInt2);
    this.byT.draw(paramCanvas);
    AppMethodBeat.o(62288);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62286);
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.byL.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.byL.get(i);
      int j = 0;
      if (j < localb.asn)
      {
        int k = localb.byF + j;
        View localView = fn(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bq(k, j))
          {
            if (!paramBoolean2) {
              break label241;
            }
            k = localView.getBottom() + localLayoutParams.bottomMargin;
            label155:
            b(paramCanvas, localb.ym, k, localb.byy);
          }
          if ((j == localb.asn - 1) && ((this.byV & 0x4) > 0)) {
            if (!paramBoolean2) {
              break label262;
            }
          }
        }
        for (k = localView.getTop() - localLayoutParams.topMargin - this.byX;; k = localLayoutParams.bottomMargin + k)
        {
          b(paramCanvas, localb.ym, k, localb.byy);
          j += 1;
          break;
          label241:
          k = localView.getTop() - localLayoutParams.topMargin - this.byX;
          break label155;
          label262:
          k = localView.getBottom();
        }
      }
      if (fo(i))
      {
        if (paramBoolean1)
        {
          j = localb.yo;
          label302:
          a(paramCanvas, j, m, n);
        }
      }
      else if ((fq(i)) && ((this.byW & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label382;
        }
      }
      label382:
      for (j = localb.ym - this.byY;; j = localb.yo)
      {
        a(paramCanvas, j, m, n);
        i += 1;
        break;
        j = localb.ym - this.byY;
        break label302;
      }
    }
    AppMethodBeat.o(62286);
  }
  
  private boolean bq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62309);
    if (br(paramInt1, paramInt2))
    {
      if (vX())
      {
        if ((this.byW & 0x1) != 0)
        {
          AppMethodBeat.o(62309);
          return true;
        }
        AppMethodBeat.o(62309);
        return false;
      }
      if ((this.byV & 0x1) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if (vX())
    {
      if ((this.byW & 0x2) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if ((this.byV & 0x2) != 0)
    {
      AppMethodBeat.o(62309);
      return true;
    }
    AppMethodBeat.o(62309);
    return false;
  }
  
  private boolean br(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62310);
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = fn(paramInt1 - i);
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
    int i2 = this.byL.size();
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
      localObject = (b)this.byL.get(paramInt3);
      paramInt4 = paramInt2;
      i = paramInt1;
      if (fo(paramInt3))
      {
        paramInt4 = paramInt2 - this.byX;
        i = paramInt1 + this.byX;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.byP)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.byP);
        AppMethodBeat.o(62282);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).asn)
        {
          j = ((b)localObject).byF + paramInt1;
          localView = fn(j);
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
              if (!bq(j, paramInt1)) {
                break label919;
              }
              paramInt2 = this.byY;
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
      if (paramInt1 == ((b)localObject).asn - 1)
      {
        j = k;
        if ((this.byW & 0x4) > 0) {
          j = this.byY;
        }
      }
      if (this.byO == 2) {
        if (paramBoolean)
        {
          this.bzb.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), paramInt4 - localView.getMeasuredHeight(), Math.round(f1), paramInt4);
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
        f2 = i1 - ((b)localObject).byw + n;
        f1 = ((b)localObject).byw - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).byw) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).byw) / 2.0F;
        break;
        paramInt1 = ((b)localObject).we();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).byw) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).we();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).byw) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).we();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).byw) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bzb.a(localView, (b)localObject, Math.round(f2), paramInt4 - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), paramInt4);
        break label434;
        if (paramBoolean)
        {
          this.bzb.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), i, Math.round(f1), i + localView.getMeasuredHeight());
          break label434;
        }
        this.bzb.a(localView, (b)localObject, Math.round(f2), i, Math.round(f2) + localView.getMeasuredWidth(), i + localView.getMeasuredHeight());
        break label434;
        label862:
        ((b)localObject).m(localView, paramInt2, 0, j, 0);
        f4 = f1;
        f1 = f4;
      }
      paramInt1 = i + ((b)localObject).byy;
      paramInt2 = paramInt4 - ((b)localObject).byy;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62282);
      return;
    }
  }
  
  private View fn(int paramInt)
  {
    AppMethodBeat.i(62274);
    if ((paramInt < 0) || (paramInt >= this.byZ.length))
    {
      AppMethodBeat.o(62274);
      return null;
    }
    View localView = getChildAt(this.byZ[paramInt]);
    AppMethodBeat.o(62274);
    return localView;
  }
  
  private boolean fo(int paramInt)
  {
    AppMethodBeat.i(62311);
    if ((paramInt < 0) || (paramInt >= this.byL.size()))
    {
      AppMethodBeat.o(62311);
      return false;
    }
    if (fp(paramInt))
    {
      if (vX())
      {
        if ((this.byV & 0x1) != 0)
        {
          AppMethodBeat.o(62311);
          return true;
        }
        AppMethodBeat.o(62311);
        return false;
      }
      if ((this.byW & 0x1) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if (vX())
    {
      if ((this.byV & 0x2) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if ((this.byW & 0x2) != 0)
    {
      AppMethodBeat.o(62311);
      return true;
    }
    AppMethodBeat.o(62311);
    return false;
  }
  
  private boolean fp(int paramInt)
  {
    AppMethodBeat.i(62312);
    int i = 0;
    while (i < paramInt)
    {
      if (((b)this.byL.get(i)).we() > 0)
      {
        AppMethodBeat.o(62312);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(62312);
    return true;
  }
  
  private boolean fq(int paramInt)
  {
    AppMethodBeat.i(62313);
    if ((paramInt < 0) || (paramInt >= this.byL.size()))
    {
      AppMethodBeat.o(62313);
      return false;
    }
    paramInt += 1;
    while (paramInt < this.byL.size())
    {
      if (((b)this.byL.get(paramInt)).we() > 0)
      {
        AppMethodBeat.o(62313);
        return false;
      }
      paramInt += 1;
    }
    if (vX())
    {
      if ((this.byV & 0x4) != 0)
      {
        AppMethodBeat.o(62313);
        return true;
      }
      AppMethodBeat.o(62313);
      return false;
    }
    if ((this.byW & 0x4) != 0)
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
  
  private void wg()
  {
    AppMethodBeat.i(62308);
    if ((this.byT == null) && (this.byU == null))
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
    if (bq(paramInt1, paramInt2))
    {
      if (vX())
      {
        paramb.byw += this.byY;
        paramb.byx += this.byY;
        AppMethodBeat.o(62301);
        return;
      }
      paramb.byw += this.byX;
      paramb.byx += this.byX;
    }
    AppMethodBeat.o(62301);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(62298);
    if (vX())
    {
      if ((this.byW & 0x4) > 0)
      {
        paramb.byw += this.byY;
        paramb.byx += this.byY;
        AppMethodBeat.o(62298);
      }
    }
    else if ((this.byV & 0x4) > 0)
    {
      paramb.byw += this.byX;
      paramb.byx += this.byX;
    }
    AppMethodBeat.o(62298);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62276);
    if (this.bza == null) {
      this.bza = new SparseIntArray(getChildCount());
    }
    this.byZ = this.bzb.a(paramView, paramInt, paramLayoutParams, this.bza);
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
  
  public final View ff(int paramInt)
  {
    AppMethodBeat.i(62273);
    View localView = getChildAt(paramInt);
    AppMethodBeat.o(62273);
    return localView;
  }
  
  public final View fg(int paramInt)
  {
    AppMethodBeat.i(62275);
    View localView = fn(paramInt);
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
    return this.byR;
  }
  
  public int getAlignItems()
  {
    return this.byQ;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.byT;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.byU;
  }
  
  public int getFlexDirection()
  {
    return this.byN;
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
    ArrayList localArrayList = new ArrayList(this.byL.size());
    Iterator localIterator = this.byL.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.we() != 0) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(62296);
    return localArrayList;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.byL;
  }
  
  public int getFlexWrap()
  {
    return this.byO;
  }
  
  public int getJustifyContent()
  {
    return this.byP;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62279);
    Iterator localIterator = this.byL.iterator();
    for (int i = -2147483648; localIterator.hasNext(); i = Math.max(i, ((b)localIterator.next()).byw)) {}
    AppMethodBeat.o(62279);
    return i;
  }
  
  public int getMaxLine()
  {
    return this.byS;
  }
  
  public int getShowDividerHorizontal()
  {
    return this.byV;
  }
  
  public int getShowDividerVertical()
  {
    return this.byW;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62280);
    int m = this.byL.size();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      b localb = (b)this.byL.get(k);
      int i = j;
      if (fo(k))
      {
        if (vX()) {
          i = j + this.byX;
        }
      }
      else
      {
        label66:
        j = i;
        if (fq(k)) {
          if (!vX()) {
            break label115;
          }
        }
      }
      label115:
      for (j = i + this.byX;; j = i + this.byY)
      {
        j += localb.byy;
        k += 1;
        break;
        i = j + this.byY;
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
    if (vX())
    {
      if (bq(paramInt1, paramInt2)) {
        i = this.byY + 0;
      }
      paramInt1 = i;
      if ((this.byW & 0x4) > 0) {
        paramInt1 = i + this.byY;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62297);
      return paramInt1;
      i = j;
      if (bq(paramInt1, paramInt2)) {
        i = this.byX + 0;
      }
      paramInt1 = i;
      if ((this.byV & 0x4) > 0) {
        paramInt1 = i + this.byX;
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
    if ((this.byU == null) && (this.byT == null))
    {
      AppMethodBeat.o(62284);
      return;
    }
    if ((this.byV == 0) && (this.byW == 0))
    {
      AppMethodBeat.o(62284);
      return;
    }
    int i = t.Y(this);
    boolean bool1;
    switch (this.byN)
    {
    default: 
      AppMethodBeat.o(62284);
      return;
    case 0: 
      if (i == 1)
      {
        bool1 = true;
        label114:
        if (this.byO != 2) {
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
        if (this.byO != 2) {
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
          if (this.byO != 2) {
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
            if (this.byO != 2) {
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
    switch (this.byN)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.byN);
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
        if (this.byO != 2) {
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
        if (this.byO != 2) {
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
    if (this.bza == null) {
      this.bza = new SparseIntArray(getChildCount());
    }
    if (this.bzb.b(this.bza)) {
      this.byZ = this.bzb.a(this.bza);
    }
    switch (this.byN)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.byN);
      AppMethodBeat.o(62271);
      throw localIllegalStateException;
    case 0: 
    case 1: 
      ac(paramInt1, paramInt2);
      AppMethodBeat.o(62271);
      return;
    }
    this.byL.clear();
    this.bzc.reset();
    this.bzb.a(this.bzc, paramInt1, paramInt2);
    this.byL = this.bzc.byL;
    this.bzb.bo(paramInt1, paramInt2);
    this.bzb.z(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.bzb.wf();
    o(this.byN, paramInt1, paramInt2, this.bzc.byM);
    AppMethodBeat.o(62271);
  }
  
  public void setAlignContent(int paramInt)
  {
    AppMethodBeat.i(62294);
    if (this.byR != paramInt)
    {
      this.byR = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62294);
  }
  
  public void setAlignItems(int paramInt)
  {
    AppMethodBeat.i(62293);
    if (this.byQ != paramInt)
    {
      this.byQ = paramInt;
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
    if (paramDrawable == this.byT)
    {
      AppMethodBeat.o(62303);
      return;
    }
    this.byT = paramDrawable;
    if (paramDrawable != null) {}
    for (this.byX = paramDrawable.getIntrinsicHeight();; this.byX = 0)
    {
      wg();
      requestLayout();
      AppMethodBeat.o(62303);
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(62304);
    if (paramDrawable == this.byU)
    {
      AppMethodBeat.o(62304);
      return;
    }
    this.byU = paramDrawable;
    if (paramDrawable != null) {}
    for (this.byY = paramDrawable.getIntrinsicWidth();; this.byY = 0)
    {
      wg();
      requestLayout();
      AppMethodBeat.o(62304);
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62290);
    if (this.byN != paramInt)
    {
      this.byN = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62290);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.byL = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(62291);
    if (this.byO != paramInt)
    {
      this.byO = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62291);
  }
  
  public void setJustifyContent(int paramInt)
  {
    AppMethodBeat.i(62292);
    if (this.byP != paramInt)
    {
      this.byP = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62292);
  }
  
  public void setMaxLine(int paramInt)
  {
    AppMethodBeat.i(62295);
    if (this.byS != paramInt)
    {
      this.byS = paramInt;
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
    if (paramInt != this.byV)
    {
      this.byV = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62307);
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(62306);
    if (paramInt != this.byW)
    {
      this.byW = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62306);
  }
  
  public final boolean vX()
  {
    return (this.byN == 0) || (this.byN == 1);
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
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private int bzd;
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
      AppMethodBeat.i(62269);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(62269);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(62266);
      this.bzd = 1;
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout_Layout);
      this.bzd = paramContext.getInt(8, 1);
      this.bze = paramContext.getFloat(2, 0.0F);
      this.bzf = paramContext.getFloat(3, 1.0F);
      this.bzg = paramContext.getInt(0, -1);
      this.bzh = paramContext.getFraction(1, 1, 1, -1.0F);
      this.mMinWidth = paramContext.getDimensionPixelSize(7, 0);
      this.mMinHeight = paramContext.getDimensionPixelSize(6, 0);
      this.mMaxWidth = paramContext.getDimensionPixelSize(5, 16777215);
      this.mMaxHeight = paramContext.getDimensionPixelSize(4, 16777215);
      this.bzi = paramContext.getBoolean(9, false);
      paramContext.recycle();
      AppMethodBeat.o(62266);
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(0);
      AppMethodBeat.i(62268);
      this.bzd = 1;
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bzd = paramParcel.readInt();
      this.bze = paramParcel.readFloat();
      this.bzf = paramParcel.readFloat();
      this.bzg = paramParcel.readInt();
      this.bzh = paramParcel.readFloat();
      this.mMinWidth = paramParcel.readInt();
      this.mMinHeight = paramParcel.readInt();
      this.mMaxWidth = paramParcel.readInt();
      this.mMaxHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.bzi = bool;
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
      this.bzd = 1;
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.bzd = 1;
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.bzd = 1;
      this.bze = 0.0F;
      this.bzf = 1.0F;
      this.bzg = -1;
      this.bzh = -1.0F;
      this.mMaxWidth = 16777215;
      this.mMaxHeight = 16777215;
      this.bzd = paramLayoutParams.bzd;
      this.bze = paramLayoutParams.bze;
      this.bzf = paramLayoutParams.bzf;
      this.bzg = paramLayoutParams.bzg;
      this.bzh = paramLayoutParams.bzh;
      this.mMinWidth = paramLayoutParams.mMinWidth;
      this.mMinHeight = paramLayoutParams.mMinHeight;
      this.mMaxWidth = paramLayoutParams.mMaxWidth;
      this.mMaxHeight = paramLayoutParams.mMaxHeight;
      this.bzi = paramLayoutParams.bzi;
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
      return this.bzd;
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
      AppMethodBeat.i(62267);
      paramParcel.writeInt(this.bzd);
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
        AppMethodBeat.o(62267);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout
 * JD-Core Version:    0.7.0.1
 */