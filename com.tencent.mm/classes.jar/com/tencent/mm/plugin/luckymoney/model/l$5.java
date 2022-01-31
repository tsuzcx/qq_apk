package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$5
  implements l.a
{
  l$5(l paraml, ImageView paramImageView) {}
  
  public final void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(42306);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(42306);
      return;
    }
    l.V(new l.5.1(this, paramBitmap));
    AppMethodBeat.o(42306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.5
 * JD-Core Version:    0.7.0.1
 */