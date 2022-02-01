package com.bumptech.glide.load.b;

import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class x
  implements com.bumptech.glide.load.g
{
  private static final com.bumptech.glide.g.g<Class<?>, byte[]> aIb;
  private final b aCo;
  private final com.bumptech.glide.load.g aFO;
  private final com.bumptech.glide.load.g aFT;
  private final i aFV;
  private final Class<?> aIc;
  private final l<?> aId;
  private final int height;
  private final int width;
  
  static
  {
    AppMethodBeat.i(77055);
    aIb = new com.bumptech.glide.g.g(50L);
    AppMethodBeat.o(77055);
  }
  
  x(b paramb, com.bumptech.glide.load.g paramg1, com.bumptech.glide.load.g paramg2, int paramInt1, int paramInt2, l<?> paraml, Class<?> paramClass, i parami)
  {
    this.aCo = paramb;
    this.aFO = paramg1;
    this.aFT = paramg2;
    this.width = paramInt1;
    this.height = paramInt2;
    this.aId = paraml;
    this.aIc = paramClass;
    this.aFV = parami;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77053);
    byte[] arrayOfByte3 = (byte[])this.aCo.o([B.class);
    ByteBuffer.wrap(arrayOfByte3).putInt(this.width).putInt(this.height).array();
    this.aFT.a(paramMessageDigest);
    this.aFO.a(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte3);
    if (this.aId != null) {
      this.aId.a(paramMessageDigest);
    }
    this.aFV.a(paramMessageDigest);
    byte[] arrayOfByte2 = (byte[])aIb.get(this.aIc);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = this.aIc.getName().getBytes(aEV);
      aIb.put(this.aIc, arrayOfByte1);
    }
    paramMessageDigest.update(arrayOfByte1);
    this.aCo.put(arrayOfByte3);
    AppMethodBeat.o(77053);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77051);
    if ((paramObject instanceof x))
    {
      paramObject = (x)paramObject;
      if ((this.height == paramObject.height) && (this.width == paramObject.width) && (k.h(this.aId, paramObject.aId)) && (this.aIc.equals(paramObject.aIc)) && (this.aFO.equals(paramObject.aFO)) && (this.aFT.equals(paramObject.aFT)) && (this.aFV.equals(paramObject.aFV)))
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
    int j = ((this.aFO.hashCode() * 31 + this.aFT.hashCode()) * 31 + this.width) * 31 + this.height;
    int i = j;
    if (this.aId != null) {
      i = j * 31 + this.aId.hashCode();
    }
    j = this.aIc.hashCode();
    int k = this.aFV.hashCode();
    AppMethodBeat.o(77052);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77054);
    String str = "ResourceCacheKey{sourceKey=" + this.aFO + ", signature=" + this.aFT + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.aIc + ", transformation='" + this.aId + '\'' + ", options=" + this.aFV + '}';
    AppMethodBeat.o(77054);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.x
 * JD-Core Version:    0.7.0.1
 */