package com.tencent.e.d.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class e
{
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
  
  private static e.a aGY(int paramInt)
  {
    AppMethodBeat.i(138366);
    try
    {
      str2 = getProcessName(paramInt);
      localObject3 = str2;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          byte[] arrayOfByte;
          String str1;
          label239:
          String str2 = new String(b.bgq(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[] { Integer.valueOf(paramInt) }))).trim();
          if ((str1 != null) && (i != -1) && (k != -1)) {
            break;
          }
          AppMethodBeat.o(138366);
          return null;
          localException1 = localException1;
          i = -1;
          localObject1 = null;
          k = -1;
        }
      }
      catch (Exception localException3)
      {
        int k;
        String str3;
        for (;;)
        {
          str3 = null;
        }
        Object localObject1 = new e.a(paramInt, i, (String)localObject1, k, str3);
        AppMethodBeat.o(138366);
        return localObject1;
      }
    }
    for (;;)
    {
      try
      {
        arrayOfByte = b.jr(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject3 = str2;
        if (arrayOfByte == null) {
          continue;
        }
        localObject3 = str2;
        i = a(arrayOfByte, 7, '\n');
        localObject3 = str2;
        if (i == 0) {
          continue;
        }
        str1 = str2;
        if (str2 == null)
        {
          localObject3 = str2;
          str1 = new String(arrayOfByte, 6, i - 6);
        }
        localObject3 = str1;
        i = a(arrayOfByte, a(arrayOfByte, a(arrayOfByte, i + 1, '\n') + 1, '\n') + 1, '\n');
        localObject3 = str1;
        if (i == 0) {
          continue;
        }
        j = i + 7;
        localObject3 = str1;
        i = a(arrayOfByte, i + 1, '\n');
        localObject3 = str1;
        if (i == 0) {
          continue;
        }
        localObject3 = str1;
        j = Integer.parseInt(new String(arrayOfByte, j, i - j));
      }
      catch (Exception localException2)
      {
        i = -1;
        Object localObject2 = localObject3;
        break label306;
        i = -1;
        j = -1;
        localObject2 = localObject3;
        break label239;
      }
      try
      {
        i = a(arrayOfByte, i + 1, '\n');
        if (i == 0) {
          continue;
        }
        i += 6;
        i = Integer.parseInt(new String(arrayOfByte, i, a(arrayOfByte, i + 1, '\t') - i));
      }
      catch (Exception localException4)
      {
        i = j;
        break label306;
        i = -1;
        break label239;
      }
    }
    k = i;
    i = j;
  }
  
  private static String getProcessName(int paramInt)
  {
    AppMethodBeat.i(138365);
    String str = "";
    try
    {
      Object localObject2 = b.jr(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject2 != null) {
        str = new String((byte[])localObject2, 0, a((byte[])localObject2, 0, '\000'));
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str))
      {
        byte[] arrayOfByte = b.jr(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject2 = str;
        if (arrayOfByte != null)
        {
          paramInt = a(arrayOfByte, 7, '\n');
          if (paramInt == 0) {
            return "";
          }
          localObject2 = new String(arrayOfByte, 6, paramInt - 6);
        }
      }
      return localObject2;
    }
    finally
    {
      AppMethodBeat.o(138365);
    }
    return "";
  }
  
  public static List<e.a> jXi()
  {
    int i = 0;
    AppMethodBeat.i(138364);
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new File("/proc").list();
    if (arrayOfString == null)
    {
      AppMethodBeat.o(138364);
      return localArrayList;
    }
    int j = arrayOfString.length;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = arrayOfString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            int k = ((String)localObject).charAt(0);
            if ((k > 57) || (k < 48)) {
              break label125;
            }
            localObject = aGY(Integer.parseInt((String)localObject));
            if (localObject == null) {
              break label125;
            }
            localArrayList.add(localObject);
          }
          catch (Exception localException) {}
        }
      }
      else
      {
        AppMethodBeat.o(138364);
        return localArrayList;
      }
      label125:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.d.b.e
 * JD-Core Version:    0.7.0.1
 */