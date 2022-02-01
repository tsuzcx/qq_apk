package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;
import java.io.InputStream;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

@Deprecated
public final class WxaCommLibRuntimeReader
{
  private static volatile ICommLibReader qFT;
  private static Future<Object> qFU;
  
  static
  {
    AppMethodBeat.i(90587);
    a.b localb = a.b.eqT;
    a.b.a(new WxaCommLibRuntimeReader.1());
    AppMethodBeat.o(90587);
  }
  
  public static ICommLibReader cgA()
  {
    try
    {
      AppMethodBeat.i(90585);
      if (qFT == null) {
        cgy();
      }
      ICommLibReader localICommLibReader = qFT;
      AppMethodBeat.o(90585);
      return localICommLibReader;
    }
    finally {}
  }
  
  public static WxaPkgWrappingInfo cgB()
  {
    AppMethodBeat.i(90586);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)cgA().cfI();
    AppMethodBeat.o(90586);
    return localWxaPkgWrappingInfo;
  }
  
  public static void cgC()
  {
    AppMethodBeat.i(184411);
    Assert.assertTrue(MMApplicationContext.isMainProcess());
    Log.i("MicroMsg.WxaCommLibRuntimeReader", "ensureLibReaderInMainProcess()");
    a locala = new a();
    IPCVoid localIPCVoid = IPCVoid.mzv;
    locala.cgD();
    AppMethodBeat.o(184411);
  }
  
  public static void cgy()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(90583);
      }
      finally
      {
        try
        {
          Log.e("MicroMsg.WxaCommLibRuntimeReader", "loadOrFallback throw %s", new Object[] { localObject1 });
          if (qFT != null) {
            break label95;
          }
          qFT = AssetReader.qDV;
          AppMethodBeat.o(90583);
          continue;
        }
        finally
        {
          if (qFT != null) {
            break label88;
          }
          qFT = AssetReader.qDV;
          AppMethodBeat.o(90583);
        }
        localObject2 = finally;
      }
      try
      {
        fn(false);
        if (qFT == null)
        {
          qFT = AssetReader.qDV;
          AppMethodBeat.o(90583);
          return;
        }
      }
      finally
      {
        localObject1 = finally;
      }
      label88:
      label95:
      AppMethodBeat.o(90583);
    }
  }
  
  public static ICommLibReader cgz()
  {
    return qFT;
  }
  
  /* Error */
  public static boolean f(ICommLibReader paramICommLibReader)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 129
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 59	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:qFT	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   11: ifnull +15 -> 26
    //   14: aload_0
    //   15: getstatic 59	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:qFT	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   18: invokeinterface 133 2 0
    //   23: ifeq +19 -> 42
    //   26: aload_0
    //   27: putstatic 59	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:qFT	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   30: iconst_1
    //   31: istore_1
    //   32: ldc 129
    //   34: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: ldc 2
    //   39: monitorexit
    //   40: iload_1
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_1
    //   44: ldc 129
    //   46: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -12 -> 37
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramICommLibReader	ICommLibReader
    //   31	13	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	26	52	finally
    //   26	30	52	finally
    //   32	37	52	finally
    //   44	49	52	finally
  }
  
  public static void fn(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(320360);
      if (qFT != null)
      {
        Log.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[] { qFT });
        AppMethodBeat.o(320360);
      }
      for (;;)
      {
        return;
        if (!bc.cgI()) {
          break;
        }
        qFT = AssetReader.qDV;
        Log.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
        AppMethodBeat.o(320360);
      }
      if (!MMApplicationContext.isMainProcess()) {
        break label100;
      }
    }
    finally {}
    Object localObject2;
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject2 = new AccountNotReadyError();
      AppMethodBeat.o(320360);
      throw ((Throwable)localObject2);
      label100:
      if (!MMApplicationContext.isMMProcessExist())
      {
        Log.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
        localObject2 = new AccountNotReadyError();
        AppMethodBeat.o(320360);
        throw ((Throwable)localObject2);
      }
    }
    for (;;)
    {
      try
      {
        if (qFU != null)
        {
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(isForPreload:%b), wait for existing retriever", new Object[] { Boolean.valueOf(paramBoolean) });
          localObject2 = qFU;
          if (!paramBoolean) {
            break label260;
          }
          l = 30L;
          localObject2 = ((Future)localObject2).get(l, TimeUnit.SECONDS);
          if (!(localObject2 instanceof ICommLibReader)) {
            break label267;
          }
          localObject2 = (ICommLibReader)localObject2;
          qFT = (ICommLibReader)localObject2;
          AppMethodBeat.o(320360);
          break;
        }
        Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(isForPreload:%b), new retriever", new Object[] { Boolean.valueOf(paramBoolean) });
        qFU = com.tencent.threadpool.h.ahAA.f(new Callable()
        {
          public final Object call()
          {
            AppMethodBeat.i(320366);
            try
            {
              if (MMApplicationContext.isMainProcess())
              {
                localObject = new WxaCommLibRuntimeReader.a();
                IPCVoid localIPCVoid = IPCVoid.mzv;
                localObject = ((WxaCommLibRuntimeReader.a)localObject).cgD();
                AppMethodBeat.o(320366);
                return localObject;
              }
              Object localObject = XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, WxaCommLibRuntimeReader.a.class);
              AppMethodBeat.o(320366);
              return localObject;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", localException, "load() ipc read lib", new Object[0]);
              AppMethodBeat.o(320366);
              return localException;
            }
          }
        });
        continue;
        long l = 5L;
      }
      finally
      {
        qFU.cancel(false);
        qFU = null;
        AppMethodBeat.o(320360);
      }
      label260:
      continue;
      label267:
      if (!(localObject3 instanceof WxaPkgWrappingInfo)) {
        break label285;
      }
      localObject4 = aw.a((WxaPkgWrappingInfo)localObject3);
    }
    label285:
    if ((localObject4 instanceof AccountNotReadyError))
    {
      localObject4 = (AccountNotReadyError)localObject4;
      AppMethodBeat.o(320360);
      throw ((Throwable)localObject4);
    }
    if ((localObject4 instanceof Exception))
    {
      localObject4 = (Exception)localObject4;
      AppMethodBeat.o(320360);
      throw ((Throwable)localObject4);
    }
    if ("Unknown result " + null == localObject4) {}
    for (Object localObject4 = "null";; localObject4 = localObject4.getClass().getName())
    {
      localObject4 = new IllegalArgumentException((String)localObject4);
      AppMethodBeat.o(320360);
      throw ((Throwable)localObject4);
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
    private final WxaPkgWrappingInfo qDU;
    private volatile WxaPkg qFW;
    
    static
    {
      AppMethodBeat.i(184410);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184410);
    }
    
    public PkgReader(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      AppMethodBeat.i(90577);
      this.qDU = paramWxaPkgWrappingInfo;
      AppMethodBeat.o(90577);
    }
    
    private WxaPkg cgE()
    {
      AppMethodBeat.i(320391);
      WxaPkg localWxaPkg;
      if (this.qFW != null)
      {
        localWxaPkg = this.qFW;
        AppMethodBeat.o(320391);
        return localWxaPkg;
      }
      try
      {
        if (this.qFW == null) {
          this.qFW = new WxaPkg(this.qDU.pkgPath());
        }
        localWxaPkg = this.qFW;
        AppMethodBeat.o(320391);
        return localWxaPkg;
      }
      finally
      {
        AppMethodBeat.o(320391);
      }
    }
    
    public final InputStream Lh(String paramString)
    {
      AppMethodBeat.i(90578);
      WxaPkg localWxaPkg = cgE();
      localWxaPkg.cfK();
      paramString = localWxaPkg.Va(paramString);
      AppMethodBeat.o(90578);
      return paramString;
    }
    
    /* Error */
    public final void close()
    {
      // Byte code:
      //   0: ldc 71
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 44	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$PkgReader:qFW	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;
      //   9: astore_2
      //   10: aload_2
      //   11: ifnull +7 -> 18
      //   14: aload_2
      //   15: invokevirtual 73	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
      //   18: aload_0
      //   19: aconst_null
      //   20: putfield 44	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$PkgReader:qFW	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;
      //   23: aload_2
      //   24: ifnull +45 -> 69
      //   27: aload_2
      //   28: invokevirtual 73	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
      //   31: ldc 71
      //   33: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: return
      //   37: astore_1
      //   38: aload_2
      //   39: ifnull +7 -> 46
      //   42: aload_2
      //   43: invokevirtual 73	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
      //   46: ldc 71
      //   48: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   51: aload_1
      //   52: athrow
      //   53: astore_1
      //   54: ldc 71
      //   56: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   59: return
      //   60: astore_2
      //   61: aload_1
      //   62: aload_2
      //   63: invokevirtual 79	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   66: goto -20 -> 46
      //   69: ldc 71
      //   71: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   74: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	PkgReader
      //   37	15	1	localObject1	Object
      //   53	9	1	localObject2	Object
      //   9	34	2	localWxaPkg	WxaPkg
      //   60	3	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   14	18	37	finally
      //   18	23	37	finally
      //   5	10	53	finally
      //   27	36	53	finally
      //   46	53	53	finally
      //   61	66	53	finally
      //   42	46	60	finally
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(90580);
      super.finalize();
      close();
      AppMethodBeat.o(90580);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(90579);
      String str = String.format(Locale.US, "PkgReader[%d] [%s]", new Object[] { Integer.valueOf(this.qDU.pkgVersion), cfD() });
      AppMethodBeat.o(90579);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184409);
      paramParcel.writeParcelable(this.qDU, paramInt);
      AppMethodBeat.o(184409);
    }
  }
  
  static final class a
    implements m<IPCVoid, Object>
  {
    private WxaPkgWrappingInfo ii(boolean paramBoolean)
    {
      AppMethodBeat.i(90575);
      try
      {
        bm localbm = ((e)com.tencent.mm.kernel.h.ax(e.class)).ceo();
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
          bh localbh2 = ay.a((bm)localObject, 0);
          if (localbh2 != null)
          {
            localbh1 = localbh2;
            if (localbh2.field_version == ((bm)localObject).bG("@LibraryAppId", 0)) {}
          }
          else
          {
            com.tencent.threadpool.h.ahAA.g(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(90572);
                if (!com.tencent.mm.kernel.h.baC().mBZ)
                {
                  AppMethodBeat.o(90572);
                  return;
                }
                try
                {
                  ((com.tencent.mm.plugin.appbrand.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.api.b.class)).id(false);
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
          Log.i("MicroMsg.WxaCommLibRuntimeReader", "getLib(%b), record.version:%d, record.md5:%s, embed.version:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(localbh1.field_version), localbh1.field_versionMd5, Integer.valueOf(AssetReader.qDV.cfG()) });
          if ((paramBoolean) && (localbh1.field_version < AssetReader.qDV.cfG()))
          {
            AppMethodBeat.o(90575);
            return null;
            localbh1 = ay.a((bm)localObject, 999);
          }
          else
          {
            localObject = ay.b(localbh1);
            AppMethodBeat.o(90575);
            return localObject;
          }
        }
      }
      AppMethodBeat.o(90575);
      return null;
    }
    
    public final Object cgD()
    {
      localObject5 = null;
      AppMethodBeat.i(90573);
      Object localObject1;
      if (!com.tencent.mm.kernel.h.baC().mBZ)
      {
        localObject1 = new WxaCommLibRuntimeReader.AccountNotReadyError();
        AppMethodBeat.o(90573);
        return localObject1;
      }
      for (;;)
      {
        try
        {
          if (!com.tencent.mm.kernel.h.baC().mBZ)
          {
            localObject3 = null;
            if ((localObject3 == null) || (!((WxaPkgWrappingInfo)localObject3).qHQ)) {
              continue;
            }
            localObject3 = AssetReader.qDV;
            localObject1 = localObject3;
          }
          try
          {
            Log.i("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib use local pkg");
            localObject1 = localObject3;
            Objects.requireNonNull(localObject1);
            av.e((ICommLibReader)localObject1);
            AppMethodBeat.o(90573);
            return localObject1;
          }
          finally
          {
            AssetReader localAssetReader;
            localObject3 = localObject1;
            localObject1 = localObject4;
          }
          localObject3 = ii(false);
          if (localObject3 != null) {
            continue;
          }
          localObject3 = ii(true);
          continue;
          if ((localObject3 != null) && (!TextUtils.isEmpty(((WxaPkgWrappingInfo)localObject3).pkgPath))) {
            continue;
          }
          localAssetReader = AssetReader.qDV;
          localObject1 = localAssetReader;
          Log.e("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib invalid PkgInfo=%s", new Object[] { localObject3 });
        }
        finally
        {
          Object localObject3 = localObject5;
          continue;
        }
        Objects.requireNonNull(localObject3);
        AppMethodBeat.o(90573);
        throw ((Throwable)localObject1);
        localObject1 = new WxaCommLibRuntimeReader.PkgReader((WxaPkgWrappingInfo)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader
 * JD-Core Version:    0.7.0.1
 */