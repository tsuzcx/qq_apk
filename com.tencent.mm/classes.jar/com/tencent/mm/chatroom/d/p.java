package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.roomsdk.a.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private g callback;
  public bl drF;
  public int fpb;
  private final b rr;
  
  public p(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12485);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bhu();
    ((b.a)localObject).gUV = new bhv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((b.a)localObject).funcId = 610;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bhu)this.rr.gUS.gUX;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bpm localbpm = new bpm();
      localbpm.DbD = z.BE(str);
      localLinkedList.add(localbpm);
    }
    ((bhu)localObject).Cxd = localLinkedList;
    ((bhu)localObject).fpb = localLinkedList.size();
    ((bhu)localObject).Cxe = z.BE(paramString);
    ((bhu)localObject).DFH = 0;
    AppMethodBeat.o(12485);
  }
  
  public p(String paramString1, List<String> paramList, String paramString2, bl parambl)
  {
    AppMethodBeat.i(12486);
    this.drF = parambl;
    parambl = new b.a();
    parambl.gUU = new bhu();
    parambl.gUV = new bhv();
    parambl.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    parambl.funcId = 610;
    parambl.reqCmdId = 0;
    parambl.respCmdId = 0;
    this.rr = parambl.atI();
    parambl = (bhu)this.rr.gUS.gUX;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bpm localbpm = new bpm();
      localbpm.DbD = z.BE(str);
      localLinkedList.add(localbpm);
    }
    this.fpb = localLinkedList.size();
    parambl.Cxd = localLinkedList;
    parambl.fpb = localLinkedList.size();
    parambl.Cxe = z.BE(paramString1);
    parambl.DFH = 2;
    parambl.DFI = paramString2;
    AppMethodBeat.o(12486);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof d))
    {
      localObject = (d)parama;
      ((d)localObject).fpb = this.fpb;
      ((d)localObject).ENh = this.drF;
    }
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(12487);
    this.callback = paramg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.p
 * JD-Core Version:    0.7.0.1
 */