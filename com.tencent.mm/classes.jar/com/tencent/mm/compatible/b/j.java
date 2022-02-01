package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  implements h.a
{
  private NoiseSuppressor gDn;
  
  @TargetApi(16)
  public j(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155614);
    this.gDn = null;
    boolean bool = NoiseSuppressor.isAvailable();
    Log.d("MicroMsg.MMNoiseSuppressor", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.gDn = NoiseSuppressor.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155614);
  }
  
  @TargetApi(16)
  public final boolean anE()
  {
    AppMethodBeat.i(155616);
    if (this.gDn != null) {}
    try
    {
      int i = this.gDn.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155616);
        return true;
      }
      Log.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMNoiseSuppressor", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(155616);
    return false;
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    AppMethodBeat.i(155615);
    boolean bool = NoiseSuppressor.isAvailable();
    AppMethodBeat.o(155615);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.b.j
 * JD-Core Version:    0.7.0.1
 */