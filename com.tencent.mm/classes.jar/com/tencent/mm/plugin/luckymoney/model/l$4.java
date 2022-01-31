package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$4
  implements l.a
{
  l$4(l paraml, ImageView paramImageView) {}
  
  public final void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(42304);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(42304);
      return;
    }
    l.V(new l.4.1(this, paramBitmap));
    AppMethodBeat.o(42304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.4
 * JD-Core Version:    0.7.0.1
 */