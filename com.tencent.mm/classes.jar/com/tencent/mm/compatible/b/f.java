package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  implements h.a
{
  private AcousticEchoCanceler gCS;
  
  @TargetApi(16)
  public f(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155557);
    this.gCS = null;
    boolean bool = AcousticEchoCanceler.isAvailable();
    Log.d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.gCS = AcousticEchoCanceler.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155557);
  }
  
  @TargetApi(16)
  public final boolean anE()
  {
    AppMethodBeat.i(155559);
    if (this.gCS != null) {}
    try
    {
      int i = this.gCS.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155559);
        return true;
      }
      Log.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(155559);
    return false;
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    AppMethodBeat.i(155558);
    boolean bool = AcousticEchoCanceler.isAvailable();
    AppMethodBeat.o(155558);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.b.f
 * JD-Core Version:    0.7.0.1
 */