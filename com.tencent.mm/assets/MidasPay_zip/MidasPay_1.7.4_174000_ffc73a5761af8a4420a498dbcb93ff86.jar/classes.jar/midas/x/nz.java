package midas.x;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class nz
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  static int a(int paramInt)
  {
    if (paramInt < a.length) {
      return a[paramInt];
    }
    return -1;
  }
  
  private static int a(nn paramnn, nu paramnu, nw paramnw, ny paramny)
    throws nl
  {
    int j = 2147483647;
    int k = -1;
    int i = 0;
    while (i < 8)
    {
      ob.a(paramnn, paramnu, paramnw, i, paramny);
      int n = a(paramny);
      int m = j;
      if (n < j)
      {
        k = i;
        m = n;
      }
      i += 1;
      j = m;
    }
    return k;
  }
  
  private static int a(nv paramnv, nn paramnn1, nn paramnn2, nw paramnw)
  {
    return paramnn1.a() + paramnv.a(paramnw) + paramnn2.a();
  }
  
  private static int a(ny paramny)
  {
    return oa.a(paramny) + oa.b(paramny) + oa.c(paramny) + oa.d(paramny);
  }
  
  static nn a(nn paramnn, int paramInt1, int paramInt2, int paramInt3)
    throws nl
  {
    if (paramnn.b() == paramInt2)
    {
      Object localObject1 = new ArrayList(paramInt3);
      int n = 0;
      int k = 0;
      int m = 0;
      int j = 0;
      int i = 0;
      Object localObject2;
      byte[] arrayOfByte;
      while (k < paramInt3)
      {
        localObject2 = new int[1];
        Object localObject3 = new int[1];
        a(paramInt1, paramInt2, paramInt3, k, (int[])localObject2, (int[])localObject3);
        int i1 = localObject2[0];
        arrayOfByte = new byte[i1];
        paramnn.a(m * 8, arrayOfByte, 0, i1);
        localObject3 = a(arrayOfByte, localObject3[0]);
        ((Collection)localObject1).add(new nx(arrayOfByte, (byte[])localObject3));
        j = Math.max(j, i1);
        i = Math.max(i, localObject3.length);
        m += localObject2[0];
        k += 1;
      }
      if (paramInt2 == m)
      {
        paramnn = new nn();
        paramInt2 = 0;
        for (;;)
        {
          paramInt3 = n;
          if (paramInt2 >= j) {
            break;
          }
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((nx)((Iterator)localObject2).next()).a();
            if (paramInt2 < arrayOfByte.length) {
              paramnn.a(arrayOfByte[paramInt2], 8);
            }
          }
          paramInt2 += 1;
        }
        while (paramInt3 < i)
        {
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((nx)((Iterator)localObject2).next()).b();
            if (paramInt3 < arrayOfByte.length) {
              paramnn.a(arrayOfByte[paramInt3], 8);
            }
          }
          paramInt3 += 1;
        }
        if (paramInt1 == paramnn.b()) {
          return paramnn;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Interleaving error: ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" and ");
        ((StringBuilder)localObject1).append(paramnn.b());
        ((StringBuilder)localObject1).append(" differ.");
        throw new nl(((StringBuilder)localObject1).toString());
      }
      throw new nl("Data bytes does not match offset");
    }
    throw new nl("Number of bits and data bytes does not match");
  }
  
  private static nv a(String paramString1, String paramString2)
  {
    if (("Shift_JIS".equals(paramString2)) && (a(paramString1))) {
      return nv.g;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57))
      {
        k = 1;
      }
      else
      {
        if (a(m) == -1) {
          break label80;
        }
        j = 1;
      }
      i += 1;
      continue;
      label80:
      return nv.e;
    }
    if (j != 0) {
      return nv.c;
    }
    if (k != 0) {
      return nv.b;
    }
    return nv.e;
  }
  
  private static nw a(int paramInt, nu paramnu)
    throws nl
  {
    int i = 1;
    while (i <= 40)
    {
      nw localnw = nw.a(i);
      if (a(paramInt, localnw, paramnu)) {
        return localnw;
      }
      i += 1;
    }
    throw new nl("Data too big");
  }
  
  private static nw a(nu paramnu, nv paramnv, nn paramnn1, nn paramnn2)
    throws nl
  {
    return a(a(paramnv, paramnn1, paramnn2, a(a(paramnv, paramnn1, paramnn2, nw.a(1)), paramnu)), paramnu);
  }
  
  public static oc a(String paramString, nu paramnu, Map<ni, ?> paramMap)
    throws nl
  {
    Object localObject1 = "ISO-8859-1";
    int j = 1;
    if ((paramMap != null) && (paramMap.containsKey(ni.b))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject1 = paramMap.get(ni.b).toString();
    }
    Object localObject2 = a(paramString, (String)localObject1);
    nn localnn = new nn();
    if ((localObject2 == nv.e) && (i != 0))
    {
      localObject3 = np.a((String)localObject1);
      if (localObject3 != null) {
        a((np)localObject3, localnn);
      }
    }
    if ((paramMap != null) && (paramMap.containsKey(ni.l))) {
      i = j;
    } else {
      i = 0;
    }
    if ((i != 0) && (Boolean.valueOf(paramMap.get(ni.l).toString()).booleanValue())) {
      a(nv.h, localnn);
    }
    a((nv)localObject2, localnn);
    Object localObject3 = new nn();
    a(paramString, (nv)localObject2, (nn)localObject3, (String)localObject1);
    if ((paramMap != null) && (paramMap.containsKey(ni.k)))
    {
      paramMap = nw.a(Integer.parseInt(paramMap.get(ni.k).toString()));
      if (!a(a((nv)localObject2, localnn, (nn)localObject3, paramMap), paramMap, paramnu)) {
        throw new nl("Data too big for requested version");
      }
    }
    else
    {
      paramMap = a(paramnu, (nv)localObject2, localnn, (nn)localObject3);
    }
    localObject1 = new nn();
    ((nn)localObject1).a(localnn);
    if (localObject2 == nv.e) {
      i = ((nn)localObject3).b();
    } else {
      i = paramString.length();
    }
    a(i, paramMap, (nv)localObject2, (nn)localObject1);
    ((nn)localObject1).a((nn)localObject3);
    paramString = paramMap.a(paramnu);
    int i = paramMap.b() - paramString.c();
    a(i, (nn)localObject1);
    paramString = a((nn)localObject1, paramMap.b(), i, paramString.b());
    localObject1 = new oc();
    ((oc)localObject1).a(paramnu);
    ((oc)localObject1).a((nv)localObject2);
    ((oc)localObject1).a(paramMap);
    i = paramMap.c();
    localObject2 = new ny(i, i);
    i = a(paramString, paramnu, paramMap, (ny)localObject2);
    ((oc)localObject1).a(i);
    ob.a(paramString, paramnu, paramMap, i, (ny)localObject2);
    ((oc)localObject1).a((ny)localObject2);
    return localObject1;
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws nl
  {
    if (paramInt4 < paramInt3)
    {
      int i = paramInt1 % paramInt3;
      int j = paramInt3 - i;
      int k = paramInt1 / paramInt3;
      paramInt2 /= paramInt3;
      int m = paramInt2 + 1;
      int n = k - paramInt2;
      k = k + 1 - m;
      if (n == k)
      {
        if (paramInt3 == j + i)
        {
          if (paramInt1 == (paramInt2 + n) * j + (m + k) * i)
          {
            if (paramInt4 < j)
            {
              paramArrayOfInt1[0] = paramInt2;
              paramArrayOfInt2[0] = n;
              return;
            }
            paramArrayOfInt1[0] = m;
            paramArrayOfInt2[0] = k;
            return;
          }
          throw new nl("Total bytes mismatch");
        }
        throw new nl("RS blocks mismatch");
      }
      throw new nl("EC bytes mismatch");
    }
    throw new nl("Block ID too large");
  }
  
  static void a(int paramInt, nn paramnn)
    throws nl
  {
    int k = paramInt * 8;
    if (paramnn.a() <= k)
    {
      int j = 0;
      int i = 0;
      while ((i < 4) && (paramnn.a() < k))
      {
        paramnn.a(false);
        i += 1;
      }
      i = paramnn.a() & 0x7;
      if (i > 0) {
        while (i < 8)
        {
          paramnn.a(false);
          i += 1;
        }
      }
      int m = paramnn.b();
      i = j;
      while (i < paramInt - m)
      {
        if ((i & 0x1) == 0) {
          j = 236;
        } else {
          j = 17;
        }
        paramnn.a(j, 8);
        i += 1;
      }
      if (paramnn.a() == k) {
        return;
      }
      throw new nl("Bits size does not equal capacity");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data bits cannot fit in the QR Code");
    localStringBuilder.append(paramnn.a());
    localStringBuilder.append(" > ");
    localStringBuilder.append(k);
    throw new nl(localStringBuilder.toString());
  }
  
  static void a(int paramInt, nw paramnw, nv paramnv, nn paramnn)
    throws nl
  {
    int i = paramnv.a(paramnw);
    int j = 1 << i;
    if (paramInt < j)
    {
      paramnn.a(paramInt, i);
      return;
    }
    paramnw = new StringBuilder();
    paramnw.append(paramInt);
    paramnw.append(" is bigger than ");
    paramnw.append(j - 1);
    throw new nl(paramnw.toString());
  }
  
  static void a(CharSequence paramCharSequence, nn paramnn)
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = paramCharSequence.charAt(i) - '0';
      int j = i + 2;
      if (j < k)
      {
        paramnn.a(m * 100 + (paramCharSequence.charAt(i + 1) - '0') * 10 + (paramCharSequence.charAt(j) - '0'), 10);
        i += 3;
      }
      else
      {
        i += 1;
        if (i < k)
        {
          paramnn.a(m * 10 + (paramCharSequence.charAt(i) - '0'), 7);
          i = j;
        }
        else
        {
          paramnn.a(m, 4);
        }
      }
    }
  }
  
  static void a(String paramString, nn paramnn)
    throws nl
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int k = paramString.length;
      int j = 0;
      while (j < k)
      {
        int i = (paramString[j] & 0xFF) << 8 | paramString[(j + 1)] & 0xFF;
        if ((i >= 33088) && (i <= 40956)) {
          i -= 33088;
        } else if ((i >= 57408) && (i <= 60351)) {
          i -= 49472;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          paramnn.a((i >> 8) * 192 + (i & 0xFF), 13);
          j += 2;
        }
        else
        {
          throw new nl("Invalid byte sequence");
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new nl(paramString);
    }
  }
  
  static void a(String paramString1, nn paramnn, String paramString2)
    throws nl
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramnn.a(paramString1[i], 8);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new nl(paramString1);
    }
  }
  
  static void a(String paramString1, nv paramnv, nn paramnn, String paramString2)
    throws nl
  {
    switch (1.a[paramnv.ordinal()])
    {
    default: 
      paramString1 = new StringBuilder();
      paramString1.append("Invalid mode: ");
      paramString1.append(paramnv);
      throw new nl(paramString1.toString());
    case 4: 
      a(paramString1, paramnn);
      return;
    case 3: 
      a(paramString1, paramnn, paramString2);
      return;
    case 2: 
      b(paramString1, paramnn);
      return;
    }
    a(paramString1, paramnn);
  }
  
  private static void a(np paramnp, nn paramnn)
  {
    paramnn.a(nv.f.a(), 4);
    paramnn.a(paramnp.a(), 8);
  }
  
  static void a(nv paramnv, nn paramnn)
  {
    paramnn.a(paramnv.a(), 4);
  }
  
  private static boolean a(int paramInt, nw paramnw, nu paramnu)
  {
    return paramnw.b() - paramnw.a(paramnu).c() >= (paramInt + 7) / 8;
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int j = paramString.length;
      if (j % 2 != 0) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        int k = paramString[i] & 0xFF;
        if ((k < 129) || (k > 159))
        {
          if (k < 224) {
            break label70;
          }
          if (k > 235) {
            return false;
          }
        }
        i += 2;
        continue;
        label70:
        return false;
      }
      return true;
    }
    catch (UnsupportedEncodingException paramString) {}
    return false;
  }
  
  static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k + paramInt];
    int j = 0;
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    new ns(nq.e).a(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  static void b(CharSequence paramCharSequence, nn paramnn)
    throws nl
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = a(paramCharSequence.charAt(i));
      if (m != -1)
      {
        int j = i + 1;
        if (j < k)
        {
          j = a(paramCharSequence.charAt(j));
          if (j != -1)
          {
            paramnn.a(m * 45 + j, 11);
            i += 2;
          }
          else
          {
            throw new nl();
          }
        }
        else
        {
          paramnn.a(m, 6);
          i = j;
        }
      }
      else
      {
        throw new nl();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.nz
 * JD-Core Version:    0.7.0.1
 */