package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class r
{
  String quX = null;
  long quY = -1L;
  long quZ = -1L;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(90931);
    if ((!Util.isNullOrNil(this.quX)) && (Util.ticksToNow(this.quZ + 3600L) / 1000L < this.quY))
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
    String str = "OpenVoiceSessionKey{sessionKey='" + this.quX + '\'' + ", expireTicks=" + this.quY + ", initTicks=" + this.quZ + '}';
    AppMethodBeat.o(90932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.r
 * JD-Core Version:    0.7.0.1
 */