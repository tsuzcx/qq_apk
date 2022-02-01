package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;

final class m$2
  implements com.tencent.mm.aw.a.c.h
{
  m$2(m paramm, String paramString1, String paramString2, m.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(174317);
    ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramb.status), Integer.valueOf(paramb.from) });
    if (paramb.status == 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.dB(991, 6);
      com.tencent.mm.plugin.report.service.h.vKh.f(18888, new Object[] { Integer.valueOf(1), this.tdN, paramString });
      if (paramb.data != null)
      {
        paramView = ai.D(paramb.data);
        if ((!bt.isNullOrNil(this.kzy)) && (!paramView.equals(this.kzy)))
        {
          ad.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramView, this.kzy });
          com.tencent.mm.plugin.report.service.h.vKh.dB(991, 8);
          com.tencent.mm.plugin.report.service.h.vKh.f(16543, new Object[] { paramString, this.kzy, paramView });
        }
      }
    }
    for (;;)
    {
      if (this.tdO != null) {
        this.tdO.b(paramb.bitmap, paramb.from, paramString);
      }
      AppMethodBeat.o(174317);
      return;
      if (paramb.status == 1)
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(991, 7);
        com.tencent.mm.plugin.report.service.h.vKh.f(18888, new Object[] { Integer.valueOf(2), this.tdN, paramString });
      }
      else if (paramb.status == 2)
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(991, 8);
        com.tencent.mm.plugin.report.service.h.vKh.f(18888, new Object[] { Integer.valueOf(2), this.tdN, paramString });
      }
      else if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(991, 9);
        com.tencent.mm.plugin.report.service.h.vKh.f(18888, new Object[] { Integer.valueOf(2), this.tdN, paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.m.2
 * JD-Core Version:    0.7.0.1
 */