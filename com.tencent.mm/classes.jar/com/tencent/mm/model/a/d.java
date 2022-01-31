package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class d
  implements com.tencent.mm.ai.e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(118144);
    parama = parama.eyJ;
    if ((parama == null) || (parama.woR == null))
    {
      ab.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(118144);
      return null;
    }
    String str = aa.a(parama.woR);
    com.tencent.mm.kernel.g.RL().Ru().set(328193, str);
    parama = g.abw();
    long l = System.currentTimeMillis();
    try
    {
      parama.pM(str);
      str = (String)com.tencent.mm.kernel.g.RL().Ru().get(328197, null);
      if ((bo.isNullOrNil(str)) || ((parama.foj != null) && (!str.equals(parama.foj.fof))))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(328197, parama.foj.fof);
        com.tencent.mm.kernel.g.RL().Ru().set(328195, Boolean.FALSE);
        com.tencent.mm.kernel.g.RL().Ru().set(328194, Boolean.FALSE);
        com.tencent.mm.kernel.g.RL().Ru().set(328196, Boolean.FALSE);
        ab.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ab.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    ab.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.abw().abu()) {
      f.pO(g.abw().foj.fof);
    }
    AppMethodBeat.o(118144);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */