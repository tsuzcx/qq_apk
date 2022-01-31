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
  private final a bcY;
  private boolean[] bcZ;
  int[] bda;
  long[] bdb;
  private long[] bdc;
  
  static
  {
    AppMethodBeat.i(54727);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(54727);
      return;
    }
  }
  
  c(a parama)
  {
    this.bcY = parama;
  }
  
  private void F(View paramView, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(54706);
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
        this.bcY.a(paramInt, paramView);
      }
      AppMethodBeat.o(54706);
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
    AppMethodBeat.i(54712);
    a locala = this.bcY;
    paramInt2 = locala.u(paramInt1, locala.getPaddingLeft() + this.bcY.getPaddingRight() + paramFlexItem.rp() + paramFlexItem.rr() + paramInt2, paramFlexItem.getWidth());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.getMaxWidth()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMaxWidth(), View.MeasureSpec.getMode(paramInt2));
    }
    for (;;)
    {
      AppMethodBeat.o(54712);
      return paramInt1;
      paramInt1 = paramInt2;
      if (i < paramFlexItem.getMinWidth()) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMinWidth(), View.MeasureSpec.getMode(paramInt2));
      }
    }
  }
  
  private static int a(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(54697);
    if (paramBoolean)
    {
      i = paramFlexItem.getWidth();
      AppMethodBeat.o(54697);
      return i;
    }
    int i = paramFlexItem.getHeight();
    AppMethodBeat.o(54697);
    return i;
  }
  
  private static List<b> a(List<b> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54715);
    paramInt1 = (paramInt1 - paramInt2) / 2;
    ArrayList localArrayList = new ArrayList();
    b localb = new b();
    localb.bcQ = paramInt1;
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
    AppMethodBeat.o(54715);
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    AppMethodBeat.i(54724);
    if (this.bdb != null) {
      this.bdb[paramInt1] = be(paramInt2, paramInt3);
    }
    if (this.bdc != null) {
      this.bdc[paramInt1] = be(paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    }
    AppMethodBeat.o(54724);
  }
  
  private void a(int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(54710);
    if ((paramb.bcS <= 0.0F) || (paramInt3 < paramb.bcO))
    {
      AppMethodBeat.o(54710);
      return;
    }
    int i1 = paramb.bcO;
    int i = 0;
    float f4 = (paramInt3 - paramb.bcO) / paramb.bcS;
    paramb.bcO = (paramb.bcP + paramInt4);
    int n = 0;
    if (!paramBoolean) {
      paramb.bcQ = -2147483648;
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
    if (m < paramb.ake)
    {
      i2 = paramb.bcX + m;
      localView = this.bcY.ew(i2);
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
          j = this.bcY.getFlexDirection();
          if ((j != 0) && (j != 1)) {
            break label610;
          }
          j = localView.getMeasuredWidth();
          if (this.bdc != null) {
            j = (int)this.bdc[i2];
          }
          k = localView.getMeasuredHeight();
          if (this.bdc != null) {
            k = (int)(this.bdc[i2] >> 32);
          }
          if ((this.bcZ[i2] != 0) || (localFlexItem.getFlexGrow() <= 0.0F)) {
            break label1032;
          }
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m != paramb.ake - 1) {
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
          this.bcZ[i2] = true;
          paramb.bcS -= localFlexItem.getFlexGrow();
          i3 = b(paramInt2, localFlexItem, paramb.bcV);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i3);
          j = localView.getMeasuredWidth();
          k = localView.getMeasuredHeight();
          a(i2, i4, i3, localView);
          this.bcY.a(i2, localView);
        }
      }
    }
    label1029:
    label1032:
    for (;;)
    {
      k = Math.max(n, localFlexItem.rq() + k + localFlexItem.getMarginBottom() + this.bcY.cc(localView));
      n = paramb.bcO;
      i2 = localFlexItem.rp();
      paramb.bcO = (localFlexItem.rr() + (i2 + j) + n);
      j = k;
      label501:
      paramb.bcQ = Math.max(paramb.bcQ, j);
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
        if (this.bdc != null) {
          j = (int)(this.bdc[i2] >> 32);
        }
        k = localView.getMeasuredWidth();
        if (this.bdc != null) {
          k = (int)this.bdc[i2];
        }
        if ((this.bcZ[i2] == 0) && (localFlexItem.getFlexGrow() > 0.0F))
        {
          f2 = j + localFlexItem.getFlexGrow() * f4;
          if (m == paramb.ake - 1)
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
              this.bcZ[i2] = true;
              paramb.bcS -= localFlexItem.getFlexGrow();
              label779:
              i3 = a(paramInt1, localFlexItem, paramb.bcV);
              i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
              localView.measure(i3, i4);
              k = localView.getMeasuredWidth();
              j = localView.getMeasuredHeight();
              a(i2, i3, i4, localView);
              this.bcY.a(i2, localView);
            }
          }
        }
        for (;;)
        {
          k = Math.max(n, localFlexItem.rp() + k + localFlexItem.rr() + this.bcY.cc(localView));
          n = paramb.bcO;
          i2 = localFlexItem.rq();
          paramb.bcO = (localFlexItem.getMarginBottom() + (i2 + j) + n);
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
            if ((i != 0) && (i1 != paramb.bcO))
            {
              paramBoolean = true;
              break;
            }
            AppMethodBeat.o(54710);
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
    AppMethodBeat.i(54705);
    paramb.bcV = paramInt2;
    this.bcY.a(paramb);
    paramb.Sm = paramInt1;
    paramList.add(paramb);
    AppMethodBeat.o(54705);
  }
  
  private static boolean a(int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(54704);
    if ((paramInt1 == paramInt2 - 1) && (paramb.rs() != 0))
    {
      AppMethodBeat.o(54704);
      return true;
    }
    AppMethodBeat.o(54704);
    return false;
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, FlexItem paramFlexItem, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(54703);
    if (this.bcY.getFlexWrap() == 0)
    {
      AppMethodBeat.o(54703);
      return false;
    }
    if (paramFlexItem.rn())
    {
      AppMethodBeat.o(54703);
      return true;
    }
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(54703);
      return false;
    }
    paramInt1 = this.bcY.getMaxLine();
    if ((paramInt1 != -1) && (paramInt1 <= paramInt7 + 1))
    {
      AppMethodBeat.o(54703);
      return false;
    }
    paramInt5 = this.bcY.n(paramView, paramInt5, paramInt6);
    paramInt1 = paramInt4;
    if (paramInt5 > 0) {
      paramInt1 = paramInt4 + paramInt5;
    }
    if (paramInt2 < paramInt3 + paramInt1)
    {
      AppMethodBeat.o(54703);
      return true;
    }
    AppMethodBeat.o(54703);
    return false;
  }
  
  private static int[] a(int paramInt, List<c.b> paramList, SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(54684);
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
    AppMethodBeat.o(54684);
    return arrayOfInt;
  }
  
  private int aN(boolean paramBoolean)
  {
    AppMethodBeat.i(54691);
    if (paramBoolean)
    {
      i = this.bcY.getPaddingStart();
      AppMethodBeat.o(54691);
      return i;
    }
    int i = this.bcY.getPaddingTop();
    AppMethodBeat.o(54691);
    return i;
  }
  
  private int aO(boolean paramBoolean)
  {
    AppMethodBeat.i(54692);
    if (paramBoolean)
    {
      i = this.bcY.getPaddingEnd();
      AppMethodBeat.o(54692);
      return i;
    }
    int i = this.bcY.getPaddingBottom();
    AppMethodBeat.o(54692);
    return i;
  }
  
  private int aP(boolean paramBoolean)
  {
    AppMethodBeat.i(54693);
    if (paramBoolean)
    {
      i = this.bcY.getPaddingTop();
      AppMethodBeat.o(54693);
      return i;
    }
    int i = this.bcY.getPaddingStart();
    AppMethodBeat.o(54693);
    return i;
  }
  
  private int aQ(boolean paramBoolean)
  {
    AppMethodBeat.i(54694);
    if (paramBoolean)
    {
      i = this.bcY.getPaddingBottom();
      AppMethodBeat.o(54694);
      return i;
    }
    int i = this.bcY.getPaddingEnd();
    AppMethodBeat.o(54694);
    return i;
  }
  
  static int am(long paramLong)
  {
    return (int)paramLong;
  }
  
  static int an(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private int b(int paramInt1, FlexItem paramFlexItem, int paramInt2)
  {
    AppMethodBeat.i(54713);
    a locala = this.bcY;
    paramInt2 = locala.v(paramInt1, locala.getPaddingTop() + this.bcY.getPaddingBottom() + paramFlexItem.rq() + paramFlexItem.getMarginBottom() + paramInt2, paramFlexItem.getHeight());
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i > paramFlexItem.getMaxHeight()) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMaxHeight(), View.MeasureSpec.getMode(paramInt2));
    }
    for (;;)
    {
      AppMethodBeat.o(54713);
      return paramInt1;
      paramInt1 = paramInt2;
      if (i < paramFlexItem.getMinHeight()) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramFlexItem.getMinHeight(), View.MeasureSpec.getMode(paramInt2));
      }
    }
  }
  
  private static int b(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(54698);
    if (paramBoolean)
    {
      i = paramFlexItem.getHeight();
      AppMethodBeat.o(54698);
      return i;
    }
    int i = paramFlexItem.getWidth();
    AppMethodBeat.o(54698);
    return i;
  }
  
  private void b(int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(54711);
    int i2 = paramb.bcO;
    if ((paramb.bcT <= 0.0F) || (paramInt3 > paramb.bcO))
    {
      AppMethodBeat.o(54711);
      return;
    }
    int i = 0;
    float f4 = (paramb.bcO - paramInt3) / paramb.bcT;
    float f1 = 0.0F;
    paramb.bcO = (paramb.bcP + paramInt4);
    if (!paramBoolean) {
      paramb.bcQ = -2147483648;
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
    if (n < paramb.ake)
    {
      i3 = paramb.bcX + n;
      localView = this.bcY.ew(i3);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label1036;
      }
      localFlexItem = (FlexItem)localView.getLayoutParams();
      j = this.bcY.getFlexDirection();
      if ((j == 0) || (j == 1))
      {
        j = localView.getMeasuredWidth();
        if (this.bdc != null) {
          j = (int)this.bdc[i3];
        }
        m = localView.getMeasuredHeight();
        if (this.bdc != null) {
          m = (int)(this.bdc[i3] >> 32);
        }
        if ((this.bcZ[i3] != 0) || (localFlexItem.getFlexShrink() <= 0.0F)) {
          break label1029;
        }
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n != paramb.ake - 1) {
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
          this.bcZ[i3] = true;
          paramb.bcT -= localFlexItem.getFlexShrink();
          i = b(paramInt2, localFlexItem, paramb.bcV);
          i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
          localView.measure(i4, i);
          j = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          a(i3, i4, i, localView);
          this.bcY.a(i3, localView);
          i = m;
          label407:
          k = Math.max(k, localFlexItem.rq() + i1 + localFlexItem.getMarginBottom() + this.bcY.cc(localView));
          m = paramb.bcO;
          i1 = localFlexItem.rp();
          paramb.bcO = (localFlexItem.rr() + (j + i1) + m);
          j = k;
          label483:
          paramb.bcQ = Math.max(paramb.bcQ, j);
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
      if (this.bdc != null) {
        j = (int)(this.bdc[i3] >> 32);
      }
      m = localView.getMeasuredWidth();
      if (this.bdc != null) {
        m = (int)this.bdc[i3];
      }
      if ((this.bcZ[i3] == 0) && (localFlexItem.getFlexShrink() > 0.0F))
      {
        f2 = j - localFlexItem.getFlexShrink() * f4;
        if (n == paramb.ake - 1)
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
            this.bcZ[i3] = true;
            paramb.bcT -= localFlexItem.getFlexShrink();
            label757:
            i = a(paramInt1, localFlexItem, paramb.bcV);
            i4 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            localView.measure(i, i4);
            i1 = localView.getMeasuredWidth();
            j = localView.getMeasuredHeight();
            a(i3, i, i4, localView);
            this.bcY.a(i3, localView);
            i = m;
          }
        }
      }
      for (;;)
      {
        k = Math.max(k, localFlexItem.rp() + i1 + localFlexItem.rr() + this.bcY.cc(localView));
        m = paramb.bcO;
        i1 = localFlexItem.rq();
        paramb.bcO = (localFlexItem.getMarginBottom() + (j + i1) + m);
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
        if ((i != 0) && (i2 != paramb.bcO))
        {
          paramBoolean = true;
          break;
        }
        AppMethodBeat.o(54711);
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
  
  private static long be(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1 & 0xFFFFFFFF;
  }
  
  private static int c(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(54699);
    if (paramBoolean)
    {
      i = paramFlexItem.rp();
      AppMethodBeat.o(54699);
      return i;
    }
    int i = paramFlexItem.rq();
    AppMethodBeat.o(54699);
    return i;
  }
  
  private static int d(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(54700);
    if (paramBoolean)
    {
      i = paramFlexItem.rr();
      AppMethodBeat.o(54700);
      return i;
    }
    int i = paramFlexItem.getMarginBottom();
    AppMethodBeat.o(54700);
    return i;
  }
  
  private static int e(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(54701);
    if (paramBoolean)
    {
      i = paramFlexItem.rq();
      AppMethodBeat.o(54701);
      return i;
    }
    int i = paramFlexItem.rp();
    AppMethodBeat.o(54701);
    return i;
  }
  
  private List<c.b> ex(int paramInt)
  {
    AppMethodBeat.i(54682);
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      FlexItem localFlexItem = (FlexItem)this.bcY.ev(i).getLayoutParams();
      c.b localb = new c.b((byte)0);
      localb.order = localFlexItem.getOrder();
      localb.index = i;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(54682);
    return localArrayList;
  }
  
  private void ey(int paramInt)
  {
    AppMethodBeat.i(54709);
    int i;
    if (this.bcZ == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bcZ = new boolean[i];
      AppMethodBeat.o(54709);
      return;
    }
    if (this.bcZ.length < paramInt)
    {
      int j = this.bcZ.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bcZ = new boolean[i];
      AppMethodBeat.o(54709);
      return;
    }
    Arrays.fill(this.bcZ, false);
    AppMethodBeat.o(54709);
  }
  
  private static int f(FlexItem paramFlexItem, boolean paramBoolean)
  {
    AppMethodBeat.i(54702);
    if (paramBoolean)
    {
      i = paramFlexItem.getMarginBottom();
      AppMethodBeat.o(54702);
      return i;
    }
    int i = paramFlexItem.rr();
    AppMethodBeat.o(54702);
    return i;
  }
  
  private static int j(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(54695);
    if (paramBoolean)
    {
      i = paramView.getMeasuredWidth();
      AppMethodBeat.o(54695);
      return i;
    }
    int i = paramView.getMeasuredHeight();
    AppMethodBeat.o(54695);
    return i;
  }
  
  private static int k(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(54696);
    if (paramBoolean)
    {
      i = paramView.getMeasuredHeight();
      AppMethodBeat.o(54696);
      return i;
    }
    int i = paramView.getMeasuredWidth();
    AppMethodBeat.o(54696);
    return i;
  }
  
  private void o(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54718);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - localFlexItem.rq() - localFlexItem.getMarginBottom() - this.bcY.cc(paramView), localFlexItem.getMinHeight()), localFlexItem.getMaxHeight());
    if (this.bdc != null) {}
    for (paramInt1 = (int)this.bdc[paramInt2];; paramInt1 = paramView.getMeasuredWidth())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(paramInt1, i);
      a(paramInt2, paramInt1, i, paramView);
      this.bcY.a(paramInt2, paramView);
      AppMethodBeat.o(54718);
      return;
    }
  }
  
  private void p(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54719);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = Math.min(Math.max(paramInt1 - localFlexItem.rp() - localFlexItem.rr() - this.bcY.cc(paramView), localFlexItem.getMinWidth()), localFlexItem.getMaxWidth());
    if (this.bdc != null) {}
    for (paramInt1 = (int)(this.bdc[paramInt2] >> 32);; paramInt1 = paramView.getMeasuredHeight())
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      paramView.measure(i, paramInt1);
      a(paramInt2, i, paramInt1, paramView);
      this.bcY.a(paramInt2, paramView);
      AppMethodBeat.o(54719);
      return;
    }
  }
  
  final void a(View paramView, b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54720);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.bcY.getAlignItems();
    if (localFlexItem.rm() != -1) {
      i = localFlexItem.rm();
    }
    int j = paramb.bcQ;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(54720);
      return;
      if (this.bcY.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, localFlexItem.rq() + paramInt2, paramInt3, localFlexItem.rq() + paramInt4);
        AppMethodBeat.o(54720);
        return;
      }
      paramView.layout(paramInt1, paramInt2 - localFlexItem.getMarginBottom(), paramInt3, paramInt4 - localFlexItem.getMarginBottom());
      AppMethodBeat.o(54720);
      return;
      if (this.bcY.getFlexWrap() != 2)
      {
        i = Math.max(paramb.bcU - paramView.getBaseline(), localFlexItem.rq());
        paramView.layout(paramInt1, paramInt2 + i, paramInt3, i + paramInt4);
        AppMethodBeat.o(54720);
        return;
      }
      i = Math.max(paramb.bcU - paramView.getMeasuredHeight() + paramView.getBaseline(), localFlexItem.getMarginBottom());
      paramView.layout(paramInt1, paramInt2 - i, paramInt3, paramInt4 - i);
      AppMethodBeat.o(54720);
      return;
      if (this.bcY.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, paramInt2 + j - paramView.getMeasuredHeight() - localFlexItem.getMarginBottom(), paramInt3, j + paramInt2 - localFlexItem.getMarginBottom());
        AppMethodBeat.o(54720);
        return;
      }
      i = paramView.getMeasuredHeight();
      int k = localFlexItem.rq();
      int m = paramView.getMeasuredHeight();
      paramView.layout(paramInt1, paramInt2 - j + i + k, paramInt3, localFlexItem.rq() + (paramInt4 - j + m));
      AppMethodBeat.o(54720);
      return;
      paramInt4 = (j - paramView.getMeasuredHeight() + localFlexItem.rq() - localFlexItem.getMarginBottom()) / 2;
      if (this.bcY.getFlexWrap() != 2)
      {
        paramView.layout(paramInt1, paramInt2 + paramInt4, paramInt3, paramInt4 + paramInt2 + paramView.getMeasuredHeight());
        AppMethodBeat.o(54720);
        return;
      }
      paramView.layout(paramInt1, paramInt2 - paramInt4, paramInt3, paramInt2 - paramInt4 + paramView.getMeasuredHeight());
    }
  }
  
  final void a(View paramView, b paramb, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54721);
    FlexItem localFlexItem = (FlexItem)paramView.getLayoutParams();
    int i = this.bcY.getAlignItems();
    if (localFlexItem.rm() != -1) {
      i = localFlexItem.rm();
    }
    int j = paramb.bcQ;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(54721);
      return;
      if (!paramBoolean)
      {
        paramView.layout(localFlexItem.rp() + paramInt1, paramInt2, localFlexItem.rp() + paramInt3, paramInt4);
        AppMethodBeat.o(54721);
        return;
      }
      paramView.layout(paramInt1 - localFlexItem.rr(), paramInt2, paramInt3 - localFlexItem.rr(), paramInt4);
      AppMethodBeat.o(54721);
      return;
      if (!paramBoolean)
      {
        paramView.layout(paramInt1 + j - paramView.getMeasuredWidth() - localFlexItem.rr(), paramInt2, j + paramInt3 - paramView.getMeasuredWidth() - localFlexItem.rr(), paramInt4);
        AppMethodBeat.o(54721);
        return;
      }
      i = paramView.getMeasuredWidth();
      int k = localFlexItem.rp();
      int m = paramView.getMeasuredWidth();
      paramView.layout(paramInt1 - j + i + k, paramInt2, localFlexItem.rp() + (paramInt3 - j + m), paramInt4);
      AppMethodBeat.o(54721);
      return;
      paramb = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      i = (j - paramView.getMeasuredWidth() + g.a(paramb) - g.b(paramb)) / 2;
      if (!paramBoolean)
      {
        paramView.layout(paramInt1 + i, paramInt2, i + paramInt3, paramInt4);
        AppMethodBeat.o(54721);
        return;
      }
      paramView.layout(paramInt1 - i, paramInt2, paramInt3 - i, paramInt4);
    }
  }
  
  final void a(c.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54687);
    a(parama, paramInt2, paramInt1, 2147483647, 0, -1, null);
    AppMethodBeat.o(54687);
  }
  
  final void a(c.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<b> paramList)
  {
    AppMethodBeat.i(54690);
    boolean bool = this.bcY.rl();
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int n = 0;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    parama.bdd = ((List)localObject);
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
      i5 = aN(bool);
      i6 = aO(bool);
      i7 = aP(bool);
      i8 = aQ(bool);
      k = -2147483648;
      j = 0;
      i1 = 0;
      paramList = new b();
      paramList.bcX = paramInt4;
      paramList.bcO = (i5 + i6);
      i9 = this.bcY.getFlexItemCount();
      m = paramInt4;
      paramInt4 = i;
      i = n;
      if (m >= i9) {
        break label1323;
      }
      localView = this.bcY.ew(m);
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
        paramList.bcR += 1;
        paramList.ake += 1;
        if (a(m, i9, paramList)) {
          a((List)localObject, paramList, m, j);
        }
      }
      else
      {
        FlexItem localFlexItem = (FlexItem)localView.getLayoutParams();
        if (localFlexItem.rm() == 4) {
          paramList.bcW.add(Integer.valueOf(m));
        }
        int i2 = a(localFlexItem, bool);
        n = i2;
        if (localFlexItem.ro() != -1.0F)
        {
          n = i2;
          if (i3 == 1073741824) {
            n = Math.round(i4 * localFlexItem.ro());
          }
        }
        int i10;
        if (bool)
        {
          i2 = this.bcY.u(paramInt1, i5 + i6 + c(localFlexItem, true) + d(localFlexItem, true), n);
          n = this.bcY.v(paramInt2, i7 + i8 + e(localFlexItem, true) + f(localFlexItem, true) + j, b(localFlexItem, true));
          localView.measure(i2, n);
          a(m, i2, n, localView);
          this.bcY.a(m, localView);
          F(localView, m);
          n = View.combineMeasuredStates(i, localView.getMeasuredState());
          i = paramList.bcO;
          i10 = j(localView, bool);
          int i11 = c(localFlexItem, bool);
          if (!a(localView, i3, i4, i, d(localFlexItem, bool) + (i10 + i11), localFlexItem, m, i1, ((List)localObject).size())) {
            break label1267;
          }
          if (paramList.rs() <= 0) {
            break label1346;
          }
          if (m <= 0) {
            break label1175;
          }
          i = m - 1;
          a((List)localObject, paramList, i, j);
          j += paramList.bcQ;
        }
        for (;;)
        {
          if (bool)
          {
            if (localFlexItem.getHeight() == -1)
            {
              paramList = this.bcY;
              localView.measure(i2, paramList.v(paramInt2, paramList.getPaddingTop() + this.bcY.getPaddingBottom() + localFlexItem.rq() + localFlexItem.getMarginBottom() + j, localFlexItem.getHeight()));
              F(localView, m);
            }
            paramList = new b();
            paramList.ake = 1;
            paramList.bcO = (i5 + i6);
            paramList.bcX = m;
            i = 0;
            k = -2147483648;
            label738:
            if (this.bda != null) {
              this.bda[m] = ((List)localObject).size();
            }
            paramList.bcO += j(localView, bool) + c(localFlexItem, bool) + d(localFlexItem, bool);
            paramList.bcS += localFlexItem.getFlexGrow();
            paramList.bcT += localFlexItem.getFlexShrink();
            this.bcY.a(localView, m, i, paramList);
            i2 = Math.max(k, k(localView, bool) + e(localFlexItem, bool) + f(localFlexItem, bool) + this.bcY.cc(localView));
            paramList.bcQ = Math.max(paramList.bcQ, i2);
            if (bool)
            {
              if (this.bcY.getFlexWrap() == 2) {
                break label1288;
              }
              paramList.bcU = Math.max(paramList.bcU, localView.getBaseline() + localFlexItem.rq());
            }
            if (!a(m, i9, paramList)) {
              break label1343;
            }
            a((List)localObject, paramList, m, j);
            j += paramList.bcQ;
          }
          for (;;)
          {
            if ((paramInt5 != -1) && (((List)localObject).size() > 0) && (((b)((List)localObject).get(((List)localObject).size() - 1)).Sm >= paramInt5) && (m >= paramInt5) && (paramInt4 == 0))
            {
              j = -paramList.bcQ;
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
                i10 = this.bcY.u(paramInt2, i7 + i8 + e(localFlexItem, false) + f(localFlexItem, false) + j, b(localFlexItem, false));
                i2 = this.bcY.v(paramInt1, i5 + i6 + c(localFlexItem, false) + d(localFlexItem, false), n);
                localView.measure(i10, i2);
                a(m, i10, i2, localView);
                break label471;
                i = 0;
                break label589;
                if (localFlexItem.getWidth() != -1) {
                  break label699;
                }
                paramList = this.bcY;
                localView.measure(paramList.u(paramInt2, paramList.getPaddingLeft() + this.bcY.getPaddingRight() + localFlexItem.rp() + localFlexItem.rr() + j, localFlexItem.getWidth()), i2);
                F(localView, m);
                break label699;
                label1267:
                paramList.ake += 1;
                i = i1 + 1;
                break label738;
                paramList.bcU = Math.max(paramList.bcU, localView.getMeasuredHeight() - localView.getBaseline() + localFlexItem.getMarginBottom());
                break label947;
                k = i;
              }
              parama.bde = k;
              AppMethodBeat.o(54690);
              return;
            }
          }
        }
      }
    }
  }
  
  final void a(c.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(54685);
    a(parama, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList);
    AppMethodBeat.o(54685);
  }
  
  final int[] a(SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(54681);
    int i = this.bcY.getFlexItemCount();
    paramSparseIntArray = a(i, ex(i), paramSparseIntArray);
    AppMethodBeat.o(54681);
    return paramSparseIntArray;
  }
  
  final int[] a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(54680);
    int i = this.bcY.getFlexItemCount();
    List localList = ex(i);
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
      AppMethodBeat.o(54680);
      return paramView;
      localb.order = 1;
      break;
      label117:
      if (paramInt < this.bcY.getFlexItemCount())
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
  
  final void b(c.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(54686);
    a(parama, paramInt1, paramInt2, paramInt3, 0, paramInt4, paramList);
    AppMethodBeat.o(54686);
  }
  
  final boolean b(SparseIntArray paramSparseIntArray)
  {
    AppMethodBeat.i(54683);
    int j = this.bcY.getFlexItemCount();
    if (paramSparseIntArray.size() != j)
    {
      AppMethodBeat.o(54683);
      return true;
    }
    int i = 0;
    while (i < j)
    {
      View localView = this.bcY.ev(i);
      if ((localView != null) && (((FlexItem)localView.getLayoutParams()).getOrder() != paramSparseIntArray.get(i)))
      {
        AppMethodBeat.o(54683);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(54683);
    return false;
  }
  
  final void bd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54707);
    w(paramInt1, paramInt2, 0);
    AppMethodBeat.o(54707);
  }
  
  final void c(c.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(54688);
    a(parama, paramInt2, paramInt1, paramInt3, paramInt4, -1, paramList);
    AppMethodBeat.o(54688);
  }
  
  final void d(c.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<b> paramList)
  {
    AppMethodBeat.i(54689);
    a(parama, paramInt2, paramInt1, paramInt3, 0, paramInt4, paramList);
    AppMethodBeat.o(54689);
  }
  
  final void d(List<b> paramList, int paramInt)
  {
    AppMethodBeat.i(54726);
    if ((!$assertionsDisabled) && (this.bda == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(54726);
      throw paramList;
    }
    if ((!$assertionsDisabled) && (this.bdb == null))
    {
      paramList = new AssertionError();
      AppMethodBeat.o(54726);
      throw paramList;
    }
    int j = this.bda[paramInt];
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
    i = this.bda.length - 1;
    if (paramInt > i) {
      Arrays.fill(this.bda, -1);
    }
    for (;;)
    {
      i = this.bdb.length - 1;
      if (paramInt <= i) {
        break;
      }
      Arrays.fill(this.bdb, 0L);
      AppMethodBeat.o(54726);
      return;
      Arrays.fill(this.bda, paramInt, i, -1);
    }
    Arrays.fill(this.bdb, paramInt, i, 0L);
    AppMethodBeat.o(54726);
  }
  
  final void eA(int paramInt)
  {
    AppMethodBeat.i(54722);
    int i;
    if (this.bdc == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bdc = new long[i];
      AppMethodBeat.o(54722);
      return;
    }
    if (this.bdc.length < paramInt)
    {
      int j = this.bdc.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bdc = Arrays.copyOf(this.bdc, i);
    }
    AppMethodBeat.o(54722);
  }
  
  final void eB(int paramInt)
  {
    AppMethodBeat.i(54723);
    int i;
    if (this.bdb == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bdb = new long[i];
      AppMethodBeat.o(54723);
      return;
    }
    if (this.bdb.length < paramInt)
    {
      int j = this.bdb.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bdb = Arrays.copyOf(this.bdb, i);
    }
    AppMethodBeat.o(54723);
  }
  
  final void eC(int paramInt)
  {
    AppMethodBeat.i(54725);
    int i;
    if (this.bda == null)
    {
      i = paramInt;
      if (paramInt < 10) {
        i = 10;
      }
      this.bda = new int[i];
      AppMethodBeat.o(54725);
      return;
    }
    if (this.bda.length < paramInt)
    {
      int j = this.bda.length * 2;
      i = paramInt;
      if (j >= paramInt) {
        i = j;
      }
      this.bda = Arrays.copyOf(this.bda, i);
    }
    AppMethodBeat.o(54725);
  }
  
  final void ez(int paramInt)
  {
    AppMethodBeat.i(54717);
    if (paramInt >= this.bcY.getFlexItemCount())
    {
      AppMethodBeat.o(54717);
      return;
    }
    int j = this.bcY.getFlexDirection();
    b localb;
    Object localObject2;
    Object localObject3;
    if (this.bcY.getAlignItems() == 4)
    {
      int i = 0;
      if (this.bda != null) {
        i = this.bda[paramInt];
      }
      localObject1 = this.bcY.getFlexLinesInternal();
      int k = ((List)localObject1).size();
      paramInt = i;
      while (paramInt < k)
      {
        localb = (b)((List)localObject1).get(paramInt);
        int m = localb.ake;
        i = 0;
        if (i < m)
        {
          int n = localb.bcX + i;
          if (i < this.bcY.getFlexItemCount())
          {
            localObject2 = this.bcY.ew(n);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8))
            {
              localObject3 = (FlexItem)((View)localObject2).getLayoutParams();
              if ((((FlexItem)localObject3).rm() == -1) || (((FlexItem)localObject3).rm() == 4)) {
                switch (j)
                {
                default: 
                  localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
                  AppMethodBeat.o(54717);
                  throw ((Throwable)localObject1);
                case 0: 
                case 1: 
                  o((View)localObject2, localb.bcQ, n);
                }
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            p((View)localObject2, localb.bcQ, n);
          }
        }
        paramInt += 1;
      }
      AppMethodBeat.o(54717);
      return;
    }
    Object localObject1 = this.bcY.getFlexLinesInternal().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localb = (b)((Iterator)localObject1).next();
      localObject2 = localb.bcW.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        View localView = this.bcY.ew(((Integer)localObject3).intValue());
        switch (j)
        {
        default: 
          localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(j)));
          AppMethodBeat.o(54717);
          throw ((Throwable)localObject1);
        case 0: 
        case 1: 
          o(localView, localb.bcQ, ((Integer)localObject3).intValue());
          break;
        case 2: 
        case 3: 
          p(localView, localb.bcQ, ((Integer)localObject3).intValue());
        }
      }
    }
    AppMethodBeat.o(54717);
  }
  
  final void rt()
  {
    AppMethodBeat.i(54716);
    ez(0);
    AppMethodBeat.o(54716);
  }
  
  final void w(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54708);
    ey(this.bcY.getFlexItemCount());
    if (paramInt3 >= this.bcY.getFlexItemCount())
    {
      AppMethodBeat.o(54708);
      return;
    }
    int i = this.bcY.getFlexDirection();
    Object localObject;
    int j;
    switch (this.bcY.getFlexDirection())
    {
    default: 
      localObject = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
      AppMethodBeat.o(54708);
      throw ((Throwable)localObject);
    case 0: 
    case 1: 
      j = View.MeasureSpec.getMode(paramInt1);
      i = View.MeasureSpec.getSize(paramInt1);
      if (j == 1073741824)
      {
        j = this.bcY.getPaddingLeft() + this.bcY.getPaddingRight();
        if (this.bda == null) {
          break label334;
        }
      }
      break;
    }
    label191:
    label334:
    for (paramInt3 = this.bda[paramInt3];; paramInt3 = 0)
    {
      localObject = this.bcY.getFlexLinesInternal();
      int k = ((List)localObject).size();
      if (paramInt3 < k)
      {
        b localb = (b)((List)localObject).get(paramInt3);
        if (localb.bcO < i) {
          a(paramInt1, paramInt2, localb, i, j, false);
        }
        for (;;)
        {
          paramInt3 += 1;
          break label191;
          i = this.bcY.getLargestMainSize();
          break;
          j = View.MeasureSpec.getMode(paramInt2);
          i = View.MeasureSpec.getSize(paramInt2);
          if (j == 1073741824) {}
          for (;;)
          {
            j = this.bcY.getPaddingTop() + this.bcY.getPaddingBottom();
            break;
            i = this.bcY.getLargestMainSize();
          }
          b(paramInt1, paramInt2, localb, i, j, false);
        }
      }
      AppMethodBeat.o(54708);
      return;
    }
  }
  
  final void x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(54714);
    int i = this.bcY.getFlexDirection();
    Object localObject1;
    switch (i)
    {
    default: 
      localObject1 = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
      AppMethodBeat.o(54714);
      throw ((Throwable)localObject1);
    case 0: 
    case 1: 
      i = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      paramInt2 = i;
    }
    for (;;)
    {
      localObject1 = this.bcY.getFlexLinesInternal();
      if (paramInt2 != 1073741824) {
        break label224;
      }
      paramInt2 = this.bcY.getSumOfCrossSize() + paramInt3;
      if (((List)localObject1).size() != 1) {
        break;
      }
      ((b)((List)localObject1).get(0)).bcQ = (paramInt1 - paramInt3);
      AppMethodBeat.o(54714);
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
    switch (this.bcY.getAlignContent())
    {
    default: 
    case 5: 
      do
      {
        AppMethodBeat.o(54714);
        return;
      } while (paramInt2 >= paramInt1);
      float f5 = (paramInt1 - paramInt2) / ((List)localObject1).size();
      f1 = 0.0F;
      paramInt3 = ((List)localObject1).size();
      paramInt2 = 0;
      if (paramInt2 < paramInt3)
      {
        localObject2 = (b)((List)localObject1).get(paramInt2);
        float f4 = ((b)localObject2).bcQ + f5;
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
      ((b)localObject2).bcQ = paramInt1;
      paramInt2 += 1;
      break label264;
      if (f1 < -1.0F)
      {
        paramInt1 -= 1;
        f1 += 1.0F;
        continue;
        AppMethodBeat.o(54714);
        return;
        if (paramInt2 >= paramInt1)
        {
          this.bcY.setFlexLines(a((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(54714);
          return;
        }
        paramInt1 = (paramInt1 - paramInt2) / (((List)localObject1).size() * 2);
        localObject2 = new ArrayList();
        b localb1 = new b();
        localb1.bcQ = paramInt1;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          b localb2 = (b)((Iterator)localObject1).next();
          ((List)localObject2).add(localb1);
          ((List)localObject2).add(localb2);
          ((List)localObject2).add(localb1);
        }
        this.bcY.setFlexLines((List)localObject2);
        AppMethodBeat.o(54714);
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
            localb1.bcQ = Math.round(f3 + f1);
            f1 = 0.0F;
            f2 = f1 + (f3 - localb1.bcQ);
            if (f2 <= 1.0F) {
              break label735;
            }
            localb1.bcQ += 1;
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
          localb1.bcQ = Math.round(f3);
          break label666;
          label735:
          f1 = f2;
          if (f2 >= -1.0F) {
            break label705;
          }
          localb1.bcQ -= 1;
          f1 = f2 + 1.0F;
          break label705;
          this.bcY.setFlexLines((List)localObject2);
          AppMethodBeat.o(54714);
          return;
          this.bcY.setFlexLines(a((List)localObject1, paramInt1, paramInt2));
          AppMethodBeat.o(54714);
          return;
          localObject2 = new b();
          ((b)localObject2).bcQ = (paramInt1 - paramInt2);
          ((List)localObject1).add(0, localObject2);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.flexbox.c
 * JD-Core Version:    0.7.0.1
 */