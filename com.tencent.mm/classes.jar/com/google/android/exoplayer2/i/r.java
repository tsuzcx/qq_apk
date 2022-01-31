package com.google.android.exoplayer2.i;

import android.os.Trace;

public final class r
{
  public static void beginSection(String paramString)
  {
    if (t.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
  
  public static void endSection()
  {
    if (t.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.r
 * JD-Core Version:    0.7.0.1
 */