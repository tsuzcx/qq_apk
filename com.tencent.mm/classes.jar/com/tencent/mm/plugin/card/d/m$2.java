package com.tencent.mm.plugin.card.d;

import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$2
  implements Runnable
{
  m$2(ImageView paramImageView, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(88928);
    this.kCm.setImageResource(this.kCn);
    this.kCm.setColorFilter(this.ixw, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(88928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m.2
 * JD-Core Version:    0.7.0.1
 */