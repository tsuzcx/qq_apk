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
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
  extends n
  implements k
{
  private f callback;
  private String errMsg;
  private cwm fLe;
  private final b rr;
  
  public t(String paramString1, String paramString2, String paramString3, cwn paramcwn)
  {
    AppMethodBeat.i(182091);
    ad.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", new Object[] { bt.bI(paramString1, ""), bt.bI(paramString2, ""), bt.bI(paramString3, ""), y.a(paramcwn) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
    ((b.a)localObject).funcId = 3854;
    ((b.a)localObject).hNM = new cwl();
    ((b.a)localObject).hNN = new cwm();
    this.rr = ((b.a)localObject).aDC();
    localObject = (cwl)this.rr.hNK.hNQ;
    ((cwl)localObject).FuL = bt.bI(paramString1, "");
    ((cwl)localObject).Hom = paramString2;
    ((cwl)localObject).Hon = paramString3;
    ((cwl)localObject).Hol = paramcwn;
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
    ad.d("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fLe = ((cwm)((b)paramq).hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.t
 * JD-Core Version:    0.7.0.1
 */