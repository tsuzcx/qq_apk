package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class g
{
  private static Map<String, HashMap<String, b>> seQ;
  private static Set<b> seR;
  private static Set<b> seS;
  public static a seT;
  private static Runnable seU;
  public static SensorManager sensorManager;
  
  static
  {
    AppMethodBeat.i(143728);
    seQ = new HashMap();
    seS = new HashSet();
    seR = new CopyOnWriteArraySet();
    seU = new Runnable()
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
      Log.i("MicroMsg.AppBrandMapManager", "registerListener map:%s", new Object[] { paramb });
      seS.add(paramb);
      if (seS.size() == 1) {
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
    //   3: ldc 81
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 83
    //   10: aload_1
    //   11: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +22 -> 36
    //   17: ldc 59
    //   19: ldc 90
    //   21: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc 81
    //   26: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: istore_3
    //   31: ldc 2
    //   33: monitorexit
    //   34: iload_3
    //   35: ireturn
    //   36: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seQ	Ljava/util/Map;
    //   39: aload_0
    //   40: invokeinterface 100 2 0
    //   45: checkcast 33	java/util/HashMap
    //   48: astore 5
    //   50: aload 5
    //   52: astore 4
    //   54: aload 5
    //   56: ifnonnull +24 -> 80
    //   59: new 33	java/util/HashMap
    //   62: dup
    //   63: invokespecial 36	java/util/HashMap:<init>	()V
    //   66: astore 4
    //   68: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seQ	Ljava/util/Map;
    //   71: aload_0
    //   72: aload 4
    //   74: invokeinterface 104 3 0
    //   79: pop
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 107	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   86: ifeq +20 -> 106
    //   89: ldc 59
    //   91: ldc 109
    //   93: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 81
    //   98: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_0
    //   102: istore_3
    //   103: goto -72 -> 31
    //   106: aload 4
    //   108: aload_1
    //   109: aload_2
    //   110: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: ldc 59
    //   116: ldc 115
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
    //   130: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 81
    //   135: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      Log.i("MicroMsg.AppBrandMapManager", "unregisterListener map:%s", new Object[] { paramb });
      seS.remove(paramb);
      if (seS.size() == 0) {
        uninit();
      }
      AppMethodBeat.o(143723);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static b ed(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 157
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 83
    //   10: aload_1
    //   11: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +22 -> 36
    //   17: ldc 59
    //   19: ldc 159
    //   21: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc 157
    //   26: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aconst_null
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seQ	Ljava/util/Map;
    //   39: aload_0
    //   40: invokeinterface 100 2 0
    //   45: checkcast 33	java/util/HashMap
    //   48: astore_0
    //   49: aload_0
    //   50: ifnonnull +13 -> 63
    //   53: ldc 157
    //   55: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aconst_null
    //   59: astore_0
    //   60: goto -29 -> 31
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 141	com/tencent/mm/plugin/appbrand/jsapi/o/a/b
    //   71: astore_0
    //   72: ldc 157
    //   74: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static boolean ee(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 163
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seQ	Ljava/util/Map;
    //   11: aload_0
    //   12: invokeinterface 100 2 0
    //   17: checkcast 33	java/util/HashMap
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +15 -> 37
    //   25: ldc 163
    //   27: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: istore_2
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_3
    //   38: aload_1
    //   39: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 141	com/tencent/mm/plugin/appbrand/jsapi/o/a/b
    //   45: astore 4
    //   47: aload 4
    //   49: ifnonnull +20 -> 69
    //   52: ldc 59
    //   54: ldc 165
    //   56: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 163
    //   61: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_0
    //   65: istore_2
    //   66: goto -34 -> 32
    //   69: ldc 59
    //   71: ldc 167
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload 4
    //   81: aastore
    //   82: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_3
    //   86: aload_1
    //   87: invokevirtual 169	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload 4
    //   93: invokestatic 171	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/o/a/b;)V
    //   96: aload_3
    //   97: invokevirtual 172	java/util/HashMap:size	()I
    //   100: ifgt +13 -> 113
    //   103: getstatic 38	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seQ	Ljava/util/Map;
    //   106: aload_0
    //   107: invokeinterface 173 2 0
    //   112: pop
    //   113: getstatic 48	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seR	Ljava/util/Set;
    //   116: aload 4
    //   118: invokeinterface 72 2 0
    //   123: pop
    //   124: getstatic 51	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seU	Ljava/lang/Runnable;
    //   127: invokestatic 179	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   130: getstatic 51	com/tencent/mm/plugin/appbrand/jsapi/o/a/g:seU	Ljava/lang/Runnable;
    //   133: ldc2_w 180
    //   136: invokestatic 185	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   139: ldc 59
    //   141: ldc 187
    //   143: iconst_2
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_0
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: aload_3
    //   154: invokevirtual 172	java/util/HashMap:size	()I
    //   157: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: ldc 163
    //   166: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      Log.i("MicroMsg.AppBrandMapManager", "init");
      if (seT == null)
      {
        seT = new a();
        Object localObject1 = (SensorManager)MMApplicationContext.getContext().getSystemService("sensor");
        sensorManager = (SensorManager)localObject1;
        localObject1 = ((SensorManager)localObject1).getDefaultSensor(3);
        sensorManager.registerListener(seT, (Sensor)localObject1, 1);
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
      Log.i("MicroMsg.AppBrandMapManager", "uninit");
      if ((seT != null) && (sensorManager != null))
      {
        Log.i("MicroMsg.AppBrandMapManager", "sensorListener uninit");
        sensorManager.unregisterListener(seT);
        sensorManager = null;
        seT = null;
      }
      AppMethodBeat.o(143722);
      return;
    }
    finally {}
  }
  
  static final class a
    implements SensorEventListener
  {
    private float seV = 0.0F;
    private long timestamp = 200L;
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent arg1)
    {
      AppMethodBeat.i(143719);
      if (???.sensor.getType() == 3)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.timestamp;
        float f = f.bJ(???.values[0]);
        if ((l1 - l2 > 200L) && (Math.abs(f - this.seV) > 3.0F))
        {
          synchronized (g.aCw())
          {
            Iterator localIterator1 = g.aCw().values().iterator();
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
            localb.aq(this.seV, f);
          }
          this.seV = f;
          this.timestamp = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(143719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.g
 * JD-Core Version:    0.7.0.1
 */