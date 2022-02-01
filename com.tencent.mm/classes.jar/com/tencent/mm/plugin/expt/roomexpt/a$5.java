package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class a$5
  implements z
{
  a$5(a parama) {}
  
  public final void aQ(Object paramObject) {}
  
  public final void aR(Object paramObject)
  {
    AppMethodBeat.i(122398);
    MMHandlerThread localMMHandlerThread;
    String str;
    r localr;
    if ((paramObject instanceof k))
    {
      localMMHandlerThread = g.aAk();
      str = ((k)paramObject).TAG;
      localr = ((k)paramObject).jda;
      paramObject = (k)paramObject;
      if ((paramObject.jdi != null) && (paramObject.jdi.KAh.Ley != null)) {
        break label82;
      }
    }
    label82:
    for (paramObject = null;; paramObject = paramObject.jdi.KAh.Ley.oTA)
    {
      localMMHandlerThread.postToWorker(new a.a(str, localr, paramObject));
      AppMethodBeat.o(122398);
      return;
    }
  }
  
  public final void aS(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.5
 * JD-Core Version:    0.7.0.1
 */