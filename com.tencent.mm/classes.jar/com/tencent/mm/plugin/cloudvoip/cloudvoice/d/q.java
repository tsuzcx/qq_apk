package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class q
{
  String oZp = null;
  long oZq = -1L;
  long oZr = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(90931);
    if ((!bt.isNullOrNil(this.oZp)) && (bt.aO(this.oZr + 3600L) / 1000L < this.oZq))
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
    String str = "OpenVoiceSessionKey{sessionKey='" + this.oZp + '\'' + ", expireTicks=" + this.oZq + ", initTicks=" + this.oZr + '}';
    AppMethodBeat.o(90932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q
 * JD-Core Version:    0.7.0.1
 */