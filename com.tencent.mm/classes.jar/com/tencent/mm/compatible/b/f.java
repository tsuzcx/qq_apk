package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  implements h.a
{
  private AcousticEchoCanceler elU;
  
  @TargetApi(16)
  public f(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(92838);
    this.elU = null;
    boolean bool = AcousticEchoCanceler.isAvailable();
    ab.d("MicroMsg.MMAcousticEchoCanceler", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.elU = AcousticEchoCanceler.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(92838);
  }
  
  @TargetApi(16)
  public final boolean KB()
  {
    AppMethodBeat.i(92840);
    if (this.elU != null) {}
    try
    {
      int i = this.elU.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(92840);
        return true;
      }
      ab.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(92840);
    return false;
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    AppMethodBeat.i(92839);
    boolean bool = AcousticEchoCanceler.isAvailable();
    AppMethodBeat.o(92839);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.f
 * JD-Core Version:    0.7.0.1
 */