package com.google.c.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class b
{
  final byte[][] bNi;
  public final int height;
  public final int width;
  
  public b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12242);
    this.bNi = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    this.width = paramInt1;
    this.height = paramInt2;
    AppMethodBeat.o(12242);
  }
  
  public final byte bP(int paramInt1, int paramInt2)
  {
    return this.bNi[paramInt2][paramInt1];
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bNi[paramInt2][paramInt1] = ((byte)paramInt3);
  }
  
  public final void set(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.bNi[paramInt2];
    if (paramBoolean) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      arrayOfByte[paramInt1] = ((byte)paramInt2);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12243);
    Object localObject = new StringBuilder(this.width * 2 * this.height + 2);
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      if (j < this.width)
      {
        switch (this.bNi[i][j])
        {
        default: 
          ((StringBuilder)localObject).append("  ");
        }
        for (;;)
        {
          j += 1;
          break;
          ((StringBuilder)localObject).append(" 0");
          continue;
          ((StringBuilder)localObject).append(" 1");
        }
      }
      ((StringBuilder)localObject).append('\n');
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(12243);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.f.b.b
 * JD-Core Version:    0.7.0.1
 */