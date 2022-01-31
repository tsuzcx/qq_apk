package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.az.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends m
  implements k
{
  com.tencent.mm.ai.f callback;
  private final String fPJ;
  private final String fPK;
  private final String fPL;
  private final String fPM;
  private final String fPN;
  private final String fPO;
  private final int fPP;
  private final int fPQ;
  private boolean fPR;
  public boolean fPS;
  public com.tencent.mm.network.q ftU;
  private int ftx;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(123463);
    this.fPR = true;
    this.fPS = false;
    this.ftx = 2;
    ab.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    ab.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    ab.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.fPQ = paramInt2;
    this.ftU = new az();
    v.a locala = (v.a)this.ftU.getReqObj();
    locala.setUin(0);
    locala.wiO.jJA = paramString1;
    locala.wiO.wvW = bo.apO(paramString2);
    if (paramInt2 == 4)
    {
      locala.wiO.wvW = paramString6;
      ab.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.wiO.wvW);
    }
    locala.wiO.jKG = paramString3;
    locala.wiO.wmq = paramInt1;
    locala.wiO.wmr = paramString4;
    locala.wiO.wms = paramString5;
    locala.wiO.wQf = paramString6;
    locala.wiO.xfK = paramInt2;
    locala.wiO.lGG = bo.dtS();
    locala.wiO.wQd = com.tencent.mm.compatible.e.q.getSimCountryIso();
    locala.wiO.lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
    locala.wiO.wso = 0;
    locala.wiO.xvg = 0;
    locala.wiO.xvh = com.tencent.mm.compatible.e.q.getAndroidId();
    locala.wiO.wSl = com.tencent.mm.compatible.e.q.LH();
    locala.wiO.xvi = ah.getContext().getSharedPreferences(ah.dsP(), 0).getString("installreferer", "");
    locala.wiO.xvj = com.tencent.mm.plugin.normsg.a.b.pgQ.AP(2);
    locala.wiO.xvk = ah.getContext().getSharedPreferences(ah.dsP() + "_google_aid", com.tencent.mm.compatible.util.h.Mp()).getString("getgoogleaid", "");
    this.fPJ = paramString1;
    this.fPK = paramString2;
    this.fPL = paramString3;
    this.fPM = paramString4;
    this.fPN = paramString5;
    this.fPP = paramInt1;
    this.fPO = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.fPR = bool;
      locala.wiO.wsp = com.tencent.mm.kernel.a.QX();
      AppMethodBeat.o(123463);
      return;
    }
  }
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(123464);
    this.fPR = true;
    this.fPS = false;
    this.ftx = 2;
    ab.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, bo.aqg(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.fPQ = paramInt2;
    this.ftU = new az();
    paramString6 = (v.a)this.ftU.getReqObj();
    paramString6.setUin(0);
    paramString6.wiO.jJA = paramString1;
    paramString6.wiO.wvW = bo.apO(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.wiO.wvW = paramString8;
      ab.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.wiO.wvW);
    }
    paramString6.wiO.jKG = paramString3;
    paramString6.wiO.wmq = paramInt1;
    paramString6.wiO.wmr = paramString4;
    paramString6.wiO.wms = paramString5;
    paramString6.wiO.wQf = paramString8;
    paramString6.wiO.xfK = paramInt2;
    paramString6.wiO.lGG = bo.dtS();
    paramString6.wiO.wQd = com.tencent.mm.compatible.e.q.getSimCountryIso();
    paramString6.wiO.lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
    paramString6.wiO.wso = 0;
    paramString6.wiO.gwU = paramString9;
    paramString6.wiO.xfJ = paramString11;
    paramString6.wiO.xfI = paramString10;
    paramString7 = paramString6.wiO;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.wvK = paramInt2;
      paramString7 = paramString6.wiO;
      if (!paramBoolean2) {
        break label643;
      }
      paramInt2 = 1;
      label427:
      paramString7.xvf = paramInt2;
      paramString6.wiO.wsp = com.tencent.mm.kernel.a.QX();
      paramString6.wiO.xvh = com.tencent.mm.compatible.e.q.getAndroidId();
      paramString6.wiO.wSl = com.tencent.mm.compatible.e.q.LH();
      paramString6.wiO.xvi = ah.getContext().getSharedPreferences(ah.dsP(), 0).getString("installreferer", "");
      paramString6.wiO.xvj = com.tencent.mm.plugin.normsg.a.b.pgQ.AP(2);
      paramString6.wiO.xvk = ah.getContext().getSharedPreferences(ah.dsP() + "_google_aid", com.tencent.mm.compatible.util.h.Mp()).getString("getgoogleaid", "");
      this.fPJ = paramString1;
      this.fPK = paramString2;
      this.fPL = paramString3;
      this.fPM = paramString4;
      this.fPN = paramString5;
      this.fPP = paramInt1;
      this.fPO = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label649;
      }
    }
    label643:
    label649:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.fPR = paramBoolean1;
      AppMethodBeat.o(123464);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label427;
    }
  }
  
  public final String ajG()
  {
    AppMethodBeat.i(123471);
    String str = ((v.b)this.ftU.getRespObj()).wiP.xfI;
    AppMethodBeat.o(123471);
    return str;
  }
  
  public final byte[] ajH()
  {
    AppMethodBeat.i(123470);
    byte[] arrayOfByte = com.tencent.mm.platformtools.aa.a(((v.b)this.ftU.getRespObj()).wiP.xfL, new byte[0]);
    AppMethodBeat.o(123470);
    return arrayOfByte;
  }
  
  public final String ajQ()
  {
    AppMethodBeat.i(123472);
    String str = ((v.b)this.ftU.getRespObj()).wiP.xvx;
    AppMethodBeat.o(123472);
    return str;
  }
  
  public final int ajR()
  {
    AppMethodBeat.i(123473);
    Object localObject = ((v.b)this.ftU.getRespObj()).wiP.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 1);
    }
    for (int i = bo.getInt(localcij.xSX, 0);; i = 0)
    {
      AppMethodBeat.o(123473);
      return i;
    }
  }
  
  public final String ajS()
  {
    AppMethodBeat.i(123474);
    Object localObject = ((v.b)this.ftU.getRespObj()).wiP.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 2);
    }
    for (localObject = localcij.xSX;; localObject = "")
    {
      AppMethodBeat.o(123474);
      return localObject;
    }
  }
  
  public final int ajT()
  {
    AppMethodBeat.i(123475);
    Object localObject = ((v.b)this.ftU.getRespObj()).wiP.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 3);
    }
    for (int i = bo.getInt(localcij.xSX, 2);; i = 2)
    {
      AppMethodBeat.o(123475);
      return i;
    }
  }
  
  public final String ajU()
  {
    AppMethodBeat.i(123476);
    Object localObject = ((v.b)this.ftU.getRespObj()).wiP.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 17);
    }
    for (localObject = localcij.xSX;; localObject = null)
    {
      AppMethodBeat.o(123476);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(123466);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(123466);
    return i;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final void lU(int paramInt)
  {
    AppMethodBeat.i(123465);
    ((v.a)this.ftU.getReqObj()).wiO.wvQ = paramInt;
    AppMethodBeat.o(123465);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123469);
    paramArrayOfByte = (v.b)paramq.getRespObj();
    Object localObject1;
    if (paramArrayOfByte.wiP != null)
    {
      paramInt1 = paramArrayOfByte.wiP.wsa;
      ab.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.RM();
      g.RL().eHM.set(47, Integer.valueOf(paramInt1));
      localObject1 = g.RK().eHt.ftA;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label185;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject1).cT(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        ax.a(true, paramArrayOfByte.wiP.wvY, paramArrayOfByte.wiP.wvZ, paramArrayOfByte.wiP.wvX);
        this.ftx -= 1;
        if (this.ftx <= 0)
        {
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(123469);
          return;
          label185:
          bool = false;
          break;
          ab.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[] { Integer.valueOf(paramArrayOfByte.getRetCode()) });
          continue;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(123469);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ab.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ftx) });
      this.ftx -= 1;
      if (this.ftx <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(123469);
        return;
      }
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(123469);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ab.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.RO().ac(new u.1(this, paramInt1));
      AppMethodBeat.o(123469);
      return;
    }
    if ((paramInt2 == 4) && ((paramInt3 == -305) || (paramInt3 == -306)))
    {
      ab.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.whV) });
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(123469);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(123469);
      return;
    }
    paramq = (v.a)paramq.getReqObj();
    ab.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.wiP.lGy + " regtype:" + paramArrayOfByte.wiP.wmu + " mode:" + paramq.wiO.xfK);
    if ((paramArrayOfByte.wiP.lGw != 0) && (!this.fPR))
    {
      g.RM();
      g.jO(paramArrayOfByte.wiP.lGw);
      g.RL().Ru().set(2, paramq.wiO.jJA);
      g.RL().Ru().set(16, Integer.valueOf(1));
      g.RL().Ru().set(52, Integer.valueOf(paramArrayOfByte.wiP.wmu));
      g.RL().Ru().set(340240, Long.valueOf(System.currentTimeMillis()));
      g.RL().Ru().set(340241, Boolean.TRUE);
      if ((this.fPJ != null) && (this.fPJ.length() > 0) && (this.fPQ != 1)) {
        paramArrayOfByte.wiP.jJA = this.fPJ;
      }
      paramArrayOfByte.wiP.wmr = this.fPM;
      paramArrayOfByte.wiP.jJS = 0;
      if ((!g.RG()) || (g.RL().Ru() == null)) {
        break label1561;
      }
      paramq = this.fPO;
      paramInt1 = this.fPP;
      localObject1 = this.fPL;
      String str1 = this.fPN;
      String str2 = paramArrayOfByte.wiP.jJA;
      String str3 = paramArrayOfByte.wiP.wmr;
      int i = paramArrayOfByte.wiP.jJS;
      String str4 = paramArrayOfByte.wiP.wmx;
      String str5 = paramArrayOfByte.wiP.wmy;
      int j = paramArrayOfByte.wiP.wmz;
      int k = paramArrayOfByte.wiP.xvr;
      String str6 = paramArrayOfByte.wiP.wkY;
      String str7 = paramArrayOfByte.wiP.wmA;
      String str8 = paramArrayOfByte.wiP.wrS;
      Object localObject2 = paramArrayOfByte.wiP.xvq;
      ab.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, paramq, com.tencent.mm.a.p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), bo.aqg(str6), str7, Integer.valueOf(0), bo.aqg(str8), bo.aqg(null), bo.aqg(null), bo.aqg(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = g.RL().Ru();
      av.flM.ao("login_weixin_username", str2);
      av.flM.ao("last_login_nick_name", (String)localObject1);
      av.flM.d(str1, paramInt1, str3);
      ((z)localObject2).set(2, str2);
      ((z)localObject2).set(42, paramq);
      ((z)localObject2).set(9, Integer.valueOf(paramInt1));
      ((z)localObject2).set(4, localObject1);
      ((z)localObject2).set(5, str3);
      ((z)localObject2).set(6, str1);
      ((z)localObject2).set(7, Integer.valueOf(i));
      ((z)localObject2).set(21, str4);
      ((z)localObject2).set(22, str5);
      ((z)localObject2).set(57, Integer.valueOf(0));
      ((z)localObject2).set(17, Integer.valueOf(j));
      ((z)localObject2).set(25, Integer.valueOf(k));
      ((z)localObject2).set(1, str6);
      ((z)localObject2).set(29, str7);
      ((z)localObject2).set(34, Integer.valueOf(0));
      ((z)localObject2).set(256, Boolean.FALSE);
      ab.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((z)localObject2).set(-1535680990, str8);
      ((z)localObject2).set(46, null);
      ((z)localObject2).set(72, null);
      ((z)localObject2).set(64, Integer.valueOf(-1));
      ((z)localObject2).dww();
      ((PluginAuth)g.G(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.fPO, this.fPP, this.fPL, this.fPN, 0);
      ax.a(false, paramArrayOfByte.wiP.wvY, paramArrayOfByte.wiP.wvZ, paramArrayOfByte.wiP.wvX);
      g.RL().Ru().dww();
      g.Rc().a(new bk(new u.2(this, paramArrayOfByte)), 0);
      ab.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.wiP.xvt);
      if ((paramArrayOfByte.wiP.xvt & 0x1) == 0) {
        break label1611;
      }
    }
    label1561:
    label1611:
    for (boolean bool = true;; bool = false)
    {
      this.fPS = bool;
      paramq = new LinkedList();
      paramq.add(new h.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((j)g.E(j.class)).Yz().c(new com.tencent.mm.az.h(paramq));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(123469);
      return;
      bool = g.RG();
      g.RJ();
      ab.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.a.p.getString(com.tencent.mm.kernel.a.getUin()), g.RL().Ru() });
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final m.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
  
  public final void uq(String paramString)
  {
    AppMethodBeat.i(123467);
    if (!bo.isNullOrNil(paramString))
    {
      ((v.a)this.ftU.getReqObj()).wiO.wvR = paramString;
      ab.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(123467);
  }
  
  public final void ur(String paramString)
  {
    AppMethodBeat.i(123468);
    if (!bo.isNullOrNil(paramString))
    {
      ((v.a)this.ftU.getReqObj()).wiO.xvp = paramString;
      ab.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(123468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */