package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
{
  public int a;
  public int b;
  
  public d() {}
  
  public d(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
    } while ((paramObject.a == this.a) && (paramObject.b == this.b));
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 32713 + this.b;
  }
  
  public String toString()
  {
    AppMethodBeat.i(221350);
    String str = "Size(" + this.a + ", " + this.b + ")";
    AppMethodBeat.o(221350);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.d
 * JD-Core Version:    0.7.0.1
 */