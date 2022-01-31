package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$2
  implements bz.a
{
  h$2(h paramh) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(22744);
    parama = aa.a(parama.eyJ.woR);
    ab.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:".concat(String.valueOf(parama)));
    h.bPd().SD(parama);
    h.bPd().bOY();
    h.bPd();
    c.kA(bo.aoy());
    AppMethodBeat.o(22744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h.2
 * JD-Core Version:    0.7.0.1
 */