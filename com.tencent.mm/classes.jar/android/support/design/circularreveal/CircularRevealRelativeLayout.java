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
  private final b jF = new b(this);
  
  public CircularRevealRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public final void bu()
  {
    this.jF.bu();
  }
  
  public final void bv()
  {
    this.jF.bv();
  }
  
  public final boolean bw()
  {
    return super.isOpaque();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jF != null)
    {
      this.jF.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.jF.jM;
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.jF.jK.getColor();
  }
  
  public c.d getRevealInfo()
  {
    return this.jF.getRevealInfo();
  }
  
  public boolean isOpaque()
  {
    if (this.jF != null) {
      return this.jF.isOpaque();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.jF.setCircularRevealOverlayDrawable(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    this.jF.setCircularRevealScrimColor(paramInt);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    this.jF.setRevealInfo(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.circularreveal.CircularRevealRelativeLayout
 * JD-Core Version:    0.7.0.1
 */