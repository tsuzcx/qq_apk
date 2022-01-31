package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

public final class l
{
  public final Format[] aIs;
  private int auK;
  public final int length;
  
  public l(Format... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      this.aIs = paramVarArgs;
      this.length = paramVarArgs.length;
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (l)paramObject;
    } while ((this.length == paramObject.length) && (Arrays.equals(this.aIs, paramObject.aIs)));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.auK == 0) {
      this.auK = (Arrays.hashCode(this.aIs) + 527);
    }
    return this.auK;
  }
  
  public final int j(Format paramFormat)
  {
    int i = 0;
    while (i < this.aIs.length)
    {
      if (paramFormat == this.aIs[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.l
 * JD-Core Version:    0.7.0.1
 */