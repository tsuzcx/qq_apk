package midas.x;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class qe
{
  public static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  public static int a(int paramInt)
  {
    int[] arrayOfInt = a;
    if (paramInt < arrayOfInt.length) {
      return arrayOfInt[paramInt];
    }
    return -1;
  }
  
  public static int a(ee paramee, le paramle, ne paramne, pe parampe)
    throws ce
  {
    int j = 2147483647;
    int k = -1;
    int i = 0;
    while (i < 8)
    {
      se.a(paramee, paramle, paramne, i, parampe);
      int n = a(parampe);
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
  
  public static int a(me paramme, ee paramee1, ee paramee2, ne paramne)
  {
    return paramee1.a() + paramme.a(paramne) + paramee2.a();
  }
  
  public static int a(pe parampe)
  {
    return re.a(parampe) + re.b(parampe) + re.c(parampe) + re.d(parampe);
  }
  
  public static ee a(ee paramee, int paramInt1, int paramInt2, int paramInt3)
    throws ce
  {
    if (paramee.b() == paramInt2)
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
        paramee.a(m * 8, arrayOfByte, 0, i1);
        localObject3 = a(arrayOfByte, localObject3[0]);
        ((Collection)localObject1).add(new oe(arrayOfByte, (byte[])localObject3));
        j = Math.max(j, i1);
        i = Math.max(i, localObject3.length);
        m += localObject2[0];
        k += 1;
      }
      if (paramInt2 == m)
      {
        paramee = new ee();
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
            arrayOfByte = ((oe)((Iterator)localObject2).next()).a();
            if (paramInt2 < arrayOfByte.length) {
              paramee.a(arrayOfByte[paramInt2], 8);
            }
          }
          paramInt2 += 1;
        }
        while (paramInt3 < i)
        {
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((oe)((Iterator)localObject2).next()).b();
            if (paramInt3 < arrayOfByte.length) {
              paramee.a(arrayOfByte[paramInt3], 8);
            }
          }
          paramInt3 += 1;
        }
        if (paramInt1 == paramee.b()) {
          return paramee;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Interleaving error: ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" and ");
        ((StringBuilder)localObject1).append(paramee.b());
        ((StringBuilder)localObject1).append(" differ.");
        throw new ce(((StringBuilder)localObject1).toString());
      }
      throw new ce("Data bytes does not match offset");
    }
    paramee = new ce("Number of bits and data bytes does not match");
    for (;;)
    {
      throw paramee;
    }
  }
  
  public static me a(String paramString1, String paramString2)
  {
    if (("Shift_JIS".equals(paramString2)) && (a(paramString1))) {
      return me.i;
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
      return me.g;
    }
    if (j != 0) {
      return me.e;
    }
    if (k != 0) {
      return me.d;
    }
    return me.g;
  }
  
  public static ne a(int paramInt, le paramle)
    throws ce
  {
    int i = 1;
    while (i <= 40)
    {
      ne localne = ne.a(i);
      if (a(paramInt, localne, paramle)) {
        return localne;
      }
      i += 1;
    }
    paramle = new ce("Data too big");
    for (;;)
    {
      throw paramle;
    }
  }
  
  public static ne a(le paramle, me paramme, ee paramee1, ee paramee2)
    throws ce
  {
    return a(a(paramme, paramee1, paramee2, a(a(paramme, paramee1, paramee2, ne.a(1)), paramle)), paramle);
  }
  
  public static te a(String paramString, le paramle, Map<zd, ?> paramMap)
    throws ce
  {
    int j = 1;
    if ((paramMap != null) && (paramMap.containsKey(zd.b))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject1 = paramMap.get(zd.b).toString();
    } else {
      localObject1 = "ISO-8859-1";
    }
    Object localObject2 = a(paramString, (String)localObject1);
    ee localee = new ee();
    if ((localObject2 == me.g) && (i != 0))
    {
      localObject3 = ge.a((String)localObject1);
      if (localObject3 != null) {
        a((ge)localObject3, localee);
      }
    }
    if ((paramMap != null) && (paramMap.containsKey(zd.l))) {
      i = j;
    } else {
      i = 0;
    }
    if ((i != 0) && (Boolean.valueOf(paramMap.get(zd.l).toString()).booleanValue())) {
      a(me.j, localee);
    }
    a((me)localObject2, localee);
    Object localObject3 = new ee();
    a(paramString, (me)localObject2, (ee)localObject3, (String)localObject1);
    if ((paramMap != null) && (paramMap.containsKey(zd.k)))
    {
      paramMap = ne.a(Integer.parseInt(paramMap.get(zd.k).toString()));
      if (!a(a((me)localObject2, localee, (ee)localObject3, paramMap), paramMap, paramle)) {
        throw new ce("Data too big for requested version");
      }
    }
    else
    {
      paramMap = a(paramle, (me)localObject2, localee, (ee)localObject3);
    }
    Object localObject1 = new ee();
    ((ee)localObject1).a(localee);
    if (localObject2 == me.g) {
      i = ((ee)localObject3).b();
    } else {
      i = paramString.length();
    }
    a(i, paramMap, (me)localObject2, (ee)localObject1);
    ((ee)localObject1).a((ee)localObject3);
    paramString = paramMap.a(paramle);
    int i = paramMap.b() - paramString.d();
    a(i, (ee)localObject1);
    paramString = a((ee)localObject1, paramMap.b(), i, paramString.c());
    localObject1 = new te();
    ((te)localObject1).a(paramle);
    ((te)localObject1).a((me)localObject2);
    ((te)localObject1).a(paramMap);
    i = paramMap.a();
    localObject2 = new pe(i, i);
    i = a(paramString, paramle, paramMap, (pe)localObject2);
    ((te)localObject1).a(i);
    se.a(paramString, paramle, paramMap, i, (pe)localObject2);
    ((te)localObject1).a((pe)localObject2);
    return localObject1;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws ce
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
          throw new ce("Total bytes mismatch");
        }
        throw new ce("RS blocks mismatch");
      }
      throw new ce("EC bytes mismatch");
    }
    throw new ce("Block ID too large");
  }
  
  public static void a(int paramInt, ee paramee)
    throws ce
  {
    int k = paramInt * 8;
    if (paramee.a() <= k)
    {
      int j = 0;
      int i = 0;
      while ((i < 4) && (paramee.a() < k))
      {
        paramee.a(false);
        i += 1;
      }
      i = paramee.a() & 0x7;
      if (i > 0) {
        while (i < 8)
        {
          paramee.a(false);
          i += 1;
        }
      }
      int m = paramee.b();
      i = j;
      while (i < paramInt - m)
      {
        if ((i & 0x1) == 0) {
          j = 236;
        } else {
          j = 17;
        }
        paramee.a(j, 8);
        i += 1;
      }
      if (paramee.a() == k) {
        return;
      }
      throw new ce("Bits size does not equal capacity");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data bits cannot fit in the QR Code");
    localStringBuilder.append(paramee.a());
    localStringBuilder.append(" > ");
    localStringBuilder.append(k);
    paramee = new ce(localStringBuilder.toString());
    for (;;)
    {
      throw paramee;
    }
  }
  
  public static void a(int paramInt, ne paramne, me paramme, ee paramee)
    throws ce
  {
    int i = paramme.a(paramne);
    int j = 1 << i;
    if (paramInt < j)
    {
      paramee.a(paramInt, i);
      return;
    }
    paramne = new StringBuilder();
    paramne.append(paramInt);
    paramne.append(" is bigger than ");
    paramne.append(j - 1);
    throw new ce(paramne.toString());
  }
  
  public static void a(CharSequence paramCharSequence, ee paramee)
    throws ce
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
            paramee.a(m * 45 + j, 11);
            i += 2;
          }
          else
          {
            throw new ce();
          }
        }
        else
        {
          paramee.a(m, 6);
          i = j;
        }
      }
      else
      {
        throw new ce();
      }
    }
  }
  
  public static void a(String paramString, ee paramee)
    throws ce
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int k = paramString.length;
      int i = 0;
      while (i < k)
      {
        int m = (paramString[i] & 0xFF) << 8 | paramString[(i + 1)] & 0xFF;
        int j = 33088;
        if ((m >= 33088) && (m <= 40956)) {}
        for (;;)
        {
          j = m - j;
          break label94;
          if ((m < 57408) || (m > 60351)) {
            break;
          }
          j = 49472;
        }
        j = -1;
        label94:
        if (j != -1)
        {
          paramee.a((j >> 8) * 192 + (j & 0xFF), 13);
          i += 2;
        }
        else
        {
          throw new ce("Invalid byte sequence");
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new ce(paramString);
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void a(String paramString1, ee paramee, String paramString2)
    throws ce
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramee.a(paramString1[i], 8);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1 = new ce(paramString1);
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public static void a(String paramString1, me paramme, ee paramee, String paramString2)
    throws ce
  {
    int i = a.a[paramme.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            a(paramString1, paramee);
            return;
          }
          paramString1 = new StringBuilder();
          paramString1.append("Invalid mode: ");
          paramString1.append(paramme);
          throw new ce(paramString1.toString());
        }
        a(paramString1, paramee, paramString2);
        return;
      }
      a(paramString1, paramee);
      return;
    }
    b(paramString1, paramee);
  }
  
  public static void a(ge paramge, ee paramee)
  {
    paramee.a(me.h.a(), 4);
    paramee.a(paramge.a(), 8);
  }
  
  public static void a(me paramme, ee paramee)
  {
    paramee.a(paramme.a(), 4);
  }
  
  public static boolean a(int paramInt, ne paramne, le paramle)
  {
    return paramne.b() - paramne.a(paramle).d() >= (paramInt + 7) / 8;
  }
  
  public static boolean a(String paramString)
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
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
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
    new je(he.h).a(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  public static void b(CharSequence paramCharSequence, ee paramee)
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = paramCharSequence.charAt(i) - '0';
      int j = i + 2;
      if (j < k)
      {
        paramee.a(m * 100 + (paramCharSequence.charAt(i + 1) - '0') * 10 + (paramCharSequence.charAt(j) - '0'), 10);
        i += 3;
      }
      else
      {
        i += 1;
        if (i < k)
        {
          paramee.a(m * 10 + (paramCharSequence.charAt(i) - '0'), 7);
          i = j;
        }
        else
        {
          paramee.a(m, 4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.qe
 * JD-Core Version:    0.7.0.1
 */