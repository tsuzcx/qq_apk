package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.b.p;
import com.tencent.mm.ba.i;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends n
  implements k
{
  com.tencent.mm.ak.f callback;
  public com.tencent.mm.network.q hRG;
  private int hRl;
  private final String ipb;
  private final String ipc;
  private final String ipd;
  private final String ipe;
  private final String ipf;
  private final String ipg;
  private final int iph;
  private final int ipi;
  private boolean ipj;
  public boolean ipk;
  
  public v(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(134188);
    this.ipj = true;
    this.ipk = false;
    this.hRl = 2;
    ae.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    ae.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    ae.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.ipi = paramInt2;
    this.hRG = new bf();
    x.a locala = (x.a)this.hRG.getReqObj();
    locala.setUin(0);
    locala.FGX.nIJ = paramString1;
    locala.FGX.FWw = bu.aSv(paramString2);
    if (paramInt2 == 4)
    {
      locala.FGX.FWw = paramString6;
      ae.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.FGX.FWw);
    }
    locala.FGX.nJO = paramString3;
    locala.FGX.FKD = paramInt1;
    locala.FGX.FKE = paramString4;
    locala.FGX.FKF = paramString5;
    locala.FGX.xrf = paramString6;
    locala.FGX.GXb = paramInt2;
    locala.FGX.qkM = bu.fpH();
    locala.FGX.GwD = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.FGX.qkN = ad.fom();
    locala.FGX.FSf = 0;
    locala.FGX.HpU = 0;
    locala.FGX.HpV = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
    locala.FGX.Gzg = com.tencent.mm.compatible.deviceinfo.q.aaE();
    locala.FGX.HpW = ak.getContext().getSharedPreferences(ak.fow(), 0).getString("installreferer", "");
    locala.FGX.HpX = com.tencent.mm.plugin.normsg.a.b.wJt.MD(2);
    locala.FGX.HpY = ak.getContext().getSharedPreferences(ak.fow() + "_google_aid", com.tencent.mm.compatible.util.g.abv()).getString("getgoogleaid", "");
    this.ipb = paramString1;
    this.ipc = paramString2;
    this.ipd = paramString3;
    this.ipe = paramString4;
    this.ipf = paramString5;
    this.iph = paramInt1;
    this.ipg = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ipj = bool;
      locala.FGX.FSg = com.tencent.mm.kernel.a.ajd();
      AppMethodBeat.o(134188);
      return;
    }
  }
  
  public v(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134189);
    this.ipj = true;
    this.ipk = false;
    this.hRl = 2;
    ae.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, bu.aSM(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.ipi = paramInt2;
    this.hRG = new bf();
    paramString6 = (x.a)this.hRG.getReqObj();
    paramString6.setUin(0);
    paramString6.FGX.nIJ = paramString1;
    paramString6.FGX.FWw = bu.aSv(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.FGX.FWw = paramString8;
      ae.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.FGX.FWw);
    }
    paramString6.FGX.nJO = paramString3;
    paramString6.FGX.FKD = paramInt1;
    paramString6.FGX.FKE = paramString4;
    paramString6.FGX.FKF = paramString5;
    paramString6.FGX.xrf = paramString8;
    paramString6.FGX.GXb = paramInt2;
    paramString6.FGX.qkM = bu.fpH();
    paramString6.FGX.GwD = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    paramString6.FGX.qkN = ad.fom();
    paramString6.FGX.FSf = 0;
    paramString6.FGX.jga = paramString9;
    paramString6.FGX.GXa = paramString11;
    paramString6.FGX.GWZ = paramString10;
    paramString7 = paramString6.FGX;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.FWi = paramInt2;
      paramString7 = paramString6.FGX;
      if (!paramBoolean2) {
        break label643;
      }
      paramInt2 = 1;
      label427:
      paramString7.HpT = paramInt2;
      paramString6.FGX.FSg = com.tencent.mm.kernel.a.ajd();
      paramString6.FGX.HpV = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
      paramString6.FGX.Gzg = com.tencent.mm.compatible.deviceinfo.q.aaE();
      paramString6.FGX.HpW = ak.getContext().getSharedPreferences(ak.fow(), 0).getString("installreferer", "");
      paramString6.FGX.HpX = com.tencent.mm.plugin.normsg.a.b.wJt.MD(2);
      paramString6.FGX.HpY = ak.getContext().getSharedPreferences(ak.fow() + "_google_aid", com.tencent.mm.compatible.util.g.abv()).getString("getgoogleaid", "");
      this.ipb = paramString1;
      this.ipc = paramString2;
      this.ipd = paramString3;
      this.ipe = paramString4;
      this.ipf = paramString5;
      this.iph = paramInt1;
      this.ipg = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label649;
      }
    }
    label643:
    label649:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.ipj = paramBoolean1;
      AppMethodBeat.o(134189);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label427;
    }
  }
  
  public final void GP(String paramString)
  {
    AppMethodBeat.i(134192);
    if (!bu.isNullOrNil(paramString))
    {
      ((x.a)this.hRG.getReqObj()).FGX.FWp = paramString;
      ae.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134192);
  }
  
  public final void GQ(String paramString)
  {
    AppMethodBeat.i(134193);
    if (!bu.isNullOrNil(paramString))
    {
      ((x.a)this.hRG.getReqObj()).FGX.Hqd = paramString;
      ae.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134193);
  }
  
  public final String aLi()
  {
    AppMethodBeat.i(134196);
    String str = ((x.b)this.hRG.getRespObj()).FGY.GWZ;
    AppMethodBeat.o(134196);
    return str;
  }
  
  public final byte[] aLj()
  {
    AppMethodBeat.i(134195);
    byte[] arrayOfByte = z.a(((x.b)this.hRG.getRespObj()).FGY.GXc, new byte[0]);
    AppMethodBeat.o(134195);
    return arrayOfByte;
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(134197);
    String str = ((x.b)this.hRG.getRespObj()).FGY.Hql;
    AppMethodBeat.o(134197);
    return str;
  }
  
  public final int aLt()
  {
    AppMethodBeat.i(134198);
    Object localObject = ((x.b)this.hRG.getRespObj()).FGY.FRC;
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
      } while (localdle.yxe != 1);
    }
    for (int i = bu.getInt(localdle.HSL, 0);; i = 0)
    {
      AppMethodBeat.o(134198);
      return i;
    }
  }
  
  public final String aLu()
  {
    AppMethodBeat.i(134199);
    Object localObject = ((x.b)this.hRG.getRespObj()).FGY.FRC;
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
      } while (localdle.yxe != 2);
    }
    for (localObject = localdle.HSL;; localObject = "")
    {
      AppMethodBeat.o(134199);
      return localObject;
    }
  }
  
  public final int aLv()
  {
    AppMethodBeat.i(134200);
    Object localObject = ((x.b)this.hRG.getRespObj()).FGY.FRC;
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
      } while (localdle.yxe != 3);
    }
    for (int i = bu.getInt(localdle.HSL, 2);; i = 2)
    {
      AppMethodBeat.o(134200);
      return i;
    }
  }
  
  public final String aLw()
  {
    AppMethodBeat.i(134201);
    Object localObject = ((x.b)this.hRG.getRespObj()).FGY.FRC;
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
      } while (localdle.yxe != 17);
    }
    for (localObject = localdle.HSL;; localObject = null)
    {
      AppMethodBeat.o(134201);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(134191);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(134191);
    return i;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134194);
    paramArrayOfByte = (x.b)paramq.getRespObj();
    Object localObject1;
    if (paramArrayOfByte.FGY != null)
    {
      paramInt1 = paramArrayOfByte.FGY.FRH;
      ae.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().gDO.set(47, Integer.valueOf(paramInt1));
      localObject1 = com.tencent.mm.kernel.g.ajQ().gDv.hRo;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label185;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject1).eK(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bd.a(true, paramArrayOfByte.FGY.FWy, paramArrayOfByte.FGY.FWz, paramArrayOfByte.FGY.FWx);
        this.hRl -= 1;
        if (this.hRl <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134194);
          return;
          label185:
          bool = false;
          break;
          ae.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[] { Integer.valueOf(paramArrayOfByte.getRetCode()) });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134194);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ae.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hRl) });
      this.hRl -= 1;
      if (this.hRl <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134194);
        return;
      }
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134194);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ae.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134186);
          new m().doScene(v.this.dispatcher(), new com.tencent.mm.ak.f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134185);
              ae.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                v.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", v.this);
                AppMethodBeat.o(134185);
                return;
              }
              v.this.doScene(v.this.dispatcher(), v.this.callback);
              AppMethodBeat.o(134185);
            }
          });
          AppMethodBeat.o(134186);
        }
      });
      AppMethodBeat.o(134194);
      return;
    }
    if ((paramInt2 == 4) && ((paramInt3 == -305) || (paramInt3 == -306)))
    {
      ae.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.FFV) });
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134194);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
    }
    paramq = (x.a)paramq.getReqObj();
    ae.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.FGY.qkE + " regtype:" + paramArrayOfByte.FGY.FKH + " mode:" + paramq.FGX.GXb);
    if ((paramArrayOfByte.FGY.qkC != 0) && (!this.ipj))
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.mT(paramArrayOfByte.FGY.qkC);
      com.tencent.mm.kernel.g.ajR().ajA().set(2, paramq.FGX.nIJ);
      com.tencent.mm.kernel.g.ajR().ajA().set(16, Integer.valueOf(1));
      com.tencent.mm.kernel.g.ajR().ajA().set(52, Integer.valueOf(paramArrayOfByte.FGY.FKH));
      com.tencent.mm.kernel.g.ajR().ajA().set(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.ajR().ajA().set(340241, Boolean.TRUE);
      if ((this.ipb != null) && (this.ipb.length() > 0) && (this.ipi != 1)) {
        paramArrayOfByte.FGY.nIJ = this.ipb;
      }
      paramArrayOfByte.FGY.FKE = this.ipe;
      paramArrayOfByte.FGY.nJb = 0;
      if ((!com.tencent.mm.kernel.g.ajM()) || (com.tencent.mm.kernel.g.ajR().ajA() == null)) {
        break label1561;
      }
      paramq = this.ipg;
      paramInt1 = this.iph;
      localObject1 = this.ipd;
      String str1 = this.ipf;
      String str2 = paramArrayOfByte.FGY.nIJ;
      String str3 = paramArrayOfByte.FGY.FKE;
      int i = paramArrayOfByte.FGY.nJb;
      String str4 = paramArrayOfByte.FGY.FKK;
      String str5 = paramArrayOfByte.FGY.FKL;
      int j = paramArrayOfByte.FGY.FKM;
      int k = paramArrayOfByte.FGY.Hqf;
      String str6 = paramArrayOfByte.FGY.FJg;
      String str7 = paramArrayOfByte.FGY.FKN;
      String str8 = paramArrayOfByte.FGY.FRz;
      Object localObject2 = paramArrayOfByte.FGY.Hqe;
      ae.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, paramq, p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), bu.aSM(str6), str7, Integer.valueOf(0), bu.aSM(str8), bu.aSM(null), bu.aSM(null), bu.aSM(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = com.tencent.mm.kernel.g.ajR().ajA();
      bb.hIK.aM("login_weixin_username", str2);
      bb.hIK.aM("last_login_nick_name", (String)localObject1);
      bb.hIK.h(str1, paramInt1, str3);
      ((aj)localObject2).set(2, str2);
      ((aj)localObject2).set(42, paramq);
      ((aj)localObject2).set(9, Integer.valueOf(paramInt1));
      ((aj)localObject2).set(4, localObject1);
      ((aj)localObject2).set(5, str3);
      ((aj)localObject2).set(6, str1);
      ((aj)localObject2).set(7, Integer.valueOf(i));
      ((aj)localObject2).set(21, str4);
      ((aj)localObject2).set(22, str5);
      ((aj)localObject2).set(57, Integer.valueOf(0));
      ((aj)localObject2).set(17, Integer.valueOf(j));
      ((aj)localObject2).set(25, Integer.valueOf(k));
      ((aj)localObject2).set(1, str6);
      ((aj)localObject2).set(29, str7);
      ((aj)localObject2).set(34, Integer.valueOf(0));
      ((aj)localObject2).set(256, Boolean.FALSE);
      ae.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((aj)localObject2).set(-1535680990, str8);
      ((aj)localObject2).set(46, null);
      ((aj)localObject2).set(72, null);
      ((aj)localObject2).set(64, Integer.valueOf(-1));
      ((aj)localObject2).fuc();
      ((PluginAuth)com.tencent.mm.kernel.g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.ipg, this.iph, this.ipd, this.ipf, 0);
      bd.a(false, paramArrayOfByte.FGY.FWy, paramArrayOfByte.FGY.FWz, paramArrayOfByte.FGY.FWx);
      com.tencent.mm.kernel.g.ajR().ajA().fuc();
      com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(134187);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(134187);
            return;
          }
          paramAnonymouse.aFs().a(paramArrayOfByte.aak(1), paramArrayOfByte.aak(2), paramArrayOfByte.aak(3), paramArrayOfByte.FGY.qkC);
          AppMethodBeat.o(134187);
        }
      }), 0);
      ae.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.FGY.Hqh);
      if ((paramArrayOfByte.FGY.Hqh & 0x1) == 0) {
        break label1611;
      }
    }
    label1561:
    label1611:
    for (boolean bool = true;; bool = false)
    {
      this.ipk = bool;
      paramq = new LinkedList();
      paramq.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new i(paramq));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
      bool = com.tencent.mm.kernel.g.ajM();
      com.tencent.mm.kernel.g.ajP();
      ae.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), p.getString(com.tencent.mm.kernel.a.getUin()), com.tencent.mm.kernel.g.ajR().ajA() });
      break;
    }
  }
  
  public final void pW(int paramInt)
  {
    AppMethodBeat.i(134190);
    ((x.a)this.hRG.getReqObj()).FGX.FWo = paramInt;
    AppMethodBeat.o(134190);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */