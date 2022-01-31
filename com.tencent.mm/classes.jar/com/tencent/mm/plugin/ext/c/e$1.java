package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.h.a.nw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  extends bf<e.a>
{
  e$1(e parame, e.a parama, d.b paramb)
  {
    super(5000L, parama);
  }
  
  private e.a aNO()
  {
    try
    {
      y.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
      if (this.jLh != null)
      {
        nw localnw = new nw();
        localnw.bXD.width = this.jLh.apf;
        localnw.bXD.height = this.jLh.apg;
        localnw.bXD.bXF = this.jLh.jLf;
        localnw.bXD.rotate = this.jLh.rotate;
        localnw.bXD.bXE = this.jLh.bXE;
        localnw.bXD.bXG = new e.1.1(this);
        a.udP.m(localnw);
        return null;
      }
      y.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
      bS(null);
      return null;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.ExtQrCodeHandler", localException, "hy: error when syncTaskScanQrCode", new Object[0]);
      bS(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.e.1
 * JD-Core Version:    0.7.0.1
 */