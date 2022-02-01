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
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class r
  extends n
  implements k
{
  private g callback;
  private String errMsg;
  private clu fpc;
  private final b rr;
  
  public r(String paramString, int paramInt, clz paramclz)
  {
    AppMethodBeat.i(182085);
    ad.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", new Object[] { bt.by(paramString, ""), Integer.valueOf(paramInt), y.a(paramclz) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
    ((b.a)localObject).funcId = 3618;
    ((b.a)localObject).gUU = new clt();
    ((b.a)localObject).gUV = new clu();
    this.rr = ((b.a)localObject).atI();
    localObject = (clt)this.rr.gUS.gUX;
    ((clt)localObject).Cxb = bt.by(paramString, "");
    ((clt)localObject).EgW = paramInt;
    ((clt)localObject).EgX = paramclz;
    AppMethodBeat.o(182085);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(182086);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(182086);
    return i;
  }
  
  public final int getType()
  {
    return 3618;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182087);
    ad.d("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fpc = ((clu)((b)paramq).gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.r
 * JD-Core Version:    0.7.0.1
 */