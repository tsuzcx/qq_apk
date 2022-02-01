package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aab;
import com.tencent.mm.f.a.zt;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cs;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eza;
import com.tencent.mm.protocal.protobuf.fqg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class p
  extends q
  implements m
{
  private String account;
  private i callback;
  private d rr;
  
  public p(String paramString)
  {
    AppMethodBeat.i(134157);
    this.account = paramString;
    d.a locala = new d.a();
    locala.lBU = new cau();
    locala.lBV = new cav();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((cau)d.b.b(this.rr.lBR)).UserName = paramString;
    AppMethodBeat.o(134157);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(134158);
    if (Util.isNullOrNil(this.account))
    {
      Log.e("MicroMsg.NetSceneGetProfile", "null or empty username");
      AppMethodBeat.o(134158);
      return -1;
    }
    this.callback = parami;
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
    boolean bool = true;
    AppMethodBeat.i(134159);
    Log.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cav)d.c.b(this.rr.lBS);
      paramArrayOfByte = new zt();
      paramArrayOfByte.fZa.fZb = params.Tjh.Uzq;
      EventCenter.instance.publish(paramArrayOfByte);
      if ((z.bcZ().equals(params.Tjg.SrH.toString())) && (!Util.isNullOrNil(params.Tjh.SjJ))) {
        h.aHG().aHp().set(ar.a.Vhv, params.Tjh.SjJ);
      }
      Log.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(params.Tjg.THk), Integer.valueOf(params.Tjh.Uzk) });
      h.aHG().aHp().i(64, Integer.valueOf(params.Tjh.RFx));
      h.aHG().aHp().i(144385, Integer.valueOf(params.Tjh.Uzk));
      h.aHG().aHp().i(40, Integer.valueOf(params.Tjg.THk));
      Log.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(params.Tjg.THk) });
      PluginAuth.setUserInfoPluginSwitch(params.Tjg.THk);
      h.aHG().aHp().i(339975, Integer.valueOf(params.Tjh.Uzs));
      Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(params.Tjh.Uzs) });
      h.aHG().aHp().set(ar.a.VlG, Integer.valueOf(params.Tjh.Tai));
      cs.vl(params.Tjh.Tai);
      Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(params.Tjh.Uzs), Integer.valueOf(params.Tjh.Tai) });
      h.aHG().aHp().i(208903, params.Tjh.RQy);
      h.aHG().aHp().i(274433, params.Tjh.TGn);
      h.aHG().aHp().i(274434, params.Tjh.TGm);
      h.aHG().aHp().i(274436, params.Tjh.Uzl);
      MultiProcessMMKV.getMMKV("mmkv_crossprocess_infos").encode("mmkv_key_user_reg_ic", params.Tjh.Uzl);
      h.aHG().aHp().set(ar.a.VjK, Util.nullAs(params.Tjh.hDv, ""));
      h.aHG().aHp().set(ar.a.Voj, params.Tjh.Uzu);
      h.aHG().aHp().set(ar.a.VDj, Integer.valueOf(params.Tjh.TWB));
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(params.Tjh.TWB) });
      h.aHG().aHp().set(ar.a.VDk, params.Tjh.Uzy);
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.BindXMail:%s", new Object[] { params.Tjh.Uzy });
      Log.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { params.Tjh.hDv });
      h.aHG().aHp().set(ar.a.VDu, params.Tjh.TGR);
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffix:%s", new Object[] { params.Tjh.TGR });
      h.aHG().aHp().set(ar.a.VDA, Integer.valueOf(params.Tjh.Uid));
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(params.Tjh.Uid) });
      if ((params.Tjh.Uzt & 0x0) == 0L) {
        break label1046;
      }
    }
    for (;;)
    {
      h.aHG().aHp().set(ar.a.VoX, Boolean.valueOf(bool));
      h.aHG().aHp().set(ar.a.VoY, Integer.valueOf(params.Tjh.Uzz));
      h.aHG().aHp().set(ar.a.VoZ, Integer.valueOf(params.Tjh.UzA));
      h.aHG().aHp().set(ar.a.Vpa, Integer.valueOf(params.Tjh.UzB));
      EventCenter.instance.publish(new aab());
      bg.ltv.aS("last_login_use_voice", params.Tjg.THk);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(MMApplicationContext.getContext().getContentResolver(), "89884a87498ef44f", params.Tjh.Uzr);
      }
      Log.i("MicroMsg.NetSceneGetProfile", "handling xagreement configs");
      if ((params.Tjh != null) && (params.Tjh.UzC != null)) {
        cs.z(params.Tjh.UzC.UOb, params.Tjh.UzC.UOc);
      }
      h.aHG().aHp().set(ar.a.VDI, params.Tjh.UzD);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134159);
      return;
      label1046:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.p
 * JD-Core Version:    0.7.0.1
 */