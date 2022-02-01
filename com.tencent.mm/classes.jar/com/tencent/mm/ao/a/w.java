package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124322);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dsl();
    ((d.a)localObject).lBV = new dsm();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
    ((d.a)localObject).funcId = 1361;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dsl)d.b.b(this.rr.lBR);
    ((dsl)localObject).RUp = paramString1;
    ((dsl)localObject).RUi = paramString2;
    ((dsl)localObject).time_stamp = paramInt;
    AppMethodBeat.o(124322);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124324);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.ao.a.w
 * JD-Core Version:    0.7.0.1
 */