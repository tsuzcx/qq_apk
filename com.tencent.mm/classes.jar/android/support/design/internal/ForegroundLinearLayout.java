package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.k;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class ForegroundLinearLayout
  extends LinearLayoutCompat
{
  private Drawable dr;
  private final Rect ds = new Rect();
  private final Rect dt = new Rect();
  private int du = 119;
  protected boolean dv = true;
  boolean dw = false;
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ForegroundLinearLayout, paramInt, 0);
    this.du = paramContext.getInt(a.k.ForegroundLinearLayout_android_foregroundGravity, this.du);
    paramAttributeSet = paramContext.getDrawable(a.k.ForegroundLinearLayout_android_foreground);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.dv = paramContext.getBoolean(a.k.ForegroundLinearLayout_foregroundInsidePadding, true);
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
    if (this.dr != null)
    {
      localDrawable = this.dr;
      if (this.dw)
      {
        this.dw = false;
        localRect1 = this.ds;
        localRect2 = this.dt;
        i = getRight() - getLeft();
        j = getBottom() - getTop();
        if (!this.dv) {
          break label113;
        }
        localRect1.set(0, 0, i, j);
      }
    }
    for (;;)
    {
      Gravity.apply(this.du, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      return;
      label113:
      localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.dr != null) {
      this.dr.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.dr != null) && (this.dr.isStateful())) {
      this.dr.setState(getDrawableState());
    }
  }
  
  public Drawable getForeground()
  {
    return this.dr;
  }
  
  public int getForegroundGravity()
  {
    return this.du;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.dr != null) {
      this.dr.jumpToCurrentState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.dw |= paramBoolean;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.dw = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (this.dr != paramDrawable)
    {
      if (this.dr != null)
      {
        this.dr.setCallback(null);
        unscheduleDrawable(this.dr);
      }
      this.dr = paramDrawable;
      if (paramDrawable == null) {
        break label96;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      if (this.du == 119) {
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
    if (this.du != paramInt)
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
      this.du = i;
      if ((this.du == 119) && (this.dr != null))
      {
        Rect localRect = new Rect();
        this.dr.getPadding(localRect);
      }
      requestLayout();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.dr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.internal.ForegroundLinearLayout
 * JD-Core Version:    0.7.0.1
 */