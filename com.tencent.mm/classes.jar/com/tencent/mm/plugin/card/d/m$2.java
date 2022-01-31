package com.tencent.mm.plugin.card.d;

import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

final class m$2
  implements Runnable
{
  m$2(ImageView paramImageView, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    this.izf.setImageResource(this.izg);
    this.izf.setColorFilter(this.fyP, PorterDuff.Mode.SRC_IN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m.2
 * JD-Core Version:    0.7.0.1
 */