package com.tencent.mm.plugin.appbrand.jsapi.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class a$b
  implements Runnable
{
  a$b(a parama, com.tencent.luggage.k.a.a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(196283);
    Object localObject1 = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).aVU();
    com.tencent.mm.plugin.appbrand.jsapi.c localc;
    Object localObject2;
    m localm;
    if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a.a.b))
    {
      localObject1 = this.jNK;
      localc = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).Dj();
      k.g(localc, "invokeContext.component");
      localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).AG();
      k.g(localObject2, "invokeContext.data");
      localm = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).aVU();
      k.g(localm, "invokeContext.jsApi");
      a.a((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).aVT());
      AppMethodBeat.o(196283);
      return;
    }
    if ((localObject1 instanceof d))
    {
      localObject1 = this.jNK;
      localc = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).Dj();
      k.g(localc, "invokeContext.component");
      localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).AG();
      k.g(localObject2, "invokeContext.data");
      localm = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).aVU();
      k.g(localm, "invokeContext.jsApi");
      a.b((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).aVT());
      AppMethodBeat.o(196283);
      return;
    }
    if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a.a.c))
    {
      localObject1 = this.jNK;
      localc = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).Dj();
      k.g(localc, "invokeContext.component");
      k.g(((com.tencent.mm.plugin.appbrand.i.b)this.jNL).AG(), "invokeContext.data");
      localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).aVU();
      k.g(localObject2, "invokeContext.jsApi");
      a.a((a)localObject1, localc, (m)localObject2, ((com.tencent.mm.plugin.appbrand.i.b)this.jNL).aVT());
    }
    AppMethodBeat.o(196283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */