package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class m$7
  implements m.a
{
  m$7(m paramm, ImageView paramImageView) {}
  
  public final void b(final Bitmap paramBitmap, int paramInt, final String paramString)
  {
    AppMethodBeat.i(174324);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(174324);
      return;
    }
    m.an(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174323);
        String str = (String)m.7.this.oXU.getTag(2131301809);
        if ((!bt.isNullOrNil(paramString)) && (paramString.equals(str)))
        {
          m.7.this.oXU.setImageBitmap(paramBitmap);
          AppMethodBeat.o(174323);
          return;
        }
        ad.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramString });
        AppMethodBeat.o(174323);
      }
    });
    AppMethodBeat.o(174324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m.7
 * JD-Core Version:    0.7.0.1
 */