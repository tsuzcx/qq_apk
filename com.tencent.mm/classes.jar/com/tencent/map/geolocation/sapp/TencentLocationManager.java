package com.tencent.map.geolocation.sapp;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.j;
import c.t.m.sapp.c.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  public static final boolean DEBUG = false;
  public static final String TAG = "TencentLocationManager";
  public static final String TYPE_OAID = "oaId";
  public static final String TYPE_QIMEI = "qImei";
  public static Context mContext;
  public static Pair<String, String> mPair;
  public static Class mProxyClass;
  public static Object mProxyObj;
  public static TencentLocationManager sInstance;
  public int mInitStatus;
  public final byte[] mLock;
  
  public TencentLocationManager(Context paramContext, Pair<String, String> paramPair)
  {
    AppMethodBeat.i(190552);
    this.mLock = new byte[0];
    this.mInitStatus = 0;
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {}
    for (;;)
    {
      try
      {
        System.loadLibrary("tencentlocsapp");
        mContext = paramContext;
        e.a(paramContext).c();
        int i = 0;
        if (i >= 3) {
          break;
        }
        if (paramPair == null)
        {
          Pair localPair = mPair;
          if (localPair != null)
          {
            bool = a(paramContext, localPair, i);
            if (bool) {
              break;
            }
            i += 1;
            continue;
          }
        }
        boolean bool = a(paramContext, paramPair, i);
      }
      catch (Throwable paramContext)
      {
        j.a("libtencentloc", paramContext);
        this.mInitStatus = 3;
        AppMethodBeat.o(190552);
        return;
      }
    }
    AppMethodBeat.o(190552);
  }
  
  private boolean a(Context paramContext, Pair<String, String> paramPair, int paramInt)
  {
    AppMethodBeat.i(190553);
    if (paramInt > 0)
    {
      q.a(q.d(paramContext));
      q.a(q.i(paramContext));
      q.a();
      f.a(paramContext).c();
    }
    Object localObject = f.a(paramContext);
    try
    {
      localObject = ((f)localObject).a();
      if (localObject == null)
      {
        paramContext = new StringBuilder();
        j.a("class loader is null," + paramInt);
        paramContext = e.b();
        paramContext.a("LMI", "41");
        this.mInitStatus = 4;
        AppMethodBeat.o(190553);
        return false;
      }
      mProxyClass = ((DexClassLoader)localObject).loadClass("com.tencent.map.geolocation.sapp.proxy.TencentLocationManagerProxy");
      if (paramPair != null) {}
      for (mProxyObj = mProxyClass.getConstructor(new Class[] { Context.class, Pair.class }).newInstance(new Object[] { paramContext, paramPair }); mProxyObj == null; mProxyObj = mProxyClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext }))
      {
        this.mInitStatus = 4;
        paramContext = new StringBuilder();
        j.a("Mgr init failed," + paramInt);
        paramContext = e.b();
        paramPair = new StringBuilder();
        paramContext.a("LMI", "42," + paramInt);
        AppMethodBeat.o(190553);
        return false;
      }
      paramContext = e.b();
    }
    catch (Throwable paramContext)
    {
      this.mInitStatus = 5;
      j.a("initLocManager", paramContext);
      e.b().a("LMI", "5" + paramContext.toString());
      AppMethodBeat.o(190553);
      return false;
    }
    paramPair = new StringBuilder();
    paramContext.a("LMI", "0," + paramInt);
    AppMethodBeat.o(190553);
    return true;
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(190554);
      if (sInstance == null)
      {
        if (paramContext == null) {
          break label81;
        }
        if (paramContext.getApplicationContext() != null)
        {
          System.currentTimeMillis();
          sInstance = new TencentLocationManager(paramContext.getApplicationContext(), null);
        }
      }
      else
      {
        paramContext = sInstance;
        AppMethodBeat.o(190554);
        return paramContext;
      }
      paramContext = new NullPointerException("application context is null");
      AppMethodBeat.o(190554);
      throw paramContext;
    }
    finally {}
    label81:
    paramContext = new NullPointerException("context is null");
    AppMethodBeat.o(190554);
    throw paramContext;
  }
  
  public static TencentLocationManager getInstance(Context paramContext, Pair<String, String> paramPair)
  {
    try
    {
      AppMethodBeat.i(190555);
      if (sInstance == null)
      {
        if (paramContext == null) {
          break label81;
        }
        if (paramContext.getApplicationContext() != null)
        {
          System.currentTimeMillis();
          sInstance = new TencentLocationManager(paramContext.getApplicationContext(), paramPair);
        }
      }
      else
      {
        paramContext = sInstance;
        AppMethodBeat.o(190555);
        return paramContext;
      }
      paramContext = new NullPointerException("application context is null");
      AppMethodBeat.o(190555);
      throw paramContext;
    }
    finally {}
    label81:
    paramContext = new NullPointerException("context is null");
    AppMethodBeat.o(190555);
    throw paramContext;
  }
  
  public static boolean isOtherIdIllegal(String paramString)
  {
    AppMethodBeat.i(190557);
    boolean bool = paramString.matches("^[a-z0-9A-Z]{6,32}$");
    AppMethodBeat.o(190557);
    return bool;
  }
  
  public static void setDeviceID(Pair<String, String> paramPair)
  {
    AppMethodBeat.i(190556);
    if (paramPair != null)
    {
      if ((!((String)paramPair.first).equals("qImei")) && (!((String)paramPair.first).equals("oaId")) && (!isOtherIdIllegal((String)paramPair.first)))
      {
        paramPair = new IllegalArgumentException("your deviceID is illegal!");
        AppMethodBeat.o(190556);
        throw paramPair;
      }
      try
      {
        if (mContext != null)
        {
          Object localObject = mProxyClass;
          if (localObject != null) {
            try
            {
              localObject = mProxyClass;
              localObject = ((Class)localObject).getDeclaredMethod("uploadLimeiInfo", new Class[] { Context.class, Pair.class });
              ((Method)localObject).setAccessible(true);
              if (mProxyObj == null) {
                break label165;
              }
              ((Method)localObject).invoke(mProxyObj, new Object[] { mContext, paramPair });
              AppMethodBeat.o(190556);
              return;
            }
            catch (Exception paramPair)
            {
              AppMethodBeat.o(190556);
              return;
            }
          }
        }
        else
        {
          mPair = paramPair;
          AppMethodBeat.o(190556);
          return;
        }
      }
      catch (Throwable paramPair)
      {
        label165:
        AppMethodBeat.o(190556);
        return;
      }
    }
    paramPair = new IllegalArgumentException("deviceID is null!");
    AppMethodBeat.o(190556);
    throw paramPair;
  }
  
  public final String getBuild()
  {
    AppMethodBeat.i(190568);
    try
    {
      Object localObject = mProxyClass;
      localObject = (String)((Class)localObject).getDeclaredMethod("getBuild", new Class[0]).invoke(mProxyObj, new Object[0]);
      AppMethodBeat.o(190568);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190568);
    }
    return "error";
  }
  
  public final int getCoordinateType()
  {
    AppMethodBeat.i(190559);
    try
    {
      Class localClass = mProxyClass;
      int i = ((Integer)localClass.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(mProxyObj, new Object[0])).intValue();
      AppMethodBeat.o(190559);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190559);
    }
    return -1;
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    AppMethodBeat.i(190566);
    try
    {
      Object localObject = mProxyClass;
      localObject = (TencentLocation)((Class)localObject).getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(mProxyObj, new Object[0]);
      AppMethodBeat.o(190566);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190566);
    }
    return null;
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(190569);
    try
    {
      Object localObject = mProxyClass;
      localObject = (String)((Class)localObject).getDeclaredMethod("getVersion", new Class[0]).invoke(mProxyObj, new Object[0]);
      AppMethodBeat.o(190569);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190569);
    }
    return "error";
  }
  
  /* Error */
  public final void removeUpdates(TencentLocationListener paramTencentLocationListener)
  {
    // Byte code:
    //   0: ldc_w 288
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 51	com/tencent/map/geolocation/sapp/TencentLocationManager:mLock	[B
    //   10: astore_2
    //   11: aload_2
    //   12: monitorenter
    //   13: getstatic 158	com/tencent/map/geolocation/sapp/TencentLocationManager:mProxyClass	Ljava/lang/Class;
    //   16: astore_3
    //   17: aload_3
    //   18: ldc_w 289
    //   21: iconst_1
    //   22: anewarray 160	java/lang/Class
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 291
    //   30: aastore
    //   31: invokevirtual 249	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: getstatic 176	com/tencent/map/geolocation/sapp/TencentLocationManager:mProxyObj	Ljava/lang/Object;
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: aastore
    //   45: invokevirtual 259	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   48: pop
    //   49: invokestatic 141	c/t/m/sapp/c/e:b	()Lc/t/m/sapp/c/e;
    //   52: invokevirtual 293	c/t/m/sapp/c/e:d	()V
    //   55: aload_2
    //   56: monitorexit
    //   57: ldc_w 288
    //   60: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_1
    //   65: aload_2
    //   66: monitorexit
    //   67: ldc_w 288
    //   70: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: goto -21 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	TencentLocationManager
    //   0	79	1	paramTencentLocationListener	TencentLocationListener
    //   16	2	3	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   13	17	64	finally
    //   17	55	64	finally
    //   55	57	64	finally
    //   65	67	64	finally
    //   13	17	75	java/lang/Throwable
    //   17	55	75	java/lang/Throwable
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    AppMethodBeat.i(190560);
    int i = this.mInitStatus;
    if (i > 0)
    {
      AppMethodBeat.o(190560);
      return i;
    }
    try
    {
      Class localClass = mProxyClass;
      i = ((Integer)localClass.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener })).intValue();
      AppMethodBeat.o(190560);
      return i;
    }
    catch (Throwable paramTencentLocationRequest)
    {
      j.a("reqLocUpdates error. ", paramTencentLocationRequest);
      AppMethodBeat.o(190560);
    }
    return 5;
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    AppMethodBeat.i(190561);
    System.currentTimeMillis();
    if (paramTencentLocationRequest != null)
    {
      if (paramTencentLocationListener != null)
      {
        if (paramLooper != null)
        {
          int i = this.mInitStatus;
          if (i > 0)
          {
            AppMethodBeat.o(190561);
            return i;
          }
          synchronized (this.mLock)
          {
            try
            {
              Class localClass = mProxyClass;
              paramTencentLocationRequest = (Integer)localClass.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper });
              paramTencentLocationListener = e.b();
              paramTencentLocationListener.a("RLU", paramTencentLocationRequest.toString());
              i = paramTencentLocationRequest.intValue();
              AppMethodBeat.o(190561);
              return i;
            }
            catch (Throwable paramTencentLocationRequest)
            {
              paramTencentLocationListener = e.b();
              paramLooper = new StringBuilder();
              paramTencentLocationListener.a("RLU", "5," + paramTencentLocationRequest.toString());
              j.a("reqLocUpdates looper error. ", paramTencentLocationRequest);
              AppMethodBeat.o(190561);
              return 5;
            }
          }
        }
        paramTencentLocationRequest = new NullPointerException("looper is null");
        AppMethodBeat.o(190561);
        throw paramTencentLocationRequest;
      }
      paramTencentLocationRequest = new NullPointerException("listener is null");
      AppMethodBeat.o(190561);
      throw paramTencentLocationRequest;
    }
    paramTencentLocationRequest = new NullPointerException("request is null");
    AppMethodBeat.o(190561);
  }
  
  public final int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    AppMethodBeat.i(190563);
    int i = requestSingleFreshLocation(paramTencentLocationRequest, paramTencentLocationListener, paramLooper, false);
    AppMethodBeat.o(190563);
    return i;
  }
  
  public final int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper, boolean paramBoolean)
  {
    AppMethodBeat.i(190562);
    if (paramTencentLocationListener != null)
    {
      if (paramLooper != null)
      {
        int i = this.mInitStatus;
        if (i > 0)
        {
          AppMethodBeat.o(190562);
          return i;
        }
        synchronized (this.mLock)
        {
          try
          {
            Class localClass = mProxyClass;
            i = ((Integer)localClass.getDeclaredMethod("requestSingleFreshLocation", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class, Boolean.TYPE }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper, Boolean.valueOf(paramBoolean) })).intValue();
            AppMethodBeat.o(190562);
            return i;
          }
          catch (Throwable paramTencentLocationRequest)
          {
            j.a("reqSigLoc error. ", paramTencentLocationRequest);
            AppMethodBeat.o(190562);
            return 5;
          }
        }
      }
      paramTencentLocationRequest = new NullPointerException("looper is null");
      AppMethodBeat.o(190562);
      throw paramTencentLocationRequest;
    }
    paramTencentLocationRequest = new NullPointerException("listener is null");
    AppMethodBeat.o(190562);
  }
  
  /* Error */
  public final void setCoordinateType(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 338
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: iconst_1
    //   8: if_icmpeq +53 -> 61
    //   11: iload_1
    //   12: ifeq +49 -> 61
    //   15: new 121	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   22: astore_2
    //   23: new 240	java/lang/IllegalArgumentException
    //   26: dup
    //   27: aload_2
    //   28: ldc_w 340
    //   31: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 243	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: ldc_w 338
    //   48: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_2
    //   52: athrow
    //   53: astore_2
    //   54: ldc_w 338
    //   57: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: aload_0
    //   62: getfield 51	com/tencent/map/geolocation/sapp/TencentLocationManager:mLock	[B
    //   65: astore_2
    //   66: aload_2
    //   67: monitorenter
    //   68: getstatic 158	com/tencent/map/geolocation/sapp/TencentLocationManager:mProxyClass	Ljava/lang/Class;
    //   71: astore_3
    //   72: aload_3
    //   73: ldc_w 341
    //   76: iconst_1
    //   77: anewarray 160	java/lang/Class
    //   80: dup
    //   81: iconst_0
    //   82: getstatic 342	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   85: aastore
    //   86: invokevirtual 249	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   89: getstatic 176	com/tencent/map/geolocation/sapp/TencentLocationManager:mProxyObj	Ljava/lang/Object;
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: iload_1
    //   99: invokestatic 345	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokevirtual 259	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload_2
    //   108: monitorexit
    //   109: ldc_w 338
    //   112: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: astore_3
    //   117: aload_2
    //   118: monitorexit
    //   119: ldc_w 338
    //   122: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_3
    //   126: athrow
    //   127: astore_3
    //   128: goto -21 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	TencentLocationManager
    //   0	131	1	paramInt	int
    //   22	30	2	localObject1	Object
    //   53	1	2	localException	Exception
    //   71	2	3	localClass	Class
    //   116	10	3	localObject2	Object
    //   127	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   15	23	53	java/lang/Exception
    //   23	53	53	java/lang/Exception
    //   61	68	53	java/lang/Exception
    //   119	127	53	java/lang/Exception
    //   68	72	116	finally
    //   72	107	116	finally
    //   107	115	116	finally
    //   117	119	116	finally
    //   68	72	127	java/lang/Throwable
    //   72	107	127	java/lang/Throwable
  }
  
  public final boolean startIndoorLocation()
  {
    AppMethodBeat.i(190564);
    try
    {
      Class localClass = mProxyClass;
      boolean bool = ((Boolean)localClass.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
      AppMethodBeat.o(190564);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190564);
    }
    return false;
  }
  
  public final boolean stopIndoorLocation()
  {
    AppMethodBeat.i(190565);
    try
    {
      Class localClass = mProxyClass;
      boolean bool = ((Boolean)localClass.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
      AppMethodBeat.o(190565);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190565);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */