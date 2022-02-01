package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private f callback;
  private LinkedList<bnj> dBa;
  private final b rr;
  
  public h(LinkedList<bnj> paramLinkedList)
  {
    AppMethodBeat.i(12458);
    this.dBa = paramLinkedList;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new aag();
    ((b.a)localObject).hQG = new aah();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((b.a)localObject).funcId = 181;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (aag)this.rr.hQD.hQJ;
    ((aag)localObject).GrC = paramLinkedList;
    ((aag)localObject).GrB = paramLinkedList.size();
    AppMethodBeat.o(12458);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12459);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12459);
    return i;
  }
  
  public final int getType()
  {
    return 181;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12460);
    updateDispatchId(paramInt1);
    ae.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (paramq.getRespObj().getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12460);
      return;
    }
    if (this.dBa != null)
    {
      paramq = this.dBa.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bnj)paramq.next();
        ae.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.Haw);
        r.zx(paramArrayOfByte.Haw);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.h
 * JD-Core Version:    0.7.0.1
 */