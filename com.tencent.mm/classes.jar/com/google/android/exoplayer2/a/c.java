package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@TargetApi(21)
public final class c
{
  public static final c ayl;
  final int[] aym;
  private final int ayn;
  
  static
  {
    AppMethodBeat.i(94650);
    ayl = new c(new int[] { 2 }, 2);
    AppMethodBeat.o(94650);
  }
  
  private c(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(94646);
    if (paramArrayOfInt != null)
    {
      this.aym = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.aym);
    }
    for (;;)
    {
      this.ayn = paramInt;
      AppMethodBeat.o(94646);
      return;
      this.aym = new int[0];
    }
  }
  
  public static c aa(Context paramContext)
  {
    AppMethodBeat.i(94645);
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    if ((paramContext == null) || (paramContext.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0))
    {
      paramContext = ayl;
      AppMethodBeat.o(94645);
      return paramContext;
    }
    paramContext = new c(paramContext.getIntArrayExtra("android.media.extra.ENCODINGS"), paramContext.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    AppMethodBeat.o(94645);
    return paramContext;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94647);
    if (this == paramObject)
    {
      AppMethodBeat.o(94647);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(94647);
      return false;
    }
    paramObject = (c)paramObject;
    if ((Arrays.equals(this.aym, paramObject.aym)) && (this.ayn == paramObject.ayn))
    {
      AppMethodBeat.o(94647);
      return true;
    }
    AppMethodBeat.o(94647);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(94648);
    int i = this.ayn;
    int j = Arrays.hashCode(this.aym);
    AppMethodBeat.o(94648);
    return i + j * 31;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94649);
    String str = "AudioCapabilities[maxChannelCount=" + this.ayn + ", supportedEncodings=" + Arrays.toString(this.aym) + "]";
    AppMethodBeat.o(94649);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.c
 * JD-Core Version:    0.7.0.1
 */