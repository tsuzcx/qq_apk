package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
final class d$e
  implements d.c
{
  private final int aGG;
  private MediaCodecInfo[] aGH;
  
  public d$e(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.aGG = i;
      return;
    }
  }
  
  private void mt()
  {
    if (this.aGH == null) {
      this.aGH = new MediaCodecList(this.aGG).getCodecInfos();
    }
  }
  
  public final boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  public final int getCodecCount()
  {
    mt();
    return this.aGH.length;
  }
  
  public final MediaCodecInfo getCodecInfoAt(int paramInt)
  {
    mt();
    return this.aGH[paramInt];
  }
  
  public final boolean ms()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.e
 * JD-Core Version:    0.7.0.1
 */