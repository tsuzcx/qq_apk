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
  private final Class<?> aDd;
  private final Object aDg;
  private final h aGb;
  private final j aGd;
  private final Class<?> aGf;
  private final Map<Class<?>, com.bumptech.glide.c.m<?>> aGh;
  private int aHQ;
  private final int height;
  private final int width;
  
  m(Object paramObject, h paramh, int paramInt1, int paramInt2, Map<Class<?>, com.bumptech.glide.c.m<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, j paramj)
  {
    AppMethodBeat.i(77001);
    this.aDg = i.checkNotNull(paramObject, "Argument must not be null");
    this.aGb = ((h)i.checkNotNull(paramh, "Signature must not be null"));
    this.width = paramInt1;
    this.height = paramInt2;
    this.aGh = ((Map)i.checkNotNull(paramMap, "Argument must not be null"));
    this.aGf = ((Class)i.checkNotNull(paramClass1, "Resource class must not be null"));
    this.aDd = ((Class)i.checkNotNull(paramClass2, "Transcode class must not be null"));
    this.aGd = ((j)i.checkNotNull(paramj, "Argument must not be null"));
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
      if ((this.aDg.equals(paramObject.aDg)) && (this.aGb.equals(paramObject.aGb)) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.aGh.equals(paramObject.aGh)) && (this.aGf.equals(paramObject.aGf)) && (this.aDd.equals(paramObject.aDd)) && (this.aGd.equals(paramObject.aGd)))
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
    if (this.aHQ == 0)
    {
      this.aHQ = this.aDg.hashCode();
      this.aHQ = (this.aHQ * 31 + this.aGb.hashCode());
      this.aHQ = (this.aHQ * 31 + this.width);
      this.aHQ = (this.aHQ * 31 + this.height);
      this.aHQ = (this.aHQ * 31 + this.aGh.hashCode());
      this.aHQ = (this.aHQ * 31 + this.aGf.hashCode());
      this.aHQ = (this.aHQ * 31 + this.aDd.hashCode());
      this.aHQ = (this.aHQ * 31 + this.aGd.hashCode());
    }
    int i = this.aHQ;
    AppMethodBeat.o(77003);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77004);
    String str = "EngineKey{model=" + this.aDg + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.aGf + ", transcodeClass=" + this.aDd + ", signature=" + this.aGb + ", hashCode=" + this.aHQ + ", transformations=" + this.aGh + ", options=" + this.aGd + '}';
    AppMethodBeat.o(77004);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.m
 * JD-Core Version:    0.7.0.1
 */