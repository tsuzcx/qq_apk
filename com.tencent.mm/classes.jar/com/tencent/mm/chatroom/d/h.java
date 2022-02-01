package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private g callback;
  private LinkedList<bij> doh;
  private final b rr;
  
  public h(LinkedList<bij> paramLinkedList)
  {
    AppMethodBeat.i(12458);
    this.doh = paramLinkedList;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ye();
    ((b.a)localObject).hvu = new yf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((b.a)localObject).funcId = 181;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ye)this.rr.hvr.hvw;
    ((ye)localObject).ErT = paramLinkedList;
    ((ye)localObject).ErS = paramLinkedList.size();
    AppMethodBeat.o(12458);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(12459);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12459);
    return i;
  }
  
  public final int getType()
  {
    return 181;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12460);
    updateDispatchId(paramInt1);
    ac.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (paramq.getRespObj().getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12460);
      return;
    }
    if (this.doh != null)
    {
      paramq = this.doh.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bij)paramq.next();
        ac.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.EXy);
        com.tencent.mm.model.q.vW(paramArrayOfByte.EXy);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.h
 * JD-Core Version:    0.7.0.1
 */