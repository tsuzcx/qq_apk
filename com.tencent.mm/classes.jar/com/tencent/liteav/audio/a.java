package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;

public class a
{
  static {}
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramInt == TXEAudioDef.TXE_AUDIO_MODE_RECEIVER)
    {
      paramContext.setMode(3);
      paramContext.setSpeakerphoneOn(false);
      TXCLog.i("TXCAudioConfig", "AudioCenter setAudioMode to receiver");
      return;
    }
    paramContext.setMode(0);
    paramContext.setSpeakerphoneOn(true);
    TXCLog.i("TXCAudioConfig", "AudioCenter setAudioMode to speaker");
  }
  
  public static void a(String paramString)
  {
    TXCTraeJNI.nativeSetTraeConfig(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.a
 * JD-Core Version:    0.7.0.1
 */