package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public static final b aCY;
  
  static
  {
    AppMethodBeat.i(76838);
    aCV = new b("PREFER_ARGB_8888", 0);
    aCW = new b("PREFER_ARGB_8888_DISALLOW_HARDWARE", 1);
    aCX = new b("PREFER_RGB_565", 2);
    aCZ = new b[] { aCV, aCW, aCX };
    aCY = aCW;
    AppMethodBeat.o(76838);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b
 * JD-Core Version:    0.7.0.1
 */