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
  implements RecyclerView.r.b, k.d
{
  private boolean bXA;
  boolean bXB;
  private boolean bXC;
  private boolean bXD;
  int bXE;
  int bXF;
  private boolean bXG;
  SavedState bXH;
  final a bXI;
  private final b bXJ;
  public int bXK;
  private c bXx;
  s bXy;
  private boolean bXz;
  int mOrientation;
  
  public LinearLayoutManager()
  {
    this(1, false);
  }
  
  public LinearLayoutManager(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194650);
    this.mOrientation = 1;
    this.bXA = false;
    this.bXB = false;
    this.bXC = false;
    this.bXD = true;
    this.bXE = -1;
    this.bXF = -2147483648;
    this.bXH = null;
    this.bXI = new a();
    this.bXJ = new b();
    this.bXK = 2;
    setOrientation(paramInt);
    aZ(false);
    AppMethodBeat.o(194650);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194664);
    this.mOrientation = 1;
    this.bXA = false;
    this.bXB = false;
    this.bXC = false;
    this.bXD = true;
    this.bXE = -1;
    this.bXF = -2147483648;
    this.bXH = null;
    this.bXI = new a();
    this.bXJ = new b();
    this.bXK = 2;
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    aZ(paramContext.agn);
    aY(paramContext.bZO);
    AppMethodBeat.o(194664);
  }
  
  private void Jn()
  {
    boolean bool = true;
    AppMethodBeat.i(194671);
    if ((this.mOrientation == 1) || (!Ja())) {
      bool = this.bXA;
    }
    for (;;)
    {
      this.bXB = bool;
      AppMethodBeat.o(194671);
      return;
      if (this.bXA) {
        bool = false;
      }
    }
  }
  
  private boolean Jp()
  {
    AppMethodBeat.i(194774);
    if ((this.bXy.getMode() == 0) && (this.bXy.getEnd() == 0))
    {
      AppMethodBeat.o(194774);
      return true;
    }
    AppMethodBeat.o(194774);
    return false;
  }
  
  private View Jq()
  {
    AppMethodBeat.i(194829);
    if (this.bXB) {}
    for (int i = getChildCount() - 1;; i = 0)
    {
      View localView = getChildAt(i);
      AppMethodBeat.o(194829);
      return localView;
    }
  }
  
  private View Jr()
  {
    AppMethodBeat.i(194835);
    if (this.bXB) {}
    for (int i = 0;; i = getChildCount() - 1)
    {
      View localView = getChildAt(i);
      AppMethodBeat.o(194835);
      return localView;
    }
  }
  
  private View Js()
  {
    AppMethodBeat.i(194866);
    View localView = bp(0, getChildCount());
    AppMethodBeat.o(194866);
    return localView;
  }
  
  private View Jt()
  {
    AppMethodBeat.i(194874);
    View localView = bp(getChildCount() - 1, -1);
    AppMethodBeat.o(194874);
    return localView;
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(194783);
    if ((getChildCount() == 0) || (paramInt == 0))
    {
      AppMethodBeat.o(194783);
      return 0;
    }
    this.bXx.bXp = true;
    Jo();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, params);
      k = this.bXx.bXP + a(paramn, this.bXx, params, false);
      if (k >= 0) {
        break;
      }
      AppMethodBeat.o(194783);
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.bXy.fQ(-paramInt);
    this.bXx.bXS = paramInt;
    AppMethodBeat.o(194783);
    return paramInt;
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(194681);
    int i = this.bXy.JF() - paramInt;
    if (i > 0)
    {
      i = -a(-i, paramn, params);
      if (paramBoolean)
      {
        paramInt = this.bXy.JF() - (paramInt + i);
        if (paramInt > 0)
        {
          this.bXy.fQ(paramInt);
          AppMethodBeat.o(194681);
          return i + paramInt;
        }
      }
    }
    else
    {
      AppMethodBeat.o(194681);
      return 0;
    }
    AppMethodBeat.o(194681);
    return i;
  }
  
  private int a(RecyclerView.n paramn, c paramc, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(194818);
    int k = paramc.bXq;
    if (paramc.bXP != -2147483648)
    {
      if (paramc.bXq < 0) {
        paramc.bXP += paramc.bXq;
      }
      a(paramn, paramc);
    }
    int i = paramc.bXq + paramc.bXQ;
    b localb = this.bXJ;
    do
    {
      int j;
      do
      {
        if (((!paramc.bXw) && (i <= 0)) || (!paramc.a(params))) {
          break;
        }
        localb.resetInternal();
        a(paramn, params, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.Sc += localb.bXN * paramc.mLayoutDirection;
        if ((localb.bXO) && (this.bXx.bXT == null))
        {
          j = i;
          if (params.caw) {}
        }
        else
        {
          paramc.bXq -= localb.bXN;
          j = i - localb.bXN;
        }
        if (paramc.bXP != -2147483648)
        {
          paramc.bXP += localb.bXN;
          if (paramc.bXq < 0) {
            paramc.bXP += paramc.bXq;
          }
          a(paramn, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.kK);
    i = paramc.bXq;
    AppMethodBeat.o(194818);
    return k - i;
  }
  
  private View a(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(194859);
    paramn = a(paramn, params, getChildCount() - 1, -1, params.getItemCount());
    AppMethodBeat.o(194859);
    return paramn;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.s params)
  {
    int i = -1;
    int j = 1;
    AppMethodBeat.i(194769);
    this.bXx.bXw = Jp();
    this.bXx.bXQ = b(params);
    this.bXx.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      params = this.bXx;
      params.bXQ += this.bXy.JH();
      params = Jr();
      localc = this.bXx;
      if (this.bXB) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.bXs = paramInt1;
        this.bXx.bXr = (getPosition(params) + this.bXx.bXs);
        this.bXx.Sc = this.bXy.bt(params);
        paramInt1 = this.bXy.bt(params) - this.bXy.JF();
        this.bXx.bXq = paramInt2;
        if (paramBoolean)
        {
          params = this.bXx;
          params.bXq -= paramInt1;
        }
        this.bXx.bXP = paramInt1;
        AppMethodBeat.o(194769);
        return;
      }
    }
    params = Jq();
    c localc = this.bXx;
    localc.bXQ += this.bXy.JE();
    localc = this.bXx;
    if (this.bXB) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.bXs = paramInt1;
      this.bXx.bXr = (getPosition(params) + this.bXx.bXs);
      this.bXx.Sc = this.bXy.bs(params);
      paramInt1 = -this.bXy.bs(params) + this.bXy.JE();
      break;
    }
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(194701);
    bm(parama.mPosition, parama.bXL);
    AppMethodBeat.o(194701);
  }
  
  private void a(RecyclerView.n paramn, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194793);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(194793);
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
      AppMethodBeat.o(194793);
      return;
    }
    while (i > paramInt2)
    {
      removeAndRecycleViewAt(i, paramn);
      i -= 1;
    }
    AppMethodBeat.o(194793);
  }
  
  private void a(RecyclerView.n paramn, c paramc)
  {
    AppMethodBeat.i(194806);
    if ((!paramc.bXp) || (paramc.bXw))
    {
      AppMethodBeat.o(194806);
      return;
    }
    int i;
    int k;
    if (paramc.mLayoutDirection == -1)
    {
      i = paramc.bXP;
      j = getChildCount();
      if (i >= 0)
      {
        k = this.bXy.getEnd() - i;
        if (this.bXB)
        {
          i = 0;
          while (i < j)
          {
            paramc = getChildAt(i);
            if ((this.bXy.bs(paramc) < k) || (this.bXy.bv(paramc) < k))
            {
              a(paramn, 0, i);
              AppMethodBeat.o(194806);
              return;
            }
            i += 1;
          }
          AppMethodBeat.o(194806);
          return;
        }
        i = j - 1;
        while (i >= 0)
        {
          paramc = getChildAt(i);
          if ((this.bXy.bs(paramc) < k) || (this.bXy.bv(paramc) < k))
          {
            a(paramn, j - 1, i);
            AppMethodBeat.o(194806);
            return;
          }
          i -= 1;
        }
      }
      AppMethodBeat.o(194806);
      return;
    }
    int j = paramc.bXP;
    if (j >= 0)
    {
      k = getChildCount();
      if (this.bXB)
      {
        i = k - 1;
        while (i >= 0)
        {
          paramc = getChildAt(i);
          if ((this.bXy.bt(paramc) > j) || (this.bXy.bu(paramc) > j))
          {
            a(paramn, k - 1, i);
            AppMethodBeat.o(194806);
            return;
          }
          i -= 1;
        }
        AppMethodBeat.o(194806);
        return;
      }
      i = 0;
      while (i < k)
      {
        paramc = getChildAt(i);
        if ((this.bXy.bt(paramc) > j) || (this.bXy.bu(paramc) > j))
        {
          a(paramn, 0, i);
          AppMethodBeat.o(194806);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(194806);
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(194693);
    int i = paramInt - this.bXy.JE();
    if (i > 0)
    {
      i = -a(i, paramn, params);
      if (paramBoolean)
      {
        paramInt = paramInt + i - this.bXy.JE();
        if (paramInt > 0)
        {
          this.bXy.fQ(-paramInt);
          AppMethodBeat.o(194693);
          return i - paramInt;
        }
      }
    }
    else
    {
      AppMethodBeat.o(194693);
      return 0;
    }
    AppMethodBeat.o(194693);
    return i;
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(194721);
    bn(parama.mPosition, parama.bXL);
    AppMethodBeat.o(194721);
  }
  
  private View ba(boolean paramBoolean)
  {
    AppMethodBeat.i(194844);
    if (this.bXB)
    {
      localView = c(getChildCount() - 1, -1, paramBoolean, true);
      AppMethodBeat.o(194844);
      return localView;
    }
    View localView = c(0, getChildCount(), paramBoolean, true);
    AppMethodBeat.o(194844);
    return localView;
  }
  
  private View bb(boolean paramBoolean)
  {
    AppMethodBeat.i(194851);
    if (this.bXB)
    {
      localView = c(0, getChildCount(), paramBoolean, true);
      AppMethodBeat.o(194851);
      return localView;
    }
    View localView = c(getChildCount() - 1, -1, paramBoolean, true);
    AppMethodBeat.o(194851);
    return localView;
  }
  
  private void bm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194712);
    this.bXx.bXq = (this.bXy.JF() - paramInt2);
    c localc = this.bXx;
    if (this.bXB) {}
    for (int i = -1;; i = 1)
    {
      localc.bXs = i;
      this.bXx.bXr = paramInt1;
      this.bXx.mLayoutDirection = 1;
      this.bXx.Sc = paramInt2;
      this.bXx.bXP = -2147483648;
      AppMethodBeat.o(194712);
      return;
    }
  }
  
  private void bn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194732);
    this.bXx.bXq = (paramInt2 - this.bXy.JE());
    this.bXx.bXr = paramInt1;
    c localc = this.bXx;
    if (this.bXB) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.bXs = paramInt1;
      this.bXx.mLayoutDirection = -1;
      this.bXx.Sc = paramInt2;
      this.bXx.bXP = -2147483648;
      AppMethodBeat.o(194732);
      return;
    }
  }
  
  private View bp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194887);
    Jo();
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (i == 0)
    {
      localView = getChildAt(paramInt1);
      AppMethodBeat.o(194887);
      return localView;
      if (paramInt2 < paramInt1) {
        i = -1;
      } else {
        i = 0;
      }
    }
    int j;
    if (this.bXy.bs(getChildAt(paramInt1)) < this.bXy.JE()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      localView = this.mHorizontalBoundCheck.s(paramInt1, paramInt2, j, i);
      AppMethodBeat.o(194887);
      return localView;
      j = 4161;
    }
    View localView = this.mVerticalBoundCheck.s(paramInt1, paramInt2, j, i);
    AppMethodBeat.o(194887);
    return localView;
  }
  
  private int c(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(194741);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(194741);
      return 0;
    }
    Jo();
    s locals = this.bXy;
    View localView;
    if (!this.bXD)
    {
      bool1 = true;
      localView = ba(bool1);
      if (this.bXD) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = v.a(params, locals, localView, bb(bool1), this, this.bXD, this.bXB);
      AppMethodBeat.o(194741);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    AppMethodBeat.i(194883);
    Jo();
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
        localView = this.mHorizontalBoundCheck.s(paramInt1, paramInt2, i, j);
        AppMethodBeat.o(194883);
        return localView;
        i = 320;
        break;
      }
      View localView = this.mVerticalBoundCheck.s(paramInt1, paramInt2, i, j);
      AppMethodBeat.o(194883);
      return localView;
      label92:
      j = 0;
    }
  }
  
  private int d(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(194750);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(194750);
      return 0;
    }
    Jo();
    s locals = this.bXy;
    View localView;
    if (!this.bXD)
    {
      bool1 = true;
      localView = ba(bool1);
      if (this.bXD) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = v.a(params, locals, localView, bb(bool1), this, this.bXD);
      AppMethodBeat.o(194750);
      return i;
      bool1 = false;
      break;
    }
  }
  
  private int e(RecyclerView.s params)
  {
    boolean bool2 = true;
    AppMethodBeat.i(194761);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(194761);
      return 0;
    }
    Jo();
    s locals = this.bXy;
    View localView;
    if (!this.bXD)
    {
      bool1 = true;
      localView = ba(bool1);
      if (this.bXD) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      int i = v.b(params, locals, localView, bb(bool1), this, this.bXD);
      AppMethodBeat.o(194761);
      return i;
      bool1 = false;
      break;
    }
  }
  
  protected final boolean Ja()
  {
    AppMethodBeat.i(195046);
    if (getLayoutDirection() == 1)
    {
      AppMethodBeat.o(195046);
      return true;
    }
    AppMethodBeat.o(195046);
    return false;
  }
  
  protected void Jo()
  {
    AppMethodBeat.i(195052);
    if (this.bXx == null) {
      this.bXx = new c();
    }
    AppMethodBeat.o(195052);
  }
  
  public final int Ju()
  {
    AppMethodBeat.i(195199);
    View localView = c(0, getChildCount(), false, true);
    if (localView == null)
    {
      AppMethodBeat.o(195199);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(195199);
    return i;
  }
  
  public final int Jv()
  {
    AppMethodBeat.i(195204);
    View localView = c(0, getChildCount(), true, false);
    if (localView == null)
    {
      AppMethodBeat.o(195204);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(195204);
    return i;
  }
  
  public final int Jw()
  {
    AppMethodBeat.i(195210);
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null)
    {
      AppMethodBeat.o(195210);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(195210);
    return i;
  }
  
  public final int Jx()
  {
    AppMethodBeat.i(195217);
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null)
    {
      AppMethodBeat.o(195217);
      return -1;
    }
    int i = getPosition(localView);
    AppMethodBeat.o(195217);
    return i;
  }
  
  View a(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195193);
    Jo();
    int j = this.bXy.JE();
    int k = this.bXy.JF();
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
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).bXh.isRemoved()) {
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
      if ((this.bXy.bs(localView) >= k) || (this.bXy.bt(localView) < j))
      {
        if (paramn == null) {
          paramn = localView;
        }
      }
      else
      {
        AppMethodBeat.o(195193);
        return localView;
        if (paramn != null)
        {
          AppMethodBeat.o(195193);
          return paramn;
        }
        AppMethodBeat.o(195193);
        return params;
      }
    }
  }
  
  void a(RecyclerView.n paramn, RecyclerView.s params, a parama, int paramInt) {}
  
  void a(RecyclerView.n paramn, RecyclerView.s params, c paramc, b paramb)
  {
    AppMethodBeat.i(195168);
    paramn = paramc.a(paramn);
    if (paramn == null)
    {
      paramb.mFinished = true;
      AppMethodBeat.o(195168);
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
    if (paramc.bXT == null)
    {
      bool2 = this.bXB;
      if (paramc.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label219;
        }
        addView(paramn);
        measureChildWithMargins(paramn, 0, 0);
        paramb.bXN = this.bXy.bw(paramn);
        if (this.mOrientation != 1) {
          break label322;
        }
        if (!Ja()) {
          break label275;
        }
        j = getWidth() - getPaddingRight();
        i = j - this.bXy.bx(paramn);
        if (paramc.mLayoutDirection != -1) {
          break label297;
        }
        m = paramc.Sc;
        k = paramc.Sc - paramb.bXN;
      }
    }
    for (;;)
    {
      layoutDecoratedWithMargins(paramn, i, k, j, m);
      if ((params.bXh.isRemoved()) || (params.bXh.KW())) {
        paramb.bXO = true;
      }
      paramb.kK = paramn.hasFocusable();
      AppMethodBeat.o(195168);
      return;
      bool1 = false;
      break;
      label219:
      addView(paramn, 0);
      break label73;
      bool2 = this.bXB;
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
      j = this.bXy.bx(paramn) + i;
      break label132;
      label297:
      k = paramc.Sc;
      m = paramc.Sc;
      m = paramb.bXN + m;
      continue;
      label322:
      k = getPaddingTop();
      m = k + this.bXy.bx(paramn);
      if (paramc.mLayoutDirection == -1)
      {
        j = paramc.Sc;
        i = paramc.Sc - paramb.bXN;
      }
      else
      {
        i = paramc.Sc;
        j = paramc.Sc;
        j = paramb.bXN + j;
      }
    }
  }
  
  void a(RecyclerView.s params, c paramc, RecyclerView.LayoutManager.a parama)
  {
    AppMethodBeat.i(195121);
    int i = paramc.bXr;
    if ((i >= 0) && (i < params.getItemCount())) {
      parama.bd(i, Math.max(0, paramc.bXP));
    }
    AppMethodBeat.o(195121);
  }
  
  public void aY(boolean paramBoolean)
  {
    AppMethodBeat.i(194955);
    assertNotInLayoutOrScroll(null);
    if (this.bXC == paramBoolean)
    {
      AppMethodBeat.o(194955);
      return;
    }
    this.bXC = paramBoolean;
    requestLayout();
    AppMethodBeat.o(194955);
  }
  
  public void aZ(boolean paramBoolean)
  {
    AppMethodBeat.i(194976);
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.bXA)
    {
      AppMethodBeat.o(194976);
      return;
    }
    this.bXA = paramBoolean;
    requestLayout();
    AppMethodBeat.o(194976);
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    AppMethodBeat.i(195151);
    if (this.bXH == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
    AppMethodBeat.o(195151);
  }
  
  protected int b(RecyclerView.s params)
  {
    AppMethodBeat.i(194992);
    if (params.cag != -1) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = this.bXy.JG();
      AppMethodBeat.o(194992);
      return i;
    }
    AppMethodBeat.o(194992);
    return 0;
  }
  
  public void bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195064);
    this.bXE = paramInt1;
    this.bXF = paramInt2;
    if (this.bXH != null) {
      this.bXH.bXU = -1;
    }
    requestLayout();
    AppMethodBeat.o(195064);
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
    AppMethodBeat.i(195138);
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      AppMethodBeat.o(195138);
      return;
      paramInt1 = paramInt2;
    }
    Jo();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, params);
      a(params, this.bXx, parama);
      AppMethodBeat.o(195138);
      return;
    }
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.a parama)
  {
    AppMethodBeat.i(195130);
    boolean bool;
    int i;
    if ((this.bXH != null) && (this.bXH.JA()))
    {
      bool = this.bXH.bXW;
      i = this.bXH.bXU;
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
      while ((i < this.bXK) && (k >= 0) && (k < paramInt))
      {
        parama.bd(k, 0);
        k += j;
        i += 1;
      }
      Jn();
      bool = this.bXB;
      if (this.bXE == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.bXE;
      break;
    }
    AppMethodBeat.o(195130);
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(195093);
    int i = d(params);
    AppMethodBeat.o(195093);
    return i;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(195084);
    int i = c(params);
    AppMethodBeat.o(195084);
    return i;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(195109);
    int i = e(params);
    AppMethodBeat.o(195109);
    return i;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    AppMethodBeat.i(195098);
    int i = d(params);
    AppMethodBeat.o(195098);
    return i;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    AppMethodBeat.i(195089);
    int i = c(params);
    AppMethodBeat.o(195089);
    return i;
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    AppMethodBeat.i(195112);
    int i = e(params);
    AppMethodBeat.o(195112);
    return i;
  }
  
  public final void d(View paramView1, View paramView2)
  {
    AppMethodBeat.i(195238);
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    Jo();
    Jn();
    int i = getPosition(paramView1);
    int j = getPosition(paramView2);
    if (i < j) {
      i = 1;
    }
    while (this.bXB) {
      if (i == 1)
      {
        bo(j, this.bXy.JF() - (this.bXy.bs(paramView2) + this.bXy.bw(paramView1)));
        AppMethodBeat.o(195238);
        return;
        i = -1;
      }
      else
      {
        bo(j, this.bXy.JF() - this.bXy.bt(paramView2));
        AppMethodBeat.o(195238);
        return;
      }
    }
    if (i == -1)
    {
      bo(j, this.bXy.bs(paramView2));
      AppMethodBeat.o(195238);
      return;
    }
    bo(j, this.bXy.bt(paramView2) - this.bXy.bw(paramView1));
    AppMethodBeat.o(195238);
  }
  
  public final PointF fM(int paramInt)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(195005);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(195005);
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.bXB) {
      paramInt = -1;
    }
    if (this.mOrientation == 0)
    {
      localPointF = new PointF(paramInt, 0.0F);
      AppMethodBeat.o(195005);
      return localPointF;
    }
    PointF localPointF = new PointF(0.0F, paramInt);
    AppMethodBeat.o(195005);
    return localPointF;
  }
  
  final int fN(int paramInt)
  {
    AppMethodBeat.i(195186);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(195186);
      return -2147483648;
    case 1: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(195186);
        return -1;
      }
      if (Ja())
      {
        AppMethodBeat.o(195186);
        return 1;
      }
      AppMethodBeat.o(195186);
      return -1;
    case 2: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(195186);
        return 1;
      }
      if (Ja())
      {
        AppMethodBeat.o(195186);
        return -1;
      }
      AppMethodBeat.o(195186);
      return 1;
    case 33: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(195186);
        return -1;
      }
      AppMethodBeat.o(195186);
      return -2147483648;
    case 130: 
      if (this.mOrientation == 1)
      {
        AppMethodBeat.o(195186);
        return 1;
      }
      AppMethodBeat.o(195186);
      return -2147483648;
    case 17: 
      if (this.mOrientation == 0)
      {
        AppMethodBeat.o(195186);
        return -1;
      }
      AppMethodBeat.o(195186);
      return -2147483648;
    }
    if (this.mOrientation == 0)
    {
      AppMethodBeat.o(195186);
      return 1;
    }
    AppMethodBeat.o(195186);
    return -2147483648;
  }
  
  public View findViewByPosition(int paramInt)
  {
    AppMethodBeat.i(194986);
    int i = getChildCount();
    if (i == 0)
    {
      AppMethodBeat.o(194986);
      return null;
    }
    int j = paramInt - getPosition(getChildAt(0));
    if ((j >= 0) && (j < i))
    {
      localView = getChildAt(j);
      if (getPosition(localView) == paramInt)
      {
        AppMethodBeat.o(194986);
        return localView;
      }
    }
    View localView = super.findViewByPosition(paramInt);
    AppMethodBeat.o(194986);
    return localView;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(194897);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(194897);
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
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    AppMethodBeat.i(194906);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.bXG)
    {
      removeAndRecycleAllViews(paramn);
      paramn.clear();
    }
    AppMethodBeat.o(194906);
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195225);
    Jn();
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(195225);
      return null;
    }
    paramInt = fN(paramInt);
    if (paramInt == -2147483648)
    {
      AppMethodBeat.o(195225);
      return null;
    }
    Jo();
    Jo();
    a(paramInt, (int)(0.3333333F * this.bXy.JG()), false, params);
    this.bXx.bXP = -2147483648;
    this.bXx.bXp = false;
    a(paramn, this.bXx, params, true);
    if (paramInt == -1) {
      if (this.bXB)
      {
        paramView = Jt();
        if (paramInt != -1) {
          break label181;
        }
        paramn = Jq();
      }
    }
    for (;;)
    {
      if (paramn.hasFocusable())
      {
        if (paramView == null)
        {
          AppMethodBeat.o(195225);
          return null;
          paramView = Js();
          break;
          if (this.bXB) {}
          for (paramView = Js();; paramView = Jt()) {
            break;
          }
          label181:
          paramn = Jr();
          continue;
        }
        AppMethodBeat.o(195225);
        return paramn;
      }
    }
    AppMethodBeat.o(195225);
    return paramView;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(194915);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(Ju());
      paramAccessibilityEvent.setToIndex(Jw());
    }
    AppMethodBeat.o(194915);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195033);
    if (((this.bXH != null) || (this.bXE != -1)) && (params.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      AppMethodBeat.o(195033);
      return;
    }
    if ((this.bXH != null) && (this.bXH.JA())) {
      this.bXE = this.bXH.bXU;
    }
    Jo();
    this.bXx.bXp = false;
    Jn();
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
    if ((!this.bXI.Nl) || (this.bXE != -1) || (this.bXH != null))
    {
      this.bXI.reset();
      this.bXI.bXM = (this.bXB ^ this.bXC);
      localObject2 = this.bXI;
      if ((params.caw) || (this.bXE == -1))
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
          if ((localLayoutParams.bXh.isRemoved()) || (localLayoutParams.bXh.KI() < 0) || (localLayoutParams.bXh.KI() >= params.getItemCount())) {
            break label1262;
          }
          i = 1;
          if (i == 0) {
            break label1267;
          }
          ((a)localObject2).G((View)localObject1, getPosition((View)localObject1));
          i = 1;
          if (i == 0)
          {
            ((a)localObject2).Jy();
            if (!this.bXC) {
              break label1463;
            }
            i = params.getItemCount() - 1;
            ((a)localObject2).mPosition = i;
          }
        }
        this.bXI.Nl = true;
        i = b(params);
        if (this.bXx.bXS < 0) {
          break label1529;
        }
        j = 0;
        m = this.bXy.JE() + j;
        n = i + this.bXy.JH();
        j = n;
        k = m;
        if (params.caw)
        {
          j = n;
          k = m;
          if (this.bXE != -1)
          {
            j = n;
            k = m;
            if (this.bXF != -2147483648)
            {
              localObject1 = findViewByPosition(this.bXE);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.bXB) {
                  break label1541;
                }
                i = this.bXy.JF() - this.bXy.bt((View)localObject1) - this.bXF;
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
        if (!this.bXI.bXM) {
          break label1591;
        }
        if (!this.bXB) {
          break label1586;
        }
        i = 1;
        label464:
        a(paramn, params, this.bXI, i);
        detachAndScrapAttachedViews(paramn);
        this.bXx.bXw = Jp();
        this.bXx.bXR = params.caw;
        if (!this.bXI.bXM) {
          break label1608;
        }
        b(this.bXI);
        this.bXx.bXQ = k;
        a(paramn, this.bXx, params, false);
        k = this.bXx.Sc;
        m = this.bXx.bXr;
        i = j;
        if (this.bXx.bXq > 0) {
          i = j + this.bXx.bXq;
        }
        a(this.bXI);
        this.bXx.bXQ = i;
        localObject1 = this.bXx;
        ((c)localObject1).bXr += this.bXx.bXs;
        a(paramn, this.bXx, params, false);
        i = this.bXx.Sc;
        if (this.bXx.bXq <= 0) {
          break label2197;
        }
        j = this.bXx.bXq;
        bn(m, k);
        this.bXx.bXQ = j;
        a(paramn, this.bXx, params, false);
        j = this.bXx.Sc;
      }
    }
    for (;;)
    {
      label700:
      if (getChildCount() > 0) {
        if ((this.bXB ^ this.bXC))
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
        if ((!params.caA) || (getChildCount() == 0) || (params.caw) || (!supportsPredictiveItemAnimations()))
        {
          if (params.caw) {
            break label2154;
          }
          paramn = this.bXy;
          paramn.bYh = paramn.JG();
          this.bXz = this.bXC;
          AppMethodBeat.o(195033);
          return;
          if ((this.bXE < 0) || (this.bXE >= params.getItemCount()))
          {
            this.bXE = -1;
            this.bXF = -2147483648;
            i = 0;
            break;
          }
          ((a)localObject2).mPosition = this.bXE;
          if ((this.bXH != null) && (this.bXH.JA()))
          {
            ((a)localObject2).bXM = this.bXH.bXW;
            if (((a)localObject2).bXM) {}
            for (((a)localObject2).bXL = (this.bXy.JF() - this.bXH.bXV);; ((a)localObject2).bXL = (this.bXy.JE() + this.bXH.bXV))
            {
              i = 1;
              break;
            }
          }
          if (this.bXF == -2147483648)
          {
            localObject1 = findViewByPosition(this.bXE);
            if (localObject1 != null) {
              if (this.bXy.bw((View)localObject1) > this.bXy.JG()) {
                ((a)localObject2).Jy();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.bXy.bs((View)localObject1) - this.bXy.JE() < 0)
            {
              ((a)localObject2).bXL = this.bXy.JE();
              ((a)localObject2).bXM = false;
            }
            else if (this.bXy.JF() - this.bXy.bt((View)localObject1) < 0)
            {
              ((a)localObject2).bXL = this.bXy.JF();
              ((a)localObject2).bXM = true;
            }
            else
            {
              if (((a)localObject2).bXM) {}
              for (i = this.bXy.bt((View)localObject1) + this.bXy.JD();; i = this.bXy.bs((View)localObject1))
              {
                ((a)localObject2).bXL = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = getPosition(getChildAt(0));
                if (this.bXE >= i) {
                  break label1194;
                }
                bool = true;
                label1167:
                if (bool != this.bXB) {
                  break label1200;
                }
              }
              label1194:
              label1200:
              for (bool = true;; bool = false)
              {
                ((a)localObject2).bXM = bool;
                ((a)localObject2).Jy();
                break;
                bool = false;
                break label1167;
              }
              ((a)localObject2).bXM = this.bXB;
              if (this.bXB) {
                ((a)localObject2).bXL = (this.bXy.JF() - this.bXF);
              } else {
                ((a)localObject2).bXL = (this.bXy.JE() + this.bXF);
              }
            }
          }
          label1262:
          i = 0;
          break label232;
          label1267:
          if (this.bXz == this.bXC)
          {
            if (((a)localObject2).bXM)
            {
              if (this.bXB) {
                break label1422;
              }
              localObject1 = a(paramn, params);
              if (localObject1 == null) {
                break label1458;
              }
              ((a)localObject2).H((View)localObject1, getPosition((View)localObject1));
              if ((!params.caw) && (supportsPredictiveItemAnimations()))
              {
                if ((this.bXy.bs((View)localObject1) < this.bXy.JF()) && (this.bXy.bt((View)localObject1) >= this.bXy.JE())) {
                  break label1442;
                }
                i = 1;
                if (i != 0) {
                  if (!((a)localObject2).bXM) {
                    break label1447;
                  }
                }
              }
            }
            for (i = this.bXy.JF();; i = this.bXy.JE())
            {
              ((a)localObject2).bXL = i;
              i = 1;
              break;
              if (this.bXB)
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
          if ((localObject1 == null) || ((this.bXy.bs((View)localObject1) < this.bXy.JF()) && (this.bXy.bt((View)localObject1) > this.bXy.JE()))) {
            break label288;
          }
          this.bXI.G((View)localObject1, getPosition((View)localObject1));
          break label288;
          label1529:
          k = 0;
          j = i;
          i = k;
          break label307;
          label1541:
          i = this.bXy.bs((View)localObject1);
          j = this.bXy.JE();
          i = this.bXF - (i - j);
          break label431;
          label1573:
          j = n - i;
          k = m;
          break label445;
          label1586:
          i = -1;
          break label464;
          label1591:
          if (this.bXB)
          {
            i = -1;
            break label464;
          }
          i = 1;
          break label464;
          label1608:
          a(this.bXI);
          this.bXx.bXQ = j;
          a(paramn, this.bXx, params, false);
          j = this.bXx.Sc;
          m = this.bXx.bXr;
          i = k;
          if (this.bXx.bXq > 0) {
            i = k + this.bXx.bXq;
          }
          b(this.bXI);
          this.bXx.bXQ = i;
          localObject1 = this.bXx;
          ((c)localObject1).bXr += this.bXx.bXs;
          a(paramn, this.bXx, params, false);
          k = this.bXx.Sc;
          if (this.bXx.bXq <= 0) {
            break label2187;
          }
          i = this.bXx.bXq;
          bm(m, j);
          this.bXx.bXQ = i;
          a(paramn, this.bXx, params, false);
          i = this.bXx.Sc;
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
        localObject1 = paramn.caa;
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
          if (((RecyclerView.v)localObject2).KI() < i3)
          {
            bool = true;
            label1922:
            if (bool == this.bXB) {
              break label1992;
            }
            i1 = -1;
            label1934:
            if (i1 != -1) {
              break label1998;
            }
            i1 = this.bXy.bw(((RecyclerView.v)localObject2).caK) + j;
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
          i1 = i + this.bXy.bw(((RecyclerView.v)localObject2).caK);
          i = j;
          j = i1;
          continue;
          this.bXx.bXT = ((List)localObject1);
          if (j > 0)
          {
            bn(getPosition(Jq()), m);
            this.bXx.bXQ = j;
            this.bXx.bXq = 0;
            this.bXx.bq(null);
            a(paramn, this.bXx, params, false);
          }
          if (i > 0)
          {
            bm(getPosition(Jr()), k);
            this.bXx.bXQ = i;
            this.bXx.bXq = 0;
            this.bXx.bq(null);
            a(paramn, this.bXx, params, false);
          }
          this.bXx.bXT = null;
          break;
          label2154:
          this.bXI.reset();
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
    AppMethodBeat.i(195039);
    super.onLayoutCompleted(params);
    this.bXH = null;
    this.bXE = -1;
    this.bXF = -2147483648;
    this.bXI.reset();
    AppMethodBeat.o(195039);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(194934);
    if ((paramParcelable instanceof SavedState))
    {
      this.bXH = ((SavedState)paramParcelable);
      requestLayout();
    }
    AppMethodBeat.o(194934);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(194925);
    if (this.bXH != null)
    {
      localSavedState = new SavedState(this.bXH);
      AppMethodBeat.o(194925);
      return localSavedState;
    }
    SavedState localSavedState = new SavedState();
    View localView;
    if (getChildCount() > 0)
    {
      Jo();
      boolean bool = this.bXz ^ this.bXB;
      localSavedState.bXW = bool;
      if (bool)
      {
        localView = Jr();
        localSavedState.bXV = (this.bXy.JF() - this.bXy.bt(localView));
        localSavedState.bXU = getPosition(localView);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(194925);
      return localSavedState;
      localView = Jq();
      localSavedState.bXU = getPosition(localView);
      localSavedState.bXV = (this.bXy.bs(localView) - this.bXy.JE());
      continue;
      localSavedState.bXU = -1;
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195072);
    if (this.mOrientation == 1)
    {
      AppMethodBeat.o(195072);
      return 0;
    }
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(195072);
    return paramInt;
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(195060);
    this.bXE = paramInt;
    this.bXF = -2147483648;
    if (this.bXH != null) {
      this.bXH.bXU = -1;
    }
    requestLayout();
    AppMethodBeat.o(195060);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(195078);
    if (this.mOrientation == 0)
    {
      AppMethodBeat.o(195078);
      return 0;
    }
    paramInt = a(paramInt, paramn, params);
    AppMethodBeat.o(195078);
    return paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(194969);
    if ((paramInt != 0) && (paramInt != 1))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(194969);
      throw localIllegalArgumentException;
    }
    assertNotInLayoutOrScroll(null);
    if ((paramInt != this.mOrientation) || (this.bXy == null))
    {
      this.bXy = s.a(this, paramInt);
      this.bXI.bXy = this.bXy;
      this.mOrientation = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(194969);
  }
  
  boolean shouldMeasureTwice()
  {
    AppMethodBeat.i(195177);
    if ((getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations()))
    {
      AppMethodBeat.o(195177);
      return true;
    }
    AppMethodBeat.o(195177);
    return false;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(194996);
    paramRecyclerView = new o(paramRecyclerView.getContext());
    paramRecyclerView.cag = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(194996);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.bXH == null) && (this.bXz == this.bXC);
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int bXU;
    int bXV;
    boolean bXW;
    
    static
    {
      AppMethodBeat.i(194824);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(194824);
    }
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(194798);
      this.bXU = paramParcel.readInt();
      this.bXV = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.bXW = bool;
        AppMethodBeat.o(194798);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.bXU = paramSavedState.bXU;
      this.bXV = paramSavedState.bXV;
      this.bXW = paramSavedState.bXW;
    }
    
    final boolean JA()
    {
      return this.bXU >= 0;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(194858);
      paramParcel.writeInt(this.bXU);
      paramParcel.writeInt(this.bXV);
      if (this.bXW) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(194858);
        return;
      }
    }
  }
  
  static final class a
  {
    boolean Nl;
    int bXL;
    boolean bXM;
    s bXy;
    int mPosition;
    
    a()
    {
      AppMethodBeat.i(195188);
      reset();
      AppMethodBeat.o(195188);
    }
    
    public final void G(View paramView, int paramInt)
    {
      AppMethodBeat.i(195236);
      int i = this.bXy.JD();
      if (i >= 0)
      {
        H(paramView, paramInt);
        AppMethodBeat.o(195236);
        return;
      }
      this.mPosition = paramInt;
      int k;
      if (this.bXM)
      {
        paramInt = this.bXy.JF() - i - this.bXy.bt(paramView);
        this.bXL = (this.bXy.JF() - paramInt);
        if (paramInt > 0)
        {
          i = this.bXy.bw(paramView);
          j = this.bXL;
          k = this.bXy.JE();
          i = j - i - (k + Math.min(this.bXy.bs(paramView) - k, 0));
          if (i < 0)
          {
            j = this.bXL;
            this.bXL = (Math.min(paramInt, -i) + j);
          }
        }
        AppMethodBeat.o(195236);
        return;
      }
      int j = this.bXy.bs(paramView);
      paramInt = j - this.bXy.JE();
      this.bXL = j;
      if (paramInt > 0)
      {
        k = this.bXy.bw(paramView);
        int m = this.bXy.JF();
        int n = this.bXy.bt(paramView);
        i = this.bXy.JF() - Math.min(0, m - i - n) - (j + k);
        if (i < 0) {
          this.bXL -= Math.min(paramInt, -i);
        }
      }
      AppMethodBeat.o(195236);
    }
    
    public final void H(View paramView, int paramInt)
    {
      AppMethodBeat.i(195244);
      if (this.bXM) {}
      for (this.bXL = (this.bXy.bt(paramView) + this.bXy.JD());; this.bXL = this.bXy.bs(paramView))
      {
        this.mPosition = paramInt;
        AppMethodBeat.o(195244);
        return;
      }
    }
    
    final void Jy()
    {
      AppMethodBeat.i(195214);
      if (this.bXM) {}
      for (int i = this.bXy.JF();; i = this.bXy.JE())
      {
        this.bXL = i;
        AppMethodBeat.o(195214);
        return;
      }
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.bXL = -2147483648;
      this.bXM = false;
      this.Nl = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195223);
      String str = "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.bXL + ", mLayoutFromEnd=" + this.bXM + ", mValid=" + this.Nl + '}';
      AppMethodBeat.o(195223);
      return str;
    }
  }
  
  protected static final class b
  {
    public int bXN;
    public boolean bXO;
    public boolean kK;
    public boolean mFinished;
    
    final void resetInternal()
    {
      this.bXN = 0;
      this.mFinished = false;
      this.bXO = false;
      this.kK = false;
    }
  }
  
  static final class c
  {
    int Sc;
    int bXP;
    int bXQ = 0;
    boolean bXR = false;
    int bXS;
    List<RecyclerView.v> bXT = null;
    boolean bXp = true;
    int bXq;
    int bXr;
    int bXs;
    boolean bXw;
    int mLayoutDirection;
    
    private View Jz()
    {
      AppMethodBeat.i(195136);
      int j = this.bXT.size();
      int i = 0;
      while (i < j)
      {
        View localView = ((RecyclerView.v)this.bXT.get(i)).caK;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.bXh.isRemoved()) && (this.bXr == localLayoutParams.bXh.KI()))
        {
          bq(localView);
          AppMethodBeat.o(195136);
          return localView;
        }
        i += 1;
      }
      AppMethodBeat.o(195136);
      return null;
    }
    
    private View br(View paramView)
    {
      AppMethodBeat.i(195148);
      int m = this.bXT.size();
      Object localObject = null;
      int i = 2147483647;
      int j = 0;
      if (j < m)
      {
        View localView = ((RecyclerView.v)this.bXT.get(j)).caK;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((localView == paramView) || (localLayoutParams.bXh.isRemoved())) {
          break label137;
        }
        int k = (localLayoutParams.bXh.KI() - this.bXr) * this.bXs;
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
        AppMethodBeat.o(195148);
        return localObject;
      }
    }
    
    final View a(RecyclerView.n paramn)
    {
      AppMethodBeat.i(195166);
      if (this.bXT != null)
      {
        paramn = Jz();
        AppMethodBeat.o(195166);
        return paramn;
      }
      paramn = paramn.gc(this.bXr);
      this.bXr += this.bXs;
      AppMethodBeat.o(195166);
      return paramn;
    }
    
    final boolean a(RecyclerView.s params)
    {
      AppMethodBeat.i(195157);
      if ((this.bXr >= 0) && (this.bXr < params.getItemCount()))
      {
        AppMethodBeat.o(195157);
        return true;
      }
      AppMethodBeat.o(195157);
      return false;
    }
    
    public final void bq(View paramView)
    {
      AppMethodBeat.i(195174);
      paramView = br(paramView);
      if (paramView == null)
      {
        this.bXr = -1;
        AppMethodBeat.o(195174);
        return;
      }
      this.bXr = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bXh.KI();
      AppMethodBeat.o(195174);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */