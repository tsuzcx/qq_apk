package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;

final class l$3
  implements g
{
  l$3(l paraml, String paramString, l.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(42302);
    ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramb.status), Integer.valueOf(paramb.from) });
    if (paramb.status == 0)
    {
      h.qsU.cT(991, 6);
      if (paramb.data != null)
      {
        paramView = ag.v(paramb.data);
        if ((!bo.isNullOrNil(this.iiy)) && (!paramView.equals(this.iiy)))
        {
          ab.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramView, this.iiy });
          h.qsU.cT(991, 8);
          h.qsU.e(16543, new Object[] { paramString, this.iiy, paramView });
        }
      }
    }
    for (;;)
    {
      if (this.onX != null) {
        this.onX.a(paramb.bitmap, 0, paramString);
      }
      AppMethodBeat.o(42302);
      return;
      if (paramb.status == 1) {
        h.qsU.cT(991, 7);
      } else if (paramb.status == 2) {
        h.qsU.cT(991, 8);
      } else if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        h.qsU.cT(991, 9);
      }
    }
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l.3
 * JD-Core Version:    0.7.0.1
 */