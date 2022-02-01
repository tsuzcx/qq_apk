package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  implements h.a
{
  private NoiseSuppressor fzg;
  
  @TargetApi(16)
  public j(AudioRecord paramAudioRecord)
  {
    AppMethodBeat.i(155614);
    this.fzg = null;
    boolean bool = NoiseSuppressor.isAvailable();
    ad.d("MicroMsg.MMNoiseSuppressor", "available  ".concat(String.valueOf(bool)));
    if (bool) {
      this.fzg = NoiseSuppressor.create(paramAudioRecord.getAudioSessionId());
    }
    AppMethodBeat.o(155614);
  }
  
  @TargetApi(16)
  public final boolean Wj()
  {
    AppMethodBeat.i(155616);
    if (this.fzg != null) {}
    try
    {
      int i = this.fzg.setEnabled(true);
      if (i == 0)
      {
        AppMethodBeat.o(155616);
        return true;
      }
      ad.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed ".concat(String.valueOf(i)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMNoiseSuppressor", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(155616);
    return false;
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    AppMethodBeat.i(155615);
    boolean bool = NoiseSuppressor.isAvailable();
    AppMethodBeat.o(155615);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.j
 * JD-Core Version:    0.7.0.1
 */