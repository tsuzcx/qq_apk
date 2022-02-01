package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  private d rr;
  
  public q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12489);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dpi();
    ((d.a)localObject).iLO = new dpj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
    ((d.a)localObject).funcId = 700;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dpi)this.rr.iLK.iLR;
    ((dpi)localObject).MSF = paramString1;
    ((dpi)localObject).MSG = paramString2;
    AppMethodBeat.o(12489);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12490);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12490);
    return i;
  }
  
  public final int getType()
  {
    return 700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12491);
    Log.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.q
 * JD-Core Version:    0.7.0.1
 */