package midas.x;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class mo
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  static int a(int paramInt)
  {
    if (paramInt < a.length) {
      return a[paramInt];
    }
    return -1;
  }
  
  private static int a(mc parammc, mj parammj, ml paramml, mn parammn)
    throws ma
  {
    int j = 2147483647;
    int k = -1;
    int i = 0;
    while (i < 8)
    {
      mq.a(parammc, parammj, paramml, i, parammn);
      int n = a(parammn);
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
  
  private static int a(mk parammk, mc parammc1, mc parammc2, ml paramml)
  {
    return parammc1.a() + parammk.a(paramml) + parammc2.a();
  }
  
  private static int a(mn parammn)
  {
    return mp.a(parammn) + mp.b(parammn) + mp.c(parammn) + mp.d(parammn);
  }
  
  static mc a(mc parammc, int paramInt1, int paramInt2, int paramInt3)
    throws ma
  {
    if (parammc.b() == paramInt2)
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
        parammc.a(m * 8, arrayOfByte, 0, i1);
        localObject3 = a(arrayOfByte, localObject3[0]);
        ((Collection)localObject1).add(new mm(arrayOfByte, (byte[])localObject3));
        j = Math.max(j, i1);
        i = Math.max(i, localObject3.length);
        m += localObject2[0];
        k += 1;
      }
      if (paramInt2 == m)
      {
        parammc = new mc();
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
            arrayOfByte = ((mm)((Iterator)localObject2).next()).a();
            if (paramInt2 < arrayOfByte.length) {
              parammc.a(arrayOfByte[paramInt2], 8);
            }
          }
          paramInt2 += 1;
        }
        while (paramInt3 < i)
        {
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((mm)((Iterator)localObject2).next()).b();
            if (paramInt3 < arrayOfByte.length) {
              parammc.a(arrayOfByte[paramInt3], 8);
            }
          }
          paramInt3 += 1;
        }
        if (paramInt1 == parammc.b()) {
          return parammc;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Interleaving error: ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" and ");
        ((StringBuilder)localObject1).append(parammc.b());
        ((StringBuilder)localObject1).append(" differ.");
        throw new ma(((StringBuilder)localObject1).toString());
      }
      throw new ma("Data bytes does not match offset");
    }
    throw new ma("Number of bits and data bytes does not match");
  }
  
  private static mk a(String paramString1, String paramString2)
  {
    if (("Shift_JIS".equals(paramString2)) && (a(paramString1))) {
      return mk.g;
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
      return mk.e;
    }
    if (j != 0) {
      return mk.c;
    }
    if (k != 0) {
      return mk.b;
    }
    return mk.e;
  }
  
  private static ml a(int paramInt, mj parammj)
    throws ma
  {
    int i = 1;
    while (i <= 40)
    {
      ml localml = ml.a(i);
      if (a(paramInt, localml, parammj)) {
        return localml;
      }
      i += 1;
    }
    throw new ma("Data too big");
  }
  
  private static ml a(mj parammj, mk parammk, mc parammc1, mc parammc2)
    throws ma
  {
    return a(a(parammk, parammc1, parammc2, a(a(parammk, parammc1, parammc2, ml.a(1)), parammj)), parammj);
  }
  
  public static mr a(String paramString, mj parammj, Map<lx, ?> paramMap)
    throws ma
  {
    Object localObject1 = "ISO-8859-1";
    int j = 1;
    if ((paramMap != null) && (paramMap.containsKey(lx.b))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject1 = paramMap.get(lx.b).toString();
    }
    Object localObject2 = a(paramString, (String)localObject1);
    mc localmc = new mc();
    if ((localObject2 == mk.e) && (i != 0))
    {
      localObject3 = me.a((String)localObject1);
      if (localObject3 != null) {
        a((me)localObject3, localmc);
      }
    }
    if ((paramMap != null) && (paramMap.containsKey(lx.l))) {
      i = j;
    } else {
      i = 0;
    }
    if ((i != 0) && (Boolean.valueOf(paramMap.get(lx.l).toString()).booleanValue())) {
      a(mk.h, localmc);
    }
    a((mk)localObject2, localmc);
    Object localObject3 = new mc();
    a(paramString, (mk)localObject2, (mc)localObject3, (String)localObject1);
    if ((paramMap != null) && (paramMap.containsKey(lx.k)))
    {
      paramMap = ml.a(Integer.parseInt(paramMap.get(lx.k).toString()));
      if (!a(a((mk)localObject2, localmc, (mc)localObject3, paramMap), paramMap, parammj)) {
        throw new ma("Data too big for requested version");
      }
    }
    else
    {
      paramMap = a(parammj, (mk)localObject2, localmc, (mc)localObject3);
    }
    localObject1 = new mc();
    ((mc)localObject1).a(localmc);
    if (localObject2 == mk.e) {
      i = ((mc)localObject3).b();
    } else {
      i = paramString.length();
    }
    a(i, paramMap, (mk)localObject2, (mc)localObject1);
    ((mc)localObject1).a((mc)localObject3);
    paramString = paramMap.a(parammj);
    int i = paramMap.b() - paramString.c();
    a(i, (mc)localObject1);
    paramString = a((mc)localObject1, paramMap.b(), i, paramString.b());
    localObject1 = new mr();
    ((mr)localObject1).a(parammj);
    ((mr)localObject1).a((mk)localObject2);
    ((mr)localObject1).a(paramMap);
    i = paramMap.c();
    localObject2 = new mn(i, i);
    i = a(paramString, parammj, paramMap, (mn)localObject2);
    ((mr)localObject1).a(i);
    mq.a(paramString, parammj, paramMap, i, (mn)localObject2);
    ((mr)localObject1).a((mn)localObject2);
    return localObject1;
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws ma
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
          throw new ma("Total bytes mismatch");
        }
        throw new ma("RS blocks mismatch");
      }
      throw new ma("EC bytes mismatch");
    }
    throw new ma("Block ID too large");
  }
  
  static void a(int paramInt, mc parammc)
    throws ma
  {
    int k = paramInt * 8;
    if (parammc.a() <= k)
    {
      int j = 0;
      int i = 0;
      while ((i < 4) && (parammc.a() < k))
      {
        parammc.a(false);
        i += 1;
      }
      i = parammc.a() & 0x7;
      if (i > 0) {
        while (i < 8)
        {
          parammc.a(false);
          i += 1;
        }
      }
      int m = parammc.b();
      i = j;
      while (i < paramInt - m)
      {
        if ((i & 0x1) == 0) {
          j = 236;
        } else {
          j = 17;
        }
        parammc.a(j, 8);
        i += 1;
      }
      if (parammc.a() == k) {
        return;
      }
      throw new ma("Bits size does not equal capacity");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data bits cannot fit in the QR Code");
    localStringBuilder.append(parammc.a());
    localStringBuilder.append(" > ");
    localStringBuilder.append(k);
    throw new ma(localStringBuilder.toString());
  }
  
  static void a(int paramInt, ml paramml, mk parammk, mc parammc)
    throws ma
  {
    int i = parammk.a(paramml);
    int j = 1 << i;
    if (paramInt < j)
    {
      parammc.a(paramInt, i);
      return;
    }
    paramml = new StringBuilder();
    paramml.append(paramInt);
    paramml.append(" is bigger than ");
    paramml.append(j - 1);
    throw new ma(paramml.toString());
  }
  
  static void a(CharSequence paramCharSequence, mc parammc)
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = paramCharSequence.charAt(i) - '0';
      int j = i + 2;
      if (j < k)
      {
        parammc.a(m * 100 + (paramCharSequence.charAt(i + 1) - '0') * 10 + (paramCharSequence.charAt(j) - '0'), 10);
        i += 3;
      }
      else
      {
        i += 1;
        if (i < k)
        {
          parammc.a(m * 10 + (paramCharSequence.charAt(i) - '0'), 7);
          i = j;
        }
        else
        {
          parammc.a(m, 4);
        }
      }
    }
  }
  
  static void a(String paramString, mc parammc)
    throws ma
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
          parammc.a((i >> 8) * 192 + (i & 0xFF), 13);
          j += 2;
        }
        else
        {
          throw new ma("Invalid byte sequence");
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new ma(paramString);
    }
  }
  
  static void a(String paramString1, mc parammc, String paramString2)
    throws ma
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        parammc.a(paramString1[i], 8);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new ma(paramString1);
    }
  }
  
  static void a(String paramString1, mk parammk, mc parammc, String paramString2)
    throws ma
  {
    switch (1.a[parammk.ordinal()])
    {
    default: 
      paramString1 = new StringBuilder();
      paramString1.append("Invalid mode: ");
      paramString1.append(parammk);
      throw new ma(paramString1.toString());
    case 4: 
      a(paramString1, parammc);
      return;
    case 3: 
      a(paramString1, parammc, paramString2);
      return;
    case 2: 
      b(paramString1, parammc);
      return;
    }
    a(paramString1, parammc);
  }
  
  private static void a(me paramme, mc parammc)
  {
    parammc.a(mk.f.a(), 4);
    parammc.a(paramme.a(), 8);
  }
  
  static void a(mk parammk, mc parammc)
  {
    parammc.a(parammk.a(), 4);
  }
  
  private static boolean a(int paramInt, ml paramml, mj parammj)
  {
    return paramml.b() - paramml.a(parammj).c() >= (paramInt + 7) / 8;
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
    new mh(mf.e).a(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  static void b(CharSequence paramCharSequence, mc parammc)
    throws ma
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
            parammc.a(m * 45 + j, 11);
            i += 2;
          }
          else
          {
            throw new ma();
          }
        }
        else
        {
          parammc.a(m, 6);
          i = j;
        }
      }
      else
      {
        throw new ma();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mo
 * JD-Core Version:    0.7.0.1
 */