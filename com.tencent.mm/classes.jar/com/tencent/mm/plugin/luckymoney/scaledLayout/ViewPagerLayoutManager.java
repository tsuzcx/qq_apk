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
  protected float AOV;
  private SparseArray<View> KvB = new SparseArray();
  protected int KvC;
  protected int KvD;
  protected int KvE;
  protected int KvF;
  protected b KvG;
  private SavedState KvH = null;
  protected float KvI;
  private boolean KvJ;
  private int KvK;
  private int KvL;
  private int KvM = -1;
  private Interpolator KvN;
  private int KvO = 2147483647;
  private View KvP;
  private boolean bXA = false;
  private boolean bXB = false;
  private boolean bXD = true;
  private int bXE = -1;
  private boolean bXG;
  private boolean bXw = false;
  public int mOrientation;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    aZ(paramBoolean);
    setAutoMeasureEnabled(true);
    setItemPrefetchEnabled(false);
  }
  
  private float ZS(int paramInt)
  {
    if (this.bXB) {
      return paramInt * -this.KvI;
    }
    return paramInt * this.KvI;
  }
  
  private void c(RecyclerView.n paramn)
  {
    detachAndScrapAttachedViews(paramn);
    this.KvB.clear();
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
    if (this.bXB)
    {
      i3 = -fXA();
      j = i3 - this.KvK;
      i = this.KvL + i3;
      if (fXv())
      {
        if (this.KvM % 2 != 0) {
          break label329;
        }
        i = 1;
        if (i == 0) {
          break label335;
        }
        i = this.KvM / 2;
        j = i3 - i + 1;
        i = i + i3 + 1;
      }
      m = i;
      i1 = j;
      if (!this.bXw)
      {
        n = i;
        k = j;
        if (j < 0)
        {
          if (!fXv()) {
            break label438;
          }
          n = this.KvM;
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
        if ((!fXv()) && (cx(ZS(i) - this.AOV))) {
          break label426;
        }
        if (i >= i2) {
          j = i % i2;
        }
      }
      for (;;)
      {
        label226:
        View localView = paramn.gb(j);
        measureChildWithMargins(localView, 0, 0);
        ia(localView);
        x(localView, ZS(i) - this.AOV);
        float f2;
        if (this.KvJ)
        {
          f2 = 0.0F;
          label273:
          if (f2 <= f1) {
            break label407;
          }
          addView(localView);
          label285:
          if (i == i3) {
            this.KvP = localView;
          }
          this.KvB.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = fXA();
          break;
          label329:
          i = 0;
          break label75;
          label335:
          i = (this.KvM - 1) / 2;
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
          this.KvP.requestFocus();
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
  
  private boolean cx(float paramFloat)
  {
    return (paramFloat > fXy()) || (paramFloat < fXz());
  }
  
  private int cy(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return (int)paramFloat;
  }
  
  private int cz(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return (int)paramFloat;
    }
    return 0;
  }
  
  private int d(int paramInt, RecyclerView.n paramn)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    Jo();
    float f = paramInt / fXq();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.AOV + f;
    int i;
    if ((!this.bXw) && (f < fXx())) {
      i = (int)(paramInt - (f - fXx()) * fXq());
    }
    for (;;)
    {
      this.AOV = (i / fXq() + this.AOV);
      c(paramn);
      return i;
      i = paramInt;
      if (!this.bXw)
      {
        i = paramInt;
        if (f > fXw()) {
          i = (int)((fXw() - this.AOV) * fXq());
        }
      }
    }
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
        View localView = paramn.gb(paramInt);
        return localView;
      }
      catch (Exception localException)
      {
        paramInt += 1;
      }
    }
  }
  
  private int fXA()
  {
    if (this.KvI == 0.0F) {
      return 0;
    }
    return Math.round(this.AOV / this.KvI);
  }
  
  private float fXB()
  {
    if (this.bXB)
    {
      if (this.bXw)
      {
        if (this.AOV <= 0.0F) {
          return this.AOV % (this.KvI * getItemCount());
        }
        return getItemCount() * -this.KvI + this.AOV % (this.KvI * getItemCount());
      }
      return this.AOV;
    }
    if (this.bXw)
    {
      if (this.AOV >= 0.0F) {
        return this.AOV % (this.KvI * getItemCount());
      }
      return getItemCount() * this.KvI + this.AOV % (this.KvI * getItemCount());
    }
    return this.AOV;
  }
  
  private int fXs()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.bXD)
    {
      if (!this.bXB) {
        return getCurrentPosition();
      }
      return getItemCount() - getCurrentPosition() - 1;
    }
    float f = fXB();
    if (!this.bXB) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.KvI);
  }
  
  private int fXt()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.bXD) {
      return 1;
    }
    return (int)this.KvI;
  }
  
  private int fXu()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.bXD) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.KvI);
  }
  
  private boolean fXv()
  {
    return this.KvM != -1;
  }
  
  private float fXw()
  {
    if (!this.bXB) {
      return (getItemCount() - 1) * this.KvI;
    }
    return 0.0F;
  }
  
  private float fXx()
  {
    if (!this.bXB) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.KvI;
  }
  
  private float fXy()
  {
    return this.KvG.JG() - this.KvE;
  }
  
  private float fXz()
  {
    return -this.KvC - this.KvG.JE() - this.KvE;
  }
  
  private int getCurrentPosition()
  {
    int j;
    if (getItemCount() == 0)
    {
      j = 0;
      return j;
    }
    int i = fXA();
    if (!this.bXw) {
      return Math.abs(i);
    }
    if (!this.bXB) {
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
  
  private static void ia(View paramView)
  {
    paramView.setRotation(0.0F);
    paramView.setRotationY(0.0F);
    paramView.setRotationX(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setAlpha(1.0F);
  }
  
  private void x(View paramView, float paramFloat)
  {
    int i = cy(paramFloat);
    int j = cz(paramFloat);
    int k;
    int m;
    int n;
    if (this.mOrientation == 1)
    {
      k = this.KvF;
      m = this.KvE;
      n = this.KvF;
      layoutDecorated(paramView, k + i, m + j, this.KvD + (i + n), this.KvE + j + this.KvC);
    }
    for (;;)
    {
      w(paramView, paramFloat);
      return;
      k = this.KvE;
      m = this.KvF;
      n = this.KvE;
      layoutDecorated(paramView, k + i, m + j, this.KvC + (i + n), this.KvF + j + this.KvD);
    }
  }
  
  public final int EK(int paramInt)
  {
    if (this.bXw)
    {
      int i = fXA();
      if (!this.bXB) {
        paramInt -= fXA();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.KvI - this.AOV) * fXq());
        paramInt = -fXA() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.bXB) {}
    for (float f1 = this.KvI;; f1 = -this.KvI) {
      return (int)((f1 * f2 - this.AOV) * fXq());
    }
  }
  
  public final void Jo()
  {
    if (this.KvG == null) {
      this.KvG = b.b(this, this.mOrientation);
    }
  }
  
  public final void ZR(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (this.KvM == paramInt) {
      return;
    }
    this.KvM = paramInt;
    removeAllViews();
  }
  
  public final void ZT(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (this.KvO == paramInt) {
      return;
    }
    this.KvO = paramInt;
    removeAllViews();
  }
  
  public final void aZ(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.bXA) {
      return;
    }
    this.bXA = paramBoolean;
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
    return fXt();
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.s params)
  {
    return fXs();
  }
  
  public int computeHorizontalScrollRange(RecyclerView.s params)
  {
    return fXu();
  }
  
  public int computeVerticalScrollExtent(RecyclerView.s params)
  {
    return fXt();
  }
  
  public int computeVerticalScrollOffset(RecyclerView.s params)
  {
    return fXs();
  }
  
  public int computeVerticalScrollRange(RecyclerView.s params)
  {
    return fXu();
  }
  
  protected abstract float fXp();
  
  protected float fXq()
  {
    return 1.0F;
  }
  
  protected void fXr() {}
  
  public View findViewByPosition(int paramInt)
  {
    int m = getItemCount();
    if (m == 0) {
      return null;
    }
    int i = 0;
    while (i < this.KvB.size())
    {
      int j = this.KvB.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.KvB.valueAt(i);
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
          return (View)this.KvB.valueAt(i);
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
  
  public void onAdapterChanged(RecyclerView.a parama1, RecyclerView.a parama2)
  {
    removeAllViews();
    this.AOV = 0.0F;
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
          if (this.bXB)
          {
            paramInt1 = 0;
            label51:
            if (paramInt1 == -1) {
              break label171;
            }
            if (paramInt1 != 1) {
              break label173;
            }
          }
        }
      }
      label171:
      label173:
      for (paramInt1 = i - 1;; paramInt1 = i + 1)
      {
        paramInt1 = EK(paramInt1);
        if (this.mOrientation != 1) {
          break label181;
        }
        paramRecyclerView.br(0, paramInt1);
        return true;
        paramInt1 = 1;
        break label51;
        if (paramInt1 == 130)
        {
          if (this.bXB)
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
          if (this.bXB)
          {
            paramInt1 = 0;
            break label51;
          }
          paramInt1 = 1;
          break label51;
        }
        if (paramInt1 == 66)
        {
          if (this.bXB)
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
      label181:
      paramRecyclerView.br(paramInt1, 0);
      return true;
    }
    localView.addFocusables(paramArrayList, paramInt1, paramInt2);
    return true;
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (this.bXG)
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
      this.AOV = 0.0F;
      return;
    }
    Jo();
    boolean bool;
    if ((this.mOrientation == 1) || (!Ja())) {
      bool = this.bXA;
    }
    for (;;)
    {
      this.bXB = bool;
      params = d(paramn, params, 0);
      if (params != null) {
        break;
      }
      removeAndRecycleAllViews(paramn);
      this.AOV = 0.0F;
      return;
      if (!this.bXA) {
        bool = true;
      } else {
        bool = false;
      }
    }
    measureChildWithMargins(params, 0, 0);
    this.KvC = this.KvG.bw(params);
    this.KvD = this.KvG.bx(params);
    this.KvE = ((this.KvG.JG() - this.KvC) / 2);
    if (this.KvO == 2147483647)
    {
      this.KvF = ((this.KvG.fXo() - this.KvD) / 2);
      this.KvI = fXp();
      fXr();
      if (this.KvI != 0.0F) {
        break label299;
      }
      this.KvK = 1;
      this.KvL = 1;
      label197:
      if (this.KvH != null)
      {
        this.bXB = this.KvH.KvQ;
        this.bXE = this.KvH.position;
        this.AOV = this.KvH.offset;
      }
      if (this.bXE != -1) {
        if (!this.bXB) {
          break label340;
        }
      }
    }
    label299:
    label340:
    for (float f = this.bXE * -this.KvI;; f = this.bXE * this.KvI)
    {
      this.AOV = f;
      c(paramn);
      return;
      this.KvF = (this.KvG.fXo() - this.KvD - this.KvO);
      break;
      this.KvK = ((int)Math.abs(fXz() / this.KvI) + 1);
      this.KvL = ((int)Math.abs(fXy() / this.KvI) + 1);
      break label197;
    }
  }
  
  public void onLayoutCompleted(RecyclerView.s params)
  {
    super.onLayoutCompleted(params);
    this.KvH = null;
    this.bXE = -1;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.KvH = new SavedState((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.KvH != null) {
      return new SavedState(this.KvH);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.position = this.bXE;
    localSavedState.offset = this.AOV;
    localSavedState.KvQ = this.bXB;
    return localSavedState;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return d(paramInt, paramn);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((!this.bXw) && ((paramInt < 0) || (paramInt >= getItemCount()))) {
      return;
    }
    this.bXE = paramInt;
    if (this.bXB) {}
    for (float f = paramInt * -this.KvI;; f = paramInt * this.KvI)
    {
      this.AOV = f;
      requestLayout();
      return;
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return d(paramInt, paramn);
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
    this.KvG = null;
    this.KvO = 2147483647;
    removeAllViews();
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    int i;
    int j;
    int k;
    if (this.bXw)
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
    for (paramInt = EK(paramInt);; paramInt = EK(paramInt))
    {
      if (this.mOrientation != 1) {
        break label130;
      }
      paramRecyclerView.a(0, paramInt, this.KvN);
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
    paramRecyclerView.a(paramInt, 0, this.KvN);
  }
  
  protected abstract void w(View paramView, float paramFloat);
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean KvQ;
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
        this.KvQ = bool;
        AppMethodBeat.o(65341);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.position = paramSavedState.position;
      this.offset = paramSavedState.offset;
      this.KvQ = paramSavedState.KvQ;
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
      if (this.KvQ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(65342);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
 * JD-Core Version:    0.7.0.1
 */