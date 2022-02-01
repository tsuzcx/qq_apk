package android.support.design.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.circularreveal.b;
import android.support.design.circularreveal.c;
import android.support.design.circularreveal.c.d;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class CircularRevealCardView
  extends CardView
  implements c
{
  private final b hI = new b(this);
  
  public CircularRevealCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public final void bc()
  {
    this.hI.bc();
  }
  
  public final void bd()
  {
    this.hI.bd();
  }
  
  public final boolean be()
  {
    return super.isOpaque();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.hI != null)
    {
      this.hI.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.hI.hP;
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.hI.hN.getColor();
  }
  
  public c.d getRevealInfo()
  {
    return this.hI.getRevealInfo();
  }
  
  public boolean isOpaque()
  {
    if (this.hI != null) {
      return this.hI.isOpaque();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.hI.setCircularRevealOverlayDrawable(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    this.hI.setCircularRevealScrimColor(paramInt);
  }
  
  public void setRevealInfo(c.d paramd)
  {
    this.hI.setRevealInfo(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.circularreveal.cardview.CircularRevealCardView
 * JD-Core Version:    0.7.0.1
 */