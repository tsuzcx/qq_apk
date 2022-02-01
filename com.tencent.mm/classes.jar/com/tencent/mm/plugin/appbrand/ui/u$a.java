package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class u$a
  implements Runnable
{
  u$a(Context paramContext, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(51153);
    Object localObject = this.crf.getSystemService("power");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(51153);
      throw ((Throwable)localObject);
    }
    boolean bool = ((PowerManager)localObject).isInteractive();
    this.mKM.invoke(Boolean.valueOf(bool));
    AppMethodBeat.o(51153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u.a
 * JD-Core Version:    0.7.0.1
 */