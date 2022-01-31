package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
{
  public final int height;
  public final int width;
  
  public aa(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (this == paramObject) {
          return true;
        }
      } while (!(paramObject instanceof aa));
      paramObject = (aa)paramObject;
    } while ((this.width != paramObject.width) || (this.height != paramObject.height));
    return true;
  }
  
  public final int hashCode()
  {
    return this.height ^ (this.width << 16 | this.width >>> 16);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93019);
    String str = this.width + "x" + this.height;
    AppMethodBeat.o(93019);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.e.aa
 * JD-Core Version:    0.7.0.1
 */