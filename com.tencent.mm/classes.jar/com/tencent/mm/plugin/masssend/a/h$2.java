package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class h$2
  implements bx.a
{
  h$2(h paramh) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    y.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:" + parama);
    h.bhe().GT(parama);
    h.bhe().bgZ();
    h.bhe();
    c.fc(bk.UY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.h.2
 * JD-Core Version:    0.7.0.1
 */