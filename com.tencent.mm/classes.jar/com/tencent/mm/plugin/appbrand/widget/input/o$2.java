package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;

final class o$2
  implements Runnable
{
  o$2(v paramv, String paramString, Integer paramInteger) {}
  
  public final void run()
  {
    AppMethodBeat.i(123678);
    Object localObject = (ab)o.aQV().get(this.hEe);
    if (localObject != null)
    {
      localObject = o.a(this.hEe, ((ab)localObject).getInputId());
      if (localObject != null) {
        ((aa)localObject).a(this.bBG, this.jmm);
      }
    }
    AppMethodBeat.o(123678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o.2
 * JD-Core Version:    0.7.0.1
 */