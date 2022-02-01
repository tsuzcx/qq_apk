package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class s
  extends n
  implements k
{
  public String account;
  com.tencent.mm.al.g callback;
  private int errCode;
  private int errType;
  private int gVE;
  public final com.tencent.mm.network.q gVZ;
  private String hrZ;
  private String hsa;
  private boolean hsb;
  private boolean hsc;
  private int hsd;
  private int hse;
  public String hsf;
  private boolean hsg;
  
  public s(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public s(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134165);
    this.hrZ = "";
    this.hsa = "";
    this.account = "";
    this.hsb = false;
    this.hsc = false;
    this.errType = 0;
    this.errCode = 0;
    this.gVE = 3;
    this.hsd = 0;
    this.hse = 0;
    this.hsg = false;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + bt.eGN());
    if ((paramBoolean1) && (bt.isNullOrNil(paramString2))) {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    Object localObject1;
    label327:
    Object localObject2;
    if (f.CpT)
    {
      i = 252;
      this.gVZ = new ba(i);
      localObject1 = (j.f)this.gVZ.getReqObj();
      i = ba.asa().getInt("key_auth_update_version", 0);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.CpK) });
      if (i != 0) {
        break label881;
      }
      ((j.f)localObject1).setSceneStatus(1);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 0L, 1L, false);
      ((j.f)localObject1).Cqr = true;
      ((j.f)localObject1).setUin(0);
      boq localboq = new boq();
      localObject2 = new boo();
      ((j.f)localObject1).Cqq.DLX = localboq;
      ((j.f)localObject1).Cqq.DLY = ((boo)localObject2);
      ((boo)localObject2).DLW = paramInt2;
      localObject1 = new ik();
      ((boo)localObject2).CBN = ((ik)localObject1);
      ((ik)localObject1).CBn = paramString6;
      ((ik)localObject1).CEa = 0;
      ((ik)localObject1).CBi = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((ik)localObject1).CBh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramString6 = new dph();
      ((ik)localObject1).CDY = paramString6;
      paramString6.CGu = "";
      paramString6.CGt = "";
      paramString6.EFs = "";
      localObject2 = new dtw();
      ((ik)localObject1).CDZ = ((dtw)localObject2);
      ((dtw)localObject2).DyE = "";
      ((dtw)localObject2).DyD = "";
      if (paramInt1 != 1) {
        break label920;
      }
      paramString6.CGu = paramString3;
      paramString6.CGt = paramString4;
      paramString6.EFs = paramString5;
      ((dtw)localObject2).DyE = "";
      ((dtw)localObject2).DyD = "";
      label550:
      if ((!bt.isNullOrNil(paramString1)) || (!com.tencent.mm.kernel.g.afw())) {
        break label971;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 2L, 1L, false);
      this.hrZ = ((String)com.tencent.mm.kernel.g.afB().afk().get(3, null));
      this.hsa = ((String)com.tencent.mm.kernel.g.afB().afk().get(19, null));
      paramString1 = (j.g)this.gVZ.getRespObj();
      paramString2 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(2, null));
      if (!bt.isNullOrNil(paramString2)) {
        break label963;
      }
      paramString2 = new com.tencent.mm.b.p(bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(9, null), 0)).toString();
      label682:
      localboq.mAQ = paramString2;
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
          paramString1 = com.tencent.mm.kernel.g.afz().aeA().e(bt.getLong(paramString2, 0L), paramString3);
        }
      }
      label729:
      if (paramString1 != null) {
        break label1056;
      }
      paramInt1 = -1;
      label735:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), bt.aGs(bt.cv(paramString1)) });
      paramString3 = new SKBuiltinBuffer_t();
      paramString2 = paramString1;
      if (bt.cw(paramString1)) {
        paramString2 = new byte[0];
      }
      ((ik)localObject1).CDX = paramString3.setBuffer(paramString2);
      localboq.CGf = this.hsa;
      localboq.CGs = this.hrZ;
      paramString1 = com.tencent.mm.plugin.report.e.vIY;
      if (!f.CpT) {
        break label1062;
      }
      l = 104L;
      label830:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.e.vIY;
      if (!f.CpU) {
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
      if (i < com.tencent.mm.protocal.d.CpK)
      {
        ((j.f)localObject1).setSceneStatus(16);
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      ((j.f)localObject1).setSceneStatus(1);
      break label327;
      if (paramInt1 != 3) {
        break label550;
      }
      paramString6.CGu = "";
      paramString6.CGt = "";
      paramString6.EFs = "";
      ((dtw)localObject2).DyE = paramString3;
      ((dtw)localObject2).DyD = paramString4;
      break label550;
      label963:
      paramString1.hKD = paramString2;
      break label682;
      label971:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.hrZ = paramString2;
        this.hsa = paramString2;
        paramString2 = paramString1;
        break label682;
      }
      this.hrZ = bt.aGb(bt.nullAsNil(paramString2));
      this.hsa = bt.aGc(bt.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label682;
      label1023:
      paramString1 = paramString4;
      if (!bt.aFU(paramString2)) {
        break label729;
      }
      paramString1 = com.tencent.mm.kernel.g.afz().aeA().a(bt.getLong(paramString2, 0L), this.hsa, true);
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
    this.hsf = paramString1;
  }
  
  public final s aAI()
  {
    this.hsg = true;
    return this;
  }
  
  public final String aAJ()
  {
    AppMethodBeat.i(134169);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134169);
      return "";
    }
    String str = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBl;
    AppMethodBeat.o(134169);
    return str;
  }
  
  public final String aAK()
  {
    AppMethodBeat.i(134170);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134170);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBg != null)
      {
        str = bt.nullAsNil(((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBg.DyD);
        AppMethodBeat.o(134170);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBf != null))
    {
      str = bt.nullAsNil(((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBf.CGt);
      AppMethodBeat.o(134170);
      return str;
    }
    AppMethodBeat.o(134170);
    return "";
  }
  
  public final byte[] aAL()
  {
    AppMethodBeat.i(134171);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134171);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBg != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBg.DyG, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBf != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBf.CxB, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.gVZ.getReqObj()).Cqq.DLX != null))
    {
      com.tencent.mm.kernel.g.afz().aeA().a(bt.getLong(((j.f)this.gVZ.getReqObj()).Cqq.DLX.mAQ, 0L), com.tencent.mm.platformtools.z.a(((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBe));
      arrayOfByte = com.tencent.mm.kernel.g.afz().aeA().mc(bt.getLong(((j.f)this.gVZ.getReqObj()).Cqq.DLX.mAQ, 0L));
      AppMethodBeat.o(134171);
      return arrayOfByte;
    }
    AppMethodBeat.o(134171);
    return new byte[0];
  }
  
  public final String aAM()
  {
    AppMethodBeat.i(134173);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134173);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBf != null))
    {
      if (((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBf.EFs != null)
      {
        String str = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBf.EFs;
        AppMethodBeat.o(134173);
        return str;
      }
      AppMethodBeat.o(134173);
      return null;
    }
    AppMethodBeat.o(134173);
    return "";
  }
  
  public final boolean aAN()
  {
    AppMethodBeat.i(134175);
    if ((((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBq & 0x10) != 0)
    {
      AppMethodBeat.o(134175);
      return true;
    }
    AppMethodBeat.o(134175);
    return false;
  }
  
  public final String aAO()
  {
    AppMethodBeat.i(134176);
    String str = ((j.g)this.gVZ.getRespObj()).Cqo.EwQ.CuH;
    AppMethodBeat.o(134176);
    return str;
  }
  
  public final int aAP()
  {
    AppMethodBeat.i(134177);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134177);
      return 0;
    }
    Object localObject = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBm;
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
      } while (localczk.vJz != 11);
    }
    for (int i = bt.getInt(localczk.Ern, 0);; i = 0)
    {
      AppMethodBeat.o(134177);
      return i;
    }
  }
  
  public final BindWordingContent aAQ()
  {
    AppMethodBeat.i(134178);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134178);
      return null;
    }
    Object localObject1 = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBm;
    czk localczk;
    if ((localObject1 != null) && (((ctj)localObject1).Elc != null) && (((ctj)localObject1).Elc.size() > 0))
    {
      localObject1 = ((ctj)localObject1).Elc.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localczk = (czk)((Iterator)localObject1).next();
      } while (localczk.vJz != 12);
    }
    Object localObject3;
    for (localObject1 = localczk.Ern;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.za((String)localObject1);
          AppMethodBeat.o(134178);
          return localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String aAR()
  {
    AppMethodBeat.i(134179);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134179);
      return "";
    }
    Object localObject = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBm;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        czk localczk = (czk)((Iterator)localObject).next();
        if (localczk.vJz == 16)
        {
          localObject = localczk.Ern;
          AppMethodBeat.o(134179);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(134179);
    return "";
  }
  
  public final int aAS()
  {
    AppMethodBeat.i(134180);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134180);
      return 0;
    }
    Object localObject = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBm;
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
      } while (localczk.vJz != 13);
    }
    for (int i = bt.getInt(localczk.Ern, 0);; i = 0)
    {
      AppMethodBeat.o(134180);
      return i;
    }
  }
  
  public final boolean aAT()
  {
    AppMethodBeat.i(134181);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(134181);
      return true;
    }
    Object localObject = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBm;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      localObject = ((ctj)localObject).Elc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        czk localczk = (czk)((Iterator)localObject).next();
        if (localczk.vJz == 18) {
          if (bt.getInt(localczk.Ern, 0) == 1)
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
  
  public final String axA()
  {
    AppMethodBeat.i(134174);
    String str = ((j.g)this.gVZ.getRespObj()).Cqo.EwP.CBn;
    AppMethodBeat.o(134174);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(134167);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(134167);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(134172);
    if (((j.g)this.gVZ.getRespObj()).Cqo.EwP == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      AppMethodBeat.o(134172);
      return 0;
    }
    if (this.errType != 4)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
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
    if (f.CpT) {
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
    if ((localg.Cqo != null) && (localg.Cqo.EwP != null))
    {
      paramInt1 = localg.Cqo.EwP.CBr;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().gcR.set(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = com.tencent.mm.kernel.g.afA().gcy.gVH;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.el(bool);
      }
    }
    dfm localdfm;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localdfm = localg.Cqo;
      if (localdfm != null) {
        break label230;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(134168);
      return;
      label198:
      bool = false;
      break;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localdfm.EwO;
    String str = this.account;
    gm localgm = localdfm.EwP;
    au localau = localdfm.EwQ;
    bsv localbsv = localdfm.EwR;
    Object localObject;
    if (localdfm.EwP == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localdfm.EwP != null) {
        break label512;
      }
      localObject = Integer.valueOf(-1);
      label291:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localdfm, Integer.valueOf(paramInt1), localgm, localau, localbsv, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1062;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label578;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 4L, 1L, false);
      if ((localdfm == null) || (localdfm.EwR == null)) {
        break label525;
      }
      ba.a(true, localdfm.EwR.CGh, localdfm.EwR.CGi, localdfm.EwR.CGg);
    }
    for (;;)
    {
      this.gVE -= 1;
      if (this.gVE > 0) {
        break label536;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(134168);
      return;
      paramArrayOfByte = localdfm.EwP.CBt;
      break;
      label512:
      localObject = localdfm.EwP.CBu;
      break label291;
      label525:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label536:
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.gVE) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(134168);
    return;
    label578:
    if ((!this.hsg) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134161);
          new l().doScene(s.this.dispatcher(), new com.tencent.mm.al.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134160);
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.CpY) });
      paramString = com.tencent.mm.plugin.report.e.vIY;
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.gVE) });
      this.gVE -= 1;
      if (this.gVE <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 6L, 1L, false);
    if ((f.CpT) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(134168);
    return;
    label1062:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localdfm.EwQ;
      if ((paramArrayOfByte == null) || (bt.isNullOrNil(paramArrayOfByte.mAQ)))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(134168);
      return;
    }
    if (ba.a(paramq) == 2)
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 7L, 1L, false);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.hse) });
      this.hse += 1;
      if (this.hse > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      ((j.f)getReqResp().getReqObj()).Cqq.DLY.CBN.CEa = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    com.tencent.mm.kernel.g.afE().KL();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    com.tencent.mm.model.ad.a(localg.Cqo, false);
    ((PluginAuth)com.tencent.mm.kernel.g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(localf, localg, false);
    if (!bt.isNullOrNil(this.account))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftd, this.account);
      ay.gNa.aD("login_user_name", this.account);
    }
    com.tencent.mm.kernel.g.afA().gcy.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(134163);
        if ((paramAnonymouse == null) || (paramAnonymouse.avg() == null) || (localg.Vz(1) == null) || (localg.Vz(2) == null) || (localg.Vz(3) == null) || (localg.Cqo == null) || (localg.Cqo.EwP == null))
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 8L, 1L, false);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          AppMethodBeat.o(134163);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { bt.aGs(bt.cv(localg.Vz(1))), bt.aGs(bt.cv(localg.Vz(2))), bt.aGs(bt.cv(localg.Vz(3))), Integer.valueOf(localg.Cqo.EwP.oXh) });
        paramAnonymouse.avg().a(localg.Vz(1), localg.Vz(2), localg.Vz(3), localg.Cqo.EwP.oXh);
        AppMethodBeat.o(134163);
      }
    }), 0);
    if (bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.b.class)).azv().ov(10);
    }
    paramInt1 = localdfm.EwP.CBq;
    if ((paramInt1 & 0x8) == 0)
    {
      paramq = u.aqG();
      if (!TextUtils.isEmpty(paramq))
      {
        paramq = new o(paramq);
        com.tencent.mm.kernel.g.afA().gcy.a(paramq, 0);
      }
      paramInt1 = 4;
      if ((localf.Cqq.DLY.CBN.CDX == null) || (localf.Cqq.DLY.CBN.CDX.getILen() <= 0)) {
        break label1673;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.b.d.F(1, paramInt1, localf.Cqq.DLX.mAQ);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        paramq = new kz();
        paramq.dpr.result = true;
        com.tencent.mm.sdk.b.a.ESL.l(paramq);
      }
      com.tencent.mm.kernel.g.afE().eFR();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134168);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 9L, 1L, false);
      break;
      label1673:
      if (localf.Cqq.DLY.DLW == 1) {
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
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public final void zc(String paramString)
  {
    AppMethodBeat.i(134166);
    j.f localf = (j.f)this.gVZ.getReqObj();
    localf.Cqq.DLX.CGf = paramString;
    localf.Cqq.DLX.CGs = paramString;
    localf.Cqq.DLY.CBN.CDX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.hrZ = paramString;
    this.hsa = paramString;
    AppMethodBeat.o(134166);
  }
  
  public static final class a
  {
    public String dgo;
    public String doh;
    public String hsk;
    public Bundle hsl;
    public int type;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(134164);
      String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bt.aGs(this.dgo), this.hsk, this.doh, this.hsl });
      AppMethodBeat.o(134164);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */