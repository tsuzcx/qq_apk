package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.n.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  public static a.a fBk;
  com.tencent.mm.ai.f callback;
  public final q ftU;
  private int ftx;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(123400);
    this.callback = null;
    this.ftx = 2;
    this.ftU = new a.b();
    n.a locala = (n.a)this.ftU.getReqObj();
    locala.wiw.wsW = paramInt1;
    ab.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.wiw.wvG = paramString1;
    locala.wiw.wvH = paramString2;
    locala.wiw.wvI = paramInt2;
    locala.wiw.wvJ = paramString3;
    locala.wiw.lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
    locala.wiw.wsp = com.tencent.mm.kernel.a.QX();
    if ((bo.isNullOrNil(locala.wiw.wvL)) && (bo.isNullOrNil(locala.wiw.wvM)))
    {
      paramString2 = locala.wiw;
      if (fBk == null) {
        break label226;
      }
    }
    label226:
    for (paramString1 = fBk.agL();; paramString1 = "")
    {
      paramString2.wvL = paramString1;
      locala.wiw.wvM = d.DEVICE_NAME;
      AppMethodBeat.o(123400);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(123399);
    ((n.a)this.ftU.getReqObj()).wiw.wrW = paramString4;
    AppMethodBeat.o(123399);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(123398);
    paramString1 = (n.a)this.ftU.getReqObj();
    paramString1.wiw.wvL = paramString5;
    paramString1.wiw.wvM = paramString6;
    AppMethodBeat.o(123398);
  }
  
  public final int Ac()
  {
    AppMethodBeat.i(123403);
    int i = ((n.a)this.ftU.getReqObj()).wiw.wsW;
    AppMethodBeat.o(123403);
    return i;
  }
  
  public final void a(cuv paramcuv)
  {
    AppMethodBeat.i(123414);
    try
    {
      ((n.a)this.ftU.getReqObj()).wiw.wss = new SKBuiltinBuffer_t().setBuffer(paramcuv.toByteArray());
      AppMethodBeat.o(123414);
      return;
    }
    catch (Throwable paramcuv)
    {
      AppMethodBeat.o(123414);
    }
  }
  
  public final int agA()
  {
    AppMethodBeat.i(123411);
    int i = ((n.b)this.ftU.getRespObj()).wix.wvQ;
    AppMethodBeat.o(123411);
    return i;
  }
  
  public final String agB()
  {
    AppMethodBeat.i(123412);
    String str = ((n.b)this.ftU.getRespObj()).wix.wwf;
    AppMethodBeat.o(123412);
    return str;
  }
  
  public final String agC()
  {
    AppMethodBeat.i(123413);
    String str = ((n.b)this.ftU.getRespObj()).wix.wwg;
    AppMethodBeat.o(123413);
    return str;
  }
  
  public final int agD()
  {
    AppMethodBeat.i(123415);
    Object localObject = ((n.b)this.ftU.getRespObj()).wix.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 6);
    }
    for (int i = bo.getInt(localcij.xSX, 3);; i = 3)
    {
      AppMethodBeat.o(123415);
      return i;
    }
  }
  
  public final int agE()
  {
    AppMethodBeat.i(123416);
    Object localObject = ((n.b)this.ftU.getRespObj()).wix.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 4);
    }
    for (int i = bo.getInt(localcij.xSX, 30);; i = 30)
    {
      AppMethodBeat.o(123416);
      return i;
    }
  }
  
  public final int agF()
  {
    AppMethodBeat.i(123417);
    Object localObject = ((n.b)this.ftU.getRespObj()).wix.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 5);
    }
    for (int i = bo.getInt(localcij.xSX, 0);; i = 0)
    {
      AppMethodBeat.o(123417);
      return i;
    }
  }
  
  public final boolean agG()
  {
    AppMethodBeat.i(123418);
    Object localObject = ((n.b)this.ftU.getRespObj()).wix.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 7);
    }
    for (int i = bo.getInt(localcij.xSX, 0);; i = 0)
    {
      if (i > 0)
      {
        AppMethodBeat.o(123418);
        return true;
      }
      AppMethodBeat.o(123418);
      return false;
    }
  }
  
  public final boolean agH()
  {
    AppMethodBeat.i(123419);
    Object localObject = ((n.b)this.ftU.getRespObj()).wix.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 10);
    }
    for (int i = bo.getInt(localcij.xSX, 0);; i = 0)
    {
      if (i > 0)
      {
        AppMethodBeat.o(123419);
        return true;
      }
      AppMethodBeat.o(123419);
      return false;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(123420);
    Object localObject = ((n.b)this.ftU.getRespObj()).wix.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 14);
    }
    for (localObject = localcij.xSX;; localObject = null)
    {
      AppMethodBeat.o(123420);
      return localObject;
    }
  }
  
  public final String agJ()
  {
    AppMethodBeat.i(123421);
    Object localObject = ((n.b)this.ftU.getRespObj()).wix.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 15);
    }
    for (localObject = localcij.xSX;; localObject = null)
    {
      AppMethodBeat.o(123421);
      return localObject;
    }
  }
  
  public final String agK()
  {
    AppMethodBeat.i(123422);
    String str = ((n.b)this.ftU.getRespObj()).wix.wvR;
    AppMethodBeat.o(123422);
    return str;
  }
  
  public final String agw()
  {
    AppMethodBeat.i(123406);
    String str = ((n.b)this.ftU.getRespObj()).wix.wvW;
    AppMethodBeat.o(123406);
    return str;
  }
  
  public final String agx()
  {
    AppMethodBeat.i(123408);
    String str = ((n.b)this.ftU.getRespObj()).wix.crs;
    AppMethodBeat.o(123408);
    return str;
  }
  
  public final String agy()
  {
    AppMethodBeat.i(123409);
    String str = ((n.b)this.ftU.getRespObj()).wix.wrW;
    AppMethodBeat.o(123409);
    return str;
  }
  
  public final String agz()
  {
    AppMethodBeat.i(123410);
    String str = ((n.b)this.ftU.getRespObj()).wix.wwd;
    AppMethodBeat.o(123410);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(123404);
    this.callback = paramf;
    paramf = (n.a)this.ftU.getReqObj();
    if ((paramf.wiw.wvG == null) || (paramf.wiw.wvG.length() <= 0))
    {
      ab.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + paramf.wiw.wvG);
      AppMethodBeat.o(123404);
      return -1;
    }
    if (((paramf.wiw.wsW == 6) || (paramf.wiw.wsW == 9)) && ((paramf.wiw.wvH == null) || (paramf.wiw.wvH.length() <= 0)))
    {
      ab.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + paramf.wiw.wvG);
      AppMethodBeat.o(123404);
      return -1;
    }
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(123404);
    return i;
  }
  
  public final int getType()
  {
    return 145;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(123407);
    String str = ((n.b)this.ftU.getRespObj()).wix.Username;
    AppMethodBeat.o(123407);
    return str;
  }
  
  public final void ll(int paramInt)
  {
    AppMethodBeat.i(123401);
    ((n.a)this.ftU.getReqObj()).wiw.wvO = paramInt;
    AppMethodBeat.o(123401);
  }
  
  public final void lm(int paramInt)
  {
    AppMethodBeat.i(123402);
    ((n.a)this.ftU.getReqObj()).wiw.wvP = paramInt;
    AppMethodBeat.o(123402);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123405);
    ab.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (n.b)paramq.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.wix != null))
    {
      paramInt1 = paramArrayOfByte.wix.wsa;
      ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.RM();
      g.RL().eHM.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.e locale = g.RK().eHt.ftA;
      if (locale != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label219;
        }
        bool = true;
        locale.cT(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        ax.a(true, paramArrayOfByte.wix.wvY, paramArrayOfByte.wix.wvZ, paramArrayOfByte.wix.wvX);
        this.ftx -= 1;
        if (this.ftx <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(123405);
          return;
          label219:
          bool = false;
          break;
          ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[] { paramArrayOfByte });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(123405);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ftx) });
      this.ftx -= 1;
      if (this.ftx <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(123405);
        return;
      }
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(123405);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ab.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.RO().ac(new a.1(this, paramInt1));
      AppMethodBeat.o(123405);
      return;
    }
    if ((paramInt2 == 4) && ((paramInt3 == -305) || (paramInt3 == -306)))
    {
      ab.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.whV) });
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(123405);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(123405);
      return;
    }
    ax.a(false, paramArrayOfByte.wix.wvY, paramArrayOfByte.wix.wvZ, paramArrayOfByte.wix.wvX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(123405);
  }
  
  public final void sQ(String paramString)
  {
    AppMethodBeat.i(123423);
    ((n.a)this.ftU.getReqObj()).wiw.wvR = paramString;
    AppMethodBeat.o(123423);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a
 * JD-Core Version:    0.7.0.1
 */