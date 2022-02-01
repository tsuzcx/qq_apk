package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.cr;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
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
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.network.m
{
  com.tencent.mm.ak.i callback;
  public s iMO;
  private int iMt;
  private final String jki;
  private final String jkj;
  private final String jkk;
  private final String jkl;
  private final String jkm;
  private final String jkn;
  private final int jko;
  private final int jkp;
  private boolean jkq;
  public boolean jkr;
  
  public v(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(134188);
    this.jkq = true;
    this.jkr = false;
    this.iMt = 2;
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.jkp = paramInt2;
    this.iMO = new bj();
    x.a locala = (x.a)this.iMO.getReqObj();
    locala.setUin(0);
    locala.KAi.UserName = paramString1;
    locala.KAi.KQi = Util.getCutPasswordMD5(paramString2);
    if (paramInt2 == 4)
    {
      locala.KAi.KQi = paramString6;
      Log.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.KAi.KQi);
    }
    locala.KAi.oUJ = paramString3;
    locala.KAi.KDZ = paramInt1;
    locala.KAi.KEa = paramString4;
    locala.KAi.KEb = paramString5;
    locala.KAi.Bri = paramString6;
    locala.KAi.LtW = paramInt2;
    locala.KAi.rBH = Util.getTimeZoneOffset();
    locala.KAi.Lsj = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.KAi.rBI = LocaleUtil.getApplicationLanguage();
    locala.KAi.KLM = 0;
    locala.KAi.MyA = 0;
    locala.KAi.MyB = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
    locala.KAi.LuU = com.tencent.mm.compatible.deviceinfo.q.aoD();
    locala.KAi.MyC = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
    locala.KAi.MyD = d.AEF.TK(2);
    locala.KAi.MyE = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", com.tencent.mm.compatible.util.g.aps()).getString("getgoogleaid", "");
    locala.KAi.KFu = MMApplicationContext.getApplicationId();
    this.jki = paramString1;
    this.jkj = paramString2;
    this.jkk = paramString3;
    this.jkl = paramString4;
    this.jkm = paramString5;
    this.jko = paramInt1;
    this.jkn = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jkq = bool;
      locala.KAi.KLN = a.azt();
      AppMethodBeat.o(134188);
      return;
    }
  }
  
  public v(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134189);
    this.jkq = true;
    this.jkr = false;
    this.iMt = 2;
    Log.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, Util.secPrint(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.jkp = paramInt2;
    this.iMO = new bj();
    paramString6 = (x.a)this.iMO.getReqObj();
    paramString6.setUin(0);
    paramString6.KAi.UserName = paramString1;
    paramString6.KAi.KQi = Util.getCutPasswordMD5(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.KAi.KQi = paramString8;
      Log.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.KAi.KQi);
    }
    paramString6.KAi.oUJ = paramString3;
    paramString6.KAi.KDZ = paramInt1;
    paramString6.KAi.KEa = paramString4;
    paramString6.KAi.KEb = paramString5;
    paramString6.KAi.Bri = paramString8;
    paramString6.KAi.LtW = paramInt2;
    paramString6.KAi.rBH = Util.getTimeZoneOffset();
    paramString6.KAi.Lsj = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    paramString6.KAi.rBI = LocaleUtil.getApplicationLanguage();
    paramString6.KAi.KLM = 0;
    paramString6.KAi.ked = paramString9;
    paramString6.KAi.MbK = paramString11;
    paramString6.KAi.MbJ = paramString10;
    paramString7 = paramString6.KAi;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.KPT = paramInt2;
      paramString7 = paramString6.KAi;
      if (!paramBoolean2) {
        break label654;
      }
      paramInt2 = 1;
      label427:
      paramString7.LtX = paramInt2;
      paramString6.KAi.KLN = a.azt();
      paramString6.KAi.MyB = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
      paramString6.KAi.LuU = com.tencent.mm.compatible.deviceinfo.q.aoD();
      paramString6.KAi.MyC = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
      paramString6.KAi.MyD = d.AEF.TK(2);
      paramString6.KAi.MyE = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", com.tencent.mm.compatible.util.g.aps()).getString("getgoogleaid", "");
      paramString6.KAi.KFu = MMApplicationContext.getApplicationId();
      this.jki = paramString1;
      this.jkj = paramString2;
      this.jkk = paramString3;
      this.jkl = paramString4;
      this.jkm = paramString5;
      this.jko = paramInt1;
      this.jkn = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label660;
      }
    }
    label654:
    label660:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.jkq = paramBoolean1;
      AppMethodBeat.o(134189);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label427;
    }
  }
  
  public final void PB(String paramString)
  {
    AppMethodBeat.i(134192);
    if (!Util.isNullOrNil(paramString))
    {
      ((x.a)this.iMO.getReqObj()).KAi.KQa = paramString;
      Log.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134192);
  }
  
  public final void PC(String paramString)
  {
    AppMethodBeat.i(134193);
    if (!Util.isNullOrNil(paramString))
    {
      ((x.a)this.iMO.getReqObj()).KAi.MyI = paramString;
      Log.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134193);
  }
  
  public final String bfl()
  {
    AppMethodBeat.i(134196);
    String str = ((x.b)this.iMO.getRespObj()).KAj.MbJ;
    AppMethodBeat.o(134196);
    return str;
  }
  
  public final byte[] bfm()
  {
    AppMethodBeat.i(134195);
    byte[] arrayOfByte = z.a(((x.b)this.iMO.getRespObj()).KAj.MbL, new byte[0]);
    AppMethodBeat.o(134195);
    return arrayOfByte;
  }
  
  public final String bfv()
  {
    AppMethodBeat.i(134197);
    String str = ((x.b)this.iMO.getRespObj()).KAj.MyR;
    AppMethodBeat.o(134197);
    return str;
  }
  
  public final int bfw()
  {
    AppMethodBeat.i(134198);
    Object localObject = ((x.b)this.iMO.getRespObj()).KAj.KLj;
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
      } while (localeer.Cya != 1);
    }
    for (int i = Util.getInt(localeer.NeO, 0);; i = 0)
    {
      AppMethodBeat.o(134198);
      return i;
    }
  }
  
  public final String bfx()
  {
    AppMethodBeat.i(134199);
    Object localObject = ((x.b)this.iMO.getRespObj()).KAj.KLj;
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
      } while (localeer.Cya != 2);
    }
    for (localObject = localeer.NeO;; localObject = "")
    {
      AppMethodBeat.o(134199);
      return localObject;
    }
  }
  
  public final int bfy()
  {
    AppMethodBeat.i(134200);
    Object localObject = ((x.b)this.iMO.getRespObj()).KAj.KLj;
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
      } while (localeer.Cya != 3);
    }
    for (int i = Util.getInt(localeer.NeO, 2);; i = 2)
    {
      AppMethodBeat.o(134200);
      return i;
    }
  }
  
  public final String bfz()
  {
    AppMethodBeat.i(134201);
    Object localObject = ((x.b)this.iMO.getRespObj()).KAj.KLj;
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
      } while (localeer.Cya != 17);
    }
    for (localObject = localeer.NeO;; localObject = null)
    {
      AppMethodBeat.o(134201);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(134191);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
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
    if (paramArrayOfByte.KAj != null)
    {
      paramInt1 = paramArrayOfByte.KAj.KLo;
      Log.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().hqB.set(47, Integer.valueOf(paramInt1));
      localObject1 = com.tencent.mm.kernel.g.aAg().hqi.iMw;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label185;
        }
        bool = true;
        ((com.tencent.mm.network.g)localObject1).fB(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bh.a(true, paramArrayOfByte.KAj.KQk, paramArrayOfByte.KAj.KQl, paramArrayOfByte.KAj.KQj);
        this.iMt -= 1;
        if (this.iMt <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134194);
          return;
          label185:
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
      Log.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.iMt) });
      this.iMt -= 1;
      if (this.iMt <= 0)
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
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134186);
          new m().doScene(v.this.dispatcher(), new com.tencent.mm.ak.i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.q paramAnonymous2q)
            {
              AppMethodBeat.i(134185);
              Log.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      Log.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.Kze) });
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
    Log.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.KAj.rBz + " regtype:" + paramArrayOfByte.KAj.KEd + " mode:" + params.KAi.LtW);
    if ((paramArrayOfByte.KAj.rBx != 0) && (!this.jkq))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.qg(paramArrayOfByte.KAj.rBx);
      com.tencent.mm.kernel.g.aAh().azQ().set(2, params.KAi.UserName);
      com.tencent.mm.kernel.g.aAh().azQ().set(16, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aAh().azQ().set(52, Integer.valueOf(paramArrayOfByte.KAj.KEd));
      com.tencent.mm.kernel.g.aAh().azQ().set(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.aAh().azQ().set(340241, Boolean.TRUE);
      cr.sk(paramArrayOfByte.KAj.KEl);
      cr.a(paramArrayOfByte.KAj.KEm);
      cr.a(paramArrayOfByte.KAj.KEn);
      if ((this.jki != null) && (this.jki.length() > 0) && (this.jkp != 1)) {
        paramArrayOfByte.KAj.UserName = this.jki;
      }
      paramArrayOfByte.KAj.KEa = this.jkl;
      paramArrayOfByte.KAj.oTW = 0;
      if ((!com.tencent.mm.kernel.g.aAc()) || (com.tencent.mm.kernel.g.aAh().azQ() == null)) {
        break label1594;
      }
      params = this.jkn;
      paramInt1 = this.jko;
      localObject1 = this.jkk;
      String str1 = this.jkm;
      String str2 = paramArrayOfByte.KAj.UserName;
      String str3 = paramArrayOfByte.KAj.KEa;
      int i = paramArrayOfByte.KAj.oTW;
      String str4 = paramArrayOfByte.KAj.KEg;
      String str5 = paramArrayOfByte.KAj.KEh;
      int j = paramArrayOfByte.KAj.KEi;
      int k = paramArrayOfByte.KAj.MyL;
      String str6 = paramArrayOfByte.KAj.KCy;
      String str7 = paramArrayOfByte.KAj.KEj;
      String str8 = paramArrayOfByte.KAj.KLg;
      Object localObject2 = paramArrayOfByte.KAj.MyK;
      Log.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, params, p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), Util.secPrint(str6), str7, Integer.valueOf(0), Util.secPrint(str8), Util.secPrint(null), Util.secPrint(null), Util.secPrint(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = com.tencent.mm.kernel.g.aAh().azQ();
      bf.iDu.aO("login_weixin_username", str2);
      bf.iDu.aO("last_login_nick_name", (String)localObject1);
      bf.iDu.k(str1, paramInt1, str3);
      ((ao)localObject2).set(2, str2);
      ((ao)localObject2).set(42, params);
      ((ao)localObject2).set(9, Integer.valueOf(paramInt1));
      ((ao)localObject2).set(4, localObject1);
      ((ao)localObject2).set(5, str3);
      ((ao)localObject2).set(6, str1);
      ((ao)localObject2).set(7, Integer.valueOf(i));
      ((ao)localObject2).set(21, str4);
      ((ao)localObject2).set(22, str5);
      ((ao)localObject2).set(57, Integer.valueOf(0));
      ((ao)localObject2).set(17, Integer.valueOf(j));
      ((ao)localObject2).set(25, Integer.valueOf(k));
      ((ao)localObject2).set(1, str6);
      ((ao)localObject2).set(29, str7);
      ((ao)localObject2).set(34, Integer.valueOf(0));
      ((ao)localObject2).set(256, Boolean.FALSE);
      Log.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((ao)localObject2).set(-1535680990, str8);
      ((ao)localObject2).set(46, null);
      ((ao)localObject2).set(72, null);
      ((ao)localObject2).set(64, Integer.valueOf(-1));
      ((ao)localObject2).gBI();
      ((PluginAuth)com.tencent.mm.kernel.g.ah(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.jkn, this.jko, this.jkk, this.jkm, 0);
      bh.a(false, paramArrayOfByte.KAj.KQk, paramArrayOfByte.KAj.KQl, paramArrayOfByte.KAj.KQj);
      com.tencent.mm.kernel.g.aAh().azQ().gBI();
      com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(134187);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(134187);
            return;
          }
          paramAnonymousg.aZh().a(paramArrayOfByte.aiZ(1), paramArrayOfByte.aiZ(2), paramArrayOfByte.aiZ(3), paramArrayOfByte.KAj.rBx);
          AppMethodBeat.o(134187);
        }
      }), 0);
      Log.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.KAj.MyN);
      if ((paramArrayOfByte.KAj.MyN & 0x1) == 0) {
        break label1644;
      }
    }
    label1594:
    label1644:
    for (boolean bool = true;; bool = false)
    {
      this.jkr = bool;
      params = new LinkedList();
      params.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(new com.tencent.mm.ba.i(params));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
      bool = com.tencent.mm.kernel.g.aAc();
      com.tencent.mm.kernel.g.aAf();
      Log.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), p.getString(a.getUin()), com.tencent.mm.kernel.g.aAh().azQ() });
      break;
    }
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
  
  public final void tL(int paramInt)
  {
    AppMethodBeat.i(134190);
    ((x.a)this.iMO.getReqObj()).KAi.KPZ = paramInt;
    AppMethodBeat.o(134190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */