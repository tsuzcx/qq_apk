package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Platform
{
  static
  {
    AppMethodBeat.i(135967);
    ANDROID = new Platform("ANDROID", 0);
    IOS = new Platform("IOS", 1);
    UNKNOWN = new Platform("UNKNOWN", 2);
    $VALUES = new Platform[] { ANDROID, IOS, UNKNOWN };
    AppMethodBeat.o(135967);
  }
  
  private Platform() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.Platform
 * JD-Core Version:    0.7.0.1
 */