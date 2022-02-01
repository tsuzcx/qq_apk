package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private String errMsg;
  public api foL;
  private final b rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(182082);
    ad.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo roomname:%s", new Object[] { bt.by(paramString, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((b.a)localObject).funcId = 3553;
    ((b.a)localObject).gUU = new aph();
    ((b.a)localObject).gUV = new api();
    this.rr = ((b.a)localObject).atI();
    localObject = (aph)this.rr.gUS.gUX;
    ((aph)localObject).dlX = bt.by(paramString, "");
    ((aph)localObject).scene = 0;
    AppMethodBeat.o(182082);
  }
  
  public k(String paramString, byte paramByte)
  {
    AppMethodBeat.i(196566);
    ad.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo ticket:%s", new Object[] { bt.by(paramString, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((b.a)localObject).funcId = 3553;
    ((b.a)localObject).gUU = new aph();
    ((b.a)localObject).gUV = new api();
    this.rr = ((b.a)localObject).atI();
    localObject = (aph)this.rr.gUS.gUX;
    ((aph)localObject).dgo = bt.by(paramString, "");
    ((aph)localObject).scene = 1;
    AppMethodBeat.o(196566);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(182083);
    this.callback = paramg;
    this.foL = ((api)this.rr.gUT.gUX);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(182083);
    return i;
  }
  
  public final int getType()
  {
    return 3553;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182084);
    ad.d("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.k
 * JD-Core Version:    0.7.0.1
 */