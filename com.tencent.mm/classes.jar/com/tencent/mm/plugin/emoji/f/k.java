package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends q
  implements m
{
  private i heq;
  public String rcT;
  private String rcU;
  public final d rr;
  
  public k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108692);
    d.a locala = new d.a();
    locala.iLN = new bmp();
    locala.iLO = new bmq();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
    locala.funcId = 368;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcT = paramString1;
    this.rcU = paramString2;
    AppMethodBeat.o(108692);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108693);
    this.heq = parami;
    parami = (bmp)this.rr.iLK.iLR;
    parami.LVq = this.rcT;
    parami.Md5 = this.rcU;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108693);
    return i;
  }
  
  public final int getType()
  {
    return 368;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108694);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.k
 * JD-Core Version:    0.7.0.1
 */