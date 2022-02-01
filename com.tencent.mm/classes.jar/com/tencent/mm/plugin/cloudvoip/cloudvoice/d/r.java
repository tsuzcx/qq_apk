package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class r
{
  String tTJ = null;
  long tTK = -1L;
  long tTL = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(90931);
    if ((!Util.isNullOrNil(this.tTJ)) && (Util.ticksToNow(this.tTL + 3600L) / 1000L < this.tTK))
    {
      AppMethodBeat.o(90931);
      return true;
    }
    AppMethodBeat.o(90931);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(90932);
    String str = "OpenVoiceSessionKey{sessionKey='" + this.tTJ + '\'' + ", expireTicks=" + this.tTK + ", initTicks=" + this.tTL + '}';
    AppMethodBeat.o(90932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.r
 * JD-Core Version:    0.7.0.1
 */