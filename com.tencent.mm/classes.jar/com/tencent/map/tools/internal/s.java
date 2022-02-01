package com.tencent.map.tools.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public class s
{
  private static Context c;
  private static s d;
  public int a;
  private String b;
  private String e;
  
  private s(Context paramContext)
  {
    AppMethodBeat.i(236567);
    this.b = "JudeCpuAbiHandler";
    this.e = "armeabi";
    this.a = 4;
    c = paramContext;
    this.e = b(paramContext);
    this.a = a(this.e);
    AppMethodBeat.o(236567);
  }
  
  private static int a(String paramString)
  {
    AppMethodBeat.i(236571);
    if (paramString == null)
    {
      AppMethodBeat.o(236571);
      return 4;
    }
    int i = 0;
    while (i < t.F.length)
    {
      if (paramString.equals(t.F[i]))
      {
        AppMethodBeat.o(236571);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(236571);
    return -1;
  }
  
  public static s a(Context paramContext)
  {
    AppMethodBeat.i(236568);
    try
    {
      if (d == null) {
        d = new s(paramContext);
      }
      paramContext = d;
      AppMethodBeat.o(236568);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(236568);
    }
  }
  
  private static String b(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(236570);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          bool1 = Process.is64Bit();
          if (!bool1) {
            break label179;
          }
          paramContext = Build.SUPPORTED_64_BIT_ABIS[0];
          AppMethodBeat.o(236570);
          return paramContext;
        }
        if (Build.VERSION.SDK_INT < 21) {
          break label186;
        }
        String[] arrayOfString = Build.SUPPORTED_ABIS;
        String str1 = "";
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
        {
          String str2 = arrayOfString[i];
          str1 = str1 + str2 + ",";
          i += 1;
          continue;
        }
        if (!str1.contains("64")) {
          break label186;
        }
        paramContext = c(paramContext);
        bool1 = bool2;
        if (paramContext == null) {
          continue;
        }
        if (paramContext.equals("getError"))
        {
          paramContext = new Exception("getError");
          AppMethodBeat.o(236570);
          throw paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(236570);
        return "armeabi";
      }
      boolean bool1 = bool2;
      if (!paramContext.contains("64"))
      {
        bool1 = false;
        continue;
        label179:
        paramContext = Build.CPU_ABI;
        continue;
        label186:
        bool1 = false;
      }
    }
  }
  
  private static String c(Context paramContext)
  {
    AppMethodBeat.i(236573);
    try
    {
      paramContext = paramContext.getApplicationContext().getPackageManager().getApplicationInfo(paramContext.getApplicationContext().getPackageName(), 0);
      Field localField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
      localField.setAccessible(true);
      paramContext = (String)localField.get(paramContext);
      AppMethodBeat.o(236573);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(236573);
    }
    return "getError";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.s
 * JD-Core Version:    0.7.0.1
 */