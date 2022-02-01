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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlexboxLayout
  extends ViewGroup
  implements a
{
  private List<b> bsY;
  private int bta;
  private int btb;
  private int btc;
  private int btd;
  private int bte;
  private int btf;
  private Drawable btg;
  private Drawable bth;
  private int bti;
  private int btj;
  private int btk;
  private int btl;
  private int[] btm;
  private SparseIntArray bto;
  private c btp;
  private c.a btq;
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlexboxLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62270);
    this.btf = -1;
    this.btp = new c(this);
    this.bsY = new ArrayList();
    this.btq = new c.a();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.btN, paramInt, 0);
    this.bta = paramContext.getInt(d.a.btT, 0);
    this.btb = paramContext.getInt(d.a.btU, 0);
    this.btc = paramContext.getInt(d.a.btV, 0);
    this.btd = paramContext.getInt(d.a.btP, 4);
    this.bte = paramContext.getInt(d.a.btO, 5);
    this.btf = paramContext.getInt(d.a.btW, -1);
    paramAttributeSet = paramContext.getDrawable(d.a.btQ);
    if (paramAttributeSet != null)
    {
      setDividerDrawableHorizontal(paramAttributeSet);
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(d.a.btR);
    if (paramAttributeSet != null) {
      setDividerDrawableHorizontal(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(d.a.btS);
    if (paramAttributeSet != null) {
      setDividerDrawableVertical(paramAttributeSet);
    }
    paramInt = paramContext.getInt(d.a.btX, 0);
    if (paramInt != 0)
    {
      this.btj = paramInt;
      this.bti = paramInt;
    }
    paramInt = paramContext.getInt(d.a.btZ, 0);
    if (paramInt != 0) {
      this.btj = paramInt;
    }
    paramInt = paramContext.getInt(d.a.btY, 0);
    if (paramInt != 0) {
      this.bti = paramInt;
    }
    paramContext.recycle();
    AppMethodBeat.o(62270);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62287);
    if (this.bth == null)
    {
      AppMethodBeat.o(62287);
      return;
    }
    this.bth.setBounds(paramInt1, paramInt2, this.btl + paramInt1, paramInt2 + paramInt3);
    this.bth.draw(paramCanvas);
    AppMethodBeat.o(62287);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62285);
    int m = getPaddingLeft();
    int i = getPaddingRight();
    int n = Math.max(0, getWidth() - i - m);
    int i1 = this.bsY.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bsY.get(i);
      int j = 0;
      if (j < localb.alU)
      {
        int k = localb.bsS + j;
        View localView = fK(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bu(k, j))
          {
            if (!paramBoolean1) {
              break label240;
            }
            k = localView.getRight() + localLayoutParams.rightMargin;
            label154:
            a(paramCanvas, k, localb.apP, localb.bsL);
          }
          if ((j == localb.alU - 1) && ((this.btj & 0x4) > 0)) {
            if (!paramBoolean1) {
              break label261;
            }
          }
        }
        for (k = localView.getLeft() - localLayoutParams.leftMargin - this.btl;; k = localLayoutParams.rightMargin + k)
        {
          a(paramCanvas, k, localb.apP, localb.bsL);
          j += 1;
          break;
          label240:
          k = localView.getLeft() - localLayoutParams.leftMargin - this.btl;
          break label154;
          label261:
          k = localView.getRight();
        }
      }
      if (fL(i))
      {
        if (paramBoolean2)
        {
          j = localb.apQ;
          label301:
          b(paramCanvas, m, j, n);
        }
      }
      else if ((fN(i)) && ((this.bti & 0x4) > 0)) {
        if (!paramBoolean2) {
          break label381;
        }
      }
      label381:
      for (j = localb.apP - this.btk;; j = localb.apQ)
      {
        b(paramCanvas, m, j, n);
        i += 1;
        break;
        j = localb.apP - this.btk;
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
    int i2 = this.bsY.size();
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
      localObject = (b)this.bsY.get(paramInt3);
      paramInt4 = paramInt1;
      i = paramInt2;
      if (fL(paramInt3))
      {
        i = paramInt2 + this.btl;
        paramInt4 = paramInt1 - this.btl;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.btc)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.btc);
        AppMethodBeat.o(62283);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).alU)
        {
          j = ((b)localObject).bsS + paramInt1;
          localView = fK(j);
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
              if (!bu(j, paramInt1)) {
                break label939;
              }
              paramInt2 = this.btk;
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
      if (paramInt1 == ((b)localObject).alU - 1)
      {
        j = k;
        if ((this.bti & 0x4) > 0) {
          j = this.btk;
        }
      }
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          this.btp.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f1) - localView.getMeasuredHeight(), paramInt4, Math.round(f1));
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
        f2 = i1 - ((b)localObject).bsJ + n;
        f1 = ((b)localObject).bsJ - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bsJ) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bsJ) / 2.0F;
        break;
        paramInt1 = ((b)localObject).vM();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bsJ) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).vM();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bsJ) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).vM();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bsJ) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.btp.a(localView, (b)localObject, true, paramInt4 - localView.getMeasuredWidth(), Math.round(f2), paramInt4, Math.round(f2) + localView.getMeasuredHeight());
        break label448;
        if (paramBoolean2)
        {
          this.btp.a(localView, (b)localObject, false, i, Math.round(f1) - localView.getMeasuredHeight(), i + localView.getMeasuredWidth(), Math.round(f1));
          break label448;
        }
        this.btp.a(localView, (b)localObject, false, i, Math.round(f2), i + localView.getMeasuredWidth(), Math.round(f2) + localView.getMeasuredHeight());
        break label448;
        label880:
        ((b)localObject).k(localView, 0, paramInt2, 0, j);
        f4 = f1;
        f1 = f4;
      }
      paramInt2 = i + ((b)localObject).bsL;
      paramInt1 = paramInt4 - ((b)localObject).bsL;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62283);
      return;
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62288);
    if (this.btg == null)
    {
      AppMethodBeat.o(62288);
      return;
    }
    this.btg.setBounds(paramInt1, paramInt2, paramInt1 + paramInt3, this.btk + paramInt2);
    this.btg.draw(paramCanvas);
    AppMethodBeat.o(62288);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62286);
    int m = getPaddingTop();
    int i = getPaddingBottom();
    int n = Math.max(0, getHeight() - i - m);
    int i1 = this.bsY.size();
    i = 0;
    if (i < i1)
    {
      b localb = (b)this.bsY.get(i);
      int j = 0;
      if (j < localb.alU)
      {
        int k = localb.bsS + j;
        View localView = fK(k);
        LayoutParams localLayoutParams;
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (bu(k, j))
          {
            if (!paramBoolean2) {
              break label241;
            }
            k = localView.getBottom() + localLayoutParams.bottomMargin;
            label155:
            b(paramCanvas, localb.tF, k, localb.bsL);
          }
          if ((j == localb.alU - 1) && ((this.bti & 0x4) > 0)) {
            if (!paramBoolean2) {
              break label262;
            }
          }
        }
        for (k = localView.getTop() - localLayoutParams.topMargin - this.btk;; k = localLayoutParams.bottomMargin + k)
        {
          b(paramCanvas, localb.tF, k, localb.bsL);
          j += 1;
          break;
          label241:
          k = localView.getTop() - localLayoutParams.topMargin - this.btk;
          break label155;
          label262:
          k = localView.getBottom();
        }
      }
      if (fL(i))
      {
        if (paramBoolean1)
        {
          j = localb.tG;
          label302:
          a(paramCanvas, j, m, n);
        }
      }
      else if ((fN(i)) && ((this.btj & 0x4) > 0)) {
        if (!paramBoolean1) {
          break label382;
        }
      }
      label382:
      for (j = localb.tF - this.btl;; j = localb.tG)
      {
        a(paramCanvas, j, m, n);
        i += 1;
        break;
        j = localb.tF - this.btl;
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
    int i2 = this.bsY.size();
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
      localObject = (b)this.bsY.get(paramInt3);
      paramInt4 = paramInt2;
      i = paramInt1;
      if (fL(paramInt3))
      {
        paramInt4 = paramInt2 - this.btk;
        i = paramInt1 + this.btk;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      switch (this.btc)
      {
      default: 
        localObject = new IllegalStateException("Invalid justifyContent is set: " + this.btc);
        AppMethodBeat.o(62282);
        throw ((Throwable)localObject);
      case 0: 
        f2 = m;
        f1 = i1 - n;
        f5 = Math.max(f3, 0.0F);
        paramInt1 = 0;
        f3 = f2;
        if (paramInt1 < ((b)localObject).alU)
        {
          j = ((b)localObject).bsS + paramInt1;
          localView = fK(j);
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
              if (!bu(j, paramInt1)) {
                break label920;
              }
              paramInt2 = this.btl;
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
      if (paramInt1 == ((b)localObject).alU - 1)
      {
        j = k;
        if ((this.btj & 0x4) > 0) {
          j = this.btl;
        }
      }
      if (this.btb == 2) {
        if (paramBoolean)
        {
          this.btp.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), paramInt4 - localView.getMeasuredHeight(), Math.round(f1), paramInt4);
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
        f2 = i1 - ((b)localObject).bsJ + n;
        f1 = ((b)localObject).bsJ - m;
        break;
        f1 = m;
        f2 = (i1 - ((b)localObject).bsJ) / 2.0F + f1;
        f1 = i1 - n - (i1 - ((b)localObject).bsJ) / 2.0F;
        break;
        paramInt1 = ((b)localObject).vM();
        f3 = f1;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bsJ) / paramInt1;
        }
        f1 = m;
        f2 = f3 / 2.0F + f1;
        f1 = i1 - n - f3 / 2.0F;
        break;
        f2 = m;
        paramInt1 = ((b)localObject).vM();
        if (paramInt1 != 1) {}
        for (f1 = paramInt1 - 1;; f1 = 1.0F)
        {
          f3 = (i1 - ((b)localObject).bsJ) / f1;
          f1 = i1 - n;
          break;
        }
        paramInt1 = ((b)localObject).vM();
        f3 = f2;
        if (paramInt1 != 0) {
          f3 = (i1 - ((b)localObject).bsJ) / (paramInt1 + 1);
        }
        f2 = m + f3;
        f1 = i1 - n - f3;
        break;
        this.btp.a(localView, (b)localObject, Math.round(f2), paramInt4 - localView.getMeasuredHeight(), Math.round(f2) + localView.getMeasuredWidth(), paramInt4);
        break label435;
        if (paramBoolean)
        {
          this.btp.a(localView, (b)localObject, Math.round(f1) - localView.getMeasuredWidth(), i, Math.round(f1), i + localView.getMeasuredHeight());
          break label435;
        }
        this.btp.a(localView, (b)localObject, Math.round(f2), i, Math.round(f2) + localView.getMeasuredWidth(), i + localView.getMeasuredHeight());
        break label435;
        label863:
        ((b)localObject).k(localView, paramInt2, 0, j, 0);
        f4 = f1;
        f1 = f4;
      }
      paramInt1 = i + ((b)localObject).bsL;
      paramInt2 = paramInt4 - ((b)localObject).bsL;
      paramInt3 += 1;
      break;
      AppMethodBeat.o(62282);
      return;
    }
  }
  
  private boolean bu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62309);
    if (bv(paramInt1, paramInt2))
    {
      if (vF())
      {
        if ((this.btj & 0x1) != 0)
        {
          AppMethodBeat.o(62309);
          return true;
        }
        AppMethodBeat.o(62309);
        return false;
      }
      if ((this.bti & 0x1) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if (vF())
    {
      if ((this.btj & 0x2) != 0)
      {
        AppMethodBeat.o(62309);
        return true;
      }
      AppMethodBeat.o(62309);
      return false;
    }
    if ((this.bti & 0x2) != 0)
    {
      AppMethodBeat.o(62309);
      return true;
    }
    AppMethodBeat.o(62309);
    return false;
  }
  
  private boolean bv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62310);
    int i = 1;
    while (i <= paramInt2)
    {
      View localView = fK(paramInt1 - i);
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
  
  private View fK(int paramInt)
  {
    AppMethodBeat.i(62274);
    if ((paramInt < 0) || (paramInt >= this.btm.length))
    {
      AppMethodBeat.o(62274);
      return null;
    }
    View localView = getChildAt(this.btm[paramInt]);
    AppMethodBeat.o(62274);
    return localView;
  }
  
  private boolean fL(int paramInt)
  {
    AppMethodBeat.i(62311);
    if ((paramInt < 0) || (paramInt >= this.bsY.size()))
    {
      AppMethodBeat.o(62311);
      return false;
    }
    if (fM(paramInt))
    {
      if (vF())
      {
        if ((this.bti & 0x1) != 0)
        {
          AppMethodBeat.o(62311);
          return true;
        }
        AppMethodBeat.o(62311);
        return false;
      }
      if ((this.btj & 0x1) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if (vF())
    {
      if ((this.bti & 0x2) != 0)
      {
        AppMethodBeat.o(62311);
        return true;
      }
      AppMethodBeat.o(62311);
      return false;
    }
    if ((this.btj & 0x2) != 0)
    {
      AppMethodBeat.o(62311);
      return true;
    }
    AppMethodBeat.o(62311);
    return false;
  }
  
  private boolean fM(int paramInt)
  {
    AppMethodBeat.i(62312);
    int i = 0;
    while (i < paramInt)
    {
      if (((b)this.bsY.get(i)).vM() > 0)
      {
        AppMethodBeat.o(62312);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(62312);
    return true;
  }
  
  private boolean fN(int paramInt)
  {
    AppMethodBeat.i(62313);
    if ((paramInt < 0) || (paramInt >= this.bsY.size()))
    {
      AppMethodBeat.o(62313);
      return false;
    }
    paramInt += 1;
    while (paramInt < this.bsY.size())
    {
      if (((b)this.bsY.get(paramInt)).vM() > 0)
      {
        AppMethodBeat.o(62313);
        return false;
      }
      paramInt += 1;
    }
    if (vF())
    {
      if ((this.bti & 0x4) != 0)
      {
        AppMethodBeat.o(62313);
        return true;
      }
      AppMethodBeat.o(62313);
      return false;
    }
    if ((this.btj & 0x4) != 0)
    {
      AppMethodBeat.o(62313);
      return true;
    }
    AppMethodBeat.o(62313);
    return false;
  }
  
  private void j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62277);
    this.bsY.clear();
    this.btq.reset();
    this.btp.a(this.btq, paramInt1, paramInt2, 2147483647, 0, -1, null);
    this.bsY = this.btq.bsY;
    this.btp.u(paramInt1, paramInt2, 0);
    b localb;
    int i;
    int j;
    label110:
    View localView;
    LayoutParams localLayoutParams;
    int k;
    int m;
    if (this.btd == 3)
    {
      Iterator localIterator = this.bsY.iterator();
      if (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        i = -2147483648;
        j = 0;
        if (j < localb.alU)
        {
          localView = fK(localb.bsS + j);
          if ((localView == null) || (localView.getVisibility() == 8)) {
            break label332;
          }
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (this.btb != 2)
          {
            k = Math.max(localb.bsP - localView.getBaseline(), localLayoutParams.topMargin);
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
      k = Math.max(localb.bsP - localView.getMeasuredHeight() + localView.getBaseline(), localLayoutParams.bottomMargin);
      m = localView.getMeasuredHeight();
      i = Math.max(i, localLayoutParams.topMargin + m + k);
      continue;
      localb.bsL = i;
      break;
      this.btp.v(paramInt1, paramInt2, getPaddingTop() + getPaddingBottom());
      this.btp.fG(0);
      n(this.bta, paramInt1, paramInt2, this.btq.bsZ);
      AppMethodBeat.o(62277);
      return;
    }
  }
  
  private void n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  private void vO()
  {
    AppMethodBeat.i(62308);
    if ((this.btg == null) && (this.bth == null))
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
    if (bu(paramInt1, paramInt2))
    {
      if (vF())
      {
        paramb.bsJ += this.btl;
        paramb.bsK += this.btl;
        AppMethodBeat.o(62301);
        return;
      }
      paramb.bsJ += this.btk;
      paramb.bsK += this.btk;
    }
    AppMethodBeat.o(62301);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(62298);
    if (vF())
    {
      if ((this.btj & 0x4) > 0)
      {
        paramb.bsJ += this.btl;
        paramb.bsK += this.btl;
        AppMethodBeat.o(62298);
      }
    }
    else if ((this.bti & 0x4) > 0)
    {
      paramb.bsJ += this.btk;
      paramb.bsK += this.btk;
    }
    AppMethodBeat.o(62298);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(62276);
    if (this.bto == null) {
      this.bto = new SparseIntArray(getChildCount());
    }
    this.btm = this.btp.a(paramView, paramInt, paramLayoutParams, this.bto);
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(62276);
  }
  
  public final int bR(View paramView)
  {
    return 0;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final View fC(int paramInt)
  {
    AppMethodBeat.i(62273);
    View localView = getChildAt(paramInt);
    AppMethodBeat.o(62273);
    return localView;
  }
  
  public final View fD(int paramInt)
  {
    AppMethodBeat.i(62275);
    View localView = fK(paramInt);
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
    return this.bte;
  }
  
  public int getAlignItems()
  {
    return this.btd;
  }
  
  public Drawable getDividerDrawableHorizontal()
  {
    return this.btg;
  }
  
  public Drawable getDividerDrawableVertical()
  {
    return this.bth;
  }
  
  public int getFlexDirection()
  {
    return this.bta;
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
    ArrayList localArrayList = new ArrayList(this.bsY.size());
    Iterator localIterator = this.bsY.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.vM() != 0) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(62296);
    return localArrayList;
  }
  
  public List<b> getFlexLinesInternal()
  {
    return this.bsY;
  }
  
  public int getFlexWrap()
  {
    return this.btb;
  }
  
  public int getJustifyContent()
  {
    return this.btc;
  }
  
  public int getLargestMainSize()
  {
    AppMethodBeat.i(62279);
    Iterator localIterator = this.bsY.iterator();
    for (int i = -2147483648; localIterator.hasNext(); i = Math.max(i, ((b)localIterator.next()).bsJ)) {}
    AppMethodBeat.o(62279);
    return i;
  }
  
  public int getMaxLine()
  {
    return this.btf;
  }
  
  public int getShowDividerHorizontal()
  {
    return this.bti;
  }
  
  public int getShowDividerVertical()
  {
    return this.btj;
  }
  
  public int getSumOfCrossSize()
  {
    AppMethodBeat.i(62280);
    int m = this.bsY.size();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      b localb = (b)this.bsY.get(k);
      int i = j;
      if (fL(k))
      {
        if (vF()) {
          i = j + this.btk;
        }
      }
      else
      {
        label66:
        j = i;
        if (fN(k)) {
          if (!vF()) {
            break label115;
          }
        }
      }
      label115:
      for (j = i + this.btk;; j = i + this.btl)
      {
        j += localb.bsL;
        k += 1;
        break;
        i = j + this.btl;
        break label66;
      }
    }
    AppMethodBeat.o(62280);
    return j;
  }
  
  public final int k(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62297);
    int j = 0;
    int i = 0;
    if (vF())
    {
      if (bu(paramInt1, paramInt2)) {
        i = this.btl + 0;
      }
      paramInt1 = i;
      if ((this.btj & 0x4) > 0) {
        paramInt1 = i + this.btl;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62297);
      return paramInt1;
      i = j;
      if (bu(paramInt1, paramInt2)) {
        i = this.btk + 0;
      }
      paramInt1 = i;
      if ((this.bti & 0x4) > 0) {
        paramInt1 = i + this.btk;
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
    if ((this.bth == null) && (this.btg == null))
    {
      AppMethodBeat.o(62284);
      return;
    }
    if ((this.bti == 0) && (this.btj == 0))
    {
      AppMethodBeat.o(62284);
      return;
    }
    int i = w.I(this);
    boolean bool1;
    switch (this.bta)
    {
    default: 
      AppMethodBeat.o(62284);
      return;
    case 0: 
      if (i == 1)
      {
        bool1 = true;
        label114:
        if (this.btb != 2) {
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
        if (this.btb != 2) {
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
          if (this.btb != 2) {
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
            if (this.btb != 2) {
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
    int i = w.I(this);
    switch (this.bta)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.bta);
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
        if (this.btb != 2) {
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
        if (this.btb != 2) {
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
    if (this.bto == null) {
      this.bto = new SparseIntArray(getChildCount());
    }
    if (this.btp.b(this.bto)) {
      this.btm = this.btp.a(this.bto);
    }
    switch (this.bta)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.bta);
      AppMethodBeat.o(62271);
      throw localIllegalStateException;
    case 0: 
    case 1: 
      j(paramInt1, paramInt2);
      AppMethodBeat.o(62271);
      return;
    }
    this.bsY.clear();
    this.btq.reset();
    this.btp.a(this.btq, paramInt1, paramInt2);
    this.bsY = this.btq.bsY;
    this.btp.bs(paramInt1, paramInt2);
    this.btp.v(paramInt1, paramInt2, getPaddingLeft() + getPaddingRight());
    this.btp.vN();
    n(this.bta, paramInt1, paramInt2, this.btq.bsZ);
    AppMethodBeat.o(62271);
  }
  
  public final int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62299);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62299);
    return paramInt1;
  }
  
  public void setAlignContent(int paramInt)
  {
    AppMethodBeat.i(62294);
    if (this.bte != paramInt)
    {
      this.bte = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62294);
  }
  
  public void setAlignItems(int paramInt)
  {
    AppMethodBeat.i(62293);
    if (this.btd != paramInt)
    {
      this.btd = paramInt;
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
    if (paramDrawable == this.btg)
    {
      AppMethodBeat.o(62303);
      return;
    }
    this.btg = paramDrawable;
    if (paramDrawable != null) {}
    for (this.btk = paramDrawable.getIntrinsicHeight();; this.btk = 0)
    {
      vO();
      requestLayout();
      AppMethodBeat.o(62303);
      return;
    }
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    AppMethodBeat.i(62304);
    if (paramDrawable == this.bth)
    {
      AppMethodBeat.o(62304);
      return;
    }
    this.bth = paramDrawable;
    if (paramDrawable != null) {}
    for (this.btl = paramDrawable.getIntrinsicWidth();; this.btl = 0)
    {
      vO();
      requestLayout();
      AppMethodBeat.o(62304);
      return;
    }
  }
  
  public void setFlexDirection(int paramInt)
  {
    AppMethodBeat.i(62290);
    if (this.bta != paramInt)
    {
      this.bta = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62290);
  }
  
  public void setFlexLines(List<b> paramList)
  {
    this.bsY = paramList;
  }
  
  public void setFlexWrap(int paramInt)
  {
    AppMethodBeat.i(62291);
    if (this.btb != paramInt)
    {
      this.btb = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62291);
  }
  
  public void setJustifyContent(int paramInt)
  {
    AppMethodBeat.i(62292);
    if (this.btc != paramInt)
    {
      this.btc = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62292);
  }
  
  public void setMaxLine(int paramInt)
  {
    AppMethodBeat.i(62295);
    if (this.btf != paramInt)
    {
      this.btf = paramInt;
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
    if (paramInt != this.bti)
    {
      this.bti = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62307);
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    AppMethodBeat.i(62306);
    if (paramInt != this.btj)
    {
      this.btj = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(62306);
  }
  
  public final int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62300);
    paramInt1 = getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(62300);
    return paramInt1;
  }
  
  public final boolean vF()
  {
    return (this.bta == 0) || (this.bta == 1);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
    implements FlexItem
  {
    public static final Parcelable.Creator<LayoutParams> CREATOR;
    private int CO;
    private int EK;
    private int btr;
    private float bts;
    private float btt;
    private int btu;
    private float btv;
    private boolean btw;
    private int lj;
    private int uJ;
    
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
      this.btr = 1;
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a.bua);
      this.btr = paramContext.getInt(d.a.buk, 1);
      this.bts = paramContext.getFloat(d.a.bud, 0.0F);
      this.btt = paramContext.getFloat(d.a.bue, 1.0F);
      this.btu = paramContext.getInt(d.a.bub, -1);
      this.btv = paramContext.getFraction(d.a.buc, 1, 1, -1.0F);
      this.lj = paramContext.getDimensionPixelSize(d.a.buj, 0);
      this.CO = paramContext.getDimensionPixelSize(d.a.bui, 0);
      this.uJ = paramContext.getDimensionPixelSize(d.a.buh, 16777215);
      this.EK = paramContext.getDimensionPixelSize(d.a.bug, 16777215);
      this.btw = paramContext.getBoolean(d.a.bul, false);
      paramContext.recycle();
      AppMethodBeat.o(62266);
    }
    
    protected LayoutParams(Parcel paramParcel)
    {
      super(0);
      AppMethodBeat.i(62268);
      this.btr = 1;
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
      this.btr = paramParcel.readInt();
      this.bts = paramParcel.readFloat();
      this.btt = paramParcel.readFloat();
      this.btu = paramParcel.readInt();
      this.btv = paramParcel.readFloat();
      this.lj = paramParcel.readInt();
      this.CO = paramParcel.readInt();
      this.uJ = paramParcel.readInt();
      this.EK = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.btw = bool;
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
      this.btr = 1;
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.btr = 1;
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.btr = 1;
      this.bts = 0.0F;
      this.btt = 1.0F;
      this.btu = -1;
      this.btv = -1.0F;
      this.uJ = 16777215;
      this.EK = 16777215;
      this.btr = paramLayoutParams.btr;
      this.bts = paramLayoutParams.bts;
      this.btt = paramLayoutParams.btt;
      this.btu = paramLayoutParams.btu;
      this.btv = paramLayoutParams.btv;
      this.lj = paramLayoutParams.lj;
      this.CO = paramLayoutParams.CO;
      this.uJ = paramLayoutParams.uJ;
      this.EK = paramLayoutParams.EK;
      this.btw = paramLayoutParams.btw;
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
      return this.btr;
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
      AppMethodBeat.i(62267);
      paramParcel.writeInt(this.btr);
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
        AppMethodBeat.o(62267);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.flexbox.FlexboxLayout
 * JD-Core Version:    0.7.0.1
 */