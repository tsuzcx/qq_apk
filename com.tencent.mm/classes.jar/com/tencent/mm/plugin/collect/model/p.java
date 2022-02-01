package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.sdk.platformtools.ac;

public final class p
  extends n
  implements k
{
  private g callback;
  private b gvE;
  private cwz oxt;
  
  public p(String paramString)
  {
    AppMethodBeat.i(63838);
    b.a locala = new b.a();
    locala.hvt = new cwz();
    locala.hvu = new cxa();
    locala.funcId = 304;
    locala.uri = "/cgi-bin/micromsg-bin/setpushsound";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.oxt = ((cwz)this.gvE.hvr.hvw);
    this.oxt.ndI = 3;
    this.oxt.FGR = paramString;
    ac.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[] { Integer.valueOf(3), paramString });
    AppMethodBeat.o(63838);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63839);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.p
 * JD-Core Version:    0.7.0.1
 */