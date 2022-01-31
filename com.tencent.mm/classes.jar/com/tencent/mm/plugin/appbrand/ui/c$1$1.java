package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.preload.e;
import com.tencent.mm.sdk.platformtools.bo;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, Bitmap paramBitmap, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(132933);
    if (this.val$bitmap != null)
    {
      c.b(this.iMr.iMp).setImageBitmap(this.val$bitmap);
      if (c.c(this.iMr.iMp)) {
        c.d(this.iMr.iMp);
      }
      e.aAT().de(1002, (int)bo.av(this.iMr.iMo));
      e.aAT().de(1001, (int)this.iMq);
    }
    AppMethodBeat.o(132933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.1.1
 * JD-Core Version:    0.7.0.1
 */