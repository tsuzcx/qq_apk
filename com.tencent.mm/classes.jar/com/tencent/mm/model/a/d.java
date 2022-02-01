package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class d
  implements com.tencent.mm.ak.f
{
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(153093);
    parama = parama.fXi;
    if ((parama == null) || (parama.DPV == null))
    {
      ac.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(153093);
      return null;
    }
    String str = z.a(parama.DPV);
    com.tencent.mm.kernel.g.agR().agA().set(328193, str);
    parama = g.azO();
    long l = System.currentTimeMillis();
    try
    {
      parama.yG(str);
      str = (String)com.tencent.mm.kernel.g.agR().agA().get(328197, null);
      if ((bs.isNullOrNil(str)) || ((parama.hqm != null) && (!str.equals(parama.hqm.hqi))))
      {
        com.tencent.mm.kernel.g.agR().agA().set(328197, parama.hqm.hqi);
        com.tencent.mm.kernel.g.agR().agA().set(328195, Boolean.FALSE);
        com.tencent.mm.kernel.g.agR().agA().set(328194, Boolean.FALSE);
        com.tencent.mm.kernel.g.agR().agA().set(328196, Boolean.FALSE);
        ac.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ac.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    ac.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.azO().azM()) {
      f.yI(g.azO().hqm.hqi);
    }
    AppMethodBeat.o(153093);
    return null;
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */