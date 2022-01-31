package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.NumberKeyListener;

final class r$1
  extends NumberKeyListener
{
  r$1(r paramr) {}
  
  protected final char[] getAcceptedChars()
  {
    return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 46, 88, 120 };
  }
  
  public final int getInputType()
  {
    if (this.hux.hvj) {}
    for (int i = 16;; i = 0) {
      return i | 0x2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.r.1
 * JD-Core Version:    0.7.0.1
 */