package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Map;

final class ag$9
  implements cd.a
{
  ag$9(ag paramag) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(124150);
    parama = parama.gqE;
    if (parama == null)
    {
      ad.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
      AppMethodBeat.o(124150);
      return;
    }
    parama = z.a(parama.Fvk);
    if (bt.isNullOrNil(parama))
    {
      ad.e("MicroMsg.SubCoreBiz", "msg content is null");
      AppMethodBeat.o(124150);
      return;
    }
    parama = bw.M(parama, "sysmsg");
    if ((parama == null) || (parama.size() <= 0))
    {
      ad.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
      AppMethodBeat.o(124150);
      return;
    }
    if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)parama.get(".sysmsg.$type")))
    {
      ad.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
      AppMethodBeat.o(124150);
      return;
    }
    int i = bt.getInt((String)parama.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
    ad.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
    g.ajC().ajl().set(al.a.Isq, Integer.valueOf(i));
    g.ajC().ajl().fqc();
    AppMethodBeat.o(124150);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.ag.9
 * JD-Core Version:    0.7.0.1
 */