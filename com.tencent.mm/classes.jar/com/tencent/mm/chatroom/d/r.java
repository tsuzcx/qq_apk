package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class r
  extends n
  implements k
{
  private f callback;
  private String errMsg;
  private cwi fLc;
  private final b rr;
  
  public r(String paramString, int paramInt, cwn paramcwn)
  {
    AppMethodBeat.i(182085);
    ad.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", new Object[] { bt.bI(paramString, ""), Integer.valueOf(paramInt), y.a(paramcwn) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
    ((b.a)localObject).funcId = 3618;
    ((b.a)localObject).hNM = new cwh();
    ((b.a)localObject).hNN = new cwi();
    this.rr = ((b.a)localObject).aDC();
    localObject = (cwh)this.rr.hNK.hNQ;
    ((cwh)localObject).FuL = bt.bI(paramString, "");
    ((cwh)localObject).Hok = paramInt;
    ((cwh)localObject).Hol = paramcwn;
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
    ad.d("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fLc = ((cwi)((b)paramq).hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.r
 * JD-Core Version:    0.7.0.1
 */