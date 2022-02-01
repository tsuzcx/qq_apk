package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  implements h.a
{
  private AcousticEchoCanceler fCs;
  
  @TargetApi(16)
  public f(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155557);
    this.fCs = null;
    boolean bool = AcousticEchoCanceler.isAvailable();
    ac.d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.fCs = AcousticEchoCanceler.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155557);
  }
  
  @TargetApi(16)
  public final boolean Xh()
  {
    AppMethodBeat.i(155559);
    if (this.fCs != null) {}
    try
    {
      int i = this.fCs.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155559);
        return true;
      }
      ac.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", localException, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.f
 * JD-Core Version:    0.7.0.1
 */