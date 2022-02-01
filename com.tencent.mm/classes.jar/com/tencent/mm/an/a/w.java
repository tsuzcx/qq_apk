package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elg;
import com.tencent.mm.protocal.protobuf.elh;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124322);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new elg();
    ((c.a)localObject).otF = new elh();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
    ((c.a)localObject).funcId = 1361;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (elg)c.b.b(this.rr.otB);
    ((elg)localObject).YRQ = paramString1;
    ((elg)localObject).YRJ = paramString2;
    ((elg)localObject).time_stamp = paramInt;
    AppMethodBeat.o(124322);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124324);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124324);
    return i;
  }
  
  public final int getType()
  {
    return 1361;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124323);
    Log.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.a.w
 * JD-Core Version:    0.7.0.1
 */