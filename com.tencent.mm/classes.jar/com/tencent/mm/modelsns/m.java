package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  private int index;
  StringBuffer jlx;
  StringBuffer jly;
  
  public m()
  {
    AppMethodBeat.i(150969);
    this.jlx = new StringBuffer();
    this.jly = new StringBuffer();
    this.index = 0;
    AppMethodBeat.o(150969);
  }
  
  public final String abW()
  {
    AppMethodBeat.i(150973);
    this.index = 0;
    this.jlx.append("--end--\n\n");
    String str = this.jlx.toString();
    AppMethodBeat.o(150973);
    return str;
  }
  
  public final void m(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150970);
    this.jlx.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.jly.append(paramObject);
    this.index += 1;
    AppMethodBeat.o(150970);
  }
  
  public final void n(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150971);
    this.jlx.append(paramString + "->" + paramObject + "\n");
    this.jly.append(paramObject);
    AppMethodBeat.o(150971);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150972);
    String str = this.jly.toString();
    AppMethodBeat.o(150972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.m
 * JD-Core Version:    0.7.0.1
 */