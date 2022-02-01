package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.os.Parcel;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class ViewPagerLayoutManager
  extends LinearLayoutManager
{
  private boolean anB;
  private boolean anf = false;
  private boolean anv = false;
  private boolean anw = false;
  private boolean any = true;
  private int anz = -1;
  public int mOrientation;
  int tgA = -1;
  private Interpolator tgB;
  int tgC = 2147483647;
  private View tgD;
  private SparseArray<View> tgo = new SparseArray();
  protected int tgp;
  protected int tgq;
  protected int tgr;
  protected int tgs;
  protected float tgt;
  protected b tgu;
  private SavedState tgv = null;
  protected float tgw;
  private boolean tgx;
  private int tgy;
  private int tgz;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    ap(paramBoolean);
    this.aqA = true;
    aw(false);
  }
  
  private float FT(int paramInt)
  {
    if (this.anw) {
      return paramInt * -this.tgw;
    }
    return paramInt * this.tgw;
  }
  
  private boolean aX(float paramFloat)
  {
    return (paramFloat > cLK()) || (paramFloat < cLL());
  }
  
  private int aY(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return (int)paramFloat;
  }
  
  private int aZ(float paramFloat)
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
    jH();
    float f = paramInt / cLC();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.tgt + f;
    int i;
    if ((!this.anf) && (f < cLJ())) {
      i = (int)(paramInt - (f - cLJ()) * cLC());
    }
    for (;;)
    {
      this.tgt = (i / cLC() + this.tgt);
      e(paramo);
      return i;
      i = paramInt;
      if (!this.anf)
      {
        i = paramInt;
        if (f > cLI()) {
          i = (int)((cLI() - this.tgt) * cLC());
        }
      }
    }
  }
  
  private int cLE()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.any)
    {
      if (!this.anw) {
        return getCurrentPosition();
      }
      return getItemCount() - getCurrentPosition() - 1;
    }
    float f = cLN();
    if (!this.anw) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.tgw);
  }
  
  private int cLF()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.any) {
      return 1;
    }
    return (int)this.tgw;
  }
  
  private int cLG()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.any) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.tgw);
  }
  
  private boolean cLH()
  {
    return this.tgA != -1;
  }
  
  private float cLI()
  {
    if (!this.anw) {
      return (getItemCount() - 1) * this.tgw;
    }
    return 0.0F;
  }
  
  private float cLJ()
  {
    if (!this.anw) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.tgw;
  }
  
  private float cLK()
  {
    return this.tgu.kf() - this.tgr;
  }
  
  private float cLL()
  {
    return -this.tgp - this.tgu.kd() - this.tgr;
  }
  
  private int cLM()
  {
    if (this.tgw == 0.0F) {
      return 0;
    }
    return Math.round(this.tgt / this.tgw);
  }
  
  private float cLN()
  {
    if (this.anw)
    {
      if (this.anf)
      {
        if (this.tgt <= 0.0F) {
          return this.tgt % (this.tgw * getItemCount());
        }
        return getItemCount() * -this.tgw + this.tgt % (this.tgw * getItemCount());
      }
      return this.tgt;
    }
    if (this.anf)
    {
      if (this.tgt >= 0.0F) {
        return this.tgt % (this.tgw * getItemCount());
      }
      return getItemCount() * this.tgw + this.tgt % (this.tgw * getItemCount());
    }
    return this.tgt;
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
        View localView = paramo.cv(paramInt);
        return localView;
      }
      catch (Exception localException)
      {
        paramInt += 1;
      }
    }
  }
  
  private void e(RecyclerView.o paramo)
  {
    b(paramo);
    this.tgo.clear();
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
    if (this.anw)
    {
      i3 = -cLM();
      j = i3 - this.tgy;
      i = this.tgz + i3;
      if (cLH())
      {
        if (this.tgA % 2 != 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label333;
        }
        i = this.tgA / 2;
        j = i3 - i + 1;
        i = i + i3 + 1;
      }
      m = i;
      i1 = j;
      if (!this.anf)
      {
        n = i;
        k = j;
        if (j < 0)
        {
          if (!cLH()) {
            break label436;
          }
          n = this.tgA;
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
        if ((!cLH()) && (aX(FT(i) - this.tgt))) {
          break label424;
        }
        if (i >= i2) {
          j = i % i2;
        }
      }
      for (;;)
      {
        label226:
        View localView = paramo.cv(j);
        bD(localView);
        ea(localView);
        q(localView, FT(i) - this.tgt);
        float f2;
        if (this.tgx)
        {
          f2 = 0.0F;
          label271:
          if (f2 <= f1) {
            break label405;
          }
          addView(localView);
          label283:
          if (i == i3) {
            this.tgD = localView;
          }
          this.tgo.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = cLM();
          break;
          label327:
          i = 0;
          break label75;
          label333:
          i = (this.tgA - 1) / 2;
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
          this.tgD.requestFocus();
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
  
  private static void ea(View paramView)
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
    int i = cLM();
    if (!this.anf) {
      return Math.abs(i);
    }
    if (!this.anw) {
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
  
  private void q(View paramView, float paramFloat)
  {
    int i = aY(paramFloat);
    int j = aZ(paramFloat);
    if (this.mOrientation == 1) {
      j(paramView, this.tgs + i, this.tgr + j, i + this.tgs + this.tgq, j + this.tgr + this.tgp);
    }
    for (;;)
    {
      p(paramView, paramFloat);
      return;
      j(paramView, this.tgr + i, this.tgs + j, i + this.tgr + this.tgp, j + this.tgs + this.tgq);
    }
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
    this.tgv = null;
    this.anz = -1;
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.anB)
    {
      d(paramo);
      paramo.clear();
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    int i;
    int j;
    int k;
    if (this.anf)
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
    for (paramInt = vv(paramInt);; paramInt = vv(paramInt))
    {
      if (this.mOrientation != 1) {
        break label130;
      }
      paramRecyclerView.a(0, paramInt, this.tgB);
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
    paramRecyclerView.a(paramInt, 0, this.tgB);
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
          if (this.anw)
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
        paramInt1 = vv(paramInt1);
        if (this.mOrientation != 1) {
          break label182;
        }
        paramRecyclerView.a(0, paramInt1, null);
        return true;
        paramInt1 = 1;
        break label51;
        if (paramInt1 == 130)
        {
          if (this.anw)
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
          if (this.anw)
          {
            paramInt1 = 0;
            break label51;
          }
          paramInt1 = 1;
          break label51;
        }
        if (paramInt1 == 66)
        {
          if (this.anw)
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
    E(null);
    if (paramBoolean == this.anv) {
      return;
    }
    this.anv = paramBoolean;
    removeAllViews();
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
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
    while (i < this.tgo.size())
    {
      int j = this.tgo.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.tgo.valueAt(i);
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
          return (View)this.tgo.valueAt(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    if (params.getItemCount() == 0)
    {
      d(paramo);
      this.tgt = 0.0F;
      return;
    }
    jH();
    boolean bool;
    if ((this.mOrientation == 1) || (!ja())) {
      bool = this.anv;
    }
    for (;;)
    {
      this.anw = bool;
      params = d(paramo, params, 0);
      if (params != null) {
        break;
      }
      d(paramo);
      this.tgt = 0.0F;
      return;
      if (!this.anv) {
        bool = true;
      } else {
        bool = false;
      }
    }
    bD(params);
    this.tgp = this.tgu.br(params);
    this.tgq = this.tgu.bs(params);
    this.tgr = ((this.tgu.kf() - this.tgp) / 2);
    if (this.tgC == 2147483647)
    {
      this.tgs = ((this.tgu.cLA() - this.tgq) / 2);
      this.tgw = cLB();
      cLD();
      if (this.tgw != 0.0F) {
        break label297;
      }
      this.tgy = 1;
      this.tgz = 1;
      label195:
      if (this.tgv != null)
      {
        this.anw = this.tgv.tgE;
        this.anz = this.tgv.position;
        this.tgt = this.tgv.offset;
      }
      if (this.anz != -1) {
        if (!this.anw) {
          break label338;
        }
      }
    }
    label297:
    label338:
    for (float f = this.anz * -this.tgw;; f = this.anz * this.tgw)
    {
      this.tgt = f;
      e(paramo);
      return;
      this.tgs = (this.tgu.cLA() - this.tgq - this.tgC);
      break;
      this.tgy = ((int)Math.abs(cLL() / this.tgw) + 1);
      this.tgz = ((int)Math.abs(cLK() / this.tgw) + 1);
      break label195;
    }
  }
  
  protected abstract float cLB();
  
  protected float cLC()
  {
    return 1.0F;
  }
  
  protected void cLD() {}
  
  public final void ca(int paramInt)
  {
    if ((!this.anf) && ((paramInt < 0) || (paramInt >= getItemCount()))) {
      return;
    }
    this.anz = paramInt;
    if (this.anw) {}
    for (float f = paramInt * -this.tgw;; f = paramInt * this.tgw)
    {
      this.tgt = f;
      requestLayout();
      return;
    }
  }
  
  public final int d(RecyclerView.s params)
  {
    return cLE();
  }
  
  public final int e(RecyclerView.s params)
  {
    return cLE();
  }
  
  public final int f(RecyclerView.s params)
  {
    return cLF();
  }
  
  public final int g(RecyclerView.s params)
  {
    return cLF();
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int h(RecyclerView.s params)
  {
    return cLG();
  }
  
  public final int i(RecyclerView.s params)
  {
    return cLG();
  }
  
  public final boolean jE()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean jF()
  {
    return this.mOrientation == 1;
  }
  
  public final void jH()
  {
    if (this.tgu == null) {
      this.tgu = b.b(this, this.mOrientation);
    }
  }
  
  public final RecyclerView.LayoutParams jy()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final void kY()
  {
    removeAllViews();
    this.tgt = 0.0F;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.tgv = new SavedState((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.tgv != null) {
      return new SavedState(this.tgv);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.position = this.anz;
    localSavedState.offset = this.tgt;
    localSavedState.tgE = this.anw;
    return localSavedState;
  }
  
  protected abstract void p(View paramView, float paramFloat);
  
  public final void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    E(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.tgu = null;
    this.tgC = 2147483647;
    removeAllViews();
  }
  
  public final int vv(int paramInt)
  {
    if (this.anf)
    {
      int i = cLM();
      if (!this.anw) {
        paramInt -= cLM();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.tgw - this.tgt) * cLC());
        paramInt = -cLM() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.anw) {}
    for (float f1 = this.tgw;; f1 = -this.tgw) {
      return (int)((f1 * f2 - this.tgt) * cLC());
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    float offset;
    int position;
    boolean tgE;
    
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
        this.tgE = bool;
        AppMethodBeat.o(65341);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.position = paramSavedState.position;
      this.offset = paramSavedState.offset;
      this.tgE = paramSavedState.tgE;
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
      if (this.tgE) {}
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