package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;

final class ExtControlProviderNearBy$2
  implements Runnable
{
  ExtControlProviderNearBy$2(ExtControlProviderNearBy paramExtControlProviderNearBy) {}
  
  public final void run()
  {
    AppMethodBeat.i(20363);
    if (ExtControlProviderNearBy.a(this.meN) == null) {
      ExtControlProviderNearBy.a(this.meN, d.agQ());
    }
    ExtControlProviderNearBy.a(this.meN).a(ExtControlProviderNearBy.b(this.meN), true);
    AppMethodBeat.o(20363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.2
 * JD-Core Version:    0.7.0.1
 */