package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  implements h.a
{
  private AutomaticGainControl fCM;
  
  @TargetApi(16)
  public i(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155611);
    this.fCM = null;
    boolean bool = AutomaticGainControl.isAvailable();
    ac.d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.fCM = AutomaticGainControl.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155611);
  }
  
  @TargetApi(16)
  public final boolean Xh()
  {
    AppMethodBeat.i(155613);
    if (this.fCM != null) {}
    try
    {
      int i = this.fCM.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155613);
        return true;
      }
      ac.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMAutomaticGainControl", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(155613);
    return false;
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    AppMethodBeat.i(155612);
    boolean bool = AutomaticGainControl.isAvailable();
    AppMethodBeat.o(155612);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.i
 * JD-Core Version:    0.7.0.1
 */