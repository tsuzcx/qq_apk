package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.v;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.ehi;
import com.tencent.mm.protocal.protobuf.ehj;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class t
  extends n
  implements k
{
  public String account;
  com.tencent.mm.ak.f callback;
  private int errCode;
  private int errType;
  public final com.tencent.mm.network.q hRG;
  private int hRl;
  private String ioM;
  private String ioN;
  private boolean ioO;
  private boolean ioP;
  private int ioQ;
  private int ioR;
  public String ioS;
  private boolean ioT;
  
  public t(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public t(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134165);
    this.ioM = "";
    this.ioN = "";
    this.account = "";
    this.ioO = false;
    this.ioP = false;
    this.errType = 0;
    this.errCode = 0;
    this.hRl = 3;
    this.ioQ = 0;
    this.ioR = 0;
    this.ioT = false;
    ae.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + bu.fpN());
    if ((paramBoolean1) && (bu.isNullOrNil(paramString2))) {
      ae.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    Object localObject1;
    label327:
    Object localObject2;
    if (com.tencent.mm.protocal.f.FFQ)
    {
      i = 252;
      this.hRG = new bd(i);
      localObject1 = (j.f)this.hRG.getReqObj();
      i = bd.aCl().getInt("key_auth_update_version", 0);
      ae.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.FFH) });
      if (i != 0) {
        break label881;
      }
      ((j.f)localObject1).setSceneStatus(1);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 0L, 1L, false);
      ((j.f)localObject1).FGo = true;
      ((j.f)localObject1).setUin(0);
      byo localbyo = new byo();
      localObject2 = new bym();
      ((j.f)localObject1).FGn.Hlo = localbyo;
      ((j.f)localObject1).FGn.Hlp = ((bym)localObject2);
      ((bym)localObject2).Hln = paramInt2;
      localObject1 = new ix();
      ((bym)localObject2).FSd = ((ix)localObject1);
      ((ix)localObject1).FRD = paramString6;
      ((ix)localObject1).FUr = 0;
      ((ix)localObject1).FRy = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((ix)localObject1).FRx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramString6 = new ecj();
      ((ix)localObject1).FUp = paramString6;
      paramString6.FWL = "";
      paramString6.FWK = "";
      paramString6.IhI = "";
      localObject2 = new ehi();
      ((ix)localObject1).FUq = ((ehi)localObject2);
      ((ehi)localObject2).GXa = "";
      ((ehi)localObject2).GWZ = "";
      if (paramInt1 != 1) {
        break label920;
      }
      paramString6.FWL = paramString3;
      paramString6.FWK = paramString4;
      paramString6.IhI = paramString5;
      ((ehi)localObject2).GXa = "";
      ((ehi)localObject2).GWZ = "";
      label550:
      if ((!bu.isNullOrNil(paramString1)) || (!g.ajM())) {
        break label971;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 2L, 1L, false);
      this.ioM = ((String)g.ajR().ajA().get(3, null));
      this.ioN = ((String)g.ajR().ajA().get(19, null));
      paramString1 = (j.g)this.hRG.getRespObj();
      paramString2 = bu.nullAsNil((String)g.ajR().ajA().get(2, null));
      if (!bu.isNullOrNil(paramString2)) {
        break label963;
      }
      paramString2 = new com.tencent.mm.b.p(bu.a((Integer)g.ajR().ajA().get(9, null), 0)).toString();
      label682:
      localbyo.nIJ = paramString2;
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
          paramString1 = g.ajP().aiR().e(bu.getLong(paramString2, 0L), paramString3);
        }
      }
      label729:
      if (paramString1 != null) {
        break label1056;
      }
      paramInt1 = -1;
      label735:
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), bu.aSM(bu.cE(paramString1)) });
      paramString3 = new SKBuiltinBuffer_t();
      paramString2 = paramString1;
      if (bu.cF(paramString1)) {
        paramString2 = new byte[0];
      }
      ((ix)localObject1).FUo = paramString3.setBuffer(paramString2);
      localbyo.FWw = this.ioN;
      localbyo.FWJ = this.ioM;
      paramString1 = com.tencent.mm.plugin.report.e.ywz;
      if (!com.tencent.mm.protocal.f.FFQ) {
        break label1062;
      }
      l = 104L;
      label830:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.e.ywz;
      if (!com.tencent.mm.protocal.f.FFR) {
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
      if (i < com.tencent.mm.protocal.d.FFH)
      {
        ((j.f)localObject1).setSceneStatus(16);
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      ((j.f)localObject1).setSceneStatus(1);
      break label327;
      if (paramInt1 != 3) {
        break label550;
      }
      paramString6.FWL = "";
      paramString6.FWK = "";
      paramString6.IhI = "";
      ((ehi)localObject2).GXa = paramString3;
      ((ehi)localObject2).GWZ = paramString4;
      break label550;
      label963:
      paramString1.dvq = paramString2;
      break label682;
      label971:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.ioM = paramString2;
        this.ioN = paramString2;
        paramString2 = paramString1;
        break label682;
      }
      this.ioM = bu.aSv(bu.nullAsNil(paramString2));
      this.ioN = bu.aSw(bu.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label682;
      label1023:
      paramString1 = paramString4;
      if (!bu.aSo(paramString2)) {
        break label729;
      }
      paramString1 = g.ajP().aiR().a(bu.getLong(paramString2, 0L), this.ioN, true);
      break label729;
      paramInt1 = paramString1.length;
      break label735;
      l = 105L;
      break label830;
    }
  }
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, 0, "", "", "", paramInt, paramString3, false, false);
  }
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString2, paramString3, 0, "", "", "", 0, paramString4, true, false);
    this.ioS = paramString1;
  }
  
  public final void GO(String paramString)
  {
    AppMethodBeat.i(134166);
    j.f localf = (j.f)this.hRG.getReqObj();
    localf.FGn.Hlo.FWw = paramString;
    localf.FGn.Hlo.FWJ = paramString;
    localf.FGn.Hlp.FSd.FUo = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.ioM = paramString;
    this.ioN = paramString;
    AppMethodBeat.o(134166);
  }
  
  public final String aHO()
  {
    AppMethodBeat.i(134174);
    String str = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRD;
    AppMethodBeat.o(134174);
    return str;
  }
  
  public final t aLg()
  {
    this.ioT = true;
    return this;
  }
  
  public final String aLh()
  {
    AppMethodBeat.i(134169);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134169);
      return "";
    }
    String str = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRB;
    AppMethodBeat.o(134169);
    return str;
  }
  
  public final String aLi()
  {
    AppMethodBeat.i(134170);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134170);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.hRG.getRespObj()).FGl.HYs.FRw != null)
      {
        str = bu.nullAsNil(((j.g)this.hRG.getRespObj()).FGl.HYs.FRw.GWZ);
        AppMethodBeat.o(134170);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.hRG.getRespObj()).FGl.HYs.FRv != null))
    {
      str = bu.nullAsNil(((j.g)this.hRG.getRespObj()).FGl.HYs.FRv.FWK);
      AppMethodBeat.o(134170);
      return str;
    }
    AppMethodBeat.o(134170);
    return "";
  }
  
  public final byte[] aLj()
  {
    AppMethodBeat.i(134171);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134171);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.hRG.getRespObj()).FGl.HYs.FRw != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.hRG.getRespObj()).FGl.HYs.FRw.GXc, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.hRG.getRespObj()).FGl.HYs.FRv != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.hRG.getRespObj()).FGl.HYs.FRv.FNK, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.hRG.getReqObj()).FGn.Hlo != null))
    {
      g.ajP().aiR().a(bu.getLong(((j.f)this.hRG.getReqObj()).FGn.Hlo.nIJ, 0L), com.tencent.mm.platformtools.z.a(((j.g)this.hRG.getRespObj()).FGl.HYs.FRu));
      arrayOfByte = g.ajP().aiR().sc(bu.getLong(((j.f)this.hRG.getReqObj()).FGn.Hlo.nIJ, 0L));
      AppMethodBeat.o(134171);
      return arrayOfByte;
    }
    AppMethodBeat.o(134171);
    return new byte[0];
  }
  
  public final String aLk()
  {
    AppMethodBeat.i(134173);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134173);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.hRG.getRespObj()).FGl.HYs.FRv != null))
    {
      if (((j.g)this.hRG.getRespObj()).FGl.HYs.FRv.IhI != null)
      {
        String str = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRv.IhI;
        AppMethodBeat.o(134173);
        return str;
      }
      AppMethodBeat.o(134173);
      return null;
    }
    AppMethodBeat.o(134173);
    return "";
  }
  
  public final boolean aLl()
  {
    AppMethodBeat.i(134175);
    if ((((j.g)this.hRG.getRespObj()).FGl.HYs.FRG & 0x10) != 0)
    {
      AppMethodBeat.o(134175);
      return true;
    }
    AppMethodBeat.o(134175);
    return false;
  }
  
  public final String aLm()
  {
    AppMethodBeat.i(134176);
    String str = ((j.g)this.hRG.getRespObj()).FGl.HYt.FKF;
    AppMethodBeat.o(134176);
    return str;
  }
  
  public final int aLn()
  {
    AppMethodBeat.i(134177);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134177);
      return 0;
    }
    Object localObject = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 11);
    }
    for (int i = bu.getInt(localdle.HSL, 0);; i = 0)
    {
      AppMethodBeat.o(134177);
      return i;
    }
  }
  
  public final BindWordingContent aLo()
  {
    AppMethodBeat.i(134178);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134178);
      return null;
    }
    Object localObject1 = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRC;
    dle localdle;
    if ((localObject1 != null) && (((dfb)localObject1).HMl != null) && (((dfb)localObject1).HMl.size() > 0))
    {
      localObject1 = ((dfb)localObject1).HMl.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject1).next();
      } while (localdle.yxe != 12);
    }
    Object localObject3;
    for (localObject1 = localdle.HSL;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.GM((String)localObject1);
          AppMethodBeat.o(134178);
          return localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String aLp()
  {
    AppMethodBeat.i(134179);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134179);
      return "";
    }
    Object localObject = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRC;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dle localdle = (dle)((Iterator)localObject).next();
        if (localdle.yxe == 16)
        {
          localObject = localdle.HSL;
          AppMethodBeat.o(134179);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(134179);
    return "";
  }
  
  public final int aLq()
  {
    AppMethodBeat.i(134180);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134180);
      return 0;
    }
    Object localObject = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRC;
    dle localdle;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localdle = (dle)((Iterator)localObject).next();
      } while (localdle.yxe != 13);
    }
    for (int i = bu.getInt(localdle.HSL, 0);; i = 0)
    {
      AppMethodBeat.o(134180);
      return i;
    }
  }
  
  public final boolean aLr()
  {
    AppMethodBeat.i(134181);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(134181);
      return true;
    }
    Object localObject = ((j.g)this.hRG.getRespObj()).FGl.HYs.FRC;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      localObject = ((dfb)localObject).HMl.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dle localdle = (dle)((Iterator)localObject).next();
        if (localdle.yxe == 18) {
          if (bu.getInt(localdle.HSL, 0) == 1)
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(134167);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(134167);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(134172);
    if (((j.g)this.hRG.getRespObj()).FGl.HYs == null)
    {
      ae.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      AppMethodBeat.o(134172);
      return 0;
    }
    if (this.errType != 4)
    {
      ae.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
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
    if (com.tencent.mm.protocal.f.FFQ) {
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
    if ((localg.FGl != null) && (localg.FGl.HYs != null))
    {
      paramInt1 = localg.FGl.HYs.FRH;
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.ajS();
      g.ajR().gDO.set(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = g.ajQ().gDv.hRo;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.eK(bool);
      }
    }
    drp localdrp;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localdrp = localg.FGl;
      if (localdrp != null) {
        break label230;
      }
      ae.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(134168);
      return;
      label198:
      bool = false;
      break;
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localdrp.HYr;
    String str = this.account;
    gx localgx = localdrp.HYs;
    aw localaw = localdrp.HYt;
    ccx localccx = localdrp.HYu;
    Object localObject;
    if (localdrp.HYs == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localdrp.HYs != null) {
        break label512;
      }
      localObject = Integer.valueOf(-1);
      label291:
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localdrp, Integer.valueOf(paramInt1), localgx, localaw, localccx, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1062;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label578;
      }
      ae.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 4L, 1L, false);
      if ((localdrp == null) || (localdrp.HYu == null)) {
        break label525;
      }
      bd.a(true, localdrp.HYu.FWy, localdrp.HYu.FWz, localdrp.HYu.FWx);
    }
    for (;;)
    {
      this.hRl -= 1;
      if (this.hRl > 0) {
        break label536;
      }
      ae.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(134168);
      return;
      paramArrayOfByte = localdrp.HYs.FRJ;
      break;
      label512:
      localObject = localdrp.HYs.FRK;
      break label291;
      label525:
      ae.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label536:
    ae.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.hRl) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(134168);
    return;
    label578:
    if ((!this.ioT) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134161);
          new m().doScene(t.this.dispatcher(), new com.tencent.mm.ak.f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134160);
              ae.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                t.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", t.this);
                AppMethodBeat.o(134160);
                return;
              }
              t.this.doScene(t.this.dispatcher(), t.this.callback);
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
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.FFV) });
      paramString = com.tencent.mm.plugin.report.e.ywz;
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
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hRl) });
      this.hRl -= 1;
      if (this.hRl <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    ae.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 6L, 1L, false);
    if ((com.tencent.mm.protocal.f.FFQ) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(134168);
    return;
    label1062:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localdrp.HYt;
      if ((paramArrayOfByte == null) || (bu.isNullOrNil(paramArrayOfByte.nIJ)))
      {
        ae.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
      }
    }
    else
    {
      ae.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(134168);
      return;
    }
    if (bd.a(paramq) == 2)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 7L, 1L, false);
      ae.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.ioR) });
      this.ioR += 1;
      if (this.ioR > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      ((j.f)getReqResp().getReqObj()).FGn.Hlp.FSd.FUr = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    g.ajU().Mh();
    ae.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    af.a(localg.FGl, false);
    ((PluginAuth)g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(localf, localg, false);
    if (!bu.isNullOrNil(this.account))
    {
      g.ajR().ajA().set(am.a.IXT, this.account);
      bb.hIK.aM("login_user_name", this.account);
    }
    g.ajQ().gDv.a(new bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(134163);
        if ((paramAnonymouse == null) || (paramAnonymouse.aFs() == null) || (localg.aak(1) == null) || (localg.aak(2) == null) || (localg.aak(3) == null) || (localg.FGl == null) || (localg.FGl.HYs == null))
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 8L, 1L, false);
          ae.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          AppMethodBeat.o(134163);
          return;
        }
        ae.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { bu.aSM(bu.cE(localg.aak(1))), bu.aSM(bu.cE(localg.aak(2))), bu.aSM(bu.cE(localg.aak(3))), Integer.valueOf(localg.FGl.HYs.qkC) });
        paramAnonymouse.aFs().a(localg.aak(1), localg.aak(2), localg.aak(3), localg.FGl.HYs.qkC);
        AppMethodBeat.o(134163);
      }
    }), 0);
    if (bu.o((Integer)g.ajR().ajA().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)g.ab(com.tencent.mm.plugin.zero.b.b.class)).aJQ().pP(10);
    }
    paramInt1 = localdrp.HYs.FRG;
    if ((paramInt1 & 0x8) == 0)
    {
      paramq = v.aAC();
      if (!TextUtils.isEmpty(paramq))
      {
        paramq = new p(paramq);
        g.ajQ().gDv.a(paramq, 0);
      }
      paramInt1 = 4;
      if ((localf.FGn.Hlp.FSd.FUo == null) || (localf.FGn.Hlp.FSd.FUo.getILen() <= 0)) {
        break label1673;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.b.d.F(1, paramInt1, localf.FGn.Hlo.nIJ);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ae.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        paramq = new ls();
        paramq.dzV.result = true;
        com.tencent.mm.sdk.b.a.IvT.l(paramq);
      }
      g.ajU().foO();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134168);
      return;
      ae.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 9L, 1L, false);
      break;
      label1673:
      if (localf.FGn.Hlp.Hln == 1) {
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
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public static final class a
  {
    public String dqk;
    public String dyI;
    public String ioX;
    public Bundle ioY;
    public int type;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(134164);
      String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bu.aSM(this.dqk), this.ioX, this.dyI, this.ioY });
      AppMethodBeat.o(134164);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.t
 * JD-Core Version:    0.7.0.1
 */