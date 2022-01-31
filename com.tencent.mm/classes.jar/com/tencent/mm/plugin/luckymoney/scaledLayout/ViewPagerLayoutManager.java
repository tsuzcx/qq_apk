package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class ViewPagerLayoutManager
  extends LinearLayoutManager
{
  private boolean afY = false;
  private boolean ago = false;
  private boolean agp = false;
  private boolean agr = true;
  private int ags = -1;
  private boolean agu;
  public int mOrientation;
  public SparseArray<View> oqk = new SparseArray();
  protected int oql;
  protected int oqm;
  protected int oqn;
  protected int oqo;
  protected float oqp;
  protected b oqq;
  private ViewPagerLayoutManager.SavedState oqr = null;
  protected float oqs;
  private boolean oqt;
  private int oqu;
  private int oqv;
  int oqw = -1;
  private Interpolator oqx;
  int oqy = 2147483647;
  private View oqz;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    ai(paramBoolean);
    this.ajq = true;
    ao(false);
  }
  
  private boolean aM(float paramFloat)
  {
    return (paramFloat > bNC()) || (paramFloat < bND());
  }
  
  private int aN(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return (int)paramFloat;
  }
  
  private int aO(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return (int)paramFloat;
    }
    return 0;
  }
  
  private int b(int paramInt, RecyclerView.o paramo)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    im();
    float f = paramInt / bNu();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.oqp + f;
    int i;
    if ((!this.afY) && (f < bNB())) {
      i = (int)(paramInt - (f - bNB()) * bNu());
    }
    for (;;)
    {
      this.oqp = (i / bNu() + this.oqp);
      e(paramo);
      return i;
      i = paramInt;
      if (!this.afY)
      {
        i = paramInt;
        if (f > bNA()) {
          i = (int)((bNA() - this.oqp) * bNu());
        }
      }
    }
  }
  
  private float bNA()
  {
    if (!this.agp) {
      return (getItemCount() - 1) * this.oqs;
    }
    return 0.0F;
  }
  
  private float bNB()
  {
    if (!this.agp) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.oqs;
  }
  
  private float bNC()
  {
    return this.oqq.iK() - this.oqn;
  }
  
  private float bND()
  {
    return -this.oql - this.oqq.iI() - this.oqn;
  }
  
  private int bNE()
  {
    if (this.oqs == 0.0F) {
      return 0;
    }
    return Math.round(this.oqp / this.oqs);
  }
  
  private float bNF()
  {
    if (this.agp)
    {
      if (this.afY)
      {
        if (this.oqp <= 0.0F) {
          return this.oqp % (this.oqs * getItemCount());
        }
        return getItemCount() * -this.oqs + this.oqp % (this.oqs * getItemCount());
      }
      return this.oqp;
    }
    if (this.afY)
    {
      if (this.oqp >= 0.0F) {
        return this.oqp % (this.oqs * getItemCount());
      }
      return getItemCount() * this.oqs + this.oqp % (this.oqs * getItemCount());
    }
    return this.oqp;
  }
  
  private int bNw()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.agr)
    {
      if (!this.agp) {
        return getCurrentPosition();
      }
      return getItemCount() - getCurrentPosition() - 1;
    }
    float f = bNF();
    if (!this.agp) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.oqs);
  }
  
  private int bNx()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.agr) {
      return 1;
    }
    return (int)this.oqs;
  }
  
  private int bNy()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.agr) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.oqs);
  }
  
  private boolean bNz()
  {
    return this.oqw != -1;
  }
  
  private static View d(RecyclerView.o paramo, RecyclerView.s params, int paramInt)
  {
    for (;;)
    {
      if ((paramInt >= params.getItemCount()) || (paramInt < 0)) {
        return null;
      }
      try
      {
        View localView = paramo.cb(paramInt);
        return localView;
      }
      catch (Exception localException)
      {
        paramInt += 1;
      }
    }
  }
  
  private static void ds(View paramView)
  {
    paramView.setRotation(0.0F);
    paramView.setRotationY(0.0F);
    paramView.setRotationX(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setAlpha(1.0F);
  }
  
  private void e(RecyclerView.o paramo)
  {
    b(paramo);
    this.oqk.clear();
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
    if (this.agp)
    {
      i3 = -bNE();
      j = i3 - this.oqu;
      i = this.oqv + i3;
      if (bNz())
      {
        if (this.oqw % 2 != 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label333;
        }
        i = this.oqw / 2;
        j = i3 - i + 1;
        i = i + i3 + 1;
      }
      m = i;
      i1 = j;
      if (!this.afY)
      {
        n = i;
        k = j;
        if (j < 0)
        {
          if (!bNz()) {
            break label436;
          }
          n = this.oqw;
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
        if ((!bNz()) && (aM(yq(i) - this.oqp))) {
          break label424;
        }
        if (i >= i2) {
          j = i % i2;
        }
      }
      for (;;)
      {
        label226:
        View localView = paramo.cb(j);
        bw(localView);
        ds(localView);
        o(localView, yq(i) - this.oqp);
        float f2;
        if (this.oqt)
        {
          f2 = 0.0F;
          label271:
          if (f2 <= f1) {
            break label405;
          }
          addView(localView);
          label283:
          if (i == i3) {
            this.oqz = localView;
          }
          this.oqk.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = bNE();
          break;
          label327:
          i = 0;
          break label75;
          label333:
          i = (this.oqw - 1) / 2;
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
          this.oqz.requestFocus();
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
  
  private int getCurrentPosition()
  {
    int j;
    if (getItemCount() == 0)
    {
      j = 0;
      return j;
    }
    int i = bNE();
    if (!this.afY) {
      return Math.abs(i);
    }
    if (!this.agp) {
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
  
  private void o(View paramView, float paramFloat)
  {
    int i = aN(paramFloat);
    int j = aO(paramFloat);
    if (this.mOrientation == 1) {
      j(paramView, this.oqo + i, this.oqn + j, i + this.oqo + this.oqm, j + this.oqn + this.oql);
    }
    for (;;)
    {
      n(paramView, paramFloat);
      return;
      j(paramView, this.oqn + i, this.oqo + j, i + this.oqn + this.oql, j + this.oqo + this.oqm);
    }
  }
  
  private float yq(int paramInt)
  {
    if (this.agp) {
      return paramInt * -this.oqs;
    }
    return paramInt * this.oqs;
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return b(paramInt, paramo);
  }
  
  public final View a(View paramView, int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    return null;
  }
  
  public final void a(RecyclerView.s params)
  {
    super.a(params);
    this.oqr = null;
    this.ags = -1;
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    int i;
    int j;
    int k;
    if (this.afY)
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
    for (paramInt = qR(paramInt);; paramInt = qR(paramInt))
    {
      if (this.mOrientation != 1) {
        break label120;
      }
      paramRecyclerView.a(0, paramInt, this.oqx);
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
    label120:
    paramRecyclerView.a(paramInt, 0, this.oqx);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.agu)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public final boolean a(RecyclerView paramRecyclerView, ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = getCurrentPosition();
    View localView = bH(j);
    if (localView == null) {
      return true;
    }
    if (paramRecyclerView.hasFocus())
    {
      if (this.mOrientation == 1) {
        if (paramInt1 == 33) {
          if (this.agp)
          {
            paramInt1 = i;
            label55:
            if (paramInt1 == -1) {
              break label155;
            }
            if (paramInt1 != 1) {
              break label157;
            }
          }
        }
      }
      label155:
      label157:
      for (paramInt1 = j - 1;; paramInt1 = j + 1)
      {
        d.a(paramRecyclerView, this, paramInt1);
        return true;
        paramInt1 = 1;
        break label55;
        if (paramInt1 == 130)
        {
          paramInt1 = i;
          if (!this.agp) {
            break label55;
          }
          paramInt1 = 1;
          break label55;
        }
        paramInt1 = -1;
        break label55;
        if (paramInt1 == 17)
        {
          paramInt1 = i;
          if (this.agp) {
            break label55;
          }
          paramInt1 = 1;
          break label55;
        }
        if (paramInt1 == 66)
        {
          paramInt1 = i;
          if (!this.agp) {
            break label55;
          }
          paramInt1 = 1;
          break label55;
        }
        paramInt1 = -1;
        break label55;
        break;
      }
    }
    localView.addFocusables(paramArrayList, paramInt1, paramInt2);
    return true;
  }
  
  public final void ai(boolean paramBoolean)
  {
    S(null);
    if (paramBoolean == this.ago) {
      return;
    }
    this.ago = paramBoolean;
    removeAllViews();
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return b(paramInt, paramo);
  }
  
  public final View bH(int paramInt)
  {
    int m = getItemCount();
    if (m == 0) {
      return null;
    }
    int i = 0;
    while (i < this.oqk.size())
    {
      int j = this.oqk.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.oqk.valueAt(i);
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
          return (View)this.oqk.valueAt(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final void bJ(int paramInt)
  {
    if ((!this.afY) && ((paramInt < 0) || (paramInt >= getItemCount()))) {
      return;
    }
    this.ags = paramInt;
    if (this.agp) {}
    for (float f = paramInt * -this.oqs;; f = paramInt * this.oqs)
    {
      this.oqp = f;
      requestLayout();
      return;
    }
  }
  
  protected abstract float bNt();
  
  protected float bNu()
  {
    return 1.0F;
  }
  
  protected void bNv() {}
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (params.getItemCount() == 0)
    {
      d(paramo);
      this.oqp = 0.0F;
      return;
    }
    im();
    boolean bool;
    if ((this.mOrientation == 1) || (!hE())) {
      bool = this.ago;
    }
    for (;;)
    {
      this.agp = bool;
      params = d(paramo, params, 0);
      if (params != null) {
        break;
      }
      d(paramo);
      this.oqp = 0.0F;
      return;
      if (!this.ago) {
        bool = true;
      } else {
        bool = false;
      }
    }
    bw(params);
    this.oql = this.oqq.bl(params);
    this.oqm = this.oqq.bm(params);
    this.oqn = ((this.oqq.iK() - this.oql) / 2);
    if (this.oqy == 2147483647)
    {
      this.oqo = ((this.oqq.bNs() - this.oqm) / 2);
      this.oqs = bNt();
      bNv();
      if (this.oqs != 0.0F) {
        break label297;
      }
      this.oqu = 1;
      this.oqv = 1;
      label195:
      if (this.oqr != null)
      {
        this.agp = this.oqr.oqA;
        this.ags = this.oqr.position;
        this.oqp = this.oqr.offset;
      }
      if (this.ags != -1) {
        if (!this.agp) {
          break label338;
        }
      }
    }
    label297:
    label338:
    for (float f = this.ags * -this.oqs;; f = this.ags * this.oqs)
    {
      this.oqp = f;
      e(paramo);
      return;
      this.oqo = (this.oqq.bNs() - this.oqm - this.oqy);
      break;
      this.oqu = ((int)Math.abs(bND() / this.oqs) + 1);
      this.oqv = ((int)Math.abs(bNC() / this.oqs) + 1);
      break label195;
    }
  }
  
  public final int d(RecyclerView.s params)
  {
    return bNw();
  }
  
  public final int e(RecyclerView.s params)
  {
    return bNw();
  }
  
  public final int f(RecyclerView.s params)
  {
    return bNx();
  }
  
  public final int g(RecyclerView.s params)
  {
    return bNx();
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int h(RecyclerView.s params)
  {
    return bNy();
  }
  
  public final int i(RecyclerView.s params)
  {
    return bNy();
  }
  
  public final RecyclerView.LayoutParams ic()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final boolean ij()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean ik()
  {
    return this.mOrientation == 1;
  }
  
  public final void im()
  {
    if (this.oqq == null) {
      this.oqq = b.a(this, this.mOrientation);
    }
  }
  
  public final void jA()
  {
    removeAllViews();
    this.oqp = 0.0F;
  }
  
  protected abstract void n(View paramView, float paramFloat);
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof ViewPagerLayoutManager.SavedState))
    {
      this.oqr = new ViewPagerLayoutManager.SavedState((ViewPagerLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.oqr != null) {
      return new ViewPagerLayoutManager.SavedState(this.oqr);
    }
    ViewPagerLayoutManager.SavedState localSavedState = new ViewPagerLayoutManager.SavedState();
    localSavedState.position = this.ags;
    localSavedState.offset = this.oqp;
    localSavedState.oqA = this.agp;
    return localSavedState;
  }
  
  public final int qR(int paramInt)
  {
    if (this.afY)
    {
      int i = bNE();
      if (!this.agp) {
        paramInt -= bNE();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.oqs - this.oqp) * bNu());
        paramInt = -bNE() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.agp) {}
    for (float f1 = this.oqs;; f1 = -this.oqs) {
      return (int)((f1 * f2 - this.oqp) * bNu());
    }
  }
  
  public final void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    S(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.oqq = null;
    this.oqy = 2147483647;
    removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager
 * JD-Core Version:    0.7.0.1
 */