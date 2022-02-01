package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private String djF;
  private final b rr;
  
  public k(String paramString, LinkedList<cab> paramLinkedList)
  {
    AppMethodBeat.i(151209);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new blt();
    ((b.a)localObject).hvu = new blu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
    ((b.a)localObject).funcId = 887;
    this.rr = ((b.a)localObject).aAz();
    this.djF = paramString;
    localObject = (blt)this.rr.hvr.hvw;
    ((blt)localObject).ioe = paramString;
    ((blt)localObject).DQg = paramLinkedList;
    ac.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151209);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151211);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151211);
    return i;
  }
  
  public final int getType()
  {
    return 887;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151210);
    ac.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.djF });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.k
 * JD-Core Version:    0.7.0.1
 */