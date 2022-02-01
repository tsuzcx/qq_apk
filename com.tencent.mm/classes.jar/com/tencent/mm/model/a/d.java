package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class d
  implements com.tencent.mm.ak.e
{
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(153093);
    parama = parama.gte;
    if ((parama == null) || (parama.FNI == null))
    {
      ae.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(153093);
      return null;
    }
    String str = z.a(parama.FNI);
    com.tencent.mm.kernel.g.ajR().ajA().set(328193, str);
    parama = g.aDh();
    long l = System.currentTimeMillis();
    try
    {
      parama.Ch(str);
      str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(328197, null);
      if ((bu.isNullOrNil(str)) || ((parama.hLx != null) && (!str.equals(parama.hLx.hLt))))
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(328197, parama.hLx.hLt);
        com.tencent.mm.kernel.g.ajR().ajA().set(328195, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajR().ajA().set(328194, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajR().ajA().set(328196, Boolean.FALSE);
        ae.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    ae.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.aDh().aDf()) {
      f.Cj(g.aDh().hLx.hLt);
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