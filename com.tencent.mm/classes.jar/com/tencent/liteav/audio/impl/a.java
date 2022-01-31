package com.tencent.liteav.audio.impl;

import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.Record.f;

public class a
{
  private static int[] a = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  
  public static int a(int paramInt)
  {
    if ((paramInt >= a.length) || (paramInt < 0)) {
      return 0;
    }
    return a[paramInt];
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append("0x");
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == TXEAudioDef.TXE_AEC_TRAE)
    {
      if (d.a().d()) {
        return TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_PLAYER_INVALID;
      }
    }
    else if (TXCTraeJNI.nativeTraeIsPlaying()) {
      return TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_PLAYER_INVALID;
    }
    return TXEAudioDef.TXE_AUDIO_COMMON_ERR_OK;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == TXEAudioDef.TXE_AEC_TRAE)
    {
      if (f.a().c()) {
        return TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
      }
    }
    else if (TXCTraeJNI.nativeTraeIsRecording()) {
      return TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
    }
    return TXEAudioDef.TXE_AUDIO_COMMON_ERR_OK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a
 * JD-Core Version:    0.7.0.1
 */