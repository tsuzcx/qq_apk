package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  implements h.a
{
  private AutomaticGainControl fYg;
  
  @TargetApi(16)
  public i(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155611);
    this.fYg = null;
    boolean bool = AutomaticGainControl.isAvailable();
    ae.d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.fYg = AutomaticGainControl.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155611);
  }
  
  @TargetApi(16)
  public final boolean ZR()
  {
    AppMethodBeat.i(155613);
    if (this.fYg != null) {}
    try
    {
      int i = this.fYg.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155613);
        return true;
      }
      ae.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMAutomaticGainControl", localException, "", new Object[0]);
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