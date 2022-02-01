package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.efr;
import com.tencent.mm.protocal.protobuf.efs;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class s
  extends n
  implements k
{
  public String account;
  com.tencent.mm.al.f callback;
  private int errCode;
  private int errType;
  public final com.tencent.mm.network.q hON;
  private int hOs;
  private String ilS;
  private String ilT;
  private boolean ilU;
  private boolean ilV;
  private int ilW;
  private int ilX;
  public String ilY;
  private boolean ilZ;
  
  public s(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public s(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134165);
    this.ilS = "";
    this.ilT = "";
    this.account = "";
    this.ilU = false;
    this.ilV = false;
    this.errType = 0;
    this.errCode = 0;
    this.hOs = 3;
    this.ilW = 0;
    this.ilX = 0;
    this.ilZ = false;
    ad.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + bt.flS());
    if ((paramBoolean1) && (bt.isNullOrNil(paramString2))) {
      ad.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    Object localObject1;
    label327:
    Object localObject2;
    if (com.tencent.mm.protocal.f.Fns)
    {
      i = 252;
      this.hON = new bb(i);
      localObject1 = (j.f)this.hON.getReqObj();
      i = bb.aBV().getInt("key_auth_update_version", 0);
      ad.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.Fnj) });
      if (i != 0) {
        break label881;
      }
      ((j.f)localObject1).setSceneStatus(1);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 0L, 1L, false);
      ((j.f)localObject1).FnQ = true;
      ((j.f)localObject1).setUin(0);
      bxu localbxu = new bxu();
      localObject2 = new bxs();
      ((j.f)localObject1).FnP.GRN = localbxu;
      ((j.f)localObject1).FnP.GRO = ((bxs)localObject2);
      ((bxs)localObject2).GRM = paramInt2;
      localObject1 = new ix();
      ((bxs)localObject2).FzF = ((ix)localObject1);
      ((ix)localObject1).Fzf = paramString6;
      ((ix)localObject1).FBW = 0;
      ((ix)localObject1).Fza = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((ix)localObject1).FyZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramString6 = new eas();
      ((ix)localObject1).FBU = paramString6;
      paramString6.FEq = "";
      paramString6.FEp = "";
      paramString6.HNB = "";
      localObject2 = new efr();
      ((ix)localObject1).FBV = ((efr)localObject2);
      ((efr)localObject2).GDx = "";
      ((efr)localObject2).GDw = "";
      if (paramInt1 != 1) {
        break label920;
      }
      paramString6.FEq = paramString3;
      paramString6.FEp = paramString4;
      paramString6.HNB = paramString5;
      ((efr)localObject2).GDx = "";
      ((efr)localObject2).GDw = "";
      label550:
      if ((!bt.isNullOrNil(paramString1)) || (!g.ajx())) {
        break label971;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 2L, 1L, false);
      this.ilS = ((String)g.ajC().ajl().get(3, null));
      this.ilT = ((String)g.ajC().ajl().get(19, null));
      paramString1 = (j.g)this.hON.getRespObj();
      paramString2 = bt.nullAsNil((String)g.ajC().ajl().get(2, null));
      if (!bt.isNullOrNil(paramString2)) {
        break label963;
      }
      paramString2 = new p(bt.a((Integer)g.ajC().ajl().get(9, null), 0)).toString();
      label682:
      localbxu.nDo = paramString2;
      paramString4 = null;
      paramString1 = paramString4;
      if (paramInt1 != 1)
      {
        paramString1 = paramString4;
        if (paramInt1 != 3)
        {
          if (paramInt1 != 2) {
            break label1023;
          }
          paramString1 = g.ajA().aiC().e(bt.getLong(paramString2, 0L), paramString3);
        }
      }
      label729:
      if (paramString1 != null) {
        break label1056;
      }
      paramInt1 = -1;
      label735:
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), bt.aRp(bt.cB(paramString1)) });
      paramString3 = new SKBuiltinBuffer_t();
      paramString2 = paramString1;
      if (bt.cC(paramString1)) {
        paramString2 = new byte[0];
      }
      ((ix)localObject1).FBT = paramString3.setBuffer(paramString2);
      localbxu.FEb = this.ilT;
      localbxu.FEo = this.ilS;
      paramString1 = com.tencent.mm.plugin.report.e.ygI;
      if (!com.tencent.mm.protocal.f.Fns) {
        break label1062;
      }
      l = 104L;
      label830:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.e.ygI;
      if (!com.tencent.mm.protocal.f.Fnt) {
        break label1070;
      }
    }
    label920:
    label1056:
    label1062:
    label1070:
    for (long l = 106L;; l = 107L)
    {
      paramString1.idkeyStat(148L, l, 1L, false);
      AppMethodBeat.o(134165);
      return;
      i = 701;
      break;
      label881:
      if (i < com.tencent.mm.protocal.d.Fnj)
      {
        ((j.f)localObject1).setSceneStatus(16);
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      ((j.f)localObject1).setSceneStatus(1);
      break label327;
      if (paramInt1 != 3) {
        break label550;
      }
      paramString6.FEq = "";
      paramString6.FEp = "";
      paramString6.HNB = "";
      ((efr)localObject2).GDx = paramString3;
      ((efr)localObject2).GDw = paramString4;
      break label550;
      label963:
      paramString1.dul = paramString2;
      break label682;
      label971:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.ilS = paramString2;
        this.ilT = paramString2;
        paramString2 = paramString1;
        break label682;
      }
      this.ilS = bt.aQY(bt.nullAsNil(paramString2));
      this.ilT = bt.aQZ(bt.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label682;
      label1023:
      paramString1 = paramString4;
      if (!bt.aQR(paramString2)) {
        break label729;
      }
      paramString1 = g.ajA().aiC().a(bt.getLong(paramString2, 0L), this.ilT, true);
      break label729;
      paramInt1 = paramString1.length;
      break label735;
      l = 105L;
      break label830;
    }
  }
  
  public s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, 0, "", "", "", paramInt, paramString3, false, false);
  }
  
  public s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString2, paramString3, 0, "", "", "", 0, paramString4, true, false);
    this.ilY = paramString1;
  }
  
  public final void Gm(String paramString)
  {
    AppMethodBeat.i(134166);
    j.f localf = (j.f)this.hON.getReqObj();
    localf.FnP.GRN.FEb = paramString;
    localf.FnP.GRN.FEo = paramString;
    localf.FnP.GRO.FzF.FBT = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.ilS = paramString;
    this.ilT = paramString;
    AppMethodBeat.o(134166);
  }
  
  public final String aHx()
  {
    AppMethodBeat.i(134174);
    String str = ((j.g)this.hON.getRespObj()).FnN.HEF.Fzf;
    AppMethodBeat.o(134174);
    return str;
  }
  
  public final s aKJ()
  {
    this.ilZ = true;
    return this;
  }
  
  public final String aKK()
  {
    AppMethodBeat.i(134169);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134169);
      return "";
    }
    String str = ((j.g)this.hON.getRespObj()).FnN.HEF.Fzd;
    AppMethodBeat.o(134169);
    return str;
  }
  
  public final String aKL()
  {
    AppMethodBeat.i(134170);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134170);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.hON.getRespObj()).FnN.HEF.FyY != null)
      {
        str = bt.nullAsNil(((j.g)this.hON.getRespObj()).FnN.HEF.FyY.GDw);
        AppMethodBeat.o(134170);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.hON.getRespObj()).FnN.HEF.FyX != null))
    {
      str = bt.nullAsNil(((j.g)this.hON.getRespObj()).FnN.HEF.FyX.FEp);
      AppMethodBeat.o(134170);
      return str;
    }
    AppMethodBeat.o(134170);
    return "";
  }
  
  public final byte[] aKM()
  {
    AppMethodBeat.i(134171);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134171);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.hON.getRespObj()).FnN.HEF.FyY != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.hON.getRespObj()).FnN.HEF.FyY.GDz, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.hON.getRespObj()).FnN.HEF.FyX != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.hON.getRespObj()).FnN.HEF.FyX.Fvm, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.hON.getReqObj()).FnP.GRN != null))
    {
      g.ajA().aiC().a(bt.getLong(((j.f)this.hON.getReqObj()).FnP.GRN.nDo, 0L), com.tencent.mm.platformtools.z.a(((j.g)this.hON.getRespObj()).FnN.HEF.FyW));
      arrayOfByte = g.ajA().aiC().rP(bt.getLong(((j.f)this.hON.getReqObj()).FnP.GRN.nDo, 0L));
      AppMethodBeat.o(134171);
      return arrayOfByte;
    }
    AppMethodBeat.o(134171);
    return new byte[0];
  }
  
  public final String aKN()
  {
    AppMethodBeat.i(134173);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134173);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.hON.getRespObj()).FnN.HEF.FyX != null))
    {
      if (((j.g)this.hON.getRespObj()).FnN.HEF.FyX.HNB != null)
      {
        String str = ((j.g)this.hON.getRespObj()).FnN.HEF.FyX.HNB;
        AppMethodBeat.o(134173);
        return str;
      }
      AppMethodBeat.o(134173);
      return null;
    }
    AppMethodBeat.o(134173);
    return "";
  }
  
  public final boolean aKO()
  {
    AppMethodBeat.i(134175);
    if ((((j.g)this.hON.getRespObj()).FnN.HEF.Fzi & 0x10) != 0)
    {
      AppMethodBeat.o(134175);
      return true;
    }
    AppMethodBeat.o(134175);
    return false;
  }
  
  public final String aKP()
  {
    AppMethodBeat.i(134176);
    String str = ((j.g)this.hON.getRespObj()).FnN.HEG.Fsh;
    AppMethodBeat.o(134176);
    return str;
  }
  
  public final int aKQ()
  {
    AppMethodBeat.i(134177);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134177);
      return 0;
    }
    Object localObject = ((j.g)this.hON.getRespObj()).FnN.HEF.Fze;
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
      } while (localdkj.yhn != 11);
    }
    for (int i = bt.getInt(localdkj.Hza, 0);; i = 0)
    {
      AppMethodBeat.o(134177);
      return i;
    }
  }
  
  public final BindWordingContent aKR()
  {
    AppMethodBeat.i(134178);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134178);
      return null;
    }
    Object localObject1 = ((j.g)this.hON.getRespObj()).FnN.HEF.Fze;
    dkj localdkj;
    if ((localObject1 != null) && (((deh)localObject1).HsI != null) && (((deh)localObject1).HsI.size() > 0))
    {
      localObject1 = ((deh)localObject1).HsI.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localdkj = (dkj)((Iterator)localObject1).next();
      } while (localdkj.yhn != 12);
    }
    Object localObject3;
    for (localObject1 = localdkj.Hza;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.Gk((String)localObject1);
          AppMethodBeat.o(134178);
          return localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String aKS()
  {
    AppMethodBeat.i(134179);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134179);
      return "";
    }
    Object localObject = ((j.g)this.hON.getRespObj()).FnN.HEF.Fze;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dkj localdkj = (dkj)((Iterator)localObject).next();
        if (localdkj.yhn == 16)
        {
          localObject = localdkj.Hza;
          AppMethodBeat.o(134179);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(134179);
    return "";
  }
  
  public final int aKT()
  {
    AppMethodBeat.i(134180);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134180);
      return 0;
    }
    Object localObject = ((j.g)this.hON.getRespObj()).FnN.HEF.Fze;
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
      } while (localdkj.yhn != 13);
    }
    for (int i = bt.getInt(localdkj.Hza, 0);; i = 0)
    {
      AppMethodBeat.o(134180);
      return i;
    }
  }
  
  public final boolean aKU()
  {
    AppMethodBeat.i(134181);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(134181);
      return true;
    }
    Object localObject = ((j.g)this.hON.getRespObj()).FnN.HEF.Fze;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      localObject = ((deh)localObject).HsI.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dkj localdkj = (dkj)((Iterator)localObject).next();
        if (localdkj.yhn == 18) {
          if (bt.getInt(localdkj.Hza, 0) == 1)
          {
            AppMethodBeat.o(134181);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(134181);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(134167);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(134167);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(134172);
    if (((j.g)this.hON.getRespObj()).FnN.HEF == null)
    {
      ad.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      AppMethodBeat.o(134172);
      return 0;
    }
    if (this.errType != 4)
    {
      ad.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
      AppMethodBeat.o(134172);
      return 0;
    }
    if (this.errCode == -311)
    {
      AppMethodBeat.o(134172);
      return 2;
    }
    if (this.errCode == -6)
    {
      AppMethodBeat.o(134172);
      return 1;
    }
    if (this.errCode == -310)
    {
      AppMethodBeat.o(134172);
      return 3;
    }
    AppMethodBeat.o(134172);
    return 0;
  }
  
  public final int getType()
  {
    if (com.tencent.mm.protocal.f.Fns) {
      return 252;
    }
    return 701;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134168);
    j.f localf = (j.f)paramq.getReqObj();
    final j.g localg = (j.g)paramq.getRespObj();
    boolean bool;
    if ((localg.FnN != null) && (localg.FnN.HEF != null))
    {
      paramInt1 = localg.FnN.HEF.Fzj;
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.ajD();
      g.ajC().gBh.set(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = g.ajB().gAO.hOv;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.eI(bool);
      }
    }
    dqs localdqs;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localdqs = localg.FnN;
      if (localdqs != null) {
        break label230;
      }
      ad.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(134168);
      return;
      label198:
      bool = false;
      break;
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localdqs.HEE;
    String str = this.account;
    gx localgx = localdqs.HEF;
    aw localaw = localdqs.HEG;
    ccd localccd = localdqs.HEH;
    Object localObject;
    if (localdqs.HEF == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localdqs.HEF != null) {
        break label512;
      }
      localObject = Integer.valueOf(-1);
      label291:
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localdqs, Integer.valueOf(paramInt1), localgx, localaw, localccd, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1062;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label578;
      }
      ad.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 4L, 1L, false);
      if ((localdqs == null) || (localdqs.HEH == null)) {
        break label525;
      }
      bb.a(true, localdqs.HEH.FEd, localdqs.HEH.FEe, localdqs.HEH.FEc);
    }
    for (;;)
    {
      this.hOs -= 1;
      if (this.hOs > 0) {
        break label536;
      }
      ad.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(134168);
      return;
      paramArrayOfByte = localdqs.HEF.Fzl;
      break;
      label512:
      localObject = localdqs.HEF.Fzm;
      break label291;
      label525:
      ad.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label536:
    ad.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.hOs) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(134168);
    return;
    label578:
    if ((!this.ilZ) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134161);
          new l().doScene(s.this.dispatcher(), new com.tencent.mm.al.f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134160);
              ad.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                s.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", s.this);
                AppMethodBeat.o(134160);
                return;
              }
              s.this.doScene(s.this.dispatcher(), s.this.callback);
              AppMethodBeat.o(134160);
            }
          });
          AppMethodBeat.o(134161);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(134162);
          String str = super.toString() + "|onGYNetEnd1";
          AppMethodBeat.o(134162);
          return str;
        }
      });
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && ((paramInt3 == -305) || (paramInt3 == -306)))
    {
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.Fnx) });
      paramString = com.tencent.mm.plugin.report.e.ygI;
      if (paramInt3 == -305) {}
      for (long l = 108L;; l = 109L)
      {
        paramString.idkeyStat(148L, l, 1L, true);
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(134168);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -217))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hOs) });
      this.hOs -= 1;
      if (this.hOs <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    ad.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 6L, 1L, false);
    if ((com.tencent.mm.protocal.f.Fns) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(134168);
    return;
    label1062:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localdqs.HEG;
      if ((paramArrayOfByte == null) || (bt.isNullOrNil(paramArrayOfByte.nDo)))
      {
        ad.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
      }
    }
    else
    {
      ad.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(134168);
      return;
    }
    if (bb.a(paramq) == 2)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 7L, 1L, false);
      ad.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.ilX) });
      this.ilX += 1;
      if (this.ilX > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      ((j.f)getReqResp().getReqObj()).FnP.GRO.FzF.FBW = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    g.ajF().LZ();
    ad.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    ae.a(localg.FnN, false);
    ((PluginAuth)g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(localf, localg, false);
    if (!bt.isNullOrNil(this.account))
    {
      g.ajC().ajl().set(al.a.IDt, this.account);
      az.hFS.aM("login_user_name", this.account);
    }
    g.ajB().gAO.a(new bo(new bo.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(134163);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFc() == null) || (localg.ZE(1) == null) || (localg.ZE(2) == null) || (localg.ZE(3) == null) || (localg.FnN == null) || (localg.FnN.HEF == null))
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 8L, 1L, false);
          ad.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          AppMethodBeat.o(134163);
          return;
        }
        ad.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { bt.aRp(bt.cB(localg.ZE(1))), bt.aRp(bt.cB(localg.ZE(2))), bt.aRp(bt.cB(localg.ZE(3))), Integer.valueOf(localg.FnN.HEF.qdX) });
        paramAnonymouse.aFc().a(localg.ZE(1), localg.ZE(2), localg.ZE(3), localg.FnN.HEF.qdX);
        AppMethodBeat.o(134163);
      }
    }), 0);
    if (bt.n((Integer)g.ajC().ajl().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)g.ab(com.tencent.mm.plugin.zero.b.b.class)).aJx().pM(10);
    }
    paramInt1 = localdqs.HEF.Fzi;
    if ((paramInt1 & 0x8) == 0)
    {
      paramq = u.aAm();
      if (!TextUtils.isEmpty(paramq))
      {
        paramq = new o(paramq);
        g.ajB().gAO.a(paramq, 0);
      }
      paramInt1 = 4;
      if ((localf.FnP.GRO.FzF.FBT == null) || (localf.FnP.GRO.FzF.FBT.getILen() <= 0)) {
        break label1673;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.b.d.F(1, paramInt1, localf.FnP.GRN.nDo);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ad.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        paramq = new lr();
        paramq.dyQ.result = true;
        com.tencent.mm.sdk.b.a.IbL.l(paramq);
      }
      g.ajF().fkT();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134168);
      return;
      ad.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 9L, 1L, false);
      break;
      label1673:
      if (localf.FnP.GRO.GRM == 1) {
        paramInt1 = 2;
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */