package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class WxaCommLibRuntimeReader
{
  private static n gVn;
  private static Future<Object> gVo;
  private static final ThreadPoolExecutor gVp;
  
  static
  {
    AppMethodBeat.i(59474);
    gVp = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(59474);
  }
  
  /* Error */
  public static void avF()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 53
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 56	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:ph	()V
    //   11: getstatic 58	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:gVn	Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   14: ifnonnull +80 -> 94
    //   17: getstatic 64	com/tencent/mm/plugin/appbrand/appcache/c:gTP	Lcom/tencent/mm/plugin/appbrand/appcache/c;
    //   20: putstatic 58	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:gVn	Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   23: ldc 53
    //   25: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: ldc 66
    //   35: ldc 68
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: getstatic 58	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:gVn	Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   51: ifnonnull +43 -> 94
    //   54: getstatic 64	com/tencent/mm/plugin/appbrand/appcache/c:gTP	Lcom/tencent/mm/plugin/appbrand/appcache/c;
    //   57: putstatic 58	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:gVn	Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   60: ldc 53
    //   62: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -37 -> 28
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: getstatic 58	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:gVn	Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   78: ifnonnull +9 -> 87
    //   81: getstatic 64	com/tencent/mm/plugin/appbrand/appcache/c:gTP	Lcom/tencent/mm/plugin/appbrand/appcache/c;
    //   84: putstatic 58	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:gVn	Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   87: ldc 53
    //   89: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: athrow
    //   94: ldc 53
    //   96: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: goto -71 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	12	0	localThrowable	Throwable
    //   68	5	0	localObject1	Object
    //   74	19	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	11	32	java/lang/Throwable
    //   3	8	68	finally
    //   11	28	68	finally
    //   48	65	68	finally
    //   75	87	68	finally
    //   87	94	68	finally
    //   94	99	68	finally
    //   8	11	74	finally
    //   33	48	74	finally
  }
  
  /* Error */
  public static boolean avG()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 77
    //   7: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 58	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:gVn	Lcom/tencent/mm/plugin/appbrand/appstorage/n;
    //   13: astore_1
    //   14: ldc 66
    //   16: ldc 79
    //   18: iconst_1
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_1
    //   30: ifnull +13 -> 43
    //   33: ldc 77
    //   35: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: ldc 2
    //   40: monitorexit
    //   41: iload_0
    //   42: ireturn
    //   43: ldc 77
    //   45: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_0
    //   49: istore_0
    //   50: goto -12 -> 38
    //   53: astore_1
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	49	0	bool	boolean
    //   13	17	1	localn	n
    //   53	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	29	53	finally
    //   33	38	53	finally
    //   43	48	53	finally
  }
  
  public static n avH()
  {
    try
    {
      AppMethodBeat.i(59467);
      if (gVn == null) {
        avF();
      }
      n localn = gVn;
      AppMethodBeat.o(59467);
      return localn;
    }
    finally {}
  }
  
  public static WxaPkgWrappingInfo avI()
  {
    AppMethodBeat.i(59473);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = avH().ave();
    AppMethodBeat.o(59473);
    return localWxaPkgWrappingInfo;
  }
  
  public static String getVersionName()
  {
    AppMethodBeat.i(59468);
    String str = avH().avc();
    AppMethodBeat.o(59468);
    return str;
  }
  
  public static void ph()
  {
    try
    {
      AppMethodBeat.i(59465);
      if (gVn != null)
      {
        ab.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[] { gVn });
        AppMethodBeat.o(59465);
      }
      for (;;)
      {
        return;
        if (!an.avM()) {
          break;
        }
        gVn = c.gTP;
        ab.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
        AppMethodBeat.o(59465);
      }
      if (ah.dsZ()) {
        break label101;
      }
    }
    finally {}
    ab.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
    Object localObject2 = new AccountNotReadyError();
    AppMethodBeat.o(59465);
    throw ((Throwable)localObject2);
    label212:
    for (;;)
    {
      try
      {
        label101:
        if (gVo != null)
        {
          ab.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
          localObject2 = gVo.get(5L, TimeUnit.SECONDS);
          if (!(localObject2 instanceof WxaPkgWrappingInfo)) {
            break label225;
          }
          localObject2 = (WxaPkgWrappingInfo)localObject2;
          if (!((WxaPkgWrappingInfo)localObject2).gXh) {
            break label212;
          }
          localObject2 = c.gTP;
          gVn = (n)localObject2;
          AppMethodBeat.o(59465);
          break;
        }
        ab.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
        gVo = gVp.submit(new WxaCommLibRuntimeReader.1());
        continue;
        localObject3 = new WxaCommLibRuntimeReader.b(localThrowable, (byte)0);
      }
      catch (Throwable localThrowable)
      {
        gVo.cancel(false);
        gVo = null;
        AppMethodBeat.o(59465);
        throw localThrowable;
      }
    }
    label225:
    if ((localObject3 instanceof AccountNotReadyError))
    {
      localObject3 = (AccountNotReadyError)localObject3;
      AppMethodBeat.o(59465);
      throw ((Throwable)localObject3);
    }
    if ((localObject3 instanceof Exception))
    {
      localObject3 = (Exception)localObject3;
      AppMethodBeat.o(59465);
      throw ((Throwable)localObject3);
    }
    if ("Unknown result " + null == localObject3) {}
    for (Object localObject3 = "null";; localObject3 = localObject3.getClass().getName())
    {
      localObject3 = new IllegalArgumentException((String)localObject3);
      AppMethodBeat.o(59465);
      throw ((Throwable)localObject3);
    }
  }
  
  public static String yt(String paramString)
  {
    AppMethodBeat.i(59470);
    paramString = avH().yl(paramString);
    AppMethodBeat.o(59470);
    return paramString;
  }
  
  static final class AccountNotReadyError
    extends Error
    implements Parcelable
  {
    public static final Parcelable.Creator<AccountNotReadyError> CREATOR;
    
    static
    {
      AppMethodBeat.i(59456);
      CREATOR = new WxaCommLibRuntimeReader.AccountNotReadyError.1();
      AppMethodBeat.o(59456);
    }
    
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