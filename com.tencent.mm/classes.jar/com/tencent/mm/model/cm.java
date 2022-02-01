package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import java.util.Map;

public final class cm
  implements g
{
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(20397);
    parama = parama.mpN;
    if (parama == null)
    {
      Log.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(20397);
      return null;
    }
    try
    {
      parama = XmlParser.parseXml("<root>" + parama.YFG + "</root>", "root", null);
      int i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      int j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      bh.bCz();
      parama = c.ban();
      if (j == Util.nullAsNil((Integer)parama.d(12305, null)))
      {
        Log.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
        AppMethodBeat.o(20397);
        return null;
      }
      parama.B(12304, Integer.valueOf(i));
      parama.B(12305, Integer.valueOf(j));
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[] { Util.stackTraceToString(parama) });
      }
    }
    AppMethodBeat.o(20397);
    return null;
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cm
 * JD-Core Version:    0.7.0.1
 */