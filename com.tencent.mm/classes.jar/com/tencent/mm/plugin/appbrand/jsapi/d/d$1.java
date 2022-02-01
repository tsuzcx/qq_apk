package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.Map;

final class d$1
  implements Runnable
{
  d$1(d paramd, a parama, r paramr, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(222464);
    Object localObject;
    HashMap localHashMap;
    if (a.kON.kOP != null)
    {
      localObject = a.kON.kOP;
      if (((FaceTracker)localObject).LYd != 0L) {
        ((FaceTracker)localObject).nDestroy(((FaceTracker)localObject).LYd);
      }
      a.kON.kOP = null;
      localObject = a.a.kOT;
      int i = a.a((a.a)localObject);
      localHashMap = new HashMap(1);
      localHashMap.put("errCode", Integer.valueOf(i));
      if (localObject != a.a.kOT) {
        break label119;
      }
      localObject = "ok:stop ok";
    }
    for (;;)
    {
      this.kph.h(this.cjS, this.kPg.n((String)localObject, localHashMap));
      AppMethodBeat.o(222464);
      return;
      localObject = a.a.kOZ;
      break;
      label119:
      if (localObject == a.a.kOZ) {
        localObject = "fail:stop fail";
      } else {
        localObject = "fail:undefine error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.d.1
 * JD-Core Version:    0.7.0.1
 */