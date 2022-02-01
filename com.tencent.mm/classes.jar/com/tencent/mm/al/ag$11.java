package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;

final class ag$11
  implements cj.a
{
  ag$11(ag paramag) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(212189);
    parama = parama.heO;
    if (parama == null)
    {
      Log.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
      AppMethodBeat.o(212189);
      return;
    }
    parama = z.a(parama.KHn);
    if (Util.isNullOrNil(parama))
    {
      Log.e("MicroMsg.SubCoreBiz", "msg content is null");
      AppMethodBeat.o(212189);
      return;
    }
    parama = XmlParser.parseXml(parama, "sysmsg", null);
    if ((parama == null) || (parama.size() <= 0))
    {
      Log.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
      AppMethodBeat.o(212189);
      return;
    }
    if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)parama.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
      AppMethodBeat.o(212189);
      return;
    }
    int i = Util.getInt((String)parama.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
    Log.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
    g.aAh().azQ().set(ar.a.NUP, Integer.valueOf(i));
    g.aAh().azQ().gBI();
    AppMethodBeat.o(212189);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.ag.11
 * JD-Core Version:    0.7.0.1
 */