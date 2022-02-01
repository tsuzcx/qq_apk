package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.li;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class s
  extends n
  implements k
{
  public String account;
  com.tencent.mm.ak.g callback;
  private int errCode;
  private int errType;
  private String hSB;
  private String hSC;
  private boolean hSD;
  private boolean hSE;
  private int hSF;
  private int hSG;
  public String hSH;
  private boolean hSI;
  private int hwd;
  public final com.tencent.mm.network.q hwy;
  
  public s(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public s(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134165);
    this.hSB = "";
    this.hSC = "";
    this.account = "";
    this.hSD = false;
    this.hSE = false;
    this.errType = 0;
    this.errCode = 0;
    this.hwd = 3;
    this.hSF = 0;
    this.hSG = 0;
    this.hSI = false;
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + bs.eWi());
    if ((paramBoolean1) && (bs.isNullOrNil(paramString2))) {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    Object localObject1;
    label327:
    Object localObject2;
    if (f.DIl)
    {
      i = 252;
      this.hwy = new ba(i);
      localObject1 = (j.f)this.hwy.getReqObj();
      i = ba.ayR().getInt("key_auth_update_version", 0);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.DIc) });
      if (i != 0) {
        break label881;
      }
      ((j.f)localObject1).setSceneStatus(1);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 0L, 1L, false);
      ((j.f)localObject1).DIJ = true;
      ((j.f)localObject1).setUin(0);
      btg localbtg = new btg();
      localObject2 = new bte();
      ((j.f)localObject1).DII.Fim = localbtg;
      ((j.f)localObject1).DII.Fin = ((bte)localObject2);
      ((bte)localObject2).Fil = paramInt2;
      localObject1 = new iq();
      ((bte)localObject2).DUl = ((iq)localObject1);
      ((iq)localObject1).DTL = paramString6;
      ((iq)localObject1).DWA = 0;
      ((iq)localObject1).DTG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((iq)localObject1).DTF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramString6 = new duy();
      ((iq)localObject1).DWy = paramString6;
      paramString6.DYU = "";
      paramString6.DYT = "";
      paramString6.GcE = "";
      localObject2 = new dzn();
      ((iq)localObject1).DWz = ((dzn)localObject2);
      ((dzn)localObject2).EUa = "";
      ((dzn)localObject2).ETZ = "";
      if (paramInt1 != 1) {
        break label920;
      }
      paramString6.DYU = paramString3;
      paramString6.DYT = paramString4;
      paramString6.GcE = paramString5;
      ((dzn)localObject2).EUa = "";
      ((dzn)localObject2).ETZ = "";
      label550:
      if ((!bs.isNullOrNil(paramString1)) || (!com.tencent.mm.kernel.g.agM())) {
        break label971;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 2L, 1L, false);
      this.hSB = ((String)com.tencent.mm.kernel.g.agR().agA().get(3, null));
      this.hSC = ((String)com.tencent.mm.kernel.g.agR().agA().get(19, null));
      paramString1 = (j.g)this.hwy.getRespObj();
      paramString2 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(2, null));
      if (!bs.isNullOrNil(paramString2)) {
        break label963;
      }
      paramString2 = new com.tencent.mm.b.p(bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(9, null), 0)).toString();
      label682:
      localbtg.ncR = paramString2;
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
          paramString1 = com.tencent.mm.kernel.g.agP().afQ().e(bs.getLong(paramString2, 0L), paramString3);
        }
      }
      label729:
      if (paramString1 != null) {
        break label1056;
      }
      paramInt1 = -1;
      label735:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), bs.aLJ(bs.cu(paramString1)) });
      paramString3 = new SKBuiltinBuffer_t();
      paramString2 = paramString1;
      if (bs.cv(paramString1)) {
        paramString2 = new byte[0];
      }
      ((iq)localObject1).DWx = paramString3.setBuffer(paramString2);
      localbtg.DYF = this.hSC;
      localbtg.DYS = this.hSB;
      paramString1 = com.tencent.mm.plugin.report.e.wTc;
      if (!f.DIl) {
        break label1062;
      }
      l = 104L;
      label830:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.e.wTc;
      if (!f.DIm) {
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
      if (i < com.tencent.mm.protocal.d.DIc)
      {
        ((j.f)localObject1).setSceneStatus(16);
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      ((j.f)localObject1).setSceneStatus(1);
      break label327;
      if (paramInt1 != 3) {
        break label550;
      }
      paramString6.DYU = "";
      paramString6.DYT = "";
      paramString6.GcE = "";
      ((dzn)localObject2).EUa = paramString3;
      ((dzn)localObject2).ETZ = paramString4;
      break label550;
      label963:
      paramString1.diA = paramString2;
      break label682;
      label971:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.hSB = paramString2;
        this.hSC = paramString2;
        paramString2 = paramString1;
        break label682;
      }
      this.hSB = bs.aLs(bs.nullAsNil(paramString2));
      this.hSC = bs.aLt(bs.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label682;
      label1023:
      paramString1 = paramString4;
      if (!bs.aLl(paramString2)) {
        break label729;
      }
      paramString1 = com.tencent.mm.kernel.g.agP().afQ().a(bs.getLong(paramString2, 0L), this.hSC, true);
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
    this.hSH = paramString1;
  }
  
  public final void Dh(String paramString)
  {
    AppMethodBeat.i(134166);
    j.f localf = (j.f)this.hwy.getReqObj();
    localf.DII.Fim.DYF = paramString;
    localf.DII.Fim.DYS = paramString;
    localf.DII.Fin.DUl.DWx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.hSB = paramString;
    this.hSC = paramString;
    AppMethodBeat.o(134166);
  }
  
  public final String aEs()
  {
    AppMethodBeat.i(134174);
    String str = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTL;
    AppMethodBeat.o(134174);
    return str;
  }
  
  public final String aHA()
  {
    AppMethodBeat.i(134170);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134170);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.hwy.getRespObj()).DIG.FTR.DTE != null)
      {
        str = bs.nullAsNil(((j.g)this.hwy.getRespObj()).DIG.FTR.DTE.ETZ);
        AppMethodBeat.o(134170);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.hwy.getRespObj()).DIG.FTR.DTD != null))
    {
      str = bs.nullAsNil(((j.g)this.hwy.getRespObj()).DIG.FTR.DTD.DYT);
      AppMethodBeat.o(134170);
      return str;
    }
    AppMethodBeat.o(134170);
    return "";
  }
  
  public final byte[] aHB()
  {
    AppMethodBeat.i(134171);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134171);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.hwy.getRespObj()).DIG.FTR.DTE != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.hwy.getRespObj()).DIG.FTR.DTE.EUc, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.hwy.getRespObj()).DIG.FTR.DTD != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.hwy.getRespObj()).DIG.FTR.DTD.DPX, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.hwy.getReqObj()).DII.Fim != null))
    {
      com.tencent.mm.kernel.g.agP().afQ().a(bs.getLong(((j.f)this.hwy.getReqObj()).DII.Fim.ncR, 0L), com.tencent.mm.platformtools.z.a(((j.g)this.hwy.getRespObj()).DIG.FTR.DTC));
      arrayOfByte = com.tencent.mm.kernel.g.agP().afQ().pQ(bs.getLong(((j.f)this.hwy.getReqObj()).DII.Fim.ncR, 0L));
      AppMethodBeat.o(134171);
      return arrayOfByte;
    }
    AppMethodBeat.o(134171);
    return new byte[0];
  }
  
  public final String aHC()
  {
    AppMethodBeat.i(134173);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134173);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.hwy.getRespObj()).DIG.FTR.DTD != null))
    {
      if (((j.g)this.hwy.getRespObj()).DIG.FTR.DTD.GcE != null)
      {
        String str = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTD.GcE;
        AppMethodBeat.o(134173);
        return str;
      }
      AppMethodBeat.o(134173);
      return null;
    }
    AppMethodBeat.o(134173);
    return "";
  }
  
  public final boolean aHD()
  {
    AppMethodBeat.i(134175);
    if ((((j.g)this.hwy.getRespObj()).DIG.FTR.DTO & 0x10) != 0)
    {
      AppMethodBeat.o(134175);
      return true;
    }
    AppMethodBeat.o(134175);
    return false;
  }
  
  public final String aHE()
  {
    AppMethodBeat.i(134176);
    String str = ((j.g)this.hwy.getRespObj()).DIG.FTS.DNc;
    AppMethodBeat.o(134176);
    return str;
  }
  
  public final int aHF()
  {
    AppMethodBeat.i(134177);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134177);
      return 0;
    }
    Object localObject = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTK;
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
      } while (localdew.wTD != 11);
    }
    for (int i = bs.getInt(localdew.FOp, 0);; i = 0)
    {
      AppMethodBeat.o(134177);
      return i;
    }
  }
  
  public final BindWordingContent aHG()
  {
    AppMethodBeat.i(134178);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134178);
      return null;
    }
    Object localObject1 = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTK;
    dew localdew;
    if ((localObject1 != null) && (((cyu)localObject1).FIa != null) && (((cyu)localObject1).FIa.size() > 0))
    {
      localObject1 = ((cyu)localObject1).FIa.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localdew = (dew)((Iterator)localObject1).next();
      } while (localdew.wTD != 12);
    }
    Object localObject3;
    for (localObject1 = localdew.FOp;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.Df((String)localObject1);
          AppMethodBeat.o(134178);
          return localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String aHH()
  {
    AppMethodBeat.i(134179);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134179);
      return "";
    }
    Object localObject = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTK;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dew localdew = (dew)((Iterator)localObject).next();
        if (localdew.wTD == 16)
        {
          localObject = localdew.FOp;
          AppMethodBeat.o(134179);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(134179);
    return "";
  }
  
  public final int aHI()
  {
    AppMethodBeat.i(134180);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134180);
      return 0;
    }
    Object localObject = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTK;
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
      } while (localdew.wTD != 13);
    }
    for (int i = bs.getInt(localdew.FOp, 0);; i = 0)
    {
      AppMethodBeat.o(134180);
      return i;
    }
  }
  
  public final boolean aHJ()
  {
    AppMethodBeat.i(134181);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134181);
      return true;
    }
    Object localObject = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTK;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      localObject = ((cyu)localObject).FIa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dew localdew = (dew)((Iterator)localObject).next();
        if (localdew.wTD == 18) {
          if (bs.getInt(localdew.FOp, 0) == 1)
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
  
  public final s aHy()
  {
    this.hSI = true;
    return this;
  }
  
  public final String aHz()
  {
    AppMethodBeat.i(134169);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(134169);
      return "";
    }
    String str = ((j.g)this.hwy.getRespObj()).DIG.FTR.DTJ;
    AppMethodBeat.o(134169);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(134167);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(134167);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(134172);
    if (((j.g)this.hwy.getRespObj()).DIG.FTR == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      AppMethodBeat.o(134172);
      return 0;
    }
    if (this.errType != 4)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
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
    if (f.DIl) {
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
    if ((localg.DIG != null) && (localg.DIG.FTR != null))
    {
      paramInt1 = localg.DIG.FTR.DTP;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().ghx.set(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = com.tencent.mm.kernel.g.agQ().ghe.hwg;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.eG(bool);
      }
    }
    dlb localdlb;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localdlb = localg.DIG;
      if (localdlb != null) {
        break label230;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(134168);
      return;
      label198:
      bool = false;
      break;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localdlb.FTQ;
    String str = this.account;
    gq localgq = localdlb.FTR;
    aw localaw = localdlb.FTS;
    bxm localbxm = localdlb.FTT;
    Object localObject;
    if (localdlb.FTR == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localdlb.FTR != null) {
        break label512;
      }
      localObject = Integer.valueOf(-1);
      label291:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localdlb, Integer.valueOf(paramInt1), localgq, localaw, localbxm, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1062;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label578;
      }
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 4L, 1L, false);
      if ((localdlb == null) || (localdlb.FTT == null)) {
        break label525;
      }
      ba.a(true, localdlb.FTT.DYH, localdlb.FTT.DYI, localdlb.FTT.DYG);
    }
    for (;;)
    {
      this.hwd -= 1;
      if (this.hwd > 0) {
        break label536;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(134168);
      return;
      paramArrayOfByte = localdlb.FTR.DTR;
      break;
      label512:
      localObject = localdlb.FTR.DTS;
      break label291;
      label525:
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label536:
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.hwd) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(134168);
    return;
    label578:
    if ((!this.hSI) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134161);
          new l().doScene(s.this.dispatcher(), new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(134160);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.DIq) });
      paramString = com.tencent.mm.plugin.report.e.wTc;
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
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hwd) });
      this.hwd -= 1;
      if (this.hwd <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 6L, 1L, false);
    if ((f.DIl) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(134168);
    return;
    label1062:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localdlb.FTS;
      if ((paramArrayOfByte == null) || (bs.isNullOrNil(paramArrayOfByte.ncR)))
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(134168);
      return;
    }
    if (ba.a(paramq) == 2)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 7L, 1L, false);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.hSG) });
      this.hSG += 1;
      if (this.hSG > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      ((j.f)getReqResp().getReqObj()).DII.Fin.DUl.DWA = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    com.tencent.mm.kernel.g.agU().Kw();
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    com.tencent.mm.model.ad.a(localg.DIG, false);
    ((PluginAuth)com.tencent.mm.kernel.g.ad(PluginAuth.class)).getHandleAuthResponseCallbacks().a(localf, localg, false);
    if (!bs.isNullOrNil(this.account))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQW, this.account);
      ay.hnA.aL("login_user_name", this.account);
    }
    com.tencent.mm.kernel.g.agQ().ghe.a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(134163);
        if ((paramAnonymouse == null) || (paramAnonymouse.aBZ() == null) || (localg.XI(1) == null) || (localg.XI(2) == null) || (localg.XI(3) == null) || (localg.DIG == null) || (localg.DIG.FTR == null))
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 8L, 1L, false);
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          AppMethodBeat.o(134163);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { bs.aLJ(bs.cu(localg.XI(1))), bs.aLJ(bs.cu(localg.XI(2))), bs.aLJ(bs.cu(localg.XI(3))), Integer.valueOf(localg.DIG.FTR.pAs) });
        paramAnonymouse.aBZ().a(localg.XI(1), localg.XI(2), localg.XI(3), localg.DIG.FTR.pAs);
        AppMethodBeat.o(134163);
      }
    }), 0);
    if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.b.class)).aGm().pj(10);
    }
    paramInt1 = localdlb.FTR.DTO;
    if ((paramInt1 & 0x8) == 0)
    {
      paramq = u.axw();
      if (!TextUtils.isEmpty(paramq))
      {
        paramq = new o(paramq);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramq, 0);
      }
      paramInt1 = 4;
      if ((localf.DII.Fin.DUl.DWx == null) || (localf.DII.Fin.DUl.DWx.getILen() <= 0)) {
        break label1673;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.c.d.E(1, paramInt1, localf.DII.Fim.ncR);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        paramq = new li();
        paramq.dnc.result = true;
        com.tencent.mm.sdk.b.a.GpY.l(paramq);
      }
      com.tencent.mm.kernel.g.agU().eVm();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134168);
      return;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 9L, 1L, false);
      break;
      label1673:
      if (localf.DII.Fin.Fil == 1) {
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
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public static final class a
  {
    public String ddJ;
    public String dlQ;
    public String hSM;
    public Bundle hSN;
    public int type;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(134164);
      String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bs.aLJ(this.ddJ), this.hSM, this.dlQ, this.hSN });
      AppMethodBeat.o(134164);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */