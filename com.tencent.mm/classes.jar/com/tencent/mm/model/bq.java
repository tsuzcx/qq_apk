package com.tencent.mm.model;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Map;
import junit.framework.Assert;

public final class bq
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    boolean bool2 = true;
    parama = parama.dBs;
    if (parama != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (parama.svH == null) {
        break label95;
      }
    }
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      parama = (String)bn.s(aa.a(parama.svH), "tips").get(".tips.tip.url");
      y.v("MicroMsg.SoftwareMsgExtension", "url:" + parama);
      au.Hx();
      c.Dz().o(12308, parama);
      return null;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bq
 * JD-Core Version:    0.7.0.1
 */