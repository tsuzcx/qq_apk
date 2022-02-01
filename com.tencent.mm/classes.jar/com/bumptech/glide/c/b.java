package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public static final b aCg;
  
  static
  {
    AppMethodBeat.i(76838);
    aCd = new b("PREFER_ARGB_8888", 0);
    aCe = new b("PREFER_ARGB_8888_DISALLOW_HARDWARE", 1);
    aCf = new b("PREFER_RGB_565", 2);
    aCh = new b[] { aCd, aCe, aCf };
    aCg = aCe;
    AppMethodBeat.o(76838);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b
 * JD-Core Version:    0.7.0.1
 */