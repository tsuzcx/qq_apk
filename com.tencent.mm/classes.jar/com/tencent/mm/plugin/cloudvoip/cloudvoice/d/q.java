package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

final class q
{
  String ovU = null;
  long ovV = -1L;
  long ovW = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(90931);
    if ((!bs.isNullOrNil(this.ovU)) && (bs.aO(this.ovW + 3600L) / 1000L < this.ovV))
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
    String str = "OpenVoiceSessionKey{sessionKey='" + this.ovU + '\'' + ", expireTicks=" + this.ovV + ", initTicks=" + this.ovW + '}';
    AppMethodBeat.o(90932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q
 * JD-Core Version:    0.7.0.1
 */