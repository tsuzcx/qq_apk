package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public final class b
  extends c.a
{
  private boolean iLx;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(132890);
    this.iLx = false;
    if ((paramContext instanceof Activity)) {
      this.iLx = o.b(((Activity)paramContext).getWindow());
    }
    AppMethodBeat.o(132890);
  }
  
  public final c aLZ()
  {
    AppMethodBeat.i(132891);
    c localc = super.aLZ();
    o.a(localc.getWindow(), this.iLx);
    AppMethodBeat.o(132891);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b
 * JD-Core Version:    0.7.0.1
 */