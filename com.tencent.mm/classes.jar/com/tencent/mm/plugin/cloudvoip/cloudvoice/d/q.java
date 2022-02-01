package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

final class q
{
  String pfT = null;
  long pfU = -1L;
  long pfV = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(90931);
    if ((!bu.isNullOrNil(this.pfT)) && (bu.aO(this.pfV + 3600L) / 1000L < this.pfU))
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
    String str = "OpenVoiceSessionKey{sessionKey='" + this.pfT + '\'' + ", expireTicks=" + this.pfU + ", initTicks=" + this.pfV + '}';
    AppMethodBeat.o(90932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q
 * JD-Core Version:    0.7.0.1
 */