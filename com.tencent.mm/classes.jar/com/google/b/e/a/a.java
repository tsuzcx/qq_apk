package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class a
{
  private final b[] ceC;
  int ceD;
  private final int height;
  private final int width;
  
  a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12294);
    this.ceC = new b[paramInt1];
    int i = 0;
    int j = this.ceC.length;
    while (i < j)
    {
      this.ceC[i] = new b((paramInt2 + 4) * 17 + 1);
      i += 1;
    }
    this.width = (paramInt2 * 17);
    this.height = paramInt1;
    this.ceD = -1;
    AppMethodBeat.o(12294);
  }
  
  final b Iy()
  {
    return this.ceC[this.ceD];
  }
  
  public final byte[][] bN(int paramInt1, int paramInt2)
  {
    int i = this.height;
    int j = this.width;
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i * paramInt2, j * paramInt1 });
    int k = this.height * paramInt2;
    i = 0;
    while (i < k)
    {
      b localb = this.ceC[(i / paramInt2)];
      byte[] arrayOfByte1 = new byte[localb.ceE.length * paramInt1];
      j = 0;
      while (j < arrayOfByte1.length)
      {
        arrayOfByte1[j] = localb.ceE[(j / paramInt1)];
        j += 1;
      }
      arrayOfByte[(k - i - 1)] = arrayOfByte1;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.e.a.a
 * JD-Core Version:    0.7.0.1
 */