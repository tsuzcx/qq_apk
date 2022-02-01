package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clx;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
  extends n
  implements k
{
  private g callback;
  private String errMsg;
  private cly fpe;
  private final b rr;
  
  public t(String paramString1, String paramString2, String paramString3, clz paramclz)
  {
    AppMethodBeat.i(182091);
    ad.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", new Object[] { bt.by(paramString1, ""), bt.by(paramString2, ""), bt.by(paramString3, ""), y.a(paramclz) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
    ((b.a)localObject).funcId = 3854;
    ((b.a)localObject).gUU = new clx();
    ((b.a)localObject).gUV = new cly();
    this.rr = ((b.a)localObject).atI();
    localObject = (clx)this.rr.gUS.gUX;
    ((clx)localObject).Cxb = bt.by(paramString1, "");
    ((clx)localObject).EgY = paramString2;
    ((clx)localObject).EgZ = paramString3;
    ((clx)localObject).EgX = paramclz;
    AppMethodBeat.o(182091);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(182092);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(182092);
    return i;
  }
  
  public final int getType()
  {
    return 3854;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182093);
    ad.d("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fpe = ((cly)((b)paramq).gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.t
 * JD-Core Version:    0.7.0.1
 */