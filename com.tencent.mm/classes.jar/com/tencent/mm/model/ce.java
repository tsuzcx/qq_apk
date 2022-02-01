package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import java.util.Map;

public final class ce
  implements e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(20397);
    parama = parama.gqE;
    if (parama == null)
    {
      ad.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(20397);
      return null;
    }
    try
    {
      parama = bw.M("<root>" + parama.Fvk + "</root>", "root");
      int i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      int j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      ba.aBQ();
      parama = c.ajl();
      if (j == bt.n((Integer)parama.get(12305, null)))
      {
        ad.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
        AppMethodBeat.o(20397);
        return null;
      }
      parama.set(12304, Integer.valueOf(i));
      parama.set(12305, Integer.valueOf(j));
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[] { bt.n(parama) });
      }
    }
    AppMethodBeat.o(20397);
    return null;
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ce
 * JD-Core Version:    0.7.0.1
 */