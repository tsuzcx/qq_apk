package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Map;

final class ag$9
  implements cf.a
{
  ag$9(ag paramag) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(124150);
    parama = parama.gte;
    if (parama == null)
    {
      ae.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
      AppMethodBeat.o(124150);
      return;
    }
    parama = z.a(parama.FNI);
    if (bu.isNullOrNil(parama))
    {
      ae.e("MicroMsg.SubCoreBiz", "msg content is null");
      AppMethodBeat.o(124150);
      return;
    }
    parama = bx.M(parama, "sysmsg");
    if ((parama == null) || (parama.size() <= 0))
    {
      ae.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
      AppMethodBeat.o(124150);
      return;
    }
    if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)parama.get(".sysmsg.$type")))
    {
      ae.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
      AppMethodBeat.o(124150);
      return;
    }
    int i = bu.getInt((String)parama.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
    ae.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
    g.ajR().ajA().set(am.a.IMM, Integer.valueOf(i));
    g.ajR().ajA().fuc();
    AppMethodBeat.o(124150);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.ag.9
 * JD-Core Version:    0.7.0.1
 */