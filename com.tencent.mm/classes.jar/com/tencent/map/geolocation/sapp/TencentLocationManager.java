package com.tencent.map.geolocation.sapp;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.j;
import c.t.m.sapp.c.r;
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
  
  /* Error */
  public TencentLocationManager(Context paramContext, Pair<String, String> paramPair)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	java/lang/Object:<init>	()V
    //   4: ldc 41
    //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_0
    //   11: newarray byte
    //   13: putfield 49	com/tencent/map/geolocation/sapp/TencentLocationManager:mLock	[B
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 51	com/tencent/map/geolocation/sapp/TencentLocationManager:mInitStatus	I
    //   21: invokestatic 57	com/tencent/map/geolocation/sapp/TencentLocationManagerOptions:isLoadLibraryEnabled	()Z
    //   24: ifeq +8 -> 32
    //   27: ldc 59
    //   29: invokestatic 65	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: putstatic 67	com/tencent/map/geolocation/sapp/TencentLocationManager:mContext	Landroid/content/Context;
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 72	c/t/m/sapp/c/r:a	(Landroid/content/Context;Landroid/util/Pair;)V
    //   41: aload_1
    //   42: invokestatic 77	c/t/m/sapp/c/e:a	(Landroid/content/Context;)Lc/t/m/sapp/c/e;
    //   45: invokevirtual 80	c/t/m/sapp/c/e:c	()V
    //   48: iconst_0
    //   49: istore_3
    //   50: iload_3
    //   51: iconst_3
    //   52: if_icmpge +69 -> 121
    //   55: aload_2
    //   56: ifnonnull +53 -> 109
    //   59: getstatic 82	com/tencent/map/geolocation/sapp/TencentLocationManager:mPair	Landroid/util/Pair;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +43 -> 109
    //   69: aload_0
    //   70: aload_1
    //   71: aload 5
    //   73: iload_3
    //   74: invokespecial 85	com/tencent/map/geolocation/sapp/TencentLocationManager:a	(Landroid/content/Context;Landroid/util/Pair;I)Z
    //   77: istore 4
    //   79: iload 4
    //   81: ifne +40 -> 121
    //   84: iload_3
    //   85: iconst_1
    //   86: iadd
    //   87: istore_3
    //   88: goto -38 -> 50
    //   91: astore_1
    //   92: ldc 87
    //   94: aload_1
    //   95: invokestatic 92	c/t/m/sapp/c/j:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_0
    //   99: iconst_3
    //   100: putfield 51	com/tencent/map/geolocation/sapp/TencentLocationManager:mInitStatus	I
    //   103: ldc 41
    //   105: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: return
    //   109: aload_0
    //   110: aload_1
    //   111: aload_2
    //   112: iload_3
    //   113: invokespecial 85	com/tencent/map/geolocation/sapp/TencentLocationManager:a	(Landroid/content/Context;Landroid/util/Pair;I)Z
    //   116: istore 4
    //   118: goto -39 -> 79
    //   121: ldc 41
    //   123: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	TencentLocationManager
    //   0	127	1	paramContext	Context
    //   0	127	2	paramPair	Pair<String, String>
    //   49	64	3	i	int
    //   77	40	4	bool	boolean
    //   62	10	5	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   27	32	91	finally
  }
  
  private boolean a(Context paramContext, Pair<String, String> paramPair, int paramInt)
  {
    AppMethodBeat.i(210888);
    if (paramInt > 0)
    {
      r.a(r.c(paramContext));
      r.a(r.h(paramContext));
      r.a();
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
        AppMethodBeat.o(210888);
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
        AppMethodBeat.o(210888);
        return false;
      }
      paramContext = e.b();
    }
    finally
    {
      this.mInitStatus = 5;
      j.a("initLocManager", paramContext);
      e.b().a("LMI", "5" + paramContext.toString());
      AppMethodBeat.o(210888);
      return false;
    }
    paramPair = new StringBuilder();
    paramContext.a("LMI", "0," + paramInt);
    AppMethodBeat.o(210888);
    return true;
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(210895);
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
        AppMethodBeat.o(210895);
        return paramContext;
      }
      paramContext = new NullPointerException("application context is null");
      AppMethodBeat.o(210895);
      throw paramContext;
    }
    finally {}
    label81:
    paramContext = new NullPointerException("context is null");
    AppMethodBeat.o(210895);
    throw paramContext;
  }
  
  public static TencentLocationManager getInstance(Context paramContext, Pair<String, String> paramPair)
  {
    try
    {
      AppMethodBeat.i(210900);
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
        AppMethodBeat.o(210900);
        return paramContext;
      }
      paramContext = new NullPointerException("application context is null");
      AppMethodBeat.o(210900);
      throw paramContext;
    }
    finally {}
    label81:
    paramContext = new NullPointerException("context is null");
    AppMethodBeat.o(210900);
    throw paramContext;
  }
  
  public static boolean isOtherIdIllegal(String paramString)
  {
    AppMethodBeat.i(210910);
    boolean bool = paramString.matches("^[a-z0-9A-Z]{6,32}$");
    AppMethodBeat.o(210910);
    return bool;
  }
  
  public static void setDeviceID(Pair<String, String> paramPair)
  {
    AppMethodBeat.i(210904);
    if (paramPair != null)
    {
      if ((!((String)paramPair.first).equals("qImei")) && (!((String)paramPair.first).equals("oaId")) && (!isOtherIdIllegal((String)paramPair.first)))
      {
        paramPair = new IllegalArgumentException("your deviceID is illegal!");
        AppMethodBeat.o(210904);
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
            }
            catch (Exception paramPair) {}
          }
        }
        else
        {
          mPair = paramPair;
        }
      }
      finally
      {
        label165:
        AppMethodBeat.o(210904);
        return;
      }
    }
    paramPair = new IllegalArgumentException("deviceID is null!");
    AppMethodBeat.o(210904);
    throw paramPair;
  }
  
  public final String getBuild()
  {
    AppMethodBeat.i(210956);
    try
    {
      Object localObject1 = mProxyClass;
      localObject1 = (String)((Class)localObject1).getDeclaredMethod("getBuild", new Class[0]).invoke(mProxyObj, new Object[0]);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(210956);
    }
    return "error";
  }
  
  public final int getCoordinateType()
  {
    AppMethodBeat.i(210919);
    try
    {
      Class localClass = mProxyClass;
      int i = ((Integer)localClass.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(mProxyObj, new Object[0])).intValue();
      return i;
    }
    finally
    {
      AppMethodBeat.o(210919);
    }
    return -1;
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    AppMethodBeat.i(210951);
    try
    {
      Object localObject1 = mProxyClass;
      localObject1 = (TencentLocation)((Class)localObject1).getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(mProxyObj, new Object[0]);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(210951);
    }
    return null;
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(210959);
    try
    {
      Object localObject1 = mProxyClass;
      localObject1 = (String)((Class)localObject1).getDeclaredMethod("getVersion", new Class[0]).invoke(mProxyObj, new Object[0]);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(210959);
    }
    return "error";
  }
  
  public final void removeUpdates(TencentLocationListener paramTencentLocationListener)
  {
    AppMethodBeat.i(210953);
    synchronized (this.mLock)
    {
      Class localClass = mProxyClass;
      localClass.getDeclaredMethod("removeUpdates", new Class[] { TencentLocationListener.class }).invoke(mProxyObj, new Object[] { paramTencentLocationListener });
      e.b().d();
      AppMethodBeat.o(210953);
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    AppMethodBeat.i(210924);
    int i = this.mInitStatus;
    if (i > 0)
    {
      AppMethodBeat.o(210924);
      return i;
    }
    try
    {
      Class localClass = mProxyClass;
      i = ((Integer)localClass.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener })).intValue();
      AppMethodBeat.o(210924);
      return i;
    }
    finally
    {
      j.a("reqLocUpdates error. ", paramTencentLocationRequest);
      AppMethodBeat.o(210924);
    }
    return 5;
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    AppMethodBeat.i(210928);
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
            AppMethodBeat.o(210928);
            return i;
          }
          synchronized (this.mLock)
          {
            Class localClass = mProxyClass;
            paramTencentLocationRequest = (Integer)localClass.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper });
            paramTencentLocationListener = e.b();
            paramTencentLocationListener.a("RLU", paramTencentLocationRequest.toString());
            i = paramTencentLocationRequest.intValue();
            AppMethodBeat.o(210928);
            return i;
          }
        }
        paramTencentLocationRequest = new NullPointerException("looper is null");
        AppMethodBeat.o(210928);
        throw paramTencentLocationRequest;
      }
      paramTencentLocationRequest = new NullPointerException("listener is null");
      AppMethodBeat.o(210928);
      throw paramTencentLocationRequest;
    }
    paramTencentLocationRequest = new NullPointerException("request is null");
    AppMethodBeat.o(210928);
  }
  
  public final int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    AppMethodBeat.i(210940);
    int i = requestSingleFreshLocation(paramTencentLocationRequest, paramTencentLocationListener, paramLooper, false);
    AppMethodBeat.o(210940);
    return i;
  }
  
  public final int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper, boolean paramBoolean)
  {
    AppMethodBeat.i(210934);
    if (paramTencentLocationListener != null)
    {
      if (paramLooper != null)
      {
        int i = this.mInitStatus;
        if (i > 0)
        {
          AppMethodBeat.o(210934);
          return i;
        }
        synchronized (this.mLock)
        {
          Class localClass = mProxyClass;
          i = ((Integer)localClass.getDeclaredMethod("requestSingleFreshLocation", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class, Boolean.TYPE }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper, Boolean.valueOf(paramBoolean) })).intValue();
          AppMethodBeat.o(210934);
          return i;
        }
      }
      paramTencentLocationRequest = new NullPointerException("looper is null");
      AppMethodBeat.o(210934);
      throw paramTencentLocationRequest;
    }
    paramTencentLocationRequest = new NullPointerException("listener is null");
    AppMethodBeat.o(210934);
  }
  
  public final void setCoordinateType(int paramInt)
  {
    AppMethodBeat.i(210915);
    if ((paramInt != 1) && (paramInt != 0)) {
      try
      {
        Object localObject1 = new StringBuilder();
        localObject1 = new IllegalArgumentException("unknown coordinate type: " + paramInt);
        AppMethodBeat.o(210915);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(210915);
        return;
      }
    }
    synchronized (this.mLock)
    {
      Class localClass = mProxyClass;
      localClass.getDeclaredMethod("setCoordinateType", new Class[] { Integer.TYPE }).invoke(mProxyObj, new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(210915);
      return;
    }
  }
  
  public final boolean startIndoorLocation()
  {
    AppMethodBeat.i(210943);
    try
    {
      Class localClass = mProxyClass;
      boolean bool = ((Boolean)localClass.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(210943);
    }
    return false;
  }
  
  public final boolean stopIndoorLocation()
  {
    AppMethodBeat.i(210947);
    try
    {
      Class localClass = mProxyClass;
      boolean bool = ((Boolean)localClass.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(210947);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */