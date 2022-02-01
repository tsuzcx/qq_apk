package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cw;
import com.tencent.mm.sdk.event.IListener;

public class CommandLine
  extends IListener<cw>
{
  public CommandLine()
  {
    super(f.hfK);
    AppMethodBeat.i(161275);
    this.__eventId = cw.class.getName().hashCode();
    AppMethodBeat.o(161275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.CommandLine
 * JD-Core Version:    0.7.0.1
 */