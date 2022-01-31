package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  implements g.a
{
  private AutomaticGainControl duG = null;
  
  @TargetApi(16)
  public h(AudioRecord paramAudioRecord)
  {
    boolean bool = AutomaticGainControl.isAvailable();
    y.d("MicroMsg.MMAutomaticGainControl", "available  " + bool);
    if (bool) {
      this.duG = AutomaticGainControl.create(paramAudioRecord.getAudioSessionId());
    }
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    return AutomaticGainControl.isAvailable();
  }
  
  @TargetApi(16)
  public final boolean yh()
  {
    if (this.duG != null) {}
    try
    {
      int i = this.duG.setEnabled(true);
      if (i == 0) {
        return true;
      }
      y.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed " + i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MMAutomaticGainControl", localException, "", new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.h
 * JD-Core Version:    0.7.0.1
 */