package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;

final class af$2
  implements cl.a
{
  af$2(af paramaf) {}
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(239466);
    parama = parama.mpN;
    if (parama == null)
    {
      Log.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
      AppMethodBeat.o(239466);
      return;
    }
    parama = w.a(parama.YFG);
    if (Util.isNullOrNil(parama))
    {
      Log.e("MicroMsg.SubCoreBiz", "msg content is null");
      AppMethodBeat.o(239466);
      return;
    }
    parama = XmlParser.parseXml(parama, "sysmsg", null);
    if ((parama == null) || (parama.size() <= 0))
    {
      Log.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
      AppMethodBeat.o(239466);
      return;
    }
    if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)parama.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
      AppMethodBeat.o(239466);
      return;
    }
    int i = Util.getInt((String)parama.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
    Log.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
    h.baE().ban().set(at.a.acKi, Integer.valueOf(i));
    h.baE().ban().iZy();
    AppMethodBeat.o(239466);
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.af.2
 * JD-Core Version:    0.7.0.1
 */