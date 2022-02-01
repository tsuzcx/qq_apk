package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(3)
public final class g
{
  private static Map<String, HashMap<String, b>> kSF;
  private static Set<b> kSG;
  private static Set<b> kSH;
  public static a kSI;
  private static Runnable kSJ;
  public static SensorManager sensorManager;
  
  static
  {
    AppMethodBeat.i(143728);
    kSF = new HashMap();
    kSH = new HashSet();
    kSG = new CopyOnWriteArraySet();
    kSJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143718);
        g.access$000();
        AppMethodBeat.o(143718);
      }
    };
    AppMethodBeat.o(143728);
  }
  
  public static void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(143721);
      ad.i("MicroMsg.AppBrandMapManager", "registerListener map:%s", new Object[] { paramb });
      kSH.add(paramb);
      if (kSH.size() == 1) {
        init();
      }
      AppMethodBeat.o(143721);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, b paramb)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 84
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 86
    //   10: aload_1
    //   11: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +22 -> 36
    //   17: ldc 62
    //   19: ldc 93
    //   21: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc 84
    //   26: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: istore_3
    //   31: ldc 2
    //   33: monitorexit
    //   34: iload_3
    //   35: ireturn
    //   36: getstatic 41	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSF	Ljava/util/Map;
    //   39: aload_0
    //   40: invokeinterface 103 2 0
    //   45: checkcast 36	java/util/HashMap
    //   48: astore 5
    //   50: aload 5
    //   52: astore 4
    //   54: aload 5
    //   56: ifnonnull +24 -> 80
    //   59: new 36	java/util/HashMap
    //   62: dup
    //   63: invokespecial 39	java/util/HashMap:<init>	()V
    //   66: astore 4
    //   68: getstatic 41	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSF	Ljava/util/Map;
    //   71: aload_0
    //   72: aload 4
    //   74: invokeinterface 107 3 0
    //   79: pop
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 110	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   86: ifeq +20 -> 106
    //   89: ldc 62
    //   91: ldc 112
    //   93: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 84
    //   98: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_0
    //   102: istore_3
    //   103: goto -72 -> 31
    //   106: aload 4
    //   108: aload_1
    //   109: aload_2
    //   110: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: ldc 62
    //   116: ldc 118
    //   118: iconst_2
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_0
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 84
    //   135: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_1
    //   139: istore_3
    //   140: goto -109 -> 31
    //   143: astore_0
    //   144: ldc 2
    //   146: monitorexit
    //   147: aload_0
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString1	String
    //   0	149	1	paramString2	String
    //   0	149	2	paramb	b
    //   30	110	3	bool	boolean
    //   52	55	4	localHashMap1	HashMap
    //   48	7	5	localHashMap2	HashMap
    // Exception table:
    //   from	to	target	type
    //   3	29	143	finally
    //   36	50	143	finally
    //   59	80	143	finally
    //   80	101	143	finally
    //   106	138	143	finally
  }
  
  public static void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(143723);
      ad.i("MicroMsg.AppBrandMapManager", "unregisterListener map:%s", new Object[] { paramb });
      kSH.remove(paramb);
      if (kSH.size() == 0) {
        uninit();
      }
      AppMethodBeat.o(143723);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static b di(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 160
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 86
    //   10: aload_1
    //   11: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +22 -> 36
    //   17: ldc 62
    //   19: ldc 162
    //   21: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc 160
    //   26: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aconst_null
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: getstatic 41	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSF	Ljava/util/Map;
    //   39: aload_0
    //   40: invokeinterface 103 2 0
    //   45: checkcast 36	java/util/HashMap
    //   48: astore_0
    //   49: aload_0
    //   50: ifnonnull +13 -> 63
    //   53: ldc 160
    //   55: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aconst_null
    //   59: astore_0
    //   60: goto -29 -> 31
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 163	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 144	com/tencent/mm/plugin/appbrand/jsapi/i/a/b
    //   71: astore_0
    //   72: ldc 160
    //   74: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: goto -46 -> 31
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramString1	String
    //   0	86	1	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   3	29	80	finally
    //   36	49	80	finally
    //   53	58	80	finally
    //   63	77	80	finally
  }
  
  /* Error */
  public static boolean dj(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 166
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 41	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSF	Ljava/util/Map;
    //   11: aload_0
    //   12: invokeinterface 103 2 0
    //   17: checkcast 36	java/util/HashMap
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +15 -> 37
    //   25: ldc 166
    //   27: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: istore_2
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_3
    //   38: aload_1
    //   39: invokevirtual 163	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 144	com/tencent/mm/plugin/appbrand/jsapi/i/a/b
    //   45: astore 4
    //   47: aload 4
    //   49: ifnonnull +20 -> 69
    //   52: ldc 62
    //   54: ldc 168
    //   56: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 166
    //   61: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_0
    //   65: istore_2
    //   66: goto -34 -> 32
    //   69: ldc 62
    //   71: ldc 170
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload 4
    //   81: aastore
    //   82: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_3
    //   86: aload_1
    //   87: invokevirtual 172	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload 4
    //   93: invokestatic 174	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/i/a/b;)V
    //   96: aload_3
    //   97: invokevirtual 175	java/util/HashMap:size	()I
    //   100: ifgt +13 -> 113
    //   103: getstatic 41	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSF	Ljava/util/Map;
    //   106: aload_0
    //   107: invokeinterface 176 2 0
    //   112: pop
    //   113: getstatic 51	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSG	Ljava/util/Set;
    //   116: aload 4
    //   118: invokeinterface 75 2 0
    //   123: pop
    //   124: getstatic 54	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSJ	Ljava/lang/Runnable;
    //   127: invokestatic 182	com/tencent/mm/sdk/platformtools/aq:aA	(Ljava/lang/Runnable;)V
    //   130: getstatic 54	com/tencent/mm/plugin/appbrand/jsapi/i/a/g:kSJ	Ljava/lang/Runnable;
    //   133: ldc2_w 183
    //   136: invokestatic 187	com/tencent/mm/sdk/platformtools/aq:o	(Ljava/lang/Runnable;J)V
    //   139: ldc 62
    //   141: ldc 189
    //   143: iconst_2
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_0
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: aload_3
    //   154: invokevirtual 175	java/util/HashMap:size	()I
    //   157: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: ldc 166
    //   166: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: iconst_1
    //   170: istore_2
    //   171: goto -139 -> 32
    //   174: astore_0
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString1	String
    //   0	180	1	paramString2	String
    //   31	140	2	bool	boolean
    //   20	134	3	localHashMap	HashMap
    //   45	72	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   3	21	174	finally
    //   25	30	174	finally
    //   37	47	174	finally
    //   52	64	174	finally
    //   69	113	174	finally
    //   113	169	174	finally
  }
  
  private static void init()
  {
    try
    {
      AppMethodBeat.i(143720);
      ad.i("MicroMsg.AppBrandMapManager", "init");
      if (kSI == null)
      {
        kSI = new a();
        Object localObject1 = (SensorManager)aj.getContext().getSystemService("sensor");
        sensorManager = (SensorManager)localObject1;
        localObject1 = ((SensorManager)localObject1).getDefaultSensor(3);
        sensorManager.registerListener(kSI, (Sensor)localObject1, 1);
      }
      AppMethodBeat.o(143720);
      return;
    }
    finally {}
  }
  
  private static void uninit()
  {
    try
    {
      AppMethodBeat.i(143722);
      ad.i("MicroMsg.AppBrandMapManager", "uninit");
      if ((kSI != null) && (sensorManager != null))
      {
        ad.i("MicroMsg.AppBrandMapManager", "sensorListener uninit");
        sensorManager.unregisterListener(kSI);
        sensorManager = null;
        kSI = null;
      }
      AppMethodBeat.o(143722);
      return;
    }
    finally {}
  }
  
  static final class a
    implements SensorEventListener
  {
    private float kSK = 0.0F;
    private long timestamp = 200L;
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent arg1)
    {
      AppMethodBeat.i(143719);
      if (???.sensor.getType() == 3)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.timestamp;
        float f = f.aB(???.values[0]);
        if ((l1 - l2 > 200L) && (Math.abs(f - this.kSK) > 3.0F))
        {
          synchronized (g.aaT())
          {
            Iterator localIterator1 = g.aaT().values().iterator();
            b localb;
            do
            {
              Iterator localIterator2;
              while (!localIterator2.hasNext())
              {
                if (!localIterator1.hasNext()) {
                  break;
                }
                localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
              }
              localb = (b)localIterator2.next();
            } while (localb == null);
            localb.H(this.kSK, f);
          }
          this.kSK = f;
          this.timestamp = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(143719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.g
 * JD-Core Version:    0.7.0.1
 */