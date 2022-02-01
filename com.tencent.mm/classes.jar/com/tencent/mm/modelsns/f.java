package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  StringBuffer hTX;
  StringBuffer hTY;
  private int index;
  
  public f()
  {
    AppMethodBeat.i(150969);
    this.hTX = new StringBuffer();
    this.hTY = new StringBuffer();
    this.index = 0;
    AppMethodBeat.o(150969);
  }
  
  public final String PS()
  {
    AppMethodBeat.i(150973);
    this.index = 0;
    this.hTX.append("--end--\n\n");
    String str = this.hTX.toString();
    AppMethodBeat.o(150973);
    return str;
  }
  
  public final void m(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150970);
    this.hTX.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.hTY.append(paramObject);
    this.index += 1;
    AppMethodBeat.o(150970);
  }
  
  public final void n(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150971);
    this.hTX.append(paramString + "->" + paramObject + "\n");
    this.hTY.append(paramObject);
    AppMethodBeat.o(150971);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150972);
    String str = this.hTY.toString();
    AppMethodBeat.o(150972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.f
 * JD-Core Version:    0.7.0.1
 */