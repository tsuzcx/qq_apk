package com.tencent.mm.plugin.appbrand.ui;

import a.f.a.a;
import a.f.b.k;
import a.l;
import a.y;
import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"doFinish", "", "invoke"})
final class i$a
  extends k
  implements a<y>
{
  i$a(com.tencent.mm.plugin.appbrand.task.i.a parama, Activity paramActivity)
  {
    super(0);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(134998);
    this.iPl.proceed();
    this.iPm.finish();
    AppMethodBeat.o(134998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i.a
 * JD-Core Version:    0.7.0.1
 */