package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class o
  extends n
  implements k
{
  private String account;
  private f callback;
  private b rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(134157);
    this.account = paramString;
    b.a locala = new b.a();
    locala.hNM = new bgo();
    locala.hNN = new bgp();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((bgo)this.rr.hNK.hNQ).nDo = paramString;
    AppMethodBeat.o(134157);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(134158);
    if (bt.isNullOrNil(this.account))
    {
      ad.e("MicroMsg.NetSceneGetProfile", "null or empty username");
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
    ad.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bgp)this.rr.hNL.hNQ;
      paramArrayOfByte = new xh();
      paramArrayOfByte.dLE.dLF = paramq.GBU.HGK;
      a.IbL.l(paramArrayOfByte);
      if ((u.aAm().equals(paramq.GBT.GbY.toString())) && (!bt.isNullOrNil(paramq.GBU.FVp))) {
        g.ajC().ajl().set(al.a.IqY, paramq.GBU.FVp);
      }
      ad.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(paramq.GBT.GVq), Integer.valueOf(paramq.GBU.HGE) });
      g.ajC().ajl().set(64, Integer.valueOf(paramq.GBU.Fsl));
      g.ajC().ajl().set(144385, Integer.valueOf(paramq.GBU.HGE));
      g.ajC().ajl().set(40, Integer.valueOf(paramq.GBT.GVq));
      ad.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(paramq.GBT.GVq) });
      PluginAuth.setUserInfoPluginSwitch(paramq.GBT.GVq);
      g.ajC().ajl().set(339975, Integer.valueOf(paramq.GBU.HGM));
      ad.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(paramq.GBU.HGM) });
      g.ajC().ajl().set(al.a.Ivh, Integer.valueOf(paramq.GBU.Gua));
      ad.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(paramq.GBU.HGM), Integer.valueOf(paramq.GBU.Gua) });
      g.ajC().ajl().set(208903, paramq.GBU.FDu);
      g.ajC().ajl().set(274433, paramq.GBU.GUu);
      g.ajC().ajl().set(274434, paramq.GBU.GUt);
      g.ajC().ajl().set(274436, paramq.GBU.HGF);
      g.ajC().ajl().set(al.a.Itl, bt.bI(paramq.GBU.ePI, ""));
      g.ajC().ajl().set(al.a.IxH, paramq.GBU.HGO);
      g.ajC().ajl().set(al.a.IJG, Integer.valueOf(paramq.GBU.Hgy));
      ad.i("MicroMsg.NetSceneGetProfile", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(paramq.GBU.Hgy) });
      g.ajC().ajl().set(al.a.IJH, paramq.GBU.HGT);
      ad.i("MicroMsg.NetSceneGetProfile", "userinfoExt.BindXMail:%s", new Object[] { paramq.GBU.HGT });
      ad.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { paramq.GBU.ePI });
      g.ajC().ajl().set(al.a.IJN, paramq.GBU.GUX);
      ad.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffix:%s", new Object[] { paramq.GBU.GUX });
      g.ajC().ajl().set(al.a.IJS, Integer.valueOf(paramq.GBU.Hqw));
      ad.i("MicroMsg.NetSceneGetProfile", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(paramq.GBU.Hqw) });
      az.hFS.aM("last_login_use_voice", paramq.GBT.GVq);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(aj.getContext().getContentResolver(), "89884a87498ef44f", paramq.GBU.HGL);
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