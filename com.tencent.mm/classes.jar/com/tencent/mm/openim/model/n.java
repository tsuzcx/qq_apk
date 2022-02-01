package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.dcx;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class n
  extends p
  implements m
{
  private h callback;
  private String hMM;
  private final c rr;
  
  public n(String paramString, LinkedList<dxf> paramLinkedList)
  {
    AppMethodBeat.i(151209);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dcw();
    ((c.a)localObject).otF = new dcx();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
    ((c.a)localObject).funcId = 887;
    this.rr = ((c.a)localObject).bEF();
    this.hMM = paramString;
    localObject = (dcw)c.b.b(this.rr.otB);
    ((dcw)localObject).pss = paramString;
    ((dcw)localObject).YFR = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151209);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151211);
    this.callback = paramh;
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
    Log.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hMM });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.model.n
 * JD-Core Version:    0.7.0.1
 */