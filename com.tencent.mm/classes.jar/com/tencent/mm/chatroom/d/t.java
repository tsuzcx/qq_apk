package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class t
  extends n
  implements k
{
  private f callback;
  private String errMsg;
  private cxg fNi;
  private final b rr;
  
  public t(String paramString1, String paramString2, String paramString3, cxh paramcxh)
  {
    AppMethodBeat.i(182091);
    ae.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", new Object[] { bu.bI(paramString1, ""), bu.bI(paramString2, ""), bu.bI(paramString3, ""), y.a(paramcxh) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
    ((b.a)localObject).funcId = 3854;
    ((b.a)localObject).hQF = new cxf();
    ((b.a)localObject).hQG = new cxg();
    this.rr = ((b.a)localObject).aDS();
    localObject = (cxf)this.rr.hQD.hQJ;
    ((cxf)localObject).FNj = bu.bI(paramString1, "");
    ((cxf)localObject).HHM = paramString2;
    ((cxf)localObject).HHN = paramString3;
    ((cxf)localObject).HHL = paramcxh;
    AppMethodBeat.o(182091);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(182092);
    this.callback = paramf;
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
    ae.d("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fNi = ((cxg)((b)paramq).hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.t
 * JD-Core Version:    0.7.0.1
 */