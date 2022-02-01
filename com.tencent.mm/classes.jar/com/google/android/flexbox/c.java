package com.google.android.flexbox;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class c
{
  private final a bsT;
  private boolean[] bsU;
  int[] bsV;
  long[] bsW;
  private long[] bsX;
  
  static
  {
    AppMethodBeat.i(62264);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(62264);
      return;
    }
  }
  
  c(a parama)
  {
    this.bsT = parama;
  }
  
  private void H(View paramView, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(62243);
    int i = 0;
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int n = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    int j;
    if (n < localFlexItem.getMinWidth())
    {
      j = localFlexItem.getMinWidth();
      i = 1;
      if (m >= localFlexItem.getMinHeight()) {
        break label158;
      }
      i = localFlexItem.getMinHeight();
    }
    for (;;)
    {
      if (k != 0)
      {
        j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        paramView.measure(j, i);
        a(paramInt, j, i, paramView);
        this.bsT.a(paramInt, paramView);
      }
      AppMethodBeat.o(62243);
      return;
      j = n;
      if (n <= localFlexItem.getMaxWidth()) {
        break;
      }
      j = localFlexItem.getMaxWidth();
      i = 1;
      break;
      label158:
      if (m > localFlexItem.getMaxHeight())
      {
        i = localFlexItem.getMaxHeight();
      }
      else
      {
        k = m;
        m = i;
        i = k;
        k = m;
      }
    }
  }
  
  private int a(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    AppMethodBeat.i(62249);
    a locala = this.bsT;
    paramInt2 = locala.s(paramInt1, locala.getPaddingLeft() + this.bsT.getPaddingRight() + paramFlexItem.vJ() + paramFlexItem.vL() + paramInt2, paramFlexItem.getWidth());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.getMaxWidth()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMaxWidth(), View.MeasureSpec.getMode(paramInt2));
    }
    for (;;)
    {
      AppMethodBeat.o(62249);
      return paramInt1;
      paramInt1 = paramInt2;
      if (i < paramFlexItem.getMinWidth()) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMinWidth(), View.MeasureSpec.getMode(paramInt2));
      }
    }
  }
  
  private static int a(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62234);
    if (paramBoolean)
    {
      i = paramFlexItem.getWidth();
      AppMethodBeat.o(62234);
      return i;
    }
    int i = paramFlexItem.getHeight();
    AppMethodBeat.o(62234);
    return i;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    AppMethodBeat.i(62261);
    if (this.bsW != null) {
      this.bsW[paramInt1] = bt(paramInt2, paramInt3);
    }
    if (this.bsX != null) {
      this.bsX[paramInt1] = bt(paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    }
    AppMethodBeat.o(62261);
  }
  
  private void a(int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(62247);
    if ((paramb.bsN <= 0.0F) || (paramInt3 < paramb.bsJ))
    {
      AppMethodBeat.o(62247);
      return;
    }
    int i1 = paramb.bsJ;
    int i = 0;
    float f4 = (paramInt3 - paramb.bsJ) / paramb.bsN;
    paramb.bsJ = (paramb.bsK + paramInt4);
    int n = 0;
    if (!paramBoolean) {
      paramb.bsL = -2147483648;
    }
    float f1 = 0.0F;
    int m = 0;
    label84:
    int i2;
    View localView;
    int k;
    int j;
    float f2;
    FlexItem localFlexItem;
    float f3;
    label300:
    label355:
    int i3;
    int i4;
    if (m < paramb.alU)
    {
      i2 = paramb.bsS + m;
      localView = this.bsT.fD(i2);
      k = n;
      j = i;
      f2 = f1;
      if (localView != null)
      {
        k = n;
        j = i;
        f2 = f1;
        if (localView.getVisibility() != 8)
        {
          localFlexItem = (FlexItem)localView.getLayoutParams();
          j = this.bsT.getFlexDirection();
          if ((j != 0) && (j != 1)) {
            break label610;
          }
          j = localView.getMeasuredWidth();
          if (this.bsX != null) {
            j = (int)this.bsX[i2];
          }
          k = localView.getMeasuredHeight();
          if (this.bsX != null) {
            k = (int)(this.bsX[i2] >> 32);
          }
          if ((this.bsU[i2] != 0) || (localFlexItem.getFlexGrow() <= 0.0F)) {
            break label1032;
          }
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m != paramb.alU - 1) {
            break label1029;
          }
          f3 = 0.0F;
          f2 = f1 + f2;
          f1 = f3;
          j = Math.round(f2);
          if (j <= localFlexItem.getMaxWidth()) {
            break label547;
          }
          i = 1;
          j = localFlexItem.getMaxWidth();
          this.bsU[i2] = true;
          paramb.bsN -= localFlexItem.getFlexGrow();
          i3 = b(paramInt2, localFlexItem, paramb.bsQ);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i3);
          j = localView.getMeasuredWidth();
          k = localView.getMeasuredHeight();
          a(i2, i4, i3, localView);
          this.bsT.a(i2, localView);
        }
      }
    }
    label1029:
    label1032:
    for (;;)
    {
      k = Math.max(n, localFlexItem.vK() + k + localFlexItem.getMarginBottom() + this.bsT.bR(localView));
      n = paramb.bsJ;
      i2 = localFlexItem.vJ();
      paramb.bsJ = (localFlexItem.vL() + (i2 + j) + n);
      j = k;
      label501:
      paramb.bsL = Math.max(paramb.bsL, j);
      k = j;
      f2 = f1;
      j = i;
      m += 1;
      n = k;
      i = j;
      f1 = f2;
      break label84;
      label547:
      f1 += f2 - j;
      if (f1 > 1.0D)
      {
        j += 1;
        f1 = (float)(f1 - 1.0D);
        break label355;
      }
      if (f1 < -1.0D)
      {
        j -= 1;
        f1 = (float)(f1 + 1.0D);
        break label355;
        label610:
        j = localView.getMeasuredHeight();
        if (this.bsX != null) {
          j = (int)(this.bsX[i2] >> 32);
        }
        k = localView.getMeasuredWidth();
        if (this.bsX != null) {
          k = (int)this.bsX[i2];
        }
        if ((this.bsU[i2] == 0) && (localFlexItem.getFlexGrow() > 0.0F))
        {
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m == paramb.alU - 1)
          {
            f3 = 0.0F;
            f2 = f1 + f2;
            f1 = f3;
            label724:
            j = Math.round(f2);
            if (j > localFlexItem.getMaxHeight())
            {
              i = 1;
              j = localFlexItem.getMaxHeight();
              this.bsU[i2] = true;
              paramb.bsN -= localFlexItem.getFlexGrow();
              label779:
              i3 = a(paramInt1, localFlexItem, paramb.bsQ);
              i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
              localView.measure(i3, i4);
              k = localView.getMeasuredWidth();
              j = localView.getMeasuredHeight();
              a(i2, i3, i4, localView);
              this.bsT.a(i2, localView);
            }
          }
        }
        for (;;)
        {
          k = Math.max(n, localFlexItem.vJ() + k + localFlexItem.vL() + this.bsT.bR(localView));
          n = paramb.bsJ;
          i2 = localFlexItem.vK();
          paramb.bsJ = (localFlexItem.getMarginBottom() + (i2 + j) + n);
          j = k;
          break label501;
          f1 += f2 - j;
          if (f1 > 1.0D)
          {
            j += 1;
            f1 = (float)(f1 - 1.0D);
            break label779;
          }
          if (f1 < -1.0D)
          {
            j -= 1;
            f1 = (float)(f1 + 1.0D);
            break label779;
            if ((i != 0) && (i1 != paramb.bsJ))
            {
              paramBoolean = true;
              break;
            }
            AppMethodBeat.o(62247);
            return;
          }
          break label779;
          break label724;
        }
      }
      break label355;
      break label300;
    }
  }
  
  private void a(List<b> paramList, b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62242);
    paramb.bsQ = paramInt2;
    this.bsT.a(paramb);
    paramb.iV = paramInt1;
    paramList.add(paramb);
    AppMethodBeat.o(62242);
  }
  
  private static boolean a(int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62241);
    if ((paramInt1 == paramInt2 - 1) && (paramb.vM() != 0))
    {
      AppMethodBeat.o(62241);
      return true;
    }
    AppMethodBeat.o(62241);
    return false;
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, FlexItem paramFlexItem, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(62240);
    if (this.bsT.getFlexWrap() == 0)
    {
      AppMethodBeat.o(62240);
      return false;
    }
    if (paramFlexItem.vH())
    {
      AppMethodBeat.o(62240);
      return true;
    }
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(62240);
      return false;
    }
    paramInt1 = this.bsT.getMaxLine();
    if ((paramInt1 != -1) && (paramInt1 <= paramInt7 + 1))
    {
      AppMethodBeat.o(62240);
      return false;
    }
    paramInt5 = this.bsT.k(paramView, paramInt5, paramInt6);
    paramInt1 = paramInt4;
    if (paramInt5 > 0) {
      paramInt1 = paramInt4 + paramInt5;
    }
    if (paramInt2 < paramInt3 + paramInt1)
    {
      AppMethodBeat.o(62240);
      return true;
    }
    AppMethodBeat.o(62240);
    return false;
  }
  
  private static int[] a(int paramInt, List<c.b> paramList, SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(62221);
    Collections.sort(paramList);
    paramSparseIntArray.clear();
    int[] arrayOfInt = new int[paramInt];
    paramList = paramList.iterator();
    paramInt = 0;
    while (paramList.hasNext())
    {
      c.b localb = (c.b)paramList.next();
      arrayOfInt[paramInt] = localb.index;
      paramSparseIntArray.append(localb.index, localb.order);
      paramInt += 1;
    }
    AppMethodBeat.o(62221);
    return arrayOfInt;
  }
  
  private int aX(boolean paramBoolean)
  {
    AppMethodBeat.i(62228);
    if (paramBoolean)
    {
      i = this.bsT.getPaddingStart();
      AppMethodBeat.o(62228);
      return i;
    }
    int i = this.bsT.getPaddingTop();
    AppMethodBeat.o(62228);
    return i;
  }
  
  private int aY(boolean paramBoolean)
  {
    AppMethodBeat.i(62229);
    if (paramBoolean)
    {
      i = this.bsT.getPaddingEnd();
      AppMethodBeat.o(62229);
      return i;
    }
    int i = this.bsT.getPaddingBottom();
    AppMethodBeat.o(62229);
    return i;
  }
  
  private int aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(62230);
    if (paramBoolean)
    {
      i = this.bsT.getPaddingTop();
      AppMethodBeat.o(62230);
      return i;
    }
    int i = this.bsT.getPaddingStart();
    AppMethodBeat.o(62230);
    return i;
  }
  
  static int ax(long paramLong)
  {
    return (int)paramLong;
  }
  
  static int ay(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private int b(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    AppMethodBeat.i(62250);
    a locala = this.bsT;
    paramInt2 = locala.t(paramInt1, locala.getPaddingTop() + this.bsT.getPaddingBottom() + paramFlexItem.vK() + paramFlexItem.getMarginBottom() + paramInt2, paramFlexItem.getHeight());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.getMaxHeight()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMaxHeight(), View.MeasureSpec.getMode(paramInt2));
    }
    for (;;)
    {
      AppMethodBeat.o(62250);
      return paramInt1;
      paramInt1 = paramInt2;
      if (i < paramFlexItem.getMinHeight()) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMinHeight(), View.MeasureSpec.getMode(paramInt2));
      }
    }
  }
  
  private static int b(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62235);
    if (paramBoolean)
    {
      i = paramFlexItem.getHeight();
      AppMethodBeat.o(62235);
      return i;
    }
    int i = paramFlexItem.getWidth();
    AppMethodBeat.o(62235);
    return i;
  }
  
  private static List<b> b(List<b> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62252);
    paramInt1 = (paramInt1 - paramInt2) / 2;
    ArrayList localArrayList = new ArrayList();
    b localb = new b();
    localb.bsL = paramInt1;
    paramInt2 = paramList.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramInt1 == 0) {
        localArrayList.add(localb);
      }
      localArrayList.add((b)paramList.get(paramInt1));
      if (paramInt1 == paramList.size() - 1) {
        localArrayList.add(localb);
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(62252);
    return localArrayList;
  }
  
  private void b(int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(62248);
    int i2 = paramb.bsJ;
    if ((paramb.bsO <= 0.0F) || (paramInt3 > paramb.bsJ))
    {
      AppMethodBeat.o(62248);
      return;
    }
    int i = 0;
    float f4 = (paramb.bsJ - paramInt3) / paramb.bsO;
    float f1 = 0.0F;
    paramb.bsJ = (paramb.bsK + paramInt4);
    if (!paramBoolean) {
      paramb.bsL = -2147483648;
    }
    int n = 0;
    int k = 0;
    label86:
    int i3;
    View localView;
    FlexItem localFlexItem;
    int j;
    int m;
    float f2;
    float f3;
    label278:
    int i1;
    label333:
    int i4;
    if (n < paramb.alU)
    {
      i3 = paramb.bsS + n;
      localView = this.bsT.fD(i3);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label1036;
      }
      localFlexItem = (FlexItem)localView.getLayoutParams();
      j = this.bsT.getFlexDirection();
      if ((j == 0) || (j == 1))
      {
        j = localView.getMeasuredWidth();
        if (this.bsX != null) {
          j = (int)this.bsX[i3];
        }
        m = localView.getMeasuredHeight();
        if (this.bsX != null) {
          m = (int)(this.bsX[i3] >> 32);
        }
        if ((this.bsU[i3] != 0) || (localFlexItem.getFlexShrink() <= 0.0F)) {
          break label1029;
        }
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n != paramb.alU - 1) {
          break label1026;
        }
        f3 = 0.0F;
        f2 = f1 + f2;
        f1 = f3;
        i1 = Math.round(f2);
        if (i1 < localFlexItem.getMinWidth())
        {
          m = 1;
          j = localFlexItem.getMinWidth();
          this.bsU[i3] = true;
          paramb.bsO -= localFlexItem.getFlexShrink();
          i = b(paramInt2, localFlexItem, paramb.bsQ);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i);
          j = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          a(i3, i4, i, localView);
          this.bsT.a(i3, localView);
          i = m;
          label407:
          k = Math.max(k, localFlexItem.vK() + i1 + localFlexItem.getMarginBottom() + this.bsT.bR(localView));
          m = paramb.bsJ;
          i1 = localFlexItem.vJ();
          paramb.bsJ = (localFlexItem.vL() + (j + i1) + m);
          j = k;
          label483:
          paramb.bsL = Math.max(paramb.bsL, j);
        }
      }
    }
    for (;;)
    {
      n += 1;
      k = j;
      break label86;
      f2 = f1 + (f2 - i1);
      if (f2 > 1.0D)
      {
        j = i1 + 1;
        f1 = f2 - 1.0F;
        m = i;
        break label333;
      }
      j = i1;
      m = i;
      f1 = f2;
      if (f2 >= -1.0D) {
        break label333;
      }
      j = i1 - 1;
      f1 = f2 + 1.0F;
      m = i;
      break label333;
      j = localView.getMeasuredHeight();
      if (this.bsX != null) {
        j = (int)(this.bsX[i3] >> 32);
      }
      m = localView.getMeasuredWidth();
      if (this.bsX != null) {
        m = (int)this.bsX[i3];
      }
      if ((this.bsU[i3] == 0) && (localFlexItem.getFlexShrink() > 0.0F))
      {
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n == paramb.alU - 1)
        {
          f3 = 0.0F;
          f2 = f1 + f2;
          f1 = f3;
          label702:
          i1 = Math.round(f2);
          if (i1 < localFlexItem.getMinHeight())
          {
            m = 1;
            j = localFlexItem.getMinHeight();
            this.bsU[i3] = true;
            paramb.bsO -= localFlexItem.getFlexShrink();
            label757:
            i = a(paramInt1, localFlexItem, paramb.bsQ);
            i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            localView.measure(i, i4);
            i1 = localView.getMeasuredWidth();
            j = localView.getMeasuredHeight();
            a(i3, i, i4, localView);
            this.bsT.a(i3, localView);
            i = m;
          }
        }
      }
      for (;;)
      {
        k = Math.max(k, localFlexItem.vJ() + i1 + localFlexItem.vL() + this.bsT.bR(localView));
        m = paramb.bsJ;
        i1 = localFlexItem.vK();
        paramb.bsJ = (localFlexItem.getMarginBottom() + (j + i1) + m);
        j = k;
        break label483;
        f2 = f1 + (f2 - i1);
        if (f2 > 1.0D)
        {
          j = i1 + 1;
          f1 = f2 - 1.0F;
          m = i;
          break label757;
        }
        j = i1;
        m = i;
        f1 = f2;
        if (f2 >= -1.0D) {
          break label757;
        }
        j = i1 - 1;
        f1 = f2 + 1.0F;
        m = i;
        break label757;
        if ((i != 0) && (i2 != paramb.bsJ))
        {
          paramBoolean = true;
          break;
        }
        AppMethodBeat.o(62248);
        return;
        break label702;
        i1 = m;
      }
      label1026:
      break label278;
      label1029:
      i1 = m;
      break label407;
      label1036:
      j = k;
    }
  }
  
  private int ba(boolean paramBoolean)
  {
    AppMethodBeat.i(62231);
    if (paramBoolean)
    {
      i = this.bsT.getPaddingBottom();
      AppMethodBeat.o(62231);
      return i;
    }
    int i = this.bsT.getPaddingEnd();
    AppMethodBeat.o(62231);
    return i;
  }
  
  private static long bt(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1 & 0xFFFFFFFF;
  }
  
  private static int c(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62236);
    if (paramBoolean)
    {
      i = paramFlexItem.vJ();
      AppMethodBeat.o(62236);
      return i;
    }
    int i = paramFlexItem.vK();
    AppMethodBeat.o(62236);
    return i;
  }
  
  private static int d(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62237);
    if (paramBoolean)
    {
      i = paramFlexItem.vL();
      AppMethodBeat.o(62237);
      return i;
    }
    int i = paramFlexItem.getMarginBottom();
    AppMethodBeat.o(62237);
    return i;
  }
  
  private static int e(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62238);
    if (paramBoolean)
    {
      i = paramFlexItem.vK();
      AppMethodBeat.o(62238);
      return i;
    }
    int i = paramFlexItem.vJ();
    AppMethodBeat.o(62238);
    return i;
  }
  
  private static int f(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62239);
    if (paramBoolean)
    {
      i = paramFlexItem.getMarginBottom();
      AppMethodBeat.o(62239);
      return i;
    }
    int i = paramFlexItem.vL();
    AppMethodBeat.o(62239);
    return i;
  }
  
  private List<c.b> fE(int paramInt)
  {
    AppMethodBeat.i(62219);
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      FlexItem localFlexItem = (FlexItem)this.bsT.fC(i).getLayoutParams();
      c.b localb = new c.b((byte)0);
      localb.order = localFlexItem.getOrder();
      localb.index = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(62219);
    return localArrayList;
  }
  
  private void fF(int paramInt)
  {
    AppMethodBeat.i(62246);
    int i;
    if (this.bsU == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bsU = new boolean[i];
      AppMethodBeat.o(62246);
      return;
    }
    if (this.bsU.length < paramInt)
    {
      int j = this.bsU.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bsU = new boolean[i];
      AppMethodBeat.o(62246);
      return;
    }
    Arrays.fill(this.bsU, false);
    AppMethodBeat.o(62246);
  }
  
  private static int j(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(62232);
    if (paramBoolean)
    {
      i = paramView.getMeasuredWidth();
      AppMethodBeat.o(62232);
      return i;
    }
    int i = paramView.getMeasuredHeight();
    AppMethodBeat.o(62232);
    return i;
  }
  
  private static int k(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(62233);
    if (paramBoolean)
    {
      i = paramView.getMeasuredHeight();
      AppMethodBeat.o(62233);
      return i;
    }
    int i = paramView.getMeasuredWidth();
    AppMethodBeat.o(62233);
    return i;
  }
  
  private void l(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62255);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - localFlexItem.vK() - localFlexItem.getMarginBottom() - this.bsT.bR(paramView), localFlexItem.getMinHeight()), localFlexItem.getMaxHeight());
    if (this.bsX != null) {}
    for (paramInt1 = (int)this.bsX[paramInt2];; paramInt1 = paramView.getMeasuredWidth())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(paramInt1, i);
      a(paramInt2, paramInt1, i, paramView);
      this.bsT.a(paramInt2, paramView);
      AppMethodBeat.o(62255);
      return;
    }
  }
  
  private void m(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62256);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - localFlexItem.vJ() - localFlexItem.vL() - this.bsT.bR(paramView), localFlexItem.getMinWidth()), localFlexItem.getMaxWidth());
    if (this.bsX != null) {}
    for (paramInt1 = (int)(this.bsX[paramInt2] >> 32);; paramInt1 = paramView.getMeasuredHeight())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(i, paramInt1);
      a(paramInt2, i, paramInt1, paramView);
      this.bsT.a(paramInt2, paramView);
      AppMethodBeat.o(62256);
      return;
    }
  }
  
  final void a(View paramView, b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62257);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.bsT.getAlignItems();
    if (localFlexItem.vG() != -1) {
      i = localFlexItem.vG();
    }
    int j = paramb.bsL;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62257);
      return;
      if (this.bsT.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, localFlexItem.vK() + paramInt2, paramInt3, localFlexItem.vK() + paramInt4);
        AppMethodBeat.o(62257);
        return;
      }
      paramView.layout(paramInt1, paramInt2 - localFlexItem.getMarginBottom(), paramInt3, paramInt4 - localFlexItem.getMarginBottom());
      AppMethodBeat.o(62257);
      return;
      if (this.bsT.getFlexWrap() != 2)
      {
        i = Math.max(paramb.bsP - paramView.getBaseline(), localFlexItem.vK());
        paramView.layout(paramInt1, paramInt2 + i, paramInt3, i + paramInt4);
        AppMethodBeat.o(62257);
        return;
      }
      i = Math.max(paramb.bsP - paramView.getMeasuredHeight() + paramView.getBaseline(), localFlexItem.getMarginBottom());
      paramView.layout(paramInt1, paramInt2 - i, paramInt3, paramInt4 - i);
      AppMethodBeat.o(62257);
      return;
      if (this.bsT.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, paramInt2 + j - paramView.getMeasuredHeight() - localFlexItem.getMarginBottom(), paramInt3, j + paramInt2 - localFlexItem.getMarginBottom());
        AppMethodBeat.o(62257);
        return;
      }
      i = paramView.getMeasuredHeight();
      int k = localFlexItem.vK();
      int m = paramView.getMeasuredHeight();
      paramView.layout(paramInt1, paramInt2 - j + i + k, paramInt3, localFlexItem.vK() + (paramInt4 - j + m));
      AppMethodBeat.o(62257);
      return;
      paramInt4 = (j - paramView.getMeasuredHeight() + localFlexItem.vK() - localFlexItem.getMarginBottom()) / 2;
      if (this.bsT.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, paramInt2 + paramInt4, paramInt3, paramInt4 + paramInt2 + paramView.getMeasuredHeight());
        AppMethodBeat.o(62257);
        return;
      }
      paramView.layout(paramInt1, paramInt2 - paramInt4, paramInt3, paramInt2 - paramInt4 + paramView.getMeasuredHeight());
    }
  }
  
  final void a(View paramView, b paramb, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62258);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.bsT.getAlignItems();
    if (localFlexItem.vG() != -1) {
      i = localFlexItem.vG();
    }
    int j = paramb.bsL;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62258);
      return;
      if (!paramBoolean)
      {
        paramView.layout(localFlexItem.vJ() + paramInt1, paramInt2, localFlexItem.vJ() + paramInt3, paramInt4);
        AppMethodBeat.o(62258);
        return;
      }
      paramView.layout(paramInt1 - localFlexItem.vL(), paramInt2, paramInt3 - localFlexItem.vL(), paramInt4);
      AppMethodBeat.o(62258);
      return;
      if (!paramBoolean)
      {
        paramView.layout(paramInt1 + j - paramView.getMeasuredWidth() - localFlexItem.vL(), paramInt2, j + paramInt3 - paramView.getMeasuredWidth() - localFlexItem.vL(), paramInt4);
        AppMethodBeat.o(62258);
        return;
      }
      i = paramView.getMeasuredWidth();
      int k = localFlexItem.vJ();
      int m = paramView.getMeasuredWidth();
      paramView.layout(paramInt1 - j + i + k, paramInt2, localFlexItem.vJ() + (paramInt3 - j + m), paramInt4);
      AppMethodBeat.o(62258);
      return;
      paramb = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      i = (j - paramView.getMeasuredWidth() + h.a(paramb) - h.b(paramb)) / 2;
      if (!paramBoolean)
      {
        paramView.layout(paramInt1 + i, paramInt2, i + paramInt3, paramInt4);
        AppMethodBeat.o(62258);
        return;
      }
      paramView.layout(paramInt1 - i, paramInt2, paramInt3 - i, paramInt4);
    }
  }
  
  final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62224);
    a(parama, paramInt2, paramInt1, 2147483647, 0, -1, null);
    AppMethodBeat.o(62224);
  }
  
  final void a(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<b> paramList)
  {
    AppMethodBeat.i(62227);
    boolean bool = this.bsT.vF();
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int n = 0;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    parama.bsY = ((List)localObject);
    int i;
    int i5;
    int i6;
    int i7;
    int i8;
    int k;
    int j;
    int i1;
    int i9;
    int m;
    label156:
    View localView;
    if (paramInt5 == -1)
    {
      i = 1;
      i5 = aX(bool);
      i6 = aY(bool);
      i7 = aZ(bool);
      i8 = ba(bool);
      k = -2147483648;
      j = 0;
      i1 = 0;
      paramList = new b();
      paramList.bsS = paramInt4;
      paramList.bsJ = (i5 + i6);
      i9 = this.bsT.getFlexItemCount();
      m = paramInt4;
      paramInt4 = i;
      i = n;
      if (m >= i9) {
        break label1323;
      }
      localView = this.bsT.fD(m);
      if (localView != null) {
        break label220;
      }
      if (!a(m, i9, paramList)) {
        break label1349;
      }
      a((List)localObject, paramList, m, j);
    }
    label471:
    for (;;)
    {
      m += 1;
      break label156;
      i = 0;
      break;
      label220:
      if (localView.getVisibility() == 8)
      {
        paramList.bsM += 1;
        paramList.alU += 1;
        if (a(m, i9, paramList)) {
          a((List)localObject, paramList, m, j);
        }
      }
      else
      {
        FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
        if (localFlexItem.vG() == 4) {
          paramList.bsR.add(Integer.valueOf(m));
        }
        int i2 = a(localFlexItem, bool);
        n = i2;
        if (localFlexItem.vI() != -1.0F)
        {
          n = i2;
          if (i3 == 1073741824) {
            n = Math.round(i4 * localFlexItem.vI());
          }
        }
        int i10;
        if (bool)
        {
          i2 = this.bsT.s(paramInt1, i5 + i6 + c(localFlexItem, true) + d(localFlexItem, true), n);
          n = this.bsT.t(paramInt2, i7 + i8 + e(localFlexItem, true) + f(localFlexItem, true) + j, b(localFlexItem, true));
          localView.measure(i2, n);
          a(m, i2, n, localView);
          this.bsT.a(m, localView);
          H(localView, m);
          n = View.combineMeasuredStates(i, localView.getMeasuredState());
          i = paramList.bsJ;
          i10 = j(localView, bool);
          int i11 = c(localFlexItem, bool);
          if (!a(localView, i3, i4, i, d(localFlexItem, bool) + (i10 + i11), localFlexItem, m, i1, ((List)localObject).size())) {
            break label1267;
          }
          if (paramList.vM() <= 0) {
            break label1346;
          }
          if (m <= 0) {
            break label1175;
          }
          i = m - 1;
          a((List)localObject, paramList, i, j);
          j += paramList.bsL;
        }
        for (;;)
        {
          if (bool)
          {
            if (localFlexItem.getHeight() == -1)
            {
              paramList = this.bsT;
              localView.measure(i2, paramList.t(paramInt2, paramList.getPaddingTop() + this.bsT.getPaddingBottom() + localFlexItem.vK() + localFlexItem.getMarginBottom() + j, localFlexItem.getHeight()));
              H(localView, m);
            }
            paramList = new b();
            paramList.alU = 1;
            paramList.bsJ = (i5 + i6);
            paramList.bsS = m;
            i = 0;
            k = -2147483648;
            label738:
            if (this.bsV != null) {
              this.bsV[m] = ((List)localObject).size();
            }
            paramList.bsJ += j(localView, bool) + c(localFlexItem, bool) + d(localFlexItem, bool);
            paramList.bsN += localFlexItem.getFlexGrow();
            paramList.bsO += localFlexItem.getFlexShrink();
            this.bsT.a(localView, m, i, paramList);
            i2 = Math.max(k, k(localView, bool) + e(localFlexItem, bool) + f(localFlexItem, bool) + this.bsT.bR(localView));
            paramList.bsL = Math.max(paramList.bsL, i2);
            if (bool)
            {
              if (this.bsT.getFlexWrap() == 2) {
                break label1288;
              }
              paramList.bsP = Math.max(paramList.bsP, localView.getBaseline() + localFlexItem.vK());
            }
            if (!a(m, i9, paramList)) {
              break label1343;
            }
            a((List)localObject, paramList, m, j);
            j += paramList.bsL;
          }
          for (;;)
          {
            if ((paramInt5 != -1) && (((List)localObject).size() > 0) && (((b)((List)localObject).get(((List)localObject).size() - 1)).iV >= paramInt5) && (m >= paramInt5) && (paramInt4 == 0))
            {
              j = -paramList.bsL;
              paramInt4 = 1;
            }
            for (;;)
            {
              if (j > paramInt3)
              {
                k = n;
                if (paramInt4 != 0) {}
              }
              else
              {
                i1 = i;
                i = n;
                k = i2;
                break;
                i10 = this.bsT.s(paramInt2, i7 + i8 + e(localFlexItem, false) + f(localFlexItem, false) + j, b(localFlexItem, false));
                i2 = this.bsT.t(paramInt1, i5 + i6 + c(localFlexItem, false) + d(localFlexItem, false), n);
                localView.measure(i10, i2);
                a(m, i10, i2, localView);
                break label471;
                i = 0;
                break label589;
                if (localFlexItem.getWidth() != -1) {
                  break label699;
                }
                paramList = this.bsT;
                localView.measure(paramList.s(paramInt2, paramList.getPaddingLeft() + this.bsT.getPaddingRight() + localFlexItem.vJ() + localFlexItem.vL() + j, localFlexItem.getWidth()), i2);
                H(localView, m);
                break label699;
                label1267:
                paramList.alU += 1;
                i = i1 + 1;
                break label738;
                paramList.bsP = Math.max(paramList.bsP, localView.getMeasuredHeight() - localView.getBaseline() + localFlexItem.getMarginBottom());
                break label947;
                k = i;
              }
              parama.bsZ = k;
              AppMethodBeat.o(62227);
              return;
            }
          }
        }
      }
    }
  }
  
  final void a(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(62222);
    a(parama, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList);
    AppMethodBeat.o(62222);
  }
  
  final int[] a(SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(62218);
    int i = this.bsT.getFlexItemCount();
    paramSparseIntArray = a(i, fE(i), paramSparseIntArray);
    AppMethodBeat.o(62218);
    return paramSparseIntArray;
  }
  
  final int[] a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(62217);
    int i = this.bsT.getFlexItemCount();
    List localList = fE(i);
    c.b localb = new c.b((byte)0);
    if ((paramView != null) && ((paramLayoutParams instanceof FlexItem)))
    {
      localb.order = ((FlexItem)paramLayoutParams).getOrder();
      if ((paramInt != -1) && (paramInt != i)) {
        break label117;
      }
      localb.index = i;
    }
    for (;;)
    {
      localList.add(localb);
      paramView = a(i + 1, localList, paramSparseIntArray);
      AppMethodBeat.o(62217);
      return paramView;
      localb.order = 1;
      break;
      label117:
      if (paramInt < this.bsT.getFlexItemCount())
      {
        localb.index = paramInt;
        while (paramInt < i)
        {
          paramView = (c.b)localList.get(paramInt);
          paramView.index += 1;
          paramInt += 1;
        }
      }
      else
      {
        localb.index = i;
      }
    }
  }
  
  final void b(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(62223);
    a(parama, paramInt1, paramInt2, paramInt3, 0, paramInt4, paramList);
    AppMethodBeat.o(62223);
  }
  
  final boolean b(SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(62220);
    int j = this.bsT.getFlexItemCount();
    if (paramSparseIntArray.size() != j)
    {
      AppMethodBeat.o(62220);
      return true;
    }
    int i = 0;
    while (i < j)
    {
      View localView = this.bsT.fC(i);
      if ((localView != null) && (((FlexItem)localView.getLayoutParams()).getOrder() != paramSparseIntArray.get(i)))
      {
        AppMethodBeat.o(62220);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(62220);
    return false;
  }
  
  final void bs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62244);
    u(paramInt1, paramInt2, 0);
    AppMethodBeat.o(62244);
  }
  
  final void c(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(62225);
    a(parama, paramInt2, paramInt1, paramInt3, paramInt4, -1, paramList);
    AppMethodBeat.o(62225);
  }
  
  final void c(List<b> paramList, int paramInt)
  {
    AppMethodBeat.i(62263);
    if ((!$assertionsDisabled) && (this.bsV == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(62263);
      throw paramList;
    }
    if ((!$assertionsDisabled) && (this.bsW == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(62263);
      throw paramList;
    }
    int j = this.bsV[paramInt];
    int i = j;
    if (j == -1) {
      i = 0;
    }
    j = paramList.size() - 1;
    while (j >= i)
    {
      paramList.remove(j);
      j -= 1;
    }
    i = this.bsV.length - 1;
    if (paramInt > i) {
      Arrays.fill(this.bsV, -1);
    }
    for (;;)
    {
      i = this.bsW.length - 1;
      if (paramInt <= i) {
        break;
      }
      Arrays.fill(this.bsW, 0L);
      AppMethodBeat.o(62263);
      return;
      Arrays.fill(this.bsV, paramInt, i, -1);
    }
    Arrays.fill(this.bsW, paramInt, i, 0L);
    AppMethodBeat.o(62263);
  }
  
  final void d(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(62226);
    a(parama, paramInt2, paramInt1, paramInt3, 0, paramInt4, paramList);
    AppMethodBeat.o(62226);
  }
  
  final void fG(int paramInt)
  {
    AppMethodBeat.i(62254);
    if (paramInt >= this.bsT.getFlexItemCount())
    {
      AppMethodBeat.o(62254);
      return;
    }
    int j = this.bsT.getFlexDirection();
    b localb;
    Object localObject2;
    Object localObject3;
    if (this.bsT.getAlignItems() == 4)
    {
      int i = 0;
      if (this.bsV != null) {
        i = this.bsV[paramInt];
      }
      localObject1 = this.bsT.getFlexLinesInternal();
      int k = ((List)localObject1).size();
      paramInt = i;
      while (paramInt < k)
      {
        localb = (b)((List)localObject1).get(paramInt);
        int m = localb.alU;
        i = 0;
        if (i < m)
        {
          int n = localb.bsS + i;
          if (i < this.bsT.getFlexItemCount())
          {
            localObject2 = this.bsT.fD(n);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8))
            {
              localObject3 = (FlexItem)((View)localObject2).getLayoutParams();
              if ((((FlexItem)localObject3).vG() == -1) || (((FlexItem)localObject3).vG() == 4)) {
                switch (j)
                {
                default: 
                  localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
                  AppMethodBeat.o(62254);
                  throw ((Throwable)localObject1);
                case 0: 
                case 1: 
                  l((View)localObject2, localb.bsL, n);
                }
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            m((View)localObject2, localb.bsL, n);
          }
        }
        paramInt += 1;
      }
      AppMethodBeat.o(62254);
      return;
    }
    Object localObject1 = this.bsT.getFlexLinesInternal().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localb = (b)((Iterator)localObject1).next();
      localObject2 = localb.bsR.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        View localView = this.bsT.fD(((Integer)localObject3).intValue());
        switch (j)
        {
        default: 
          localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
          AppMethodBeat.o(62254);
          throw ((Throwable)localObject1);
        case 0: 
        case 1: 
          l(localView, localb.bsL, ((Integer)localObject3).intValue());
          break;
        case 2: 
        case 3: 
          m(localView, localb.bsL, ((Integer)localObject3).intValue());
        }
      }
    }
    AppMethodBeat.o(62254);
  }
  
  final void fH(int paramInt)
  {
    AppMethodBeat.i(62259);
    int i;
    if (this.bsX == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bsX = new long[i];
      AppMethodBeat.o(62259);
      return;
    }
    if (this.bsX.length < paramInt)
    {
      int j = this.bsX.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bsX = Arrays.copyOf(this.bsX, i);
    }
    AppMethodBeat.o(62259);
  }
  
  final void fI(int paramInt)
  {
    AppMethodBeat.i(62260);
    int i;
    if (this.bsW == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bsW = new long[i];
      AppMethodBeat.o(62260);
      return;
    }
    if (this.bsW.length < paramInt)
    {
      int j = this.bsW.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bsW = Arrays.copyOf(this.bsW, i);
    }
    AppMethodBeat.o(62260);
  }
  
  final void fJ(int paramInt)
  {
    AppMethodBeat.i(62262);
    int i;
    if (this.bsV == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bsV = new int[i];
      AppMethodBeat.o(62262);
      return;
    }
    if (this.bsV.length < paramInt)
    {
      int j = this.bsV.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bsV = Arrays.copyOf(this.bsV, i);
    }
    AppMethodBeat.o(62262);
  }
  
  final void u(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62245);
    fF(this.bsT.getFlexItemCount());
    if (paramInt3 >= this.bsT.getFlexItemCount())
    {
      AppMethodBeat.o(62245);
      return;
    }
    int i = this.bsT.getFlexDirection();
    Object localObject;
    int j;
    switch (this.bsT.getFlexDirection())
    {
    default: 
      localObject = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
      AppMethodBeat.o(62245);
      throw ((Throwable)localObject);
    case 0: 
    case 1: 
      j = View.MeasureSpec.getMode(paramInt1);
      i = View.MeasureSpec.getSize(paramInt1);
      if (j == 1073741824)
      {
        j = this.bsT.getPaddingLeft() + this.bsT.getPaddingRight();
        if (this.bsV == null) {
          break label334;
        }
      }
      break;
    }
    label191:
    label334:
    for (paramInt3 = this.bsV[paramInt3];; paramInt3 = 0)
    {
      localObject = this.bsT.getFlexLinesInternal();
      int k = ((List)localObject).size();
      if (paramInt3 < k)
      {
        b localb = (b)((List)localObject).get(paramInt3);
        if (localb.bsJ < i) {
          a(paramInt1, paramInt2, localb, i, j, false);
        }
        for (;;)
        {
          paramInt3 += 1;
          break label191;
          i = this.bsT.getLargestMainSize();
          break;
          j = View.MeasureSpec.getMode(paramInt2);
          i = View.MeasureSpec.getSize(paramInt2);
          if (j == 1073741824) {}
          for (;;)
          {
            j = this.bsT.getPaddingTop() + this.bsT.getPaddingBottom();
            break;
            i = this.bsT.getLargestMainSize();
          }
          b(paramInt1, paramInt2, localb, i, j, false);
        }
      }
      AppMethodBeat.o(62245);
      return;
    }
  }
  
  final void v(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62251);
    int i = this.bsT.getFlexDirection();
    Object localObject1;
    switch (i)
    {
    default: 
      localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
      AppMethodBeat.o(62251);
      throw ((Throwable)localObject1);
    case 0: 
    case 1: 
      i = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      paramInt2 = i;
    }
    for (;;)
    {
      localObject1 = this.bsT.getFlexLinesInternal();
      if (paramInt2 != 1073741824) {
        break label224;
      }
      paramInt2 = this.bsT.getSumOfCrossSize() + paramInt3;
      if (((List)localObject1).size() != 1) {
        break;
      }
      ((b)((List)localObject1).get(0)).bsL = (paramInt1 - paramInt3);
      AppMethodBeat.o(62251);
      return;
      paramInt2 = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
    }
    if (((List)localObject1).size() >= 2) {}
    label224:
    float f1;
    label264:
    Object localObject2;
    float f3;
    float f2;
    switch (this.bsT.getAlignContent())
    {
    default: 
    case 5: 
      do
      {
        AppMethodBeat.o(62251);
        return;
      } while (paramInt2 >= paramInt1);
      float f5 = (paramInt1 - paramInt2) / ((List)localObject1).size();
      f1 = 0.0F;
      paramInt3 = ((List)localObject1).size();
      paramInt2 = 0;
      if (paramInt2 < paramInt3)
      {
        localObject2 = (b)((List)localObject1).get(paramInt2);
        float f4 = ((b)localObject2).bsL + f5;
        f3 = f4;
        f2 = f1;
        if (paramInt2 == ((List)localObject1).size() - 1)
        {
          f3 = f4 + f1;
          f2 = 0.0F;
        }
        paramInt1 = Math.round(f3);
        f1 = f2 + (f3 - paramInt1);
        if (f1 > 1.0F)
        {
          paramInt1 += 1;
          f1 -= 1.0F;
        }
      }
      break;
    }
    for (;;)
    {
      ((b)localObject2).bsL = paramInt1;
      paramInt2 += 1;
      break label264;
      if (f1 < -1.0F)
      {
        paramInt1 -= 1;
        f1 += 1.0F;
        continue;
        AppMethodBeat.o(62251);
        return;
        if (paramInt2 >= paramInt1)
        {
          this.bsT.setFlexLines(b((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(62251);
          return;
        }
        paramInt1 = (paramInt1 - paramInt2) / (((List)localObject1).size() * 2);
        localObject2 = new ArrayList();
        b localb1 = new b();
        localb1.bsL = paramInt1;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          b localb2 = (b)((Iterator)localObject1).next();
          ((List)localObject2).add(localb1);
          ((List)localObject2).add(localb2);
          ((List)localObject2).add(localb1);
        }
        this.bsT.setFlexLines((List)localObject2);
        AppMethodBeat.o(62251);
        return;
        if (paramInt2 >= paramInt1) {
          break;
        }
        f3 = (paramInt1 - paramInt2) / (((List)localObject1).size() - 1);
        f1 = 0.0F;
        localObject2 = new ArrayList();
        paramInt2 = ((List)localObject1).size();
        paramInt1 = 0;
        label591:
        if (paramInt1 < paramInt2)
        {
          ((List)localObject2).add((b)((List)localObject1).get(paramInt1));
          if (paramInt1 == ((List)localObject1).size() - 1) {
            break label840;
          }
          localb1 = new b();
          if (paramInt1 == ((List)localObject1).size() - 2)
          {
            localb1.bsL = Math.round(f3 + f1);
            f1 = 0.0F;
            f2 = f1 + (f3 - localb1.bsL);
            if (f2 <= 1.0F) {
              break label735;
            }
            localb1.bsL += 1;
            f1 = f2 - 1.0F;
            ((List)localObject2).add(localb1);
          }
        }
        label666:
        label705:
        label840:
        for (;;)
        {
          paramInt1 += 1;
          break label591;
          localb1.bsL = Math.round(f3);
          break label666;
          label735:
          f1 = f2;
          if (f2 >= -1.0F) {
            break label705;
          }
          localb1.bsL -= 1;
          f1 = f2 + 1.0F;
          break label705;
          this.bsT.setFlexLines((List)localObject2);
          AppMethodBeat.o(62251);
          return;
          this.bsT.setFlexLines(b((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(62251);
          return;
          localObject2 = new b();
          ((b)localObject2).bsL = (paramInt1 - paramInt2);
          ((List)localObject1).add(0, localObject2);
          break;
        }
      }
    }
  }
  
  final void vN()
  {
    AppMethodBeat.i(62253);
    fG(0);
    AppMethodBeat.o(62253);
  }
  
  static final class a
  {
    List<b> bsY;
    int bsZ;
    
    final void reset()
    {
      this.bsY = null;
      this.bsZ = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.flexbox.c
 * JD-Core Version:    0.7.0.1
 */