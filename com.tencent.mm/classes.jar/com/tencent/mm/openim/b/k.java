package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String dvs;
  private final b rr;
  
  public k(String paramString, LinkedList<ces> paramLinkedList)
  {
    AppMethodBeat.i(151209);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bqd();
    ((b.a)localObject).hNN = new bqe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
    ((b.a)localObject).funcId = 887;
    this.rr = ((b.a)localObject).aDC();
    this.dvs = paramString;
    localObject = (bqd)this.rr.hNK.hNQ;
    ((bqd)localObject).iHB = paramString;
    ((bqd)localObject).Fvu = paramLinkedList;
    ad.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151209);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151211);
    this.callback = paramf;
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
    ad.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dvs });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.k
 * JD-Core Version:    0.7.0.1
 */