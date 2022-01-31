package com.tencent.luggage.f.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.HandlerThread;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.t.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements com.tencent.mm.plugin.appbrand.t.b.a
{
  private volatile TencentLocationManager bFl;
  @SuppressLint({"NewApi"})
  private final List<a.b> bFm;
  @SuppressLint({"NewApi"})
  private final List<a.b> bFn;
  @SuppressLint({"NewApi"})
  private final List<a.b> bFo;
  @SuppressLint({"NewApi"})
  private final List<a.b> bFp;
  TencentLocationListener bFq;
  private Set<String> bFr;
  private Runnable bFs;
  
  public a()
  {
    AppMethodBeat.i(51138);
    this.bFm = new CopyOnWriteArrayList();
    this.bFn = new CopyOnWriteArrayList();
    this.bFo = new CopyOnWriteArrayList();
    this.bFp = new CopyOnWriteArrayList();
    this.bFq = new a.2(this);
    this.bFr = new HashSet();
    this.bFs = new a.3(this);
    ab.i("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", new Object[] { ah.getProcessName() });
    AppMethodBeat.o(51138);
  }
  
  /* Error */
  private TencentLocationManager xa()
  {
    // Byte code:
    //   0: ldc 223
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 225	com/tencent/luggage/f/a/a:bFl	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   9: ifnonnull +131 -> 140
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 225	com/tencent/luggage/f/a/a:bFl	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   18: ifnonnull +120 -> 138
    //   21: aload_0
    //   22: invokevirtual 228	com/tencent/luggage/f/a/a:xb	()Z
    //   25: ifeq +56 -> 81
    //   28: new 230	java/io/File
    //   31: dup
    //   32: new 232	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   39: getstatic 238	com/tencent/mm/loader/j/b:eQz	Ljava/lang/String;
    //   42: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 244
    //   47: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokestatic 73	com/tencent/mm/sdk/platformtools/ah:getProcessName	()Ljava/lang/String;
    //   53: invokestatic 247	com/tencent/mm/sdk/platformtools/ah:getPackageName	()Ljava/lang/String;
    //   56: invokevirtual 250	java/lang/String:length	()I
    //   59: iconst_1
    //   60: iadd
    //   61: invokevirtual 254	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: invokestatic 264	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   77: aload_1
    //   78: invokestatic 270	com/tencent/map/geolocation/internal/TencentExtraKeys:setTencentLog	(Landroid/content/Context;Ljava/io/File;)V
    //   81: aload_0
    //   82: invokestatic 264	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   85: invokestatic 276	com/tencent/map/geolocation/TencentLocationManager:getInstance	(Landroid/content/Context;)Lcom/tencent/map/geolocation/TencentLocationManager;
    //   88: putfield 225	com/tencent/luggage/f/a/a:bFl	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   91: aload_0
    //   92: getfield 225	com/tencent/luggage/f/a/a:bFl	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   95: iconst_0
    //   96: invokevirtual 279	com/tencent/map/geolocation/TencentLocationManager:setCoordinateType	(I)V
    //   99: invokestatic 264	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   102: invokestatic 283	com/tencent/map/geolocation/internal/TencentExtraKeys:setContext	(Landroid/content/Context;)V
    //   105: new 285	com/tencent/luggage/f/a/a$1
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 286	com/tencent/luggage/f/a/a$1:<init>	(Lcom/tencent/luggage/f/a/a;)V
    //   113: invokestatic 290	com/tencent/map/geolocation/internal/TencentExtraKeys:setTencentLogCallback	(Lcom/tencent/map/geolocation/internal/LocationLogCallback;)V
    //   116: ldc 65
    //   118: ldc_w 292
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_0
    //   128: getfield 225	com/tencent/luggage/f/a/a:bFl	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   131: invokevirtual 295	com/tencent/map/geolocation/TencentLocationManager:getVersion	()Ljava/lang/String;
    //   134: aastore
    //   135: invokestatic 78	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_0
    //   141: getfield 225	com/tencent/luggage/f/a/a:bFl	Lcom/tencent/map/geolocation/TencentLocationManager;
    //   144: astore_1
    //   145: ldc 223
    //   147: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: areturn
    //   152: astore_1
    //   153: ldc 65
    //   155: ldc 186
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_1
    //   164: aastore
    //   165: invokestatic 297	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: goto -87 -> 81
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: ldc 223
    //   176: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: ldc 65
    //   184: ldc 186
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: aastore
    //   194: invokestatic 297	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: goto -81 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	a
    //   73	78	1	localObject1	Object
    //   152	12	1	localException1	java.lang.Exception
    //   171	9	1	localObject2	Object
    //   181	12	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   74	81	152	java/lang/Exception
    //   14	74	171	finally
    //   74	81	171	finally
    //   81	105	171	finally
    //   105	116	171	finally
    //   116	138	171	finally
    //   138	140	171	finally
    //   153	168	171	finally
    //   172	174	171	finally
    //   182	197	171	finally
    //   105	116	181	java/lang/Exception
  }
  
  private void xc()
  {
    AppMethodBeat.i(51143);
    if ((this.bFn.size() <= 0) && (this.bFm.size() <= 0) && (this.bFo.size() <= 0) && (this.bFp.size() <= 0))
    {
      ab.i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
      xa().removeUpdates(null);
    }
    AppMethodBeat.o(51143);
  }
  
  public final void a(String paramString, a.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    if ("wgs84".equals(paramString)) {
      this.bFm.add(paramb);
    }
    for (;;)
    {
      m.aNS().caB().removeCallbacks(this.bFs);
      m.aNS().o(this.bFs, 20000L);
      boolean bool = paramBundle.getBoolean("enableIndoor");
      paramString = TencentLocationRequest.create();
      paramString.setInterval(2000L);
      paramString.setIndoorLocationMode(bool);
      paramString.setSmallAppKey(paramBundle.getString("smallAppKey"));
      int i = xa().requestSingleFreshLocation(paramString, this.bFq, m.aNS().oNc.getLooper());
      ab.d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", new Object[] { paramBundle.getString("smallAppKey") });
      ab.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(51140);
      return;
      this.bFn.add(paramb);
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
      AppMethodBeat.i(51141);
      ab.i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", new Object[] { paramString });
      if (!"wgs84".equals(paramString)) {
        break label260;
      }
      paramString = this.bFo.iterator();
      while (paramString.hasNext())
      {
        localb = (a.b)paramString.next();
        if ((localb != null) && (localb.equals(paramb)))
        {
          ab.w("MicroMsg.DefaultTencentLocationManager", "already register");
          AppMethodBeat.o(51141);
          return false;
        }
      }
      this.bFo.add(paramb);
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("smallAppKey");
        if (!bo.isNullOrNil(paramString)) {
          this.bFr.add(paramString);
        }
      }
      if ((paramBundle == null) || (!paramBundle.getBoolean("enableIndoor"))) {
        break label424;
      }
      bool = true;
      if (this.bFo.size() + this.bFp.size() != 1) {
        break label430;
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
      paramBundle = this.bFr.iterator();
      for (;;)
      {
        if (paramBundle.hasNext())
        {
          paramb.append((String)paramBundle.next());
          continue;
          label260:
          paramString = this.bFp.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              localb = (a.b)paramString.next();
              if ((localb != null) && (localb.equals(paramb)))
              {
                ab.w("MicroMsg.DefaultTencentLocationManager", "already register");
                AppMethodBeat.o(51141);
                break;
              }
            }
          }
          this.bFp.add(paramb);
          break;
        }
      }
      ab.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", new Object[] { paramb.toString() });
      paramString.setSmallAppKey(paramb.toString());
      ab.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(xa().requestLocationUpdates(paramString, this.bFq, m.aNS().oNc.getLooper())) });
      label402:
      AppMethodBeat.o(51141);
      break;
      for (;;)
      {
        if (i != 0) {
          break label434;
        }
        if (!bool) {
          break label402;
        }
        break label183;
        label424:
        bool = false;
        break;
        label430:
        i = 0;
      }
      label434:
      break label183;
    }
  }
  
  /* Error */
  public final boolean c(String paramString, a.b paramb, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 423
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 65
    //   10: ldc_w 425
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 78	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: ldc_w 316
    //   27: aload_1
    //   28: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +51 -> 82
    //   34: aload_0
    //   35: getfield 44	com/tencent/luggage/f/a/a:bFo	Ljava/util/List;
    //   38: aload_2
    //   39: invokeinterface 428 2 0
    //   44: pop
    //   45: aload_3
    //   46: ifnull +22 -> 68
    //   49: aload_3
    //   50: ldc_w 367
    //   53: invokevirtual 371	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 58	com/tencent/luggage/f/a/a:bFr	Ljava/util/Set;
    //   61: aload_1
    //   62: invokeinterface 429 2 0
    //   67: pop
    //   68: aload_0
    //   69: invokespecial 218	com/tencent/luggage/f/a/a:xc	()V
    //   72: ldc_w 423
    //   75: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: getfield 46	com/tencent/luggage/f/a/a:bFp	Ljava/util/List;
    //   86: aload_2
    //   87: invokeinterface 428 2 0
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
  
  protected boolean xb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.f.a.a
 * JD-Core Version:    0.7.0.1
 */