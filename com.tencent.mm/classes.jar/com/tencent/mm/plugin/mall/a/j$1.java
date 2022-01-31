package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class j$1
  implements bz.a
{
  j$1(j paramj) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(43117);
    parama = aa.a(parama.eyJ.woR);
    ab.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:".concat(String.valueOf(parama)));
    j.a(this.oya).post(new j.1.1(this, parama));
    AppMethodBeat.o(43117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j.1
 * JD-Core Version:    0.7.0.1
 */