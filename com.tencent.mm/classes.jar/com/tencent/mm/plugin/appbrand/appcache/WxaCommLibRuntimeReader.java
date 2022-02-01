package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

@Deprecated
public final class WxaCommLibRuntimeReader
{
  private static volatile ICommLibReader kMh;
  private static Future<Object> kMi;
  private static final ThreadPoolExecutor kMj;
  
  static
  {
    AppMethodBeat.i(90587);
    kMj = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(90587);
  }
  
  private static ICommLibReader a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(90581);
    if (paramWxaPkgWrappingInfo.kNY)
    {
      paramWxaPkgWrappingInfo = AssetReader.kKj;
      AppMethodBeat.o(90581);
      return paramWxaPkgWrappingInfo;
    }
    paramWxaPkgWrappingInfo = new PkgReader(paramWxaPkgWrappingInfo);
    AppMethodBeat.o(90581);
    return paramWxaPkgWrappingInfo;
  }
  
  /* Error */
  public static boolean b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 80
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 82	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:a	(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;)Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   12: astore_0
    //   13: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   16: ifnull +15 -> 31
    //   19: aload_0
    //   20: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   23: invokeinterface 90 2 0
    //   28: ifeq +19 -> 47
    //   31: aload_0
    //   32: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   35: iconst_1
    //   36: istore_1
    //   37: ldc 80
    //   39: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: iload_1
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_1
    //   49: ldc 80
    //   51: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -12 -> 42
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramWxaPkgWrappingInfo	WxaPkgWrappingInfo
    //   36	13	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	31	57	finally
    //   31	35	57	finally
    //   37	42	57	finally
    //   49	54	57	finally
  }
  
  /* Error */
  public static void bvU()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 94
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 97	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:vC	()V
    //   11: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   14: ifnonnull +80 -> 94
    //   17: getstatic 74	com/tencent/mm/plugin/appbrand/appcache/AssetReader:kKj	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   20: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   23: ldc 94
    //   25: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: ldc 99
    //   35: ldc 101
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   51: ifnonnull +43 -> 94
    //   54: getstatic 74	com/tencent/mm/plugin/appbrand/appcache/AssetReader:kKj	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   57: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   60: ldc 94
    //   62: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -37 -> 28
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   78: ifnonnull +9 -> 87
    //   81: getstatic 74	com/tencent/mm/plugin/appbrand/appcache/AssetReader:kKj	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   84: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:kMh	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   87: ldc 94
    //   89: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: athrow
    //   94: ldc 94
    //   96: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static ICommLibReader bvV()
  {
    return kMh;
  }
  
  public static ICommLibReader bvW()
  {
    try
    {
      AppMethodBeat.i(90585);
      if (kMh == null) {
        bvU();
      }
      ICommLibReader localICommLibReader = kMh;
      AppMethodBeat.o(90585);
      return localICommLibReader;
    }
    finally {}
  }
  
  public static WxaPkgWrappingInfo bvX()
  {
    AppMethodBeat.i(90586);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)bvW().bve();
    AppMethodBeat.o(90586);
    return localWxaPkgWrappingInfo;
  }
  
  public static void bvY()
  {
    AppMethodBeat.i(184411);
    Assert.assertTrue(MMApplicationContext.isMainProcess());
    Log.i("MicroMsg.WxaCommLibRuntimeReader", "ensureLibReaderInMainProcess()");
    a locala = new a();
    IPCVoid localIPCVoid = IPCVoid.hnE;
    locala.bvZ();
    AppMethodBeat.o(184411);
  }
  
  public static void vC()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(90584);
        if (kMh != null)
        {
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[] { kMh });
          AppMethodBeat.o(90584);
          return;
        }
        if (ay.bwe())
        {
          kMh = AssetReader.kKj;
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
          AppMethodBeat.o(90584);
          continue;
        }
        if (MMApplicationContext.isMMProcessExist()) {
          break label101;
        }
      }
      finally {}
      Log.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
      Object localObject2 = new AccountNotReadyError();
      AppMethodBeat.o(90584);
      throw ((Throwable)localObject2);
      try
      {
        label101:
        if (kMi != null) {
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
        }
        for (;;)
        {
          localObject2 = kMi.get(5L, TimeUnit.SECONDS);
          if (!(localObject2 instanceof WxaPkgWrappingInfo)) {
            break label202;
          }
          kMh = a((WxaPkgWrappingInfo)localObject2);
          AppMethodBeat.o(90584);
          break;
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
          kMi = kMj.submit(new Callable()
          {
            public final Object call()
            {
              AppMethodBeat.i(90569);
              try
              {
                Object localObject = XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, WxaCommLibRuntimeReader.a.class);
                AppMethodBeat.o(90569);
                return localObject;
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", localException, "load() ipc read lib", new Object[0]);
                AppMethodBeat.o(90569);
                return localException;
              }
            }
          });
        }
        if (!(localThrowable instanceof AccountNotReadyError)) {
          break label221;
        }
      }
      catch (Throwable localThrowable)
      {
        kMi.cancel(false);
        kMi = null;
        AppMethodBeat.o(90584);
        throw localThrowable;
      }
    }
    label202:
    Object localObject3 = (AccountNotReadyError)localThrowable;
    AppMethodBeat.o(90584);
    throw ((Throwable)localObject3);
    label221:
    if ((localObject3 instanceof Exception))
    {
      localObject3 = (Exception)localObject3;
      AppMethodBeat.o(90584);
      throw ((Throwable)localObject3);
    }
    if ("Unknown result " + null == localObject3) {}
    for (localObject3 = "null";; localObject3 = localObject3.getClass().getName())
    {
      localObject3 = new IllegalArgumentException((String)localObject3);
      AppMethodBeat.o(90584);
      throw ((Throwable)localObject3);
    }
  }
  
  static final class AccountNotReadyError
    extends Error
    implements Parcelable
  {
    public static final Parcelable.Creator<AccountNotReadyError> CREATOR;
    
    static
    {
      AppMethodBeat.i(90571);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(90571);
    }
    
    AccountNotReadyError() {}
    
    AccountNotReadyError(byte paramByte) {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
  
  public static final class PkgReader
    extends AbsReader
  {
    public static final Parcelable.Creator<PkgReader> CREATOR;
    private final WxaPkgWrappingInfo kKi;
    private final WxaPkg kMl;
    
    static
    {
      AppMethodBeat.i(184410);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184410);
    }
    
    public PkgReader(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      AppMethodBeat.i(90577);
      this.kKi = paramWxaPkgWrappingInfo;
      this.kMl = new WxaPkg(paramWxaPkgWrappingInfo.pkgPath);
      AppMethodBeat.o(90577);
    }
    
    public final void close()
    {
      AppMethodBeat.i(230561);
      try
      {
        this.kMl.close();
        AppMethodBeat.o(230561);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(230561);
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(90580);
      super.finalize();
      try
      {
        this.kMl.close();
        AppMethodBeat.o(90580);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(90580);
      }
    }
    
    public final InputStream openRead(String paramString)
    {
      AppMethodBeat.i(90578);
      this.kMl.bvf();
      paramString = this.kMl.UR(paramString);
      AppMethodBeat.o(90578);
      return paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(90579);
      String str = String.format(Locale.US, "PkgReader[%d] [%s]", new Object[] { Integer.valueOf(this.kKi.pkgVersion), bvb() });
      AppMethodBeat.o(90579);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184409);
      paramParcel.writeParcelable(this.kKi, paramInt);
      AppMethodBeat.o(184409);
    }
  }
  
  static final class a
    implements k<IPCVoid, Object>
  {
    private WxaPkgWrappingInfo bwa()
    {
      AppMethodBeat.i(90574);
      if (!g.aAf().hpY)
      {
        AppMethodBeat.o(90574);
        return null;
      }
      WxaPkgWrappingInfo localWxaPkgWrappingInfo = gG(false);
      if (localWxaPkgWrappingInfo != null)
      {
        AppMethodBeat.o(90574);
        return localWxaPkgWrappingInfo;
      }
      localWxaPkgWrappingInfo = gG(true);
      AppMethodBeat.o(90574);
      return localWxaPkgWrappingInfo;
    }
    
    private WxaPkgWrappingInfo gG(boolean paramBoolean)
    {
      AppMethodBeat.i(90575);
      Object localObject = WxaPkgIntegrityChecker.gJ(paramBoolean);
      if ((((Pair)localObject).first == WxaPkgIntegrityChecker.a.kNp) && (((Pair)localObject).second == null) && (!paramBoolean)) {
        h.RTc.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(90572);
            if (!g.aAf().hpY)
            {
              AppMethodBeat.o(90572);
              return;
            }
            try
            {
              ((b)g.af(b.class)).gB(false);
              AppMethodBeat.o(90572);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", localException, "[NOT CRASH]", new Object[0]);
              AppMethodBeat.o(90572);
            }
          }
        }, "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
      }
      if ((((Pair)localObject).second != null) && (((WxaPkgWrappingInfo)((Pair)localObject).second).kNW == 999)) {
        ((WxaPkgWrappingInfo)((Pair)localObject).second).pkgVersion = 0;
      }
      localObject = (WxaPkgWrappingInfo)((Pair)localObject).second;
      AppMethodBeat.o(90575);
      return localObject;
    }
    
    public final Object bvZ()
    {
      AppMethodBeat.i(90573);
      Object localObject;
      if (!g.aAf().hpY)
      {
        localObject = new WxaCommLibRuntimeReader.AccountNotReadyError();
        AppMethodBeat.o(90573);
        return localObject;
      }
      WxaPkgWrappingInfo localWxaPkgWrappingInfo = bwa();
      if ((localWxaPkgWrappingInfo != null) && (localWxaPkgWrappingInfo.kNY))
      {
        localObject = AssetReader.kKj;
        Log.i("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib use local pkg");
      }
      for (;;)
      {
        at.c((ICommLibReader)localObject);
        AppMethodBeat.o(90573);
        return localWxaPkgWrappingInfo;
        if ((localWxaPkgWrappingInfo == null) || (TextUtils.isEmpty(localWxaPkgWrappingInfo.pkgPath)))
        {
          localObject = AssetReader.kKj;
          Log.e("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib invalid PkgInfo=%s", new Object[] { localWxaPkgWrappingInfo });
        }
        else
        {
          localObject = new WxaCommLibRuntimeReader.PkgReader(localWxaPkgWrappingInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader
 * JD-Core Version:    0.7.0.1
 */