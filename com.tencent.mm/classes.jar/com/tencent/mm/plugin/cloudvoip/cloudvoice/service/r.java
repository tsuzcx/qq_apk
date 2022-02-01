package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class r
{
  String wXa = null;
  long wXb = -1L;
  long wXc = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(90931);
    if ((!Util.isNullOrNil(this.wXa)) && (Util.ticksToNow(this.wXc + 3600L) / 1000L < this.wXb))
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
    String str = "OpenVoiceSessionKey{sessionKey='" + this.wXa + '\'' + ", expireTicks=" + this.wXb + ", initTicks=" + this.wXc + '}';
    AppMethodBeat.o(90932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.r
 * JD-Core Version:    0.7.0.1
 */