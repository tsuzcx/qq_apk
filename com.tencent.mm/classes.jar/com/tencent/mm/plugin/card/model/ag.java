package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.sdk.platformtools.y;

public final class ag
  extends m
  implements k
{
  public String bXl;
  public String content;
  private final b dmK;
  private f dmL;
  public String fNR;
  public boolean hkG;
  public String inJ;
  public String inK;
  public String inL;
  public String inM;
  public String inN;
  public String inO;
  public int status;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bfe();
    ((b.a)localObject).ecI = new bff();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((b.a)localObject).ecG = 1171;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bfe)this.dmK.ecE.ecN;
    ((bfe)localObject).sth = paramInt;
    ((bfe)localObject).sti = paramString1;
    ((bfe)localObject).stj = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bff)this.dmK.ecF.ecN;
      this.bXl = paramq.stm;
      this.inJ = paramq.stn;
      this.status = paramq.status;
      this.content = paramq.content;
      this.inK = paramq.imZ;
      this.fNR = paramq.tzQ;
      this.hkG = paramq.hkG;
      this.inL = paramq.tzR;
      this.inM = paramq.tzS;
      this.inN = paramq.tzT;
      this.inO = paramq.tzU;
      y.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.bXl, this.inJ, Integer.valueOf(this.status), this.content, this.inK, this.fNR, Boolean.valueOf(this.hkG) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1171;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */