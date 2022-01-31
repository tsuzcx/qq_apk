package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.t;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.protocal.c.md;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class v
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String inw;
  public ArrayList<mb> inx;
  
  public v(String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    this.inw = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new mc();
    ((b.a)localObject).ecI = new md();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardshoplbs";
    ((b.a)localObject).ecG = 563;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (mc)this.dmK.ecE.ecN;
    ((mc)localObject).iln = paramString1;
    ((mc)localObject).bTc = paramFloat1;
    ((mc)localObject).bRt = paramFloat2;
    ((mc)localObject).bZc = paramString2;
    y.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[] { paramString1, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    if (bk.bl(((mc)this.dmK.ecE.ecN).iln))
    {
      y.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
      return -1;
    }
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((md)this.dmK.ecF.ecN).inn;
      if (TextUtils.isEmpty(paramq)) {
        y.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
      }
      this.inx = t.ze(paramq);
      if (this.inx != null) {
        y.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[] { Integer.valueOf(this.inx.size()) });
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.v
 * JD-Core Version:    0.7.0.1
 */