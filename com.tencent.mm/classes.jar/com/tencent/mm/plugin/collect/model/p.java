package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.protocal.protobuf.dwl;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends q
  implements m
{
  private i callback;
  private d hJu;
  private dwk qwB;
  
  public p(String paramString)
  {
    AppMethodBeat.i(63838);
    d.a locala = new d.a();
    locala.iLN = new dwk();
    locala.iLO = new dwl();
    locala.funcId = 304;
    locala.uri = "/cgi-bin/micromsg-bin/setpushsound";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.qwB = ((dwk)this.hJu.iLK.iLR);
    this.qwB.oUv = 3;
    this.qwB.MWK = paramString;
    Log.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[] { Integer.valueOf(3), paramString });
    AppMethodBeat.o(63838);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63839);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(63839);
    return i;
  }
  
  public final int getType()
  {
    return 304;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63840);
    Log.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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