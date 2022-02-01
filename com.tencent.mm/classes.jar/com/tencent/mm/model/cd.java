package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import java.util.Map;

public final class cd
  implements f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(20397);
    parama = parama.fTo;
    if (parama == null)
    {
      ad.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(20397);
      return null;
    }
    try
    {
      parama = bw.K("<root>" + parama.Cxz + "</root>", "root");
      int i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      int j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      az.arV();
      parama = c.afk();
      if (j == bt.l((Integer)parama.get(12305, null)))
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
        ad.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[] { bt.m(parama) });
      }
    }
    AppMethodBeat.o(20397);
    return null;
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cd
 * JD-Core Version:    0.7.0.1
 */