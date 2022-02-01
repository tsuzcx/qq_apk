package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  Map<String, String> lGR;
  public d rr;
  
  public q(LinkedList<nk> paramLinkedList)
  {
    AppMethodBeat.i(124304);
    this.lGR = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (nk)((Iterator)localObject1).next();
      String str = ((nk)localObject2).RUi;
      localObject2 = ((nk)localObject2).RUp;
      if ((localObject2 != null) && (str != null)) {
        this.lGR.put(str, localObject2);
      }
    }
    localObject1 = new d.a();
    ((d.a)localObject1).lBU = new bqs();
    ((d.a)localObject1).lBV = new bqt();
    ((d.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
    ((d.a)localObject1).funcId = 1365;
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).bgN();
    ((bqs)d.b.b(this.rr.lBR)).TbR = paramLinkedList;
    AppMethodBeat.o(124304);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124306);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124306);
    return i;
  }
  
  public final int getType()
  {
    return 1365;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124305);
    Log.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.a.q
 * JD-Core Version:    0.7.0.1
 */