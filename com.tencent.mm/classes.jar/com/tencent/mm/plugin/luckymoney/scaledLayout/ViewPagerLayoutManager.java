package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class ViewPagerLayoutManager
  extends LinearLayoutManager
{
  private boolean aqA;
  private boolean aqe = false;
  private boolean aqu = false;
  private boolean aqv = false;
  private boolean aqx = true;
  private int aqy = -1;
  public int mOrientation;
  int yYA = -1;
  private Interpolator yYB;
  int yYC = 2147483647;
  private View yYD;
  private SparseArray<View> yYo = new SparseArray();
  protected int yYp;
  protected int yYq;
  protected int yYr;
  protected int yYs;
  protected float yYt;
  protected b yYu;
  private SavedState yYv = null;
  protected float yYw;
  private boolean yYx;
  private int yYy;
  private int yYz;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    ao(paramBoolean);
    setAutoMeasureEnabled(true);
    setItemPrefetchEnabled(false);
  }
  
  private float PL(int paramInt)
  {
    if (this.aqv) {
      return paramInt * -this.yYw;
    }
    return paramInt * this.yYw;
  }
  
  private int a(int paramInt, RecyclerView.n paramn)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    km();
    float f = paramInt / efo();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.yYt + f;
    int i;
    if ((!this.aqe) && (f < efv())) {
      i = (int)(paramInt - (f - efv()) * efo());
    }
    for (;;)
    {
      this.yYt = (i / efo() + this.yYt);
      b(paramn);
      return i;
      i = paramInt;
      if (!this.aqe)
      {
        i = paramInt;
        if (f > efu()) {
          i = (int)((efu() - this.yYt) * efo());
        }
      }
    }
  }
  
  private void b(RecyclerView.n paramn)
  {
    detachAndScrapAttachedViews(paramn);
    this.yYo.clear();
    int i2 = getItemCount();
    if (i2 == 0) {
      return;
    }
    int i3;
    int j;
    int i;
    label75:
    label106:
    int m;
    int i1;
    int n;
    int k;
    if (this.aqv)
    {
      i3 = -efy();
      j = i3 - this.yYy;
      i = this.yYz + i3;
      if (eft())
      {
        if (this.yYA % 2 != 0) {
          break label329;
        }
        i = 1;
        if (i == 0) {
          break label335;
        }
        i = this.yYA / 2;
        j = i3 - i + 1;
        i = i + i3 + 1;
      }
      m = i;
      i1 = j;
      if (!this.aqe)
      {
        n = i;
        k = j;
        if (j < 0)
        {
          if (!eft()) {
            break label438;
          }
          n = this.yYA;
          k = 0;
        }
      }
    }
    for (;;)
    {
      m = n;
      i1 = k;
      if (n > i2)
      {
        m = i2;
        i1 = k;
      }
      float f1 = 1.4E-45F;
      i = i1;
      label180:
      if (i < m)
      {
        if ((!eft()) && (br(PL(i) - this.yYt))) {
          break label426;
        }
        if (i >= i2) {
          j = i % i2;
        }
      }
      for (;;)
      {
        label226:
        View localView = paramn.cp(j);
        measureChildWithMargins(localView, 0, 0);
        ep(localView);
        w(localView, PL(i) - this.yYt);
        float f2;
        if (this.yYx)
        {
          f2 = 0.0F;
          label273:
          if (f2 <= f1) {
            break label407;
          }
          addView(localView);
          label285:
          if (i == i3) {
            this.yYD = localView;
          }
          this.yYo.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = efy();
          break;
          label329:
          i = 0;
          break label75;
          label335:
          i = (this.yYA - 1) / 2;
          j = i3 - i;
          i = i + i3 + 1;
          break label106;
          if (i >= 0) {
            break label431;
          }
          k = -i % i2;
          j = k;
          if (k == 0) {
            j = i2;
          }
          j = i2 - j;
          break label226;
          f2 = j;
          break label273;
          label407:
          addView(localView, 0);
          break label285;
          this.yYD.requestFocus();
          return;
          label426:
          f2 = f1;
        }
        label431:
        j = i;
      }
      label438:
      k = 0;
      n = i;
    }
  }
  
  private boolean br(float paramFloat)
  {
    return (paramFloat > efw()) || (paramFloat < efx());
  }
  
  private int bs(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return (int)paramFloat;
  }
  
  private int bt(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return (int)paramFloat;
    }
    return 0;
  }
  
  private static View d(RecyclerView.n paramn, RecyclerView.s params, int paramInt)
  {
    for (;;)
    {
      if ((paramInt >= params.getItemCount()) || (paramInt < 0)) {
        return null;
      }
      try
      {
        View localView = paramn.cp(paramInt);
        return localView;
      }
      catch (Exception localException)
      {
        paramInt += 1;
      }
    }
  }
  
  private int efq()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aqx)
    {
      if (!this.aqv) {
        return getCurrentPosition();
      }
      return getItemCount() - getCurrentPosition() - 1;
    }
    float f = efz();
    if (!this.aqv) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.yYw);
  }
  
  private int efr()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aqx) {
      return 1;
    }
    return (int)this.yYw;
  }
  
  private int efs()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aqx) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.yYw);
  }
  
  private boolean eft()
  {
    return this.yYA != -1;
  }
  
  private float efu()
  {
    if (!this.aqv) {
      return (getItemCount() - 1) * this.yYw;
    }
    return 0.0F;
  }
  
  private float efv()
  {
    if (!this.aqv) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.yYw;
  }
  
  private float efw()
  {
    return this.yYu.kJ() - this.yYr;
  }
  
  private float efx()
  {
    return -this.yYp - this.yYu.kH() - this.yYr;
  }
  
  private int efy()
  {
    if (this.yYw == 0.0F) {
      return 0;
    }
    return Math.round(this.yYt / this.yYw);
  }
  
  private float efz()
  {
    if (this.aqv)
    {
      if (this.aqe)
      {
        if (this.yYt <= 0.0F) {
          return this.yYt % (this.yYw * getItemCount());
        }
        return getItemCount() * -this.yYw + this.yYt % (this.yYw * getItemCount());
      }
      return this.yYt;
    }
    if (this.aqe)
    {
      if (this.yYt >= 0.0F) {
        return this.yYt % (this.yYw * getItemCount());
      }
      return getItemCount() * this.yYw + this.yYt % (this.yYw * getItemCount());
    }
    return this.yYt;
  }
  
  private static void ep(View paramView)
  {
    paramView.setRotation(0.0F);
    paramView.setRotationY(0.0F);
    paramView.setRotationX(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setAlpha(1.0F);
  }
  
  private int getCurrentPosition()
  {
    int j;
    if (getItemCount() == 0)
    {
      j = 0;
      return j;
    }
    int i = efy();
    if (!this.aqe) {
      return Math.abs(i);
    }
    if (!this.aqv) {
      if (i >= 0) {
        i %= getItemCount();
      }
    }
    for (;;)
    {
      j = i;
      if (i != getItemCount()) {
        break;
      }
      return 0;
      j = getItemCount();
      i = i % getItemCount() + j;
      continue;
      if (i > 0) {
        i = getItemCount() - i % getItemCount();
      } else {
        i = -i % getItemCount();
      }
    }
  }
  
  private void w(View paramView, float paramFloat)
  {
    int i = bs(paramFloat);
    int j = bt(paramFloat);
    int k;
    int m;
    int n;
    if (this.mOrientation == 1)
    {
      k = this.yYs;
      m = this.yYr;
      n = this.yYs;
      layoutDecorated(paramView, k + i, m + j, this.yYq + (i + n), this.yYr + j + this.yYp);
    }
    for (;;)
    {
      v(paramView, paramFloat);
      return;
      k = this.yYr;
      m = this.yYs;
      n = this.yYr;
      layoutDecorated(paramView, k + i, m + j, this.yYp + (i + n), this.yYs + j + this.yYq);
    }
  }
  
  public final int AE(int paramInt)
  {
    if (this.aqe)
    {
      int i = efy();
      if (!this.aqv) {
        paramInt -= efy();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.yYw - this.yYt) * efo());
        paramInt = -efy() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.aqv) {}
    for (float f1 = this.yYw;; f1 = -this.yYw) {
      return (int)((f1 * f2 - this.yYt) * efo());
    }
  }
  
  public final void ao(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.aqu) {
      return;
    }
    this.aqu = paramBoolean;
    removeAllViews();
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.s params)
  {
    return efr();
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    return efq();
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    return efs();
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    return efr();
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    return efq();
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    return efs();
  }
  
  protected abstract float efn();
  
  protected float efo()
  {
    return 1.0F;
  }
  
  protected void efp() {}
  
  public View findViewByPosition(int paramInt)
  {
    int m = getItemCount();
    if (m == 0) {
      return null;
    }
    int i = 0;
    while (i < this.yYo.size())
    {
      int j = this.yYo.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.yYo.valueAt(i);
        }
      }
      else
      {
        int k = j % m;
        j = k;
        if (k == 0) {
          j = -m;
        }
        if (j + m == paramInt) {
          return (View)this.yYo.valueAt(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final void km()
  {
    if (this.yYu == null) {
      this.yYu = b.b(this, this.mOrientation);
    }
  }
  
  public void onAdapterChanged(RecyclerView.a parama1, RecyclerView.a parama2)
  {
    removeAllViews();
    this.yYt = 0.0F;
  }
  
  public boolean onAddFocusables(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = getCurrentPosition();
    View localView = findViewByPosition(i);
    if (localView == null) {
      return true;
    }
    if (paramRecyclerView.hasFocus())
    {
      if (this.mOrientation == 1) {
        if (paramInt1 == 33) {
          if (this.aqv)
          {
            paramInt1 = 0;
            label51:
            if (paramInt1 == -1) {
              break label172;
            }
            if (paramInt1 != 1) {
              break label174;
            }
          }
        }
      }
      label172:
      label174:
      for (paramInt1 = i - 1;; paramInt1 = i + 1)
      {
        paramInt1 = AE(paramInt1);
        if (this.mOrientation != 1) {
          break label182;
        }
        paramRecyclerView.a(0, paramInt1, null);
        return true;
        paramInt1 = 1;
        break label51;
        if (paramInt1 == 130)
        {
          if (this.aqv)
          {
            paramInt1 = 1;
            break label51;
          }
          paramInt1 = 0;
          break label51;
        }
        paramInt1 = -1;
        break label51;
        if (paramInt1 == 17)
        {
          if (this.aqv)
          {
            paramInt1 = 0;
            break label51;
          }
          paramInt1 = 1;
          break label51;
        }
        if (paramInt1 == 66)
        {
          if (this.aqv)
          {
            paramInt1 = 1;
            break label51;
          }
          paramInt1 = 0;
          break label51;
        }
        paramInt1 = -1;
        break label51;
        break;
      }
      label182:
      paramRecyclerView.a(paramInt1, 0, null);
      return true;
    }
    localView.addFocusables(paramArrayList, paramInt1, paramInt2);
    return true;
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
    return null;
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    if (params.getItemCount() == 0)
    {
      removeAndRecycleAllViews(paramn);
      this.yYt = 0.0F;
      return;
    }
    km();
    boolean bool;
    if ((this.mOrientation == 1) || (!jH())) {
      bool = this.aqu;
    }
    for (;;)
    {
      this.aqv = bool;
      params = d(paramn, params, 0);
      if (params != null) {
        break;
      }
      removeAndRecycleAllViews(paramn);
      this.yYt = 0.0F;
      return;
      if (!this.aqu) {
        bool = true;
      } else {
        bool = false;
      }
    }
    measureChildWithMargins(params, 0, 0);
    this.yYp = this.yYu.bs(params);
    this.yYq = this.yYu.bt(params);
    this.yYr = ((this.yYu.kJ() - this.yYp) / 2);
    if (this.yYC == 2147483647)
    {
      this.yYs = ((this.yYu.efm() - this.yYq) / 2);
      this.yYw = efn();
      efp();
      if (this.yYw != 0.0F) {
        break label299;
      }
      this.yYy = 1;
      this.yYz = 1;
      label197:
      if (this.yYv != null)
      {
        this.aqv = this.yYv.yYE;
        this.aqy = this.yYv.position;
        this.yYt = this.yYv.offset;
      }
      if (this.aqy != -1) {
        if (!this.aqv) {
          break label340;
        }
      }
    }
    label299:
    label340:
    for (float f = this.aqy * -this.yYw;; f = this.aqy * this.yYw)
    {
      this.yYt = f;
      b(paramn);
      return;
      this.yYs = (this.yYu.efm() - this.yYq - this.yYC);
      break;
      this.yYy = ((int)Math.abs(efx() / this.yYw) + 1);
      this.yYz = ((int)Math.abs(efw() / this.yYw) + 1);
      break label197;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    super.onLayoutCompleted(params);
    this.yYv = null;
    this.aqy = -1;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.yYv = new SavedState((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.yYv != null) {
      return new SavedState(this.yYv);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.position = this.aqy;
    localSavedState.offset = this.yYt;
    localSavedState.yYE = this.aqv;
    return localSavedState;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return a(paramInt, paramn);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((!this.aqe) && ((paramInt < 0) || (paramInt >= getItemCount()))) {
      return;
    }
    this.aqy = paramInt;
    if (this.aqv) {}
    for (float f = paramInt * -this.yYw;; f = paramInt * this.yYw)
    {
      this.yYt = f;
      requestLayout();
      return;
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return a(paramInt, paramn);
  }
  
  public final void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.yYu = null;
    this.yYC = 2147483647;
    removeAllViews();
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    int i;
    int j;
    int k;
    if (this.aqe)
    {
      i = getCurrentPosition();
      j = getItemCount();
      if (paramInt < i)
      {
        k = i - paramInt;
        paramInt = j - i + paramInt;
        if (k < paramInt) {
          paramInt = i - k;
        }
      }
    }
    for (paramInt = AE(paramInt);; paramInt = AE(paramInt))
    {
      if (this.mOrientation != 1) {
        break label130;
      }
      paramRecyclerView.a(0, paramInt, this.yYB);
      return;
      paramInt = i + paramInt;
      break;
      k = paramInt - i;
      paramInt = j + i - paramInt;
      if (k < paramInt)
      {
        paramInt = i + k;
        break;
      }
      paramInt = i - paramInt;
      break;
    }
    label130:
    paramRecyclerView.a(paramInt, 0, this.yYB);
  }
  
  protected abstract void v(View paramView, float paramFloat);
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    float offset;
    int position;
    boolean yYE;
    
    static
    {
      AppMethodBeat.i(65343);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(65343);
    }
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      AppMethodBeat.i(65341);
      this.position = paramParcel.readInt();
      this.offset = paramParcel.readFloat();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.yYE = bool;
        AppMethodBeat.o(65341);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.position = paramSavedState.position;
      this.offset = paramSavedState.offset;
      this.yYE = paramSavedState.yYE;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(65342);
      paramParcel.writeInt(this.position);
      paramParcel.writeFloat(this.offset);
      if (this.yYE) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(65342);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
 * JD-Core Version:    0.7.0.1
 */