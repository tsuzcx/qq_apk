package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;

final class l$4$1
  implements Runnable
{
  l$4$1(l.4 param4, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(42303);
    this.onY.lHj.setImageBitmap(d.a(this.val$bitmap, false, a.fromDPToPix(ah.getContext(), 3)));
    AppMethodBeat.o(42303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.4.1
 * JD-Core Version:    0.7.0.1
 */