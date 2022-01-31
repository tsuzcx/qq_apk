package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class l$7$1
  implements Runnable
{
  l$7$1(l.7 param7, int paramInt, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(42309);
    if (this.ong > 0)
    {
      int i = ((Integer)this.oof.lHj.getTag(2131820638)).intValue();
      if (i == this.ong)
      {
        this.oof.lHj.setImageBitmap(l.a(this.val$bitmap, this.oof.ooc, this.oof.ood, this.oof.ooe));
        AppMethodBeat.o(42309);
        return;
      }
      ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss subtype: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ong) });
      AppMethodBeat.o(42309);
      return;
    }
    String str = (String)this.oof.lHj.getTag(2131820639);
    if ((!bo.isNullOrNil(this.val$url)) && (this.val$url.equals(str)))
    {
      this.oof.lHj.setImageBitmap(l.a(this.val$bitmap, this.oof.ooc, this.oof.ood, this.oof.ooe));
      AppMethodBeat.o(42309);
      return;
    }
    ab.w("MicroMsg.LuckyMoneyEnvelopeLogic", "pss url: %s, %s", new Object[] { str, this.val$url });
    AppMethodBeat.o(42309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.7.1
 * JD-Core Version:    0.7.0.1
 */