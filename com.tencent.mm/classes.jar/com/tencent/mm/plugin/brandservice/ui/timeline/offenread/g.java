package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends m
  implements k
{
  private f callback;
  b rr;
  
  public g()
  {
    AppMethodBeat.i(14359);
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new ckc();
    ((b.a)localObject1).fsY = new ckd();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((b.a)localObject1).funcId = 2768;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (ckc)this.rr.fsV.fta;
    Object localObject2 = d.aXb();
    if (localObject2 == null) {}
    for (;;)
    {
      ((ckc)localObject1).xUf = localLinkedList;
      AppMethodBeat.o(14359);
      return;
      localObject2 = ((ckd)localObject2).xUg;
      if (!bo.es((List)localObject2))
      {
        localLinkedList = new LinkedList();
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (cke)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            tt localtt = new tt();
            localtt.wqR = ((cke)localObject3).wqR;
            long l = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arx(((cke)localObject3).wqR);
            localObject3 = z.afo().ob(l);
            if (localObject3 != null) {
              localtt.wMp = ((int)(((com.tencent.mm.storage.q)localObject3).field_createTime / 1000L));
            }
            localLinkedList.add(localtt);
          }
        }
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(14361);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(14361);
    return i;
  }
  
  public final int getType()
  {
    return 2768;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14360);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(14360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g
 * JD-Core Version:    0.7.0.1
 */