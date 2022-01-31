package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  implements g.a
{
  private AcousticEchoCanceler dug = null;
  
  @TargetApi(16)
  public e(AudioRecord paramAudioRecord)
  {
    boolean bool = AcousticEchoCanceler.isAvailable();
    y.d("MicroMsg.MMAcousticEchoCanceler", "available  " + bool);
    if (bool) {
      this.dug = AcousticEchoCanceler.create(paramAudioRecord.getAudioSessionId());
    }
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    return AcousticEchoCanceler.isAvailable();
  }
  
  @TargetApi(16)
  public final boolean yh()
  {
    if (this.dug != null) {}
    try
    {
      int i = this.dug.setEnabled(true);
      if (i == 0) {
        return true;
      }
      y.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed " + i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", localException, "", new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.b.e
 * JD-Core Version:    0.7.0.1
 */