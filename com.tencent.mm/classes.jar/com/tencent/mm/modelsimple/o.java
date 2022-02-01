package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class o
  extends n
  implements k
{
  private String account;
  private com.tencent.mm.al.g callback;
  private b rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(134157);
    this.account = paramString;
    b.a locala = new b.a();
    locala.gUU = new ays();
    locala.gUV = new ayt();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((ays)this.rr.gUS.gUX).mAQ = paramString;
    AppMethodBeat.o(134157);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(134158);
    if (bt.isNullOrNil(this.account))
    {
      ad.e("MicroMsg.NetSceneGetProfile", "null or empty username");
      AppMethodBeat.o(134158);
      return -1;
    }
    this.callback = paramg;
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
    ad.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ayt)this.rr.gUT.gUX;
      paramArrayOfByte = new wd();
      paramArrayOfByte.dBE.dBF = paramq.Dxf.EyU;
      a.ESL.l(paramArrayOfByte);
      if ((u.aqG().equals(paramq.Dxe.Dby.toString())) && (!bt.isNullOrNil(paramq.Dxf.CVw))) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgR, paramq.Dxf.CVw);
      }
      ad.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(paramq.Dxe.DPq), Integer.valueOf(paramq.Dxf.EyO) });
      com.tencent.mm.kernel.g.afB().afk().set(64, Integer.valueOf(paramq.Dxf.CuL));
      com.tencent.mm.kernel.g.afB().afk().set(144385, Integer.valueOf(paramq.Dxf.EyO));
      com.tencent.mm.kernel.g.afB().afk().set(40, Integer.valueOf(paramq.Dxe.DPq));
      ad.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(paramq.Dxe.DPq) });
      PluginAuth.setUserInfoPluginSwitch(paramq.Dxe.DPq);
      com.tencent.mm.kernel.g.afB().afk().set(339975, Integer.valueOf(paramq.Dxf.EyW));
      ad.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(paramq.Dxf.EyW) });
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fla, Integer.valueOf(paramq.Dxf.DpU));
      ad.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(paramq.Dxf.EyW), Integer.valueOf(paramq.Dxf.DpU) });
      com.tencent.mm.kernel.g.afB().afk().set(208903, paramq.Dxf.CFy);
      com.tencent.mm.kernel.g.afB().afk().set(274433, paramq.Dxf.DOv);
      com.tencent.mm.kernel.g.afB().afk().set(274434, paramq.Dxf.DOu);
      com.tencent.mm.kernel.g.afB().afk().set(274436, paramq.Dxf.EyP);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fje, bt.by(paramq.Dxf.evN, ""));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FnA, paramq.Dxf.EyY);
      ad.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { paramq.Dxf.evN });
      ay.gNa.aD("last_login_use_voice", paramq.Dxe.DPq);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(aj.getContext().getContentResolver(), "89884a87498ef44f", paramq.Dxf.EyV);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.o
 * JD-Core Version:    0.7.0.1
 */