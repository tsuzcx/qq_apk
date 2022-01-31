package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import c.t.m.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  private static TencentLocationManager b;
  private static Class c;
  private static Object d;
  private final byte[] a;
  private int e;
  private Context f;
  
  /* Error */
  private TencentLocationManager(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/lang/Object:<init>	()V
    //   4: ldc 28
    //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_0
    //   11: newarray byte
    //   13: putfield 36	com/tencent/map/geolocation/TencentLocationManager:a	[B
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 38	com/tencent/map/geolocation/TencentLocationManager:e	I
    //   21: invokestatic 44	com/tencent/map/geolocation/TencentLocationManagerOptions:isLoadLibraryEnabled	()Z
    //   24: ifeq +8 -> 32
    //   27: ldc 46
    //   29: invokestatic 52	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_1
    //   34: putfield 54	com/tencent/map/geolocation/TencentLocationManager:f	Landroid/content/Context;
    //   37: aload_1
    //   38: invokestatic 59	c/t/m/c/f:a	(Landroid/content/Context;)Lc/t/m/c/f;
    //   41: astore_2
    //   42: aload_2
    //   43: invokevirtual 62	c/t/m/c/f:a	()Ldalvik/system/DexClassLoader;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnonnull +36 -> 84
    //   51: invokestatic 67	c/t/m/c/e:a	()Lc/t/m/c/e;
    //   54: ldc 69
    //   56: ldc 71
    //   58: invokevirtual 74	c/t/m/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: iconst_4
    //   63: putfield 38	com/tencent/map/geolocation/TencentLocationManager:e	I
    //   66: ldc 28
    //   68: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: iconst_3
    //   75: putfield 38	com/tencent/map/geolocation/TencentLocationManager:e	I
    //   78: ldc 28
    //   80: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_2
    //   85: ldc 79
    //   87: invokevirtual 85	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   90: astore_2
    //   91: aload_2
    //   92: putstatic 87	com/tencent/map/geolocation/TencentLocationManager:c	Ljava/lang/Class;
    //   95: aload_2
    //   96: iconst_1
    //   97: anewarray 89	java/lang/Class
    //   100: dup
    //   101: iconst_0
    //   102: ldc 91
    //   104: aastore
    //   105: invokevirtual 95	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_1
    //   115: aastore
    //   116: invokevirtual 101	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   119: astore_1
    //   120: aload_1
    //   121: putstatic 103	com/tencent/map/geolocation/TencentLocationManager:d	Ljava/lang/Object;
    //   124: aload_1
    //   125: ifnonnull +24 -> 149
    //   128: aload_0
    //   129: iconst_4
    //   130: putfield 38	com/tencent/map/geolocation/TencentLocationManager:e	I
    //   133: invokestatic 67	c/t/m/c/e:a	()Lc/t/m/c/e;
    //   136: ldc 69
    //   138: ldc 105
    //   140: invokevirtual 74	c/t/m/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc 28
    //   145: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: invokestatic 67	c/t/m/c/e:a	()Lc/t/m/c/e;
    //   152: ldc 69
    //   154: ldc 107
    //   156: invokevirtual 74	c/t/m/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: ldc 28
    //   161: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: astore_1
    //   166: aload_0
    //   167: iconst_5
    //   168: putfield 38	com/tencent/map/geolocation/TencentLocationManager:e	I
    //   171: invokestatic 67	c/t/m/c/e:a	()Lc/t/m/c/e;
    //   174: ldc 69
    //   176: new 109	java/lang/StringBuilder
    //   179: dup
    //   180: ldc 111
    //   182: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload_1
    //   186: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   189: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 74	c/t/m/c/e:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: ldc 28
    //   200: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	TencentLocationManager
    //   0	204	1	paramContext	Context
    //   41	55	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	72	java/lang/Throwable
    //   42	47	165	java/lang/Throwable
    //   51	66	165	java/lang/Throwable
    //   84	124	165	java/lang/Throwable
    //   128	143	165	java/lang/Throwable
    //   149	159	165	java/lang/Throwable
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(136456);
      if (b != null) {
        break label83;
      }
      if (paramContext == null)
      {
        paramContext = new NullPointerException("context is null");
        AppMethodBeat.o(136456);
        throw paramContext;
      }
    }
    finally {}
    if (paramContext.getApplicationContext() == null)
    {
      paramContext = new NullPointerException("application context is null");
      AppMethodBeat.o(136456);
      throw paramContext;
    }
    System.currentTimeMillis();
    b = new TencentLocationManager(paramContext.getApplicationContext());
    label83:
    paramContext = b;
    AppMethodBeat.o(136456);
    return paramContext;
  }
  
  public final String getBuild()
  {
    AppMethodBeat.i(136466);
    try
    {
      String str = (String)c.getDeclaredMethod("getBuild", new Class[0]).invoke(d, new Object[0]);
      AppMethodBeat.o(136466);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136466);
    }
    return "error";
  }
  
  public final int getCoordinateType()
  {
    AppMethodBeat.i(136458);
    try
    {
      int i = ((Integer)c.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(d, new Object[0])).intValue();
      AppMethodBeat.o(136458);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136458);
    }
    return -1;
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    AppMethodBeat.i(136464);
    try
    {
      TencentLocation localTencentLocation = (TencentLocation)c.getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(d, new Object[0]);
      AppMethodBeat.o(136464);
      return localTencentLocation;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136464);
    }
    return null;
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(136467);
    try
    {
      String str = (String)c.getDeclaredMethod("getVersion", new Class[0]).invoke(d, new Object[0]);
      AppMethodBeat.o(136467);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136467);
    }
    return "error";
  }
  
  public final void removeUpdates(TencentLocationListener paramTencentLocationListener)
  {
    AppMethodBeat.i(136465);
    try
    {
      synchronized (this.a)
      {
        c.getDeclaredMethod("removeUpdates", new Class[] { TencentLocationListener.class }).invoke(d, new Object[] { paramTencentLocationListener });
        e.a().c();
        label50:
        AppMethodBeat.o(136465);
        return;
      }
    }
    catch (Throwable paramTencentLocationListener)
    {
      break label50;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    AppMethodBeat.i(136459);
    int i;
    if (this.e > 0)
    {
      i = this.e;
      AppMethodBeat.o(136459);
      return i;
    }
    try
    {
      i = ((Integer)c.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class }).invoke(d, new Object[] { paramTencentLocationRequest, paramTencentLocationListener })).intValue();
      AppMethodBeat.o(136459);
      return i;
    }
    catch (Throwable paramTencentLocationRequest)
    {
      AppMethodBeat.o(136459);
    }
    return 5;
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    AppMethodBeat.i(136460);
    System.currentTimeMillis();
    if (paramTencentLocationRequest == null)
    {
      paramTencentLocationRequest = new NullPointerException("request is null");
      AppMethodBeat.o(136460);
      throw paramTencentLocationRequest;
    }
    if (paramTencentLocationListener == null)
    {
      paramTencentLocationRequest = new NullPointerException("listener is null");
      AppMethodBeat.o(136460);
      throw paramTencentLocationRequest;
    }
    if (paramLooper == null)
    {
      paramTencentLocationRequest = new NullPointerException("looper is null");
      AppMethodBeat.o(136460);
      throw paramTencentLocationRequest;
    }
    int i;
    if (this.e > 0)
    {
      i = this.e;
      AppMethodBeat.o(136460);
      return i;
    }
    synchronized (this.a)
    {
      try
      {
        paramTencentLocationRequest = (Integer)c.getDeclaredMethod("requestLocationUpdates", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class }).invoke(d, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper });
        e.a().a("RLU", paramTencentLocationRequest.toString());
        i = paramTencentLocationRequest.intValue();
        AppMethodBeat.o(136460);
        return i;
      }
      catch (Throwable paramTencentLocationRequest)
      {
        e.a().a("RLU", "5," + paramTencentLocationRequest.toString());
        AppMethodBeat.o(136460);
        return 5;
      }
    }
  }
  
  public final int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    AppMethodBeat.i(136461);
    int i = requestSingleFreshLocation(paramTencentLocationRequest, paramTencentLocationListener, paramLooper, false);
    AppMethodBeat.o(136461);
    return i;
  }
  
  public final int requestSingleFreshLocation(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper, boolean paramBoolean)
  {
    AppMethodBeat.i(151735);
    if (paramTencentLocationListener == null)
    {
      paramTencentLocationRequest = new NullPointerException("listener is null");
      AppMethodBeat.o(151735);
      throw paramTencentLocationRequest;
    }
    if (paramLooper == null)
    {
      paramTencentLocationRequest = new NullPointerException("looper is null");
      AppMethodBeat.o(151735);
      throw paramTencentLocationRequest;
    }
    int i;
    if (this.e > 0)
    {
      i = this.e;
      AppMethodBeat.o(151735);
      return i;
    }
    synchronized (this.a)
    {
      try
      {
        i = ((Integer)c.getDeclaredMethod("requestSingleFreshLocation", new Class[] { TencentLocationRequest.class, TencentLocationListener.class, Looper.class, Boolean.TYPE }).invoke(d, new Object[] { paramTencentLocationRequest, paramTencentLocationListener, paramLooper, Boolean.valueOf(paramBoolean) })).intValue();
        AppMethodBeat.o(151735);
        return i;
      }
      catch (Throwable paramTencentLocationRequest)
      {
        AppMethodBeat.o(151735);
        return 5;
      }
    }
  }
  
  /* Error */
  public final void setCoordinateType(int paramInt)
  {
    // Byte code:
    //   0: ldc 229
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_1
    //   6: iconst_1
    //   7: if_icmpeq +7 -> 14
    //   10: iload_1
    //   11: ifne +71 -> 82
    //   14: aload_0
    //   15: getfield 36	com/tencent/map/geolocation/TencentLocationManager:a	[B
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: getstatic 87	com/tencent/map/geolocation/TencentLocationManager:c	Ljava/lang/Class;
    //   24: ldc 230
    //   26: iconst_1
    //   27: anewarray 89	java/lang/Class
    //   30: dup
    //   31: iconst_0
    //   32: getstatic 231	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   35: aastore
    //   36: invokevirtual 152	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: getstatic 103	com/tencent/map/geolocation/TencentLocationManager:d	Ljava/lang/Object;
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: iload_1
    //   49: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: invokevirtual 158	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_2
    //   58: monitorexit
    //   59: ldc 229
    //   61: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: astore_3
    //   66: aload_2
    //   67: monitorexit
    //   68: ldc 229
    //   70: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_3
    //   74: athrow
    //   75: astore_2
    //   76: ldc 229
    //   78: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: new 236	java/lang/IllegalArgumentException
    //   85: dup
    //   86: ldc 238
    //   88: iload_1
    //   89: invokestatic 241	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   92: invokevirtual 245	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokespecial 246	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   98: astore_2
    //   99: ldc 229
    //   101: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_2
    //   105: athrow
    //   106: astore_3
    //   107: goto -50 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	TencentLocationManager
    //   0	110	1	paramInt	int
    //   75	1	2	localException	java.lang.Exception
    //   98	7	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   65	9	3	localObject	Object
    //   106	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	57	65	finally
    //   57	59	65	finally
    //   66	68	65	finally
    //   14	21	75	java/lang/Exception
    //   59	64	75	java/lang/Exception
    //   68	75	75	java/lang/Exception
    //   82	106	75	java/lang/Exception
    //   21	57	106	java/lang/Throwable
  }
  
  public final boolean startIndoorLocation()
  {
    AppMethodBeat.i(136462);
    try
    {
      boolean bool = ((Boolean)c.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(d, new Object[0])).booleanValue();
      AppMethodBeat.o(136462);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136462);
    }
    return false;
  }
  
  public final boolean stopIndoorLocation()
  {
    AppMethodBeat.i(136463);
    try
    {
      boolean bool = ((Boolean)c.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(d, new Object[0])).booleanValue();
      AppMethodBeat.o(136463);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136463);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */