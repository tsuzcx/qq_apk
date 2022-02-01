package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.aa;
import java.util.LinkedList;

public final class b$b
  implements k
{
  public final LinkedList<aa> nmN;
  
  private b$b()
  {
    AppMethodBeat.i(164055);
    this.nmN = new LinkedList();
    AppMethodBeat.o(164055);
  }
  
  public static b an(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(164056);
    b localb2 = (b)paramAppBrandRuntime.as(b.class);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      paramAppBrandRuntime.a(localb1);
    }
    AppMethodBeat.o(164056);
    return localb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.b.b
 * JD-Core Version:    0.7.0.1
 */