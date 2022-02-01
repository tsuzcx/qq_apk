package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cwz;
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
  public ca fNz;
  public int iWB;
  private final com.tencent.mm.an.d rr;
  
  public p(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(193867);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cmd();
    ((d.a)localObject).lBV = new cme();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((d.a)localObject).funcId = 610;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cmd)d.b.b(this.rr.lBR);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      cwz localcwz = new cwz();
      localcwz.SrM = z.ZW(str);
      localLinkedList.add(localcwz);
    }
    ((cmd)localObject).RIk = localLinkedList;
    ((cmd)localObject).iWB = localLinkedList.size();
    ((cmd)localObject).RIl = z.ZW(paramString);
    ((cmd)localObject).TtV = 0;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      Log.i("MicroMsg.NetSceneInviteChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((cmd)localObject).RIo = new cju();
      ((cmd)localObject).RIo.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((cmd)localObject).RIo.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((cmd)localObject).RIo.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((cmd)localObject).RIo.iZc = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).iZc;
      ((cmd)localObject).RIo.iZd = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).iZd;
    }
    AppMethodBeat.o(193867);
  }
  
  public p(String paramString1, List<String> paramList, String paramString2, ca paramca)
  {
    AppMethodBeat.i(12486);
    this.fNz = paramca;
    paramca = new d.a();
    paramca.lBU = new cmd();
    paramca.lBV = new cme();
    paramca.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    paramca.funcId = 610;
    paramca.lBW = 0;
    paramca.respCmdId = 0;
    this.rr = paramca.bgN();
    paramca = (cmd)d.b.b(this.rr.lBR);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      cwz localcwz = new cwz();
      localcwz.SrM = z.ZW(str);
      localLinkedList.add(localcwz);
    }
    this.iWB = localLinkedList.size();
    paramca.RIk = localLinkedList;
    paramca.iWB = localLinkedList.size();
    paramca.RIl = z.ZW(paramString1);
    paramca.TtV = 2;
    paramca.TtW = paramString2;
    AppMethodBeat.o(12486);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof com.tencent.mm.roomsdk.a.b.d))
    {
      localObject = (com.tencent.mm.roomsdk.a.b.d)parama;
      ((com.tencent.mm.roomsdk.a.b.d)localObject).iWB = this.iWB;
      ((com.tencent.mm.roomsdk.a.b.d)localObject).URh = this.fNz;
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
    d.c.b(this.rr.lBS);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.p
 * JD-Core Version:    0.7.0.1
 */