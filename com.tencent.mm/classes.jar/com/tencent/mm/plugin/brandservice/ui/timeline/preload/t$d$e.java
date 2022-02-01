package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
final class t$d$e
  extends q
  implements d.g.a.a<Integer>
{
  t$d$e(t.d paramd)
  {
    super(0);
  }
  
  private int cBg()
  {
    AppMethodBeat.i(224141);
    Object localObject1 = t.oqh;
    Object localObject3 = t.bQH();
    localObject1 = this.oqt.oqq;
    localObject3 = (ay)((as)localObject3).aRy((String)localObject1);
    int i;
    if (localObject3 != null) {
      if (((ay)localObject3).containsKey((String)localObject1))
      {
        localObject1 = ((ay)localObject3).decodeBytes((String)localObject1);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label115;
            }
            i = 1;
            label65:
            if (i == 0) {
              break label136;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = efz.class.newInstance();
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bw.a)localObject3;
        localObject1 = (efz)localObject1;
        if (localObject1 == null) {
          break label146;
        }
        i = ((efz)localObject1).nLC;
        AppMethodBeat.o(224141);
        return i;
      }
      catch (Exception localException)
      {
        label115:
        ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label65;
      label136:
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
    label146:
    AppMethodBeat.o(224141);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.d.e
 * JD-Core Version:    0.7.0.1
 */