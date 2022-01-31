package com.github.henryye.nativeiv.bitmap;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public enum BitmapType
{
  static
  {
    AppMethodBeat.i(115756);
    Native = new BitmapType("Native", 0);
    Legacy = new BitmapType("Legacy", 1);
    Undefined = new BitmapType("Undefined", 2);
    $VALUES = new BitmapType[] { Native, Legacy, Undefined };
    AppMethodBeat.o(115756);
  }
  
  private BitmapType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.bitmap.BitmapType
 * JD-Core Version:    0.7.0.1
 */