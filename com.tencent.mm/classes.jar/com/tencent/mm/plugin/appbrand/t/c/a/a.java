package com.tencent.mm.plugin.appbrand.t.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;", "", "data", "", "startPos", "", "size", "([BII)V", "getSize", "()I", "asString", "", "dataEquals", "", "otherData", "get", "", "index", "newView", "toString", "Companion", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tpm;
  public final int dIY;
  public final byte[] data;
  public final int size;
  
  static
  {
    AppMethodBeat.i(319184);
    tpm = new a((byte)0);
    AppMethodBeat.o(319184);
  }
  
  private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    this.dIY = paramInt1;
    this.size = paramInt2;
  }
  
  public final boolean bb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(319198);
    s.u(paramArrayOfByte, "otherData");
    int k = paramArrayOfByte.length;
    if (this.size != k)
    {
      AppMethodBeat.o(319198);
      return false;
    }
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (get(i) != paramArrayOfByte[i])
      {
        AppMethodBeat.o(319198);
        return false;
      }
      if (j >= k)
      {
        AppMethodBeat.o(319198);
        return true;
      }
    }
  }
  
  public final a fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(319191);
    a locala = a.C(this.data, this.dIY + paramInt1, paramInt2);
    AppMethodBeat.o(319191);
    return locala;
  }
  
  public final byte get(int paramInt)
  {
    AppMethodBeat.i(319188);
    if (paramInt >= this.size)
    {
      ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("index: " + paramInt + ", size: " + this.size);
      AppMethodBeat.o(319188);
      throw localArrayIndexOutOfBoundsException;
    }
    byte b = this.data[(this.dIY + paramInt)];
    AppMethodBeat.o(319188);
    return b;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(319205);
    int j = this.size - 1;
    if (-1 == j)
    {
      AppMethodBeat.o(319205);
      return "[]";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
    int i = 0;
    if (j >= 0) {}
    for (;;)
    {
      ((StringBuilder)localObject).append(Byte.valueOf(get(i)));
      if (j != i) {
        ((StringBuilder)localObject).append(", ");
      }
      while (i == j)
      {
        localObject = ((StringBuilder)localObject).toString();
        s.s(localObject, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(319205);
        return localObject;
        ((StringBuilder)localObject).append(']');
      }
      i += 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView$Companion;", "", "()V", "newView", "Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;", "data", "", "startPos", "", "size", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int j = 1;
      AppMethodBeat.i(319185);
      s.u(paramArrayOfByte, "data");
      int k = paramArrayOfByte.length;
      int i;
      if (paramInt1 >= 0) {
        if (paramInt1 < k) {
          i = 1;
        }
      }
      while (i == 0)
      {
        paramArrayOfByte = new IllegalArgumentException("startPos is illegal, since startPos is " + paramInt1 + ", dataSize is " + k);
        AppMethodBeat.o(319185);
        throw paramArrayOfByte;
        i = 0;
        continue;
        i = 0;
      }
      int m = paramInt1 + paramInt2;
      if (m >= 0) {
        if (m <= k) {
          i = j;
        }
      }
      while (i == 0)
      {
        paramArrayOfByte = new IllegalArgumentException("endPos is illegal, since endPos is " + m + ", dataSize is " + k);
        AppMethodBeat.o(319185);
        throw paramArrayOfByte;
        i = 0;
        continue;
        i = 0;
      }
      paramArrayOfByte = new a(paramArrayOfByte, paramInt1, paramInt2, (byte)0);
      AppMethodBeat.o(319185);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.a.a
 * JD-Core Version:    0.7.0.1
 */