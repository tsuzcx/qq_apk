package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private f callback;
  public String chatroomName;
  public String fKQ;
  public int fKR;
  public int fKS;
  private final b rr;
  public int status;
  
  public m(String paramString)
  {
    AppMethodBeat.i(12473);
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new azc();
    locala.hNN = new azd();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
    locala.funcId = 519;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.chatroomName = paramString;
    ((azc)this.rr.hNK.hNQ).FuL = paramString;
    AppMethodBeat.o(12473);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12474);
    this.callback = paramf;
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
    paramq = (azd)this.rr.hNL.hNQ;
    ad.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.status = paramq.nDG;
    this.fKQ = paramq.Gwy;
    this.fKS = paramq.Gwz;
    this.fKQ = paramq.Gwy;
    this.fKR = paramq.Gwx;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.m
 * JD-Core Version:    0.7.0.1
 */