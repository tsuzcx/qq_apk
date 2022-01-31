package c.t.m.g;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public final class cm
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(Math.max(paramInt1, 0), paramInt2);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) && (paramInt4 >= paramInt2) && (paramInt4 <= paramInt3)) {
      return paramInt4;
    }
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  public static String a()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject = a;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (TelephonyManager)m.a().getSystemService("phone");
          if (localObject != null)
          {
            String str = ((TelephonyManager)localObject).getDeviceId();
            localObject = str;
            if (str == null) {
              localObject = "NOIMEI";
            }
            a = (String)localObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      return a;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 71	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 73
    //   8: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: iload_0
    //   12: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15: ldc 83
    //   17: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_2
    //   24: new 91	java/io/BufferedReader
    //   27: dup
    //   28: new 93	java/io/FileReader
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 94	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   36: invokespecial 97	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 100	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_3
    //   45: aload_3
    //   46: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +60 -> 109
    //   52: aload_3
    //   53: invokevirtual 60	java/lang/String:trim	()Ljava/lang/String;
    //   56: astore_3
    //   57: aload_3
    //   58: astore_1
    //   59: aload_2
    //   60: invokevirtual 109	java/io/BufferedReader:close	()V
    //   63: aload_1
    //   64: areturn
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull -6 -> 63
    //   72: aload_2
    //   73: invokevirtual 109	java/io/BufferedReader:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 109	java/io/BufferedReader:close	()V
    //   92: aload_1
    //   93: athrow
    //   94: astore_2
    //   95: aload_1
    //   96: areturn
    //   97: astore_2
    //   98: goto -6 -> 92
    //   101: astore_1
    //   102: goto -18 -> 84
    //   105: astore_3
    //   106: goto -38 -> 68
    //   109: aload_3
    //   110: astore_1
    //   111: goto -52 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInt	int
    //   1	63	1	localObject1	Object
    //   78	1	1	localIOException1	java.io.IOException
    //   81	15	1	str1	String
    //   101	1	1	localObject2	Object
    //   110	1	1	localObject3	Object
    //   23	37	2	localObject4	Object
    //   65	1	2	localException1	Exception
    //   67	22	2	localObject5	Object
    //   94	1	2	localIOException2	java.io.IOException
    //   97	1	2	localIOException3	java.io.IOException
    //   44	14	3	str2	String
    //   105	5	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	40	65	java/lang/Exception
    //   72	76	78	java/io/IOException
    //   24	40	81	finally
    //   59	63	94	java/io/IOException
    //   88	92	97	java/io/IOException
    //   40	57	101	finally
    //   40	57	105	java/lang/Exception
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      paramString = paramString.format(localCalendar.getTime());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSystemService("activity");
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (ActivityManager)paramContext;
        if (paramContext != null) {
          break;
        }
        return null;
      }
      catch (Throwable paramContext) {}
      paramContext = null;
    }
    paramContext = paramContext.getRunningAppProcesses();
    int i;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      int j = paramContext.size();
      i = 0;
      if (i < j)
      {
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
        if ((localRunningAppProcessInfo == null) || (localRunningAppProcessInfo.pid != paramInt)) {}
      }
    }
    for (paramContext = localRunningAppProcessInfo.processName;; paramContext = null)
    {
      return paramContext;
      i += 1;
      break;
    }
  }
  
  public static String a(Throwable paramThrowable)
  {
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (!TextUtils.isEmpty(paramThrowable))
    {
      paramThrowable = paramThrowable.split("\n");
      if (paramThrowable.length >= 2) {
        return paramThrowable[0] + paramThrowable[1];
      }
      if (paramThrowable.length == 1) {
        return paramThrowable[0];
      }
      return "";
    }
    return "";
  }
  
  private static String a(InetAddress paramInetAddress)
  {
    for (;;)
    {
      int i;
      try
      {
        paramInetAddress = paramInetAddress.getAddress();
        StringBuilder localStringBuilder1 = new StringBuilder();
        i = 0;
        if (i < paramInetAddress.length)
        {
          StringBuilder localStringBuilder2 = new StringBuilder(".");
          if (paramInetAddress[i] < 0)
          {
            j = paramInetAddress[i] + 256;
            localStringBuilder1.append(j);
            i += 1;
          }
        }
        else
        {
          paramInetAddress = localStringBuilder1.substring(1);
          return paramInetAddress;
        }
      }
      catch (Throwable paramInetAddress)
      {
        return "";
      }
      int j = paramInetAddress[i];
    }
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() == 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static String b()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject = b;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (TelephonyManager)m.a().getSystemService("phone");
          if (localObject != null)
          {
            String str = ((TelephonyManager)localObject).getSubscriberId();
            localObject = str;
            if (str == null) {
              localObject = "NOIMSI";
            }
            b = (String)localObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      return b;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    int i = paramArrayOfByte.length;
    if (paramArrayOfByte == null) {
      return "null";
    }
    int j = Math.min(i, paramArrayOfByte.length);
    StringBuffer localStringBuffer = new StringBuffer("size:" + j + ",content:");
    i = 0;
    while (i < j)
    {
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF));
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String c()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject = c;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (WifiManager)m.a().getApplicationContext().getSystemService("wifi");
          if (localObject != null)
          {
            localObject = ((WifiManager)localObject).getConnectionInfo();
            if (localObject != null)
            {
              String str = ((WifiInfo)localObject).getMacAddress();
              localObject = str;
              if (str == null) {
                localObject = "NOMAC";
              }
              c = (String)localObject;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      return c;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = a(InetAddress.getByName(paramString));
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String d()
  {
    try
    {
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append((int)(Math.random() * 2147483647.0D));
      localObject = cl.a(((StringBuilder)localObject).toString());
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = paramString.split("\\.");
      int i;
      String str;
      if (paramString.length == 4)
      {
        int j = paramString.length;
        i = 0;
        if (i < j) {
          str = paramString[i];
        }
      }
      try
      {
        int k = Integer.parseInt(str);
        if ((k >= 0) && (k <= 255)) {
          i += 1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return true;
    return false;
  }
  
  public static String e()
  {
    int i = 1;
    try
    {
      String str = d;
      if (str == null) {}
      for (;;)
      {
        if (i != 0) {
          d = Settings.Secure.getString(m.a().getContentResolver(), "android_id");
        }
        return d;
        int j = str.trim().length();
        if (j != 0) {
          i = 0;
        }
      }
      return "";
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String f()
  {
    try
    {
      String str = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.cm
 * JD-Core Version:    0.7.0.1
 */