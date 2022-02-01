package com.tencent.midas.comm.log.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Locale;

public class APCallbackLogger
{
  private static Object logCallbackObj;
  private static Method onLoggingMethod;
  
  public static boolean init(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(217214);
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = Class.forName(paramString);
      logCallbackObj = paramString.newInstance();
      onLoggingMethod = paramString.getDeclaredMethod("onLogging", new Class[] { Integer.TYPE, String.class, String.class });
      bool1 = bool2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    AppMethodBeat.o(217214);
    return bool1;
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217234);
    int i = 0;
    try
    {
      if (i < paramString2.length())
      {
        if (paramString2.length() <= i + 3600) {}
        String str2;
        for (String str1 = paramString2.substring(i);; str2 = paramString2.substring(i, i + 3600))
        {
          for (;;)
          {
            int j = i + 3600;
            i = j;
            if (logCallbackObj == null) {
              break;
            }
            Method localMethod = onLoggingMethod;
            i = j;
            if (localMethod == null) {
              break;
            }
            try
            {
              onLoggingMethod.invoke(logCallbackObj, new Object[] { Integer.valueOf(paramInt), paramString1, str1 });
              i = j;
            }
            catch (Exception localException)
            {
              i = j;
            }
          }
          break;
        }
      }
      AppMethodBeat.o(217234);
      return;
    }
    finally
    {
      String.format(Locale.CHINA, "print log error: <%s>%s", new Object[] { paramString1.getClass().getName(), paramString1.getMessage() });
      AppMethodBeat.o(217234);
    }
  }
  
  public static void release()
  {
    logCallbackObj = null;
    onLoggingMethod = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.comm.log.internal.APCallbackLogger
 * JD-Core Version:    0.7.0.1
 */