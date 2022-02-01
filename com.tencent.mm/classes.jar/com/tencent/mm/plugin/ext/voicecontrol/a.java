package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  public int Kd;
  public String appId;
  public int cWU;
  private g callback;
  public int diR;
  public int gTY;
  int pMA;
  long pMB;
  public int pMv;
  public com.tencent.mm.bx.b pMw;
  public String pMx;
  public fx pMy;
  public fr pMz;
  com.tencent.mm.al.b rr;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, fx paramfx)
  {
    AppMethodBeat.i(24534);
    this.pMA = 5000;
    this.pMB = 0L;
    this.diR = 1;
    this.appId = paramString1;
    this.pMv = paramInt1;
    this.Kd = 1;
    this.gTY = paramInt2;
    this.pMy = paramfx;
    this.pMz = null;
    this.pMx = paramString2;
    if (paramfx != null) {}
    for (;;)
    {
      ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(24534);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, fr paramfr, long paramLong)
  {
    AppMethodBeat.i(24535);
    this.pMA = 5000;
    this.pMB = 0L;
    this.diR = 2;
    this.appId = paramString;
    this.pMv = paramInt;
    this.Kd = 1;
    this.pMy = null;
    this.pMz = paramfr;
    this.pMB = paramLong;
    ad.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(24535);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(24537);
    this.callback = paramg;
    paramg = new b.a();
    paramg.funcId = 985;
    paramg.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    paramg.gUU = new fs();
    paramg.gUV = new ft();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.atI();
    paramg = (fs)this.rr.gUS.gUX;
    paramg.OpCode = this.diR;
    paramg.hnC = this.appId;
    paramg.CAt = this.pMv;
    paramg.CAu = this.Kd;
    paramg.CAv = this.pMy;
    paramg.CAw = this.pMz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */