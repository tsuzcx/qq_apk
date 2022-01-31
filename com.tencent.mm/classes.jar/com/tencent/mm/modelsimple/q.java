package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.jn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.protocal.c.bwb;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.chv;
import com.tencent.mm.protocal.c.chw;
import com.tencent.mm.protocal.c.clp;
import com.tencent.mm.protocal.c.clq;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class q
  extends com.tencent.mm.ah.m
  implements k
{
  public String account = "";
  com.tencent.mm.ah.f dmL;
  public final com.tencent.mm.network.q edR;
  private int edu = 3;
  private int errCode = 0;
  private int errType = 0;
  private String ezE = "";
  private String ezF = "";
  private boolean ezG = false;
  private boolean ezH = false;
  private int ezI = 0;
  private int ezJ = 0;
  public String ezK;
  private boolean ezL = false;
  
  public q(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public q(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + bk.csb());
    this.ezH = paramBoolean2;
    this.account = paramString1;
    this.edR = new av(701);
    Object localObject1 = (i.d)this.edR.Kv();
    int i = av.HD().getInt("key_auth_update_version", 0);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.spa) });
    avr localavr;
    Object localObject2;
    if (i == 0)
    {
      ((k.d)localObject1).spI = 1;
      com.tencent.mm.plugin.report.f.nEG.a(148L, 0L, 1L, false);
      ((i.d)localObject1).spx = true;
      ((i.d)localObject1).fn(0);
      localavr = new avr();
      localObject2 = new avp();
      ((i.d)localObject1).spw.trj = localavr;
      ((i.d)localObject1).spw.trk = ((avp)localObject2);
      ((avp)localObject2).tri = paramInt2;
      localObject1 = new ga();
      ((avp)localObject2).syE = ((ga)localObject1);
      ((ga)localObject1).syt = paramString6;
      ((ga)localObject1).sAf = 0;
      ((ga)localObject1).syo = new bmk().bs(new byte[0]);
      ((ga)localObject1).syn = new bmk().bs(new byte[0]);
      paramString6 = new chv();
      ((ga)localObject1).sAd = paramString6;
      paramString6.sBQ = "";
      paramString6.sBP = "";
      paramString6.tWv = "";
      localObject2 = new clp();
      ((ga)localObject1).sAe = ((clp)localObject2);
      ((clp)localObject2).tgV = "";
      ((clp)localObject2).tgU = "";
      if (paramInt1 != 1) {
        break label819;
      }
      paramString6.sBQ = paramString3;
      paramString6.sBP = paramString4;
      paramString6.tWv = paramString5;
      ((clp)localObject2).tgV = "";
      ((clp)localObject2).tgU = "";
      label514:
      if ((!bk.bl(paramString1)) || (!g.DK())) {
        break label870;
      }
      com.tencent.mm.plugin.report.f.nEG.a(148L, 2L, 1L, false);
      this.ezE = ((String)g.DP().Dz().get(3, null));
      this.ezF = ((String)g.DP().Dz().get(19, null));
      paramString1 = (i.e)this.edR.HF();
      paramString2 = bk.pm((String)g.DP().Dz().get(2, null));
      if (!bk.bl(paramString2)) {
        break label862;
      }
      paramString2 = new com.tencent.mm.a.o(bk.a((Integer)g.DP().Dz().get(9, null), 0)).toString();
      label646:
      localavr.hPY = paramString2;
      paramString4 = null;
      paramString1 = paramString4;
      if (paramInt1 != 1)
      {
        paramString1 = paramString4;
        if (paramInt1 != 3)
        {
          if (paramInt1 != 2) {
            break label922;
          }
          paramString1 = g.DN().CU().f(bk.getLong(paramString2, 0L), paramString3);
        }
      }
      label693:
      if (paramString1 != null) {
        break label955;
      }
    }
    label819:
    label955:
    for (paramInt1 = -1;; paramInt1 = paramString1.length)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), bk.aac(bk.bD(paramString1)) });
      paramString3 = new bmk();
      paramString2 = paramString1;
      if (bk.bE(paramString1)) {
        paramString2 = new byte[0];
      }
      ((ga)localObject1).sAc = paramString3.bs(paramString2);
      localavr.sBC = this.ezF;
      localavr.sBO = this.ezE;
      return;
      if (i < com.tencent.mm.protocal.d.spa)
      {
        ((k.d)localObject1).spI = 16;
        com.tencent.mm.plugin.report.f.nEG.a(148L, 1L, 1L, false);
        break;
      }
      ((k.d)localObject1).spI = 1;
      break;
      if (paramInt1 != 3) {
        break label514;
      }
      paramString6.sBQ = "";
      paramString6.sBP = "";
      paramString6.tWv = "";
      ((clp)localObject2).tgV = paramString3;
      ((clp)localObject2).tgU = paramString4;
      break label514;
      label862:
      paramString1.eNw = paramString2;
      break label646;
      label870:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.ezE = paramString2;
        this.ezF = paramString2;
        paramString2 = paramString1;
        break label646;
      }
      this.ezE = bk.ZK(bk.pm(paramString2));
      this.ezF = bk.ZL(bk.pm(paramString2));
      paramString2 = paramString1;
      break label646;
      paramString1 = paramString4;
      if (!bk.ZB(paramString2)) {
        break label693;
      }
      paramString1 = g.DN().CU().a(bk.getLong(paramString2, 0L), this.ezF, true);
      break label693;
    }
  }
  
  public q(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, 0, "", "", "", paramInt, paramString3, false, false);
  }
  
  public q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString2, paramString3, 0, "", "", "", 0, paramString4, true, false);
    this.ezK = paramString1;
  }
  
  protected final int Ka()
  {
    return 5;
  }
  
  public final String NK()
  {
    return ((i.e)this.edR.HF()).spz.tPv.syt;
  }
  
  public final byte[] QA()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return new byte[0];
    }
    int i = getSecCodeType();
    if (i == 3)
    {
      if (((i.e)this.edR.HF()).spz.tPv.sym != null) {
        return aa.a(((i.e)this.edR.HF()).spz.tPv.sym.tgX, new byte[0]);
      }
    }
    else if (i == 1)
    {
      if (((i.e)this.edR.HF()).spz.tPv.syl != null) {
        return aa.a(((i.e)this.edR.HF()).spz.tPv.syl.svJ, new byte[0]);
      }
    }
    else if ((i == 2) && (((i.d)this.edR.Kv()).spw.trj != null))
    {
      g.DN().CU().a(bk.getLong(((i.d)this.edR.Kv()).spw.trj.hPY, 0L), aa.a(((i.e)this.edR.HF()).spz.tPv.syk));
      return g.DN().CU().bH(bk.getLong(((i.d)this.edR.Kv()).spw.trj.hPY, 0L));
    }
    return new byte[0];
  }
  
  public final String QB()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return "";
    }
    if ((getSecCodeType() == 1) && (((i.e)this.edR.HF()).spz.tPv.syl != null))
    {
      if (((i.e)this.edR.HF()).spz.tPv.syl.tWv != null) {
        return ((i.e)this.edR.HF()).spz.tPv.syl.tWv;
      }
      return null;
    }
    return "";
  }
  
  public final String QC()
  {
    return ((i.e)this.edR.HF()).spz.tPw.stO;
  }
  
  public final int QD()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return 0;
    }
    Object localObject = ((i.e)this.edR.HF()).spz.tPv.sys;
    bwb localbwb;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbwb = (bwb)((Iterator)localObject).next();
      } while (localbwb.nFi != 11);
    }
    for (int i = bk.getInt(localbwb.tMN, 0);; i = 0) {
      return i;
    }
  }
  
  public final BindWordingContent QE()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return null;
    }
    Object localObject1 = ((i.e)this.edR.HF()).spz.tPv.sys;
    bwb localbwb;
    if ((localObject1 != null) && (((bsd)localObject1).tIO != null) && (((bsd)localObject1).tIO.size() > 0))
    {
      localObject1 = ((bsd)localObject1).tIO.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localbwb = (bwb)((Iterator)localObject1).next();
      } while (localbwb.nFi != 12);
    }
    Object localObject3;
    for (localObject1 = localbwb.tMN;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.nc((String)localObject1);
          return localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String QF()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return "";
    }
    Object localObject = ((i.e)this.edR.HF()).spz.tPv.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 16) {
          return localbwb.tMN;
        }
      }
    }
    return "";
  }
  
  public final int QG()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return 0;
    }
    Object localObject = ((i.e)this.edR.HF()).spz.tPv.sys;
    bwb localbwb;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbwb = (bwb)((Iterator)localObject).next();
      } while (localbwb.nFi != 13);
    }
    for (int i = bk.getInt(localbwb.tMN, 0);; i = 0) {
      return i;
    }
  }
  
  public final boolean QH()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return true;
    }
    Object localObject = ((i.e)this.edR.HF()).spz.tPv.sys;
    if ((localObject != null) && (((bsd)localObject).tIO != null) && (((bsd)localObject).tIO.size() > 0))
    {
      localObject = ((bsd)localObject).tIO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bwb localbwb = (bwb)((Iterator)localObject).next();
        if (localbwb.nFi == 18) {
          if (bk.getInt(localbwb.tMN, 0) == 1) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public final q Qx()
  {
    this.ezL = true;
    return this;
  }
  
  public final String Qy()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return "";
    }
    return ((i.e)this.edR.HF()).spz.tPv.syr;
  }
  
  public final String Qz()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null) {
      return "";
    }
    int i = getSecCodeType();
    if (i == 3)
    {
      if (((i.e)this.edR.HF()).spz.tPv.sym != null) {
        return bk.pm(((i.e)this.edR.HF()).spz.tPv.sym.tgU);
      }
    }
    else if ((i == 1) && (((i.e)this.edR.HF()).spz.tPv.syl != null)) {
      return bk.pm(((i.e)this.edR.HF()).spz.tPv.syl.sBP);
    }
    return "";
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (i.d)paramq.Kv();
    i.e locale = (i.e)paramq.HF();
    Object localObject;
    boolean bool;
    if ((locale.spz != null) && (locale.spz.tPv != null))
    {
      paramInt1 = locale.spz.tPv.syx;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.DQ();
      g.DP().dKo.set(47, Integer.valueOf(paramInt1));
      localObject = g.DO().dJT.edx;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label186;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject).bR(bool);
      }
    }
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localObject = locale.spz;
      if (localObject != null) {
        break label218;
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.dmL.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.f.nEG.a(148L, 3L, 1L, false);
      return;
      label186:
      bool = false;
      break;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(locale.spN) });
    }
    label218:
    paramInt1 = ((bzo)localObject).tPu;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localObject, Integer.valueOf(paramInt1), ((bzo)localObject).tPv, ((bzo)localObject).tPw, ((bzo)localObject).tPx });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -301))
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
        com.tencent.mm.plugin.report.f.nEG.a(148L, 4L, 1L, false);
        if ((localObject != null) && (((bzo)localObject).tPx != null)) {
          av.a(true, ((bzo)localObject).tPx.sBE, ((bzo)localObject).tPx.sBF, ((bzo)localObject).tPx.sBD);
        }
        for (;;)
        {
          this.edu -= 1;
          if (this.edu > 0) {
            break;
          }
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
          this.dmL.onSceneEnd(3, -1, "", this);
          return;
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.edu) });
        a(this.edc, this.dmL);
        return;
      }
      if ((!this.ezL) && (paramInt2 == 4) && (paramInt3 == -102))
      {
        com.tencent.mm.plugin.report.f.nEG.a(148L, 5L, 1L, false);
        paramInt1 = paramq.Kv().spM.ver;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
        g.DS().O(new Runnable()
        {
          public final void run()
          {
            new i().a(q.this.edc, new q.1.1(this));
          }
          
          public final String toString()
          {
            return super.toString() + "|onGYNetEnd1";
          }
        });
        return;
      }
      if ((paramInt2 == 4) && (paramInt3 == -217))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.f.nEG.a(148L, 47L, 1L, false);
        return;
      }
      if ((paramInt2 == 4) && (paramInt3 == -218))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.f.nEG.a(148L, 53L, 1L, false);
        return;
      }
      if ((paramInt2 == 4) && (paramInt3 == -240))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.edu) });
        this.edu -= 1;
        if (this.edu <= 0)
        {
          this.dmL.onSceneEnd(3, -1, "", this);
          return;
        }
        com.tencent.mm.plugin.report.f.nEG.a(148L, 57L, 1L, false);
        a(this.edc, this.dmL);
        return;
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.f.nEG.a(148L, 6L, 1L, false);
      return;
    }
    if ((paramInt1 & 0x2) != 0)
    {
      ar localar = ((bzo)localObject).tPw;
      if ((localar == null) || (bk.bl(localar.hPY)))
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.dmL.onSceneEnd(4, -1, "", this);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.dmL.onSceneEnd(4, -1, "", this);
      return;
    }
    if (av.a(paramq) == 2)
    {
      com.tencent.mm.plugin.report.f.nEG.a(148L, 7L, 1L, false);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.ezJ) });
      this.ezJ += 1;
      if (this.ezJ > 1)
      {
        this.dmL.onSceneEnd(4, -1, "", this);
        return;
      }
      ((i.d)this.edi.Kv()).spw.trk.syE.sAf = 1;
      a(this.edc, this.dmL);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneManualAuth", "summerauth decode succeed!");
    g.DS().sQ();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    com.tencent.mm.model.z.a(locale.spz, false);
    ((PluginAuth)g.t(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, locale, false);
    if (!bk.bl(this.account))
    {
      g.DP().Dz().c(ac.a.uze, this.account);
      at.dVC.Y("login_user_name", this.account);
    }
    if (this.ezH) {
      g.DP().Dz().o(2, paramArrayOfByte.spw.trj.hPY);
    }
    g.DO().dJT.a(new bi(new q.2(this, locale)), 0);
    if (bk.g((Integer)g.DP().Dz().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)g.r(com.tencent.mm.plugin.zero.b.b.class)).Pm().iT(10);
    }
    paramInt1 = ((bzo)localObject).tPv.syw;
    if ((paramInt1 & 0x8) == 0)
    {
      paramq = com.tencent.mm.model.q.Gj();
      if (!TextUtils.isEmpty(paramq))
      {
        paramq = new m(paramq);
        g.DO().dJT.a(paramq, 0);
      }
      paramInt1 = 4;
      if ((paramArrayOfByte.spw.trk.syE.sAc == null) || (paramArrayOfByte.spw.trk.syE.sAc.tFK <= 0)) {
        break label1399;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.b.d.r(1, paramInt1, paramArrayOfByte.spw.trj.hPY);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        paramq = new jn();
        paramq.bRJ.bFQ = true;
        com.tencent.mm.sdk.b.a.udP.m(paramq);
      }
      g.DS().cre();
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.f.nEG.a(148L, 9L, 1L, false);
      break;
      label1399:
      if (paramArrayOfByte.spw.trk.tri == 1) {
        paramInt1 = 2;
      }
    }
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getSecCodeType()
  {
    if (((i.e)this.edR.HF()).spz.tPv == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      return 0;
    }
    if (this.errType != 4)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
      return 0;
    }
    if (this.errCode == -311) {
      return 2;
    }
    if (this.errCode == -6) {
      return 1;
    }
    if (this.errCode == -310) {
      return 3;
    }
    return 0;
  }
  
  public final int getType()
  {
    return 701;
  }
  
  public final void nd(String paramString)
  {
    i.d locald = (i.d)this.edR.Kv();
    locald.spw.trj.sBC = paramString;
    locald.spw.trj.sBO = paramString;
    locald.spw.trk.syE.sAc = new bmk().bs(new byte[0]);
    this.ezE = paramString;
    this.ezF = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q
 * JD-Core Version:    0.7.0.1
 */