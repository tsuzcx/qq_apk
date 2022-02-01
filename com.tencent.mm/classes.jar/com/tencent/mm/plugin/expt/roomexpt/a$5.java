package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class a$5
  implements ad
{
  a$5(a parama) {}
  
  public final void aU(Object paramObject) {}
  
  public final void aV(Object paramObject)
  {
    AppMethodBeat.i(122398);
    MMHandlerThread localMMHandlerThread;
    String str;
    r localr;
    if ((paramObject instanceof k))
    {
      localMMHandlerThread = h.aHJ();
      str = ((k)paramObject).TAG;
      localr = ((k)paramObject).lTz;
      paramObject = (k)paramObject;
      if ((paramObject.lTH != null) && (paramObject.lTH.RBX.SfL != null)) {
        break label82;
      }
    }
    label82:
    for (paramObject = null;; paramObject = paramObject.lTH.RBX.SfL.rVy)
    {
      localMMHandlerThread.postToWorker(new a.a(str, localr, paramObject));
      AppMethodBeat.o(122398);
      return;
    }
  }
  
  public final void aW(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.5
 * JD-Core Version:    0.7.0.1
 */