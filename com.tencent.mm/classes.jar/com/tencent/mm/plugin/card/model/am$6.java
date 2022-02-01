package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class am$6
  implements ck.a
{
  am$6(am paramam) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(112878);
    String str = z.a(parama.jQG.RIF);
    if ((str == null) || (str.length() == 0))
    {
      Log.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
      AppMethodBeat.o(112878);
      return;
    }
    am.a(this.trc).post(new am.6.1(this, str, parama));
    AppMethodBeat.o(112878);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.6
 * JD-Core Version:    0.7.0.1
 */