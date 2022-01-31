package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class l$6$1
  implements Runnable
{
  l$6$1(l.6 param6, int paramInt, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(42307);
    if (this.ong > 0)
    {
      int i = ((Integer)this.oob.lHj.getTag(2131820638)).intValue();
      if (i == this.ong)
      {
        this.oob.lHj.setImageBitmap(d.a(this.val$bitmap, false, a.fromDPToPix(ah.getContext(), 8)));
        if (this.oob.ooa != null)
        {
          this.oob.ooa.iX(true);
          AppMethodBeat.o(42307);
        }
      }
      else
      {
        ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ong) });
      }
      AppMethodBeat.o(42307);
      return;
    }
    String str = (String)this.oob.lHj.getTag(2131820639);
    if ((!bo.isNullOrNil(this.val$url)) && (this.val$url.equals(str)))
    {
      this.oob.lHj.setImageBitmap(d.a(this.val$bitmap, false, a.fromDPToPix(ah.getContext(), 8)));
      if (this.oob.ooa != null)
      {
        this.oob.ooa.iX(true);
        AppMethodBeat.o(42307);
      }
    }
    else
    {
      ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, this.val$url });
    }
    AppMethodBeat.o(42307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.6.1
 * JD-Core Version:    0.7.0.1
 */