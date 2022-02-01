package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.esn;
import com.tencent.mm.protocal.protobuf.eso;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  private final String hMM;
  private final c rr;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151212);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new esn();
    ((c.a)localObject).otF = new eso();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
    ((c.a)localObject).funcId = 772;
    this.rr = ((c.a)localObject).bEF();
    this.hMM = paramString1;
    localObject = (esn)c.b.b(this.rr.otB);
    ((esn)localObject).hMM = paramString1;
    ((esn)localObject).hSC = paramString2;
    Log.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151212);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151214);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151214);
    return i;
  }
  
  public final int getType()
  {
    return 772;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151213);
    Log.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hMM });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.model.p
 * JD-Core Version:    0.7.0.1
 */