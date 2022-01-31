package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.d;

final class b$1
  implements VoiceSearchLayout.a
{
  b$1(b paramb) {}
  
  public final void TK()
  {
    if ((a.bk(ae.getContext())) || (a.bi(ae.getContext()))) {}
    do
    {
      return;
      y.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
      h.nFQ.f(10453, new Object[] { Integer.valueOf(this.eNk.eNf), Integer.valueOf(3) });
    } while (this.eNk.eNh == null);
    this.eNk.eNh.TP();
  }
  
  public final void TL()
  {
    y.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
    h.nFQ.f(10453, new Object[] { Integer.valueOf(this.eNk.eNf), Integer.valueOf(4) });
    if (this.eNk.wep != null)
    {
      this.eNk.wep.setEditTextEnabled(true);
      this.eNk.wep.setStatusBtnEnabled(true);
    }
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong)
  {
    y.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if (this.eNk.eNh != null) {
      this.eNk.eNh.a(paramBoolean, paramArrayOfString, paramLong, this.eNk.eNg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b.1
 * JD-Core Version:    0.7.0.1
 */