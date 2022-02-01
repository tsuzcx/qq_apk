package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends p
  implements m
{
  public String appId;
  private h callback;
  public int dIY;
  public int dQ;
  public int hHC;
  public int osy;
  c rr;
  public int zQC;
  public b zQD;
  public String zQE;
  public ha zQF;
  public gu zQG;
  int zQH;
  long zQI;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, ha paramha)
  {
    AppMethodBeat.i(24534);
    this.zQH = 5000;
    this.zQI = 0L;
    this.hHC = 1;
    this.appId = paramString1;
    this.zQC = paramInt1;
    this.dQ = 1;
    this.osy = paramInt2;
    this.zQF = paramha;
    this.zQG = null;
    this.zQE = paramString2;
    if (paramha != null) {}
    for (;;)
    {
      Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(24534);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, gu paramgu, long paramLong)
  {
    AppMethodBeat.i(24535);
    this.zQH = 5000;
    this.zQI = 0L;
    this.hHC = 2;
    this.appId = paramString;
    this.zQC = paramInt;
    this.dQ = 1;
    this.zQF = null;
    this.zQG = paramgu;
    this.zQI = paramLong;
    Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(24535);
  }
  
  public static int dOt()
  {
    AppMethodBeat.i(274322);
    int i = Util.nowMilliSecond().hashCode();
    if (i != -2147483648)
    {
      i = Math.abs(i);
      AppMethodBeat.o(274322);
      return i;
    }
    AppMethodBeat.o(274322);
    return -2147483648;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(24537);
    this.callback = paramh;
    paramh = new c.a();
    paramh.funcId = 985;
    paramh.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    paramh.otE = new gv();
    paramh.otF = new gw();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
    paramh = (gv)c.b.b(this.rr.otB);
    paramh.YIq = this.hHC;
    paramh.oOI = this.appId;
    paramh.YIr = this.zQC;
    paramh.YIs = this.dQ;
    paramh.YIt = this.zQF;
    paramh.YIu = this.zQG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */