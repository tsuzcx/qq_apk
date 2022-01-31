package com.tencent.d.d.b;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d
{
  private static String Jk(int paramInt)
  {
    String str = "";
    Object localObject;
    try
    {
      localObject = a.dT(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject != null) {
        str = new String((byte[])localObject, 0, a((byte[])localObject, 0, '\000'));
      }
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        byte[] arrayOfByte = a.dT(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject = str;
        if (arrayOfByte != null)
        {
          paramInt = a(arrayOfByte, 7, '\n');
          if (paramInt == 0) {
            return "";
          }
          str = new String(arrayOfByte, 6, paramInt - 6);
          return str;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localObject = "";
    }
    return localObject;
  }
  
  private static d.a Jl(int paramInt)
  {
    try
    {
      str1 = Jk(paramInt);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str1;
          Object localObject = new String(a.afF(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[] { Integer.valueOf(paramInt) }))).trim();
          if ((str1 != null) && (i != -1) && (k != -1)) {
            break;
          }
          return null;
          localException1 = localException1;
          i = -1;
          str2 = null;
          label230:
          k = -1;
        }
      }
      catch (Exception localException2)
      {
        int k;
        String str2;
        String str3;
        for (;;)
        {
          str3 = null;
        }
        return new d.a(paramInt, i, str2, k, str3);
      }
    }
    for (;;)
    {
      try
      {
        localObject = a.dT(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        if (localObject == null) {
          continue;
        }
        i = a((byte[])localObject, 7, '\n');
        if (i == 0) {
          continue;
        }
        i = a((byte[])localObject, a((byte[])localObject, a((byte[])localObject, i + 1, '\n') + 1, '\n') + 1, '\n');
        if (i == 0) {
          continue;
        }
        j = i + 7;
        i = a((byte[])localObject, i + 1, '\n');
        if (i == 0) {
          continue;
        }
        j = Integer.parseInt(new String((byte[])localObject, j, i - j));
      }
      catch (Exception localException3)
      {
        i = -1;
        break label230;
        i = -1;
        j = -1;
        break;
      }
      try
      {
        i = a((byte[])localObject, i + 1, '\n');
        if (i == 0) {
          continue;
        }
        i += 6;
        i = Integer.parseInt(new String((byte[])localObject, i, a((byte[])localObject, i + 1, '\t') - i));
      }
      catch (Exception localException4)
      {
        i = j;
        break label230;
        i = -1;
        break;
      }
    }
    k = i;
    i = j;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt, char paramChar)
  {
    paramInt -= 1;
    for (;;)
    {
      int i = paramInt + 1;
      if (paramInt < paramArrayOfByte.length)
      {
        if ((i == paramArrayOfByte.length) || (paramArrayOfByte[i] == paramChar)) {
          return i;
        }
      }
      else {
        return 0;
      }
      paramInt = i;
    }
  }
  
  public static List<d.a> cOL()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new File("/proc").list();
    if (arrayOfString == null) {}
    for (;;)
    {
      return localArrayList;
      int j = arrayOfString.length;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            int k = ((String)localObject).charAt(0);
            if ((k <= 57) && (k >= 48))
            {
              localObject = Jl(Integer.parseInt((String)localObject));
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
          }
          catch (Exception localException) {}
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.d.b.d
 * JD-Core Version:    0.7.0.1
 */