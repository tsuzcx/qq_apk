package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.bd.i.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.cs;
import com.tencent.mm.network.e;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.an.i callback;
  private int lCA;
  public s lCW;
  private final String maf;
  private final String mag;
  private final String mah;
  private final String mai;
  private final String maj;
  private final String mak;
  private final int mal;
  private final int mam;
  private boolean man;
  public boolean mao;
  
  public v(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(134188);
    this.man = true;
    this.mao = false;
    this.lCA = 2;
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.mam = paramInt2;
    this.lCW = new bk();
    x.a locala = (x.a)this.lCW.getReqObj();
    locala.setUin(0);
    locala.RBY.UserName = paramString1;
    locala.RBY.RRg = Util.getCutPasswordMD5(paramString2);
    if (paramInt2 == 4)
    {
      locala.RBY.RRg = paramString6;
      Log.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.RBY.RRg);
    }
    locala.RBY.rWI = paramString3;
    locala.RBY.RFr = paramInt1;
    locala.RBY.RFs = paramString4;
    locala.RBY.RFt = paramString5;
    locala.RBY.HlB = paramString6;
    locala.RBY.Swu = paramInt2;
    locala.RBY.vhp = Util.getTimeZoneOffset();
    locala.RBY.StL = com.tencent.mm.compatible.deviceinfo.q.auI();
    locala.RBY.vhq = LocaleUtil.getApplicationLanguage();
    locala.RBY.RMI = 0;
    locala.RBY.TKb = 0;
    locala.RBY.TKc = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
    locala.RBY.Sxu = com.tencent.mm.compatible.deviceinfo.q.auJ();
    locala.RBY.TKd = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
    locala.RBY.TKe = d.GxJ.aax(2);
    locala.RBY.TKf = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", com.tencent.mm.compatible.util.g.avK()).getString("getgoogleaid", "");
    locala.RBY.RGL = MMApplicationContext.getApplicationId();
    this.maf = paramString1;
    this.mag = paramString2;
    this.mah = paramString3;
    this.mai = paramString4;
    this.maj = paramString5;
    this.mal = paramInt1;
    this.mak = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.man = bool;
      locala.RBY.RMJ = com.tencent.mm.kernel.b.aGR();
      AppMethodBeat.o(134188);
      return;
    }
  }
  
  public v(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134189);
    this.man = true;
    this.mao = false;
    this.lCA = 2;
    Log.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, Util.secPrint(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.mam = paramInt2;
    this.lCW = new bk();
    paramString6 = (x.a)this.lCW.getReqObj();
    paramString6.setUin(0);
    paramString6.RBY.UserName = paramString1;
    paramString6.RBY.RRg = Util.getCutPasswordMD5(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.RBY.RRg = paramString8;
      Log.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.RBY.RRg);
    }
    paramString6.RBY.rWI = paramString3;
    paramString6.RBY.RFr = paramInt1;
    paramString6.RBY.RFs = paramString4;
    paramString6.RBY.RFt = paramString5;
    paramString6.RBY.HlB = paramString8;
    paramString6.RBY.Swu = paramInt2;
    paramString6.RBY.vhp = Util.getTimeZoneOffset();
    paramString6.RBY.StL = com.tencent.mm.compatible.deviceinfo.q.auI();
    paramString6.RBY.vhq = LocaleUtil.getApplicationLanguage();
    paramString6.RBY.RMI = 0;
    paramString6.RBY.mVD = paramString9;
    paramString6.RBY.Tlm = paramString11;
    paramString6.RBY.Tll = paramString10;
    paramString7 = paramString6.RBY;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.RQR = paramInt2;
      paramString7 = paramString6.RBY;
      if (!paramBoolean2) {
        break label654;
      }
      paramInt2 = 1;
      label427:
      paramString7.Swv = paramInt2;
      paramString6.RBY.RMJ = com.tencent.mm.kernel.b.aGR();
      paramString6.RBY.TKc = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
      paramString6.RBY.Sxu = com.tencent.mm.compatible.deviceinfo.q.auJ();
      paramString6.RBY.TKd = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
      paramString6.RBY.TKe = d.GxJ.aax(2);
      paramString6.RBY.TKf = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", com.tencent.mm.compatible.util.g.avK()).getString("getgoogleaid", "");
      paramString6.RBY.RGL = MMApplicationContext.getApplicationId();
      this.maf = paramString1;
      this.mag = paramString2;
      this.mah = paramString3;
      this.mai = paramString4;
      this.maj = paramString5;
      this.mal = paramInt1;
      this.mak = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label660;
      }
    }
    label654:
    label660:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.man = paramBoolean1;
      AppMethodBeat.o(134189);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label427;
    }
  }
  
  public final void WZ(String paramString)
  {
    AppMethodBeat.i(134192);
    if (!Util.isNullOrNil(paramString))
    {
      ((x.a)this.lCW.getReqObj()).RBY.RQY = paramString;
      Log.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134192);
  }
  
  public final void Xa(String paramString)
  {
    AppMethodBeat.i(134193);
    if (!Util.isNullOrNil(paramString))
    {
      ((x.a)this.lCW.getReqObj()).RBY.TKj = paramString;
      Log.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134193);
  }
  
  public final String boB()
  {
    AppMethodBeat.i(134196);
    String str = ((x.b)this.lCW.getRespObj()).RBZ.Tll;
    AppMethodBeat.o(134196);
    return str;
  }
  
  public final byte[] boC()
  {
    AppMethodBeat.i(134195);
    byte[] arrayOfByte = z.a(((x.b)this.lCW.getRespObj()).RBZ.Tln, new byte[0]);
    AppMethodBeat.o(134195);
    return arrayOfByte;
  }
  
  public final String boL()
  {
    AppMethodBeat.i(134197);
    String str = ((x.b)this.lCW.getRespObj()).RBZ.TKs;
    AppMethodBeat.o(134197);
    return str;
  }
  
  public final int boM()
  {
    AppMethodBeat.i(134198);
    Object localObject = ((x.b)this.lCW.getRespObj()).RBZ.RMf;
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
      } while (localeos.IyZ != 1);
    }
    for (int i = Util.getInt(localeos.Uro, 0);; i = 0)
    {
      AppMethodBeat.o(134198);
      return i;
    }
  }
  
  public final String boN()
  {
    AppMethodBeat.i(134199);
    Object localObject = ((x.b)this.lCW.getRespObj()).RBZ.RMf;
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
      } while (localeos.IyZ != 2);
    }
    for (localObject = localeos.Uro;; localObject = "")
    {
      AppMethodBeat.o(134199);
      return localObject;
    }
  }
  
  public final int boO()
  {
    AppMethodBeat.i(134200);
    Object localObject = ((x.b)this.lCW.getRespObj()).RBZ.RMf;
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
      } while (localeos.IyZ != 3);
    }
    for (int i = Util.getInt(localeos.Uro, 2);; i = 2)
    {
      AppMethodBeat.o(134200);
      return i;
    }
  }
  
  public final String boP()
  {
    AppMethodBeat.i(134201);
    Object localObject = ((x.b)this.lCW.getRespObj()).RBZ.RMf;
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
      } while (localeos.IyZ != 17);
    }
    for (localObject = localeos.Uro;; localObject = null)
    {
      AppMethodBeat.o(134201);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(134191);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(134191);
    return i;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134194);
    paramArrayOfByte = (x.b)params.getRespObj();
    Object localObject1;
    if (paramArrayOfByte.RBZ != null)
    {
      paramInt1 = paramArrayOfByte.RBZ.RMk;
      Log.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      h.aHH();
      h.aHG().kcw.i(47, Integer.valueOf(paramInt1));
      localObject1 = h.aHF().kcd.lCD;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label187;
        }
        bool = true;
        ((com.tencent.mm.network.g)localObject1).gm(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bi.a(true, paramArrayOfByte.RBZ.RRi, paramArrayOfByte.RBZ.RRj, paramArrayOfByte.RBZ.RRh, true, 0);
        this.lCA -= 1;
        if (this.lCA <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134194);
          return;
          label187:
          bool = false;
          break;
          Log.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[] { Integer.valueOf(paramArrayOfByte.getRetCode()) });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134194);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      Log.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.lCA) });
      this.lCA -= 1;
      if (this.lCA <= 0)
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
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134186);
          new m().doScene(v.a(v.this), new com.tencent.mm.an.i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
            {
              AppMethodBeat.i(134185);
              Log.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                v.b(v.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", v.this);
                AppMethodBeat.o(134185);
                return;
              }
              v.this.doScene(v.c(v.this), v.b(v.this));
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
      Log.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.hoP()) });
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
    params = (x.a)params.getReqObj();
    Log.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.RBZ.vhh + " regtype:" + paramArrayOfByte.RBZ.RFv + " mode:" + params.RBY.Swu);
    if ((paramArrayOfByte.RBZ.vhf != 0) && (!this.man))
    {
      h.aHH();
      h.sG(paramArrayOfByte.RBZ.vhf);
      h.aHG().aHp().i(2, params.RBY.UserName);
      h.aHG().aHp().i(16, Integer.valueOf(1));
      h.aHG().aHp().i(52, Integer.valueOf(paramArrayOfByte.RBZ.RFv));
      h.aHG().aHp().i(340240, Long.valueOf(System.currentTimeMillis()));
      h.aHG().aHp().i(340241, Boolean.TRUE);
      cs.vh(paramArrayOfByte.RBZ.RFD);
      cs.a(paramArrayOfByte.RBZ.RFE);
      cs.a(paramArrayOfByte.RBZ.RFF);
      if ((this.maf != null) && (this.maf.length() > 0) && (this.mam != 1)) {
        paramArrayOfByte.RBZ.UserName = this.maf;
      }
      paramArrayOfByte.RBZ.RFs = this.mai;
      paramArrayOfByte.RBZ.rVU = 0;
      if ((!h.aHB()) || (h.aHG().aHp() == null)) {
        break label1598;
      }
      params = this.mak;
      paramInt1 = this.mal;
      localObject1 = this.mah;
      String str1 = this.maj;
      String str2 = paramArrayOfByte.RBZ.UserName;
      String str3 = paramArrayOfByte.RBZ.RFs;
      int i = paramArrayOfByte.RBZ.rVU;
      String str4 = paramArrayOfByte.RBZ.RFy;
      String str5 = paramArrayOfByte.RBZ.RFz;
      int j = paramArrayOfByte.RBZ.RFA;
      int k = paramArrayOfByte.RBZ.TKm;
      String str6 = paramArrayOfByte.RBZ.Tvd;
      String str7 = paramArrayOfByte.RBZ.RFB;
      String str8 = paramArrayOfByte.RBZ.RMc;
      Object localObject2 = paramArrayOfByte.RBZ.TKl;
      Log.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, params, p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), Util.secPrint(str6), str7, Integer.valueOf(0), Util.secPrint(str8), Util.secPrint(null), Util.secPrint(null), Util.secPrint(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = h.aHG().aHp();
      bg.ltv.aS("login_weixin_username", str2);
      bg.ltv.aS("last_login_nick_name", (String)localObject1);
      bg.ltv.j(str1, paramInt1, str3);
      ((ao)localObject2).i(2, str2);
      ((ao)localObject2).i(42, params);
      ((ao)localObject2).i(9, Integer.valueOf(paramInt1));
      ((ao)localObject2).i(4, localObject1);
      ((ao)localObject2).i(5, str3);
      ((ao)localObject2).i(6, str1);
      ((ao)localObject2).i(7, Integer.valueOf(i));
      ((ao)localObject2).i(21, str4);
      ((ao)localObject2).i(22, str5);
      ((ao)localObject2).i(57, Integer.valueOf(0));
      ((ao)localObject2).i(17, Integer.valueOf(j));
      ((ao)localObject2).i(25, Integer.valueOf(k));
      ((ao)localObject2).i(1, str6);
      ((ao)localObject2).i(29, str7);
      ((ao)localObject2).i(34, Integer.valueOf(0));
      ((ao)localObject2).i(256, Boolean.FALSE);
      Log.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((ao)localObject2).i(-1535680990, str8);
      ((ao)localObject2).i(46, null);
      ((ao)localObject2).i(72, null);
      ((ao)localObject2).i(64, Integer.valueOf(-1));
      ((ao)localObject2).hxT();
      ((PluginAuth)h.ag(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.mak, this.mal, this.mah, this.maj, 0);
      bi.a(false, paramArrayOfByte.RBZ.RRi, paramArrayOfByte.RBZ.RRj, paramArrayOfByte.RBZ.RRh, false, 0);
      h.aHG().aHp().hxT();
      h.aGY().a(new bv(new bv.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(134187);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(134187);
            return;
          }
          paramAnonymousg.biw().a(paramArrayOfByte.arm(1), paramArrayOfByte.arm(2), paramArrayOfByte.arm(3), paramArrayOfByte.RBZ.vhf);
          AppMethodBeat.o(134187);
        }
      }), 0);
      Log.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.RBZ.TKo);
      if ((paramArrayOfByte.RBZ.TKo & 0x1) == 0) {
        break label1648;
      }
    }
    label1598:
    label1648:
    for (boolean bool = true;; bool = false)
    {
      this.mao = bool;
      params = new LinkedList();
      params.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((n)h.ae(n.class)).bbK().d(new com.tencent.mm.bd.i(params));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
      bool = h.aHB();
      h.aHE();
      Log.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), p.getString(com.tencent.mm.kernel.b.getUin()), h.aHG().aHp() });
      break;
    }
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
  
  public final void wL(int paramInt)
  {
    AppMethodBeat.i(134190);
    ((x.a)this.lCW.getReqObj()).RBY.RQX = paramInt;
    AppMethodBeat.o(134190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */