package com.tencent.mm.plugin.ext.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  public i callback;
  public String mUrl;
  private d rr;
  public int wue;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24508);
    this.wue = -1;
    this.mUrl = null;
    this.mUrl = paramString;
    d.a locala = new d.a();
    locala.lBU = new yg();
    locala.lBV = new yh();
    locala.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
    locala.funcId = 782;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    Log.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[] { paramString });
    paramString = (yg)d.b.b(this.rr.lBR);
    paramString.URL = this.mUrl;
    paramString.Sks = paramInt1;
    paramString.Skt = paramInt2;
    AppMethodBeat.o(24508);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(24509);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(24509);
    return i;
  }
  
  public final int getType()
  {
    return 782;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24510);
    Log.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (yh)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.wue = params.rWu;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.a.a
 * JD-Core Version:    0.7.0.1
 */