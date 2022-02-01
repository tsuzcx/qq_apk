package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.og;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.dmg;
import com.tencent.mm.protocal.protobuf.dmh;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.fck;
import com.tencent.mm.protocal.protobuf.fjq;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.gdp;
import com.tencent.mm.protocal.protobuf.gdq;
import com.tencent.mm.protocal.protobuf.gjp;
import com.tencent.mm.protocal.protobuf.gjq;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class u
  extends com.tencent.mm.am.p
  implements m
{
  public String account;
  private com.tencent.mm.am.h callback;
  private int errCode;
  private int errType;
  private String oSG;
  private String oSH;
  private boolean oSI;
  private boolean oSJ;
  private int oSK;
  private int oSL;
  public String oSM;
  private boolean oSN;
  public final com.tencent.mm.network.s ouH;
  private int ouk;
  
  public u(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public u(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134165);
    this.oSG = "";
    this.oSH = "";
    this.account = "";
    this.oSI = false;
    this.oSJ = false;
    this.errType = 0;
    this.errCode = 0;
    this.ouk = 3;
    this.oSK = 0;
    this.oSL = 0;
    this.oSN = false;
    Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + Util.getStack());
    if ((paramBoolean1) && (Util.isNullOrNil(paramString2))) {
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    j.f localf;
    label327:
    Object localObject2;
    if (com.tencent.mm.protocal.f.Yxs)
    {
      i = 252;
      this.ouH = new bj(i);
      localf = (j.f)this.ouH.getReqObj();
      i = bj.bCE().getInt("key_auth_update_version", 0);
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.Yxh) });
      if (i != 0) {
        break label1012;
      }
      localf.setSceneStatus(1);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 0L, 1L, false);
      localf.YxS = true;
      localf.setUin(0);
      dmi localdmi = new dmi();
      localObject2 = new dmg();
      localf.YxR.aaSr = localdmi;
      localf.YxR.aaSs = ((dmg)localObject2);
      ((dmg)localObject2).YKd = new eil();
      Object localObject1 = com.tencent.mm.network.b.bQD().bQE();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1051;
      }
      ((dmg)localObject2).YKd.Zsz = com.tencent.mm.network.b.bQD().pny.Zsz;
      ((dmg)localObject2).YKd.YKf = new gol().df(((String)localObject1).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.NetSceneManualAuth", "manual auth add public key , length " + ((String)localObject1).length());
      label468:
      ((dmg)localObject2).aaSq = paramInt2;
      localObject1 = new jv();
      ((dmg)localObject2).YJU = ((jv)localObject1);
      ((jv)localObject1).YJu = paramString6;
      ((jv)localObject1).YMi = 0;
      ((jv)localObject1).YJp = new gol().df(new byte[0]);
      ((jv)localObject1).YJo = new gol().df(new byte[0]);
      paramString6 = new gdp();
      ((jv)localObject1).YMg = paramString6;
      paramString6.YON = "";
      paramString6.YOM = "";
      paramString6.acbw = "";
      localObject2 = new gjp();
      ((jv)localObject1).YMh = ((gjp)localObject2);
      ((gjp)localObject2).aayW = "";
      ((gjp)localObject2).aayV = "";
      if (paramInt1 != 1) {
        break label1092;
      }
      paramString6.YON = paramString3;
      paramString6.YOM = paramString4;
      paramString6.acbw = paramString5;
      ((gjp)localObject2).aayW = "";
      ((gjp)localObject2).aayV = "";
      label647:
      if ((!Util.isNullOrNil(paramString1)) || (!com.tencent.mm.kernel.h.baz())) {
        break label1143;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 2L, 1L, false);
      this.oSG = ((String)com.tencent.mm.kernel.h.baE().ban().d(3, null));
      this.oSH = ((String)com.tencent.mm.kernel.h.baE().ban().d(19, null));
      paramString1 = (j.g)this.ouH.getRespObj();
      paramString2 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(2, null));
      if (!Util.isNullOrNil(paramString2)) {
        break label1135;
      }
      paramString2 = new com.tencent.mm.b.p(Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null), 0)).toString();
      label779:
      localdmi.UserName = paramString2;
      paramString4 = null;
      paramString1 = paramString4;
      if (paramInt1 != 1)
      {
        paramString1 = paramString4;
        if (paramInt1 != 3)
        {
          if (paramInt1 != 2) {
            break label1195;
          }
          paramString1 = com.tencent.mm.kernel.h.baC().aZE().g(Util.getLong(paramString2, 0L), paramString3);
        }
      }
      label826:
      if (paramString1 != null) {
        break label1228;
      }
      paramInt1 = -1;
      label832:
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), Util.secPrint(Util.dumpHex(paramString1)) });
      paramString3 = new gol();
      paramString2 = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        paramString2 = new byte[0];
      }
      ((jv)localObject1).YMf = paramString3.df(paramString2);
      localdmi.YOy = this.oSH;
      localdmi.YOL = this.oSG;
      paramString1 = new b.a();
      paramString1.pnA = com.tencent.mm.network.b.bQD().bQE();
      paramString1.pnz = com.tencent.mm.network.b.bQD().pnz;
      localf.setCGiVerifyKey(paramString1);
      paramString1 = com.tencent.mm.plugin.report.f.Ozc;
      if (!com.tencent.mm.protocal.f.Yxs) {
        break label1234;
      }
      l = 104L;
      label961:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.f.Ozc;
      if (!com.tencent.mm.protocal.f.Yxt) {
        break label1242;
      }
    }
    label1051:
    label1092:
    label1228:
    label1234:
    label1242:
    for (long l = 106L;; l = 107L)
    {
      paramString1.idkeyStat(148L, l, 1L, false);
      AppMethodBeat.o(134165);
      return;
      i = 701;
      break;
      label1012:
      if (i < d.Yxh)
      {
        localf.setSceneStatus(16);
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      localf.setSceneStatus(1);
      break label327;
      ((dmg)localObject2).YKd.Zsz = 0;
      ((dmg)localObject2).YKd.YKf = new gol().df(new byte[0]);
      Log.e("MicroMsg.NetSceneManualAuth", "get sign key failed");
      break label468;
      if (paramInt1 != 3) {
        break label647;
      }
      paramString6.YON = "";
      paramString6.YOM = "";
      paramString6.acbw = "";
      ((gjp)localObject2).aayW = paramString3;
      ((gjp)localObject2).aayV = paramString4;
      break label647;
      label1135:
      paramString1.hLv = paramString2;
      break label779;
      label1143:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.oSG = paramString2;
        this.oSH = paramString2;
        paramString2 = paramString1;
        break label779;
      }
      this.oSG = Util.getCutPasswordMD5(Util.nullAsNil(paramString2));
      this.oSH = Util.getFullPasswordMD5(Util.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label779;
      paramString1 = paramString4;
      if (!Util.isValidQQNum(paramString2)) {
        break label826;
      }
      paramString1 = com.tencent.mm.kernel.h.baC().aZE().a(Util.getLong(paramString2, 0L), this.oSH, true);
      break label826;
      paramInt1 = paramString1.length;
      break label832;
      l = 105L;
      break label961;
    }
  }
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, 0, "", "", "", paramInt, paramString3, false, false);
  }
  
  public u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString2, paramString3, 0, "", "", "", 0, paramString4, true, false);
    this.oSM = paramString1;
  }
  
  public final void OY(String paramString)
  {
    AppMethodBeat.i(134166);
    j.f localf = (j.f)this.ouH.getReqObj();
    localf.YxR.aaSr.YOy = paramString;
    localf.YxR.aaSr.YOL = paramString;
    localf.YxR.aaSs.YJU.YMf = new gol().df(new byte[0]);
    this.oSG = paramString;
    this.oSH = paramString;
    AppMethodBeat.o(134166);
  }
  
  public final String aJs()
  {
    AppMethodBeat.i(236773);
    Object localObject = ((j.g)this.ouH.getRespObj()).YxP;
    if (localObject != null)
    {
      localObject = ((frg)localObject).abQR.pSk;
      AppMethodBeat.o(236773);
      return localObject;
    }
    AppMethodBeat.o(236773);
    return null;
  }
  
  public final String bIR()
  {
    AppMethodBeat.i(134174);
    String str = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJu;
    AppMethodBeat.o(134174);
    return str;
  }
  
  public final u bMg()
  {
    this.oSN = true;
    return this;
  }
  
  public final String bMh()
  {
    AppMethodBeat.i(134169);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134169);
      return "";
    }
    String str = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJs;
    AppMethodBeat.o(134169);
    return str;
  }
  
  public final String bMi()
  {
    AppMethodBeat.i(134170);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134170);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.ouH.getRespObj()).YxP.abQQ.YJn != null)
      {
        str = Util.nullAsNil(((j.g)this.ouH.getRespObj()).YxP.abQQ.YJn.aayV);
        AppMethodBeat.o(134170);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.ouH.getRespObj()).YxP.abQQ.YJm != null))
    {
      str = Util.nullAsNil(((j.g)this.ouH.getRespObj()).YxP.abQQ.YJm.YOM);
      AppMethodBeat.o(134170);
      return str;
    }
    AppMethodBeat.o(134170);
    return "";
  }
  
  public final byte[] bMj()
  {
    AppMethodBeat.i(134171);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134171);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.ouH.getRespObj()).YxP.abQQ.YJn != null)
      {
        arrayOfByte = w.a(((j.g)this.ouH.getRespObj()).YxP.abQQ.YJn.aayX, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.ouH.getRespObj()).YxP.abQQ.YJm != null)
      {
        arrayOfByte = w.a(((j.g)this.ouH.getRespObj()).YxP.abQQ.YJm.YFI, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.ouH.getReqObj()).YxR.aaSr != null))
    {
      com.tencent.mm.kernel.h.baC().aZE().b(Util.getLong(((j.f)this.ouH.getReqObj()).YxR.aaSr.UserName, 0L), w.a(((j.g)this.ouH.getRespObj()).YxP.abQQ.YJl));
      arrayOfByte = com.tencent.mm.kernel.h.baC().aZE().iA(Util.getLong(((j.f)this.ouH.getReqObj()).YxR.aaSr.UserName, 0L));
      AppMethodBeat.o(134171);
      return arrayOfByte;
    }
    AppMethodBeat.o(134171);
    return new byte[0];
  }
  
  public final String bMk()
  {
    AppMethodBeat.i(134173);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134173);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.ouH.getRespObj()).YxP.abQQ.YJm != null))
    {
      if (((j.g)this.ouH.getRespObj()).YxP.abQQ.YJm.acbw != null)
      {
        String str = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJm.acbw;
        AppMethodBeat.o(134173);
        return str;
      }
      AppMethodBeat.o(134173);
      return null;
    }
    AppMethodBeat.o(134173);
    return "";
  }
  
  public final boolean bMl()
  {
    AppMethodBeat.i(134175);
    if ((((j.g)this.ouH.getRespObj()).YxP.abQQ.YJx & 0x10) != 0)
    {
      AppMethodBeat.o(134175);
      return true;
    }
    AppMethodBeat.o(134175);
    return false;
  }
  
  public final String bMm()
  {
    AppMethodBeat.i(134176);
    String str = ((j.g)this.ouH.getRespObj()).YxP.abQR.YBW;
    AppMethodBeat.o(134176);
    return str;
  }
  
  public final int bMn()
  {
    AppMethodBeat.i(134177);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134177);
      return 0;
    }
    Object localObject = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJt;
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
      } while (localfjq.OzG != 11);
    }
    for (int i = Util.getInt(localfjq.abKm, 0);; i = 0)
    {
      AppMethodBeat.o(134177);
      return i;
    }
  }
  
  public final BindWordingContent bMo()
  {
    AppMethodBeat.i(134178);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134178);
      return null;
    }
    Object localObject1 = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJt;
    fjq localfjq;
    if ((localObject1 != null) && (((fck)localObject1).abBZ != null) && (((fck)localObject1).abBZ.size() > 0))
    {
      localObject1 = ((fck)localObject1).abBZ.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localfjq = (fjq)((Iterator)localObject1).next();
      } while (localfjq.OzG != 12);
    }
    Object localObject3;
    for (localObject1 = localfjq.abKm;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.OV((String)localObject1);
          AppMethodBeat.o(134178);
          return localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String bMp()
  {
    AppMethodBeat.i(134179);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134179);
      return "";
    }
    Object localObject = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJt;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        fjq localfjq = (fjq)((Iterator)localObject).next();
        if (localfjq.OzG == 16)
        {
          localObject = localfjq.abKm;
          AppMethodBeat.o(134179);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(134179);
    return "";
  }
  
  public final int bMq()
  {
    AppMethodBeat.i(134180);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134180);
      return 0;
    }
    Object localObject = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJt;
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
      } while (localfjq.OzG != 13);
    }
    for (int i = Util.getInt(localfjq.abKm, 0);; i = 0)
    {
      AppMethodBeat.o(134180);
      return i;
    }
  }
  
  public final boolean bMr()
  {
    AppMethodBeat.i(134181);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(134181);
      return true;
    }
    Object localObject = ((j.g)this.ouH.getRespObj()).YxP.abQQ.YJt;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      localObject = ((fck)localObject).abBZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        fjq localfjq = (fjq)((Iterator)localObject).next();
        if (localfjq.OzG == 18) {
          if (Util.getInt(localfjq.abKm, 0) == 1)
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(134167);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(134167);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(134172);
    if (((j.g)this.ouH.getRespObj()).YxP.abQQ == null)
    {
      Log.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      AppMethodBeat.o(134172);
      return 0;
    }
    if (this.errType != 4)
    {
      Log.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
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
    if (com.tencent.mm.protocal.f.Yxs) {
      return 252;
    }
    return 701;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134168);
    j.f localf = (j.f)params.getReqObj();
    final j.g localg = (j.g)params.getRespObj();
    boolean bool;
    if ((localg.YxP != null) && (localg.YxP.abQQ != null))
    {
      paramInt1 = localg.YxP.abQQ.YJy;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().mCE.B(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = com.tencent.mm.kernel.h.baD().mCm.oun;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.hd(bool);
      }
    }
    frg localfrg;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localfrg = localg.YxP;
      if (localfrg != null) {
        break label230;
      }
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(134168);
      return;
      label198:
      bool = false;
      break;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localfrg.abQP;
    String str = this.account;
    hw localhw = localfrg.abQQ;
    ba localba = localfrg.abQR;
    dtt localdtt = localfrg.abQS;
    Object localObject;
    if (localfrg.abQQ == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localfrg.abQQ != null) {
        break label579;
      }
      localObject = Integer.valueOf(-1);
      label291:
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localfrg, Integer.valueOf(paramInt1), localhw, localba, localdtt, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1129;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label645;
      }
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 4L, 1L, false);
      if ((localfrg == null) || (localfrg.abQS == null)) {
        break label592;
      }
      bj.a(true, localfrg.abQS.YOA, localfrg.abQS.YOB, localfrg.abQS.YOz, true, localfrg.abQS.aaZs);
    }
    for (;;)
    {
      this.ouk -= 1;
      if (this.ouk > 0) {
        break label603;
      }
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getResources().getString(a.a.auth_idc_mismatch) + "(" + paramInt2 + ", " + paramInt3 + ")", 0).show();
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(134168);
      return;
      paramArrayOfByte = localfrg.abQQ.YJA;
      break;
      label579:
      localObject = localfrg.abQQ.YJB;
      break label291;
      label592:
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label603:
    Log.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.ouk) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(134168);
    return;
    label645:
    if ((!this.oSN) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134161);
          new o().doScene(u.a(u.this), new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.am.p paramAnonymous2p)
            {
              AppMethodBeat.i(134160);
              Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2p.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                u.b(u.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", u.this);
                AppMethodBeat.o(134160);
                return;
              }
              u.this.doScene(u.c(u.this), u.b(u.this));
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
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.iPL()) });
      paramString = com.tencent.mm.plugin.report.f.Ozc;
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
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ouk) });
      this.ouk -= 1;
      if (this.ouk <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    Log.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 6L, 1L, false);
    if ((com.tencent.mm.protocal.f.Yxs) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(134168);
    return;
    label1129:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localfrg.abQR;
      if ((paramArrayOfByte == null) || (Util.isNullOrNil(paramArrayOfByte.UserName)))
      {
        Log.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
      }
    }
    else
    {
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(134168);
      return;
    }
    if (bj.a(params) == 2)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 7L, 1L, false);
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.oSL) });
      this.oSL += 1;
      if (this.oSL > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      ((j.f)getReqResp().getReqObj()).YxR.aaSs.YJU.YMi = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    com.tencent.mm.kernel.h.baH().setHighPriority();
    Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    aj.a(localg.YxP, false);
    ((PluginAuth)com.tencent.mm.kernel.h.az(PluginAuth.class)).getHandleAuthResponseCallbacks().onAuthResponse(localf, localg, false);
    if (!Util.isNullOrNil(this.account))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWp, this.account);
      bg.okT.bc("login_user_name", this.account);
    }
    com.tencent.mm.kernel.h.baD().mCm.a(new bw(new bw.a()
    {
      public final void b(g paramAnonymousg)
      {
        AppMethodBeat.i(134163);
        if ((paramAnonymousg == null) || (paramAnonymousg.bGg() == null) || (localg.axu(1) == null) || (localg.axu(2) == null) || (localg.axu(3) == null) || (localg.YxP == null) || (localg.YxP.abQQ == null))
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 8L, 1L, false);
          Log.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          AppMethodBeat.o(134163);
          return;
        }
        Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { Util.secPrint(Util.dumpHex(localg.axu(1))), Util.secPrint(Util.dumpHex(localg.axu(2))), Util.secPrint(Util.dumpHex(localg.axu(3))), Integer.valueOf(localg.YxP.abQQ.yth) });
        paramAnonymousg.bGg().a(localg.axu(1), localg.axu(2), localg.axu(3), localg.YxP.abQQ.yth);
        AppMethodBeat.o(134163);
      }
    }), 0);
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.b.class)).bKY().wG(10);
    }
    paramInt1 = localfrg.abQQ.YJx;
    if ((paramInt1 & 0x8) == 0)
    {
      params = z.bAM();
      if (!TextUtils.isEmpty(params))
      {
        params = new q(params);
        com.tencent.mm.kernel.h.baD().mCm.a(params, 0);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Log.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        params = new og();
        params.hQM.result = true;
        params.publish();
      }
      com.tencent.mm.kernel.h.baH().setLowPriority();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134168);
      return;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 9L, 1L, false);
    }
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
  
  public static final class a
  {
    public String hFb;
    public String oSR;
    public Bundle oSS;
    public int type;
    public String username;
    public String wording;
    
    public final String toString()
    {
      AppMethodBeat.i(134164);
      String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, Util.secPrint(this.hFb), this.oSR, this.wording, this.oSS });
      AppMethodBeat.o(134164);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.u
 * JD-Core Version:    0.7.0.1
 */