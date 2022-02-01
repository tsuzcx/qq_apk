package com.tencent.map.geolocation.sapp.internal;

import android.content.Context;
import android.location.Location;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.j;
import c.t.m.sapp.c.r;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class TencentExtraKeys
{
  public static final boolean ALLOW_NLP_LOCATION = true;
  public static final boolean DIDI_INTERNAL = false;
  public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
  public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
  public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
  public static final String LOCATION_KEY_LOCALITY = "locality";
  public static final String LOCATION_KEY_NATION = "nation";
  public static final String LOCATION_KEY_ROUTE = "route";
  public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
  public static final String LOCATION_SOURCE_CELL = "cell";
  public static final String LOCATION_SOURCE_GPS = "gps";
  public static final String LOCATION_SOURCE_WIFI = "wifi";
  public static final String RAW_DATA = "raw_data";
  public static final String REQUEST_RAW_DATA = "request_raw_data";
  public static final boolean STRICT_CELL_FILTER = true;
  public static final String TAG = "TencentExtraKeys";
  public static final boolean TENCENT_INTERNAL = true;
  public static Context mContext;
  public static DexClassLoader mLoader;
  public static Object mProxyObj;
  public static Class mProxyclass;
  
  public static boolean a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(210909);
    if (paramInt > 0) {}
    try
    {
      r.a(r.c(paramContext));
      r.a(r.h(paramContext));
      r.a();
      f.a(paramContext).c();
      paramContext = f.a(paramContext).a();
      if (paramContext == null)
      {
        j.a("EKS,loader is null");
        paramContext = e.b();
        localObject = new StringBuilder();
        paramContext.a("EKS", "init error 2," + paramInt);
        AppMethodBeat.o(210909);
        return false;
      }
      if (mProxyclass != null)
      {
        localObject = mProxyObj;
        if (localObject != null) {}
      }
      else
      {
        paramContext = paramContext.loadClass("com.tencent.map.geolocation.sapp.proxy.TencentExtraKeysProxy");
        mProxyclass = paramContext;
        mProxyObj = paramContext.newInstance();
      }
      paramContext = e.b();
      Object localObject = new StringBuilder();
      paramContext.a("EKS", "init ok 0," + paramInt);
      AppMethodBeat.o(210909);
      return true;
    }
    finally
    {
      e.b().a("EKS", "init error 3," + paramInt + "," + paramContext.toString());
      AppMethodBeat.o(210909);
    }
    return false;
  }
  
  public static void enableMockLocationFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(210916);
    Exception localException;
    try
    {
      if (initProxy())
      {
        localObject1 = mProxyclass;
        ((Class)localObject1).getDeclaredMethod("enableMockLocationFilter", new Class[] { Boolean.TYPE }).invoke(mProxyObj, new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(210916);
        return;
      }
      Object localObject1 = new Exception("proxy is error");
      AppMethodBeat.o(210916);
      throw ((Throwable)localObject1);
    }
    finally
    {
      localException = new Exception(localObject2.toString());
      AppMethodBeat.o(210916);
    }
  }
  
  public static String getLocationSource(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(210972);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        paramTencentLocation = (String)localClass.getDeclaredMethod("getLocationSource", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
        AppMethodBeat.o(210972);
        return paramTencentLocation;
      }
      paramTencentLocation = new Exception("proxy is error");
      AppMethodBeat.o(210972);
      throw paramTencentLocation;
    }
    finally
    {
      paramTencentLocation = new Exception(paramTencentLocation.toString());
      AppMethodBeat.o(210972);
    }
  }
  
  /* Error */
  public static File getLogDir()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 206
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 170	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:initProxy	()Z
    //   11: ifeq +41 -> 52
    //   14: getstatic 136	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyclass	Ljava/lang/Class;
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 207
    //   21: iconst_0
    //   22: anewarray 148	java/lang/Class
    //   25: invokevirtual 180	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: getstatic 138	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyObj	Ljava/lang/Object;
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokevirtual 190	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 209	java/io/File
    //   41: astore_0
    //   42: ldc 206
    //   44: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: new 192	java/lang/Exception
    //   55: dup
    //   56: ldc 194
    //   58: invokespecial 195	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: ldc 206
    //   64: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: athrow
    //   69: astore_0
    //   70: new 192	java/lang/Exception
    //   73: dup
    //   74: aload_0
    //   75: invokevirtual 163	java/lang/Throwable:toString	()Ljava/lang/String;
    //   78: invokespecial 195	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   81: astore_0
    //   82: ldc 206
    //   84: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_0
    //   88: athrow
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	51	0	localObject1	Object
    //   69	6	0	localObject2	Object
    //   81	7	0	localException	Exception
    //   89	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	18	69	finally
    //   18	42	69	finally
    //   52	69	69	finally
    //   3	8	89	finally
    //   42	47	89	finally
    //   70	89	89	finally
  }
  
  public static byte[] getRawData(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(210923);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        paramTencentLocation = (byte[])localClass.getDeclaredMethod("getRawData", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
        AppMethodBeat.o(210923);
        return paramTencentLocation;
      }
      paramTencentLocation = new Exception("proxy is error");
      AppMethodBeat.o(210923);
      throw paramTencentLocation;
    }
    finally
    {
      paramTencentLocation = new Exception(paramTencentLocation.toString());
      AppMethodBeat.o(210923);
    }
  }
  
  public static Location getRawGps(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(210950);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        paramTencentLocation = (Location)localClass.getDeclaredMethod("getRawGps", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
        AppMethodBeat.o(210950);
        return paramTencentLocation;
      }
      paramTencentLocation = new Exception("proxy is error");
      AppMethodBeat.o(210950);
      throw paramTencentLocation;
    }
    finally
    {
      paramTencentLocation = new Exception(paramTencentLocation.toString());
      AppMethodBeat.o(210950);
    }
  }
  
  public static String getRawQuery(TencentLocation paramTencentLocation)
  {
    AppMethodBeat.i(210938);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        paramTencentLocation = (String)localClass.getDeclaredMethod("getRawQuery", new Class[] { TencentLocation.class }).invoke(mProxyObj, new Object[] { paramTencentLocation });
        AppMethodBeat.o(210938);
        return paramTencentLocation;
      }
      paramTencentLocation = new Exception("proxy is error");
      AppMethodBeat.o(210938);
      throw paramTencentLocation;
    }
    finally
    {
      paramTencentLocation = new Exception(paramTencentLocation.toString());
      AppMethodBeat.o(210938);
    }
  }
  
  public static boolean initProxy()
  {
    AppMethodBeat.i(210896);
    if (mContext == null)
    {
      AppMethodBeat.o(210896);
      return false;
    }
    int i = 0;
    while (i < 3)
    {
      if (a(mContext, i))
      {
        AppMethodBeat.o(210896);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(210896);
    return false;
  }
  
  public static boolean isAllowedLevel(int paramInt)
  {
    AppMethodBeat.i(210967);
    Exception localException;
    try
    {
      if (initProxy())
      {
        localObject1 = mProxyclass;
        boolean bool = ((Boolean)((Class)localObject1).getDeclaredMethod("isAllowedLevel", new Class[] { Integer.TYPE }).invoke(mProxyObj, new Object[] { Integer.valueOf(paramInt) })).booleanValue();
        AppMethodBeat.o(210967);
        return bool;
      }
      Object localObject1 = new Exception("proxy is error");
      AppMethodBeat.o(210967);
      throw ((Throwable)localObject1);
    }
    finally
    {
      localException = new Exception(localObject2.toString());
      AppMethodBeat.o(210967);
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean isDebugEnabled()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 245
    //   5: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 170	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:initProxy	()Z
    //   11: ifeq +44 -> 55
    //   14: getstatic 136	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyclass	Ljava/lang/Class;
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 246
    //   21: iconst_0
    //   22: anewarray 148	java/lang/Class
    //   25: invokevirtual 180	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: getstatic 138	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyObj	Ljava/lang/Object;
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokevirtual 190	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 173	java/lang/Boolean
    //   41: invokevirtual 242	java/lang/Boolean:booleanValue	()Z
    //   44: istore_0
    //   45: ldc 245
    //   47: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: ldc 2
    //   52: monitorexit
    //   53: iload_0
    //   54: ireturn
    //   55: new 192	java/lang/Exception
    //   58: dup
    //   59: ldc 194
    //   61: invokespecial 195	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   64: astore_1
    //   65: ldc 245
    //   67: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: new 192	java/lang/Exception
    //   76: dup
    //   77: aload_1
    //   78: invokevirtual 163	java/lang/Throwable:toString	()Ljava/lang/String;
    //   81: invokespecial 195	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   84: astore_1
    //   85: ldc 245
    //   87: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	10	0	bool	boolean
    //   17	54	1	localObject1	Object
    //   72	6	1	localObject2	Object
    //   84	7	1	localException	Exception
    //   92	5	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	18	72	finally
    //   18	45	72	finally
    //   55	72	72	finally
    //   3	8	92	finally
    //   45	50	92	finally
    //   73	92	92	finally
  }
  
  public static int isInsIllegalApp(Context paramContext)
  {
    AppMethodBeat.i(210970);
    try
    {
      mContext = paramContext;
      if (initProxy())
      {
        Class localClass = mProxyclass;
        int i = ((Integer)localClass.getDeclaredMethod("isInsIllegalApp", new Class[] { Context.class }).invoke(mProxyObj, new Object[] { paramContext })).intValue();
        AppMethodBeat.o(210970);
        return i;
      }
      paramContext = new Exception("proxy is error");
      AppMethodBeat.o(210970);
      throw paramContext;
    }
    finally
    {
      paramContext = new Exception(paramContext.toString());
      AppMethodBeat.o(210970);
    }
  }
  
  public static boolean isRequestRawData(TencentLocationRequest paramTencentLocationRequest)
  {
    AppMethodBeat.i(210963);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        boolean bool = ((Boolean)localClass.getDeclaredMethod("isRequestRawData", new Class[] { TencentLocationRequest.class }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest })).booleanValue();
        AppMethodBeat.o(210963);
        return bool;
      }
      paramTencentLocationRequest = new Exception("proxy is error");
      AppMethodBeat.o(210963);
      throw paramTencentLocationRequest;
    }
    finally
    {
      paramTencentLocationRequest = new Exception(paramTencentLocationRequest.toString());
      AppMethodBeat.o(210963);
    }
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(210975);
    try
    {
      System.load(paramString);
      AppMethodBeat.o(210975);
      return;
    }
    finally
    {
      paramString = new Exception(paramString.toString());
      AppMethodBeat.o(210975);
    }
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(210890);
    mContext = paramContext;
    e.a(paramContext).c();
    AppMethodBeat.o(210890);
  }
  
  /* Error */
  public static void setLogDir(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 280
    //   6: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 170	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:initProxy	()Z
    //   12: ifeq +48 -> 60
    //   15: getstatic 136	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyclass	Ljava/lang/Class;
    //   18: astore_1
    //   19: aload_1
    //   20: ldc_w 281
    //   23: iconst_1
    //   24: anewarray 148	java/lang/Class
    //   27: dup
    //   28: iconst_0
    //   29: ldc 209
    //   31: aastore
    //   32: invokevirtual 180	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   35: getstatic 138	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:mProxyObj	Ljava/lang/Object;
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: aastore
    //   46: invokevirtual 190	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: ldc_w 280
    //   53: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: ldc 2
    //   58: monitorexit
    //   59: return
    //   60: new 192	java/lang/Exception
    //   63: dup
    //   64: ldc 194
    //   66: invokespecial 195	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   69: astore_0
    //   70: ldc_w 280
    //   73: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_0
    //   79: new 192	java/lang/Exception
    //   82: dup
    //   83: aload_0
    //   84: invokevirtual 163	java/lang/Throwable:toString	()Ljava/lang/String;
    //   87: invokespecial 195	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   90: astore_0
    //   91: ldc_w 280
    //   94: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   18	2	1	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   9	19	78	finally
    //   19	50	78	finally
    //   60	78	78	finally
    //   3	9	99	finally
    //   50	56	99	finally
    //   79	99	99	finally
  }
  
  public static TencentLocation setRawData(TencentLocation paramTencentLocation, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210929);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        paramTencentLocation = (TencentLocation)localClass.getDeclaredMethod("setRawData", new Class[] { TencentLocation.class, [B.class }).invoke(mProxyObj, new Object[] { paramTencentLocation, paramArrayOfByte });
        AppMethodBeat.o(210929);
        return paramTencentLocation;
      }
      paramTencentLocation = new Exception("proxy is error");
      AppMethodBeat.o(210929);
      throw paramTencentLocation;
    }
    finally
    {
      paramTencentLocation = new Exception(paramTencentLocation.toString());
      AppMethodBeat.o(210929);
    }
  }
  
  public static void setRawGps(TencentLocation paramTencentLocation, Location paramLocation)
  {
    AppMethodBeat.i(210954);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setRawGps", new Class[] { TencentLocation.class, Location.class }).invoke(mProxyObj, new Object[] { paramTencentLocation, paramLocation });
        AppMethodBeat.o(210954);
        return;
      }
      paramTencentLocation = new Exception("proxy is error");
      AppMethodBeat.o(210954);
      throw paramTencentLocation;
    }
    finally
    {
      paramTencentLocation = new Exception(paramTencentLocation.toString());
      AppMethodBeat.o(210954);
    }
  }
  
  public static void setRawQuery(TencentLocation paramTencentLocation, String paramString)
  {
    AppMethodBeat.i(210945);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setRawQuery", new Class[] { TencentLocation.class, String.class }).invoke(mProxyObj, new Object[] { paramTencentLocation, paramString });
        AppMethodBeat.o(210945);
        return;
      }
      paramTencentLocation = new Exception("proxy is error");
      AppMethodBeat.o(210945);
      throw paramTencentLocation;
    }
    finally
    {
      paramTencentLocation = new Exception(paramTencentLocation.toString());
      AppMethodBeat.o(210945);
    }
  }
  
  public static TencentLocationRequest setRequestRawData(TencentLocationRequest paramTencentLocationRequest, boolean paramBoolean)
  {
    AppMethodBeat.i(210961);
    try
    {
      if (initProxy())
      {
        Class localClass = mProxyclass;
        paramTencentLocationRequest = (TencentLocationRequest)localClass.getDeclaredMethod("setRequestRawData", new Class[] { TencentLocationRequest.class, Boolean.TYPE }).invoke(mProxyObj, new Object[] { paramTencentLocationRequest, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(210961);
        return paramTencentLocationRequest;
      }
      paramTencentLocationRequest = new Exception("proxy is error");
      AppMethodBeat.o(210961);
      throw paramTencentLocationRequest;
    }
    finally
    {
      paramTencentLocationRequest = new Exception(paramTencentLocationRequest.toString());
      AppMethodBeat.o(210961);
    }
  }
  
  public static void setTencentLog(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(210977);
    try
    {
      mContext = paramContext;
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setTencentLog", new Class[] { Context.class, File.class }).invoke(mProxyObj, new Object[] { paramContext, paramFile });
        AppMethodBeat.o(210977);
        return;
      }
      paramContext = new Exception("proxy is error");
      AppMethodBeat.o(210977);
      throw paramContext;
    }
    finally
    {
      paramContext = new Exception(paramContext.toString());
      AppMethodBeat.o(210977);
    }
  }
  
  public static void setTencentLogCallback(LocationLogCallback paramLocationLogCallback)
  {
    AppMethodBeat.i(210979);
    try
    {
      j.a(paramLocationLogCallback);
      if (initProxy())
      {
        Class localClass = mProxyclass;
        localClass.getDeclaredMethod("setTencentLogCallback", new Class[] { LocationLogCallback.class }).invoke(mProxyObj, new Object[] { paramLocationLogCallback });
        AppMethodBeat.o(210979);
        return;
      }
      paramLocationLogCallback = new Exception("proxy is error");
      AppMethodBeat.o(210979);
      throw paramLocationLogCallback;
    }
    finally
    {
      paramLocationLogCallback = new Exception(paramLocationLogCallback.toString());
      AppMethodBeat.o(210979);
    }
  }
  
  public static boolean wgs84ToGcj02(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(211007);
    try
    {
      boolean bool = TencentLocationManagerOptions.isLoadLibraryEnabled();
      if (bool) {}
      try
      {
        System.loadLibrary("tencentlocsapp");
        if (initProxy())
        {
          Class localClass = mProxyclass;
          bool = ((Boolean)localClass.getDeclaredMethod("wgs84ToGcj02", new Class[] { [D.class, [D.class }).invoke(mProxyObj, new Object[] { paramArrayOfDouble1, paramArrayOfDouble2 })).booleanValue();
          AppMethodBeat.o(211007);
          return bool;
        }
      }
      finally
      {
        paramArrayOfDouble2 = new StringBuilder();
        paramArrayOfDouble2.append("LOAD:").append(paramArrayOfDouble1.toString());
        AppMethodBeat.o(211007);
        return false;
      }
      paramArrayOfDouble1 = new Exception("proxy is error");
      AppMethodBeat.o(211007);
      throw paramArrayOfDouble1;
    }
    finally
    {
      paramArrayOfDouble1 = new Exception(paramArrayOfDouble1.toString());
      AppMethodBeat.o(211007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.internal.TencentExtraKeys
 * JD-Core Version:    0.7.0.1
 */