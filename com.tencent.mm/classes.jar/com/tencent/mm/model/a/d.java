package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class d
  implements com.tencent.mm.al.f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(153093);
    parama = parama.fTo;
    if ((parama == null) || (parama.Cxz == null))
    {
      ad.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(153093);
      return null;
    }
    String str = z.a(parama.Cxz);
    com.tencent.mm.kernel.g.afB().afk().set(328193, str);
    parama = g.asX();
    long l = System.currentTimeMillis();
    try
    {
      parama.uA(str);
      str = (String)com.tencent.mm.kernel.g.afB().afk().get(328197, null);
      if ((bt.isNullOrNil(str)) || ((parama.gPM != null) && (!str.equals(parama.gPM.gPI))))
      {
        com.tencent.mm.kernel.g.afB().afk().set(328197, parama.gPM.gPI);
        com.tencent.mm.kernel.g.afB().afk().set(328195, Boolean.FALSE);
        com.tencent.mm.kernel.g.afB().afk().set(328194, Boolean.FALSE);
        com.tencent.mm.kernel.g.afB().afk().set(328196, Boolean.FALSE);
        ad.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    ad.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.asX().asV()) {
      f.uC(g.asX().gPM.gPI);
    }
    AppMethodBeat.o(153093);
    return null;
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */