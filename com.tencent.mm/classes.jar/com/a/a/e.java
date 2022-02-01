package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
{
  private static final float[] aPE = { 1.0F, 10.0F, 100.0F, 1000.0F, 10000.0F, 100000.0F, 1000000.0F, 10000000.0F, 1.0E+008F, 1.0E+009F, 1.0E+010F, 1.0E+011F, 1.0E+012F, 1.0E+013F, 1.0E+014F, 1.0E+015F, 1.0E+016F, 1.0E+017F, 1.0E+018F, 1.0E+019F, 1.0E+020F, 1.0E+021F, 1.0E+022F, 1.0E+023F, 1.0E+024F, 1.0E+025F, 1.0E+026F, 1.0E+027F, 9.999999E+027F, 1.0E+029F, 1.0E+030F, 1.0E+031F, 1.0E+032F, 1.0E+033F, 1.0E+034F, 1.0E+035F, 1.0E+036F, 1.0E+037F, 1.0E+038F };
  private static final float[] aPF = { 1.0F, 0.1F, 0.01F, 0.001F, 1.0E-004F, 1.0E-005F, 1.0E-006F, 1.0E-007F, 1.0E-008F, 1.0E-009F, 1.0E-010F, 1.0E-011F, 1.0E-012F, 1.0E-013F, 1.0E-014F, 1.0E-015F, 1.0E-016F, 1.0E-017F, 1.0E-018F, 1.0E-019F, 1.0E-020F, 1.0E-021F, 1.0E-022F, 1.0E-023F, 1.0E-024F, 1.0E-025F, 1.0E-026F, 1.0E-027F, 1.0E-028F, 1.0E-029F, 1.0E-030F, 1.0E-031F, 1.0E-032F, 1.0E-033F, 1.0E-034F, 1.0E-035F, 1.0E-036F, 1.0E-037F, 9.999999E-039F };
  int pos;
  
  final float f(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214736);
    int i3 = 0;
    int i2 = 0;
    long l1 = 0L;
    int i = 0;
    int m = 0;
    int j = 0;
    int n = 0;
    int i1 = 0;
    this.pos = paramInt1;
    if (this.pos >= paramInt2)
    {
      AppMethodBeat.o(214736);
      return (0.0F / 0.0F);
    }
    int k = i2;
    paramInt1 = i3;
    switch (paramString.charAt(this.pos))
    {
    default: 
      k = i2;
    case ',': 
      i2 = this.pos;
      paramInt1 = j;
      label105:
      if (this.pos >= paramInt2) {
        break label324;
      }
      i3 = paramString.charAt(this.pos);
      if (i3 == 48) {
        if (i == 0) {
          m += 1;
        }
      }
      break;
    }
    for (;;)
    {
      this.pos += 1;
      break label105;
      paramInt1 = 1;
      this.pos += 1;
      k = paramInt1;
      break;
      paramInt1 += 1;
      continue;
      if ((i3 >= 49) && (i3 <= 57))
      {
        j = paramInt1;
        while (j > 0)
        {
          if (l1 > 922337203685477580L)
          {
            AppMethodBeat.o(214736);
            return (0.0F / 0.0F);
          }
          l1 *= 10L;
          j -= 1;
        }
        if (l1 > 922337203685477580L)
        {
          AppMethodBeat.o(214736);
          return (0.0F / 0.0F);
        }
        long l2 = l1 * 10L + (i3 - 48);
        i = i + paramInt1 + 1;
        paramInt1 = j;
        l1 = l2;
        if (l2 < 0L)
        {
          AppMethodBeat.o(214736);
          return (0.0F / 0.0F);
        }
      }
      else
      {
        if ((i3 != 46) || (n != 0)) {
          break label324;
        }
        i1 = this.pos - i2;
        n = 1;
      }
    }
    label324:
    if ((n != 0) && (this.pos == i1 + 1))
    {
      AppMethodBeat.o(214736);
      return (0.0F / 0.0F);
    }
    if (i == 0) {
      if (m == 0)
      {
        AppMethodBeat.o(214736);
        return (0.0F / 0.0F);
      }
    }
    for (j = 1;; j = i)
    {
      if (n != 0) {
        paramInt1 = i1 - m - j;
      }
      if (this.pos < paramInt2)
      {
        i = paramString.charAt(this.pos);
        if ((i == 69) || (i == 101))
        {
          i = 0;
          m = 0;
          this.pos += 1;
          if (this.pos == paramInt2)
          {
            AppMethodBeat.o(214736);
            return (0.0F / 0.0F);
          }
          switch (paramString.charAt(this.pos))
          {
          case ',': 
          case '.': 
          case '/': 
          default: 
            m = 1;
            this.pos -= 1;
            i = 0;
            if (m == 0)
            {
              n = this.pos;
              m = 0;
            }
            break;
          case '-': 
          case '+': 
          case '0': 
          case '1': 
          case '2': 
          case '3': 
          case '4': 
          case '5': 
          case '6': 
          case '7': 
          case '8': 
          case '9': 
            for (;;)
            {
              if (this.pos >= paramInt2) {
                break label656;
              }
              i1 = paramString.charAt(this.pos);
              if ((i1 < 48) || (i1 > 57)) {
                break label656;
              }
              if (m > 922337203685477580L)
              {
                AppMethodBeat.o(214736);
                return (0.0F / 0.0F);
                i = 1;
                this.pos += 1;
                break;
                i = 0;
                break;
              }
              m = m * 10 + (i1 - 48);
              this.pos += 1;
            }
            label656:
            if (this.pos == n)
            {
              AppMethodBeat.o(214736);
              return (0.0F / 0.0F);
            }
            if (i != 0) {
              paramInt1 -= m;
            }
            break;
          }
        }
      }
      for (;;)
      {
        if ((paramInt1 + j > 39) || (paramInt1 + j < -44))
        {
          AppMethodBeat.o(214736);
          return (0.0F / 0.0F);
          paramInt1 += m;
        }
        else
        {
          float f2 = (float)l1;
          float f1 = f2;
          if (l1 != 0L)
          {
            if (paramInt1 <= 0) {
              break label765;
            }
            f1 = f2 * aPE[paramInt1];
          }
          while (k != 0)
          {
            f1 = -f1;
            AppMethodBeat.o(214736);
            return f1;
            label765:
            f1 = f2;
            if (paramInt1 < 0)
            {
              f1 = f2;
              paramInt2 = paramInt1;
              if (paramInt1 < -38)
              {
                f1 = (float)(f2 * 1.0E-020D);
                paramInt2 = paramInt1 + 20;
              }
              f1 *= aPF[(-paramInt2)];
            }
          }
          AppMethodBeat.o(214736);
          return f1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.e
 * JD-Core Version:    0.7.0.1
 */