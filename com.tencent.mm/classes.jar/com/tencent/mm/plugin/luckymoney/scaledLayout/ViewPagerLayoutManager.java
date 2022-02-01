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
  private SparseArray<View> vrh = new SparseArray();
  protected int vri;
  protected int vrj;
  protected int vrk;
  protected int vrl;
  protected float vrm;
  protected b vrn;
  private SavedState vro = null;
  protected float vrp;
  private boolean vrq;
  private int vrr;
  private int vrs;
  int vrt = -1;
  private Interpolator vru;
  int vrv = 2147483647;
  private View vrw;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    ap(paramBoolean);
    this.atn = true;
    aw(false);
  }
  
  private float Jk(int paramInt)
  {
    if (this.aqj) {
      return paramInt * -this.vrp;
    }
    return paramInt * this.vrp;
  }
  
  private int b(int paramInt, RecyclerView.o paramo)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    kf();
    float f = paramInt / diu();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.vrm + f;
    int i;
    if ((!this.apS) && (f < diB())) {
      i = (int)(paramInt - (f - diB()) * diu());
    }
    for (;;)
    {
      this.vrm = (i / diu() + this.vrm);
      e(paramo);
      return i;
      i = paramInt;
      if (!this.apS)
      {
        i = paramInt;
        if (f > diA()) {
          i = (int)((diA() - this.vrm) * diu());
        }
      }
    }
  }
  
  private boolean bh(float paramFloat)
  {
    return (paramFloat > diC()) || (paramFloat < diD());
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
  
  private float diA()
  {
    if (!this.aqj) {
      return (getItemCount() - 1) * this.vrp;
    }
    return 0.0F;
  }
  
  private float diB()
  {
    if (!this.aqj) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.vrp;
  }
  
  private float diC()
  {
    return this.vrn.kD() - this.vrk;
  }
  
  private float diD()
  {
    return -this.vri - this.vrn.kB() - this.vrk;
  }
  
  private int diE()
  {
    if (this.vrp == 0.0F) {
      return 0;
    }
    return Math.round(this.vrm / this.vrp);
  }
  
  private float diF()
  {
    if (this.aqj)
    {
      if (this.apS)
      {
        if (this.vrm <= 0.0F) {
          return this.vrm % (this.vrp * getItemCount());
        }
        return getItemCount() * -this.vrp + this.vrm % (this.vrp * getItemCount());
      }
      return this.vrm;
    }
    if (this.apS)
    {
      if (this.vrm >= 0.0F) {
        return this.vrm % (this.vrp * getItemCount());
      }
      return getItemCount() * this.vrp + this.vrm % (this.vrp * getItemCount());
    }
    return this.vrm;
  }
  
  private int diw()
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
    float f = diF();
    if (!this.aqj) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.vrp);
  }
  
  private int dix()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aql) {
      return 1;
    }
    return (int)this.vrp;
  }
  
  private int diy()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aql) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.vrp);
  }
  
  private boolean diz()
  {
    return this.vrt != -1;
  }
  
  private void e(RecyclerView.o paramo)
  {
    b(paramo);
    this.vrh.clear();
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
      i3 = -diE();
      j = i3 - this.vrr;
      i = this.vrs + i3;
      if (diz())
      {
        if (this.vrt % 2 != 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label333;
        }
        i = this.vrt / 2;
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
          if (!diz()) {
            break label436;
          }
          n = this.vrt;
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
        if ((!diz()) && (bh(Jk(i) - this.vrm))) {
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
        r(localView, Jk(i) - this.vrm);
        float f2;
        if (this.vrq)
        {
          f2 = 0.0F;
          label271:
          if (f2 <= f1) {
            break label405;
          }
          addView(localView);
          label283:
          if (i == i3) {
            this.vrw = localView;
          }
          this.vrh.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = diE();
          break;
          label327:
          i = 0;
          break label75;
          label333:
          i = (this.vrt - 1) / 2;
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
          this.vrw.requestFocus();
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
    int i = diE();
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
      j(paramView, this.vrl + i, this.vrk + j, i + this.vrl + this.vrj, j + this.vrk + this.vri);
    }
    for (;;)
    {
      q(paramView, paramFloat);
      return;
      j(paramView, this.vrk + i, this.vrl + j, i + this.vrk + this.vri, j + this.vrl + this.vrj);
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
    this.vro = null;
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
    for (paramInt = wR(paramInt);; paramInt = wR(paramInt))
    {
      if (this.mOrientation != 1) {
        break label130;
      }
      paramRecyclerView.a(0, paramInt, this.vru);
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
    paramRecyclerView.a(paramInt, 0, this.vru);
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
        paramInt1 = wR(paramInt1);
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
    while (i < this.vrh.size())
    {
      int j = this.vrh.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.vrh.valueAt(i);
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
          return (View)this.vrh.valueAt(i);
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
      this.vrm = 0.0F;
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
      this.vrm = 0.0F;
      return;
      if (!this.aqi) {
        bool = true;
      } else {
        bool = false;
      }
    }
    bD(paramt);
    this.vri = this.vrn.br(paramt);
    this.vrj = this.vrn.bs(paramt);
    this.vrk = ((this.vrn.kD() - this.vri) / 2);
    if (this.vrv == 2147483647)
    {
      this.vrl = ((this.vrn.dis() - this.vrj) / 2);
      this.vrp = dit();
      div();
      if (this.vrp != 0.0F) {
        break label297;
      }
      this.vrr = 1;
      this.vrs = 1;
      label195:
      if (this.vro != null)
      {
        this.aqj = this.vro.vrx;
        this.aqm = this.vro.position;
        this.vrm = this.vro.offset;
      }
      if (this.aqm != -1) {
        if (!this.aqj) {
          break label338;
        }
      }
    }
    label297:
    label338:
    for (float f = this.aqm * -this.vrp;; f = this.aqm * this.vrp)
    {
      this.vrm = f;
      e(paramo);
      return;
      this.vrl = (this.vrn.dis() - this.vrj - this.vrv);
      break;
      this.vrr = ((int)Math.abs(diD() / this.vrp) + 1);
      this.vrs = ((int)Math.abs(diC() / this.vrp) + 1);
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
    for (float f = paramInt * -this.vrp;; f = paramInt * this.vrp)
    {
      this.vrm = f;
      requestLayout();
      return;
    }
  }
  
  public final int d(RecyclerView.t paramt)
  {
    return diw();
  }
  
  protected abstract float dit();
  
  protected float diu()
  {
    return 1.0F;
  }
  
  protected void div() {}
  
  public final int e(RecyclerView.t paramt)
  {
    return diw();
  }
  
  public final int f(RecyclerView.t paramt)
  {
    return dix();
  }
  
  public final int g(RecyclerView.t paramt)
  {
    return dix();
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int h(RecyclerView.t paramt)
  {
    return diy();
  }
  
  public final int i(RecyclerView.t paramt)
  {
    return diy();
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
    if (this.vrn == null) {
      this.vrn = b.b(this, this.mOrientation);
    }
  }
  
  public final void ly()
  {
    removeAllViews();
    this.vrm = 0.0F;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.vro = new SavedState((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.vro != null) {
      return new SavedState(this.vro);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.position = this.aqm;
    localSavedState.offset = this.vrm;
    localSavedState.vrx = this.aqj;
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
    this.vrn = null;
    this.vrv = 2147483647;
    removeAllViews();
  }
  
  public final int wR(int paramInt)
  {
    if (this.apS)
    {
      int i = diE();
      if (!this.aqj) {
        paramInt -= diE();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.vrp - this.vrm) * diu());
        paramInt = -diE() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.aqj) {}
    for (float f1 = this.vrp;; f1 = -this.vrp) {
      return (int)((f1 * f2 - this.vrm) * diu());
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    float offset;
    int position;
    boolean vrx;
    
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
        this.vrx = bool;
        AppMethodBeat.o(65341);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.position = paramSavedState.position;
      this.offset = paramSavedState.offset;
      this.vrx = paramSavedState.vrx;
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
      if (this.vrx) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(65342);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
 * JD-Core Version:    0.7.0.1
 */