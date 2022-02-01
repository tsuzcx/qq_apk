package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.a.a.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.r.b, a.d
{
  private boolean aqA;
  SavedState aqB = null;
  final a aqC = new a();
  private final b aqD = new b();
  public int aqE = 2;
  private c aqr;
  aj aqs;
  private boolean aqt;
  private boolean aqu = false;
  boolean aqv = false;
  private boolean aqw = false;
  private boolean aqx = true;
  int aqy = -1;
  int aqz = -2147483648;
  int mOrientation = 1;
  
  public LinearLayoutManager()
  {
    this(1, false);
  }
  
  public LinearLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    ao(false);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    ao(paramContext.atu);
    an(paramContext.atv);
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.aqr.apX = true;
    km();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, params);
      k = this.aqr.aqK + a(paramn, this.aqr, params, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.aqs.ce(-paramInt);
    this.aqr.aqN = paramInt;
    return paramInt;
  }
  
  private int a(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    int i = this.aqs.kI() - paramInt;
    if (i > 0)
    {
      int j = -a(-i, paramn, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.aqs.kI() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.aqs.ce(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(RecyclerView.n paramn, c paramc, RecyclerView.s params, boolean paramBoolean)
  {
    int k = paramc.apY;
    if (paramc.aqK != -2147483648)
    {
      if (paramc.apY < 0) {
        paramc.aqK += paramc.apY;
      }
      a(paramn, paramc);
    }
    int i = paramc.apY + paramc.aqL;
    b localb = this.aqD;
    do
    {
      int j;
      do
      {
        if (((!paramc.aqe) && (i <= 0)) || (!paramc.a(params))) {
          break;
        }
        localb.resetInternal();
        a(paramn, params, paramc, localb);
        if (localb.mFinished) {
          break;
        }
        paramc.fs += localb.aqI * paramc.mLayoutDirection;
        if ((localb.aqJ) && (this.aqr.aqO == null))
        {
          j = i;
          if (params.aue) {}
        }
        else
        {
          paramc.apY -= localb.aqI;
          j = i - localb.aqI;
        }
        if (paramc.aqK != -2147483648)
        {
          paramc.aqK += localb.aqI;
          if (paramc.apY < 0) {
            paramc.aqK += paramc.apY;
          }
          a(paramn, paramc);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localb.adH);
    return k - paramc.apY;
  }
  
  private View a(RecyclerView.n paramn, RecyclerView.s params)
  {
    return a(paramn, params, getChildCount() - 1, -1, params.getItemCount());
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.s params)
  {
    int i = -1;
    int j = 1;
    this.aqr.aqe = kn();
    this.aqr.aqL = b(params);
    this.aqr.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      params = this.aqr;
      params.aqL += this.aqs.getEndPadding();
      params = kp();
      localc = this.aqr;
      if (this.aqv) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localc.aqa = paramInt1;
        this.aqr.apZ = (getPosition(params) + this.aqr.aqa);
        this.aqr.fs = this.aqs.bp(params);
        paramInt1 = this.aqs.bp(params) - this.aqs.kI();
        this.aqr.apY = paramInt2;
        if (paramBoolean)
        {
          params = this.aqr;
          params.apY -= paramInt1;
        }
        this.aqr.aqK = paramInt1;
        return;
      }
    }
    params = ko();
    c localc = this.aqr;
    localc.aqL += this.aqs.kH();
    localc = this.aqr;
    if (this.aqv) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localc.aqa = paramInt1;
      this.aqr.apZ = (getPosition(params) + this.aqr.aqa);
      this.aqr.fs = this.aqs.bo(params);
      paramInt1 = -this.aqs.bo(params) + this.aqs.kH();
      break;
    }
  }
  
  private void a(a parama)
  {
    af(parama.mPosition, parama.aqF);
  }
  
  private void a(RecyclerView.n paramn, int paramInt1, int paramInt2)
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
          removeAndRecycleViewAt(paramInt2, paramn);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          removeAndRecycleViewAt(i, paramn);
          i -= 1;
        }
      }
    }
  }
  
  private void a(RecyclerView.n paramn, c paramc)
  {
    if ((!paramc.apX) || (paramc.aqe)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramc.mLayoutDirection == -1)
      {
        i = paramc.aqK;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.aqs.getEnd() - i;
          if (this.aqv)
          {
            i = 0;
            while (i < j)
            {
              paramc = getChildAt(i);
              if ((this.aqs.bo(paramc) < k) || (this.aqs.br(paramc) < k))
              {
                a(paramn, 0, i);
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
              if ((this.aqs.bo(paramc) < k) || (this.aqs.br(paramc) < k))
              {
                a(paramn, j - 1, i);
                return;
              }
              i -= 1;
            }
          }
        }
      }
      else
      {
        j = paramc.aqK;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.aqv)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramc = getChildAt(i);
              if ((this.aqs.bp(paramc) > j) || (this.aqs.bq(paramc) > j))
              {
                a(paramn, k - 1, i);
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
              if ((this.aqs.bp(paramc) > j) || (this.aqs.bq(paramc) > j))
              {
                a(paramn, 0, i);
                return;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private void af(int paramInt1, int paramInt2)
  {
    this.aqr.apY = (this.aqs.kI() - paramInt2);
    c localc = this.aqr;
    if (this.aqv) {}
    for (int i = -1;; i = 1)
    {
      localc.aqa = i;
      this.aqr.apZ = paramInt1;
      this.aqr.mLayoutDirection = 1;
      this.aqr.fs = paramInt2;
      this.aqr.aqK = -2147483648;
      return;
    }
  }
  
  private void ag(int paramInt1, int paramInt2)
  {
    this.aqr.apY = (paramInt2 - this.aqs.kH());
    this.aqr.apZ = paramInt1;
    c localc = this.aqr;
    if (this.aqv) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localc.aqa = paramInt1;
      this.aqr.mLayoutDirection = -1;
      this.aqr.fs = paramInt2;
      this.aqr.aqK = -2147483648;
      return;
    }
  }
  
  private View ai(int paramInt1, int paramInt2)
  {
    km();
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
    if (this.aqs.bo(getChildAt(paramInt1)) < this.aqs.kH()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      return this.mHorizontalBoundCheck.k(paramInt1, paramInt2, j, i);
      j = 4161;
    }
    return this.mVerticalBoundCheck.k(paramInt1, paramInt2, j, i);
  }
  
  private View ap(boolean paramBoolean)
  {
    if (this.aqv) {
      return c(getChildCount() - 1, -1, paramBoolean, true);
    }
    return c(0, getChildCount(), paramBoolean, true);
  }
  
  private View aq(boolean paramBoolean)
  {
    if (this.aqv) {
      return c(0, getChildCount(), paramBoolean, true);
    }
    return c(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private int b(int paramInt, RecyclerView.n paramn, RecyclerView.s params, boolean paramBoolean)
  {
    int i = paramInt - this.aqs.kH();
    if (i > 0)
    {
      int j = -a(i, paramn, params);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.aqs.kH();
        i = j;
        if (paramInt > 0)
        {
          this.aqs.ce(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(a parama)
  {
    ag(parama.mPosition, parama.aqF);
  }
  
  private int c(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    km();
    aj localaj = this.aqs;
    View localView;
    if (!this.aqx)
    {
      bool1 = true;
      localView = ap(bool1);
      if (this.aqx) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, aq(bool1), this, this.aqx, this.aqv);
      bool1 = false;
      break;
    }
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    km();
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
        return this.mHorizontalBoundCheck.k(paramInt1, paramInt2, i, j);
        i = 320;
        break;
      }
      return this.mVerticalBoundCheck.k(paramInt1, paramInt2, i, j);
      label66:
      j = 0;
    }
  }
  
  private int d(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    km();
    aj localaj = this.aqs;
    View localView;
    if (!this.aqx)
    {
      bool1 = true;
      localView = ap(bool1);
      if (this.aqx) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.a(params, localaj, localView, aq(bool1), this, this.aqx);
      bool1 = false;
      break;
    }
  }
  
  private int e(RecyclerView.s params)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    km();
    aj localaj = this.aqs;
    View localView;
    if (!this.aqx)
    {
      bool1 = true;
      localView = ap(bool1);
      if (this.aqx) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return aq.b(params, localaj, localView, aq(bool1), this, this.aqx);
      bool1 = false;
      break;
    }
  }
  
  private void kl()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!jH())) {
      bool = this.aqu;
    }
    for (;;)
    {
      this.aqv = bool;
      return;
      if (this.aqu) {
        bool = false;
      }
    }
  }
  
  private boolean kn()
  {
    return (this.aqs.getMode() == 0) && (this.aqs.getEnd() == 0);
  }
  
  private View ko()
  {
    if (this.aqv) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View kp()
  {
    if (this.aqv) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View kq()
  {
    return ai(0, getChildCount());
  }
  
  private View kr()
  {
    return ai(getChildCount() - 1, -1);
  }
  
  View a(RecyclerView.n paramn, RecyclerView.s params, int paramInt1, int paramInt2, int paramInt3)
  {
    km();
    int j = this.aqs.kH();
    int k = this.aqs.kI();
    int i;
    RecyclerView.s locals;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramn = null;
      locals = null;
      label36:
      if (paramInt1 == paramInt2) {
        break label143;
      }
      params = getChildAt(paramInt1);
      int m = getPosition(params);
      if ((m < 0) || (m >= paramInt3)) {
        break label156;
      }
      if (!((RecyclerView.LayoutParams)params.getLayoutParams()).atw.isRemoved()) {
        break label105;
      }
      if (locals != null) {
        break label156;
      }
      locals = params;
    }
    label143:
    label153:
    label156:
    for (;;)
    {
      paramInt1 += i;
      break label36;
      i = -1;
      break;
      label105:
      Object localObject;
      if (this.aqs.bo(params) < k)
      {
        localObject = params;
        if (this.aqs.bp(params) >= j) {}
      }
      else
      {
        if (paramn != null) {
          break label156;
        }
        paramn = params;
        continue;
        if (paramn == null) {
          break label153;
        }
        localObject = paramn;
      }
      return localObject;
      return locals;
    }
  }
  
  void a(RecyclerView.n paramn, RecyclerView.s params, a parama, int paramInt) {}
  
  void a(RecyclerView.n paramn, RecyclerView.s params, c paramc, b paramb)
  {
    paramn = paramc.a(paramn);
    if (paramn == null)
    {
      paramb.mFinished = true;
      return;
    }
    params = (RecyclerView.LayoutParams)paramn.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label61:
    int j;
    int i;
    label120:
    int m;
    int k;
    if (paramc.aqO == null)
    {
      bool2 = this.aqv;
      if (paramc.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label201;
        }
        addView(paramn);
        measureChildWithMargins(paramn, 0, 0);
        paramb.aqI = this.aqs.bs(paramn);
        if (this.mOrientation != 1) {
          break label304;
        }
        if (!jH()) {
          break label257;
        }
        j = getWidth() - getPaddingRight();
        i = j - this.aqs.bt(paramn);
        if (paramc.mLayoutDirection != -1) {
          break label279;
        }
        m = paramc.fs;
        k = paramc.fs - paramb.aqI;
      }
    }
    for (;;)
    {
      layoutDecoratedWithMargins(paramn, i, k, j, m);
      if ((params.atw.isRemoved()) || (params.atw.mh())) {
        paramb.aqJ = true;
      }
      paramb.adH = paramn.hasFocusable();
      return;
      bool1 = false;
      break;
      label201:
      addView(paramn, 0);
      break label61;
      bool2 = this.aqv;
      if (paramc.mLayoutDirection == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label248;
        }
        addDisappearingView(paramn);
        break;
      }
      label248:
      addDisappearingView(paramn, 0);
      break label61;
      label257:
      i = getPaddingLeft();
      j = this.aqs.bt(paramn) + i;
      break label120;
      label279:
      k = paramc.fs;
      m = paramc.fs;
      m = paramb.aqI + m;
      continue;
      label304:
      k = getPaddingTop();
      m = k + this.aqs.bt(paramn);
      if (paramc.mLayoutDirection == -1)
      {
        j = paramc.fs;
        i = paramc.fs - paramb.aqI;
      }
      else
      {
        i = paramc.fs;
        j = paramc.fs;
        j = paramb.aqI + j;
      }
    }
  }
  
  void a(RecyclerView.s params, c paramc, RecyclerView.LayoutManager.a parama)
  {
    int i = paramc.apZ;
    if ((i >= 0) && (i < params.getItemCount())) {
      parama.S(i, Math.max(0, paramc.aqK));
    }
  }
  
  public void ah(int paramInt1, int paramInt2)
  {
    this.aqy = paramInt1;
    this.aqz = paramInt2;
    if (this.aqB != null) {
      this.aqB.aqP = -1;
    }
    requestLayout();
  }
  
  public void an(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.aqw == paramBoolean) {
      return;
    }
    this.aqw = paramBoolean;
    requestLayout();
  }
  
  public void ao(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.aqu) {
      return;
    }
    this.aqu = paramBoolean;
    requestLayout();
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.aqB == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  protected int b(RecyclerView.s params)
  {
    int j = 0;
    if (params.atO != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = this.aqs.kJ();
      }
      return j;
    }
  }
  
  public final PointF bZ(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.aqv) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public final void ca(int paramInt)
  {
    this.aqE = paramInt;
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  final int cb(int paramInt)
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
            } while (!jH());
            return 1;
            if (this.mOrientation == 1) {
              return 1;
            }
            paramInt = i;
          } while (jH());
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
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.s params, RecyclerView.LayoutManager.a parama)
  {
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      return;
      paramInt1 = paramInt2;
    }
    km();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      a(paramInt2, Math.abs(paramInt1), true, params);
      a(params, this.aqr, parama);
      return;
    }
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.a parama)
  {
    boolean bool;
    int i;
    if ((this.aqB != null) && (this.aqB.ky()))
    {
      bool = this.aqB.aqR;
      i = this.aqB.aqP;
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
      while ((i < this.aqE) && (k >= 0) && (k < paramInt))
      {
        parama.S(k, 0);
        k += j;
        i += 1;
      }
      kl();
      bool = this.aqv;
      if (this.aqy == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.aqy;
      break;
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    return d(params);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    return c(params);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    return e(params);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    return d(params);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    return c(params);
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    return e(params);
  }
  
  public final void e(View paramView1, View paramView2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    km();
    kl();
    int i = getPosition(paramView1);
    int j = getPosition(paramView2);
    if (i < j) {
      i = 1;
    }
    while (this.aqv) {
      if (i == 1)
      {
        ah(j, this.aqs.kI() - (this.aqs.bo(paramView2) + this.aqs.bs(paramView1)));
        return;
        i = -1;
      }
      else
      {
        ah(j, this.aqs.kI() - this.aqs.bp(paramView2));
        return;
      }
    }
    if (i == -1)
    {
      ah(j, this.aqs.bo(paramView2));
      return;
    }
    ah(j, this.aqs.bp(paramView2) - this.aqs.bs(paramView1));
  }
  
  public View findViewByPosition(int paramInt)
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
      int j = paramInt - getPosition(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (getPosition(localView) == paramInt);
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  protected final boolean jH()
  {
    return getLayoutDirection() == 1;
  }
  
  protected void km()
  {
    if (this.aqr == null) {
      this.aqr = new c();
    }
  }
  
  public final int ks()
  {
    View localView = c(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public final int kt()
  {
    View localView = c(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public final int ku()
  {
    View localView = c(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public final int kv()
  {
    View localView = c(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.aqA)
    {
      removeAndRecycleAllViews(paramn);
      paramn.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    kl();
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = cb(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    km();
    km();
    a(paramInt, (int)(0.3333333F * this.aqs.kJ()), false, params);
    this.aqr.aqK = -2147483648;
    this.aqr.apX = false;
    a(paramn, this.aqr, params, true);
    if (paramInt == -1) {
      if (this.aqv)
      {
        paramView = kr();
        label105:
        paramn = paramView;
        if (paramInt != -1) {
          break label163;
        }
      }
    }
    label163:
    for (paramView = ko();; paramView = kp())
    {
      if (!paramView.hasFocusable()) {
        return paramn;
      }
      if (paramn != null) {
        break;
      }
      return null;
      paramView = kq();
      break label105;
      if (this.aqv) {}
      for (paramView = kq();; paramView = kr())
      {
        paramn = paramView;
        break;
      }
    }
    return paramn;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(ks());
      paramAccessibilityEvent.setToIndex(ku());
    }
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    if (((this.aqB != null) || (this.aqy != -1)) && (params.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramn);
      return;
    }
    if ((this.aqB != null) && (this.aqB.ky())) {
      this.aqy = this.aqB.aqP;
    }
    km();
    this.aqr.apX = false;
    kl();
    Object localObject1 = getFocusedChild();
    Object localObject2;
    int i;
    label220:
    label239:
    int j;
    label262:
    label276:
    label295:
    int m;
    int n;
    int k;
    if ((!this.aqC.aqH) || (this.aqy != -1) || (this.aqB != null))
    {
      this.aqC.reset();
      this.aqC.aqG = (this.aqv ^ this.aqw);
      localObject2 = this.aqC;
      if ((params.aue) || (this.aqy == -1))
      {
        i = 0;
        if (i == 0)
        {
          if (getChildCount() == 0) {
            break label1440;
          }
          localObject1 = getFocusedChild();
          if (localObject1 == null) {
            break label1249;
          }
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
          if ((localLayoutParams.atw.isRemoved()) || (localLayoutParams.atw.lQ() < 0) || (localLayoutParams.atw.lQ() >= params.getItemCount())) {
            break label1244;
          }
          i = 1;
          if (i == 0) {
            break label1249;
          }
          ((a)localObject2).C((View)localObject1, getPosition((View)localObject1));
          i = 1;
          if (i == 0)
          {
            ((a)localObject2).kw();
            if (!this.aqw) {
              break label1445;
            }
            i = params.getItemCount() - 1;
            ((a)localObject2).mPosition = i;
          }
        }
        this.aqC.aqH = true;
        i = b(params);
        if (this.aqr.aqN < 0) {
          break label1511;
        }
        j = 0;
        m = this.aqs.kH() + j;
        n = i + this.aqs.getEndPadding();
        j = n;
        k = m;
        if (params.aue)
        {
          j = n;
          k = m;
          if (this.aqy != -1)
          {
            j = n;
            k = m;
            if (this.aqz != -2147483648)
            {
              localObject1 = findViewByPosition(this.aqy);
              j = n;
              k = m;
              if (localObject1 != null)
              {
                if (!this.aqv) {
                  break label1523;
                }
                i = this.aqs.kI() - this.aqs.bp((View)localObject1) - this.aqz;
                label419:
                if (i <= 0) {
                  break label1555;
                }
                k = m + i;
                j = n;
              }
            }
          }
        }
        label433:
        if (!this.aqC.aqG) {
          break label1573;
        }
        if (!this.aqv) {
          break label1568;
        }
        i = 1;
        label452:
        a(paramn, params, this.aqC, i);
        detachAndScrapAttachedViews(paramn);
        this.aqr.aqe = kn();
        this.aqr.aqM = params.aue;
        if (!this.aqC.aqG) {
          break label1590;
        }
        b(this.aqC);
        this.aqr.aqL = k;
        a(paramn, this.aqr, params, false);
        k = this.aqr.fs;
        m = this.aqr.apZ;
        i = j;
        if (this.aqr.apY > 0) {
          i = j + this.aqr.apY;
        }
        a(this.aqC);
        this.aqr.aqL = i;
        localObject1 = this.aqr;
        ((c)localObject1).apZ += this.aqr.aqa;
        a(paramn, this.aqr, params, false);
        i = this.aqr.fs;
        if (this.aqr.apY <= 0) {
          break label2179;
        }
        j = this.aqr.apY;
        ag(m, k);
        this.aqr.aqL = j;
        a(paramn, this.aqr, params, false);
        j = this.aqr.fs;
      }
    }
    for (;;)
    {
      label688:
      if (getChildCount() > 0) {
        if ((this.aqv ^ this.aqw))
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
        label799:
        boolean bool;
        if ((!params.aui) || (getChildCount() == 0) || (params.aue) || (!supportsPredictiveItemAnimations()))
        {
          if (params.aue) {
            break label2136;
          }
          paramn = this.aqs;
          paramn.arJ = paramn.kJ();
          this.aqt = this.aqw;
          return;
          if ((this.aqy < 0) || (this.aqy >= params.getItemCount()))
          {
            this.aqy = -1;
            this.aqz = -2147483648;
            i = 0;
            break;
          }
          ((a)localObject2).mPosition = this.aqy;
          if ((this.aqB != null) && (this.aqB.ky()))
          {
            ((a)localObject2).aqG = this.aqB.aqR;
            if (((a)localObject2).aqG) {}
            for (((a)localObject2).aqF = (this.aqs.kI() - this.aqB.aqQ);; ((a)localObject2).aqF = (this.aqs.kH() + this.aqB.aqQ))
            {
              i = 1;
              break;
            }
          }
          if (this.aqz == -2147483648)
          {
            localObject1 = findViewByPosition(this.aqy);
            if (localObject1 != null) {
              if (this.aqs.bs((View)localObject1) > this.aqs.kJ()) {
                ((a)localObject2).kw();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.aqs.bo((View)localObject1) - this.aqs.kH() < 0)
            {
              ((a)localObject2).aqF = this.aqs.kH();
              ((a)localObject2).aqG = false;
            }
            else if (this.aqs.kI() - this.aqs.bp((View)localObject1) < 0)
            {
              ((a)localObject2).aqF = this.aqs.kI();
              ((a)localObject2).aqG = true;
            }
            else
            {
              if (((a)localObject2).aqG) {}
              for (i = this.aqs.bp((View)localObject1) + this.aqs.kG();; i = this.aqs.bo((View)localObject1))
              {
                ((a)localObject2).aqF = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = getPosition(getChildAt(0));
                if (this.aqy >= i) {
                  break label1176;
                }
                bool = true;
                label1149:
                if (bool != this.aqv) {
                  break label1182;
                }
              }
              label1176:
              label1182:
              for (bool = true;; bool = false)
              {
                ((a)localObject2).aqG = bool;
                ((a)localObject2).kw();
                break;
                bool = false;
                break label1149;
              }
              ((a)localObject2).aqG = this.aqv;
              if (this.aqv) {
                ((a)localObject2).aqF = (this.aqs.kI() - this.aqz);
              } else {
                ((a)localObject2).aqF = (this.aqs.kH() + this.aqz);
              }
            }
          }
          label1244:
          i = 0;
          break label220;
          label1249:
          if (this.aqt == this.aqw)
          {
            if (((a)localObject2).aqG)
            {
              if (this.aqv) {
                break label1404;
              }
              localObject1 = a(paramn, params);
              if (localObject1 == null) {
                break label1440;
              }
              ((a)localObject2).D((View)localObject1, getPosition((View)localObject1));
              if ((!params.aue) && (supportsPredictiveItemAnimations()))
              {
                if ((this.aqs.bo((View)localObject1) < this.aqs.kI()) && (this.aqs.bp((View)localObject1) >= this.aqs.kH())) {
                  break label1424;
                }
                i = 1;
                if (i != 0) {
                  if (!((a)localObject2).aqG) {
                    break label1429;
                  }
                }
              }
            }
            for (i = this.aqs.kI();; i = this.aqs.kH())
            {
              ((a)localObject2).aqF = i;
              i = 1;
              break;
              if (this.aqv)
              {
                localObject1 = a(paramn, params);
                break label1283;
              }
              label1404:
              localObject1 = a(paramn, params, 0, getChildCount(), params.getItemCount());
              break label1283;
              i = 0;
              break label1355;
            }
          }
          label1283:
          label1355:
          i = 0;
          label1424:
          label1429:
          label1440:
          break label239;
          label1445:
          i = 0;
          break label262;
          if ((localObject1 == null) || ((this.aqs.bo((View)localObject1) < this.aqs.kI()) && (this.aqs.bp((View)localObject1) > this.aqs.kH()))) {
            break label276;
          }
          this.aqC.C((View)localObject1, getPosition((View)localObject1));
          break label276;
          label1511:
          k = 0;
          j = i;
          i = k;
          break label295;
          label1523:
          i = this.aqs.bo((View)localObject1);
          j = this.aqs.kH();
          i = this.aqz - (i - j);
          break label419;
          label1555:
          j = n - i;
          k = m;
          break label433;
          label1568:
          i = -1;
          break label452;
          label1573:
          if (this.aqv)
          {
            i = -1;
            break label452;
          }
          i = 1;
          break label452;
          label1590:
          a(this.aqC);
          this.aqr.aqL = j;
          a(paramn, this.aqr, params, false);
          j = this.aqr.fs;
          m = this.aqr.apZ;
          i = k;
          if (this.aqr.apY > 0) {
            i = k + this.aqr.apY;
          }
          b(this.aqC);
          this.aqr.aqL = i;
          localObject1 = this.aqr;
          ((c)localObject1).apZ += this.aqr.aqa;
          a(paramn, this.aqr, params, false);
          k = this.aqr.fs;
          if (this.aqr.apY <= 0) {
            break label2169;
          }
          i = this.aqr.apY;
          af(m, j);
          this.aqr.aqL = i;
          a(paramn, this.aqr, params, false);
          i = this.aqr.fs;
          j = k;
          break label688;
          m = b(j, paramn, params, true);
          k = i + m;
          i = a(k, paramn, params, false);
          k += i;
          m = j + m + i;
          continue;
        }
        j = 0;
        i = 0;
        localObject1 = paramn.atI;
        int i2 = ((List)localObject1).size();
        int i3 = getPosition(getChildAt(0));
        n = 0;
        label1862:
        label1904:
        int i1;
        if (n < i2)
        {
          localObject2 = (RecyclerView.v)((List)localObject1).get(n);
          if (((RecyclerView.v)localObject2).isRemoved()) {
            break label2146;
          }
          if (((RecyclerView.v)localObject2).lQ() < i3)
          {
            bool = true;
            if (bool == this.aqv) {
              break label1974;
            }
            i1 = -1;
            label1916:
            if (i1 != -1) {
              break label1980;
            }
            i1 = this.aqs.bs(((RecyclerView.v)localObject2).aus) + j;
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
          break label1862;
          bool = false;
          break label1904;
          label1974:
          i1 = 1;
          break label1916;
          label1980:
          i1 = i + this.aqs.bs(((RecyclerView.v)localObject2).aus);
          i = j;
          j = i1;
          continue;
          this.aqr.aqO = ((List)localObject1);
          if (j > 0)
          {
            ag(getPosition(ko()), m);
            this.aqr.aqL = j;
            this.aqr.apY = 0;
            this.aqr.bm(null);
            a(paramn, this.aqr, params, false);
          }
          if (i > 0)
          {
            af(getPosition(kp()), k);
            this.aqr.aqL = i;
            this.aqr.apY = 0;
            this.aqr.bm(null);
            a(paramn, this.aqr, params, false);
          }
          this.aqr.aqO = null;
          break;
          label2136:
          this.aqC.reset();
          break label799;
          label2146:
          i1 = i;
          i = j;
          j = i1;
        }
        k = i;
        m = j;
      }
      label2169:
      i = j;
      j = k;
      continue;
      label2179:
      j = k;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    super.onLayoutCompleted(params);
    this.aqB = null;
    this.aqy = -1;
    this.aqz = -2147483648;
    this.aqC.reset();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.aqB = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.aqB != null) {
      return new SavedState(this.aqB);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      km();
      boolean bool = this.aqt ^ this.aqv;
      localSavedState.aqR = bool;
      if (bool)
      {
        localView = kp();
        localSavedState.aqQ = (this.aqs.kI() - this.aqs.bp(localView));
        localSavedState.aqP = getPosition(localView);
        return localSavedState;
      }
      View localView = ko();
      localSavedState.aqP = getPosition(localView);
      localSavedState.aqQ = (this.aqs.bo(localView) - this.aqs.kH());
      return localSavedState;
    }
    localSavedState.aqP = -1;
    return localSavedState;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return a(paramInt, paramn, params);
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.aqy = paramInt;
    this.aqz = -2147483648;
    if (this.aqB != null) {
      this.aqB.aqP = -1;
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return a(paramInt, paramn, params);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    assertNotInLayoutOrScroll(null);
    if ((paramInt != this.mOrientation) || (this.aqs == null))
    {
      this.aqs = aj.a(this, paramInt);
      this.aqC.aqs = this.aqs;
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  boolean shouldMeasureTwice()
  {
    return (getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations());
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    paramRecyclerView = new ae(paramRecyclerView.getContext());
    paramRecyclerView.atO = paramInt;
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.aqB == null) && (this.aqt == this.aqw);
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int aqP;
    int aqQ;
    boolean aqR;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.aqP = paramParcel.readInt();
      this.aqQ = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.aqR = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.aqP = paramSavedState.aqP;
      this.aqQ = paramSavedState.aqQ;
      this.aqR = paramSavedState.aqR;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final boolean ky()
    {
      return this.aqP >= 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.aqP);
      paramParcel.writeInt(this.aqQ);
      if (this.aqR) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  static final class a
  {
    int aqF;
    boolean aqG;
    boolean aqH;
    aj aqs;
    int mPosition;
    
    a()
    {
      reset();
    }
    
    public final void C(View paramView, int paramInt)
    {
      int i = this.aqs.kG();
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
              if (!this.aqG) {
                break;
              }
              paramInt = this.aqs.kI() - i - this.aqs.bp(paramView);
              this.aqF = (this.aqs.kI() - paramInt);
            } while (paramInt <= 0);
            i = this.aqs.bs(paramView);
            j = this.aqF;
            k = this.aqs.kH();
            i = j - i - (k + Math.min(this.aqs.bo(paramView) - k, 0));
          } while (i >= 0);
          j = this.aqF;
          this.aqF = (Math.min(paramInt, -i) + j);
          return;
          j = this.aqs.bo(paramView);
          paramInt = j - this.aqs.kH();
          this.aqF = j;
        } while (paramInt <= 0);
        int k = this.aqs.bs(paramView);
        int m = this.aqs.kI();
        int n = this.aqs.bp(paramView);
        i = this.aqs.kI() - Math.min(0, m - i - n) - (j + k);
      } while (i >= 0);
      this.aqF -= Math.min(paramInt, -i);
    }
    
    public final void D(View paramView, int paramInt)
    {
      if (this.aqG) {}
      for (this.aqF = (this.aqs.bp(paramView) + this.aqs.kG());; this.aqF = this.aqs.bo(paramView))
      {
        this.mPosition = paramInt;
        return;
      }
    }
    
    final void kw()
    {
      if (this.aqG) {}
      for (int i = this.aqs.kI();; i = this.aqs.kH())
      {
        this.aqF = i;
        return;
      }
    }
    
    final void reset()
    {
      this.mPosition = -1;
      this.aqF = -2147483648;
      this.aqG = false;
      this.aqH = false;
    }
    
    public final String toString()
    {
      return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.aqF + ", mLayoutFromEnd=" + this.aqG + ", mValid=" + this.aqH + '}';
    }
  }
  
  protected static final class b
  {
    public boolean adH;
    public int aqI;
    public boolean aqJ;
    public boolean mFinished;
    
    final void resetInternal()
    {
      this.aqI = 0;
      this.mFinished = false;
      this.aqJ = false;
      this.adH = false;
    }
  }
  
  static final class c
  {
    boolean apX = true;
    int apY;
    int apZ;
    int aqK;
    int aqL = 0;
    boolean aqM = false;
    int aqN;
    List<RecyclerView.v> aqO = null;
    int aqa;
    boolean aqe;
    int fs;
    int mLayoutDirection;
    
    private View bn(View paramView)
    {
      int m = this.aqO.size();
      Object localObject = null;
      int i = 2147483647;
      int j = 0;
      if (j < m)
      {
        View localView = ((RecyclerView.v)this.aqO.get(j)).aus;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((localView == paramView) || (localLayoutParams.atw.isRemoved())) {
          break label127;
        }
        int k = (localLayoutParams.atw.lQ() - this.apZ) * this.aqa;
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
    
    private View kx()
    {
      int j = this.aqO.size();
      int i = 0;
      while (i < j)
      {
        View localView = ((RecyclerView.v)this.aqO.get(i)).aus;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.atw.isRemoved()) && (this.apZ == localLayoutParams.atw.lQ()))
        {
          bm(localView);
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    final View a(RecyclerView.n paramn)
    {
      if (this.aqO != null) {
        return kx();
      }
      paramn = paramn.cq(this.apZ);
      this.apZ += this.aqa;
      return paramn;
    }
    
    final boolean a(RecyclerView.s params)
    {
      return (this.apZ >= 0) && (this.apZ < params.getItemCount());
    }
    
    public final void bm(View paramView)
    {
      paramView = bn(paramView);
      if (paramView == null)
      {
        this.apZ = -1;
        return;
      }
      this.apZ = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).atw.lQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */