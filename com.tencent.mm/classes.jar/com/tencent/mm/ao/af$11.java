package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;

final class af$11
  implements ck.a
{
  af$11(af paramaf) {}
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(205217);
    parama = parama.jQG;
    if (parama == null)
    {
      Log.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
      AppMethodBeat.o(205217);
      return;
    }
    parama = z.a(parama.RIF);
    if (Util.isNullOrNil(parama))
    {
      Log.e("MicroMsg.SubCoreBiz", "msg content is null");
      AppMethodBeat.o(205217);
      return;
    }
    parama = XmlParser.parseXml(parama, "sysmsg", null);
    if ((parama == null) || (parama.size() <= 0))
    {
      Log.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
      AppMethodBeat.o(205217);
      return;
    }
    if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String)parama.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
      AppMethodBeat.o(205217);
      return;
    }
    int i = Util.getInt((String)parama.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
    Log.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[] { Integer.valueOf(i) });
    h.aHG().aHp().set(ar.a.ViO, Integer.valueOf(i));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(205217);
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ao.af.11
 * JD-Core Version:    0.7.0.1
 */