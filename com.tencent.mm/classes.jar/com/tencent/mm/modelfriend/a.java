package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.bj;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.n.b;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.protocal.protobuf.fck;
import com.tencent.mm.protocal.protobuf.fde;
import com.tencent.mm.protocal.protobuf.fjq;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends p
  implements m
{
  public static a oDC;
  private com.tencent.mm.am.h callback;
  public final com.tencent.mm.network.s ouH;
  private int ouk;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3, 0);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(134117);
    this.callback = null;
    this.ouk = 2;
    this.ouH = new b();
    n.a locala = (n.a)this.ouH.getReqObj();
    locala.Yyb.YKH = paramInt1;
    Log.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.Yyb.YOc = paramString1;
    locala.Yyb.YOd = paramString2;
    locala.Yyb.YOm = paramInt3;
    locala.Yyb.YOe = paramInt2;
    locala.Yyb.YOf = paramString3;
    locala.Yyb.yts = LocaleUtil.getApplicationLanguage();
    locala.Yyb.YJX = b.aZR();
    if ((Util.isNullOrNil(locala.Yyb.YOh)) && (Util.isNullOrNil(locala.Yyb.YOi)))
    {
      paramString2 = locala.Yyb;
      if (oDC == null) {
        break label233;
      }
    }
    label233:
    for (paramString1 = oDC.bJf();; paramString1 = "")
    {
      paramString2.YOh = paramString1;
      locala.Yyb.YOi = d.Yxf;
      AppMethodBeat.o(134117);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(134116);
    ((n.a)this.ouH.getReqObj()).Yyb.YJu = paramString4;
    AppMethodBeat.o(134116);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(134115);
    paramString1 = (n.a)this.ouH.getReqObj();
    paramString1.Yyb.YOh = paramString5;
    paramString1.Yyb.YOi = paramString6;
    AppMethodBeat.o(134115);
  }
  
  public final void NG(String paramString)
  {
    AppMethodBeat.i(239526);
    ((n.a)this.ouH.getReqObj()).Yyb.YOs = paramString;
    AppMethodBeat.o(239526);
  }
  
  public final void NH(String paramString)
  {
    AppMethodBeat.i(134141);
    ((n.a)this.ouH.getReqObj()).Yyb.YOn = paramString;
    AppMethodBeat.o(134141);
  }
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134142);
    fde localfde = new fde();
    localfde.AXR = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localfde.abCH = paramInt;
      ((n.a)this.ouH.getReqObj()).Yyb.YOq = localfde;
      AppMethodBeat.o(134142);
      return;
    }
  }
  
  public final void a(gdd paramgdd)
  {
    AppMethodBeat.i(134132);
    try
    {
      ((n.a)this.ouH.getReqObj()).Yyb.YKb = new gol().df(paramgdd.toByteArray());
      return;
    }
    finally
    {
      AppMethodBeat.o(134132);
    }
  }
  
  public final int bIO()
  {
    AppMethodBeat.i(134120);
    int i = ((n.a)this.ouH.getReqObj()).Yyb.YKH;
    AppMethodBeat.o(134120);
    return i;
  }
  
  public final String bIP()
  {
    AppMethodBeat.i(134123);
    String str = ((n.b)this.ouH.getRespObj()).Yyc.YOy;
    AppMethodBeat.o(134123);
    return str;
  }
  
  public final String bIQ()
  {
    AppMethodBeat.i(134125);
    String str = ((n.b)this.ouH.getRespObj()).Yyc.hFb;
    AppMethodBeat.o(134125);
    return str;
  }
  
  public final String bIR()
  {
    AppMethodBeat.i(134126);
    String str = ((n.b)this.ouH.getRespObj()).Yyc.YJu;
    AppMethodBeat.o(134126);
    return str;
  }
  
  public final String bIS()
  {
    AppMethodBeat.i(134127);
    String str = ((n.b)this.ouH.getRespObj()).Yyc.YOF;
    AppMethodBeat.o(134127);
    return str;
  }
  
  public final int bIT()
  {
    AppMethodBeat.i(134128);
    int i = ((n.b)this.ouH.getRespObj()).Yyc.YOm;
    AppMethodBeat.o(134128);
    return i;
  }
  
  public final String bIU()
  {
    AppMethodBeat.i(134129);
    String str = ((n.b)this.ouH.getRespObj()).Yyc.YOH;
    AppMethodBeat.o(134129);
    return str;
  }
  
  public final String bIV()
  {
    AppMethodBeat.i(134130);
    String str = ((n.b)this.ouH.getRespObj()).Yyc.YOI;
    AppMethodBeat.o(134130);
    return str;
  }
  
  public final dtr bIW()
  {
    AppMethodBeat.i(239619);
    dtr localdtr = ((n.b)this.ouH.getRespObj()).Yyc.YOr;
    AppMethodBeat.o(239619);
    return localdtr;
  }
  
  public final int bIX()
  {
    AppMethodBeat.i(134133);
    Object localObject = ((n.b)this.ouH.getRespObj()).Yyc.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 6);
    }
    for (int i = Util.getInt(localfjq.abKm, 3);; i = 3)
    {
      AppMethodBeat.o(134133);
      return i;
    }
  }
  
  public final int bIY()
  {
    AppMethodBeat.i(134134);
    Object localObject = ((n.b)this.ouH.getRespObj()).Yyc.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 4);
    }
    for (int i = Util.getInt(localfjq.abKm, 30);; i = 30)
    {
      AppMethodBeat.o(134134);
      return i;
    }
  }
  
  public final int bIZ()
  {
    AppMethodBeat.i(134135);
    Object localObject = ((n.b)this.ouH.getRespObj()).Yyc.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 5);
    }
    for (int i = Util.getInt(localfjq.abKm, 0);; i = 0)
    {
      AppMethodBeat.o(134135);
      return i;
    }
  }
  
  public final boolean bJa()
  {
    AppMethodBeat.i(134136);
    Object localObject = ((n.b)this.ouH.getRespObj()).Yyc.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 7);
    }
    for (int i = Util.getInt(localfjq.abKm, 0);; i = 0)
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
  
  public final boolean bJb()
  {
    AppMethodBeat.i(134137);
    Object localObject = ((n.b)this.ouH.getRespObj()).Yyc.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 10);
    }
    for (int i = Util.getInt(localfjq.abKm, 0);; i = 0)
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
  
  public final String bJc()
  {
    AppMethodBeat.i(134138);
    Object localObject = ((n.b)this.ouH.getRespObj()).Yyc.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 14);
    }
    for (localObject = localfjq.abKm;; localObject = null)
    {
      AppMethodBeat.o(134138);
      return localObject;
    }
  }
  
  public final String bJd()
  {
    AppMethodBeat.i(134139);
    Object localObject = ((n.b)this.ouH.getRespObj()).Yyc.YJt;
    fjq localfjq;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject).next();
      } while (localfjq.OzG != 15);
    }
    for (localObject = localfjq.abKm;; localObject = null)
    {
      AppMethodBeat.o(134139);
      return localObject;
    }
  }
  
  public final String bJe()
  {
    AppMethodBeat.i(134140);
    String str = ((n.b)this.ouH.getRespObj()).Yyc.YOn;
    AppMethodBeat.o(134140);
    return str;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(134121);
    this.callback = paramh;
    paramh = (n.a)this.ouH.getReqObj();
    if ((paramh.Yyb.YOc == null) || (paramh.Yyb.YOc.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + paramh.Yyb.YOc);
      AppMethodBeat.o(134121);
      return -1;
    }
    if (((paramh.Yyb.YKH == 6) || (paramh.Yyb.YKH == 9)) && ((paramh.Yyb.YOd == null) || (paramh.Yyb.YOd.length() <= 0)))
    {
      Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + paramh.Yyb.YOc);
      AppMethodBeat.o(134121);
      return -1;
    }
    int i = dispatch(paramg, this.ouH, this);
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
    String str = ((n.b)this.ouH.getRespObj()).Yyc.Username;
    AppMethodBeat.o(134124);
    return str;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134122);
    Log.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (n.b)params.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.Yyc != null))
    {
      paramInt1 = paramArrayOfByte.Yyc.YJy;
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().mCE.B(47, Integer.valueOf(paramInt1));
      g localg = com.tencent.mm.kernel.h.baD().mCm.oun;
      if (localg != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label218;
        }
        bool = true;
        localg.hd(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bj.a(true, paramArrayOfByte.Yyc.YOA, paramArrayOfByte.Yyc.YOB, paramArrayOfByte.Yyc.YOz, true, 0);
        this.ouk -= 1;
        if (this.ouk <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134122);
          return;
          label218:
          bool = false;
          break;
          Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[] { paramArrayOfByte });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134122);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ouk) });
      this.ouk -= 1;
      if (this.ouk <= 0)
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
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134113);
          new o().doScene(a.a(a.this), new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(134112);
              Log.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                a.b(a.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", a.this);
                AppMethodBeat.o(134112);
                return;
              }
              a.this.doScene(a.c(a.this), a.b(a.this));
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
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.iPL()) });
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134122);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134122);
      return;
    }
    bj.a(false, paramArrayOfByte.Yyc.YOA, paramArrayOfByte.Yyc.YOB, paramArrayOfByte.Yyc.YOz, false, 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134122);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
  
  public final void wd(int paramInt)
  {
    AppMethodBeat.i(134118);
    ((n.a)this.ouH.getReqObj()).Yyb.YOk = paramInt;
    AppMethodBeat.o(134118);
  }
  
  public final void we(int paramInt)
  {
    AppMethodBeat.i(134119);
    ((n.a)this.ouH.getReqObj()).Yyb.YOl = paramInt;
    AppMethodBeat.o(134119);
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(239623);
    ((n.a)this.ouH.getReqObj()).Yyb.YOm = paramInt;
    AppMethodBeat.o(239623);
  }
  
  public static abstract interface a
  {
    public abstract String bJf();
  }
  
  public static final class b
    extends n
  {
    private final n.a oDG;
    private final n.b oDH;
    
    public b()
    {
      AppMethodBeat.i(134114);
      this.oDG = new n.a();
      this.oDH = new n.b();
      AppMethodBeat.o(134114);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.oDG;
    }
    
    public final l.e getRespObj()
    {
      return this.oDH;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a
 * JD-Core Version:    0.7.0.1
 */