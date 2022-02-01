package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int index;
  StringBuffer oUu;
  StringBuffer oUv;
  
  public n()
  {
    AppMethodBeat.i(150969);
    this.oUu = new StringBuffer();
    this.oUv = new StringBuffer();
    this.index = 0;
    AppMethodBeat.o(150969);
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(150973);
    this.index = 0;
    this.oUu.append("--end--\n\n");
    String str = this.oUu.toString();
    AppMethodBeat.o(150973);
    return str;
  }
  
  public final void r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150970);
    this.oUu.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.oUv.append(paramObject);
    this.index += 1;
    AppMethodBeat.o(150970);
  }
  
  public final void s(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150971);
    this.oUu.append(paramString + "->" + paramObject + "\n");
    this.oUv.append(paramObject);
    AppMethodBeat.o(150971);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150972);
    String str = this.oUv.toString();
    AppMethodBeat.o(150972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.n
 * JD-Core Version:    0.7.0.1
 */