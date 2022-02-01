package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.protocal.protobuf.ews;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.fcb;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.jk;
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
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.network.m
{
  public String account;
  i callback;
  private int errCode;
  private int errType;
  public final s iMO;
  private int iMt;
  private String jjT;
  private String jjU;
  private boolean jjV;
  private boolean jjW;
  private int jjX;
  private int jjY;
  public String jjZ;
  private boolean jka;
  
  public t(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public t(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(134165);
    this.jjT = "";
    this.jjU = "";
    this.account = "";
    this.jjV = false;
    this.jjW = false;
    this.errType = 0;
    this.errCode = 0;
    this.iMt = 3;
    this.jjX = 0;
    this.jjY = 0;
    this.jka = false;
    Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + Util.getStack());
    if ((paramBoolean1) && (Util.isNullOrNil(paramString2))) {
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    j.f localf;
    label327:
    Object localObject2;
    if (f.KyZ)
    {
      i = 252;
      this.iMO = new bh(i);
      localf = (j.f)this.iMO.getReqObj();
      i = bh.aVK().getInt("key_auth_update_version", 0);
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
      if (i != 0) {
        break label1012;
      }
      localf.setSceneStatus(1);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 0L, 1L, false);
      localf.Kzz = true;
      localf.setUin(0);
      cmg localcmg = new cmg();
      localObject2 = new cme();
      localf.Kzy.MrA = localcmg;
      localf.Kzy.MrB = ((cme)localObject2);
      ((cme)localObject2).KLS = new dfx();
      Object localObject1 = com.tencent.mm.network.b.bjq().bjr();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1051;
      }
      ((cme)localObject2).KLS.LrO = com.tencent.mm.network.b.bjq().jDB.LrO;
      ((cme)localObject2).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(((String)localObject1).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.NetSceneManualAuth", "manual auth add public key , length " + ((String)localObject1).length());
      label468:
      ((cme)localObject2).Mrz = paramInt2;
      localObject1 = new jk();
      ((cme)localObject2).KLK = ((jk)localObject1);
      ((jk)localObject1).KLk = paramString6;
      ((jk)localObject1).KOa = 0;
      ((jk)localObject1).KLf = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((jk)localObject1).KLe = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramString6 = new ewr();
      ((jk)localObject1).KNY = paramString6;
      paramString6.KQx = "";
      paramString6.KQw = "";
      paramString6.Num = "";
      localObject2 = new fca();
      ((jk)localObject1).KNZ = ((fca)localObject2);
      ((fca)localObject2).MbK = "";
      ((fca)localObject2).MbJ = "";
      if (paramInt1 != 1) {
        break label1092;
      }
      paramString6.KQx = paramString3;
      paramString6.KQw = paramString4;
      paramString6.Num = paramString5;
      ((fca)localObject2).MbK = "";
      ((fca)localObject2).MbJ = "";
      label647:
      if ((!Util.isNullOrNil(paramString1)) || (!com.tencent.mm.kernel.g.aAc())) {
        break label1143;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 2L, 1L, false);
      this.jjT = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(3, null));
      this.jjU = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(19, null));
      paramString1 = (j.g)this.iMO.getRespObj();
      paramString2 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null));
      if (!Util.isNullOrNil(paramString2)) {
        break label1135;
      }
      paramString2 = new com.tencent.mm.b.p(Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(9, null), 0)).toString();
      label779:
      localcmg.UserName = paramString2;
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
          paramString1 = com.tencent.mm.kernel.g.aAf().azh().e(Util.getLong(paramString2, 0L), paramString3);
        }
      }
      label826:
      if (paramString1 != null) {
        break label1228;
      }
      paramInt1 = -1;
      label832:
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), Util.secPrint(Util.dumpHex(paramString1)) });
      paramString3 = new SKBuiltinBuffer_t();
      paramString2 = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        paramString2 = new byte[0];
      }
      ((jk)localObject1).KNX = paramString3.setBuffer(paramString2);
      localcmg.KQi = this.jjU;
      localcmg.KQv = this.jjT;
      paramString1 = new b.a();
      paramString1.jDD = com.tencent.mm.network.b.bjq().bjr();
      paramString1.jDC = com.tencent.mm.network.b.bjq().jDC;
      localf.setCGiVerifyKey(paramString1);
      paramString1 = com.tencent.mm.plugin.report.e.Cxv;
      if (!f.KyZ) {
        break label1234;
      }
      l = 104L;
      label961:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.e.Cxv;
      if (!f.Kza) {
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
      if (i < com.tencent.mm.protocal.d.KyO)
      {
        localf.setSceneStatus(16);
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      localf.setSceneStatus(1);
      break label327;
      ((cme)localObject2).KLS.LrO = 0;
      ((cme)localObject2).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      Log.e("MicroMsg.NetSceneManualAuth", "get sign key failed");
      break label468;
      if (paramInt1 != 3) {
        break label647;
      }
      paramString6.KQx = "";
      paramString6.KQw = "";
      paramString6.Num = "";
      ((fca)localObject2).MbK = paramString3;
      ((fca)localObject2).MbJ = paramString4;
      break label647;
      label1135:
      paramString1.dMW = paramString2;
      break label779;
      label1143:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.jjT = paramString2;
        this.jjU = paramString2;
        paramString2 = paramString1;
        break label779;
      }
      this.jjT = Util.getCutPasswordMD5(Util.nullAsNil(paramString2));
      this.jjU = Util.getFullPasswordMD5(Util.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label779;
      paramString1 = paramString4;
      if (!Util.isValidQQNum(paramString2)) {
        break label826;
      }
      paramString1 = com.tencent.mm.kernel.g.aAf().azh().a(Util.getLong(paramString2, 0L), this.jjU, true);
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
    this.jjZ = paramString1;
  }
  
  public final void PA(String paramString)
  {
    AppMethodBeat.i(134166);
    j.f localf = (j.f)this.iMO.getReqObj();
    localf.Kzy.MrA.KQi = paramString;
    localf.Kzy.MrA.KQv = paramString;
    localf.Kzy.MrB.KLK.KNX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.jjT = paramString;
    this.jjU = paramString;
    AppMethodBeat.o(134166);
  }
  
  public final String ajx()
  {
    AppMethodBeat.i(222850);
    Object localObject = ((j.g)this.iMO.getRespObj()).Kzw;
    if (localObject != null)
    {
      localObject = ((ell)localObject).Nkz.ked;
      AppMethodBeat.o(222850);
      return localObject;
    }
    AppMethodBeat.o(222850);
    return null;
  }
  
  public final String bbH()
  {
    AppMethodBeat.i(134174);
    String str = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLk;
    AppMethodBeat.o(134174);
    return str;
  }
  
  public final t bfj()
  {
    this.jka = true;
    return this;
  }
  
  public final String bfk()
  {
    AppMethodBeat.i(134169);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134169);
      return "";
    }
    String str = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLi;
    AppMethodBeat.o(134169);
    return str;
  }
  
  public final String bfl()
  {
    AppMethodBeat.i(134170);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134170);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.iMO.getRespObj()).Kzw.Nky.KLd != null)
      {
        str = Util.nullAsNil(((j.g)this.iMO.getRespObj()).Kzw.Nky.KLd.MbJ);
        AppMethodBeat.o(134170);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.iMO.getRespObj()).Kzw.Nky.KLc != null))
    {
      str = Util.nullAsNil(((j.g)this.iMO.getRespObj()).Kzw.Nky.KLc.KQw);
      AppMethodBeat.o(134170);
      return str;
    }
    AppMethodBeat.o(134170);
    return "";
  }
  
  public final byte[] bfm()
  {
    AppMethodBeat.i(134171);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134171);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.iMO.getRespObj()).Kzw.Nky.KLd != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.iMO.getRespObj()).Kzw.Nky.KLd.MbL, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.iMO.getRespObj()).Kzw.Nky.KLc != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.z.a(((j.g)this.iMO.getRespObj()).Kzw.Nky.KLc.KHp, new byte[0]);
        AppMethodBeat.o(134171);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.iMO.getReqObj()).Kzy.MrA != null))
    {
      com.tencent.mm.kernel.g.aAf().azh().a(Util.getLong(((j.f)this.iMO.getReqObj()).Kzy.MrA.UserName, 0L), com.tencent.mm.platformtools.z.a(((j.g)this.iMO.getRespObj()).Kzw.Nky.KLb));
      arrayOfByte = com.tencent.mm.kernel.g.aAf().azh().Ai(Util.getLong(((j.f)this.iMO.getReqObj()).Kzy.MrA.UserName, 0L));
      AppMethodBeat.o(134171);
      return arrayOfByte;
    }
    AppMethodBeat.o(134171);
    return new byte[0];
  }
  
  public final String bfn()
  {
    AppMethodBeat.i(134173);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134173);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.iMO.getRespObj()).Kzw.Nky.KLc != null))
    {
      if (((j.g)this.iMO.getRespObj()).Kzw.Nky.KLc.Num != null)
      {
        String str = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLc.Num;
        AppMethodBeat.o(134173);
        return str;
      }
      AppMethodBeat.o(134173);
      return null;
    }
    AppMethodBeat.o(134173);
    return "";
  }
  
  public final boolean bfo()
  {
    AppMethodBeat.i(134175);
    if ((((j.g)this.iMO.getRespObj()).Kzw.Nky.KLn & 0x10) != 0)
    {
      AppMethodBeat.o(134175);
      return true;
    }
    AppMethodBeat.o(134175);
    return false;
  }
  
  public final String bfp()
  {
    AppMethodBeat.i(134176);
    String str = ((j.g)this.iMO.getRespObj()).Kzw.Nkz.KEb;
    AppMethodBeat.o(134176);
    return str;
  }
  
  public final int bfq()
  {
    AppMethodBeat.i(134177);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134177);
      return 0;
    }
    Object localObject = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 11);
    }
    for (int i = Util.getInt(localeer.NeO, 0);; i = 0)
    {
      AppMethodBeat.o(134177);
      return i;
    }
  }
  
  public final BindWordingContent bfr()
  {
    AppMethodBeat.i(134178);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134178);
      return null;
    }
    Object localObject1 = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLj;
    eer localeer;
    if ((localObject1 != null) && (((dyh)localObject1).MXV != null) && (((dyh)localObject1).MXV.size() > 0))
    {
      localObject1 = ((dyh)localObject1).MXV.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject1).next();
      } while (localeer.Cya != 12);
    }
    Object localObject3;
    for (localObject1 = localeer.NeO;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.Py((String)localObject1);
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
  
  public final String bfs()
  {
    AppMethodBeat.i(134179);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134179);
      return "";
    }
    Object localObject = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLj;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eer localeer = (eer)((Iterator)localObject).next();
        if (localeer.Cya == 16)
        {
          localObject = localeer.NeO;
          AppMethodBeat.o(134179);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(134179);
    return "";
  }
  
  public final int bft()
  {
    AppMethodBeat.i(134180);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134180);
      return 0;
    }
    Object localObject = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLj;
    eer localeer;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localeer = (eer)((Iterator)localObject).next();
      } while (localeer.Cya != 13);
    }
    for (int i = Util.getInt(localeer.NeO, 0);; i = 0)
    {
      AppMethodBeat.o(134180);
      return i;
    }
  }
  
  public final boolean bfu()
  {
    AppMethodBeat.i(134181);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(134181);
      return true;
    }
    Object localObject = ((j.g)this.iMO.getRespObj()).Kzw.Nky.KLj;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      localObject = ((dyh)localObject).MXV.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eer localeer = (eer)((Iterator)localObject).next();
        if (localeer.Cya == 18) {
          if (Util.getInt(localeer.NeO, 0) == 1)
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(134167);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(134167);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(134172);
    if (((j.g)this.iMO.getRespObj()).Kzw.Nky == null)
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
    if (f.KyZ) {
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
    if ((localg.Kzw != null) && (localg.Kzw.Nky != null))
    {
      paramInt1 = localg.Kzw.Nky.KLo;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().hqB.set(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = com.tencent.mm.kernel.g.aAg().hqi.iMw;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.fB(bool);
      }
    }
    ell localell;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localell = localg.Kzw;
      if (localell != null) {
        break label230;
      }
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(134168);
      return;
      label198:
      bool = false;
      break;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localell.Nkx;
    String str = this.account;
    hk localhk = localell.Nky;
    ba localba = localell.Nkz;
    ctc localctc = localell.NkA;
    Object localObject;
    if (localell.Nky == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localell.Nky != null) {
        break label570;
      }
      localObject = Integer.valueOf(-1);
      label291:
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth account %s, errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localell, Integer.valueOf(paramInt1), localhk, localba, localctc, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1120;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label636;
      }
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 4L, 1L, false);
      if ((localell == null) || (localell.NkA == null)) {
        break label583;
      }
      bh.a(true, localell.NkA.KQk, localell.NkA.KQl, localell.NkA.KQj);
    }
    for (;;)
    {
      this.iMt -= 1;
      if (this.iMt > 0) {
        break label594;
      }
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getResources().getString(2131756212) + "(" + paramInt2 + ", " + paramInt3 + ")", 0).show();
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(134168);
      return;
      paramArrayOfByte = localell.Nky.KLq;
      break;
      label570:
      localObject = localell.Nky.KLr;
      break label291;
      label583:
      Log.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label594:
    Log.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.iMt) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(134168);
    return;
    label636:
    if ((!this.jka) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = params.getReqObj().getRsaInfo().ver;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134161);
          new m().doScene(t.this.dispatcher(), new i()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.q paramAnonymous2q)
            {
              AppMethodBeat.i(134160);
              Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2q.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(f.Kze) });
      paramString = com.tencent.mm.plugin.report.e.Cxv;
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
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(134168);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.iMt) });
      this.iMt -= 1;
      if (this.iMt <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    Log.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 6L, 1L, false);
    if ((f.KyZ) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(134168);
    return;
    label1120:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localell.Nkz;
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
    if (bh.a(params) == 2)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 7L, 1L, false);
      Log.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.jjY) });
      this.jjY += 1;
      if (this.jjY > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(134168);
        return;
      }
      ((j.f)getReqResp().getReqObj()).Kzy.MrB.KLK.KOa = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(134168);
      return;
    }
    com.tencent.mm.kernel.g.aAk().setHighPriority();
    Log.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    aj.a(localg.Kzw, false);
    ((PluginAuth)com.tencent.mm.kernel.g.ah(PluginAuth.class)).getHandleAuthResponseCallbacks().a(localf, localg, false);
    if (!Util.isNullOrNil(this.account))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogq, this.account);
      bf.iDu.aO("login_user_name", this.account);
    }
    com.tencent.mm.kernel.g.aAg().hqi.a(new bu(new bu.a()
    {
      public final void a(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(134163);
        if ((paramAnonymousg == null) || (paramAnonymousg.aZh() == null) || (localg.aiZ(1) == null) || (localg.aiZ(2) == null) || (localg.aiZ(3) == null) || (localg.Kzw == null) || (localg.Kzw.Nky == null))
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 8L, 1L, false);
          Log.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          AppMethodBeat.o(134163);
          return;
        }
        Log.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { Util.secPrint(Util.dumpHex(localg.aiZ(1))), Util.secPrint(Util.dumpHex(localg.aiZ(2))), Util.secPrint(Util.dumpHex(localg.aiZ(3))), Integer.valueOf(localg.Kzw.Nky.rBx) });
        paramAnonymousg.aZh().a(localg.aiZ(1), localg.aiZ(2), localg.aiZ(3), localg.Kzw.Nky.rBx);
        AppMethodBeat.o(134163);
      }
    }), 0);
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.b.class)).bdS().tE(10);
    }
    paramInt1 = localell.Nky.KLn;
    if ((paramInt1 & 0x8) == 0)
    {
      params = com.tencent.mm.model.z.aTY();
      if (!TextUtils.isEmpty(params))
      {
        params = new p(params);
        com.tencent.mm.kernel.g.aAg().hqi.a(params, 0);
      }
      paramInt1 = 4;
      if ((localf.Kzy.MrB.KLK.KNX == null) || (localf.Kzy.MrB.KLK.KNX.getILen() <= 0)) {
        break label1731;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.b.d.E(1, paramInt1, localf.Kzy.MrA.UserName);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Log.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        params = new mi();
        params.dRI.result = true;
        EventCenter.instance.publish(params);
      }
      com.tencent.mm.kernel.g.aAk().setLowPriority();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134168);
      return;
      Log.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 9L, 1L, false);
      break;
      label1731:
      if (localf.Kzy.MrB.Mrz == 1) {
        paramInt1 = 2;
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
  
  public static final class a
  {
    public String dHx;
    public String dQx;
    public String jke;
    public Bundle jkf;
    public int type;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(134164);
      String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, Util.secPrint(this.dHx), this.jke, this.dQx, this.jkf });
      AppMethodBeat.o(134164);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.t
 * JD-Core Version:    0.7.0.1
 */