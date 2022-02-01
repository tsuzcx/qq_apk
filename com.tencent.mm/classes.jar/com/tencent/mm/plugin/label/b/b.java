package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.al.b rr;
  public String sLW;
  
  public b(String paramString)
  {
    AppMethodBeat.i(26146);
    this.sLW = null;
    b.a locala = new b.a();
    locala.gUU = new zx();
    locala.gUV = new zy();
    locala.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
    locala.funcId = 636;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.sLW = paramString;
    AppMethodBeat.o(26146);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26148);
    this.callback = paramg;
    zx localzx = (zx)this.rr.gUS.gUX;
    localzx.DbA = this.sLW;
    if ((this.sLW != null) && (!bt.isNullOrNil(this.sLW)))
    {
      localzx.DbA = this.sLW;
      localzx.DbA = this.sLW;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26148);
      return i;
    }
    ad.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
    paramg.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
    AppMethodBeat.o(26148);
    return 0;
  }
  
  public final int getType()
  {
    return 636;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26147);
    ad.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.b
 * JD-Core Version:    0.7.0.1
 */