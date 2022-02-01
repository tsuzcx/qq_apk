package com.google.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
  implements Cloneable
{
  public int[] ceb;
  public int size;
  
  public a()
  {
    AppMethodBeat.i(12344);
    this.size = 0;
    this.ceb = new int[1];
    AppMethodBeat.o(12344);
  }
  
  private a(int[] paramArrayOfInt, int paramInt)
  {
    this.ceb = paramArrayOfInt;
    this.size = paramInt;
  }
  
  private void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(12345);
    if (paramInt > this.ceb.length << 5)
    {
      int[] arrayOfInt = new int[(paramInt + 31) / 32];
      System.arraycopy(this.ceb, 0, arrayOfInt, 0, this.ceb.length);
      this.ceb = arrayOfInt;
    }
    AppMethodBeat.o(12345);
  }
  
  public final int JI()
  {
    return (this.size + 7) / 8;
  }
  
  public final void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(12349);
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
        if (cr(i)) {
          m = k | 1 << 7 - j;
        }
        i += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt1 + 0)] = ((byte)k);
      paramInt1 += 1;
    }
    AppMethodBeat.o(12349);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(12348);
    int j = parama.size;
    ensureCapacity(this.size + j);
    int i = 0;
    while (i < j)
    {
      bU(parama.cr(i));
      i += 1;
    }
    AppMethodBeat.o(12348);
  }
  
  public final void bU(boolean paramBoolean)
  {
    AppMethodBeat.i(12346);
    ensureCapacity(this.size + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.ceb;
      int i = this.size / 32;
      arrayOfInt[i] |= 1 << (this.size & 0x1F);
    }
    this.size += 1;
    AppMethodBeat.o(12346);
  }
  
  public final void bY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12347);
    if ((paramInt2 < 0) || (paramInt2 > 32))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
      AppMethodBeat.o(12347);
      throw localIllegalArgumentException;
    }
    ensureCapacity(this.size + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        bU(bool);
        paramInt2 -= 1;
        break;
      }
    }
    AppMethodBeat.o(12347);
  }
  
  public final boolean cr(int paramInt)
  {
    return (this.ceb[(paramInt / 32)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(12350);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(12350);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.size == paramObject.size) && (Arrays.equals(this.ceb, paramObject.ceb)))
    {
      AppMethodBeat.o(12350);
      return true;
    }
    AppMethodBeat.o(12350);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(12351);
    int i = this.size;
    int j = Arrays.hashCode(this.ceb);
    AppMethodBeat.o(12351);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12352);
    Object localObject = new StringBuilder(this.size);
    int i = 0;
    if (i < this.size)
    {
      if ((i & 0x7) == 0) {
        ((StringBuilder)localObject).append(' ');
      }
      if (cr(i)) {}
      for (char c = 'X';; c = '.')
      {
        ((StringBuilder)localObject).append(c);
        i += 1;
        break;
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(12352);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.b.a
 * JD-Core Version:    0.7.0.1
 */