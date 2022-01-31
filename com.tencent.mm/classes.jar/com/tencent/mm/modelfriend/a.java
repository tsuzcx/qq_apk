package com.tencent.mm.modelfriend;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.protocal.c.chk;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.protocal.c.ib;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  public static a ekT;
  f dmL = null;
  public final q edR = new a.b();
  private int edu = 2;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    com.tencent.mm.protocal.m.a locala = (com.tencent.mm.protocal.m.a)this.edR.Kv();
    locala.spS.syV = paramInt1;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.spS.sBm = paramString1;
    locala.spS.sBn = paramString2;
    locala.spS.sBo = paramInt2;
    locala.spS.sBp = paramString3;
    locala.spS.jxi = x.cqJ();
    locala.spS.syH = com.tencent.mm.kernel.a.Df();
    if ((bk.bl(locala.spS.sBr)) && (bk.bl(locala.spS.sBs)))
    {
      paramString2 = locala.spS;
      if (ekT == null) {
        break label216;
      }
    }
    label216:
    for (paramString1 = ekT.NX();; paramString1 = "")
    {
      paramString2.sBr = paramString1;
      locala.spS.sBs = d.DEVICE_NAME;
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    ((com.tencent.mm.protocal.m.a)this.edR.Kv()).spS.syt = paramString4;
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    paramString1 = (com.tencent.mm.protocal.m.a)this.edR.Kv();
    paramString1.spS.sBr = paramString5;
    paramString1.spS.sBs = paramString6;
  }
  
  protected final int Ka()
  {
    return 3;
  }
  
  public final String NI()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sBC;
  }
  
  public final String NJ()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.bJY;
  }
  
  public final String NK()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.syt;
  }
  
  public final String NL()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sBJ;
  }
  
  public final int NM()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sBw;
  }
  
  public final String NN()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sBL;
  }
  
  public final String NO()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sBM;
  }
  
  public final int NP()
  {
    Object localObject = ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 6) {
          return bk.getInt(localbwb.tMN, 3);
        }
      }
    }
    return 3;
  }
  
  public final int NQ()
  {
    Object localObject = ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 4) {
          return bk.getInt(localbwb.tMN, 30);
        }
      }
    }
    return 30;
  }
  
  public final int NR()
  {
    Object localObject = ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 5) {
          return bk.getInt(localbwb.tMN, 0);
        }
      }
    }
    return 0;
  }
  
  public final boolean NS()
  {
    Object localObject = ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sys;
    bwb localbwb;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbwb = (bwb)((Iterator)localObject).next();
      } while (localbwb.nFi != 7);
    }
    for (int i = bk.getInt(localbwb.tMN, 0);; i = 0) {
      return i > 0;
    }
  }
  
  public final boolean NT()
  {
    Object localObject = ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sys;
    bwb localbwb;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbwb = (bwb)((Iterator)localObject).next();
      } while (localbwb.nFi != 10);
    }
    for (int i = bk.getInt(localbwb.tMN, 0);; i = 0) {
      return i > 0;
    }
  }
  
  public final String NU()
  {
    Object localObject = ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 14) {
          return localbwb.tMN;
        }
      }
    }
    return null;
  }
  
  public final String NV()
  {
    Object localObject = ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 15) {
          return localbwb.tMN;
        }
      }
    }
    return null;
  }
  
  public final String NW()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sBx;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (com.tencent.mm.protocal.m.a)this.edR.Kv();
    if ((paramf.spS.sBm == null) || (paramf.spS.sBm.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + paramf.spS.sBm);
      return -1;
    }
    if (((paramf.spS.syV == 6) || (paramf.spS.syV == 9)) && ((paramf.spS.sBn == null) || (paramf.spS.sBn.length() <= 0)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + paramf.spS.sBm);
      return -1;
    }
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (com.tencent.mm.protocal.m.b)paramq.HF();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.spT != null))
    {
      paramInt1 = paramArrayOfByte.spT.syx;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.DQ();
      g.DP().dKo.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.e locale = g.DO().dJT.edx;
      if (locale != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label206;
        }
        bool = true;
        locale.bR(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        av.a(true, paramArrayOfByte.spT.sBE, paramArrayOfByte.spT.sBF, paramArrayOfByte.spT.sBD);
        this.edu -= 1;
        if (this.edu <= 0)
        {
          this.dmL.onSceneEnd(3, -1, "", this);
          return;
          label206:
          bool = false;
          break;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[] { paramArrayOfByte });
          continue;
        }
        a(this.edc, this.dmL);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.edu) });
      this.edu -= 1;
      if (this.edu <= 0)
      {
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      a(this.edc, this.dmL);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.Kv().spM.ver;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.DS().O(new a.1(this, paramInt1));
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    av.a(false, paramArrayOfByte.spT.sBE, paramArrayOfByte.spT.sBF, paramArrayOfByte.spT.sBD);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final void a(com.tencent.mm.ah.m.a parama) {}
  
  public final void a(chk paramchk)
  {
    try
    {
      ((com.tencent.mm.protocal.m.a)this.edR.Kv()).spS.sBz = new bmk().bs(paramchk.toByteArray());
      return;
    }
    catch (Throwable paramchk) {}
  }
  
  protected final com.tencent.mm.ah.m.b b(q paramq)
  {
    return com.tencent.mm.ah.m.b.edr;
  }
  
  public final int getType()
  {
    return 145;
  }
  
  public final String getUsername()
  {
    return ((com.tencent.mm.protocal.m.b)this.edR.HF()).spT.sxM;
  }
  
  public final void ix(int paramInt)
  {
    ((com.tencent.mm.protocal.m.a)this.edR.Kv()).spS.sBu = paramInt;
  }
  
  public final void iy(int paramInt)
  {
    ((com.tencent.mm.protocal.m.a)this.edR.Kv()).spS.sBv = paramInt;
  }
  
  public final void lS(String paramString)
  {
    ((com.tencent.mm.protocal.m.a)this.edR.Kv()).spS.sBx = paramString;
  }
  
  public final int rN()
  {
    return ((com.tencent.mm.protocal.m.a)this.edR.Kv()).spS.syV;
  }
  
  public static abstract interface a
  {
    public abstract String NX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a
 * JD-Core Version:    0.7.0.1
 */