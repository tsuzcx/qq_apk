package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  public static a hZK;
  com.tencent.mm.ak.f callback;
  public final com.tencent.mm.network.q hRG;
  private int hRl;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3, 0);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(134117);
    this.callback = null;
    this.hRl = 2;
    this.hRG = new b();
    com.tencent.mm.protocal.n.a locala = (com.tencent.mm.protocal.n.a)this.hRG.getReqObj();
    locala.FGx.FSQ = paramInt1;
    ae.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.FGx.FWe = paramString1;
    locala.FGx.FWf = paramString2;
    locala.FGx.FWo = paramInt3;
    locala.FGx.FWg = paramInt2;
    locala.FGx.FWh = paramString3;
    locala.FGx.qkN = ad.fom();
    locala.FGx.FSg = com.tencent.mm.kernel.a.ajd();
    if ((bu.isNullOrNil(locala.FGx.FWj)) && (bu.isNullOrNil(locala.FGx.FWk)))
    {
      paramString2 = locala.FGx;
      if (hZK == null) {
        break label236;
      }
    }
    label236:
    for (paramString1 = hZK.aIc();; paramString1 = "")
    {
      paramString2.FWj = paramString1;
      locala.FGx.FWk = d.DEVICE_NAME;
      AppMethodBeat.o(134117);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(134116);
    ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FRD = paramString4;
    AppMethodBeat.o(134116);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(134115);
    paramString1 = (com.tencent.mm.protocal.n.a)this.hRG.getReqObj();
    paramString1.FGx.FWj = paramString5;
    paramString1.FGx.FWk = paramString6;
    AppMethodBeat.o(134115);
  }
  
  public final void B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134142);
    dfq localdfq = new dfq();
    localdfq.HMO = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localdfq.HMP = paramInt;
      ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FWs = localdfq;
      AppMethodBeat.o(134142);
      return;
    }
  }
  
  public final void Fz(String paramString)
  {
    AppMethodBeat.i(134141);
    ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FWp = paramString;
    AppMethodBeat.o(134141);
  }
  
  public final int KZ()
  {
    AppMethodBeat.i(134120);
    int i = ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FSQ;
    AppMethodBeat.o(134120);
    return i;
  }
  
  public final void a(eby parameby)
  {
    AppMethodBeat.i(134132);
    try
    {
      ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FSj = new SKBuiltinBuffer_t().setBuffer(parameby.toByteArray());
      AppMethodBeat.o(134132);
      return;
    }
    catch (Throwable parameby)
    {
      AppMethodBeat.o(134132);
    }
  }
  
  public final String aHM()
  {
    AppMethodBeat.i(134123);
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FWw;
    AppMethodBeat.o(134123);
    return str;
  }
  
  public final String aHN()
  {
    AppMethodBeat.i(134125);
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.dqk;
    AppMethodBeat.o(134125);
    return str;
  }
  
  public final String aHO()
  {
    AppMethodBeat.i(134126);
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRD;
    AppMethodBeat.o(134126);
    return str;
  }
  
  public final String aHP()
  {
    AppMethodBeat.i(134127);
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FWD;
    AppMethodBeat.o(134127);
    return str;
  }
  
  public final int aHQ()
  {
    AppMethodBeat.i(134128);
    int i = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FWo;
    AppMethodBeat.o(134128);
    return i;
  }
  
  public final String aHR()
  {
    AppMethodBeat.i(134129);
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FWF;
    AppMethodBeat.o(134129);
    return str;
  }
  
  public final String aHS()
  {
    AppMethodBeat.i(134130);
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FWG;
    AppMethodBeat.o(134130);
    return str;
  }
  
  public final ccv aHT()
  {
    AppMethodBeat.i(220271);
    ccv localccv = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FWt;
    AppMethodBeat.o(220271);
    return localccv;
  }
  
  public final int aHU()
  {
    AppMethodBeat.i(134133);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 6);
    }
    for (int i = bu.getInt(localdle.HSL, 3);; i = 3)
    {
      AppMethodBeat.o(134133);
      return i;
    }
  }
  
  public final int aHV()
  {
    AppMethodBeat.i(134134);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 4);
    }
    for (int i = bu.getInt(localdle.HSL, 30);; i = 30)
    {
      AppMethodBeat.o(134134);
      return i;
    }
  }
  
  public final int aHW()
  {
    AppMethodBeat.i(134135);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 5);
    }
    for (int i = bu.getInt(localdle.HSL, 0);; i = 0)
    {
      AppMethodBeat.o(134135);
      return i;
    }
  }
  
  public final boolean aHX()
  {
    AppMethodBeat.i(134136);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 7);
    }
    for (int i = bu.getInt(localdle.HSL, 0);; i = 0)
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
  
  public final boolean aHY()
  {
    AppMethodBeat.i(134137);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 10);
    }
    for (int i = bu.getInt(localdle.HSL, 0);; i = 0)
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
  
  public final String aHZ()
  {
    AppMethodBeat.i(134138);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 14);
    }
    for (localObject = localdle.HSL;; localObject = null)
    {
      AppMethodBeat.o(134138);
      return localObject;
    }
  }
  
  public final String aIa()
  {
    AppMethodBeat.i(134139);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 15);
    }
    for (localObject = localdle.HSL;; localObject = null)
    {
      AppMethodBeat.o(134139);
      return localObject;
    }
  }
  
  public final String aIb()
  {
    AppMethodBeat.i(134140);
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.FWp;
    AppMethodBeat.o(134140);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(134121);
    this.callback = paramf;
    paramf = (com.tencent.mm.protocal.n.a)this.hRG.getReqObj();
    if ((paramf.FGx.FWe == null) || (paramf.FGx.FWe.length() <= 0))
    {
      ae.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + paramf.FGx.FWe);
      AppMethodBeat.o(134121);
      return -1;
    }
    if (((paramf.FGx.FSQ == 6) || (paramf.FGx.FSQ == 9)) && ((paramf.FGx.FWf == null) || (paramf.FGx.FWf.length() <= 0)))
    {
      ae.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + paramf.FGx.FWe);
      AppMethodBeat.o(134121);
      return -1;
    }
    int i = dispatch(parame, this.hRG, this);
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
    String str = ((com.tencent.mm.protocal.n.b)this.hRG.getRespObj()).FGy.Username;
    AppMethodBeat.o(134124);
    return str;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134122);
    ae.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (com.tencent.mm.protocal.n.b)paramq.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.FGy != null))
    {
      paramInt1 = paramArrayOfByte.FGy.FRH;
      ae.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.ajS();
      g.ajR().gDO.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.e locale = g.ajQ().gDv.hRo;
      if (locale != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label219;
        }
        bool = true;
        locale.eK(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bd.a(true, paramArrayOfByte.FGy.FWy, paramArrayOfByte.FGy.FWz, paramArrayOfByte.FGy.FWx);
        this.hRl -= 1;
        if (this.hRl <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134122);
          return;
          label219:
          bool = false;
          break;
          ae.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[] { paramArrayOfByte });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134122);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ae.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hRl) });
      this.hRl -= 1;
      if (this.hRl <= 0)
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
      ae.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134113);
          new m().doScene(a.this.dispatcher(), new com.tencent.mm.ak.f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134112);
              ae.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      ae.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.FFV) });
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134122);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134122);
      return;
    }
    bd.a(false, paramArrayOfByte.FGy.FWy, paramArrayOfByte.FGy.FWz, paramArrayOfByte.FGy.FWx);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134122);
  }
  
  public final void pk(int paramInt)
  {
    AppMethodBeat.i(134118);
    ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FWm = paramInt;
    AppMethodBeat.o(134118);
  }
  
  public final void pl(int paramInt)
  {
    AppMethodBeat.i(134119);
    ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FWn = paramInt;
    AppMethodBeat.o(134119);
  }
  
  public final void pm(int paramInt)
  {
    AppMethodBeat.i(220272);
    ((com.tencent.mm.protocal.n.a)this.hRG.getReqObj()).FGx.FWo = paramInt;
    AppMethodBeat.o(220272);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final com.tencent.mm.ak.n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return com.tencent.mm.ak.n.b.hRi;
  }
  
  public final void setSecurityCheckError(com.tencent.mm.ak.n.a parama) {}
  
  public static abstract interface a
  {
    public abstract String aIc();
  }
  
  public static final class b
    extends l
  {
    private final com.tencent.mm.protocal.n.a hZO;
    private final com.tencent.mm.protocal.n.b hZP;
    
    public b()
    {
      AppMethodBeat.i(134114);
      this.hZO = new com.tencent.mm.protocal.n.a();
      this.hZP = new com.tencent.mm.protocal.n.b();
      AppMethodBeat.o(134114);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.hZO;
    }
    
    public final l.e getRespObj()
    {
      return this.hZP;
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