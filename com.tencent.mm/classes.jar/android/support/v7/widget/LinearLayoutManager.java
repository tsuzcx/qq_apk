package android.support.v7.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.i
  implements RecyclerView.r.b
{
  int adN = 1;
  private LinearLayoutManager.c adY;
  aj adZ;
  private boolean aea;
  private boolean aeb = false;
  boolean aec = false;
  private boolean aed = false;
  private boolean aee = true;
  int aef = -1;
  int aeg = -2147483648;
  private boolean aeh;
  LinearLayoutManager.SavedState aei = null;
  final LinearLayoutManager.a aej = new LinearLayoutManager.a();
  private final LinearLayoutManager.b aek = new LinearLayoutManager.b();
  public int ael = 2;
  
  public LinearLayoutManager()
  {
    this(1);
  }
  
  public LinearLayoutManager(int paramInt)
  {
    setOrientation(paramInt);
    Q(null);
    if (this.aeb)
    {
      this.aeb = false;
      requestLayout();
    }
  }
  
  private void X(int paramInt1, int paramInt2)
  {
    this.adY.adD = (this.adZ.hi() - paramInt2);
    LinearLayoutManager.c localc = this.adY;
    if (this.aec) {}
    for (int i = -1;; i = 1)
    {
      localc.adF = i;
      this.adY.adE = paramInt1;
      this.adY.kO = 1;
      this.adY.El = paramInt2;
      this.adY.aer = -2147483648;
      return;
    }
  }
  
  private void Y(int paramInt1, int paramInt2)
  {
    this.adY.adD = (paramInt2 - this.adZ.hh());
    this.adY.adE = paramInt1;
    LinearLayoutManager.c localc = this.adY;
    if (this.aec) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.adF = paramInt1;
      this.adY.kO = -1;
      this.adY.El = paramInt2;
      this.adY.aer = -2147483648;
      return;
    }
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = this.adZ.hi() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramo, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.adZ.hi() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.adZ.bI(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(RecyclerView.o paramo, LinearLayoutManager.c paramc, RecyclerView.s params, boolean paramBoolean)
  {
    int k = paramc.adD;
    if (paramc.aer != -2147483648)
    {
      if (paramc.adD < 0) {
        paramc.aer += paramc.adD;
      }
      a(paramo, paramc);
    }
    int i = paramc.adD + paramc.aes;
    LinearLayoutManager.b localb = this.aek;
    do
    {
      int j;
      do
      {
        if (((!paramc.adJ) && (i <= 0)) || (!paramc.b(params))) {
          break;
        }
        localb.aep = 0;
        localb.mFinished = false;
        localb.aeq = false;
        localb.SV = false;
        a(paramo, params, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.El += localb.aep * paramc.kO;
        if ((localb.aeq) && (this.adY.aev == null))
        {
          j = i;
          if (params.ahQ) {}
        }
        else
        {
          paramc.adD -= localb.aep;
          j = i - localb.aep;
        }
        if (paramc.aer != -2147483648)
        {
          paramc.aer += localb.aep;
          if (paramc.adD < 0) {
            paramc.aer += paramc.adD;
          }
          a(paramo, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.SV);
    return k - paramc.adD;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.s params)
  {
    int i = -1;
    int j = 1;
    this.adY.adJ = gS();
    this.adY.aes = c(params);
    this.adY.kO = paramInt1;
    if (paramInt1 == 1)
    {
      params = this.adY;
      params.aes += this.adZ.getEndPadding();
      params = gV();
      localc = this.adY;
      if (this.aec) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.adF = paramInt1;
        this.adY.adE = (bl(params) + this.adY.adF);
        this.adY.El = this.adZ.aY(params);
        paramInt1 = this.adZ.aY(params) - this.adZ.hi();
        this.adY.adD = paramInt2;
        if (paramBoolean)
        {
          params = this.adY;
          params.adD -= paramInt1;
        }
        this.adY.aer = paramInt1;
        return;
      }
    }
    params = gU();
    LinearLayoutManager.c localc = this.adY;
    localc.aes += this.adZ.hh();
    localc = this.adY;
    if (this.aec) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.adF = paramInt1;
      this.adY.adE = (bl(params) + this.adY.adF);
      this.adY.El = this.adZ.aX(params);
      paramInt1 = -this.adZ.aX(params) + this.adZ.hh();
      break;
    }
  }
  
  private void a(LinearLayoutManager.a parama)
  {
    X(parama.mPosition, parama.aem);
  }
  
  private void a(RecyclerView.o paramo, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          a(paramInt2, paramo);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          a(i, paramo);
          i -= 1;
        }
      }
    }
  }
  
  private void a(RecyclerView.o paramo, LinearLayoutManager.c paramc)
  {
    if ((!paramc.adC) || (paramc.adJ)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramc.kO == -1)
      {
        i = paramc.aer;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.adZ.getEnd() - i;
          if (this.aec)
          {
            i = 0;
            while (i < j)
            {
              paramc = getChildAt(i);
              if ((this.adZ.aX(paramc) < k) || (this.adZ.ba(paramc) < k))
              {
                a(paramo, 0, i);
                return;
              }
              i += 1;
            }
          }
          else
          {
            i = j - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if ((this.adZ.aX(paramc) < k) || (this.adZ.ba(paramc) < k))
              {
                a(paramo, j - 1, i);
                return;
              }
              i -= 1;
            }
          }
        }
      }
      else
      {
        j = paramc.aer;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.aec)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if ((this.adZ.aY(paramc) > j) || (this.adZ.aZ(paramc) > j))
              {
                a(paramo, k - 1, i);
                return;
              }
              i -= 1;
            }
          }
          else
          {
            i = 0;
            while (i < k)
            {
              paramc = getChildAt(i);
              if ((this.adZ.aY(paramc) > j) || (this.adZ.aZ(paramc) > j))
              {
                a(paramo, 0, i);
                return;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private View aa(int paramInt1, int paramInt2)
  {
    gR();
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (i == 0)
    {
      return getChildAt(paramInt1);
      if (paramInt2 < paramInt1) {
        i = -1;
      } else {
        i = 0;
      }
    }
    int j;
    if (this.adZ.aX(getChildAt(paramInt1)) < this.adZ.hh()) {
      j = 16644;
    }
    for (int i = 16388; this.adN == 0; i = 4097)
    {
      return this.agW.i(paramInt1, paramInt2, j, i);
      j = 4161;
    }
    return this.agX.i(paramInt1, paramInt2, j, i);
  }
  
  private View aa(boolean paramBoolean)
  {
    if (this.aec) {
      return c(getChildCount() - 1, -1, paramBoolean, true);
    }
    return c(0, getChildCount(), paramBoolean, true);
  }
  
  private View ab(boolean paramBoolean)
  {
    if (this.aec) {
      return c(0, getChildCount(), paramBoolean, true);
    }
    return c(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = paramInt - this.adZ.hh();
    if (i > 0)
    {
      int j = -c(i, paramo, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.adZ.hh();
        i = j;
        if (paramInt > 0)
        {
          this.adZ.bI(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(LinearLayoutManager.a parama)
  {
    Y(parama.mPosition, parama.aem);
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.adY.adC = true;
    gR();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, params);
      k = this.adY.aer + a(paramo, this.adY, params, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.adZ.bI(-paramInt);
    this.adY.aeu = paramInt;
    return paramInt;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    gR();
    int i;
    if (paramBoolean1)
    {
      i = 24579;
      if (!paramBoolean2) {
        break label66;
      }
    }
    for (;;)
    {
      if (this.adN == 0)
      {
        return this.agW.i(paramInt1, paramInt2, i, j);
        i = 320;
        break;
      }
      return this.agX.i(paramInt1, paramInt2, i, j);
      label66:
      j = 0;
    }
  }
  
  private View d(RecyclerView.o paramo, RecyclerView.s params)
  {
    return a(paramo, params, getChildCount() - 1, -1, params.getItemCount());
  }
  
  private void gQ()
  {
    boolean bool = true;
    if ((this.adN == 1) || (!gE())) {
      bool = this.aeb;
    }
    for (;;)
    {
      this.aec = bool;
      return;
      if (this.aeb) {
        bool = false;
      }
    }
  }
  
  private boolean gS()
  {
    return (this.adZ.getMode() == 0) && (this.adZ.getEnd() == 0);
  }
  
  private View gU()
  {
    if (this.aec) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View gV()
  {
    if (this.aec) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View gW()
  {
    return aa(0, getChildCount());
  }
  
  private View gX()
  {
    return aa(getChildCount() - 1, -1);
  }
  
  private int j(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    gR();
    aj localaj = this.adZ;
    View localView;
    if (!this.aee)
    {
      bool1 = true;
      localView = aa(bool1);
      if (this.aee) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(params, localaj, localView, ab(bool1), this, this.aee, this.aec);
      bool1 = false;
      break;
    }
  }
  
  private int k(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    gR();
    aj localaj = this.adZ;
    View localView;
    if (!this.aee)
    {
      bool1 = true;
      localView = aa(bool1);
      if (this.aee) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(params, localaj, localView, ab(bool1), this, this.aee);
      bool1 = false;
      break;
    }
  }
  
  private int l(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    gR();
    aj localaj = this.adZ;
    View localView;
    if (!this.aee)
    {
      bool1 = true;
      localView = aa(bool1);
      if (this.aee) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.b(params, localaj, localView, ab(bool1), this, this.aee);
      bool1 = false;
      break;
    }
  }
  
  public final void Q(String paramString)
  {
    if (this.aei == null) {
      super.Q(paramString);
    }
  }
  
  public final void Z(int paramInt1, int paramInt2)
  {
    this.aef = paramInt1;
    this.aeg = paramInt2;
    if (this.aei != null) {
      this.aei.aew = -1;
    }
    requestLayout();
  }
  
  public int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.adN == 1) {
      return 0;
    }
    return c(paramInt, paramo, params);
  }
  
  View a(RecyclerView.o paramo, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    gR();
    int j = this.adZ.hh();
    int k = this.adZ.hi();
    int i;
    RecyclerView.s locals;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramo = null;
      locals = null;
      label36:
      if (paramInt1 == paramInt2) {
        break label142;
      }
      params = getChildAt(paramInt1);
      int m = bl(params);
      if ((m < 0) || (m >= paramInt3)) {
        break label155;
      }
      if (!((RecyclerView.LayoutParams)params.getLayoutParams()).ahi.isRemoved()) {
        break label104;
      }
      if (locals != null) {
        break label155;
      }
      locals = params;
    }
    label142:
    label152:
    label155:
    for (;;)
    {
      paramInt1 += i;
      break label36;
      i = -1;
      break;
      label104:
      Object localObject;
      if (this.adZ.aX(params) < k)
      {
        localObject = params;
        if (this.adZ.aY(params) >= j) {}
      }
      else
      {
        if (paramo != null) {
          break label155;
        }
        paramo = params;
        continue;
        if (paramo == null) {
          break label152;
        }
        localObject = paramo;
      }
      return localObject;
      return locals;
    }
  }
  
  public View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    gQ();
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = bF(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    gR();
    gR();
    a(paramInt, (int)(0.3333333F * this.adZ.hj()), false, params);
    this.adY.aer = -2147483648;
    this.adY.adC = false;
    a(paramo, this.adY, params, true);
    if (paramInt == -1) {
      if (this.aec)
      {
        paramView = gX();
        label105:
        paramo = paramView;
        if (paramInt != -1) {
          break label163;
        }
      }
    }
    label163:
    for (paramView = gU();; paramView = gV())
    {
      if (!paramView.hasFocusable()) {
        return paramo;
      }
      if (paramo != null) {
        break;
      }
      return null;
      paramView = gW();
      break label105;
      if (this.aec) {}
      for (paramView = gW();; paramView = gX())
      {
        paramo = paramView;
        break;
      }
    }
    return paramo;
  }
  
  public final void a(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.i.a parama)
  {
    if (this.adN == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      return;
      paramInt1 = paramInt2;
    }
    gR();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, params);
      a(params, this.adY, parama);
      return;
    }
  }
  
  public final void a(int paramInt, RecyclerView.i.a parama)
  {
    boolean bool;
    int i;
    if ((this.aei != null) && (this.aei.hd()))
    {
      bool = this.aei.aey;
      i = this.aei.aew;
      if (!bool) {
        break label136;
      }
    }
    label136:
    for (int j = -1;; j = 1)
    {
      int m = 0;
      int k = i;
      i = m;
      while ((i < this.ael) && (k >= 0) && (k < paramInt))
      {
        parama.M(k, 0);
        k += j;
        i += 1;
      }
      gQ();
      bool = this.aec;
      if (this.aef == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.aef;
      break;
    }
  }
  
  void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.a parama, int paramInt) {}
  
  void a(RecyclerView.o paramo, RecyclerView.s params, LinearLayoutManager.c paramc, LinearLayoutManager.b paramb)
  {
    paramo = paramc.a(paramo);
    if (paramo == null)
    {
      paramb.mFinished = true;
      return;
    }
    params = (RecyclerView.LayoutParams)paramo.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label63:
    int k;
    int m;
    int i;
    int j;
    label286:
    int n;
    if (paramc.aev == null)
    {
      bool2 = this.aec;
      if (paramc.kO == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label374;
        }
        super.c(paramo, -1, false);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramo.getLayoutParams();
        Rect localRect = this.acI.bi(paramo);
        k = localRect.left;
        m = localRect.right;
        i = localRect.top;
        j = localRect.bottom;
        k = RecyclerView.i.c(this.mWidth, this.ahf, k + m + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, gO());
        i = RecyclerView.i.c(this.mHeight, this.ahg, j + i + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, gP());
        if (a(paramo, k, i, localLayoutParams)) {
          paramo.measure(k, i);
        }
        paramb.aep = this.adZ.bb(paramo);
        if (this.adN != 1) {
          break label485;
        }
        if (!gE()) {
          break label434;
        }
        j = this.mWidth - getPaddingRight();
        i = j - this.adZ.bc(paramo);
        if (paramc.kO != -1) {
          break label456;
        }
        n = paramc.El;
        m = paramc.El - paramb.aep;
        k = i;
        i = n;
      }
    }
    for (;;)
    {
      h(paramo, k, m, j, i);
      if ((params.ahi.isRemoved()) || (params.ahi.ip())) {
        paramb.aeq = true;
      }
      paramb.SV = paramo.hasFocusable();
      return;
      bool1 = false;
      break;
      label374:
      super.c(paramo, 0, false);
      break label63;
      bool2 = this.aec;
      if (paramc.kO == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label424;
        }
        super.c(paramo, -1, true);
        break;
      }
      label424:
      super.c(paramo, 0, true);
      break label63;
      label434:
      i = getPaddingLeft();
      j = this.adZ.bc(paramo) + i;
      break label286;
      label456:
      m = paramc.El;
      n = paramc.El + paramb.aep;
      k = i;
      i = n;
      continue;
      label485:
      m = getPaddingTop();
      i = this.adZ.bc(paramo) + m;
      if (paramc.kO == -1)
      {
        j = paramc.El;
        k = paramc.El - paramb.aep;
      }
      else
      {
        k = paramc.El;
        j = paramc.El;
        n = paramb.aep;
        j += n;
      }
    }
  }
  
  public void a(RecyclerView.s params)
  {
    super.a(params);
    this.aei = null;
    this.aef = -1;
    this.aeg = -2147483648;
    this.aej.reset();
  }
  
  void a(RecyclerView.s params, LinearLayoutManager.c paramc, RecyclerView.i.a parama)
  {
    int i = paramc.adE;
    if ((i >= 0) && (i < params.getItemCount())) {
      parama.M(i, Math.max(0, paramc.aer));
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new af(paramRecyclerView.getContext());
    paramRecyclerView.ahA = paramInt;
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.aeh)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.adN == 0) {
      return 0;
    }
    return c(paramInt, paramo, params);
  }
  
  public final View bC(int paramInt)
  {
    int i = getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return localObject;
      int j = paramInt - bl(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (bl(localView) == paramInt);
    return super.bC(paramInt);
  }
  
  public final PointF bD(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < bl(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.aec) {
      paramInt = -1;
    }
    if (this.adN == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public final void bE(int paramInt)
  {
    this.aef = paramInt;
    this.aeg = -2147483648;
    if (this.aei != null) {
      this.aei.aew = -1;
    }
    requestLayout();
  }
  
  final int bF(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = -2147483648;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramInt;
                paramInt = i;
              } while (this.adN == 1);
              paramInt = i;
            } while (!gE());
            return 1;
            if (this.adN == 1) {
              return 1;
            }
            paramInt = i;
          } while (gE());
          return 1;
          paramInt = i;
        } while (this.adN == 1);
        return -2147483648;
        if (this.adN == 1) {
          return 1;
        }
        return -2147483648;
        paramInt = i;
      } while (this.adN == 0);
      return -2147483648;
    }
    if (this.adN == 0) {
      return 1;
    }
    return -2147483648;
  }
  
  public int c(RecyclerView.s params)
  {
    int j = 0;
    if (params.ahA != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = this.adZ.hj();
      }
      return j;
    }
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (((this.aei != null) || (this.aef != -1)) && (params.getItemCount() == 0))
    {
      d(paramo);
      return;
    }
    if ((this.aei != null) && (this.aei.hd())) {
      this.aef = this.aei.aew;
    }
    gR();
    this.adY.adC = false;
    gQ();
    Object localObject1 = getFocusedChild();
    Object localObject2;
    label220:
    label238:
    int j;
    label261:
    label275:
    label294:
    int m;
    int n;
    int k;
    if ((!this.aej.aeo) || (this.aef != -1) || (this.aei != null))
    {
      this.aej.reset();
      this.aej.aen = (this.aec ^ this.aed);
      localObject2 = this.aej;
      if ((params.ahQ) || (this.aef == -1))
      {
        i = 0;
        if (i == 0)
        {
          if (getChildCount() == 0) {
            break label1452;
          }
          localObject1 = getFocusedChild();
          if (localObject1 == null) {
            break label1262;
          }
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
          if ((localLayoutParams.ahi.isRemoved()) || (localLayoutParams.ahi.ic() < 0) || (localLayoutParams.ahi.ic() >= params.getItemCount())) {
            break label1257;
          }
          i = 1;
          if (i == 0) {
            break label1262;
          }
          ((LinearLayoutManager.a)localObject2).v((View)localObject1, bl((View)localObject1));
          i = 1;
          if (i == 0)
          {
            ((LinearLayoutManager.a)localObject2).hc();
            if (!this.aed) {
              break label1457;
            }
            i = params.getItemCount() - 1;
            ((LinearLayoutManager.a)localObject2).mPosition = i;
          }
        }
        this.aej.aeo = true;
        i = c(params);
        if (this.adY.aeu < 0) {
          break label1522;
        }
        j = 0;
        m = this.adZ.hh() + j;
        n = i + this.adZ.getEndPadding();
        j = n;
        k = m;
        if (params.ahQ)
        {
          j = n;
          k = m;
          if (this.aef != -1)
          {
            j = n;
            k = m;
            if (this.aeg != -2147483648)
            {
              localObject1 = bC(this.aef);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.aec) {
                  break label1534;
                }
                i = this.adZ.hi() - this.adZ.aY((View)localObject1) - this.aeg;
                label418:
                if (i <= 0) {
                  break label1566;
                }
                k = m + i;
                j = n;
              }
            }
          }
        }
        label432:
        if (!this.aej.aen) {
          break label1584;
        }
        if (!this.aec) {
          break label1579;
        }
        i = 1;
        label451:
        a(paramo, params, this.aej, i);
        b(paramo);
        this.adY.adJ = gS();
        this.adY.aet = params.ahQ;
        if (!this.aej.aen) {
          break label1601;
        }
        b(this.aej);
        this.adY.aes = k;
        a(paramo, this.adY, params, false);
        k = this.adY.El;
        m = this.adY.adE;
        i = j;
        if (this.adY.adD > 0) {
          i = j + this.adY.adD;
        }
        a(this.aej);
        this.adY.aes = i;
        localObject1 = this.adY;
        ((LinearLayoutManager.c)localObject1).adE += this.adY.adF;
        a(paramo, this.adY, params, false);
        j = this.adY.El;
        if (this.adY.adD <= 0) {
          break label2184;
        }
        i = this.adY.adD;
        Y(m, k);
        this.adY.aes = i;
        a(paramo, this.adY, params, false);
      }
    }
    label1798:
    label2184:
    for (int i = this.adY.El;; i = k)
    {
      k = j;
      j = i;
      i = k;
      for (;;)
      {
        label695:
        k = i;
        m = j;
        if (getChildCount() > 0)
        {
          if (!(this.aec ^ this.aed)) {
            break label1798;
          }
          k = a(i, paramo, params, true);
          m = j + k;
          j = b(m, paramo, params, false);
          m += j;
        }
        label813:
        boolean bool;
        for (k = j + (k + i);; k = n + i)
        {
          if ((params.ahU) && (getChildCount() != 0) && (!params.ahQ) && (gM())) {
            break label1843;
          }
          if (params.ahQ) {
            break label2148;
          }
          paramo = this.adZ;
          paramo.afn = paramo.hj();
          this.aea = this.aed;
          return;
          if ((this.aef < 0) || (this.aef >= params.getItemCount()))
          {
            this.aef = -1;
            this.aeg = -2147483648;
            i = 0;
            break;
          }
          ((LinearLayoutManager.a)localObject2).mPosition = this.aef;
          if ((this.aei != null) && (this.aei.hd()))
          {
            ((LinearLayoutManager.a)localObject2).aen = this.aei.aey;
            if (((LinearLayoutManager.a)localObject2).aen) {}
            for (((LinearLayoutManager.a)localObject2).aem = (this.adZ.hi() - this.aei.aex);; ((LinearLayoutManager.a)localObject2).aem = (this.adZ.hh() + this.aei.aex))
            {
              i = 1;
              break;
            }
          }
          if (this.aeg == -2147483648)
          {
            localObject1 = bC(this.aef);
            if (localObject1 != null) {
              if (this.adZ.bb((View)localObject1) > this.adZ.hj()) {
                ((LinearLayoutManager.a)localObject2).hc();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.adZ.aX((View)localObject1) - this.adZ.hh() < 0)
            {
              ((LinearLayoutManager.a)localObject2).aem = this.adZ.hh();
              ((LinearLayoutManager.a)localObject2).aen = false;
            }
            else if (this.adZ.hi() - this.adZ.aY((View)localObject1) < 0)
            {
              ((LinearLayoutManager.a)localObject2).aem = this.adZ.hi();
              ((LinearLayoutManager.a)localObject2).aen = true;
            }
            else
            {
              if (((LinearLayoutManager.a)localObject2).aen) {}
              for (i = this.adZ.aY((View)localObject1) + this.adZ.hg();; i = this.adZ.aX((View)localObject1))
              {
                ((LinearLayoutManager.a)localObject2).aem = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = bl(getChildAt(0));
                if (this.aef >= i) {
                  break label1189;
                }
                bool = true;
                label1162:
                if (bool != this.aec) {
                  break label1195;
                }
              }
              label1189:
              label1195:
              for (bool = true;; bool = false)
              {
                ((LinearLayoutManager.a)localObject2).aen = bool;
                ((LinearLayoutManager.a)localObject2).hc();
                break;
                bool = false;
                break label1162;
              }
              ((LinearLayoutManager.a)localObject2).aen = this.aec;
              if (this.aec) {
                ((LinearLayoutManager.a)localObject2).aem = (this.adZ.hi() - this.aeg);
              } else {
                ((LinearLayoutManager.a)localObject2).aem = (this.adZ.hh() + this.aeg);
              }
            }
          }
          label1257:
          i = 0;
          break label220;
          label1262:
          if (this.aea == this.aed)
          {
            if (((LinearLayoutManager.a)localObject2).aen)
            {
              if (this.aec) {
                break label1416;
              }
              localObject1 = d(paramo, params);
              if (localObject1 == null) {
                break label1452;
              }
              ((LinearLayoutManager.a)localObject2).w((View)localObject1, bl((View)localObject1));
              if ((!params.ahQ) && (gM()))
              {
                if ((this.adZ.aX((View)localObject1) < this.adZ.hi()) && (this.adZ.aY((View)localObject1) >= this.adZ.hh())) {
                  break label1436;
                }
                i = 1;
                if (i != 0) {
                  if (!((LinearLayoutManager.a)localObject2).aen) {
                    break label1441;
                  }
                }
              }
            }
            for (i = this.adZ.hi();; i = this.adZ.hh())
            {
              ((LinearLayoutManager.a)localObject2).aem = i;
              i = 1;
              break;
              if (this.aec)
              {
                localObject1 = d(paramo, params);
                break label1296;
              }
              localObject1 = a(paramo, params, 0, getChildCount(), params.getItemCount());
              break label1296;
              i = 0;
              break label1367;
            }
          }
          label1296:
          label1367:
          i = 0;
          label1416:
          label1436:
          label1441:
          label1452:
          break label238;
          label1457:
          i = 0;
          break label261;
          if ((localObject1 == null) || ((this.adZ.aX((View)localObject1) < this.adZ.hi()) && (this.adZ.aY((View)localObject1) > this.adZ.hh()))) {
            break label275;
          }
          this.aej.v((View)localObject1, bl((View)localObject1));
          break label275;
          label1522:
          k = 0;
          j = i;
          i = k;
          break label294;
          label1534:
          i = this.adZ.aX((View)localObject1);
          j = this.adZ.hh();
          i = this.aeg - (i - j);
          break label418;
          label1566:
          j = n - i;
          k = m;
          break label432;
          label1579:
          i = -1;
          break label451;
          label1584:
          if (this.aec)
          {
            i = -1;
            break label451;
          }
          i = 1;
          break label451;
          label1601:
          a(this.aej);
          this.adY.aes = j;
          a(paramo, this.adY, params, false);
          j = this.adY.El;
          m = this.adY.adE;
          i = k;
          if (this.adY.adD > 0) {
            i = k + this.adY.adD;
          }
          b(this.aej);
          this.adY.aes = i;
          localObject1 = this.adY;
          ((LinearLayoutManager.c)localObject1).adE += this.adY.adF;
          a(paramo, this.adY, params, false);
          i = this.adY.El;
          if (this.adY.adD <= 0) {
            break label2171;
          }
          k = this.adY.adD;
          X(m, j);
          this.adY.aes = k;
          a(paramo, this.adY, params, false);
          k = this.adY.El;
          j = i;
          i = k;
          break label695;
          k = b(j, paramo, params, true);
          i = k + i;
          n = a(i, paramo, params, false);
          m = j + k + n;
        }
        label1843:
        i = 0;
        j = 0;
        localObject1 = paramo.ahu;
        int i2 = ((List)localObject1).size();
        int i3 = bl(getChildAt(0));
        n = 0;
        label1876:
        label1918:
        int i1;
        if (n < i2)
        {
          localObject2 = (RecyclerView.v)((List)localObject1).get(n);
          if (((RecyclerView.v)localObject2).isRemoved()) {
            break label2158;
          }
          if (((RecyclerView.v)localObject2).ic() < i3)
          {
            bool = true;
            if (bool == this.aec) {
              break label1988;
            }
            i1 = -1;
            label1930:
            if (i1 != -1) {
              break label1994;
            }
            i1 = i + this.adZ.bb(((RecyclerView.v)localObject2).aie);
            i = j;
            j = i1;
          }
        }
        for (;;)
        {
          i1 = n + 1;
          n = j;
          j = i;
          i = n;
          n = i1;
          break label1876;
          bool = false;
          break label1918;
          label1988:
          i1 = 1;
          break label1930;
          label1994:
          i1 = this.adZ.bb(((RecyclerView.v)localObject2).aie) + j;
          j = i;
          i = i1;
          continue;
          this.adY.aev = ((List)localObject1);
          if (i > 0)
          {
            Y(bl(gU()), m);
            this.adY.aes = i;
            this.adY.adD = 0;
            this.adY.aW(null);
            a(paramo, this.adY, params, false);
          }
          if (j > 0)
          {
            X(bl(gV()), k);
            this.adY.aes = j;
            this.adY.adD = 0;
            this.adY.aW(null);
            a(paramo, this.adY, params, false);
          }
          this.adY.aev = null;
          break;
          label2148:
          this.aej.reset();
          break label813;
          label2158:
          i1 = i;
          i = j;
          j = i1;
        }
        label2171:
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public final int d(RecyclerView.s params)
  {
    return j(params);
  }
  
  public final int e(RecyclerView.s params)
  {
    return j(params);
  }
  
  public final int f(RecyclerView.s params)
  {
    return k(params);
  }
  
  public final int g(RecyclerView.s params)
  {
    return k(params);
  }
  
  protected final boolean gE()
  {
    return q.Q(this.acI) == 1;
  }
  
  public RecyclerView.LayoutParams gJ()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public boolean gM()
  {
    return (this.aei == null) && (this.aea == this.aed);
  }
  
  public final boolean gN()
  {
    return true;
  }
  
  public final boolean gO()
  {
    return this.adN == 0;
  }
  
  public final boolean gP()
  {
    return this.adN == 1;
  }
  
  final void gR()
  {
    if (this.adY == null) {
      this.adY = new LinearLayoutManager.c();
    }
  }
  
  final boolean gT()
  {
    if ((this.ahg != 1073741824) && (this.ahf != 1073741824))
    {
      int j = getChildCount();
      int i = 0;
      if (i < j)
      {
        ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
        if ((localLayoutParams.width >= 0) || (localLayoutParams.height >= 0)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label75;
        }
        return true;
        i += 1;
        break;
      }
    }
    label75:
    return false;
  }
  
  public final int gY()
  {
    View localView = c(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return bl(localView);
  }
  
  public final int gZ()
  {
    View localView = c(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return bl(localView);
  }
  
  public final int h(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final int ha()
  {
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return bl(localView);
  }
  
  public final int hb()
  {
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return bl(localView);
  }
  
  public final int i(RecyclerView.s params)
  {
    return l(params);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(gY());
      paramAccessibilityEvent.setToIndex(ha());
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.aei = ((LinearLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.aei != null) {
      return new LinearLayoutManager.SavedState(this.aei);
    }
    LinearLayoutManager.SavedState localSavedState = new LinearLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      gR();
      boolean bool = this.aea ^ this.aec;
      localSavedState.aey = bool;
      if (bool)
      {
        localView = gV();
        localSavedState.aex = (this.adZ.hi() - this.adZ.aY(localView));
        localSavedState.aew = bl(localView);
        return localSavedState;
      }
      View localView = gU();
      localSavedState.aew = bl(localView);
      localSavedState.aex = (this.adZ.aX(localView) - this.adZ.hh());
      return localSavedState;
    }
    localSavedState.aew = -1;
    return localSavedState;
  }
  
  public final void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    Q(null);
    if ((paramInt != this.adN) || (this.adZ == null)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("invalid orientation");
      }
    }
    for (aj localaj = aj.a(this);; localaj = aj.b(this))
    {
      this.adZ = localaj;
      this.aej.adZ = this.adZ;
      this.adN = paramInt;
      requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */