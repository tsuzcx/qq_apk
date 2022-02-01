package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class q
  extends n
  implements k
{
  private g callback;
  Map<String, String> gZC;
  public b rr;
  
  public q(LinkedList<me> paramLinkedList)
  {
    AppMethodBeat.i(124304);
    this.gZC = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (me)((Iterator)localObject1).next();
      String str = ((me)localObject2).CIJ;
      localObject2 = ((me)localObject2).CIQ;
      if ((localObject2 != null) && (str != null)) {
        this.gZC.put(str, localObject2);
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).gUU = new aqh();
    ((b.a)localObject1).gUV = new aqi();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
    ((b.a)localObject1).funcId = 1365;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).atI();
    ((aqh)this.rr.gUS.gUX).Drv = paramLinkedList;
    AppMethodBeat.o(124304);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124306);
    this.callback = paramg;
    ad.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124306);
    return i;
  }
  
  public final int getType()
  {
    return 1365;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124305);
    ad.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.q
 * JD-Core Version:    0.7.0.1
 */