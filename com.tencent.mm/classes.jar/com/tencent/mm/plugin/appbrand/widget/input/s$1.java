package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.NumberKeyListener;

final class s$1
  extends NumberKeyListener
{
  s$1(s params) {}
  
  protected final char[] getAcceptedChars()
  {
    return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 46, 88, 120 };
  }
  
  public final int getInputType()
  {
    if (this.jmD.jnu) {}
    for (int i = 16;; i = 0) {
      return i | 0x2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.s.1
 * JD-Core Version:    0.7.0.1
 */