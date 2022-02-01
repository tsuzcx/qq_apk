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
  private final a bJk;
  private boolean[] bJl;
  int[] bJm;
  long[] bJn;
  private long[] bJo;
  
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
    this.bJk = parama;
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
        this.bJk.a(paramInt, paramView);
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
    a locala = this.bJk;
    paramInt2 = locala.t(paramInt1, locala.getPaddingLeft() + this.bJk.getPaddingRight() + paramFlexItem.xG() + paramFlexItem.xI() + paramInt2, paramFlexItem.getWidth());
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
    localb.bJc = paramInt1;
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
    if (this.bJn != null) {
      this.bJn[paramInt1] = bl(paramInt2, paramInt3);
    }
    if (this.bJo != null) {
      this.bJo[paramInt1] = bl(paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    }
    AppMethodBeat.o(62261);
  }
  
  private void a(int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(62247);
    if ((paramb.bJe <= 0.0F) || (paramInt3 < paramb.bJa))
    {
      AppMethodBeat.o(62247);
      return;
    }
    int i1 = paramb.bJa;
    int i = 0;
    float f4 = (paramInt3 - paramb.bJa) / paramb.bJe;
    paramb.bJa = (paramb.bJb + paramInt4);
    int n = 0;
    if (!paramBoolean) {
      paramb.bJc = -2147483648;
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
    if (m < paramb.auc)
    {
      i2 = paramb.bJj + m;
      localView = this.bJk.fk(i2);
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
          j = this.bJk.getFlexDirection();
          if ((j != 0) && (j != 1)) {
            break label610;
          }
          j = localView.getMeasuredWidth();
          if (this.bJo != null) {
            j = (int)this.bJo[i2];
          }
          k = localView.getMeasuredHeight();
          if (this.bJo != null) {
            k = (int)(this.bJo[i2] >> 32);
          }
          if ((this.bJl[i2] != 0) || (localFlexItem.getFlexGrow() <= 0.0F)) {
            break label1032;
          }
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m != paramb.auc - 1) {
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
          this.bJl[i2] = true;
          paramb.bJe -= localFlexItem.getFlexGrow();
          i3 = b(paramInt2, localFlexItem, paramb.bJh);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i3);
          j = localView.getMeasuredWidth();
          k = localView.getMeasuredHeight();
          a(i2, i4, i3, localView);
          this.bJk.a(i2, localView);
        }
      }
    }
    label1029:
    label1032:
    for (;;)
    {
      k = Math.max(n, localFlexItem.xH() + k + localFlexItem.getMarginBottom() + this.bJk.bV(localView));
      n = paramb.bJa;
      i2 = localFlexItem.xG();
      paramb.bJa = (localFlexItem.xI() + (i2 + j) + n);
      j = k;
      label501:
      paramb.bJc = Math.max(paramb.bJc, j);
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
        if (this.bJo != null) {
          j = (int)(this.bJo[i2] >> 32);
        }
        k = localView.getMeasuredWidth();
        if (this.bJo != null) {
          k = (int)this.bJo[i2];
        }
        if ((this.bJl[i2] == 0) && (localFlexItem.getFlexGrow() > 0.0F))
        {
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m == paramb.auc - 1)
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
              this.bJl[i2] = true;
              paramb.bJe -= localFlexItem.getFlexGrow();
              label779:
              i3 = a(paramInt1, localFlexItem, paramb.bJh);
              i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
              localView.measure(i3, i4);
              k = localView.getMeasuredWidth();
              j = localView.getMeasuredHeight();
              a(i2, i3, i4, localView);
              this.bJk.a(i2, localView);
            }
          }
        }
        for (;;)
        {
          k = Math.max(n, localFlexItem.xG() + k + localFlexItem.xI() + this.bJk.bV(localView));
          n = paramb.bJa;
          i2 = localFlexItem.xH();
          paramb.bJa = (localFlexItem.getMarginBottom() + (i2 + j) + n);
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
            if ((i != 0) && (i1 != paramb.bJa))
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
    paramb.bJh = paramInt2;
    this.bJk.a(paramb);
    paramb.acn = paramInt1;
    paramList.add(paramb);
    AppMethodBeat.o(62242);
  }
  
  private static boolean a(int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(62241);
    if ((paramInt1 == paramInt2 - 1) && (paramb.xJ() != 0))
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
    if (this.bJk.getFlexWrap() == 0)
    {
      AppMethodBeat.o(62240);
      return false;
    }
    if (paramFlexItem.xE())
    {
      AppMethodBeat.o(62240);
      return true;
    }
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(62240);
      return false;
    }
    paramInt1 = this.bJk.getMaxLine();
    if ((paramInt1 != -1) && (paramInt1 <= paramInt7 + 1))
    {
      AppMethodBeat.o(62240);
      return false;
    }
    paramInt5 = this.bJk.m(paramView, paramInt5, paramInt6);
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
  
  private int aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(62228);
    if (paramBoolean)
    {
      i = this.bJk.getPaddingStart();
      AppMethodBeat.o(62228);
      return i;
    }
    int i = this.bJk.getPaddingTop();
    AppMethodBeat.o(62228);
    return i;
  }
  
  static int at(long paramLong)
  {
    return (int)paramLong;
  }
  
  static int au(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private int b(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    AppMethodBeat.i(62250);
    a locala = this.bJk;
    paramInt2 = locala.u(paramInt1, locala.getPaddingTop() + this.bJk.getPaddingBottom() + paramFlexItem.xH() + paramFlexItem.getMarginBottom() + paramInt2, paramFlexItem.getHeight());
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
    int i2 = paramb.bJa;
    if ((paramb.bJf <= 0.0F) || (paramInt3 > paramb.bJa))
    {
      AppMethodBeat.o(62248);
      return;
    }
    int i = 0;
    float f4 = (paramb.bJa - paramInt3) / paramb.bJf;
    float f1 = 0.0F;
    paramb.bJa = (paramb.bJb + paramInt4);
    if (!paramBoolean) {
      paramb.bJc = -2147483648;
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
    if (n < paramb.auc)
    {
      i3 = paramb.bJj + n;
      localView = this.bJk.fk(i3);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label1036;
      }
      localFlexItem = (FlexItem)localView.getLayoutParams();
      j = this.bJk.getFlexDirection();
      if ((j == 0) || (j == 1))
      {
        j = localView.getMeasuredWidth();
        if (this.bJo != null) {
          j = (int)this.bJo[i3];
        }
        m = localView.getMeasuredHeight();
        if (this.bJo != null) {
          m = (int)(this.bJo[i3] >> 32);
        }
        if ((this.bJl[i3] != 0) || (localFlexItem.getFlexShrink() <= 0.0F)) {
          break label1029;
        }
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n != paramb.auc - 1) {
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
          this.bJl[i3] = true;
          paramb.bJf -= localFlexItem.getFlexShrink();
          i = b(paramInt2, localFlexItem, paramb.bJh);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i);
          j = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          a(i3, i4, i, localView);
          this.bJk.a(i3, localView);
          i = m;
          label407:
          k = Math.max(k, localFlexItem.xH() + i1 + localFlexItem.getMarginBottom() + this.bJk.bV(localView));
          m = paramb.bJa;
          i1 = localFlexItem.xG();
          paramb.bJa = (localFlexItem.xI() + (j + i1) + m);
          j = k;
          label483:
          paramb.bJc = Math.max(paramb.bJc, j);
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
      if (this.bJo != null) {
        j = (int)(this.bJo[i3] >> 32);
      }
      m = localView.getMeasuredWidth();
      if (this.bJo != null) {
        m = (int)this.bJo[i3];
      }
      if ((this.bJl[i3] == 0) && (localFlexItem.getFlexShrink() > 0.0F))
      {
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n == paramb.auc - 1)
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
            this.bJl[i3] = true;
            paramb.bJf -= localFlexItem.getFlexShrink();
            label757:
            i = a(paramInt1, localFlexItem, paramb.bJh);
            i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            localView.measure(i, i4);
            i1 = localView.getMeasuredWidth();
            j = localView.getMeasuredHeight();
            a(i3, i, i4, localView);
            this.bJk.a(i3, localView);
            i = m;
          }
        }
      }
      for (;;)
      {
        k = Math.max(k, localFlexItem.xG() + i1 + localFlexItem.xI() + this.bJk.bV(localView));
        m = paramb.bJa;
        i1 = localFlexItem.xH();
        paramb.bJa = (localFlexItem.getMarginBottom() + (j + i1) + m);
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
        if ((i != 0) && (i2 != paramb.bJa))
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
    AppMethodBeat.i(62229);
    if (paramBoolean)
    {
      i = this.bJk.getPaddingEnd();
      AppMethodBeat.o(62229);
      return i;
    }
    int i = this.bJk.getPaddingBottom();
    AppMethodBeat.o(62229);
    return i;
  }
  
  private int bb(boolean paramBoolean)
  {
    AppMethodBeat.i(62230);
    if (paramBoolean)
    {
      i = this.bJk.getPaddingTop();
      AppMethodBeat.o(62230);
      return i;
    }
    int i = this.bJk.getPaddingStart();
    AppMethodBeat.o(62230);
    return i;
  }
  
  private int bc(boolean paramBoolean)
  {
    AppMethodBeat.i(62231);
    if (paramBoolean)
    {
      i = this.bJk.getPaddingBottom();
      AppMethodBeat.o(62231);
      return i;
    }
    int i = this.bJk.getPaddingEnd();
    AppMethodBeat.o(62231);
    return i;
  }
  
  private static long bl(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1 & 0xFFFFFFFF;
  }
  
  private static int c(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62236);
    if (paramBoolean)
    {
      i = paramFlexItem.xG();
      AppMethodBeat.o(62236);
      return i;
    }
    int i = paramFlexItem.xH();
    AppMethodBeat.o(62236);
    return i;
  }
  
  private static int d(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(62237);
    if (paramBoolean)
    {
      i = paramFlexItem.xI();
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
      i = paramFlexItem.xH();
      AppMethodBeat.o(62238);
      return i;
    }
    int i = paramFlexItem.xG();
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
    int i = paramFlexItem.xI();
    AppMethodBeat.o(62239);
    return i;
  }
  
  private List<c.b> fl(int paramInt)
  {
    AppMethodBeat.i(62219);
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      FlexItem localFlexItem = (FlexItem)this.bJk.fj(i).getLayoutParams();
      c.b localb = new c.b((byte)0);
      localb.order = localFlexItem.getOrder();
      localb.index = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(62219);
    return localArrayList;
  }
  
  private void fm(int paramInt)
  {
    AppMethodBeat.i(62246);
    int i;
    if (this.bJl == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bJl = new boolean[i];
      AppMethodBeat.o(62246);
      return;
    }
    if (this.bJl.length < paramInt)
    {
      int j = this.bJl.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bJl = new boolean[i];
      AppMethodBeat.o(62246);
      return;
    }
    Arrays.fill(this.bJl, false);
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
    int i = Math.min(Math.max(paramInt1 - localFlexItem.xH() - localFlexItem.getMarginBottom() - this.bJk.bV(paramView), localFlexItem.getMinHeight()), localFlexItem.getMaxHeight());
    if (this.bJo != null) {}
    for (paramInt1 = (int)this.bJo[paramInt2];; paramInt1 = paramView.getMeasuredWidth())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(paramInt1, i);
      a(paramInt2, paramInt1, i, paramView);
      this.bJk.a(paramInt2, paramView);
      AppMethodBeat.o(62255);
      return;
    }
  }
  
  private void o(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62256);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - localFlexItem.xG() - localFlexItem.xI() - this.bJk.bV(paramView), localFlexItem.getMinWidth()), localFlexItem.getMaxWidth());
    if (this.bJo != null) {}
    for (paramInt1 = (int)(this.bJo[paramInt2] >> 32);; paramInt1 = paramView.getMeasuredHeight())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(i, paramInt1);
      a(paramInt2, i, paramInt1, paramView);
      this.bJk.a(paramInt2, paramView);
      AppMethodBeat.o(62256);
      return;
    }
  }
  
  final void a(View paramView, b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62257);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.bJk.getAlignItems();
    if (localFlexItem.xD() != -1) {
      i = localFlexItem.xD();
    }
    int j = paramb.bJc;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62257);
      return;
      if (this.bJk.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, localFlexItem.xH() + paramInt2, paramInt3, localFlexItem.xH() + paramInt4);
        AppMethodBeat.o(62257);
        return;
      }
      paramView.layout(paramInt1, paramInt2 - localFlexItem.getMarginBottom(), paramInt3, paramInt4 - localFlexItem.getMarginBottom());
      AppMethodBeat.o(62257);
      return;
      if (this.bJk.getFlexWrap() != 2)
      {
        i = Math.max(paramb.bJg - paramView.getBaseline(), localFlexItem.xH());
        paramView.layout(paramInt1, paramInt2 + i, paramInt3, i + paramInt4);
        AppMethodBeat.o(62257);
        return;
      }
      i = Math.max(paramb.bJg - paramView.getMeasuredHeight() + paramView.getBaseline(), localFlexItem.getMarginBottom());
      paramView.layout(paramInt1, paramInt2 - i, paramInt3, paramInt4 - i);
      AppMethodBeat.o(62257);
      return;
      if (this.bJk.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, paramInt2 + j - paramView.getMeasuredHeight() - localFlexItem.getMarginBottom(), paramInt3, j + paramInt2 - localFlexItem.getMarginBottom());
        AppMethodBeat.o(62257);
        return;
      }
      i = paramView.getMeasuredHeight();
      int k = localFlexItem.xH();
      int m = paramView.getMeasuredHeight();
      paramView.layout(paramInt1, paramInt2 - j + i + k, paramInt3, localFlexItem.xH() + (paramInt4 - j + m));
      AppMethodBeat.o(62257);
      return;
      paramInt4 = (j - paramView.getMeasuredHeight() + localFlexItem.xH() - localFlexItem.getMarginBottom()) / 2;
      if (this.bJk.getFlexWrap() != 2)
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
    int i = this.bJk.getAlignItems();
    if (localFlexItem.xD() != -1) {
      i = localFlexItem.xD();
    }
    int j = paramb.bJc;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62258);
      return;
      if (!paramBoolean)
      {
        paramView.layout(localFlexItem.xG() + paramInt1, paramInt2, localFlexItem.xG() + paramInt3, paramInt4);
        AppMethodBeat.o(62258);
        return;
      }
      paramView.layout(paramInt1 - localFlexItem.xI(), paramInt2, paramInt3 - localFlexItem.xI(), paramInt4);
      AppMethodBeat.o(62258);
      return;
      if (!paramBoolean)
      {
        paramView.layout(paramInt1 + j - paramView.getMeasuredWidth() - localFlexItem.xI(), paramInt2, j + paramInt3 - paramView.getMeasuredWidth() - localFlexItem.xI(), paramInt4);
        AppMethodBeat.o(62258);
        return;
      }
      i = paramView.getMeasuredWidth();
      int k = localFlexItem.xG();
      int m = paramView.getMeasuredWidth();
      paramView.layout(paramInt1 - j + i + k, paramInt2, localFlexItem.xG() + (paramInt3 - j + m), paramInt4);
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
    boolean bool = this.bJk.xC();
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int n = 0;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    parama.bJp = ((List)localObject);
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
      i5 = aZ(bool);
      i6 = ba(bool);
      i7 = bb(bool);
      i8 = bc(bool);
      k = -2147483648;
      j = 0;
      i1 = 0;
      paramList = new b();
      paramList.bJj = paramInt4;
      paramList.bJa = (i5 + i6);
      i9 = this.bJk.getFlexItemCount();
      m = paramInt4;
      paramInt4 = i;
      i = n;
      if (m >= i9) {
        break label1323;
      }
      localView = this.bJk.fk(m);
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
        paramList.bJd += 1;
        paramList.auc += 1;
        if (a(m, i9, paramList)) {
          a((List)localObject, paramList, m, j);
        }
      }
      else
      {
        FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
        if (localFlexItem.xD() == 4) {
          paramList.bJi.add(Integer.valueOf(m));
        }
        int i2 = a(localFlexItem, bool);
        n = i2;
        if (localFlexItem.xF() != -1.0F)
        {
          n = i2;
          if (i3 == 1073741824) {
            n = Math.round(i4 * localFlexItem.xF());
          }
        }
        int i10;
        if (bool)
        {
          i2 = this.bJk.t(paramInt1, i5 + i6 + c(localFlexItem, true) + d(localFlexItem, true), n);
          n = this.bJk.u(paramInt2, i7 + i8 + e(localFlexItem, true) + f(localFlexItem, true) + j, b(localFlexItem, true));
          localView.measure(i2, n);
          a(m, i2, n, localView);
          this.bJk.a(m, localView);
          H(localView, m);
          n = View.combineMeasuredStates(i, localView.getMeasuredState());
          i = paramList.bJa;
          i10 = j(localView, bool);
          int i11 = c(localFlexItem, bool);
          if (!a(localView, i3, i4, i, d(localFlexItem, bool) + (i10 + i11), localFlexItem, m, i1, ((List)localObject).size())) {
            break label1267;
          }
          if (paramList.xJ() <= 0) {
            break label1346;
          }
          if (m <= 0) {
            break label1175;
          }
          i = m - 1;
          a((List)localObject, paramList, i, j);
          j += paramList.bJc;
        }
        for (;;)
        {
          if (bool)
          {
            if (localFlexItem.getHeight() == -1)
            {
              paramList = this.bJk;
              localView.measure(i2, paramList.u(paramInt2, paramList.getPaddingTop() + this.bJk.getPaddingBottom() + localFlexItem.xH() + localFlexItem.getMarginBottom() + j, localFlexItem.getHeight()));
              H(localView, m);
            }
            paramList = new b();
            paramList.auc = 1;
            paramList.bJa = (i5 + i6);
            paramList.bJj = m;
            i = 0;
            k = -2147483648;
            label738:
            if (this.bJm != null) {
              this.bJm[m] = ((List)localObject).size();
            }
            paramList.bJa += j(localView, bool) + c(localFlexItem, bool) + d(localFlexItem, bool);
            paramList.bJe += localFlexItem.getFlexGrow();
            paramList.bJf += localFlexItem.getFlexShrink();
            this.bJk.a(localView, m, i, paramList);
            i2 = Math.max(k, k(localView, bool) + e(localFlexItem, bool) + f(localFlexItem, bool) + this.bJk.bV(localView));
            paramList.bJc = Math.max(paramList.bJc, i2);
            if (bool)
            {
              if (this.bJk.getFlexWrap() == 2) {
                break label1288;
              }
              paramList.bJg = Math.max(paramList.bJg, localView.getBaseline() + localFlexItem.xH());
            }
            if (!a(m, i9, paramList)) {
              break label1343;
            }
            a((List)localObject, paramList, m, j);
            j += paramList.bJc;
          }
          for (;;)
          {
            if ((paramInt5 != -1) && (((List)localObject).size() > 0) && (((b)((List)localObject).get(((List)localObject).size() - 1)).acn >= paramInt5) && (m >= paramInt5) && (paramInt4 == 0))
            {
              j = -paramList.bJc;
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
                i10 = this.bJk.t(paramInt2, i7 + i8 + e(localFlexItem, false) + f(localFlexItem, false) + j, b(localFlexItem, false));
                i2 = this.bJk.u(paramInt1, i5 + i6 + c(localFlexItem, false) + d(localFlexItem, false), n);
                localView.measure(i10, i2);
                a(m, i10, i2, localView);
                break label471;
                i = 0;
                break label589;
                if (localFlexItem.getWidth() != -1) {
                  break label699;
                }
                paramList = this.bJk;
                localView.measure(paramList.t(paramInt2, paramList.getPaddingLeft() + this.bJk.getPaddingRight() + localFlexItem.xG() + localFlexItem.xI() + j, localFlexItem.getWidth()), i2);
                H(localView, m);
                break label699;
                label1267:
                paramList.auc += 1;
                i = i1 + 1;
                break label738;
                paramList.bJg = Math.max(paramList.bJg, localView.getMeasuredHeight() - localView.getBaseline() + localFlexItem.getMarginBottom());
                break label947;
                k = i;
              }
              parama.bJq = k;
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
    int i = this.bJk.getFlexItemCount();
    paramSparseIntArray = a(i, fl(i), paramSparseIntArray);
    AppMethodBeat.o(62218);
    return paramSparseIntArray;
  }
  
  final int[] a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(62217);
    int i = this.bJk.getFlexItemCount();
    List localList = fl(i);
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
      if (paramInt < this.bJk.getFlexItemCount())
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
    int j = this.bJk.getFlexItemCount();
    if (paramSparseIntArray.size() != j)
    {
      AppMethodBeat.o(62220);
      return true;
    }
    int i = 0;
    while (i < j)
    {
      View localView = this.bJk.fj(i);
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
  
  final void bk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62244);
    v(paramInt1, paramInt2, 0);
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
    if ((!$assertionsDisabled) && (this.bJm == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(62263);
      throw paramList;
    }
    if ((!$assertionsDisabled) && (this.bJn == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(62263);
      throw paramList;
    }
    int j = this.bJm[paramInt];
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
    i = this.bJm.length - 1;
    if (paramInt > i) {
      Arrays.fill(this.bJm, -1);
    }
    for (;;)
    {
      i = this.bJn.length - 1;
      if (paramInt <= i) {
        break;
      }
      Arrays.fill(this.bJn, 0L);
      AppMethodBeat.o(62263);
      return;
      Arrays.fill(this.bJm, paramInt, i, -1);
    }
    Arrays.fill(this.bJn, paramInt, i, 0L);
    AppMethodBeat.o(62263);
  }
  
  final void d(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(62226);
    a(parama, paramInt2, paramInt1, paramInt3, 0, paramInt4, paramList);
    AppMethodBeat.o(62226);
  }
  
  final void fn(int paramInt)
  {
    AppMethodBeat.i(62254);
    if (paramInt >= this.bJk.getFlexItemCount())
    {
      AppMethodBeat.o(62254);
      return;
    }
    int j = this.bJk.getFlexDirection();
    b localb;
    Object localObject2;
    Object localObject3;
    if (this.bJk.getAlignItems() == 4)
    {
      int i = 0;
      if (this.bJm != null) {
        i = this.bJm[paramInt];
      }
      localObject1 = this.bJk.getFlexLinesInternal();
      int k = ((List)localObject1).size();
      paramInt = i;
      while (paramInt < k)
      {
        localb = (b)((List)localObject1).get(paramInt);
        int m = localb.auc;
        i = 0;
        if (i < m)
        {
          int n = localb.bJj + i;
          if (i < this.bJk.getFlexItemCount())
          {
            localObject2 = this.bJk.fk(n);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8))
            {
              localObject3 = (FlexItem)((View)localObject2).getLayoutParams();
              if ((((FlexItem)localObject3).xD() == -1) || (((FlexItem)localObject3).xD() == 4)) {
                switch (j)
                {
                default: 
                  localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
                  AppMethodBeat.o(62254);
                  throw ((Throwable)localObject1);
                case 0: 
                case 1: 
                  n((View)localObject2, localb.bJc, n);
                }
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            o((View)localObject2, localb.bJc, n);
          }
        }
        paramInt += 1;
      }
      AppMethodBeat.o(62254);
      return;
    }
    Object localObject1 = this.bJk.getFlexLinesInternal().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localb = (b)((Iterator)localObject1).next();
      localObject2 = localb.bJi.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        View localView = this.bJk.fk(((Integer)localObject3).intValue());
        switch (j)
        {
        default: 
          localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
          AppMethodBeat.o(62254);
          throw ((Throwable)localObject1);
        case 0: 
        case 1: 
          n(localView, localb.bJc, ((Integer)localObject3).intValue());
          break;
        case 2: 
        case 3: 
          o(localView, localb.bJc, ((Integer)localObject3).intValue());
        }
      }
    }
    AppMethodBeat.o(62254);
  }
  
  final void fo(int paramInt)
  {
    AppMethodBeat.i(62259);
    int i;
    if (this.bJo == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bJo = new long[i];
      AppMethodBeat.o(62259);
      return;
    }
    if (this.bJo.length < paramInt)
    {
      int j = this.bJo.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bJo = Arrays.copyOf(this.bJo, i);
    }
    AppMethodBeat.o(62259);
  }
  
  final void fp(int paramInt)
  {
    AppMethodBeat.i(62260);
    int i;
    if (this.bJn == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bJn = new long[i];
      AppMethodBeat.o(62260);
      return;
    }
    if (this.bJn.length < paramInt)
    {
      int j = this.bJn.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bJn = Arrays.copyOf(this.bJn, i);
    }
    AppMethodBeat.o(62260);
  }
  
  final void fq(int paramInt)
  {
    AppMethodBeat.i(62262);
    int i;
    if (this.bJm == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bJm = new int[i];
      AppMethodBeat.o(62262);
      return;
    }
    if (this.bJm.length < paramInt)
    {
      int j = this.bJm.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bJm = Arrays.copyOf(this.bJm, i);
    }
    AppMethodBeat.o(62262);
  }
  
  final void v(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62245);
    fm(this.bJk.getFlexItemCount());
    if (paramInt3 >= this.bJk.getFlexItemCount())
    {
      AppMethodBeat.o(62245);
      return;
    }
    int i = this.bJk.getFlexDirection();
    Object localObject;
    int j;
    switch (this.bJk.getFlexDirection())
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
        j = this.bJk.getPaddingLeft() + this.bJk.getPaddingRight();
        if (this.bJm == null) {
          break label334;
        }
      }
      break;
    }
    label191:
    label334:
    for (paramInt3 = this.bJm[paramInt3];; paramInt3 = 0)
    {
      localObject = this.bJk.getFlexLinesInternal();
      int k = ((List)localObject).size();
      if (paramInt3 < k)
      {
        b localb = (b)((List)localObject).get(paramInt3);
        if (localb.bJa < i) {
          a(paramInt1, paramInt2, localb, i, j, false);
        }
        for (;;)
        {
          paramInt3 += 1;
          break label191;
          i = this.bJk.getLargestMainSize();
          break;
          j = View.MeasureSpec.getMode(paramInt2);
          i = View.MeasureSpec.getSize(paramInt2);
          if (j == 1073741824) {}
          for (;;)
          {
            j = this.bJk.getPaddingTop() + this.bJk.getPaddingBottom();
            break;
            i = this.bJk.getLargestMainSize();
          }
          b(paramInt1, paramInt2, localb, i, j, false);
        }
      }
      AppMethodBeat.o(62245);
      return;
    }
  }
  
  final void w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62251);
    int i = this.bJk.getFlexDirection();
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
      localObject1 = this.bJk.getFlexLinesInternal();
      if (paramInt2 != 1073741824) {
        break label224;
      }
      paramInt2 = this.bJk.getSumOfCrossSize() + paramInt3;
      if (((List)localObject1).size() != 1) {
        break;
      }
      ((b)((List)localObject1).get(0)).bJc = (paramInt1 - paramInt3);
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
    switch (this.bJk.getAlignContent())
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
        float f4 = ((b)localObject2).bJc + f5;
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
      ((b)localObject2).bJc = paramInt1;
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
          this.bJk.setFlexLines(a((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(62251);
          return;
        }
        paramInt1 = (paramInt1 - paramInt2) / (((List)localObject1).size() * 2);
        localObject2 = new ArrayList();
        b localb1 = new b();
        localb1.bJc = paramInt1;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          b localb2 = (b)((Iterator)localObject1).next();
          ((List)localObject2).add(localb1);
          ((List)localObject2).add(localb2);
          ((List)localObject2).add(localb1);
        }
        this.bJk.setFlexLines((List)localObject2);
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
            localb1.bJc = Math.round(f3 + f1);
            f1 = 0.0F;
            f2 = f1 + (f3 - localb1.bJc);
            if (f2 <= 1.0F) {
              break label735;
            }
            localb1.bJc += 1;
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
          localb1.bJc = Math.round(f3);
          break label666;
          label735:
          f1 = f2;
          if (f2 >= -1.0F) {
            break label705;
          }
          localb1.bJc -= 1;
          f1 = f2 + 1.0F;
          break label705;
          this.bJk.setFlexLines((List)localObject2);
          AppMethodBeat.o(62251);
          return;
          this.bJk.setFlexLines(a((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(62251);
          return;
          localObject2 = new b();
          ((b)localObject2).bJc = (paramInt1 - paramInt2);
          ((List)localObject1).add(0, localObject2);
          break;
        }
      }
    }
  }
  
  final void xK()
  {
    AppMethodBeat.i(62253);
    fn(0);
    AppMethodBeat.o(62253);
  }
  
  static final class a
  {
    List<b> bJp;
    int bJq;
    
    final void reset()
    {
      this.bJp = null;
      this.bJq = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.flexbox.c
 * JD-Core Version:    0.7.0.1
 */