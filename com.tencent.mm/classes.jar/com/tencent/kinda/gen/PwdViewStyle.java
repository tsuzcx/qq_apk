package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PwdViewStyle
{
  static
  {
    AppMethodBeat.i(226704);
    CASHIERSTYLE = new PwdViewStyle("CASHIERSTYLE", 0);
    CHECKPWDSTYLE = new PwdViewStyle("CHECKPWDSTYLE", 1);
    HALFPAGECASHIERSTYLE = new PwdViewStyle("HALFPAGECASHIERSTYLE", 2);
    $VALUES = new PwdViewStyle[] { CASHIERSTYLE, CHECKPWDSTYLE, HALFPAGECASHIERSTYLE };
    AppMethodBeat.o(226704);
  }
  
  private PwdViewStyle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.PwdViewStyle
 * JD-Core Version:    0.7.0.1
 */