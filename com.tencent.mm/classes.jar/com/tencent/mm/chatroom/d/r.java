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
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class r
  extends n
  implements k
{
  private g callback;
  private String errMsg;
  private crb fsC;
  private final b rr;
  
  public r(String paramString, int paramInt, crg paramcrg)
  {
    AppMethodBeat.i(182085);
    ac.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", new Object[] { bs.bG(paramString, ""), Integer.valueOf(paramInt), y.a(paramcrg) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
    ((b.a)localObject).funcId = 3618;
    ((b.a)localObject).hvt = new cra();
    ((b.a)localObject).hvu = new crb();
    this.rr = ((b.a)localObject).aAz();
    localObject = (cra)this.rr.hvr.hvw;
    ((cra)localObject).DPx = bs.bG(paramString, "");
    ((cra)localObject).FDV = paramInt;
    ((cra)localObject).FDW = paramcrg;
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
    ac.d("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fsC = ((crb)((b)paramq).hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.r
 * JD-Core Version:    0.7.0.1
 */