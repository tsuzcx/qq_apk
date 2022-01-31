package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
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
  private List<b> bdd;
  private int bdf;
  private int bdg;
  private int bdh;
  private int bdi;
  private int bdj;
  private int bdk;
  private Drawable bdl;
  private Drawable bdm;
  private int bdn;
  private int bdo;
  private int bdp;
  private int bdq;
  private int[] bdr;
  private SparseIntArray bds;
  private c bdt;
  private c.a bdu;
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(54733);
    this.bdk = -1;
    this.bdt = new c(this);
    this.bdd = new ArrayList();
    this.bdu = new c.a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout, paramInt, 0);
    this.bdf = paramContext.getInt(0, 0);
    this.bdg = paramContext.getInt(1, 0);
    this.bdh = paramContext.getInt(2, 0);
    this.bdi = paramContext.getInt(3, 4);
    this.bdj = paramContext.getInt(4, 5);
    this.bdk = paramContext.getInt(11, -1);
    paramAttributeSet = paramContext.getDrawable(5);
    if (paramAttributeSet != null)
    {
      setDividerDrawableHorizontal(paramAttributeSet);
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(6);
    if (paramAttributeSet != null) {
      setDividerDrawableHorizontal(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(7);
    if (paramAttributeSet != null) {
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramInt = paramContext.getInt(8, 0);
    if (paramInt != 0)
    {
      this.bdo = paramInt;
      this.bdn = paramInt;
    }
    paramInt = paramContext.getInt(10, 0);
    if (paramInt != 0) {
      this.bdo = paramInt;
    }
    paramInt = paramContext.getInt(9, 0);
    if (paramInt != 0) {
      this.bdn = paramInt;
    }
    paramContext.recycle();
    AppMethodBeat.o(54733);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54750);
    if (this.bdm == null)
    {
      AppMethodBeat.o(54750);
      return;
    }
    this.bdm.setBounds(paramInt1, paramInt2, this.bdq + paramInt1, paramInt2 + paramInt3);
    this.bdm.draw(paramCanvas);
    AppMethodBeat.o(54750);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54748);
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.bdd.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bdd.get(i);
      int j = 0;
      if (j < localb.ake)
      {
        int k = localb.bcX + j;
        View localView = eD(k);
        FlexboxLayout.LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
          if (bf(k, j))
          {
            if (!paramBoolean1) {
              break label240;
            }
            k = localView.getRight() + localLayoutParams.rightMargin;
            label154:
            a(paramCanvas, k, localb.qP, localb.bcQ);
          }
          if ((j == localb.ake - 1) && ((this.bdo & 0x4) > 0)) {
            if (!paramBoolean1) {
              break label261;
            }
          }
        }
        for (k = localView.getLeft() - localLayoutParams.leftMargin - this.bdq;; k = localLayoutParams.rightMargin + k)
        {
          a(paramCanvas, k, localb.qP, localb.bcQ);
          j += 1;
          break;
          label240:
          k = localView.getLeft() - localLayoutParams.leftMargin - this.bdq;
          break label154;
          label261:
          k = localView.getRight();
        }
      }
      if (eE(i))
      {
        if (paramBoolean2)
        {
          j = localb.qR;
          label301:
          b(paramCanvas, m, j, n);
        }
      }
      else if ((eG(i)) && ((this.bdn & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label381;
        }
      }
      label381:
      for (j = localb.qP - this.bdp;; j = localb.qR)
      {
        b(paramCanvas, m, j, n);
        i += 1;
        break;
        j = localb.qP - this.bdp;
        break label301;
      }
    }
    AppMethodBeat.o(54748);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54746);
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int j = getPaddingRight();
    int i = getPaddingLeft();
    int i1 = paramInt4 - paramInt2;
    paramInt1 = paramInt3 - paramInt1 - j;
    int i2 = this.bdd.size();
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
      localObject = (b)this.bdd.get(paramInt3);
      paramInt4 = paramInt1;
      i = paramInt2;
      if (eE(paramInt3))
      {
        i = paramInt2 + this.bdq;
        paramInt4 = paramInt1 - this.bdq;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bdh)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bdh);
        AppMethodBeat.o(54746);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).ake)
        {
          j = ((b)localObject).bcX + paramInt1;
          localView = eD(j);
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
              if (!bf(j, paramInt1)) {
                break label932;
              }
              paramInt2 = this.bdp;
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
      if (paramInt1 == ((b)localObject).ake - 1)
      {
        j = k;
        if ((this.bdn & 0x4) > 0) {
          j = this.bdp;
        }
      }
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.bdt.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
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
        f2 = i1 - ((b)localObject).bcO + n;
        f1 = ((b)localObject).bcO - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bcO) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bcO) / 2.0F;
        break;
        paramInt1 = ((b)localObject).rs();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bcO) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).rs();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bcO) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).rs();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bcO) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bdt.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        if (paramBoolean2)
        {
          this.bdt.a(localView, (b)localObject, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          break label442;
        }
        this.bdt.a(localView, (b)localObject, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        break label442;
        label874:
        ((b)localObject).m(localView, 0, paramInt2, 0, j);
        f4 = f1;
        f1 = f4;
      }
      paramInt2 = i + ((b)localObject).bcQ;
      paramInt1 = paramInt4 - ((b)localObject).bcQ;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(54746);
      return;
    }
  }
  
  private void aa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54740);
    this.bdd.clear();
    this.bdu.reset();
    this.bdt.a(this.bdu, paramInt1, paramInt2, 2147483647, 0, -1, null);
    this.bdd = this.bdu.bdd;
    this.bdt.w(paramInt1, paramInt2, 0);
    if (this.bdi == 3)
    {
      Iterator localIterator = this.bdd.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        int j = 0;
        int k = -2147483648;
        if (j < localb.ake)
        {
          View localView = eD(localb.bcX + j);
          int i = k;
          FlexboxLayout.LayoutParams localLayoutParams;
          int m;
          if (localView != null)
          {
            i = k;
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
              if (this.bdg == 2) {
                break label229;
              }
              i = Math.max(localb.bcU - localView.getBaseline(), localLayoutParams.topMargin);
              m = localView.getMeasuredHeight();
            }
          }
          for (i = Math.max(k, localLayoutParams.bottomMargin + (m + i));; i = Math.max(k, localLayoutParams.topMargin + m + i))
          {
            j += 1;
            k = i;
            break;
            label229:
            i = Math.max(localb.bcU - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
            m = localView.getMeasuredHeight();
          }
        }
        localb.bcQ = k;
      }
    }
    this.bdt.x(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
    this.bdt.ez(0);
    n(this.bdf, paramInt1, paramInt2, this.bdu.bde);
    AppMethodBeat.o(54740);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54751);
    if (this.bdl == null)
    {
      AppMethodBeat.o(54751);
      return;
    }
    this.bdl.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.bdp + paramInt2);
    this.bdl.draw(paramCanvas);
    AppMethodBeat.o(54751);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54749);
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.bdd.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bdd.get(i);
      int j = 0;
      if (j < localb.ake)
      {
        int k = localb.bcX + j;
        View localView = eD(k);
        FlexboxLayout.LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (FlexboxLayout.LayoutParams)localView.getLayoutParams();
          if (bf(k, j))
          {
            if (!paramBoolean2) {
              break label241;
            }
            k = localView.getBottom() + localLayoutParams.bottomMargin;
            label155:
            b(paramCanvas, localb.qO, k, localb.bcQ);
          }
          if ((j == localb.ake - 1) && ((this.bdn & 0x4) > 0)) {
            if (!paramBoolean2) {
              break label262;
            }
          }
        }
        for (k = localView.getTop() - localLayoutParams.topMargin - this.bdp;; k = localLayoutParams.bottomMargin + k)
        {
          b(paramCanvas, localb.qO, k, localb.bcQ);
          j += 1;
          break;
          label241:
          k = localView.getTop() - localLayoutParams.topMargin - this.bdp;
          break label155;
          label262:
          k = localView.getBottom();
        }
      }
      if (eE(i))
      {
        if (paramBoolean1)
        {
          j = localb.qQ;
          label302:
          a(paramCanvas, j, m, n);
        }
      }
      else if ((eG(i)) && ((this.bdo & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label382;
        }
      }
      label382:
      for (j = localb.qO - this.bdq;; j = localb.qQ)
      {
        a(paramCanvas, j, m, n);
        i += 1;
        break;
        j = localb.qO - this.bdq;
        break label302;
      }
    }
    AppMethodBeat.o(54749);
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54745);
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2 - getPaddingBottom();
    paramInt1 = getPaddingTop();
    int i2 = this.bdd.size();
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
      localObject = (b)this.bdd.get(paramInt3);
      paramInt4 = paramInt2;
      i = paramInt1;
      if (eE(paramInt3))
      {
        paramInt4 = paramInt2 - this.bdp;
        i = paramInt1 + this.bdp;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.bdh)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.bdh);
        AppMethodBeat.o(54745);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).ake)
        {
          j = ((b)localObject).bcX + paramInt1;
          localView = eD(j);
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
              if (!bf(j, paramInt1)) {
                break label919;
              }
              paramInt2 = this.bdq;
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
      if (paramInt1 == ((b)localObject).ake - 1)
      {
        j = k;
        if ((this.bdo & 0x4) > 0) {
          j = this.bdq;
        }
      }
      if (this.bdg == 2) {
        if (paramBoolean)
        {
          this.bdt.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), paramInt4 - localView.getMeasuredHeight(), Math.round(f1), paramInt4);
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
        f2 = i1 - ((b)localObject).bcO + n;
        f1 = ((b)localObject).bcO - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bcO) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bcO) / 2.0F;
        break;
        paramInt1 = ((b)localObject).rs();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bcO) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).rs();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bcO) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).rs();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bcO) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.bdt.a(localView, (b)localObject, Math.round(f2), paramInt4 - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), paramInt4);
        break label434;
        if (paramBoolean)
        {
          this.bdt.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), i, Math.round(f1), i + localView.getMeasuredHeight());
          break label434;
        }
        this.bdt.a(localView, (b)localObject, Math.round(f2), i, Math.round(f2) + localView.getMeasuredWidth(), i + localView.getMeasuredHeight());
        break label434;
        label862:
        ((b)localObject).m(localView, paramInt2, 0, j, 0);
        f4 = f1;
        f1 = f4;
      }
      paramInt1 = i + ((b)localObject).bcQ;
      paramInt2 = paramInt4 - ((b)localObject).bcQ;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(54745);
      return;
    }
  }
  
  private boolean bf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54772);
    if (bg(paramInt1, paramInt2))
    {
      if (rl())
      {
        if ((this.bdo & 0x1) != 0)
        {
          AppMethodBeat.o(54772);
          return true;
        }
        AppMethodBeat.o(54772);
        return false;
      }
      if ((this.bdn & 0x1) != 0)
      {
        AppMethodBeat.o(54772);
        return true;
      }
      AppMethodBeat.o(54772);
      return false;
    }
    if (rl())
    {
      if ((this.bdo & 0x2) != 0)
      {
        AppMethodBeat.o(54772);
        return true;
      }
      AppMethodBeat.o(54772);
      return false;
    }
    if ((this.bdn & 0x2) != 0)
    {
      AppMethodBeat.o(54772);
      return true;
    }
    AppMethodBeat.o(54772);
    return false;
  }
  
  private boolean bg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54773);
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = eD(paramInt1 - i);
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        AppMethodBeat.o(54773);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(54773);
    return true;
  }
  
  private View eD(int paramInt)
  {
    AppMethodBeat.i(54737);
    if ((paramInt < 0) || (paramInt >= this.bdr.length))
    {
      AppMethodBeat.o(54737);
      return null;
    }
    View localView = getChildAt(this.bdr[paramInt]);
    AppMethodBeat.o(54737);
    return localView;
  }
  
  private boolean eE(int paramInt)
  {
    AppMethodBeat.i(54774);
    if ((paramInt < 0) || (paramInt >= this.bdd.size()))
    {
      AppMethodBeat.o(54774);
      return false;
    }
    if (eF(paramInt))
    {
      if (rl())
      {
        if ((this.bdn & 0x1) != 0)
        {
          AppMethodBeat.o(54774);
          return true;
        }
        AppMethodBeat.o(54774);
        return false;
      }
      if ((this.bdo & 0x1) != 0)
      {
        AppMethodBeat.o(54774);
        return true;
      }
      AppMethodBeat.o(54774);
      return false;
    }
    if (rl())
    {
      if ((this.bdn & 0x2) != 0)
      {
        AppMethodBeat.o(54774);
        return true;
      }
      AppMethodBeat.o(54774);
      return false;
    }
    if ((this.bdo & 0x2) != 0)
    {
      AppMethodBeat.o(54774);
      return true;
    }
    AppMethodBeat.o(54774);
    return false;
  }
  
  private boolean eF(int paramInt)
  {
    AppMethodBeat.i(54775);
    int i = 0;
    while (i < paramInt)
    {
      if (((b)this.bdd.get(i)).rs() > 0)
      {
        AppMethodBeat.o(54775);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(54775);
    return true;
  }
  
  private boolean eG(int paramInt)
  {
    AppMethodBeat.i(54776);
    if ((paramInt < 0) || (paramInt >= this.bdd.size()))
    {
      AppMethodBeat.o(54776);
      return false;
    }
    paramInt += 1;
    while (paramInt < this.bdd.size())
    {
      if (((b)this.bdd.get(paramInt)).rs() > 0)
      {
        AppMethodBeat.o(54776);
        return false;
      }
      paramInt += 1;
    }
    if (rl())
    {
      if ((this.bdn & 0x4) != 0)
      {
        AppMethodBeat.o(54776);
        return true;
      }
      AppMethodBeat.o(54776);
      return false;
    }
    if ((this.bdo & 0x4) != 0)
    {
      AppMethodBeat.o(54776);
      return true;
    }
    AppMethodBeat.o(54776);
    return false;
  }
  
  private void n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54741);
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
      AppMethodBeat.o(54741);
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
        AppMethodBeat.o(54741);
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
        AppMethodBeat.o(54741);
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
      AppMethodBeat.o(54741);
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
  
  private void ru()
  {
    AppMethodBeat.i(54771);
    if ((this.bdl == null) && (this.bdm == null))
    {
      setWillNotDraw(true);
      AppMethodBeat.o(54771);
      return;
    }
    setWillNotDraw(false);
    AppMethodBeat.o(54771);
  }
  
  public final void a(int paramInt, View paramView) {}
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(54764);
    if (bf(paramInt1, paramInt2))
    {
      if (rl())
      {
        paramb.bcO += this.bdq;
        paramb.bcP += this.bdq;
        AppMethodBeat.o(54764);
        return;
      }
      paramb.bcO += this.bdp;
      paramb.bcP += this.bdp;
    }
    AppMethodBeat.o(54764);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(54761);
    if (rl())
    {
      if ((this.bdo & 0x4) > 0)
      {
        paramb.bcO += this.bdq;
        paramb.bcP += this.bdq;
        AppMethodBeat.o(54761);
      }
    }
    else if ((this.bdn & 0x4) > 0)
    {
      paramb.bcO += this.bdp;
      paramb.bcP += this.bdp;
    }
    AppMethodBeat.o(54761);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(54739);
    if (this.bds == null) {
      this.bds = new SparseIntArray(getChildCount());
    }
    this.bdr = this.bdt.a(paramView, paramInt, paramLayoutParams, this.bds);
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(54739);
  }
  
  public final int cc(View paramView)
  {
    return 0;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FlexboxLayout.LayoutParams;
  }
  
  public final View ev(int paramInt)
  {
    AppMethodBeat.i(54736);
    View localView = getChildAt(paramInt);
    AppMethodBeat.o(54736);
    return localView;
  }
  
  public final View ew(int paramInt)
  {
    AppMethodBeat.i(54738);
    View localView = eD(paramInt);
    AppMethodBeat.o(54738);
    return localView;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(54752);
    if ((paramLayoutParams instanceof FlexboxLayout.LayoutParams))
    {
      paramLayoutParams = new FlexboxLayout.LayoutParams((FlexboxLayout.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(54752);
      return paramLayoutParams;
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new FlexboxLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(54752);
      return paramLayoutParams;
    }
    paramLayoutParams = new FlexboxLayout.LayoutParams(paramLayoutParams);
    AppMethodBeat.o(54752);
    return paramLayoutParams;
  }
  
  public int getAlignContent()
  {
    return this.bdj;
  }
  
  public int getAlignItems()
  {
    return this.bdi;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.bdl;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.bdm;
  }
  
  public int getFlexDirection()
  {
    return this.bdf;
  }
  
  public int getFlexItemCount()
  {
    AppMethodBeat.i(54735);
    int i = getChildCount();
    AppMethodBeat.o(54735);
    return i;
  }
  
  public List<b> getFlexLines()
  {
    AppMethodBeat.i(54759);
    ArrayList localArrayList = new ArrayList(this.bdd.size());
    Iterator localIterator = this.bdd.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.rs() != 0) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(54759);
    return localArrayList;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bdd;
  }
  
  public int getFlexWrap()
  {
    return this.bdg;
  }
  
  public int getJustifyContent()
  {
    return this.bdh;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(54742);
    Iterator localIterator = this.bdd.iterator();
    for (int i = -2147483648; localIterator.hasNext(); i = Math.max(i, ((b)localIterator.next()).bcO)) {}
    AppMethodBeat.o(54742);
    return i;
  }
  
  public int getMaxLine()
  {
    return this.bdk;
  }
  
  public int getShowDividerHorizontal()
  {
    return this.bdn;
  }
  
  public int getShowDividerVertical()
  {
    return this.bdo;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(54743);
    int m = this.bdd.size();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      b localb = (b)this.bdd.get(k);
      int i = j;
      if (eE(k))
      {
        if (rl()) {
          i = j + this.bdp;
        }
      }
      else
      {
        label66:
        j = i;
        if (eG(k)) {
          if (!rl()) {
            break label115;
          }
        }
      }
      label115:
      for (j = i + this.bdp;; j = i + this.bdq)
      {
        j += localb.bcQ;
        k += 1;
        break;
        i = j + this.bdq;
        break label66;
      }
    }
    AppMethodBeat.o(54743);
    return j;
  }
  
  public final int n(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54760);
    int j = 0;
    int i = 0;
    if (rl())
    {
      if (bf(paramInt1, paramInt2)) {
        i = this.bdq + 0;
      }
      paramInt1 = i;
      if ((this.bdo & 0x4) > 0) {
        paramInt1 = i + this.bdq;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(54760);
      return paramInt1;
      i = j;
      if (bf(paramInt1, paramInt2)) {
        i = this.bdp + 0;
      }
      paramInt1 = i;
      if ((this.bdn & 0x4) > 0) {
        paramInt1 = i + this.bdp;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool3 = true;
    AppMethodBeat.i(54747);
    if ((this.bdm == null) && (this.bdl == null))
    {
      AppMethodBeat.o(54747);
      return;
    }
    if ((this.bdn == 0) && (this.bdo == 0))
    {
      AppMethodBeat.o(54747);
      return;
    }
    int i = t.T(this);
    boolean bool1;
    switch (this.bdf)
    {
    default: 
      AppMethodBeat.o(54747);
      return;
    case 0: 
      if (i == 1)
      {
        bool1 = true;
        label114:
        if (this.bdg != 2) {
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
      AppMethodBeat.o(54747);
      return;
      bool1 = false;
      break label114;
      if (i != 1)
      {
        bool1 = true;
        if (this.bdg != 2) {
          break label278;
        }
      }
      for (bool2 = bool4;; bool2 = false)
      {
        a(paramCanvas, bool1, bool2);
        AppMethodBeat.o(54747);
        return;
        bool1 = false;
        break label153;
        if (i == 1)
        {
          bool1 = true;
          label192:
          if (this.bdg != 2) {
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
          AppMethodBeat.o(54747);
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
            if (this.bdg != 2) {
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
    AppMethodBeat.i(54744);
    int i = t.T(this);
    switch (this.bdf)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.bdf);
      AppMethodBeat.o(54744);
      throw localIllegalStateException;
    case 0: 
      if (i == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(54744);
        return;
      }
    case 1: 
      if (i != 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(54744);
        return;
      }
    case 2: 
      if (i == 1)
      {
        paramBoolean = true;
        if (this.bdg != 2) {
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
      AppMethodBeat.o(54744);
      return;
      paramBoolean = false;
      break;
      label199:
      paramBoolean = false;
      continue;
      if (i == 1)
      {
        paramBoolean = true;
        if (this.bdg != 2) {
          break label252;
        }
        if (paramBoolean) {}
      }
      label252:
      for (bool1 = true;; bool1 = paramBoolean)
      {
        a(bool1, true, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(54744);
        return;
        paramBoolean = false;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54734);
    if (this.bds == null) {
      this.bds = new SparseIntArray(getChildCount());
    }
    if (this.bdt.b(this.bds)) {
      this.bdr = this.bdt.a(this.bds);
    }
    switch (this.bdf)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.bdf);
      AppMethodBeat.o(54734);
      throw localIllegalStateException;
    case 0: 
    case 1: 
      aa(paramInt1, paramInt2);
      AppMethodBeat.o(54734);
      return;
    }
    this.bdd.clear();
    this.bdu.reset();
    this.bdt.a(this.bdu, paramInt1, paramInt2);
    this.bdd = this.bdu.bdd;
    this.bdt.bd(paramInt1, paramInt2);
    this.bdt.x(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.bdt.rt();
    n(this.bdf, paramInt1, paramInt2, this.bdu.bde);
    AppMethodBeat.o(54734);
  }
  
  public final boolean rl()
  {
    return (this.bdf == 0) || (this.bdf == 1);
  }
  
  public void setAlignContent(int paramInt)
  {
    AppMethodBeat.i(54757);
    if (this.bdj != paramInt)
    {
      this.bdj = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54757);
  }
  
  public void setAlignItems(int paramInt)
  {
    AppMethodBeat.i(54756);
    if (this.bdi != paramInt)
    {
      this.bdi = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54756);
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(54765);
    setDividerDrawableHorizontal(paramDrawable);
    setDividerDrawableVertical(paramDrawable);
    AppMethodBeat.o(54765);
  }
  
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    AppMethodBeat.i(54766);
    if (paramDrawable == this.bdl)
    {
      AppMethodBeat.o(54766);
      return;
    }
    this.bdl = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bdp = paramDrawable.getIntrinsicHeight();; this.bdp = 0)
    {
      ru();
      requestLayout();
      AppMethodBeat.o(54766);
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(54767);
    if (paramDrawable == this.bdm)
    {
      AppMethodBeat.o(54767);
      return;
    }
    this.bdm = paramDrawable;
    if (paramDrawable != null) {}
    for (this.bdq = paramDrawable.getIntrinsicWidth();; this.bdq = 0)
    {
      ru();
      requestLayout();
      AppMethodBeat.o(54767);
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(54753);
    if (this.bdf != paramInt)
    {
      this.bdf = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54753);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bdd = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(54754);
    if (this.bdg != paramInt)
    {
      this.bdg = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54754);
  }
  
  public void setJustifyContent(int paramInt)
  {
    AppMethodBeat.i(54755);
    if (this.bdh != paramInt)
    {
      this.bdh = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54755);
  }
  
  public void setMaxLine(int paramInt)
  {
    AppMethodBeat.i(54758);
    if (this.bdk != paramInt)
    {
      this.bdk = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54758);
  }
  
  public void setShowDivider(int paramInt)
  {
    AppMethodBeat.i(54768);
    setShowDividerVertical(paramInt);
    setShowDividerHorizontal(paramInt);
    AppMethodBeat.o(54768);
  }
  
  public void setShowDividerHorizontal(int paramInt)
  {
    AppMethodBeat.i(54770);
    if (paramInt != this.bdn)
    {
      this.bdn = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54770);
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(54769);
    if (paramInt != this.bdo)
    {
      this.bdo = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(54769);
  }
  
  public final int u(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54762);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(54762);
    return paramInt1;
  }
  
  public final int v(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54763);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(54763);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout
 * JD-Core Version:    0.7.0.1
 */