package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Map;

final class af$9
  implements cc.a
{
  af$9(af paramaf) {}
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(124150);
    parama = parama.fXi;
    if (parama == null)
    {
      ac.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
      AppMethodBeat.o(124150);
      return;
    }
    parama = z.a(parama.DPV);
    if (bs.isNullOrNil(parama))
    {
      ac.e("MicroMsg.SubCoreBiz", "msg content is null");
      AppMethodBeat.o(124150);
      return;
    }
    parama = bv.L(parama, "sysmsg");
    if ((parama == null) || (parama.size() <= 0))
    {
      ac.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
      AppMethodBeat.o(124150);
      return;
    }
    if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)parama.get(".sysmsg.$type")))
    {
      ac.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
      AppMethodBeat.o(124150);
      return;
    }
    int i = bs.getInt((String)parama.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
    ac.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
    g.agR().agA().set(ah.a.GFY, Integer.valueOf(i));
    g.agR().agA().faa();
    AppMethodBeat.o(124150);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.af.9
 * JD-Core Version:    0.7.0.1
 */