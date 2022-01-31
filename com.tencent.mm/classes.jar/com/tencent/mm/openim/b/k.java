package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  private String gfK;
  private final b rr;
  
  public k(String paramString, LinkedList<bia> paramLinkedList)
  {
    AppMethodBeat.i(78865);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aww();
    ((b.a)localObject).fsY = new awx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
    ((b.a)localObject).funcId = 887;
    this.rr = ((b.a)localObject).ado();
    this.gfK = paramString;
    localObject = (aww)this.rr.fsV.fta;
    ((aww)localObject).gfM = paramString;
    ((aww)localObject).wpb = paramLinkedList;
    ab.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(78865);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78867);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78867);
    return i;
  }
  
  public final int getType()
  {
    return 887;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78866);
    ab.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.k
 * JD-Core Version:    0.7.0.1
 */