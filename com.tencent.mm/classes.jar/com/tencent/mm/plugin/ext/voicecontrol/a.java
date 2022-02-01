package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  public int MQ;
  public String appId;
  private f callback;
  public int dgI;
  public int dsO;
  public int hPI;
  public int rmW;
  public com.tencent.mm.bw.b rmX;
  public String rmY;
  public gg rmZ;
  public ga rna;
  int rnb;
  long rnc;
  com.tencent.mm.ak.b rr;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, gg paramgg)
  {
    AppMethodBeat.i(24534);
    this.rnb = 5000;
    this.rnc = 0L;
    this.dsO = 1;
    this.appId = paramString1;
    this.rmW = paramInt1;
    this.MQ = 1;
    this.hPI = paramInt2;
    this.rmZ = paramgg;
    this.rna = null;
    this.rmY = paramString2;
    if (paramgg != null) {}
    for (;;)
    {
      ae.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(24534);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, ga paramga, long paramLong)
  {
    AppMethodBeat.i(24535);
    this.rnb = 5000;
    this.rnc = 0L;
    this.dsO = 2;
    this.appId = paramString;
    this.rmW = paramInt;
    this.MQ = 1;
    this.rmZ = null;
    this.rna = paramga;
    this.rnc = paramLong;
    ae.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(24535);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24537);
    this.callback = paramf;
    paramf = new b.a();
    paramf.funcId = 985;
    paramf.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    paramf.hQF = new gb();
    paramf.hQG = new gc();
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
    paramf = (gb)this.rr.hQD.hQJ;
    paramf.OpCode = this.dsO;
    paramf.ikm = this.appId;
    paramf.FQG = this.rmW;
    paramf.FQH = this.MQ;
    paramf.FQI = this.rmZ;
    paramf.FQJ = this.rna;
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
      ae.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    while (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(24536);
      return;
      ae.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    ae.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
    AppMethodBeat.o(24536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */