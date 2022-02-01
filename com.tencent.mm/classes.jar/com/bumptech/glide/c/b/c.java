package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

final class c
  implements h
{
  private final h aEf;
  private final h aEk;
  
  c(h paramh1, h paramh2)
  {
    this.aEf = paramh1;
    this.aEk = paramh2;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(76930);
    this.aEf.a(paramMessageDigest);
    this.aEk.a(paramMessageDigest);
    AppMethodBeat.o(76930);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76927);
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      if ((this.aEf.equals(paramObject.aEf)) && (this.aEk.equals(paramObject.aEk)))
      {
        AppMethodBeat.o(76927);
        return true;
      }
      AppMethodBeat.o(76927);
      return false;
    }
    AppMethodBeat.o(76927);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76928);
    int i = this.aEf.hashCode();
    int j = this.aEk.hashCode();
    AppMethodBeat.o(76928);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76929);
    String str = "DataCacheKey{sourceKey=" + this.aEf + ", signature=" + this.aEk + '}';
    AppMethodBeat.o(76929);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.c
 * JD-Core Version:    0.7.0.1
 */