package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  private final com.tencent.mm.am.c rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(127575);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ev();
    ((c.a)localObject).otF = new ew();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/androidfcmreg";
    ((c.a)localObject).funcId = 216;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ev)c.b.b(this.rr.otB);
    ((ev)localObject).YGM = paramString;
    ((ev)localObject).IHg = 1;
    AppMethodBeat.o(127575);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(127576);
    this.callback = paramh;
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