package com.tencent.mm.plugin.expt.edge.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int index;
  public String name;
  public int qDL;
  public String stringValue;
  public int type;
  public long zzU;
  
  public final String toString()
  {
    AppMethodBeat.i(299644);
    String str = "";
    if (this.type == 2) {
      str = String.valueOf(this.zzU);
    }
    for (;;)
    {
      str = "EdgeComputingDataModel{index=" + this.index + ", type=" + this.type + ", name='" + this.name + '\'' + ", value=" + str + '\'' + '}';
      AppMethodBeat.o(299644);
      return str;
      if (this.type == 1) {
        str = String.valueOf(this.qDL);
      } else if (this.type == 0) {
        str = this.stringValue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.e.b
 * JD-Core Version:    0.7.0.1
 */