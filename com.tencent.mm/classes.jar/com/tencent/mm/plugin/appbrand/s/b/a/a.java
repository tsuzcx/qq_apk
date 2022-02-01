package com.tencent.mm.plugin.appbrand.s.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;", "", "data", "", "startPos", "", "size", "([BII)V", "getSize", "()I", "asString", "", "dataEquals", "", "otherData", "get", "", "index", "newView", "toString", "Companion", "luggage-commons_release"})
public final class a
{
  public static final a qkp;
  public final int bPt;
  public final byte[] data;
  public final int size;
  
  static
  {
    AppMethodBeat.i(209773);
    qkp = new a((byte)0);
    AppMethodBeat.o(209773);
  }
  
  private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    this.bPt = paramInt1;
    this.size = paramInt2;
  }
  
  public final boolean bb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209770);
    p.k(paramArrayOfByte, "otherData");
    int j = paramArrayOfByte.length;
    if (this.size != j)
    {
      AppMethodBeat.o(209770);
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (get(i) != paramArrayOfByte[i])
      {
        AppMethodBeat.o(209770);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(209770);
    return true;
  }
  
  public final a eR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209767);
    a locala = a.E(this.data, this.bPt + paramInt1, paramInt2);
    AppMethodBeat.o(209767);
    return locala;
  }
  
  public final byte get(int paramInt)
  {
    AppMethodBeat.i(209766);
    if (paramInt >= this.size)
    {
      Throwable localThrowable = (Throwable)new ArrayIndexOutOfBoundsException("index: " + paramInt + ", size: " + this.size);
      AppMethodBeat.o(209766);
      throw localThrowable;
    }
    byte b = this.data[(this.bPt + paramInt)];
    AppMethodBeat.o(209766);
    return b;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209771);
    int j = this.size - 1;
    if (-1 == j)
    {
      AppMethodBeat.o(209771);
      return "[]";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
    int i = 0;
    if (j >= 0)
    {
      ((StringBuilder)localObject).append(Byte.valueOf(get(i)));
      if (j != i) {
        ((StringBuilder)localObject).append(", ");
      }
      for (;;)
      {
        if (i == j) {
          break label93;
        }
        i += 1;
        break;
        ((StringBuilder)localObject).append(']');
      }
    }
    label93:
    localObject = ((StringBuilder)localObject).toString();
    p.j(localObject, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(209771);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView$Companion;", "", "()V", "newView", "Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;", "data", "", "startPos", "", "size", "luggage-commons_release"})
  public static final class a
  {
    public static a E(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(208616);
      p.k(paramArrayOfByte, "data");
      int i = paramArrayOfByte.length;
      if ((paramInt1 < 0) || (i <= paramInt1))
      {
        paramArrayOfByte = (Throwable)new IllegalArgumentException("startPos is illegal, since startPos is " + paramInt1 + ", dataSize is " + i);
        AppMethodBeat.o(208616);
        throw paramArrayOfByte;
      }
      int j = paramInt1 + paramInt2;
      if ((j < 0) || (i < j))
      {
        paramArrayOfByte = (Throwable)new IllegalArgumentException("endPos is illegal, since endPos is " + j + ", dataSize is " + i);
        AppMethodBeat.o(208616);
        throw paramArrayOfByte;
      }
      paramArrayOfByte = new a(paramArrayOfByte, paramInt1, paramInt2, (byte)0);
      AppMethodBeat.o(208616);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.a.a
 * JD-Core Version:    0.7.0.1
 */