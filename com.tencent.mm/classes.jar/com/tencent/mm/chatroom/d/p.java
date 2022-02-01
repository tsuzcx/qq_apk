package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.roomsdk.a.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  public bv dCi;
  public int fNf;
  private final b rr;
  
  public p(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(217117);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bqq();
    ((b.a)localObject).hQG = new bqr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((b.a)localObject).funcId = 610;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bqq)this.rr.hQD.hQJ;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bzm localbzm = new bzm();
      localbzm.GuK = z.Jw(str);
      localLinkedList.add(localbzm);
    }
    ((bqq)localObject).FNl = localLinkedList;
    ((bqq)localObject).fNf = localLinkedList.size();
    ((bqq)localObject).FNm = z.Jw(paramString);
    ((bqq)localObject).Heb = 0;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      ae.i("MicroMsg.NetSceneInviteChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((bqq)localObject).FNp = new boz();
      ((bqq)localObject).FNp.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((bqq)localObject).FNp.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((bqq)localObject).FNp.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((bqq)localObject).FNp.fPH = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fPH;
      ((bqq)localObject).FNp.fPI = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fPI;
    }
    AppMethodBeat.o(217117);
  }
  
  public p(String paramString1, List<String> paramList, String paramString2, bv parambv)
  {
    AppMethodBeat.i(12486);
    this.dCi = parambv;
    parambv = new b.a();
    parambv.hQF = new bqq();
    parambv.hQG = new bqr();
    parambv.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    parambv.funcId = 610;
    parambv.hQH = 0;
    parambv.respCmdId = 0;
    this.rr = parambv.aDS();
    parambv = (bqq)this.rr.hQD.hQJ;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bzm localbzm = new bzm();
      localbzm.GuK = z.Jw(str);
      localLinkedList.add(localbzm);
    }
    this.fNf = localLinkedList.size();
    parambv.FNl = localLinkedList;
    parambv.fNf = localLinkedList.size();
    parambv.FNm = z.Jw(paramString1);
    parambv.Heb = 2;
    parambv.Hec = paramString2;
    AppMethodBeat.o(12486);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof d))
    {
      localObject = (d)parama;
      ((d)localObject).fNf = this.fNf;
      ((d)localObject).Iqn = this.dCi;
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
    ae.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.p
 * JD-Core Version:    0.7.0.1
 */