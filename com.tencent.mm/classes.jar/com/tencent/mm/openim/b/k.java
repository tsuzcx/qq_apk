package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private i callback;
  private String fHp;
  private final d rr;
  
  public k(String paramString, LinkedList<dfd> paramLinkedList)
  {
    AppMethodBeat.i(151209);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cmk();
    ((d.a)localObject).lBV = new cml();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
    ((d.a)localObject).funcId = 887;
    this.rr = ((d.a)localObject).bgN();
    this.fHp = paramString;
    localObject = (cmk)d.b.b(this.rr.lBR);
    ((cmk)localObject).mye = paramString;
    ((cmk)localObject).RIQ = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151209);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151211);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151211);
    return i;
  }
  
  public final int getType()
  {
    return 887;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151210);
    Log.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.fHp });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.b.k
 * JD-Core Version:    0.7.0.1
 */