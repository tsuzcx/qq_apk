package com.tencent.mm.plugin.card.d;

import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$1$1
  implements Runnable
{
  m$1$1(m.1 param1, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(88926);
    this.kCp.kCm.setImageBitmap(this.kCo);
    this.kCp.kCm.setColorFilter(this.kCp.ixw, PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(88926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m.1.1
 * JD-Core Version:    0.7.0.1
 */