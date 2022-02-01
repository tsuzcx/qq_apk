package com.bumptech.glide.c;

import android.support.v4.e.a;
import com.bumptech.glide.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class j
  implements h
{
  public final a<i<?>, Object> aFk;
  
  public j()
  {
    AppMethodBeat.i(76856);
    this.aFk = new b();
    AppMethodBeat.o(76856);
  }
  
  public final <T> T a(i<T> parami)
  {
    AppMethodBeat.i(76858);
    if (this.aFk.containsKey(parami))
    {
      parami = this.aFk.get(parami);
      AppMethodBeat.o(76858);
      return parami;
    }
    parami = parami.aFh;
    AppMethodBeat.o(76858);
    return parami;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(76857);
    this.aFk.a(paramj.aFk);
    AppMethodBeat.o(76857);
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(76861);
    int i = 0;
    while (i < this.aFk.size())
    {
      i locali = (i)this.aFk.keyAt(i);
      Object localObject = this.aFk.valueAt(i);
      i.a locala = locali.aFi;
      if (locali.aFj == null) {
        locali.aFj = locali.key.getBytes(h.aFf);
      }
      locala.a(locali.aFj, localObject, paramMessageDigest);
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
      boolean bool = this.aFk.equals(paramObject.aFk);
      AppMethodBeat.o(76859);
      return bool;
    }
    AppMethodBeat.o(76859);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76860);
    int i = this.aFk.hashCode();
    AppMethodBeat.o(76860);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76862);
    String str = "Options{values=" + this.aFk + '}';
    AppMethodBeat.o(76862);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.j
 * JD-Core Version:    0.7.0.1
 */