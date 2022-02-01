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
    AppMethodBeat.i(61446);
    int i = this.v8Object.executeIntegerFunction("sourceColumn", null);
    AppMethodBeat.o(61446);
    return i;
  }
  
  public int getSourceLine()
  {
    AppMethodBeat.i(61445);
    int i = this.v8Object.executeIntegerFunction("sourceLine", null);
    AppMethodBeat.o(61445);
    return i;
  }
  
  public String getSourceLineText()
  {
    AppMethodBeat.i(61447);
    String str = this.v8Object.executeStringFunction("sourceLineText", null);
    AppMethodBeat.o(61447);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.debug.BreakEvent
 * JD-Core Version:    0.7.0.1
 */