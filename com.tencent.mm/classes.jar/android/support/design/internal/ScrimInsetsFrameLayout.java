package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  Drawable ea;
  Rect eb;
  private Rect ec = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ScrimInsetsFrameLayout, paramInt, a.j.Widget_Design_ScrimInsetsFrameLayout);
    this.ea = paramContext.getDrawable(a.k.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    q.a(this, new ScrimInsetsFrameLayout.1(this));
  }
  
  public void a(y paramy) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.eb != null) && (this.ea != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.ec.set(0, 0, i, this.eb.top);
      this.ea.setBounds(this.ec);
      this.ea.draw(paramCanvas);
      this.ec.set(0, j - this.eb.bottom, i, j);
      this.ea.setBounds(this.ec);
      this.ea.draw(paramCanvas);
      this.ec.set(0, this.eb.top, this.eb.left, j - this.eb.bottom);
      this.ea.setBounds(this.ec);
      this.ea.draw(paramCanvas);
      this.ec.set(i - this.eb.right, this.eb.top, i, j - this.eb.bottom);
      this.ea.setBounds(this.ec);
      this.ea.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.ea != null) {
      this.ea.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.ea != null) {
      this.ea.setCallback(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */