package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

@Deprecated
public final class WxaCommLibRuntimeReader
{
  private static volatile ICommLibReader nGa;
  private static Future<Object> nGb;
  
  /* Error */
  public static boolean b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 30
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 41	com/tencent/mm/plugin/appbrand/appcache/av:a	(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;)Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   12: astore_0
    //   13: getstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   16: ifnull +15 -> 31
    //   19: aload_0
    //   20: getstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   23: invokeinterface 49 2 0
    //   28: ifeq +19 -> 47
    //   31: aload_0
    //   32: putstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   35: iconst_1
    //   36: istore_1
    //   37: ldc 30
    //   39: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: iload_1
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_1
    //   49: ldc 30
    //   51: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static void bHc()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 58
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 61	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:tA	()V
    //   11: getstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   14: ifnonnull +80 -> 94
    //   17: getstatic 67	com/tencent/mm/plugin/appbrand/appcache/AssetReader:nEa	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   20: putstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   23: ldc 58
    //   25: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: ldc 69
    //   35: ldc 71
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: getstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   51: ifnonnull +43 -> 94
    //   54: getstatic 67	com/tencent/mm/plugin/appbrand/appcache/AssetReader:nEa	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   57: putstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   60: ldc 58
    //   62: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -37 -> 28
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: getstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   78: ifnonnull +9 -> 87
    //   81: getstatic 67	com/tencent/mm/plugin/appbrand/appcache/AssetReader:nEa	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   84: putstatic 43	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:nGa	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   87: ldc 58
    //   89: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: athrow
    //   94: ldc 58
    //   96: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static ICommLibReader bHd()
  {
    return nGa;
  }
  
  public static ICommLibReader bHe()
  {
    try
    {
      AppMethodBeat.i(90585);
      if (nGa == null) {
        bHc();
      }
      ICommLibReader localICommLibReader = nGa;
      AppMethodBeat.o(90585);
      return localICommLibReader;
    }
    finally {}
  }
  
  public static void bHf()
  {
    AppMethodBeat.i(184411);
    Assert.assertTrue(MMApplicationContext.isMainProcess());
    Log.i("MicroMsg.WxaCommLibRuntimeReader", "ensureLibReaderInMainProcess()");
    a locala = new a();
    IPCVoid localIPCVoid = IPCVoid.jZu;
    locala.bHg();
    AppMethodBeat.o(184411);
  }
  
