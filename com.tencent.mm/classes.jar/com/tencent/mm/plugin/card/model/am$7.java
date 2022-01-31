package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class am$7
  implements bz.a
{
  am$7(am paramam) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(87941);
    String str = aa.a(parama.eyJ.woR);
    if ((str == null) || (str.length() == 0))
    {
      ab.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
      AppMethodBeat.o(87941);
      return;
    }
    am.a(this.kpm).post(new am.7.1(this, str, parama));
    AppMethodBeat.o(87941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.7
 * JD-Core Version:    0.7.0.1
 */