package com.tencent.mm.plugin.appbrand.page.a;

import android.content.res.Resources.NotFoundException;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$a$2
  implements Runnable
{
  f$a$2(f.a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(87354);
    try
    {
      this.iAs.setLogo(b.k(this.iAs.iAr.getContext(), this.fEK));
      AppMethodBeat.o(87354);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      this.iAs.setLogo(null);
      AppMethodBeat.o(87354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f.a.2
 * JD-Core Version:    0.7.0.1
 */