package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  implements g.a
{
  private NoiseSuppressor duH = null;
  
  @TargetApi(16)
  public i(AudioRecord paramAudioRecord)
  {
    boolean bool = NoiseSuppressor.isAvailable();
    y.d("MicroMsg.MMNoiseSuppressor", "available  " + bool);
    if (bool) {
      this.duH = NoiseSuppressor.create(paramAudioRecord.getAudioSessionId());
    }
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    return NoiseSuppressor.isAvailable();
  }
  
  @TargetApi(16)
  public final boolean yh()
  {
    if (this.duH != null) {}
    try
    {
      int i = this.duH.setEnabled(true);
      if (i == 0) {
        return true;
      }
      y.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed " + i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MMNoiseSuppressor", localException, "", new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.i
 * JD-Core Version:    0.7.0.1
 */