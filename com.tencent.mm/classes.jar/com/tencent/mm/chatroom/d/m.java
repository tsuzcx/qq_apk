package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  public String chatroomName;
  public String fsq;
  public int fsr;
  public int fss;
  private final b rr;
  public int status;
  
  public m(String paramString)
  {
    AppMethodBeat.i(12473);
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new ave();
    locala.hvu = new avf();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
    locala.funcId = 519;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.chatroomName = paramString;
    ((ave)this.rr.hvr.hvw).DPx = paramString;
    AppMethodBeat.o(12473);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(12474);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12474);
    return i;
  }
  
  public final int getType()
  {
    return 519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12475);
    paramq = (avf)this.rr.hvs.hvw;
    ac.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.status = paramq.ndj;
    this.fsq = paramq.ENt;
    this.fss = paramq.ENu;
    this.fsq = paramq.ENt;
    this.fsr = paramq.ENs;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.m
 * JD-Core Version:    0.7.0.1
 */