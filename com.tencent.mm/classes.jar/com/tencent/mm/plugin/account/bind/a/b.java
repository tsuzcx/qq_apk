package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.a.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.ic;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

public final class b
  extends m
  implements k
{
  private String bPS;
  private String bPU;
  public final com.tencent.mm.ah.b dmK;
  private f dmL;
  public long eAo = 0L;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ic();
    ((b.a)localObject).ecI = new id();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((b.a)localObject).ecG = 144;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    this.eAo = paramLong;
    localObject = (ic)this.dmK.ecE.ecN;
    ((ic)localObject).sBN = new o(paramLong).intValue();
    ((ic)localObject).sBC = "";
    ((ic)localObject).sBO = "";
    ((ic)localObject).sBP = "";
    ((ic)localObject).sBQ = "";
    ((ic)localObject).sBS = new bml().YI("");
    ((ic)localObject).sBR = 1;
    if (paramBoolean == true) {}
    for (paramString1 = g.DN().CU().f(paramLong, paramString3);; paramString1 = g.DN().CU().a(paramLong, bk.ZL(paramString1), true))
    {
      ((ic)localObject).sAc = new bmk().bs(paramString1);
      String str = bk.pm((String)g.DP().Dz().get(47, null));
      ((ic)localObject).sBT = new bmk().bs(bk.ZM(str));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(bk.bF(paramString1)), paramString3, paramString2, paramString4, str });
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    this.bPS = paramString5;
    this.bPU = paramString6;
    paramString1 = (ic)this.dmK.ecE.ecN;
    paramString1.sBr = paramString5;
    paramString1.sBs = paramString6;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (ic)this.dmK.ecE.ecN;
    paramArrayOfByte = (id)this.dmK.ecF.ecN;
    Object localObject = aa.a(paramArrayOfByte.syk);
    if (!bk.bE((byte[])localObject)) {}
    for (boolean bool1 = g.DN().CU().a(new o(paramq.sBN).longValue(), (byte[])localObject);; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(bk.bF((byte[])localObject)), paramArrayOfByte.sBP });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        g.DP().Dz().o(9, Integer.valueOf(paramq.sBN));
        if (paramq.sBR == 1) {
          g.DP().Dz().o(17, Integer.valueOf(paramArrayOfByte.stV));
        }
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE();
        String str = paramArrayOfByte.sBW;
        if (paramArrayOfByte.sBV == 1)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.a.j)localObject).aK(str, bool2);
          paramInt1 = paramq.sBN;
          if (paramInt1 != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().bX(new o(paramInt1) + "@qqim", 3);
          }
          com.tencent.mm.ag.b.c(paramInt1, 3);
          g.DP().Dz().o(32, paramq.sBC);
          g.DP().Dz().o(33, paramq.sBO);
          localObject = bk.bG(g.DN().CU().bI(new o(paramq.sBN).longValue()));
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), bk.aac((String)localObject) });
          g.DP().Dz().o(72, localObject);
          g.DP().Dz().o(46, bk.bG(aa.a(paramArrayOfByte.syq)));
          localObject = bk.bG(aa.a(paramq.sBT));
          g.DP().Dz().o(47, localObject);
          g.DP().dKo.set(18, localObject);
          g.DP().Dz().o(-1535680990, paramArrayOfByte.sBX);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (paramq.sBR == 3)
        {
          paramInt1 = paramInt3;
          if (paramInt3 == -3)
          {
            paramInt1 = 10000;
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
          }
        }
        this.dmL.onSceneEnd(paramInt2, paramInt1, paramString, this);
        return;
        bool2 = false;
        break;
        if (paramInt2 == 4)
        {
          g.DP().Dz().o(32, "");
          g.DP().Dz().o(33, "");
        }
      }
    }
  }
  
  public final int getType()
  {
    return 144;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */