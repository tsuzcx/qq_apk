package com.bumptech.glide.load.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.util.Map;

final class n
  implements g
{
  private final Class<?> aDd;
  private final Object aDf;
  private final g aFT;
  private final i aFV;
  private final Class<?> aFX;
  private final Map<Class<?>, l<?>> aFZ;
  private int aHK;
  private final int height;
  private final int width;
  
  n(Object paramObject, g paramg, int paramInt1, int paramInt2, Map<Class<?>, l<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, i parami)
  {
    AppMethodBeat.i(77001);
    this.aDf = j.checkNotNull(paramObject, "Argument must not be null");
    this.aFT = ((g)j.checkNotNull(paramg, "Signature must not be null"));
    this.width = paramInt1;
    this.height = paramInt2;
    this.aFZ = ((Map)j.checkNotNull(paramMap, "Argument must not be null"));
    this.aFX = ((Class)j.checkNotNull(paramClass1, "Resource class must not be null"));
    this.aDd = ((Class)j.checkNotNull(paramClass2, "Transcode class must not be null"));
    this.aFV = ((i)j.checkNotNull(parami, "Argument must not be null"));
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
    if ((paramObject instanceof n))
    {
      paramObject = (n)paramObject;
      if ((this.aDf.equals(paramObject.aDf)) && (this.aFT.equals(paramObject.aFT)) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.aFZ.equals(paramObject.aFZ)) && (this.aFX.equals(paramObject.aFX)) && (this.aDd.equals(paramObject.aDd)) && (this.aFV.equals(paramObject.aFV)))
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
    if (this.aHK == 0)
    {
      this.aHK = this.aDf.hashCode();
      this.aHK = (this.aHK * 31 + this.aFT.hashCode());
      this.aHK = (this.aHK * 31 + this.width);
      this.aHK = (this.aHK * 31 + this.height);
      this.aHK = (this.aHK * 31 + this.aFZ.hashCode());
      this.aHK = (this.aHK * 31 + this.aFX.hashCode());
      this.aHK = (this.aHK * 31 + this.aDd.hashCode());
      this.aHK = (this.aHK * 31 + this.aFV.hashCode());
    }
    int i = this.aHK;
    AppMethodBeat.o(77003);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77004);
    String str = "EngineKey{model=" + this.aDf + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.aFX + ", transcodeClass=" + this.aDd + ", signature=" + this.aFT + ", hashCode=" + this.aHK + ", transformations=" + this.aFZ + ", options=" + this.aFV + '}';
    AppMethodBeat.o(77004);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.n
 * JD-Core Version:    0.7.0.1
 */