package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;

final class a$3
  implements Runnable
{
  a$3(a parama, LaunchParcel paramLaunchParcel, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(132053);
    com.tencent.mm.plugin.appbrand.t.e.aNX();
    new com.tencent.mm.plugin.appbrand.launching.e(this.inR, this.hTC, new a.3.1(this)).run();
    AppMethodBeat.o(132053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.a.3
 * JD-Core Version:    0.7.0.1
 */