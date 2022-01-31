package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cu$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128859);
    ddp = new a("release", 0, 1);
    ddq = new a("debug", 1, 2);
    ddr = new a("demo", 2, 3);
    dds = new a[] { ddp, ddq, ddr };
    AppMethodBeat.o(128859);
  }
  
  private cu$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hi(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ddp;
    case 2: 
      return ddq;
    }
    return ddr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cu.a
 * JD-Core Version:    0.7.0.1
 */