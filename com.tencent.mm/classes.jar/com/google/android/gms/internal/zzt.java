package com.google.android.gms.internal;

import android.util.Log;
import java.util.Locale;

public class zzt
{
  public static boolean DEBUG = Log.isLoggable("Volley", 2);
  public static String TAG = "Volley";
  
  public static void zza(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      zzd(paramString, paramVarArgs);
    }
  }
  
  public static void zza(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    zzd(paramString, paramVarArgs);
  }
  
  public static void zzb(String paramString, Object... paramVarArgs)
  {
    zzd(paramString, paramVarArgs);
  }
  
  public static void zzc(String paramString, Object... paramVarArgs)
  {
    zzd(paramString, paramVarArgs);
  }
  
  private static String zzd(String paramString, Object... paramVarArgs)
  {
    int i;
    label20:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label154;
      }
      if (paramVarArgs[i].getClass().equals(zzt.class)) {
        break label147;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
    }
    label147:
    label154:
    for (paramVarArgs = str + "." + paramVarArgs[i].getMethodName();; paramVarArgs = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i += 1;
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzt
 * JD-Core Version:    0.7.0.1
 */