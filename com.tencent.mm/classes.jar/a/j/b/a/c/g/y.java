package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class y
{
  public static boolean D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121685);
    if (E(paramArrayOfByte, paramInt1, paramInt2) == 0)
    {
      AppMethodBeat.o(121685);
      return true;
    }
    AppMethodBeat.o(121685);
    return false;
  }
  
  public static int E(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121686);
    while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] >= 0)) {
      paramInt1 += 1;
    }
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(121686);
      return 0;
    }
    paramInt1 = F(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(121686);
    return paramInt1;
  }
  
  private static int F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121687);
    for (;;)
    {
      if (paramInt1 >= paramInt2)
      {
        AppMethodBeat.o(121687);
        return 0;
      }
      int i = paramInt1 + 1;
      paramInt1 = paramArrayOfByte[paramInt1];
      if (paramInt1 < 0)
      {
        if (paramInt1 < -32)
        {
          if (i >= paramInt2)
          {
            AppMethodBeat.o(121687);
            return paramInt1;
          }
          if (paramInt1 >= -62)
          {
            paramInt1 = i + 1;
            if (paramArrayOfByte[i] <= -65) {}
          }
          else
          {
            AppMethodBeat.o(121687);
            return -1;
          }
        }
        else
        {
          int j;
          if (paramInt1 < -16)
          {
            if (i >= paramInt2 - 1)
            {
              paramInt1 = G(paramArrayOfByte, i, paramInt2);
              AppMethodBeat.o(121687);
              return paramInt1;
            }
            j = i + 1;
            i = paramArrayOfByte[i];
            if ((i <= -65) && ((paramInt1 != -32) || (i >= -96)) && ((paramInt1 != -19) || (i < -96)))
            {
              paramInt1 = j + 1;
              if (paramArrayOfByte[j] <= -65) {}
            }
            else
            {
              AppMethodBeat.o(121687);
              return -1;
            }
          }
          else
          {
            if (i >= paramInt2 - 2)
            {
              paramInt1 = G(paramArrayOfByte, i, paramInt2);
              AppMethodBeat.o(121687);
              return paramInt1;
            }
            j = i + 1;
            i = paramArrayOfByte[i];
            if ((i <= -65) && ((paramInt1 << 28) + (i + 112) >> 30 == 0))
            {
              i = j + 1;
              if (paramArrayOfByte[j] <= -65)
              {
                paramInt1 = i + 1;
                if (paramArrayOfByte[i] <= -65) {
                  break label243;
                }
              }
            }
            AppMethodBeat.o(121687);
            return -1;
          }
        }
      }
      else {
        label243:
        paramInt1 = i;
      }
    }
  }
  
  private static int G(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121688);
    int i = paramArrayOfByte[(paramInt1 - 1)];
    switch (paramInt2 - paramInt1)
    {
    default: 
      paramArrayOfByte = new AssertionError();
      AppMethodBeat.o(121688);
      throw paramArrayOfByte;
    case 0: 
      paramInt1 = VP(i);
      AppMethodBeat.o(121688);
      return paramInt1;
    case 1: 
      paramInt1 = iI(i, paramArrayOfByte[paramInt1]);
      AppMethodBeat.o(121688);
      return paramInt1;
    }
    paramInt1 = aS(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
    AppMethodBeat.o(121688);
    return paramInt1;
  }
  
  private static int VP(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  static int aS(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16;
  }
  
  static int iI(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.g.y
 * JD-Core Version:    0.7.0.1
 */