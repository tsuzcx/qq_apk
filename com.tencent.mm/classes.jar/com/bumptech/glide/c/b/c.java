package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

final class c
  implements h
{
  private final h aDo;
  private final h aDt;
  
  c(h paramh1, h paramh2)
  {
    this.aDo = paramh1;
    this.aDt = paramh2;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(76930);
    this.aDo.a(paramMessageDigest);
    this.aDt.a(paramMessageDigest);
    AppMethodBeat.o(76930);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76927);
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      if ((this.aDo.equals(paramObject.aDo)) && (this.aDt.equals(paramObject.aDt)))
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
    int i = this.aDo.hashCode();
    int j = this.aDt.hashCode();
    AppMethodBeat.o(76928);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76929);
    String str = "DataCacheKey{sourceKey=" + this.aDo + ", signature=" + this.aDt + '}';
    AppMethodBeat.o(76929);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.c
 * JD-Core Version:    0.7.0.1
 */