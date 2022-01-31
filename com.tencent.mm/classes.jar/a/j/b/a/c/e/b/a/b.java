package a.j.b.a.c.e.b.a;

import a.aa;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static final boolean CpZ;
  
  static
  {
    AppMethodBeat.i(121302);
    boolean bool;
    if (!b.class.desiredAssertionStatus()) {
      bool = true;
    }
    for (;;)
    {
      $assertionsDisabled = bool;
      try
      {
        String str = System.getProperty("kotlin.jvm.serialization.use8to7");
        CpZ = "true".equals(str);
        AppMethodBeat.o(121302);
        return;
        bool = false;
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static byte[] af(String[] paramArrayOfString)
  {
    int n = 0;
    AppMethodBeat.i(121299);
    Object localObject = paramArrayOfString;
    if (paramArrayOfString.length > 0)
    {
      localObject = paramArrayOfString;
      if (!paramArrayOfString[0].isEmpty())
      {
        int i = paramArrayOfString[0].charAt(0);
        if (i == 0)
        {
          paramArrayOfString = ag(paramArrayOfString);
          j.q(paramArrayOfString, "strings");
          int k = paramArrayOfString.length;
          i = 0;
          int j = 0;
          while (i < k)
          {
            j += paramArrayOfString[i].length();
            i += 1;
          }
          localObject = new byte[j];
          int i1 = paramArrayOfString.length;
          j = 0;
          i = 0;
          while (j < i1)
          {
            String str = paramArrayOfString[j];
            int i2 = str.length() - 1;
            if (i2 >= 0)
            {
              k = 0;
              for (;;)
              {
                int m = i + 1;
                localObject[i] = ((byte)str.charAt(k));
                i = m;
                if (k == i2) {
                  break;
                }
                k += 1;
                i = m;
              }
            }
            j += 1;
          }
          j = n;
          if (i == localObject.length) {
            j = 1;
          }
          if ((aa.BMh) && (j == 0))
          {
            paramArrayOfString = (Throwable)new AssertionError("Should have reached the end");
            AppMethodBeat.o(121299);
            throw paramArrayOfString;
          }
          AppMethodBeat.o(121299);
          return localObject;
        }
        localObject = paramArrayOfString;
        if (i == 65535) {
          localObject = ag(paramArrayOfString);
        }
      }
    }
    paramArrayOfString = ah((String[])localObject);
    cz(paramArrayOfString);
    paramArrayOfString = cA(paramArrayOfString);
    AppMethodBeat.o(121299);
    return paramArrayOfString;
  }
  
  private static String[] ag(String[] paramArrayOfString)
  {
    AppMethodBeat.i(121300);
    paramArrayOfString = (String[])paramArrayOfString.clone();
    paramArrayOfString[0] = paramArrayOfString[0].substring(1);
    AppMethodBeat.o(121300);
    return paramArrayOfString;
  }
  
  private static byte[] ah(String[] paramArrayOfString)
  {
    AppMethodBeat.i(121301);
    int k = paramArrayOfString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localObject = paramArrayOfString[i];
      if ((!$assertionsDisabled) && (((String)localObject).length() > 65535))
      {
        paramArrayOfString = new AssertionError("String is too long: " + ((String)localObject).length());
        AppMethodBeat.o(121301);
        throw paramArrayOfString;
      }
      j += ((String)localObject).length();
      i += 1;
    }
    Object localObject = new byte[j];
    int m = paramArrayOfString.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      String str = paramArrayOfString[i];
      int n = str.length();
      k = 0;
      while (k < n)
      {
        localObject[j] = ((byte)str.charAt(k));
        k += 1;
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(121301);
    return localObject;
  }
  
  private static byte[] cA(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length * 7 / 8;
    byte[] arrayOfByte = new byte[m];
    int k = 0;
    int j = 0;
    int i = 0;
    if (k < m)
    {
      int n = paramArrayOfByte[i];
      i += 1;
      arrayOfByte[k] = ((byte)(((n & 0xFF) >>> j) + ((paramArrayOfByte[i] & (1 << j + 1) - 1) << 7 - j)));
      if (j == 6)
      {
        i += 1;
        j = 0;
      }
      for (;;)
      {
        k += 1;
        break;
        j += 1;
      }
    }
    return arrayOfByte;
  }
  
  private static void cz(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] + 127 & 0x7F));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.b
 * JD-Core Version:    0.7.0.1
 */