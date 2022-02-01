package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.cr;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.protocal.protobuf.fff;
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
    locala.iLN = new btc();
    locala.iLO = new btd();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((btc)this.rr.iLK.iLR).UserName = paramString;
    AppMethodBeat.o(134157);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
      params = (btd)this.rr.iLL.iLR;
      paramArrayOfByte = new ym();
      paramArrayOfByte.eeL.eeM = params.LZO.NmE;
      EventCenter.instance.publish(paramArrayOfByte);
      if ((z.aTY().equals(params.LZN.Lqk.toString())) && (!Util.isNullOrNil(params.LZO.Lis))) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTv, params.LZO.Lis);
      }
      Log.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(params.LZN.Mwm), Integer.valueOf(params.LZO.Nmy) });
      com.tencent.mm.kernel.g.aAh().azQ().set(64, Integer.valueOf(params.LZO.KEf));
      com.tencent.mm.kernel.g.aAh().azQ().set(144385, Integer.valueOf(params.LZO.Nmy));
      com.tencent.mm.kernel.g.aAh().azQ().set(40, Integer.valueOf(params.LZN.Mwm));
      Log.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(params.LZN.Mwm) });
      PluginAuth.setUserInfoPluginSwitch(params.LZN.Mwm);
      com.tencent.mm.kernel.g.aAh().azQ().set(339975, Integer.valueOf(params.LZO.NmG));
      Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(params.LZO.NmG) });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXG, Integer.valueOf(params.LZO.LRD));
      cr.so(params.LZO.LRD);
      Log.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(params.LZO.NmG), Integer.valueOf(params.LZO.LRD) });
      com.tencent.mm.kernel.g.aAh().azQ().set(208903, params.LZO.KPA);
      com.tencent.mm.kernel.g.aAh().azQ().set(274433, params.LZO.Mvp);
      com.tencent.mm.kernel.g.aAh().azQ().set(274434, params.LZO.Mvo);
      com.tencent.mm.kernel.g.aAh().azQ().set(274436, params.LZO.Nmz);
      MultiProcessMMKV.getMMKV("mmkv_crossprocess_infos").encode("mmkv_key_user_reg_ic", params.LZO.Nmz);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVK, Util.nullAs(params.LZO.fuW, ""));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oah, params.LZO.NmI);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnT, Integer.valueOf(params.LZO.MKH));
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(params.LZO.MKH) });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnU, params.LZO.NmM);
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.BindXMail:%s", new Object[] { params.LZO.NmM });
      Log.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { params.LZO.fuW });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oob, params.LZO.MvT);
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffix:%s", new Object[] { params.LZO.MvT });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ooh, Integer.valueOf(params.LZO.MVK));
      Log.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(params.LZO.MVK) });
      if ((params.LZO.NmH & 0x0) == 0L) {
        break label1045;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaV, Boolean.valueOf(bool));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaW, Integer.valueOf(params.LZO.NmN));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaX, Integer.valueOf(params.LZO.NmO));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaY, Integer.valueOf(params.LZO.NmP));
      EventCenter.instance.publish(new yu());
      bf.iDu.aO("last_login_use_voice", params.LZN.Mwm);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(MMApplicationContext.getContext().getContentResolver(), "89884a87498ef44f", params.LZO.NmF);
      }
      Log.i("MicroMsg.NetSceneGetProfile", "handling xagreement configs");
      if ((params.LZO != null) && (params.LZO.NmQ != null)) {
        cr.z(params.LZO.NmQ.NAz, params.LZO.NmQ.NAA);
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oop, params.LZO.NmR);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(134159);
      return;
      label1045:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.p
 * JD-Core Version:    0.7.0.1
 */