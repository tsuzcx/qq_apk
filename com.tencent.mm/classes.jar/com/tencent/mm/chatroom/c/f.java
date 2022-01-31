package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private LinkedList<atq> cAn;
  private com.tencent.mm.ai.f callback;
  private final b rr;
  
  public f(LinkedList<atq> paramLinkedList)
  {
    AppMethodBeat.i(103913);
    this.cAn = paramLinkedList;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new um();
    ((b.a)localObject).fsY = new un();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((b.a)localObject).funcId = 181;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (um)this.rr.fsV.fta;
    ((um)localObject).wMK = paramLinkedList;
    ((um)localObject).wMJ = paramLinkedList.size();
    AppMethodBeat.o(103913);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(103914);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103914);
    return i;
  }
  
  public final int getType()
  {
    return 181;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103915);
    updateDispatchId(paramInt1);
    ab.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (paramq.getRespObj().getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103915);
      return;
    }
    if (this.cAn != null)
    {
      paramq = this.cAn.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (atq)paramq.next();
        ab.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.xiK);
        n.nq(paramArrayOfByte.xiK);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.f
 * JD-Core Version:    0.7.0.1
 */