package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class ForegroundLinearLayout
  extends LinearLayoutCompat
{
  private int foregroundGravity = 119;
  private Drawable kL;
  private final Rect kM = new Rect();
  private final Rect kN = new Rect();
  protected boolean kO = true;
  boolean kP = false;
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = f.a(paramContext, paramAttributeSet, a.a.ForegroundLinearLayout, paramInt, 0, new int[0]);
    this.foregroundGravity = paramContext.getInt(1, this.foregroundGravity);
    paramAttributeSet = paramContext.getDrawable(0);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.kO = paramContext.getBoolean(2, true);
    paramContext.recycle();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    Rect localRect1;
    Rect localRect2;
    int i;
    int j;
    if (this.kL != null)
    {
      localDrawable = this.kL;
      if (this.kP)
      {
        this.kP = false;
        localRect1 = this.kM;
        localRect2 = this.kN;
        i = getRight() - getLeft();
        j = getBottom() - getTop();
        if (!this.kO) {
          break label113;
        }
        localRect1.set(0, 0, i, j);
      }
    }
    for (;;)
    {
      Gravity.apply(this.foregroundGravity, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      return;
      label113:
      localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    }
  }
  
  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.kL != null) {
      this.kL.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.kL != null) && (this.kL.isStateful())) {
      this.kL.setState(getDrawableState());
    }
  }
  
  public Drawable getForeground()
  {
    return this.kL;
  }
  
  public int getForegroundGravity()
  {
    return this.foregroundGravity;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.kL != null) {
      this.kL.jumpToCurrentState();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.kP |= paramBoolean;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.kP = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (this.kL != paramDrawable)
    {
      if (this.kL != null)
      {
        this.kL.setCallback(null);
        unscheduleDrawable(this.kL);
      }
      this.kL = paramDrawable;
      if (paramDrawable == null) {
        break label96;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      if (this.foregroundGravity == 119) {
        paramDrawable.getPadding(new Rect());
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      return;
      label96:
      setWillNotDraw(true);
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (this.foregroundGravity != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label77;
      }
      paramInt = 0x800003 | paramInt;
    }
    label77:
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.foregroundGravity = i;
      if ((this.foregroundGravity == 119) && (this.kL != null))
      {
        Rect localRect = new Rect();
        this.kL.getPadding(localRect);
      }
      requestLayout();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.kL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.ForegroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */