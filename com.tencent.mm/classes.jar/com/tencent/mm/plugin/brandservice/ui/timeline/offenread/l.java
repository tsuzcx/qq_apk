package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.fmy;
import com.tencent.mm.protocal.protobuf.fmz;
import com.tencent.mm.protocal.protobuf.fnc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  c rr;
  
  public l()
  {
    AppMethodBeat.i(6151);
    Object localObject2 = new c.a();
    ((c.a)localObject2).otE = new fmy();
    ((c.a)localObject2).otF = new fmz();
    ((c.a)localObject2).uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
    ((c.a)localObject2).funcId = 2768;
    ((c.a)localObject2).otG = 0;
    ((c.a)localObject2).respCmdId = 0;
    this.rr = ((c.a)localObject2).bEF();
    localObject2 = (fmy)c.b.b(this.rr.otB);
    Object localObject3 = g.deD();
    if (localObject3 == null)
    {
      ((fmy)localObject2).abNb = ((LinkedList)localObject1);
      localObject1 = b.vPq;
      if (!b.dew()) {
        break label295;
      }
      localObject1 = b.vPq;
      if (!b.dex()) {
        break label295;
      }
    }
    label295:
    for (int i = 1;; i = 0)
    {
      ((fmy)localObject2).ZZN = i;
      AppMethodBeat.o(6151);
      return;
      localObject3 = ((fmz)localObject3).abNc;
      if (Util.isNullOrNil((List)localObject3)) {
        break;
      }
      localObject1 = new LinkedList();
      localObject3 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (fnc)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          ada localada = new ada();
          localada.YIf = ((fnc)localObject4).YIf;
          long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxx(((fnc)localObject4).YIf);
          localObject4 = af.bHl().yK(l);
          if (localObject4 != null) {
            localada.ZlC = ((int)(((ab)localObject4).field_createTime / 1000L));
          }
          ((LinkedList)localObject1).add(localada);
        }
      }
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(6153);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.l
 * JD-Core Version:    0.7.0.1
 */