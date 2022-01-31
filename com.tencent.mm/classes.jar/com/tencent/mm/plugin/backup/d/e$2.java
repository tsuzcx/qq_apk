package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.e.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  implements f
{
  e$2(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17303);
    com.tencent.mm.plugin.backup.g.b.b(704, this.jCl.jCj);
    ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(paramString)));
      ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramInt2 == -100)
      {
        aw.Rc().a(1000, this.jCl.jCk);
        paramString = new a(this.jCl.jCd, this.jCl.jCe, b.aTr().jBb);
        aw.Rc().a(paramString, 0);
        AppMethodBeat.o(17303);
        return;
      }
      this.jCl.jyI.jyN = -11;
      this.jCl.jCh.l(-11, null);
      AppMethodBeat.o(17303);
      return;
    }
    paramString = (com.tencent.mm.plugin.backup.e.b)paramm;
    paramm = (gw)paramString.rr.fsW.fta;
    b.aTr().jyF = "";
    b.aTr().jyG = paramm.wtj;
    b.aTr().jyH = paramm.wtk;
    b.aTr().jBb = paramm.wtf;
    paramString = (gw)paramString.rr.fsW.fta;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      if (paramString != null)
      {
        this.jCl.jyI.jyN = 51;
        this.jCl.jCh.l(51, paramString);
      }
      AppMethodBeat.o(17303);
      return;
      if (paramString.wtg == null) {
        paramString = null;
      } else {
        paramString = paramString.wtg.getBufferToBytes();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e.2
 * JD-Core Version:    0.7.0.1
 */