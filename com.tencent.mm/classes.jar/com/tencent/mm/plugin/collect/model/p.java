package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.sdk.platformtools.ad;

public final class p
  extends n
  implements k
{
  private f callback;
  private b gPp;
  private dcm paO;
  
  public p(String paramString)
  {
    AppMethodBeat.i(63838);
    b.a locala = new b.a();
    locala.hNM = new dcm();
    locala.hNN = new dcn();
    locala.funcId = 304;
    locala.uri = "/cgi-bin/micromsg-bin/setpushsound";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.paO = ((dcm)this.gPp.hNK.hNQ);
    this.paO.nEf = 3;
    this.paO.Hrz = paramString;
    ad.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[] { Integer.valueOf(3), paramString });
    AppMethodBeat.o(63838);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63839);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(63839);
    return i;
  }
  
  public final int getType()
  {
    return 304;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63840);
    ad.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.p
 * JD-Core Version:    0.7.0.1
 */