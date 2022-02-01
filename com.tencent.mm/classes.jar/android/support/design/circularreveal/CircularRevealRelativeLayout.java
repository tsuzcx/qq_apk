package android.support.design.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CircularRevealRelativeLayout
  extends RelativeLayout
  implements c
{
  private final b jD = new b(this);
  
  public CircularRevealRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public final void bs()
  {
    this.jD.bs();
  }
  
  public final void bt()
  {
    this.jD.bt();
  }
  
  public final boolean bu()
  {
    return super.isOpaque();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jD != null)
    {
      this.jD.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.jD.jK;
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.jD.jI.getColor();
  }
  
  public c.d getRevealInfo()
  {
    return this.jD.getRevealInfo();
  }
  
  public boolean isOpaque()
  {
    if (this.jD != null) {
      return this.jD.isOpaque();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.jD.setCircularRevealOverlayDrawable(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    this.jD.setCircularRevealScrimColor(paramInt);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    this.jD.setRevealInfo(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.circularreveal.CircularRevealRelativeLayout
 * JD-Core Version:    0.7.0.1
 */