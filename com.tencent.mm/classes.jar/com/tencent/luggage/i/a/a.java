package com.tencent.luggage.i.a;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.mm.plugin.appbrand.utils.b.a
{
  private final List<a.b> ewA;
  private final List<a.b> ewB;
  private final List<a.b> ewC;
  TencentLocationListener ewD;
  private Set<String> ewE;
  private Runnable ewF;
  private volatile TencentLocationManager ewu;
  private TencentLocation ewv;
  private long eww;
  private int ewx;
  private String ewy;
  private final List<a.b> ewz;
  
  public a()
  {
    AppMethodBeat.i(146447);
    this.ewv = null;
    this.eww = 0L;
    this.ewx = 0;
    this.ewy = "";
    this.ewz = new CopyOnWriteArrayList();
    this.ewA = new CopyOnWriteArrayList();
    this.ewB = new CopyOnWriteArrayList();
    this.ewC = new CopyOnWriteArrayList();
    this.ewD = new TencentLocationListener()
    {
      public final void onLocationChanged(final TencentLocation paramAnonymousTencentLocation, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(219922);
        if (MMHandlerThread.isMainThread())
        {
          h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219919);
              jdField_this.onLocationChanged(paramAnonymousTencentLocation, paramAnonymousInt, paramAnonymousString);
              AppMethodBeat.o(219919);
            }
          }, "MicroMsg.DefaultTencentLocationManager");
          AppMethodBeat.o(219922);
          return;
        }
        Log.v("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt != 0) {
          Log.e("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        }
        if ((a.a(a.this) != null) && (a.a(a.this).size() > 0))
        {
          a.a(a.a(a.this), paramAnonymousInt, paramAnonymousString, a.b(paramAnonymousTencentLocation, false));
          a.a(a.this).clear();
        }
        if ((a.b(a.this) != null) && (a.b(a.this).size() > 0))
        {
          a.a(a.b(a.this), paramAnonymousInt, paramAnonymousString, a.b(paramAnonymousTencentLocation, true));
          a.b(a.this).clear();
        }
        if ((a.c(a.this) != null) && (a.c(a.this).size() > 0)) {
          a.a(a.c(a.this), paramAnonymousInt, paramAnonymousString, a.b(paramAnonymousTencentLocation, false));
        }
        if ((a.d(a.this) != null) && (a.d(a.this).size() > 0)) {
          a.a(a.d(a.this), paramAnonymousInt, paramAnonymousString, a.b(paramAnonymousTencentLocation, true));
        }
        a.a(a.this, paramAnonymousTencentLocation);
        a.a(a.this, System.currentTimeMillis());
        a.a(a.this, paramAnonymousInt);
        a.a(a.this, paramAnonymousString);
        a.e(a.this);
        AppMethodBeat.o(219922);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(146445);
        Log.i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2 });
        AppMethodBeat.o(146445);
      }
    };
    this.ewE = new HashSet();
    this.ewF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146446);
        if ((a.b(a.this) != null) && (a.b(a.this).size() > 0)) {
          a.a(a.b(a.this), -1, "timeout", null);
        }
        if ((a.a(a.this) != null) && (a.a(a.this).size() > 0)) {
          a.a(a.a(a.this), -1, "timeout", null);
        }
        AppMethodBeat.o(146446);
      }
    };
    Log.i("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", new Object[] { MMApplicationContext.getProcessName() });
    AppMethodBeat.o(146447);
  }
  
  private static a.a a(TencentLocation paramTencentLocation, boolean paramBoolean)
  {
    AppMethodBeat.i(219925);
    a.a locala = new a.a();
    if (paramBoolean)
    {
      locala.latitude = paramTencentLocation.getLatitude();
      locala.longitude = paramTencentLocation.getLongitude();
      locala.type = "wgs84";
      locala.provider = fH(paramTencentLocation.getProvider());
      locala.huN = paramTencentLocation.getSpeed();
      locala.usi = paramTencentLocation.getAccuracy();
      locala.altitude = paramTencentLocation.getAltitude();
      locala.usj = paramTencentLocation.getIndoorLocationType();
      locala.usk = paramTencentLocation.getBearing();
      if (paramTencentLocation.getExtra() != null) {
        locala.usl = paramTencentLocation.getExtra().getDouble("steps");
      }
      Log.v("MicroMsg.DefaultTencentLocationManager", "buildingId:%s floorName:%s steps:%f", new Object[] { paramTencentLocation.getIndoorBuildingId(), paramTencentLocation.getIndoorBuildingFloor(), Double.valueOf(locala.usl) });
      if (Util.isNullOrNil(paramTencentLocation.getIndoorBuildingId())) {
        break label291;
      }
      locala.buildingId = paramTencentLocation.getIndoorBuildingId();
    }
    for (locala.floorName = paramTencentLocation.getIndoorBuildingFloor();; locala.floorName = "")
    {
      AppMethodBeat.o(219925);
      return locala;
      double d1 = paramTencentLocation.getLatitude();
      double d2 = paramTencentLocation.getLongitude();
      double[] arrayOfDouble = new double[2];
      TencentLocationUtils.wgs84ToGcj02(new double[] { d1, d2 }, arrayOfDouble);
      locala.latitude = arrayOfDouble[0];
      locala.longitude = arrayOfDouble[1];
      locala.type = "gcj02";
      break;
      label291:
      locala.buildingId = "";
    }
  }
  
  /* Error */
  private TencentLocationManager atf()
  {
    // Byte code:
    //   0: ldc_w 256
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 258	com/tencent/luggage/i/a/a:ewu	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   10: ifnonnull +168 -> 178
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 258	com/tencent/luggage/i/a/a:ewu	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   19: ifnonnull +157 -> 176
    //   22: aload_0
    //   23: invokevirtual 261	com/tencent/luggage/i/a/a:atg	()Z
    //   26: ifeq +78 -> 104
    //   29: new 263	com/tencent/mm/vfs/u
    //   32: dup
    //   33: new 265	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   40: invokestatic 271	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   43: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 277
    //   49: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokestatic 92	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
    //   55: invokestatic 280	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   58: invokevirtual 285	java/lang/String:length	()I
    //   61: iconst_1
    //   62: iadd
    //   63: invokevirtual 289	java/lang/String:substring	(I)Ljava/lang/String;
    //   66: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: iconst_1
    //   73: invokestatic 298	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   76: invokespecial 301	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   79: astore_1
    //   80: invokestatic 305	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   83: new 307	java/io/File
    //   86: dup
    //   87: aload_1
    //   88: getfield 311	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   91: invokestatic 316	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   94: iconst_1
    //   95: invokestatic 298	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   98: invokespecial 317	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: invokestatic 323	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setTencentLog	(Landroid/content/Context;Ljava/io/File;)V
    //   104: invokestatic 305	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   107: invokestatic 327	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setContext	(Landroid/content/Context;)V
    //   110: new 8	com/tencent/luggage/i/a/a$1
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 328	com/tencent/luggage/i/a/a$1:<init>	(Lcom/tencent/luggage/i/a/a;)V
    //   118: invokestatic 332	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setTencentLogCallback	(Lcom/tencent/map/geolocation/sapp/internal/LocationLogCallback;)V
    //   121: invokestatic 337	com/tencent/mm/compatible/deviceinfo/q:aPk	()Ljava/lang/String;
    //   124: astore_1
    //   125: aload_1
    //   126: invokestatic 343	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +111 -> 240
    //   132: aload_0
    //   133: invokestatic 305	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   136: invokestatic 349	com/tencent/map/geolocation/sapp/TencentLocationManager:getInstance	(Landroid/content/Context;)Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   139: putfield 258	com/tencent/luggage/i/a/a:ewu	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   142: aload_0
    //   143: getfield 258	com/tencent/luggage/i/a/a:ewu	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   146: iconst_0
    //   147: invokevirtual 352	com/tencent/map/geolocation/sapp/TencentLocationManager:setCoordinateType	(I)V
    //   150: ldc 84
    //   152: ldc_w 354
    //   155: iconst_2
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_0
    //   166: getfield 258	com/tencent/luggage/i/a/a:ewu	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   169: invokevirtual 357	com/tencent/map/geolocation/sapp/TencentLocationManager:getVersion	()Ljava/lang/String;
    //   172: aastore
    //   173: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_0
    //   179: getfield 258	com/tencent/luggage/i/a/a:ewu	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   182: astore_1
    //   183: ldc_w 256
    //   186: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: areturn
    //   191: astore_1
    //   192: ldc 84
    //   194: ldc 56
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload_1
    //   203: aastore
    //   204: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -103 -> 104
    //   210: astore_1
    //   211: aload_0
    //   212: monitorexit
    //   213: ldc_w 256
    //   216: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: athrow
    //   221: astore_1
    //   222: ldc 84
    //   224: ldc 56
    //   226: iconst_1
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: aastore
    //   234: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: goto -116 -> 121
    //   240: aload_0
    //   241: invokestatic 305	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   244: new 362	android/util/Pair
    //   247: dup
    //   248: ldc_w 364
    //   251: aload_1
    //   252: invokespecial 367	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   255: invokestatic 370	com/tencent/map/geolocation/sapp/TencentLocationManager:getInstance	(Landroid/content/Context;Landroid/util/Pair;)Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   258: putfield 258	com/tencent/luggage/i/a/a:ewu	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   261: goto -119 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	a
    //   79	111	1	localObject1	Object
    //   191	12	1	localException1	java.lang.Exception
    //   210	10	1	localObject2	Object
    //   221	31	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   80	104	191	java/lang/Exception
    //   15	80	210	finally
    //   80	104	210	finally
    //   104	110	210	finally
    //   110	121	210	finally
    //   121	142	210	finally
    //   142	176	210	finally
    //   176	178	210	finally
    //   192	207	210	finally
    //   222	237	210	finally
    //   240	261	210	finally
    //   110	121	221	java/lang/Exception
  }
  
  private void ath()
  {
    AppMethodBeat.i(146452);
    if ((this.ewA.size() <= 0) && (this.ewz.size() <= 0) && (this.ewB.size() <= 0) && (this.ewC.size() <= 0))
    {
      Log.i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
      atf().removeUpdates(null);
    }
    AppMethodBeat.o(146452);
  }
  
  private static String fH(String paramString)
  {
    AppMethodBeat.i(219926);
    if ("gps".equals(paramString))
    {
      AppMethodBeat.o(219926);
      return "gps";
    }
    AppMethodBeat.o(219926);
    return "network";
  }
  
  public final void a(String paramString, a.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(146449);
    boolean bool1 = "wgs84".equals(paramString);
    boolean bool2 = paramBundle.getBoolean("enableIndoor");
    boolean bool3 = paramBundle.getBoolean("isHighAccuracy", false);
    int i = paramBundle.getInt("highAccuracyExpireTime", 3000);
    boolean bool4 = paramBundle.getBoolean("useCache", false);
    if (((bool4) && (this.ewv != null)) || ((this.ewv != null) && (System.currentTimeMillis() - this.eww < 5000L)))
    {
      Log.i("MicroMsg.DefaultTencentLocationManager", "useCache enableIndoor:%b isHighAccuracy:%b highAccuracyExpireTime:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(i) });
      paramb.a(this.ewx, this.ewy, a(this.ewv, bool1));
      AppMethodBeat.o(146449);
      return;
    }
    if ("wgs84".equals(paramString))
    {
      this.ewz.add(paramb);
      if (this.ewz.size() > 1) {
        AppMethodBeat.o(146449);
      }
    }
    else
    {
      this.ewA.add(paramb);
      if (this.ewA.size() > 1)
      {
        AppMethodBeat.o(146449);
        return;
      }
    }
    o.cNm().removeCallbacks(this.ewF);
    o.cNm().j(this.ewF, 20000L);
    paramString = TencentLocationRequest.create();
    paramString.setInterval(2000L);
    paramString.setIndoorLocationMode(bool2);
    paramString.setSmallAppKey(paramBundle.getString("smallAppKey"));
    paramString.setmExpirationTime(i);
    paramString.setAndroidId(q.getAndroidId());
    int j = atf().requestSingleFreshLocation(paramString, this.ewD, Looper.getMainLooper(), bool3);
    Log.d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", new Object[] { paramBundle.getString("smallAppKey") });
    Log.i("MicroMsg.DefaultTencentLocationManager", "enableIndoor:%b isHighAccuracy:%b highAccuracyExpireTime:%d useCache:%b requestCode %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool4), Integer.valueOf(j) });
    AppMethodBeat.o(146449);
  }
  
  protected boolean atg()
  {
    return false;
  }
  
  public final boolean b(String paramString, a.b paramb, Bundle paramBundle)
  {
    int i = 0;
    for (;;)
    {
      boolean bool;
      label314:
      try
      {
        AppMethodBeat.i(146450);
        Log.i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", new Object[] { paramString });
        a.b localb;
        if ("wgs84".equals(paramString))
        {
          paramString = this.ewB.iterator();
          if (paramString.hasNext())
          {
            localb = (a.b)paramString.next();
            if ((localb == null) || (!localb.equals(paramb))) {
              continue;
            }
            Log.w("MicroMsg.DefaultTencentLocationManager", "already register");
            AppMethodBeat.o(146450);
            bool = false;
            return bool;
          }
          this.ewB.add(paramb);
          if (this.ewB.size() > 1)
          {
            AppMethodBeat.o(146450);
            bool = true;
            continue;
          }
        }
        else
        {
          paramString = this.ewC.iterator();
          if (paramString.hasNext())
          {
            localb = (a.b)paramString.next();
            if ((localb == null) || (!localb.equals(paramb))) {
              continue;
            }
            Log.w("MicroMsg.DefaultTencentLocationManager", "already register");
            AppMethodBeat.o(146450);
            bool = false;
            continue;
          }
          this.ewC.add(paramb);
          if (this.ewC.size() > 1)
          {
            AppMethodBeat.o(146450);
            bool = true;
            continue;
          }
        }
        if (paramBundle != null)
        {
          paramString = paramBundle.getString("smallAppKey");
          if (!Util.isNullOrNil(paramString)) {
            this.ewE.add(paramString);
          }
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("enableIndoor"))) {
          break label391;
        }
        bool = true;
        if (this.ewB.size() + this.ewC.size() != 1) {
          break label486;
        }
        i = 1;
      }
      finally {}
      paramString = TencentLocationRequest.create();
      paramString.setIndoorLocationMode(bool);
      long l;
      if (bool)
      {
        l = 1000L;
        paramString.setInterval(l);
        paramb = new StringBuilder();
        paramBundle = this.ewE.iterator();
        if (paramBundle.hasNext())
        {
          paramb.append((String)paramBundle.next());
          continue;
          label391:
          bool = false;
        }
      }
      else
      {
        l = 2000L;
        continue;
      }
      Log.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", new Object[] { paramb.toString() });
      paramString.setSmallAppKey(paramb.toString());
      paramString.setAndroidId(q.getAndroidId());
      Log.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(atf().requestLocationUpdates(paramString, this.ewD, Looper.getMainLooper())) });
      label486:
      do
      {
        AppMethodBeat.o(146450);
        bool = true;
        break;
        if (i != 0) {
          break label314;
        }
      } while (!bool);
    }
  }
  
  /* Error */
  public final boolean c(String paramString, a.b paramb, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 542
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 84
    //   10: ldc_w 544
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: ldc 128
    //   26: aload_1
    //   27: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +51 -> 81
    //   33: aload_0
    //   34: getfield 67	com/tencent/luggage/i/a/a:ewB	Ljava/util/List;
    //   37: aload_2
    //   38: invokeinterface 547 2 0
    //   43: pop
    //   44: aload_3
    //   45: ifnull +22 -> 67
    //   48: aload_3
    //   49: ldc_w 484
    //   52: invokevirtual 487	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 79	com/tencent/luggage/i/a/a:ewE	Ljava/util/Set;
    //   60: aload_1
    //   61: invokeinterface 548 2 0
    //   66: pop
    //   67: aload_0
    //   68: invokespecial 396	com/tencent/luggage/i/a/a:ath	()V
    //   71: ldc_w 542
    //   74: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_0
    //   82: getfield 69	com/tencent/luggage/i/a/a:ewC	Ljava/util/List;
    //   85: aload_2
    //   86: invokeinterface 547 2 0
    //   91: pop
    //   92: goto -48 -> 44
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	paramString	String
    //   0	100	2	paramb	a.b
    //   0	100	3	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   2	44	95	finally
    //   48	67	95	finally
    //   67	77	95	finally
    //   81	92	95	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.i.a.a
 * JD-Core Version:    0.7.0.1
 */