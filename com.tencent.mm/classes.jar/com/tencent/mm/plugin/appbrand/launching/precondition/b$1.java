package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;

final class b$1
  implements e.a
{
  b$1(b paramb, LaunchParcel paramLaunchParcel) {}
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(154330);
    if (this.inR.inK != null) {
      this.inR.inK.b(paramInt, paramIntent);
    }
    AppMethodBeat.o(154330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.b.1
 * JD-Core Version:    0.7.0.1
 */