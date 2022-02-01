package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.af;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  b rr;
  
  public j()
  {
    AppMethodBeat.i(6151);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new dhh();
    ((b.a)localObject1).hvu = new dhi();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((b.a)localObject1).funcId = 2768;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (dhh)this.rr.hvr.hvw;
    Object localObject2 = e.bKr();
    if (localObject2 == null) {}
    for (;;)
    {
      ((dhh)localObject1).FQA = localLinkedList;
      AppMethodBeat.o(6151);
      return;
      localObject2 = ((dhi)localObject2).FQB;
      if (!bs.gY((List)localObject2))
      {
        localLinkedList = new LinkedList();
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (dhk)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            xd localxd = new xd();
            localxd.DSy = ((dhk)localObject3).DSy;
            long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNv(((dhk)localObject3).DSy);
            localObject3 = af.aDc().AA(l);
            if (localObject3 != null) {
              localxd.Erx = ((int)(((t)localObject3).field_createTime / 1000L));
            }
            localLinkedList.add(localxd);
          }
        }
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.j
 * JD-Core Version:    0.7.0.1
 */