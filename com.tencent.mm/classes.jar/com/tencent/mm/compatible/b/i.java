package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  implements h.a
{
  private AutomaticGainControl fWa;
  
  @TargetApi(16)
  public i(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155611);
    this.fWa = null;
    boolean bool = AutomaticGainControl.isAvailable();
    ad.d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.fWa = AutomaticGainControl.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155611);
  }
  
  @TargetApi(16)
  public final boolean ZI()
  {
    AppMethodBeat.i(155613);
    if (this.fWa != null) {}
    try
    {
      int i = this.fWa.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155613);
        return true;
      }
      ad.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMAutomaticGainControl", localException, "", new Object[0]);
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