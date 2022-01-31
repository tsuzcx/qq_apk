package com.tencent.mm.model;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Map;

public final class by
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    parama = parama.dBs;
    if (parama == null)
    {
      y.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
      return null;
    }
    int i;
    int j;
    try
    {
      parama = bn.s("<root>" + parama.svH + "</root>", "root");
      i = Integer.valueOf((String)parama.get(".root.newcount")).intValue();
      j = Integer.valueOf((String)parama.get(".root.version")).intValue();
      au.Hx();
      parama = c.Dz();
      if (j == bk.g((Integer)parama.get(12305, null)))
      {
        y.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
        return null;
      }
    }
    catch (Exception parama)
    {
      y.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[] { bk.j(parama) });
      return null;
    }
    parama.o(12304, Integer.valueOf(i));
    parama.o(12305, Integer.valueOf(j));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.by
 * JD-Core Version:    0.7.0.1
 */