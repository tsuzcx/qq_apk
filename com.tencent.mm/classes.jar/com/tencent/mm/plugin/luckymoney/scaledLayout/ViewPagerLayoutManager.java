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
  private boolean aoa = false;
  private boolean aoq = false;
  private boolean aor = false;
  private boolean aot = true;
  private int aou = -1;
  private boolean aow;
  public int mOrientation;
  private SparseArray<View> uoD = new SparseArray();
  protected int uoE;
  protected int uoF;
  protected int uoG;
  protected int uoH;
  protected float uoI;
  protected b uoJ;
  private SavedState uoK = null;
  protected float uoL;
  private boolean uoM;
  private int uoN;
  private int uoO;
  int uoP = -1;
  private Interpolator uoQ;
  int uoR = 2147483647;
  private View uoS;
  
  public ViewPagerLayoutManager(int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    ap(paramBoolean);
    this.arw = true;
    aw(false);
  }
  
  private float HO(int paramInt)
  {
    if (this.aor) {
      return paramInt * -this.uoL;
    }
    return paramInt * this.uoL;
  }
  
  private int b(int paramInt, RecyclerView.o paramo)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    jP();
    float f = paramInt / cZi();
    if (Math.abs(f) < 1.0E-008F) {
      return 0;
    }
    f = this.uoI + f;
    int i;
    if ((!this.aoa) && (f < cZp())) {
      i = (int)(paramInt - (f - cZp()) * cZi());
    }
    for (;;)
    {
      this.uoI = (i / cZi() + this.uoI);
      e(paramo);
      return i;
      i = paramInt;
      if (!this.aoa)
      {
        i = paramInt;
        if (f > cZo()) {
          i = (int)((cZo() - this.uoI) * cZi());
        }
      }
    }
  }
  
  private boolean be(float paramFloat)
  {
    return (paramFloat > cZq()) || (paramFloat < cZr());
  }
  
  private int bf(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return (int)paramFloat;
  }
  
  private int bg(float paramFloat)
  {
    if (this.mOrientation == 1) {
      return (int)paramFloat;
    }
    return 0;
  }
  
  private int cZk()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aot)
    {
      if (!this.aor) {
        return getCurrentPosition();
      }
      return getItemCount() - getCurrentPosition() - 1;
    }
    float f = cZt();
    if (!this.aor) {
      return (int)f;
    }
    return (int)(f + (getItemCount() - 1) * this.uoL);
  }
  
  private int cZl()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aot) {
      return 1;
    }
    return (int)this.uoL;
  }
  
  private int cZm()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    if (!this.aot) {
      return getItemCount();
    }
    return (int)(getItemCount() * this.uoL);
  }
  
  private boolean cZn()
  {
    return this.uoP != -1;
  }
  
  private float cZo()
  {
    if (!this.aor) {
      return (getItemCount() - 1) * this.uoL;
    }
    return 0.0F;
  }
  
  private float cZp()
  {
    if (!this.aor) {
      return 0.0F;
    }
    return -(getItemCount() - 1) * this.uoL;
  }
  
  private float cZq()
  {
    return this.uoJ.kn() - this.uoG;
  }
  
  private float cZr()
  {
    return -this.uoE - this.uoJ.kl() - this.uoG;
  }
  
  private int cZs()
  {
    if (this.uoL == 0.0F) {
      return 0;
    }
    return Math.round(this.uoI / this.uoL);
  }
  
  private float cZt()
  {
    if (this.aor)
    {
      if (this.aoa)
      {
        if (this.uoI <= 0.0F) {
          return this.uoI % (this.uoL * getItemCount());
        }
        return getItemCount() * -this.uoL + this.uoI % (this.uoL * getItemCount());
      }
      return this.uoI;
    }
    if (this.aoa)
    {
      if (this.uoI >= 0.0F) {
        return this.uoI % (this.uoL * getItemCount());
      }
      return getItemCount() * this.uoL + this.uoI % (this.uoL * getItemCount());
    }
    return this.uoI;
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
  
  private void e(RecyclerView.o paramo)
  {
    b(paramo);
    this.uoD.clear();
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
    if (this.aor)
    {
      i3 = -cZs();
      j = i3 - this.uoN;
      i = this.uoO + i3;
      if (cZn())
      {
        if (this.uoP % 2 != 0) {
          break label327;
        }
        i = 1;
        if (i == 0) {
          break label333;
        }
        i = this.uoP / 2;
        j = i3 - i + 1;
        i = i + i3 + 1;
      }
      m = i;
      i1 = j;
      if (!this.aoa)
      {
        n = i;
        k = j;
        if (j < 0)
        {
          if (!cZn()) {
            break label436;
          }
          n = this.uoP;
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
        if ((!cZn()) && (be(HO(i) - this.uoI))) {
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
        ej(localView);
        r(localView, HO(i) - this.uoI);
        float f2;
        if (this.uoM)
        {
          f2 = 0.0F;
          label271:
          if (f2 <= f1) {
            break label405;
          }
          addView(localView);
          label283:
          if (i == i3) {
            this.uoS = localView;
          }
          this.uoD.put(i, localView);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break label180;
          i3 = cZs();
          break;
          label327:
          i = 0;
          break label75;
          label333:
          i = (this.uoP - 1) / 2;
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
          this.uoS.requestFocus();
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
  
  private static void ej(View paramView)
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
    int i = cZs();
    if (!this.aoa) {
      return Math.abs(i);
    }
    if (!this.aor) {
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
    int i = bf(paramFloat);
    int j = bg(paramFloat);
    if (this.mOrientation == 1) {
      j(paramView, this.uoH + i, this.uoG + j, i + this.uoH + this.uoF, j + this.uoG + this.uoE);
    }
    for (;;)
    {
      q(paramView, paramFloat);
      return;
      j(paramView, this.uoG + i, this.uoH + j, i + this.uoG + this.uoE, j + this.uoH + this.uoF);
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
    this.uoK = null;
    this.aou = -1;
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.o paramo)
  {
    super.a(paramRecyclerView, paramo);
    if (this.aow)
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
    if (this.aoa)
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
    for (paramInt = wm(paramInt);; paramInt = wm(paramInt))
    {
      if (this.mOrientation != 1) {
        break label130;
      }
      paramRecyclerView.a(0, paramInt, this.uoQ);
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
    paramRecyclerView.a(paramInt, 0, this.uoQ);
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
          if (this.aor)
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
        paramInt1 = wm(paramInt1);
        if (this.mOrientation != 1) {
          break label182;
        }
        paramRecyclerView.a(0, paramInt1, null);
        return true;
        paramInt1 = 1;
        break label51;
        if (paramInt1 == 130)
        {
          if (this.aor)
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
          if (this.aor)
          {
            paramInt1 = 0;
            break label51;
          }
          paramInt1 = 1;
          break label51;
        }
        if (paramInt1 == 66)
        {
          if (this.aor)
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
    G(null);
    if (paramBoolean == this.aoq) {
      return;
    }
    this.aoq = paramBoolean;
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
    while (i < this.uoD.size())
    {
      int j = this.uoD.keyAt(i);
      if (j >= 0)
      {
        if (paramInt == j % m) {
          return (View)this.uoD.valueAt(i);
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
          return (View)this.uoD.valueAt(i);
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
      this.uoI = 0.0F;
      return;
    }
    jP();
    boolean bool;
    if ((this.mOrientation == 1) || (!ji())) {
      bool = this.aoq;
    }
    for (;;)
    {
      this.aor = bool;
      paramt = d(paramo, paramt, 0);
      if (paramt != null) {
        break;
      }
      d(paramo);
      this.uoI = 0.0F;
      return;
      if (!this.aoq) {
        bool = true;
      } else {
        bool = false;
      }
    }
    bD(paramt);
    this.uoE = this.uoJ.br(paramt);
    this.uoF = this.uoJ.bs(paramt);
    this.uoG = ((this.uoJ.kn() - this.uoE) / 2);
    if (this.uoR == 2147483647)
    {
      this.uoH = ((this.uoJ.cZg() - this.uoF) / 2);
      this.uoL = cZh();
      cZj();
      if (this.uoL != 0.0F) {
        break label297;
      }
      this.uoN = 1;
      this.uoO = 1;
      label195:
      if (this.uoK != null)
      {
        this.aor = this.uoK.uoT;
        this.aou = this.uoK.position;
        this.uoI = this.uoK.offset;
      }
      if (this.aou != -1) {
        if (!this.aor) {
          break label338;
        }
      }
    }
    label297:
    label338:
    for (float f = this.aou * -this.uoL;; f = this.aou * this.uoL)
    {
      this.uoI = f;
      e(paramo);
      return;
      this.uoH = (this.uoJ.cZg() - this.uoF - this.uoR);
      break;
      this.uoN = ((int)Math.abs(cZr() / this.uoL) + 1);
      this.uoO = ((int)Math.abs(cZq() / this.uoL) + 1);
      break label195;
    }
  }
  
  protected abstract float cZh();
  
  protected float cZi()
  {
    return 1.0F;
  }
  
  protected void cZj() {}
  
  public final void ca(int paramInt)
  {
    if ((!this.aoa) && ((paramInt < 0) || (paramInt >= getItemCount()))) {
      return;
    }
    this.aou = paramInt;
    if (this.aor) {}
    for (float f = paramInt * -this.uoL;; f = paramInt * this.uoL)
    {
      this.uoI = f;
      requestLayout();
      return;
    }
  }
  
  public final int d(RecyclerView.t paramt)
  {
    return cZk();
  }
  
  public final int e(RecyclerView.t paramt)
  {
    return cZk();
  }
  
  public final int f(RecyclerView.t paramt)
  {
    return cZl();
  }
  
  public final int g(RecyclerView.t paramt)
  {
    return cZl();
  }
  
  public final int getOrientation()
  {
    return this.mOrientation;
  }
  
  public final int h(RecyclerView.t paramt)
  {
    return cZm();
  }
  
  public final int i(RecyclerView.t paramt)
  {
    return cZm();
  }
  
  public final RecyclerView.LayoutParams jG()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final boolean jM()
  {
    return this.mOrientation == 0;
  }
  
  public final boolean jN()
  {
    return this.mOrientation == 1;
  }
  
  public final void jP()
  {
    if (this.uoJ == null) {
      this.uoJ = b.b(this, this.mOrientation);
    }
  }
  
  public final void lg()
  {
    removeAllViews();
    this.uoI = 0.0F;
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.uoK = new SavedState((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.uoK != null) {
      return new SavedState(this.uoK);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.position = this.aou;
    localSavedState.offset = this.uoI;
    localSavedState.uoT = this.aor;
    return localSavedState;
  }
  
  protected abstract void q(View paramView, float paramFloat);
  
  public final void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(paramInt)));
    }
    G(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.uoJ = null;
    this.uoR = 2147483647;
    removeAllViews();
  }
  
  public final int wm(int paramInt)
  {
    if (this.aoa)
    {
      int i = cZs();
      if (!this.aor) {
        paramInt -= cZs();
      }
      for (;;)
      {
        return (int)(((paramInt + i) * this.uoL - this.uoI) * cZi());
        paramInt = -cZs() - paramInt;
      }
    }
    float f2 = paramInt;
    if (!this.aor) {}
    for (float f1 = this.uoL;; f1 = -this.uoL) {
      return (int)((f1 * f2 - this.uoI) * cZi());
    }
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    float offset;
    int position;
    boolean uoT;
    
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
        this.uoT = bool;
        AppMethodBeat.o(65341);
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.position = paramSavedState.position;
      this.offset = paramSavedState.offset;
      this.uoT = paramSavedState.uoT;
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
      if (this.uoT) {}
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