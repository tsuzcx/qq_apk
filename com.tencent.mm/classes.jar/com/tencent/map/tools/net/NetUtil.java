package com.tencent.map.tools.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

@SuppressLint({"MissingPermission"})
public class NetUtil
{
  private static final int BUF_SIZE = 4096;
  private static final String CMWAP = "cmwap";
  private static final String CTWAP = "ctwap";
  public static final int DEFAULT_TIME_OUT = 10000;
  public static final String MAP_USER_AGENT = "QQ Map Mobile";
  private static final String NET_3G = "3gnet";
  public static final String STR_UserAgent = "androidsdk";
  public static final int TYPE_3GWAP = 3;
  public static final int TYPE_CMWAP = 1;
  public static final int TYPE_CTWAP = 4;
  public static final int TYPE_NET_WORK_DISABLED = 0;
  public static final int TYPE_OTHER_NET = 6;
  public static final int TYPE_UNIWAP = 2;
  public static final int TYPE_WIFI = 5;
  private static final String UNIWAP = "uniwap";
  private static final String WAP_3G = "3gwap";
  private static final String WIFI = "wifi";
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(172931);
    int i = getNetType(getNetworkInfo(paramContext));
    AppMethodBeat.o(172931);
    return i;
  }
  
  private static int getNetType(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(180923);
    if ((paramNetworkInfo == null) || (!paramNetworkInfo.isAvailable()))
    {
      AppMethodBeat.o(180923);
      return 0;
    }
    int i = paramNetworkInfo.getType();
    if (i == 1)
    {
      AppMethodBeat.o(180923);
      return 5;
    }
    if (i != 0)
    {
      AppMethodBeat.o(180923);
      return 6;
    }
    paramNetworkInfo = paramNetworkInfo.getExtraInfo();
    if (TextUtils.isEmpty(paramNetworkInfo))
    {
      AppMethodBeat.o(180923);
      return 6;
    }
    if (paramNetworkInfo.equalsIgnoreCase("cmwap"))
    {
      AppMethodBeat.o(180923);
      return 1;
    }
    if (paramNetworkInfo.equalsIgnoreCase("3gwap"))
    {
      AppMethodBeat.o(180923);
      return 3;
    }
    if (paramNetworkInfo.equalsIgnoreCase("uniwap"))
    {
      AppMethodBeat.o(180923);
      return 2;
    }
    if (paramNetworkInfo.equalsIgnoreCase("ctwap"))
    {
      AppMethodBeat.o(180923);
      return 4;
    }
    AppMethodBeat.o(180923);
    return 3;
  }
  
  public static String getNetTypeStr(Context paramContext)
  {
    AppMethodBeat.i(172932);
    int i = getNetType(paramContext);
    paramContext = "";
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(172932);
      return paramContext;
      paramContext = "wifi";
      continue;
      paramContext = "3gwap";
      continue;
      paramContext = "uniwap";
      continue;
      paramContext = "cmwap";
      continue;
      paramContext = "ctwap";
    }
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    AppMethodBeat.i(172930);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      AppMethodBeat.o(172930);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(172930);
    }
    return null;
  }
  
  public static String getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(172933);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        if (i == 1)
        {
          AppMethodBeat.o(172933);
          return "wifi";
        }
        if (i == 0)
        {
          i = paramContext.getSubtype();
          switch (i)
          {
          case 7: 
          default: 
            AppMethodBeat.o(172933);
            return "other";
          case 4: 
            AppMethodBeat.o(172933);
            return "2g";
          case 2: 
            AppMethodBeat.o(172933);
            return "2g";
          case 5: 
            AppMethodBeat.o(172933);
            return "3g";
          case 6: 
            AppMethodBeat.o(172933);
            return "3g";
          case 1: 
            AppMethodBeat.o(172933);
            return "2g";
          case 8: 
            AppMethodBeat.o(172933);
            return "3g";
          }
          AppMethodBeat.o(172933);
          return "3g";
        }
        AppMethodBeat.o(172933);
        return "other";
      }
      AppMethodBeat.o(172933);
      return "unknown";
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(172933);
    }
    return "unknown";
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(172936);
    int i = getNetType(paramContext);
    if ((i != 0) && (i != 5))
    {
      AppMethodBeat.o(172936);
      return true;
    }
    AppMethodBeat.o(172936);
    return false;
  }
  
  public static boolean isNetAvailable(Context paramContext)
  {
    AppMethodBeat.i(172934);
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      paramContext = getNetworkInfo(paramContext);
      boolean bool;
      if (paramContext != null)
      {
        bool = paramContext.isAvailable();
        AppMethodBeat.o(172934);
        return bool;
      }
      paramContext = localConnectivityManager.getAllNetworkInfo();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        localConnectivityManager = paramContext[i];
        if (localConnectivityManager.isAvailable())
        {
          bool = localConnectivityManager.isConnectedOrConnecting();
          if (bool)
          {
            AppMethodBeat.o(172934);
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(172934);
    }
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(172935);
    if (getNetType(paramContext) == 5)
    {
      AppMethodBeat.o(172935);
      return true;
    }
    AppMethodBeat.o(172935);
    return false;
  }
  
  public static final void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(195080);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(195080);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(195080);
  }
  
  /* Error */
  public static byte[] toBytes(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 168
    //   11: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 170	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 171	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_2
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore_3
    //   30: aload_0
    //   31: aload_3
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 177	java/io/InputStream:read	([BII)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_m1
    //   42: if_icmpeq +25 -> 67
    //   45: aload_2
    //   46: aload_3
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 181	java/io/ByteArrayOutputStream:write	([BII)V
    //   52: goto -22 -> 30
    //   55: astore_0
    //   56: aload_2
    //   57: invokestatic 183	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   60: ldc 168
    //   62: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: aload_2
    //   68: invokevirtual 186	java/io/ByteArrayOutputStream:flush	()V
    //   71: aload_2
    //   72: invokevirtual 190	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokestatic 183	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   80: ldc 168
    //   82: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: invokestatic 183	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   94: ldc 168
    //   96: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: goto -12 -> 90
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_2
    //   108: goto -52 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramInputStream	java.io.InputStream
    //   39	10	1	i	int
    //   23	85	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   29	18	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	30	55	java/lang/Throwable
    //   30	40	55	java/lang/Throwable
    //   45	52	55	java/lang/Throwable
    //   67	76	55	java/lang/Throwable
    //   16	24	87	finally
    //   24	30	101	finally
    //   30	40	101	finally
    //   45	52	101	finally
    //   67	76	101	finally
    //   16	24	105	java/lang/Throwable
  }
  
  public static void writeBytesWithoutClose(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(195082);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramOutputStream == null))
    {
      AppMethodBeat.o(195082);
      return;
    }
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      AppMethodBeat.o(195082);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      AppMethodBeat.o(195082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.net.NetUtil
 * JD-Core Version:    0.7.0.1
 */