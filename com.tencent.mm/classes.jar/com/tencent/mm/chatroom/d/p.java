package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.roomsdk.a.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private g callback;
  public bo dpq;
  public int fsB;
  private final b rr;
  
  public p(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12485);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new blm();
    ((b.a)localObject).hvu = new bln();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((b.a)localObject).funcId = 610;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (blm)this.rr.hvr.hvw;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bud localbud = new bud();
      localbud.EuJ = z.FI(str);
      localLinkedList.add(localbud);
    }
    ((blm)localObject).DPz = localLinkedList;
    ((blm)localObject).fsB = localLinkedList.size();
    ((blm)localObject).DPA = z.FI(paramString);
    ((blm)localObject).Fbb = 0;
    AppMethodBeat.o(12485);
  }
  
  public p(String paramString1, List<String> paramList, String paramString2, bo parambo)
  {
    AppMethodBeat.i(12486);
    this.dpq = parambo;
    parambo = new b.a();
    parambo.hvt = new blm();
    parambo.hvu = new bln();
    parambo.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    parambo.funcId = 610;
    parambo.reqCmdId = 0;
    parambo.respCmdId = 0;
    this.rr = parambo.aAz();
    parambo = (blm)this.rr.hvr.hvw;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bud localbud = new bud();
      localbud.EuJ = z.FI(str);
      localLinkedList.add(localbud);
    }
    this.fsB = localLinkedList.size();
    parambo.DPz = localLinkedList;
    parambo.fsB = localLinkedList.size();
    parambo.DPA = z.FI(paramString1);
    parambo.Fbb = 2;
    parambo.Fbc = paramString2;
    AppMethodBeat.o(12486);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof d))
    {
      localObject = (d)parama;
      ((d)localObject).fsB = this.fsB;
      ((d)localObject).Gkt = this.dpq;
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
    ac.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.p
 * JD-Core Version:    0.7.0.1
 */