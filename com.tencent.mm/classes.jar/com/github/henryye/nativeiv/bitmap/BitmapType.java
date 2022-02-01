package com.github.henryye.nativeiv.bitmap;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public enum BitmapType
{
  static
  {
    AppMethodBeat.i(127361);
    Native = new BitmapType("Native", 0);
    Legacy = new BitmapType("Legacy", 1);
    Undefined = new BitmapType("Undefined", 2);
    $VALUES = new BitmapType[] { Native, Legacy, Undefined };
    AppMethodBeat.o(127361);
  }
  
  private BitmapType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.bitmap.BitmapType
 * JD-Core Version:    0.7.0.1
 */