package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(5574);
    d.a locala = new d.a();
    locala.iLN = new clb();
    locala.iLO = new clc();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
    locala.funcId = 1031;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((clb)this.rr.iLK.iLR).Mis = paramString;
    AppMethodBeat.o(5574);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5576);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.h
 * JD-Core Version:    0.7.0.1
 */