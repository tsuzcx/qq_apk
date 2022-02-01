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
import com.tencent.mm.bb.i;
import com.tencent.mm.bb.i.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bo;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends n
  implements k
{
  com.tencent.mm.al.f callback;
  public com.tencent.mm.network.q hON;
  private int hOs;
  private final String imh;
  private final String imi;
  private final String imj;
  private final String imk;
  private final String iml;
  private final String imm;
  private final int imn;
  private final int imo;
  private boolean imp;
  public boolean imq;
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(134188);
    this.imp = true;
    this.imq = false;
    this.hOs = 2;
    ad.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    ad.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    ad.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.imo = paramInt2;
    this.hON = new bd();
    x.a locala = (x.a)this.hON.getReqObj();
    locala.setUin(0);
    locala.Foz.nDo = paramString1;
    locala.Foz.FEb = bt.aQY(paramString2);
    if (paramInt2 == 4)
    {
      locala.Foz.FEb = paramString6;
      ad.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.Foz.FEb);
    }
    locala.Foz.nEt = paramString3;
    locala.Foz.Fsf = paramInt1;
    locala.Foz.Fsg = paramString4;
    locala.Foz.Fsh = paramString5;
    locala.Foz.xbo = paramString6;
    locala.Foz.GDy = paramInt2;
    locala.Foz.qeh = bt.flM();
    locala.Foz.GdW = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    locala.Foz.qei = com.tencent.mm.sdk.platformtools.ac.fks();
    locala.Foz.FzH = 0;
    locala.Foz.GWu = 0;
    locala.Foz.GWv = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
    locala.Foz.Ggx = com.tencent.mm.compatible.deviceinfo.q.aav();
    locala.Foz.GWw = aj.getContext().getSharedPreferences(aj.fkC(), 0).getString("installreferer", "");
    locala.Foz.GWx = com.tencent.mm.plugin.normsg.a.b.wtJ.LY(2);
    locala.Foz.GWy = aj.getContext().getSharedPreferences(aj.fkC() + "_google_aid", com.tencent.mm.compatible.util.g.abm()).getString("getgoogleaid", "");
    this.imh = paramString1;
    this.imi = paramString2;
    this.imj = paramString3;
    this.imk = paramString4;
    this.iml = paramString5;
    this.imn = paramInt1;
    this.imm = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.imp = bool;
      locala.Foz.FzI = com.tencent.mm.kernel.a.aiO();
      AppMethodBeat.o(134188);
      return;
    }
  }
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134189);
    this.imp = true;
    this.imq = false;
    this.hOs = 2;
    ad.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, bt.aRp(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.imo = paramInt2;
    this.hON = new bd();
    paramString6 = (x.a)this.hON.getReqObj();
    paramString6.setUin(0);
    paramString6.Foz.nDo = paramString1;
    paramString6.Foz.FEb = bt.aQY(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.Foz.FEb = paramString8;
      ad.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.Foz.FEb);
    }
    paramString6.Foz.nEt = paramString3;
    paramString6.Foz.Fsf = paramInt1;
    paramString6.Foz.Fsg = paramString4;
    paramString6.Foz.Fsh = paramString5;
    paramString6.Foz.xbo = paramString8;
    paramString6.Foz.GDy = paramInt2;
    paramString6.Foz.qeh = bt.flM();
    paramString6.Foz.GdW = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
    paramString6.Foz.qei = com.tencent.mm.sdk.platformtools.ac.fks();
    paramString6.Foz.FzH = 0;
    paramString6.Foz.jdh = paramString9;
    paramString6.Foz.GDx = paramString11;
    paramString6.Foz.GDw = paramString10;
    paramString7 = paramString6.Foz;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.FDN = paramInt2;
      paramString7 = paramString6.Foz;
      if (!paramBoolean2) {
        break label643;
      }
      paramInt2 = 1;
      label427:
      paramString7.GWt = paramInt2;
      paramString6.Foz.FzI = com.tencent.mm.kernel.a.aiO();
      paramString6.Foz.GWv = com.tencent.mm.compatible.deviceinfo.q.getAndroidId();
      paramString6.Foz.Ggx = com.tencent.mm.compatible.deviceinfo.q.aav();
      paramString6.Foz.GWw = aj.getContext().getSharedPreferences(aj.fkC(), 0).getString("installreferer", "");
      paramString6.Foz.GWx = com.tencent.mm.plugin.normsg.a.b.wtJ.LY(2);
      paramString6.Foz.GWy = aj.getContext().getSharedPreferences(aj.fkC() + "_google_aid", com.tencent.mm.compatible.util.g.abm()).getString("getgoogleaid", "");
      this.imh = paramString1;
      this.imi = paramString2;
      this.imj = paramString3;
      this.imk = paramString4;
      this.iml = paramString5;
      this.imn = paramInt1;
      this.imm = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label649;
      }
    }
    label643:
    label649:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.imp = paramBoolean1;
      AppMethodBeat.o(134189);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label427;
    }
  }
  
  public final void Gn(String paramString)
  {
    AppMethodBeat.i(134192);
    if (!bt.isNullOrNil(paramString))
    {
      ((x.a)this.hON.getReqObj()).Foz.FDU = paramString;
      ad.i("MicroMsg.NetSceneReg", "setRegSessionId %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134192);
  }
  
  public final void Go(String paramString)
  {
    AppMethodBeat.i(134193);
    if (!bt.isNullOrNil(paramString))
    {
      ((x.a)this.hON.getReqObj()).Foz.GWD = paramString;
      ad.i("MicroMsg.NetSceneReg", "thirdAppTicket %s", new Object[] { paramString });
    }
    AppMethodBeat.o(134193);
  }
  
  public final String aKL()
  {
    AppMethodBeat.i(134196);
    String str = ((x.b)this.hON.getRespObj()).FoA.GDw;
    AppMethodBeat.o(134196);
    return str;
  }
  
  public final byte[] aKM()
  {
    AppMethodBeat.i(134195);
    byte[] arrayOfByte = z.a(((x.b)this.hON.getRespObj()).FoA.GDz, new byte[0]);
    AppMethodBeat.o(134195);
    return arrayOfByte;
  }
  
  public final String aKV()
  {
    AppMethodBeat.i(134197);
    String str = ((x.b)this.hON.getRespObj()).FoA.GWL;
    AppMethodBeat.o(134197);
    return str;
  }
  
  public final int aKW()
  {
    AppMethodBeat.i(134198);
    Object localObject = ((x.b)this.hON.getRespObj()).FoA.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 1);
    }
    for (int i = bt.getInt(localdkj.Hza, 0);; i = 0)
    {
      AppMethodBeat.o(134198);
      return i;
    }
  }
  
  public final String aKX()
  {
    AppMethodBeat.i(134199);
    Object localObject = ((x.b)this.hON.getRespObj()).FoA.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 2);
    }
    for (localObject = localdkj.Hza;; localObject = "")
    {
      AppMethodBeat.o(134199);
      return localObject;
    }
  }
  
  public final int aKY()
  {
    AppMethodBeat.i(134200);
    Object localObject = ((x.b)this.hON.getRespObj()).FoA.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 3);
    }
    for (int i = bt.getInt(localdkj.Hza, 2);; i = 2)
    {
      AppMethodBeat.o(134200);
      return i;
    }
  }
  
  public final String aKZ()
  {
    AppMethodBeat.i(134201);
    Object localObject = ((x.b)this.hON.getRespObj()).FoA.Fze;
    dkj localdkj;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject).next();
      } while (localdkj.yhn != 17);
    }
    for (localObject = localdkj.Hza;; localObject = null)
    {
      AppMethodBeat.o(134201);
      return localObject;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(134191);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(134191);
    return i;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134194);
    paramArrayOfByte = (x.b)paramq.getRespObj();
    Object localObject1;
    if (paramArrayOfByte.FoA != null)
    {
      paramInt1 = paramArrayOfByte.FoA.Fzj;
      ad.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().gBh.set(47, Integer.valueOf(paramInt1));
      localObject1 = com.tencent.mm.kernel.g.ajB().gAO.hOv;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label185;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject1).eI(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        bb.a(true, paramArrayOfByte.FoA.FEd, paramArrayOfByte.FoA.FEe, paramArrayOfByte.FoA.FEc);
        this.hOs -= 1;
        if (this.hOs <= 0)
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
      ad.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hOs) });
      this.hOs -= 1;
      if (this.hOs <= 0)
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
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134186);
          new l().doScene(u.this.dispatcher(), new com.tencent.mm.al.f()
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
      ad.i("MicroMsg.NetSceneReg", "summerauth newreg MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.Fnx) });
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
    ad.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.FoA.qdZ + " regtype:" + paramArrayOfByte.FoA.Fsj + " mode:" + paramq.Foz.GDy);
    if ((paramArrayOfByte.FoA.qdX != 0) && (!this.imp))
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.mQ(paramArrayOfByte.FoA.qdX);
      com.tencent.mm.kernel.g.ajC().ajl().set(2, paramq.Foz.nDo);
      com.tencent.mm.kernel.g.ajC().ajl().set(16, Integer.valueOf(1));
      com.tencent.mm.kernel.g.ajC().ajl().set(52, Integer.valueOf(paramArrayOfByte.FoA.Fsj));
      com.tencent.mm.kernel.g.ajC().ajl().set(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.ajC().ajl().set(340241, Boolean.TRUE);
      if ((this.imh != null) && (this.imh.length() > 0) && (this.imo != 1)) {
        paramArrayOfByte.FoA.nDo = this.imh;
      }
      paramArrayOfByte.FoA.Fsg = this.imk;
      paramArrayOfByte.FoA.nDG = 0;
      if ((!com.tencent.mm.kernel.g.ajx()) || (com.tencent.mm.kernel.g.ajC().ajl() == null)) {
        break label1561;
      }
      paramq = this.imm;
      paramInt1 = this.imn;
      localObject1 = this.imj;
      String str1 = this.iml;
      String str2 = paramArrayOfByte.FoA.nDo;
      String str3 = paramArrayOfByte.FoA.Fsg;
      int i = paramArrayOfByte.FoA.nDG;
      String str4 = paramArrayOfByte.FoA.Fsm;
      String str5 = paramArrayOfByte.FoA.Fsn;
      int j = paramArrayOfByte.FoA.Fso;
      int k = paramArrayOfByte.FoA.GWF;
      String str6 = paramArrayOfByte.FoA.FqI;
      String str7 = paramArrayOfByte.FoA.Fsp;
      String str8 = paramArrayOfByte.FoA.Fzb;
      Object localObject2 = paramArrayOfByte.FoA.GWE;
      ad.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, paramq, p.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), bt.aRp(str6), str7, Integer.valueOf(0), bt.aRp(str8), bt.aRp(null), bt.aRp(null), bt.aRp(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = com.tencent.mm.kernel.g.ajC().ajl();
      az.hFS.aM("login_weixin_username", str2);
      az.hFS.aM("last_login_nick_name", (String)localObject1);
      az.hFS.h(str1, paramInt1, str3);
      ((ai)localObject2).set(2, str2);
      ((ai)localObject2).set(42, paramq);
      ((ai)localObject2).set(9, Integer.valueOf(paramInt1));
      ((ai)localObject2).set(4, localObject1);
      ((ai)localObject2).set(5, str3);
      ((ai)localObject2).set(6, str1);
      ((ai)localObject2).set(7, Integer.valueOf(i));
      ((ai)localObject2).set(21, str4);
      ((ai)localObject2).set(22, str5);
      ((ai)localObject2).set(57, Integer.valueOf(0));
      ((ai)localObject2).set(17, Integer.valueOf(j));
      ((ai)localObject2).set(25, Integer.valueOf(k));
      ((ai)localObject2).set(1, str6);
      ((ai)localObject2).set(29, str7);
      ((ai)localObject2).set(34, Integer.valueOf(0));
      ((ai)localObject2).set(256, Boolean.FALSE);
      ad.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((ai)localObject2).set(-1535680990, str8);
      ((ai)localObject2).set(46, null);
      ((ai)localObject2).set(72, null);
      ((ai)localObject2).set(64, Integer.valueOf(-1));
      ((ai)localObject2).fqc();
      ((PluginAuth)com.tencent.mm.kernel.g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.imm, this.imn, this.imj, this.iml, 0);
      bb.a(false, paramArrayOfByte.FoA.FEd, paramArrayOfByte.FoA.FEe, paramArrayOfByte.FoA.FEc);
      com.tencent.mm.kernel.g.ajC().ajl().fqc();
      com.tencent.mm.kernel.g.aiU().a(new bo(new u.2(this, paramArrayOfByte)), 0);
      ad.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.FoA.GWH);
      if ((paramArrayOfByte.FoA.GWH & 0x1) == 0) {
        break label1611;
      }
    }
    label1561:
    label1611:
    for (boolean bool = true;; bool = false)
    {
      this.imq = bool;
      paramq = new LinkedList();
      paramq.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new i(paramq));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134194);
      return;
      bool = com.tencent.mm.kernel.g.ajx();
      com.tencent.mm.kernel.g.ajA();
      ad.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), p.getString(com.tencent.mm.kernel.a.getUin()), com.tencent.mm.kernel.g.ajC().ajl() });
      break;
    }
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(134190);
    ((x.a)this.hON.getReqObj()).Foz.FDT = paramInt;
    AppMethodBeat.o(134190);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */