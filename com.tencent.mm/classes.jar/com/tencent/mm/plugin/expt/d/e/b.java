package com.tencent.mm.plugin.expt.d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int index;
  public int intValue;
  public String name;
  public String stringValue;
  public long syi;
  public int type;
  
  public final String toString()
  {
    AppMethodBeat.i(220338);
    String str = "";
    if (this.type == 2) {
      str = String.valueOf(this.syi);
    }
    for (;;)
    {
      str = "EdgeComputingDataModel{index=" + this.index + ", type=" + this.type + ", name='" + this.name + '\'' + ", value=" + str + '\'' + '}';
      AppMethodBeat.o(220338);
      return str;
      if (this.type == 1) {
        str = String.valueOf(this.intValue);
      } else if (this.type == 0) {
        str = this.stringValue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e.b
 * JD-Core Version:    0.7.0.1
 */