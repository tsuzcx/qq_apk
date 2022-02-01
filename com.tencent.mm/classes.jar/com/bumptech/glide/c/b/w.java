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
  private static final f<Class<?>, byte[]> aFA;
  private final h aDo;
  private final h aDt;
  private final com.bumptech.glide.c.j aDv;
  private final Class<?> aFB;
  private final m<?> aFC;
  private final b azE;
  private final int height;
  private final int width;
  
  static
  {
    AppMethodBeat.i(77055);
    aFA = new f(50L);
    AppMethodBeat.o(77055);
  }
  
  w(b paramb, h paramh1, h paramh2, int paramInt1, int paramInt2, m<?> paramm, Class<?> paramClass, com.bumptech.glide.c.j paramj)
  {
    this.azE = paramb;
    this.aDo = paramh1;
    this.aDt = paramh2;
    this.width = paramInt1;
    this.height = paramInt2;
    this.aFC = paramm;
    this.aFB = paramClass;
    this.aDv = paramj;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77053);
    byte[] arrayOfByte3 = (byte[])this.azE.n([B.class);
    ByteBuffer.wrap(arrayOfByte3).putInt(this.width).putInt(this.height).array();
    this.aDt.a(paramMessageDigest);
    this.aDo.a(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte3);
    if (this.aFC != null) {
      this.aFC.a(paramMessageDigest);
    }
    this.aDv.a(paramMessageDigest);
    byte[] arrayOfByte2 = (byte[])aFA.get(this.aFB);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = this.aFB.getName().getBytes(aCw);
      aFA.put(this.aFB, arrayOfByte1);
    }
    paramMessageDigest.update(arrayOfByte1);
    this.azE.put(arrayOfByte3);
    AppMethodBeat.o(77053);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77051);
    if ((paramObject instanceof w))
    {
      paramObject = (w)paramObject;
      if ((this.height == paramObject.height) && (this.width == paramObject.width) && (com.bumptech.glide.h.j.e(this.aFC, paramObject.aFC)) && (this.aFB.equals(paramObject.aFB)) && (this.aDo.equals(paramObject.aDo)) && (this.aDt.equals(paramObject.aDt)) && (this.aDv.equals(paramObject.aDv)))
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
    int j = ((this.aDo.hashCode() * 31 + this.aDt.hashCode()) * 31 + this.width) * 31 + this.height;
    int i = j;
    if (this.aFC != null) {
      i = j * 31 + this.aFC.hashCode();
    }
    j = this.aFB.hashCode();
    int k = this.aDv.hashCode();
    AppMethodBeat.o(77052);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77054);
    String str = "ResourceCacheKey{sourceKey=" + this.aDo + ", signature=" + this.aDt + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.aFB + ", transformation='" + this.aFC + '\'' + ", options=" + this.aDv + '}';
    AppMethodBeat.o(77054);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.w
 * JD-Core Version:    0.7.0.1
 */