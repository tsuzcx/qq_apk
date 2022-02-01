package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
  extends n
  implements k
{
  private g callback;
  private String errMsg;
  private crf fsE;
  private final b rr;
  
  public t(String paramString1, String paramString2, String paramString3, crg paramcrg)
  {
    AppMethodBeat.i(182091);
    ac.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", new Object[] { bs.bG(paramString1, ""), bs.bG(paramString2, ""), bs.bG(paramString3, ""), y.a(paramcrg) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
    ((b.a)localObject).funcId = 3854;
    ((b.a)localObject).hvt = new cre();
    ((b.a)localObject).hvu = new crf();
    this.rr = ((b.a)localObject).aAz();
    localObject = (cre)this.rr.hvr.hvw;
    ((cre)localObject).DPx = bs.bG(paramString1, "");
    ((cre)localObject).FDX = paramString2;
    ((cre)localObject).FDY = paramString3;
    ((cre)localObject).FDW = paramcrg;
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
    ac.d("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fsE = ((crf)((b)paramq).hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.t
 * JD-Core Version:    0.7.0.1
 */