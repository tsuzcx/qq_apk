package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  public static a hEn;
  com.tencent.mm.ak.g callback;
  private int hwd;
  public final com.tencent.mm.network.q hwy;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3, 0);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(134117);
    this.callback = null;
    this.hwd = 2;
    this.hwy = new b();
    com.tencent.mm.protocal.n.a locala = (com.tencent.mm.protocal.n.a)this.hwy.getReqObj();
    locala.DIS.DUY = paramInt1;
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.DIS.DYn = paramString1;
    locala.DIS.DYo = paramString2;
    locala.DIS.DYx = paramInt3;
    locala.DIS.DYp = paramInt2;
    locala.DIS.DYq = paramString3;
    locala.DIS.pAD = ab.eUO();
    locala.DIS.DUo = com.tencent.mm.kernel.a.agc();
    if ((bs.isNullOrNil(locala.DIS.DYs)) && (bs.isNullOrNil(locala.DIS.DYt)))
    {
      paramString2 = locala.DIS;
      if (hEn == null) {
        break label236;
      }
    }
    label236:
    for (paramString1 = hEn.aEG();; paramString1 = "")
    {
      paramString2.DYs = paramString1;
      locala.DIS.DYt = d.DEVICE_NAME;
      AppMethodBeat.o(134117);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(134116);
    ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DTL = paramString4;
    AppMethodBeat.o(134116);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(134115);
    paramString1 = (com.tencent.mm.protocal.n.a)this.hwy.getReqObj();
    paramString1.DIS.DYs = paramString5;
    paramString1.DIS.DYt = paramString6;
    AppMethodBeat.o(134115);
  }
  
  public final void B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134142);
    czj localczj = new czj();
    localczj.FID = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localczj.FIE = paramInt;
      ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DYB = localczj;
      AppMethodBeat.o(134142);
      return;
    }
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(134141);
    ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DYy = paramString;
    AppMethodBeat.o(134141);
  }
  
  public final int Js()
  {
    AppMethodBeat.i(134120);
    int i = ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DUY;
    AppMethodBeat.o(134120);
    return i;
  }
  
  public final void a(dun paramdun)
  {
    AppMethodBeat.i(134132);
    try
    {
      ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DUr = new SKBuiltinBuffer_t().setBuffer(paramdun.toByteArray());
      AppMethodBeat.o(134132);
      return;
    }
    catch (Throwable paramdun)
    {
      AppMethodBeat.o(134132);
    }
  }
  
  public final int aEA()
  {
    AppMethodBeat.i(134135);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 5);
    }
    for (int i = bs.getInt(localdew.FOp, 0);; i = 0)
    {
      AppMethodBeat.o(134135);
      return i;
    }
  }
  
  public final boolean aEB()
  {
    AppMethodBeat.i(134136);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 7);
    }
    for (int i = bs.getInt(localdew.FOp, 0);; i = 0)
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
  
  public final boolean aEC()
  {
    AppMethodBeat.i(134137);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 10);
    }
    for (int i = bs.getInt(localdew.FOp, 0);; i = 0)
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
  
  public final String aED()
  {
    AppMethodBeat.i(134138);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 14);
    }
    for (localObject = localdew.FOp;; localObject = null)
    {
      AppMethodBeat.o(134138);
      return localObject;
    }
  }
  
  public final String aEE()
  {
    AppMethodBeat.i(134139);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 15);
    }
    for (localObject = localdew.FOp;; localObject = null)
    {
      AppMethodBeat.o(134139);
      return localObject;
    }
  }
  
  public final String aEF()
  {
    AppMethodBeat.i(134140);
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DYy;
    AppMethodBeat.o(134140);
    return str;
  }
  
  public final String aEq()
  {
    AppMethodBeat.i(134123);
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DYF;
    AppMethodBeat.o(134123);
    return str;
  }
  
  public final String aEr()
  {
    AppMethodBeat.i(134125);
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.ddJ;
    AppMethodBeat.o(134125);
    return str;
  }
  
  public final String aEs()
  {
    AppMethodBeat.i(134126);
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTL;
    AppMethodBeat.o(134126);
    return str;
  }
  
  public final String aEt()
  {
    AppMethodBeat.i(134127);
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DYM;
    AppMethodBeat.o(134127);
    return str;
  }
  
  public final int aEu()
  {
    AppMethodBeat.i(134128);
    int i = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DYx;
    AppMethodBeat.o(134128);
    return i;
  }
  
  public final String aEv()
  {
    AppMethodBeat.i(134129);
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DYO;
    AppMethodBeat.o(134129);
    return str;
  }
  
  public final String aEw()
  {
    AppMethodBeat.i(134130);
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DYP;
    AppMethodBeat.o(134130);
    return str;
  }
  
  public final bxk aEx()
  {
    AppMethodBeat.i(195778);
    bxk localbxk = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DYC;
    AppMethodBeat.o(195778);
    return localbxk;
  }
  
  public final int aEy()
  {
    AppMethodBeat.i(134133);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 6);
    }
    for (int i = bs.getInt(localdew.FOp, 3);; i = 3)
    {
      AppMethodBeat.o(134133);
      return i;
    }
  }
  
  public final int aEz()
  {
    AppMethodBeat.i(134134);
    Object localObject = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.DTK;
    dew localdew;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject).next();
      } while (localdew.wTD != 4);
    }
    for (int i = bs.getInt(localdew.FOp, 30);; i = 30)
    {
      AppMethodBeat.o(134134);
      return i;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(134121);
    this.callback = paramg;
    paramg = (com.tencent.mm.protocal.n.a)this.hwy.getReqObj();
    if ((paramg.DIS.DYn == null) || (paramg.DIS.DYn.length() <= 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + paramg.DIS.DYn);
      AppMethodBeat.o(134121);
      return -1;
    }
    if (((paramg.DIS.DUY == 6) || (paramg.DIS.DUY == 9)) && ((paramg.DIS.DYo == null) || (paramg.DIS.DYo.length() <= 0)))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + paramg.DIS.DYn);
      AppMethodBeat.o(134121);
      return -1;
    }
    int i = dispatch(parame, this.hwy, this);
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
    String str = ((com.tencent.mm.protocal.n.b)this.hwy.getRespObj()).DIT.Username;
    AppMethodBeat.o(134124);
    return str;
  }
  
  public final void oG(int paramInt)
  {
    AppMethodBeat.i(134118);
    ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DYv = paramInt;
    AppMethodBeat.o(134118);
  }
  
  public final void oH(int paramInt)
  {
    AppMethodBeat.i(134119);
    ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DYw = paramInt;
    AppMethodBeat.o(134119);
  }
  
  public final void oI(int paramInt)
  {
    AppMethodBeat.i(195779);
    ((com.tencent.mm.protocal.n.a)this.hwy.getReqObj()).DIS.DYx = paramInt;
    AppMethodBeat.o(195779);
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134122);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (com.tencent.mm.protocal.n.b)paramq.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.DIT != null))
    {
      paramInt1 = paramArrayOfByte.DIT.DTP;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().ghx.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.e locale = com.tencent.mm.kernel.g.agQ().ghe.hwg;
      if (locale != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label219;
        }
        bool = true;
        locale.eG(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        ba.a(true, paramArrayOfByte.DIT.DYH, paramArrayOfByte.DIT.DYI, paramArrayOfByte.DIT.DYG);
        this.hwd -= 1;
        if (this.hwd <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134122);
          return;
          label219:
          bool = false;
          break;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[] { paramArrayOfByte });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134122);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hwd) });
      this.hwd -= 1;
      if (this.hwd <= 0)
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
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134113);
          new com.tencent.mm.modelsimple.l().doScene(a.this.dispatcher(), new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134112);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.DIq) });
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134122);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134122);
      return;
    }
    ba.a(false, paramArrayOfByte.DIT.DYH, paramArrayOfByte.DIT.DYI, paramArrayOfByte.DIT.DYG);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134122);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final com.tencent.mm.ak.n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return com.tencent.mm.ak.n.b.hwa;
  }
  
  public final void setSecurityCheckError(com.tencent.mm.ak.n.a parama) {}
  
  public static abstract interface a
  {
    public abstract String aEG();
  }
  
  public static final class b
    extends com.tencent.mm.ak.l
  {
    private final com.tencent.mm.protocal.n.a hEr;
    private final com.tencent.mm.protocal.n.b hEs;
    
    public b()
    {
      AppMethodBeat.i(134114);
      this.hEr = new com.tencent.mm.protocal.n.a();
      this.hEs = new com.tencent.mm.protocal.n.b();
      AppMethodBeat.o(134114);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.hEr;
    }
    
    public final l.e getRespObj()
    {
      return this.hEs;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a
 * JD-Core Version:    0.7.0.1
 */