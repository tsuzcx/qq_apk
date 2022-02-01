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
import com.tencent.mm.protocal.protobuf.etb;
import com.tencent.mm.protocal.protobuf.etc;
import com.tencent.mm.protocal.protobuf.etd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class w
  extends p
  implements m
{
  private h callback;
  private String errMsg;
  private etc lyI;
  private final c rr;
  
  public w(String paramString1, String paramString2, String paramString3, etd parametd)
  {
    AppMethodBeat.i(182091);
    Log.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", new Object[] { Util.nullAs(paramString1, ""), Util.nullAs(paramString2, ""), Util.nullAs(paramString3, ""), ab.a(parametd) });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
    ((c.a)localObject).funcId = 3854;
    ((c.a)localObject).otE = new etb();
    ((c.a)localObject).otF = new etc();
    this.rr = ((c.a)localObject).bEF();
    localObject = (etb)c.b.b(this.rr.otB);
    ((etb)localObject).YFk = Util.nullAs(paramString1, "");
    ((etb)localObject).abws = paramString2;
    ((etb)localObject).abwt = paramString3;
    ((etb)localObject).abwr = parametd;
    AppMethodBeat.o(182091);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(182092);
    this.callback = paramh;
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
    this.lyI = ((etc)c.c.b(((c)params).otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.w
 * JD-Core Version:    0.7.0.1
 */