package com.tencent.luggage.f.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.mm.plugin.appbrand.utils.b.a
{
  TencentLocationListener cqA;
  private Set<String> cqB;
  private Runnable cqC;
  private volatile TencentLocationManager cqv;
  @SuppressLint({"NewApi"})
  private final List<a.b> cqw;
  @SuppressLint({"NewApi"})
  private final List<a.b> cqx;
  @SuppressLint({"NewApi"})
  private final List<a.b> cqy;
  @SuppressLint({"NewApi"})
  private final List<a.b> cqz;
  
  public a()
  {
    AppMethodBeat.i(146447);
    this.cqw = new CopyOnWriteArrayList();
    this.cqx = new CopyOnWriteArrayList();
    this.cqy = new CopyOnWriteArrayList();
    this.cqz = new CopyOnWriteArrayList();
    this.cqA = new TencentLocationListener()
    {
      public final void onLocationChanged(final TencentLocation paramAnonymousTencentLocation, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(212514);
        if (ar.isMainThread())
        {
          h.MqF.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(212513);
              jdField_this.onLocationChanged(paramAnonymousTencentLocation, paramAnonymousInt, paramAnonymousString);
              AppMethodBeat.o(212513);
            }
          }, "MicroMsg.DefaultTencentLocationManager");
          AppMethodBeat.o(212514);
          return;
        }
        ae.v("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt != 0) {
          ae.e("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        }
        if ((a.a(a.this) != null) && (a.a(a.this).size() > 0))
        {
          a.a(a.a(a.this), paramAnonymousInt, paramAnonymousString, a.a(paramAnonymousTencentLocation, false));
          a.a(a.this).clear();
        }
        if ((a.b(a.this) != null) && (a.b(a.this).size() > 0))
        {
          a.a(a.b(a.this), paramAnonymousInt, paramAnonymousString, a.a(paramAnonymousTencentLocation, true));
          a.b(a.this).clear();
        }
        if ((a.c(a.this) != null) && (a.c(a.this).size() > 0)) {
          a.a(a.c(a.this), paramAnonymousInt, paramAnonymousString, a.a(paramAnonymousTencentLocation, false));
        }
        if ((a.d(a.this) != null) && (a.d(a.this).size() > 0)) {
          a.a(a.d(a.this), paramAnonymousInt, paramAnonymousString, a.a(paramAnonymousTencentLocation, true));
        }
        a.e(a.this);
        AppMethodBeat.o(212514);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(146445);
        ae.i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2 });
        AppMethodBeat.o(146445);
      }
    };
    this.cqB = new HashSet();
    this.cqC = new Runnable()
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
    ae.i("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", new Object[] { ak.getProcessName() });
    AppMethodBeat.o(146447);
  }
  
  /* Error */
  private TencentLocationManager Ft()
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 93	com/tencent/luggage/f/a/a:cqv	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   9: ifnonnull +166 -> 175
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 93	com/tencent/luggage/f/a/a:cqv	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   18: ifnonnull +155 -> 173
    //   21: aload_0
    //   22: invokevirtual 97	com/tencent/luggage/f/a/a:Fu	()Z
    //   25: ifeq +77 -> 102
    //   28: new 99	com/tencent/mm/vfs/k
    //   31: dup
    //   32: new 101	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   39: invokestatic 107	com/tencent/mm/loader/j/b:asj	()Ljava/lang/String;
    //   42: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 113
    //   47: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokestatic 77	com/tencent/mm/sdk/platformtools/ak:getProcessName	()Ljava/lang/String;
    //   53: invokestatic 116	com/tencent/mm/sdk/platformtools/ak:getPackageName	()Ljava/lang/String;
    //   56: invokevirtual 122	java/lang/String:length	()I
    //   59: iconst_1
    //   60: iadd
    //   61: invokevirtual 126	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_1
    //   71: invokestatic 135	com/tencent/mm/vfs/o:k	(Ljava/lang/String;Z)Ljava/lang/String;
    //   74: invokespecial 138	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   81: new 144	java/io/File
    //   84: dup
    //   85: aload_1
    //   86: getfield 148	com/tencent/mm/vfs/k:mUri	Landroid/net/Uri;
    //   89: invokestatic 154	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   92: iconst_1
    //   93: invokestatic 135	com/tencent/mm/vfs/o:k	(Ljava/lang/String;Z)Ljava/lang/String;
    //   96: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokestatic 161	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setTencentLog	(Landroid/content/Context;Ljava/io/File;)V
    //   102: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   105: invokestatic 165	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setContext	(Landroid/content/Context;)V
    //   108: new 8	com/tencent/luggage/f/a/a$1
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 166	com/tencent/luggage/f/a/a$1:<init>	(Lcom/tencent/luggage/f/a/a;)V
    //   116: invokestatic 170	com/tencent/map/geolocation/sapp/internal/TencentExtraKeys:setTencentLogCallback	(Lcom/tencent/map/geolocation/sapp/internal/LocationLogCallback;)V
    //   119: invokestatic 175	com/tencent/mm/compatible/deviceinfo/q:aaL	()Ljava/lang/String;
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +108 -> 235
    //   130: aload_0
    //   131: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   134: invokestatic 187	com/tencent/map/geolocation/sapp/TencentLocationManager:getInstance	(Landroid/content/Context;)Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   137: putfield 93	com/tencent/luggage/f/a/a:cqv	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   140: aload_0
    //   141: getfield 93	com/tencent/luggage/f/a/a:cqv	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   144: iconst_0
    //   145: invokevirtual 190	com/tencent/map/geolocation/sapp/TencentLocationManager:setCoordinateType	(I)V
    //   148: ldc 69
    //   150: ldc 192
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_1
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload_0
    //   163: getfield 93	com/tencent/luggage/f/a/a:cqv	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   166: invokevirtual 195	com/tencent/map/geolocation/sapp/TencentLocationManager:getVersion	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 82	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_0
    //   176: getfield 93	com/tencent/luggage/f/a/a:cqv	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   179: astore_1
    //   180: ldc 91
    //   182: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_1
    //   186: areturn
    //   187: astore_1
    //   188: ldc 69
    //   190: ldc 197
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_1
    //   199: aastore
    //   200: invokestatic 200	com/tencent/mm/sdk/platformtools/ae:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: goto -101 -> 102
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: ldc 91
    //   211: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: ldc 69
    //   219: ldc 197
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_1
    //   228: aastore
    //   229: invokestatic 200	com/tencent/mm/sdk/platformtools/ae:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: goto -113 -> 119
    //   235: aload_0
    //   236: invokestatic 142	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   239: new 202	android/util/Pair
    //   242: dup
    //   243: ldc 204
    //   245: aload_1
    //   246: invokespecial 207	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   249: invokestatic 210	com/tencent/map/geolocation/sapp/TencentLocationManager:getInstance	(Landroid/content/Context;Landroid/util/Pair;)Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   252: putfield 93	com/tencent/luggage/f/a/a:cqv	Lcom/tencent/map/geolocation/sapp/TencentLocationManager;
    //   255: goto -115 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	a
    //   77	109	1	localObject1	Object
    //   187	12	1	localException1	java.lang.Exception
    //   206	9	1	localObject2	Object
    //   216	30	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   78	102	187	java/lang/Exception
    //   14	78	206	finally
    //   78	102	206	finally
    //   102	108	206	finally
    //   108	119	206	finally
    //   119	140	206	finally
    //   140	173	206	finally
    //   173	175	206	finally
    //   188	203	206	finally
    //   207	209	206	finally
    //   217	232	206	finally
    //   235	255	206	finally
    //   108	119	216	java/lang/Exception
  }
  
  private void Fv()
  {
    AppMethodBeat.i(146452);
    if ((this.cqx.size() <= 0) && (this.cqw.size() <= 0) && (this.cqy.size() <= 0) && (this.cqz.size() <= 0))
    {
      ae.i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
      Ft().removeUpdates(null);
    }
    AppMethodBeat.o(146452);
  }
  
  protected boolean Fu()
  {
    return false;
  }
  
  public final void a(String paramString, a.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(146449);
    if ("wgs84".equals(paramString)) {
      this.cqw.add(paramb);
    }
    for (;;)
    {
      m.bCj().removeCallbacks(this.cqC);
      m.bCj().k(this.cqC, 20000L);
      boolean bool1 = paramBundle.getBoolean("enableIndoor");
      boolean bool2 = paramBundle.getBoolean("isHighAccuracy", false);
      int i = paramBundle.getInt("highAccuracyExpireTime", 3000);
      paramString = TencentLocationRequest.create();
      paramString.setInterval(2000L);
      paramString.setIndoorLocationMode(bool1);
      paramString.setSmallAppKey(paramBundle.getString("smallAppKey"));
      paramString.setmExpirationTime(i);
      i = Ft().requestSingleFreshLocation(paramString, this.cqA, Looper.getMainLooper(), bool2);
      ae.d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", new Object[] { paramBundle.getString("smallAppKey") });
      ae.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(146449);
      return;
      this.cqx.add(paramb);
    }
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
      ae.i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", new Object[] { paramString });
      if (!"wgs84".equals(paramString)) {
        break label260;
      }
      paramString = this.cqy.iterator();
      while (paramString.hasNext())
      {
        localb = (a.b)paramString.next();
        if ((localb != null) && (localb.equals(paramb)))
        {
          ae.w("MicroMsg.DefaultTencentLocationManager", "already register");
          AppMethodBeat.o(146450);
          return false;
        }
      }
      this.cqy.add(paramb);
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("smallAppKey");
        if (!bu.isNullOrNil(paramString)) {
          this.cqB.add(paramString);
        }
      }
      if ((paramBundle == null) || (!paramBundle.getBoolean("enableIndoor"))) {
        break label418;
      }
      bool = true;
      if (this.cqy.size() + this.cqz.size() != 1) {
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
      paramBundle = this.cqB.iterator();
      for (;;)
      {
        if (paramBundle.hasNext())
        {
          paramb.append((String)paramBundle.next());
          continue;
          label260:
          paramString = this.cqz.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              localb = (a.b)paramString.next();
              if ((localb != null) && (localb.equals(paramb)))
              {
                ae.w("MicroMsg.DefaultTencentLocationManager", "already register");
                AppMethodBeat.o(146450);
                break;
              }
            }
          }
          this.cqz.add(paramb);
          break;
        }
      }
      ae.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", new Object[] { paramb.toString() });
      paramString.setSmallAppKey(paramb.toString());
      ae.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(Ft().requestLocationUpdates(paramString, this.cqA, Looper.getMainLooper())) });
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
    //   2: ldc_w 490
    //   5: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 69
    //   10: ldc_w 492
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 82	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: ldc_w 380
    //   27: aload_1
    //   28: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +51 -> 82
    //   34: aload_0
    //   35: getfield 52	com/tencent/luggage/f/a/a:cqy	Ljava/util/List;
    //   38: aload_2
    //   39: invokeinterface 495 2 0
    //   44: pop
    //   45: aload_3
    //   46: ifnull +22 -> 68
    //   49: aload_3
    //   50: ldc_w 434
    //   53: invokevirtual 438	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 64	com/tencent/luggage/f/a/a:cqB	Ljava/util/Set;
    //   61: aload_1
    //   62: invokeinterface 496 2 0
    //   67: pop
    //   68: aload_0
    //   69: invokespecial 376	com/tencent/luggage/f/a/a:Fv	()V
    //   72: ldc_w 490
    //   75: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: getfield 54	com/tencent/luggage/f/a/a:cqz	Ljava/util/List;
    //   86: aload_2
    //   87: invokeinterface 495 2 0
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.f.a.a
 * JD-Core Version:    0.7.0.1
 */