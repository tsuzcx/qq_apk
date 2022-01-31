package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.e.a;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.sdk.platformtools.y;

final class e$3
  implements f
{
  e$3(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.plugin.backup.g.b.b(1000, this.hIL.hIK);
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:" + paramString);
      this.hIL.hFp.hFu = -11;
      this.hIL.hIH.l(-11, null);
    }
    label191:
    label217:
    for (;;)
    {
      return;
      paramm = ((j.b)((a)paramm).edR.HF()).spD;
      if (paramm == null)
      {
        paramString = "null";
        y.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramString });
        if (paramm != null) {
          break label191;
        }
        paramString = null;
      }
      for (;;)
      {
        if (paramString == null) {
          break label217;
        }
        this.hIL.hFp.hFu = 51;
        this.hIL.hIH.l(51, paramString);
        return;
        paramString = paramm.szg;
        break;
        if (paramm.szf == null) {
          paramString = null;
        } else {
          paramString = paramm.szf.tFM.oY;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e.3
 * JD-Core Version:    0.7.0.1
 */