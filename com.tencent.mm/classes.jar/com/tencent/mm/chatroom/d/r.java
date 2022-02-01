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
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class r
  extends n
  implements k
{
  private f callback;
  private String errMsg;
  private cxc fNg;
  private final b rr;
  
  public r(String paramString, int paramInt, cxh paramcxh)
  {
    AppMethodBeat.i(182085);
    ae.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", new Object[] { bu.bI(paramString, ""), Integer.valueOf(paramInt), y.a(paramcxh) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
    ((b.a)localObject).funcId = 3618;
    ((b.a)localObject).hQF = new cxb();
    ((b.a)localObject).hQG = new cxc();
    this.rr = ((b.a)localObject).aDS();
    localObject = (cxb)this.rr.hQD.hQJ;
    ((cxb)localObject).FNj = bu.bI(paramString, "");
    ((cxb)localObject).HHK = paramInt;
    ((cxb)localObject).HHL = paramcxh;
    AppMethodBeat.o(182085);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(182086);
    this.callback = paramf;
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
    ae.d("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fNg = ((cxc)((b)paramq).hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.r
 * JD-Core Version:    0.7.0.1
 */