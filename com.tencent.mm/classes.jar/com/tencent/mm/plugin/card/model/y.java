package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class y
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public y()
  {
    b.a locala = new b.a();
    locala.ecH = new ade();
    locala.ecI = new adf();
    locala.uri = "/cgi-bin/micromsg-bin/getcardcount";
    locala.ecG = 663;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (adf)this.dmK.ecF.ecN;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + paramq.tbE + " has_share_card:" + paramq.tbF);
      if (paramq.tbE > 0)
      {
        l.aDc();
        if (TextUtils.isEmpty((String)g.DP().Dz().get(ac.a.uoW, null)))
        {
          am.aAr();
          com.tencent.mm.plugin.card.b.b.oM(1);
        }
      }
      if (paramq.tbF > 0)
      {
        l.aDe();
        paramq = (Long)g.DP().Dz().get(ac.a.upg, Long.valueOf(0L));
        if ((paramq != null) && (paramq.longValue() == 0L)) {
          am.aAz().aAN();
        }
      }
    }
    g.DP().Dz().o(282882, Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 663;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.y
 * JD-Core Version:    0.7.0.1
 */