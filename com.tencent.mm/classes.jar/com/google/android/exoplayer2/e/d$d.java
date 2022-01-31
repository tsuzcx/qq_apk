package com.google.android.exoplayer2.e;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

final class d$d
  implements d.c
{
  public final boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return "video/avc".equals(paramString);
  }
  
  public final int getCodecCount()
  {
    return MediaCodecList.getCodecCount();
  }
  
  public final MediaCodecInfo getCodecInfoAt(int paramInt)
  {
    return MediaCodecList.getCodecInfoAt(paramInt);
  }
  
  public final boolean ms()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.d
 * JD-Core Version:    0.7.0.1
 */