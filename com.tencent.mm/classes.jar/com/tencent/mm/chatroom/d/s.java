package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.roomsdk.model.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends com.tencent.mm.roomsdk.model.a
  implements m
{
  private h callback;
  public cc hTm;
  public int lyF;
  private final c rr;
  
  public s(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(241431);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dcp();
    ((c.a)localObject).otF = new dcq();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((c.a)localObject).funcId = 610;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dcp)c.b.b(this.rr.otB);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      doe localdoe = new doe();
      localdoe.ZqQ = w.Sk(str);
      localLinkedList.add(localdoe);
    }
    ((dcp)localObject).YFm = localLinkedList;
    ((dcp)localObject).lyF = localLinkedList.size();
    ((dcp)localObject).YFn = w.Sk(paramString);
    ((dcp)localObject).aaIx = 0;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      Log.i("MicroMsg.NetSceneInviteChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((dcp)localObject).YFq = new daa();
      ((dcp)localObject).YFq.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((dcp)localObject).YFq.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((dcp)localObject).YFq.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((dcp)localObject).YFq.lAT = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAT;
      ((dcp)localObject).YFq.lAU = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAU;
      ((dcp)localObject).YFq.lAV = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAV;
      ((dcp)localObject).YFq.lAW = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAW;
      ((dcp)localObject).YFq.lAX = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAX;
      ((dcp)localObject).YFq.lAY = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAY;
      ((dcp)localObject).YFq.lAZ = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAZ;
    }
    AppMethodBeat.o(241431);
  }
  
  public s(String paramString1, List<String> paramList, String paramString2, cc paramcc)
  {
    AppMethodBeat.i(12486);
    this.hTm = paramcc;
    paramcc = new c.a();
    paramcc.otE = new dcp();
    paramcc.otF = new dcq();
    paramcc.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    paramcc.funcId = 610;
    paramcc.otG = 0;
    paramcc.respCmdId = 0;
    this.rr = paramcc.bEF();
    paramcc = (dcp)c.b.b(this.rr.otB);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      doe localdoe = new doe();
      localdoe.ZqQ = w.Sk(str);
      localLinkedList.add(localdoe);
    }
    this.lyF = localLinkedList.size();
    paramcc.YFm = localLinkedList;
    paramcc.lyF = localLinkedList.size();
    paramcc.YFn = w.Sk(paramString1);
    paramcc.aaIx = 2;
    paramcc.aaIy = paramString2;
    AppMethodBeat.o(12486);
  }
  
  public final com.tencent.mm.roomsdk.model.b.a a(com.tencent.mm.roomsdk.model.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof d))
    {
      localObject = (d)parama;
      ((d)localObject).lyF = this.lyF;
      ((d)localObject).acmv = this.hTm;
    }
    return localObject;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12487);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12487);
    return i;
  }
  
  public final int getType()
  {
    return 610;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12488);
    Log.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    c.c.b(this.rr.otC);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.s
 * JD-Core Version:    0.7.0.1
 */