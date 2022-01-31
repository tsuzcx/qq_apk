package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class ExtControlProviderSNS$1
  implements ap.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(20377);
    ExtControlProviderSNS.Pt();
    AppMethodBeat.o(20377);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS.1
 * JD-Core Version:    0.7.0.1
 */