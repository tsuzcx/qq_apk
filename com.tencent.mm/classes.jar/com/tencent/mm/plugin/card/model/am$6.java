package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class am$6
  implements bz.a
{
  am$6(am paramam) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(87939);
    String str = aa.a(parama.eyJ.woR);
    if ((str == null) || (str.length() == 0))
    {
      ab.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
      AppMethodBeat.o(87939);
      return;
    }
    am.a(this.kpm).post(new am.6.1(this, str, parama));
    AppMethodBeat.o(87939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.6
 * JD-Core Version:    0.7.0.1
 */