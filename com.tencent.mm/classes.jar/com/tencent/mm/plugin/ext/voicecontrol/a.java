package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  public int MQ;
  public String appId;
  private f callback;
  public int dfG;
  public int drI;
  public int hMP;
  public int reT;
  public com.tencent.mm.bx.b reU;
  public String reV;
  public gg reW;
  public ga reX;
  int reY;
  long reZ;
  com.tencent.mm.al.b rr;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, gg paramgg)
  {
    AppMethodBeat.i(24534);
    this.reY = 5000;
    this.reZ = 0L;
    this.drI = 1;
    this.appId = paramString1;
    this.reT = paramInt1;
    this.MQ = 1;
    this.hMP = paramInt2;
    this.reW = paramgg;
    this.reX = null;
    this.reV = paramString2;
    if (paramgg != null) {}
    for (;;)
    {
      ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(24534);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, ga paramga, long paramLong)
  {
    AppMethodBeat.i(24535);
    this.reY = 5000;
    this.reZ = 0L;
    this.drI = 2;
    this.appId = paramString;
    this.reT = paramInt;
    this.MQ = 1;
    this.reW = null;
    this.reX = paramga;
    this.reZ = paramLong;
    ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(24535);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24537);
    this.callback = paramf;
    paramf = new b.a();
    paramf.funcId = 985;
    paramf.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    paramf.hNM = new gb();
    paramf.hNN = new gc();
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDC();
    paramf = (gb)this.rr.hNK.hNQ;
    paramf.OpCode = this.drI;
    paramf.iht = this.appId;
    paramf.Fyi = this.reT;
    paramf.Fyj = this.MQ;
    paramf.Fyk = this.reW;
    paramf.Fyl = this.reX;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24537);
    return i;
  }
  
  public final int getType()
  {
    return 985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24536);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramq != null)) {
      ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    while (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(24536);
      return;
      ad.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    ad.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
    AppMethodBeat.o(24536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */