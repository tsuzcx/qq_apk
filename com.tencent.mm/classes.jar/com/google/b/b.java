package com.google.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public final int height;
  public final int width;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (this.width == paramObject.width)
      {
        bool1 = bool2;
        if (this.height == paramObject.height) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.width * 32713 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57216);
    String str = this.width + "x" + this.height;
    AppMethodBeat.o(57216);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.b
 * JD-Core Version:    0.7.0.1
 */