package android.support.design.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;

public class CircularRevealGridLayout
  extends GridLayout
  implements c
{
  private final b gJ = new b(this);
  
  public CircularRevealGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public final void aV()
  {
    this.gJ.aV();
  }
  
  public final void aW()
  {
    this.gJ.aW();
  }
  
  public final boolean aX()
  {
    return super.isOpaque();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.gJ != null)
    {
      this.gJ.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.gJ.gQ;
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.gJ.gO.getColor();
  }
  
  public c.d getRevealInfo()
  {
    return this.gJ.getRevealInfo();
  }
  
  public boolean isOpaque()
  {
    if (this.gJ != null) {
      return this.gJ.isOpaque();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.gJ.setCircularRevealOverlayDrawable(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    this.gJ.setCircularRevealScrimColor(paramInt);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    this.gJ.setRevealInfo(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.circularreveal.CircularRevealGridLayout
 * JD-Core Version:    0.7.0.1
 */