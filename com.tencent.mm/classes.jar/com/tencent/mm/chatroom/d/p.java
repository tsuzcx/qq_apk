package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends com.tencent.mm.roomsdk.a.a
  implements m
{
  private i callback;
  public ca dTX;
  public int gsq;
  private final com.tencent.mm.ak.d rr;
  
  public p(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(194031);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cdj();
    ((d.a)localObject).iLO = new cdk();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((d.a)localObject).funcId = 610;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cdj)this.rr.iLK.iLR;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      con localcon = new con();
      localcon.Lqp = z.Su(str);
      localLinkedList.add(localcon);
    }
    ((cdj)localObject).KGQ = localLinkedList;
    ((cdj)localObject).gsq = localLinkedList.size();
    ((cdj)localObject).KGR = z.Su(paramString);
    ((cdj)localObject).Mjh = 0;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      Log.i("MicroMsg.NetSceneInviteChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((cdj)localObject).KGU = new cbr();
      ((cdj)localObject).KGU.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((cdj)localObject).KGU.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((cdj)localObject).KGU.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((cdj)localObject).KGU.guR = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).guR;
      ((cdj)localObject).KGU.guS = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).guS;
    }
    AppMethodBeat.o(194031);
  }
  
  public p(String paramString1, List<String> paramList, String paramString2, ca paramca)
  {
    AppMethodBeat.i(12486);
    this.dTX = paramca;
    paramca = new d.a();
    paramca.iLN = new cdj();
    paramca.iLO = new cdk();
    paramca.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    paramca.funcId = 610;
    paramca.iLP = 0;
    paramca.respCmdId = 0;
    this.rr = paramca.aXF();
    paramca = (cdj)this.rr.iLK.iLR;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      con localcon = new con();
      localcon.Lqp = z.Su(str);
      localLinkedList.add(localcon);
    }
    this.gsq = localLinkedList.size();
    paramca.KGQ = localLinkedList;
    paramca.gsq = localLinkedList.size();
    paramca.KGR = z.Su(paramString1);
    paramca.Mjh = 2;
    paramca.Mji = paramString2;
    AppMethodBeat.o(12486);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof com.tencent.mm.roomsdk.a.b.d))
    {
      localObject = (com.tencent.mm.roomsdk.a.b.d)parama;
      ((com.tencent.mm.roomsdk.a.b.d)localObject).gsq = this.gsq;
      ((com.tencent.mm.roomsdk.a.b.d)localObject).NDK = this.dTX;
    }
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12487);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12487);
    return i;
  }
  
  public final int getType()
  {
    return 610;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12488);
    Log.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.p
 * JD-Core Version:    0.7.0.1
 */