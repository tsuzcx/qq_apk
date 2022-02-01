package com.tencent.mm.modelfriend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.o;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.n.b;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eix;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.protocal.protobuf.ly;
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
  public static a lLa;
  private i callback;
  private int lCA;
  public final s lCW;
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3, 0);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(134117);
    this.callback = null;
    this.lCA = 2;
    this.lCW = new b();
    n.a locala = (n.a)this.lCW.getReqObj();
    locala.RBy.RNt = paramInt1;
    Log.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.RBy.RQN = paramString1;
    locala.RBy.RQO = paramString2;
    locala.RBy.RQX = paramInt3;
    locala.RBy.RQP = paramInt2;
    locala.RBy.RQQ = paramString3;
    locala.RBy.vhq = LocaleUtil.getApplicationLanguage();
    locala.RBy.RMJ = b.aGR();
    if ((Util.isNullOrNil(locala.RBy.RQS)) && (Util.isNullOrNil(locala.RBy.RQT)))
    {
      paramString2 = locala.RBy;
      if (lLa == null) {
        break label236;
      }
    }
    label236:
    for (paramString1 = lLa.bll();; paramString1 = "")
    {
      paramString2.RQS = paramString1;
      locala.RBy.RQT = d.RAB;
      AppMethodBeat.o(134117);
      return;
    }
  }
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(134116);
    ((n.a)this.lCW.getReqObj()).RBy.RMg = paramString4;
    AppMethodBeat.o(134116);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, paramString3, paramString4);
    AppMethodBeat.i(134115);
    paramString1 = (n.a)this.lCW.getReqObj();
    paramString1.RBy.RQS = paramString5;
    paramString1.RBy.RQT = paramString6;
    AppMethodBeat.o(134115);
  }
  
  public final void H(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134142);
    eix localeix = new eix();
    localeix.FOy = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localeix.UkQ = paramInt;
      ((n.a)this.lCW.getReqObj()).RBy.RRb = localeix;
      AppMethodBeat.o(134142);
      return;
    }
  }
  
  public final void VG(String paramString)
  {
    AppMethodBeat.i(186454);
    ((n.a)this.lCW.getReqObj()).RBy.RRd = paramString;
    AppMethodBeat.o(186454);
  }
  
  public final void VH(String paramString)
  {
    AppMethodBeat.i(134141);
    ((n.a)this.lCW.getReqObj()).RBy.RQY = paramString;
    AppMethodBeat.o(134141);
  }
  
  public final int ZB()
  {
    AppMethodBeat.i(134120);
    int i = ((n.a)this.lCW.getReqObj()).RBy.RNt;
    AppMethodBeat.o(134120);
    return i;
  }
  
  public final void a(fgr paramfgr)
  {
    AppMethodBeat.i(134132);
    try
    {
      ((n.a)this.lCW.getReqObj()).RBy.RMN = new eae().dc(paramfgr.toByteArray());
      AppMethodBeat.o(134132);
      return;
    }
    catch (Throwable paramfgr)
    {
      AppMethodBeat.o(134132);
    }
  }
  
  public final String bkV()
  {
    AppMethodBeat.i(134123);
    String str = ((n.b)this.lCW.getRespObj()).RBz.RRg;
    AppMethodBeat.o(134123);
    return str;
  }
  
  public final String bkW()
  {
    AppMethodBeat.i(134125);
    String str = ((n.b)this.lCW.getRespObj()).RBz.fAo;
    AppMethodBeat.o(134125);
    return str;
  }
  
  public final String bkX()
  {
    AppMethodBeat.i(134126);
    String str = ((n.b)this.lCW.getRespObj()).RBz.RMg;
    AppMethodBeat.o(134126);
    return str;
  }
  
  public final String bkY()
  {
    AppMethodBeat.i(134127);
    String str = ((n.b)this.lCW.getRespObj()).RBz.RRn;
    AppMethodBeat.o(134127);
    return str;
  }
  
  public final int bkZ()
  {
    AppMethodBeat.i(134128);
    int i = ((n.b)this.lCW.getRespObj()).RBz.RQX;
    AppMethodBeat.o(134128);
    return i;
  }
  
  public final String bla()
  {
    AppMethodBeat.i(134129);
    String str = ((n.b)this.lCW.getRespObj()).RBz.RRp;
    AppMethodBeat.o(134129);
    return str;
  }
  
  public final String blb()
  {
    AppMethodBeat.i(134130);
    String str = ((n.b)this.lCW.getRespObj()).RBz.RRq;
    AppMethodBeat.o(134130);
    return str;
  }
  
  public final dbz blc()
  {
    AppMethodBeat.i(186478);
    dbz localdbz = ((n.b)this.lCW.getRespObj()).RBz.RRc;
    AppMethodBeat.o(186478);
    return localdbz;
  }
  
  public final int bld()
  {
    AppMethodBeat.i(134133);
    Object localObject = ((n.b)this.lCW.getRespObj()).RBz.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 6);
    }
    for (int i = Util.getInt(localeos.Uro, 3);; i = 3)
    {
      AppMethodBeat.o(134133);
      return i;
    }
  }
  
  public final int ble()
  {
    AppMethodBeat.i(134134);
    Object localObject = ((n.b)this.lCW.getRespObj()).RBz.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 4);
    }
    for (int i = Util.getInt(localeos.Uro, 30);; i = 30)
    {
      AppMethodBeat.o(134134);
      return i;
    }
  }
  
  public final int blf()
  {
    AppMethodBeat.i(134135);
    Object localObject = ((n.b)this.lCW.getRespObj()).RBz.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 5);
    }
    for (int i = Util.getInt(localeos.Uro, 0);; i = 0)
    {
      AppMethodBeat.o(134135);
      return i;
    }
  }
  
  public final boolean blg()
  {
    AppMethodBeat.i(134136);
    Object localObject = ((n.b)this.lCW.getRespObj()).RBz.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 7);
    }
    for (int i = Util.getInt(localeos.Uro, 0);; i = 0)
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
  
  public final boolean blh()
  {
    AppMethodBeat.i(134137);
    Object localObject = ((n.b)this.lCW.getRespObj()).RBz.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 10);
    }
    for (int i = Util.getInt(localeos.Uro, 0);; i = 0)
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
  
  public final String bli()
  {
    AppMethodBeat.i(134138);
    Object localObject = ((n.b)this.lCW.getRespObj()).RBz.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 14);
    }
    for (localObject = localeos.Uro;; localObject = null)
    {
      AppMethodBeat.o(134138);
      return localObject;
    }
  }
  
  public final String blj()
  {
    AppMethodBeat.i(134139);
    Object localObject = ((n.b)this.lCW.getRespObj()).RBz.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 15);
    }
    for (localObject = localeos.Uro;; localObject = null)
    {
      AppMethodBeat.o(134139);
      return localObject;
    }
  }
  
  public final String blk()
  {
    AppMethodBeat.i(134140);
    String str = ((n.b)this.lCW.getRespObj()).RBz.RQY;
    AppMethodBeat.o(134140);
    return str;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(134121);
    this.callback = parami;
    parami = (n.a)this.lCW.getReqObj();
    if ((parami.RBy.RQN == null) || (parami.RBy.RQN.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + parami.RBy.RQN);
      AppMethodBeat.o(134121);
      return -1;
    }
    if (((parami.RBy.RNt == 6) || (parami.RBy.RNt == 9)) && ((parami.RBy.RQO == null) || (parami.RBy.RQO.length() <= 0)))
    {
      Log.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + parami.RBy.RQN);
      AppMethodBeat.o(134121);
      return -1;
    }
    int i = dispatch(paramg, this.lCW, this);
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
    String str = ((n.b)this.lCW.getRespObj()).RBz.Username;
    AppMethodBeat.o(134124);
    return str;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134122);
    Log.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (n.b)params.getRespObj();
    boolean bool;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.RBz != null))
    {
      paramInt1 = paramArrayOfByte.RBz.RMk;
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[] { Integer.valueOf(paramInt1) });
      h.aHH();
      h.aHG().kcw.i(47, Integer.valueOf(paramInt1));
      g localg = h.aHF().kcd.lCD;
      if (localg != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label221;
        }
        bool = true;
        localg.gm(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bi.a(true, paramArrayOfByte.RBz.RRi, paramArrayOfByte.RBz.RRj, paramArrayOfByte.RBz.RRh, true, 0);
        this.lCA -= 1;
        if (this.lCA <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134122);
          return;
          label221:
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
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.lCA) });
      this.lCA -= 1;
      if (this.lCA <= 0)
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
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134113);
          new com.tencent.mm.modelsimple.m().doScene(a.a(a.this), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(134112);
              Log.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      Log.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindmobilereg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.hoP()) });
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
    bi.a(false, paramArrayOfByte.RBz.RRi, paramArrayOfByte.RBz.RRj, paramArrayOfByte.RBz.RRh, false, 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134122);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
  
  public final void vY(int paramInt)
  {
    AppMethodBeat.i(134118);
    ((n.a)this.lCW.getReqObj()).RBy.RQV = paramInt;
    AppMethodBeat.o(134118);
  }
  
  public final void vZ(int paramInt)
  {
    AppMethodBeat.i(134119);
    ((n.a)this.lCW.getReqObj()).RBy.RQW = paramInt;
    AppMethodBeat.o(134119);
  }
  
  public final void wa(int paramInt)
  {
    AppMethodBeat.i(186479);
    ((n.a)this.lCW.getReqObj()).RBy.RQX = paramInt;
    AppMethodBeat.o(186479);
  }
  
  public static abstract interface a
  {
    public abstract String bll();
  }
  
  public static final class b
    extends o
  {
    private final n.a lLe;
    private final n.b lLf;
    
    public b()
    {
      AppMethodBeat.i(134114);
      this.lLe = new n.a();
      this.lLf = new n.b();
      AppMethodBeat.o(134114);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.lLe;
    }
    
    public final l.e getRespObj()
    {
      return this.lLf;
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