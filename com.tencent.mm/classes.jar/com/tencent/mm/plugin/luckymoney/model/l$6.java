package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class l$6
  implements l.a
{
  l$6(l paraml, a.a parama, ImageView paramImageView) {}
  
  public final void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(42308);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      if (this.ooa != null) {
        this.ooa.iX(false);
      }
      AppMethodBeat.o(42308);
      return;
    }
    l.V(new l.6.1(this, paramInt, paramBitmap, paramString));
    AppMethodBeat.o(42308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.6
 * JD-Core Version:    0.7.0.1
 */