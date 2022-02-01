package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private i callback;
  private String dOe;
  private final d rr;
  
  public k(String paramString, LinkedList<cvt> paramLinkedList)
  {
    AppMethodBeat.i(151209);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cdq();
    ((d.a)localObject).iLO = new cdr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
    ((d.a)localObject).funcId = 887;
    this.rr = ((d.a)localObject).aXF();
    this.dOe = paramString;
    localObject = (cdq)this.rr.iLK.iLR;
    ((cdq)localObject).jHa = paramString;
    ((cdq)localObject).KHx = paramLinkedList;
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
    Log.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dOe });
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