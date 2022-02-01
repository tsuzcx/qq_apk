package com.tencent.mm.plugin.luckymoney.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;

final class r$2
  implements com.tencent.mm.ay.a.c.h
{
  r$2(r paramr, String paramString1, String paramString2, r.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(174317);
    Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "load finish url: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramb.status), Integer.valueOf(paramb.from) });
    if (paramb.status == 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(991, 6);
      com.tencent.mm.plugin.report.service.h.IzE.a(18888, new Object[] { Integer.valueOf(1), this.EzL, paramString });
      if (paramb.data != null)
      {
        paramView = MD5Util.getMD5String(paramb.data);
        if ((!Util.isNullOrNil(this.lQU)) && (!paramView.equals(this.lQU)))
        {
          Log.i("MicroMsg.LuckyMoneyEnvelopeLogic", "md5 not match: %s, %s", new Object[] { paramView, this.lQU });
          com.tencent.mm.plugin.report.service.h.IzE.el(991, 8);
          com.tencent.mm.plugin.report.service.h.IzE.a(16543, new Object[] { paramString, this.lQU, paramView });
        }
      }
    }
    for (;;)
    {
      if (this.EzM != null) {
        this.EzM.b(paramb.bitmap, paramb.from, paramString);
      }
      AppMethodBeat.o(174317);
      return;
      if (paramb.status == 1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(991, 7);
        com.tencent.mm.plugin.report.service.h.IzE.a(18888, new Object[] { Integer.valueOf(2), this.EzL, paramString });
      }
      else if (paramb.status == 2)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(991, 8);
        com.tencent.mm.plugin.report.service.h.IzE.a(18888, new Object[] { Integer.valueOf(2), this.EzL, paramString });
      }
      else if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(991, 9);
        com.tencent.mm.plugin.report.service.h.IzE.a(18888, new Object[] { Integer.valueOf(2), this.EzL, paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.r.2
 * JD-Core Version:    0.7.0.1
 */