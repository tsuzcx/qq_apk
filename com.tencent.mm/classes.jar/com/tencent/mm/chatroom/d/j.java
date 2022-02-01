package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends p
  implements m
{
  private h callback;
  private LinkedList<cxv> hRX;
  private final c rr;
  
  public j(LinkedList<cxv> paramLinkedList)
  {
    AppMethodBeat.i(12458);
    this.hRX = paramLinkedList;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aei();
    ((c.a)localObject).otF = new aej();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/collectchatroom";
    ((c.a)localObject).funcId = 181;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (aei)c.b.b(this.rr.otB);
    ((aei)localObject).Zmm = paramLinkedList;
    ((aei)localObject).Zml = paramLinkedList.size();
    AppMethodBeat.o(12458);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12459);
    this.callback = paramh;
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
    c.c.b(((c)params).otC);
    if (params.getRespObj().getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12460);
      return;
    }
    if (this.hRX != null)
    {
      params = this.hRX.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (cxv)params.next();
        Log.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + paramArrayOfByte.aaDc);
        v.Ii(paramArrayOfByte.aaDc);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.j
 * JD-Core Version:    0.7.0.1
 */