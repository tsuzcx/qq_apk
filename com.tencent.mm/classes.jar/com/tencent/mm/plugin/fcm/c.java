package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(127575);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eb();
    ((d.a)localObject).lBV = new ec();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/androidfcmreg";
    ((d.a)localObject).funcId = 216;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (eb)d.b.b(this.rr.lBR);
    ((eb)localObject).RJs = paramString;
    ((eb)localObject).CNb = 1;
    AppMethodBeat.o(127575);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127576);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(127576);
    return i;
  }
  
  public final int getType()
  {
    return 216;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127577);
    Log.i("MicroMsg.FCM.NetSceneFcmReg", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.c
 * JD-Core Version:    0.7.0.1
 */