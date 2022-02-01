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
  implements RecyclerView.r.b, a.d
{
  int anA = -2147483648;
  private boolean anB;
  SavedState anC = null;
  final a anD = new a();
  private final b anE = new b();
  public int anF = 2;
  private c ans;
  aj ant;
  private boolean anu;
  private boolean anv = false;
  boolean anw = false;
  private boolean anx = false;
  private boolean any = true;
  int anz = -1;
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
    ap(paramContext.aqJ);
    ao(paramContext.aqK);
  }
  
  private int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = this.ant.ke() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramo, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.ant.ke() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.ant.cf(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(RecyclerView.o paramo, c paramc, RecyclerView.s params, boolean paramBoolean)
  {
    int k = paramc.amZ;
    if (paramc.anL != -2147483648)
    {
      if (paramc.amZ < 0) {
        paramc.anL += paramc.amZ;
      }
      a(paramo, paramc);
    }
    int i = paramc.amZ + paramc.anM;
    b localb = this.anE;
    do
    {
      int j;
      do
      {
        if (((!paramc.anf) && (i <= 0)) || (!paramc.b(params))) {
          break;
        }
        localb.resetInternal();
        a(paramo, params, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.LZ += localb.anJ * paramc.mLayoutDirection;
        if ((localb.anK) && (this.ans.anP == null))
        {
          j = i;
          if (params.aru) {}
        }
        else
        {
          paramc.amZ -= localb.anJ;
          j = i - localb.anJ;
        }
        if (paramc.anL != -2147483648)
        {
          paramc.anL += localb.anJ;
          if (paramc.amZ < 0) {
            paramc.anL += paramc.amZ;
          }
          a(paramo, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.aaI);
    return k - paramc.amZ;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.s params)
  {
    int i = -1;
    int j = 1;
    this.ans.anf = jI();
    this.ans.anM = c(params);
    this.ans.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      params = this.ans;
      params.anM += this.ant.getEndPadding();
      params = jL();
      localc = this.ans;
      if (this.anw) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.anb = paramInt1;
        this.ans.ana = (bB(params) + this.ans.anb);
        this.ans.LZ = this.ant.bo(params);
        paramInt1 = this.ant.bo(params) - this.ant.ke();
        this.ans.amZ = paramInt2;
        if (paramBoolean)
        {
          params = this.ans;
          params.amZ -= paramInt1;
        }
        this.ans.anL = paramInt1;
        return;
      }
    }
    params = jK();
    c localc = this.ans;
    localc.anM += this.ant.kd();
    localc = this.ans;
    if (this.anw) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.anb = paramInt1;
      this.ans.ana = (bB(params) + this.ans.anb);
      this.ans.LZ = this.ant.bn(params);
      paramInt1 = -this.ant.bn(params) + this.ant.kd();
      break;
    }
  }
  
  private void a(a parama)
  {
    ad(parama.mPosition, parama.anG);
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
    if ((!paramc.amY) || (paramc.anf)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramc.mLayoutDirection == -1)
      {
        i = paramc.anL;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.ant.getEnd() - i;
          if (this.anw)
          {
            i = 0;
            while (i < j)
            {
              paramc = getChildAt(i);
              if ((this.ant.bn(paramc) < k) || (this.ant.bq(paramc) < k))
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
              if ((this.ant.bn(paramc) < k) || (this.ant.bq(paramc) < k))
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
        j = paramc.anL;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.anw)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if ((this.ant.bo(paramc) > j) || (this.ant.bp(paramc) > j))
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
              if ((this.ant.bo(paramc) > j) || (this.ant.bp(paramc) > j))
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
    this.ans.amZ = (this.ant.ke() - paramInt2);
    c localc = this.ans;
    if (this.anw) {}
    for (int i = -1;; i = 1)
    {
      localc.anb = i;
      this.ans.ana = paramInt1;
      this.ans.mLayoutDirection = 1;
      this.ans.LZ = paramInt2;
      this.ans.anL = -2147483648;
      return;
    }
  }
  
  private void ae(int paramInt1, int paramInt2)
  {
    this.ans.amZ = (paramInt2 - this.ant.kd());
    this.ans.ana = paramInt1;
    c localc = this.ans;
    if (this.anw) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.anb = paramInt1;
      this.ans.mLayoutDirection = -1;
      this.ans.LZ = paramInt2;
      this.ans.anL = -2147483648;
      return;
    }
  }
  
  private View ag(int paramInt1, int paramInt2)
  {
    jH();
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
    if (this.ant.bn(getChildAt(paramInt1)) < this.ant.kd()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      return this.aqw.k(paramInt1, paramInt2, j, i);
      j = 4161;
    }
    return this.aqx.k(paramInt1, paramInt2, j, i);
  }
  
  private View aq(boolean paramBoolean)
  {
    if (this.anw) {
      return c(getChildCount() - 1, -1, paramBoolean, true);
    }
    return c(0, getChildCount(), paramBoolean, true);
  }
  
  private View ar(boolean paramBoolean)
  {
    if (this.anw) {
      return c(0, getChildCount(), paramBoolean, true);
    }
    return c(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params, boolean paramBoolean)
  {
    int i = paramInt - this.ant.kd();
    if (i > 0)
    {
      int j = -c(i, paramo, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.ant.kd();
        i = j;
        if (paramInt > 0)
        {
          this.ant.cf(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(a parama)
  {
    ae(parama.mPosition, parama.anG);
  }
  
  private int c(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.ans.amY = true;
    jH();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, params);
      k = this.ans.anL + a(paramo, this.ans, params, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.ant.cf(-paramInt);
    this.ans.anO = paramInt;
    return paramInt;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    jH();
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
        return this.aqw.k(paramInt1, paramInt2, i, j);
        i = 320;
        break;
      }
      return this.aqx.k(paramInt1, paramInt2, i, j);
      label66:
      j = 0;
    }
  }
  
  private View d(RecyclerView.o paramo, RecyclerView.s params)
  {
    return a(paramo, params, getChildCount() - 1, -1, params.getItemCount());
  }
  
  private int j(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    jH();
    aj localaj = this.ant;
    View localView;
    if (!this.any)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.any) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, ar(bool1), this, this.any, this.anw);
      bool1 = false;
      break;
    }
  }
  
  private void jG()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!ja())) {
      bool = this.anv;
    }
    for (;;)
    {
      this.anw = bool;
      return;
      if (this.anv) {
        bool = false;
      }
    }
  }
  
  private boolean jI()
  {
    return (this.ant.getMode() == 0) && (this.ant.getEnd() == 0);
  }
  
  private View jK()
  {
    if (this.anw) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View jL()
  {
    if (this.anw) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View jM()
  {
    return ag(0, getChildCount());
  }
  
  private View jN()
  {
    return ag(getChildCount() - 1, -1);
  }
  
  private int k(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    jH();
    aj localaj = this.ant;
    View localView;
    if (!this.any)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.any) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, ar(bool1), this, this.any);
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
    jH();
    aj localaj = this.ant;
    View localView;
    if (!this.any)
    {
      bool1 = true;
      localView = aq(bool1);
      if (this.any) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(params, localaj, localView, ar(bool1), this, this.any);
      bool1 = false;
      break;
    }
  }
  
  public final void E(String paramString)
  {
    if (this.anC == null) {
      super.E(paramString);
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
    jH();
    int j = this.ant.kd();
    int k = this.ant.ke();
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
      int m = bB(params);
      if ((m < 0) || (m >= paramInt3)) {
        break label155;
      }
      if (!((RecyclerView.LayoutParams)params.getLayoutParams()).aqL.isRemoved()) {
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
      if (this.ant.bn(params) < k)
      {
        localObject = params;
        if (this.ant.bo(params) >= j) {}
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
    jG();
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = cc(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    jH();
    jH();
    a(paramInt, (int)(0.3333333F * this.ant.kf()), false, params);
    this.ans.anL = -2147483648;
    this.ans.amY = false;
    a(paramo, this.ans, params, true);
    if (paramInt == -1) {
      if (this.anw)
      {
        paramView = jN();
        label105:
        paramo = paramView;
        if (paramInt != -1) {
          break label163;
        }
      }
    }
    label163:
    for (paramView = jK();; paramView = jL())
    {
      if (!paramView.hasFocusable()) {
        return paramo;
      }
      if (paramo != null) {
        break;
      }
      return null;
      paramView = jM();
      break label105;
      if (this.anw) {}
      for (paramView = jM();; paramView = jN())
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
    jH();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, params);
      a(params, this.ans, parama);
      return;
    }
  }
  
  public final void a(int paramInt, RecyclerView.i.a parama)
  {
    boolean bool;
    int i;
    if ((this.anC != null) && (this.anC.jU()))
    {
      bool = this.anC.anS;
      i = this.anC.anQ;
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
      while ((i < this.anF) && (k >= 0) && (k < paramInt))
      {
        parama.R(k, 0);
        k += j;
        i += 1;
      }
      jG();
      bool = this.anw;
      if (this.anz == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.anz;
      break;
    }
  }
  
  void a(RecyclerView.o paramo, RecyclerView.s params, a parama, int paramInt) {}
  
  void a(RecyclerView.o paramo, RecyclerView.s params, c paramc, b paramb)
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
    if (paramc.anP == null)
    {
      bool2 = this.anw;
      if (paramc.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label215;
        }
        addView(paramo, -1);
        bD(paramo);
        paramb.anJ = this.ant.br(paramo);
        if (this.mOrientation != 1) {
          break label331;
        }
        if (!ja()) {
          break label272;
        }
        i = this.mWidth - getPaddingRight();
        j = i - this.ant.bs(paramo);
        if (paramc.mLayoutDirection != -1) {
          break label294;
        }
        i1 = paramc.LZ;
        n = paramc.LZ - paramb.anJ;
        m = i;
        k = j;
        j = i1;
        i = n;
      }
    }
    for (;;)
    {
      k(paramo, k, i, m, j);
      if ((params.aqL.isRemoved()) || (params.aqL.lC())) {
        paramb.anK = true;
      }
      paramb.aaI = paramo.hasFocusable();
      return;
      bool1 = false;
      break;
      label215:
      addView(paramo, 0);
      break label62;
      bool2 = this.anw;
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
      i = this.ant.bs(paramo) + j;
      break label119;
      label294:
      i1 = paramc.LZ;
      n = paramc.LZ + paramb.anJ;
      k = j;
      m = i;
      i = i1;
      j = n;
      continue;
      label331:
      j = getPaddingTop();
      i = this.ant.bs(paramo) + j;
      if (paramc.mLayoutDirection == -1)
      {
        m = paramc.LZ;
        n = paramc.LZ - paramb.anJ;
        k = i;
        i = j;
        j = k;
        k = n;
      }
      else
      {
        n = paramc.LZ;
        m = paramc.LZ + paramb.anJ;
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
    this.anC = null;
    this.anz = -1;
    this.anA = -2147483648;
    this.anD.reset();
  }
  
  void a(RecyclerView.s params, c paramc, RecyclerView.i.a parama)
  {
    int i = paramc.ana;
    if ((i >= 0) && (i < params.getItemCount())) {
      parama.R(i, Math.max(0, paramc.anL));
    }
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.anB)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.ard = paramInt;
    a(paramRecyclerView);
  }
  
  public void af(int paramInt1, int paramInt2)
  {
    this.anz = paramInt1;
    this.anA = paramInt2;
    if (this.anC != null) {
      this.anC.anQ = -1;
    }
    requestLayout();
  }
  
  public void ao(boolean paramBoolean)
  {
    E(null);
    if (this.anx == paramBoolean) {
      return;
    }
    this.anx = paramBoolean;
    requestLayout();
  }
  
  public void ap(boolean paramBoolean)
  {
    E(null);
    if (paramBoolean == this.anv) {
      return;
    }
    this.anv = paramBoolean;
    requestLayout();
  }
  
  public int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return c(paramInt, paramo, params);
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
    if (j != this.anw) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  protected int c(RecyclerView.s params)
  {
    int j = 0;
    if (params.ard != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = this.ant.kf();
      }
      return j;
    }
  }
  
  public void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (((this.anC != null) || (this.anz != -1)) && (params.getItemCount() == 0))
    {
      d(paramo);
      return;
    }
    if ((this.anC != null) && (this.anC.jU())) {
      this.anz = this.anC.anQ;
    }
    jH();
    this.ans.amY = false;
    jG();
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
    if ((!this.anD.anI) || (this.anz != -1) || (this.anC != null))
    {
      this.anD.reset();
      this.anD.anH = (this.anw ^ this.anx);
      localObject2 = this.anD;
      if ((params.aru) || (this.anz == -1))
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
          if ((localLayoutParams.aqL.isRemoved()) || (localLayoutParams.aqL.lm() < 0) || (localLayoutParams.aqL.lm() >= params.getItemCount())) {
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
            ((a)localObject2).jS();
            if (!this.anx) {
              break label1442;
            }
            i = params.getItemCount() - 1;
            ((a)localObject2).mPosition = i;
          }
        }
        this.anD.anI = true;
        i = c(params);
        if (this.ans.anO < 0) {
          break label1507;
        }
        j = 0;
        m = this.ant.kd() + j;
        n = i + this.ant.getEndPadding();
        j = n;
        k = m;
        if (params.aru)
        {
          j = n;
          k = m;
          if (this.anz != -1)
          {
            j = n;
            k = m;
            if (this.anA != -2147483648)
            {
              localObject1 = bY(this.anz);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.anw) {
                  break label1519;
                }
                i = this.ant.ke() - this.ant.bo((View)localObject1) - this.anA;
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
        if (!this.anD.anH) {
          break label1569;
        }
        if (!this.anw) {
          break label1564;
        }
        i = 1;
        label451:
        a(paramo, params, this.anD, i);
        b(paramo);
        this.ans.anf = jI();
        this.ans.anN = params.aru;
        if (!this.anD.anH) {
          break label1586;
        }
        b(this.anD);
        this.ans.anM = k;
        a(paramo, this.ans, params, false);
        k = this.ans.LZ;
        m = this.ans.ana;
        i = j;
        if (this.ans.amZ > 0) {
          i = j + this.ans.amZ;
        }
        a(this.anD);
        this.ans.anM = i;
        localObject1 = this.ans;
        ((c)localObject1).ana += this.ans.anb;
        a(paramo, this.ans, params, false);
        i = this.ans.LZ;
        if (this.ans.amZ <= 0) {
          break label2172;
        }
        j = this.ans.amZ;
        ae(m, k);
        this.ans.anM = j;
        a(paramo, this.ans, params, false);
        j = this.ans.LZ;
      }
    }
    for (;;)
    {
      label687:
      if (getChildCount() > 0) {
        if ((this.anw ^ this.anx))
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
        if ((!params.ary) || (getChildCount() == 0) || (params.aru) || (!jC()))
        {
          if (params.aru) {
            break label2129;
          }
          paramo = this.ant;
          paramo.aoJ = paramo.kf();
          this.anu = this.anx;
          return;
          if ((this.anz < 0) || (this.anz >= params.getItemCount()))
          {
            this.anz = -1;
            this.anA = -2147483648;
            i = 0;
            break;
          }
          ((a)localObject2).mPosition = this.anz;
          if ((this.anC != null) && (this.anC.jU()))
          {
            ((a)localObject2).anH = this.anC.anS;
            if (((a)localObject2).anH) {}
            for (((a)localObject2).anG = (this.ant.ke() - this.anC.anR);; ((a)localObject2).anG = (this.ant.kd() + this.anC.anR))
            {
              i = 1;
              break;
            }
          }
          if (this.anA == -2147483648)
          {
            localObject1 = bY(this.anz);
            if (localObject1 != null) {
              if (this.ant.br((View)localObject1) > this.ant.kf()) {
                ((a)localObject2).jS();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.ant.bn((View)localObject1) - this.ant.kd() < 0)
            {
              ((a)localObject2).anG = this.ant.kd();
              ((a)localObject2).anH = false;
            }
            else if (this.ant.ke() - this.ant.bo((View)localObject1) < 0)
            {
              ((a)localObject2).anG = this.ant.ke();
              ((a)localObject2).anH = true;
            }
            else
            {
              if (((a)localObject2).anH) {}
              for (i = this.ant.bo((View)localObject1) + this.ant.kc();; i = this.ant.bn((View)localObject1))
              {
                ((a)localObject2).anG = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = bB(getChildAt(0));
                if (this.anz >= i) {
                  break label1174;
                }
                bool = true;
                label1147:
                if (bool != this.anw) {
                  break label1180;
                }
              }
              label1174:
              label1180:
              for (bool = true;; bool = false)
              {
                ((a)localObject2).anH = bool;
                ((a)localObject2).jS();
                break;
                bool = false;
                break label1147;
              }
              ((a)localObject2).anH = this.anw;
              if (this.anw) {
                ((a)localObject2).anG = (this.ant.ke() - this.anA);
              } else {
                ((a)localObject2).anG = (this.ant.kd() + this.anA);
              }
            }
          }
          label1242:
          i = 0;
          break label220;
          label1247:
          if (this.anu == this.anx)
          {
            if (((a)localObject2).anH)
            {
              if (this.anw) {
                break label1401;
              }
              localObject1 = d(paramo, params);
              if (localObject1 == null) {
                break label1437;
              }
              ((a)localObject2).D((View)localObject1, bB((View)localObject1));
              if ((!params.aru) && (jC()))
              {
                if ((this.ant.bn((View)localObject1) < this.ant.ke()) && (this.ant.bo((View)localObject1) >= this.ant.kd())) {
                  break label1421;
                }
                i = 1;
                if (i != 0) {
                  if (!((a)localObject2).anH) {
                    break label1426;
                  }
                }
              }
            }
            for (i = this.ant.ke();; i = this.ant.kd())
            {
              ((a)localObject2).anG = i;
              i = 1;
              break;
              if (this.anw)
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
          if ((localObject1 == null) || ((this.ant.bn((View)localObject1) < this.ant.ke()) && (this.ant.bo((View)localObject1) > this.ant.kd()))) {
            break label275;
          }
          this.anD.C((View)localObject1, bB((View)localObject1));
          break label275;
          label1507:
          k = 0;
          j = i;
          i = k;
          break label294;
          label1519:
          i = this.ant.bn((View)localObject1);
          j = this.ant.kd();
          i = this.anA - (i - j);
          break label418;
          label1551:
          j = n - i;
          k = m;
          break label432;
          label1564:
          i = -1;
          break label451;
          label1569:
          if (this.anw)
          {
            i = -1;
            break label451;
          }
          i = 1;
          break label451;
          label1586:
          a(this.anD);
          this.ans.anM = j;
          a(paramo, this.ans, params, false);
          j = this.ans.LZ;
          m = this.ans.ana;
          i = k;
          if (this.ans.amZ > 0) {
            i = k + this.ans.amZ;
          }
          b(this.anD);
          this.ans.anM = i;
          localObject1 = this.ans;
          ((c)localObject1).ana += this.ans.anb;
          a(paramo, this.ans, params, false);
          k = this.ans.LZ;
          if (this.ans.amZ <= 0) {
            break label2162;
          }
          i = this.ans.amZ;
          ad(m, j);
          this.ans.anM = i;
          a(paramo, this.ans, params, false);
          i = this.ans.LZ;
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
        localObject1 = paramo.aqX;
        int i2 = ((List)localObject1).size();
        int i3 = bB(getChildAt(0));
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
          if (((RecyclerView.v)localObject2).lm() < i3)
          {
            bool = true;
            if (bool == this.anw) {
              break label1969;
            }
            i1 = -1;
            label1911:
            if (i1 != -1) {
              break label1975;
            }
            i1 = this.ant.br(((RecyclerView.v)localObject2).arI) + j;
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
          i1 = i + this.ant.br(((RecyclerView.v)localObject2).arI);
          i = j;
          j = i1;
          continue;
          this.ans.anP = ((List)localObject1);
          if (j > 0)
          {
            ae(bB(jK()), m);
            this.ans.anM = j;
            this.ans.amZ = 0;
            this.ans.bl(null);
            a(paramo, this.ans, params, false);
          }
          if (i > 0)
          {
            ad(bB(jL()), k);
            this.ans.anM = i;
            this.ans.amZ = 0;
            this.ans.bl(null);
            a(paramo, this.ans, params, false);
          }
          this.ans.anP = null;
          break;
          label2129:
          this.anD.reset();
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
    this.anz = paramInt;
    this.anA = -2147483648;
    if (this.anC != null) {
      this.anC.anQ = -1;
    }
    requestLayout();
  }
  
  public final void cb(int paramInt)
  {
    this.anF = paramInt;
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
            } while (!ja());
            return 1;
            if (this.mOrientation == 1) {
              return 1;
            }
            paramInt = i;
          } while (ja());
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
  
  public int d(RecyclerView.s params)
  {
    return j(params);
  }
  
  public int e(RecyclerView.s params)
  {
    return j(params);
  }
  
  public final void e(View paramView1, View paramView2)
  {
    E("Cannot drop a view during a scroll or layout calculation");
    jH();
    jG();
    int i = bB(paramView1);
    int j = bB(paramView2);
    if (i < j) {
      i = 1;
    }
    while (this.anw) {
      if (i == 1)
      {
        af(j, this.ant.ke() - (this.ant.bn(paramView2) + this.ant.br(paramView1)));
        return;
        i = -1;
      }
      else
      {
        af(j, this.ant.ke() - this.ant.bo(paramView2));
        return;
      }
    }
    if (i == -1)
    {
      af(j, this.ant.bn(paramView2));
      return;
    }
    af(j, this.ant.bo(paramView2) - this.ant.br(paramView1));
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
  
  public int i(RecyclerView.s params)
  {
    return l(params);
  }
  
  public boolean jC()
  {
    return (this.anC == null) && (this.anu == this.anx);
  }
  
  public final boolean jD()
  {
    return true;
  }
  
  public boolean jE()
  {
    return this.mOrientation == 0;
  }
  
  public boolean jF()
  {
    return this.mOrientation == 1;
  }
  
  protected void jH()
  {
    if (this.ans == null) {
      this.ans = new c();
    }
  }
  
  final boolean jJ()
  {
    if ((this.aqG != 1073741824) && (this.aqF != 1073741824))
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
  
  public final int jO()
  {
    View localView = c(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int jP()
  {
    View localView = c(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int jQ()
  {
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  public final int jR()
  {
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return bB(localView);
  }
  
  protected final boolean ja()
  {
    return t.Y(this.akA) == 1;
  }
  
  public RecyclerView.LayoutParams jy()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(jO());
      paramAccessibilityEvent.setToIndex(jQ());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.anC = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.anC != null) {
      return new SavedState(this.anC);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      jH();
      boolean bool = this.anu ^ this.anw;
      localSavedState.anS = bool;
      if (bool)
      {
        localView = jL();
        localSavedState.anR = (this.ant.ke() - this.ant.bo(localView));
        localSavedState.anQ = bB(localView);
        return localSavedState;
      }
      View localView = jK();
      localSavedState.anQ = bB(localView);
      localSavedState.anR = (this.ant.bn(localView) - this.ant.kd());
      return localSavedState;
    }
    localSavedState.anQ = -1;
    return localSavedState;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    E(null);
    if ((paramInt != this.mOrientation) || (this.ant == null))
    {
      this.ant = aj.a(this, paramInt);
      this.anD.ant = this.ant;
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int anQ;
    int anR;
    boolean anS;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.anQ = paramParcel.readInt();
      this.anR = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.anS = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.anQ = paramSavedState.anQ;
      this.anR = paramSavedState.anR;
      this.anS = paramSavedState.anS;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final boolean jU()
    {
      return this.anQ >= 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.anQ);
      paramParcel.writeInt(this.anR);
      if (this.anS) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  static final class a
  {
    int anG;
    boolean anH;
    boolean anI;
    aj ant;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    public final void C(View paramView, int paramInt)
    {
      int i = this.ant.kc();
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
              if (!this.anH) {
                break;
              }
              paramInt = this.ant.ke() - i - this.ant.bo(paramView);
              this.anG = (this.ant.ke() - paramInt);
            } while (paramInt <= 0);
            i = this.ant.br(paramView);
            j = this.anG;
            k = this.ant.kd();
            i = j - i - (k + Math.min(this.ant.bn(paramView) - k, 0));
          } while (i >= 0);
          j = this.anG;
          this.anG = (Math.min(paramInt, -i) + j);
          return;
          j = this.ant.bn(paramView);
          paramInt = j - this.ant.kd();
          this.anG = j;
        } while (paramInt <= 0);
        int k = this.ant.br(paramView);
        int m = this.ant.ke();
        int n = this.ant.bo(paramView);
        i = this.ant.ke() - Math.min(0, m - i - n) - (j + k);
      } while (i >= 0);
      this.anG -= Math.min(paramInt, -i);
    }
    
    public final void D(View paramView, int paramInt)
    {
      if (this.anH) {}
      for (this.anG = (this.ant.bo(paramView) + this.ant.kc());; this.anG = this.ant.bn(paramView))
      {
        this.mPosition = paramInt;
        return;
      }
    }
    
    final void jS()
    {
      if (this.anH) {}
      for (int i = this.ant.ke();; i = this.ant.kd())
      {
        this.anG = i;
        return;
      }
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.anG = -2147483648;
      this.anH = false;
      this.anI = false;
    }
    
    public final String toString()
    {
      return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.anG + ", mLayoutFromEnd=" + this.anH + ", mValid=" + this.anI + '}';
    }
  }
  
  protected static final class b
  {
    public boolean aaI;
    public int anJ;
    public boolean anK;
    public boolean mFinished;
    
    final void resetInternal()
    {
      this.anJ = 0;
      this.mFinished = false;
      this.anK = false;
      this.aaI = false;
    }
  }
  
  static final class c
  {
    int LZ;
    boolean amY = true;
    int amZ;
    int anL;
    int anM = 0;
    boolean anN = false;
    int anO;
    List<RecyclerView.v> anP = null;
    int ana;
    int anb;
    boolean anf;
    int mLayoutDirection;
    
    private View bm(View paramView)
    {
      int m = this.anP.size();
      Object localObject = null;
      int i = 2147483647;
      int j = 0;
      if (j < m)
      {
        View localView = ((RecyclerView.v)this.anP.get(j)).arI;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((localView == paramView) || (localLayoutParams.aqL.isRemoved())) {
          break label127;
        }
        int k = (localLayoutParams.aqL.lm() - this.ana) * this.anb;
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
    
    private View jT()
    {
      int j = this.anP.size();
      int i = 0;
      while (i < j)
      {
        View localView = ((RecyclerView.v)this.anP.get(i)).arI;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.aqL.isRemoved()) && (this.ana == localLayoutParams.aqL.lm()))
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
      if (this.anP != null) {
        return jT();
      }
      paramo = paramo.cw(this.ana);
      this.ana += this.anb;
      return paramo;
    }
    
    final boolean b(RecyclerView.s params)
    {
      return (this.ana >= 0) && (this.ana < params.getItemCount());
    }
    
    public final void bl(View paramView)
    {
      paramView = bm(paramView);
      if (paramView == null)
      {
        this.ana = -1;
        return;
      }
      this.ana = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aqL.lm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */