package com.tencent.liteav.basic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;

public class g
{
  public static final byte[] a;
  
  static
  {
    AppMethodBeat.i(146699);
    a = "#PART#".getBytes();
    AppMethodBeat.o(146699);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(146697);
    paramArrayOfByte2 = new PKCS8EncodedKeySpec(paramArrayOfByte2);
    paramArrayOfByte2 = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte2);
    Cipher localCipher = Cipher.getInstance("RSA/None/PKCS1Padding");
    localCipher.init(2, paramArrayOfByte2);
    paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
    AppMethodBeat.o(146697);
    return paramArrayOfByte1;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(146698);
    int i3 = a.length;
    if (i3 <= 0)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(146698);
      return paramArrayOfByte1;
    }
    int i4 = paramArrayOfByte1.length;
    ArrayList localArrayList = new ArrayList(1024);
    int j = 0;
    int k = 0;
    int i;
    byte[] arrayOfByte;
    int n;
    int m;
    if (j < i4)
    {
      i = paramArrayOfByte1[j];
      if (j == i4 - 1)
      {
        arrayOfByte = new byte[i4 - k];
        System.arraycopy(paramArrayOfByte1, k, arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = a(arrayOfByte, paramArrayOfByte2);
        k = arrayOfByte.length;
        i = 0;
        while (i < k)
        {
          localArrayList.add(Byte.valueOf(arrayOfByte[i]));
          i += 1;
        }
        n = j + i3;
        m = n - 1;
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        arrayOfByte = new byte[m - n];
        System.arraycopy(paramArrayOfByte1, n, arrayOfByte, 0, arrayOfByte.length);
        arrayOfByte = a(arrayOfByte, paramArrayOfByte2);
        j = arrayOfByte.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localArrayList.add(Byte.valueOf(arrayOfByte[i]));
            i += 1;
            continue;
            if (i != a[0]) {
              break label404;
            }
            if (i3 > 1)
            {
              if (j + i3 >= i4) {
                break label404;
              }
              int i2 = 1;
              int i1 = 0;
              for (;;)
              {
                i = i1;
                m = j;
                n = k;
                if (i2 >= i3) {
                  break;
                }
                i = i1;
                m = j;
                n = k;
                if (a[i2] != paramArrayOfByte1[(j + i2)]) {
                  break;
                }
                if (i2 == i3 - 1) {
                  i1 = 1;
                }
                i2 += 1;
              }
            }
            i = 1;
            m = j;
            n = k;
            break;
          }
        }
        k = m + i3;
        i = k - 1;
      }
      for (;;)
      {
        j = i + 1;
        break;
        paramArrayOfByte1 = new byte[localArrayList.size()];
        paramArrayOfByte2 = localArrayList.iterator();
        i = 0;
        while (paramArrayOfByte2.hasNext())
        {
          paramArrayOfByte1[i] = ((Byte)paramArrayOfByte2.next()).byteValue();
          i += 1;
        }
        AppMethodBeat.o(146698);
        return paramArrayOfByte1;
        i = m;
        k = n;
      }
      label404:
      i = 0;
      m = j;
      n = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.basic.b.g
 * JD-Core Version:    0.7.0.1
 */