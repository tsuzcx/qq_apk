package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

final class am$6
  implements cc.a
{
  am$6(am paramam) {}
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(112878);
    String str = z.a(parama.fTo.Cxz);
    if ((str == null) || (str.length() == 0))
    {
      ad.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
      AppMethodBeat.o(112878);
      return;
    }
    am.a(this.nuz).post(new am.6.1(this, str, parama));
    AppMethodBeat.o(112878);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.6
 * JD-Core Version:    0.7.0.1
 */