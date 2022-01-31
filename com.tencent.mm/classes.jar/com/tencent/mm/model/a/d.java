package com.tencent.mm.model.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class d
  implements com.tencent.mm.ah.e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    parama = parama.dBs;
    if ((parama == null) || (parama.svH == null)) {
      y.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
    }
    do
    {
      return null;
      String str = aa.a(parama.svH);
      com.tencent.mm.kernel.g.DP().Dz().o(328193, str);
      parama = g.Iy();
      long l = System.currentTimeMillis();
      try
      {
        parama.iY(str);
        str = (String)com.tencent.mm.kernel.g.DP().Dz().get(328197, null);
        if ((bk.bl(str)) || ((parama.dYf != null) && (!str.equals(parama.dYf.dYb))))
        {
          com.tencent.mm.kernel.g.DP().Dz().o(328197, parama.dYf.dYb);
          com.tencent.mm.kernel.g.DP().Dz().o(328195, Boolean.valueOf(false));
          com.tencent.mm.kernel.g.DP().Dz().o(328194, Boolean.valueOf(false));
          com.tencent.mm.kernel.g.DP().Dz().o(328196, Boolean.valueOf(false));
          y.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          y.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
        }
      }
      y.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    } while (!g.Iy().Iw());
    f.ja(g.Iy().dYf.dYb);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */