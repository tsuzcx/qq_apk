package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.eho;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends q
  implements m
{
  private i callback;
  d rr;
  
  public k()
  {
    AppMethodBeat.i(6151);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new eho();
    ((d.a)localObject1).iLO = new ehp();
    ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((d.a)localObject1).funcId = 2768;
    ((d.a)localObject1).iLP = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (eho)this.rr.iLK.iLR;
    Object localObject2 = f.cnr();
    if (localObject2 == null) {}
    for (;;)
    {
      ((eho)localObject1).Nhc = localLinkedList;
      AppMethodBeat.o(6151);
      return;
      localObject2 = ((ehp)localObject2).Nhd;
      if (!Util.isNullOrNil((List)localObject2))
      {
        localLinkedList = new LinkedList();
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (ehs)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            aau localaau = new aau();
            localaau.KJV = ((ehs)localObject3).KJV;
            long l = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjM(((ehs)localObject3).KJV);
            localObject3 = ag.ban().MP(l);
            if (localObject3 != null) {
              localaau.Lmc = ((int)(((z)localObject3).field_createTime / 1000L));
            }
            localLinkedList.add(localaau);
          }
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.k
 * JD-Core Version:    0.7.0.1
 */