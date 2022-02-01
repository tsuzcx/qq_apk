package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import java.util.Map;

public final class cg
  implements e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(20397);
    parama = parama.gte;
    if (parama == null)
    {
      ae.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(20397);
      return null;
    }
    try
    {
      parama = bx.M("<root>" + parama.FNI + "</root>", "root");
      int i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      int j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      bc.aCg();
      parama = c.ajA();
      if (j == bu.o((Integer)parama.get(12305, null)))
      {
        ae.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
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
        ae.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[] { bu.o(parama) });
      }
    }
    AppMethodBeat.o(20397);
    return null;
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cg
 * JD-Core Version:    0.7.0.1
 */