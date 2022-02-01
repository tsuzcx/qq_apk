package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  public static a hdK;
  com.tencent.mm.al.g callback;
  private int gVE;
  public final com.tencent.mm.network.q gVZ;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3, 0);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(134117);
    this.callback = null;
    this.gVE = 2;
    this.gVZ = new b();
    com.tencent.mm.protocal.n.a locala = (com.tencent.mm.protocal.n.a)this.gVZ.getReqObj();
    locala.CqA.CCB = paramInt1;
    ad.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.CqA.CFN = paramString1;
    locala.CqA.CFO = paramString2;
    locala.CqA.CFX = paramInt3;
    locala.CqA.CFP = paramInt2;
    locala.CqA.CFQ = paramString3;
    locala.CqA.oXs = com.tencent.mm.sdk.platformtools.ac.eFu();
    locala.CqA.CBQ = com.tencent.mm.kernel.a.aeM();
    if ((bt.isNullOrNil(locala.CqA.CFS)) && (bt.isNullOrNil(locala.CqA.CFT)))
    {
      paramString2 = locala.CqA;
      if (hdK == null) {
        break label236;
      }
    }
    label236:
    for (paramString1 = hdK.axO();; paramString1 = "")
    {
      paramString2.CFS = paramString1;
      locala.CqA.CFT = d.DEVICE_NAME;
      AppMethodBeat.o(134117);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(134116);
    ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CBn = paramString4;
    AppMethodBeat.o(134116);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(134115);
    paramString1 = (com.tencent.mm.protocal.n.a)this.gVZ.getReqObj();
    paramString1.CqA.CFS = paramString5;
    paramString1.CqA.CFT = paramString6;
    AppMethodBeat.o(134115);
  }
  
  public final void B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134142);
    ctx localctx = new ctx();
    localctx.ElE = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localctx.ElF = paramInt;
      ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CGb = localctx;
      AppMethodBeat.o(134142);
      return;
    }
  }
  
  public final int JJ()
  {
    AppMethodBeat.i(134120);
    int i = ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CCB;
    AppMethodBeat.o(134120);
    return i;
  }
  
  public final void a(dow paramdow)
  {
    AppMethodBeat.i(134132);
    try
    {
      ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CBU = new SKBuiltinBuffer_t().setBuffer(paramdow.toByteArray());
      AppMethodBeat.o(134132);
      return;
    }
    catch (Throwable paramdow)
    {
      AppMethodBeat.o(134132);
    }
  }
  
  public final String axA()
  {
    AppMethodBeat.i(134126);
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBn;
    AppMethodBeat.o(134126);
    return str;
  }
  
  public final String axB()
  {
    AppMethodBeat.i(134127);
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CGm;
    AppMethodBeat.o(134127);
    return str;
  }
  
  public final int axC()
  {
    AppMethodBeat.i(134128);
    int i = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CFX;
    AppMethodBeat.o(134128);
    return i;
  }
  
  public final String axD()
  {
    AppMethodBeat.i(134129);
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CGo;
    AppMethodBeat.o(134129);
    return str;
  }
  
  public final String axE()
  {
    AppMethodBeat.i(134130);
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CGp;
    AppMethodBeat.o(134130);
    return str;
  }
  
  public final bst axF()
  {
    AppMethodBeat.i(190815);
    bst localbst = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CGc;
    AppMethodBeat.o(190815);
    return localbst;
  }
  
  public final int axG()
  {
    AppMethodBeat.i(134133);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 6);
    }
    for (int i = bt.getInt(localczk.Ern, 3);; i = 3)
    {
      AppMethodBeat.o(134133);
      return i;
    }
  }
  
  public final int axH()
  {
    AppMethodBeat.i(134134);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 4);
    }
    for (int i = bt.getInt(localczk.Ern, 30);; i = 30)
    {
      AppMethodBeat.o(134134);
      return i;
    }
  }
  
  public final int axI()
  {
    AppMethodBeat.i(134135);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 5);
    }
    for (int i = bt.getInt(localczk.Ern, 0);; i = 0)
    {
      AppMethodBeat.o(134135);
      return i;
    }
  }
  
  public final boolean axJ()
  {
    AppMethodBeat.i(134136);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 7);
    }
    for (int i = bt.getInt(localczk.Ern, 0);; i = 0)
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
  
  public final boolean axK()
  {
    AppMethodBeat.i(134137);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 10);
    }
    for (int i = bt.getInt(localczk.Ern, 0);; i = 0)
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
  
  public final String axL()
  {
    AppMethodBeat.i(134138);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 14);
    }
    for (localObject = localczk.Ern;; localObject = null)
    {
      AppMethodBeat.o(134138);
      return localObject;
    }
  }
  
  public final String axM()
  {
    AppMethodBeat.i(134139);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CBm;
    czk localczk;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject).next();
      } while (localczk.vJz != 15);
    }
    for (localObject = localczk.Ern;; localObject = null)
    {
      AppMethodBeat.o(134139);
      return localObject;
    }
  }
  
  public final String axN()
  {
    AppMethodBeat.i(134140);
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CFY;
    AppMethodBeat.o(134140);
    return str;
  }
  
  public final String axy()
  {
    AppMethodBeat.i(134123);
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.CGf;
    AppMethodBeat.o(134123);
    return str;
  }
  
  public final String axz()
  {
    AppMethodBeat.i(134125);
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.dgo;
    AppMethodBeat.o(134125);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(134121);
    this.callback = paramg;
    paramg = (com.tencent.mm.protocal.n.a)this.gVZ.getReqObj();
    if ((paramg.CqA.CFN == null) || (paramg.CqA.CFN.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + paramg.CqA.CFN);
      AppMethodBeat.o(134121);
      return -1;
    }
    if (((paramg.CqA.CCB == 6) || (paramg.CqA.CCB == 9)) && ((paramg.CqA.CFO == null) || (paramg.CqA.CFO.length() <= 0)))
    {
      ad.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + paramg.CqA.CFN);
      AppMethodBeat.o(134121);
      return -1;
    }
    int i = dispatch(parame, this.gVZ, this);
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
    String str = ((com.tencent.mm.protocal.n.b)this.gVZ.getRespObj()).CqB.Username;
    AppMethodBeat.o(134124);
    return str;
  }
  
  public final void nS(int paramInt)
  {
    AppMethodBeat.i(134118);
    ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CFV = paramInt;
    AppMethodBeat.o(134118);
  }
  
  public final void nT(int paramInt)
  {
    AppMethodBeat.i(134119);
    ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CFW = paramInt;
    AppMethodBeat.o(134119);
  }
  
  public final void nU(int paramInt)
  {
    AppMethodBeat.i(190816);
    ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CFX = paramInt;
    AppMethodBeat.o(190816);
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134122);
    ad.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (com.tencent.mm.protocal.n.b)paramq.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.CqB != null))
    {
      paramInt1 = paramArrayOfByte.CqB.CBr;
      ad.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().gcR.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.e locale = com.tencent.mm.kernel.g.afA().gcy.gVH;
      if (locale != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label219;
        }
        bool = true;
        locale.el(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        ba.a(true, paramArrayOfByte.CqB.CGh, paramArrayOfByte.CqB.CGi, paramArrayOfByte.CqB.CGg);
        this.gVE -= 1;
        if (this.gVE <= 0)
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
      ad.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.gVE) });
      this.gVE -= 1;
      if (this.gVE <= 0)
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
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134113);
          new com.tencent.mm.modelsimple.l().doScene(a.this.dispatcher(), new com.tencent.mm.al.g()
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
      ad.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.CpY) });
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
    ba.a(false, paramArrayOfByte.CqB.CGh, paramArrayOfByte.CqB.CGi, paramArrayOfByte.CqB.CGg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134122);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final com.tencent.mm.al.n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return com.tencent.mm.al.n.b.gVB;
  }
  
  public final void setSecurityCheckError(com.tencent.mm.al.n.a parama) {}
  
  public final void xT(String paramString)
  {
    AppMethodBeat.i(134141);
    ((com.tencent.mm.protocal.n.a)this.gVZ.getReqObj()).CqA.CFY = paramString;
    AppMethodBeat.o(134141);
  }
  
  public static abstract interface a
  {
    public abstract String axO();
  }
  
  public static final class b
    extends com.tencent.mm.al.l
  {
    private final com.tencent.mm.protocal.n.a hdO;
    private final com.tencent.mm.protocal.n.b hdP;
    
    public b()
    {
      AppMethodBeat.i(134114);
      this.hdO = new com.tencent.mm.protocal.n.a();
      this.hdP = new com.tencent.mm.protocal.n.b();
      AppMethodBeat.o(134114);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.hdO;
    }
    
    public final l.e getRespObj()
    {
      return this.hdP;
    }
    
    public final int getType()
    {
      return 145;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/bindopmobileforreg";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a
 * JD-Core Version:    0.7.0.1
 */