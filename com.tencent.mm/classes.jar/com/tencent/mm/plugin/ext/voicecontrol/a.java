package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  public int Na;
  public String appId;
  public int bNu;
  private i callback;
  public int dJY;
  public int iKP;
  d rr;
  public int sOB;
  public b sOC;
  public String sOD;
  public gt sOE;
  public gn sOF;
  int sOG;
  long sOH;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, gt paramgt)
  {
    AppMethodBeat.i(24534);
    this.sOG = 5000;
    this.sOH = 0L;
    this.dJY = 1;
    this.appId = paramString1;
    this.sOB = paramInt1;
    this.Na = 1;
    this.iKP = paramInt2;
    this.sOE = paramgt;
    this.sOF = null;
    this.sOD = paramString2;
    if (paramgt != null) {}
    for (;;)
    {
      Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(24534);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, gn paramgn, long paramLong)
  {
    AppMethodBeat.i(24535);
    this.sOG = 5000;
    this.sOH = 0L;
    this.dJY = 2;
    this.appId = paramString;
    this.sOB = paramInt;
    this.Na = 1;
    this.sOE = null;
    this.sOF = paramgn;
    this.sOH = paramLong;
    Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(24535);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(24537);
    this.callback = parami;
    parami = new d.a();
    parami.funcId = 985;
    parami.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    parami.iLN = new go();
    parami.iLO = new gp();
    parami.iLP = 0;
    parami.respCmdId = 0;
    this.rr = parami.aXF();
    parami = (go)this.rr.iLK.iLR;
    parami.OpCode = this.dJY;
    parami.jfi = this.appId;
    parami.KKn = this.sOB;
    parami.KKo = this.Na;
    parami.KKp = this.sOE;
    parami.KKq = this.sOF;
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