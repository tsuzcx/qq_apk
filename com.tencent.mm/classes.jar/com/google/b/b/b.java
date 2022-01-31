package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class b
  implements Cloneable
{
  private final int[] bij;
  private final int bik;
  public final int height;
  public final int width;
  
  public b(int paramInt)
  {
    this(paramInt, paramInt);
    AppMethodBeat.i(57264);
    AppMethodBeat.o(57264);
  }
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57265);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Both dimensions must be greater than 0");
      AppMethodBeat.o(57265);
      throw localIllegalArgumentException;
    }
    this.width = paramInt1;
    this.height = paramInt2;
    this.bik = ((paramInt1 + 31) / 32);
    this.bij = new int[this.bik * paramInt2];
    AppMethodBeat.o(57265);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.bik = paramInt3;
    this.bij = paramArrayOfInt;
  }
  
  public final boolean bu(int paramInt1, int paramInt2)
  {
    int i = this.bik;
    int j = paramInt1 / 32;
    return (this.bij[(i * paramInt2 + j)] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public final void clear()
  {
    int j = this.bij.length;
    int i = 0;
    while (i < j)
    {
      this.bij[i] = 0;
      i += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57267);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(57267);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.width == paramObject.width) && (this.height == paramObject.height) && (this.bik == paramObject.bik) && (Arrays.equals(this.bij, paramObject.bij)))
    {
      AppMethodBeat.o(57267);
      return true;
    }
    AppMethodBeat.o(57267);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57268);
    int i = this.width;
    int j = this.width;
    int k = this.height;
    int m = this.bik;
    int n = Arrays.hashCode(this.bij);
    AppMethodBeat.o(57268);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void o(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(57266);
    Object localObject;
    if ((paramInt2 < 0) || (paramInt1 < 0))
    {
      localObject = new IllegalArgumentException("Left and top must be nonnegative");
      AppMethodBeat.o(57266);
      throw ((Throwable)localObject);
    }
    if ((paramInt4 <= 0) || (paramInt3 <= 0))
    {
      localObject = new IllegalArgumentException("Height and width must be at least 1");
      AppMethodBeat.o(57266);
      throw ((Throwable)localObject);
    }
    int i = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    if ((paramInt4 > this.height) || (i > this.width))
    {
      localObject = new IllegalArgumentException("The region must fit inside the matrix");
      AppMethodBeat.o(57266);
      throw ((Throwable)localObject);
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 >= paramInt4) {
        break;
      }
      int j = this.bik;
      paramInt3 = paramInt1;
      while (paramInt3 < i)
      {
        localObject = this.bij;
        int k = paramInt3 / 32 + paramInt2 * j;
        localObject[k] |= 1 << (paramInt3 & 0x1F);
        paramInt3 += 1;
      }
    }
    AppMethodBeat.o(57266);
  }
  
  public final void set(int paramInt1, int paramInt2)
  {
    paramInt2 = this.bik * paramInt2 + paramInt1 / 32;
    int[] arrayOfInt = this.bij;
    arrayOfInt[paramInt2] |= 1 << (paramInt1 & 0x1F);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57269);
    StringBuilder localStringBuilder = new StringBuilder(this.height * (this.width + 1));
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      if (j < this.width)
      {
        if (bu(j, i)) {}
        for (str = "X ";; str = "  ")
        {
          localStringBuilder.append(str);
          j += 1;
          break;
        }
      }
      localStringBuilder.append("\n");
      i += 1;
    }
    String str = localStringBuilder.toString();
    AppMethodBeat.o(57269);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.b.b
 * JD-Core Version:    0.7.0.1
 */