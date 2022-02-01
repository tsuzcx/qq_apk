package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class p
{
  String nSA = null;
  long nSB = -1L;
  long nSC = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(90931);
    if ((!bt.isNullOrNil(this.nSA)) && (bt.aS(this.nSC + 3600L) / 1000L < this.nSB))
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
    String str = "OpenVoiceSessionKey{sessionKey='" + this.nSA + '\'' + ", expireTicks=" + this.nSB + ", initTicks=" + this.nSC + '}';
    AppMethodBeat.o(90932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p
 * JD-Core Version:    0.7.0.1
 */