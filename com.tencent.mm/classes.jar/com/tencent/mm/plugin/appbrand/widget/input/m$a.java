package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$a
  implements CharSequence
{
  private CharSequence njs;
  
  m$a(CharSequence paramCharSequence)
  {
    this.njs = paramCharSequence;
  }
  
  public final char charAt(int paramInt)
  {
    return '●';
  }
  
  public final int length()
  {
    AppMethodBeat.i(131501);
    int i = this.njs.length();
    AppMethodBeat.o(131501);
    return i;
  }
  
  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131502);
    CharSequence localCharSequence = this.njs.subSequence(paramInt1, paramInt2);
    AppMethodBeat.o(131502);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.m.a
 * JD-Core Version:    0.7.0.1
 */