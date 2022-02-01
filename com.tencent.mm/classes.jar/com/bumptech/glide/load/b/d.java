package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

final class d
  implements g
{
  private final g aFO;
  private final g aFT;
  
  d(g paramg1, g paramg2)
  {
    this.aFO = paramg1;
    this.aFT = paramg2;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(76930);
    this.aFO.a(paramMessageDigest);
    this.aFT.a(paramMessageDigest);
    AppMethodBeat.o(76930);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76927);
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      if ((this.aFO.equals(paramObject.aFO)) && (this.aFT.equals(paramObject.aFT)))
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
    int i = this.aFO.hashCode();
    int j = this.aFT.hashCode();
    AppMethodBeat.o(76928);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76929);
    String str = "DataCacheKey{sourceKey=" + this.aFO + ", signature=" + this.aFT + '}';
    AppMethodBeat.o(76929);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.d
 * JD-Core Version:    0.7.0.1
 */