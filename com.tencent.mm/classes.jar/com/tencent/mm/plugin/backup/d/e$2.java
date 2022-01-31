package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.e.a;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements f
{
  e$2(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.plugin.backup.g.b.b(704, this.hIL.hIJ);
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:" + paramString);
      y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramInt2 == -100)
      {
        au.Dk().a(1000, this.hIL.hIK);
        paramString = new a(this.hIL.hID, this.hIL.hIE, b.atS().hHF);
        au.Dk().a(paramString, 0);
      }
    }
    for (;;)
    {
      return;
      this.hIL.hFp.hFu = -11;
      this.hIL.hIH.l(-11, null);
      return;
      paramString = (com.tencent.mm.plugin.backup.e.b)paramm;
      paramm = (fn)paramString.dmK.ecF.ecN;
      b.atS().hFm = "";
      b.atS().hFn = paramm.szi;
      b.atS().hFo = paramm.szj;
      b.atS().hHF = paramm.szd;
      paramString = (fn)paramString.dmK.ecF.ecN;
      if (paramString == null) {
        paramString = null;
      }
      while (paramString != null)
      {
        this.hIL.hFp.hFu = 51;
        this.hIL.hIH.l(51, paramString);
        return;
        if (paramString.szf == null) {
          paramString = null;
        } else {
          paramString = paramString.szf.tFM.oY;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e.2
 * JD-Core Version:    0.7.0.1
 */