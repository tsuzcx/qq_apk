package com.tencent.mm.compatible.b;

import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  implements h.a
{
  private AutomaticGainControl lQD;
  
  public i(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155611);
    this.lQD = null;
    boolean bool = AutomaticGainControl.isAvailable();
    Log.d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.lQD = AutomaticGainControl.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155611);
  }
  
  public final boolean aOe()
  {
    AppMethodBeat.i(155613);
    if (this.lQD != null) {}
    try
    {
      int i = this.lQD.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155613);
        return true;
      }
      Log.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMAutomaticGainControl", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(155613);
    return false;
  }
  
  public final boolean isAvailable()
  {
    AppMethodBeat.i(155612);
    boolean bool = AutomaticGainControl.isAvailable();
    AppMethodBeat.o(155612);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.b.i
 * JD-Core Version:    0.7.0.1
 */