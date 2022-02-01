package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelmulti.x;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class a$5
  implements ad
{
  a$5(a parama) {}
  
  public final void cq(Object paramObject) {}
  
  public final void cr(Object paramObject)
  {
    AppMethodBeat.i(122398);
    MMHandlerThread localMMHandlerThread;
    String str;
    x localx;
    if ((paramObject instanceof p))
    {
      localMMHandlerThread = h.baH();
      str = ((p)paramObject).TAG;
      localx = ((p)paramObject).oMs;
      paramObject = (p)paramObject;
      if ((paramObject.oMA != null) && (paramObject.oMA.YyA.ZdG != null)) {
        break label82;
      }
    }
    label82:
    for (paramObject = null;; paramObject = paramObject.oMA.YyA.ZdG.vgO)
    {
      localMMHandlerThread.postToWorker(new a.a(str, localx, paramObject));
      AppMethodBeat.o(122398);
      return;
    }
  }
  
  public final void cs(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.5
 * JD-Core Version:    0.7.0.1
 */