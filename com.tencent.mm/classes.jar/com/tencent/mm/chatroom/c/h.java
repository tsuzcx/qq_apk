package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends m
  implements k
{
  public List<String> cAs;
  private f callback;
  private b rr;
  
  public h(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(103922);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new wp();
    ((b.a)localObject).fsY = new wq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delchatroommember";
    ((b.a)localObject).funcId = 179;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (wp)this.rr.fsV.fta;
    ((wp)localObject).wot = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      wz localwz = new wz();
      localwz.wOY = aa.wA(str);
      paramString.add(localwz);
    }
    ((wp)localObject).wov = paramString;
    ((wp)localObject).eeF = paramString.size();
    ((wp)localObject).Scene = paramInt;
    this.cAs = paramList;
    AppMethodBeat.o(103922);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103923);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103923);
    return i;
  }
  
  public final int getType()
  {
    return 179;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103924);
    updateDispatchId(paramInt1);
    ab.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (wp)this.rr.fsV.fta;
    paramArrayOfByte = (wq)this.rr.fsW.fta;
    if (this.rr.fsW.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103924);
      return;
    }
    n.a(paramq.wot, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.h
 * JD-Core Version:    0.7.0.1
 */