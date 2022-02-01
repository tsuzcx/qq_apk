package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class m$3
  implements m.a
{
  m$3(m paramm, ImageView paramImageView) {}
  
  public final void b(final Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(163543);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(163543);
      return;
    }
    m.an(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163542);
        m.3.this.oXU.setImageBitmap(paramBitmap);
        AppMethodBeat.o(163542);
      }
    });
    AppMethodBeat.o(163543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m.3
 * JD-Core Version:    0.7.0.1
 */