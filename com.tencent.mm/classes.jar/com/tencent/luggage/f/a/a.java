package com.tencent.luggage.f.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.LocationLogCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.mm.plugin.appbrand.utils.b.a
{
  private volatile TencentLocationManager ciG;
  @SuppressLint({"NewApi"})
  private final List<a.b> ciH;
  @SuppressLint({"NewApi"})
  private final List<a.b> ciI;
  @SuppressLint({"NewApi"})
  private final List<a.b> ciJ;
  @SuppressLint({"NewApi"})
  private final List<a.b> ciK;
  TencentLocationListener ciL;
  private Set<String> ciM;
  private Runnable ciN;
  
  public a()
  {
    AppMethodBeat.i(146447);
    this.ciH = new CopyOnWriteArrayList();
    this.ciI = new CopyOnWriteArrayList();
    this.ciJ = new CopyOnWriteArrayList();
    this.ciK = new CopyOnWriteArrayList();
    this.ciL = new TencentLocationListener()
    {
      public final void onLocationChanged(final TencentLocation paramAnonymousTencentLocation, final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(146444);
        if (aq.isMainThread())
        {
          h.Iye.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193596);
              jdField_this.onLocationChanged(paramAnonymousTencentLocation, paramAnonymousInt, paramAnonymousString);
              AppMethodBeat.o(193596);
            }
          }, "MicroMsg.DefaultTencentLocationManager");
          AppMethodBeat.o(146444);
          return;
        }
        ad.v("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt != 0) {
          ad.e("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
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
        AppMethodBeat.o(146444);
      }
      
      public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      {
        AppMethodBeat.i(146445);
        ad.i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2 });
        AppMethodBeat.o(146445);
      }
    };
    this.ciM = new HashSet();
    this.ciN = new Runnable()
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
    ad.i("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", new Object[] { aj.getProcessName() });
    AppMethodBeat.o(146447);
  }
  
  /* Error */
  private TencentLocationManager Em()
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 93	com/tencent/luggage/f/a/a:ciG	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   9: ifnonnull +162 -> 171
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 93	com/tencent/luggage/f/a/a:ciG	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   18: ifnonnull +151 -> 169
    //   21: aload_0
    //   22: invokevirtual 97	com/tencent/luggage/f/a/a:En	()Z
    //   25: ifeq +77 -> 102
    //   28: new 99	com/tencent/mm/vfs/e
    //   31: dup
    //   32: new 101	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   39: invokestatic 107	com/tencent/mm/loader/j/b:aih	()Ljava/lang/String;
    //   42: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 113
    //   47: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokestatic 77	com/tencent/mm/sdk/platformtools/aj:getProcessName	()Ljava/lang/String;
    //   53: invokestatic 116	com/tencent/mm/sdk/platformtools/aj:getPackageName	()Ljava/lang/String;
    //   56: invokevirtual 122	java/lang/String:length	()I
    //   59: iconst_1
    //   60: iadd
    //   61: invokevirtual 126	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_1
    //   71: invokestatic 135	com/tencent/mm/vfs/i:k	(Ljava/lang/String;Z)Ljava/lang/String;
    //   74: invokespecial 138	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: invokestatic 142	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   81: new 144	java/io/File
    //   84: dup
    //   85: aload_1
    //   86: getfield 148	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   89: invokestatic 154	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   92: iconst_1
    //   93: invokestatic 135	com/tencent/mm/vfs/i:k	(Ljava/lang/String;Z)Ljava/lang/String;
    //   96: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokestatic 161	com/tencent/map/geolocation/internal/TencentExtraKeys:setTencentLog	(Landroid/content/Context;Ljava/io/File;)V
    //   102: invokestatic 142	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   105: invokestatic 165	com/tencent/map/geolocation/internal/TencentExtraKeys:setContext	(Landroid/content/Context;)V
    //   108: new 8	com/tencent/luggage/f/a/a$1
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 166	com/tencent/luggage/f/a/a$1:<init>	(Lcom/tencent/luggage/f/a/a;)V
    //   116: invokestatic 170	com/tencent/map/geolocation/internal/TencentExtraKeys:setTencentLogCallback	(Lcom/tencent/map/geolocation/internal/LocationLogCallback;)V
    //   119: invokestatic 175	com/tencent/mm/compatible/deviceinfo/q:getOAID	()Ljava/lang/String;
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +104 -> 231
    //   130: aload_0
    //   131: invokestatic 142	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   134: invokestatic 187	com/tencent/map/geolocation/TencentLocationManager:getInstance	(Landroid/content/Context;)Lcom/tencent/map/geolocation/TencentLocationManager;
    //   137: putfield 93	com/tencent/luggage/f/a/a:ciG	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   140: aload_0
    //   141: getfield 93	com/tencent/luggage/f/a/a:ciG	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   144: iconst_0
    //   145: invokevirtual 190	com/tencent/map/geolocation/TencentLocationManager:setCoordinateType	(I)V
    //   148: ldc 69
    //   150: ldc 192
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_0
    //   159: getfield 93	com/tencent/luggage/f/a/a:ciG	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   162: invokevirtual 195	com/tencent/map/geolocation/TencentLocationManager:getVersion	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_0
    //   172: getfield 93	com/tencent/luggage/f/a/a:ciG	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   175: astore_1
    //   176: ldc 91
    //   178: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: areturn
    //   183: astore_1
    //   184: ldc 69
    //   186: ldc 197
    //   188: iconst_1
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_1
    //   195: aastore
    //   196: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: goto -97 -> 102
    //   202: astore_1
    //   203: aload_0
    //   204: monitorexit
    //   205: ldc 91
    //   207: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: ldc 69
    //   215: ldc 197
    //   217: iconst_1
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload_1
    //   224: aastore
    //   225: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: goto -109 -> 119
    //   231: aload_0
    //   232: invokestatic 142	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   235: new 202	android/util/Pair
    //   238: dup
    //   239: ldc 204
    //   241: aload_1
    //   242: invokespecial 207	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   245: invokestatic 210	com/tencent/map/geolocation/TencentLocationManager:getInstance	(Landroid/content/Context;Landroid/util/Pair;)Lcom/tencent/map/geolocation/TencentLocationManager;
    //   248: putfield 93	com/tencent/luggage/f/a/a:ciG	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   251: goto -111 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	a
    //   77	105	1	localObject1	Object
    //   183	12	1	localException1	java.lang.Exception
    //   202	9	1	localObject2	Object
    //   212	30	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   78	102	183	java/lang/Exception
    //   14	78	202	finally
    //   78	102	202	finally
    //   102	108	202	finally
    //   108	119	202	finally
    //   119	140	202	finally
    //   140	169	202	finally
    //   169	171	202	finally
    //   184	199	202	finally
    //   203	205	202	finally
    //   213	228	202	finally
    //   231	251	202	finally
    //   108	119	212	java/lang/Exception
  }
  
  private void Eo()
  {
    AppMethodBeat.i(146452);
    if ((this.ciI.size() <= 0) && (this.ciH.size() <= 0) && (this.ciJ.size() <= 0) && (this.ciK.size() <= 0))
    {
      ad.i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
      Em().removeUpdates(null);
    }
    AppMethodBeat.o(146452);
  }
  
  protected boolean En()
  {
    return false;
  }
  
  public final void a(String paramString, a.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(146449);
    if ("wgs84".equals(paramString)) {
      this.ciH.add(paramb);
    }
    for (;;)
    {
      l.bqm().removeCallbacks(this.ciN);
      l.bqm().j(this.ciN, 20000L);
      boolean bool1 = paramBundle.getBoolean("enableIndoor");
      boolean bool2 = paramBundle.getBoolean("isHighAccuracy", false);
      int i = paramBundle.getInt("highAccuracyExpireTime", 3000);
      paramString = TencentLocationRequest.create();
      paramString.setInterval(2000L);
      paramString.setIndoorLocationMode(bool1);
      paramString.setSmallAppKey(paramBundle.getString("smallAppKey"));
      paramString.setmExpirationTime(i);
      i = Em().requestSingleFreshLocation(paramString, this.ciL, Looper.getMainLooper(), bool2);
      ad.d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", new Object[] { paramBundle.getString("smallAppKey") });
      ad.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(146449);
      return;
      this.ciI.add(paramb);
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
      ad.i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", new Object[] { paramString });
      if (!"wgs84".equals(paramString)) {
        break label260;
      }
      paramString = this.ciJ.iterator();
      while (paramString.hasNext())
      {
        localb = (a.b)paramString.next();
        if ((localb != null) && (localb.equals(paramb)))
        {
          ad.w("MicroMsg.DefaultTencentLocationManager", "already register");
          AppMethodBeat.o(146450);
          return false;
        }
      }
      this.ciJ.add(paramb);
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("smallAppKey");
        if (!bt.isNullOrNil(paramString)) {
          this.ciM.add(paramString);
        }
      }
      if ((paramBundle == null) || (!paramBundle.getBoolean("enableIndoor"))) {
        break label418;
      }
      bool = true;
      if (this.ciJ.size() + this.ciK.size() != 1) {
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
      paramBundle = this.ciM.iterator();
      for (;;)
      {
        if (paramBundle.hasNext())
        {
          paramb.append((String)paramBundle.next());
          continue;
          label260:
          paramString = this.ciK.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              localb = (a.b)paramString.next();
              if ((localb != null) && (localb.equals(paramb)))
              {
                ad.w("MicroMsg.DefaultTencentLocationManager", "already register");
                AppMethodBeat.o(146450);
                break;
              }
            }
          }
          this.ciK.add(paramb);
          break;
        }
      }
      ad.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", new Object[] { paramb.toString() });
      paramString.setSmallAppKey(paramb.toString());
      ad.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(Em().requestLocationUpdates(paramString, this.ciL, Looper.getMainLooper())) });
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
    //   2: ldc_w 491
    //   5: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 69
    //   10: ldc_w 493
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: ldc_w 380
    //   27: aload_1
    //   28: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +51 -> 82
    //   34: aload_0
    //   35: getfield 52	com/tencent/luggage/f/a/a:ciJ	Ljava/util/List;
    //   38: aload_2
    //   39: invokeinterface 496 2 0
    //   44: pop
    //   45: aload_3
    //   46: ifnull +22 -> 68
    //   49: aload_3
    //   50: ldc_w 435
    //   53: invokevirtual 439	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 64	com/tencent/luggage/f/a/a:ciM	Ljava/util/Set;
    //   61: aload_1
    //   62: invokeinterface 497 2 0
    //   67: pop
    //   68: aload_0
    //   69: invokespecial 376	com/tencent/luggage/f/a/a:Eo	()V
    //   72: ldc_w 491
    //   75: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: getfield 54	com/tencent/luggage/f/a/a:ciK	Ljava/util/List;
    //   86: aload_2
    //   87: invokeinterface 496 2 0
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