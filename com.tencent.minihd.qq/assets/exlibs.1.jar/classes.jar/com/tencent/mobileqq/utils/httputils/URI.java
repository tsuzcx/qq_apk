package com.tencent.mobileqq.utils.httputils;

public class URI
{
  public static final int a = 0;
  private static String a = "3g.qq.com";
  public static final short a = 0;
  public static final int b = 1;
  public static final short b = 1;
  public static final short c = 2;
  public static final short d = 3;
  public static final short e = 4;
  public static final short f = 5;
  public static final short g = 6;
  public static final short h = 7;
  
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (paramInt1 < 128)
    {
      paramArrayOfByte[(0 + paramInt2)] = ((byte)paramInt1);
      return 1;
    }
    if (paramInt1 < 2048)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 6 & 0x1F | 0xC0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 2;
    }
    if (paramInt1 < 65536)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 12 & 0xF | 0xE0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 3;
    }
    if (paramInt1 < 2097152)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 18 & 0x7 | 0xF0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 12 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 4;
    }
    return 0;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = b(paramString);
    int i = paramString.indexOf(str);
    i = str.length() + i;
    paramString = paramString.replace('\\', '/');
    while ((i < paramString.length()) && (paramString.charAt(i) != '/')) {
      i += 1;
    }
    int k = paramString.indexOf('?', i);
    int j = k;
    if (k < 0) {
      j = paramString.length();
    }
    try
    {
      str = b(paramString.substring(i, j), false);
      str = paramString.substring(0, i) + str + paramString.substring(j);
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String a(String paramString1, short paramShort, String paramString2)
  {
    String str1;
    short s1;
    label148:
    label172:
    label184:
    short s2;
    switch (paramShort)
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      try
      {
        return c(paramString1);
      }
      catch (Exception paramString1)
      {
        boolean bool;
        label194:
        int i;
        label214:
        return a;
      }
      bool = paramString1.startsWith("#");
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        str1 = paramString1.trim();
        if ((str1 == null) || (str1.length() <= 0)) {
          return c(paramString1);
        }
      }
      else
      {
        return c(paramString2);
      }
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        paramString2 = paramString2.trim();
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          return c(paramString1);
        }
        s1 = paramString2.indexOf('?');
        paramString1 = paramString2;
        if (s1 <= 0) {
          break label611;
        }
        paramString1 = paramString2.substring(0, s1);
        break label611;
        if (paramShort != 0) {
          break label574;
        }
        if (paramString1.substring(0, 4).toLowerCase().compareTo("http") != 0) {
          break label614;
        }
        s1 = 8;
        if (s1 <= 0) {
          break label307;
        }
        paramShort = paramString1.indexOf('/', s1);
        if (paramShort > 0) {
          break label595;
        }
        s2 = paramString1.length();
        i = paramString1.lastIndexOf('/');
        if (i >= s1) {
          break label592;
        }
        i = paramString1.length();
        if ((str1.length() <= 0) || (str1.charAt(0) != '/')) {
          break label318;
        }
        paramString1 = paramString1.substring(0, s2);
      }
      break;
    }
    for (;;)
    {
      if ((str1.charAt(0) != '/') && (paramString1.charAt(paramString1.length() - 1) != '/') && (!bool))
      {
        return c(paramString1 + '/' + str1);
        paramString1 = a;
        break label148;
        label307:
        paramShort = paramString1.indexOf('/', 0);
        break label184;
        label318:
        if ((str1.length() <= 2) || (str1.substring(0, 2).compareTo("./") != 0)) {
          break label619;
        }
        paramString1 = paramString1.substring(0, i);
        str1 = str1.substring(2, str1.length());
        continue;
      }
      for (;;)
      {
        short s3;
        if (paramShort == 0)
        {
          s3 = s1 + 1;
          if (paramString2.length() > 3)
          {
            short s4 = paramString2.substring(0, 3).compareTo("../");
            paramShort = s4;
            s1 = s3;
            if (s4 != 0) {
              continue;
            }
            paramString2 = paramString2.substring(3, paramString2.length());
            paramShort = s4;
            s1 = s3;
          }
        }
        else
        {
          if (bool) {
            break label637;
          }
          String str2 = paramString1.substring(0, i);
          paramShort = s1;
          for (;;)
          {
            s1 = paramShort - 1;
            str1 = paramString2;
            paramString1 = str2;
            if (paramShort <= 0) {
              break;
            }
            paramShort = str2.lastIndexOf('/');
            if ((paramShort > 0) && (s2 <= paramShort))
            {
              str2 = str2.substring(0, paramShort);
              paramShort = s1;
              continue;
              if ((str1.charAt(0) == '/') && (paramString1.charAt(paramString1.length() - 1) == '/') && (!bool)) {
                return c(paramString1 + str1.substring(1, str1.length()));
              }
              return c(paramString1 + str1);
              label574:
              paramString1 = c(str1);
              return paramString1;
            }
            else
            {
              paramShort = s1;
            }
          }
          label592:
          break label214;
          label595:
          s2 = paramShort;
          break label194;
          paramShort = 1;
          break;
          paramShort = 0;
          break;
          label611:
          break label148;
          label614:
          s1 = 0;
          break label172;
          label619:
          paramString2 = str1;
          paramShort = 0;
          s1 = -1;
          continue;
        }
        paramShort = -1;
        s1 = s3;
      }
      label637:
      str1 = paramString2;
    }
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    byte[] arrayOfByte;
    int j;
    int i;
    if (paramBoolean)
    {
      paramString = PkgTools.d(paramString);
      arrayOfByte = new byte[paramString.length * 3 + 1];
      j = 0;
      i = 0;
      label37:
      if (j >= paramString.length) {
        break label314;
      }
      if (((paramString[j] < 97) || (paramString[j] > 122)) && ((paramString[j] < 65) || (paramString[j] > 90)) && ((paramString[j] < 48) || (paramString[j] > 57)) && (paramString[j] != 46) && (paramString[j] != 45) && (paramString[j] != 42) && (paramString[j] != 95)) {
        break label149;
      }
      arrayOfByte[i] = paramString[j];
      i += 1;
    }
    for (;;)
    {
      j += 1;
      break label37;
      paramString = paramString.getBytes();
      break;
      label149:
      int k;
      int m;
      if (paramString[j] == 32)
      {
        k = i + 1;
        arrayOfByte[i] = 37;
        m = k + 1;
        arrayOfByte[k] = 50;
        i = m + 1;
        arrayOfByte[m] = 48;
      }
      else
      {
        k = i + 1;
        arrayOfByte[i] = 37;
        m = paramString[j] >> 4 & 0xF;
        if (m < 10)
        {
          i = k + 1;
          arrayOfByte[k] = ((byte)(m + 48));
        }
        for (;;)
        {
          k = paramString[j] & 0xF;
          if (k >= 10) {
            break label294;
          }
          arrayOfByte[i] = ((byte)(k + 48));
          i += 1;
          break;
          i = k + 1;
          arrayOfByte[k] = ((byte)(m + 65 - 10));
        }
        label294:
        arrayOfByte[i] = ((byte)(k + 65 - 10));
        i += 1;
      }
    }
    label314:
    return new String(arrayOfByte, 0, i);
  }
  
  public static short a(String paramString)
  {
    short s = 5;
    if ((paramString == null) || (paramString.length() < 3)) {
      s = 0;
    }
    do
    {
      return s;
      paramString = PkgTools.b(paramString);
      if ((paramString.length() > 5) && (PkgTools.a(paramString.substring(0, 5), "http:"))) {
        return 1;
      }
    } while ((paramString.length() > 6) && (PkgTools.a(paramString.substring(0, 6), "https:")));
    if ((paramString.length() > 5) && (PkgTools.a(paramString.substring(0, 5), "wtai:"))) {
      return 2;
    }
    if ((paramString.length() > 7) && (PkgTools.a(paramString.substring(0, 7), "mailto:"))) {
      return 3;
    }
    if ((paramString.length() > 4) && (PkgTools.a(paramString.substring(0, 4), "sms:"))) {
      return 6;
    }
    if ((paramString.length() > 11) && (PkgTools.a(paramString.substring(0, 11), "javascript:"))) {
      return 6;
    }
    if ((paramString.length() > 4) && (PkgTools.a(paramString.substring(0, 4), "ext:"))) {
      return 7;
    }
    return 0;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public static final boolean a(char paramChar)
  {
    return (Character.isDigit(paramChar)) || (Character.isLowerCase(paramChar)) || (Character.isUpperCase(paramChar)) || (paramChar == '-') || (paramChar == '_') || (paramChar == '.') || (paramChar == '!') || (paramChar == '~') || (paramChar == '+');
  }
  
  public static boolean a(String paramString)
  {
    paramString = PkgTools.a(b(paramString), ".");
    if (paramString.length != 4) {}
    for (;;)
    {
      return false;
      int i = 0;
      if (i < 4) {}
      try
      {
        int j = Integer.parseInt(paramString[i]);
        if ((j >= 0) && (j < 255) && ((j != 0) || ((i != 0) && (i != 3)))) {
          i += 1;
        }
      }
      catch (Exception paramString) {}
    }
    return true;
    return false;
  }
  
  public static String b(String paramString)
  {
    int i = paramString.indexOf("://");
    int m;
    int j;
    if (i > 0)
    {
      i += 3;
      m = paramString.length();
      j = i;
      label23:
      if (j >= paramString.length()) {
        break label84;
      }
      int n = paramString.charAt(j);
      k = j;
      if (n != 58)
      {
        k = j;
        if (n != 47) {
          if (n != 63) {
            break label77;
          }
        }
      }
    }
    label77:
    label84:
    for (int k = j;; k = m)
    {
      return paramString.substring(i, k);
      i = 0;
      break;
      j += 1;
      break label23;
    }
  }
  
  public static String b(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = "";
    }
    byte[] arrayOfByte;
    int j;
    int k;
    int m;
    for (;;)
    {
      return paramString;
      if (paramBoolean) {}
      for (arrayOfByte = PkgTools.d(paramString); arrayOfByte != null; arrayOfByte = paramString.getBytes())
      {
        paramString = new byte[arrayOfByte.length * 3 + 1];
        j = 0;
        i = 0;
        for (;;)
        {
          if (j >= arrayOfByte.length) {
            break label258;
          }
          if (arrayOfByte[j] != 32) {
            break;
          }
          k = i + 1;
          paramString[i] = 37;
          m = k + 1;
          paramString[k] = 50;
          i = m + 1;
          paramString[m] = 48;
          j += 1;
        }
      }
    }
    if (!b((char)arrayOfByte[j]))
    {
      k = i + 1;
      paramString[i] = 37;
      m = arrayOfByte[j] >> 4 & 0xF;
      if (m < 10)
      {
        i = k + 1;
        paramString[k] = ((byte)(m + 48));
      }
      for (;;)
      {
        m = arrayOfByte[j] & 0xF;
        if (m >= 10) {
          break label217;
        }
        paramString[i] = ((byte)(m + 48));
        i += 1;
        break;
        i = k + 1;
        paramString[k] = ((byte)(m + 65 - 10));
      }
      label217:
      k = i + 1;
      paramString[i] = ((byte)(m + 65 - 10));
    }
    for (int i = k;; i = k)
    {
      break;
      k = i + 1;
      paramString[i] = arrayOfByte[j];
    }
    label258:
    return new String(paramString, 0, i);
  }
  
  public static final boolean b(char paramChar)
  {
    return (Character.isDigit(paramChar)) || (Character.isLowerCase(paramChar)) || (Character.isUpperCase(paramChar)) || (paramChar == '-') || (paramChar == '_') || (paramChar == '.') || (paramChar == '!') || (paramChar == '~') || (paramChar == '+') || (paramChar == '/');
  }
  
  private static String c(String paramString)
  {
    try
    {
      int j = paramString.indexOf('?');
      if (paramString.indexOf("/?") <= 0)
      {
        if (j < 0) {
          return paramString;
        }
        Object localObject = b(paramString);
        int i = paramString.indexOf((String)localObject);
        if (i < 0) {}
        int k;
        for (i = 0; paramString.indexOf('/', i) < 0; i = k + i)
        {
          localObject = new StringBuffer(paramString);
          ((StringBuffer)localObject).insert(j, '/');
          return ((StringBuffer)localObject).toString();
          k = ((String)localObject).length();
        }
      }
      return paramString;
    }
    catch (Exception localException) {}
  }
  
  public static String c(String paramString, boolean paramBoolean)
  {
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[paramString.length * 4];
    int j = 0;
    int k = 0;
    if (j < paramString.length)
    {
      int m;
      int i;
      if ((paramString[j] == '%') && (j + 2 < paramString.length))
      {
        m = 1;
        int n = 0;
        if (m < 3)
        {
          if ((paramString[(j + m)] <= '9') && (paramString[(j + m)] >= '0')) {
            i = n * 16 + (paramString[(j + m)] - '0');
          }
          for (;;)
          {
            m += 1;
            n = i;
            break;
            if ((paramString[(j + m)] <= 'F') && (paramString[(j + m)] >= 'A'))
            {
              i = n * 16 + (paramString[(j + m)] - 'A' + 10);
            }
            else
            {
              i = n;
              if (paramString[(j + m)] <= 'f')
              {
                i = n;
                if (paramString[(j + m)] >= 'a') {
                  i = n * 16 + (paramString[(j + m)] - 'a' + 10);
                }
              }
            }
          }
        }
        arrayOfByte[k] = ((byte)n);
        j += 2;
        i = k + 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (paramBoolean)
        {
          i = k + a(paramString[j], arrayOfByte, k);
        }
        else
        {
          m = k + 1;
          arrayOfByte[k] = ((byte)(paramString[j] >> '\b'));
          i = m + 1;
          arrayOfByte[m] = ((byte)paramString[j]);
        }
      }
    }
    if (paramBoolean) {}
    try
    {
      paramString = PkgTools.c(arrayOfByte, 0, k);
      return paramString;
    }
    catch (Exception paramString) {}
    return new String(arrayOfByte, 0, k);
    return null;
  }
  
  public static final boolean c(char paramChar)
  {
    return (a(paramChar)) || (paramChar == '$') || (paramChar == '\'') || (paramChar == '(') || (paramChar == ')') || (paramChar == '*') || (paramChar == ',') || (paramChar == ';') || (paramChar == '=') || (paramChar == ':') || (paramChar == '@') || (paramChar == '/') || (paramChar == '?');
  }
  
  public static String d(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      localObject = "";
    }
    do
    {
      do
      {
        return localObject;
        i = paramString.indexOf("?");
        localObject = paramString;
      } while (i <= 0);
      localObject = paramString;
    } while (i == paramString.length() - 1);
    char[] arrayOfChar = paramString.substring(i + 1, paramString.length()).toCharArray();
    Object localObject = new StringBuffer();
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer2.append(paramString.substring(0, i + 1));
    int j = 0;
    paramString = localStringBuffer1;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      switch (j)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (arrayOfChar[i] != '=')
        {
          ((StringBuffer)localObject).append(arrayOfChar[i]);
        }
        else
        {
          paramString = new StringBuffer();
          j = 1;
          continue;
          if (arrayOfChar[i] != '&')
          {
            char c1 = arrayOfChar[i];
            if (!c(c1))
            {
              if ((c1 == '%') && (i < arrayOfChar.length - 2) && (d(arrayOfChar[(i + 1)])) && (d(arrayOfChar[(i + 2)])))
              {
                paramString.append(arrayOfChar[i]);
                paramString.append(arrayOfChar[(i + 1)]);
                paramString.append(arrayOfChar[(i + 2)]);
                i += 3;
                break;
              }
              paramString.append(a(String.valueOf(arrayOfChar[i]), true));
              continue;
            }
            paramString.append(arrayOfChar[i]);
            continue;
          }
          localStringBuffer2.append((StringBuffer)localObject).append("=").append(paramString.toString()).append("&");
          localObject = new StringBuffer();
          paramString = new StringBuffer();
          j = 0;
        }
      }
    }
    if (j == 1) {
      localStringBuffer2.append((StringBuffer)localObject).append("=").append(paramString.toString());
    }
    for (;;)
    {
      return localStringBuffer2.toString();
      if (arrayOfChar[(arrayOfChar.length - 1)] != '&') {
        localStringBuffer2.append((StringBuffer)localObject);
      }
    }
  }
  
  public static boolean d(char paramChar)
  {
    return (Character.isDigit(paramChar)) || ((paramChar >= 'A') && (paramChar <= 'F')) || ((paramChar >= 'a') && (paramChar <= 'f'));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.URI
 * JD-Core Version:    0.7.0.1
 */