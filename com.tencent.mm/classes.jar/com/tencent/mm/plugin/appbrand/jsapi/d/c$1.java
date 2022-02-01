package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.xlabeffect.d;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements Runnable
{
  c$1(c paramc, a parama, r paramr, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(222462);
    Object localObject1 = this.kPd;
    Object localObject2;
    if (a.kON.kOP == null)
    {
      a.kON.kOO = e.FaL;
      localObject2 = e.fcl();
      d.fcj();
      a.kON.kOP = new FaceTracker((String)localObject2);
      ((a)localObject1).kOO = null;
      localObject1 = a.a.kOT;
      int i = a.a((a.a)localObject1);
      localObject2 = new HashMap(1);
      ((HashMap)localObject2).put("errCode", Integer.valueOf(i));
      if (localObject1 != a.a.kOT) {
        break label126;
      }
      localObject1 = "ok:init ok";
    }
    for (;;)
    {
      this.kph.h(this.cjS, this.kPf.n((String)localObject1, (Map)localObject2));
      AppMethodBeat.o(222462);
      return;
      localObject1 = a.a.kOV;
      break;
      label126:
      if (localObject1 == a.a.kOV) {
        localObject1 = "fail: already init";
      } else if (localObject1 == a.a.kOW) {
        localObject1 = "fail:init fail";
      } else {
        localObject1 = "fail:undefine error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.c.1
 * JD-Core Version:    0.7.0.1
 */