package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.m;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class WxaCommLibRuntimeReader
{
  private static i fCX;
  private static Future<Object> fCY;
  private static final ThreadPoolExecutor fCZ = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  
  /* Error */
  public static void abN()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 49	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:mT	()V
    //   6: getstatic 51	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fCX	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   9: ifnonnull +9 -> 18
    //   12: getstatic 55	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$b:fDb	Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$b;
    //   15: putstatic 51	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fCX	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: astore_0
    //   23: ldc 57
    //   25: ldc 59
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: invokestatic 65	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: getstatic 51	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fCX	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   41: ifnonnull -23 -> 18
    //   44: getstatic 55	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$b:fDb	Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$b;
    //   47: putstatic 51	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fCX	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   50: goto -32 -> 18
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: getstatic 51	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fCX	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   63: ifnonnull +9 -> 72
    //   66: getstatic 55	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$b:fDb	Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$b;
    //   69: putstatic 51	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fCX	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   72: aload_0
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	12	0	localThrowable	Throwable
    //   53	5	0	localObject1	Object
    //   59	14	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	6	22	java/lang/Throwable
    //   6	18	53	finally
    //   38	50	53	finally
    //   60	72	53	finally
    //   72	74	53	finally
    //   3	6	59	finally
    //   23	38	59	finally
  }
  
  /* Error */
  public static boolean abO()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 51	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:fCX	Lcom/tencent/mm/plugin/appbrand/appcache/i;
    //   8: astore_1
    //   9: ldc 57
    //   11: ldc 69
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 72	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_1
    //   25: ifnull +8 -> 33
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload_0
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_0
    //   35: goto -7 -> 28
    //   38: astore_1
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	34	0	bool	boolean
    //   8	17	1	locali	i
    //   38	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	38	finally
  }
  
  public static i abP()
  {
    try
    {
      if (fCX == null) {
        abN();
      }
      i locali = fCX;
      return locali;
    }
    finally {}
  }
  
  public static WxaPkgWrappingInfo abQ()
  {
    return abP().abB();
  }
  
  /* Error */
  private static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 91	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 94	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_2
    //   9: sipush 4096
    //   12: newarray char
    //   14: astore_3
    //   15: new 96	java/io/StringWriter
    //   18: dup
    //   19: invokespecial 97	java/io/StringWriter:<init>	()V
    //   22: astore 4
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 101	java/io/InputStreamReader:read	([C)I
    //   29: istore_1
    //   30: iconst_m1
    //   31: iload_1
    //   32: if_icmpeq +44 -> 76
    //   35: aload 4
    //   37: aload_3
    //   38: iconst_0
    //   39: iload_1
    //   40: invokevirtual 105	java/io/StringWriter:write	([CII)V
    //   43: goto -19 -> 24
    //   46: astore_3
    //   47: ldc 57
    //   49: ldc 107
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: invokevirtual 111	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: aastore
    //   62: invokestatic 65	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_2
    //   66: invokestatic 117	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   69: aload_0
    //   70: invokestatic 117	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   73: ldc 119
    //   75: areturn
    //   76: aload_2
    //   77: invokestatic 117	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: invokestatic 117	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   84: aload 4
    //   86: invokevirtual 122	java/io/StringWriter:toString	()Ljava/lang/String;
    //   89: areturn
    //   90: astore_3
    //   91: aload_2
    //   92: invokestatic 117	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   95: aload_0
    //   96: invokestatic 117	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   99: aload_3
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramInputStream	InputStream
    //   29	11	1	i	int
    //   8	84	2	localInputStreamReader	java.io.InputStreamReader
    //   14	24	3	arrayOfChar	char[]
    //   46	12	3	localException	Exception
    //   90	10	3	localObject	Object
    //   22	63	4	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   24	30	46	java/lang/Exception
    //   35	43	46	java/lang/Exception
    //   24	30	90	finally
    //   35	43	90	finally
    //   47	65	90	finally
  }
  
  public static String getVersionName()
  {
    return abP().abC();
  }
  
  public static void mT()
  {
    try
    {
      if (fCX != null) {
        y.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[] { fCX });
      }
      for (;;)
      {
        return;
        if (!ah.abV()) {
          break;
        }
        fCX = WxaCommLibRuntimeReader.b.fDb;
        y.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
      }
      if (ae.cra()) {
        break label79;
      }
    }
    finally {}
    y.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
    throw new AccountNotReadyError();
    for (;;)
    {
      try
      {
        label79:
        if (fCY != null)
        {
          y.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
          Object localObject2 = fCY.get(5L, TimeUnit.SECONDS);
          if (!(localObject2 instanceof WxaPkgWrappingInfo)) {
            break label193;
          }
          localObject2 = (WxaPkgWrappingInfo)localObject2;
          if (!((WxaPkgWrappingInfo)localObject2).fEP) {
            break label180;
          }
          localObject2 = WxaCommLibRuntimeReader.b.fDb;
          fCX = (i)localObject2;
        }
      }
      catch (Throwable localThrowable)
      {
        fCY.cancel(false);
        fCY = null;
        throw localThrowable;
      }
      y.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
      fCY = fCZ.submit(new WxaCommLibRuntimeReader.1());
      continue;
      label180:
      localObject3 = new WxaCommLibRuntimeReader.d(localThrowable, (byte)0);
    }
    label193:
    if ((localObject3 instanceof AccountNotReadyError)) {
      throw ((AccountNotReadyError)localObject3);
    }
    if ((localObject3 instanceof Exception)) {
      throw ((Exception)localObject3);
    }
    if ("Unknown result " + null == localObject3) {}
    for (Object localObject3 = "null";; localObject3 = localObject3.getClass().getName()) {
      throw new IllegalArgumentException((String)localObject3);
    }
  }
  
  private static InputStream qW(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject = abP();
    InputStream localInputStream = ((i)localObject).openRead(paramString);
    localObject = String.format(Locale.US, "[v%d | %d | %s | %b]", new Object[] { Integer.valueOf(((i)localObject).abB().fEN), Integer.valueOf(((i)localObject).abB().fEM), bk.hs(((i)localObject).abB().fEO), Boolean.valueOf(((i)localObject).abB().fEP) });
    if (localInputStream == null) {}
    for (int i = -1;; i = localInputStream.available()) {
      try
      {
        y.i("MicroMsg.WxaCommLibRuntimeReader", "read %s, %s, ret %d", new Object[] { paramString, localObject, Integer.valueOf(i) });
        return localInputStream;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WxaCommLibRuntimeReader", "read %s, %s, e %s", new Object[] { paramString, localObject, localException });
        return localInputStream;
      }
    }
  }
  
  public static String qX(String paramString)
  {
    paramString = qW(paramString);
    if (paramString == null) {
      return "";
    }
    return convertStreamToString(paramString);
  }
  
  public static m qY(String paramString)
  {
    InputStream localInputStream = qW(paramString);
    if (localInputStream == null) {
      return null;
    }
    return new m(s.wK(paramString), "UTF-8", localInputStream);
  }
  
  private static final class AccountNotReadyError
    extends Error
    implements Parcelable
  {
    public static final Parcelable.Creator<AccountNotReadyError> CREATOR = new WxaCommLibRuntimeReader.AccountNotReadyError.1();
    
    AccountNotReadyError() {}
    
    AccountNotReadyError(byte paramByte) {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader
 * JD-Core Version:    0.7.0.1
 */