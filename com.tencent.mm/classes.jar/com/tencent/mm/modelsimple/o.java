package com.tencent.mm.modelsimple;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class o
  extends m
  implements k
{
  private String account;
  private f callback;
  private b rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(123433);
    this.account = paramString;
    b.a locala = new b.a();
    locala.fsX = new aol();
    locala.fsY = new aom();
    locala.uri = "/cgi-bin/micromsg-bin/getprofile";
    locala.funcId = 302;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((aol)this.rr.fsV.fta).jJA = paramString;
    AppMethodBeat.o(123433);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(123434);
    if (bo.isNullOrNil(this.account))
    {
      ab.e("MicroMsg.NetSceneGetProfile", "null or empty username");
      AppMethodBeat.o(123434);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(123434);
    return i;
  }
  
  public final int getType()
  {
    return 302;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123435);
    ab.d("MicroMsg.NetSceneGetProfile", "get profile ret: errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aom)this.rr.fsW.fta;
      paramArrayOfByte = new ue();
      paramArrayOfByte.cKH.cKI = paramq.xep.xYn;
      a.ymk.l(paramArrayOfByte);
      if ((r.Zn().equals(paramq.xeo.wOT.toString())) && (!bo.isNullOrNil(paramq.xep.wJr))) {
        g.RL().Ru().set(ac.a.yyw, paramq.xep.wJr);
      }
      ab.d("MicroMsg.NetSceneGetProfile", "summersafecdn resp.UserInfo.PluginSwitch[%d], GrayscaleFlag[%d]", new Object[] { Integer.valueOf(paramq.xeo.xun), Integer.valueOf(paramq.xep.xYh) });
      g.RL().Ru().set(64, Integer.valueOf(paramq.xep.wmw));
      g.RL().Ru().set(144385, Integer.valueOf(paramq.xep.xYh));
      g.RL().Ru().set(40, Integer.valueOf(paramq.xeo.xun));
      ab.i("MicroMsg.NetSceneGetProfile", "getprofile PluginSwitch: %d", new Object[] { Integer.valueOf(paramq.xeo.xun) });
      PluginAuth.setUserInfoPluginSwitch(paramq.xeo.xun);
      g.RL().Ru().set(339975, Integer.valueOf(paramq.xep.xYp));
      ab.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d", new Object[] { Integer.valueOf(paramq.xep.xYp) });
      g.RL().Ru().set(ac.a.yCE, Integer.valueOf(paramq.xep.wYk));
      ab.i("MicroMsg.NetSceneGetProfile", "hy: getprofile pay wallet type: %d %d", new Object[] { Integer.valueOf(paramq.xep.xYp), Integer.valueOf(paramq.xep.wYk) });
      g.RL().Ru().set(208903, paramq.xep.wvt);
      g.RL().Ru().set(274433, paramq.xep.xtw);
      g.RL().Ru().set(274434, paramq.xep.xtv);
      g.RL().Ru().set(274436, paramq.xep.xYi);
      g.RL().Ru().set(ac.a.yAI, bo.bf(paramq.xep.dqY, ""));
      g.RL().Ru().set(ac.a.yET, paramq.xep.xYr);
      ab.d("MicroMsg.NetSceneGetProfile", "weidianInfo:%s", new Object[] { paramq.xep.dqY });
      av.flM.ao("last_login_use_voice", paramq.xeo.xun);
      if (Build.VERSION.SDK_INT < 23) {
        Settings.System.putString(ah.getContext().getContentResolver(), "89884a87498ef44f", paramq.xep.xYo);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(123435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.o
 * JD-Core Version:    0.7.0.1
 */