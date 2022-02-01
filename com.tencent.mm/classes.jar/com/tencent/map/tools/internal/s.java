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
  private static Context b;
  private static s c;
  private String a;
  private String d;
  private int e;
  
  private s(Context paramContext)
  {
    AppMethodBeat.i(209798);
    this.a = "JudeCpuAbiHandler";
    this.d = "armeabi";
    this.e = 4;
    b = paramContext;
    this.d = b(paramContext);
    this.e = a(this.d);
    AppMethodBeat.o(209798);
  }
  
  private static int a(String paramString)
  {
    AppMethodBeat.i(209801);
    if (paramString == null)
    {
      AppMethodBeat.o(209801);
      return 4;
    }
    int i = 0;
    while (i < t.F.length)
    {
      if (paramString.equals(t.F[i]))
      {
        AppMethodBeat.o(209801);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(209801);
    return -1;
  }
  
  public static s a(Context paramContext)
  {
    AppMethodBeat.i(209799);
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new s(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(209799);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(209799);
    }
  }
  
  private static String b(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(209800);
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
          AppMethodBeat.o(209800);
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
          AppMethodBeat.o(209800);
          throw paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(209800);
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
    AppMethodBeat.i(209802);
    try
    {
      paramContext = paramContext.getApplicationContext().getPackageManager().getApplicationInfo(paramContext.getApplicationContext().getPackageName(), 0);
      Field localField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
      localField.setAccessible(true);
      paramContext = (String)localField.get(paramContext);
      AppMethodBeat.o(209802);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(209802);
    }
    return "getError";
  }
  
  public final int a()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.s
 * JD-Core Version:    0.7.0.1
 */