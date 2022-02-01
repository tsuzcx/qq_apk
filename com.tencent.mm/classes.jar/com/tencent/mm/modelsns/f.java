package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  StringBuffer htv;
  StringBuffer htw;
  private int index;
  
  public f()
  {
    AppMethodBeat.i(150969);
    this.htv = new StringBuffer();
    this.htw = new StringBuffer();
    this.index = 0;
    AppMethodBeat.o(150969);
  }
  
  public final String PW()
  {
    AppMethodBeat.i(150973);
    this.index = 0;
    this.htv.append("--end--\n\n");
    String str = this.htv.toString();
    AppMethodBeat.o(150973);
    return str;
  }
  
  public final void n(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150970);
    this.htv.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.htw.append(paramObject);
    this.index += 1;
    AppMethodBeat.o(150970);
  }
  
  public final void o(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150971);
    this.htv.append(paramString + "->" + paramObject + "\n");
    this.htw.append(paramObject);
    AppMethodBeat.o(150971);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150972);
    String str = this.htw.toString();
    AppMethodBeat.o(150972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.f
 * JD-Core Version:    0.7.0.1
 */