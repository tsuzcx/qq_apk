package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.g.a.d;
import androidx.core.g.a.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  boolean bWk;
  public int bWl;
  int[] bWm;
  View[] bWn;
  final SparseIntArray bWo;
  final SparseIntArray bWp;
  public b bWq;
  final Rect bWr;
  
  public GridLayoutManager(int paramInt)
  {
    AppMethodBeat.i(194918);
    this.bWk = false;
    this.bWl = -1;
    this.bWo = new SparseIntArray();
    this.bWp = new SparseIntArray();
    this.bWq = new GridLayoutManager.a();
    this.bWr = new Rect();
    fI(paramInt);
    AppMethodBeat.o(194918);
  }
  
  public GridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt2, false);
    AppMethodBeat.i(194926);
    this.bWk = false;
    this.bWl = -1;
    this.bWo = new SparseIntArray();
    this.bWp = new SparseIntArray();
    this.bWq = new GridLayoutManager.a();
    this.bWr = new Rect();
    fI(paramInt1);
    AppMethodBeat.o(194926);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(194909);
    this.bWk = false;
    this.bWl = -1;
    this.bWo = new SparseIntArray();
    this.bWp = new SparseIntArray();
    this.bWq = new GridLayoutManager.a();
    this.bWr = new Rect();
    fI(getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).spanCount);
    AppMethodBeat.o(194909);
  }
  
  private void Jd()
  {
    AppMethodBeat.i(194937);
    if (getOrientation() == 1) {}
    for (int i = getWidth() - getPaddingRight() - getPaddingLeft();; i = getHeight() - getPaddingBottom() - getPaddingTop())
    {
      fH(i);
      AppMethodBeat.o(194937);
      return;
    }
  }
  
  private void Je()
  {
    if ((this.bWn == null) || (this.bWn.length != this.bWl)) {
      this.bWn = new View[this.bWl];
    }
  }
  
  private int a(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(194975);
    if (!params.caw)
    {
      paramInt = this.bWq.bh(paramInt, this.bWl);
      AppMethodBeat.o(194975);
      return paramInt;
    }
    paramInt = paramn.ga(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(194975);
      return 0;
    }
    paramInt = this.bWq.bh(paramInt, this.bWl);
    AppMethodBeat.o(194975);
    return paramInt;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(195004);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {}
    for (paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);; paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      AppMethodBeat.o(195004);
      return;
    }
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.s params, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(195012);
    int i;
    int j;
    if (paramBoolean)
    {
      i = 1;
      int m = 0;
      j = paramInt;
      paramInt = m;
    }
    while (paramInt != j)
    {
      View localView = this.bWn[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localLayoutParams.bWt = c(paramn, params, getPosition(localView));
      localLayoutParams.bWs = k;
      k += localLayoutParams.bWt;
      paramInt += i;
      continue;
      paramInt -= 1;
      i = -1;
      j = -1;
    }
    AppMethodBeat.o(195012);
  }
  
  private int b(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(194984);
    if (!params.caw)
    {
      paramInt = this.bWq.bg(paramInt, this.bWl);
      AppMethodBeat.o(194984);
      return paramInt;
    }
    int i = this.bWp.get(paramInt, -1);
    if (i != -1)
    {
      AppMethodBeat.o(194984);
      return i;
    }
    paramInt = paramn.ga(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(194984);
      return 0;
    }
    paramInt = this.bWq.bg(paramInt, this.bWl);
    AppMethodBeat.o(194984);
    return paramInt;
  }
  
  private int be(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194960);
    if ((this.mOrientation == 1) && (Ja()))
    {
      int i = this.bWm[(this.bWl - paramInt1)];
      paramInt1 = this.bWm[(this.bWl - paramInt1 - paramInt2)];
      AppMethodBeat.o(194960);
      return i - paramInt1;
    }
    paramInt2 = this.bWm[(paramInt1 + paramInt2)];
    paramInt1 = this.bWm[paramInt1];
    AppMethodBeat.o(194960);
    return paramInt2 - paramInt1;
  }
  
  private int c(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(194990);
    if (!params.caw)
    {
      paramInt = this.bWq.fJ(paramInt);
      AppMethodBeat.o(194990);
      return paramInt;
    }
    int i = this.bWo.get(paramInt, -1);
    if (i != -1)
    {
      AppMethodBeat.o(194990);
      return i;
    }
    paramInt = paramn.ga(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(194990);
      return 1;
    }
    paramInt = this.bWq.fJ(paramInt);
    AppMethodBeat.o(194990);
    return paramInt;
  }
  
  private void d(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194997);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.bWr;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = be(localLayoutParams.bWs, localLayoutParams.bWt);
    if (this.mOrientation == 1)
    {
      i = getChildMeasureSpec(k, paramInt, i, localLayoutParams.width, false);
      paramInt = getChildMeasureSpec(this.bXy.JG(), getHeightMode(), j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      AppMethodBeat.o(194997);
      return;
      paramInt = getChildMeasureSpec(k, paramInt, j, localLayoutParams.height, false);
      i = getChildMeasureSpec(this.bXy.JG(), getWidthMode(), i, localLayoutParams.width, true);
    }
  }
  
  private void fH(int paramInt)
  {
    AppMethodBeat.i(194942);
    this.bWm = g(this.bWm, this.bWl, paramInt);
    AppMethodBeat.o(194942);
  }
  
  private static int[] g(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 1;
    paramInt2 = 0;
    int j = 0;
    int k;
    if (i <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 <= 0) || (paramInt1 - paramInt2 >= n)) {
        break label109;
      }
      k = m + 1;
      paramInt2 -= paramInt1;
    }
    for (;;)
    {
      j += k;
      arrayOfInt[i] = j;
      i += 1;
      break;
      return arrayOfInt;
      label109:
      k = m;
    }
  }
  
  final View a(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195129);
    Jo();
    int j = this.bXy.JE();
    int k = this.bXy.JF();
    int i;
    Object localObject1;
    Object localObject2;
    label42:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label174;
      }
      localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramn, params, m) != 0)) {
        break label195;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).bXh.isRemoved()) {
        break label126;
      }
      if (localObject2 != null) {
        break label195;
      }
      localObject2 = localView;
    }
    label174:
    label195:
    for (;;)
    {
      paramInt1 += i;
      break label42;
      i = -1;
      break;
      label126:
      if ((this.bXy.bs(localView) >= k) || (this.bXy.bt(localView) < j))
      {
        if (localObject1 == null) {
          localObject1 = localView;
        }
      }
      else
      {
        AppMethodBeat.o(195129);
        return localView;
        if (localObject1 != null)
        {
          AppMethodBeat.o(195129);
          return localObject1;
        }
        AppMethodBeat.o(195129);
        return localObject2;
      }
    }
  }
  
  final void a(RecyclerView.n paramn, RecyclerView.s params, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(195107);
    super.a(paramn, params, parama, paramInt);
    Jd();
    if ((params.getItemCount() > 0) && (!params.caw))
    {
      if (paramInt == 1) {}
      for (paramInt = i;; paramInt = 0)
      {
        i = b(paramn, params, parama.mPosition);
        if (paramInt == 0) {
          break;
        }
        while ((i > 0) && (parama.mPosition > 0))
        {
          parama.mPosition -= 1;
          i = b(paramn, params, parama.mPosition);
        }
      }
      int k = params.getItemCount();
      paramInt = parama.mPosition;
      while (paramInt < k - 1)
      {
        int j = b(paramn, params, paramInt + 1);
        if (j <= i) {
          break;
        }
        paramInt += 1;
        i = j;
      }
      parama.mPosition = paramInt;
    }
    Je();
    AppMethodBeat.o(195107);
  }
  
  final void a(RecyclerView.n paramn, RecyclerView.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    AppMethodBeat.i(195169);
    int i3 = this.bXy.JI();
    int j;
    int k;
    label44:
    boolean bool;
    label64:
    int i;
    int n;
    if (i3 != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0) {
        break label218;
      }
      k = this.bWm[this.bWl];
      if (j != 0) {
        Jd();
      }
      if (paramc.bXs != 1) {
        break label224;
      }
      bool = true;
      i = this.bWl;
      if (bool) {
        break label1140;
      }
      i = b(paramn, params, paramc.bXr) + c(paramn, params, paramc.bXr);
      n = 0;
    }
    label559:
    label1079:
    for (;;)
    {
      int i1;
      label218:
      label224:
      Object localObject;
      if ((n < this.bWl) && (paramc.a(params)) && (i > 0))
      {
        m = paramc.bXr;
        i1 = c(paramn, params, m);
        if (i1 > this.bWl)
        {
          paramn = new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.bWl + " spans.");
          AppMethodBeat.o(195169);
          throw paramn;
          j = 0;
          break;
          k = 0;
          break label44;
          bool = false;
          break label64;
        }
        i -= i1;
        if (i >= 0)
        {
          localObject = paramc.a(paramn);
          if (localObject != null)
          {
            this.bWn[n] = localObject;
            n += 1;
            continue;
          }
        }
      }
      if (n == 0)
      {
        paramb.mFinished = true;
        AppMethodBeat.o(195169);
        return;
      }
      i = 0;
      float f1 = 0.0F;
      a(paramn, params, n, bool);
      int m = 0;
      label341:
      int i2;
      if (m < n)
      {
        paramn = this.bWn[m];
        if (paramc.bXT == null) {
          if (bool)
          {
            addView(paramn);
            calculateItemDecorationsForChild(paramn, this.bWr);
            d(paramn, i3, false);
            i2 = this.bXy.bw(paramn);
            i1 = i;
            if (i2 > i) {
              i1 = i2;
            }
            params = (LayoutParams)paramn.getLayoutParams();
            float f2 = this.bXy.bx(paramn) * 1.0F / params.bWt;
            if (f2 <= f1) {
              break label1137;
            }
            f1 = f2;
          }
        }
      }
      label725:
      label1119:
      label1134:
      label1137:
      for (;;)
      {
        m += 1;
        i = i1;
        break;
        addView(paramn, 0);
        break label341;
        if (bool)
        {
          addDisappearingView(paramn);
          break label341;
        }
        addDisappearingView(paramn, 0);
        break label341;
        if (j != 0)
        {
          fH(Math.max(Math.round(this.bWl * f1), k));
          i = 0;
          k = 0;
          j = i;
          if (k >= n) {
            break label559;
          }
          paramn = this.bWn[k];
          d(paramn, 1073741824, true);
          j = this.bXy.bw(paramn);
          if (j <= i) {
            break label1134;
          }
          i = j;
        }
        for (;;)
        {
          k += 1;
          break;
          j = i;
          i = 0;
          if (i < n)
          {
            paramn = this.bWn[i];
            if (this.bXy.bw(paramn) != j)
            {
              params = (LayoutParams)paramn.getLayoutParams();
              localObject = params.bWr;
              m = ((Rect)localObject).top + ((Rect)localObject).bottom + params.topMargin + params.bottomMargin;
              k = ((Rect)localObject).left;
              k = ((Rect)localObject).right + k + params.leftMargin + params.rightMargin;
              i1 = be(params.bWs, params.bWt);
              if (this.mOrientation != 1) {
                break label725;
              }
              k = getChildMeasureSpec(i1, 1073741824, k, params.width, false);
            }
            for (m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);; m = getChildMeasureSpec(i1, 1073741824, m, params.height, false))
            {
              a(paramn, k, m, true);
              i += 1;
              break;
              k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
            }
          }
          paramb.bXN = j;
          k = 0;
          m = 0;
          i1 = 0;
          if (this.mOrientation == 1) {
            if (paramc.mLayoutDirection == -1)
            {
              i = paramc.Sc;
              j = i - j;
              i1 = 0;
              i3 = k;
              k = i1;
              i1 = i;
              i2 = m;
              m = j;
              i = i3;
              if (k >= n) {
                break label1119;
              }
              paramn = this.bWn[k];
              params = (LayoutParams)paramn.getLayoutParams();
              if (this.mOrientation != 1) {
                break label1079;
              }
              if (!Ja()) {
                break label1043;
              }
              j = getPaddingLeft() + this.bWm[(this.bWl - params.bWs)];
              i = j - this.bXy.bx(paramn);
            }
          }
          for (;;)
          {
            layoutDecoratedWithMargins(paramn, i, m, j, i1);
            if ((params.bXh.isRemoved()) || (params.bXh.KW())) {
              paramb.bXO = true;
            }
            paramb.kK |= paramn.hasFocusable();
            k += 1;
            i2 = j;
            break label830;
            i1 = paramc.Sc;
            i = j + i1;
            j = i1;
            break;
            if (paramc.mLayoutDirection == -1)
            {
              m = paramc.Sc;
              k = m - j;
              i = 0;
              j = i1;
              break;
            }
            k = paramc.Sc;
            m = k + j;
            i = 0;
            j = i1;
            break;
            i = getPaddingLeft();
            i = this.bWm[params.bWs] + i;
            j = i + this.bXy.bx(paramn);
            continue;
            j = getPaddingTop();
            m = this.bWm[params.bWs] + j;
            i1 = m + this.bXy.bx(paramn);
            j = i2;
          }
          Arrays.fill(this.bWn, null);
          AppMethodBeat.o(195169);
          return;
        }
      }
      label830:
      label1140:
      n = 0;
    }
  }
  
  final void a(RecyclerView.s params, LinearLayoutManager.c paramc, RecyclerView.LayoutManager.a parama)
  {
    AppMethodBeat.i(195140);
    int j = this.bWl;
    int i = 0;
    while ((i < this.bWl) && (paramc.a(params)) && (j > 0))
    {
      int k = paramc.bXr;
      parama.bd(k, Math.max(0, paramc.bXP));
      j -= this.bWq.fJ(k);
      paramc.bXr += paramc.bXs;
      i += 1;
    }
    AppMethodBeat.o(195140);
  }
  
  public final void aY(boolean paramBoolean)
  {
    AppMethodBeat.i(195018);
    if (paramBoolean)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
      AppMethodBeat.o(195018);
      throw localUnsupportedOperationException;
    }
    super.aY(false);
    AppMethodBeat.o(195018);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final void fI(int paramInt)
  {
    AppMethodBeat.i(195183);
    if (paramInt == this.bWl)
    {
      AppMethodBeat.o(195183);
      return;
    }
    this.bWk = true;
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(195183);
      throw localIllegalArgumentException;
    }
    this.bWl = paramInt;
    this.bWq.bWu.clear();
    requestLayout();
    AppMethodBeat.o(195183);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(195073);
    if (this.mOrientation == 0)
    {
      localLayoutParams = new LayoutParams(-2, -1);
      AppMethodBeat.o(195073);
      return localLayoutParams;
    }
    LayoutParams localLayoutParams = new LayoutParams(-1, -2);
    AppMethodBeat.o(195073);
    return localLayoutParams;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(195079);
    paramContext = new LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(195079);
    return paramContext;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(195085);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(195085);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(195085);
    return paramLayoutParams;
  }
  
  public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195028);
    if (this.mOrientation == 1)
    {
      i = this.bWl;
      AppMethodBeat.o(195028);
      return i;
    }
    if (params.getItemCount() <= 0)
    {
      AppMethodBeat.o(195028);
      return 0;
    }
    int i = a(paramn, params, params.getItemCount() - 1);
    AppMethodBeat.o(195028);
    return i + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195022);
    if (this.mOrientation == 0)
    {
      i = this.bWl;
      AppMethodBeat.o(195022);
      return i;
    }
    if (params.getItemCount() <= 0)
    {
      AppMethodBeat.o(195022);
      return 0;
    }
    int i = a(paramn, params, params.getItemCount() - 1);
    AppMethodBeat.o(195022);
    return i + 1;
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195195);
    View localView2 = findContainingItemView(paramView);
    if (localView2 == null)
    {
      AppMethodBeat.o(195195);
      return null;
    }
    Object localObject = (LayoutParams)localView2.getLayoutParams();
    int i6 = ((LayoutParams)localObject).bWs;
    int i7 = ((LayoutParams)localObject).bWs + ((LayoutParams)localObject).bWt;
    if (super.onFocusSearchFailed(paramView, paramInt, paramn, params) == null)
    {
      AppMethodBeat.o(195195);
      return null;
    }
    int i11;
    label99:
    int m;
    int k;
    if (fN(paramInt) == 1)
    {
      i11 = 1;
      if (i11 == this.bXB) {
        break label232;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label237;
      }
      paramInt = getChildCount() - 1;
      m = -1;
      k = -1;
      label116:
      if ((this.mOrientation != 1) || (!Ja())) {
        break label251;
      }
    }
    int i2;
    int i3;
    int i;
    int j;
    int i1;
    View localView1;
    label232:
    label237:
    label251:
    for (int n = 1;; n = 0)
    {
      paramView = null;
      i2 = -1;
      i3 = 0;
      localObject = null;
      i = -1;
      j = 0;
      int i8 = a(paramn, params, paramInt);
      i1 = paramInt;
      if (i1 != k)
      {
        paramInt = a(paramn, params, i1);
        localView1 = getChildAt(i1);
        if (localView1 != localView2)
        {
          if ((!localView1.hasFocusable()) || (paramInt == i8)) {
            break label257;
          }
          if (paramView == null) {
            break label596;
          }
        }
      }
      if (paramView == null) {
        break label587;
      }
      AppMethodBeat.o(195195);
      return paramView;
      i11 = 0;
      break;
      paramInt = 0;
      break label99;
      paramInt = 0;
      m = 1;
      k = getChildCount();
      break label116;
    }
    label257:
    LayoutParams localLayoutParams = (LayoutParams)localView1.getLayoutParams();
    int i9 = localLayoutParams.bWs;
    int i10 = localLayoutParams.bWs + localLayoutParams.bWt;
    if ((localView1.hasFocusable()) && (i9 == i6) && (i10 == i7))
    {
      AppMethodBeat.o(195195);
      return localView1;
    }
    int i5 = 0;
    if (((localView1.hasFocusable()) && (paramView == null)) || ((!localView1.hasFocusable()) && (localObject == null)))
    {
      paramInt = 1;
      label348:
      if (paramInt == 0) {
        break label596;
      }
      if (!localView1.hasFocusable()) {
        break label557;
      }
      i2 = localLayoutParams.bWs;
      i3 = Math.min(i10, i7) - Math.max(i9, i6);
      paramInt = j;
      paramView = localView1;
    }
    for (;;)
    {
      i1 += m;
      j = paramInt;
      break;
      paramInt = Math.max(i9, i6);
      int i4 = Math.min(i10, i7) - paramInt;
      if (localView1.hasFocusable())
      {
        if (i4 > i3)
        {
          paramInt = 1;
          break label348;
        }
        paramInt = i5;
        if (i4 != i3) {
          break label348;
        }
        if (i9 > i2) {}
        for (i4 = 1;; i4 = 0)
        {
          paramInt = i5;
          if (n != i4) {
            break;
          }
          paramInt = 1;
          break;
        }
      }
      paramInt = i5;
      if (paramView != null) {
        break label348;
      }
      paramInt = i5;
      if (!isViewPartiallyVisible(localView1, false, true)) {
        break label348;
      }
      if (i4 > j)
      {
        paramInt = 1;
        break label348;
      }
      paramInt = i5;
      if (i4 != j) {
        break label348;
      }
      if (i9 > i) {}
      for (i4 = 1;; i4 = 0)
      {
        paramInt = i5;
        if (n != i4) {
          break;
        }
        paramInt = 1;
        break;
      }
      label557:
      i = localLayoutParams.bWs;
      paramInt = Math.min(i10, i7) - Math.max(i9, i6);
      localObject = localView1;
      continue;
      label587:
      AppMethodBeat.o(195195);
      return localObject;
      label596:
      paramInt = j;
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, d paramd)
  {
    AppMethodBeat.i(195034);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramd);
      AppMethodBeat.o(195034);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = a(paramn, params, paramView.bXh.KI());
    if (this.mOrientation == 0)
    {
      j = paramView.bWs;
      k = paramView.bWt;
      if ((this.bWl > 1) && (paramView.bWt == this.bWl)) {}
      for (bool = true;; bool = false)
      {
        paramd.aC(d.c.a(j, k, i, 1, bool, false));
        AppMethodBeat.o(195034);
        return;
      }
    }
    int j = paramView.bWs;
    int k = paramView.bWt;
    if ((this.bWl > 1) && (paramView.bWt == this.bWl)) {}
    for (boolean bool = true;; bool = false)
    {
      paramd.aC(d.c.a(i, 1, j, k, bool, false));
      AppMethodBeat.o(195034);
      return;
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195045);
    this.bWq.bWu.clear();
    AppMethodBeat.o(195045);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(195051);
    this.bWq.bWu.clear();
    AppMethodBeat.o(195051);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195066);
    this.bWq.bWu.clear();
    AppMethodBeat.o(195066);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195056);
    this.bWq.bWu.clear();
    AppMethodBeat.o(195056);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(195061);
    this.bWq.bWu.clear();
    AppMethodBeat.o(195061);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195040);
    if (params.caw)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.bXh.KI();
        this.bWo.put(k, localLayoutParams.bWt);
        this.bWp.put(k, localLayoutParams.bWs);
        i += 1;
      }
    }
    super.onLayoutChildren(paramn, params);
    this.bWo.clear();
    this.bWp.clear();
    AppMethodBeat.o(195040);
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(195044);
    super.onLayoutCompleted(params);
    this.bWk = false;
    AppMethodBeat.o(195044);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195113);
    Jd();
    Je();
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(195113);
    return paramInt;
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195119);
    Jd();
    Je();
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(195119);
    return paramInt;
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195096);
    if (this.bWm == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.bWm[(this.bWm.length - 1)], getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(195096);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.bWm[(this.bWm.length - 1)], getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.bXH == null) && (!this.bWk);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public int bWs = -1;
    public int bWt = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract class b
  {
    final SparseIntArray bWu = new SparseIntArray();
    private boolean bWv = false;
    
    public int bf(int paramInt1, int paramInt2)
    {
      int n = fJ(paramInt1);
      if (n == paramInt2) {
        return 0;
      }
      int j;
      int i;
      int k;
      if ((this.bWv) && (this.bWu.size() > 0))
      {
        j = this.bWu.size() - 1;
        i = 0;
        while (i <= j)
        {
          k = i + j >>> 1;
          if (this.bWu.keyAt(k) < paramInt1) {
            i = k + 1;
          } else {
            j = k - 1;
          }
        }
        i -= 1;
        if ((i >= 0) && (i < this.bWu.size()))
        {
          i = this.bWu.keyAt(i);
          if (i < 0) {
            break label216;
          }
          j = this.bWu.get(i) + fJ(i);
          k = i + 1;
          i = j;
          j = k;
        }
      }
      for (;;)
      {
        label149:
        if (j < paramInt1)
        {
          k = fJ(j);
          int m = i + k;
          if (m == paramInt2) {
            i = 0;
          }
          for (;;)
          {
            j += 1;
            break label149;
            i = -1;
            break;
            i = k;
            if (m <= paramInt2) {
              i = m;
            }
          }
        }
        if (i + n > paramInt2) {
          break;
        }
        return i;
        label216:
        j = 0;
        i = 0;
      }
    }
    
    final int bg(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.bWv) {
        i = bf(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = this.bWu.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = bf(paramInt1, paramInt2);
      this.bWu.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public final int bh(int paramInt1, int paramInt2)
    {
      int n = fJ(paramInt1);
      int k = 0;
      int i = 0;
      int j = 0;
      int m;
      if (k < paramInt1)
      {
        m = fJ(k);
        j += m;
        if (j == paramInt2)
        {
          j = i + 1;
          i = 0;
        }
      }
      for (;;)
      {
        k += 1;
        m = i;
        i = j;
        j = m;
        break;
        if (j > paramInt2)
        {
          j = i + 1;
          i = m;
          continue;
          paramInt1 = i;
          if (j + n > paramInt2) {
            paramInt1 = i + 1;
          }
          return paramInt1;
        }
        else
        {
          m = j;
          j = i;
          i = m;
        }
      }
    }
    
    public abstract int fJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */