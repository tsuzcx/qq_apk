package com.google.android.material.internal;

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
  private Drawable dvp;
  private final Rect dvq;
  private final Rect dvr;
  private int dvs;
  protected boolean dvt;
  boolean dvu;
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209272);
    this.dvq = new Rect();
    this.dvr = new Rect();
    this.dvs = 119;
    this.dvt = true;
    this.dvu = false;
    paramContext = k.a(paramContext, paramAttributeSet, a.k.ForegroundLinearLayout, paramInt, 0, new int[0]);
    this.dvs = paramContext.getInt(a.k.ForegroundLinearLayout_android_foregroundGravity, this.dvs);
    paramAttributeSet = paramContext.getDrawable(a.k.ForegroundLinearLayout_android_foreground);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.dvt = paramContext.getBoolean(a.k.ForegroundLinearLayout_foregroundInsidePadding, true);
    paramContext.recycle();
    AppMethodBeat.o(209272);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209378);
    super.draw(paramCanvas);
    Drawable localDrawable;
    Rect localRect1;
    Rect localRect2;
    int i;
    int j;
    if (this.dvp != null)
    {
      localDrawable = this.dvp;
      if (this.dvu)
      {
        this.dvu = false;
        localRect1 = this.dvq;
        localRect2 = this.dvr;
        i = getRight() - getLeft();
        j = getBottom() - getTop();
        if (!this.dvt) {
          break label123;
        }
        localRect1.set(0, 0, i, j);
      }
    }
    for (;;)
    {
      Gravity.apply(this.dvs, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(209378);
      return;
      label123:
      localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(209387);
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.dvp != null) {
      this.dvp.setHotspot(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(209387);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(209321);
    super.drawableStateChanged();
    if ((this.dvp != null) && (this.dvp.isStateful())) {
      this.dvp.setState(getDrawableState());
    }
    AppMethodBeat.o(209321);
  }
  
  public Drawable getForeground()
  {
    return this.dvp;
  }
  
  public int getForegroundGravity()
  {
    return this.dvs;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(209314);
    super.jumpDrawablesToCurrentState();
    if (this.dvp != null) {
      this.dvp.jumpToCurrentState();
    }
    AppMethodBeat.o(209314);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209356);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.dvu |= paramBoolean;
    AppMethodBeat.o(209356);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209367);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.dvu = true;
    AppMethodBeat.o(209367);
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    AppMethodBeat.i(209331);
    if (this.dvp != paramDrawable)
    {
      if (this.dvp != null)
      {
        this.dvp.setCallback(null);
        unscheduleDrawable(this.dvp);
      }
      this.dvp = paramDrawable;
      if (paramDrawable == null) {
        break label106;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      if (this.dvs == 119) {
        paramDrawable.getPadding(new Rect());
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      AppMethodBeat.o(209331);
      return;
      label106:
      setWillNotDraw(true);
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    AppMethodBeat.i(209294);
    if (this.dvs != paramInt)
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
      this.dvs = i;
      if ((this.dvs == 119) && (this.dvp != null))
      {
        Rect localRect = new Rect();
        this.dvp.getPadding(localRect);
      }
      requestLayout();
      AppMethodBeat.o(209294);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209302);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.dvp))
    {
      AppMethodBeat.o(209302);
      return true;
    }
    AppMethodBeat.o(209302);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.ForegroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */