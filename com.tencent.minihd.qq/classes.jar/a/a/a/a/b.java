package a.a.a.a;

import a.a.a.b.h;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class b
{
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    localObject = paramContext.getPackageManager();
    for (paramContext = paramContext.getPackageName();; paramContext = null)
    {
      try
      {
        paramContext = ((PackageManager)localObject).getApplicationInfo(paramContext, 8192);
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.sourceDir;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
          continue;
          localObject = paramString2;
          if (!paramString2.endsWith(File.separator)) {
            localObject = paramString2 + File.separator;
          }
          new File((String)localObject).mkdirs();
          paramString2 = "lib/" + b() + "/";
          paramString1 = "lib/" + b() + "/" + paramString1;
          try
          {
            paramContext = new e(new File(paramContext), paramString1);
            if (paramContext != null)
            {
              d locald = paramContext.d;
              if ((locald != null) && (locald.a.contains(paramString2)) && (locald.a.endsWith(".so")))
              {
                paramString2 = locald.a;
                int i = paramString2.lastIndexOf('/');
                paramString1 = paramString2;
                if (i != -1) {
                  paramString1 = paramString2.substring(i + 1);
                }
                paramString1 = new File((String)localObject + paramString1);
                if (paramString1.exists()) {
                  paramString1.delete();
                }
                paramString2 = new byte[4096];
                try
                {
                  paramContext = paramContext.a(locald);
                  localObject = new FileOutputStream(paramString1);
                  for (;;)
                  {
                    i = paramContext.read(paramString2);
                    if (i <= 0) {
                      break;
                    }
                    ((FileOutputStream)localObject).write(paramString2, 0, i);
                  }
                }
                catch (IOException paramContext)
                {
                  paramContext = paramString1;
                }
              }
            }
          }
          catch (IOException paramContext)
          {
            for (;;)
            {
              paramContext = null;
            }
            paramContext = null;
          }
        }
      }
      if (paramContext != null) {
        break;
      }
      paramContext = null;
      if (paramContext.exists())
      {
        paramString1 = paramContext;
        if (paramContext.length() > 0L) {}
      }
      else
      {
        paramString1 = null;
      }
      return paramString1;
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 134	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc 136
    //   14: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc 136
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: ldc 138
    //   35: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +9 -> 47
    //   41: ldc 138
    //   43: astore_0
    //   44: goto -21 -> 23
    //   47: aload_0
    //   48: ifnull +18 -> 66
    //   51: aload_0
    //   52: ldc 140
    //   54: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifeq +9 -> 66
    //   60: ldc 136
    //   62: astore_0
    //   63: goto -40 -> 23
    //   66: ldc 142
    //   68: astore_0
    //   69: goto -46 -> 23
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	63	0	str	String
    //   72	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	72	finally
    //   11	20	72	finally
    //   32	41	72	finally
    //   51	60	72	finally
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i % 8)]));
      i += 1;
    }
    return new String(arrayOfByte);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      if (paramInputStream == null) {
        break label82;
      }
      if (paramArrayOfByte == null) {
        break label72;
      }
      if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= paramArrayOfByte.length) && (paramArrayOfByte.length - paramInt1 >= paramInt2)) {
        while (paramInt2 > 0)
        {
          int i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
          if (i < 0) {
            break label64;
          }
          paramInt1 += i;
          paramInt2 -= i;
        }
      }
    }
    label64:
    throw new EOFException();
    label72:
    throw new NullPointerException("dst == null");
    label82:
    throw new NullPointerException("in == null");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    String str = "lib" + paramString + ".so";
    Object localObject1 = new StringBuilder();
    boolean bool1;
    try
    {
      paramString = paramContext.getFilesDir().getParent();
      localObject2 = paramString + "/.seclib/";
      try
      {
        localObject1 = new File((String)localObject2 + str);
        if (((File)localObject1).exists())
        {
          paramString = (String)localObject1;
          if (((File)localObject1).length() != 0L) {}
        }
        else
        {
          paramString = a(paramContext, str, (String)localObject2);
        }
        if ((paramString != null) && (paramString.exists()))
        {
          if (h.a(paramString, null)) {
            break label283;
          }
          paramString.delete();
          bool1 = h.a(a(paramContext, str, (String)localObject2), null);
          if (bool1) {
            break label283;
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          boolean bool2;
          paramContext.printStackTrace();
        }
      }
      bool1 = false;
      bool2 = bool1;
      if (!bool1) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          System.load((String)localObject2 + str);
          bool2 = true;
          return bool2;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          Object localObject2;
          label283:
          paramContext.printStackTrace();
        }
        paramString = paramString;
        try
        {
          if ((paramContext instanceof ContextWrapper))
          {
            paramString = ((ContextWrapper)paramContext).getBaseContext();
            localObject2 = paramString.getClass();
            localObject2 = ((Class)localObject2).getDeclaredMethod("getDataDirFile", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            paramString = ((File)((Method)localObject2).invoke(paramString, new Object[0])).getAbsolutePath();
            continue;
          }
          paramString = ContextWrapper.class.getDeclaredField("mBase");
          paramString.setAccessible(true);
          paramString = paramString.get(paramContext);
          continue;
          continue;
        }
        finally
        {
          paramString = null;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String b()
  {
    try
    {
      String str = a();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = a(paramContext, paramString);
      localUnsatisfiedLinkError.printStackTrace();
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */