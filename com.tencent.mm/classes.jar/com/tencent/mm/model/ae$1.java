package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$1
  implements Runnable
{
  ae$1(hs paramhs) {}
  
  public final void run()
  {
    AppMethodBeat.i(134109);
    ad.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
    g.aiU().a(new af(this.hFK), 0);
    AppMethodBeat.o(134109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ae.1
 * JD-Core Version:    0.7.0.1
 */