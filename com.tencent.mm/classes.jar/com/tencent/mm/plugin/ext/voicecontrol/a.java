package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  public int KY;
  public String appId;
  public int cUq;
  private g callback;
  public int dgm;
  public int hux;
  public int qvd;
  public com.tencent.mm.bw.b qve;
  public String qvf;
  public fz qvg;
  public ft qvh;
  int qvi;
  long qvj;
  com.tencent.mm.ak.b rr;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, fz paramfz)
  {
    AppMethodBeat.i(24534);
    this.qvi = 5000;
    this.qvj = 0L;
    this.dgm = 1;
    this.appId = paramString1;
    this.qvd = paramInt1;
    this.KY = 1;
    this.hux = paramInt2;
    this.qvg = paramfz;
    this.qvh = null;
    this.qvf = paramString2;
    if (paramfz != null) {}
    for (;;)
    {
      ac.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(24534);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, ft paramft, long paramLong)
  {
    AppMethodBeat.i(24535);
    this.qvi = 5000;
    this.qvj = 0L;
    this.dgm = 2;
    this.appId = paramString;
    this.qvd = paramInt;
    this.KY = 1;
    this.qvg = null;
    this.qvh = paramft;
    this.qvj = paramLong;
    ac.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(24535);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(24537);
    this.callback = paramg;
    paramg = new b.a();
    paramg.funcId = 985;
    paramg.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    paramg.hvt = new fu();
    paramg.hvu = new fv();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.aAz();
    paramg = (fu)this.rr.hvr.hvw;
    paramg.OpCode = this.dgm;
    paramg.hOf = this.appId;
    paramg.DSP = this.qvd;
    paramg.DSQ = this.KY;
    paramg.DSR = this.qvg;
    paramg.DSS = this.qvh;
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
      ac.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    while (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(24536);
      return;
      ac.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    ac.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
    AppMethodBeat.o(24536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */