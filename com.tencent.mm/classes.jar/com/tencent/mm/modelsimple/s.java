package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class s
  extends m
  implements k
{
  public String account;
  com.tencent.mm.ai.f callback;
  private int errCode;
  private int errType;
  public String fPA;
  private boolean fPB;
  private String fPu;
  private String fPv;
  private boolean fPw;
  private boolean fPx;
  private int fPy;
  private int fPz;
  public final q ftU;
  private int ftx;
  
  public s(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
  }
  
  public s(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(123441);
    this.fPu = "";
    this.fPv = "";
    this.account = "";
    this.fPw = false;
    this.fPx = false;
    this.errType = 0;
    this.errCode = 0;
    this.ftx = 3;
    this.fPy = 0;
    this.fPz = 0;
    this.fPB = false;
    ab.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + paramString1 + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + bo.dtY());
    if ((paramBoolean1) && (bo.isNullOrNil(paramString2))) {
      ab.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth useRawPwd but [%s]", new Object[] { paramString2 });
    }
    this.account = paramString1;
    int i;
    Object localObject1;
    label327:
    Object localObject2;
    if (com.tencent.mm.protocal.f.whQ)
    {
      i = 252;
      this.ftU = new ax(i);
      localObject1 = (j.f)this.ftU.getReqObj();
      i = ax.aaF().getInt("key_auth_update_version", 0);
      ab.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.whH) });
      if (i != 0) {
        break label881;
      }
      ((j.f)localObject1).setSceneStatus(1);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 0L, 1L, false);
      ((j.f)localObject1).wio = true;
      ((j.f)localObject1).setUin(0);
      bcf localbcf = new bcf();
      localObject2 = new bcd();
      ((j.f)localObject1).win.xrm = localbcf;
      ((j.f)localObject1).win.xrn = ((bcd)localObject2);
      ((bcd)localObject2).xrl = paramInt2;
      localObject1 = new hm();
      ((bcd)localObject2).wsm = ((hm)localObject1);
      ((hm)localObject1).wrW = paramString6;
      ((hm)localObject1).wuk = 0;
      ((hm)localObject1).wrR = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((hm)localObject1).wrQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramString6 = new cvg();
      ((hm)localObject1).wui = paramString6;
      paramString6.wwl = "";
      paramString6.wwk = "";
      paramString6.ydL = "";
      localObject2 = new czg();
      ((hm)localObject1).wuj = ((czg)localObject2);
      ((czg)localObject2).xfJ = "";
      ((czg)localObject2).xfI = "";
      if (paramInt1 != 1) {
        break label920;
      }
      paramString6.wwl = paramString3;
      paramString6.wwk = paramString4;
      paramString6.ydL = paramString5;
      ((czg)localObject2).xfJ = "";
      ((czg)localObject2).xfI = "";
      label550:
      if ((!bo.isNullOrNil(paramString1)) || (!g.RG())) {
        break label971;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 2L, 1L, false);
      this.fPu = ((String)g.RL().Ru().get(3, null));
      this.fPv = ((String)g.RL().Ru().get(19, null));
      paramString1 = (j.g)this.ftU.getRespObj();
      paramString2 = bo.nullAsNil((String)g.RL().Ru().get(2, null));
      if (!bo.isNullOrNil(paramString2)) {
        break label963;
      }
      paramString2 = new com.tencent.mm.a.p(bo.a((Integer)g.RL().Ru().get(9, null), 0)).toString();
      label682:
      localbcf.jJA = paramString2;
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
          paramString1 = g.RJ().QN().d(bo.getLong(paramString2, 0L), paramString3);
        }
      }
      label729:
      if (paramString1 != null) {
        break label1056;
      }
      paramInt1 = -1;
      label735:
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), bo.aqg(bo.cd(paramString1)) });
      paramString3 = new SKBuiltinBuffer_t();
      paramString2 = paramString1;
      if (bo.ce(paramString1)) {
        paramString2 = new byte[0];
      }
      ((hm)localObject1).wuh = paramString3.setBuffer(paramString2);
      localbcf.wvW = this.fPv;
      localbcf.wwj = this.fPu;
      paramString1 = com.tencent.mm.plugin.report.e.qrI;
      if (!com.tencent.mm.protocal.f.whQ) {
        break label1062;
      }
      l = 104L;
      label830:
      paramString1.idkeyStat(148L, l, 1L, false);
      paramString1 = com.tencent.mm.plugin.report.e.qrI;
      if (!com.tencent.mm.protocal.f.whR) {
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
      AppMethodBeat.o(123441);
      return;
      i = 701;
      break;
      label881:
      if (i < com.tencent.mm.protocal.d.whH)
      {
        ((j.f)localObject1).setSceneStatus(16);
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 1L, 1L, false);
        break label327;
      }
      ((j.f)localObject1).setSceneStatus(1);
      break label327;
      if (paramInt1 != 3) {
        break label550;
      }
      paramString6.wwl = "";
      paramString6.wwk = "";
      paramString6.ydL = "";
      ((czg)localObject2).xfJ = paramString3;
      ((czg)localObject2).xfI = paramString4;
      break label550;
      label963:
      paramString1.gde = paramString2;
      break label682;
      label971:
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.fPu = paramString2;
        this.fPv = paramString2;
        paramString2 = paramString1;
        break label682;
      }
      this.fPu = bo.apO(bo.nullAsNil(paramString2));
      this.fPv = bo.apP(bo.nullAsNil(paramString2));
      paramString2 = paramString1;
      break label682;
      label1023:
      paramString1 = paramString4;
      if (!bo.apG(paramString2)) {
        break label729;
      }
      paramString1 = g.RJ().QN().a(bo.getLong(paramString2, 0L), this.fPv, true);
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
    this.fPA = paramString1;
  }
  
  public final String agy()
  {
    AppMethodBeat.i(123450);
    String str = ((j.g)this.ftU.getRespObj()).wil.xWm.wrW;
    AppMethodBeat.o(123450);
    return str;
  }
  
  public final s ajE()
  {
    this.fPB = true;
    return this;
  }
  
  public final String ajF()
  {
    AppMethodBeat.i(123445);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123445);
      return "";
    }
    String str = ((j.g)this.ftU.getRespObj()).wil.xWm.wrU;
    AppMethodBeat.o(123445);
    return str;
  }
  
  public final String ajG()
  {
    AppMethodBeat.i(123446);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123446);
      return "";
    }
    int i = getSecCodeType();
    String str;
    if (i == 3)
    {
      if (((j.g)this.ftU.getRespObj()).wil.xWm.wrP != null)
      {
        str = bo.nullAsNil(((j.g)this.ftU.getRespObj()).wil.xWm.wrP.xfI);
        AppMethodBeat.o(123446);
        return str;
      }
    }
    else if ((i == 1) && (((j.g)this.ftU.getRespObj()).wil.xWm.wrO != null))
    {
      str = bo.nullAsNil(((j.g)this.ftU.getRespObj()).wil.xWm.wrO.wwk);
      AppMethodBeat.o(123446);
      return str;
    }
    AppMethodBeat.o(123446);
    return "";
  }
  
  public final byte[] ajH()
  {
    AppMethodBeat.i(123447);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123447);
      return new byte[0];
    }
    int i = getSecCodeType();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((j.g)this.ftU.getRespObj()).wil.xWm.wrP != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.aa.a(((j.g)this.ftU.getRespObj()).wil.xWm.wrP.xfL, new byte[0]);
        AppMethodBeat.o(123447);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((j.g)this.ftU.getRespObj()).wil.xWm.wrO != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.aa.a(((j.g)this.ftU.getRespObj()).wil.xWm.wrO.woT, new byte[0]);
        AppMethodBeat.o(123447);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((j.f)this.ftU.getReqObj()).win.xrm != null))
    {
      g.RJ().QN().a(bo.getLong(((j.f)this.ftU.getReqObj()).win.xrm.jJA, 0L), com.tencent.mm.platformtools.aa.a(((j.g)this.ftU.getRespObj()).wil.xWm.wrN));
      arrayOfByte = g.RJ().QN().gC(bo.getLong(((j.f)this.ftU.getReqObj()).win.xrm.jJA, 0L));
      AppMethodBeat.o(123447);
      return arrayOfByte;
    }
    AppMethodBeat.o(123447);
    return new byte[0];
  }
  
  public final String ajI()
  {
    AppMethodBeat.i(123449);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123449);
      return "";
    }
    if ((getSecCodeType() == 1) && (((j.g)this.ftU.getRespObj()).wil.xWm.wrO != null))
    {
      if (((j.g)this.ftU.getRespObj()).wil.xWm.wrO.ydL != null)
      {
        String str = ((j.g)this.ftU.getRespObj()).wil.xWm.wrO.ydL;
        AppMethodBeat.o(123449);
        return str;
      }
      AppMethodBeat.o(123449);
      return null;
    }
    AppMethodBeat.o(123449);
    return "";
  }
  
  public final boolean ajJ()
  {
    AppMethodBeat.i(140666);
    if ((((j.g)this.ftU.getRespObj()).wil.xWm.wrZ & 0x10) != 0)
    {
      AppMethodBeat.o(140666);
      return true;
    }
    AppMethodBeat.o(140666);
    return false;
  }
  
  public final String ajK()
  {
    AppMethodBeat.i(123451);
    String str = ((j.g)this.ftU.getRespObj()).wil.xWn.wms;
    AppMethodBeat.o(123451);
    return str;
  }
  
  public final int ajL()
  {
    AppMethodBeat.i(123452);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123452);
      return 0;
    }
    Object localObject = ((j.g)this.ftU.getRespObj()).wil.xWm.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 11);
    }
    for (int i = bo.getInt(localcij.xSX, 0);; i = 0)
    {
      AppMethodBeat.o(123452);
      return i;
    }
  }
  
  public final BindWordingContent ajM()
  {
    AppMethodBeat.i(123453);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123453);
      return null;
    }
    Object localObject1 = ((j.g)this.ftU.getRespObj()).wil.xWm.wrV;
    cij localcij;
    if ((localObject1 != null) && (((cco)localObject1).xNc != null) && (((cco)localObject1).xNc.size() > 0))
    {
      localObject1 = ((cco)localObject1).xNc.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject1).next();
      } while (localcij.qsk != 12);
    }
    Object localObject3;
    for (localObject1 = localcij.xSX;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.un((String)localObject1);
          AppMethodBeat.o(123453);
          return localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String ajN()
  {
    AppMethodBeat.i(123454);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123454);
      return "";
    }
    Object localObject = ((j.g)this.ftU.getRespObj()).wil.xWm.wrV;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cij localcij = (cij)((Iterator)localObject).next();
        if (localcij.qsk == 16)
        {
          localObject = localcij.xSX;
          AppMethodBeat.o(123454);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(123454);
    return "";
  }
  
  public final int ajO()
  {
    AppMethodBeat.i(123455);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123455);
      return 0;
    }
    Object localObject = ((j.g)this.ftU.getRespObj()).wil.xWm.wrV;
    cij localcij;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localcij = (cij)((Iterator)localObject).next();
      } while (localcij.qsk != 13);
    }
    for (int i = bo.getInt(localcij.xSX, 0);; i = 0)
    {
      AppMethodBeat.o(123455);
      return i;
    }
  }
  
  public final boolean ajP()
  {
    AppMethodBeat.i(123456);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(123456);
      return true;
    }
    Object localObject = ((j.g)this.ftU.getRespObj()).wil.xWm.wrV;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      localObject = ((cco)localObject).xNc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cij localcij = (cij)((Iterator)localObject).next();
        if (localcij.qsk == 18) {
          if (bo.getInt(localcij.xSX, 0) == 1)
          {
            AppMethodBeat.o(123456);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(123456);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(123443);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(123443);
    return i;
  }
  
  public final int getSecCodeType()
  {
    AppMethodBeat.i(123448);
    if (((j.g)this.ftU.getRespObj()).wil.xWm == null)
    {
      ab.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      AppMethodBeat.o(123448);
      return 0;
    }
    if (this.errType != 4)
    {
      ab.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
      AppMethodBeat.o(123448);
      return 0;
    }
    if (this.errCode == -311)
    {
      AppMethodBeat.o(123448);
      return 2;
    }
    if (this.errCode == -6)
    {
      AppMethodBeat.o(123448);
      return 1;
    }
    if (this.errCode == -310)
    {
      AppMethodBeat.o(123448);
      return 3;
    }
    AppMethodBeat.o(123448);
    return 0;
  }
  
  public final int getType()
  {
    if (com.tencent.mm.protocal.f.whQ) {
      return 252;
    }
    return 701;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123444);
    j.f localf = (j.f)paramq.getReqObj();
    j.g localg = (j.g)paramq.getRespObj();
    boolean bool;
    if ((localg.wil != null) && (localg.wil.xWm != null))
    {
      paramInt1 = localg.wil.xWm.wsa;
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.RM();
      g.RL().eHM.set(47, Integer.valueOf(paramInt1));
      paramArrayOfByte = g.RK().eHt.ftA;
      if (paramArrayOfByte != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label198;
        }
        bool = true;
        paramArrayOfByte.cT(bool);
      }
    }
    cmm localcmm;
    for (;;)
    {
      this.errType = paramInt2;
      this.errCode = paramInt3;
      localcmm = localg.wil;
      if (localcmm != null) {
        break label230;
      }
      ab.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.callback.onSceneEnd(4, -1, "", this);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 3L, 1L, false);
      AppMethodBeat.o(123444);
      return;
      label198:
      bool = false;
      break;
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[] { Integer.valueOf(localg.getRetCode()) });
    }
    label230:
    paramInt1 = localcmm.xWl;
    ft localft = localcmm.xWm;
    ar localar = localcmm.xWn;
    bfu localbfu = localcmm.xWo;
    Object localObject;
    if (localcmm.xWm == null)
    {
      paramArrayOfByte = Integer.valueOf(-1);
      if (localcmm.xWm != null) {
        break label500;
      }
      localObject = Integer.valueOf(-1);
      label285:
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s  clientSessionKey[%s], serverSessionKey[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localcmm, Integer.valueOf(paramInt1), localft, localar, localbfu, paramArrayOfByte, localObject });
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label1050;
      }
      if ((paramInt2 != 4) || (paramInt3 != -301)) {
        break label566;
      }
      ab.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 4L, 1L, false);
      if ((localcmm == null) || (localcmm.xWo == null)) {
        break label513;
      }
      ax.a(true, localcmm.xWo.wvY, localcmm.xWo.wvZ, localcmm.xWo.wvX);
    }
    for (;;)
    {
      this.ftx -= 1;
      if (this.ftx > 0) {
        break label524;
      }
      ab.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(123444);
      return;
      paramArrayOfByte = localcmm.xWm.wsc;
      break;
      label500:
      localObject = localcmm.xWm.wsd;
      break label285;
      label513:
      ab.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
    }
    label524:
    ab.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.ftx) });
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(123444);
    return;
    label566:
    if ((!this.fPB) && (paramInt2 == 4) && (paramInt3 == -102))
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 5L, 1L, false);
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.RO().ac(new s.1(this, paramInt1));
      AppMethodBeat.o(123444);
      return;
    }
    if ((paramInt2 == 4) && ((paramInt3 == -305) || (paramInt3 == -306)))
    {
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_SWITCH or MM_ERR_ECDHFAIL_ROLLBACK errCode:%d ver:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(com.tencent.mm.protocal.f.whV) });
      paramString = com.tencent.mm.plugin.report.e.qrI;
      if (paramInt3 == -305) {}
      for (long l = 108L;; l = 109L)
      {
        paramString.idkeyStat(148L, l, 1L, true);
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(123444);
        return;
      }
    }
    if ((paramInt2 == 4) && (paramInt3 == -217))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 47L, 1L, false);
      AppMethodBeat.o(123444);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -218))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 53L, 1L, false);
      AppMethodBeat.o(123444);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -240))
    {
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ftx) });
      this.ftx -= 1;
      if (this.ftx <= 0)
      {
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(123444);
        return;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 57L, 1L, false);
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(123444);
      return;
    }
    ab.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 6L, 1L, false);
    if ((com.tencent.mm.protocal.f.whQ) && (paramInt3 != -106)) {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 110L, 1L, false);
    }
    AppMethodBeat.o(123444);
    return;
    label1050:
    if ((paramInt1 & 0x2) != 0)
    {
      paramArrayOfByte = localcmm.xWn;
      if ((paramArrayOfByte == null) || (bo.isNullOrNil(paramArrayOfByte.jJA)))
      {
        ab.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(123444);
      }
    }
    else
    {
      ab.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.callback.onSceneEnd(4, -1, "", this);
      AppMethodBeat.o(123444);
      return;
    }
    if (ax.a(paramq) == 2)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 7L, 1L, false);
      ab.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.fPz) });
      this.fPz += 1;
      if (this.fPz > 1)
      {
        this.callback.onSceneEnd(4, -1, "", this);
        AppMethodBeat.o(123444);
        return;
      }
      ((j.f)getReqResp().getReqObj()).win.xrn.wsm.wuk = 1;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(123444);
      return;
    }
    g.RO().Bk();
    ab.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    com.tencent.mm.model.aa.a(localg.wil, false);
    ((PluginAuth)g.G(PluginAuth.class)).getHandleAuthResponseCallbacks().a(localf, localg, false);
    if (!bo.isNullOrNil(this.account))
    {
      g.RL().Ru().set(ac.a.yJS, this.account);
      av.flM.ao("login_user_name", this.account);
    }
    g.RK().eHt.a(new bk(new s.2(this, localg)), 0);
    if (bo.g((Integer)g.RL().Ru().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)g.E(com.tencent.mm.plugin.zero.b.b.class)).aio().lL(10);
    }
    paramInt1 = localcmm.xWm.wrZ;
    if ((paramInt1 & 0x8) == 0)
    {
      paramq = r.Zn();
      if (!TextUtils.isEmpty(paramq))
      {
        paramq = new o(paramq);
        g.RK().eHt.a(paramq, 0);
      }
      paramInt1 = 4;
      if ((localf.win.xrn.wsm.wuh == null) || (localf.win.xrn.wsm.wuh.getILen() <= 0)) {
        break label1661;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.b.d.x(1, paramInt1, localf.win.xrm.jJA);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ab.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
        paramq = new jw();
        paramq.czl.cmX = true;
        com.tencent.mm.sdk.b.a.ymk.l(paramq);
      }
      g.RO().dtd();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(123444);
      return;
      ab.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 9L, 1L, false);
      break;
      label1661:
      if (localf.win.xrn.xrl == 1) {
        paramInt1 = 2;
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 5;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
  
  public final void up(String paramString)
  {
    AppMethodBeat.i(123442);
    j.f localf = (j.f)this.ftU.getReqObj();
    localf.win.xrm.wvW = paramString;
    localf.win.xrm.wwj = paramString;
    localf.win.xrn.wsm.wuh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    this.fPu = paramString;
    this.fPv = paramString;
    AppMethodBeat.o(123442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */