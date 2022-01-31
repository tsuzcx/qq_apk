package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class am$5
  implements bx.a
{
  am$5(am paramam) {}
  
  public final void a(e.a parama)
  {
    String str = aa.a(parama.dBs.svH);
    if ((str == null) || (str.length() == 0))
    {
      y.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
      return;
    }
    am.a(this.ior).post(new am.5.1(this, str, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.5
 * JD-Core Version:    0.7.0.1
 */