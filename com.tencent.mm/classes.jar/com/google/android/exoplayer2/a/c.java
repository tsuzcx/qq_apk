package com.google.android.exoplayer2.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c
{
  public static final c cIk;
  private final int maxChannelCount;
  final int[] supportedEncodings;
  
  static
  {
    AppMethodBeat.i(91761);
    cIk = new c(new int[] { 2 }, 2);
    AppMethodBeat.o(91761);
  }
  
  private c(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(91757);
    if (paramArrayOfInt != null)
    {
      this.supportedEncodings = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.supportedEncodings);
    }
    for (;;)
    {
      this.maxChannelCount = paramInt;
      AppMethodBeat.o(91757);
      return;
      this.supportedEncodings = new int[0];
    }
  }
  
  public static c aM(Context paramContext)
  {
    AppMethodBeat.i(91756);
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    if ((paramContext == null) || (paramContext.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0))
    {
      paramContext = cIk;
      AppMethodBeat.o(91756);
      return paramContext;
    }
    paramContext = new c(paramContext.getIntArrayExtra("android.media.extra.ENCODINGS"), paramContext.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    AppMethodBeat.o(91756);
    return paramContext;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(91758);
    if (this == paramObject)
    {
      AppMethodBeat.o(91758);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(91758);
      return false;
    }
    paramObject = (c)paramObject;
    if ((Arrays.equals(this.supportedEncodings, paramObject.supportedEncodings)) && (this.maxChannelCount == paramObject.maxChannelCount))
    {
      AppMethodBeat.o(91758);
      return true;
    }
    AppMethodBeat.o(91758);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(91759);
    int i = this.maxChannelCount;
    int j = Arrays.hashCode(this.supportedEncodings);
    AppMethodBeat.o(91759);
    return i + j * 31;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(91760);
    String str = "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
    AppMethodBeat.o(91760);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.c
 * JD-Core Version:    0.7.0.1
 */