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
import com.tencent.mm.protocal.protobuf.esx;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.etd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  extends p
  implements m
{
  private h callback;
  private String errMsg;
  private esy lyG;
  private final c rr;
  
  public u(String paramString, int paramInt, etd parametd)
  {
    AppMethodBeat.i(182085);
    Log.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(paramInt), ab.a(parametd) });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
    ((c.a)localObject).funcId = 3618;
    ((c.a)localObject).otE = new esx();
    ((c.a)localObject).otF = new esy();
    this.rr = ((c.a)localObject).bEF();
    localObject = (esx)c.b.b(this.rr.otB);
    ((esx)localObject).YFk = Util.nullAs(paramString, "");
    ((esx)localObject).abwq = paramInt;
    ((esx)localObject).abwr = parametd;
    AppMethodBeat.o(182085);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(182086);
    this.callback = paramh;
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
    this.lyG = ((esy)c.c.b(((c)params).otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.u
 * JD-Core Version:    0.7.0.1
 */