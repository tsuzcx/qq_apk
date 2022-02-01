package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends q
  implements m
{
  private i callback;
  private LinkedList<caa> dSP;
  private final d rr;
  
  public h(LinkedList<caa> paramLinkedList)
  {
    AppMethodBeat.i(12458);
    this.dSP = paramLinkedList;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new abx();
    ((d.a)localObject).iLO = new aby();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((d.a)localObject).funcId = 181;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (abx)this.rr.iLK.iLR;
    ((abx)localObject).LmA = paramLinkedList;
    ((abx)localObject).Lmz = paramLinkedList.size();
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
    if (params.getRespObj().getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12460);
      return;
    }
    if (this.dSP != null)
    {
      params = this.dSP.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (caa)params.next();
        Log.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.Mfw);
        v.HZ(paramArrayOfByte.Mfw);
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