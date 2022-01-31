package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class ExtControlProviderNearBy$1
  implements ap.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(20362);
    ExtControlProviderNearBy.Pt();
    AppMethodBeat.o(20362);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.1
 * JD-Core Version:    0.7.0.1
 */