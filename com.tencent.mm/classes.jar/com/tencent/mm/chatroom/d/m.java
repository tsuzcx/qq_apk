package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  public String chatroomName;
  public int gsf;
  public int gsg;
  public String resultMsg;
  private final d rr;
  public int status;
  
  public m(String paramString)
  {
    AppMethodBeat.i(12473);
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new blc();
    locala.iLO = new bld();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
    locala.funcId = 519;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.chatroomName = paramString;
    ((blc)this.rr.iLK.iLR).KGO = paramString;
    AppMethodBeat.o(12473);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12474);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12474);
    return i;
  }
  
  public final int getType()
  {
    return 519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12475);
    params = (bld)this.rr.iLL.iLR;
    Log.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.status = params.oTW;
    this.resultMsg = params.LUf;
    this.gsg = params.LUg;
    this.resultMsg = params.LUf;
    this.gsf = params.LUe;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.m
 * JD-Core Version:    0.7.0.1
 */