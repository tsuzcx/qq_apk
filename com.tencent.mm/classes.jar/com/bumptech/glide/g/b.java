package com.bumptech.glide.g;

import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b
  implements h
{
  private final Object object;
  
  public b(Object paramObject)
  {
    AppMethodBeat.i(77706);
    this.object = i.checkNotNull(paramObject, "Argument must not be null");
    AppMethodBeat.o(77706);
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77710);
    paramMessageDigest.update(this.object.toString().getBytes(aDo));
    AppMethodBeat.o(77710);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77708);
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      boolean bool = this.object.equals(paramObject.object);
      AppMethodBeat.o(77708);
      return bool;
    }
    AppMethodBeat.o(77708);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77709);
    int i = this.object.hashCode();
    AppMethodBeat.o(77709);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77707);
    String str = "ObjectKey{object=" + this.object + '}';
    AppMethodBeat.o(77707);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.g.b
 * JD-Core Version:    0.7.0.1
 */