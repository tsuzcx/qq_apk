package com.tencent.mm.plugin.ext.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  public i callback;
  public String mUrl;
  private d rr;
  public int sOj;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24508);
    this.sOj = -1;
    this.mUrl = null;
    this.mUrl = paramString;
    d.a locala = new d.a();
    locala.iLN = new ya();
    locala.iLO = new yb();
    locala.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
    locala.funcId = 782;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    Log.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[] { paramString });
    paramString = (ya)this.rr.iLK.iLR;
    paramString.URL = this.mUrl;
    paramString.Ljb = paramInt1;
    paramString.Ljc = paramInt2;
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
    params = (yb)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.sOj = params.oUv;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.d.a.a
 * JD-Core Version:    0.7.0.1
 */