package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.luggage.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.d;
import com.tencent.mm.plugin.appbrand.widget.b.k;

public final class i
  implements a
{
  public final void a(k paramk)
  {
    AppMethodBeat.i(132103);
    if ((paramk instanceof b)) {
      ((b)paramk).dismiss();
    }
    AppMethodBeat.o(132103);
  }
  
  public final k an(Context paramContext)
  {
    AppMethodBeat.i(132102);
    paramContext = new d(paramContext);
    paramContext.setCancelable(false);
    AppMethodBeat.o(132102);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */