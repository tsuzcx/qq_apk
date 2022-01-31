package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p
  extends m
  implements k
{
  private f callback;
  Map<String, String> fyg;
  public b rr;
  
  public p(LinkedList<kq> paramLinkedList)
  {
    AppMethodBeat.i(11618);
    this.fyg = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (kq)((Iterator)localObject1).next();
      String str = ((kq)localObject2).wyb;
      localObject2 = ((kq)localObject2).wyh;
      if ((localObject2 != null) && (str != null)) {
        this.fyg.put(str, localObject2);
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).fsX = new aha();
    ((b.a)localObject1).fsY = new ahb();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
    ((b.a)localObject1).funcId = 1365;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).ado();
    ((aha)this.rr.fsV.fta).wZG = paramLinkedList;
    AppMethodBeat.o(11618);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11620);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11620);
    return i;
  }
  
  public final int getType()
  {
    return 1365;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11619);
    ab.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a.p
 * JD-Core Version:    0.7.0.1
 */