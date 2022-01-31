package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.tools.d;

final class b$1
  implements VoiceSearchLayout.a
{
  b$1(b paramb) {}
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong)
  {
    AppMethodBeat.i(116787);
    ab.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if (this.gcP.gcM != null) {
      this.gcP.gcM.a(paramBoolean, paramArrayOfString, paramLong, this.gcP.gcL);
    }
    AppMethodBeat.o(116787);
  }
  
  public final void amX()
  {
    AppMethodBeat.i(116785);
    if ((a.bO(ah.getContext())) || (a.bM(ah.getContext())))
    {
      AppMethodBeat.o(116785);
      return;
    }
    ab.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
    h.qsU.e(10453, new Object[] { Integer.valueOf(this.gcP.gcK), Integer.valueOf(3) });
    if (this.gcP.gcM != null) {
      this.gcP.gcM.anc();
    }
    AppMethodBeat.o(116785);
  }
  
  public final void amY()
  {
    AppMethodBeat.i(116786);
    ab.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
    h.qsU.e(10453, new Object[] { Integer.valueOf(this.gcP.gcK), Integer.valueOf(4) });
    if (this.gcP.Axf != null)
    {
      this.gcP.Axf.setEditTextEnabled(true);
      this.gcP.Axf.setStatusBtnEnabled(true);
    }
    AppMethodBeat.o(116786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.b.1
 * JD-Core Version:    0.7.0.1
 */