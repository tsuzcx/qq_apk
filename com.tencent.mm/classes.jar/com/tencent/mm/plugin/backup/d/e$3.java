package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.e.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ab;

final class e$3
  implements f
{
  e$3(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17304);
    b.b(1000, this.jCl.jCk);
    ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramString)));
      this.jCl.jyI.jyN = -11;
      this.jCl.jCh.l(-11, null);
      AppMethodBeat.o(17304);
      return;
    }
    paramm = ((k.b)((a)paramm).ftU.getRespObj()).wit;
    if (paramm == null)
    {
      paramString = "null";
      ab.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramString });
      if (paramm != null) {
        break label202;
      }
      paramString = null;
    }
    for (;;)
    {
      if (paramString != null)
      {
        this.jCl.jyI.jyN = 51;
        this.jCl.jCh.l(51, paramString);
      }
      AppMethodBeat.o(17304);
      return;
      paramString = paramm.wth;
      break;
      label202:
      if (paramm.wtg == null) {
        paramString = null;
      } else {
        paramString = paramm.wtg.getBufferToBytes();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e.3
 * JD-Core Version:    0.7.0.1
 */