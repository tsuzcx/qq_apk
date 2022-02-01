package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
{
  public final int height;
  public final int width;
  
  public ad(int paramInt1, int paramInt2)
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
      } while (!(paramObject instanceof ad));
      paramObject = (ad)paramObject;
    } while ((this.width != paramObject.width) || (this.height != paramObject.height));
    return true;
  }
  
  public final int hashCode()
  {
    return this.height ^ (this.width << 16 | this.width >>> 16);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(155822);
    String str = this.width + "x" + this.height;
    AppMethodBeat.o(155822);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ad
 * JD-Core Version:    0.7.0.1
 */