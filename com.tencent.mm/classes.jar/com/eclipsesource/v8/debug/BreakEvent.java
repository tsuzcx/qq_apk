package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.V8Object;

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
    return this.v8Object.executeIntegerFunction("sourceColumn", null);
  }
  
  public int getSourceLine()
  {
    return this.v8Object.executeIntegerFunction("sourceLine", null);
  }
  
  public String getSourceLineText()
  {
    return this.v8Object.executeStringFunction("sourceLineText", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.debug.BreakEvent
 * JD-Core Version:    0.7.0.1
 */