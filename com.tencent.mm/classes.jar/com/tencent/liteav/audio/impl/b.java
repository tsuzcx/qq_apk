package com.tencent.liteav.audio.impl;

import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static int[] a = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  
  public static int a(int paramInt)
  {
    if ((paramInt >= a.length) || (paramInt < 0)) {
      return 0;
    }
    return a[paramInt];
  }
  
  public static int b(int paramInt)
  {
    AppMethodBeat.i(66555);
    if (paramInt == 2)
    {
      if (d.a().d())
      {
        AppMethodBeat.o(66555);
        return -5;
      }
    }
    else if (TXCTraeJNI.nativeTraeIsPlaying())
    {
      AppMethodBeat.o(66555);
      return -5;
    }
    AppMethodBeat.o(66555);
    return 0;
  }
  
  public static int c(int paramInt)
  {
    AppMethodBeat.i(66556);
    if (paramInt == 2)
    {
      if (f.a().c())
      {
        AppMethodBeat.o(66556);
        return -106;
      }
    }
    else if (TXCTraeJNI.nativeTraeIsRecording())
    {
      AppMethodBeat.o(66556);
      return -106;
    }
    AppMethodBeat.o(66556);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.b
 * JD-Core Version:    0.7.0.1
 */