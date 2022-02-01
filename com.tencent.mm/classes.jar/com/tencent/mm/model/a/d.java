package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class d
  implements com.tencent.mm.al.e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(153093);
    parama = parama.gqE;
    if ((parama == null) || (parama.Fvk == null))
    {
      ad.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(153093);
      return null;
    }
    String str = z.a(parama.Fvk);
    com.tencent.mm.kernel.g.ajC().ajl().set(328193, str);
    parama = g.aCR();
    long l = System.currentTimeMillis();
    try
    {
      parama.BF(str);
      str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(328197, null);
      if ((bt.isNullOrNil(str)) || ((parama.hIE != null) && (!str.equals(parama.hIE.hIA))))
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(328197, parama.hIE.hIA);
        com.tencent.mm.kernel.g.ajC().ajl().set(328195, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajC().ajl().set(328194, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajC().ajl().set(328196, Boolean.FALSE);
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
    if (g.aCR().aCP()) {
      f.BH(g.aCR().hIE.hIA);
    }
    AppMethodBeat.o(153093);
    return null;
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */