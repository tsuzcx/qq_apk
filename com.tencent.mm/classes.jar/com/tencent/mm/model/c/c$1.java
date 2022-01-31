package com.tencent.mm.model.c;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.b;
import com.tencent.mm.storage.d;

final class c$1
  implements bx.a
{
  c$1(c paramc) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    y.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s" + parama);
    parama = a.jj(parama);
    if (parama == null) {
      return;
    }
    c.IX().k(parama.items, 1);
    c.IY().k(parama.dYN, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c.c.1
 * JD-Core Version:    0.7.0.1
 */