package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public static final b aEP;
  
  static
  {
    AppMethodBeat.i(76838);
    aEM = new b("PREFER_ARGB_8888", 0);
    aEN = new b("PREFER_ARGB_8888_DISALLOW_HARDWARE", 1);
    aEO = new b("PREFER_RGB_565", 2);
    aEQ = new b[] { aEM, aEN, aEO };
    aEP = aEN;
    AppMethodBeat.o(76838);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b
 * JD-Core Version:    0.7.0.1
 */