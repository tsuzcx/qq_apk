package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v4.view.ab;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  Drawable eZ;
  Rect fa;
  private Rect mTempRect = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ScrimInsetsFrameLayout, paramInt, 2131493841);
    this.eZ = paramContext.getDrawable(0);
    paramContext.recycle();
    setWillNotDraw(true);
    t.a(this, new ScrimInsetsFrameLayout.1(this));
  }
  
  protected void a(ab paramab) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.fa != null) && (this.eZ != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.mTempRect.set(0, 0, i, this.fa.top);
      this.eZ.setBounds(this.mTempRect);
      this.eZ.draw(paramCanvas);
      this.mTempRect.set(0, j - this.fa.bottom, i, j);
      this.eZ.setBounds(this.mTempRect);
      this.eZ.draw(paramCanvas);
      this.mTempRect.set(0, this.fa.top, this.fa.left, j - this.fa.bottom);
      this.eZ.setBounds(this.mTempRect);
      this.eZ.draw(paramCanvas);
      this.mTempRect.set(i - this.fa.right, this.fa.top, i, j - this.fa.bottom);
      this.eZ.setBounds(this.mTempRect);
      this.eZ.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.eZ != null) {
      this.eZ.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.eZ != null) {
      this.eZ.setCallback(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */