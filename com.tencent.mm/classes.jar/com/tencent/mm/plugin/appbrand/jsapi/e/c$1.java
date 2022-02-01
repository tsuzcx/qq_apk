package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.xlabeffect.d;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements Runnable
{
  c$1(c paramc, a parama, s params, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(226766);
    Object localObject1 = this.lUb;
    Object localObject2;
    if (a.lTL.lTN == null)
    {
      a.lTL.lTM = e.JRF;
      localObject2 = e.glu();
      d.gls();
      a.lTL.lTN = new FaceTracker((String)localObject2);
      ((a)localObject1).lTM = null;
      localObject1 = a.a.lTR;
      int i = a.a((a.a)localObject1);
      localObject2 = new HashMap(1);
      ((HashMap)localObject2).put("errCode", Integer.valueOf(i));
      if (localObject1 != a.a.lTR) {
        break label126;
      }
      localObject1 = "ok:init ok";
    }
    for (;;)
    {
      this.lsQ.i(this.cvP, this.lUd.n((String)localObject1, (Map)localObject2));
      AppMethodBeat.o(226766);
      return;
      localObject1 = a.a.lTT;
      break;
      label126:
      if (localObject1 == a.a.lTT) {
        localObject1 = "fail: already init";
      } else if (localObject1 == a.a.lTU) {
        localObject1 = "fail:init fail";
      } else {
        localObject1 = "fail:undefine error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.c.1
 * JD-Core Version:    0.7.0.1
 */