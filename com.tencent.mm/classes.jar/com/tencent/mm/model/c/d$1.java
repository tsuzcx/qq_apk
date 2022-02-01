package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.b;

final class d$1
  implements cf.a
{
  d$1(d paramd) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(153124);
    parama = z.a(parama.gte.FNI);
    ae.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s".concat(String.valueOf(parama)));
    parama = a.Cs(parama);
    if (parama == null)
    {
      AppMethodBeat.o(153124);
      return;
    }
    d.aDI().B(parama.hMc, 1);
    d.aDJ().B(parama.hMd, 2);
    AppMethodBeat.o(153124);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c.d.1
 * JD-Core Version:    0.7.0.1
 */