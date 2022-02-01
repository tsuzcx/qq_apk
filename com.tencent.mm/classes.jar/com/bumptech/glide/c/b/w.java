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
  private static final f<Class<?>, byte[]> aIh;
  private final b aCp;
  private final h aFW;
  private final h aGb;
  private final com.bumptech.glide.c.j aGd;
  private final Class<?> aIi;
  private final m<?> aIj;
  private final int height;
  private final int width;
  
  static
  {
    AppMethodBeat.i(77055);
    aIh = new f(50L);
    AppMethodBeat.o(77055);
  }
  
  w(b paramb, h paramh1, h paramh2, int paramInt1, int paramInt2, m<?> paramm, Class<?> paramClass, com.bumptech.glide.c.j paramj)
  {
    this.aCp = paramb;
    this.aFW = paramh1;
    this.aGb = paramh2;
    this.width = paramInt1;
    this.height = paramInt2;
    this.aIj = paramm;
    this.aIi = paramClass;
    this.aGd = paramj;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77053);
    byte[] arrayOfByte3 = (byte[])this.aCp.n([B.class);
    ByteBuffer.wrap(arrayOfByte3).putInt(this.width).putInt(this.height).array();
    this.aGb.a(paramMessageDigest);
    this.aFW.a(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte3);
    if (this.aIj != null) {
      this.aIj.a(paramMessageDigest);
    }
    this.aGd.a(paramMessageDigest);
    byte[] arrayOfByte2 = (byte[])aIh.get(this.aIi);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = this.aIi.getName().getBytes(aFf);
      aIh.put(this.aIi, arrayOfByte1);
    }
    paramMessageDigest.update(arrayOfByte1);
    this.aCp.put(arrayOfByte3);
    AppMethodBeat.o(77053);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77051);
    if ((paramObject instanceof w))
    {
      paramObject = (w)paramObject;
      if ((this.height == paramObject.height) && (this.width == paramObject.width) && (com.bumptech.glide.h.j.g(this.aIj, paramObject.aIj)) && (this.aIi.equals(paramObject.aIi)) && (this.aFW.equals(paramObject.aFW)) && (this.aGb.equals(paramObject.aGb)) && (this.aGd.equals(paramObject.aGd)))
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
    int j = ((this.aFW.hashCode() * 31 + this.aGb.hashCode()) * 31 + this.width) * 31 + this.height;
    int i = j;
    if (this.aIj != null) {
      i = j * 31 + this.aIj.hashCode();
    }
    j = this.aIi.hashCode();
    int k = this.aGd.hashCode();
    AppMethodBeat.o(77052);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77054);
    String str = "ResourceCacheKey{sourceKey=" + this.aFW + ", signature=" + this.aGb + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.aIi + ", transformation='" + this.aIj + '\'' + ", options=" + this.aGd + '}';
    AppMethodBeat.o(77054);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.w
 * JD-Core Version:    0.7.0.1
 */