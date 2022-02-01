package com.tencent.luggage.h.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.mm.plugin.appbrand.utils.b.a
{
  private Set<String> cDA;
  private Runnable cDB;
  private volatile TencentLocationManager cDr;
  private TencentLocation cDs;
  private int cDt;
  private String cDu;
  @SuppressLint({"NewApi"})
  private final List<a.b> cDv;
  @SuppressLint({"NewApi"})
  private final List<a.b> cDw;
  @SuppressLint({"NewApi"})
  private final List<a.b> cDx;
  @SuppressLint({"NewApi"})
  private final List<a.b> cDy;
  TencentLocationListener cDz;
  
  public a()
  {
    AppMethodBeat.i(146447);
    this.cDs = null;
    this.cDt = 0;
    this.cDu = "";
    this.cDv = new CopyOnWriteArrayList();
    this.cDw = new CopyOnWriteArrayList();
    this.cDx = new CopyOnWriteArrayList();
    this.cDy = new CopyOnWriteArrayList();
    this.cDz = new TencentLocationListener()
    {
      public final void onLocationChanged(final TencentLocation paramAnonymousTencentLocation, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(189724);
        if (MMHandlerThread.isMainThread())
        {
          h.ZvG.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(189647);
              jdField_this.onLocationChanged(paramAnonymousTencentLocation, paramAnonymousInt, paramAnonymousString);
              AppMethodBeat.o(189647);
            }
          }, "MicroMsg.DefaultTencentLocationManager");
          AppMethodBeat.o(189724);
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
        a.a(a.this, paramAnonymousInt);
        a.a(a.this, paramAnonymousString);
        a.e(a.this);
        AppMethodBeat.o(189724);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(146445);
        Log.i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2 });
        AppMethodBeat.o(146445);
      }
    };
    this.cDA = new HashSet();
    this.cDB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146446);
        if ((a.a(a.this) != null) && (a.a(a.this).size() > 0)) {
          a.a(a.a(a.this), -1, "timeout", null);
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
  
  /* Error */
  private TencentLocationManager SB()
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 107	com/tencent/luggage/h/a/a:cDr	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   9: ifnonnull +163 -> 172
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 107	com/tencent/luggage/h/a/a:cDr	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   18: ifnonnull +152 -> 170
    //   21: aload_0
    //   22: invokevirtual 111	com/tencent/luggage/h/a/a:SC	()Z
    //   25: ifeq +74 -> 99
    //   28: new 113	com/tencent/mm/vfs/q
    //   31: dup
    //   32: new 115	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   39: invokestatic 121	com/tencent/mm/loader/j/b:aSL	()Ljava/lang/String;
    //   42: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 127
    //   47: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokestatic 91	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
    //   53: invokestatic 130	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   56: invokevirtual 136	java/lang/String:length	()I
    //   59: iconst_1
    //   60: iadd
    //   61: invokevirtual 140	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_1
    //   71: invokestatic 149	com/tencent/mm/vfs/u:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   74: invokespecial 152	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: invokestatic 156	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   81: new 158	java/io/File
    //   84: dup
    //   85: aload_1
    //   86: invokevirtual 161	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   89: iconst_1
    //   90: invokestatic 149	com/tencent/mm/vfs/u:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   93: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: invokestatic 168	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setTencentLog	(Landroid/content/Context;Ljava/io/File;)V
    //   99: invokestatic 156	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   102: invokestatic 172	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setContext	(Landroid/content/Context;)V
    //   105: new 8	com/tencent/luggage/h/a/a$1
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 173	com/tencent/luggage/h/a/a$1:<init>	(Lcom/tencent/luggage/h/a/a;)V
    //   113: invokestatic 177	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setTencentLogCallback	(Lcom/tencent/map/geolocation/sapp/internal/LocationLogCallback;)V
    //   116: invokestatic 182	com/tencent/mm/compatible/deviceinfo/q:auQ	()Ljava/lang/String;
    //   119: astore_1
    //   120: aload_1
    //   121: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +108 -> 232
    //   127: aload_0
    //   128: invokestatic 156	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   131: invokestatic 194	com/tencent/map/geolocation/sapp/TencentLocationManager:getInstance	(Landroid/content/Context;)Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   134: putfield 107	com/tencent/luggage/h/a/a:cDr	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   137: aload_0
    //   138: getfield 107	com/tencent/luggage/h/a/a:cDr	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   141: iconst_0
    //   142: invokevirtual 197	com/tencent/map/geolocation/sapp/TencentLocationManager:setCoordinateType	(I)V
    //   145: ldc 83
    //   147: ldc 199
    //   149: iconst_2
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload_0
    //   160: getfield 107	com/tencent/luggage/h/a/a:cDr	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   163: invokevirtual 202	com/tencent/map/geolocation/sapp/TencentLocationManager:getVersion	()Ljava/lang/String;
    //   166: aastore
    //   167: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_0
    //   173: getfield 107	com/tencent/luggage/h/a/a:cDr	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   176: astore_1
    //   177: ldc 105
    //   179: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: areturn
    //   184: astore_1
    //   185: ldc 83
    //   187: ldc 55
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_1
    //   196: aastore
    //   197: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: goto -101 -> 99
    //   203: astore_1
    //   204: aload_0
    //   205: monitorexit
    //   206: ldc 105
    //   208: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_1
    //   212: athrow
    //   213: astore_1
    //   214: ldc 83
    //   216: ldc 55
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_1
    //   225: aastore
    //   226: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: goto -113 -> 116
    //   232: aload_0
    //   233: invokestatic 156	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   236: new 207	android/util/Pair
    //   239: dup
    //   240: ldc 209
    //   242: aload_1
    //   243: invokespecial 212	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   246: invokestatic 215	com/tencent/map/geolocation/sapp/TencentLocationManager:getInstance	(Landroid/content/Context;Landroid/util/Pair;)Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   249: putfield 107	com/tencent/luggage/h/a/a:cDr	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   252: goto -115 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	a
    //   77	106	1	localObject1	Object
    //   184	12	1	localException1	java.lang.Exception
    //   203	9	1	localObject2	Object
    //   213	30	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   78	99	184	java/lang/Exception
    //   14	78	203	finally
    //   78	99	203	finally
    //   99	105	203	finally
    //   105	116	203	finally
    //   116	137	203	finally
    //   137	170	203	finally
    //   170	172	203	finally
    //   185	200	203	finally
    //   214	229	203	finally
    //   232	252	203	finally
    //   105	116	213	java/lang/Exception
  }
  
  private void SD()
  {
    AppMethodBeat.i(146452);
    if ((this.cDw.size() <= 0) && (this.cDv.size() <= 0) && (this.cDx.size() <= 0) && (this.cDy.size() <= 0))
    {
      Log.i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
      SB().removeUpdates(null);
    }
    AppMethodBeat.o(146452);
  }
  
  private static a.a a(TencentLocation paramTencentLocation, boolean paramBoolean)
  {
    AppMethodBeat.i(188742);
    a.a locala = new a.a();
    if (paramBoolean)
    {
      locala.latitude = paramTencentLocation.getLatitude();
      locala.longitude = paramTencentLocation.getLongitude();
      locala.type = "wgs84";
      locala.provider = el(paramTencentLocation.getProvider());
      locala.fqE = paramTencentLocation.getSpeed();
      locala.rjO = paramTencentLocation.getAccuracy();
      locala.altitude = paramTencentLocation.getAltitude();
      locala.rjP = paramTencentLocation.getIndoorLocationType();
      locala.rjQ = paramTencentLocation.getBearing();
      if (paramTencentLocation.getExtra() != null) {
        locala.rjR = paramTencentLocation.getExtra().getDouble("steps");
      }
      Log.v("MicroMsg.DefaultTencentLocationManager", "buildingId:%s floorName:%s steps:%f", new Object[] { paramTencentLocation.getIndoorBuildingId(), paramTencentLocation.getIndoorBuildingFloor(), Double.valueOf(locala.rjR) });
      if (Util.isNullOrNil(paramTencentLocation.getIndoorBuildingId())) {
        break label295;
      }
      locala.buildingId = paramTencentLocation.getIndoorBuildingId();
    }
    for (locala.floorName = paramTencentLocation.getIndoorBuildingFloor();; locala.floorName = "")
    {
      AppMethodBeat.o(188742);
      return locala;
      double d1 = paramTencentLocation.getLatitude();
      double d2 = paramTencentLocation.getLongitude();
      double[] arrayOfDouble = new double[2];
      TencentLocationUtils.wgs84ToGcj02(new double[] { d1, d2 }, arrayOfDouble);
      locala.latitude = arrayOfDouble[0];
      locala.longitude = arrayOfDouble[1];
      locala.type = "gcj02";
      break;
      label295:
      locala.buildingId = "";
    }
  }
  
  private static String el(String paramString)
  {
    AppMethodBeat.i(188745);
    if ("gps".equals(paramString))
    {
      AppMethodBeat.o(188745);
      return "gps";
    }
    AppMethodBeat.o(188745);
    return "network";
  }
  
  protected boolean SC()
  {
    return false;
  }
  
  public final void a(String paramString, a.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(146449);
    if ("wgs84".equals(paramString)) {
      this.cDv.add(paramb);
    }
    boolean bool2;
    boolean bool3;
    int i;
    boolean bool4;
    for (;;)
    {
      m.clV().removeCallbacks(this.cDB);
      m.clV().i(this.cDB, 20000L);
      boolean bool1 = "wgs84".equals(paramString);
      bool2 = paramBundle.getBoolean("enableIndoor");
      bool3 = paramBundle.getBoolean("isHighAccuracy", false);
      i = paramBundle.getInt("highAccuracyExpireTime", 3000);
      bool4 = paramBundle.getBoolean("useCache", false);
      if ((!bool4) || (this.cDs == null)) {
        break;
      }
      Log.i("MicroMsg.DefaultTencentLocationManager", "useCache enableIndoor:%b isHighAccuracy:%b highAccuracyExpireTime:%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(i) });
      paramb.a(this.cDt, this.cDu, a(this.cDs, bool1));
      AppMethodBeat.o(146449);
      return;
      this.cDw.add(paramb);
    }
    paramString = TencentLocationRequest.create();
    paramString.setInterval(2000L);
    paramString.setIndoorLocationMode(bool2);
    paramString.setSmallAppKey(paramBundle.getString("smallAppKey"));
    paramString.setmExpirationTime(i);
    int j = SB().requestSingleFreshLocation(paramString, this.cDz, Looper.getMainLooper(), bool3);
    Log.d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", new Object[] { paramBundle.getString("smallAppKey") });
    Log.i("MicroMsg.DefaultTencentLocationManager", "enableIndoor:%b isHighAccuracy:%b highAccuracyExpireTime:%d useCache:%b requestCode %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(i), Boolean.valueOf(bool4), Integer.valueOf(j) });
    AppMethodBeat.o(146449);
  }
  
  public final boolean b(String paramString, a.b paramb, Bundle paramBundle)
  {
    a.b localb;
    boolean bool;
    int i;
    label183:
    try
    {
      AppMethodBeat.i(146450);
      Log.i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", new Object[] { paramString });
      if (!"wgs84".equals(paramString)) {
        break label260;
      }
      paramString = this.cDx.iterator();
      while (paramString.hasNext())
      {
        localb = (a.b)paramString.next();
        if ((localb != null) && (localb.equals(paramb)))
        {
          Log.w("MicroMsg.DefaultTencentLocationManager", "already register");
          AppMethodBeat.o(146450);
          return false;
        }
      }
      this.cDx.add(paramb);
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("smallAppKey");
        if (!Util.isNullOrNil(paramString)) {
          this.cDA.add(paramString);
        }
      }
      if ((paramBundle == null) || (!paramBundle.getBoolean("enableIndoor"))) {
        break label418;
      }
      bool = true;
      if (this.cDx.size() + this.cDy.size() != 1) {
        break label424;
      }
      i = 1;
    }
    finally {}
    paramString = TencentLocationRequest.create();
    paramString.setIndoorLocationMode(bool);
    if (bool) {}
    for (long l = 1000L;; l = 2000L)
    {
      paramString.setInterval(l);
      paramb = new StringBuilder();
      paramBundle = this.cDA.iterator();
      for (;;)
      {
        if (paramBundle.hasNext())
        {
          paramb.append((String)paramBundle.next());
          continue;
          label260:
          paramString = this.cDy.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              localb = (a.b)paramString.next();
              if ((localb != null) && (localb.equals(paramb)))
              {
                Log.w("MicroMsg.DefaultTencentLocationManager", "already register");
                AppMethodBeat.o(146450);
                break;
              }
            }
          }
          this.cDy.add(paramb);
          break;
        }
      }
      Log.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", new Object[] { paramb.toString() });
      paramString.setSmallAppKey(paramb.toString());
      Log.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(SB().requestLocationUpdates(paramString, this.cDz, Looper.getMainLooper())) });
      label396:
      AppMethodBeat.o(146450);
      break;
      for (;;)
      {
        if (i != 0) {
          break label428;
        }
        if (!bool) {
          break label396;
        }
        break label183;
        label418:
        bool = false;
        break;
        label424:
        i = 0;
      }
      label428:
      break label183;
    }
  }
  
  /* Error */
  public final boolean c(String paramString, a.b paramb, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 519
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 83
    //   10: ldc_w 521
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: ldc_w 259
    //   27: aload_1
    //   28: invokevirtual 395	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +51 -> 82
    //   34: aload_0
    //   35: getfield 66	com/tencent/luggage/h/a/a:cDx	Ljava/util/List;
    //   38: aload_2
    //   39: invokeinterface 524 2 0
    //   44: pop
    //   45: aload_3
    //   46: ifnull +22 -> 68
    //   49: aload_3
    //   50: ldc_w 467
    //   53: invokevirtual 470	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 78	com/tencent/luggage/h/a/a:cDA	Ljava/util/Set;
    //   61: aload_1
    //   62: invokeinterface 525 2 0
    //   67: pop
    //   68: aload_0
    //   69: invokespecial 388	com/tencent/luggage/h/a/a:SD	()V
    //   72: ldc_w 519
    //   75: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: getfield 68	com/tencent/luggage/h/a/a:cDy	Ljava/util/List;
    //   86: aload_2
    //   87: invokeinterface 524 2 0
    //   92: pop
    //   93: goto -48 -> 45
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   0	101	1	paramString	String
    //   0	101	2	paramb	a.b
    //   0	101	3	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   2	45	96	finally
    //   49	68	96	finally
    //   68	78	96	finally
    //   82	93	96	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.h.a.a
 * JD-Core Version:    0.7.0.1
 */