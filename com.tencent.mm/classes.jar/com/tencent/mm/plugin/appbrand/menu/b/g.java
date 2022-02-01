package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import com.tencent.luggage.game.d.a.a.c;
import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.7;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements b<ah>
{
  boolean tlo = false;
  
  private void a(o paramo, MBRuntime paramMBRuntime, Context paramContext)
  {
    AppMethodBeat.i(323915);
    paramo.evaluateJavascript(";var __debug_v8_cpu_profiler = (function(profiler) {if (typeof profiler === 'undefined') { profiler = new NativeGlobal.CpuProfiler();} profiler.startProfiling(); return profiler;})(__debug_v8_cpu_profiler);", new g.1(this, paramContext));
    if (paramMBRuntime != null) {
      paramMBRuntime.dg(true);
    }
    AppMethodBeat.o(323915);
  }
  
  private void a(o paramo, MBRuntime paramMBRuntime, Context paramContext, String paramString)
  {
    AppMethodBeat.i(323918);
    paramo.evaluateJavascript(";(function(profiler) {return JSON.stringify(profiler.stopProfiling());})(__debug_v8_cpu_profiler);", new g.2(this, paramString, paramContext));
    if (paramMBRuntime != null) {
      paramMBRuntime.dg(false);
    }
    AppMethodBeat.o(323918);
  }
  
  private static List<o> ao(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(323912);
    if (paramAppBrandRuntime.ari() == null)
    {
      Log.e("MiroMsg.GameCpuProfile", "hy: service released. abort walking through workers");
      AppMethodBeat.o(323912);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.ari().cdn();
    if (paramAppBrandRuntime != null)
    {
      ConcurrentHashMap localConcurrentHashMap = paramAppBrandRuntime.qxg.hnT;
      if ((localConcurrentHashMap == null) || (localConcurrentHashMap.size() <= 0))
      {
        AppMethodBeat.o(323912);
        return null;
      }
      ArrayList localArrayList = new ArrayList(5);
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localConcurrentHashMap.get((Integer)localIterator.next());
        localArrayList.add(new v.7(paramAppBrandRuntime.qxg, localm));
      }
      AppMethodBeat.o(323912);
      return localArrayList;
    }
    AppMethodBeat.o(323912);
    return null;
  }
  
  private static e d(d paramd)
  {
    AppMethodBeat.i(323907);
    paramd = (c)paramd.aa(c.class);
    if (paramd != null)
    {
      paramd = paramd.getMagicBrush();
      AppMethodBeat.o(323907);
      return paramd;
    }
    AppMethodBeat.o(323907);
    return null;
  }
  
  /* Error */
  static boolean eZ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 164
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 169	com/tencent/mm/compatible/util/e:aPU	()Z
    //   10: ifne +17 -> 27
    //   13: ldc 67
    //   15: ldc 171
    //   17: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 164
    //   22: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aload 6
    //   35: astore 4
    //   37: new 173	com/tencent/mm/vfs/u
    //   40: dup
    //   41: new 175	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   48: invokestatic 182	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   51: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 188
    //   56: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 194	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   65: astore 7
    //   67: aload 6
    //   69: astore 4
    //   71: aload 7
    //   73: invokevirtual 197	com/tencent/mm/vfs/u:jKS	()Z
    //   76: ifne +13 -> 89
    //   79: aload 6
    //   81: astore 4
    //   83: aload 7
    //   85: invokevirtual 200	com/tencent/mm/vfs/u:jKY	()Z
    //   88: pop
    //   89: aload 6
    //   91: astore 4
    //   93: new 202	com/tencent/mm/vfs/ac
    //   96: dup
    //   97: new 173	com/tencent/mm/vfs/u
    //   100: dup
    //   101: aload 7
    //   103: aload_0
    //   104: invokespecial 205	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   107: iconst_0
    //   108: invokespecial 208	com/tencent/mm/vfs/ac:<init>	(Lcom/tencent/mm/vfs/u;Z)V
    //   111: astore_0
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 211	com/tencent/mm/vfs/ac:write	(Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore_2
    //   119: aload_0
    //   120: invokevirtual 214	com/tencent/mm/vfs/ac:close	()V
    //   123: ldc 164
    //   125: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iload_2
    //   129: ireturn
    //   130: astore_0
    //   131: ldc 67
    //   133: ldc 216
    //   135: aload_0
    //   136: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokevirtual 226	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: goto -22 -> 123
    //   148: astore_1
    //   149: aload 5
    //   151: astore_0
    //   152: aload_0
    //   153: astore 4
    //   155: ldc 67
    //   157: ldc 228
    //   159: aload_1
    //   160: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 226	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: iload_3
    //   170: istore_2
    //   171: aload_0
    //   172: ifnull -49 -> 123
    //   175: aload_0
    //   176: invokevirtual 214	com/tencent/mm/vfs/ac:close	()V
    //   179: iload_3
    //   180: istore_2
    //   181: goto -58 -> 123
    //   184: astore_0
    //   185: ldc 67
    //   187: ldc 216
    //   189: aload_0
    //   190: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokevirtual 226	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iload_3
    //   200: istore_2
    //   201: goto -78 -> 123
    //   204: astore_0
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 214	com/tencent/mm/vfs/ac:close	()V
    //   215: ldc 164
    //   217: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_0
    //   221: athrow
    //   222: astore_1
    //   223: ldc 67
    //   225: ldc 216
    //   227: aload_1
    //   228: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 226	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -22 -> 215
    //   240: astore_1
    //   241: aload_0
    //   242: astore 4
    //   244: aload_1
    //   245: astore_0
    //   246: goto -41 -> 205
    //   249: astore_1
    //   250: goto -98 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString1	String
    //   0	253	1	paramString2	String
    //   118	83	2	bool1	boolean
    //   1	199	3	bool2	boolean
    //   35	208	4	localObject1	Object
    //   31	119	5	localObject2	Object
    //   28	62	6	localObject3	Object
    //   65	37	7	localu	com.tencent.mm.vfs.u
    // Exception table:
    //   from	to	target	type
    //   119	123	130	java/lang/Exception
    //   37	67	148	java/lang/Exception
    //   71	79	148	java/lang/Exception
    //   83	89	148	java/lang/Exception
    //   93	112	148	java/lang/Exception
    //   175	179	184	java/lang/Exception
    //   37	67	204	finally
    //   71	79	204	finally
    //   83	89	204	finally
    //   93	112	204	finally
    //   155	169	204	finally
    //   210	215	222	java/lang/Exception
    //   112	117	240	finally
    //   112	117	249	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.g
 * JD-Core Version:    0.7.0.1
 */