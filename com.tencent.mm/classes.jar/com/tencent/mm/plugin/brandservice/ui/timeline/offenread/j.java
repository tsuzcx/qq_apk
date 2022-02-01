package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dmw;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
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
    ((b.a)localObject1).hNM = new dmw();
    ((b.a)localObject1).hNN = new dmx();
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((b.a)localObject1).funcId = 2768;
    ((b.a)localObject1).hNO = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (dmw)this.rr.hNK.hNQ;
    Object localObject2 = e.bOS();
    if (localObject2 == null) {}
    for (;;)
    {
      ((dmw)localObject1).HBf = localLinkedList;
      AppMethodBeat.o(6151);
      return;
      localObject2 = ((dmx)localObject2).HBg;
      if (!bt.hj((List)localObject2))
      {
        localLinkedList = new LinkedList();
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (dmz)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            zc localzc = new zc();
            localzc.FxR = ((dmz)localObject3).FxR;
            long l = ((l)g.ab(l.class)).azp().aTm(((dmz)localObject3).FxR);
            localObject3 = ag.aGf().Dq(l);
            if (localObject3 != null) {
              localzc.FYH = ((int)(((w)localObject3).field_createTime / 1000L));
            }
            localLinkedList.add(localzc);
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