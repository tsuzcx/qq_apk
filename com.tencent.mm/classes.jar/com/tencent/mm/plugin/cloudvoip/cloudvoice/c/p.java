package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class p
{
  String kMp = null;
  long kMq = -1L;
  long kMr = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(135587);
    if ((!bo.isNullOrNil(this.kMp)) && (bo.av(this.kMr + 3600L) / 1000L < this.kMq))
    {
      AppMethodBeat.o(135587);
      return true;
    }
    AppMethodBeat.o(135587);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135588);
    String str = "OpenVoiceSessionKey{sessionKey='" + this.kMp + '\'' + ", expireTicks=" + this.kMq + ", initTicks=" + this.kMr + '}';
    AppMethodBeat.o(135588);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.p
 * JD-Core Version:    0.7.0.1
 */