package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  implements h.a
{
  private AcousticEchoCanceler fXM;
  
  @TargetApi(16)
  public f(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155557);
    this.fXM = null;
    boolean bool = AcousticEchoCanceler.isAvailable();
    ae.d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.fXM = AcousticEchoCanceler.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155557);
  }
  
  @TargetApi(16)
  public final boolean ZR()
  {
    AppMethodBeat.i(155559);
    if (this.fXM != null) {}
    try
    {
      int i = this.fXM.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155559);
        return true;
      }
      ae.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", localException, "", new Object[0]);
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