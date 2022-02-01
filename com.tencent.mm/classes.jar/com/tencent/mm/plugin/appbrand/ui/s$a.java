package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class s$a
  implements Runnable
{
  s$a(Context paramContext, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(51153);
    Object localObject = this.cgl.getSystemService("power");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(51153);
      throw ((Throwable)localObject);
    }
    boolean bool = ((PowerManager)localObject).isInteractive();
    this.mfh.ay(Boolean.valueOf(bool));
    AppMethodBeat.o(51153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.s.a
 * JD-Core Version:    0.7.0.1
 */