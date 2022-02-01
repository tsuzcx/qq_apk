package com.bumptech.glide.load;

import android.support.v4.e.a;
import com.bumptech.glide.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class i
  implements g
{
  public final a<h<?>, Object> aFa;
  
  public i()
  {
    AppMethodBeat.i(76856);
    this.aFa = new b();
    AppMethodBeat.o(76856);
  }
  
  public final <T> T a(h<T> paramh)
  {
    AppMethodBeat.i(76858);
    if (this.aFa.containsKey(paramh))
    {
      paramh = this.aFa.get(paramh);
      AppMethodBeat.o(76858);
      return paramh;
    }
    paramh = paramh.aEX;
    AppMethodBeat.o(76858);
    return paramh;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(76857);
    this.aFa.a(parami.aFa);
    AppMethodBeat.o(76857);
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(76861);
    int i = 0;
    while (i < this.aFa.size())
    {
      h localh = (h)this.aFa.keyAt(i);
      Object localObject = this.aFa.valueAt(i);
      h.a locala = localh.aEY;
      if (localh.aEZ == null) {
        localh.aEZ = localh.key.getBytes(g.aEV);
      }
      locala.a(localh.aEZ, localObject, paramMessageDigest);
      i += 1;
    }
    AppMethodBeat.o(76861);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76859);
    if ((paramObject instanceof i))
    {
      paramObject = (i)paramObject;
      boolean bool = this.aFa.equals(paramObject.aFa);
      AppMethodBeat.o(76859);
      return bool;
    }
    AppMethodBeat.o(76859);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76860);
    int i = this.aFa.hashCode();
    AppMethodBeat.o(76860);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76862);
    String str = "Options{values=" + this.aFa + '}';
    AppMethodBeat.o(76862);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.i
 * JD-Core Version:    0.7.0.1
 */