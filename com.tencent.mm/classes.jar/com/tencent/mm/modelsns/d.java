package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  StringBuffer fQO;
  StringBuffer fQP;
  private int index;
  
  public d()
  {
    AppMethodBeat.i(78618);
    this.fQO = new StringBuffer();
    this.fQP = new StringBuffer();
    this.index = 0;
    AppMethodBeat.o(78618);
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(78622);
    this.index = 0;
    this.fQO.append("--end--\n\n");
    String str = this.fQO.toString();
    AppMethodBeat.o(78622);
    return str;
  }
  
  public final void j(String paramString, Object paramObject)
  {
    AppMethodBeat.i(78619);
    this.fQO.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.fQP.append(paramObject);
    this.index += 1;
    AppMethodBeat.o(78619);
  }
  
  public final void k(String paramString, Object paramObject)
  {
    AppMethodBeat.i(78620);
    this.fQO.append(paramString + "->" + paramObject + "\n");
    this.fQP.append(paramObject);
    AppMethodBeat.o(78620);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78621);
    String str = this.fQP.toString();
    AppMethodBeat.o(78621);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */