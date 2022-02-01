package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.ar;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private String hMM;
  private final c rr;
  
  public e(String paramString, LinkedList<dxf> paramLinkedList)
  {
    AppMethodBeat.i(151187);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aiq();
    ((c.a)localObject).otF = new air();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((c.a)localObject).funcId = 943;
    this.rr = ((c.a)localObject).bEF();
    this.hMM = paramString;
    localObject = (aiq)c.b.b(this.rr.otB);
    ((aiq)localObject).pss = paramString;
    ((aiq)localObject).YFR = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151187);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151189);
    this.callback = paramh;
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
    Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hMM });
    Object localObject;
    String str;
    if (params.getRespObj().getRetCode() == 0)
    {
      localObject = (air)c.c.b(((c)params).otC);
      str = this.hMM;
      if ((str.toLowerCase().endsWith("@im.chatroom")) && (!((air)localObject).YFR.isEmpty())) {
        break label166;
      }
      Log.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + str + "] listCnt:" + ((air)localObject).YFR.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151188);
      return;
      label166:
      params = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK();
      paramArrayOfByte = params.Ju(str);
      List localList = aj.bvM(paramArrayOfByte.field_memberlist);
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((air)localObject).YFR.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((dxg)((Iterator)localObject).next()).userName);
      }
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      str = ((a)com.tencent.mm.kernel.h.ax(a.class)).f(localList, str);
      paramArrayOfByte.mI(localList).field_displayname = str;
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(params.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.e
 * JD-Core Version:    0.7.0.1
 */