package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class k$a
  extends i
{
  private final char[] auq;
  private int aur;
  
  private k$a(Writer paramWriter, char[] paramArrayOfChar)
  {
    super(paramWriter);
    this.auq = paramArrayOfChar;
  }
  
  private boolean ms()
  {
    int i = 0;
    AppMethodBeat.i(70604);
    if (this.auq == null)
    {
      AppMethodBeat.o(70604);
      return false;
    }
    this.writer.write(10);
    while (i < this.aur)
    {
      this.writer.write(this.auq);
      i += 1;
    }
    AppMethodBeat.o(70604);
    return true;
  }
  
  protected final void ml()
  {
    AppMethodBeat.i(70597);
    this.aur += 1;
    this.writer.write(91);
    ms();
    AppMethodBeat.o(70597);
  }
  
  protected final void mm()
  {
    AppMethodBeat.i(70598);
    this.aur -= 1;
    ms();
    this.writer.write(93);
    AppMethodBeat.o(70598);
  }
  
  protected final void mn()
  {
    AppMethodBeat.i(70599);
    this.writer.write(44);
    if (!ms()) {
      this.writer.write(32);
    }
    AppMethodBeat.o(70599);
  }
  
  protected final void mo()
  {
    AppMethodBeat.i(70600);
    this.aur += 1;
    this.writer.write(123);
    ms();
    AppMethodBeat.o(70600);
  }
  
  protected final void mp()
  {
    AppMethodBeat.i(70601);
    this.aur -= 1;
    ms();
    this.writer.write(125);
    AppMethodBeat.o(70601);
  }
  
  protected final void mq()
  {
    AppMethodBeat.i(70602);
    this.writer.write(58);
    this.writer.write(32);
    AppMethodBeat.o(70602);
  }
  
  protected final void mr()
  {
    AppMethodBeat.i(70603);
    this.writer.write(44);
    if (!ms()) {
      this.writer.write(32);
    }
    AppMethodBeat.o(70603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.a.k.a
 * JD-Core Version:    0.7.0.1
 */