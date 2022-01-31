package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;

final class e$1
  extends bj<e.a>
{
  e$1(e parame, e.a parama, d.b paramb)
  {
    super(5000L, parama);
  }
  
  private e.a btR()
  {
    AppMethodBeat.i(20418);
    try
    {
      ab.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
      if (this.mfl != null)
      {
        ox localox = new ox();
        localox.cFC.width = this.mfl.arz;
        localox.cFC.height = this.mfl.arA;
        localox.cFC.cFE = this.mfl.mfj;
        localox.cFC.rotate = this.mfl.rotate;
        localox.cFC.cFD = this.mfl.cFD;
        localox.cFC.cFF = new e.1.1(this);
        a.ymk.l(localox);
      }
      for (;;)
      {
        AppMethodBeat.o(20418);
        return null;
        ab.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
        cv(null);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ExtQrCodeHandler", localException, "hy: error when syncTaskScanQrCode", new Object[0]);
        cv(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.1
 * JD-Core Version:    0.7.0.1
 */