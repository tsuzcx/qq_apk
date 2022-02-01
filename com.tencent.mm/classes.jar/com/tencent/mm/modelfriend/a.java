package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  public static a.a hWS;
  com.tencent.mm.al.f callback;
  public final com.tencent.mm.network.q hON;
  private int hOs;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3, 0);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(134117);
    this.callback = null;
    this.hOs = 2;
    this.hON = new a.b();
    com.tencent.mm.protocal.n.a locala = (com.tencent.mm.protocal.n.a)this.hON.getReqObj();
    locala.FnZ.FAt = paramInt1;
    ad.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.FnZ.FDJ = paramString1;
    locala.FnZ.FDK = paramString2;
    locala.FnZ.FDT = paramInt3;
    locala.FnZ.FDL = paramInt2;
    locala.FnZ.FDM = paramString3;
    locala.FnZ.qei = com.tencent.mm.sdk.platformtools.ac.fks();
    locala.FnZ.FzI = com.tencent.mm.kernel.a.aiO();
    if ((bt.isNullOrNil(locala.FnZ.FDO)) && (bt.isNullOrNil(locala.FnZ.FDP)))
    {
      paramString2 = locala.FnZ;
      if (hWS == null) {
        break label236;
      }
    }
    label236:
    for (paramString1 = hWS.aHL();; paramString1 = "")
    {
      paramString2.FDO = paramString1;
      locala.FnZ.FDP = d.DEVICE_NAME;
      AppMethodBeat.o(134117);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(134116);
    ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.Fzf = paramString4;
    AppMethodBeat.o(134116);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(134115);
    paramString1 = (com.tencent.mm.protocal.n.a)this.hON.getReqObj();
    paramString1.FnZ.FDO = paramString5;
    paramString1.FnZ.FDP = paramString6;
    AppMethodBeat.o(134115);
  }
  
  public final void B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134142);
    dew localdew = new dew();
    localdew.Htl = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localdew.Htm = paramInt;
      ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.FDX = localdew;
      AppMethodBeat.o(134142);
      return;
    }
  }
  
  public final void EX(String paramString)
  {
    AppMethodBeat.i(134141);
    ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.FDU = paramString;
    AppMethodBeat.o(134141);
  }
  
  public final int KR()
  {
    AppMethodBeat.i(134120);
    int i = ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.FAt;
    AppMethodBeat.o(134120);
    return i;
  }
  
  public final void a(eah parameah)
  {
    AppMethodBeat.i(134132);
    try
    {
      ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.FzL = new SKBuiltinBuffer_t().setBuffer(parameah.toByteArray());
      AppMethodBeat.o(134132);
      return;
    }
    catch (Throwable parameah)
    {
      AppMethodBeat.o(134132);
    }
  }
  
  public final String aHA()
  {
    AppMethodBeat.i(134129);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.FEk;
    AppMethodBeat.o(134129);
    return str;
  }
  
  public final String aHB()
  {
    AppMethodBeat.i(134130);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.FEl;
    AppMethodBeat.o(134130);
    return str;
  }
  
  public final ccb aHC()
  {
    AppMethodBeat.i(193067);
    ccb localccb = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.FDY;
    AppMethodBeat.o(193067);
    return localccb;
  }
  
  public final int aHD()
  {
    AppMethodBeat.i(134133);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 6);
    }
    for (int i = bt.getInt(localdkj.Hza, 3);; i = 3)
    {
      AppMethodBeat.o(134133);
      return i;
    }
  }
  
  public final int aHE()
  {
    AppMethodBeat.i(134134);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 4);
    }
    for (int i = bt.getInt(localdkj.Hza, 30);; i = 30)
    {
      AppMethodBeat.o(134134);
      return i;
    }
  }
  
  public final int aHF()
  {
    AppMethodBeat.i(134135);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 5);
    }
    for (int i = bt.getInt(localdkj.Hza, 0);; i = 0)
    {
      AppMethodBeat.o(134135);
      return i;
    }
  }
  
  public final boolean aHG()
  {
    AppMethodBeat.i(134136);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 7);
    }
    for (int i = bt.getInt(localdkj.Hza, 0);; i = 0)
    {
      if (i > 0)
      {
        AppMethodBeat.o(134136);
        return true;
      }
      AppMethodBeat.o(134136);
      return false;
    }
  }
  
  public final boolean aHH()
  {
    AppMethodBeat.i(134137);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 10);
    }
    for (int i = bt.getInt(localdkj.Hza, 0);; i = 0)
    {
      if (i > 0)
      {
        AppMethodBeat.o(134137);
        return true;
      }
      AppMethodBeat.o(134137);
      return false;
    }
  }
  
  public final String aHI()
  {
    AppMethodBeat.i(134138);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 14);
    }
    for (localObject = localdkj.Hza;; localObject = null)
    {
      AppMethodBeat.o(134138);
      return localObject;
    }
  }
  
  public final String aHJ()
  {
    AppMethodBeat.i(134139);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 15);
    }
    for (localObject = localdkj.Hza;; localObject = null)
    {
      AppMethodBeat.o(134139);
      return localObject;
    }
  }
  
  public final String aHK()
  {
    AppMethodBeat.i(134140);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.FDU;
    AppMethodBeat.o(134140);
    return str;
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(134123);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.FEb;
    AppMethodBeat.o(134123);
    return str;
  }
  
  public final String aHw()
  {
    AppMethodBeat.i(134125);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.dpf;
    AppMethodBeat.o(134125);
    return str;
  }
  
  public final String aHx()
  {
    AppMethodBeat.i(134126);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Fzf;
    AppMethodBeat.o(134126);
    return str;
  }
  
  public final String aHy()
  {
    AppMethodBeat.i(134127);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.FEi;
    AppMethodBeat.o(134127);
    return str;
  }
  
  public final int aHz()
  {
    AppMethodBeat.i(134128);
    int i = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.FDT;
    AppMethodBeat.o(134128);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(134121);
    this.callback = paramf;
    paramf = (com.tencent.mm.protocal.n.a)this.hON.getReqObj();
    if ((paramf.FnZ.FDJ == null) || (paramf.FnZ.FDJ.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + paramf.FnZ.FDJ);
      AppMethodBeat.o(134121);
      return -1;
    }
    if (((paramf.FnZ.FAt == 6) || (paramf.FnZ.FAt == 9)) && ((paramf.FnZ.FDK == null) || (paramf.FnZ.FDK.length() <= 0)))
    {
      ad.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + paramf.FnZ.FDJ);
      AppMethodBeat.o(134121);
      return -1;
    }
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(134121);
    return i;
  }
  
  public final int getType()
  {
    return 145;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(134124);
    String str = ((com.tencent.mm.protocal.n.b)this.hON.getRespObj()).Foa.Username;
    AppMethodBeat.o(134124);
    return str;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134122);
    ad.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (com.tencent.mm.protocal.n.b)paramq.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.Foa != null))
    {
      paramInt1 = paramArrayOfByte.Foa.Fzj;
      ad.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.ajD();
      g.ajC().gBh.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.e locale = g.ajB().gAO.hOv;
      if (locale != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label219;
        }
        bool = true;
        locale.eI(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bb.a(true, paramArrayOfByte.Foa.FEd, paramArrayOfByte.Foa.FEe, paramArrayOfByte.Foa.FEc);
        this.hOs -= 1;
        if (this.hOs <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134122);
          return;
          label219:
          bool = false;
          break;
          ad.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[] { paramArrayOfByte });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134122);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ad.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hOs) });
      this.hOs -= 1;
      if (this.hOs <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134122);
        return;
      }
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134122);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ad.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134113);
          new l().doScene(a.this.dispatcher(), new com.tencent.mm.al.f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134112);
              ad.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                a.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", a.this);
                AppMethodBeat.o(134112);
                return;
              }
              a.this.doScene(a.this.dispatcher(), a.this.callback);
              AppMethodBeat.o(134112);
            }
          });
          AppMethodBeat.o(134113);
        }
      });
      AppMethodBeat.o(134122);
      return;
    }
    if ((paramInt2 == 4) && ((paramInt3 == -305) || (paramInt3 == -306)))
    {
      ad.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.Fnx) });
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134122);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134122);
      return;
    }
    bb.a(false, paramArrayOfByte.Foa.FEd, paramArrayOfByte.Foa.FEe, paramArrayOfByte.Foa.FEc);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134122);
  }
  
  public final void ph(int paramInt)
  {
    AppMethodBeat.i(134118);
    ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.FDR = paramInt;
    AppMethodBeat.o(134118);
  }
  
  public final void pi(int paramInt)
  {
    AppMethodBeat.i(134119);
    ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.FDS = paramInt;
    AppMethodBeat.o(134119);
  }
  
  public final void pj(int paramInt)
  {
    AppMethodBeat.i(193068);
    ((com.tencent.mm.protocal.n.a)this.hON.getReqObj()).FnZ.FDT = paramInt;
    AppMethodBeat.o(193068);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final com.tencent.mm.al.n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return com.tencent.mm.al.n.b.hOp;
  }
  
  public final void setSecurityCheckError(com.tencent.mm.al.n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a
 * JD-Core Version:    0.7.0.1
 */