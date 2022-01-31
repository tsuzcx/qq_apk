package android.support.design.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class FloatingActionButton$b
  implements k
{
  FloatingActionButton$b(FloatingActionButton paramFloatingActionButton) {}
  
  public final boolean br()
  {
    return this.js.jm;
  }
  
  public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.js.jn.set(paramInt1, paramInt2, paramInt3, paramInt4);
    FloatingActionButton localFloatingActionButton = this.js;
    localFloatingActionButton.setPadding(localFloatingActionButton.jk + paramInt1, this.js.jk + paramInt2, this.js.jk + paramInt3, this.js.jk + paramInt4);
  }
  
  public final float getRadius()
  {
    return this.js.getSizeDimension() / 2.0F;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    FloatingActionButton.a(this.js, paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton.b
 * JD-Core Version:    0.7.0.1
 */