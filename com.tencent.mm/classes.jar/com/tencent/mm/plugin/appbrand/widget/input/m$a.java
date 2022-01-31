package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$a
  implements CharSequence
{
  private CharSequence jlW;
  
  m$a(CharSequence paramCharSequence)
  {
    this.jlW = paramCharSequence;
  }
  
  public final char charAt(int paramInt)
  {
    return '●';
  }
  
  public final int length()
  {
    AppMethodBeat.i(77425);
    int i = this.jlW.length();
    AppMethodBeat.o(77425);
    return i;
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77426);
    CharSequence localCharSequence = this.jlW.subSequence(paramInt1, paramInt2);
    AppMethodBeat.o(77426);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.m.a
 * JD-Core Version:    0.7.0.1
 */