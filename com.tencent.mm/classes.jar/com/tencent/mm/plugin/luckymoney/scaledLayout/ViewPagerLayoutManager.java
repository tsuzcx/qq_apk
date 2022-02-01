package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class ViewPagerLayoutManager
  extends LinearLayoutManager
{
  private boolean apS = false;
  private boolean aqi = false;
  private boolean aqj = false;
  private boolean aql = true;
  private int aqm = -1;
  private boolean aqo;
  public int mOrientation;
  int vDA = 2147483647;
  private View vDB;
  private SparseArray<View> vDm = new SparseArray();
  protected int vDn;
  protected int vDo;
  protected int vDp;
  protected int vDq;
  protected float vDr;
  protected b vDs;
  private SavedState vDt = null;
  protected float vDu;
  private boolean vDv;
  private int vDw;
  private int vDx;
  int vDy = -1;
  private Interpolator vDz;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    ap(paramBoolean);
    this.atn = true;
    aw(false);
  }
  
  private float JJ(int paramInt)
  {
    if (this.aqj) {
      return paramInt * -this.vDu;
    }
    return paramInt * this.vDu;
  }
  
  private int b(int paramInt, RecyclerView.o paramo)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    kf();
    float f = paramInt / dlt();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.vDr + f;
    int i;
    if ((!this.apS) && (f < dlA())) {
      i = (int)(paramInt - (f - dlA()) * dlt());
    }
    for (;;)
    {
      this.vDr = (i / dlt() + this.vDr);
      e(paramo);
      return i;
      i = paramInt;
      if (!this.apS)
      {
        i = paramInt;
        if (f > dlz()) {
          i = (int)((dlz() - this.vDr) * dlt());
        }
      }
    }
  }
  
  private boolean bh(float paramFloat)
  {
    return (paramFloat > dlB()) || (paramFloat < dlC());
  }
  
  private int bi(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return (int)paramFloat;
  }
  
  private int bj(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return (int)paramFloat;
    }
    return 0;
  }
  
  private static View d(RecyclerView.o paramo, RecyclerView.t paramt, int paramInt)
  {
    for (;;)
    {
      if ((paramInt >= paramt.getItemCount()) || (paramInt < 0)) {
        return null;
      }
      try
      {
        View localView = paramo.cu(paramInt);
        return localView;
      }
      catch (Exception localException)
      {
        paramInt += 1;
      }
    }
  }
  
  private float dlA()
  {
    if (!this.aqj) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.vDu;
  }
  
  private float dlB()
  {
    return this.vDs.kD() - this.vDp;
  }
  
  private float dlC()
  {
    return -this.vDn - this.vDs.kB() - this.vDp;
  }
  
  private int dlD()
  {
    if (this.vDu == 0.0F) {
      return 0;
    }
    return Math.round(this.vDr / this.vDu);
  }
  
  private float dlE()
  {
    if (this.aqj)
    {
      if (this.apS)
      {
        if (this.vDr <= 0.0F) {
          return this.vDr % (this.vDu * getItemCount());
        }
        return getItemCount() * -this.vDu + this.vDr % (this.vDu * getItemCount());
      }
      return this.vDr;
    }
    if (this.apS)
    {
      if (this.vDr >= 0.0F) {
        return this.vDr % (this.vDu * getItemCount());
      }
      return getItemCount() * this.vDu + this.vDr % (this.vDu * getItemCount());
    }
    return this.vDr;
  }
  
  private int dlv()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aql)
    {
      if (!this.aqj) {
        return getCurrentPosition();
      }
      return getItemCount() - getCurrentPosition() - 1;
    }
    float f = dlE();
    if (!this.aqj) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.vDu);
  }
  
  private int dlw()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aql) {
      return 1;
    }
    return (int)this.vDu;
  }
  
  private int dlx()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aql) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.vDu);
  }
  
  private boolean dly()
  {
    return this.vDy != -1;
  }
  
  private float dlz()
  {
    if (!this.aqj) {
      return (getItemCount() - 1) * this.vDu;
    }
    return 0.0F;
  }
  
  private void e(RecyclerView.o paramo)
  {
    b(paramo);
    this.vDm.clear();
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
    if (this.aqj)
    {
      i3 = -dlD();
      j = i3 - this.vDw;
      i = this.vDx + i3;
      if (dly())
      {
        if (this.vDy % 2 != 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label333;
        }
        i = this.vDy / 2;
        j = i3 - i + 1;
        i = i + i3 + 1;
      }
      m = i;
      i1 = j;
      if (!this.apS)
      {
        n = i;
        k = j;
        if (j < 0)
        {
          if (!dly()) {
            break label436;
          }
          n = this.vDy;
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
        if ((!dly()) && (bh(JJ(i) - this.vDr))) {
          break label424;
        }
        if (i >= i2) {
          j = i % i2;
        }
      }
      for (;;)
      {
        label226:
        View localView = paramo.cu(j);
        bD(localView);
        er(localView);
        r(localView, JJ(i) - this.vDr);
        float f2;
        if (this.vDv)
        {
          f2 = 0.0F;
          label271:
          if (f2 <= f1) {
            break label405;
          }
          addView(localView);
          label283:
          if (i == i3) {
            this.vDB = localView;
          }
          this.vDm.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = dlD();
          break;
          label327:
          i = 0;
          break label75;
          label333:
          i = (this.vDy - 1) / 2;
          j = i3 - i;
          i = i + i3 + 1;
          break label106;
          if (i >= 0) {
            break label429;
          }
          k = -i % i2;
          j = k;
          if (k == 0) {
            j = i2;
          }
          j = i2 - j;
          break label226;
          f2 = j;
          break label271;
          label405:
          addView(localView, 0);
          break label283;
          this.vDB.requestFocus();
          return;
          label424:
          f2 = f1;
        }
        label429:
        j = i;
      }
      label436:
      k = 0;
      n = i;
    }
  }
  
  private static void er(View paramView)
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
    int i = dlD();
    if (!this.apS) {
      return Math.abs(i);
    }
    if (!this.aqj) {
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
  
  private void r(View paramView, float paramFloat)
  {
    int i = bi(paramFloat);
    int j = bj(paramFloat);
    if (this.mOrientation == 1) {
      j(paramView, this.vDq + i, this.vDp + j, i + this.vDq + this.vDo, j + this.vDp + this.vDn);
    }
    for (;;)
    {
      q(paramView, paramFloat);
      return;
      j(paramView, this.vDp + i, this.vDq + j, i + this.vDp + this.vDn, j + this.vDq + this.vDo);
    }
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return b(paramInt, paramo);
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    return null;
  }
  
  public final void a(RecyclerView.t paramt)
  {
    super.a(paramt);
    this.vDt = null;
    this.aqm = -1;
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.aqo)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    int i;
    int j;
    int k;
    if (this.apS)
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
    for (paramInt = wW(paramInt);; paramInt = wW(paramInt))
    {
      if (this.mOrientation != 1) {
        break label130;
      }
      paramRecyclerView.a(0, paramInt, this.vDz);
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
    paramRecyclerView.a(paramInt, 0, this.vDz);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = getCurrentPosition();
    View localView = bY(i);
    if (localView == null) {
      return true;
    }
    if (paramRecyclerView.hasFocus())
    {
      if (this.mOrientation == 1) {
        if (paramInt1 == 33) {
          if (this.aqj)
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
        paramInt1 = wW(paramInt1);
        if (this.mOrientation != 1) {
          break label182;
        }
        paramRecyclerView.a(0, paramInt1, null);
        return true;
        paramInt1 = 1;
        break label51;
        if (paramInt1 == 130)
        {
          if (this.aqj)
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
          if (this.aqj)
          {
            paramInt1 = 0;
            break label51;
          }
          paramInt1 = 1;
          break label51;
        }
        if (paramInt1 == 66)
        {
          if (this.aqj)
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
  
  public final void ap(boolean paramBoolean)
  {
    F(null);
    if (paramBoolean == this.aqi) {
      return;
    }
    this.aqi = paramBoolean;
    removeAllViews();
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return b(paramInt, paramo);
  }
  
  public final View bY(int paramInt)
  {
    int m = getItemCount();
    if (m == 0) {
      return null;
    }
    int i = 0;
    while (i < this.vDm.size())
    {
      int j = this.vDm.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.vDm.valueAt(i);
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
          return (View)this.vDm.valueAt(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    if (paramt.getItemCount() == 0)
    {
      d(paramo);
      this.vDr = 0.0F;
      return;
    }
    kf();
    boolean bool;
    if ((this.mOrientation == 1) || (!jy())) {
      bool = this.aqi;
    }
    for (;;)
    {
      this.aqj = bool;
      paramt = d(paramo, paramt, 0);
      if (paramt != null) {
        break;
      }
      d(paramo);
      this.vDr = 0.0F;
      return;
      if (!this.aqi) {
        bool = true;
      } else {
        bool = false;
      }
    }
    bD(paramt);
    this.vDn = this.vDs.br(paramt);
    this.vDo = this.vDs.bs(paramt);
    this.vDp = ((this.vDs.kD() - this.vDn) / 2);
    if (this.vDA == 2147483647)
    {
      this.vDq = ((this.vDs.dlr() - this.vDo) / 2);
      this.vDu = dls();
      dlu();
      if (this.vDu != 0.0F) {
        break label297;
      }
      this.vDw = 1;
      this.vDx = 1;
      label195:
      if (this.vDt != null)
      {
        this.aqj = this.vDt.vDC;
        this.aqm = this.vDt.position;
        this.vDr = this.vDt.offset;
      }
      if (this.aqm != -1) {
        if (!this.aqj) {
          break label338;
        }
      }
    }
    label297:
    label338:
    for (float f = this.aqm * -this.vDu;; f = this.aqm * this.vDu)
    {
      this.vDr = f;
      e(paramo);
      return;
      this.vDq = (this.vDs.dlr() - this.vDo - this.vDA);
      break;
      this.vDw = ((int)Math.abs(dlC() / this.vDu) + 1);
      this.vDx = ((int)Math.abs(dlB() / this.vDu) + 1);
      break label195;
    }
  }
  
  public final void ca(int paramInt)
  {
    if ((!this.apS) && ((paramInt < 0) || (paramInt >= getItemCount()))) {
      return;
    }
    this.aqm = paramInt;
    if (this.aqj) {}
    for (float f = paramInt * -this.vDu;; f = paramInt * this.vDu)
    {
      this.vDr = f;
      requestLayout();
      return;
    }
  }
  
  public final int d(RecyclerView.t paramt)
  {
    return dlv();
  }
  
  protected abstract float dls();
  
  protected float dlt()
  {
    return 1.0F;
  }
  
  protected void dlu() {}
  
  public final int e(RecyclerView.t paramt)
  {
    return dlv();
  }
  
  public final int f(RecyclerView.t paramt)
  {
    return dlw();
  }
  
  public final int g(RecyclerView.t paramt)
  {
    return dlw();
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int h(RecyclerView.t paramt)
  {
    return dlx();
  }
  
  public final int i(RecyclerView.t paramt)
  {
    return dlx();
  }
  
  public final RecyclerView.LayoutParams jW()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final boolean kc()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean kd()
  {
    return this.mOrientation == 1;
  }
  
  public final void kf()
  {
    if (this.vDs == null) {
      this.vDs = b.b(this, this.mOrientation);
    }
  }
  
  public final void ly()
  {
    removeAllViews();
    this.vDr = 0.0F;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.vDt = new SavedState((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.vDt != null) {
      return new SavedState(this.vDt);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.position = this.aqm;
    localSavedState.offset = this.vDr;
    localSavedState.vDC = this.aqj;
    return localSavedState;
  }
  
  protected abstract void q(View paramView, float paramFloat);
  
  public final void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    F(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.vDs = null;
    this.vDA = 2147483647;
    removeAllViews();
  }
  
  public final int wW(int paramInt)
  {
    if (this.apS)
    {
      int i = dlD();
      if (!this.aqj) {
        paramInt -= dlD();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.vDu - this.vDr) * dlt());
        paramInt = -dlD() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.aqj) {}
    for (float f1 = this.vDu;; f1 = -this.vDu) {
      return (int)((f1 * f2 - this.vDr) * dlt());
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    float offset;
    int position;
    boolean vDC;
    
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
        this.vDC = bool;
        AppMethodBeat.o(65341);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.position = paramSavedState.position;
      this.offset = paramSavedState.offset;
      this.vDC = paramSavedState.vDC;
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
      if (this.vDC) {}
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