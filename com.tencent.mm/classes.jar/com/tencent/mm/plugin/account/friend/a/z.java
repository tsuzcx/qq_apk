package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends m
  implements k
{
  private f dmL;
  public com.tencent.mm.network.q edR = new z.a();
  private int edu = 2;
  
  private z(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    r.a locala = (r.a)this.edR.Kv();
    locala.ffZ.syV = paramInt;
    locala.ffZ.sAY = paramString1;
    locala.ffZ.jxi = x.cqJ();
    locala.ffZ.sBC = bk.ZK(paramString2);
    locala.ffZ.sRo = paramString3;
    paramString1 = locala.ffZ;
    g.DN();
    paramString1.syH = a.Df();
    locala.ffZ.sRp = com.tencent.mm.compatible.e.q.getSimCountryIso();
    locala.ffZ.sRq = 1;
  }
  
  public z(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2, "");
  }
  
  public z(String paramString1, String paramString2, String paramString3)
  {
    this(2, paramString1, paramString2, paramString3);
  }
  
  protected final int Ka()
  {
    return 5;
  }
  
  public final int QJ()
  {
    Object localObject = ((r.b)this.edR.HF()).fga.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 1) {
          return bk.getInt(localbwb.tMN, 0);
        }
      }
    }
    return 0;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (r.b)paramq.HF();
    if ((paramInt2 == 4) && (paramInt3 == -301))
    {
      av.a(true, paramq.fga.sBE, paramq.fga.sBF, paramq.fga.sBD);
      this.edu -= 1;
      if (this.edu <= 0)
      {
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      a(this.edc, this.dmL);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    av.a(false, paramq.fga.sBE, paramq.fga.sBF, paramq.fga.sBD);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 481;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */