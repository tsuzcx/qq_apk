package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ap;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends q
  implements m
{
  private i callback;
  private String dOe;
  private final com.tencent.mm.ak.d rr;
  
  public d(String paramString, LinkedList<cvt> paramLinkedList)
  {
    AppMethodBeat.i(151187);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new afu();
    ((d.a)localObject).iLO = new afv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((d.a)localObject).funcId = 943;
    this.rr = ((d.a)localObject).aXF();
    this.dOe = paramString;
    localObject = (afu)this.rr.iLK.iLR;
    ((afu)localObject).jHa = paramString;
    ((afu)localObject).KHx = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151187);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(151189);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151189);
    return i;
  }
  
  public final int getType()
  {
    return 943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151188);
    Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dOe });
    Object localObject;
    if (params.getRespObj().getRetCode() == 0)
    {
      localObject = (afv)((com.tencent.mm.ak.d)params).iLL.iLR;
      paramArrayOfByte = this.dOe;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((afv)localObject).KHx.isEmpty())) {
        break label169;
      }
      Log.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((afv)localObject).KHx.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151188);
      return;
      label169:
      params = ((c)com.tencent.mm.kernel.g.af(c.class)).aSX();
      paramArrayOfByte = params.Kd(paramArrayOfByte);
      List localList = ah.bji(paramArrayOfByte.field_memberlist);
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((afv)localObject).KHx.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((cvu)((Iterator)localObject).next()).userName);
      }
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((b)com.tencent.mm.kernel.g.af(b.class)).ao(localList);
      paramArrayOfByte.iE(localList).field_displayname = ((String)localObject);
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(params.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */