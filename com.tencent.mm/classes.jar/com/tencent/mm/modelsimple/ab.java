package com.tencent.mm.modelsimple;

import com.tencent.mm.a.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.ccv;
import com.tencent.mm.protocal.c.ccw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

public final class ab
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  public long eAo = 0L;
  
  public ab(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ab(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ccv();
    ((b.a)localObject).ecI = new ccw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((b.a)localObject).ecG = 384;
    ((b.a)localObject).ecJ = 182;
    ((b.a)localObject).ecK = 1000000182;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ccv)this.dmK.ecE.ecN;
    ((ccv)localObject).ssq = paramInt1;
    ((ccv)localObject).tHN = paramInt2;
    ((ccv)localObject).tRK = bk.ZL(paramString1);
    ((ccv)localObject).sBO = bk.ZK(paramString1);
    ((ccv)localObject).tii = new bml().YI(paramString2);
    ((ccv)localObject).tRL = new bml().YI(paramString3);
    ((ccv)localObject).sBS = new bml().YI(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.eAo = new o(com.tencent.mm.model.q.Gi()).longValue();
      if (paramBoolean1)
      {
        paramString1 = g.DN().CU().f(this.eAo, paramString3);
        ((ccv)localObject).sAc = new bmk().bs(paramString1);
      }
    }
    else
    {
      paramString1 = bk.pm((String)g.DP().Dz().get(47, null));
      ((ccv)localObject).sBT = new bmk().bs(bk.ZM(paramString1));
      paramInt2 = ((ccv)localObject).ssq;
      if (((ccv)localObject).sAc != null) {
        break label377;
      }
      paramInt1 = -1;
      label296:
      if (((ccv)localObject).sAc != null) {
        break label389;
      }
    }
    label389:
    for (paramString1 = "null";; paramString1 = bk.aac(bk.bD(((ccv)localObject).sAc.tFM.oY)))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      return;
      paramString1 = g.DN().CU().a(this.eAo, bk.ZL(paramString1), paramBoolean2);
      break;
      label377:
      paramInt1 = ((ccv)localObject).sAc.tFK;
      break label296;
    }
  }
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String NJ()
  {
    try
    {
      String str = ((ccw)this.dmK.ecF.ecN).sRr;
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (ccv)this.dmK.ecE.ecN;
    paramq = (ccw)this.dmK.ecF.ecN;
    if ((paramq.syk != null) && (paramq.syk.tFK > 0)) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(g.DN().CU().a(this.eAo, aa.a(paramq.syk))), Integer.valueOf(paramq.syk.tFK) });
    }
    int i;
    label258:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.DP().Dz().o(77830, paramq.sRr);
      g.DP().Dz().o(32, paramArrayOfByte.tRK);
      g.DP().Dz().o(33, paramArrayOfByte.sBO);
      g.DP().Dz().o(46, bk.bG(aa.a(paramq.syq)));
      paramArrayOfByte = bk.bG(aa.a(paramArrayOfByte.sBT));
      g.DP().Dz().o(47, paramArrayOfByte);
      g.DP().dKo.set(18, paramArrayOfByte);
      g.DP().Dz().o(-1535680990, paramq.syp);
      if (paramq.syq == null)
      {
        paramInt1 = 0;
        if (paramq.syp != null) {
          break label331;
        }
        i = 0;
        if (paramq.sRr != null) {
          break label344;
        }
        j = 0;
        label269:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramInt1 = paramq.syq.tFK;
      break;
      label331:
      i = paramq.syp.length();
      break label258;
      label344:
      j = paramq.sRr.length();
      break label269;
      if (paramInt2 == 4)
      {
        g.DP().Dz().o(32, "");
        g.DP().Dz().o(33, "");
      }
    }
  }
  
  public final int getType()
  {
    return 384;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */