package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class c
{
  public static final c avV = new c(new int[] { 2 }, 2);
  final int[] avW;
  private final int avX;
  
  private c(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      this.avW = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.avW);
    }
    for (;;)
    {
      this.avX = paramInt;
      return;
      this.avW = new int[0];
    }
  }
  
  public static c Y(Context paramContext)
  {
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    if ((paramContext == null) || (paramContext.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0)) {
      return avV;
    }
    return new c(paramContext.getIntArrayExtra("android.media.extra.ENCODINGS"), paramContext.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
    } while ((Arrays.equals(this.avW, paramObject.avW)) && (this.avX == paramObject.avX));
    return false;
  }
  
  public final int hashCode()
  {
    return this.avX + Arrays.hashCode(this.avW) * 31;
  }
  
  public final String toString()
  {
    return "AudioCapabilities[maxChannelCount=" + this.avX + ", supportedEncodings=" + Arrays.toString(this.avW) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.a.c
 * JD-Core Version:    0.7.0.1
 */