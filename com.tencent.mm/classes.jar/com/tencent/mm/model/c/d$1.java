package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.b;

final class d$1
  implements cc.a
{
  d$1(d paramd) {}
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(153124);
    parama = z.a(parama.fXi.DPV);
    ac.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s".concat(String.valueOf(parama)));
    parama = a.yR(parama);
    if (parama == null)
    {
      AppMethodBeat.o(153124);
      return;
    }
    d.aAp().y(parama.hqR, 1);
    d.aAq().y(parama.hqS, 2);
    AppMethodBeat.o(153124);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c.d.1
 * JD-Core Version:    0.7.0.1
 */