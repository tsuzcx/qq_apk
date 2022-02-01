package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.roomsdk.a.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  public bu dBd;
  public int fLb;
  private final b rr;
  
  public p(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(213404);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bpw();
    ((b.a)localObject).hNN = new bpx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((b.a)localObject).funcId = 610;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bpw)this.rr.hNK.hNQ;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bys localbys = new bys();
      localbys.Gcd = z.IX(str);
      localLinkedList.add(localbys);
    }
    ((bpw)localObject).FuN = localLinkedList;
    ((bpw)localObject).fLb = localLinkedList.size();
    ((bpw)localObject).FuO = z.IX(paramString);
    ((bpw)localObject).GKA = 0;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      ad.i("MicroMsg.NetSceneInviteChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((bpw)localObject).FuR = new boh();
      ((bpw)localObject).FuR.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((bpw)localObject).FuR.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((bpw)localObject).FuR.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((bpw)localObject).FuR.fNA = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fNA;
      ((bpw)localObject).FuR.fNB = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fNB;
    }
    AppMethodBeat.o(213404);
  }
  
  public p(String paramString1, List<String> paramList, String paramString2, bu parambu)
  {
    AppMethodBeat.i(12486);
    this.dBd = parambu;
    parambu = new b.a();
    parambu.hNM = new bpw();
    parambu.hNN = new bpx();
    parambu.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    parambu.funcId = 610;
    parambu.hNO = 0;
    parambu.respCmdId = 0;
    this.rr = parambu.aDC();
    parambu = (bpw)this.rr.hNK.hNQ;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bys localbys = new bys();
      localbys.Gcd = z.IX(str);
      localLinkedList.add(localbys);
    }
    this.fLb = localLinkedList.size();
    parambu.FuN = localLinkedList;
    parambu.fLb = localLinkedList.size();
    parambu.FuO = z.IX(paramString1);
    parambu.GKA = 2;
    parambu.GKB = paramString2;
    AppMethodBeat.o(12486);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof d))
    {
      localObject = (d)parama;
      ((d)localObject).fLb = this.fLb;
      ((d)localObject).HWf = this.dBd;
    }
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12487);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12487);
    return i;
  }
  
  public final int getType()
  {
    return 610;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12488);
    ad.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.p
 * JD-Core Version:    0.7.0.1
 */