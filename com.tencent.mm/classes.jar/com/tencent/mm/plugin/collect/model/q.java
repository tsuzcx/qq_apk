package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private d kwO;
  private egk tVC;
  
  public q(String paramString)
  {
    AppMethodBeat.i(63838);
    d.a locala = new d.a();
    locala.lBU = new egk();
    locala.lBV = new egl();
    locala.funcId = 304;
    locala.uri = "/cgi-bin/micromsg-bin/setpushsound";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.tVC = ((egk)d.b.b(this.kwO.lBR));
    this.tVC.rWu = 3;
    this.tVC.Ujf = paramString;
    Log.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[] { Integer.valueOf(3), paramString });
    AppMethodBeat.o(63838);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63839);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.q
 * JD-Core Version:    0.7.0.1
 */