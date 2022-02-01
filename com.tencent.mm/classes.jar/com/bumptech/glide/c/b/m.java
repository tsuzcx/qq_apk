package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.util.Map;

final class m
  implements h
{
  private final Class<?> aBm;
  private final Object aBp;
  private final h aEk;
  private final j aEm;
  private final Class<?> aEo;
  private final Map<Class<?>, com.bumptech.glide.c.m<?>> aEq;
  private int aFZ;
  private final int height;
  private final int width;
  
  m(Object paramObject, h paramh, int paramInt1, int paramInt2, Map<Class<?>, com.bumptech.glide.c.m<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, j paramj)
  {
    AppMethodBeat.i(77001);
    this.aBp = i.checkNotNull(paramObject, "Argument must not be null");
    this.aEk = ((h)i.checkNotNull(paramh, "Signature must not be null"));
    this.width = paramInt1;
    this.height = paramInt2;
    this.aEq = ((Map)i.checkNotNull(paramMap, "Argument must not be null"));
    this.aEo = ((Class)i.checkNotNull(paramClass1, "Resource class must not be null"));
    this.aBm = ((Class)i.checkNotNull(paramClass2, "Transcode class must not be null"));
    this.aEm = ((j)i.checkNotNull(paramj, "Argument must not be null"));
    AppMethodBeat.o(77001);
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77005);
    paramMessageDigest = new UnsupportedOperationException();
    AppMethodBeat.o(77005);
    throw paramMessageDigest;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77002);
    if ((paramObject instanceof m))
    {
      paramObject = (m)paramObject;
      if ((this.aBp.equals(paramObject.aBp)) && (this.aEk.equals(paramObject.aEk)) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.aEq.equals(paramObject.aEq)) && (this.aEo.equals(paramObject.aEo)) && (this.aBm.equals(paramObject.aBm)) && (this.aEm.equals(paramObject.aEm)))
      {
        AppMethodBeat.o(77002);
        return true;
      }
      AppMethodBeat.o(77002);
      return false;
    }
    AppMethodBeat.o(77002);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77003);
    if (this.aFZ == 0)
    {
      this.aFZ = this.aBp.hashCode();
      this.aFZ = (this.aFZ * 31 + this.aEk.hashCode());
      this.aFZ = (this.aFZ * 31 + this.width);
      this.aFZ = (this.aFZ * 31 + this.height);
      this.aFZ = (this.aFZ * 31 + this.aEq.hashCode());
      this.aFZ = (this.aFZ * 31 + this.aEo.hashCode());
      this.aFZ = (this.aFZ * 31 + this.aBm.hashCode());
      this.aFZ = (this.aFZ * 31 + this.aEm.hashCode());
    }
    int i = this.aFZ;
    AppMethodBeat.o(77003);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77004);
    String str = "EngineKey{model=" + this.aBp + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.aEo + ", transcodeClass=" + this.aBm + ", signature=" + this.aEk + ", hashCode=" + this.aFZ + ", transformations=" + this.aEq + ", options=" + this.aEm + '}';
    AppMethodBeat.o(77004);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.m
 * JD-Core Version:    0.7.0.1
 */