package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum os$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43495);
    hcX = new a("release", 0, 1);
    hcY = new a("debug", 1, 2);
    hcZ = new a("demo", 2, 3);
    hda = new a[] { hcX, hcY, hcZ };
    AppMethodBeat.o(43495);
  }
  
  private os$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a or(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hcX;
    case 2: 
      return hcY;
    }
    return hcZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.os.a
 * JD-Core Version:    0.7.0.1
 */