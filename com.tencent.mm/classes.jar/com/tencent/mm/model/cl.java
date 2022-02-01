package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.Map;

public final class cl
  implements h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(20397);
    parama = parama.jQG;
    if (parama == null)
    {
      Log.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(20397);
      return null;
    }
    try
    {
      parama = XmlParser.parseXml("<root>" + parama.RIF + "</root>", "root", null);
      int i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      int j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      bh.beI();
      parama = c.aHp();
      if (j == Util.nullAsNil((Integer)parama.b(12305, null)))
      {
        Log.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
        AppMethodBeat.o(20397);
        return null;
      }
      parama.i(12304, Integer.valueOf(i));
      parama.i(12305, Integer.valueOf(j));
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
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cl
 * JD-Core Version:    0.7.0.1
 */