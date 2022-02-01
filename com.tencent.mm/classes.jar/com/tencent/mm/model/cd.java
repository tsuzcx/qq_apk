package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import java.util.Map;

public final class cd
  implements f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(20397);
    parama = parama.fXi;
    if (parama == null)
    {
      ac.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(20397);
      return null;
    }
    try
    {
      parama = bv.L("<root>" + parama.DPV + "</root>", "root");
      int i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      int j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      az.ayM();
      parama = c.agA();
      if (j == bs.m((Integer)parama.get(12305, null)))
      {
        ac.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
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
        ac.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[] { bs.m(parama) });
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