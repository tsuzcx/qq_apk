package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  private dpw gsr;
  private final d rr;
  
  public r(String paramString, int paramInt, dqb paramdqb)
  {
    AppMethodBeat.i(182085);
    Log.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(paramInt), y.a(paramdqb) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
    ((d.a)localObject).funcId = 3618;
    ((d.a)localObject).iLN = new dpv();
    ((d.a)localObject).iLO = new dpw();
    this.rr = ((d.a)localObject).aXF();
    localObject = (dpv)this.rr.iLK.iLR;
    ((dpv)localObject).KGO = Util.nullAs(paramString, "");
    ((dpv)localObject).MSV = paramInt;
    ((dpv)localObject).MSW = paramdqb;
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
    this.gsr = ((dpw)((d)params).iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.r
 * JD-Core Version:    0.7.0.1
 */