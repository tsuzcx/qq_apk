package com.tencent.mm.plugin.appbrand.page.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$a$4
  implements Runnable
{
  f$a$4(f.a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(87356);
    try
    {
      this.iAs.setDescription(this.iAs.iAr.getContext().getResources().getString(this.fEK));
      AppMethodBeat.o(87356);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      this.iAs.setDescription(null);
      AppMethodBeat.o(87356);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f.a.4
 * JD-Core Version:    0.7.0.1
 */