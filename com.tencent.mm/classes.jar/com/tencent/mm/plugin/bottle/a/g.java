package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.protocal.c.bxj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  int hYm = 0;
  private com.tencent.mm.modelvoice.b hYp;
  int msgType = -1;
  
  public g(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bxi();
    ((b.a)localObject).ecI = new bxj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/throwbottle";
    ((b.a)localObject).ecG = 154;
    ((b.a)localObject).ecJ = 53;
    ((b.a)localObject).ecK = 1000000053;
    this.dmK = ((b.a)localObject).Kt();
    if (!bk.bl(paramString))
    {
      this.msgType = 1;
      localObject = (bxi)this.dmK.ecE.ecN;
      ((bxi)localObject).tzA = 0;
      ((bxi)localObject).kSW = this.msgType;
      ((bxi)localObject).ndg = 0;
      ((bxi)localObject).ndf = paramString.getBytes().length;
      ((bxi)localObject).sRf = 0;
      ((bxi)localObject).sPG = aa.I(paramString.getBytes());
      ((bxi)localObject).trv = com.tencent.mm.a.g.o((paramString + bk.UY()).getBytes());
    }
  }
  
  public g(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bxi();
    ((b.a)localObject).ecI = new bxj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/throwbottle";
    ((b.a)localObject).ecG = 154;
    ((b.a)localObject).ecJ = 53;
    ((b.a)localObject).ecK = 1000000053;
    this.dmK = ((b.a)localObject).Kt();
    if ((!bk.bl(paramString)) && (paramInt > 0))
    {
      this.msgType = 3;
      localObject = (bxi)this.dmK.ecE.ecN;
      ((bxi)localObject).sRf = paramInt;
      ((bxi)localObject).trv = paramString;
      ((bxi)localObject).tzA = 0;
      ((bxi)localObject).kSW = this.msgType;
    }
  }
  
  private int oi(int paramInt)
  {
    a locala = new a();
    locala.msgType = paramInt;
    Object localObject = (bxi)this.dmK.ecE.ecN;
    bxj localbxj = (bxj)this.dmK.ecF.ecN;
    locala.hYe = localbxj.tNn.size();
    locala.hYg = 1;
    if (paramInt == 3)
    {
      locala.content = ((bxi)localObject).trv;
      locala.hYh = ((bxi)localObject).sRf;
    }
    for (;;)
    {
      localObject = "";
      paramInt = 0;
      while (paramInt < localbxj.tNn.size())
      {
        localObject = (String)localObject + localbxj.tNn.get(paramInt);
        paramInt += 1;
      }
      locala.content = new String(aa.a(((bxi)localObject).sPG));
    }
    locala.hYd = com.tencent.mm.a.g.o(((String)localObject).getBytes());
    locala.hYi = bk.UY();
    paramInt = 0;
    while (paramInt < localbxj.tNn.size())
    {
      localObject = c.xN(aa.a((bml)localbxj.tNn.get(paramInt)));
      if (!bk.bl((String)localObject))
      {
        locala.hYf = ((String)localObject);
        i.awN().a(locala);
      }
      paramInt += 1;
    }
    return 0;
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    if (this.msgType == 1) {
      this.msgType = (0 - this.msgType);
    }
    for (;;)
    {
      return a(parame, this.dmK, this);
      if (this.msgType != 3) {
        break;
      }
      paramf = (bxi)this.dmK.ecE.ecN;
      paramf.kSW = 3;
      paramf.tzA = 0;
      if (this.hYp == null)
      {
        this.hYp = com.tencent.mm.modelvoice.q.ox(paramf.trv);
        this.hYm = 0;
        paramf.ndf = o.nU(paramf.trv);
      }
      com.tencent.mm.modelvoice.g localg = this.hYp.bz(this.hYm, 6000);
      y.d("MicroMsg.NetSceneThrowBottle", "doScene READ file[" + paramf.trv + "] read ret:" + localg.ret + " readlen:" + localg.bDu + " newOff:" + localg.eIh + " netOff:" + this.hYm + " line:" + com.tencent.mm.compatible.util.g.getLine());
      if ((localg.ret < 0) || (localg.bDu == 0))
      {
        y.e("MicroMsg.NetSceneThrowBottle", "Err doScene READ file[" + paramf.trv + "] read ret:" + localg.ret + " readlen:" + localg.bDu + " newOff:" + localg.eIh + " netOff:" + this.hYm);
        com.tencent.mm.modelvoice.q.oy(paramf.trv);
        return -1;
      }
      byte[] arrayOfByte = new byte[localg.bDu];
      System.arraycopy(localg.buf, 0, arrayOfByte, 0, localg.bDu);
      paramf.sPG = aa.I(arrayOfByte);
      paramf.ndg = this.hYm;
    }
    y.e("MicroMsg.NetSceneThrowBottle", "doScene Error Msg type: " + this.msgType);
    return -1;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneThrowBottle", "onGYNetEnd errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bxi)this.dmK.ecE.ecN;
    paramArrayOfByte = (bxj)this.dmK.ecF.ecN;
    if (paramInt2 == 4) {
      switch (paramInt3)
      {
      default: 
        c.og(paramArrayOfByte.tbz);
        c.of(paramArrayOfByte.tby);
      }
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.d("MicroMsg.NetSceneThrowBottle", "ERR: onGYNetEnd errtype:" + paramInt2 + " errCode:" + paramInt3);
      com.tencent.mm.modelvoice.q.oy(paramq.trv);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      y.d("MicroMsg.NetSceneThrowBottle", "getStartPos " + paramArrayOfByte.ndg);
      y.d("MicroMsg.NetSceneThrowBottle", "getTotalLen " + paramArrayOfByte.ndf);
      y.d("MicroMsg.NetSceneThrowBottle", "getThrowCount " + paramArrayOfByte.tby);
      y.d("MicroMsg.NetSceneThrowBottle", "getPickCount " + paramArrayOfByte.tbz);
      y.d("MicroMsg.NetSceneThrowBottle", "getDistance " + paramArrayOfByte.tzC);
      y.d("MicroMsg.NetSceneThrowBottle", "getBottleList " + paramArrayOfByte.tNn.size());
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfByte.tNn.size())
      {
        y.d("MicroMsg.NetSceneThrowBottle", "bott id:" + paramArrayOfByte.tNn.get(paramInt1));
        paramInt1 += 1;
      }
      if (paramq.kSW == 1)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        oi(1);
        return;
      }
      this.hYm += paramq.sPG.tFK;
      if (this.hYm >= paramq.ndf)
      {
        c.og(paramArrayOfByte.tbz);
        c.of(paramArrayOfByte.tby);
        oi(3);
        com.tencent.mm.modelvoice.q.oy(paramq.trv);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    } while (a(this.edc, this.dmL) != -1);
    this.dmL.onSceneEnd(3, -1, "doScene failed", this);
  }
  
  protected final void a(m.a parama)
  {
    y.e("MicroMsg.NetSceneThrowBottle", "setSecurityCheckError:" + parama + " type:" + this.msgType);
  }
  
  public final int awL()
  {
    return ((bxj)this.dmK.ecF.ecN).tzC;
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    paramq = (bxi)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    if (paramq.kSW == 1) {
      return m.b.edr;
    }
    if (paramq.kSW != 3) {
      return m.b.eds;
    }
    if ((paramq.ndf == 0) || (paramq.ndf <= paramq.ndg) || (bk.bl(paramq.trv)) || (bk.bE(aa.a(paramq.sPG)))) {
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 154;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.g
 * JD-Core Version:    0.7.0.1
 */