package com.tencent.mm.modelstat;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class c$4
  implements f
{
  c$4(c paramc, a parama, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm.getType() != 1126) || (paramInt1 != 0) || (paramInt2 != 0)) {
      return;
    }
    paramString = (afm)((j)paramm).eDB.ecF.ecN;
    if (paramString == null)
    {
      y.e("MicroMsg.ClickFlowStatReceiver", "NetSceneUpdateEventConfig onSceneEnd resp is null");
      return;
    }
    c.b(this.eCm).post(new c.4.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.4
 * JD-Core Version:    0.7.0.1
 */