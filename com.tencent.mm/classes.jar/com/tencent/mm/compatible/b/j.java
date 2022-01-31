package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  implements h.a
{
  private NoiseSuppressor emx;
  
  @TargetApi(16)
  public j(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(92896);
    this.emx = null;
    boolean bool = NoiseSuppressor.isAvailable();
    ab.d("MicroMsg.MMNoiseSuppressor", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.emx = NoiseSuppressor.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(92896);
  }
  
  @TargetApi(16)
  public final boolean KB()
  {
    AppMethodBeat.i(92898);
    if (this.emx != null) {}
    try
    {
      int i = this.emx.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(92898);
        return true;
      }
      ab.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMNoiseSuppressor", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(92898);
    return false;
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    AppMethodBeat.i(92897);
    boolean bool = NoiseSuppressor.isAvailable();
    AppMethodBeat.o(92897);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.j
 * JD-Core Version:    0.7.0.1
 */