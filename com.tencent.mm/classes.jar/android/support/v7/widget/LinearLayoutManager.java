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
  private c aqf;
  aj aqg;
  private boolean aqh;
  private boolean aqi = false;
  boolean aqj = false;
  private boolean aqk = false;
  private boolean aql = true;
  int aqm = -1;
  int aqn = -2147483648;
  private boolean aqo;
  SavedState aqp = null;
  final a aqq = new a();
  private final b aqr = new b();
  public int aqs = 2;
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
    ap(paramContext.atw);
    ao(paramContext.atx);
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    int i = this.aqg.kC() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramo, paramt);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.aqg.kC() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.aqg.cf(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(RecyclerView.o paramo, c paramc, RecyclerView.t paramt, boolean paramBoolean)
  {
    int k = paramc.apM;
    if (paramc.aqy != -2147483648)
    {
      if (paramc.apM < 0) {
        paramc.aqy += paramc.apM;
      }
      a(paramo, paramc);
    }
    int i = paramc.apM + paramc.aqz;
    b localb = this.aqr;
    do
    {
      int j;
      do
      {
        if (((!paramc.apS) && (i <= 0)) || (!paramc.b(paramt))) {
          break;
        }
        localb.resetInternal();
        a(paramo, paramt, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.fq += localb.aqw * paramc.mLayoutDirection;
        if ((localb.aqx) && (this.aqf.aqC == null))
        {
          j = i;
          if (paramt.aug) {}
        }
        else
        {
          paramc.apM -= localb.aqw;
          j = i - localb.aqw;
        }
        if (paramc.aqy != -2147483648)
        {
          paramc.aqy += localb.aqw;
          if (paramc.apM < 0) {
            paramc.aqy += paramc.apM;
          }
          a(paramo, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.adu);
    return k - paramc.apM;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.t paramt)
  {
    int i = -1;
    int j = 1;
    this.aqf.apS = kg();
    this.aqf.aqz = c(paramt);
    this.aqf.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      paramt = this.aqf;
      paramt.aqz += this.aqg.getEndPadding();
      paramt = kj();
      localc = this.aqf;
      if (this.aqj) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.apO = paramInt1;
        this.aqf.apN = (bB(paramt) + this.aqf.apO);
        this.aqf.fq = this.aqg.bo(paramt);
        paramInt1 = this.aqg.bo(paramt) - this.aqg.kC();
        this.aqf.apM = paramInt2;
        if (paramBoolean)
        {
          paramt = this.aqf;
          paramt.apM -= paramInt1;
        }
        this.aqf.aqy = paramInt1;
        return;
      }
    }
    paramt = ki();
    c localc = this.aqf;
    localc.aqz += this.aqg.kB();
    localc = this.aqf;
    if (this.aqj) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.apO = paramInt1;
      this.aqf.apN = (bB(paramt) + this.aqf.apO);
      this.aqf.fq = this.aqg.bn(paramt);
      paramInt1 = -this.aqg.bn(paramt) + this.aqg.kB();
      break;
    }
  }
  
  private void a(a parama)
  {
    ae(parama.mPosition, parama.aqt);
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
    if ((!paramc.apL) || (paramc.apS)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramc.mLayoutDirection == -1)
      {
        i = paramc.aqy;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.aqg.getEnd() - i;
          if (this.aqj)
          {
            i = 0;
            while (i < j)
            {
              paramc = getChildAt(i);
              if ((this.aqg.bn(paramc) < k) || (this.aqg.bq(paramc) < k))
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
              if ((this.aqg.bn(paramc) < k) || (this.aqg.bq(paramc) < k))
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
        j = paramc.aqy;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.aqj)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if ((this.aqg.bo(paramc) > j) || (this.aqg.bp(paramc) > j))
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
              if ((this.aqg.bo(paramc) > j) || (this.aqg.bp(paramc) > j))
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
  
  private void ae(int paramInt1, int paramInt2)
  {
    this.aqf.apM = (this.aqg.kC() - paramInt2);
    c localc = this.aqf;
    if (this.aqj) {}
    for (int i = -1;; i = 1)
    {
      localc.apO = i;
      this.aqf.apN = paramInt1;
      this.aqf.mLayoutDirection = 1;
      this.aqf.fq = paramInt2;
      this.aqf.aqy = -2147483648;
      return;
    }
  }
  
  private void af(int paramInt1, int paramInt2)
  {
    this.aqf.apM = (paramInt2 - this.aqg.kB());
    this.aqf.apN = paramInt1;
    c localc = this.aqf;
    if (this.aqj) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.apO = paramInt1;
      this.aqf.mLayoutDirection = -1;
      this.aqf.fq = paramInt2;
      this.aqf.aqy = -2147483648;
      return;
    }
  }
  
  private View ah(int paramInt1, int paramInt2)
  {
    kf();
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
    if (this.aqg.bn(getChildAt(paramInt1)) < this.aqg.kB()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      return this.atj.k(paramInt1, paramInt2, j, i);
      j = 4161;
    }
    return this.atk.k(paramInt1, paramInt2, j, i);
  }
  
  private View aq(boolean paramBoolean)
  {
    if (this.aqj) {
      return c(getChildCount() - 1, -1, paramBoolean, true);
    }
    return c(0, getChildCount(), paramBoolean, true);
  }
  
  private View ar(boolean paramBoolean)
  {
    if (this.aqj) {
      return c(0, getChildCount(), paramBoolean, true);
    }
    return c(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt, boolean paramBoolean)
  {
    int i = paramInt - this.aqg.kB();
    if (i > 0)
    {
      int j = -c(i, paramo, paramt);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.aqg.kB();
        i = j;
        if (paramInt > 0)
        {
          this.aqg.cf(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(a parama)
  {
    af(parama.mPosition, parama.aqt);
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.aqf.apL = true;
    kf();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, paramt);
      k = this.aqf.aqy + a(paramo, this.aqf, paramt, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.aqg.cf(-paramInt);
    this.aqf.aqB = paramInt;
    return paramInt;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    kf();
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
        return this.atj.k(paramInt1, paramInt2, i, j);
        i = 320;
        break;
      }
      return this.atk.k(paramInt1, paramInt2, i, j);
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
    kf();
    aj localaj = this.aqg;
    View localView;
    if (!this.aql)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.aql) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, ar(bool1), this, this.aql, this.aqj);
      bool1 = false;
      break;
    }
  }
  
  private int k(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    kf();
    aj localaj = this.aqg;
    View localView;
    if (!this.aql)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.aql) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(paramt, localaj, localView, ar(bool1), this, this.aql);
      bool1 = false;
      break;
    }
  }
  
  private void ke()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!jy())) {
      bool = this.aqi;
    }
    for (;;)
    {
      this.aqj = bool;
      return;
      if (this.aqi) {
        bool = false;
      }
    }
  }
  
  private boolean kg()
  {
    return (this.aqg.getMode() == 0) && (this.aqg.getEnd() == 0);
  }
  
  private View ki()
  {
    if (this.aqj) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View kj()
  {
    if (this.aqj) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View kk()
  {
    return ah(0, getChildCount());
  }
  
  private View kl()
  {
    return ah(getChildCount() - 1, -1);
  }
  
  private int l(RecyclerView.t paramt)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    kf();
    aj localaj = this.aqg;
    View localView;
    if (!this.aql)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.aql) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(paramt, localaj, localView, ar(bool1), this, this.aql);
      bool1 = false;
      break;
    }
  }
  
  public final void F(String paramString)
  {
    if (this.aqp == null) {
      super.F(paramString);
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
    kf();
    int j = this.aqg.kB();
    int k = this.aqg.kC();
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
      if (!((RecyclerView.LayoutParams)paramt.getLayoutParams()).aty.isRemoved()) {
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
      if (this.aqg.bn(paramt) < k)
      {
        localObject = paramt;
        if (this.aqg.bo(paramt) >= j) {}
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
    ke();
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = cc(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    kf();
    kf();
    a(paramInt, (int)(0.3333333F * this.aqg.kD()), false, paramt);
    this.aqf.aqy = -2147483648;
    this.aqf.apL = false;
    a(paramo, this.aqf, paramt, true);
    if (paramInt == -1) {
      if (this.aqj)
      {
        paramView = kl();
        label105:
        paramo = paramView;
        if (paramInt != -1) {
          break label163;
        }
      }
    }
    label163:
    for (paramView = ki();; paramView = kj())
    {
      if (!paramView.hasFocusable()) {
        return paramo;
      }
      if (paramo != null) {
        break;
      }
      return null;
      paramView = kk();
      break label105;
      if (this.aqj) {}
      for (paramView = kk();; paramView = kl())
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
    kf();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, paramt);
      a(paramt, this.aqf, parama);
      return;
    }
  }
  
  public final void a(int paramInt, RecyclerView.i.a parama)
  {
    boolean bool;
    int i;
    if ((this.aqp != null) && (this.aqp.ks()))
    {
      bool = this.aqp.aqF;
      i = this.aqp.aqD;
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
      while ((i < this.aqs) && (k >= 0) && (k < paramInt))
      {
        parama.S(k, 0);
        k += j;
        i += 1;
      }
      ke();
      bool = this.aqj;
      if (this.aqm == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.aqm;
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
    if (paramc.aqC == null)
    {
      bool2 = this.aqj;
      if (paramc.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label215;
        }
        addView(paramo, -1);
        bD(paramo);
        paramb.aqw = this.aqg.br(paramo);
        if (this.mOrientation != 1) {
          break label331;
        }
        if (!jy()) {
          break label272;
        }
        i = this.mWidth - getPaddingRight();
        j = i - this.aqg.bs(paramo);
        if (paramc.mLayoutDirection != -1) {
          break label294;
        }
        i1 = paramc.fq;
        n = paramc.fq - paramb.aqw;
        m = i;
        k = j;
        j = i1;
        i = n;
      }
    }
    for (;;)
    {
      k(paramo, k, i, m, j);
      if ((paramt.aty.isRemoved()) || (paramt.aty.md())) {
        paramb.aqx = true;
      }
      paramb.adu = paramo.hasFocusable();
      return;
      bool1 = false;
      break;
      label215:
      addView(paramo, 0);
      break label62;
      bool2 = this.aqj;
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
      i = this.aqg.bs(paramo) + j;
      break label119;
      label294:
      i1 = paramc.fq;
      n = paramc.fq + paramb.aqw;
      k = j;
      m = i;
      i = i1;
      j = n;
      continue;
      label331:
      j = getPaddingTop();
      i = this.aqg.bs(paramo) + j;
      if (paramc.mLayoutDirection == -1)
      {
        m = paramc.fq;
        n = paramc.fq - paramb.aqw;
        k = i;
        i = j;
        j = k;
        k = n;
      }
      else
      {
        n = paramc.fq;
        m = paramc.fq + paramb.aqw;
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
    this.aqp = null;
    this.aqm = -1;
    this.aqn = -2147483648;
    this.aqq.reset();
  }
  
  void a(RecyclerView.t paramt, c paramc, RecyclerView.i.a parama)
  {
    int i = paramc.apN;
    if ((i >= 0) && (i < paramt.getItemCount())) {
      parama.S(i, Math.max(0, paramc.aqy));
    }
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.aqo)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.atQ = paramInt;
    a(paramRecyclerView);
  }
  
  public void ag(int paramInt1, int paramInt2)
  {
    this.aqm = paramInt1;
    this.aqn = paramInt2;
    if (this.aqp != null) {
      this.aqp.aqD = -1;
    }
    requestLayout();
  }
  
  public void ao(boolean paramBoolean)
  {
    F(null);
    if (this.aqk == paramBoolean) {
      return;
    }
    this.aqk = paramBoolean;
    requestLayout();
  }
  
  public void ap(boolean paramBoolean)
  {
    F(null);
    if (paramBoolean == this.aqi) {
      return;
    }
    this.aqi = paramBoolean;
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
    if (j != this.aqj) {
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
    if (paramt.atQ != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = this.aqg.kD();
      }
      return j;
    }
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (((this.aqp != null) || (this.aqm != -1)) && (paramt.getItemCount() == 0))
    {
      d(paramo);
      return;
    }
    if ((this.aqp != null) && (this.aqp.ks())) {
      this.aqm = this.aqp.aqD;
    }
    kf();
    this.aqf.apL = false;
    ke();
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
    if ((!this.aqq.aqv) || (this.aqm != -1) || (this.aqp != null))
    {
      this.aqq.reset();
      this.aqq.aqu = (this.aqj ^ this.aqk);
      localObject2 = this.aqq;
      if ((paramt.aug) || (this.aqm == -1))
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
          if ((localLayoutParams.aty.isRemoved()) || (localLayoutParams.aty.lM() < 0) || (localLayoutParams.aty.lM() >= paramt.getItemCount())) {
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
            ((a)localObject2).kq();
            if (!this.aqk) {
              break label1442;
            }
            i = paramt.getItemCount() - 1;
            ((a)localObject2).mPosition = i;
          }
        }
        this.aqq.aqv = true;
        i = c(paramt);
        if (this.aqf.aqB < 0) {
          break label1507;
        }
        j = 0;
        m = this.aqg.kB() + j;
        n = i + this.aqg.getEndPadding();
        j = n;
        k = m;
        if (paramt.aug)
        {
          j = n;
          k = m;
          if (this.aqm != -1)
          {
            j = n;
            k = m;
            if (this.aqn != -2147483648)
            {
              localObject1 = bY(this.aqm);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.aqj) {
                  break label1519;
                }
                i = this.aqg.kC() - this.aqg.bo((View)localObject1) - this.aqn;
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
        if (!this.aqq.aqu) {
          break label1569;
        }
        if (!this.aqj) {
          break label1564;
        }
        i = 1;
        label451:
        a(paramo, paramt, this.aqq, i);
        b(paramo);
        this.aqf.apS = kg();
        this.aqf.aqA = paramt.aug;
        if (!this.aqq.aqu) {
          break label1586;
        }
        b(this.aqq);
        this.aqf.aqz = k;
        a(paramo, this.aqf, paramt, false);
        k = this.aqf.fq;
        m = this.aqf.apN;
        i = j;
        if (this.aqf.apM > 0) {
          i = j + this.aqf.apM;
        }
        a(this.aqq);
        this.aqf.aqz = i;
        localObject1 = this.aqf;
        ((c)localObject1).apN += this.aqf.apO;
        a(paramo, this.aqf, paramt, false);
        i = this.aqf.fq;
        if (this.aqf.apM <= 0) {
          break label2172;
        }
        j = this.aqf.apM;
        af(m, k);
        this.aqf.aqz = j;
        a(paramo, this.aqf, paramt, false);
        j = this.aqf.fq;
      }
    }
    for (;;)
    {
      label687:
      if (getChildCount() > 0) {
        if ((this.aqj ^ this.aqk))
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
        if ((!paramt.auk) || (getChildCount() == 0) || (paramt.aug) || (!ka()))
        {
          if (paramt.aug) {
            break label2129;
          }
          paramo = this.aqg;
          paramo.arx = paramo.kD();
          this.aqh = this.aqk;
          return;
          if ((this.aqm < 0) || (this.aqm >= paramt.getItemCount()))
          {
            this.aqm = -1;
            this.aqn = -2147483648;
            i = 0;
            break;
          }
          ((a)localObject2).mPosition = this.aqm;
          if ((this.aqp != null) && (this.aqp.ks()))
          {
            ((a)localObject2).aqu = this.aqp.aqF;
            if (((a)localObject2).aqu) {}
            for (((a)localObject2).aqt = (this.aqg.kC() - this.aqp.aqE);; ((a)localObject2).aqt = (this.aqg.kB() + this.aqp.aqE))
            {
              i = 1;
              break;
            }
          }
          if (this.aqn == -2147483648)
          {
            localObject1 = bY(this.aqm);
            if (localObject1 != null) {
              if (this.aqg.br((View)localObject1) > this.aqg.kD()) {
                ((a)localObject2).kq();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.aqg.bn((View)localObject1) - this.aqg.kB() < 0)
            {
              ((a)localObject2).aqt = this.aqg.kB();
              ((a)localObject2).aqu = false;
            }
            else if (this.aqg.kC() - this.aqg.bo((View)localObject1) < 0)
            {
              ((a)localObject2).aqt = this.aqg.kC();
              ((a)localObject2).aqu = true;
            }
            else
            {
              if (((a)localObject2).aqu) {}
              for (i = this.aqg.bo((View)localObject1) + this.aqg.kA();; i = this.aqg.bn((View)localObject1))
              {
                ((a)localObject2).aqt = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = bB(getChildAt(0));
                if (this.aqm >= i) {
                  break label1174;
                }
                bool = true;
                label1147:
                if (bool != this.aqj) {
                  break label1180;
                }
              }
              label1174:
              label1180:
              for (bool = true;; bool = false)
              {
                ((a)localObject2).aqu = bool;
                ((a)localObject2).kq();
                break;
                bool = false;
                break label1147;
              }
              ((a)localObject2).aqu = this.aqj;
              if (this.aqj) {
                ((a)localObject2).aqt = (this.aqg.kC() - this.aqn);
              } else {
                ((a)localObject2).aqt = (this.aqg.kB() + this.aqn);
              }
            }
          }
          label1242:
          i = 0;
          break label220;
          label1247:
          if (this.aqh == this.aqk)
          {
            if (((a)localObject2).aqu)
            {
              if (this.aqj) {
                break label1401;
              }
              localObject1 = d(paramo, paramt);
              if (localObject1 == null) {
                break label1437;
              }
              ((a)localObject2).D((View)localObject1, bB((View)localObject1));
              if ((!paramt.aug) && (ka()))
              {
                if ((this.aqg.bn((View)localObject1) < this.aqg.kC()) && (this.aqg.bo((View)localObject1) >= this.aqg.kB())) {
                  break label1421;
                }
                i = 1;
                if (i != 0) {
                  if (!((a)localObject2).aqu) {
                    break label1426;
                  }
                }
              }
            }
            for (i = this.aqg.kC();; i = this.aqg.kB())
            {
              ((a)localObject2).aqt = i;
              i = 1;
              break;
              if (this.aqj)
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
          if ((localObject1 == null) || ((this.aqg.bn((View)localObject1) < this.aqg.kC()) && (this.aqg.bo((View)localObject1) > this.aqg.kB()))) {
            break label275;
          }
          this.aqq.C((View)localObject1, bB((View)localObject1));
          break label275;
          label1507:
          k = 0;
          j = i;
          i = k;
          break label294;
          label1519:
          i = this.aqg.bn((View)localObject1);
          j = this.aqg.kB();
          i = this.aqn - (i - j);
          break label418;
          label1551:
          j = n - i;
          k = m;
          break label432;
          label1564:
          i = -1;
          break label451;
          label1569:
          if (this.aqj)
          {
            i = -1;
            break label451;
          }
          i = 1;
          break label451;
          label1586:
          a(this.aqq);
          this.aqf.aqz = j;
          a(paramo, this.aqf, paramt, false);
          j = this.aqf.fq;
          m = this.aqf.apN;
          i = k;
          if (this.aqf.apM > 0) {
            i = k + this.aqf.apM;
          }
          b(this.aqq);
          this.aqf.aqz = i;
          localObject1 = this.aqf;
          ((c)localObject1).apN += this.aqf.apO;
          a(paramo, this.aqf, paramt, false);
          k = this.aqf.fq;
          if (this.aqf.apM <= 0) {
            break label2162;
          }
          i = this.aqf.apM;
          ae(m, j);
          this.aqf.aqz = i;
          a(paramo, this.aqf, paramt, false);
          i = this.aqf.fq;
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
        localObject1 = paramo.atK;
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
          if (((RecyclerView.w)localObject2).lM() < i3)
          {
            bool = true;
            if (bool == this.aqj) {
              break label1969;
            }
            i1 = -1;
            label1911:
            if (i1 != -1) {
              break label1975;
            }
            i1 = this.aqg.br(((RecyclerView.w)localObject2).auu) + j;
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
          i1 = i + this.aqg.br(((RecyclerView.w)localObject2).auu);
          i = j;
          j = i1;
          continue;
          this.aqf.aqC = ((List)localObject1);
          if (j > 0)
          {
            af(bB(ki()), m);
            this.aqf.aqz = j;
            this.aqf.apM = 0;
            this.aqf.bl(null);
            a(paramo, this.aqf, paramt, false);
          }
          if (i > 0)
          {
            ae(bB(kj()), k);
            this.aqf.aqz = i;
            this.aqf.apM = 0;
            this.aqf.bl(null);
            a(paramo, this.aqf, paramt, false);
          }
          this.aqf.aqC = null;
          break;
          label2129:
          this.aqq.reset();
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
    this.aqm = paramInt;
    this.aqn = -2147483648;
    if (this.aqp != null) {
      this.aqp.aqD = -1;
    }
    requestLayout();
  }
  
  public final void cb(int paramInt)
  {
    this.aqs = paramInt;
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
            } while (!jy());
            return 1;
            if (this.mOrientation == 1) {
              return 1;
            }
            paramInt = i;
          } while (jy());
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
    F("Cannot drop a view during a scroll or layout calculation");
    kf();
    ke();
    int i = bB(paramView1);
    int j = bB(paramView2);
    if (i < j) {
      i = 1;
    }
    while (this.aqj) {
      if (i == 1)
      {
        ag(j, this.aqg.kC() - (this.aqg.bn(paramView2) + this.aqg.br(paramView1)));
        return;
        i = -1;
      }
      else
      {
        ag(j, this.aqg.kC() - this.aqg.bo(paramView2));
        return;
      }
    }
    if (i == -1)
    {
      ag(j, this.aqg.bn(paramView2));
      return;
    }
    ag(j, this.aqg.bo(paramView2) - this.aqg.br(paramView1));
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
  
  public RecyclerView.LayoutParams jW()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  protected final boolean jy()
  {
    return t.Y(this.anl) == 1;
  }
  
  public boolean ka()
  {
    return (this.aqp == null) && (this.aqh == this.aqk);
  }
  
  public final boolean kb()
  {
    return true;
  }
  
  public boolean kc()
  {
    return this.mOrientation == 0;
  }
  
  public boolean kd()
  {
    return this.mOrientation == 1;
  }
  
  protected void kf()
  {
    if (this.aqf == null) {
      this.aqf = new c();
    }
  }
  
  final boolean kh()
  {
    if ((this.att != 1073741824) && (this.ats != 1073741824))
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
  
  public final int km()
  {
    View localView = c(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int kn()
  {
    View localView = c(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int ko()
  {
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int kp()
  {
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(km());
      paramAccessibilityEvent.setToIndex(ko());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.aqp = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.aqp != null) {
      return new SavedState(this.aqp);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      kf();
      boolean bool = this.aqh ^ this.aqj;
      localSavedState.aqF = bool;
      if (bool)
      {
        localView = kj();
        localSavedState.aqE = (this.aqg.kC() - this.aqg.bo(localView));
        localSavedState.aqD = bB(localView);
        return localSavedState;
      }
      View localView = ki();
      localSavedState.aqD = bB(localView);
      localSavedState.aqE = (this.aqg.bn(localView) - this.aqg.kB());
      return localSavedState;
    }
    localSavedState.aqD = -1;
    return localSavedState;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    F(null);
    if ((paramInt != this.mOrientation) || (this.aqg == null))
    {
      this.aqg = aj.a(this, paramInt);
      this.aqq.aqg = this.aqg;
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int aqD;
    int aqE;
    boolean aqF;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.aqD = paramParcel.readInt();
      this.aqE = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.aqF = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.aqD = paramSavedState.aqD;
      this.aqE = paramSavedState.aqE;
      this.aqF = paramSavedState.aqF;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final boolean ks()
    {
      return this.aqD >= 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.aqD);
      paramParcel.writeInt(this.aqE);
      if (this.aqF) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  static final class a
  {
    aj aqg;
    int aqt;
    boolean aqu;
    boolean aqv;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    public final void C(View paramView, int paramInt)
    {
      int i = this.aqg.kA();
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
              if (!this.aqu) {
                break;
              }
              paramInt = this.aqg.kC() - i - this.aqg.bo(paramView);
              this.aqt = (this.aqg.kC() - paramInt);
            } while (paramInt <= 0);
            i = this.aqg.br(paramView);
            j = this.aqt;
            k = this.aqg.kB();
            i = j - i - (k + Math.min(this.aqg.bn(paramView) - k, 0));
          } while (i >= 0);
          j = this.aqt;
          this.aqt = (Math.min(paramInt, -i) + j);
          return;
          j = this.aqg.bn(paramView);
          paramInt = j - this.aqg.kB();
          this.aqt = j;
        } while (paramInt <= 0);
        int k = this.aqg.br(paramView);
        int m = this.aqg.kC();
        int n = this.aqg.bo(paramView);
        i = this.aqg.kC() - Math.min(0, m - i - n) - (j + k);
      } while (i >= 0);
      this.aqt -= Math.min(paramInt, -i);
    }
    
    public final void D(View paramView, int paramInt)
    {
      if (this.aqu) {}
      for (this.aqt = (this.aqg.bo(paramView) + this.aqg.kA());; this.aqt = this.aqg.bn(paramView))
      {
        this.mPosition = paramInt;
        return;
      }
    }
    
    final void kq()
    {
      if (this.aqu) {}
      for (int i = this.aqg.kC();; i = this.aqg.kB())
      {
        this.aqt = i;
        return;
      }
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.aqt = -2147483648;
      this.aqu = false;
      this.aqv = false;
    }
    
    public final String toString()
    {
      return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.aqt + ", mLayoutFromEnd=" + this.aqu + ", mValid=" + this.aqv + '}';
    }
  }
  
  protected static final class b
  {
    public boolean adu;
    public int aqw;
    public boolean aqx;
    public boolean mFinished;
    
    final void resetInternal()
    {
      this.aqw = 0;
      this.mFinished = false;
      this.aqx = false;
      this.adu = false;
    }
  }
  
  static final class c
  {
    boolean apL = true;
    int apM;
    int apN;
    int apO;
    boolean apS;
    boolean aqA = false;
    int aqB;
    List<RecyclerView.w> aqC = null;
    int aqy;
    int aqz = 0;
    int fq;
    int mLayoutDirection;
    
    private View bm(View paramView)
    {
      int m = this.aqC.size();
      Object localObject = null;
      int i = 2147483647;
      int j = 0;
      if (j < m)
      {
        View localView = ((RecyclerView.w)this.aqC.get(j)).auu;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((localView == paramView) || (localLayoutParams.aty.isRemoved())) {
          break label127;
        }
        int k = (localLayoutParams.aty.lM() - this.apN) * this.apO;
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
    
    private View kr()
    {
      int j = this.aqC.size();
      int i = 0;
      while (i < j)
      {
        View localView = ((RecyclerView.w)this.aqC.get(i)).auu;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.aty.isRemoved()) && (this.apN == localLayoutParams.aty.lM()))
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
      if (this.aqC != null) {
        return kr();
      }
      paramo = paramo.cv(this.apN);
      this.apN += this.apO;
      return paramo;
    }
    
    final boolean b(RecyclerView.t paramt)
    {
      return (this.apN >= 0) && (this.apN < paramt.getItemCount());
    }
    
    public final void bl(View paramView)
    {
      paramView = bm(paramView);
      if (paramView == null)
      {
        this.apN = -1;
        return;
      }
      this.apN = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aty.lM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */