package com.bumptech.glide.c;

import android.support.v4.e.a;
import com.bumptech.glide.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class j
  implements h
{
  public final a<i<?>, Object> aDt;
  
  public j()
  {
    AppMethodBeat.i(76856);
    this.aDt = new b();
    AppMethodBeat.o(76856);
  }
  
  public final <T> T a(i<T> parami)
  {
    AppMethodBeat.i(76858);
    if (this.aDt.containsKey(parami))
    {
      parami = this.aDt.get(parami);
      AppMethodBeat.o(76858);
      return parami;
    }
    parami = parami.aDq;
    AppMethodBeat.o(76858);
    return parami;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(76857);
    this.aDt.a(paramj.aDt);
    AppMethodBeat.o(76857);
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(76861);
    int i = 0;
    while (i < this.aDt.size())
    {
      i locali = (i)this.aDt.keyAt(i);
      Object localObject = this.aDt.valueAt(i);
      i.a locala = locali.aDr;
      if (locali.aDs == null) {
        locali.aDs = locali.key.getBytes(h.aDo);
      }
      locala.a(locali.aDs, localObject, paramMessageDigest);
      i += 1;
    }
    AppMethodBeat.o(76861);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76859);
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      boolean bool = this.aDt.equals(paramObject.aDt);
      AppMethodBeat.o(76859);
      return bool;
    }
    AppMethodBeat.o(76859);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76860);
    int i = this.aDt.hashCode();
    AppMethodBeat.o(76860);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76862);
    String str = "Options{values=" + this.aDt + '}';
    AppMethodBeat.o(76862);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.j
 * JD-Core Version:    0.7.0.1
 */