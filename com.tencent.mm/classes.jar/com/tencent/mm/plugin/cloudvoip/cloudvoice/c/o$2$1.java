package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class o$2$1
  implements Runnable
{
  o$2$1(o.2 param2, uy paramuy, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(135510);
    Object localObject1 = o.m(this.kLK.kLI);
    ??? = this.kLJ;
    if ((??? == null) || (((uy)???).wpb == null) || (((uy)???).wpb.size() == 0))
    {
      ((j)localObject1).kKm.clear();
      localObject1 = o.l(this.kLK.kLI);
      ??? = this.kLJ;
      ab.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "updateMembers");
      if ((??? != null) && (((uy)???).wpb != null) && (((uy)???).wpb.size() != 0)) {
        break label211;
      }
    }
    for (;;)
    {
      if (o.e(this.kLK.kLI) == o.d.kMn)
      {
        if (o.n(this.kLK.kLI) == null)
        {
          ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: mCurrentMemeberChangeCallback is null");
          AppMethodBeat.o(135510);
          return;
          ??? = ((uy)???).wpb;
          ((j)localObject1).kKm.clear();
          ??? = ((LinkedList)???).iterator();
          Object localObject5;
          while (((Iterator)???).hasNext())
          {
            localObject4 = (ux)((Iterator)???).next();
            localObject5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b();
            ((com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b)localObject5).kJx = ((ux)localObject4).wNy;
            ((com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b)localObject5).openId = ((ux)localObject4).wys;
            ((j)localObject1).kKm.add(localObject5);
          }
          break;
          label211:
          Object localObject4 = ((uy)???).wpb;
          synchronized (((r)localObject1).kMy)
          {
            localObject4 = ((LinkedList)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (ux)((Iterator)localObject4).next();
              c localc = (c)((r)localObject1).kMy.get(((ux)localObject5).wys);
              if (localc != null) {
                localc.tG(((ux)localObject5).wNy);
              }
            }
          }
          continue;
        }
        if (this.val$errCode == 0)
        {
          o.n(this.kLK.kLI).a(0, 0, "ok", o.m(this.kLK.kLI).kKm);
          AppMethodBeat.o(135510);
          return;
        }
        ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: invalid member list change. will ignore");
        o.n(this.kLK.kLI).a(-10087, this.val$errCode, "error in member change", null);
        AppMethodBeat.o(135510);
        return;
      }
    }
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room. do not notify");
    AppMethodBeat.o(135510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.2.1
 * JD-Core Version:    0.7.0.1
 */