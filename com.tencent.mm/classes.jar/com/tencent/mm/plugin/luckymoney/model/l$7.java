package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$7
  implements l.a
{
  l$7(l paraml, ImageView paramImageView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public final void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(42310);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(42310);
      return;
    }
    l.V(new l.7.1(this, paramInt, paramBitmap, paramString));
    AppMethodBeat.o(42310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.7
 * JD-Core Version:    0.7.0.1
 */