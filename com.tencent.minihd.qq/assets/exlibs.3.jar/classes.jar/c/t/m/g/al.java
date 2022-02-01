package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class al
{
  private static String a = null;
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getPackageName();
  }
  
  /* Error */
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull +8 -> 14
    //   9: ldc 2
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: aload_0
    //   15: ldc 24
    //   17: iconst_0
    //   18: invokevirtual 28	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   21: ldc 30
    //   23: iconst_1
    //   24: invokeinterface 36 3 0
    //   29: istore_2
    //   30: iload_2
    //   31: istore_1
    //   32: iload_2
    //   33: ifeq -24 -> 9
    //   36: aload_0
    //   37: invokevirtual 40	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   40: ldc 24
    //   42: iconst_0
    //   43: invokevirtual 28	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   46: invokeinterface 44 1 0
    //   51: astore_0
    //   52: aload_0
    //   53: ldc 30
    //   55: iconst_0
    //   56: invokeinterface 50 3 0
    //   61: pop
    //   62: aload_0
    //   63: invokeinterface 54 1 0
    //   68: pop
    //   69: iload_2
    //   70: istore_1
    //   71: goto -62 -> 9
    //   74: astore_0
    //   75: iload_2
    //   76: istore_1
    //   77: aload_0
    //   78: invokevirtual 57	java/lang/Exception:printStackTrace	()V
    //   81: goto -72 -> 9
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    //   90: astore_0
    //   91: iconst_1
    //   92: istore_1
    //   93: goto -16 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   1	92	1	bool1	boolean
    //   29	47	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   36	69	74	java/lang/Exception
    //   14	30	84	finally
    //   36	69	84	finally
    //   77	81	84	finally
    //   14	30	90	java/lang/Exception
  }
  
  public static String c(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      int k;
      try
      {
        if (a != null)
        {
          paramContext = a;
          return paramContext;
        }
        Object localObject;
        if (paramContext == null) {
          localObject = null;
        }
        try
        {
          paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
          localObject = paramContext.versionName;
          int m = paramContext.versionCode;
          if ((localObject == null) || (((String)localObject).trim().length() <= 0))
          {
            paramContext = m;
            continue;
            localObject = paramContext.getPackageName();
            continue;
          }
          paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
          localObject = paramContext.toCharArray();
          j = 0;
          if (i < localObject.length)
          {
            k = j;
            if (localObject[i] != '.') {
              break label211;
            }
            k = j + 1;
            break label211;
          }
          if (j >= 3) {
            break label208;
          }
          paramContext = paramContext + "." + m;
          a = paramContext;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          paramContext = "";
        }
        continue;
        continue;
      }
      finally {}
      label208:
      label211:
      i += 1;
      int j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.al
 * JD-Core Version:    0.7.0.1
 */