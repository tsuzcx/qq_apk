package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class p
  extends n
  implements k
{
  private String account;
  private f callback;
  private b rr;
  
  public p(String paramString)
  {
    AppMethodBeat.i(134157);
    this.account = paramString;
    b.a locala = new b.a();
    locala.hQF = new bhe();
    locala.hQG = new bhf();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((bhe)this.rr.hQD.hQJ).nIJ = paramString;
    AppMethodBeat.o(134157);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(134158);
    if (bu.isNullOrNil(this.account))
    {
      ae.e("MicroMsg.NetSceneGetProfile", "null or empty username");
      AppMethodBeat.o(134158);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(134158);
    return i;
  }
  
  public final int getType()
  {
    return 302;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134159);
    ae.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bhf)this.rr.hQE.hQJ;
      paramArrayOfByte = new xl();
      paramArrayOfByte.dMT.dMU = paramq.GVu.Iax;
      a.IvT.l(paramArrayOfByte);
      if ((v.aAC().equals(paramq.GVt.GuF.toString())) && (!bu.isNullOrNil(paramq.GVu.GnO))) {
        g.ajR().ajA().set(am.a.ILu, paramq.GVu.GnO);
      }
      ae.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(paramq.GVt.HoR), Integer.valueOf(paramq.GVu.Iar) });
      g.ajR().ajA().set(64, Integer.valueOf(paramq.GVu.FKJ));
      g.ajR().ajA().set(144385, Integer.valueOf(paramq.GVu.Iar));
      g.ajR().ajA().set(40, Integer.valueOf(paramq.GVt.HoR));
      ae.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(paramq.GVt.HoR) });
      PluginAuth.setUserInfoPluginSwitch(paramq.GVt.HoR);
      g.ajR().ajA().set(339975, Integer.valueOf(paramq.GVu.Iaz));
      ae.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(paramq.GVu.Iaz) });
      g.ajR().ajA().set(am.a.IPF, Integer.valueOf(paramq.GVu.GNz));
      ae.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(paramq.GVu.Iaz), Integer.valueOf(paramq.GVu.GNz) });
      g.ajR().ajA().set(208903, paramq.GVu.FVP);
      g.ajR().ajA().set(274433, paramq.GVu.HnV);
      g.ajR().ajA().set(274434, paramq.GVu.HnU);
      g.ajR().ajA().set(274436, paramq.GVu.Ias);
      ay.aRW("mmkv_crossprocess_infos").encode("mmkv_key_user_reg_ic", paramq.GVu.Ias);
      g.ajR().ajA().set(am.a.INH, bu.bI(paramq.GVu.eRt, ""));
      g.ajR().ajA().set(am.a.ISf, paramq.GVu.IaB);
      g.ajR().ajA().set(am.a.Jem, Integer.valueOf(paramq.GVu.HzY));
      ae.i("MicroMsg.NetSceneGetProfile", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(paramq.GVu.HzY) });
      g.ajR().ajA().set(am.a.Jen, paramq.GVu.IaG);
      ae.i("MicroMsg.NetSceneGetProfile", "userinfoExt.BindXMail:%s", new Object[] { paramq.GVu.IaG });
      ae.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { paramq.GVu.eRt });
      g.ajR().ajA().set(am.a.Jet, paramq.GVu.Hoy);
      ae.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffix:%s", new Object[] { paramq.GVu.Hoy });
      g.ajR().ajA().set(am.a.Jez, Integer.valueOf(paramq.GVu.HJY));
      ae.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(paramq.GVu.HJY) });
      bb.hIK.aM("last_login_use_voice", paramq.GVt.HoR);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(ak.getContext().getContentResolver(), "89884a87498ef44f", paramq.GVu.Iay);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.p
 * JD-Core Version:    0.7.0.1
 */