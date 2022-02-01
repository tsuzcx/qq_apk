package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b, l.d
{
  private c aiS;
  u aiT;
  private boolean aiU;
  private boolean aiV;
  boolean aiW;
  private boolean aiX;
  private boolean aiY;
  int aiZ;
  int aja;
  private boolean ajb;
  SavedState ajc;
  final a ajd;
  private final b aje;
  public int ajf;
  int mOrientation;
  
  public LinearLayoutManager()
  {
    this(1, false);
  }
  
  public LinearLayoutManager(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(261701);
    this.mOrientation = 1;
    this.aiV = false;
    this.aiW = false;
    this.aiX = false;
    this.aiY = true;
    this.aiZ = -1;
    this.aja = -2147483648;
    this.ajc = null;
    this.ajd = new a();
    this.aje = new b();
    this.ajf = 2;
    setOrientation(paramInt);
    aq(false);
    AppMethodBeat.o(261701);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261703);
    this.mOrientation = 1;
    this.aiV = false;
    this.aiW = false;
    this.aiX = false;
    this.aiY = true;
    this.aiZ = -1;
    this.aja = -2147483648;
    this.ajc = null;
    this.ajd = new a();
    this.aje = new b();
    this.ajf = 2;
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.FO);
    aq(paramContext.aln);
    ap(paramContext.alo);
    AppMethodBeat.o(261703);
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261830);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(261830);
      return 0;
    }
    this.aiS.aiK = true;
    kD();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, params);
      k = this.aiS.ajl + a(paramn, this.aiS, params, false);
      if (k >= 0) {
        break;
      }
      AppMethodBeat.o(261830);
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.aiT.cG(-paramInt);
    this.aiS.ajo = paramInt;
    AppMethodBeat.o(261830);
    return paramInt;
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(261764);
    int i = this.aiT.kU() - paramInt;
    if (i > 0)
    {
      i = -a(-i, paramn, params);
      if (paramBoolean)
      {
        paramInt = this.aiT.kU() - (paramInt + i);
        if (paramInt > 0)
        {
          this.aiT.cG(paramInt);
          AppMethodBeat.o(261764);
          return i + paramInt;
        }
      }
    }
    else
    {
      AppMethodBeat.o(261764);
      return 0;
    }
    AppMethodBeat.o(261764);
    return i;
  }
  
  private int a(RecyclerView.n paramn, c paramc, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(261835);
    int k = paramc.aiL;
    if (paramc.ajl != -2147483648)
    {
      if (paramc.aiL < 0) {
        paramc.ajl += paramc.aiL;
      }
      a(paramn, paramc);
    }
    int i = paramc.aiL + paramc.ajm;
    b localb = this.aje;
    do
    {
      int j;
      do
      {
        if (((!paramc.aiR) && (i <= 0)) || (!paramc.a(params))) {
          break;
        }
        localb.resetInternal();
        a(paramn, params, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.zP += localb.ajj * paramc.mLayoutDirection;
        if ((localb.ajk) && (this.aiS.ajp == null))
        {
          j = i;
          if (params.alW) {}
        }
        else
        {
          paramc.aiL -= localb.ajj;
          j = i - localb.ajj;
        }
        if (paramc.ajl != -2147483648)
        {
          paramc.ajl += localb.ajj;
          if (paramc.aiL < 0) {
            paramc.ajl += paramc.aiL;
          }
          a(paramn, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.jO);
    i = paramc.aiL;
    AppMethodBeat.o(261835);
    return k - i;
  }
  
  private View a(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261852);
    paramn = a(paramn, params, getChildCount() - 1, -1, params.getItemCount());
    AppMethodBeat.o(261852);
    return paramn;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.s params)
  {
    int i = -1;
    int j = 1;
    AppMethodBeat.i(261817);
    this.aiS.aiR = kE();
    this.aiS.ajm = b(params);
    this.aiS.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      params = this.aiS;
      params.ajm += this.aiT.kW();
      params = kG();
      localc = this.aiS;
      if (this.aiW) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.aiN = paramInt1;
        this.aiS.aiM = (getPosition(params) + this.aiS.aiN);
        this.aiS.zP = this.aiT.ba(params);
        paramInt1 = this.aiT.ba(params) - this.aiT.kU();
        this.aiS.aiL = paramInt2;
        if (paramBoolean)
        {
          params = this.aiS;
          params.aiL -= paramInt1;
        }
        this.aiS.ajl = paramInt1;
        AppMethodBeat.o(261817);
        return;
      }
    }
    params = kF();
    c localc = this.aiS;
    localc.ajm += this.aiT.kT();
    localc = this.aiS;
    if (this.aiW) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.aiN = paramInt1;
      this.aiS.aiM = (getPosition(params) + this.aiS.aiN);
      this.aiS.zP = this.aiT.aZ(params);
      paramInt1 = -this.aiT.aZ(params) + this.aiT.kT();
      break;
    }
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(261768);
    as(parama.mPosition, parama.ajg);
    AppMethodBeat.o(261768);
  }
  
  private void a(RecyclerView.n paramn, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261833);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(261833);
      return;
    }
    int i = paramInt1;
    if (paramInt2 > paramInt1)
    {
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        removeAndRecycleViewAt(paramInt2, paramn);
        paramInt2 -= 1;
      }
      AppMethodBeat.o(261833);
      return;
    }
    while (i > paramInt2)
    {
      removeAndRecycleViewAt(i, paramn);
      i -= 1;
    }
    AppMethodBeat.o(261833);
  }
  
  private void a(RecyclerView.n paramn, c paramc)
  {
    AppMethodBeat.i(261834);
    if ((!paramc.aiK) || (paramc.aiR))
    {
      AppMethodBeat.o(261834);
      return;
    }
    int i;
    int k;
    if (paramc.mLayoutDirection == -1)
    {
      i = paramc.ajl;
      j = getChildCount();
      if (i >= 0)
      {
        k = this.aiT.getEnd() - i;
        if (this.aiW)
        {
          i = 0;
          while (i < j)
          {
            paramc = getChildAt(i);
            if ((this.aiT.aZ(paramc) < k) || (this.aiT.bc(paramc) < k))
            {
              a(paramn, 0, i);
              AppMethodBeat.o(261834);
              return;
            }
            i += 1;
          }
          AppMethodBeat.o(261834);
          return;
        }
        i = j - 1;
        while (i >= 0)
        {
          paramc = getChildAt(i);
          if ((this.aiT.aZ(paramc) < k) || (this.aiT.bc(paramc) < k))
          {
            a(paramn, j - 1, i);
            AppMethodBeat.o(261834);
            return;
          }
          i -= 1;
        }
      }
      AppMethodBeat.o(261834);
      return;
    }
    int j = paramc.ajl;
    if (j >= 0)
    {
      k = getChildCount();
      if (this.aiW)
      {
        i = k - 1;
        while (i >= 0)
        {
          paramc = getChildAt(i);
          if ((this.aiT.ba(paramc) > j) || (this.aiT.bb(paramc) > j))
          {
            a(paramn, k - 1, i);
            AppMethodBeat.o(261834);
            return;
          }
          i -= 1;
        }
        AppMethodBeat.o(261834);
        return;
      }
      i = 0;
      while (i < k)
      {
        paramc = getChildAt(i);
        if ((this.aiT.ba(paramc) > j) || (this.aiT.bb(paramc) > j))
        {
          a(paramn, 0, i);
          AppMethodBeat.o(261834);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(261834);
  }
  
  private View ar(boolean paramBoolean)
  {
    AppMethodBeat.i(261849);
    if (this.aiW)
    {
      localView = c(getChildCount() - 1, -1, paramBoolean, true);
      AppMethodBeat.o(261849);
      return localView;
    }
    View localView = c(0, getChildCount(), paramBoolean, true);
    AppMethodBeat.o(261849);
    return localView;
  }
  
  private View as(boolean paramBoolean)
  {
    AppMethodBeat.i(261850);
    if (this.aiW)
    {
      localView = c(0, getChildCount(), paramBoolean, true);
      AppMethodBeat.o(261850);
      return localView;
    }
    View localView = c(getChildCount() - 1, -1, paramBoolean, true);
    AppMethodBeat.o(261850);
    return localView;
  }
  
  private void as(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261770);
    this.aiS.aiL = (this.aiT.kU() - paramInt2);
    c localc = this.aiS;
    if (this.aiW) {}
    for (int i = -1;; i = 1)
    {
      localc.aiN = i;
      this.aiS.aiM = paramInt1;
      this.aiS.mLayoutDirection = 1;
      this.aiS.zP = paramInt2;
      this.aiS.ajl = -2147483648;
      AppMethodBeat.o(261770);
      return;
    }
  }
  
  private void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261772);
    this.aiS.aiL = (paramInt2 - this.aiT.kT());
    this.aiS.aiM = paramInt1;
    c localc = this.aiS;
    if (this.aiW) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.aiN = paramInt1;
      this.aiS.mLayoutDirection = -1;
      this.aiS.zP = paramInt2;
      this.aiS.ajl = -2147483648;
      AppMethodBeat.o(261772);
      return;
    }
  }
  
  private View av(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261864);
    kD();
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (i == 0)
    {
      localView = getChildAt(paramInt1);
      AppMethodBeat.o(261864);
      return localView;
      if (paramInt2 < paramInt1) {
        i = -1;
      } else {
        i = 0;
      }
    }
    int j;
    if (this.aiT.aZ(getChildAt(paramInt1)) < this.aiT.kT()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      localView = this.mHorizontalBoundCheck.j(paramInt1, paramInt2, j, i);
      AppMethodBeat.o(261864);
      return localView;
      j = 4161;
    }
    View localView = this.mVerticalBoundCheck.j(paramInt1, paramInt2, j, i);
    AppMethodBeat.o(261864);
    return localView;
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(261767);
    int i = paramInt - this.aiT.kT();
    if (i > 0)
    {
      i = -a(i, paramn, params);
      if (paramBoolean)
      {
        paramInt = paramInt + i - this.aiT.kT();
        if (paramInt > 0)
        {
          this.aiT.cG(-paramInt);
          AppMethodBeat.o(261767);
          return i - paramInt;
        }
      }
    }
    else
    {
      AppMethodBeat.o(261767);
      return 0;
    }
    AppMethodBeat.o(261767);
    return i;
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(261771);
    at(parama.mPosition, parama.ajg);
    AppMethodBeat.o(261771);
  }
  
  private int c(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(261808);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(261808);
      return 0;
    }
    kD();
    u localu = this.aiT;
    View localView;
    if (!this.aiY)
    {
      bool1 = true;
      localView = ar(bool1);
      if (this.aiY) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = x.a(params, localu, localView, as(bool1), this, this.aiY, this.aiW);
      AppMethodBeat.o(261808);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    AppMethodBeat.i(261863);
    kD();
    int i;
    if (paramBoolean1)
    {
      i = 24579;
      if (!paramBoolean2) {
        break label92;
      }
    }
    for (;;)
    {
      if (this.mOrientation == 0)
      {
        localView = this.mHorizontalBoundCheck.j(paramInt1, paramInt2, i, j);
        AppMethodBeat.o(261863);
        return localView;
        i = 320;
        break;
      }
      View localView = this.mVerticalBoundCheck.j(paramInt1, paramInt2, i, j);
      AppMethodBeat.o(261863);
      return localView;
      label92:
      j = 0;
    }
  }
  
  private int d(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(261810);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(261810);
      return 0;
    }
    kD();
    u localu = this.aiT;
    View localView;
    if (!this.aiY)
    {
      bool1 = true;
      localView = ar(bool1);
      if (this.aiY) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = x.a(params, localu, localView, as(bool1), this, this.aiY);
      AppMethodBeat.o(261810);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private int e(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(261812);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(261812);
      return 0;
    }
    kD();
    u localu = this.aiT;
    View localView;
    if (!this.aiY)
    {
      bool1 = true;
      localView = ar(bool1);
      if (this.aiY) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = x.b(params, localu, localView, as(bool1), this, this.aiY);
      AppMethodBeat.o(261812);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private void kC()
  {
    boolean bool = true;
    AppMethodBeat.i(261731);
    if ((this.mOrientation == 1) || (!kp())) {
      bool = this.aiV;
    }
    for (;;)
    {
      this.aiW = bool;
      AppMethodBeat.o(261731);
      return;
      if (this.aiV) {
        bool = false;
      }
    }
  }
  
  private boolean kE()
  {
    AppMethodBeat.i(261820);
    if ((this.aiT.getMode() == 0) && (this.aiT.getEnd() == 0))
    {
      AppMethodBeat.o(261820);
      return true;
    }
    AppMethodBeat.o(261820);
    return false;
  }
  
  private View kF()
  {
    AppMethodBeat.i(261846);
    if (this.aiW) {}
    for (int i = getChildCount() - 1;; i = 0)
    {
      View localView = getChildAt(i);
      AppMethodBeat.o(261846);
      return localView;
    }
  }
  
  private View kG()
  {
    AppMethodBeat.i(261848);
    if (this.aiW) {}
    for (int i = 0;; i = getChildCount() - 1)
    {
      View localView = getChildAt(i);
      AppMethodBeat.o(261848);
      return localView;
    }
  }
  
  private View kH()
  {
    AppMethodBeat.i(261854);
    View localView = av(0, getChildCount());
    AppMethodBeat.o(261854);
    return localView;
  }
  
  private View kI()
  {
    AppMethodBeat.i(261855);
    View localView = av(getChildCount() - 1, -1);
    AppMethodBeat.o(261855);
    return localView;
  }
  
  View a(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(261853);
    kD();
    int j = this.aiT.kT();
    int k = this.aiT.kU();
    int i;
    label41:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramn = null;
      params = null;
      if (paramInt1 == paramInt2) {
        break label159;
      }
      localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      if ((m < 0) || (m >= paramInt3)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).aiC.isRemoved()) {
        break label112;
      }
      if (params != null) {
        break label179;
      }
      params = localView;
    }
    label159:
    label179:
    for (;;)
    {
      paramInt1 += i;
      break label41;
      i = -1;
      break;
      label112:
      if ((this.aiT.aZ(localView) >= k) || (this.aiT.ba(localView) < j))
      {
        if (paramn == null) {
          paramn = localView;
        }
      }
      else
      {
        AppMethodBeat.o(261853);
        return localView;
        if (paramn != null)
        {
          AppMethodBeat.o(261853);
          return paramn;
        }
        AppMethodBeat.o(261853);
        return params;
      }
    }
  }
  
  void a(RecyclerView.n paramn, RecyclerView.s params, a parama, int paramInt) {}
  
  void a(RecyclerView.n paramn, RecyclerView.s params, c paramc, b paramb)
  {
    AppMethodBeat.i(261841);
    paramn = paramc.a(paramn);
    if (paramn == null)
    {
      paramb.mFinished = true;
      AppMethodBeat.o(261841);
      return;
    }
    params = (RecyclerView.LayoutParams)paramn.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label73:
    int j;
    int i;
    label132:
    int m;
    int k;
    if (paramc.ajp == null)
    {
      bool2 = this.aiW;
      if (paramc.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label219;
        }
        addView(paramn);
        measureChildWithMargins(paramn, 0, 0);
        paramb.ajj = this.aiT.bd(paramn);
        if (this.mOrientation != 1) {
          break label322;
        }
        if (!kp()) {
          break label275;
        }
        j = getWidth() - getPaddingRight();
        i = j - this.aiT.be(paramn);
        if (paramc.mLayoutDirection != -1) {
          break label297;
        }
        m = paramc.zP;
        k = paramc.zP - paramb.ajj;
      }
    }
    for (;;)
    {
      layoutDecoratedWithMargins(paramn, i, k, j, m);
      if ((params.aiC.isRemoved()) || (params.aiC.mt())) {
        paramb.ajk = true;
      }
      paramb.jO = paramn.hasFocusable();
      AppMethodBeat.o(261841);
      return;
      bool1 = false;
      break;
      label219:
      addView(paramn, 0);
      break label73;
      bool2 = this.aiW;
      if (paramc.mLayoutDirection == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label266;
        }
        addDisappearingView(paramn);
        break;
      }
      label266:
      addDisappearingView(paramn, 0);
      break label73;
      label275:
      i = getPaddingLeft();
      j = this.aiT.be(paramn) + i;
      break label132;
      label297:
      k = paramc.zP;
      m = paramc.zP;
      m = paramb.ajj + m;
      continue;
      label322:
      k = getPaddingTop();
      m = k + this.aiT.be(paramn);
      if (paramc.mLayoutDirection == -1)
      {
        j = paramc.zP;
        i = paramc.zP - paramb.ajj;
      }
      else
      {
        i = paramc.zP;
        j = paramc.zP;
        j = paramb.ajj + j;
      }
    }
  }
  
  void a(RecyclerView.s params, c paramc, RecyclerView.LayoutManager.a parama)
  {
    AppMethodBeat.i(261822);
    int i = paramc.aiM;
    if ((i >= 0) && (i < params.getItemCount())) {
      parama.ak(i, Math.max(0, paramc.ajl));
    }
    AppMethodBeat.o(261822);
  }
  
  public void ap(boolean paramBoolean)
  {
    AppMethodBeat.i(261726);
    assertNotInLayoutOrScroll(null);
    if (this.aiX == paramBoolean)
    {
      AppMethodBeat.o(261726);
      return;
    }
    this.aiX = paramBoolean;
    requestLayout();
    AppMethodBeat.o(261726);
  }
  
  public void aq(boolean paramBoolean)
  {
    AppMethodBeat.i(261734);
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.aiV)
    {
      AppMethodBeat.o(261734);
      return;
    }
    this.aiV = paramBoolean;
    requestLayout();
    AppMethodBeat.o(261734);
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(261831);
    if (this.ajc == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
    AppMethodBeat.o(261831);
  }
  
  public void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261776);
    this.aiZ = paramInt1;
    this.aja = paramInt2;
    if (this.ajc != null) {
      this.ajc.ajq = -1;
    }
    requestLayout();
    AppMethodBeat.o(261776);
  }
  
  protected int b(RecyclerView.s params)
  {
    AppMethodBeat.i(261739);
    if (params.alG != -1) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = this.aiT.kV();
      AppMethodBeat.o(261739);
      return i;
    }
    AppMethodBeat.o(261739);
    return 0;
  }
  
  public final PointF cB(int paramInt)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(261745);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(261745);
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.aiW) {
      paramInt = -1;
    }
    if (this.mOrientation == 0)
    {
      localPointF = new PointF(paramInt, 0.0F);
      AppMethodBeat.o(261745);
      return localPointF;
    }
    PointF localPointF = new PointF(0.0F, paramInt);
    AppMethodBeat.o(261745);
    return localPointF;
  }
  
  public final void cC(int paramInt)
  {
    this.ajf = paramInt;
  }
  
  final int cD(int paramInt)
  {
    AppMethodBeat.i(261845);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(261845);
      return -2147483648;
    case 1: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(261845);
        return -1;
      }
      if (kp())
      {
        AppMethodBeat.o(261845);
        return 1;
      }
      AppMethodBeat.o(261845);
      return -1;
    case 2: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(261845);
        return 1;
      }
      if (kp())
      {
        AppMethodBeat.o(261845);
        return -1;
      }
      AppMethodBeat.o(261845);
      return 1;
    case 33: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(261845);
        return -1;
      }
      AppMethodBeat.o(261845);
      return -2147483648;
    case 130: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(261845);
        return 1;
      }
      AppMethodBeat.o(261845);
      return -2147483648;
    case 17: 
      if (this.mOrientation == 0)
      {
        AppMethodBeat.o(261845);
        return -1;
      }
      AppMethodBeat.o(261845);
      return -2147483648;
    }
    if (this.mOrientation == 0)
    {
      AppMethodBeat.o(261845);
      return 1;
    }
    AppMethodBeat.o(261845);
    return -2147483648;
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.LayoutManager.a parama)
  {
    AppMethodBeat.i(261829);
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      AppMethodBeat.o(261829);
      return;
      paramInt1 = paramInt2;
    }
    kD();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, params);
      a(params, this.aiS, parama);
      AppMethodBeat.o(261829);
      return;
    }
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.a parama)
  {
    AppMethodBeat.i(261824);
    boolean bool;
    int i;
    if ((this.ajc != null) && (this.ajc.kP()))
    {
      bool = this.ajc.ajs;
      i = this.ajc.ajq;
      if (!bool) {
        break label142;
      }
    }
    label142:
    for (int j = -1;; j = 1)
    {
      int m = 0;
      int k = i;
      i = m;
      while ((i < this.ajf) && (k >= 0) && (k < paramInt))
      {
        parama.ak(k, 0);
        k += j;
        i += 1;
      }
      kC();
      bool = this.aiW;
      if (this.aiZ == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.aiZ;
      break;
    }
    AppMethodBeat.o(261824);
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(261792);
    int i = d(params);
    AppMethodBeat.o(261792);
    return i;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(261787);
    int i = c(params);
    AppMethodBeat.o(261787);
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(261799);
    int i = e(params);
    AppMethodBeat.o(261799);
    return i;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(261796);
    int i = d(params);
    AppMethodBeat.o(261796);
    return i;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(261789);
    int i = c(params);
    AppMethodBeat.o(261789);
    return i;
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(261802);
    int i = e(params);
    AppMethodBeat.o(261802);
    return i;
  }
  
  public final void d(View paramView1, View paramView2)
  {
    AppMethodBeat.i(261868);
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    kD();
    kC();
    int i = getPosition(paramView1);
    int j = getPosition(paramView2);
    if (i < j) {
      i = 1;
    }
    while (this.aiW) {
      if (i == 1)
      {
        au(j, this.aiT.kU() - (this.aiT.aZ(paramView2) + this.aiT.bd(paramView1)));
        AppMethodBeat.o(261868);
        return;
        i = -1;
      }
      else
      {
        au(j, this.aiT.kU() - this.aiT.ba(paramView2));
        AppMethodBeat.o(261868);
        return;
      }
    }
    if (i == -1)
    {
      au(j, this.aiT.aZ(paramView2));
      AppMethodBeat.o(261868);
      return;
    }
    au(j, this.aiT.ba(paramView2) - this.aiT.bd(paramView1));
    AppMethodBeat.o(261868);
  }
  
  public View findViewByPosition(int paramInt)
  {
    AppMethodBeat.i(261737);
    int i = getChildCount();
    if (i == 0)
    {
      AppMethodBeat.o(261737);
      return null;
    }
    int j = paramInt - getPosition(getChildAt(0));
    if ((j >= 0) && (j < i))
    {
      localView = getChildAt(j);
      if (getPosition(localView) == paramInt)
      {
        AppMethodBeat.o(261737);
        return localView;
      }
    }
    View localView = super.findViewByPosition(paramInt);
    AppMethodBeat.o(261737);
    return localView;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(261707);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(261707);
    return localLayoutParams;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  protected void kD()
  {
    AppMethodBeat.i(261774);
    if (this.aiS == null) {
      this.aiS = new c();
    }
    AppMethodBeat.o(261774);
  }
  
  public final int kJ()
  {
    AppMethodBeat.i(261857);
    View localView = c(0, getChildCount(), false, true);
    if (localView == null)
    {
      AppMethodBeat.o(261857);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(261857);
    return i;
  }
  
  public final int kK()
  {
    AppMethodBeat.i(261859);
    View localView = c(0, getChildCount(), true, false);
    if (localView == null)
    {
      AppMethodBeat.o(261859);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(261859);
    return i;
  }
  
  public final int kL()
  {
    AppMethodBeat.i(261860);
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null)
    {
      AppMethodBeat.o(261860);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(261860);
    return i;
  }
  
  public final int kM()
  {
    AppMethodBeat.i(261861);
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null)
    {
      AppMethodBeat.o(261861);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(261861);
    return i;
  }
  
  protected final boolean kp()
  {
    AppMethodBeat.i(261773);
    if (getLayoutDirection() == 1)
    {
      AppMethodBeat.o(261773);
      return true;
    }
    AppMethodBeat.o(261773);
    return false;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(261709);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.ajb)
    {
      removeAndRecycleAllViews(paramn);
      paramn.clear();
    }
    AppMethodBeat.o(261709);
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261867);
    kC();
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(261867);
      return null;
    }
    paramInt = cD(paramInt);
    if (paramInt == -2147483648)
    {
      AppMethodBeat.o(261867);
      return null;
    }
    kD();
    kD();
    a(paramInt, (int)(0.3333333F * this.aiT.kV()), false, params);
    this.aiS.ajl = -2147483648;
    this.aiS.aiK = false;
    a(paramn, this.aiS, params, true);
    if (paramInt == -1) {
      if (this.aiW)
      {
        paramView = kI();
        if (paramInt != -1) {
          break label181;
        }
        paramn = kF();
      }
    }
    for (;;)
    {
      if (paramn.hasFocusable())
      {
        if (paramView == null)
        {
          AppMethodBeat.o(261867);
          return null;
          paramView = kH();
          break;
          if (this.aiW) {}
          for (paramView = kH();; paramView = kI()) {
            break;
          }
          label181:
          paramn = kG();
          continue;
        }
        AppMethodBeat.o(261867);
        return paramn;
      }
    }
    AppMethodBeat.o(261867);
    return paramView;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(261711);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(kJ());
      paramAccessibilityEvent.setToIndex(kL());
    }
    AppMethodBeat.o(261711);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261757);
    if (((this.ajc != null) || (this.aiZ != -1)) && (params.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      AppMethodBeat.o(261757);
      return;
    }
    if ((this.ajc != null) && (this.ajc.kP())) {
      this.aiZ = this.ajc.ajq;
    }
    kD();
    this.aiS.aiK = false;
    kC();
    Object localObject1 = getFocusedChild();
    Object localObject2;
    int i;
    label232:
    label251:
    int j;
    label274:
    label288:
    label307:
    int m;
    int n;
    int k;
    if ((!this.ajd.aji) || (this.aiZ != -1) || (this.ajc != null))
    {
      this.ajd.reset();
      this.ajd.ajh = (this.aiW ^ this.aiX);
      localObject2 = this.ajd;
      if ((params.alW) || (this.aiZ == -1))
      {
        i = 0;
        if (i == 0)
        {
          if (getChildCount() == 0) {
            break label1458;
          }
          localObject1 = getFocusedChild();
          if (localObject1 == null) {
            break label1267;
          }
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
          if ((localLayoutParams.aiC.isRemoved()) || (localLayoutParams.aiC.mc() < 0) || (localLayoutParams.aiC.mc() >= params.getItemCount())) {
            break label1262;
          }
          i = 1;
          if (i == 0) {
            break label1267;
          }
          ((a)localObject2).C((View)localObject1, getPosition((View)localObject1));
          i = 1;
          if (i == 0)
          {
            ((a)localObject2).kN();
            if (!this.aiX) {
              break label1463;
            }
            i = params.getItemCount() - 1;
            ((a)localObject2).mPosition = i;
          }
        }
        this.ajd.aji = true;
        i = b(params);
        if (this.aiS.ajo < 0) {
          break label1529;
        }
        j = 0;
        m = this.aiT.kT() + j;
        n = i + this.aiT.kW();
        j = n;
        k = m;
        if (params.alW)
        {
          j = n;
          k = m;
          if (this.aiZ != -1)
          {
            j = n;
            k = m;
            if (this.aja != -2147483648)
            {
              localObject1 = findViewByPosition(this.aiZ);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.aiW) {
                  break label1541;
                }
                i = this.aiT.kU() - this.aiT.ba((View)localObject1) - this.aja;
                label431:
                if (i <= 0) {
                  break label1573;
                }
                k = m + i;
                j = n;
              }
            }
          }
        }
        label445:
        if (!this.ajd.ajh) {
          break label1591;
        }
        if (!this.aiW) {
          break label1586;
        }
        i = 1;
        label464:
        a(paramn, params, this.ajd, i);
        detachAndScrapAttachedViews(paramn);
        this.aiS.aiR = kE();
        this.aiS.ajn = params.alW;
        if (!this.ajd.ajh) {
          break label1608;
        }
        b(this.ajd);
        this.aiS.ajm = k;
        a(paramn, this.aiS, params, false);
        k = this.aiS.zP;
        m = this.aiS.aiM;
        i = j;
        if (this.aiS.aiL > 0) {
          i = j + this.aiS.aiL;
        }
        a(this.ajd);
        this.aiS.ajm = i;
        localObject1 = this.aiS;
        ((c)localObject1).aiM += this.aiS.aiN;
        a(paramn, this.aiS, params, false);
        i = this.aiS.zP;
        if (this.aiS.aiL <= 0) {
          break label2197;
        }
        j = this.aiS.aiL;
        at(m, k);
        this.aiS.ajm = j;
        a(paramn, this.aiS, params, false);
        j = this.aiS.zP;
      }
    }
    for (;;)
    {
      label700:
      if (getChildCount() > 0) {
        if ((this.aiW ^ this.aiX))
        {
          k = a(i, paramn, params, true);
          j += k;
          m = b(j, paramn, params, false);
          k = i + k + m;
          m = j + m;
        }
      }
      for (;;)
      {
        label811:
        boolean bool;
        if ((!params.ama) || (getChildCount() == 0) || (params.alW) || (!supportsPredictiveItemAnimations()))
        {
          if (params.alW) {
            break label2154;
          }
          paramn = this.aiT;
          paramn.ajE = paramn.kV();
          this.aiU = this.aiX;
          AppMethodBeat.o(261757);
          return;
          if ((this.aiZ < 0) || (this.aiZ >= params.getItemCount()))
          {
            this.aiZ = -1;
            this.aja = -2147483648;
            i = 0;
            break;
          }
          ((a)localObject2).mPosition = this.aiZ;
          if ((this.ajc != null) && (this.ajc.kP()))
          {
            ((a)localObject2).ajh = this.ajc.ajs;
            if (((a)localObject2).ajh) {}
            for (((a)localObject2).ajg = (this.aiT.kU() - this.ajc.ajr);; ((a)localObject2).ajg = (this.aiT.kT() + this.ajc.ajr))
            {
              i = 1;
              break;
            }
          }
          if (this.aja == -2147483648)
          {
            localObject1 = findViewByPosition(this.aiZ);
            if (localObject1 != null) {
              if (this.aiT.bd((View)localObject1) > this.aiT.kV()) {
                ((a)localObject2).kN();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.aiT.aZ((View)localObject1) - this.aiT.kT() < 0)
            {
              ((a)localObject2).ajg = this.aiT.kT();
              ((a)localObject2).ajh = false;
            }
            else if (this.aiT.kU() - this.aiT.ba((View)localObject1) < 0)
            {
              ((a)localObject2).ajg = this.aiT.kU();
              ((a)localObject2).ajh = true;
            }
            else
            {
              if (((a)localObject2).ajh) {}
              for (i = this.aiT.ba((View)localObject1) + this.aiT.kS();; i = this.aiT.aZ((View)localObject1))
              {
                ((a)localObject2).ajg = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = getPosition(getChildAt(0));
                if (this.aiZ >= i) {
                  break label1194;
                }
                bool = true;
                label1167:
                if (bool != this.aiW) {
                  break label1200;
                }
              }
              label1194:
              label1200:
              for (bool = true;; bool = false)
              {
                ((a)localObject2).ajh = bool;
                ((a)localObject2).kN();
                break;
                bool = false;
                break label1167;
              }
              ((a)localObject2).ajh = this.aiW;
              if (this.aiW) {
                ((a)localObject2).ajg = (this.aiT.kU() - this.aja);
              } else {
                ((a)localObject2).ajg = (this.aiT.kT() + this.aja);
              }
            }
          }
          label1262:
          i = 0;
          break label232;
          label1267:
          if (this.aiU == this.aiX)
          {
            if (((a)localObject2).ajh)
            {
              if (this.aiW) {
                break label1422;
              }
              localObject1 = a(paramn, params);
              if (localObject1 == null) {
                break label1458;
              }
              ((a)localObject2).D((View)localObject1, getPosition((View)localObject1));
              if ((!params.alW) && (supportsPredictiveItemAnimations()))
              {
                if ((this.aiT.aZ((View)localObject1) < this.aiT.kU()) && (this.aiT.ba((View)localObject1) >= this.aiT.kT())) {
                  break label1442;
                }
                i = 1;
                if (i != 0) {
                  if (!((a)localObject2).ajh) {
                    break label1447;
                  }
                }
              }
            }
            for (i = this.aiT.kU();; i = this.aiT.kT())
            {
              ((a)localObject2).ajg = i;
              i = 1;
              break;
              if (this.aiW)
              {
                localObject1 = a(paramn, params);
                break label1301;
              }
              localObject1 = a(paramn, params, 0, getChildCount(), params.getItemCount());
              break label1301;
              i = 0;
              break label1373;
            }
          }
          label1301:
          label1373:
          i = 0;
          label1422:
          label1442:
          label1447:
          label1458:
          break label251;
          label1463:
          i = 0;
          break label274;
          if ((localObject1 == null) || ((this.aiT.aZ((View)localObject1) < this.aiT.kU()) && (this.aiT.ba((View)localObject1) > this.aiT.kT()))) {
            break label288;
          }
          this.ajd.C((View)localObject1, getPosition((View)localObject1));
          break label288;
          label1529:
          k = 0;
          j = i;
          i = k;
          break label307;
          label1541:
          i = this.aiT.aZ((View)localObject1);
          j = this.aiT.kT();
          i = this.aja - (i - j);
          break label431;
          label1573:
          j = n - i;
          k = m;
          break label445;
          label1586:
          i = -1;
          break label464;
          label1591:
          if (this.aiW)
          {
            i = -1;
            break label464;
          }
          i = 1;
          break label464;
          label1608:
          a(this.ajd);
          this.aiS.ajm = j;
          a(paramn, this.aiS, params, false);
          j = this.aiS.zP;
          m = this.aiS.aiM;
          i = k;
          if (this.aiS.aiL > 0) {
            i = k + this.aiS.aiL;
          }
          b(this.ajd);
          this.aiS.ajm = i;
          localObject1 = this.aiS;
          ((c)localObject1).aiM += this.aiS.aiN;
          a(paramn, this.aiS, params, false);
          k = this.aiS.zP;
          if (this.aiS.aiL <= 0) {
            break label2187;
          }
          i = this.aiS.aiL;
          as(m, j);
          this.aiS.ajm = i;
          a(paramn, this.aiS, params, false);
          i = this.aiS.zP;
          j = k;
          break label700;
          m = b(j, paramn, params, true);
          k = i + m;
          i = a(k, paramn, params, false);
          k += i;
          m = j + m + i;
          continue;
        }
        j = 0;
        i = 0;
        localObject1 = paramn.alA;
        int i2 = ((List)localObject1).size();
        int i3 = getPosition(getChildAt(0));
        n = 0;
        label1880:
        int i1;
        if (n < i2)
        {
          localObject2 = (RecyclerView.v)((List)localObject1).get(n);
          if (((RecyclerView.v)localObject2).isRemoved()) {
            break label2164;
          }
          if (((RecyclerView.v)localObject2).mc() < i3)
          {
            bool = true;
            label1922:
            if (bool == this.aiW) {
              break label1992;
            }
            i1 = -1;
            label1934:
            if (i1 != -1) {
              break label1998;
            }
            i1 = this.aiT.bd(((RecyclerView.v)localObject2).amk) + j;
            j = i;
            i = i1;
          }
        }
        for (;;)
        {
          i1 = n + 1;
          n = j;
          j = i;
          i = n;
          n = i1;
          break label1880;
          bool = false;
          break label1922;
          label1992:
          i1 = 1;
          break label1934;
          label1998:
          i1 = i + this.aiT.bd(((RecyclerView.v)localObject2).amk);
          i = j;
          j = i1;
          continue;
          this.aiS.ajp = ((List)localObject1);
          if (j > 0)
          {
            at(getPosition(kF()), m);
            this.aiS.ajm = j;
            this.aiS.aiL = 0;
            this.aiS.aX(null);
            a(paramn, this.aiS, params, false);
          }
          if (i > 0)
          {
            as(getPosition(kG()), k);
            this.aiS.ajm = i;
            this.aiS.aiL = 0;
            this.aiS.aX(null);
            a(paramn, this.aiS, params, false);
          }
          this.aiS.ajp = null;
          break;
          label2154:
          this.ajd.reset();
          break label811;
          label2164:
          i1 = i;
          i = j;
          j = i1;
        }
        k = i;
        m = j;
      }
      label2187:
      i = j;
      j = k;
      continue;
      label2197:
      j = k;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(261759);
    super.onLayoutCompleted(params);
    this.ajc = null;
    this.aiZ = -1;
    this.aja = -2147483648;
    this.ajd.reset();
    AppMethodBeat.o(261759);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(261716);
    if ((paramParcelable instanceof SavedState))
    {
      this.ajc = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(261716);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(261714);
    if (this.ajc != null)
    {
      localSavedState = new SavedState(this.ajc);
      AppMethodBeat.o(261714);
      return localSavedState;
    }
    SavedState localSavedState = new SavedState();
    View localView;
    if (getChildCount() > 0)
    {
      kD();
      boolean bool = this.aiU ^ this.aiW;
      localSavedState.ajs = bool;
      if (bool)
      {
        localView = kG();
        localSavedState.ajr = (this.aiT.kU() - this.aiT.ba(localView));
        localSavedState.ajq = getPosition(localView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(261714);
      return localSavedState;
      localView = kF();
      localSavedState.ajq = getPosition(localView);
      localSavedState.ajr = (this.aiT.aZ(localView) - this.aiT.kT());
      continue;
      localSavedState.ajq = -1;
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261779);
    if (this.mOrientation == 1)
    {
      AppMethodBeat.o(261779);
      return 0;
    }
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(261779);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(261775);
    this.aiZ = paramInt;
    this.aja = -2147483648;
    if (this.ajc != null) {
      this.ajc.ajq = -1;
    }
    requestLayout();
    AppMethodBeat.o(261775);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(261782);
    if (this.mOrientation == 0)
    {
      AppMethodBeat.o(261782);
      return 0;
    }
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(261782);
    return paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(261729);
    if ((paramInt != 0) && (paramInt != 1))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(261729);
      throw localIllegalArgumentException;
    }
    assertNotInLayoutOrScroll(null);
    if ((paramInt != this.mOrientation) || (this.aiT == null))
    {
      this.aiT = u.a(this, paramInt);
      this.ajd.aiT = this.aiT;
      this.mOrientation = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(261729);
  }
  
  boolean shouldMeasureTwice()
  {
    AppMethodBeat.i(261844);
    if ((getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations()))
    {
      AppMethodBeat.o(261844);
      return true;
    }
    AppMethodBeat.o(261844);
    return false;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(261742);
    paramRecyclerView = new p(paramRecyclerView.getContext());
    paramRecyclerView.alG = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(261742);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.ajc == null) && (this.aiU == this.aiX);
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int ajq;
    int ajr;
    boolean ajs;
    
    static
    {
      AppMethodBeat.i(261641);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(261641);
    }
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(261629);
      this.ajq = paramParcel.readInt();
      this.ajr = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ajs = bool;
        AppMethodBeat.o(261629);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.ajq = paramSavedState.ajq;
      this.ajr = paramSavedState.ajr;
      this.ajs = paramSavedState.ajs;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final boolean kP()
    {
      return this.ajq >= 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(261638);
      paramParcel.writeInt(this.ajq);
      paramParcel.writeInt(this.ajr);
      if (this.ajs) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(261638);
        return;
      }
    }
  }
  
  static final class a
  {
    u aiT;
    int ajg;
    boolean ajh;
    boolean aji;
    int mPosition;
    
    a()
    {
      AppMethodBeat.i(261562);
      reset();
      AppMethodBeat.o(261562);
    }
    
    public final void C(View paramView, int paramInt)
    {
      AppMethodBeat.i(261568);
      int i = this.aiT.kS();
      if (i >= 0)
      {
        D(paramView, paramInt);
        AppMethodBeat.o(261568);
        return;
      }
      this.mPosition = paramInt;
      int k;
      if (this.ajh)
      {
        paramInt = this.aiT.kU() - i - this.aiT.ba(paramView);
        this.ajg = (this.aiT.kU() - paramInt);
        if (paramInt > 0)
        {
          i = this.aiT.bd(paramView);
          j = this.ajg;
          k = this.aiT.kT();
          i = j - i - (k + Math.min(this.aiT.aZ(paramView) - k, 0));
          if (i < 0)
          {
            j = this.ajg;
            this.ajg = (Math.min(paramInt, -i) + j);
          }
        }
        AppMethodBeat.o(261568);
        return;
      }
      int j = this.aiT.aZ(paramView);
      paramInt = j - this.aiT.kT();
      this.ajg = j;
      if (paramInt > 0)
      {
        k = this.aiT.bd(paramView);
        int m = this.aiT.kU();
        int n = this.aiT.ba(paramView);
        i = this.aiT.kU() - Math.min(0, m - i - n) - (j + k);
        if (i < 0) {
          this.ajg -= Math.min(paramInt, -i);
        }
      }
      AppMethodBeat.o(261568);
    }
    
    public final void D(View paramView, int paramInt)
    {
      AppMethodBeat.i(261570);
      if (this.ajh) {}
      for (this.ajg = (this.aiT.ba(paramView) + this.aiT.kS());; this.ajg = this.aiT.aZ(paramView))
      {
        this.mPosition = paramInt;
        AppMethodBeat.o(261570);
        return;
      }
    }
    
    final void kN()
    {
      AppMethodBeat.i(261563);
      if (this.ajh) {}
      for (int i = this.aiT.kU();; i = this.aiT.kT())
      {
        this.ajg = i;
        AppMethodBeat.o(261563);
        return;
      }
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.ajg = -2147483648;
      this.ajh = false;
      this.aji = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(261565);
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.ajg + ", mLayoutFromEnd=" + this.ajh + ", mValid=" + this.aji + '}';
      AppMethodBeat.o(261565);
      return str;
    }
  }
  
  protected static final class b
  {
    public int ajj;
    public boolean ajk;
    public boolean jO;
    public boolean mFinished;
    
    final void resetInternal()
    {
      this.ajj = 0;
      this.mFinished = false;
      this.ajk = false;
      this.jO = false;
    }
  }
  
  static final class c
  {
    boolean aiK = true;
    int aiL;
    int aiM;
    int aiN;
    boolean aiR;
    int ajl;
    int ajm = 0;
    boolean ajn = false;
    int ajo;
    List<RecyclerView.v> ajp = null;
    int mLayoutDirection;
    int zP;
    
    private View aY(View paramView)
    {
      AppMethodBeat.i(261612);
      int m = this.ajp.size();
      Object localObject = null;
      int i = 2147483647;
      int j = 0;
      if (j < m)
      {
        View localView = ((RecyclerView.v)this.ajp.get(j)).amk;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((localView == paramView) || (localLayoutParams.aiC.isRemoved())) {
          break label137;
        }
        int k = (localLayoutParams.aiC.mc() - this.aiM) * this.aiN;
        if ((k < 0) || (k >= i)) {
          break label137;
        }
        localObject = localView;
        if (k != 0)
        {
          localObject = localView;
          i = k;
        }
      }
      label137:
      for (;;)
      {
        j += 1;
        break;
        AppMethodBeat.o(261612);
        return localObject;
      }
    }
    
    private View kO()
    {
      AppMethodBeat.i(261599);
      int j = this.ajp.size();
      int i = 0;
      while (i < j)
      {
        View localView = ((RecyclerView.v)this.ajp.get(i)).amk;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.aiC.isRemoved()) && (this.aiM == localLayoutParams.aiC.mc()))
        {
          aX(localView);
          AppMethodBeat.o(261599);
          return localView;
        }
        i += 1;
      }
      AppMethodBeat.o(261599);
      return null;
    }
    
    final View a(RecyclerView.n paramn)
    {
      AppMethodBeat.i(261594);
      if (this.ajp != null)
      {
        paramn = kO();
        AppMethodBeat.o(261594);
        return paramn;
      }
      paramn = paramn.cS(this.aiM);
      this.aiM += this.aiN;
      AppMethodBeat.o(261594);
      return paramn;
    }
    
    final boolean a(RecyclerView.s params)
    {
      AppMethodBeat.i(261588);
      if ((this.aiM >= 0) && (this.aiM < params.getItemCount()))
      {
        AppMethodBeat.o(261588);
        return true;
      }
      AppMethodBeat.o(261588);
      return false;
    }
    
    public final void aX(View paramView)
    {
      AppMethodBeat.i(261605);
      paramView = aY(paramView);
      if (paramView == null)
      {
        this.aiM = -1;
        AppMethodBeat.o(261605);
        return;
      }
      this.aiM = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aiC.mc();
      AppMethodBeat.o(261605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */