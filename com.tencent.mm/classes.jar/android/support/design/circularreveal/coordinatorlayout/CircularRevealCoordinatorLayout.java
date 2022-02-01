package android.support.design.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.circularreveal.b;
import android.support.design.circularreveal.c;
import android.support.design.circularreveal.c.d;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;

public class CircularRevealCoordinatorLayout
  extends CoordinatorLayout
  implements c
{
  private final b gJ = new b(this);
  
  public CircularRevealCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
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
 * Qualified Name:     android.support.design.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */