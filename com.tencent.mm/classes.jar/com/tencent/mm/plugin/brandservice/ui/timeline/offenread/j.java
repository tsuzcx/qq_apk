package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements k
{
  private f callback;
  b rr;
  
  public j()
  {
    AppMethodBeat.i(6151);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dnt();
    ((b.a)localObject1).hQG = new dnu();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((b.a)localObject1).funcId = 2768;
    ((b.a)localObject1).hQH = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (dnt)this.rr.hQD.hQJ;
    Object localObject2 = e.bPQ();
    if (localObject2 == null) {}
    for (;;)
    {
      ((dnt)localObject1).HUS = localLinkedList;
      AppMethodBeat.o(6151);
      return;
      localObject2 = ((dnu)localObject2).HUT;
      if (!bu.ht((List)localObject2))
      {
        localLinkedList = new LinkedList();
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (dnw)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            zf localzf = new zf();
            localzf.FQp = ((dnw)localObject3).FQp;
            long l = ((l)g.ab(l.class)).azF().aUN(((dnw)localObject3).FQp);
            localObject3 = ag.aGv().DP(l);
            if (localObject3 != null) {
              localzf.Grg = ((int)(((w)localObject3).field_createTime / 1000L));
            }
            localLinkedList.add(localzf);
          }
        }
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(6153);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.j
 * JD-Core Version:    0.7.0.1
 */