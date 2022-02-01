package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  public int a;
  public int b;
  
  public e() {}
  
  public e(int paramInt1, int paramInt2)
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
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
    } while ((paramObject.a == this.a) && (paramObject.b == this.b));
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 32713 + this.b;
  }
  
  public String toString()
  {
    AppMethodBeat.i(239268);
    String str = "Size(" + this.a + ", " + this.b + ")";
    AppMethodBeat.o(239268);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.e
 * JD-Core Version:    0.7.0.1
 */