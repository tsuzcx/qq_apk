package com.tencent.d.d.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d
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
  
  private static String agD(int paramInt)
  {
    AppMethodBeat.i(138365);
    String str = "";
    try
    {
      Object localObject = a.gS(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject != null) {
        str = new String((byte[])localObject, 0, a((byte[])localObject, 0, '\000'));
      }
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        byte[] arrayOfByte = a.gS(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject = str;
        if (arrayOfByte != null)
        {
          paramInt = a(arrayOfByte, 7, '\n');
          if (paramInt == 0)
          {
            AppMethodBeat.o(138365);
            return "";
          }
          localObject = new String(arrayOfByte, 6, paramInt - 6);
        }
      }
      AppMethodBeat.o(138365);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(138365);
    }
    return "";
  }
  
  private static a agE(int paramInt)
  {
    AppMethodBeat.i(138366);
    try
    {
      str1 = agD(paramInt);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str1;
          Object localObject2 = new String(a.aZj(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[] { Integer.valueOf(paramInt) }))).trim();
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
      catch (Exception localException2)
      {
        int k;
        String str2;
        for (;;)
        {
          str2 = null;
        }
        Object localObject1 = new a(paramInt, i, (String)localObject1, k, str2);
        AppMethodBeat.o(138366);
        return localObject1;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = a.gS(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        if (localObject2 == null) {
          continue;
        }
        i = a((byte[])localObject2, 7, '\n');
        if (i == 0) {
          continue;
        }
        i = a((byte[])localObject2, a((byte[])localObject2, a((byte[])localObject2, i + 1, '\n') + 1, '\n') + 1, '\n');
        if (i == 0) {
          continue;
        }
        j = i + 7;
        i = a((byte[])localObject2, i + 1, '\n');
        if (i == 0) {
          continue;
        }
        j = Integer.parseInt(new String((byte[])localObject2, j, i - j));
      }
      catch (Exception localException3)
      {
        i = -1;
        break label240;
        i = -1;
        j = -1;
        break;
      }
      try
      {
        i = a((byte[])localObject2, i + 1, '\n');
        if (i == 0) {
          continue;
        }
        i += 6;
        i = Integer.parseInt(new String((byte[])localObject2, i, a((byte[])localObject2, i + 1, '\t') - i));
      }
      catch (Exception localException4)
      {
        i = j;
        break label240;
        i = -1;
        break;
      }
    }
    k = i;
    i = j;
  }
  
  public static List<a> fTN()
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
            localObject = agE(Integer.parseInt((String)localObject));
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
  
  public static final class a
  {
    public int LMW;
    public String LMX;
    public String name = "";
    public int pid;
    public int uid;
    
    a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
    {
      this.pid = paramInt1;
      this.LMW = paramInt2;
      this.name = paramString1;
      this.uid = paramInt3;
      this.LMX = paramString2;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(138363);
      String str = "PID=" + this.pid + " PPID=" + this.LMW + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.LMX;
      AppMethodBeat.o(138363);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.b.d
 * JD-Core Version:    0.7.0.1
 */