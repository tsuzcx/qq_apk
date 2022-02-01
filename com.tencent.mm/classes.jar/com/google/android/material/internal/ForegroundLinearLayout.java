package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ForegroundLinearLayout
  extends LinearLayoutCompat
{
  private Drawable bCo;
  private final Rect bCp;
  private final Rect bCq;
  private int bCr;
  protected boolean bCs;
  boolean bCt;
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237706);
    this.bCp = new Rect();
    this.bCq = new Rect();
    this.bCr = 119;
    this.bCs = true;
    this.bCt = false;
    paramContext = k.a(paramContext, paramAttributeSet, a.k.ForegroundLinearLayout, paramInt, 0, new int[0]);
    this.bCr = paramContext.getInt(a.k.ForegroundLinearLayout_android_foregroundGravity, this.bCr);
    paramAttributeSet = paramContext.getDrawable(a.k.ForegroundLinearLayout_android_foreground);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.bCs = paramContext.getBoolean(a.k.ForegroundLinearLayout_foregroundInsidePadding, true);
    paramContext.recycle();
    AppMethodBeat.o(237706);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237730);
    super.draw(paramCanvas);
    Drawable localDrawable;
    Rect localRect1;
    Rect localRect2;
    int i;
    int j;
    if (this.bCo != null)
    {
      localDrawable = this.bCo;
      if (this.bCt)
      {
        this.bCt = false;
        localRect1 = this.bCp;
        localRect2 = this.bCq;
        i = getRight() - getLeft();
        j = getBottom() - getTop();
        if (!this.bCs) {
          break label123;
        }
        localRect1.set(0, 0, i, j);
      }
    }
    for (;;)
    {
      Gravity.apply(this.bCr, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(237730);
      return;
      label123:
      localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    }
  }
  
  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237733);
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.bCo != null) {
      this.bCo.setHotspot(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(237733);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(237717);
    super.drawableStateChanged();
    if ((this.bCo != null) && (this.bCo.isStateful())) {
      this.bCo.setState(getDrawableState());
    }
    AppMethodBeat.o(237717);
  }
  
  public Drawable getForeground()
  {
    return this.bCo;
  }
  
  public int getForegroundGravity()
  {
    return this.bCr;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(237715);
    super.jumpDrawablesToCurrentState();
    if (this.bCo != null) {
      this.bCo.jumpToCurrentState();
    }
    AppMethodBeat.o(237715);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237726);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.bCt |= paramBoolean;
    AppMethodBeat.o(237726);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237728);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.bCt = true;
    AppMethodBeat.o(237728);
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    AppMethodBeat.i(237720);
    if (this.bCo != paramDrawable)
    {
      if (this.bCo != null)
      {
        this.bCo.setCallback(null);
        unscheduleDrawable(this.bCo);
      }
      this.bCo = paramDrawable;
      if (paramDrawable == null) {
        break label106;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      if (this.bCr == 119) {
        paramDrawable.getPadding(new Rect());
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      AppMethodBeat.o(237720);
      return;
      label106:
      setWillNotDraw(true);
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    AppMethodBeat.i(237709);
    if (this.bCr != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label87;
      }
      paramInt = 0x800003 | paramInt;
    }
    label87:
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.bCr = i;
      if ((this.bCr == 119) && (this.bCo != null))
      {
        Rect localRect = new Rect();
        this.bCo.getPadding(localRect);
      }
      requestLayout();
      AppMethodBeat.o(237709);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(237712);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.bCo))
    {
      AppMethodBeat.o(237712);
      return true;
    }
    AppMethodBeat.o(237712);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.ForegroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */