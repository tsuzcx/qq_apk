package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;

public final class h
{
  private static char[] MA;
  private static final Object Mz;
  
  static
  {
    AppMethodBeat.i(251358);
    Mz = new Object();
    MA = new char[24];
    AppMethodBeat.o(251358);
  }
  
  private static int a(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean)
  {
    int i;
    int j;
    if (!paramBoolean)
    {
      i = paramInt2;
      if (paramInt1 <= 0) {}
    }
    else
    {
      if (paramInt1 <= 99) {
        break label120;
      }
      j = paramInt1 / 100;
      paramArrayOfChar[paramInt2] = ((char)(j + 48));
      i = paramInt2 + 1;
      paramInt1 -= j * 100;
    }
    for (;;)
    {
      int k;
      if (paramInt1 <= 9)
      {
        k = i;
        j = paramInt1;
        if (paramInt2 == i) {}
      }
      else
      {
        paramInt2 = paramInt1 / 10;
        paramArrayOfChar[i] = ((char)(paramInt2 + 48));
        k = i + 1;
        j = paramInt1 - paramInt2 * 10;
      }
      paramArrayOfChar[k] = ((char)(j + 48));
      paramInt1 = k + 1;
      paramArrayOfChar[paramInt1] = paramChar;
      i = paramInt1 + 1;
      return i;
      label120:
      i = paramInt2;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(251357);
    if (paramLong1 == 0L)
    {
      paramPrintWriter.print("--");
      AppMethodBeat.o(251357);
      return;
    }
    a(paramLong1 - paramLong2, paramPrintWriter);
    AppMethodBeat.o(251357);
  }
  
  private static void a(long paramLong, PrintWriter paramPrintWriter)
  {
    boolean bool2 = true;
    int j = 1;
    AppMethodBeat.i(251355);
    for (;;)
    {
      synchronized (Mz)
      {
        if (MA.length < 0) {
          MA = new char[0];
        }
        char[] arrayOfChar = MA;
        if (paramLong == 0L)
        {
          arrayOfChar[0] = '0';
          paramPrintWriter.print(new String(MA, 0, j));
          AppMethodBeat.o(251355);
          return;
        }
        int i;
        if (paramLong > 0L)
        {
          i = 43;
          int i1 = (int)(paramLong % 1000L);
          j = (int)Math.floor(paramLong / 1000L);
          if (j <= 86400) {
            break label346;
          }
          k = j / 86400;
          j -= k * 86400;
          if (j <= 3600) {
            break label340;
          }
          m = j / 3600;
          j -= m * 3600;
          if (j <= 60) {
            break label334;
          }
          n = j / 60;
          j -= n * 60;
          arrayOfChar[0] = i;
          k = a(arrayOfChar, k, 'd', 1, false);
          if (k != 1)
          {
            bool1 = true;
            k = a(arrayOfChar, m, 'h', k, bool1);
            if (k == 1) {
              continue;
            }
            bool1 = true;
            k = a(arrayOfChar, n, 'm', k, bool1);
            if (k == 1) {
              continue;
            }
            bool1 = bool2;
            j = a(arrayOfChar, i1, 'm', a(arrayOfChar, j, 's', k, bool1), true);
            arrayOfChar[j] = 's';
            j += 1;
          }
        }
        else
        {
          paramLong = -paramLong;
          i = 45;
          continue;
        }
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
      }
      label334:
      int n = 0;
      continue;
      label340:
      int m = 0;
      continue;
      label346:
      int k = 0;
    }
  }
  
  public static void b(long paramLong, PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(251356);
    a(paramLong, paramPrintWriter);
    AppMethodBeat.o(251356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.core.f.h
 * JD-Core Version:    0.7.0.1
 */