package android.support.design.widget;

import android.graphics.Outline;

public final class c
  extends b
{
  public final void getOutline(Outline paramOutline)
  {
    copyBounds(this.rect);
    paramOutline.setOval(this.rect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.c
 * JD-Core Version:    0.7.0.1
 */