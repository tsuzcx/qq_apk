package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.roomsdk.a.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  public bi cEE;
  private f callback;
  public int eeF;
  private final b rr;
  
  public m(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(103940);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new awp();
    ((b.a)localObject).fsY = new awq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((b.a)localObject).funcId = 610;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (awp)this.rr.fsV.fta;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bcw localbcw = new bcw();
      localbcw.wOY = aa.wA(str);
      localLinkedList.add(localbcw);
    }
    ((awp)localObject).wov = localLinkedList;
    ((awp)localObject).eeF = localLinkedList.size();
    ((awp)localObject).wow = aa.wA(paramString);
    ((awp)localObject).xmg = 0;
    AppMethodBeat.o(103940);
  }
  
  public m(String paramString1, List<String> paramList, String paramString2, bi parambi)
  {
    AppMethodBeat.i(103941);
    this.cEE = parambi;
    parambi = new b.a();
    parambi.fsX = new awp();
    parambi.fsY = new awq();
    parambi.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    parambi.funcId = 610;
    parambi.reqCmdId = 0;
    parambi.respCmdId = 0;
    this.rr = parambi.ado();
    parambi = (awp)this.rr.fsV.fta;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bcw localbcw = new bcw();
      localbcw.wOY = aa.wA(str);
      localLinkedList.add(localbcw);
    }
    this.eeF = localLinkedList.size();
    parambi.wov = localLinkedList;
    parambi.eeF = localLinkedList.size();
    parambi.wow = aa.wA(paramString1);
    parambi.xmg = 2;
    parambi.xmh = paramString2;
    AppMethodBeat.o(103941);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof d))
    {
      localObject = (d)parama;
      ((d)localObject).eeF = this.eeF;
      ((d)localObject).yjG = this.cEE;
    }
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103942);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103942);
    return i;
  }
  
  public final int getType()
  {
    return 610;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103943);
    ab.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.m
 * JD-Core Version:    0.7.0.1
 */