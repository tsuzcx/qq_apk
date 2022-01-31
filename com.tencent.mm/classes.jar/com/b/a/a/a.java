package com.b.a.a;

import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public final class a
{
  private static final FileFilter asd = new FileFilter()
  {
    public final boolean accept(File paramAnonymousFile)
    {
      paramAnonymousFile = paramAnonymousFile.getName();
      if (paramAnonymousFile.startsWith("cpu"))
      {
        int i = 3;
        while (i < paramAnonymousFile.length())
        {
          if (!Character.isDigit(paramAnonymousFile.charAt(i))) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
  };
  
  /* Error */
  @android.annotation.TargetApi(16)
  public static long W(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 29	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmplt +32 -> 37
    //   8: new 31	android/app/ActivityManager$MemoryInfo
    //   11: dup
    //   12: invokespecial 32	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   15: astore 4
    //   17: aload_0
    //   18: ldc 34
    //   20: invokevirtual 40	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 42	android/app/ActivityManager
    //   26: aload 4
    //   28: invokevirtual 46	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   31: aload 4
    //   33: getfield 50	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   36: lreturn
    //   37: new 52	java/io/FileInputStream
    //   40: dup
    //   41: ldc 54
    //   43: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   46: astore_0
    //   47: ldc 59
    //   49: aload_0
    //   50: invokestatic 63	com/b/a/a/a:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   53: istore_1
    //   54: iload_1
    //   55: i2l
    //   56: ldc2_w 64
    //   59: lmul
    //   60: lstore_2
    //   61: aload_0
    //   62: invokevirtual 68	java/io/FileInputStream:close	()V
    //   65: lload_2
    //   66: lreturn
    //   67: astore_0
    //   68: lload_2
    //   69: lreturn
    //   70: astore 4
    //   72: aload_0
    //   73: invokevirtual 68	java/io/FileInputStream:close	()V
    //   76: aload 4
    //   78: athrow
    //   79: astore_0
    //   80: ldc2_w 69
    //   83: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramContext	android.content.Context
    //   53	2	1	i	int
    //   60	9	2	l	long
    //   15	17	4	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   70	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/io/IOException
    //   47	54	70	finally
    //   37	47	79	java/io/IOException
    //   72	79	79	java/io/IOException
  }
  
  private static int a(String paramString, FileInputStream paramFileInputStream)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
      }
      catch (NumberFormatException paramString)
      {
        int n;
        return -1;
      }
      catch (IOException paramString)
      {
        continue;
      }
      int k = i;
      if (j < m)
      {
        n = j - i;
        k = i;
        if (arrayOfByte[j] == paramString.charAt(n))
        {
          if (n == paramString.length() - 1)
          {
            if ((j < 1024) && (arrayOfByte[j] != 10))
            {
              if (Character.isDigit(arrayOfByte[j]))
              {
                i = j + 1;
                if ((i < 1024) && (Character.isDigit(arrayOfByte[i])))
                {
                  i += 1;
                  continue;
                }
                i = bk.ZR(new String(arrayOfByte, 0, j, i - j));
                return i;
              }
              j += 1;
              continue;
            }
            return -1;
          }
          j += 1;
          continue;
        }
      }
      j = k + 1;
      if (j < m) {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
        }
      }
    }
  }
  
  /* Error */
  private static int af(String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: new 52	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: new 105	java/io/BufferedReader
    //   14: dup
    //   15: new 107	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 110	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: invokespecial 113	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 117	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload 4
    //   37: invokevirtual 118	java/io/BufferedReader:close	()V
    //   40: iload_2
    //   41: istore_1
    //   42: aload 5
    //   44: ifnull +17 -> 61
    //   47: aload 5
    //   49: ldc 120
    //   51: invokevirtual 124	java/lang/String:matches	(Ljava/lang/String;)Z
    //   54: istore_3
    //   55: iload_3
    //   56: ifne +11 -> 67
    //   59: iload_2
    //   60: istore_1
    //   61: aload_0
    //   62: invokevirtual 127	java/io/InputStream:close	()V
    //   65: iload_1
    //   66: ireturn
    //   67: aload 5
    //   69: iconst_2
    //   70: invokevirtual 131	java/lang/String:substring	(I)Ljava/lang/String;
    //   73: invokestatic 137	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   76: invokevirtual 140	java/lang/Integer:intValue	()I
    //   79: istore_1
    //   80: iload_1
    //   81: iconst_1
    //   82: iadd
    //   83: istore_1
    //   84: goto -23 -> 61
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_0
    //   90: iload_2
    //   91: istore_1
    //   92: aload_0
    //   93: ifnull -28 -> 65
    //   96: aload_0
    //   97: invokevirtual 127	java/io/InputStream:close	()V
    //   100: iconst_m1
    //   101: ireturn
    //   102: astore_0
    //   103: iconst_m1
    //   104: ireturn
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 127	java/io/InputStream:close	()V
    //   117: aload 4
    //   119: athrow
    //   120: astore_0
    //   121: iload_1
    //   122: ireturn
    //   123: astore_0
    //   124: goto -7 -> 117
    //   127: astore 4
    //   129: goto -20 -> 109
    //   132: astore 4
    //   134: goto -44 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   41	81	1	i	int
    //   1	90	2	j	int
    //   54	2	3	bool	boolean
    //   26	10	4	localBufferedReader	java.io.BufferedReader
    //   105	13	4	localObject1	Object
    //   127	1	4	localObject2	Object
    //   132	1	4	localIOException	IOException
    //   33	35	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	11	87	java/io/IOException
    //   96	100	102	java/io/IOException
    //   2	11	105	finally
    //   61	65	120	java/io/IOException
    //   113	117	123	java/io/IOException
    //   11	40	127	finally
    //   47	55	127	finally
    //   67	80	127	finally
    //   11	40	132	java/io/IOException
    //   47	55	132	java/io/IOException
    //   67	80	132	java/io/IOException
  }
  
  public static int kk()
  {
    int j;
    if (Build.VERSION.SDK_INT <= 10) {
      j = 1;
    }
    for (;;)
    {
      return j;
      try
      {
        j = af("/sys/devices/system/cpu/possible");
        int i = j;
        if (j == -1) {
          i = af("/sys/devices/system/cpu/present");
        }
        j = i;
        if (i == -1)
        {
          i = new File("/sys/devices/system/cpu/").listFiles(asd).length;
          return i;
        }
      }
      catch (SecurityException localSecurityException)
      {
        return -1;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    return -1;
  }
  
  public static int kl()
  {
    int k = 0;
    int i = -1;
    try
    {
      int j;
      for (;;)
      {
        Object localObject1;
        if (k < kk())
        {
          localObject1 = new File("/sys/devices/system/cpu/cpu" + k + "/cpufreq/cpuinfo_max_freq");
          j = i;
          if (((File)localObject1).exists())
          {
            j = i;
            if (((File)localObject1).canRead())
            {
              Object localObject2 = new byte[''];
              localObject1 = new FileInputStream((File)localObject1);
              try
              {
                ((FileInputStream)localObject1).read((byte[])localObject2);
                j = 0;
                while ((Character.isDigit(localObject2[j])) && (j < 128)) {
                  j += 1;
                }
                localObject2 = Integer.valueOf(bk.ZR(new String((byte[])localObject2, 0, j)));
                j = i;
                if (((Integer)localObject2).intValue() > i) {
                  j = ((Integer)localObject2).intValue();
                }
              }
              catch (NumberFormatException localNumberFormatException)
              {
                ((FileInputStream)localObject1).close();
                j = i;
              }
              finally
              {
                ((FileInputStream)localObject1).close();
              }
            }
          }
        }
        else
        {
          j = i;
          if (i != -1) {
            break;
          }
          localObject1 = new FileInputStream("/proc/cpuinfo");
          try
          {
            j = a("cpu MHz", (FileInputStream)localObject1);
            k = j * 1000;
            j = i;
            if (k > i) {
              j = k;
            }
            return j;
          }
          finally
          {
            ((FileInputStream)localObject1).close();
          }
        }
        k += 1;
        i = j;
      }
      return j;
    }
    catch (IOException localIOException)
    {
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */