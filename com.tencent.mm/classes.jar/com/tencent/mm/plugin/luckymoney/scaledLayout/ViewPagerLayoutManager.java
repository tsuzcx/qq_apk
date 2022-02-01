package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class ViewPagerLayoutManager
  extends LinearLayoutManager
{
  protected int ECA;
  protected int ECB;
  protected b ECC;
  private SavedState ECD = null;
  protected float ECE;
  private boolean ECF;
  private int ECG;
  private int ECH;
  private int ECI = -1;
  private Interpolator ECJ;
  private int ECK = 2147483647;
  private View ECL;
  private SparseArray<View> ECx = new SparseArray();
  protected int ECy;
  protected int ECz;
  private boolean aiR = false;
  private boolean aiV = false;
  private boolean aiW = false;
  private boolean aiY = true;
  private int aiZ = -1;
  private boolean ajb;
  public int mOrientation;
  protected float xrL;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    aq(paramBoolean);
    setAutoMeasureEnabled(true);
    setItemPrefetchEnabled(false);
  }
  
  private float VW(int paramInt)
  {
    if (this.aiW) {
      return paramInt * -this.ECE;
    }
    return paramInt * this.ECE;
  }
  
  private int a(int paramInt, RecyclerView.n paramn)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    kD();
    float f = paramInt / eOM();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.xrL + f;
    int i;
    if ((!this.aiR) && (f < eOT())) {
      i = (int)(paramInt - (f - eOT()) * eOM());
    }
    for (;;)
    {
      this.xrL = (i / eOM() + this.xrL);
      b(paramn);
      return i;
      i = paramInt;
      if (!this.aiR)
      {
        i = paramInt;
        if (f > eOS()) {
          i = (int)((eOS() - this.xrL) * eOM());
        }
      }
    }
  }
  
  private void b(RecyclerView.n paramn)
  {
    detachAndScrapAttachedViews(paramn);
    this.ECx.clear();
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
    if (this.aiW)
    {
      i3 = -eOW();
      j = i3 - this.ECG;
      i = this.ECH + i3;
      if (eOR())
      {
        if (this.ECI % 2 != 0) {
          break label329;
        }
        i = 1;
        if (i == 0) {
          break label335;
        }
        i = this.ECI / 2;
        j = i3 - i + 1;
        i = i + i3 + 1;
      }
      m = i;
      i1 = j;
      if (!this.aiR)
      {
        n = i;
        k = j;
        if (j < 0)
        {
          if (!eOR()) {
            break label438;
          }
          n = this.ECI;
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
        if ((!eOR()) && (bt(VW(i) - this.xrL))) {
          break label426;
        }
        if (i >= i2) {
          j = i % i2;
        }
      }
      for (;;)
      {
        label226:
        View localView = paramn.cR(j);
        measureChildWithMargins(localView, 0, 0);
        fn(localView);
        w(localView, VW(i) - this.xrL);
        float f2;
        if (this.ECF)
        {
          f2 = 0.0F;
          label273:
          if (f2 <= f1) {
            break label407;
          }
          addView(localView);
          label285:
          if (i == i3) {
            this.ECL = localView;
          }
          this.ECx.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = eOW();
          break;
          label329:
          i = 0;
          break label75;
          label335:
          i = (this.ECI - 1) / 2;
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
          this.ECL.requestFocus();
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
  
  private boolean bt(float paramFloat)
  {
    return (paramFloat > eOU()) || (paramFloat < eOV());
  }
  
  private int bu(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return (int)paramFloat;
  }
  
  private int bv(float paramFloat)
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
        View localView = paramn.cR(paramInt);
        return localView;
      }
      catch (Exception localException)
      {
        paramInt += 1;
      }
    }
  }
  
  private int eOO()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aiY)
    {
      if (!this.aiW) {
        return getCurrentPosition();
      }
      return getItemCount() - getCurrentPosition() - 1;
    }
    float f = eOX();
    if (!this.aiW) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.ECE);
  }
  
  private int eOP()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aiY) {
      return 1;
    }
    return (int)this.ECE;
  }
  
  private int eOQ()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aiY) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.ECE);
  }
  
  private boolean eOR()
  {
    return this.ECI != -1;
  }
  
  private float eOS()
  {
    if (!this.aiW) {
      return (getItemCount() - 1) * this.ECE;
    }
    return 0.0F;
  }
  
  private float eOT()
  {
    if (!this.aiW) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.ECE;
  }
  
  private float eOU()
  {
    return this.ECC.kV() - this.ECA;
  }
  
  private float eOV()
  {
    return -this.ECy - this.ECC.kT() - this.ECA;
  }
  
  private int eOW()
  {
    if (this.ECE == 0.0F) {
      return 0;
    }
    return Math.round(this.xrL / this.ECE);
  }
  
  private float eOX()
  {
    if (this.aiW)
    {
      if (this.aiR)
      {
        if (this.xrL <= 0.0F) {
          return this.xrL % (this.ECE * getItemCount());
        }
        return getItemCount() * -this.ECE + this.xrL % (this.ECE * getItemCount());
      }
      return this.xrL;
    }
    if (this.aiR)
    {
      if (this.xrL >= 0.0F) {
        return this.xrL % (this.ECE * getItemCount());
      }
      return getItemCount() * this.ECE + this.xrL % (this.ECE * getItemCount());
    }
    return this.xrL;
  }
  
  private static void fn(View paramView)
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
    int i = eOW();
    if (!this.aiR) {
      return Math.abs(i);
    }
    if (!this.aiW) {
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
    int i = bu(paramFloat);
    int j = bv(paramFloat);
    int k;
    int m;
    int n;
    if (this.mOrientation == 1)
    {
      k = this.ECB;
      m = this.ECA;
      n = this.ECB;
      layoutDecorated(paramView, k + i, m + j, this.ECz + (i + n), this.ECA + j + this.ECy);
    }
    for (;;)
    {
      v(paramView, paramFloat);
      return;
      k = this.ECA;
      m = this.ECB;
      n = this.ECA;
      layoutDecorated(paramView, k + i, m + j, this.ECy + (i + n), this.ECB + j + this.ECz);
    }
  }
  
  public final int Ek(int paramInt)
  {
    if (this.aiR)
    {
      int i = eOW();
      if (!this.aiW) {
        paramInt -= eOW();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.ECE - this.xrL) * eOM());
        paramInt = -eOW() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.aiW) {}
    for (float f1 = this.ECE;; f1 = -this.ECE) {
      return (int)((f1 * f2 - this.xrL) * eOM());
    }
  }
  
  public final void VV(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (this.ECI == paramInt) {
      return;
    }
    this.ECI = paramInt;
    removeAllViews();
  }
  
  public final void VX(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (this.ECK == paramInt) {
      return;
    }
    this.ECK = paramInt;
    removeAllViews();
  }
  
  public final void aq(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.aiV) {
      return;
    }
    this.aiV = paramBoolean;
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
    return eOP();
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    return eOO();
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    return eOQ();
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    return eOP();
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    return eOO();
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    return eOQ();
  }
  
  protected abstract float eOL();
  
  protected float eOM()
  {
    return 1.0F;
  }
  
  protected void eON() {}
  
  public View findViewByPosition(int paramInt)
  {
    int m = getItemCount();
    if (m == 0) {
      return null;
    }
    int i = 0;
    while (i < this.ECx.size())
    {
      int j = this.ECx.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.ECx.valueAt(i);
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
          return (View)this.ECx.valueAt(i);
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
  
  public final void kD()
  {
    if (this.ECC == null) {
      this.ECC = b.b(this, this.mOrientation);
    }
  }
  
  public void onAdapterChanged(RecyclerView.a parama1, RecyclerView.a parama2)
  {
    removeAllViews();
    this.xrL = 0.0F;
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
          if (this.aiW)
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
        paramInt1 = Ek(paramInt1);
        if (this.mOrientation != 1) {
          break label182;
        }
        paramRecyclerView.a(0, paramInt1, null);
        return true;
        paramInt1 = 1;
        break label51;
        if (paramInt1 == 130)
        {
          if (this.aiW)
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
          if (this.aiW)
          {
            paramInt1 = 0;
            break label51;
          }
          paramInt1 = 1;
          break label51;
        }
        if (paramInt1 == 66)
        {
          if (this.aiW)
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
    if (this.ajb)
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
      this.xrL = 0.0F;
      return;
    }
    kD();
    boolean bool;
    if ((this.mOrientation == 1) || (!kp())) {
      bool = this.aiV;
    }
    for (;;)
    {
      this.aiW = bool;
      params = d(paramn, params, 0);
      if (params != null) {
        break;
      }
      removeAndRecycleAllViews(paramn);
      this.xrL = 0.0F;
      return;
      if (!this.aiV) {
        bool = true;
      } else {
        bool = false;
      }
    }
    measureChildWithMargins(params, 0, 0);
    this.ECy = this.ECC.bd(params);
    this.ECz = this.ECC.be(params);
    this.ECA = ((this.ECC.kV() - this.ECy) / 2);
    if (this.ECK == 2147483647)
    {
      this.ECB = ((this.ECC.eOK() - this.ECz) / 2);
      this.ECE = eOL();
      eON();
      if (this.ECE != 0.0F) {
        break label299;
      }
      this.ECG = 1;
      this.ECH = 1;
      label197:
      if (this.ECD != null)
      {
        this.aiW = this.ECD.ECM;
        this.aiZ = this.ECD.position;
        this.xrL = this.ECD.offset;
      }
      if (this.aiZ != -1) {
        if (!this.aiW) {
          break label340;
        }
      }
    }
    label299:
    label340:
    for (float f = this.aiZ * -this.ECE;; f = this.aiZ * this.ECE)
    {
      this.xrL = f;
      b(paramn);
      return;
      this.ECB = (this.ECC.eOK() - this.ECz - this.ECK);
      break;
      this.ECG = ((int)Math.abs(eOV() / this.ECE) + 1);
      this.ECH = ((int)Math.abs(eOU() / this.ECE) + 1);
      break label197;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    super.onLayoutCompleted(params);
    this.ECD = null;
    this.aiZ = -1;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.ECD = new SavedState((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.ECD != null) {
      return new SavedState(this.ECD);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.position = this.aiZ;
    localSavedState.offset = this.xrL;
    localSavedState.ECM = this.aiW;
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
    if ((!this.aiR) && ((paramInt < 0) || (paramInt >= getItemCount()))) {
      return;
    }
    this.aiZ = paramInt;
    if (this.aiW) {}
    for (float f = paramInt * -this.ECE;; f = paramInt * this.ECE)
    {
      this.xrL = f;
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
    this.ECC = null;
    this.ECK = 2147483647;
    removeAllViews();
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    int i;
    int j;
    int k;
    if (this.aiR)
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
    for (paramInt = Ek(paramInt);; paramInt = Ek(paramInt))
    {
      if (this.mOrientation != 1) {
        break label130;
      }
      paramRecyclerView.a(0, paramInt, this.ECJ);
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
    paramRecyclerView.a(paramInt, 0, this.ECJ);
  }
  
  protected abstract void v(View paramView, float paramFloat);
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean ECM;
    float offset;
    int position;
    
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
        this.ECM = bool;
        AppMethodBeat.o(65341);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.position = paramSavedState.position;
      this.offset = paramSavedState.offset;
      this.ECM = paramSavedState.ECM;
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
      if (this.ECM) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(65342);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
 * JD-Core Version:    0.7.0.1
 */