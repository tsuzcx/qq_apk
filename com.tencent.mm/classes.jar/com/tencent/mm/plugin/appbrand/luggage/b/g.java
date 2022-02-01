package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.luggage.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;

public final class g
  implements a
{
  public final void a(k paramk)
  {
    AppMethodBeat.i(47485);
    if ((paramk instanceof b)) {
      ((b)paramk).dismiss();
    }
    AppMethodBeat.o(47485);
  }
  
  public final k au(Context paramContext)
  {
    AppMethodBeat.i(47484);
    paramContext = new d(paramContext);
    paramContext.setCancelable(false);
    AppMethodBeat.o(47484);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */