package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.h;
import com.tencent.mm.bb.h.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.al.g callback;
  private int gVE;
  public com.tencent.mm.network.q gVZ;
  private final String hso;
  private final String hsp;
  private final String hsq;
  private final String hsr;
  private final String hss;
  private final String hst;
  private final int hsu;
  private final int hsv;
  private boolean hsw;
  public boolean hsx;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(134188);
    this.hsw = true;
    this.hsx = false;
    this.gVE = 2;
    ad.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    ad.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    ad.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.hsv = paramInt2;
    this.gVZ = new bc();
    x.a locala = (x.a)this.gVZ.getReqObj();
    locala.setUin(0);
    locala.Cra.mAQ = paramString1;
    locala.Cra.CGf = bt.aGb(paramString2);
    if (paramInt2 == 4)
    {
      locala.Cra.CGf = paramString6;
      ad.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.Cra.CGf);
    }
    locala.Cra.mBV = paramString3;
    locala.Cra.CuF = paramInt1;
    locala.Cra.CuG = paramString4;
    locala.Cra.CuH = paramString5;
    locala.Cra.Ddo = paramString6;
    locala.Cra.DyF = paramInt2;
    locala.Cra.oXr = bt.eGH();
    locala.Cra.Ddm = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.Cra.oXs = com.tencent.mm.sdk.platformtools.ac.eFu();
    locala.Cra.CBP = 0;
    locala.Cra.DQt = 0;
    locala.Cra.DQu = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
    locala.Cra.DfF = com.tencent.mm.compatible.deviceinfo.q.WX();
    locala.Cra.DQv = aj.getContext().getSharedPreferences(aj.eFD(), 0).getString("installreferer", "");
    locala.Cra.DQw = com.tencent.mm.plugin.normsg.a.b.ufs.Ix(2);
    locala.Cra.DQx = aj.getContext().getSharedPreferences(aj.eFD() + "_google_aid", com.tencent.mm.compatible.util.g.XN()).getString("getgoogleaid", "");
    this.hso = paramString1;
    this.hsp = paramString2;
    this.hsq = paramString3;
    this.hsr = paramString4;
    this.hss = paramString5;
    this.hsu = paramInt1;
    this.hst = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.hsw = bool;
      locala.Cra.CBQ = com.tencent.mm.kernel.a.aeM();
      AppMethodBeat.o(134188);
      return;
    }
  }
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134189);
    this.hsw = true;
    this.hsx = false;
    this.gVE = 2;
    ad.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, bt.aGs(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.hsv = paramInt2;
    this.gVZ = new bc();
    paramString6 = (x.a)this.gVZ.getReqObj();
    paramString6.setUin(0);
    paramString6.Cra.mAQ = paramString1;
    paramString6.Cra.CGf = bt.aGb(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.Cra.CGf = paramString8;
      ad.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.Cra.CGf);
    }
    paramString6.Cra.mBV = paramString3;
    paramString6.Cra.CuF = paramInt1;
    paramString6.Cra.CuG = paramString4;
    paramString6.Cra.CuH = paramString5;
    paramString6.Cra.Ddo = paramString8;
    paramString6.Cra.DyF = paramInt2;
    paramString6.Cra.oXr = bt.eGH();
    paramString6.Cra.Ddm = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    paramString6.Cra.oXs = com.tencent.mm.sdk.platformtools.ac.eFu();
    paramString6.Cra.CBP = 0;
    paramString6.Cra.ijR = paramString9;
    paramString6.Cra.DyE = paramString11;
    paramString6.Cra.DyD = paramString10;
    paramString7 = paramString6.Cra;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.CFR = paramInt2;
      paramString7 = paramString6.Cra;
      if (!paramBoolean2) {
        break label643;
      }
      paramInt2 = 1;
      label427:
      paramString7.DQs = paramInt2;
      paramString6.Cra.CBQ = com.tencent.mm.kernel.a.aeM();
      paramString6.Cra.DQu = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
      paramString6.Cra.DfF = com.tencent.mm.compatible.deviceinfo.q.WX();
      paramString6.Cra.DQv = aj.getContext().getSharedPreferences(aj.eFD(), 0).getString("installreferer", "");
      paramString6.Cra.DQw = com.tencent.mm.plugin.normsg.a.b.ufs.Ix(2);
      paramString6.Cra.DQx = aj.getContext().getSharedPreferences(aj.eFD() + "_google_aid", com.tencent.mm.compatible.util.g.XN()).getString("getgoogleaid", "");
      this.hso = paramString1;
      this.hsp = paramString2;
      this.hsq = paramString3;
      this.hsr = paramString4;
      this.hss = paramString5;
      this.hsu = paramInt1;
      this.hst = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label649;
      }
    }
    label643:
    label649:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.hsw = paramBoolean1;
      AppMethodBeat.o(134189);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label427;
    }
  }
  
  public final String aAK()
  {
    AppMethodBeat.i(134196);
    String str = ((x.b)this.gVZ.getRespObj()).Crb.DyD;
    AppMethodBeat.o(134196);
    return str;
  }
  
  public final byte[] aAL()
  {
    AppMethodBeat.i(134195);
    byte[] arrayOfByte = z.a(((x.b)this.gVZ.getRespObj()).Crb.DyG, new byte[0]);
    AppMethodBeat.o(134195);
    return arrayOfByte;
  }
  
  public final String aAU()
  {
    AppMethodBeat.i(134197);
    String str = ((x.b)this.gVZ.getRespObj()).Crb.DQK;
    AppMethodBeat.o(134197);
    return str;
  }
  
  public final int aAV()
  {
    AppMethodBeat.i(134198);
    Object localObject = ((x.b)this.gVZ.getRespObj()).Crb.CBm;
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
      } while (localczk.vJz != 1);
    }
    for (int i = bt.getInt(localczk.Ern, 0);; i = 0)
    {
      AppMethodBeat.o(134198);
      return i;
    }
  }
  
  public final String aAW()
  {
    AppMethodBeat.i(134199);
    Object localObject = ((x.b)this.gVZ.getRespObj()).Crb.CBm;
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
      } while (localczk.vJz != 2);
    }
    for (localObject = localczk.Ern;; localObject = "")
    {
      AppMethodBeat.o(134199);
      return localObject;
    }
  }
  
  public final int aAX()
  {
    AppMethodBeat.i(134200);
    Object localObject = ((x.b)this.gVZ.getRespObj()).Crb.CBm;
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
      } while (localczk.vJz != 3);
    }
    for (int i = bt.getInt(localczk.Ern, 2);; i = 2)
    {
      AppMethodBeat.o(134200);
      return i;
    }
  }
  
  public final String aAY()
  {
    AppMethodBeat.i(134201);
    Object localObject = ((x.b)this.gVZ.getRespObj()).Crb.CBm;
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
      } while (localczk.vJz != 17);
    }
    for (localObject = localczk.Ern;; localObject = null)
    {
      AppMethodBeat.o(134201);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(134191);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(134191);
    return i;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final void oC(int paramInt)
  {
    AppMethodBeat.i(134190);
    ((x.a)this.gVZ.getReqObj()).Cra.CFX = paramInt;
    AppMethodBeat.o(134190);
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134194);
    paramArrayOfByte = (x.b)paramq.getRespObj();
    Object localObject1;
    if (paramArrayOfByte.Crb != null)
    {
      paramInt1 = paramArrayOfByte.Crb.CBr;
      ad.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().gcR.set(47, Integer.valueOf(paramInt1));
      localObject1 = com.tencent.mm.kernel.g.afA().gcy.gVH;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label185;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject1).el(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        ba.a(true, paramArrayOfByte.Crb.CGh, paramArrayOfByte.Crb.CGi, paramArrayOfByte.Crb.CGg);
        this.gVE -= 1;
        if (this.gVE <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134194);
          return;
          label185:
          bool = false;
          break;
          ad.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[] { Integer.valueOf(paramArrayOfByte.getRetCode()) });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134194);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ad.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.gVE) });
      this.gVE -= 1;
      if (this.gVE <= 0)
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
      ad.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134186);
          new l().doScene(u.this.dispatcher(), new com.tencent.mm.al.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134185);
              ad.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                u.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", u.this);
                AppMethodBeat.o(134185);
                return;
              }
              u.this.doScene(u.this.dispatcher(), u.this.callback);
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
      ad.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.CpY) });
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
    ad.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.Crb.oXj + " regtype:" + paramArrayOfByte.Crb.CuJ + " mode:" + paramq.Cra.DyF);
    if ((paramArrayOfByte.Crb.oXh != 0) && (!this.hsw))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.ms(paramArrayOfByte.Crb.oXh);
      com.tencent.mm.kernel.g.afB().afk().set(2, paramq.Cra.mAQ);
      com.tencent.mm.kernel.g.afB().afk().set(16, Integer.valueOf(1));
      com.tencent.mm.kernel.g.afB().afk().set(52, Integer.valueOf(paramArrayOfByte.Crb.CuJ));
      com.tencent.mm.kernel.g.afB().afk().set(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.afB().afk().set(340241, Boolean.TRUE);
      if ((this.hso != null) && (this.hso.length() > 0) && (this.hsv != 1)) {
        paramArrayOfByte.Crb.mAQ = this.hso;
      }
      paramArrayOfByte.Crb.CuG = this.hsr;
      paramArrayOfByte.Crb.mBi = 0;
      if ((!com.tencent.mm.kernel.g.afw()) || (com.tencent.mm.kernel.g.afB().afk() == null)) {
        break label1561;
      }
      paramq = this.hst;
      paramInt1 = this.hsu;
      localObject1 = this.hsq;
      String str1 = this.hss;
      String str2 = paramArrayOfByte.Crb.mAQ;
      String str3 = paramArrayOfByte.Crb.CuG;
      int i = paramArrayOfByte.Crb.mBi;
      String str4 = paramArrayOfByte.Crb.CuM;
      String str5 = paramArrayOfByte.Crb.CuN;
      int j = paramArrayOfByte.Crb.CuO;
      int k = paramArrayOfByte.Crb.DQE;
      String str6 = paramArrayOfByte.Crb.Ctm;
      String str7 = paramArrayOfByte.Crb.CuP;
      String str8 = paramArrayOfByte.Crb.CBj;
      Object localObject2 = paramArrayOfByte.Crb.DQD;
      ad.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, paramq, p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), bt.aGs(str6), str7, Integer.valueOf(0), bt.aGs(str8), bt.aGs(null), bt.aGs(null), bt.aGs(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = com.tencent.mm.kernel.g.afB().afk();
      ay.gNa.aD("login_weixin_username", str2);
      ay.gNa.aD("last_login_nick_name", (String)localObject1);
      ay.gNa.g(str1, paramInt1, str3);
      ((ab)localObject2).set(2, str2);
      ((ab)localObject2).set(42, paramq);
      ((ab)localObject2).set(9, Integer.valueOf(paramInt1));
      ((ab)localObject2).set(4, localObject1);
      ((ab)localObject2).set(5, str3);
      ((ab)localObject2).set(6, str1);
      ((ab)localObject2).set(7, Integer.valueOf(i));
      ((ab)localObject2).set(21, str4);
      ((ab)localObject2).set(22, str5);
      ((ab)localObject2).set(57, Integer.valueOf(0));
      ((ab)localObject2).set(17, Integer.valueOf(j));
      ((ab)localObject2).set(25, Integer.valueOf(k));
      ((ab)localObject2).set(1, str6);
      ((ab)localObject2).set(29, str7);
      ((ab)localObject2).set(34, Integer.valueOf(0));
      ((ab)localObject2).set(256, Boolean.FALSE);
      ad.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((ab)localObject2).set(-1535680990, str8);
      ((ab)localObject2).set(46, null);
      ((ab)localObject2).set(72, null);
      ((ab)localObject2).set(64, Integer.valueOf(-1));
      ((ab)localObject2).eKy();
      ((PluginAuth)com.tencent.mm.kernel.g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.hst, this.hsu, this.hsq, this.hss, 0);
      ba.a(false, paramArrayOfByte.Crb.CGh, paramArrayOfByte.Crb.CGi, paramArrayOfByte.Crb.CGg);
      com.tencent.mm.kernel.g.afB().afk().eKy();
      com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(134187);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(134187);
            return;
          }
          paramAnonymouse.avg().a(paramArrayOfByte.Vz(1), paramArrayOfByte.Vz(2), paramArrayOfByte.Vz(3), paramArrayOfByte.Crb.oXh);
          AppMethodBeat.o(134187);
        }
      }), 0);
      ad.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.Crb.DQG);
      if ((paramArrayOfByte.Crb.DQG & 0x1) == 0) {
        break label1611;
      }
    }
    label1561:
    label1611:
    for (boolean bool = true;; bool = false)
    {
      this.hsx = bool;
      paramq = new LinkedList();
      paramq.add(new h.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new h(paramq));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
      bool = com.tencent.mm.kernel.g.afw();
      com.tencent.mm.kernel.g.afz();
      ad.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), p.getString(com.tencent.mm.kernel.a.getUin()), com.tencent.mm.kernel.g.afB().afk() });
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public final void zd(String paramString)
  {
    AppMethodBeat.i(134192);
    if (!bt.isNullOrNil(paramString))
    {
      ((x.a)this.gVZ.getReqObj()).Cra.CFY = paramString;
      ad.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134192);
  }
  
  public final void ze(String paramString)
  {
    AppMethodBeat.i(134193);
    if (!bt.isNullOrNil(paramString))
    {
      ((x.a)this.gVZ.getReqObj()).Cra.DQC = paramString;
      ad.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */