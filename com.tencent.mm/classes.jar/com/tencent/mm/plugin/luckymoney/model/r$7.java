package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class r$7
  implements r.a
{
  r$7(r paramr, ImageView paramImageView) {}
  
  public final void b(final Bitmap paramBitmap, int paramInt, final String paramString)
  {
    AppMethodBeat.i(174324);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "load error: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(174324);
      return;
    }
    r.aB(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174323);
        String str = (String)r.7.this.vhS.getTag(a.f.lucky_money_envelope_url);
        if ((!Util.isNullOrNil(paramString)) && (paramString.equals(str)))
        {
          r.7.this.vhS.setImageBitmap(paramBitmap);
          AppMethodBeat.o(174323);
          return;
        }
        Log.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, paramString });
        AppMethodBeat.o(174323);
      }
    });
    AppMethodBeat.o(174324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.r.7
 * JD-Core Version:    0.7.0.1
 */