package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class s
  extends n
  implements k
{
  private g callback;
  Object data;
  Map<String, String> gZD;
  public b rr;
  
  public s(LinkedList<og> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124310);
    this.gZD = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (og)((Iterator)localObject1).next();
      Object localObject3 = ((og)localObject2).CLT;
      localObject2 = ((og)localObject2).CIQ;
      if ((localObject2 != null) && (localObject3 != null) && (((LinkedList)localObject3).size() > 0))
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          this.gZD.put(str, localObject2);
        }
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).gUU = new aqn();
    ((b.a)localObject1).gUV = new aqo();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
    ((b.a)localObject1).funcId = 1353;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).atI();
    ((aqn)this.rr.gUS.gUX).Drx = paramLinkedList;
    this.data = paramObject;
    AppMethodBeat.o(124310);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124312);
    this.callback = paramg;
    ad.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124312);
    return i;
  }
  
  public final int getType()
  {
    return 1353;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124311);
    ad.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.s
 * JD-Core Version:    0.7.0.1
 */