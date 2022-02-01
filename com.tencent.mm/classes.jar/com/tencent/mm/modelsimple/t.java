package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.protocal.protobuf.fhe;
import com.tencent.mm.protocal.protobuf.fmx;
import com.tencent.mm.protocal.protobuf.fmy;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class t
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  public String account;
  private i callback;
  private int errCode;
  private int errType;
  private int lCA;
  public final s lCW;
  private String lZP;
  private String lZQ;
  private boolean lZR;
  private boolean lZS;
  private int lZT;
  private int lZU;
  public String lZV;
  private boolean lZW;
  
  public t(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public t(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134165);
    this.lZP = "";
    this.lZQ = "";
    this.account = "";
    this.lZR = false;
    this.lZS = false;
    this.errType = 0;
    this.errCode = 0;
    this.lCA = 3;
    this.lZT = 0;
    this.lZU = 0;
    this.lZW = false;
    Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + Util.getStack());
    if ((paramBoolean1) && (Util.isNullOrNil(paramString2))) {
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    j.f localf;
    label327:
    Object localObject2;
    if (com.tencent.mm.protocal.f.RAO)
    {
      i = 252;
      this.lCW = new bi(i);
      localf = (j.f)this.lCW.getReqObj();
      i = bi.beN().getInt("key_auth_update_version", 0);
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.RAD) });
      if (i != 0) {
        break label1012;
      }
      localf.setSceneStatus(1);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 0L, 1L, false);
      localf.RBp = true;
      localf.setUin(0);
      cvc localcvc = new cvc();
      localObject2 = new cva();
      localf.RBo.TCK = localcvc;
      localf.RBo.TCL = ((cva)localObject2);
      ((cva)localObject2).RMP = new dpr();
      Object localObject1 = com.tencent.mm.network.b.bsU().bsV();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1051;
      }
      ((cva)localObject2).RMP.Stl = com.tencent.mm.network.b.bsU().mue.Stl;
      ((cva)localObject2).RMP.RMR = new eae().dc(((String)localObject1).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.NetSceneManualAuth", "manual auth add public key , length " + ((String)localObject1).length());
      label468:
      ((cva)localObject2).TCJ = paramInt2;
      localObject1 = new iz();
      ((cva)localObject2).RMG = ((iz)localObject1);
      ((iz)localObject1).RMg = paramString6;
      ((iz)localObject1).ROU = 0;
      ((iz)localObject1).RMb = new eae().dc(new byte[0]);
      ((iz)localObject1).RMa = new eae().dc(new byte[0]);
      paramString6 = new fhd();
      ((iz)localObject1).ROS = paramString6;
      paramString6.RRv = "";
      paramString6.RRu = "";
      paramString6.UHm = "";
      localObject2 = new fmx();
      ((iz)localObject1).ROT = ((fmx)localObject2);
      ((fmx)localObject2).Tlm = "";
      ((fmx)localObject2).Tll = "";
      if (paramInt1 != 1) {
        break label1092;
      }
      paramString6.RRv = paramString3;
      paramString6.RRu = paramString4;
      paramString6.UHm = paramString5;
      ((fmx)localObject2).Tlm = "";
      ((fmx)localObject2).Tll = "";
      label647:
      if ((!Util.isNullOrNil(paramString1)) || (!h.aHB())) {
        break label1143;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 2L, 1L, false);
      this.lZP = ((String)h.aHG().aHp().b(3, null));
      this.lZQ = ((String)h.aHG().aHp().b(19, null));
      paramString1 = (j.g)this.lCW.getRespObj();
      paramString2 = Util.nullAsNil((String)h.aHG().aHp().b(2, null));
      if (!Util.isNullOrNil(paramString2)) {
        break label1135;
      }
      paramString2 = new com.tencent.mm.b.p(Util.nullAs((Integer)h.aHG().aHp().b(9, null), 0)).toString();
      label779:
      localcvc.UserName = paramString2;
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
          paramString1 = h.aHE().aGC().f(Util.getLong(paramString2, 0L), paramString3);
        }
      }
      label826:
      if (paramString1 != null) {
        break label1228;
      }
      paramInt1 = -1;
      label832:
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), Util.secPrint(Util.dumpHex(paramString1)) });
      paramString3 = new eae();
      paramString2 = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        paramString2 = new byte[0];
      }
      ((iz)localObject1).ROR = paramString3.dc(paramString2);
      localcvc.RRg = this.lZQ;
      localcvc.RRt = this.lZP;
      paramString1 = new b.a();
      paramString1.mug = com.tencent.mm.network.b.bsU().bsV();
      paramString1.muf = com.tencent.mm.network.b.bsU().muf;
      localf.setCGiVerifyKey(paramString1);
      paramString1 = com.tencent.mm.plugin.report.f.Iyx;
      if (!com.tencent.mm.protocal.f.RAO) {
        break label1234;
      }
      l = 104L;
      label961:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.f.Iyx;
      if (!com.tencent.mm.protocal.f.RAP) {
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
      if (i < d.RAD)
      {
        localf.setSceneStatus(16);
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      localf.setSceneStatus(1);
      break label327;
      ((cva)localObject2).RMP.Stl = 0;
      ((cva)localObject2).RMP.RMR = new eae().dc(new byte[0]);
      Log.e("MicroMsg.NetSceneManualAuth", "get sign key failed");
      break label468;
      if (paramInt1 != 3) {
        break label647;
      }
      paramString6.RRv = "";
      paramString6.RRu = "";
      paramString6.UHm = "";
      ((fmx)localObject2).Tlm = paramString3;
      ((fmx)localObject2).Tll = paramString4;
      break label647;
      label1135:
      paramString1.fGe = paramString2;
      break label779;
      label1143:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.lZP = paramString2;
        this.lZQ = paramString2;
        paramString2 = paramString1;
        break label779;
      }
      this.lZP = Util.getCutPasswordMD5(Util.nullAsNil(paramString2));
      this.lZQ = Util.getFullPasswordMD5(Util.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label779;
      paramString1 = paramString4;
      if (!Util.isValidQQNum(paramString2)) {
        break label826;
      }
      paramString1 = h.aHE().aGC().a(Util.getLong(paramString2, 0L), this.lZQ, true);
      break label826;
      paramInt1 = paramString1.length;
      break label832;
      l = 105L;
      break label961;
    }
  }
  
  public t(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, 0, "", "", "", paramInt, paramString3, false, false);
  }
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString2, paramString3, 0, "", "", "", 0, paramString4, true, false);
    this.lZV = paramString1;
  }
  
  public final void WY(String paramString)
  {
    AppMethodBeat.i(134166);
    j.f localf = (j.f)this.lCW.getReqObj();
    localf.RBo.TCK.RRg = paramString;
    localf.RBo.TCK.RRt = paramString;
    localf.RBo.TCL.RMG.ROR = new eae().dc(new byte[0]);
    this.lZP = paramString;
    this.lZQ = paramString;
    AppMethodBeat.o(134166);
  }
  
  public final String apf()
  {
    AppMethodBeat.i(186723);
    Object localObject = ((j.g)this.lCW.getRespObj()).RBm;
    if (localObject != null)
    {
      localObject = ((evr)localObject).Uxj.mVD;
      AppMethodBeat.o(186723);
      return localObject;
    }
    AppMethodBeat.o(186723);
    return null;
  }
  
  public final String bkX()
  {
    AppMethodBeat.i(134174);
    String str = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RMg;
    AppMethodBeat.o(134174);
    return str;
  }
  
  public final String boA()
  {
    AppMethodBeat.i(134169);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134169);
      return "";
    }
    String str = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RMe;
    AppMethodBeat.o(134169);
    return str;
  }
  
  public final String boB()
  {
    AppMethodBeat.i(134170);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134170);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.lCW.getRespObj()).RBm.Uxi.RLZ != null)
      {
        str = Util.nullAsNil(((j.g)this.lCW.getRespObj()).RBm.Uxi.RLZ.Tll);
        AppMethodBeat.o(134170);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.lCW.getRespObj()).RBm.Uxi.RLY != null))
    {
      str = Util.nullAsNil(((j.g)this.lCW.getRespObj()).RBm.Uxi.RLY.RRu);
      AppMethodBeat.o(134170);
      return str;
    }
    AppMethodBeat.o(134170);
    return "";
  }
  
  public final byte[] boC()
  {
    AppMethodBeat.i(134171);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134171);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.lCW.getRespObj()).RBm.Uxi.RLZ != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.lCW.getRespObj()).RBm.Uxi.RLZ.Tln, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.lCW.getRespObj()).RBm.Uxi.RLY != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.lCW.getRespObj()).RBm.Uxi.RLY.RIH, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.lCW.getReqObj()).RBo.TCK != null))
    {
      h.aHE().aGC().a(Util.getLong(((j.f)this.lCW.getReqObj()).RBo.TCK.UserName, 0L), com.tencent.mm.platformtools.z.a(((j.g)this.lCW.getRespObj()).RBm.Uxi.RLX));
      arrayOfByte = h.aHE().aGC().Gq(Util.getLong(((j.f)this.lCW.getReqObj()).RBo.TCK.UserName, 0L));
      AppMethodBeat.o(134171);
      return arrayOfByte;
    }
    AppMethodBeat.o(134171);
    return new byte[0];
  }
  
  public final String boD()
  {
    AppMethodBeat.i(134173);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134173);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.lCW.getRespObj()).RBm.Uxi.RLY != null))
    {
      if (((j.g)this.lCW.getRespObj()).RBm.Uxi.RLY.UHm != null)
      {
        String str = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RLY.UHm;
        AppMethodBeat.o(134173);
        return str;
      }
      AppMethodBeat.o(134173);
      return null;
    }
    AppMethodBeat.o(134173);
    return "";
  }
  
  public final boolean boE()
  {
    AppMethodBeat.i(134175);
    if ((((j.g)this.lCW.getRespObj()).RBm.Uxi.RMj & 0x10) != 0)
    {
      AppMethodBeat.o(134175);
      return true;
    }
    AppMethodBeat.o(134175);
    return false;
  }
  
  public final String boF()
  {
    AppMethodBeat.i(134176);
    String str = ((j.g)this.lCW.getRespObj()).RBm.Uxj.RFt;
    AppMethodBeat.o(134176);
    return str;
  }
  
  public final int boG()
  {
    AppMethodBeat.i(134177);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134177);
      return 0;
    }
    Object localObject = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 11);
    }
    for (int i = Util.getInt(localeos.Uro, 0);; i = 0)
    {
      AppMethodBeat.o(134177);
      return i;
    }
  }
  
  public final BindWordingContent boH()
  {
    AppMethodBeat.i(134178);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134178);
      return null;
    }
    Object localObject1 = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RMf;
    eos localeos;
    if ((localObject1 != null) && (((eii)localObject1).Ukq != null) && (((eii)localObject1).Ukq.size() > 0))
    {
      localObject1 = ((eii)localObject1).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject1).next();
      } while (localeos.IyZ != 12);
    }
    Object localObject3;
    for (localObject1 = localeos.Uro;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.WV((String)localObject1);
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
  
  public final String boI()
  {
    AppMethodBeat.i(134179);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134179);
      return "";
    }
    Object localObject = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RMf;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eos localeos = (eos)((Iterator)localObject).next();
        if (localeos.IyZ == 16)
        {
          localObject = localeos.Uro;
          AppMethodBeat.o(134179);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(134179);
    return "";
  }
  
  public final int boJ()
  {
    AppMethodBeat.i(134180);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134180);
      return 0;
    }
    Object localObject = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RMf;
    eos localeos;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeos = (eos)((Iterator)localObject).next();
      } while (localeos.IyZ != 13);
    }
    for (int i = Util.getInt(localeos.Uro, 0);; i = 0)
    {
      AppMethodBeat.o(134180);
      return i;
    }
  }
  
  public final boolean boK()
  {
    AppMethodBeat.i(134181);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(134181);
      return true;
    }
    Object localObject = ((j.g)this.lCW.getRespObj()).RBm.Uxi.RMf;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      localObject = ((eii)localObject).Ukq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eos localeos = (eos)((Iterator)localObject).next();
        if (localeos.IyZ == 18) {
          if (Util.getInt(localeos.Uro, 0) == 1)
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
  
  public final t boz()
  {
    this.lZW = true;
    return this;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(134167);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(134167);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(134172);
    if (((j.g)this.lCW.getRespObj()).RBm.Uxi == null)
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
    if (com.tencent.mm.protocal.f.RAO) {
      return 252;
    }
    return 701;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134168);
    j.f localf = (j.f)params.getReqObj();
    final j.g localg = (j.g)params.getRespObj();
    boolean bool;
    if ((localg.RBm != null) && (localg.RBm.Uxi != null))
    {
      paramInt1 = localg.RBm.Uxi.RMk;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      h.aHH();
      h.aHG().kcw.i(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = h.aHF().kcd.lCD;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.gm(bool);
      }
    }
    evr localevr;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localevr = localg.RBm;
      if (localevr != null) {
        break label230;
      }
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(134168);
      return;
      label198:
      bool = false;
      break;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localevr.Uxh;
    String str = this.account;
    ha localha = localevr.Uxi;
    ay localay = localevr.Uxj;
    dcb localdcb = localevr.Uxk;
    Object localObject;
    if (localevr.Uxi == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localevr.Uxi != null) {
        break label579;
      }
      localObject = Integer.valueOf(-1);
      label291:
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localevr, Integer.valueOf(paramInt1), localha, localay, localdcb, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1129;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label645;
      }
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 4L, 1L, false);
      if ((localevr == null) || (localevr.Uxk == null)) {
        break label592;
      }
      bi.a(true, localevr.Uxk.RRi, localevr.Uxk.RRj, localevr.Uxk.RRh, true, localevr.Uxk.TJD);
    }
    for (;;)
    {
      this.lCA -= 1;
      if (this.lCA > 0) {
        break label603;
      }
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getResources().getString(a.a.auth_idc_mismatch) + "(" + paramInt2 + ", " + paramInt3 + ")", 0).show();
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(134168);
      return;
      paramArrayOfByte = localevr.Uxi.RMm;
      break;
      label579:
      localObject = localevr.Uxi.RMn;
      break label291;
      label592:
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label603:
    Log.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.lCA) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(134168);
    return;
    label645:
    if ((!this.lZW) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134161);
          new m().doScene(t.a(t.this), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
            {
              AppMethodBeat.i(134160);
              Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                t.b(t.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", t.this);
                AppMethodBeat.o(134160);
                return;
              }
              t.this.doScene(t.c(t.this), t.b(t.this));
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
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.hoP()) });
      paramString = com.tencent.mm.plugin.report.f.Iyx;
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
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.lCA) });
      this.lCA -= 1;
      if (this.lCA <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    Log.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 6L, 1L, false);
    if ((com.tencent.mm.protocal.f.RAO) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(134168);
    return;
    label1129:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localevr.Uxj;
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
    if (bi.a(params) == 2)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 7L, 1L, false);
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.lZU) });
      this.lZU += 1;
      if (this.lZU > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      ((j.f)getReqResp().getReqObj()).RBo.TCL.RMG.ROU = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    h.aHJ().setHighPriority();
    Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    aj.a(localg.RBm, false);
    ((PluginAuth)h.ag(PluginAuth.class)).getHandleAuthResponseCallbacks().a(localf, localg, false);
    if (!Util.isNullOrNil(this.account))
    {
      h.aHG().aHp().set(ar.a.VuG, this.account);
      bg.ltv.aS("login_user_name", this.account);
    }
    h.aHF().kcd.a(new bv(new bv.a()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(134163);
        if ((paramAnonymousg == null) || (paramAnonymousg.biw() == null) || (localg.arm(1) == null) || (localg.arm(2) == null) || (localg.arm(3) == null) || (localg.RBm == null) || (localg.RBm.Uxi == null))
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 8L, 1L, false);
          Log.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          AppMethodBeat.o(134163);
          return;
        }
        Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { Util.secPrint(Util.dumpHex(localg.arm(1))), Util.secPrint(Util.dumpHex(localg.arm(2))), Util.secPrint(Util.dumpHex(localg.arm(3))), Integer.valueOf(localg.RBm.Uxi.vhf) });
        paramAnonymousg.biw().a(localg.arm(1), localg.arm(2), localg.arm(3), localg.RBm.Uxi.vhf);
        AppMethodBeat.o(134163);
      }
    }), 0);
    if (Util.nullAsNil((Integer)h.aHG().aHp().b(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)h.ae(com.tencent.mm.plugin.zero.b.b.class)).bnn().wE(10);
    }
    paramInt1 = localevr.Uxi.RMj;
    if ((paramInt1 & 0x8) == 0)
    {
      params = com.tencent.mm.model.z.bcZ();
      if (!TextUtils.isEmpty(params))
      {
        params = new p(params);
        h.aHF().kcd.a(params, 0);
      }
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Log.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        params = new mz();
        params.fLf.result = true;
        EventCenter.instance.publish(params);
      }
      h.aHJ().setLowPriority();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134168);
      return;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 9L, 1L, false);
    }
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
  
  public static final class a
  {
    public String fAo;
    public String maa;
    public Bundle mab;
    public int type;
    public String username;
    public String wording;
    
    public final String toString()
    {
      AppMethodBeat.i(134164);
      String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, Util.secPrint(this.fAo), this.maa, this.wording, this.mab });
      AppMethodBeat.o(134164);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.t
 * JD-Core Version:    0.7.0.1
 */