package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  implements h.a
{
  private AcousticEchoCanceler fVG;
  
  @TargetApi(16)
  public f(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155557);
    this.fVG = null;
    boolean bool = AcousticEchoCanceler.isAvailable();
    ad.d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.fVG = AcousticEchoCanceler.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155557);
  }
  
  @TargetApi(16)
  public final boolean ZI()
  {
    AppMethodBeat.i(155559);
    if (this.fVG != null) {}
    try
    {
      int i = this.fVG.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155559);
        return true;
      }
      ad.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", localException, "", new Object[0]);
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