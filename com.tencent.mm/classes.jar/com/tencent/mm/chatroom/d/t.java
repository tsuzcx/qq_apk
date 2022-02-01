package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12489);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new esj();
    ((c.a)localObject).otF = new esk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
    ((c.a)localObject).funcId = 700;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (esj)c.b.b(this.rr.otB);
    ((esj)localObject).abvZ = paramString1;
    ((esj)localObject).abwa = paramString2;
    AppMethodBeat.o(12489);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12490);
    this.callback = paramh;
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
    c.b.b(this.rr.otB);
    c.c.b(this.rr.otC);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.t
 * JD-Core Version:    0.7.0.1
 */