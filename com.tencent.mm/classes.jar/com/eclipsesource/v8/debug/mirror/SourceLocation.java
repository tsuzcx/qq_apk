package com.eclipsesource.v8.debug.mirror;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceLocation
{
  private final int column;
  private final int line;
  private final int position;
  private final String scriptName;
  private String sourceText;
  
  public SourceLocation(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    this.scriptName = paramString1;
    this.position = paramInt1;
    this.line = paramInt2;
    this.column = paramInt3;
    this.sourceText = paramString2;
  }
  
  public int getColumn()
  {
    return this.column;
  }
  
  public int getLine()
  {
    return this.line;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getScriptName()
  {
    return this.scriptName;
  }
  
  public String getSourceText()
  {
    return this.sourceText;
  }
  
  public String toString()
  {
    AppMethodBeat.i(61532);
    String str = this.scriptName + " : " + this.position + " : " + this.line + " : " + this.column + " : " + this.sourceText;
    AppMethodBeat.o(61532);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.SourceLocation
 * JD-Core Version:    0.7.0.1
 */