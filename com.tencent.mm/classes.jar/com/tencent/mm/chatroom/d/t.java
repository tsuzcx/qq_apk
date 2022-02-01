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
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  private dzw iWE;
  private final d rr;
  
  public t(String paramString1, String paramString2, String paramString3, dzx paramdzx)
  {
    AppMethodBeat.i(182091);
    Log.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", new Object[] { Util.nullAs(paramString1, ""), Util.nullAs(paramString2, ""), Util.nullAs(paramString3, ""), y.a(paramdzx) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
    ((d.a)localObject).funcId = 3854;
    ((d.a)localObject).lBU = new dzv();
    ((d.a)localObject).lBV = new dzw();
    this.rr = ((d.a)localObject).bgN();
    localObject = (dzv)d.b.b(this.rr.lBR);
    ((dzv)localObject).RIi = Util.nullAs(paramString1, "");
    ((dzv)localObject).Uff = paramString2;
    ((dzv)localObject).Ufg = paramString3;
    ((dzv)localObject).Ufe = paramdzx;
    AppMethodBeat.o(182091);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(182092);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(182092);
    return i;
  }
  
  public final int getType()
  {
    return 3854;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182093);
    Log.d("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.iWE = ((dzw)d.c.b(((d)params).lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.t
 * JD-Core Version:    0.7.0.1
 */