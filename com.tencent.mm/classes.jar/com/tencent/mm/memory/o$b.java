package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o$b
  implements Comparable
{
  private String gEj;
  public int height;
  public int width;
  
  public o$b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156453);
    this.width = paramInt1;
    this.height = paramInt2;
    this.gEj = String.format("SightBitmapSize: [%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(156453);
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof b))
    {
      if ((this.width == ((b)paramObject).width) && (this.height == ((b)paramObject).height)) {
        return 0;
      }
      int i = this.width;
      if (this.height * i > ((b)paramObject).width * ((b)paramObject).height) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  public final String toString()
  {
    return this.gEj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.o.b
 * JD-Core Version:    0.7.0.1
 */