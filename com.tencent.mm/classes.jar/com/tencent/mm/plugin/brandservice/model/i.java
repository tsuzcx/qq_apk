package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dkw;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(5574);
    c.a locala = new c.a();
    locala.otE = new dkw();
    locala.otF = new dkx();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
    locala.funcId = 1031;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((dkw)c.b.b(this.rr.otB)).aaGq = paramString;
    AppMethodBeat.o(5574);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(5576);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5576);
    return i;
  }
  
  public final int getType()
  {
    return 1031;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5575);
    Log.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.i
 * JD-Core Version:    0.7.0.1
 */