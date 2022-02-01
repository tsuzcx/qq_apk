package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import c.t.m.g.bf;
import c.t.m.g.bg;
import c.t.m.g.br;

public final class TencentLocationManager
{
  public static final String BUILD = "165965-qq";
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  public static final String VERSION = "3.1.10";
  private static TencentLocationManager d;
  private static boolean e;
  private final byte[] a = new byte[0];
  private final bf b;
  private final br c;
  
  private TencentLocationManager(Context paramContext)
  {
    this.b = bf.a(paramContext);
    String str = this.b.d().c();
    paramContext = str;
    if (TextUtils.isEmpty(str))
    {
      paramContext = this.b.h();
      this.b.d().a(paramContext);
    }
    this.c = new br(this.b, paramContext);
  }
  
  private static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("bad key: " + paramString);
    }
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new NullPointerException("context is null");
      }
      finally {}
    }
    if (paramContext.getApplicationContext() == null) {
      throw new NullPointerException("application context is null");
    }
    if (d == null) {
      d = new TencentLocationManager(paramContext.getApplicationContext());
    }
    paramContext = d;
    return paramContext;
  }
  
  /* Error */
  public static boolean hasListener()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 101	com/tencent/map/geolocation/TencentLocationManager:d	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +10 -> 18
    //   11: iconst_0
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: getstatic 107	com/tencent/map/geolocation/TencentLocationManager:e	Z
    //   21: istore_0
    //   22: goto -9 -> 13
    //   25: astore_1
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	10	0	bool	boolean
    //   6	2	1	localTencentLocationManager	TencentLocationManager
    //   25	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	25	finally
    //   18	22	25	finally
  }
  
  public final int getCoordinateType()
  {
    return this.c.d();
  }
  
  public final String getKey()
  {
    synchronized (this.a)
    {
      String str = this.c.a();
      return str;
    }
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    return this.c.b();
  }
  
  /* Error */
  public final void removeUpdates(TencentLocationListener arg1)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 33	com/tencent/map/geolocation/TencentLocationManager:a	[B
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 67	com/tencent/map/geolocation/TencentLocationManager:c	Lc/t/m/g/br;
    //   14: invokevirtual 122	c/t/m/g/br:c	()V
    //   17: aload_1
    //   18: monitorexit
    //   19: iconst_0
    //   20: putstatic 107	com/tencent/map/geolocation/TencentLocationManager:e	Z
    //   23: ldc 2
    //   25: monitorexit
    //   26: return
    //   27: astore_2
    //   28: aload_1
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    //   32: astore_1
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	TencentLocationManager
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	27	finally
    //   3	10	32	finally
    //   19	26	32	finally
    //   28	32	32	finally
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  /* Error */
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 88	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 135
    //   10: invokespecial 91	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: new 88	java/lang/NullPointerException
    //   21: dup
    //   22: ldc 137
    //   24: invokespecial 91	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: aload_3
    //   29: ifnonnull +13 -> 42
    //   32: new 88	java/lang/NullPointerException
    //   35: dup
    //   36: ldc 139
    //   38: invokespecial 91	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   41: athrow
    //   42: ldc 2
    //   44: monitorenter
    //   45: iconst_1
    //   46: putstatic 107	com/tencent/map/geolocation/TencentLocationManager:e	Z
    //   49: aload_0
    //   50: getfield 33	com/tencent/map/geolocation/TencentLocationManager:a	[B
    //   53: astore 5
    //   55: aload 5
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 67	com/tencent/map/geolocation/TencentLocationManager:c	Lc/t/m/g/br;
    //   62: invokevirtual 114	c/t/m/g/br:a	()Ljava/lang/String;
    //   65: invokestatic 140	com/tencent/map/geolocation/TencentLocationManager:a	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 67	com/tencent/map/geolocation/TencentLocationManager:c	Lc/t/m/g/br;
    //   72: aload_1
    //   73: aload_2
    //   74: aload_3
    //   75: invokevirtual 142	c/t/m/g/br:a	(Lcom/tencent/map/geolocation/TencentLocationRequest;Lcom/tencent/map/geolocation/TencentLocationListener;Landroid/os/Looper;)I
    //   78: istore 4
    //   80: aload 5
    //   82: monitorexit
    //   83: ldc 2
    //   85: monitorexit
    //   86: iload 4
    //   88: ireturn
    //   89: astore_1
    //   90: aload 5
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	TencentLocationManager
    //   0	101	1	paramTencentLocationRequest	TencentLocationRequest
    //   0	101	2	paramTencentLocationListener	TencentLocationListener
    //   0	101	3	paramLooper	Looper
    //   78	9	4	i	int
    // Exception table:
    //   from	to	target	type
    //   58	83	89	finally
    //   45	58	95	finally
    //   83	86	95	finally
    //   90	95	95	finally
    //   96	99	95	finally
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      synchronized (this.a)
      {
        this.c.a(paramInt);
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: " + paramInt);
  }
  
  public final void setKey(String paramString)
  {
    a(paramString);
    this.b.d().a(paramString);
    synchronized (this.a)
    {
      this.c.a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */