package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.Map;

final class d$1
  implements Runnable
{
  d$1(d paramd, a parama, s params, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(226768);
    Object localObject;
    HashMap localHashMap;
    if (a.lTL.lTN != null)
    {
      localObject = a.lTL.lTN;
      if (((FaceTracker)localObject).Rxd != 0L) {
        ((FaceTracker)localObject).nDestroy(((FaceTracker)localObject).Rxd);
      }
      a.lTL.lTN = null;
      localObject = a.a.lTR;
      int i = a.a((a.a)localObject);
      localHashMap = new HashMap(1);
      localHashMap.put("errCode", Integer.valueOf(i));
      if (localObject != a.a.lTR) {
        break label119;
      }
      localObject = "ok:stop ok";
    }
    for (;;)
    {
      this.lsQ.i(this.cvP, this.lUe.n((String)localObject, localHashMap));
      AppMethodBeat.o(226768);
      return;
      localObject = a.a.lTX;
      break;
      label119:
      if (localObject == a.a.lTX) {
        localObject = "fail:stop fail";
      } else {
        localObject = "fail:undefine error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.d.1
 * JD-Core Version:    0.7.0.1
 */