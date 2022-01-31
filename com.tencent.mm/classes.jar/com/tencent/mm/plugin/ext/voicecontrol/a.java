package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  public int Dm;
  public String appId;
  private f callback;
  public int chT;
  public int ctW;
  public int fsd;
  public int mfJ;
  public com.tencent.mm.bv.b mfK;
  public String mfL;
  public ff mfM;
  public ez mfN;
  int mfO;
  long mfP;
  com.tencent.mm.ai.b rr;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, ff paramff)
  {
    AppMethodBeat.i(20457);
    this.mfO = 5000;
    this.mfP = 0L;
    this.ctW = 1;
    this.appId = paramString1;
    this.mfJ = paramInt1;
    this.Dm = 1;
    this.fsd = paramInt2;
    this.mfM = paramff;
    this.mfN = null;
    this.mfL = paramString2;
    if (paramff != null) {}
    for (;;)
    {
      ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.FALSE });
      AppMethodBeat.o(20457);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, ez paramez, long paramLong)
  {
    AppMethodBeat.i(20458);
    this.mfO = 5000;
    this.mfP = 0L;
    this.ctW = 2;
    this.appId = paramString;
    this.mfJ = paramInt;
    this.Dm = 1;
    this.mfM = null;
    this.mfN = paramez;
    this.mfP = paramLong;
    ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE });
    AppMethodBeat.o(20458);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20460);
    this.callback = paramf;
    paramf = new b.a();
    paramf.funcId = 985;
    paramf.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    paramf.fsX = new fa();
    paramf.fsY = new fb();
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    paramf = (fa)this.rr.fsV.fta;
    paramf.OpCode = this.ctW;
    paramf.fKw = this.appId;
    paramf.wrf = this.mfJ;
    paramf.wrg = this.Dm;
    paramf.wrh = this.mfM;
    paramf.wri = this.mfN;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20460);
    return i;
  }
  
  public final int getType()
  {
    return 985;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20459);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramq != null)) {
      ab.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    while (this.callback != null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20459);
      return;
      ab.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    ab.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
    AppMethodBeat.o(20459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.voicecontrol.a
 * JD-Core Version:    0.7.0.1
 */