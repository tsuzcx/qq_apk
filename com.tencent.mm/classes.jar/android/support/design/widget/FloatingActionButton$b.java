package android.support.design.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class FloatingActionButton$b
  implements k
{
  FloatingActionButton$b(FloatingActionButton paramFloatingActionButton) {}
  
  public final boolean aI()
  {
    return this.iz.is;
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iz.it.set(paramInt1, paramInt2, paramInt3, paramInt4);
    this.iz.setPadding(this.iz.iq + paramInt1, this.iz.iq + paramInt2, this.iz.iq + paramInt3, this.iz.iq + paramInt4);
  }
  
  public final float getRadius()
  {
    return this.iz.getSizeDimension() / 2.0F;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    FloatingActionButton.a(this.iz, paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton.b
 * JD-Core Version:    0.7.0.1
 */