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
import com.tencent.mm.ba.i.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ak.g callback;
  private final String hSQ;
  private final String hSR;
  private final String hSS;
  private final String hST;
  private final String hSU;
  private final String hSV;
  private final int hSW;
  private final int hSX;
  private boolean hSY;
  public boolean hSZ;
  private int hwd;
  public com.tencent.mm.network.q hwy;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(134188);
    this.hSY = true;
    this.hSZ = false;
    this.hwd = 2;
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.hSX = paramInt2;
    this.hwy = new bc();
    x.a locala = (x.a)this.hwy.getReqObj();
    locala.setUin(0);
    locala.DJs.ncR = paramString1;
    locala.DJs.DYF = bs.aLs(paramString2);
    if (paramInt2 == 4)
    {
      locala.DJs.DYF = paramString6;
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.DJs.DYF);
    }
    locala.DJs.ndW = paramString3;
    locala.DJs.DNa = paramInt1;
    locala.DJs.DNb = paramString4;
    locala.DJs.DNc = paramString5;
    locala.DJs.Ewu = paramString6;
    locala.DJs.EUb = paramInt2;
    locala.DJs.pAC = bs.eWc();
    locala.DJs.Ews = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.DJs.pAD = ab.eUO();
    locala.DJs.DUn = 0;
    locala.DJs.FmL = 0;
    locala.DJs.FmM = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
    locala.DJs.EyL = com.tencent.mm.compatible.deviceinfo.q.XU();
    locala.DJs.FmN = ai.getContext().getSharedPreferences(ai.eUX(), 0).getString("installreferer", "");
    locala.DJs.FmO = com.tencent.mm.plugin.normsg.a.b.vor.Kw(2);
    locala.DJs.FmP = ai.getContext().getSharedPreferences(ai.eUX() + "_google_aid", com.tencent.mm.compatible.util.g.YK()).getString("getgoogleaid", "");
    this.hSQ = paramString1;
    this.hSR = paramString2;
    this.hSS = paramString3;
    this.hST = paramString4;
    this.hSU = paramString5;
    this.hSW = paramInt1;
    this.hSV = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.hSY = bool;
      locala.DJs.DUo = com.tencent.mm.kernel.a.agc();
      AppMethodBeat.o(134188);
      return;
    }
  }
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134189);
    this.hSY = true;
    this.hSZ = false;
    this.hwd = 2;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, bs.aLJ(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.hSX = paramInt2;
    this.hwy = new bc();
    paramString6 = (x.a)this.hwy.getReqObj();
    paramString6.setUin(0);
    paramString6.DJs.ncR = paramString1;
    paramString6.DJs.DYF = bs.aLs(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.DJs.DYF = paramString8;
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.DJs.DYF);
    }
    paramString6.DJs.ndW = paramString3;
    paramString6.DJs.DNa = paramInt1;
    paramString6.DJs.DNb = paramString4;
    paramString6.DJs.DNc = paramString5;
    paramString6.DJs.Ewu = paramString8;
    paramString6.DJs.EUb = paramInt2;
    paramString6.DJs.pAC = bs.eWc();
    paramString6.DJs.Ews = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    paramString6.DJs.pAD = ab.eUO();
    paramString6.DJs.DUn = 0;
    paramString6.DJs.iJY = paramString9;
    paramString6.DJs.EUa = paramString11;
    paramString6.DJs.ETZ = paramString10;
    paramString7 = paramString6.DJs;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.DYr = paramInt2;
      paramString7 = paramString6.DJs;
      if (!paramBoolean2) {
        break label643;
      }
      paramInt2 = 1;
      label427:
      paramString7.FmK = paramInt2;
      paramString6.DJs.DUo = com.tencent.mm.kernel.a.agc();
      paramString6.DJs.FmM = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
      paramString6.DJs.EyL = com.tencent.mm.compatible.deviceinfo.q.XU();
      paramString6.DJs.FmN = ai.getContext().getSharedPreferences(ai.eUX(), 0).getString("installreferer", "");
      paramString6.DJs.FmO = com.tencent.mm.plugin.normsg.a.b.vor.Kw(2);
      paramString6.DJs.FmP = ai.getContext().getSharedPreferences(ai.eUX() + "_google_aid", com.tencent.mm.compatible.util.g.YK()).getString("getgoogleaid", "");
      this.hSQ = paramString1;
      this.hSR = paramString2;
      this.hSS = paramString3;
      this.hST = paramString4;
      this.hSU = paramString5;
      this.hSW = paramInt1;
      this.hSV = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label649;
      }
    }
    label643:
    label649:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.hSY = paramBoolean1;
      AppMethodBeat.o(134189);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label427;
    }
  }
  
  public final void Di(String paramString)
  {
    AppMethodBeat.i(134192);
    if (!bs.isNullOrNil(paramString))
    {
      ((x.a)this.hwy.getReqObj()).DJs.DYy = paramString;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134192);
  }
  
  public final void Dj(String paramString)
  {
    AppMethodBeat.i(134193);
    if (!bs.isNullOrNil(paramString))
    {
      ((x.a)this.hwy.getReqObj()).DJs.FmU = paramString;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134193);
  }
  
  public final String aHA()
  {
    AppMethodBeat.i(134196);
    String str = ((x.b)this.hwy.getRespObj()).DJt.ETZ;
    AppMethodBeat.o(134196);
    return str;
  }
  
  public final byte[] aHB()
  {
    AppMethodBeat.i(134195);
    byte[] arrayOfByte = z.a(((x.b)this.hwy.getRespObj()).DJt.EUc, new byte[0]);
    AppMethodBeat.o(134195);
    return arrayOfByte;
  }
  
  public final String aHK()
  {
    AppMethodBeat.i(134197);
    String str = ((x.b)this.hwy.getRespObj()).DJt.Fnc;
    AppMethodBeat.o(134197);
    return str;
  }
  
  public final int aHL()
  {
    AppMethodBeat.i(134198);
    Object localObject = ((x.b)this.hwy.getRespObj()).DJt.DTK;
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
      } while (localdew.wTD != 1);
    }
    for (int i = bs.getInt(localdew.FOp, 0);; i = 0)
    {
      AppMethodBeat.o(134198);
      return i;
    }
  }
  
  public final String aHM()
  {
    AppMethodBeat.i(134199);
    Object localObject = ((x.b)this.hwy.getRespObj()).DJt.DTK;
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
      } while (localdew.wTD != 2);
    }
    for (localObject = localdew.FOp;; localObject = "")
    {
      AppMethodBeat.o(134199);
      return localObject;
    }
  }
  
  public final int aHN()
  {
    AppMethodBeat.i(134200);
    Object localObject = ((x.b)this.hwy.getRespObj()).DJt.DTK;
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
      } while (localdew.wTD != 3);
    }
    for (int i = bs.getInt(localdew.FOp, 2);; i = 2)
    {
      AppMethodBeat.o(134200);
      return i;
    }
  }
  
  public final String aHO()
  {
    AppMethodBeat.i(134201);
    Object localObject = ((x.b)this.hwy.getRespObj()).DJt.DTK;
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
      } while (localdew.wTD != 17);
    }
    for (localObject = localdew.FOp;; localObject = null)
    {
      AppMethodBeat.o(134201);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(134191);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
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
    if (paramArrayOfByte.DJt != null)
    {
      paramInt1 = paramArrayOfByte.DJt.DTP;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().ghx.set(47, Integer.valueOf(paramInt1));
      localObject1 = com.tencent.mm.kernel.g.agQ().ghe.hwg;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label185;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject1).eG(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        ba.a(true, paramArrayOfByte.DJt.DYH, paramArrayOfByte.DJt.DYI, paramArrayOfByte.DJt.DYG);
        this.hwd -= 1;
        if (this.hwd <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134194);
          return;
          label185:
          bool = false;
          break;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[] { Integer.valueOf(paramArrayOfByte.getRetCode()) });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134194);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hwd) });
      this.hwd -= 1;
      if (this.hwd <= 0)
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134186);
          new l().doScene(u.this.dispatcher(), new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134185);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.DIq) });
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
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.DJt.pAu + " regtype:" + paramArrayOfByte.DJt.DNe + " mode:" + paramq.DJs.EUb);
    if ((paramArrayOfByte.DJt.pAs != 0) && (!this.hSY))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.mr(paramArrayOfByte.DJt.pAs);
      com.tencent.mm.kernel.g.agR().agA().set(2, paramq.DJs.ncR);
      com.tencent.mm.kernel.g.agR().agA().set(16, Integer.valueOf(1));
      com.tencent.mm.kernel.g.agR().agA().set(52, Integer.valueOf(paramArrayOfByte.DJt.DNe));
      com.tencent.mm.kernel.g.agR().agA().set(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.agR().agA().set(340241, Boolean.TRUE);
      if ((this.hSQ != null) && (this.hSQ.length() > 0) && (this.hSX != 1)) {
        paramArrayOfByte.DJt.ncR = this.hSQ;
      }
      paramArrayOfByte.DJt.DNb = this.hST;
      paramArrayOfByte.DJt.ndj = 0;
      if ((!com.tencent.mm.kernel.g.agM()) || (com.tencent.mm.kernel.g.agR().agA() == null)) {
        break label1561;
      }
      paramq = this.hSV;
      paramInt1 = this.hSW;
      localObject1 = this.hSS;
      String str1 = this.hSU;
      String str2 = paramArrayOfByte.DJt.ncR;
      String str3 = paramArrayOfByte.DJt.DNb;
      int i = paramArrayOfByte.DJt.ndj;
      String str4 = paramArrayOfByte.DJt.DNh;
      String str5 = paramArrayOfByte.DJt.DNi;
      int j = paramArrayOfByte.DJt.DNj;
      int k = paramArrayOfByte.DJt.FmW;
      String str6 = paramArrayOfByte.DJt.DLD;
      String str7 = paramArrayOfByte.DJt.DNk;
      String str8 = paramArrayOfByte.DJt.DTH;
      Object localObject2 = paramArrayOfByte.DJt.FmV;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, paramq, p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), bs.aLJ(str6), str7, Integer.valueOf(0), bs.aLJ(str8), bs.aLJ(null), bs.aLJ(null), bs.aLJ(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = com.tencent.mm.kernel.g.agR().agA();
      ay.hnA.aL("login_weixin_username", str2);
      ay.hnA.aL("last_login_nick_name", (String)localObject1);
      ay.hnA.g(str1, paramInt1, str3);
      ((ae)localObject2).set(2, str2);
      ((ae)localObject2).set(42, paramq);
      ((ae)localObject2).set(9, Integer.valueOf(paramInt1));
      ((ae)localObject2).set(4, localObject1);
      ((ae)localObject2).set(5, str3);
      ((ae)localObject2).set(6, str1);
      ((ae)localObject2).set(7, Integer.valueOf(i));
      ((ae)localObject2).set(21, str4);
      ((ae)localObject2).set(22, str5);
      ((ae)localObject2).set(57, Integer.valueOf(0));
      ((ae)localObject2).set(17, Integer.valueOf(j));
      ((ae)localObject2).set(25, Integer.valueOf(k));
      ((ae)localObject2).set(1, str6);
      ((ae)localObject2).set(29, str7);
      ((ae)localObject2).set(34, Integer.valueOf(0));
      ((ae)localObject2).set(256, Boolean.FALSE);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((ae)localObject2).set(-1535680990, str8);
      ((ae)localObject2).set(46, null);
      ((ae)localObject2).set(72, null);
      ((ae)localObject2).set(64, Integer.valueOf(-1));
      ((ae)localObject2).faa();
      ((PluginAuth)com.tencent.mm.kernel.g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.hSV, this.hSW, this.hSS, this.hSU, 0);
      ba.a(false, paramArrayOfByte.DJt.DYH, paramArrayOfByte.DJt.DYI, paramArrayOfByte.DJt.DYG);
      com.tencent.mm.kernel.g.agR().agA().faa();
      com.tencent.mm.kernel.g.agi().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(134187);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(134187);
            return;
          }
          paramAnonymouse.aBZ().a(paramArrayOfByte.XI(1), paramArrayOfByte.XI(2), paramArrayOfByte.XI(3), paramArrayOfByte.DJt.pAs);
          AppMethodBeat.o(134187);
        }
      }), 0);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.DJt.FmY);
      if ((paramArrayOfByte.DJt.FmY & 0x1) == 0) {
        break label1611;
      }
    }
    label1561:
    label1611:
    for (boolean bool = true;; bool = false)
    {
      this.hSZ = bool;
      paramq = new LinkedList();
      paramq.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new com.tencent.mm.ba.i(paramq));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
      bool = com.tencent.mm.kernel.g.agM();
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), p.getString(com.tencent.mm.kernel.a.getUin()), com.tencent.mm.kernel.g.agR().agA() });
      break;
    }
  }
  
  public final void pq(int paramInt)
  {
    AppMethodBeat.i(134190);
    ((x.a)this.hwy.getReqObj()).DJs.DYx = paramInt;
    AppMethodBeat.o(134190);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */