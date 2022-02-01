package com.google.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class b
  implements Cloneable
{
  private final int[] ccy;
  private final int ccz;
  public final int height;
  public final int width;
  
  public b(int paramInt)
  {
    this(paramInt, paramInt);
    AppMethodBeat.i(12329);
    AppMethodBeat.o(12329);
  }
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12330);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Both dimensions must be greater than 0");
      AppMethodBeat.o(12330);
      throw localIllegalArgumentException;
    }
    this.width = paramInt1;
    this.height = paramInt2;
    this.ccz = ((paramInt1 + 31) / 32);
    this.ccy = new int[this.ccz * paramInt2];
    AppMethodBeat.o(12330);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.ccz = paramInt3;
    this.ccy = paramArrayOfInt;
  }
  
  public final boolean bI(int paramInt1, int paramInt2)
  {
    int i = this.ccz;
    int j = paramInt1 / 32;
    return (this.ccy[(i * paramInt2 + j)] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public final void clear()
  {
    int j = this.ccy.length;
    int i = 0;
    while (i < j)
    {
      this.ccy[i] = 0;
      i += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(12332);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(12332);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.width == paramObject.width) && (this.height == paramObject.height) && (this.ccz == paramObject.ccz) && (Arrays.equals(this.ccy, paramObject.ccy)))
    {
      AppMethodBeat.o(12332);
      return true;
    }
    AppMethodBeat.o(12332);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(12333);
    int i = this.width;
    int j = this.width;
    int k = this.height;
    int m = this.ccz;
    int n = Arrays.hashCode(this.ccy);
    AppMethodBeat.o(12333);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(12331);
    Object localObject;
    if ((paramInt2 < 0) || (paramInt1 < 0))
    {
      localObject = new IllegalArgumentException("Left and top must be nonnegative");
      AppMethodBeat.o(12331);
      throw ((Throwable)localObject);
    }
    if ((paramInt4 <= 0) || (paramInt3 <= 0))
    {
      localObject = new IllegalArgumentException("Height and width must be at least 1");
      AppMethodBeat.o(12331);
      throw ((Throwable)localObject);
    }
    int i = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    if ((paramInt4 > this.height) || (i > this.width))
    {
      localObject = new IllegalArgumentException("The region must fit inside the matrix");
      AppMethodBeat.o(12331);
      throw ((Throwable)localObject);
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 >= paramInt4) {
        break;
      }
      int j = this.ccz;
      paramInt3 = paramInt1;
      while (paramInt3 < i)
      {
        localObject = this.ccy;
        int k = paramInt3 / 32 + paramInt2 * j;
        localObject[k] |= 1 << (paramInt3 & 0x1F);
        paramInt3 += 1;
      }
    }
    AppMethodBeat.o(12331);
  }
  
  public final void set(int paramInt1, int paramInt2)
  {
    paramInt2 = this.ccz * paramInt2 + paramInt1 / 32;
    int[] arrayOfInt = this.ccy;
    arrayOfInt[paramInt2] |= 1 << (paramInt1 & 0x1F);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12334);
    StringBuilder localStringBuilder = new StringBuilder(this.height * (this.width + 1));
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      if (j < this.width)
      {
        if (bI(j, i)) {}
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
    AppMethodBeat.o(12334);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.b.b
 * JD-Core Version:    0.7.0.1
 */