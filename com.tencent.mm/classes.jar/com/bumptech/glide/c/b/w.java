package com.bumptech.glide.c.b;

import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.m;
import com.bumptech.glide.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class w
  implements h
{
  private static final f<Class<?>, byte[]> aGq;
  private final b aAy;
  private final h aEf;
  private final h aEk;
  private final com.bumptech.glide.c.j aEm;
  private final Class<?> aGr;
  private final m<?> aGs;
  private final int height;
  private final int width;
  
  static
  {
    AppMethodBeat.i(77055);
    aGq = new f(50L);
    AppMethodBeat.o(77055);
  }
  
  w(b paramb, h paramh1, h paramh2, int paramInt1, int paramInt2, m<?> paramm, Class<?> paramClass, com.bumptech.glide.c.j paramj)
  {
    this.aAy = paramb;
    this.aEf = paramh1;
    this.aEk = paramh2;
    this.width = paramInt1;
    this.height = paramInt2;
    this.aGs = paramm;
    this.aGr = paramClass;
    this.aEm = paramj;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77053);
    byte[] arrayOfByte3 = (byte[])this.aAy.n([B.class);
    ByteBuffer.wrap(arrayOfByte3).putInt(this.width).putInt(this.height).array();
    this.aEk.a(paramMessageDigest);
    this.aEf.a(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte3);
    if (this.aGs != null) {
      this.aGs.a(paramMessageDigest);
    }
    this.aEm.a(paramMessageDigest);
    byte[] arrayOfByte2 = (byte[])aGq.get(this.aGr);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = this.aGr.getName().getBytes(aDo);
      aGq.put(this.aGr, arrayOfByte1);
    }
    paramMessageDigest.update(arrayOfByte1);
    this.aAy.put(arrayOfByte3);
    AppMethodBeat.o(77053);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77051);
    if ((paramObject instanceof w))
    {
      paramObject = (w)paramObject;
      if ((this.height == paramObject.height) && (this.width == paramObject.width) && (com.bumptech.glide.h.j.e(this.aGs, paramObject.aGs)) && (this.aGr.equals(paramObject.aGr)) && (this.aEf.equals(paramObject.aEf)) && (this.aEk.equals(paramObject.aEk)) && (this.aEm.equals(paramObject.aEm)))
      {
        AppMethodBeat.o(77051);
        return true;
      }
      AppMethodBeat.o(77051);
      return false;
    }
    AppMethodBeat.o(77051);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77052);
    int j = ((this.aEf.hashCode() * 31 + this.aEk.hashCode()) * 31 + this.width) * 31 + this.height;
    int i = j;
    if (this.aGs != null) {
      i = j * 31 + this.aGs.hashCode();
    }
    j = this.aGr.hashCode();
    int k = this.aEm.hashCode();
    AppMethodBeat.o(77052);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77054);
    String str = "ResourceCacheKey{sourceKey=" + this.aEf + ", signature=" + this.aEk + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.aGr + ", transformation='" + this.aGs + '\'' + ", options=" + this.aEm + '}';
    AppMethodBeat.o(77054);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.w
 * JD-Core Version:    0.7.0.1
 */