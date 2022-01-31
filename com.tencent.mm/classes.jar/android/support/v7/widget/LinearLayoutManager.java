package android.support.v7.widget;

import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.i
  implements RecyclerView.r.b
{
  private LinearLayoutManager.c agl;
  aj agm;
  private boolean agn;
  private boolean ago = false;
  boolean agp = false;
  private boolean agq = false;
  private boolean agr = true;
  int ags = -1;
  int agt = -2147483648;
  private boolean agu;
  LinearLayoutManager.SavedState agv = null;
  final LinearLayoutManager.a agw = new LinearLayoutManager.a();
  private final LinearLayoutManager.b agx = new LinearLayoutManager.b();
  public int agy = 2;
  int mOrientation = 1;
  
  public LinearLayoutManager()
  {
    this(1);
  }
  
  public LinearLayoutManager(int paramInt)
  {
    setOrientation(paramInt);
    ai(false);
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = this.agm.iJ() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramo, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.agm.iJ() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.agm.bN(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(RecyclerView.o paramo, LinearLayoutManager.c paramc, RecyclerView.s params, boolean paramBoolean)
  {
    int k = paramc.afS;
    if (paramc.agE != -2147483648)
    {
      if (paramc.afS < 0) {
        paramc.agE += paramc.afS;
      }
      a(paramo, paramc);
    }
    int i = paramc.afS + paramc.agF;
    LinearLayoutManager.b localb = this.agx;
    do
    {
      int j;
      do
      {
        if (((!paramc.afY) && (i <= 0)) || (!paramc.b(params))) {
          break;
        }
        localb.resetInternal();
        a(paramo, params, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.Fb += localb.agC * paramc.mLayoutDirection;
        if ((localb.agD) && (this.agl.agI == null))
        {
          j = i;
          if (params.akg) {}
        }
        else
        {
          paramc.afS -= localb.agC;
          j = i - localb.agC;
        }
        if (paramc.agE != -2147483648)
        {
          paramc.agE += localb.agC;
          if (paramc.afS < 0) {
            paramc.agE += paramc.afS;
          }
          a(paramo, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.TF);
    return k - paramc.afS;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.s params)
  {
    int i = -1;
    int j = 1;
    this.agl.afY = in();
    this.agl.agF = c(params);
    this.agl.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      params = this.agl;
      params.agF += this.agm.getEndPadding();
      params = iq();
      localc = this.agl;
      if (this.agp) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.afU = paramInt1;
        this.agl.afT = (bv(params) + this.agl.afU);
        this.agl.Fb = this.agm.bi(params);
        paramInt1 = this.agm.bi(params) - this.agm.iJ();
        this.agl.afS = paramInt2;
        if (paramBoolean)
        {
          params = this.agl;
          params.afS -= paramInt1;
        }
        this.agl.agE = paramInt1;
        return;
      }
    }
    params = ip();
    LinearLayoutManager.c localc = this.agl;
    localc.agF += this.agm.iI();
    localc = this.agl;
    if (this.agp) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.afU = paramInt1;
      this.agl.afT = (bv(params) + this.agl.afU);
      this.agl.Fb = this.agm.bh(params);
      paramInt1 = -this.agm.bh(params) + this.agm.iI();
      break;
    }
  }
  
  private void a(LinearLayoutManager.a parama)
  {
    ab(parama.mPosition, parama.agz);
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
    if ((!paramc.afR) || (paramc.afY)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramc.mLayoutDirection == -1)
      {
        i = paramc.agE;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.agm.getEnd() - i;
          if (this.agp)
          {
            i = 0;
            while (i < j)
            {
              paramc = getChildAt(i);
              if ((this.agm.bh(paramc) < k) || (this.agm.bk(paramc) < k))
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
              if ((this.agm.bh(paramc) < k) || (this.agm.bk(paramc) < k))
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
        j = paramc.agE;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.agp)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if ((this.agm.bi(paramc) > j) || (this.agm.bj(paramc) > j))
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
              if ((this.agm.bi(paramc) > j) || (this.agm.bj(paramc) > j))
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
  
  private void ab(int paramInt1, int paramInt2)
  {
    this.agl.afS = (this.agm.iJ() - paramInt2);
    LinearLayoutManager.c localc = this.agl;
    if (this.agp) {}
    for (int i = -1;; i = 1)
    {
      localc.afU = i;
      this.agl.afT = paramInt1;
      this.agl.mLayoutDirection = 1;
      this.agl.Fb = paramInt2;
      this.agl.agE = -2147483648;
      return;
    }
  }
  
  private void ac(int paramInt1, int paramInt2)
  {
    this.agl.afS = (paramInt2 - this.agm.iI());
    this.agl.afT = paramInt1;
    LinearLayoutManager.c localc = this.agl;
    if (this.agp) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.afU = paramInt1;
      this.agl.mLayoutDirection = -1;
      this.agl.Fb = paramInt2;
      this.agl.agE = -2147483648;
      return;
    }
  }
  
  private View ae(int paramInt1, int paramInt2)
  {
    im();
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
    if (this.agm.bh(getChildAt(paramInt1)) < this.agm.iI()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      return this.ajm.k(paramInt1, paramInt2, j, i);
      j = 4161;
    }
    return this.ajn.k(paramInt1, paramInt2, j, i);
  }
  
  private View aj(boolean paramBoolean)
  {
    if (this.agp) {
      return c(getChildCount() - 1, -1, paramBoolean, true);
    }
    return c(0, getChildCount(), paramBoolean, true);
  }
  
  private View ak(boolean paramBoolean)
  {
    if (this.agp) {
      return c(0, getChildCount(), paramBoolean, true);
    }
    return c(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = paramInt - this.agm.iI();
    if (i > 0)
    {
      int j = -c(i, paramo, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.agm.iI();
        i = j;
        if (paramInt > 0)
        {
          this.agm.bN(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(LinearLayoutManager.a parama)
  {
    ac(parama.mPosition, parama.agz);
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.agl.afR = true;
    im();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, params);
      k = this.agl.agE + a(paramo, this.agl, params, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.agm.bN(-paramInt);
    this.agl.agH = paramInt;
    return paramInt;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    im();
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
        return this.ajm.k(paramInt1, paramInt2, i, j);
        i = 320;
        break;
      }
      return this.ajn.k(paramInt1, paramInt2, i, j);
      label66:
      j = 0;
    }
  }
  
  private View d(RecyclerView.o paramo, RecyclerView.s params)
  {
    return a(paramo, params, getChildCount() - 1, -1, params.getItemCount());
  }
  
  private void il()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!hE())) {
      bool = this.ago;
    }
    for (;;)
    {
      this.agp = bool;
      return;
      if (this.ago) {
        bool = false;
      }
    }
  }
  
  private boolean in()
  {
    return (this.agm.getMode() == 0) && (this.agm.getEnd() == 0);
  }
  
  private View ip()
  {
    if (this.agp) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View iq()
  {
    if (this.agp) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View ir()
  {
    return ae(0, getChildCount());
  }
  
  private View is()
  {
    return ae(getChildCount() - 1, -1);
  }
  
  private int j(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    im();
    aj localaj = this.agm;
    View localView;
    if (!this.agr)
    {
      bool1 = true;
      localView = aj(bool1);
      if (this.agr) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, ak(bool1), this, this.agr, this.agp);
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
    im();
    aj localaj = this.agm;
    View localView;
    if (!this.agr)
    {
      bool1 = true;
      localView = aj(bool1);
      if (this.agr) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, ak(bool1), this, this.agr);
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
    im();
    aj localaj = this.agm;
    View localView;
    if (!this.agr)
    {
      bool1 = true;
      localView = aj(bool1);
      if (this.agr) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(params, localaj, localView, ak(bool1), this, this.agr);
      bool1 = false;
      break;
    }
  }
  
  public final void S(String paramString)
  {
    if (this.agv == null) {
      super.S(paramString);
    }
  }
  
  public int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return c(paramInt, paramo, params);
  }
  
  View a(RecyclerView.o paramo, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    im();
    int j = this.agm.iI();
    int k = this.agm.iJ();
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
      int m = bv(params);
      if ((m < 0) || (m >= paramInt3)) {
        break label155;
      }
      if (!((RecyclerView.LayoutParams)params.getLayoutParams()).ajy.isRemoved()) {
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
      if (this.agm.bh(params) < k)
      {
        localObject = params;
        if (this.agm.bi(params) >= j) {}
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
    il();
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = bK(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    im();
    im();
    a(paramInt, (int)(0.3333333F * this.agm.iK()), false, params);
    this.agl.agE = -2147483648;
    this.agl.afR = false;
    a(paramo, this.agl, params, true);
    if (paramInt == -1) {
      if (this.agp)
      {
        paramView = is();
        label105:
        paramo = paramView;
        if (paramInt != -1) {
          break label163;
        }
      }
    }
    label163:
    for (paramView = ip();; paramView = iq())
    {
      if (!paramView.hasFocusable()) {
        return paramo;
      }
      if (paramo != null) {
        break;
      }
      return null;
      paramView = ir();
      break label105;
      if (this.agp) {}
      for (paramView = ir();; paramView = is())
      {
        paramo = paramView;
        break;
      }
    }
    return paramo;
  }
  
  public final void a(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.i.a parama)
  {
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      return;
      paramInt1 = paramInt2;
    }
    im();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, params);
      a(params, this.agl, parama);
      return;
    }
  }
  
  public final void a(int paramInt, RecyclerView.i.a parama)
  {
    boolean bool;
    int i;
    if ((this.agv != null) && (this.agv.iz()))
    {
      bool = this.agv.agL;
      i = this.agv.agJ;
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
      while ((i < this.agy) && (k >= 0) && (k < paramInt))
      {
        parama.P(k, 0);
        k += j;
        i += 1;
      }
      il();
      bool = this.agp;
      if (this.ags == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.ags;
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
    label62:
    int i;
    int j;
    label119:
    int i1;
    int n;
    int m;
    int k;
    if (paramc.agI == null)
    {
      bool2 = this.agp;
      if (paramc.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label215;
        }
        addView(paramo, -1);
        bw(paramo);
        paramb.agC = this.agm.bl(paramo);
        if (this.mOrientation != 1) {
          break label331;
        }
        if (!hE()) {
          break label272;
        }
        i = this.mWidth - getPaddingRight();
        j = i - this.agm.bm(paramo);
        if (paramc.mLayoutDirection != -1) {
          break label294;
        }
        i1 = paramc.Fb;
        n = paramc.Fb - paramb.agC;
        m = i;
        k = j;
        j = i1;
        i = n;
      }
    }
    for (;;)
    {
      k(paramo, k, i, m, j);
      if ((params.ajy.isRemoved()) || (params.ajy.kb())) {
        paramb.agD = true;
      }
      paramb.TF = paramo.hasFocusable();
      return;
      bool1 = false;
      break;
      label215:
      addView(paramo, 0);
      break label62;
      bool2 = this.agp;
      if (paramc.mLayoutDirection == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label263;
        }
        C(paramo, -1);
        break;
      }
      label263:
      C(paramo, 0);
      break label62;
      label272:
      j = getPaddingLeft();
      i = this.agm.bm(paramo) + j;
      break label119;
      label294:
      i1 = paramc.Fb;
      n = paramc.Fb + paramb.agC;
      k = j;
      m = i;
      i = i1;
      j = n;
      continue;
      label331:
      j = getPaddingTop();
      i = this.agm.bm(paramo) + j;
      if (paramc.mLayoutDirection == -1)
      {
        m = paramc.Fb;
        n = paramc.Fb - paramb.agC;
        k = i;
        i = j;
        j = k;
        k = n;
      }
      else
      {
        n = paramc.Fb;
        m = paramc.Fb + paramb.agC;
        k = i;
        i = j;
        j = k;
        k = n;
      }
    }
  }
  
  public void a(RecyclerView.s params)
  {
    super.a(params);
    this.agv = null;
    this.ags = -1;
    this.agt = -2147483648;
    this.agw.reset();
  }
  
  void a(RecyclerView.s params, LinearLayoutManager.c paramc, RecyclerView.i.a parama)
  {
    int i = paramc.afT;
    if ((i >= 0) && (i < params.getItemCount())) {
      parama.P(i, Math.max(0, paramc.agE));
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.ajQ = paramInt;
    a(paramRecyclerView);
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.agu)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public void ad(int paramInt1, int paramInt2)
  {
    this.ags = paramInt1;
    this.agt = paramInt2;
    if (this.agv != null) {
      this.agv.agJ = -1;
    }
    requestLayout();
  }
  
  public void ai(boolean paramBoolean)
  {
    S(null);
    if (paramBoolean == this.ago) {
      return;
    }
    this.ago = paramBoolean;
    requestLayout();
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return c(paramInt, paramo, params);
  }
  
  public View bH(int paramInt)
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
      int j = paramInt - bv(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (bv(localView) == paramInt);
    return super.bH(paramInt);
  }
  
  public final PointF bI(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < bv(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.agp) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public void bJ(int paramInt)
  {
    this.ags = paramInt;
    this.agt = -2147483648;
    if (this.agv != null) {
      this.agv.agJ = -1;
    }
    requestLayout();
  }
  
  final int bK(int paramInt)
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
            } while (!hE());
            return 1;
            if (this.mOrientation == 1) {
              return 1;
            }
            paramInt = i;
          } while (hE());
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
  
  protected int c(RecyclerView.s params)
  {
    int j = 0;
    if (params.ajQ != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = this.agm.iK();
      }
      return j;
    }
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (((this.agv != null) || (this.ags != -1)) && (params.getItemCount() == 0))
    {
      d(paramo);
      return;
    }
    if ((this.agv != null) && (this.agv.iz())) {
      this.ags = this.agv.agJ;
    }
    im();
    this.agl.afR = false;
    il();
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
    if ((!this.agw.agB) || (this.ags != -1) || (this.agv != null))
    {
      this.agw.reset();
      this.agw.agA = (this.agp ^ this.agq);
      localObject2 = this.agw;
      if ((params.akg) || (this.ags == -1))
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
          if ((localLayoutParams.ajy.isRemoved()) || (localLayoutParams.ajy.jM() < 0) || (localLayoutParams.ajy.jM() >= params.getItemCount())) {
            break label1242;
          }
          i = 1;
          if (i == 0) {
            break label1247;
          }
          ((LinearLayoutManager.a)localObject2).A((View)localObject1, bv((View)localObject1));
          i = 1;
          if (i == 0)
          {
            ((LinearLayoutManager.a)localObject2).ix();
            if (!this.agq) {
              break label1442;
            }
            i = params.getItemCount() - 1;
            ((LinearLayoutManager.a)localObject2).mPosition = i;
          }
        }
        this.agw.agB = true;
        i = c(params);
        if (this.agl.agH < 0) {
          break label1507;
        }
        j = 0;
        m = this.agm.iI() + j;
        n = i + this.agm.getEndPadding();
        j = n;
        k = m;
        if (params.akg)
        {
          j = n;
          k = m;
          if (this.ags != -1)
          {
            j = n;
            k = m;
            if (this.agt != -2147483648)
            {
              localObject1 = bH(this.ags);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.agp) {
                  break label1519;
                }
                i = this.agm.iJ() - this.agm.bi((View)localObject1) - this.agt;
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
        if (!this.agw.agA) {
          break label1569;
        }
        if (!this.agp) {
          break label1564;
        }
        i = 1;
        label451:
        a(paramo, params, this.agw, i);
        b(paramo);
        this.agl.afY = in();
        this.agl.agG = params.akg;
        if (!this.agw.agA) {
          break label1586;
        }
        b(this.agw);
        this.agl.agF = k;
        a(paramo, this.agl, params, false);
        k = this.agl.Fb;
        m = this.agl.afT;
        i = j;
        if (this.agl.afS > 0) {
          i = j + this.agl.afS;
        }
        a(this.agw);
        this.agl.agF = i;
        localObject1 = this.agl;
        ((LinearLayoutManager.c)localObject1).afT += this.agl.afU;
        a(paramo, this.agl, params, false);
        i = this.agl.Fb;
        if (this.agl.afS <= 0) {
          break label2172;
        }
        j = this.agl.afS;
        ac(m, k);
        this.agl.agF = j;
        a(paramo, this.agl, params, false);
        j = this.agl.Fb;
      }
    }
    for (;;)
    {
      label687:
      if (getChildCount() > 0) {
        if ((this.agp ^ this.agq))
        {
          k = a(i, paramo, params, true);
          j += k;
          m = b(j, paramo, params, false);
          k = i + k + m;
          m = j + m;
        }
      }
      for (;;)
      {
        label798:
        boolean bool;
        if ((!params.akk) || (getChildCount() == 0) || (params.akg) || (!ih()))
        {
          if (params.akg) {
            break label2129;
          }
          paramo = this.agm;
          paramo.ahC = paramo.iK();
          this.agn = this.agq;
          return;
          if ((this.ags < 0) || (this.ags >= params.getItemCount()))
          {
            this.ags = -1;
            this.agt = -2147483648;
            i = 0;
            break;
          }
          ((LinearLayoutManager.a)localObject2).mPosition = this.ags;
          if ((this.agv != null) && (this.agv.iz()))
          {
            ((LinearLayoutManager.a)localObject2).agA = this.agv.agL;
            if (((LinearLayoutManager.a)localObject2).agA) {}
            for (((LinearLayoutManager.a)localObject2).agz = (this.agm.iJ() - this.agv.agK);; ((LinearLayoutManager.a)localObject2).agz = (this.agm.iI() + this.agv.agK))
            {
              i = 1;
              break;
            }
          }
          if (this.agt == -2147483648)
          {
            localObject1 = bH(this.ags);
            if (localObject1 != null) {
              if (this.agm.bl((View)localObject1) > this.agm.iK()) {
                ((LinearLayoutManager.a)localObject2).ix();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.agm.bh((View)localObject1) - this.agm.iI() < 0)
            {
              ((LinearLayoutManager.a)localObject2).agz = this.agm.iI();
              ((LinearLayoutManager.a)localObject2).agA = false;
            }
            else if (this.agm.iJ() - this.agm.bi((View)localObject1) < 0)
            {
              ((LinearLayoutManager.a)localObject2).agz = this.agm.iJ();
              ((LinearLayoutManager.a)localObject2).agA = true;
            }
            else
            {
              if (((LinearLayoutManager.a)localObject2).agA) {}
              for (i = this.agm.bi((View)localObject1) + this.agm.iH();; i = this.agm.bh((View)localObject1))
              {
                ((LinearLayoutManager.a)localObject2).agz = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = bv(getChildAt(0));
                if (this.ags >= i) {
                  break label1174;
                }
                bool = true;
                label1147:
                if (bool != this.agp) {
                  break label1180;
                }
              }
              label1174:
              label1180:
              for (bool = true;; bool = false)
              {
                ((LinearLayoutManager.a)localObject2).agA = bool;
                ((LinearLayoutManager.a)localObject2).ix();
                break;
                bool = false;
                break label1147;
              }
              ((LinearLayoutManager.a)localObject2).agA = this.agp;
              if (this.agp) {
                ((LinearLayoutManager.a)localObject2).agz = (this.agm.iJ() - this.agt);
              } else {
                ((LinearLayoutManager.a)localObject2).agz = (this.agm.iI() + this.agt);
              }
            }
          }
          label1242:
          i = 0;
          break label220;
          label1247:
          if (this.agn == this.agq)
          {
            if (((LinearLayoutManager.a)localObject2).agA)
            {
              if (this.agp) {
                break label1401;
              }
              localObject1 = d(paramo, params);
              if (localObject1 == null) {
                break label1437;
              }
              ((LinearLayoutManager.a)localObject2).B((View)localObject1, bv((View)localObject1));
              if ((!params.akg) && (ih()))
              {
                if ((this.agm.bh((View)localObject1) < this.agm.iJ()) && (this.agm.bi((View)localObject1) >= this.agm.iI())) {
                  break label1421;
                }
                i = 1;
                if (i != 0) {
                  if (!((LinearLayoutManager.a)localObject2).agA) {
                    break label1426;
                  }
                }
              }
            }
            for (i = this.agm.iJ();; i = this.agm.iI())
            {
              ((LinearLayoutManager.a)localObject2).agz = i;
              i = 1;
              break;
              if (this.agp)
              {
                localObject1 = d(paramo, params);
                break label1281;
              }
              label1401:
              localObject1 = a(paramo, params, 0, getChildCount(), params.getItemCount());
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
          if ((localObject1 == null) || ((this.agm.bh((View)localObject1) < this.agm.iJ()) && (this.agm.bi((View)localObject1) > this.agm.iI()))) {
            break label275;
          }
          this.agw.A((View)localObject1, bv((View)localObject1));
          break label275;
          label1507:
          k = 0;
          j = i;
          i = k;
          break label294;
          label1519:
          i = this.agm.bh((View)localObject1);
          j = this.agm.iI();
          i = this.agt - (i - j);
          break label418;
          label1551:
          j = n - i;
          k = m;
          break label432;
          label1564:
          i = -1;
          break label451;
          label1569:
          if (this.agp)
          {
            i = -1;
            break label451;
          }
          i = 1;
          break label451;
          label1586:
          a(this.agw);
          this.agl.agF = j;
          a(paramo, this.agl, params, false);
          j = this.agl.Fb;
          m = this.agl.afT;
          i = k;
          if (this.agl.afS > 0) {
            i = k + this.agl.afS;
          }
          b(this.agw);
          this.agl.agF = i;
          localObject1 = this.agl;
          ((LinearLayoutManager.c)localObject1).afT += this.agl.afU;
          a(paramo, this.agl, params, false);
          k = this.agl.Fb;
          if (this.agl.afS <= 0) {
            break label2162;
          }
          i = this.agl.afS;
          ab(m, j);
          this.agl.agF = i;
          a(paramo, this.agl, params, false);
          i = this.agl.Fb;
          j = k;
          break label687;
          m = b(j, paramo, params, true);
          k = i + m;
          i = a(k, paramo, params, false);
          k += i;
          m = j + m + i;
          continue;
        }
        j = 0;
        i = 0;
        localObject1 = paramo.ajK;
        int i2 = ((List)localObject1).size();
        int i3 = bv(getChildAt(0));
        n = 0;
        label1857:
        label1899:
        int i1;
        if (n < i2)
        {
          localObject2 = (RecyclerView.v)((List)localObject1).get(n);
          if (((RecyclerView.v)localObject2).isRemoved()) {
            break label2139;
          }
          if (((RecyclerView.v)localObject2).jM() < i3)
          {
            bool = true;
            if (bool == this.agp) {
              break label1969;
            }
            i1 = -1;
            label1911:
            if (i1 != -1) {
              break label1975;
            }
            i1 = this.agm.bl(((RecyclerView.v)localObject2).aku) + j;
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
          i1 = i + this.agm.bl(((RecyclerView.v)localObject2).aku);
          i = j;
          j = i1;
          continue;
          this.agl.agI = ((List)localObject1);
          if (j > 0)
          {
            ac(bv(ip()), m);
            this.agl.agF = j;
            this.agl.afS = 0;
            this.agl.bf(null);
            a(paramo, this.agl, params, false);
          }
          if (i > 0)
          {
            ab(bv(iq()), k);
            this.agl.agF = i;
            this.agl.afS = 0;
            this.agl.bf(null);
            a(paramo, this.agl, params, false);
          }
          this.agl.agI = null;
          break;
          label2129:
          this.agw.reset();
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
  
  public int d(RecyclerView.s params)
  {
    return j(params);
  }
  
  public int e(RecyclerView.s params)
  {
    return j(params);
  }
  
  public int f(RecyclerView.s params)
  {
    return k(params);
  }
  
  public int g(RecyclerView.s params)
  {
    return k(params);
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int h(RecyclerView.s params)
  {
    return l(params);
  }
  
  protected final boolean hE()
  {
    return t.T(this.adt) == 1;
  }
  
  public int i(RecyclerView.s params)
  {
    return l(params);
  }
  
  public RecyclerView.LayoutParams ic()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public boolean ih()
  {
    return (this.agv == null) && (this.agn == this.agq);
  }
  
  public final boolean ii()
  {
    return true;
  }
  
  public boolean ij()
  {
    return this.mOrientation == 0;
  }
  
  public boolean ik()
  {
    return this.mOrientation == 1;
  }
  
  protected void im()
  {
    if (this.agl == null) {
      this.agl = new LinearLayoutManager.c();
    }
  }
  
  final boolean io()
  {
    if ((this.ajw != 1073741824) && (this.ajv != 1073741824))
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
  
  public final int it()
  {
    View localView = c(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return bv(localView);
  }
  
  public final int iu()
  {
    View localView = c(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return bv(localView);
  }
  
  public final int iv()
  {
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return bv(localView);
  }
  
  public final int iw()
  {
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return bv(localView);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(it());
      paramAccessibilityEvent.setToIndex(iv());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.agv = ((LinearLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.agv != null) {
      return new LinearLayoutManager.SavedState(this.agv);
    }
    LinearLayoutManager.SavedState localSavedState = new LinearLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      im();
      boolean bool = this.agn ^ this.agp;
      localSavedState.agL = bool;
      if (bool)
      {
        localView = iq();
        localSavedState.agK = (this.agm.iJ() - this.agm.bi(localView));
        localSavedState.agJ = bv(localView);
        return localSavedState;
      }
      View localView = ip();
      localSavedState.agJ = bv(localView);
      localSavedState.agK = (this.agm.bh(localView) - this.agm.iI());
      return localSavedState;
    }
    localSavedState.agJ = -1;
    return localSavedState;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    S(null);
    if ((paramInt != this.mOrientation) || (this.agm == null)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("invalid orientation");
      }
    }
    for (aj localaj = aj.d(this);; localaj = aj.e(this))
    {
      this.agm = localaj;
      this.agw.agm = this.agm;
      this.mOrientation = paramInt;
      requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */