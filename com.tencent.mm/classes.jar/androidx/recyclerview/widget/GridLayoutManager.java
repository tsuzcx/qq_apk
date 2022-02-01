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
  boolean ahE;
  public int ahF;
  int[] ahG;
  View[] ahH;
  final SparseIntArray ahI;
  final SparseIntArray ahJ;
  public GridLayoutManager.b ahK;
  final Rect ahL;
  
  public GridLayoutManager(int paramInt)
  {
    AppMethodBeat.i(261269);
    this.ahE = false;
    this.ahF = -1;
    this.ahI = new SparseIntArray();
    this.ahJ = new SparseIntArray();
    this.ahK = new GridLayoutManager.a();
    this.ahL = new Rect();
    cw(paramInt);
    AppMethodBeat.o(261269);
  }
  
  public GridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt2, false);
    AppMethodBeat.i(261270);
    this.ahE = false;
    this.ahF = -1;
    this.ahI = new SparseIntArray();
    this.ahJ = new SparseIntArray();
    this.ahK = new GridLayoutManager.a();
    this.ahL = new Rect();
    cw(paramInt1);
    AppMethodBeat.o(261270);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(261267);
    this.ahE = false;
    this.ahF = -1;
    this.ahI = new SparseIntArray();
    this.ahJ = new SparseIntArray();
    this.ahK = new GridLayoutManager.a();
    this.ahL = new Rect();
    cw(getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).spanCount);
    AppMethodBeat.o(261267);
  }
  
  private int a(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(261343);
    if (!params.alW)
    {
      paramInt = this.ahK.ao(paramInt, this.ahF);
      AppMethodBeat.o(261343);
      return paramInt;
    }
    paramInt = paramn.cQ(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(261343);
      return 0;
    }
    paramInt = this.ahK.ao(paramInt, this.ahF);
    AppMethodBeat.o(261343);
    return paramInt;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(261366);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {}
    for (paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);; paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      AppMethodBeat.o(261366);
      return;
    }
  }
  
  private void a(RecyclerView.n paramn, RecyclerView.s params, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(261368);
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
      View localView = this.ahH[paramInt];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localLayoutParams.ahN = c(paramn, params, getPosition(localView));
      localLayoutParams.ahM = k;
      k += localLayoutParams.ahN;
      paramInt += i;
      continue;
      paramInt -= 1;
      i = -1;
      j = -1;
    }
    AppMethodBeat.o(261368);
  }
  
  private int al(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261322);
    if ((this.mOrientation == 1) && (kp()))
    {
      int i = this.ahG[(this.ahF - paramInt1)];
      paramInt1 = this.ahG[(this.ahF - paramInt1 - paramInt2)];
      AppMethodBeat.o(261322);
      return i - paramInt1;
    }
    paramInt2 = this.ahG[(paramInt1 + paramInt2)];
    paramInt1 = this.ahG[paramInt1];
    AppMethodBeat.o(261322);
    return paramInt2 - paramInt1;
  }
  
  private int b(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(261347);
    if (!params.alW)
    {
      paramInt = this.ahK.an(paramInt, this.ahF);
      AppMethodBeat.o(261347);
      return paramInt;
    }
    int i = this.ahJ.get(paramInt, -1);
    if (i != -1)
    {
      AppMethodBeat.o(261347);
      return i;
    }
    paramInt = paramn.cQ(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(261347);
      return 0;
    }
    paramInt = this.ahK.an(paramInt, this.ahF);
    AppMethodBeat.o(261347);
    return paramInt;
  }
  
  private int c(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(261350);
    if (!params.alW)
    {
      paramInt = this.ahK.cx(paramInt);
      AppMethodBeat.o(261350);
      return paramInt;
    }
    int i = this.ahI.get(paramInt, -1);
    if (i != -1)
    {
      AppMethodBeat.o(261350);
      return i;
    }
    paramInt = paramn.cQ(paramInt);
    if (paramInt == -1)
    {
      AppMethodBeat.o(261350);
      return 1;
    }
    paramInt = this.ahK.cx(paramInt);
    AppMethodBeat.o(261350);
    return paramInt;
  }
  
  private void c(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(261363);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.ahL;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left;
    int k = localRect.right;
    int m = localLayoutParams.leftMargin;
    i = localLayoutParams.rightMargin + (k + i + m);
    k = al(localLayoutParams.ahM, localLayoutParams.ahN);
    if (this.mOrientation == 1)
    {
      i = getChildMeasureSpec(k, paramInt, i, localLayoutParams.width, false);
      paramInt = getChildMeasureSpec(this.aiT.kV(), getHeightMode(), j, localLayoutParams.height, true);
    }
    for (;;)
    {
      a(paramView, i, paramInt, paramBoolean);
      AppMethodBeat.o(261363);
      return;
      paramInt = getChildMeasureSpec(k, paramInt, j, localLayoutParams.height, false);
      i = getChildMeasureSpec(this.aiT.kV(), getWidthMode(), i, localLayoutParams.width, true);
    }
  }
  
  private static int[] c(int[] paramArrayOfInt, int paramInt1, int paramInt2)
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
  
  private void cv(int paramInt)
  {
    AppMethodBeat.i(261316);
    this.ahG = c(this.ahG, this.ahF, paramInt);
    AppMethodBeat.o(261316);
  }
  
  private void ks()
  {
    AppMethodBeat.i(261310);
    if (getOrientation() == 1) {}
    for (int i = getWidth() - getPaddingRight() - getPaddingLeft();; i = getHeight() - getPaddingBottom() - getPaddingTop())
    {
      cv(i);
      AppMethodBeat.o(261310);
      return;
    }
  }
  
  private void kt()
  {
    if ((this.ahH == null) || (this.ahH.length != this.ahF)) {
      this.ahH = new View[this.ahF];
    }
  }
  
  final View a(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(261337);
    kD();
    int j = this.aiT.kT();
    int k = this.aiT.kU();
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
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aiC.isRemoved()) {
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
      if ((this.aiT.aZ(localView) >= k) || (this.aiT.ba(localView) < j))
      {
        if (localObject1 == null) {
          localObject1 = localView;
        }
      }
      else
      {
        AppMethodBeat.o(261337);
        return localView;
        if (localObject1 != null)
        {
          AppMethodBeat.o(261337);
          return localObject1;
        }
        AppMethodBeat.o(261337);
        return localObject2;
      }
    }
  }
  
  public final void a(GridLayoutManager.b paramb)
  {
    this.ahK = paramb;
  }
  
  final void a(RecyclerView.n paramn, RecyclerView.s params, LinearLayoutManager.a parama, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(261325);
    super.a(paramn, params, parama, paramInt);
    ks();
    if ((params.getItemCount() > 0) && (!params.alW))
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
    kt();
    AppMethodBeat.o(261325);
  }
  
  final void a(RecyclerView.n paramn, RecyclerView.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    AppMethodBeat.i(261360);
    int i3 = this.aiT.kX();
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
      k = this.ahG[this.ahF];
      if (j != 0) {
        ks();
      }
      if (paramc.aiN != 1) {
        break label224;
      }
      bool = true;
      i = this.ahF;
      if (bool) {
        break label1140;
      }
      i = b(paramn, params, paramc.aiM) + c(paramn, params, paramc.aiM);
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
      if ((n < this.ahF) && (paramc.a(params)) && (i > 0))
      {
        m = paramc.aiM;
        i1 = c(paramn, params, m);
        if (i1 > this.ahF)
        {
          paramn = new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + this.ahF + " spans.");
          AppMethodBeat.o(261360);
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
            this.ahH[n] = localObject;
            n += 1;
            continue;
          }
        }
      }
      if (n == 0)
      {
        paramb.mFinished = true;
        AppMethodBeat.o(261360);
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
        paramn = this.ahH[m];
        if (paramc.ajp == null) {
          if (bool)
          {
            addView(paramn);
            calculateItemDecorationsForChild(paramn, this.ahL);
            c(paramn, i3, false);
            i2 = this.aiT.bd(paramn);
            i1 = i;
            if (i2 > i) {
              i1 = i2;
            }
            params = (LayoutParams)paramn.getLayoutParams();
            float f2 = this.aiT.be(paramn) * 1.0F / params.ahN;
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
          cv(Math.max(Math.round(this.ahF * f1), k));
          i = 0;
          k = 0;
          j = i;
          if (k >= n) {
            break label559;
          }
          paramn = this.ahH[k];
          c(paramn, 1073741824, true);
          j = this.aiT.bd(paramn);
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
            paramn = this.ahH[i];
            if (this.aiT.bd(paramn) != j)
            {
              params = (LayoutParams)paramn.getLayoutParams();
              localObject = params.ahL;
              m = ((Rect)localObject).top + ((Rect)localObject).bottom + params.topMargin + params.bottomMargin;
              k = ((Rect)localObject).left;
              k = ((Rect)localObject).right + k + params.leftMargin + params.rightMargin;
              i1 = al(params.ahM, params.ahN);
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
          paramb.ajj = j;
          k = 0;
          m = 0;
          i1 = 0;
          if (this.mOrientation == 1) {
            if (paramc.mLayoutDirection == -1)
            {
              i = paramc.zP;
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
              paramn = this.ahH[k];
              params = (LayoutParams)paramn.getLayoutParams();
              if (this.mOrientation != 1) {
                break label1079;
              }
              if (!kp()) {
                break label1043;
              }
              j = getPaddingLeft() + this.ahG[(this.ahF - params.ahM)];
              i = j - this.aiT.be(paramn);
            }
          }
          for (;;)
          {
            layoutDecoratedWithMargins(paramn, i, m, j, i1);
            if ((params.aiC.isRemoved()) || (params.aiC.mt())) {
              paramb.ajk = true;
            }
            paramb.jO |= paramn.hasFocusable();
            k += 1;
            i2 = j;
            break label830;
            i1 = paramc.zP;
            i = j + i1;
            j = i1;
            break;
            if (paramc.mLayoutDirection == -1)
            {
              m = paramc.zP;
              k = m - j;
              i = 0;
              j = i1;
              break;
            }
            k = paramc.zP;
            m = k + j;
            i = 0;
            j = i1;
            break;
            i = getPaddingLeft();
            i = this.ahG[params.ahM] + i;
            j = i + this.aiT.be(paramn);
            continue;
            j = getPaddingTop();
            m = this.ahG[params.ahM] + j;
            i1 = m + this.aiT.be(paramn);
            j = i2;
          }
          Arrays.fill(this.ahH, null);
          AppMethodBeat.o(261360);
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
    AppMethodBeat.i(261352);
    int j = this.ahF;
    int i = 0;
    while ((i < this.ahF) && (paramc.a(params)) && (j > 0))
    {
      int k = paramc.aiM;
      parama.ak(k, Math.max(0, paramc.ajl));
      j -= this.ahK.cx(k);
      paramc.aiM += paramc.aiN;
      i += 1;
    }
    AppMethodBeat.o(261352);
  }
  
  public final void ap(boolean paramBoolean)
  {
    AppMethodBeat.i(261272);
    if (paramBoolean)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
      AppMethodBeat.o(261272);
      throw localUnsupportedOperationException;
    }
    super.ap(false);
    AppMethodBeat.o(261272);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final void cw(int paramInt)
  {
    AppMethodBeat.i(261372);
    if (paramInt == this.ahF)
    {
      AppMethodBeat.o(261372);
      return;
    }
    this.ahE = true;
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(261372);
      throw localIllegalArgumentException;
    }
    this.ahF = paramInt;
    this.ahK.ahO.clear();
    requestLayout();
    AppMethodBeat.o(261372);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(261293);
    if (this.mOrientation == 0)
    {
      localLayoutParams = new LayoutParams(-2, -1);
      AppMethodBeat.o(261293);
      return localLayoutParams;
    }
    LayoutParams localLayoutParams = new LayoutParams(-1, -2);
    AppMethodBeat.o(261293);
    return localLayoutParams;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(261297);
    paramContext = new LayoutParams(paramContext, paramAttributeSet);
    AppMethodBeat.o(261297);
    return paramContext;
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(261301);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      AppMethodBeat.o(261301);
      return paramLayoutParams;
    }
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(261301);
    return paramLayoutParams;
  }
  
  public int getColumnCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261274);
    if (this.mOrientation == 1)
    {
      i = this.ahF;
      AppMethodBeat.o(261274);
      return i;
    }
    if (params.getItemCount() <= 0)
    {
      AppMethodBeat.o(261274);
      return 0;
    }
    int i = a(paramn, params, params.getItemCount() - 1);
    AppMethodBeat.o(261274);
    return i + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261273);
    if (this.mOrientation == 0)
    {
      i = this.ahF;
      AppMethodBeat.o(261273);
      return i;
    }
    if (params.getItemCount() <= 0)
    {
      AppMethodBeat.o(261273);
      return 0;
    }
    int i = a(paramn, params, params.getItemCount() - 1);
    AppMethodBeat.o(261273);
    return i + 1;
  }
  
  public final GridLayoutManager.b getSpanSizeLookup()
  {
    return this.ahK;
  }
  
  public final int ku()
  {
    return this.ahF;
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261375);
    View localView2 = findContainingItemView(paramView);
    if (localView2 == null)
    {
      AppMethodBeat.o(261375);
      return null;
    }
    Object localObject = (LayoutParams)localView2.getLayoutParams();
    int i6 = ((LayoutParams)localObject).ahM;
    int i7 = ((LayoutParams)localObject).ahM + ((LayoutParams)localObject).ahN;
    if (super.onFocusSearchFailed(paramView, paramInt, paramn, params) == null)
    {
      AppMethodBeat.o(261375);
      return null;
    }
    int i11;
    label99:
    int m;
    int k;
    if (cD(paramInt) == 1)
    {
      i11 = 1;
      if (i11 == this.aiW) {
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
      if ((this.mOrientation != 1) || (!kp())) {
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
      AppMethodBeat.o(261375);
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
    int i9 = localLayoutParams.ahM;
    int i10 = localLayoutParams.ahM + localLayoutParams.ahN;
    if ((localView1.hasFocusable()) && (i9 == i6) && (i10 == i7))
    {
      AppMethodBeat.o(261375);
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
      i2 = localLayoutParams.ahM;
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
      i = localLayoutParams.ahM;
      paramInt = Math.min(i10, i7) - Math.max(i9, i6);
      localObject = localView1;
      continue;
      label587:
      AppMethodBeat.o(261375);
      return localObject;
      label596:
      paramInt = j;
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n paramn, RecyclerView.s params, View paramView, d paramd)
  {
    boolean bool2 = false;
    AppMethodBeat.i(261275);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramd);
      AppMethodBeat.o(261275);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = a(paramn, params, paramView.aiC.mc());
    if (this.mOrientation == 0)
    {
      j = paramView.ahM;
      k = paramView.ahN;
      if ((this.ahF > 1) && (paramView.ahN == this.ahF)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramd.D(d.c.a(j, k, i, 1, bool1));
        AppMethodBeat.o(261275);
        return;
      }
    }
    int j = paramView.ahM;
    int k = paramView.ahN;
    boolean bool1 = bool2;
    if (this.ahF > 1)
    {
      bool1 = bool2;
      if (paramView.ahN == this.ahF) {
        bool1 = true;
      }
    }
    paramd.D(d.c.a(i, 1, j, k, bool1));
    AppMethodBeat.o(261275);
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261280);
    this.ahK.ahO.clear();
    AppMethodBeat.o(261280);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(261282);
    this.ahK.ahO.clear();
    AppMethodBeat.o(261282);
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(261290);
    this.ahK.ahO.clear();
    AppMethodBeat.o(261290);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261284);
    this.ahK.ahO.clear();
    AppMethodBeat.o(261284);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(261287);
    this.ahK.ahO.clear();
    AppMethodBeat.o(261287);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261276);
    if (params.alW)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.aiC.mc();
        this.ahI.put(k, localLayoutParams.ahN);
        this.ahJ.put(k, localLayoutParams.ahM);
        i += 1;
      }
    }
    super.onLayoutChildren(paramn, params);
    this.ahI.clear();
    this.ahJ.clear();
    AppMethodBeat.o(261276);
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(261277);
    super.onLayoutCompleted(params);
    this.ahE = false;
    AppMethodBeat.o(261277);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261330);
    ks();
    kt();
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(261330);
    return paramInt;
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261334);
    ks();
    kt();
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(261334);
    return paramInt;
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261314);
    if (this.ahG == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.ahG[(this.ahG.length - 1)], getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(261314);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.ahG[(this.ahG.length - 1)], getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.ajc == null) && (!this.ahE);
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public int ahM = -1;
    public int ahN = 0;
    
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
    
    public final int kv()
    {
      return this.ahM;
    }
    
    public final int kw()
    {
      return this.ahN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */