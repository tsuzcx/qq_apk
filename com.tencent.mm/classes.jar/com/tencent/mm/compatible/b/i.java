package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  implements h.a
{
  private AutomaticGainControl emw;
  
  @TargetApi(16)
  public i(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(92893);
    this.emw = null;
    boolean bool = AutomaticGainControl.isAvailable();
    ab.d("MicroMsg.MMAutomaticGainControl", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.emw = AutomaticGainControl.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(92893);
  }
  
  @TargetApi(16)
  public final boolean KB()
  {
    AppMethodBeat.i(92895);
    if (this.emw != null) {}
    try
    {
      int i = this.emw.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(92895);
        return true;
      }
      ab.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMAutomaticGainControl", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(92895);
    return false;
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    AppMethodBeat.i(92894);
    boolean bool = AutomaticGainControl.isAvailable();
    AppMethodBeat.o(92894);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.i
 * JD-Core Version:    0.7.0.1
 */