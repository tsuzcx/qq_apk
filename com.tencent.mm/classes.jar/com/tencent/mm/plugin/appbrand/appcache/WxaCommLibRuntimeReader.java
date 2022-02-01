package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

@Deprecated
public final class WxaCommLibRuntimeReader
{
  private static volatile ICommLibReader jnl;
  private static Future<Object> jnm;
  private static final ThreadPoolExecutor jnn;
  
  static
  {
    AppMethodBeat.i(90587);
    jnn = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(90587);
  }
  
  private static ICommLibReader a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(90581);
    if (paramWxaPkgWrappingInfo.jpc)
    {
      paramWxaPkgWrappingInfo = AssetReader.jly;
      AppMethodBeat.o(90581);
      return paramWxaPkgWrappingInfo;
    }
    paramWxaPkgWrappingInfo = new PkgReader(paramWxaPkgWrappingInfo);
    AppMethodBeat.o(90581);
    return paramWxaPkgWrappingInfo;
  }
  
  /* Error */
  public static void aWK()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 79
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 82	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:tX	()V
    //   11: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   14: ifnonnull +80 -> 94
    //   17: getstatic 72	com/tencent/mm/plugin/appbrand/appcache/AssetReader:jly	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   20: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   23: ldc 79
    //   25: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: return
    //   32: astore_0
    //   33: ldc 86
    //   35: ldc 88
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   51: ifnonnull +43 -> 94
    //   54: getstatic 72	com/tencent/mm/plugin/appbrand/appcache/AssetReader:jly	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   57: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   60: ldc 79
    //   62: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -37 -> 28
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   78: ifnonnull +9 -> 87
    //   81: getstatic 72	com/tencent/mm/plugin/appbrand/appcache/AssetReader:jly	Lcom/tencent/mm/plugin/appbrand/appcache/AssetReader;
    //   84: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   87: ldc 79
    //   89: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: athrow
    //   94: ldc 79
    //   96: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static ICommLibReader aWL()
  {
    return jnl;
  }
  
  public static ICommLibReader aWM()
  {
    try
    {
      AppMethodBeat.i(90585);
      if (jnl == null) {
        aWK();
      }
      ICommLibReader localICommLibReader = jnl;
      AppMethodBeat.o(90585);
      return localICommLibReader;
    }
    finally {}
  }
  
  public static WxaPkgWrappingInfo aWN()
  {
    AppMethodBeat.i(90586);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)aWM().aVV();
    AppMethodBeat.o(90586);
    return localWxaPkgWrappingInfo;
  }
  
  public static void aWO()
  {
    AppMethodBeat.i(184411);
    Assert.assertTrue(ai.cin());
    ac.i("MicroMsg.WxaCommLibRuntimeReader", "ensureLibReaderInMainProcess()");
    a locala = new a();
    IPCVoid localIPCVoid = IPCVoid.gey;
    locala.aWP();
    AppMethodBeat.o(184411);
  }
  
  /* Error */
  public static boolean b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 144
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 146	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:a	(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;)Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   12: astore_0
    //   13: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   16: ifnull +15 -> 31
    //   19: aload_0
    //   20: getstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   23: invokeinterface 150 2 0
    //   28: ifeq +19 -> 47
    //   31: aload_0
    //   32: putstatic 84	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:jnl	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   35: iconst_1
    //   36: istore_1
    //   37: ldc 144
    //   39: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: iload_1
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_1
    //   49: ldc 144
    //   51: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void tX()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(90584);
        if (jnl != null)
        {
          ac.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", new Object[] { jnl });
          AppMethodBeat.o(90584);
          return;
        }
        if (aw.aWU())
        {
          jnl = AssetReader.jly;
          ac.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
          AppMethodBeat.o(90584);
          continue;
        }
        if (ai.eVi()) {
          break label101;
        }
      }
      finally {}
      ac.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
      Object localObject2 = new AccountNotReadyError();
      AppMethodBeat.o(90584);
      throw ((Throwable)localObject2);
      try
      {
        label101:
        if (jnm != null) {
          ac.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
        }
        for (;;)
        {
          localObject2 = jnm.get(5L, TimeUnit.SECONDS);
          if (!(localObject2 instanceof WxaPkgWrappingInfo)) {
            break label202;
          }
          jnl = a((WxaPkgWrappingInfo)localObject2);
          AppMethodBeat.o(90584);
          break;
          ac.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
          jnm = jnn.submit(new WxaCommLibRuntimeReader.1());
        }
        if (!(localThrowable instanceof AccountNotReadyError)) {
          break label221;
        }
      }
      catch (Throwable localThrowable)
      {
        jnm.cancel(false);
        jnm = null;
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
    private final WxaPkgWrappingInfo jlx;
    private final WxaPkg jnp;
    
    static
    {
      AppMethodBeat.i(184410);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(184410);
    }
    
    public PkgReader(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      AppMethodBeat.i(90577);
      this.jlx = paramWxaPkgWrappingInfo;
      this.jnp = new WxaPkg(paramWxaPkgWrappingInfo.pkgPath);
      AppMethodBeat.o(90577);
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
        this.jnp.close();
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
      this.jnp.aVW();
      paramString = this.jnp.HP(paramString);
      AppMethodBeat.o(90578);
      return paramString;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(90579);
      String str = String.format(Locale.US, "PkgReader[%d] [%s]", new Object[] { Integer.valueOf(this.jlx.pkgVersion), aVS() });
      AppMethodBeat.o(90579);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(184409);
      paramParcel.writeParcelable(this.jlx, paramInt);
      AppMethodBeat.o(184409);
    }
  }
  
  static final class a
    implements k<IPCVoid, Object>
  {
    private WxaPkgWrappingInfo aWQ()
    {
      AppMethodBeat.i(90574);
      if (!g.agP().ggT)
      {
        AppMethodBeat.o(90574);
        return null;
      }
      WxaPkgWrappingInfo localWxaPkgWrappingInfo = fH(false);
      if (localWxaPkgWrappingInfo != null)
      {
        AppMethodBeat.o(90574);
        return localWxaPkgWrappingInfo;
      }
      localWxaPkgWrappingInfo = fH(true);
      AppMethodBeat.o(90574);
      return localWxaPkgWrappingInfo;
    }
    
    private WxaPkgWrappingInfo fH(boolean paramBoolean)
    {
      AppMethodBeat.i(90575);
      Object localObject = WxaPkgIntegrityChecker.fK(paramBoolean);
      if ((((Pair)localObject).first == WxaPkgIntegrityChecker.a.jot) && (((Pair)localObject).second == null) && (!paramBoolean)) {
        h.JZN.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(90572);
            if (!g.agP().ggT)
            {
              AppMethodBeat.o(90572);
              return;
            }
            try
            {
              ((b)g.ab(b.class)).fD(false);
              AppMethodBeat.o(90572);
              return;
            }
            catch (Exception localException)
            {
              ac.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", localException, "[NOT CRASH]", new Object[0]);
              AppMethodBeat.o(90572);
            }
          }
        }, "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
      }
      if ((((Pair)localObject).second != null) && (((WxaPkgWrappingInfo)((Pair)localObject).second).jpa == 999)) {
        ((WxaPkgWrappingInfo)((Pair)localObject).second).pkgVersion = 0;
      }
      localObject = (WxaPkgWrappingInfo)((Pair)localObject).second;
      AppMethodBeat.o(90575);
      return localObject;
    }
    
    public final Object aWP()
    {
      AppMethodBeat.i(90573);
      Object localObject;
      if (!g.agP().ggT)
      {
        localObject = new WxaCommLibRuntimeReader.AccountNotReadyError();
        AppMethodBeat.o(90573);
        return localObject;
      }
      WxaPkgWrappingInfo localWxaPkgWrappingInfo = aWQ();
      if ((localWxaPkgWrappingInfo != null) && (localWxaPkgWrappingInfo.jpc))
      {
        localObject = AssetReader.jly;
        ac.i("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib use local pkg");
      }
      for (;;)
      {
        ar.c((ICommLibReader)localObject);
        AppMethodBeat.o(90573);
        return localWxaPkgWrappingInfo;
        if ((localWxaPkgWrappingInfo == null) || (TextUtils.isEmpty(localWxaPkgWrappingInfo.pkgPath)))
        {
          localObject = AssetReader.jly;
          ac.e("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib invalid PkgInfo=%s", new Object[] { localWxaPkgWrappingInfo });
        }
        else
        {
          localObject = new WxaCommLibRuntimeReader.PkgReader(localWxaPkgWrappingInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader
 * JD-Core Version:    0.7.0.1
 */