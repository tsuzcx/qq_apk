package com.tencent.mm.plugin.appbrand.jsapi.aa.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b.c;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.j;
import d.l;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class k$a
  implements Runnable
{
  k$a(c paramc, ax paramax) {}
  
  public final void run()
  {
    String str = null;
    AppMethodBeat.i(139810);
    Object localObject1 = this.fKK.getStringSet("VideoCastDeviceManager.saveDevice", null);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = j.q((Collection)localObject1);
      localObject2 = this.kCH.aUL();
      if (localObject2 == null) {
        break label84;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.h.b.b)localObject2).jis;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (((List)localObject1).contains(localObject2))
        {
          this.fKK.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(139810);
          return;
          localObject1 = null;
          break;
          label84:
          localObject2 = null;
          continue;
        }
        if (((List)localObject1).size() >= this.kCI) {
          new k.a.1(this, (List)localObject1, (String)localObject2).invoke();
        }
        com.tencent.mm.plugin.appbrand.h.b.b localb = this.kCH.aUL();
        if (localb != null) {
          str = localb.jis;
        }
        ((List)localObject1).add(str);
        this.fKK.putStringSet("VideoCastDeviceManager.saveDevice", j.o((Iterable)localObject1));
        this.fKK.putLong((String)localObject2, System.currentTimeMillis());
        AppMethodBeat.o(139810);
        return;
      }
    }
    localObject1 = new android.support.v4.e.b();
    ((android.support.v4.e.b)localObject1).add(localObject2);
    this.fKK.putStringSet("VideoCastDeviceManager.saveDevice", (Set)localObject1);
    this.fKK.putLong((String)localObject2, System.currentTimeMillis());
    AppMethodBeat.o(139810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.k.a
 * JD-Core Version:    0.7.0.1
 */