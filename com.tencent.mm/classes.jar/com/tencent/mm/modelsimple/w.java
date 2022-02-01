package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.ct;
import com.tencent.mm.network.e;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.fck;
import com.tencent.mm.protocal.protobuf.fjq;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends com.tencent.mm.am.p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final String oSV;
  private final String oSW;
  private final String oSX;
  private final String oSY;
  private final String oSZ;
  private final String oTa;
  private final int oTb;
  private final int oTc;
  private boolean oTd;
  private boolean oTe;
  public com.tencent.mm.network.s ouH;
  private int ouk;
  
  public w(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(236741);
    this.oTd = true;
    this.oTe = false;
    this.ouk = 2;
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    Log.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = 2 ticket: " + paramString6);
    this.oTc = 2;
    this.ouH = new bl();
    x.a locala = (x.a)this.ouH.getReqObj();
    locala.setUin(0);
    locala.YyB.UserName = paramString1;
    locala.YyB.YOy = Util.getCutPasswordMD5(paramString2);
    locala.YyB.vhX = paramString3;
    locala.YyB.YBU = paramInt;
    locala.YyB.YBV = paramString4;
    locala.YyB.YBW = paramString5;
    locala.YyB.Njp = paramString6;
    locala.YyB.ZwR = 2;
    locala.YyB.ytr = Util.getTimeZoneOffset();
    locala.YyB.Ztv = q.aPc();
    locala.YyB.yts = LocaleUtil.getApplicationLanguage();
    locala.YyB.YJW = 0;
    locala.YyB.aaZQ = 0;
    locala.YyB.aaZR = q.getAndroidId();
    locala.YyB.Zym = q.aPd();
    locala.YyB.aaZS = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
    locala.YyB.aaZT = d.MtP.aeQ(2);
    locala.YyB.aaZU = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", com.tencent.mm.compatible.util.g.aQe()).getString("getgoogleaid", "");
    locala.YyB.YDN = MMApplicationContext.getApplicationId();
    this.oSV = paramString1;
    this.oSW = paramString2;
    this.oSX = paramString3;
    this.oSY = paramString4;
    this.oSZ = paramString5;
    this.oTb = paramInt;
    this.oTa = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.oTd = bool;
      locala.YyB.YJX = com.tencent.mm.kernel.b.aZR();
      AppMethodBeat.o(236741);
      return;
    }
  }
  
  public w(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134189);
    this.oTd = true;
    this.oTe = false;
    this.ouk = 2;
    Log.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, Util.secPrint(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.oTc = paramInt2;
    this.ouH = new bl();
    paramString6 = (x.a)this.ouH.getReqObj();
    paramString6.setUin(0);
    paramString6.YyB.UserName = paramString1;
    paramString6.YyB.YOy = Util.getCutPasswordMD5(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.YyB.YOy = paramString8;
      Log.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.YyB.YOy);
    }
    paramString6.YyB.vhX = paramString3;
    paramString6.YyB.YBU = paramInt1;
    paramString6.YyB.YBV = paramString4;
    paramString6.YyB.YBW = paramString5;
    paramString6.YyB.Njp = paramString8;
    paramString6.YyB.ZwR = paramInt2;
    paramString6.YyB.ytr = Util.getTimeZoneOffset();
    paramString6.YyB.Ztv = q.aPc();
    paramString6.YyB.yts = LocaleUtil.getApplicationLanguage();
    paramString6.YyB.YJW = 0;
    paramString6.YyB.pSk = paramString9;
    paramString6.YyB.aayW = paramString11;
    paramString6.YyB.aayV = paramString10;
    paramString7 = paramString6.YyB;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.YOg = paramInt2;
      paramString7 = paramString6.YyB;
      if (!paramBoolean2) {
        break label656;
      }
      paramInt2 = 1;
      label429:
      paramString7.ZwS = paramInt2;
      paramString6.YyB.YJX = com.tencent.mm.kernel.b.aZR();
      paramString6.YyB.aaZR = q.getAndroidId();
      paramString6.YyB.Zym = q.aPd();
      paramString6.YyB.aaZS = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getString("installreferer", "");
      paramString6.YyB.aaZT = d.MtP.aeQ(2);
      paramString6.YyB.aaZU = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", com.tencent.mm.compatible.util.g.aQe()).getString("getgoogleaid", "");
      paramString6.YyB.YDN = MMApplicationContext.getApplicationId();
      this.oSV = paramString1;
      this.oSW = paramString2;
      this.oSX = paramString3;
      this.oSY = paramString4;
      this.oSZ = paramString5;
      this.oTb = paramInt1;
      this.oTa = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label662;
      }
    }
    label656:
    label662:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.oTd = paramBoolean1;
      AppMethodBeat.o(134189);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label429;
    }
  }
  
  public final void OZ(String paramString)
  {
    AppMethodBeat.i(134192);
    if (!Util.isNullOrNil(paramString))
    {
      ((x.a)this.ouH.getReqObj()).YyB.YOn = paramString;
      Log.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134192);
  }
  
  public final void Pa(String paramString)
  {
    AppMethodBeat.i(134193);
    if (!Util.isNullOrNil(paramString))
    {
      ((x.a)this.ouH.getReqObj()).YyB.aaZY = paramString;
      Log.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134193);
  }
  
  public final String bMi()
  {
    AppMethodBeat.i(134196);
    String str = ((x.b)this.ouH.getRespObj()).YyC.aayV;
    AppMethodBeat.o(134196);
    return str;
  }
  
  public final byte[] bMj()
  {
    AppMethodBeat.i(134195);
    byte[] arrayOfByte = com.tencent.mm.platformtools.w.a(((x.b)this.ouH.getRespObj()).YyC.aayX, new byte[0]);
    AppMethodBeat.o(134195);
    return arrayOfByte;
  }
  
  public final String bMs()
  {
    AppMethodBeat.i(134197);
    String str = ((x.b)this.ouH.getRespObj()).YyC.abah;
    AppMethodBeat.o(134197);
    return str;
  }
  
  public final int bMt()
  {
    AppMethodBeat.i(134198);
    Object localObject = ((x.b)this.ouH.getRespObj()).YyC.YJt;
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
      } while (localfjq.OzG != 1);
    }
    for (int i = Util.getInt(localfjq.abKm, 0);; i = 0)
    {
      AppMethodBeat.o(134198);
      return i;
    }
  }
  
  public final String bMu()
  {
    AppMethodBeat.i(134199);
    Object localObject = ((x.b)this.ouH.getRespObj()).YyC.YJt;
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
      } while (localfjq.OzG != 2);
    }
    for (localObject = localfjq.abKm;; localObject = "")
    {
      AppMethodBeat.o(134199);
      return localObject;
    }
  }
  
  public final int bMv()
  {
    AppMethodBeat.i(134200);
    Object localObject = ((x.b)this.ouH.getRespObj()).YyC.YJt;
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
      } while (localfjq.OzG != 3);
    }
    for (int i = Util.getInt(localfjq.abKm, 2);; i = 2)
    {
      AppMethodBeat.o(134200);
      return i;
    }
  }
  
  public final String bMw()
  {
    AppMethodBeat.i(134201);
    Object localObject = ((x.b)this.ouH.getRespObj()).YyC.YJt;
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
      } while (localfjq.OzG != 17);
    }
    for (localObject = localfjq.abKm;; localObject = null)
    {
      AppMethodBeat.o(134201);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(134191);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(134191);
    return i;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134194);
    paramArrayOfByte = (x.b)params.getRespObj();
    Object localObject1;
    if (paramArrayOfByte.YyC != null)
    {
      paramInt1 = paramArrayOfByte.YyC.YJy;
      Log.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().mCE.B(47, Integer.valueOf(paramInt1));
      localObject1 = com.tencent.mm.kernel.h.baD().mCm.oun;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label187;
        }
        bool = true;
        ((com.tencent.mm.network.g)localObject1).hd(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bj.a(true, paramArrayOfByte.YyC.YOA, paramArrayOfByte.YyC.YOB, paramArrayOfByte.YyC.YOz, true, 0);
        this.ouk -= 1;
        if (this.ouk <= 0)
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
      Log.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ouk) });
      this.ouk -= 1;
      if (this.ouk <= 0)
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
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134186);
          new o().doScene(w.a(w.this), new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.am.p paramAnonymous2p)
            {
              AppMethodBeat.i(134185);
              Log.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                w.b(w.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", w.this);
                AppMethodBeat.o(134185);
                return;
              }
              w.this.doScene(w.c(w.this), w.b(w.this));
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
      Log.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.iPL()) });
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
    Log.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.YyC.ytj + " regtype:" + paramArrayOfByte.YyC.YBY + " mode:" + params.YyB.ZwR);
    if ((paramArrayOfByte.YyC.yth != 0) && (!this.oTd))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.sC(paramArrayOfByte.YyC.yth);
      com.tencent.mm.kernel.h.baE().ban().B(2, params.YyB.UserName);
      com.tencent.mm.kernel.h.baE().ban().B(16, Integer.valueOf(1));
      com.tencent.mm.kernel.h.baE().ban().B(52, Integer.valueOf(paramArrayOfByte.YyC.YBY));
      com.tencent.mm.kernel.h.baE().ban().B(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.baE().ban().B(340241, Boolean.TRUE);
      ct.vr(paramArrayOfByte.YyC.YCg);
      ct.a(paramArrayOfByte.YyC.YCh);
      ct.a(paramArrayOfByte.YyC.YCi);
      if ((this.oSV != null) && (this.oSV.length() > 0) && (this.oTc != 1)) {
        paramArrayOfByte.YyC.UserName = this.oSV;
      }
      paramArrayOfByte.YyC.YBV = this.oSY;
      paramArrayOfByte.YyC.vhk = 0;
      if ((!com.tencent.mm.kernel.h.baz()) || (com.tencent.mm.kernel.h.baE().ban() == null)) {
        break label1598;
      }
      params = this.oTa;
      paramInt1 = this.oTb;
      localObject1 = this.oSX;
      String str1 = this.oSZ;
      String str2 = paramArrayOfByte.YyC.UserName;
      String str3 = paramArrayOfByte.YyC.YBV;
      int i = paramArrayOfByte.YyC.vhk;
      String str4 = paramArrayOfByte.YyC.YCb;
      String str5 = paramArrayOfByte.YyC.YCc;
      int j = paramArrayOfByte.YyC.YCd;
      int k = paramArrayOfByte.YyC.abab;
      String str6 = paramArrayOfByte.YyC.aaJJ;
      String str7 = paramArrayOfByte.YyC.YCe;
      String str8 = paramArrayOfByte.YyC.YJq;
      Object localObject2 = paramArrayOfByte.YyC.abaa;
      Log.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, params, com.tencent.mm.b.p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), Util.secPrint(str6), str7, Integer.valueOf(0), Util.secPrint(str8), Util.secPrint(null), Util.secPrint(null), Util.secPrint(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      bg.okT.bc("login_weixin_username", str2);
      bg.okT.bc("last_login_nick_name", (String)localObject1);
      bg.okT.k(str1, paramInt1, str3);
      ((aq)localObject2).B(2, str2);
      ((aq)localObject2).B(42, params);
      ((aq)localObject2).B(9, Integer.valueOf(paramInt1));
      ((aq)localObject2).B(4, localObject1);
      ((aq)localObject2).B(5, str3);
      ((aq)localObject2).B(6, str1);
      ((aq)localObject2).B(7, Integer.valueOf(i));
      ((aq)localObject2).B(21, str4);
      ((aq)localObject2).B(22, str5);
      ((aq)localObject2).B(57, Integer.valueOf(0));
      ((aq)localObject2).B(17, Integer.valueOf(j));
      ((aq)localObject2).B(25, Integer.valueOf(k));
      ((aq)localObject2).B(1, str6);
      ((aq)localObject2).B(29, str7);
      ((aq)localObject2).B(34, Integer.valueOf(0));
      ((aq)localObject2).B(256, Boolean.FALSE);
      Log.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((aq)localObject2).B(-1535680990, str8);
      ((aq)localObject2).B(46, null);
      ((aq)localObject2).B(72, null);
      ((aq)localObject2).B(64, Integer.valueOf(-1));
      ((aq)localObject2).iZy();
      ((PluginAuth)com.tencent.mm.kernel.h.az(PluginAuth.class)).getHandleAuthResponseCallbacks().onRegResponse(paramArrayOfByte, this.oTa, this.oTb, this.oSX, this.oSZ, 0);
      bj.a(false, paramArrayOfByte.YyC.YOA, paramArrayOfByte.YyC.YOB, paramArrayOfByte.YyC.YOz, false, 0);
      com.tencent.mm.kernel.h.baE().ban().iZy();
      com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
      {
        public final void b(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(134187);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(134187);
            return;
          }
          paramAnonymousg.bGg().a(paramArrayOfByte.axu(1), paramArrayOfByte.axu(2), paramArrayOfByte.axu(3), paramArrayOfByte.YyC.yth);
          AppMethodBeat.o(134187);
        }
      }), 0);
      Log.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.YyC.abad);
      if ((paramArrayOfByte.YyC.abad & 0x1) == 0) {
        break label1648;
      }
    }
    label1598:
    label1648:
    for (boolean bool = true;; bool = false)
    {
      this.oTe = bool;
      params = new LinkedList();
      params.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + q.aPo()));
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new i(params));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
      bool = com.tencent.mm.kernel.h.baz();
      com.tencent.mm.kernel.h.baC();
      Log.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.b.getUin()), com.tencent.mm.kernel.h.baE().ban() });
      break;
    }
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
  
  public final void wL(int paramInt)
  {
    AppMethodBeat.i(134190);
    ((x.a)this.ouH.getReqObj()).YyB.YOm = paramInt;
    AppMethodBeat.o(134190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */