package com.tencent.mm.plugin.ext.qrcode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  public h callback;
  public String mUrl;
  private c rr;
  public int zQk;
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24508);
    this.zQk = -1;
    this.mUrl = null;
    this.mUrl = paramString;
    c.a locala = new c.a();
    locala.otE = new aad();
    locala.otF = new aae();
    locala.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
    locala.funcId = 782;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    Log.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", new Object[] { paramString });
    paramString = (aad)c.b.b(this.rr.otB);
    paramString.URL = this.mUrl;
    paramString.ZiC = paramInt1;
    paramString.ZiD = paramInt2;
    AppMethodBeat.o(24508);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(24509);
    this.callback = paramh;
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
    params = (aae)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.zQk = params.vhJ;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.qrcode.a.a
 * JD-Core Version:    0.7.0.1
 */