  public static void tA()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(90584);
        if (nGa != null)
        {
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[] { nGa });
          AppMethodBeat.o(90584);
          return;
        }
        if (bb.bHl())
        {
          nGa = AssetReader.nEa;
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
        if (nGb != null) {
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
        }
        for (;;)
        {
          localObject2 = nGb.get(5L, TimeUnit.SECONDS);
          if (!(localObject2 instanceof WxaPkgWrappingInfo)) {
            break label204;
          }
          nGa = av.a((WxaPkgWrappingInfo)localObject2);
          AppMethodBeat.o(90584);
          break;
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
          nGb = com.tencent.e.h.ZvG.e(new Callable()
          {
            public final Object call()
            {
              AppMethodBeat.i(90569);
              try
              {
                Object localObject = XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, WxaCommLibRuntimeReader.a.class);
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
          break label223;
        }
      }
      catch (Throwable localThrowable)
      {
        nGb.cancel(false);
        nGb = null;
        AppMethodBeat.o(90584);
        throw localThrowable;
      }
    }
    label204:
    Object localObject3 = (AccountNotReadyError)localThrowable;
    AppMethodBeat.o(90584);
    throw ((Throwable)localObject3);
    label223:
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
    private final WxaPkgWrappingInfo nDZ;
    private final WxaPkg nGd;
    
    static
    {
      AppMethodBeat.i(184410);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184410);
    }
    
    public PkgReader(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      AppMethodBeat.i(90577);
      this.nDZ = paramWxaPkgWrappingInfo;
      this.nGd = new WxaPkg(paramWxaPkgWrappingInfo.pkgPath);
      AppMethodBeat.o(90577);
    }
    
    public final InputStream Tf(String paramString)
    {
      AppMethodBeat.i(90578);
      this.nGd.bGl();
      paramString = this.nGd.acB(paramString);
      AppMethodBeat.o(90578);
      return paramString;
    }
    
    public final void close()
    {
      AppMethodBeat.i(206697);
      try
      {
        this.nGd.close();
        AppMethodBeat.o(206697);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(206697);
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
        this.nGd.close();
        AppMethodBeat.o(90580);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(90580);
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(90579);
      String str = String.format(Locale.US, "PkgReader[%d] [%s]", new Object[] { Integer.valueOf(this.nDZ.pkgVersion), bGg() });
      AppMethodBeat.o(90579);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184409);
      paramParcel.writeParcelable(this.nDZ, paramInt);
      AppMethodBeat.o(184409);
    }
  }
  
  static final class a
    implements m<IPCVoid, Object>
  {
    private WxaPkgWrappingInfo bHh()
    {
      AppMethodBeat.i(90574);
      if (!com.tencent.mm.kernel.h.aHE().kbT)
      {
        AppMethodBeat.o(90574);
        return null;
      }
      WxaPkgWrappingInfo localWxaPkgWrappingInfo = hr(false);
      if (localWxaPkgWrappingInfo != null)
      {
        AppMethodBeat.o(90574);
        return localWxaPkgWrappingInfo;
      }
      localWxaPkgWrappingInfo = hr(true);
      AppMethodBeat.o(90574);
      return localWxaPkgWrappingInfo;
    }
    
    private WxaPkgWrappingInfo hr(boolean paramBoolean)
    {
      AppMethodBeat.i(90575);
      try
      {
        bm localbm = ((e)com.tencent.mm.kernel.h.ae(e.class)).bFb();
        if (localbm == null)
        {
          Log.e("MicroMsg.WxaCommLibRuntimeReader", "getLib(release:%b), NULL == WxaPkgStorage", new Object[] { Boolean.valueOf(paramBoolean) });
          AppMethodBeat.o(90575);
          return null;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        for (;;)
        {
          localObject = null;
        }
        bh localbh1;
        if (paramBoolean)
        {
          bh localbh2 = ax.a((bm)localObject, 0);
          if (localbh2 != null)
          {
            localbh1 = localbh2;
            if (localbh2.field_version == ((bm)localObject).bp("@LibraryAppId", 0)) {}
          }
          else
          {
            com.tencent.e.h.ZvG.d(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(90572);
                if (!com.tencent.mm.kernel.h.aHE().kbT)
                {
                  AppMethodBeat.o(90572);
                  return;
                }
                try
                {
                  ((com.tencent.mm.plugin.appbrand.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.api.b.class)).hm(false);
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
            localbh1 = localbh2;
          }
        }
        while (localbh1 != null)
        {
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "getLib(%b), record.version:%d, record.md5:%s, embed.version:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(localbh1.field_version), localbh1.field_versionMd5, Integer.valueOf(AssetReader.nEa.bGi()) });
          if ((paramBoolean) && (localbh1.field_version < AssetReader.nEa.bGi()))
          {
            AppMethodBeat.o(90575);
            return null;
            localbh1 = ax.a((bm)localObject, 999);
          }
          else
          {
            localObject = ax.b(localbh1);
            AppMethodBeat.o(90575);
            return localObject;
          }
        }
      }
      AppMethodBeat.o(90575);
      return null;
    }
    
    public final Object bHg()
    {
      AppMethodBeat.i(90573);
      Object localObject;
      if (!com.tencent.mm.kernel.h.aHE().kbT)
      {
        localObject = new WxaCommLibRuntimeReader.AccountNotReadyError();
        AppMethodBeat.o(90573);
        return localObject;
      }
      WxaPkgWrappingInfo localWxaPkgWrappingInfo = bHh();
      if ((localWxaPkgWrappingInfo != null) && (localWxaPkgWrappingInfo.nIa))
      {
        localObject = AssetReader.nEa;
        Log.i("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib use local pkg");
      }
      for (;;)
      {
        au.d((ICommLibReader)localObject);
        AppMethodBeat.o(90573);
        return localWxaPkgWrappingInfo;
        if ((localWxaPkgWrappingInfo == null) || (TextUtils.isEmpty(localWxaPkgWrappingInfo.pkgPath)))
        {
          localObject = AssetReader.nEa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader
 * JD-Core Version:    0.7.0.1
 */