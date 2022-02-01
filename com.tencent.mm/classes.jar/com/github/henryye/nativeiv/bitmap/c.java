package com.github.henryye.nativeiv.bitmap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  static
  {
    AppMethodBeat.i(127365);
    cEA = new c("JPG", 0);
    cEB = new c("PNG", 1);
    cEC = new c("BMP", 2);
    cED = new c("GIF", 3);
    cEE = new c("WEBP", 4);
    cEF = new c("CUSTOM", 5);
    cEG = new c("UNKNOWN", 6);
    cEH = new c[] { cEA, cEB, cEC, cED, cEE, cEF, cEG };
    AppMethodBeat.o(127365);
  }
  
  private c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.bitmap.c
 * JD-Core Version:    0.7.0.1
 */