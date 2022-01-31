package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import java.util.Map;

final class z$9
  implements bz.a
{
  z$9(z paramz) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(11465);
    parama = parama.eyJ;
    if (parama == null)
    {
      ab.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
      AppMethodBeat.o(11465);
      return;
    }
    parama = aa.a(parama.woR);
    if (bo.isNullOrNil(parama))
    {
      ab.e("MicroMsg.SubCoreBiz", "msg content is null");
      AppMethodBeat.o(11465);
      return;
    }
    parama = br.F(parama, "sysmsg");
    if ((parama == null) || (parama.size() <= 0))
    {
      ab.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
      AppMethodBeat.o(11465);
      return;
    }
    if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)parama.get(".sysmsg.$type")))
    {
      ab.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
      AppMethodBeat.o(11465);
      return;
    }
    int i = bo.getInt((String)parama.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
    ab.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
    g.RL().Ru().set(ac.a.yzO, Integer.valueOf(i));
    g.RL().Ru().dww();
    AppMethodBeat.o(11465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.z.9
 * JD-Core Version:    0.7.0.1
 */