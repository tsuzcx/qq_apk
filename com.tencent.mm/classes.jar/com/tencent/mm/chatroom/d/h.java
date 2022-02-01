package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends q
  implements m
{
  private i callback;
  private LinkedList<chv> fMn;
  private final d rr;
  
  public h(LinkedList<chv> paramLinkedList)
  {
    AppMethodBeat.i(12458);
    this.fMn = paramLinkedList;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ace();
    ((d.a)localObject).lBV = new acf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((d.a)localObject).funcId = 181;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ace)d.b.b(this.rr.lBR);
    ((ace)localObject).SnO = paramLinkedList;
    ((ace)localObject).SnN = paramLinkedList.size();
    AppMethodBeat.o(12458);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12459);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12459);
    return i;
  }
  
  public final int getType()
  {
    return 181;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12460);
    updateDispatchId(paramInt1);
    Log.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    d.c.b(((d)params).lBS);
    if (params.getRespObj().getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12460);
      return;
    }
    if (this.fMn != null)
    {
      params = this.fMn.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (chv)params.next();
        Log.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.Tpa);
        v.Pp(paramArrayOfByte.Tpa);
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