package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
  implements Cloneable
{
  public int[] bij;
  public int size;
  
  public a()
  {
    AppMethodBeat.i(57279);
    this.size = 0;
    this.bij = new int[1];
    AppMethodBeat.o(57279);
  }
  
  private a(int[] paramArrayOfInt, int paramInt)
  {
    this.bij = paramArrayOfInt;
    this.size = paramInt;
  }
  
  private void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(57280);
    if (paramInt > this.bij.length << 5)
    {
      int[] arrayOfInt = new int[(paramInt + 31) / 32];
      System.arraycopy(this.bij, 0, arrayOfInt, 0, this.bij.length);
      this.bij = arrayOfInt;
    }
    AppMethodBeat.o(57280);
  }
  
  public final void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(57284);
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (get(i)) {
          m = k | 1 << 7 - j;
        }
        i += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt1 + 0)] = ((byte)k);
      paramInt1 += 1;
    }
    AppMethodBeat.o(57284);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(57283);
    int j = parama.size;
    ensureCapacity(this.size + j);
    int i = 0;
    while (i < j)
    {
      aS(parama.get(i));
      i += 1;
    }
    AppMethodBeat.o(57283);
  }
  
  public final void aS(boolean paramBoolean)
  {
    AppMethodBeat.i(57281);
    ensureCapacity(this.size + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.bij;
      int i = this.size / 32;
      arrayOfInt[i] |= 1 << (this.size & 0x1F);
    }
    this.size += 1;
    AppMethodBeat.o(57281);
  }
  
  public final void bt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57282);
    if ((paramInt2 < 0) || (paramInt2 > 32))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
      AppMethodBeat.o(57282);
      throw localIllegalArgumentException;
    }
    ensureCapacity(this.size + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        aS(bool);
        paramInt2 -= 1;
        break;
      }
    }
    AppMethodBeat.o(57282);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57285);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(57285);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.size == paramObject.size) && (Arrays.equals(this.bij, paramObject.bij)))
    {
      AppMethodBeat.o(57285);
      return true;
    }
    AppMethodBeat.o(57285);
    return false;
  }
  
  public final boolean get(int paramInt)
  {
    return (this.bij[(paramInt / 32)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57286);
    int i = this.size;
    int j = Arrays.hashCode(this.bij);
    AppMethodBeat.o(57286);
    return i * 31 + j;
  }
  
  public final int sB()
  {
    return (this.size + 7) / 8;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57287);
    Object localObject = new StringBuilder(this.size);
    int i = 0;
    if (i < this.size)
    {
      if ((i & 0x7) == 0) {
        ((StringBuilder)localObject).append(' ');
      }
      if (get(i)) {}
      for (char c = 'X';; c = '.')
      {
        ((StringBuilder)localObject).append(c);
        i += 1;
        break;
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(57287);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.b.b.a
 * JD-Core Version:    0.7.0.1
 */