package com.tencent.mm.plugin.expt.d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int index;
  public int intValue;
  public String name;
  public long qQe;
  public String stringValue;
  public int type;
  
  public final String toString()
  {
    AppMethodBeat.i(210262);
    String str = "";
    if (this.type == 2) {
      str = String.valueOf(this.qQe);
    }
    for (;;)
    {
      str = "EdgeComputingDataModel{index=" + this.index + ", type=" + this.type + ", name='" + this.name + '\'' + ", value=" + str + '\'' + '}';
      AppMethodBeat.o(210262);
      return str;
      if (this.type == 1) {
        str = String.valueOf(this.intValue);
      } else if (this.type == 0) {
        str = this.stringValue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e.b
 * JD-Core Version:    0.7.0.1
 */