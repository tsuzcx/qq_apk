package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.t;
import android.support.v7.widget.a.a.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.i
  implements RecyclerView.s.b, a.d
{
  public int aoA = 2;
  private c aon;
  aj aoo;
  private boolean aop;
  private boolean aoq = false;
  boolean aor = false;
  private boolean aos = false;
  private boolean aot = true;
  int aou = -1;
  int aov = -2147483648;
  private boolean aow;
  SavedState aox = null;
  final a aoy = new a();
  private final b aoz = new b();
  int mOrientation = 1;
  
  public LinearLayoutManager()
  {
    this(1);
  }
  
  public LinearLayoutManager(int paramInt)
  {
    setOrientation(paramInt);
    ap(false);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = c(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    ap(paramContext.arF);
    ao(paramContext.arG);
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    int i = this.aoo.km() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramo, paramt);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.aoo.km() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.aoo.cf(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(RecyclerView.o paramo, c paramc, RecyclerView.t paramt, boolean paramBoolean)
  {
    int k = paramc.anU;
    if (paramc.aoG != -2147483648)
    {
      if (paramc.anU < 0) {
        paramc.aoG += paramc.anU;
      }
      a(paramo, paramc);
    }
    int i = paramc.anU + paramc.aoH;
    b localb = this.aoz;
    do
    {
      int j;
      do
      {
        if (((!paramc.aoa) && (i <= 0)) || (!paramc.b(paramt))) {
          break;
        }
        localb.resetInternal();
        a(paramo, paramt, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.MW += localb.aoE * paramc.mLayoutDirection;
        if ((localb.aoF) && (this.aon.aoK == null))
        {
          j = i;
          if (paramt.asp) {}
        }
        else
        {
          paramc.anU -= localb.aoE;
          j = i - localb.aoE;
        }
        if (paramc.aoG != -2147483648)
        {
          paramc.aoG += localb.aoE;
          if (paramc.anU < 0) {
            paramc.aoG += paramc.anU;
          }
          a(paramo, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.abD);
    return k - paramc.anU;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.t paramt)
  {
    int i = -1;
    int j = 1;
    this.aon.aoa = jQ();
    this.aon.aoH = c(paramt);
    this.aon.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      paramt = this.aon;
      paramt.aoH += this.aoo.getEndPadding();
      paramt = jT();
      localc = this.aon;
      if (this.aor) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.anW = paramInt1;
        this.aon.anV = (bB(paramt) + this.aon.anW);
        this.aon.MW = this.aoo.bo(paramt);
        paramInt1 = this.aoo.bo(paramt) - this.aoo.km();
        this.aon.anU = paramInt2;
        if (paramBoolean)
        {
          paramt = this.aon;
          paramt.anU -= paramInt1;
        }
        this.aon.aoG = paramInt1;
        return;
      }
    }
    paramt = jS();
    c localc = this.aon;
    localc.aoH += this.aoo.kl();
    localc = this.aon;
    if (this.aor) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.anW = paramInt1;
      this.aon.anV = (bB(paramt) + this.aon.anW);
      this.aon.MW = this.aoo.bn(paramt);
      paramInt1 = -this.aoo.bn(paramt) + this.aoo.kl();
      break;
    }
  }
  
  private void a(a parama)
  {
    ad(parama.mPosition, parama.aoB);
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
  
  private void a(RecyclerView.o paramo, c paramc)
  {
    if ((!paramc.anT) || (paramc.aoa)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramc.mLayoutDirection == -1)
      {
        i = paramc.aoG;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.aoo.getEnd() - i;
          if (this.aor)
          {
            i = 0;
            while (i < j)
            {
              paramc = getChildAt(i);
              if ((this.aoo.bn(paramc) < k) || (this.aoo.bq(paramc) < k))
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
              if ((this.aoo.bn(paramc) < k) || (this.aoo.bq(paramc) < k))
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
        j = paramc.aoG;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.aor)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if ((this.aoo.bo(paramc) > j) || (this.aoo.bp(paramc) > j))
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
              if ((this.aoo.bo(paramc) > j) || (this.aoo.bp(paramc) > j))
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
  
  private void ad(int paramInt1, int paramInt2)
  {
    this.aon.anU = (this.aoo.km() - paramInt2);
    c localc = this.aon;
    if (this.aor) {}
    for (int i = -1;; i = 1)
    {
      localc.anW = i;
      this.aon.anV = paramInt1;
      this.aon.mLayoutDirection = 1;
      this.aon.MW = paramInt2;
      this.aon.aoG = -2147483648;
      return;
    }
  }
  
  private void ae(int paramInt1, int paramInt2)
  {
    this.aon.anU = (paramInt2 - this.aoo.kl());
    this.aon.anV = paramInt1;
    c localc = this.aon;
    if (this.aor) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.anW = paramInt1;
      this.aon.mLayoutDirection = -1;
      this.aon.MW = paramInt2;
      this.aon.aoG = -2147483648;
      return;
    }
  }
  
  private View ag(int paramInt1, int paramInt2)
  {
    jP();
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
    if (this.aoo.bn(getChildAt(paramInt1)) < this.aoo.kl()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      return this.ars.k(paramInt1, paramInt2, j, i);
      j = 4161;
    }
    return this.art.k(paramInt1, paramInt2, j, i);
  }
  
  private View aq(boolean paramBoolean)
  {
    if (this.aor) {
      return c(getChildCount() - 1, -1, paramBoolean, true);
    }
    return c(0, getChildCount(), paramBoolean, true);
  }
  
  private View ar(boolean paramBoolean)
  {
    if (this.aor) {
      return c(0, getChildCount(), paramBoolean, true);
    }
    return c(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    int i = paramInt - this.aoo.kl();
    if (i > 0)
    {
      int j = -c(i, paramo, paramt);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.aoo.kl();
        i = j;
        if (paramInt > 0)
        {
          this.aoo.cf(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(a parama)
  {
    ae(parama.mPosition, parama.aoB);
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.aon.anT = true;
    jP();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, paramt);
      k = this.aon.aoG + a(paramo, this.aon, paramt, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.aoo.cf(-paramInt);
    this.aon.aoJ = paramInt;
    return paramInt;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    jP();
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
      if (this.mOrientation == 0)
      {
        return this.ars.k(paramInt1, paramInt2, i, j);
        i = 320;
        break;
      }
      return this.art.k(paramInt1, paramInt2, i, j);
      label66:
      j = 0;
    }
  }
  
  private View d(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    return a(paramo, paramt, getChildCount() - 1, -1, paramt.getItemCount());
  }
  
  private int j(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    jP();
    aj localaj = this.aoo;
    View localView;
    if (!this.aot)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.aot) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, ar(bool1), this, this.aot, this.aor);
      bool1 = false;
      break;
    }
  }
  
  private void jO()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!ji())) {
      bool = this.aoq;
    }
    for (;;)
    {
      this.aor = bool;
      return;
      if (this.aoq) {
        bool = false;
      }
    }
  }
  
  private boolean jQ()
  {
    return (this.aoo.getMode() == 0) && (this.aoo.getEnd() == 0);
  }
  
  private View jS()
  {
    if (this.aor) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View jT()
  {
    if (this.aor) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View jU()
  {
    return ag(0, getChildCount());
  }
  
  private View jV()
  {
    return ag(getChildCount() - 1, -1);
  }
  
  private int k(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    jP();
    aj localaj = this.aoo;
    View localView;
    if (!this.aot)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.aot) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, ar(bool1), this, this.aot);
      bool1 = false;
      break;
    }
  }
  
  private int l(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    jP();
    aj localaj = this.aoo;
    View localView;
    if (!this.aot)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.aot) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(paramt, localaj, localView, ar(bool1), this, this.aot);
      bool1 = false;
      break;
    }
  }
  
  public final void G(String paramString)
  {
    if (this.aox == null) {
      super.G(paramString);
    }
  }
  
  public int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return c(paramInt, paramo, paramt);
  }
  
  View a(RecyclerView.o paramo, RecyclerView.t paramt, int paramInt1, int paramInt2, int paramInt3)
  {
    jP();
    int j = this.aoo.kl();
    int k = this.aoo.km();
    int i;
    RecyclerView.t localt;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramo = null;
      localt = null;
      label36:
      if (paramInt1 == paramInt2) {
        break label142;
      }
      paramt = getChildAt(paramInt1);
      int m = bB(paramt);
      if ((m < 0) || (m >= paramInt3)) {
        break label155;
      }
      if (!((RecyclerView.LayoutParams)paramt.getLayoutParams()).arH.isRemoved()) {
        break label104;
      }
      if (localt != null) {
        break label155;
      }
      localt = paramt;
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
      if (this.aoo.bn(paramt) < k)
      {
        localObject = paramt;
        if (this.aoo.bo(paramt) >= j) {}
      }
      else
      {
        if (paramo != null) {
          break label155;
        }
        paramo = paramt;
        continue;
        if (paramo == null) {
          break label152;
        }
        localObject = paramo;
      }
      return localObject;
      return localt;
    }
  }
  
  public View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    jO();
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = cc(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    jP();
    jP();
    a(paramInt, (int)(0.3333333F * this.aoo.kn()), false, paramt);
    this.aon.aoG = -2147483648;
    this.aon.anT = false;
    a(paramo, this.aon, paramt, true);
    if (paramInt == -1) {
      if (this.aor)
      {
        paramView = jV();
        label105:
        paramo = paramView;
        if (paramInt != -1) {
          break label163;
        }
      }
    }
    label163:
    for (paramView = jS();; paramView = jT())
    {
      if (!paramView.hasFocusable()) {
        return paramo;
      }
      if (paramo != null) {
        break;
      }
      return null;
      paramView = jU();
      break label105;
      if (this.aor) {}
      for (paramView = jU();; paramView = jV())
      {
        paramo = paramView;
        break;
      }
    }
    return paramo;
  }
  
  public final void a(int paramInt1, int paramInt2, RecyclerView.t paramt, RecyclerView.i.a parama)
  {
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      return;
      paramInt1 = paramInt2;
    }
    jP();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, paramt);
      a(paramt, this.aon, parama);
      return;
    }
  }
  
  public final void a(int paramInt, RecyclerView.i.a parama)
  {
    boolean bool;
    int i;
    if ((this.aox != null) && (this.aox.kc()))
    {
      bool = this.aox.aoN;
      i = this.aox.aoL;
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
      while ((i < this.aoA) && (k >= 0) && (k < paramInt))
      {
        parama.R(k, 0);
        k += j;
        i += 1;
      }
      jO();
      bool = this.aor;
      if (this.aou == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.aou;
      break;
    }
  }
  
  void a(RecyclerView.o paramo, RecyclerView.t paramt, a parama, int paramInt) {}
  
  void a(RecyclerView.o paramo, RecyclerView.t paramt, c paramc, b paramb)
  {
    paramo = paramc.a(paramo);
    if (paramo == null)
    {
      paramb.mFinished = true;
      return;
    }
    paramt = (RecyclerView.LayoutParams)paramo.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label62:
    int i;
    int j;
    label119:
    int i1;
    int n;
    int m;
    int k;
    if (paramc.aoK == null)
    {
      bool2 = this.aor;
      if (paramc.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label215;
        }
        addView(paramo, -1);
        bD(paramo);
        paramb.aoE = this.aoo.br(paramo);
        if (this.mOrientation != 1) {
          break label331;
        }
        if (!ji()) {
          break label272;
        }
        i = this.mWidth - getPaddingRight();
        j = i - this.aoo.bs(paramo);
        if (paramc.mLayoutDirection != -1) {
          break label294;
        }
        i1 = paramc.MW;
        n = paramc.MW - paramb.aoE;
        m = i;
        k = j;
        j = i1;
        i = n;
      }
    }
    for (;;)
    {
      k(paramo, k, i, m, j);
      if ((paramt.arH.isRemoved()) || (paramt.arH.lL())) {
        paramb.aoF = true;
      }
      paramb.abD = paramo.hasFocusable();
      return;
      bool1 = false;
      break;
      label215:
      addView(paramo, 0);
      break label62;
      bool2 = this.aor;
      if (paramc.mLayoutDirection == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label263;
        }
        G(paramo, -1);
        break;
      }
      label263:
      G(paramo, 0);
      break label62;
      label272:
      j = getPaddingLeft();
      i = this.aoo.bs(paramo) + j;
      break label119;
      label294:
      i1 = paramc.MW;
      n = paramc.MW + paramb.aoE;
      k = j;
      m = i;
      i = i1;
      j = n;
      continue;
      label331:
      j = getPaddingTop();
      i = this.aoo.bs(paramo) + j;
      if (paramc.mLayoutDirection == -1)
      {
        m = paramc.MW;
        n = paramc.MW - paramb.aoE;
        k = i;
        i = j;
        j = k;
        k = n;
      }
      else
      {
        n = paramc.MW;
        m = paramc.MW + paramb.aoE;
        k = i;
        i = j;
        j = k;
        k = n;
      }
    }
  }
  
  public void a(RecyclerView.t paramt)
  {
    super.a(paramt);
    this.aox = null;
    this.aou = -1;
    this.aov = -2147483648;
    this.aoy.reset();
  }
  
  void a(RecyclerView.t paramt, c paramc, RecyclerView.i.a parama)
  {
    int i = paramc.anV;
    if ((i >= 0) && (i < paramt.getItemCount())) {
      parama.R(i, Math.max(0, paramc.aoG));
    }
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.aow)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.arZ = paramInt;
    a(paramRecyclerView);
  }
  
  public void af(int paramInt1, int paramInt2)
  {
    this.aou = paramInt1;
    this.aov = paramInt2;
    if (this.aox != null) {
      this.aox.aoL = -1;
    }
    requestLayout();
  }
  
  public void ao(boolean paramBoolean)
  {
    G(null);
    if (this.aos == paramBoolean) {
      return;
    }
    this.aos = paramBoolean;
    requestLayout();
  }
  
  public void ap(boolean paramBoolean)
  {
    G(null);
    if (paramBoolean == this.aoq) {
      return;
    }
    this.aoq = paramBoolean;
    requestLayout();
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return c(paramInt, paramo, paramt);
  }
  
  public View bY(int paramInt)
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
      int j = paramInt - bB(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (bB(localView) == paramInt);
    return super.bY(paramInt);
  }
  
  public final PointF bZ(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < bB(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.aor) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  protected int c(RecyclerView.t paramt)
  {
    int j = 0;
    if (paramt.arZ != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = this.aoo.kn();
      }
      return j;
    }
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (((this.aox != null) || (this.aou != -1)) && (paramt.getItemCount() == 0))
    {
      d(paramo);
      return;
    }
    if ((this.aox != null) && (this.aox.kc())) {
      this.aou = this.aox.aoL;
    }
    jP();
    this.aon.anT = false;
    jO();
    Object localObject1 = getFocusedChild();
    Object localObject2;
    int i;
    label220:
    label238:
    int j;
    label261:
    label275:
    label294:
    int m;
    int n;
    int k;
    if ((!this.aoy.aoD) || (this.aou != -1) || (this.aox != null))
    {
      this.aoy.reset();
      this.aoy.aoC = (this.aor ^ this.aos);
      localObject2 = this.aoy;
      if ((paramt.asp) || (this.aou == -1))
      {
        i = 0;
        if (i == 0)
        {
          if (getChildCount() == 0) {
            break label1437;
          }
          localObject1 = getFocusedChild();
          if (localObject1 == null) {
            break label1247;
          }
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
          if ((localLayoutParams.arH.isRemoved()) || (localLayoutParams.arH.lu() < 0) || (localLayoutParams.arH.lu() >= paramt.getItemCount())) {
            break label1242;
          }
          i = 1;
          if (i == 0) {
            break label1247;
          }
          ((a)localObject2).C((View)localObject1, bB((View)localObject1));
          i = 1;
          if (i == 0)
          {
            ((a)localObject2).ka();
            if (!this.aos) {
              break label1442;
            }
            i = paramt.getItemCount() - 1;
            ((a)localObject2).mPosition = i;
          }
        }
        this.aoy.aoD = true;
        i = c(paramt);
        if (this.aon.aoJ < 0) {
          break label1507;
        }
        j = 0;
        m = this.aoo.kl() + j;
        n = i + this.aoo.getEndPadding();
        j = n;
        k = m;
        if (paramt.asp)
        {
          j = n;
          k = m;
          if (this.aou != -1)
          {
            j = n;
            k = m;
            if (this.aov != -2147483648)
            {
              localObject1 = bY(this.aou);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.aor) {
                  break label1519;
                }
                i = this.aoo.km() - this.aoo.bo((View)localObject1) - this.aov;
                label418:
                if (i <= 0) {
                  break label1551;
                }
                k = m + i;
                j = n;
              }
            }
          }
        }
        label432:
        if (!this.aoy.aoC) {
          break label1569;
        }
        if (!this.aor) {
          break label1564;
        }
        i = 1;
        label451:
        a(paramo, paramt, this.aoy, i);
        b(paramo);
        this.aon.aoa = jQ();
        this.aon.aoI = paramt.asp;
        if (!this.aoy.aoC) {
          break label1586;
        }
        b(this.aoy);
        this.aon.aoH = k;
        a(paramo, this.aon, paramt, false);
        k = this.aon.MW;
        m = this.aon.anV;
        i = j;
        if (this.aon.anU > 0) {
          i = j + this.aon.anU;
        }
        a(this.aoy);
        this.aon.aoH = i;
        localObject1 = this.aon;
        ((c)localObject1).anV += this.aon.anW;
        a(paramo, this.aon, paramt, false);
        i = this.aon.MW;
        if (this.aon.anU <= 0) {
          break label2172;
        }
        j = this.aon.anU;
        ae(m, k);
        this.aon.aoH = j;
        a(paramo, this.aon, paramt, false);
        j = this.aon.MW;
      }
    }
    for (;;)
    {
      label687:
      if (getChildCount() > 0) {
        if ((this.aor ^ this.aos))
        {
          k = a(i, paramo, paramt, true);
          j += k;
          m = b(j, paramo, paramt, false);
          k = i + k + m;
          m = j + m;
        }
      }
      for (;;)
      {
        label798:
        boolean bool;
        if ((!paramt.ast) || (getChildCount() == 0) || (paramt.asp) || (!jK()))
        {
          if (paramt.asp) {
            break label2129;
          }
          paramo = this.aoo;
          paramo.apF = paramo.kn();
          this.aop = this.aos;
          return;
          if ((this.aou < 0) || (this.aou >= paramt.getItemCount()))
          {
            this.aou = -1;
            this.aov = -2147483648;
            i = 0;
            break;
          }
          ((a)localObject2).mPosition = this.aou;
          if ((this.aox != null) && (this.aox.kc()))
          {
            ((a)localObject2).aoC = this.aox.aoN;
            if (((a)localObject2).aoC) {}
            for (((a)localObject2).aoB = (this.aoo.km() - this.aox.aoM);; ((a)localObject2).aoB = (this.aoo.kl() + this.aox.aoM))
            {
              i = 1;
              break;
            }
          }
          if (this.aov == -2147483648)
          {
            localObject1 = bY(this.aou);
            if (localObject1 != null) {
              if (this.aoo.br((View)localObject1) > this.aoo.kn()) {
                ((a)localObject2).ka();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.aoo.bn((View)localObject1) - this.aoo.kl() < 0)
            {
              ((a)localObject2).aoB = this.aoo.kl();
              ((a)localObject2).aoC = false;
            }
            else if (this.aoo.km() - this.aoo.bo((View)localObject1) < 0)
            {
              ((a)localObject2).aoB = this.aoo.km();
              ((a)localObject2).aoC = true;
            }
            else
            {
              if (((a)localObject2).aoC) {}
              for (i = this.aoo.bo((View)localObject1) + this.aoo.kk();; i = this.aoo.bn((View)localObject1))
              {
                ((a)localObject2).aoB = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = bB(getChildAt(0));
                if (this.aou >= i) {
                  break label1174;
                }
                bool = true;
                label1147:
                if (bool != this.aor) {
                  break label1180;
                }
              }
              label1174:
              label1180:
              for (bool = true;; bool = false)
              {
                ((a)localObject2).aoC = bool;
                ((a)localObject2).ka();
                break;
                bool = false;
                break label1147;
              }
              ((a)localObject2).aoC = this.aor;
              if (this.aor) {
                ((a)localObject2).aoB = (this.aoo.km() - this.aov);
              } else {
                ((a)localObject2).aoB = (this.aoo.kl() + this.aov);
              }
            }
          }
          label1242:
          i = 0;
          break label220;
          label1247:
          if (this.aop == this.aos)
          {
            if (((a)localObject2).aoC)
            {
              if (this.aor) {
                break label1401;
              }
              localObject1 = d(paramo, paramt);
              if (localObject1 == null) {
                break label1437;
              }
              ((a)localObject2).D((View)localObject1, bB((View)localObject1));
              if ((!paramt.asp) && (jK()))
              {
                if ((this.aoo.bn((View)localObject1) < this.aoo.km()) && (this.aoo.bo((View)localObject1) >= this.aoo.kl())) {
                  break label1421;
                }
                i = 1;
                if (i != 0) {
                  if (!((a)localObject2).aoC) {
                    break label1426;
                  }
                }
              }
            }
            for (i = this.aoo.km();; i = this.aoo.kl())
            {
              ((a)localObject2).aoB = i;
              i = 1;
              break;
              if (this.aor)
              {
                localObject1 = d(paramo, paramt);
                break label1281;
              }
              label1401:
              localObject1 = a(paramo, paramt, 0, getChildCount(), paramt.getItemCount());
              break label1281;
              i = 0;
              break label1352;
            }
          }
          label1281:
          label1352:
          i = 0;
          label1421:
          label1426:
          label1437:
          break label238;
          label1442:
          i = 0;
          break label261;
          if ((localObject1 == null) || ((this.aoo.bn((View)localObject1) < this.aoo.km()) && (this.aoo.bo((View)localObject1) > this.aoo.kl()))) {
            break label275;
          }
          this.aoy.C((View)localObject1, bB((View)localObject1));
          break label275;
          label1507:
          k = 0;
          j = i;
          i = k;
          break label294;
          label1519:
          i = this.aoo.bn((View)localObject1);
          j = this.aoo.kl();
          i = this.aov - (i - j);
          break label418;
          label1551:
          j = n - i;
          k = m;
          break label432;
          label1564:
          i = -1;
          break label451;
          label1569:
          if (this.aor)
          {
            i = -1;
            break label451;
          }
          i = 1;
          break label451;
          label1586:
          a(this.aoy);
          this.aon.aoH = j;
          a(paramo, this.aon, paramt, false);
          j = this.aon.MW;
          m = this.aon.anV;
          i = k;
          if (this.aon.anU > 0) {
            i = k + this.aon.anU;
          }
          b(this.aoy);
          this.aon.aoH = i;
          localObject1 = this.aon;
          ((c)localObject1).anV += this.aon.anW;
          a(paramo, this.aon, paramt, false);
          k = this.aon.MW;
          if (this.aon.anU <= 0) {
            break label2162;
          }
          i = this.aon.anU;
          ad(m, j);
          this.aon.aoH = i;
          a(paramo, this.aon, paramt, false);
          i = this.aon.MW;
          j = k;
          break label687;
          m = b(j, paramo, paramt, true);
          k = i + m;
          i = a(k, paramo, paramt, false);
          k += i;
          m = j + m + i;
          continue;
        }
        j = 0;
        i = 0;
        localObject1 = paramo.arT;
        int i2 = ((List)localObject1).size();
        int i3 = bB(getChildAt(0));
        n = 0;
        label1857:
        label1899:
        int i1;
        if (n < i2)
        {
          localObject2 = (RecyclerView.w)((List)localObject1).get(n);
          if (((RecyclerView.w)localObject2).isRemoved()) {
            break label2139;
          }
          if (((RecyclerView.w)localObject2).lu() < i3)
          {
            bool = true;
            if (bool == this.aor) {
              break label1969;
            }
            i1 = -1;
            label1911:
            if (i1 != -1) {
              break label1975;
            }
            i1 = this.aoo.br(((RecyclerView.w)localObject2).asD) + j;
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
          break label1857;
          bool = false;
          break label1899;
          label1969:
          i1 = 1;
          break label1911;
          label1975:
          i1 = i + this.aoo.br(((RecyclerView.w)localObject2).asD);
          i = j;
          j = i1;
          continue;
          this.aon.aoK = ((List)localObject1);
          if (j > 0)
          {
            ae(bB(jS()), m);
            this.aon.aoH = j;
            this.aon.anU = 0;
            this.aon.bl(null);
            a(paramo, this.aon, paramt, false);
          }
          if (i > 0)
          {
            ad(bB(jT()), k);
            this.aon.aoH = i;
            this.aon.anU = 0;
            this.aon.bl(null);
            a(paramo, this.aon, paramt, false);
          }
          this.aon.aoK = null;
          break;
          label2129:
          this.aoy.reset();
          break label798;
          label2139:
          i1 = i;
          i = j;
          j = i1;
        }
        k = i;
        m = j;
      }
      label2162:
      i = j;
      j = k;
      continue;
      label2172:
      j = k;
    }
  }
  
  public void ca(int paramInt)
  {
    this.aou = paramInt;
    this.aov = -2147483648;
    if (this.aox != null) {
      this.aox.aoL = -1;
    }
    requestLayout();
  }
  
  public final void cb(int paramInt)
  {
    this.aoA = paramInt;
  }
  
  final int cc(int paramInt)
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
              } while (this.mOrientation == 1);
              paramInt = i;
            } while (!ji());
            return 1;
            if (this.mOrientation == 1) {
              return 1;
            }
            paramInt = i;
          } while (ji());
          return 1;
          paramInt = i;
        } while (this.mOrientation == 1);
        return -2147483648;
        if (this.mOrientation == 1) {
          return 1;
        }
        return -2147483648;
        paramInt = i;
      } while (this.mOrientation == 0);
      return -2147483648;
    }
    if (this.mOrientation == 0) {
      return 1;
    }
    return -2147483648;
  }
  
  public int d(RecyclerView.t paramt)
  {
    return j(paramt);
  }
  
  public int e(RecyclerView.t paramt)
  {
    return j(paramt);
  }
  
  public final void e(View paramView1, View paramView2)
  {
    G("Cannot drop a view during a scroll or layout calculation");
    jP();
    jO();
    int i = bB(paramView1);
    int j = bB(paramView2);
    if (i < j) {
      i = 1;
    }
    while (this.aor) {
      if (i == 1)
      {
        af(j, this.aoo.km() - (this.aoo.bn(paramView2) + this.aoo.br(paramView1)));
        return;
        i = -1;
      }
      else
      {
        af(j, this.aoo.km() - this.aoo.bo(paramView2));
        return;
      }
    }
    if (i == -1)
    {
      af(j, this.aoo.bn(paramView2));
      return;
    }
    af(j, this.aoo.bo(paramView2) - this.aoo.br(paramView1));
  }
  
  public int f(RecyclerView.t paramt)
  {
    return k(paramt);
  }
  
  public int g(RecyclerView.t paramt)
  {
    return k(paramt);
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int h(RecyclerView.t paramt)
  {
    return l(paramt);
  }
  
  public int i(RecyclerView.t paramt)
  {
    return l(paramt);
  }
  
  public RecyclerView.LayoutParams jG()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public boolean jK()
  {
    return (this.aox == null) && (this.aop == this.aos);
  }
  
  public final boolean jL()
  {
    return true;
  }
  
  public boolean jM()
  {
    return this.mOrientation == 0;
  }
  
  public boolean jN()
  {
    return this.mOrientation == 1;
  }
  
  protected void jP()
  {
    if (this.aon == null) {
      this.aon = new c();
    }
  }
  
  final boolean jR()
  {
    if ((this.arC != 1073741824) && (this.arB != 1073741824))
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
  
  public final int jW()
  {
    View localView = c(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int jX()
  {
    View localView = c(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int jY()
  {
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int jZ()
  {
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  protected final boolean ji()
  {
    return t.Y(this.alu) == 1;
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(jW());
      paramAccessibilityEvent.setToIndex(jY());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.aox = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.aox != null) {
      return new SavedState(this.aox);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      jP();
      boolean bool = this.aop ^ this.aor;
      localSavedState.aoN = bool;
      if (bool)
      {
        localView = jT();
        localSavedState.aoM = (this.aoo.km() - this.aoo.bo(localView));
        localSavedState.aoL = bB(localView);
        return localSavedState;
      }
      View localView = jS();
      localSavedState.aoL = bB(localView);
      localSavedState.aoM = (this.aoo.bn(localView) - this.aoo.kl());
      return localSavedState;
    }
    localSavedState.aoL = -1;
    return localSavedState;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    G(null);
    if ((paramInt != this.mOrientation) || (this.aoo == null))
    {
      this.aoo = aj.a(this, paramInt);
      this.aoy.aoo = this.aoo;
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int aoL;
    int aoM;
    boolean aoN;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.aoL = paramParcel.readInt();
      this.aoM = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.aoN = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.aoL = paramSavedState.aoL;
      this.aoM = paramSavedState.aoM;
      this.aoN = paramSavedState.aoN;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final boolean kc()
    {
      return this.aoL >= 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.aoL);
      paramParcel.writeInt(this.aoM);
      if (this.aoN) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  static final class a
  {
    int aoB;
    boolean aoC;
    boolean aoD;
    aj aoo;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    public final void C(View paramView, int paramInt)
    {
      int i = this.aoo.kk();
      if (i >= 0) {
        D(paramView, paramInt);
      }
      do
      {
        int j;
        do
        {
          do
          {
            do
            {
              return;
              this.mPosition = paramInt;
              if (!this.aoC) {
                break;
              }
              paramInt = this.aoo.km() - i - this.aoo.bo(paramView);
              this.aoB = (this.aoo.km() - paramInt);
            } while (paramInt <= 0);
            i = this.aoo.br(paramView);
            j = this.aoB;
            k = this.aoo.kl();
            i = j - i - (k + Math.min(this.aoo.bn(paramView) - k, 0));
          } while (i >= 0);
          j = this.aoB;
          this.aoB = (Math.min(paramInt, -i) + j);
          return;
          j = this.aoo.bn(paramView);
          paramInt = j - this.aoo.kl();
          this.aoB = j;
        } while (paramInt <= 0);
        int k = this.aoo.br(paramView);
        int m = this.aoo.km();
        int n = this.aoo.bo(paramView);
        i = this.aoo.km() - Math.min(0, m - i - n) - (j + k);
      } while (i >= 0);
      this.aoB -= Math.min(paramInt, -i);
    }
    
    public final void D(View paramView, int paramInt)
    {
      if (this.aoC) {}
      for (this.aoB = (this.aoo.bo(paramView) + this.aoo.kk());; this.aoB = this.aoo.bn(paramView))
      {
        this.mPosition = paramInt;
        return;
      }
    }
    
    final void ka()
    {
      if (this.aoC) {}
      for (int i = this.aoo.km();; i = this.aoo.kl())
      {
        this.aoB = i;
        return;
      }
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.aoB = -2147483648;
      this.aoC = false;
      this.aoD = false;
    }
    
    public final String toString()
    {
      return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.aoB + ", mLayoutFromEnd=" + this.aoC + ", mValid=" + this.aoD + '}';
    }
  }
  
  protected static final class b
  {
    public boolean abD;
    public int aoE;
    public boolean aoF;
    public boolean mFinished;
    
    final void resetInternal()
    {
      this.aoE = 0;
      this.mFinished = false;
      this.aoF = false;
      this.abD = false;
    }
  }
  
  static final class c
  {
    int MW;
    boolean anT = true;
    int anU;
    int anV;
    int anW;
    int aoG;
    int aoH = 0;
    boolean aoI = false;
    int aoJ;
    List<RecyclerView.w> aoK = null;
    boolean aoa;
    int mLayoutDirection;
    
    private View bm(View paramView)
    {
      int m = this.aoK.size();
      Object localObject = null;
      int i = 2147483647;
      int j = 0;
      if (j < m)
      {
        View localView = ((RecyclerView.w)this.aoK.get(j)).asD;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((localView == paramView) || (localLayoutParams.arH.isRemoved())) {
          break label127;
        }
        int k = (localLayoutParams.arH.lu() - this.anV) * this.anW;
        if ((k < 0) || (k >= i)) {
          break label127;
        }
        localObject = localView;
        if (k != 0)
        {
          localObject = localView;
          i = k;
        }
      }
      label127:
      for (;;)
      {
        j += 1;
        break;
        return localObject;
      }
    }
    
    private View kb()
    {
      int j = this.aoK.size();
      int i = 0;
      while (i < j)
      {
        View localView = ((RecyclerView.w)this.aoK.get(i)).asD;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.arH.isRemoved()) && (this.anV == localLayoutParams.arH.lu()))
        {
          bl(localView);
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    final View a(RecyclerView.o paramo)
    {
      if (this.aoK != null) {
        return kb();
      }
      paramo = paramo.cv(this.anV);
      this.anV += this.anW;
      return paramo;
    }
    
    final boolean b(RecyclerView.t paramt)
    {
      return (this.anV >= 0) && (this.anV < paramt.getItemCount());
    }
    
    public final void bl(View paramView)
    {
      paramView = bm(paramView);
      if (paramView == null)
      {
        this.anV = -1;
        return;
      }
      this.anV = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).arH.lu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */