package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.c;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class k$a
  implements Runnable
{
  k$a(c paramc, MultiProcessMMKV paramMultiProcessMMKV) {}
  
  public final void run()
  {
    String str = null;
    AppMethodBeat.i(139810);
    Object localObject1 = this.gUu.getStringSet("VideoCastDeviceManager.saveDevice", null);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = j.v((Collection)localObject1);
      localObject2 = this.mNf.bBo();
      if (localObject2 == null) {
        break label84;
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.g.b.b)localObject2).ljS;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (((List)localObject1).contains(localObject2))
        {
          this.gUu.putLong((String)localObject2, System.currentTimeMillis());
          AppMethodBeat.o(139810);
          return;
          localObject1 = null;
          break;
          label84:
          localObject2 = null;
          continue;
        }
        if (((List)localObject1).size() >= this.mNg) {
          new k.a.1(this, (List)localObject1, (String)localObject2).invoke();
        }
        com.tencent.mm.plugin.appbrand.g.b.b localb = this.mNf.bBo();
        if (localb != null) {
          str = localb.ljS;
        }
        ((List)localObject1).add(str);
        this.gUu.putStringSet("VideoCastDeviceManager.saveDevice", j.r((Iterable)localObject1));
        this.gUu.putLong((String)localObject2, System.currentTimeMillis());
        AppMethodBeat.o(139810);
        return;
      }
    }
    localObject1 = new android.support.v4.e.b();
    ((android.support.v4.e.b)localObject1).add(localObject2);
    this.gUu.putStringSet("VideoCastDeviceManager.saveDevice", (Set)localObject1);
    this.gUu.putLong((String)localObject2, System.currentTimeMillis());
    AppMethodBeat.o(139810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.k.a
 * JD-Core Version:    0.7.0.1
 */