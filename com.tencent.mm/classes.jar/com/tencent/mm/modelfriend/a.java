package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.n.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends q
  implements com.tencent.mm.network.m
{
  public static a.a iUI;
  i callback;
  public final s iMO;
  private int iMt;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3, 0);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(134117);
    this.callback = null;
    this.iMt = 2;
    this.iMO = new a.b();
    n.a locala = (n.a)this.iMO.getReqObj();
    locala.KzI.KMz = paramInt1;
    Log.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.KzI.KPP = paramString1;
    locala.KzI.KPQ = paramString2;
    locala.KzI.KPZ = paramInt3;
    locala.KzI.KPR = paramInt2;
    locala.KzI.KPS = paramString3;
    locala.KzI.rBI = LocaleUtil.getApplicationLanguage();
    locala.KzI.KLN = com.tencent.mm.kernel.a.azt();
    if ((Util.isNullOrNil(locala.KzI.KPU)) && (Util.isNullOrNil(locala.KzI.KPV)))
    {
      paramString2 = locala.KzI;
      if (iUI == null) {
        break label236;
      }
    }
    label236:
    for (paramString1 = iUI.bbV();; paramString1 = "")
    {
      paramString2.KPU = paramString1;
      locala.KzI.KPV = d.DEVICE_NAME;
      AppMethodBeat.o(134117);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(134116);
    ((n.a)this.iMO.getReqObj()).KzI.KLk = paramString4;
    AppMethodBeat.o(134116);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(134115);
    paramString1 = (n.a)this.iMO.getReqObj();
    paramString1.KzI.KPU = paramString5;
    paramString1.KzI.KPV = paramString6;
    AppMethodBeat.o(134115);
  }
  
  public final void F(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134142);
    dyx localdyx = new dyx();
    localdyx.AhC = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localdyx.MYy = paramInt;
      ((n.a)this.iMO.getReqObj()).KzI.KQd = localdyx;
      AppMethodBeat.o(134142);
      return;
    }
  }
  
  public final void Oj(String paramString)
  {
    AppMethodBeat.i(222847);
    ((n.a)this.iMO.getReqObj()).KzI.KQf = paramString;
    AppMethodBeat.o(222847);
  }
  
  public final void Ok(String paramString)
  {
    AppMethodBeat.i(134141);
    ((n.a)this.iMO.getReqObj()).KzI.KQa = paramString;
    AppMethodBeat.o(134141);
  }
  
  public final int Vj()
  {
    AppMethodBeat.i(134120);
    int i = ((n.a)this.iMO.getReqObj()).KzI.KMz;
    AppMethodBeat.o(134120);
    return i;
  }
  
  public final void a(ewf paramewf)
  {
    AppMethodBeat.i(134132);
    try
    {
      ((n.a)this.iMO.getReqObj()).KzI.KLQ = new SKBuiltinBuffer_t().setBuffer(paramewf.toByteArray());
      AppMethodBeat.o(134132);
      return;
    }
    catch (Throwable paramewf)
    {
      AppMethodBeat.o(134132);
    }
  }
  
  public final String bbF()
  {
    AppMethodBeat.i(134123);
    String str = ((n.b)this.iMO.getRespObj()).KzJ.KQi;
    AppMethodBeat.o(134123);
    return str;
  }
  
  public final String bbG()
  {
    AppMethodBeat.i(134125);
    String str = ((n.b)this.iMO.getRespObj()).KzJ.dHx;
    AppMethodBeat.o(134125);
    return str;
  }
  
  public final String bbH()
  {
    AppMethodBeat.i(134126);
    String str = ((n.b)this.iMO.getRespObj()).KzJ.KLk;
    AppMethodBeat.o(134126);
    return str;
  }
  
  public final String bbI()
  {
    AppMethodBeat.i(134127);
    String str = ((n.b)this.iMO.getRespObj()).KzJ.KQp;
    AppMethodBeat.o(134127);
    return str;
  }
  
  public final int bbJ()
  {
    AppMethodBeat.i(134128);
    int i = ((n.b)this.iMO.getRespObj()).KzJ.KPZ;
    AppMethodBeat.o(134128);
    return i;
  }
  
  public final String bbK()
  {
    AppMethodBeat.i(134129);
    String str = ((n.b)this.iMO.getRespObj()).KzJ.KQr;
    AppMethodBeat.o(134129);
    return str;
  }
  
  public final String bbL()
  {
    AppMethodBeat.i(134130);
    String str = ((n.b)this.iMO.getRespObj()).KzJ.KQs;
    AppMethodBeat.o(134130);
    return str;
  }
  
  public final cta bbM()
  {
    AppMethodBeat.i(222848);
    cta localcta = ((n.b)this.iMO.getRespObj()).KzJ.KQe;
    AppMethodBeat.o(222848);
    return localcta;
  }
  
  public final int bbN()
  {
    AppMethodBeat.i(134133);
    Object localObject = ((n.b)this.iMO.getRespObj()).KzJ.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 6);
    }
    for (int i = Util.getInt(localeer.NeO, 3);; i = 3)
    {
      AppMethodBeat.o(134133);
      return i;
    }
  }
  
  public final int bbO()
  {
    AppMethodBeat.i(134134);
    Object localObject = ((n.b)this.iMO.getRespObj()).KzJ.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 4);
    }
    for (int i = Util.getInt(localeer.NeO, 30);; i = 30)
    {
      AppMethodBeat.o(134134);
      return i;
    }
  }
  
  public final int bbP()
  {
    AppMethodBeat.i(134135);
    Object localObject = ((n.b)this.iMO.getRespObj()).KzJ.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 5);
    }
    for (int i = Util.getInt(localeer.NeO, 0);; i = 0)
    {
      AppMethodBeat.o(134135);
      return i;
    }
  }
  
  public final boolean bbQ()
  {
    AppMethodBeat.i(134136);
    Object localObject = ((n.b)this.iMO.getRespObj()).KzJ.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 7);
    }
    for (int i = Util.getInt(localeer.NeO, 0);; i = 0)
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
  
  public final boolean bbR()
  {
    AppMethodBeat.i(134137);
    Object localObject = ((n.b)this.iMO.getRespObj()).KzJ.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 10);
    }
    for (int i = Util.getInt(localeer.NeO, 0);; i = 0)
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
  
  public final String bbS()
  {
    AppMethodBeat.i(134138);
    Object localObject = ((n.b)this.iMO.getRespObj()).KzJ.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 14);
    }
    for (localObject = localeer.NeO;; localObject = null)
    {
      AppMethodBeat.o(134138);
      return localObject;
    }
  }
  
  public final String bbT()
  {
    AppMethodBeat.i(134139);
    Object localObject = ((n.b)this.iMO.getRespObj()).KzJ.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 15);
    }
    for (localObject = localeer.NeO;; localObject = null)
    {
      AppMethodBeat.o(134139);
      return localObject;
    }
  }
  
  public final String bbU()
  {
    AppMethodBeat.i(134140);
    String str = ((n.b)this.iMO.getRespObj()).KzJ.KQa;
    AppMethodBeat.o(134140);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(134121);
    this.callback = parami;
    parami = (n.a)this.iMO.getReqObj();
    if ((parami.KzI.KPP == null) || (parami.KzI.KPP.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + parami.KzI.KPP);
      AppMethodBeat.o(134121);
      return -1;
    }
    if (((parami.KzI.KMz == 6) || (parami.KzI.KMz == 9)) && ((parami.KzI.KPQ == null) || (parami.KzI.KPQ.length() <= 0)))
    {
      Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + parami.KzI.KPP);
      AppMethodBeat.o(134121);
      return -1;
    }
    int i = dispatch(paramg, this.iMO, this);
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
    String str = ((n.b)this.iMO.getRespObj()).KzJ.Username;
    AppMethodBeat.o(134124);
    return str;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134122);
    Log.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (n.b)params.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.KzJ != null))
    {
      paramInt1 = paramArrayOfByte.KzJ.KLo;
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().hqB.set(47, Integer.valueOf(paramInt1));
      com.tencent.mm.network.g localg = com.tencent.mm.kernel.g.aAg().hqi.iMw;
      if (localg != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label219;
        }
        bool = true;
        localg.fB(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bh.a(true, paramArrayOfByte.KzJ.KQk, paramArrayOfByte.KzJ.KQl, paramArrayOfByte.KzJ.KQj);
        this.iMt -= 1;
        if (this.iMt <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134122);
          return;
          label219:
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
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.iMt) });
      this.iMt -= 1;
      if (this.iMt <= 0)
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
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134113);
          new com.tencent.mm.modelsimple.m().doScene(a.this.dispatcher(), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(134112);
              Log.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.Kze) });
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
    bh.a(false, paramArrayOfByte.KzJ.KQk, paramArrayOfByte.KzJ.KQl, paramArrayOfByte.KzJ.KQj);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134122);
  }
  
  public final void sZ(int paramInt)
  {
    AppMethodBeat.i(134118);
    ((n.a)this.iMO.getReqObj()).KzI.KPX = paramInt;
    AppMethodBeat.o(134118);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
  
  public final void ta(int paramInt)
  {
    AppMethodBeat.i(134119);
    ((n.a)this.iMO.getReqObj()).KzI.KPY = paramInt;
    AppMethodBeat.o(134119);
  }
  
  public final void tb(int paramInt)
  {
    AppMethodBeat.i(222849);
    ((n.a)this.iMO.getReqObj()).KzI.KPZ = paramInt;
    AppMethodBeat.o(222849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelfriend.a
 * JD-Core Version:    0.7.0.1
 */