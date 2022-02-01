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
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  private dqa gst;
  private final d rr;
  
  public t(String paramString1, String paramString2, String paramString3, dqb paramdqb)
  {
    AppMethodBeat.i(182091);
    Log.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", new Object[] { Util.nullAs(paramString1, ""), Util.nullAs(paramString2, ""), Util.nullAs(paramString3, ""), y.a(paramdqb) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
    ((d.a)localObject).funcId = 3854;
    ((d.a)localObject).iLN = new dpz();
    ((d.a)localObject).iLO = new dqa();
    this.rr = ((d.a)localObject).aXF();
    localObject = (dpz)this.rr.iLK.iLR;
    ((dpz)localObject).KGO = Util.nullAs(paramString1, "");
    ((dpz)localObject).MSX = paramString2;
    ((dpz)localObject).MSY = paramString3;
    ((dpz)localObject).MSW = paramdqb;
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
    this.gst = ((dqa)((d)params).iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.t
 * JD-Core Version:    0.7.0.1
 */