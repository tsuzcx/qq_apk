package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.abq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.ct;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fvb;
import com.tencent.mm.protocal.protobuf.gnp;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class q
  extends p
  implements m
{
  private String account;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public q(String paramString)
  {
    AppMethodBeat.i(134157);
    this.account = paramString;
    c.a locala = new c.a();
    locala.otE = new cqd();
    locala.otF = new cqe();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((cqd)c.b.b(this.rr.otB)).UserName = paramString;
    AppMethodBeat.o(134157);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(134158);
    if (Util.isNullOrNil(this.account))
    {
      Log.e("MicroMsg.NetSceneGetProfile", "null or empty username");
      AppMethodBeat.o(134158);
      return -1;
    }
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(134158);
    return i;
  }
  
  public final int getType()
  {
    return 302;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134159);
    Log.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cqe)c.c.b(this.rr.otC);
      paramArrayOfByte = new abq();
      paramArrayOfByte.ifg.ifh = params.aawK.abTf;
      paramArrayOfByte.publish();
      if ((z.bAM().equals(params.aawJ.ZqL.toString())) && (!Util.isNullOrNil(params.aawK.ZhP))) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIP, params.aawK.ZhP);
      }
      Log.i("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(params.aawJ.aaWS), Integer.valueOf(params.aawK.abSZ) });
      com.tencent.mm.kernel.h.baE().ban().B(64, Integer.valueOf(params.aawK.YCa));
      com.tencent.mm.kernel.h.baE().ban().B(144385, Integer.valueOf(params.aawK.abSZ));
      com.tencent.mm.kernel.h.baE().ban().B(40, Integer.valueOf(params.aawJ.aaWS));
      Log.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(params.aawJ.aaWS) });
      PluginAuth.setUserInfoPluginSwitch(params.aawJ.aaWS);
      com.tencent.mm.kernel.h.baE().ban().B(339975, Integer.valueOf(params.aawK.abTh));
      Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(params.aawK.abTh) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNa, Integer.valueOf(params.aawK.aang));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNb, Integer.valueOf(params.aawK.abTw));
      Log.i("MicroMsg.NetSceneGetProfile", "getprofile smcrypto flag: %d", new Object[] { Integer.valueOf(params.aawK.abTw) });
      ct.vv(params.aawK.aang);
      Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(params.aawK.abTh), Integer.valueOf(params.aawK.aang) });
      com.tencent.mm.kernel.h.baE().ban().B(208903, params.aawK.YNO);
      com.tencent.mm.kernel.h.baE().ban().B(274433, params.aawK.aaVT);
      com.tencent.mm.kernel.h.baE().ban().B(274434, params.aawK.aaVS);
      com.tencent.mm.kernel.h.baE().ban().B(274436, params.aawK.abTa);
      MultiProcessMMKV.getMMKV("mmkv_crossprocess_infos").encode("mmkv_key_user_reg_ic", params.aawK.abTa);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acLe, Util.nullAs(params.aawK.kaq, ""));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acPF, params.aawK.abTj);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adge, Integer.valueOf(params.aawK.abnq));
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(params.aawK.abnq) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgf, params.aawK.abTn);
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.BindXMail:%s", new Object[] { params.aawK.abTn });
      Log.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { params.aawK.kaq });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgr, params.aawK.aaWy);
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffix:%s", new Object[] { params.aawK.aaWy });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgx, Integer.valueOf(params.aawK.abzt));
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(params.aawK.abzt) });
      if ((params.aawK.abTi & 0x0) == 0L) {
        break label1193;
      }
      bool = true;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQt, Boolean.valueOf(bool));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQu, Integer.valueOf(params.aawK.abTo));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQv, Integer.valueOf(params.aawK.abTp));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQw, Integer.valueOf(params.aawK.abTq));
      if ((params.aawK.abTi & 0x0) == 0L) {
        break label1199;
      }
      bool = true;
      label946:
      Log.i("MicroMsg.NetSceneGetProfile", "dancy test isCareMode:%s, value:%s, ExtStatus:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(params.aawK.abTi & 0x0), Long.valueOf(params.aawK.abTi) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acQy, Boolean.valueOf(bool));
      if ((params.aawK.abTi & 0x4000000) == 0L) {
        break label1205;
      }
    }
    label1193:
    label1199:
    label1205:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQC, Boolean.valueOf(bool));
      }
      bg.okT.bc("last_login_use_voice", params.aawJ.aaWS);
      Log.i("MicroMsg.NetSceneGetProfile", "handling xagreement configs");
      if ((params.aawK != null) && (params.aawK.abTr != null)) {
        ct.V(params.aawK.abTr.aciD, params.aawK.abTr.aciE);
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgJ, params.aawK.abTs);
      ((aj)MvvmEventCenter.getEvent(aj.class)).publish(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134159);
      return;
      bool = false;
      break;
      bool = false;
      break label946;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q
 * JD-Core Version:    0.7.0.1
 */