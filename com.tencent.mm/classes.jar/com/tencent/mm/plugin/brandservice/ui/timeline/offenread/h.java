package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.am.af;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dbv;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  b rr;
  
  public h()
  {
    AppMethodBeat.i(6151);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new dbv();
    ((b.a)localObject1).gUV = new dbw();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((b.a)localObject1).funcId = 2768;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (dbv)this.rr.gUS.gUX;
    Object localObject2 = e.bDe();
    if (localObject2 == null) {}
    for (;;)
    {
      ((dbv)localObject1).Ety = localLinkedList;
      AppMethodBeat.o(6151);
      return;
      localObject2 = ((dbw)localObject2).Etz;
      if (!bt.gL((List)localObject2))
      {
        localLinkedList = new LinkedList();
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (dby)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            wr localwr = new wr();
            localwr.CAc = ((dby)localObject3).CAc;
            long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIa(((dby)localObject3).CAc);
            localObject3 = af.awk().vX(l);
            if (localObject3 != null) {
              localwr.CYM = ((int)(((s)localObject3).field_createTime / 1000L));
            }
            localLinkedList.add(localwr);
          }
        }
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(6153);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6153);
    return i;
  }
  
  public final int getType()
  {
    return 2768;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6152);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h
 * JD-Core Version:    0.7.0.1
 */