package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlexboxLayout
  extends ViewGroup
  implements a
{
  private List<b> dmC;
  private int dmE;
  private int dmF;
  private int dmG;
  private int dmH;
  private int dmI;
  private int dmJ;
  private Drawable dmK;
  private Drawable dmL;
  private int dmM;
  private int dmN;
  private int dmO;
  private int dmP;
  private int[] dmQ;
  private SparseIntArray dmR;
  private c dmS;
  private c.a dmT;
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62270);
    this.dmJ = -1;
    this.dmS = new c(this);
    this.dmC = new ArrayList();
    this.dmT = new c.a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout, paramInt, 0);
    this.dmE = paramContext.getInt(d.a.FlexboxLayout_flexDirection, 0);
    this.dmF = paramContext.getInt(d.a.FlexboxLayout_flexWrap, 0);
    this.dmG = paramContext.getInt(d.a.FlexboxLayout_justifyContent, 0);
    this.dmH = paramContext.getInt(d.a.FlexboxLayout_alignItems, 0);
    this.dmI = paramContext.getInt(d.a.FlexboxLayout_alignContent, 0);
    this.dmJ = paramContext.getInt(d.a.FlexboxLayout_maxLine, -1);
    paramAttributeSet = paramContext.getDrawable(d.a.FlexboxLayout_dividerDrawable);
    if (paramAttributeSet != null)
    {
      setDividerDrawableHorizontal(paramAttributeSet);
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(d.a.FlexboxLayout_dividerDrawableHorizontal);
    if (paramAttributeSet != null) {
      setDividerDrawableHorizontal(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(d.a.FlexboxLayout_dividerDrawableVertical);
    if (paramAttributeSet != null) {
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramInt = paramContext.getInt(d.a.FlexboxLayout_showDivider, 0);
    if (paramInt != 0)
    {
      this.dmN = paramInt;
      this.dmM = paramInt;
    }
    paramInt = paramContext.getInt(d.a.FlexboxLayout_showDividerVertical, 0);
    if (paramInt != 0) {
      this.dmN = paramInt;
    }
    paramInt = paramContext.getInt(d.a.FlexboxLayout_showDividerHorizontal, 0);
    if (paramInt != 0) {
      this.dmM = paramInt;
    }
    paramContext.recycle();
    AppMethodBeat.o(62270);
  }
  
  private void Vn()
  {
    AppMethodBeat.i(62308);
    if ((this.dmK == null) && (this.dmL == null))
    {
      setWillNotDraw(true);
      AppMethodBeat.o(62308);
      return;
    }
    setWillNotDraw(false);
    AppMethodBeat.o(62308);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62287);
    if (this.dmL == null)
    {
      AppMethodBeat.o(62287);
      return;
    }
    this.dmL.setBounds(paramInt1, paramInt2, this.dmP + paramInt1, paramInt2 + paramInt3);
    this.dmL.draw(paramCanvas);
    AppMethodBeat.o(62287);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62285);
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.dmC.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.dmC.get(i);
      int j = 0;
      if (j < localb.cau)
      {
        int k = localb.dmu + j;
        View localView = iZ(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (cp(k, j))
          {
            if (!paramBoolean1) {
              break label240;
            }
            k = localView.getRight() + localLayoutParams.rightMargin;
            label154:
            a(paramCanvas, k, localb.cey, localb.dmn);
          }
          if ((j == localb.cau - 1) && ((this.dmN & 0x4) > 0)) {
            if (!paramBoolean1) {
              break label261;
            }
          }
        }
        for (k = localView.getLeft() - localLayoutParams.leftMargin - this.dmP;; k = localLayoutParams.rightMargin + k)
        {
          a(paramCanvas, k, localb.cey, localb.dmn);
          j += 1;
          break;
          label240:
          k = localView.getLeft() - localLayoutParams.leftMargin - this.dmP;
          break label154;
          label261:
          k = localView.getRight();
        }
      }
      if (ja(i))
      {
        if (paramBoolean2)
        {
          j = localb.cez;
          label301:
          b(paramCanvas, m, j, n);
        }
      }
      else if ((jc(i)) && ((this.dmM & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label381;
        }
      }
      label381:
      for (j = localb.cey - this.dmO;; j = localb.cez)
      {
        b(paramCanvas, m, j, n);
        i += 1;
        break;
        j = localb.cey - this.dmO;
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
    int i2 = this.dmC.size();
    paramInt3 = 0;
    paramInt2 = i;
    Object localObject;
    float f1;
    float f2;
    float f3;
    float f5;
    label237:
    View localView;
    float f4;
    LayoutParams localLayoutParams;
    int k;
    if (paramInt3 < i2)
    {
      localObject = (b)this.dmC.get(paramInt3);
      paramInt4 = paramInt1;
      i = paramInt2;
      if (ja(paramInt3))
      {
        i = paramInt2 + this.dmP;
        paramInt4 = paramInt1 - this.dmP;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.dmG)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.dmG);
        AppMethodBeat.o(62283);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).cau)
        {
          j = ((b)localObject).dmu + paramInt1;
          localView = iZ(j);
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
              if (!cp(j, paramInt1)) {
                break label939;
              }
              paramInt2 = this.dmO;
              f3 = paramInt2;
              f1 -= paramInt2;
              f2 += f3;
            }
          }
        }
        break;
      }
    }
    label939:
    for (;;)
    {
      j = k;
      if (paramInt1 == ((b)localObject).cau - 1)
      {
        j = k;
        if ((this.dmM & 0x4) > 0) {
          j = this.dmO;
        }
      }
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.dmS.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
          label448:
          f2 += localView.getMeasuredHeight() + f5 + localLayoutParams.bottomMargin;
          f1 -= localView.getMeasuredHeight() + f5 + localLayoutParams.topMargin;
          if (!paramBoolean2) {
            break label880;
          }
          ((b)localObject).k(localView, 0, j, 0, paramInt2);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        f3 = f2;
        break label237;
        f2 = i1 - ((b)localObject).dml + n;
        f1 = ((b)localObject).dml - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).dml) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).dml) / 2.0F;
        break;
        paramInt1 = ((b)localObject).Vl();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).dml) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).Vl();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).dml) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).Vl();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).dml) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.dmS.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
        break label448;
        if (paramBoolean2)
        {
          this.dmS.a(localView, (b)localObject, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          break label448;
        }
        this.dmS.a(localView, (b)localObject, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        break label448;
        label880:
        ((b)localObject).k(localView, 0, paramInt2, 0, j);
        f4 = f1;
        f1 = f4;
      }
      paramInt2 = i + ((b)localObject).dmn;
      paramInt1 = paramInt4 - ((b)localObject).dmn;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62283);
      return;
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62288);
    if (this.dmK == null)
    {
      AppMethodBeat.o(62288);
      return;
    }
    this.dmK.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.dmO + paramInt2);
    this.dmK.draw(paramCanvas);
    AppMethodBeat.o(62288);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62286);
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.dmC.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.dmC.get(i);
      int j = 0;
      if (j < localb.cau)
      {
        int k = localb.dmu + j;
        View localView = iZ(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (cp(k, j))
          {
            if (!paramBoolean2) {
              break label241;
            }
            k = localView.getBottom() + localLayoutParams.bottomMargin;
            label155:
            b(paramCanvas, localb.uE, k, localb.dmn);
          }
          if ((j == localb.cau - 1) && ((this.dmM & 0x4) > 0)) {
            if (!paramBoolean2) {
              break label262;
            }
          }
        }
        for (k = localView.getTop() - localLayoutParams.topMargin - this.dmO;; k = localLayoutParams.bottomMargin + k)
        {
          b(paramCanvas, localb.uE, k, localb.dmn);
          j += 1;
          break;
          label241:
          k = localView.getTop() - localLayoutParams.topMargin - this.dmO;
          break label155;
          label262:
          k = localView.getBottom();
        }
      }
      if (ja(i))
      {
        if (paramBoolean1)
        {
          j = localb.uF;
          label302:
          a(paramCanvas, j, m, n);
        }
      }
      else if ((jc(i)) && ((this.dmN & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label382;
        }
      }
      label382:
      for (j = localb.uE - this.dmP;; j = localb.uF)
      {
        a(paramCanvas, j, m, n);
        i += 1;
        break;
        j = localb.uE - this.dmP;
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
    int i2 = this.dmC.size();
    paramInt3 = 0;
    Object localObject;
    int i;
    float f1;
    float f2;
    float f3;
    float f5;
    label225:
    int j;
    View localView;
    float f4;
    LayoutParams localLayoutParams;
    int k;
    if (paramInt3 < i2)
    {
      localObject = (b)this.dmC.get(paramInt3);
      paramInt4 = paramInt2;
      i = paramInt1;
      if (ja(paramInt3))
      {
        paramInt4 = paramInt2 - this.dmO;
        i = paramInt1 + this.dmO;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.dmG)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.dmG);
        AppMethodBeat.o(62282);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).cau)
        {
          j = ((b)localObject).dmu + paramInt1;
          localView = iZ(j);
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
              if (!cp(j, paramInt1)) {
                break label920;
              }
              paramInt2 = this.dmP;
              f3 = paramInt2;
              f1 -= paramInt2;
              f2 += f3;
            }
          }
        }
        break;
      }
    }
    label920:
    for (;;)
    {
      j = k;
      if (paramInt1 == ((b)localObject).cau - 1)
      {
        j = k;
        if ((this.dmN & 0x4) > 0) {
          j = this.dmP;
        }
      }
      if (this.dmF == 2) {
        if (paramBoolean)
        {
          this.dmS.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), paramInt4 - localView.getMeasuredHeight(), Math.round(f1), paramInt4);
          label435:
          f2 += localView.getMeasuredWidth() + f5 + localLayoutParams.rightMargin;
          f1 -= localView.getMeasuredWidth() + f5 + localLayoutParams.leftMargin;
          if (!paramBoolean) {
            break label863;
          }
          ((b)localObject).k(localView, j, 0, paramInt2, 0);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        f3 = f2;
        break label225;
        f2 = i1 - ((b)localObject).dml + n;
        f1 = ((b)localObject).dml - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).dml) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).dml) / 2.0F;
        break;
        paramInt1 = ((b)localObject).Vl();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).dml) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).Vl();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).dml) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).Vl();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).dml) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.dmS.a(localView, (b)localObject, Math.round(f2), paramInt4 - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), paramInt4);
        break label435;
        if (paramBoolean)
        {
          this.dmS.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), i, Math.round(f1), i + localView.getMeasuredHeight());
          break label435;
        }
        this.dmS.a(localView, (b)localObject, Math.round(f2), i, Math.round(f2) + localView.getMeasuredWidth(), i + localView.getMeasuredHeight());
        break label435;
        label863:
        ((b)localObject).k(localView, paramInt2, 0, j, 0);
        f4 = f1;
        f1 = f4;
      }
      paramInt1 = i + ((b)localObject).dmn;
      paramInt2 = paramInt4 - ((b)localObject).dmn;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62282);
      return;
    }
  }
  
  private boolean cp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62309);
    if (cq(paramInt1, paramInt2))
    {
      if (Ve())
      {
        if ((this.dmN & 0x1) != 0)
        {
          AppMethodBeat.o(62309);
          return true;
        }
        AppMethodBeat.o(62309);
        return false;
      }
      if ((this.dmM & 0x1) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if (Ve())
    {
      if ((this.dmN & 0x2) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if ((this.dmM & 0x2) != 0)
    {
      AppMethodBeat.o(62309);
      return true;
    }
    AppMethodBeat.o(62309);
    return false;
  }
  
  private boolean cq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62310);
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = iZ(paramInt1 - i);
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
  
  private View iZ(int paramInt)
  {
    AppMethodBeat.i(62274);
    if ((paramInt < 0) || (paramInt >= this.dmQ.length))
    {
      AppMethodBeat.o(62274);
      return null;
    }
    View localView = getChildAt(this.dmQ[paramInt]);
    AppMethodBeat.o(62274);
    return localView;
  }
  
  private boolean ja(int paramInt)
  {
    AppMethodBeat.i(62311);
    if ((paramInt < 0) || (paramInt >= this.dmC.size()))
    {
      AppMethodBeat.o(62311);
      return false;
    }
    if (jb(paramInt))
    {
      if (Ve())
      {
        if ((this.dmM & 0x1) != 0)
        {
          AppMethodBeat.o(62311);
          return true;
        }
        AppMethodBeat.o(62311);
        return false;
      }
      if ((this.dmN & 0x1) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if (Ve())
    {
      if ((this.dmM & 0x2) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if ((this.dmN & 0x2) != 0)
    {
      AppMethodBeat.o(62311);
      return true;
    }
    AppMethodBeat.o(62311);
    return false;
  }
  
  private boolean jb(int paramInt)
  {
    AppMethodBeat.i(62312);
    int i = 0;
    while (i < paramInt)
    {
      if (((b)this.dmC.get(i)).Vl() > 0)
      {
        AppMethodBeat.o(62312);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(62312);
    return true;
  }
  
  private boolean jc(int paramInt)
  {
    AppMethodBeat.i(62313);
    if ((paramInt < 0) || (paramInt >= this.dmC.size()))
    {
      AppMethodBeat.o(62313);
      return false;
    }
    paramInt += 1;
    while (paramInt < this.dmC.size())
    {
      if (((b)this.dmC.get(paramInt)).Vl() > 0)
      {
        AppMethodBeat.o(62313);
        return false;
      }
      paramInt += 1;
    }
    if (Ve())
    {
      if ((this.dmM & 0x4) != 0)
      {
        AppMethodBeat.o(62313);
        return true;
      }
      AppMethodBeat.o(62313);
      return false;
    }
    if ((this.dmN & 0x4) != 0)
    {
      AppMethodBeat.o(62313);
      return true;
    }
    AppMethodBeat.o(62313);
    return false;
  }
  
  private void o(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62277);
    this.dmC.clear();
    this.dmT.reset();
    this.dmS.a(this.dmT, paramInt1, paramInt2, 2147483647, 0, -1, null);
    this.dmC = this.dmT.dmC;
    this.dmS.K(paramInt1, paramInt2, 0);
    b localb;
    int i;
    int j;
    label110:
    View localView;
    LayoutParams localLayoutParams;
    int k;
    int m;
    if (this.dmH == 3)
    {
      Iterator localIterator = this.dmC.iterator();
      if (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        i = -2147483648;
        j = 0;
        if (j < localb.cau)
        {
          localView = iZ(localb.dmu + j);
          if ((localView == null) || (localView.getVisibility() == 8)) {
            break label332;
          }
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (this.dmF != 2)
          {
            k = Math.max(localb.dmr - localView.getBaseline(), localLayoutParams.topMargin);
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
      k = Math.max(localb.dmr - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
      m = localView.getMeasuredHeight();
      i = Math.max(i, localLayoutParams.topMargin + m + k);
      continue;
      localb.dmn = i;
      break;
      this.dmS.L(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
      this.dmS.iV(0);
      w(this.dmE, paramInt1, paramInt2, this.dmT.dmD);
      AppMethodBeat.o(62277);
      return;
    }
  }
  
  private void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public final int I(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62299);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62299);
    return paramInt1;
  }
  
  public final int J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62300);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62300);
    return paramInt1;
  }
  
  public final boolean Ve()
  {
    return (this.dmE == 0) || (this.dmE == 1);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62301);
    if (cp(paramInt1, paramInt2))
    {
      if (Ve())
      {
        paramb.dml += this.dmP;
        paramb.dmm += this.dmP;
        AppMethodBeat.o(62301);
        return;
      }
      paramb.dml += this.dmO;
      paramb.dmm += this.dmO;
    }
    AppMethodBeat.o(62301);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(62298);
    if (Ve())
    {
      if ((this.dmN & 0x4) > 0)
      {
        paramb.dml += this.dmP;
        paramb.dmm += this.dmP;
        AppMethodBeat.o(62298);
      }
    }
    else if ((this.dmM & 0x4) > 0)
    {
      paramb.dml += this.dmO;
      paramb.dmm += this.dmO;
    }
    AppMethodBeat.o(62298);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62276);
    if (this.dmR == null) {
      this.dmR = new SparseIntArray(getChildCount());
    }
    this.dmQ = this.dmS.a(paramView, paramInt, paramLayoutParams, this.dmR);
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(62276);
  }
  
  public final void b(int paramInt, View paramView) {}
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final int cn(View paramView)
  {
    return 0;
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
    return this.dmI;
  }
  
  public int getAlignItems()
  {
    return this.dmH;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.dmK;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.dmL;
  }
  
  public int getFlexDirection()
  {
    return this.dmE;
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
    ArrayList localArrayList = new ArrayList(this.dmC.size());
    Iterator localIterator = this.dmC.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.Vl() != 0) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(62296);
    return localArrayList;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.dmC;
  }
  
  public int getFlexWrap()
  {
    return this.dmF;
  }
  
  public int getJustifyContent()
  {
    return this.dmG;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62279);
    Iterator localIterator = this.dmC.iterator();
    for (int i = -2147483648; localIterator.hasNext(); i = Math.max(i, ((b)localIterator.next()).dml)) {}
    AppMethodBeat.o(62279);
    return i;
  }
  
  public int getMaxLine()
  {
    return this.dmJ;
  }
  
  public int getShowDividerHorizontal()
  {
    return this.dmM;
  }
  
  public int getShowDividerVertical()
  {
    return this.dmN;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62280);
    int m = this.dmC.size();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      b localb = (b)this.dmC.get(k);
      int i = j;
      if (ja(k))
      {
        if (Ve()) {
          i = j + this.dmO;
        }
      }
      else
      {
        label66:
        j = i;
        if (jc(k)) {
          if (!Ve()) {
            break label115;
          }
        }
      }
      label115:
      for (j = i + this.dmO;; j = i + this.dmP)
      {
        j += localb.dmn;
        k += 1;
        break;
        i = j + this.dmP;
        break label66;
      }
    }
    AppMethodBeat.o(62280);
    return j;
  }
  
  public final View iR(int paramInt)
  {
    AppMethodBeat.i(62273);
    View localView = getChildAt(paramInt);
    AppMethodBeat.o(62273);
    return localView;
  }
  
  public final View iS(int paramInt)
  {
    AppMethodBeat.i(62275);
    View localView = iZ(paramInt);
    AppMethodBeat.o(62275);
    return localView;
  }
  
  public final int k(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62297);
    int j = 0;
    int i = 0;
    if (Ve())
    {
      if (cp(paramInt1, paramInt2)) {
        i = this.dmP + 0;
      }
      paramInt1 = i;
      if ((this.dmN & 0x4) > 0) {
        paramInt1 = i + this.dmP;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62297);
      return paramInt1;
      i = j;
      if (cp(paramInt1, paramInt2)) {
        i = this.dmO + 0;
      }
      paramInt1 = i;
      if ((this.dmM & 0x4) > 0) {
        paramInt1 = i + this.dmO;
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
    if ((this.dmL == null) && (this.dmK == null))
    {
      AppMethodBeat.o(62284);
      return;
    }
    if ((this.dmM == 0) && (this.dmN == 0))
    {
      AppMethodBeat.o(62284);
      return;
    }
    int i = z.U(this);
    boolean bool1;
    switch (this.dmE)
    {
    default: 
      AppMethodBeat.o(62284);
      return;
    case 0: 
      if (i == 1)
      {
        bool1 = true;
        label114:
        if (this.dmF != 2) {
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
        if (this.dmF != 2) {
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
          if (this.dmF != 2) {
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
            if (this.dmF != 2) {
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
    int i = z.U(this);
    switch (this.dmE)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.dmE);
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
        if (this.dmF != 2) {
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
        if (this.dmF != 2) {
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
    if (this.dmR == null) {
      this.dmR = new SparseIntArray(getChildCount());
    }
    if (this.dmS.b(this.dmR)) {
      this.dmQ = this.dmS.a(this.dmR);
    }
    switch (this.dmE)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.dmE);
      AppMethodBeat.o(62271);
      throw localIllegalStateException;
    case 0: 
    case 1: 
      o(paramInt1, paramInt2);
      AppMethodBeat.o(62271);
      return;
    }
    this.dmC.clear();
    this.dmT.reset();
    this.dmS.a(this.dmT, paramInt1, paramInt2);
    this.dmC = this.dmT.dmC;
    this.dmS.cn(paramInt1, paramInt2);
    this.dmS.L(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.dmS.Vm();
    w(this.dmE, paramInt1, paramInt2, this.dmT.dmD);
    AppMethodBeat.o(62271);
  }
  
  public void setAlignContent(int paramInt)
  {
    AppMethodBeat.i(62294);
    if (this.dmI != paramInt)
    {
      this.dmI = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62294);
  }
  
  public void setAlignItems(int paramInt)
  {
    AppMethodBeat.i(62293);
    if (this.dmH != paramInt)
    {
      this.dmH = paramInt;
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
    if (paramDrawable == this.dmK)
    {
      AppMethodBeat.o(62303);
      return;
    }
    this.dmK = paramDrawable;
    if (paramDrawable != null) {}
    for (this.dmO = paramDrawable.getIntrinsicHeight();; this.dmO = 0)
    {
      Vn();
      requestLayout();
      AppMethodBeat.o(62303);
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(62304);
    if (paramDrawable == this.dmL)
    {
      AppMethodBeat.o(62304);
      return;
    }
    this.dmL = paramDrawable;
    if (paramDrawable != null) {}
    for (this.dmP = paramDrawable.getIntrinsicWidth();; this.dmP = 0)
    {
      Vn();
      requestLayout();
      AppMethodBeat.o(62304);
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62290);
    if (this.dmE != paramInt)
    {
      this.dmE = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62290);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.dmC = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(62291);
    if (this.dmF != paramInt)
    {
      this.dmF = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62291);
  }
  
  public void setJustifyContent(int paramInt)
  {
    AppMethodBeat.i(62292);
    if (this.dmG != paramInt)
    {
      this.dmG = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62292);
  }
  
  public void setMaxLine(int paramInt)
  {
    AppMethodBeat.i(62295);
    if (this.dmJ != paramInt)
    {
      this.dmJ = paramInt;
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
    if (paramInt != this.dmM)
    {
      this.dmM = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62307);
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(62306);
    if (paramInt != this.dmN)
    {
      this.dmN = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62306);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private int biW;
    private int bkR;
    private int dmU;
    private float dmV;
    public float dmW;
    private int dmX;
    private float dmY;
    private boolean dmZ;
    private int mf;
    private int vF;
    
    static
    {
      AppMethodBeat.i(62269);
      CREATOR = new FlexboxLayout.LayoutParams.1();
      AppMethodBeat.o(62269);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(62266);
      this.dmU = 1;
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.mf = -1;
      this.biW = -1;
      this.vF = 16777215;
      this.bkR = 16777215;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.FlexboxLayout_Layout);
      this.dmU = paramContext.getInt(d.a.FlexboxLayout_Layout_layout_order, 1);
      this.dmV = paramContext.getFloat(d.a.FlexboxLayout_Layout_layout_flexGrow, 0.0F);
      this.dmW = paramContext.getFloat(d.a.FlexboxLayout_Layout_layout_flexShrink, 1.0F);
      this.dmX = paramContext.getInt(d.a.FlexboxLayout_Layout_layout_alignSelf, -1);
      this.dmY = paramContext.getFraction(d.a.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0F);
      this.mf = paramContext.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_minWidth, -1);
      this.biW = paramContext.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_minHeight, -1);
      this.vF = paramContext.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_maxWidth, 16777215);
      this.bkR = paramContext.getDimensionPixelSize(d.a.FlexboxLayout_Layout_layout_maxHeight, 16777215);
      this.dmZ = paramContext.getBoolean(d.a.FlexboxLayout_Layout_layout_wrapBefore, false);
      paramContext.recycle();
      AppMethodBeat.o(62266);
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(0);
      AppMethodBeat.i(62268);
      this.dmU = 1;
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.mf = -1;
      this.biW = -1;
      this.vF = 16777215;
      this.bkR = 16777215;
      this.dmU = paramParcel.readInt();
      this.dmV = paramParcel.readFloat();
      this.dmW = paramParcel.readFloat();
      this.dmX = paramParcel.readInt();
      this.dmY = paramParcel.readFloat();
      this.mf = paramParcel.readInt();
      this.biW = paramParcel.readInt();
      this.vF = paramParcel.readInt();
      this.bkR = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.dmZ = bool;
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
      this.dmU = 1;
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.mf = -1;
      this.biW = -1;
      this.vF = 16777215;
      this.bkR = 16777215;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.dmU = 1;
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.mf = -1;
      this.biW = -1;
      this.vF = 16777215;
      this.bkR = 16777215;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.dmU = 1;
      this.dmV = 0.0F;
      this.dmW = 1.0F;
      this.dmX = -1;
      this.dmY = -1.0F;
      this.mf = -1;
      this.biW = -1;
      this.vF = 16777215;
      this.bkR = 16777215;
      this.dmU = paramLayoutParams.dmU;
      this.dmV = paramLayoutParams.dmV;
      this.dmW = paramLayoutParams.dmW;
      this.dmX = paramLayoutParams.dmX;
      this.dmY = paramLayoutParams.dmY;
      this.mf = paramLayoutParams.mf;
      this.biW = paramLayoutParams.biW;
      this.vF = paramLayoutParams.vF;
      this.bkR = paramLayoutParams.bkR;
      this.dmZ = paramLayoutParams.dmZ;
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
      return this.dmU;
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
      AppMethodBeat.i(62267);
      paramParcel.writeInt(this.dmU);
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
        AppMethodBeat.o(62267);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout
 * JD-Core Version:    0.7.0.1
 */