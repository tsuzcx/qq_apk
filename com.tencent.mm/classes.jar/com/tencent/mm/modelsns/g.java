package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private int index;
  StringBuffer iqm;
  StringBuffer iqn;
  
  public g()
  {
    AppMethodBeat.i(150969);
    this.iqm = new StringBuffer();
    this.iqn = new StringBuffer();
    this.index = 0;
    AppMethodBeat.o(150969);
  }
  
  public final String RD()
  {
    AppMethodBeat.i(150973);
    this.index = 0;
    this.iqm.append("--end--\n\n");
    String str = this.iqm.toString();
    AppMethodBeat.o(150973);
    return str;
  }
  
  public final void l(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150970);
    this.iqm.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.iqn.append(paramObject);
    this.index += 1;
    AppMethodBeat.o(150970);
  }
  
  public final void m(String paramString, Object paramObject)
  {
    AppMethodBeat.i(150971);
    this.iqm.append(paramString + "->" + paramObject + "\n");
    this.iqn.append(paramObject);
    AppMethodBeat.o(150971);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150972);
    String str = this.iqn.toString();
    AppMethodBeat.o(150972);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.g
 * JD-Core Version:    0.7.0.1
 */