package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BreakEvent
  extends EventData
{
  private static final String SOURCE_COLUMN = "sourceColumn";
  private static final String SOURCE_LINE = "sourceLine";
  private static final String SOURCE_LINE_TEXT = "sourceLineText";
  
  BreakEvent(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public int getSourceColumn()
  {
    AppMethodBeat.i(74823);
    int i = this.v8Object.executeIntegerFunction("sourceColumn", null);
    AppMethodBeat.o(74823);
    return i;
  }
  
  public int getSourceLine()
  {
    AppMethodBeat.i(74822);
    int i = this.v8Object.executeIntegerFunction("sourceLine", null);
    AppMethodBeat.o(74822);
    return i;
  }
  
  public String getSourceLineText()
  {
    AppMethodBeat.i(74824);
    String str = this.v8Object.executeStringFunction("sourceLineText", null);
    AppMethodBeat.o(74824);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.debug.BreakEvent
 * JD-Core Version:    0.7.0.1
 */