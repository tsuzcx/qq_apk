package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  private dzs iWC;
  private final d rr;
  
  public r(String paramString, int paramInt, dzx paramdzx)
  {
    AppMethodBeat.i(182085);
    Log.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(paramInt), y.a(paramdzx) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
    ((d.a)localObject).funcId = 3618;
    ((d.a)localObject).lBU = new dzr();
    ((d.a)localObject).lBV = new dzs();
    this.rr = ((d.a)localObject).bgN();
    localObject = (dzr)d.b.b(this.rr.lBR);
    ((dzr)localObject).RIi = Util.nullAs(paramString, "");
    ((dzr)localObject).Ufd = paramInt;
    ((dzr)localObject).Ufe = paramdzx;
    AppMethodBeat.o(182085);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(182086);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(182086);
    return i;
  }
  
  public final int getType()
  {
    return 3618;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182087);
    Log.d("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.iWC = ((dzs)d.c.b(((d)params).lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.r
 * JD-Core Version:    0.7.0.1
 */