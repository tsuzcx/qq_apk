package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class o
  extends n
  implements k
{
  private String account;
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(134157);
    this.account = paramString;
    b.a locala = new b.a();
    locala.hvt = new bck();
    locala.hvu = new bcl();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((bck)this.rr.hvr.hvw).ncR = paramString;
    AppMethodBeat.o(134157);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(134158);
    if (bs.isNullOrNil(this.account))
    {
      ac.e("MicroMsg.NetSceneGetProfile", "null or empty username");
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
    ac.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bcl)this.rr.hvs.hvw;
      paramArrayOfByte = new wo();
      paramArrayOfByte.dzs.dzt = paramq.ESA.FVW;
      a.GpY.l(paramArrayOfByte);
      if ((u.axw().equals(paramq.ESz.EuE.toString())) && (!bs.isNullOrNil(paramq.ESA.Eog))) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEF, paramq.ESA.Eog);
      }
      ac.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(paramq.ESz.FlH), Integer.valueOf(paramq.ESA.FVQ) });
      com.tencent.mm.kernel.g.agR().agA().set(64, Integer.valueOf(paramq.ESA.DNg));
      com.tencent.mm.kernel.g.agR().agA().set(144385, Integer.valueOf(paramq.ESA.FVQ));
      com.tencent.mm.kernel.g.agR().agA().set(40, Integer.valueOf(paramq.ESz.FlH));
      ac.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(paramq.ESz.FlH) });
      PluginAuth.setUserInfoPluginSwitch(paramq.ESz.FlH);
      com.tencent.mm.kernel.g.agR().agA().set(339975, Integer.valueOf(paramq.ESA.FVY));
      ac.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(paramq.ESA.FVY) });
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIP, Integer.valueOf(paramq.ESA.EKX));
      ac.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(paramq.ESA.FVY), Integer.valueOf(paramq.ESA.EKX) });
      com.tencent.mm.kernel.g.agR().agA().set(208903, paramq.ESA.DXY);
      com.tencent.mm.kernel.g.agR().agA().set(274433, paramq.ESA.FkM);
      com.tencent.mm.kernel.g.agR().agA().set(274434, paramq.ESA.FkL);
      com.tencent.mm.kernel.g.agR().agA().set(274436, paramq.ESA.FVR);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGT, bs.bG(paramq.ESA.eyk, ""));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLp, paramq.ESA.FWa);
      ac.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { paramq.ESA.eyk });
      ay.hnA.aL("last_login_use_voice", paramq.ESz.FlH);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(ai.getContext().getContentResolver(), "89884a87498ef44f", paramq.ESA.FVX);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.o
 * JD-Core Version:    0.7.0.1
 */