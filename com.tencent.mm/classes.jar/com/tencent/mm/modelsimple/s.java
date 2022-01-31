package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.ay.g.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends m
  implements k
{
  f dmL;
  private final int eAa;
  private boolean eAb = true;
  public boolean eAc = false;
  public com.tencent.mm.network.q edR;
  private int edu = 2;
  private final String ezT;
  private final String ezU;
  private final String ezV;
  private final String ezW;
  private final String ezX;
  private final String ezY;
  private final int ezZ;
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.eAa = paramInt2;
    this.edR = new ax();
    u.a locala = (u.a)this.edR.Kv();
    locala.fn(0);
    locala.sqk.hPY = paramString1;
    locala.sqk.sBC = bk.ZK(paramString2);
    if (paramInt2 == 4)
    {
      locala.sqk.sBC = paramString6;
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.sqk.sBC);
    }
    locala.sqk.hRf = paramString3;
    locala.sqk.stM = paramInt1;
    locala.sqk.stN = paramString4;
    locala.sqk.stO = paramString5;
    locala.sqk.sRr = paramString6;
    locala.sqk.tgW = paramInt2;
    locala.sqk.jxh = bk.crV();
    locala.sqk.sRp = com.tencent.mm.compatible.e.q.getSimCountryIso();
    locala.sqk.jxi = x.cqJ();
    locala.sqk.syG = 0;
    locala.sqk.tuX = 0;
    locala.sqk.tuY = com.tencent.mm.compatible.e.q.getAndroidId();
    locala.sqk.sUo = com.tencent.mm.compatible.e.q.zi();
    locala.sqk.tuZ = ae.getContext().getSharedPreferences(ae.cqR(), 0).getString("installreferer", "");
    locala.sqk.tva = com.tencent.mm.plugin.normsg.a.b.mGK.vr(2);
    locala.sqk.tvb = ae.getContext().getSharedPreferences(ae.cqR() + "_google_aid", 4).getString("getgoogleaid", "");
    this.ezT = paramString1;
    this.ezU = paramString2;
    this.ezV = paramString3;
    this.ezW = paramString4;
    this.ezX = paramString5;
    this.ezZ = paramInt1;
    this.ezY = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.eAb = bool;
      locala.sqk.syH = com.tencent.mm.kernel.a.Df();
      return;
    }
  }
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, bk.aac(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.eAa = paramInt2;
    this.edR = new ax();
    paramString6 = (u.a)this.edR.Kv();
    paramString6.fn(0);
    paramString6.sqk.hPY = paramString1;
    paramString6.sqk.sBC = bk.ZK(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.sqk.sBC = paramString8;
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.sqk.sBC);
    }
    paramString6.sqk.hRf = paramString3;
    paramString6.sqk.stM = paramInt1;
    paramString6.sqk.stN = paramString4;
    paramString6.sqk.stO = paramString5;
    paramString6.sqk.sRr = paramString8;
    paramString6.sqk.tgW = paramInt2;
    paramString6.sqk.jxh = bk.crV();
    paramString6.sqk.sRp = com.tencent.mm.compatible.e.q.getSimCountryIso();
    paramString6.sqk.jxi = x.cqJ();
    paramString6.sqk.syG = 0;
    paramString6.sqk.ffm = paramString9;
    paramString6.sqk.tgV = paramString11;
    paramString6.sqk.tgU = paramString10;
    paramString7 = paramString6.sqk;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.sBq = paramInt2;
      paramString7 = paramString6.sqk;
      if (!paramBoolean2) {
        break label629;
      }
      paramInt2 = 1;
      label421:
      paramString7.tuW = paramInt2;
      paramString6.sqk.syH = com.tencent.mm.kernel.a.Df();
      paramString6.sqk.tuY = com.tencent.mm.compatible.e.q.getAndroidId();
      paramString6.sqk.sUo = com.tencent.mm.compatible.e.q.zi();
      paramString6.sqk.tuZ = ae.getContext().getSharedPreferences(ae.cqR(), 0).getString("installreferer", "");
      paramString6.sqk.tva = com.tencent.mm.plugin.normsg.a.b.mGK.vr(2);
      paramString6.sqk.tvb = ae.getContext().getSharedPreferences(ae.cqR() + "_google_aid", 4).getString("getgoogleaid", "");
      this.ezT = paramString1;
      this.ezU = paramString2;
      this.ezV = paramString3;
      this.ezW = paramString4;
      this.ezX = paramString5;
      this.ezZ = paramInt1;
      this.ezY = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label635;
      }
    }
    label629:
    label635:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.eAb = paramBoolean1;
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label421;
    }
  }
  
  protected final int Ka()
  {
    return 3;
  }
  
  public final byte[] QA()
  {
    return aa.a(((u.b)this.edR.HF()).sqm.tgX, new byte[0]);
  }
  
  public final String QI()
  {
    return ((u.b)this.edR.HF()).sqm.tvm;
  }
  
  public final int QJ()
  {
    Object localObject = ((u.b)this.edR.HF()).sqm.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 1) {
          return bk.getInt(localbwb.tMN, 0);
        }
      }
    }
    return 0;
  }
  
  public final String QK()
  {
    Object localObject = ((u.b)this.edR.HF()).sqm.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 2) {
          return localbwb.tMN;
        }
      }
    }
    return "";
  }
  
  public final int QL()
  {
    Object localObject = ((u.b)this.edR.HF()).sqm.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 3) {
          return bk.getInt(localbwb.tMN, 2);
        }
      }
    }
    return 2;
  }
  
  public final String QM()
  {
    Object localObject = ((u.b)this.edR.HF()).sqm.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 17) {
          return localbwb.tMN;
        }
      }
    }
    return null;
  }
  
  public final String Qz()
  {
    return ((u.b)this.edR.HF()).sqm.tgU;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (u.b)paramq.HF();
    Object localObject1;
    if (paramArrayOfByte.sqm != null)
    {
      paramInt1 = paramArrayOfByte.sqm.syx;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().dKo.set(47, Integer.valueOf(paramInt1));
      localObject1 = com.tencent.mm.kernel.g.DO().dJT.edx;
      if (localObject1 != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label173;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject1).bR(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        av.a(true, paramArrayOfByte.sqm.sBE, paramArrayOfByte.sqm.sBF, paramArrayOfByte.sqm.sBD);
        this.edu -= 1;
        if (this.edu <= 0)
        {
          this.dmL.onSceneEnd(3, -1, "", this);
          return;
          label173:
          bool = false;
          break;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[] { Integer.valueOf(paramArrayOfByte.spN) });
          continue;
        }
        a(this.edc, this.dmL);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.edu) });
      this.edu -= 1;
      if (this.edu <= 0)
      {
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      a(this.edc, this.dmL);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.Kv().spM.ver;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.DS().O(new Runnable()
      {
        public final void run()
        {
          new i().a(s.this.edc, new s.1.1(this));
        }
      });
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (u.a)paramq.Kv();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.sqm.jwZ + " regtype:" + paramArrayOfByte.sqm.stQ + " mode:" + paramq.sqk.tgW);
    if ((paramArrayOfByte.sqm.jwX != 0) && (!this.eAb))
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.hx(paramArrayOfByte.sqm.jwX);
      com.tencent.mm.kernel.g.DP().Dz().o(2, paramq.sqk.hPY);
      com.tencent.mm.kernel.g.DP().Dz().o(16, Integer.valueOf(1));
      com.tencent.mm.kernel.g.DP().Dz().o(52, Integer.valueOf(paramArrayOfByte.sqm.stQ));
      com.tencent.mm.kernel.g.DP().Dz().o(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.DP().Dz().o(340241, Boolean.valueOf(true));
      if ((this.ezT != null) && (this.ezT.length() > 0) && (this.eAa != 1)) {
        paramArrayOfByte.sqm.hPY = this.ezT;
      }
      paramArrayOfByte.sqm.stN = this.ezW;
      paramArrayOfByte.sqm.hQq = 0;
      if ((!com.tencent.mm.kernel.g.DK()) || (com.tencent.mm.kernel.g.DP().Dz() == null)) {
        break label1450;
      }
      paramq = this.ezY;
      paramInt1 = this.ezZ;
      localObject1 = this.ezV;
      String str1 = this.ezX;
      String str2 = paramArrayOfByte.sqm.hPY;
      String str3 = paramArrayOfByte.sqm.stN;
      int i = paramArrayOfByte.sqm.hQq;
      String str4 = paramArrayOfByte.sqm.stT;
      String str5 = paramArrayOfByte.sqm.stU;
      int j = paramArrayOfByte.sqm.stV;
      int k = paramArrayOfByte.sqm.tvg;
      String str6 = paramArrayOfByte.sqm.sst;
      String str7 = paramArrayOfByte.sqm.stW;
      String str8 = paramArrayOfByte.sqm.syp;
      Object localObject2 = paramArrayOfByte.sqm.tvf;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str2, paramq, o.getString(paramInt1), localObject1, str3, str1, Integer.valueOf(i), str4, str5, Integer.valueOf(j), Integer.valueOf(k), bk.aac(str6), str7, Integer.valueOf(0), bk.aac(str8), bk.aac(null), bk.aac(null), bk.aac(null), Integer.valueOf(-1), localObject2, Integer.valueOf(0) });
      localObject2 = com.tencent.mm.kernel.g.DP().Dz();
      at.dVC.Y("login_weixin_username", str2);
      at.dVC.Y("last_login_nick_name", (String)localObject1);
      at.dVC.c(str1, paramInt1, str3);
      ((z)localObject2).o(2, str2);
      ((z)localObject2).o(42, paramq);
      ((z)localObject2).o(9, Integer.valueOf(paramInt1));
      ((z)localObject2).o(4, localObject1);
      ((z)localObject2).o(5, str3);
      ((z)localObject2).o(6, str1);
      ((z)localObject2).o(7, Integer.valueOf(i));
      ((z)localObject2).o(21, str4);
      ((z)localObject2).o(22, str5);
      ((z)localObject2).o(57, Integer.valueOf(0));
      ((z)localObject2).o(17, Integer.valueOf(j));
      ((z)localObject2).o(25, Integer.valueOf(k));
      ((z)localObject2).o(1, str6);
      ((z)localObject2).o(29, str7);
      ((z)localObject2).o(34, Integer.valueOf(0));
      ((z)localObject2).o(256, Boolean.valueOf(false));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
      ((z)localObject2).o(-1535680990, str8);
      ((z)localObject2).o(46, null);
      ((z)localObject2).o(72, null);
      ((z)localObject2).o(64, Integer.valueOf(-1));
      ((z)localObject2).mC(true);
      ((PluginAuth)com.tencent.mm.kernel.g.t(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.ezY, this.ezZ, this.ezV, this.ezX, 0);
      av.a(false, paramArrayOfByte.sqm.sBE, paramArrayOfByte.sqm.sBF, paramArrayOfByte.sqm.sBD);
      com.tencent.mm.kernel.g.DP().Dz().mC(true);
      com.tencent.mm.kernel.g.Dk().a(new bi(new s.2(this, paramArrayOfByte)), 0);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.sqm.tvi);
      if ((paramArrayOfByte.sqm.tvi & 0x1) == 0) {
        break label1500;
      }
    }
    label1450:
    label1500:
    for (boolean bool = true;; bool = false)
    {
      this.eAc = bool;
      paramq = new LinkedList();
      paramq.add(new g.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new com.tencent.mm.ay.g(paramq));
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      bool = com.tencent.mm.kernel.g.DK();
      com.tencent.mm.kernel.g.DN();
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), o.getString(com.tencent.mm.kernel.a.CK()), com.tencent.mm.kernel.g.DP().Dz() });
      break;
    }
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final void jc(int paramInt)
  {
    ((u.a)this.edR.Kv()).sqk.sBw = paramInt;
  }
  
  public final void ne(String paramString)
  {
    if (!bk.bl(paramString)) {
      ((u.a)this.edR.Kv()).sqk.sBx = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */