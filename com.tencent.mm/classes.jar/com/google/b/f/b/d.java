package com.google.b.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  static int a(b paramb, boolean paramBoolean)
  {
    int m;
    int n;
    label20:
    int i1;
    if (paramBoolean)
    {
      m = paramb.height;
      if (!paramBoolean) {
        break label97;
      }
      n = paramb.width;
      paramb = paramb.cfD;
      i1 = 0;
    }
    label46:
    int j;
    for (int i = 0;; i = j)
    {
      if (i1 >= m) {
        return i;
      }
      int k = -1;
      int i2 = 0;
      int i3 = 0;
      if (i2 < n)
      {
        if (paramBoolean)
        {
          j = paramb[i1][i2];
          label65:
          if (j != k) {
            break label117;
          }
        }
        for (j = i3 + 1;; j = i3)
        {
          i2 += 1;
          i3 = j;
          break label46;
          m = paramb.width;
          break;
          label97:
          n = paramb.height;
          break label20;
          j = paramb[i2][i1];
          break label65;
          label117:
          k = i;
          if (i3 >= 5) {
            k = i + (i3 - 5 + 3);
          }
          i3 = 1;
          i = k;
          k = j;
        }
      }
      j = i;
      if (i3 >= 5) {
        j = i + (i3 - 5 + 3);
      }
      i1 += 1;
    }
    return i;
  }
  
  static boolean a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12246);
    paramInt2 = Math.max(paramInt2, 0);
    paramInt3 = Math.min(paramInt3, paramArrayOfByte.length);
    while (paramInt2 < paramInt3)
    {
      if (paramArrayOfByte[paramInt2][paramInt1] == 1)
      {
        AppMethodBeat.o(12246);
        return false;
      }
      paramInt2 += 1;
    }
    AppMethodBeat.o(12246);
    return true;
  }
  
  static boolean x(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12245);
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.min(paramInt2, paramArrayOfByte.length);
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] == 1)
      {
        AppMethodBeat.o(12245);
        return false;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(12245);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.f.b.d
 * JD-Core Version:    0.7.0.1
 */