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
  private final Class<?> aAs;
  private final Object aAv;
  private final h aDt;
  private final j aDv;
  private final Class<?> aDx;
  private final Map<Class<?>, com.bumptech.glide.c.m<?>> aDz;
  private int aFj;
  private final int height;
  private final int width;
  
  m(Object paramObject, h paramh, int paramInt1, int paramInt2, Map<Class<?>, com.bumptech.glide.c.m<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, j paramj)
  {
    AppMethodBeat.i(77001);
    this.aAv = i.checkNotNull(paramObject, "Argument must not be null");
    this.aDt = ((h)i.checkNotNull(paramh, "Signature must not be null"));
    this.width = paramInt1;
    this.height = paramInt2;
    this.aDz = ((Map)i.checkNotNull(paramMap, "Argument must not be null"));
    this.aDx = ((Class)i.checkNotNull(paramClass1, "Resource class must not be null"));
    this.aAs = ((Class)i.checkNotNull(paramClass2, "Transcode class must not be null"));
    this.aDv = ((j)i.checkNotNull(paramj, "Argument must not be null"));
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
      if ((this.aAv.equals(paramObject.aAv)) && (this.aDt.equals(paramObject.aDt)) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.aDz.equals(paramObject.aDz)) && (this.aDx.equals(paramObject.aDx)) && (this.aAs.equals(paramObject.aAs)) && (this.aDv.equals(paramObject.aDv)))
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
    if (this.aFj == 0)
    {
      this.aFj = this.aAv.hashCode();
      this.aFj = (this.aFj * 31 + this.aDt.hashCode());
      this.aFj = (this.aFj * 31 + this.width);
      this.aFj = (this.aFj * 31 + this.height);
      this.aFj = (this.aFj * 31 + this.aDz.hashCode());
      this.aFj = (this.aFj * 31 + this.aDx.hashCode());
      this.aFj = (this.aFj * 31 + this.aAs.hashCode());
      this.aFj = (this.aFj * 31 + this.aDv.hashCode());
    }
    int i = this.aFj;
    AppMethodBeat.o(77003);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77004);
    String str = "EngineKey{model=" + this.aAv + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.aDx + ", transcodeClass=" + this.aAs + ", signature=" + this.aDt + ", hashCode=" + this.aFj + ", transformations=" + this.aDz + ", options=" + this.aDv + '}';
    AppMethodBeat.o(77004);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.m
 * JD-Core Version:    0.7.0.1
 */