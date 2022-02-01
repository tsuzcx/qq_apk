package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class d
  implements com.tencent.mm.an.h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(153093);
    parama = parama.jQG;
    if ((parama == null) || (parama.RIF == null))
    {
      Log.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(153093);
      return null;
    }
    String str = z.a(parama.RIF);
    com.tencent.mm.kernel.h.aHG().aHp().i(328193, str);
    parama = g.bga();
    long l = System.currentTimeMillis();
    try
    {
      parama.Sl(str);
      str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(328197, null);
      if ((Util.isNullOrNil(str)) || ((parama.lwB != null) && (!str.equals(parama.lwB.lwy))))
      {
        com.tencent.mm.kernel.h.aHG().aHp().i(328197, parama.lwB.lwy);
        com.tencent.mm.kernel.h.aHG().aHp().i(328195, Boolean.FALSE);
        com.tencent.mm.kernel.h.aHG().aHp().i(328194, Boolean.FALSE);
        com.tencent.mm.kernel.h.aHG().aHp().i(328196, Boolean.FALSE);
        Log.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.bga().bfY()) {
      f.Sn(g.bga().lwB.lwy);
    }
    AppMethodBeat.o(153093);
    return null;
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */