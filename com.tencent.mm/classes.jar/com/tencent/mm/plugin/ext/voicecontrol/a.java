package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  public String appId;
  public int bPt;
  private i callback;
  public int dQ;
  public int fCN;
  public int lAW;
  d rr;
  public gb wuA;
  int wuB;
  long wuC;
  public int wuw;
  public b wux;
  public String wuy;
  public gh wuz;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, gh paramgh)
  {
    AppMethodBeat.i(24534);
    this.wuB = 5000;
    this.wuC = 0L;
    this.fCN = 1;
    this.appId = paramString1;
    this.wuw = paramInt1;
    this.dQ = 1;
    this.lAW = paramInt2;
    this.wuz = paramgh;
    this.wuA = null;
    this.wuy = paramString2;
    if (paramgh != null) {}
    for (;;)
    {
      Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(24534);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, gb paramgb, long paramLong)
  {
    AppMethodBeat.i(24535);
    this.wuB = 5000;
    this.wuC = 0L;
    this.fCN = 2;
    this.appId = paramString;
    this.wuw = paramInt;
    this.dQ = 1;
    this.wuz = null;
    this.wuA = paramgb;
    this.wuC = paramLong;
    Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(24535);
  }
  
  public static int dhI()
  {
    AppMethodBeat.i(269502);
    int i = Util.nowMilliSecond().hashCode();
    if (i != -2147483648)
    {
      i = Math.abs(i);
      AppMethodBeat.o(269502);
      return i;
    }
    AppMethodBeat.o(269502);
    return -2147483648;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(24537);
    this.callback = parami;
    parami = new d.a();
    parami.funcId = 985;
    parami.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    parami.lBU = new gc();
    parami.lBV = new gd();
    parami.lBW = 0;
    parami.respCmdId = 0;
    this.rr = parami.bgN();
    parami = (gc)d.b.b(this.rr.lBR);
    parami.RLe = this.fCN;
    parami.lVG = this.appId;
    parami.RLf = this.wuw;
    parami.RLg = this.dQ;
    parami.RLh = this.wuz;
    parami.RLi = this.wuA;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(24537);
    return i;
  }
  
  public final int getType()
  {
    return 985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24536);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (params != null)) {
      Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    while (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(24536);
      return;
      Log.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    Log.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
    AppMethodBeat.o(24536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */