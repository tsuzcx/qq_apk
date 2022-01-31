package android.support.design.widget;

import android.graphics.Outline;

final class e
  extends d
{
  public final void getOutline(Outline paramOutline)
  {
    copyBounds(this.mRect);
    paramOutline.setOval(this.mRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.e
 * JD-Core Version:    0.7.0.1
 */