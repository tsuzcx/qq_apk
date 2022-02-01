package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.erq;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public l()
  {
    AppMethodBeat.i(6151);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new erq();
    ((d.a)localObject1).lBV = new err();
    ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((d.a)localObject1).funcId = 2768;
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (erq)d.b.b(this.rr.lBR);
    Object localObject2 = g.cBq();
    if (localObject2 == null) {}
    for (;;)
    {
      ((erq)localObject1).UtG = localLinkedList;
      AppMethodBeat.o(6151);
      return;
      localObject2 = ((err)localObject2).UtH;
      if (!Util.isNullOrNil((List)localObject2))
      {
        localLinkedList = new LinkedList();
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (eru)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            aba localaba = new aba();
            localaba.RKL = ((eru)localObject3).RKL;
            long l = ((n)h.ae(n.class)).bbL().bwk(((eru)localObject3).RKL);
            localObject3 = af.bjB().UA(l);
            if (localObject3 != null) {
              localaba.Snq = ((int)(((z)localObject3).field_createTime / 1000L));
            }
            localLinkedList.add(localaba);
          }
        }
      }
    }
  }
  
  public final err cBt()
  {
    AppMethodBeat.i(258173);
    err localerr = (err)d.c.b(this.rr.lBS);
    AppMethodBeat.o(258173);
    return localerr;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(6153);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(6153);
    return i;
  }
  
  public final int getType()
  {
    return 2768;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6152);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.l
 * JD-Core Version:    0.7.0.1
 */