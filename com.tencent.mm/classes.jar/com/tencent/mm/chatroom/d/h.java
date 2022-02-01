package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private f callback;
  private LinkedList<bmr> dzV;
  private final b rr;
  
  public h(LinkedList<bmr> paramLinkedList)
  {
    AppMethodBeat.i(12458);
    this.dzV = paramLinkedList;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aad();
    ((b.a)localObject).hNN = new aae();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((b.a)localObject).funcId = 181;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (aad)this.rr.hNK.hNQ;
    ((aad)localObject).FZc = paramLinkedList;
    ((aad)localObject).FZb = paramLinkedList.size();
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12460);
    updateDispatchId(paramInt1);
    ad.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (paramq.getRespObj().getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12460);
      return;
    }
    if (this.dzV != null)
    {
      paramq = this.dzV.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bmr)paramq.next();
        ad.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.GGU);
        com.tencent.mm.model.q.yN(paramArrayOfByte.GGU);
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