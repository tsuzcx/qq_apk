package com.google.android.flexbox;

import android.support.v4.view.g;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class c
{
  private final a bAY;
  private boolean[] bAZ;
  int[] bBa;
  long[] bBb;
  private long[] bBc;
  
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
    this.bAY = parama;
  }
  
  private void J(View paramView, int paramInt)
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
        this.bAY.a(paramInt, paramView);
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
    a locala = this.bAY;
    paramInt2 = locala.w(paramInt1, locala.getPaddingLeft() + this.bAY.getPaddingRight() + paramFlexItem.wo() + paramFlexItem.wq() + paramInt2, paramFlexItem.getWidth());
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
  
  private static List<b> a(List<b> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62252);
    paramInt1 = (paramInt1 - paramInt2) / 2;
    ArrayList localArrayList = new ArrayList();
    b localb = new b();
    localb.bAQ = paramInt1;
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
  
  private void a(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    AppMethodBeat.i(62261);
    if (this.bBb != null) {
      this.bBb[paramInt1] = bs(paramInt2, paramInt3);
    }
    if (this.bBc != null) {
      this.bBc[paramInt1] = bs(paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    }
    AppMethodBeat.o(62261);
  }
  
  private void a(int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(62247);
    if ((paramb.bAS <= 0.0F) || (paramInt3 < paramb.bAO))
    {
      AppMethodBeat.o(62247);
      return;
    }
    int i1 = paramb.bAO;
    int i = 0;
    float f4 = (paramInt3 - paramb.bAO) / paramb.bAS;
    paramb.bAO = (paramb.bAP + paramInt4);
    int n = 0;
    if (!paramBoolean) {
      paramb.bAQ = -2147483648;
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
    if (m < paramb.ars)
    {
      i2 = paramb.bAX + m;
      localView = this.bAY.fu(i2);
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
          j = this.bAY.getFlexDirection();
          if ((j != 0) && (j != 1)) {
            break label610;
          }
          j = localView.getMeasuredWidth();
          if (this.bBc != null) {
            j = (int)this.bBc[i2];
          }
          k = localView.getMeasuredHeight();
          if (this.bBc != null) {
            k = (int)(this.bBc[i2] >> 32);
          }
          if ((this.bAZ[i2] != 0) || (localFlexItem.getFlexGrow() <= 0.0F)) {
            break label1032;
          }
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m != paramb.ars - 1) {
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
          this.bAZ[i2] = true;
          paramb.bAS -= localFlexItem.getFlexGrow();
          i3 = b(paramInt2, localFlexItem, paramb.bAV);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i3);
          j = localView.getMeasuredWidth();
          k = localView.getMeasuredHeight();
          a(i2, i4, i3, localView);
          this.bAY.a(i2, localView);
        }
      }
    }
    label1029:
    label1032:
    for (;;)
    {
      k = Math.max(n, localFlexItem.wp() + k + localFlexItem.getMarginBottom() + this.bAY.cj(localView));
      n = paramb.bAO;
      i2 = localFlexItem.wo();
      paramb.bAO = (localFlexItem.wq() + (i2 + j) + n);
      j = k;
      label501:
      paramb.bAQ = Math.max(paramb.bAQ, j);
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
        if (this.bBc != null) {
          j = (int)(this.bBc[i2] >> 32);
        }
        k = localView.getMeasuredWidth();
        if (this.bBc != null) {
          k = (int)this.bBc[i2];
        }
        if ((this.bAZ[i2] == 0) && (localFlexItem.getFlexGrow() > 0.0F))
        {
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m == paramb.ars - 1)
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
              this.bAZ[i2] = true;
              paramb.bAS -= localFlexItem.getFlexGrow();
              label779:
              i3 = a(paramInt1, localFlexItem, paramb.bAV);
              i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
              localView.measure(i3, i4);
              k = localView.getMeasuredWidth();
              j = localView.getMeasuredHeight();
              a(i2, i3, i4, localView);
              this.bAY.a(i2, localView);
            }
          }
        }
        for (;;)
        {
          k = Math.max(n, localFlexItem.wo() + k + localFlexItem.wq() + this.bAY.cj(localView));
          n = paramb.bAO;
          i2 = localFlexItem.wp();
          paramb.bAO = (localFlexItem.getMarginBottom() + (i2 + j) + n);
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
            if ((i != 0) && (i1 != paramb.bAO))
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
    paramb.bAV = paramInt2;
    this.bAY.a(paramb);
    paramb.Zp = paramInt1;
    paramList.add(paramb);
    AppMethodBeat.o(62242);
  }
  
  private static boolean a(int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62241);
    if ((paramInt1 == paramInt2 - 1) && (paramb.wr() != 0))
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
    if (this.bAY.getFlexWrap() == 0)
    {
      AppMethodBeat.o(62240);
      return false;
    }
    if (paramFlexItem.wm())
    {
      AppMethodBeat.o(62240);
      return true;
    }
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(62240);
      return false;
    }
    paramInt1 = this.bAY.getMaxLine();
    if ((paramInt1 != -1) && (paramInt1 <= paramInt7 + 1))
    {
      AppMethodBeat.o(62240);
      return false;
    }
    paramInt5 = this.bAY.m(paramView, paramInt5, paramInt6);
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
    a locala = this.bAY;
    paramInt2 = locala.x(paramInt1, locala.getPaddingTop() + this.bAY.getPaddingBottom() + paramFlexItem.wp() + paramFlexItem.getMarginBottom() + paramInt2, paramFlexItem.getHeight());
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
  
  private void b(int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(62248);
    int i2 = paramb.bAO;
    if ((paramb.bAT <= 0.0F) || (paramInt3 > paramb.bAO))
    {
      AppMethodBeat.o(62248);
      return;
    }
    int i = 0;
    float f4 = (paramb.bAO - paramInt3) / paramb.bAT;
    float f1 = 0.0F;
    paramb.bAO = (paramb.bAP + paramInt4);
    if (!paramBoolean) {
      paramb.bAQ = -2147483648;
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
    if (n < paramb.ars)
    {
      i3 = paramb.bAX + n;
      localView = this.bAY.fu(i3);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label1036;
      }
      localFlexItem = (FlexItem)localView.getLayoutParams();
      j = this.bAY.getFlexDirection();
      if ((j == 0) || (j == 1))
      {
        j = localView.getMeasuredWidth();
        if (this.bBc != null) {
          j = (int)this.bBc[i3];
        }
        m = localView.getMeasuredHeight();
        if (this.bBc != null) {
          m = (int)(this.bBc[i3] >> 32);
        }
        if ((this.bAZ[i3] != 0) || (localFlexItem.getFlexShrink() <= 0.0F)) {
          break label1029;
        }
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n != paramb.ars - 1) {
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
          this.bAZ[i3] = true;
          paramb.bAT -= localFlexItem.getFlexShrink();
          i = b(paramInt2, localFlexItem, paramb.bAV);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i);
          j = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          a(i3, i4, i, localView);
          this.bAY.a(i3, localView);
          i = m;
          label407:
          k = Math.max(k, localFlexItem.wp() + i1 + localFlexItem.getMarginBottom() + this.bAY.cj(localView));
          m = paramb.bAO;
          i1 = localFlexItem.wo();
          paramb.bAO = (localFlexItem.wq() + (j + i1) + m);
          j = k;
          label483:
          paramb.bAQ = Math.max(paramb.bAQ, j);
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
      if (this.bBc != null) {
        j = (int)(this.bBc[i3] >> 32);
      }
      m = localView.getMeasuredWidth();
      if (this.bBc != null) {
        m = (int)this.bBc[i3];
      }
      if ((this.bAZ[i3] == 0) && (localFlexItem.getFlexShrink() > 0.0F))
      {
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n == paramb.ars - 1)
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
            this.bAZ[i3] = true;
            paramb.bAT -= localFlexItem.getFlexShrink();
            label757:
            i = a(paramInt1, localFlexItem, paramb.bAV);
            i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            localView.measure(i, i4);
            i1 = localView.getMeasuredWidth();
            j = localView.getMeasuredHeight();
            a(i3, i, i4, localView);
            this.bAY.a(i3, localView);
            i = m;
          }
        }
      }
      for (;;)
      {
        k = Math.max(k, localFlexItem.wo() + i1 + localFlexItem.wq() + this.bAY.cj(localView));
        m = paramb.bAO;
        i1 = localFlexItem.wp();
        paramb.bAO = (localFlexItem.getMarginBottom() + (j + i1) + m);
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
        if ((i != 0) && (i2 != paramb.bAO))
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
    AppMethodBeat.i(62228);
    if (paramBoolean)
    {
      i = this.bAY.getPaddingStart();
      AppMethodBeat.o(62228);
      return i;
    }
    int i = this.bAY.getPaddingTop();
    AppMethodBeat.o(62228);
    return i;
  }
  
  private int bb(boolean paramBoolean)
  {
    AppMethodBeat.i(62229);
    if (paramBoolean)
    {
      i = this.bAY.getPaddingEnd();
      AppMethodBeat.o(62229);
      return i;
    }
    int i = this.bAY.getPaddingBottom();
    AppMethodBeat.o(62229);
    return i;
  }
  
  private int bc(boolean paramBoolean)
  {
    AppMethodBeat.i(62230);
    if (paramBoolean)
    {
      i = this.bAY.getPaddingTop();
      AppMethodBeat.o(62230);
      return i;
    }
    int i = this.bAY.getPaddingStart();
    AppMethodBeat.o(62230);
    return i;
  }
  
  private int bd(boolean paramBoolean)
  {
    AppMethodBeat.i(62231);
    if (paramBoolean)
    {
      i = this.bAY.getPaddingBottom();
      AppMethodBeat.o(62231);
      return i;
    }
    int i = this.bAY.getPaddingEnd();
    AppMethodBeat.o(62231);
    return i;
  }
  
  private static long bs(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1 & 0xFFFFFFFF;
  }
  
  private static int c(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62236);
    if (paramBoolean)
    {
      i = paramFlexItem.wo();
      AppMethodBeat.o(62236);
      return i;
    }
    int i = paramFlexItem.wp();
    AppMethodBeat.o(62236);
    return i;
  }
  
  private static int d(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62237);
    if (paramBoolean)
    {
      i = paramFlexItem.wq();
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
      i = paramFlexItem.wp();
      AppMethodBeat.o(62238);
      return i;
    }
    int i = paramFlexItem.wo();
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
    int i = paramFlexItem.wq();
    AppMethodBeat.o(62239);
    return i;
  }
  
  private List<c.b> fv(int paramInt)
  {
    AppMethodBeat.i(62219);
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      FlexItem localFlexItem = (FlexItem)this.bAY.ft(i).getLayoutParams();
      c.b localb = new c.b((byte)0);
      localb.order = localFlexItem.getOrder();
      localb.index = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(62219);
    return localArrayList;
  }
  
  private void fw(int paramInt)
  {
    AppMethodBeat.i(62246);
    int i;
    if (this.bAZ == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bAZ = new boolean[i];
      AppMethodBeat.o(62246);
      return;
    }
    if (this.bAZ.length < paramInt)
    {
      int j = this.bAZ.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bAZ = new boolean[i];
      AppMethodBeat.o(62246);
      return;
    }
    Arrays.fill(this.bAZ, false);
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
  
  private void n(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62255);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - localFlexItem.wp() - localFlexItem.getMarginBottom() - this.bAY.cj(paramView), localFlexItem.getMinHeight()), localFlexItem.getMaxHeight());
    if (this.bBc != null) {}
    for (paramInt1 = (int)this.bBc[paramInt2];; paramInt1 = paramView.getMeasuredWidth())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(paramInt1, i);
      a(paramInt2, paramInt1, i, paramView);
      this.bAY.a(paramInt2, paramView);
      AppMethodBeat.o(62255);
      return;
    }
  }
  
  private void o(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62256);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - localFlexItem.wo() - localFlexItem.wq() - this.bAY.cj(paramView), localFlexItem.getMinWidth()), localFlexItem.getMaxWidth());
    if (this.bBc != null) {}
    for (paramInt1 = (int)(this.bBc[paramInt2] >> 32);; paramInt1 = paramView.getMeasuredHeight())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(i, paramInt1);
      a(paramInt2, i, paramInt1, paramView);
      this.bAY.a(paramInt2, paramView);
      AppMethodBeat.o(62256);
      return;
    }
  }
  
  final void a(View paramView, b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62257);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.bAY.getAlignItems();
    if (localFlexItem.wl() != -1) {
      i = localFlexItem.wl();
    }
    int j = paramb.bAQ;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62257);
      return;
      if (this.bAY.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, localFlexItem.wp() + paramInt2, paramInt3, localFlexItem.wp() + paramInt4);
        AppMethodBeat.o(62257);
        return;
      }
      paramView.layout(paramInt1, paramInt2 - localFlexItem.getMarginBottom(), paramInt3, paramInt4 - localFlexItem.getMarginBottom());
      AppMethodBeat.o(62257);
      return;
      if (this.bAY.getFlexWrap() != 2)
      {
        i = Math.max(paramb.bAU - paramView.getBaseline(), localFlexItem.wp());
        paramView.layout(paramInt1, paramInt2 + i, paramInt3, i + paramInt4);
        AppMethodBeat.o(62257);
        return;
      }
      i = Math.max(paramb.bAU - paramView.getMeasuredHeight() + paramView.getBaseline(), localFlexItem.getMarginBottom());
      paramView.layout(paramInt1, paramInt2 - i, paramInt3, paramInt4 - i);
      AppMethodBeat.o(62257);
      return;
      if (this.bAY.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, paramInt2 + j - paramView.getMeasuredHeight() - localFlexItem.getMarginBottom(), paramInt3, j + paramInt2 - localFlexItem.getMarginBottom());
        AppMethodBeat.o(62257);
        return;
      }
      i = paramView.getMeasuredHeight();
      int k = localFlexItem.wp();
      int m = paramView.getMeasuredHeight();
      paramView.layout(paramInt1, paramInt2 - j + i + k, paramInt3, localFlexItem.wp() + (paramInt4 - j + m));
      AppMethodBeat.o(62257);
      return;
      paramInt4 = (j - paramView.getMeasuredHeight() + localFlexItem.wp() - localFlexItem.getMarginBottom()) / 2;
      if (this.bAY.getFlexWrap() != 2)
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
    int i = this.bAY.getAlignItems();
    if (localFlexItem.wl() != -1) {
      i = localFlexItem.wl();
    }
    int j = paramb.bAQ;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62258);
      return;
      if (!paramBoolean)
      {
        paramView.layout(localFlexItem.wo() + paramInt1, paramInt2, localFlexItem.wo() + paramInt3, paramInt4);
        AppMethodBeat.o(62258);
        return;
      }
      paramView.layout(paramInt1 - localFlexItem.wq(), paramInt2, paramInt3 - localFlexItem.wq(), paramInt4);
      AppMethodBeat.o(62258);
      return;
      if (!paramBoolean)
      {
        paramView.layout(paramInt1 + j - paramView.getMeasuredWidth() - localFlexItem.wq(), paramInt2, j + paramInt3 - paramView.getMeasuredWidth() - localFlexItem.wq(), paramInt4);
        AppMethodBeat.o(62258);
        return;
      }
      i = paramView.getMeasuredWidth();
      int k = localFlexItem.wo();
      int m = paramView.getMeasuredWidth();
      paramView.layout(paramInt1 - j + i + k, paramInt2, localFlexItem.wo() + (paramInt3 - j + m), paramInt4);
      AppMethodBeat.o(62258);
      return;
      paramb = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      i = (j - paramView.getMeasuredWidth() + g.a(paramb) - g.b(paramb)) / 2;
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
    boolean bool = this.bAY.wk();
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int n = 0;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    parama.bBd = ((List)localObject);
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
      i5 = ba(bool);
      i6 = bb(bool);
      i7 = bc(bool);
      i8 = bd(bool);
      k = -2147483648;
      j = 0;
      i1 = 0;
      paramList = new b();
      paramList.bAX = paramInt4;
      paramList.bAO = (i5 + i6);
      i9 = this.bAY.getFlexItemCount();
      m = paramInt4;
      paramInt4 = i;
      i = n;
      if (m >= i9) {
        break label1323;
      }
      localView = this.bAY.fu(m);
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
        paramList.bAR += 1;
        paramList.ars += 1;
        if (a(m, i9, paramList)) {
          a((List)localObject, paramList, m, j);
        }
      }
      else
      {
        FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
        if (localFlexItem.wl() == 4) {
          paramList.bAW.add(Integer.valueOf(m));
        }
        int i2 = a(localFlexItem, bool);
        n = i2;
        if (localFlexItem.wn() != -1.0F)
        {
          n = i2;
          if (i3 == 1073741824) {
            n = Math.round(i4 * localFlexItem.wn());
          }
        }
        int i10;
        if (bool)
        {
          i2 = this.bAY.w(paramInt1, i5 + i6 + c(localFlexItem, true) + d(localFlexItem, true), n);
          n = this.bAY.x(paramInt2, i7 + i8 + e(localFlexItem, true) + f(localFlexItem, true) + j, b(localFlexItem, true));
          localView.measure(i2, n);
          a(m, i2, n, localView);
          this.bAY.a(m, localView);
          J(localView, m);
          n = View.combineMeasuredStates(i, localView.getMeasuredState());
          i = paramList.bAO;
          i10 = j(localView, bool);
          int i11 = c(localFlexItem, bool);
          if (!a(localView, i3, i4, i, d(localFlexItem, bool) + (i10 + i11), localFlexItem, m, i1, ((List)localObject).size())) {
            break label1267;
          }
          if (paramList.wr() <= 0) {
            break label1346;
          }
          if (m <= 0) {
            break label1175;
          }
          i = m - 1;
          a((List)localObject, paramList, i, j);
          j += paramList.bAQ;
        }
        for (;;)
        {
          if (bool)
          {
            if (localFlexItem.getHeight() == -1)
            {
              paramList = this.bAY;
              localView.measure(i2, paramList.x(paramInt2, paramList.getPaddingTop() + this.bAY.getPaddingBottom() + localFlexItem.wp() + localFlexItem.getMarginBottom() + j, localFlexItem.getHeight()));
              J(localView, m);
            }
            paramList = new b();
            paramList.ars = 1;
            paramList.bAO = (i5 + i6);
            paramList.bAX = m;
            i = 0;
            k = -2147483648;
            label738:
            if (this.bBa != null) {
              this.bBa[m] = ((List)localObject).size();
            }
            paramList.bAO += j(localView, bool) + c(localFlexItem, bool) + d(localFlexItem, bool);
            paramList.bAS += localFlexItem.getFlexGrow();
            paramList.bAT += localFlexItem.getFlexShrink();
            this.bAY.a(localView, m, i, paramList);
            i2 = Math.max(k, k(localView, bool) + e(localFlexItem, bool) + f(localFlexItem, bool) + this.bAY.cj(localView));
            paramList.bAQ = Math.max(paramList.bAQ, i2);
            if (bool)
            {
              if (this.bAY.getFlexWrap() == 2) {
                break label1288;
              }
              paramList.bAU = Math.max(paramList.bAU, localView.getBaseline() + localFlexItem.wp());
            }
            if (!a(m, i9, paramList)) {
              break label1343;
            }
            a((List)localObject, paramList, m, j);
            j += paramList.bAQ;
          }
          for (;;)
          {
            if ((paramInt5 != -1) && (((List)localObject).size() > 0) && (((b)((List)localObject).get(((List)localObject).size() - 1)).Zp >= paramInt5) && (m >= paramInt5) && (paramInt4 == 0))
            {
              j = -paramList.bAQ;
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
                i10 = this.bAY.w(paramInt2, i7 + i8 + e(localFlexItem, false) + f(localFlexItem, false) + j, b(localFlexItem, false));
                i2 = this.bAY.x(paramInt1, i5 + i6 + c(localFlexItem, false) + d(localFlexItem, false), n);
                localView.measure(i10, i2);
                a(m, i10, i2, localView);
                break label471;
                i = 0;
                break label589;
                if (localFlexItem.getWidth() != -1) {
                  break label699;
                }
                paramList = this.bAY;
                localView.measure(paramList.w(paramInt2, paramList.getPaddingLeft() + this.bAY.getPaddingRight() + localFlexItem.wo() + localFlexItem.wq() + j, localFlexItem.getWidth()), i2);
                J(localView, m);
                break label699;
                label1267:
                paramList.ars += 1;
                i = i1 + 1;
                break label738;
                paramList.bAU = Math.max(paramList.bAU, localView.getMeasuredHeight() - localView.getBaseline() + localFlexItem.getMarginBottom());
                break label947;
                k = i;
              }
              parama.bBe = k;
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
    int i = this.bAY.getFlexItemCount();
    paramSparseIntArray = a(i, fv(i), paramSparseIntArray);
    AppMethodBeat.o(62218);
    return paramSparseIntArray;
  }
  
  final int[] a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(62217);
    int i = this.bAY.getFlexItemCount();
    List localList = fv(i);
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
      if (paramInt < this.bAY.getFlexItemCount())
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
    int j = this.bAY.getFlexItemCount();
    if (paramSparseIntArray.size() != j)
    {
      AppMethodBeat.o(62220);
      return true;
    }
    int i = 0;
    while (i < j)
    {
      View localView = this.bAY.ft(i);
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
  
  final void br(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62244);
    y(paramInt1, paramInt2, 0);
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
    if ((!$assertionsDisabled) && (this.bBa == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(62263);
      throw paramList;
    }
    if ((!$assertionsDisabled) && (this.bBb == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(62263);
      throw paramList;
    }
    int j = this.bBa[paramInt];
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
    i = this.bBa.length - 1;
    if (paramInt > i) {
      Arrays.fill(this.bBa, -1);
    }
    for (;;)
    {
      i = this.bBb.length - 1;
      if (paramInt <= i) {
        break;
      }
      Arrays.fill(this.bBb, 0L);
      AppMethodBeat.o(62263);
      return;
      Arrays.fill(this.bBa, paramInt, i, -1);
    }
    Arrays.fill(this.bBb, paramInt, i, 0L);
    AppMethodBeat.o(62263);
  }
  
  final void d(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(62226);
    a(parama, paramInt2, paramInt1, paramInt3, 0, paramInt4, paramList);
    AppMethodBeat.o(62226);
  }
  
  final void fA(int paramInt)
  {
    AppMethodBeat.i(62262);
    int i;
    if (this.bBa == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bBa = new int[i];
      AppMethodBeat.o(62262);
      return;
    }
    if (this.bBa.length < paramInt)
    {
      int j = this.bBa.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bBa = Arrays.copyOf(this.bBa, i);
    }
    AppMethodBeat.o(62262);
  }
  
  final void fx(int paramInt)
  {
    AppMethodBeat.i(62254);
    if (paramInt >= this.bAY.getFlexItemCount())
    {
      AppMethodBeat.o(62254);
      return;
    }
    int j = this.bAY.getFlexDirection();
    b localb;
    Object localObject2;
    Object localObject3;
    if (this.bAY.getAlignItems() == 4)
    {
      int i = 0;
      if (this.bBa != null) {
        i = this.bBa[paramInt];
      }
      localObject1 = this.bAY.getFlexLinesInternal();
      int k = ((List)localObject1).size();
      paramInt = i;
      while (paramInt < k)
      {
        localb = (b)((List)localObject1).get(paramInt);
        int m = localb.ars;
        i = 0;
        if (i < m)
        {
          int n = localb.bAX + i;
          if (i < this.bAY.getFlexItemCount())
          {
            localObject2 = this.bAY.fu(n);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8))
            {
              localObject3 = (FlexItem)((View)localObject2).getLayoutParams();
              if ((((FlexItem)localObject3).wl() == -1) || (((FlexItem)localObject3).wl() == 4)) {
                switch (j)
                {
                default: 
                  localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
                  AppMethodBeat.o(62254);
                  throw ((Throwable)localObject1);
                case 0: 
                case 1: 
                  n((View)localObject2, localb.bAQ, n);
                }
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            o((View)localObject2, localb.bAQ, n);
          }
        }
        paramInt += 1;
      }
      AppMethodBeat.o(62254);
      return;
    }
    Object localObject1 = this.bAY.getFlexLinesInternal().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localb = (b)((Iterator)localObject1).next();
      localObject2 = localb.bAW.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        View localView = this.bAY.fu(((Integer)localObject3).intValue());
        switch (j)
        {
        default: 
          localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
          AppMethodBeat.o(62254);
          throw ((Throwable)localObject1);
        case 0: 
        case 1: 
          n(localView, localb.bAQ, ((Integer)localObject3).intValue());
          break;
        case 2: 
        case 3: 
          o(localView, localb.bAQ, ((Integer)localObject3).intValue());
        }
      }
    }
    AppMethodBeat.o(62254);
  }
  
  final void fy(int paramInt)
  {
    AppMethodBeat.i(62259);
    int i;
    if (this.bBc == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bBc = new long[i];
      AppMethodBeat.o(62259);
      return;
    }
    if (this.bBc.length < paramInt)
    {
      int j = this.bBc.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bBc = Arrays.copyOf(this.bBc, i);
    }
    AppMethodBeat.o(62259);
  }
  
  final void fz(int paramInt)
  {
    AppMethodBeat.i(62260);
    int i;
    if (this.bBb == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bBb = new long[i];
      AppMethodBeat.o(62260);
      return;
    }
    if (this.bBb.length < paramInt)
    {
      int j = this.bBb.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bBb = Arrays.copyOf(this.bBb, i);
    }
    AppMethodBeat.o(62260);
  }
  
  final void ws()
  {
    AppMethodBeat.i(62253);
    fx(0);
    AppMethodBeat.o(62253);
  }
  
  final void y(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62245);
    fw(this.bAY.getFlexItemCount());
    if (paramInt3 >= this.bAY.getFlexItemCount())
    {
      AppMethodBeat.o(62245);
      return;
    }
    int i = this.bAY.getFlexDirection();
    Object localObject;
    int j;
    switch (this.bAY.getFlexDirection())
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
        j = this.bAY.getPaddingLeft() + this.bAY.getPaddingRight();
        if (this.bBa == null) {
          break label334;
        }
      }
      break;
    }
    label191:
    label334:
    for (paramInt3 = this.bBa[paramInt3];; paramInt3 = 0)
    {
      localObject = this.bAY.getFlexLinesInternal();
      int k = ((List)localObject).size();
      if (paramInt3 < k)
      {
        b localb = (b)((List)localObject).get(paramInt3);
        if (localb.bAO < i) {
          a(paramInt1, paramInt2, localb, i, j, false);
        }
        for (;;)
        {
          paramInt3 += 1;
          break label191;
          i = this.bAY.getLargestMainSize();
          break;
          j = View.MeasureSpec.getMode(paramInt2);
          i = View.MeasureSpec.getSize(paramInt2);
          if (j == 1073741824) {}
          for (;;)
          {
            j = this.bAY.getPaddingTop() + this.bAY.getPaddingBottom();
            break;
            i = this.bAY.getLargestMainSize();
          }
          b(paramInt1, paramInt2, localb, i, j, false);
        }
      }
      AppMethodBeat.o(62245);
      return;
    }
  }
  
  final void z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62251);
    int i = this.bAY.getFlexDirection();
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
      localObject1 = this.bAY.getFlexLinesInternal();
      if (paramInt2 != 1073741824) {
        break label224;
      }
      paramInt2 = this.bAY.getSumOfCrossSize() + paramInt3;
      if (((List)localObject1).size() != 1) {
        break;
      }
      ((b)((List)localObject1).get(0)).bAQ = (paramInt1 - paramInt3);
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
    switch (this.bAY.getAlignContent())
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
        float f4 = ((b)localObject2).bAQ + f5;
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
      ((b)localObject2).bAQ = paramInt1;
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
          this.bAY.setFlexLines(a((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(62251);
          return;
        }
        paramInt1 = (paramInt1 - paramInt2) / (((List)localObject1).size() * 2);
        localObject2 = new ArrayList();
        b localb1 = new b();
        localb1.bAQ = paramInt1;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          b localb2 = (b)((Iterator)localObject1).next();
          ((List)localObject2).add(localb1);
          ((List)localObject2).add(localb2);
          ((List)localObject2).add(localb1);
        }
        this.bAY.setFlexLines((List)localObject2);
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
            localb1.bAQ = Math.round(f3 + f1);
            f1 = 0.0F;
            f2 = f1 + (f3 - localb1.bAQ);
            if (f2 <= 1.0F) {
              break label735;
            }
            localb1.bAQ += 1;
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
          localb1.bAQ = Math.round(f3);
          break label666;
          label735:
          f1 = f2;
          if (f2 >= -1.0F) {
            break label705;
          }
          localb1.bAQ -= 1;
          f1 = f2 + 1.0F;
          break label705;
          this.bAY.setFlexLines((List)localObject2);
          AppMethodBeat.o(62251);
          return;
          this.bAY.setFlexLines(a((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(62251);
          return;
          localObject2 = new b();
          ((b)localObject2).bAQ = (paramInt1 - paramInt2);
          ((List)localObject1).add(0, localObject2);
          break;
        }
      }
    }
  }
  
  static final class a
  {
    List<b> bBd;
    int bBe;
    
    final void reset()
    {
      this.bBd = null;
      this.bBe = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.c
 * JD-Core Version:    0.7.0.1
 */