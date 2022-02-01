package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements b<ad>
{
  boolean lYm = false;
  
  private static List<o> Z(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(222832);
    if (paramAppBrandRuntime.Ey() == null)
    {
      ae.e("MiroMsg.GameCpuProfile", "hy: service released. abort walking through workers");
      AppMethodBeat.o(222832);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.Ey().aXW();
    if (paramAppBrandRuntime != null)
    {
      ConcurrentHashMap localConcurrentHashMap = paramAppBrandRuntime.jDu.dav;
      if ((localConcurrentHashMap == null) || (localConcurrentHashMap.size() <= 0))
      {
        AppMethodBeat.o(222832);
        return null;
      }
      ArrayList localArrayList = new ArrayList(5);
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localConcurrentHashMap.get((Integer)localIterator.next());
        localArrayList.add(paramAppBrandRuntime.jDu.b(localm));
      }
      AppMethodBeat.o(222832);
      return localArrayList;
    }
    AppMethodBeat.o(222832);
    return null;
  }
  
  private void a(o paramo, MBRuntime paramMBRuntime, final Context paramContext)
  {
    AppMethodBeat.i(222833);
    paramo.evaluateJavascript(";var __debug_v8_cpu_profiler = (function(profiler) {if (typeof profiler === 'undefined') { profiler = new NativeGlobal.CpuProfiler();} profiler.startProfiling(); return profiler;})(__debug_v8_cpu_profiler);", new ValueCallback() {});
    if (paramMBRuntime != null) {
      paramMBRuntime.bN(true);
    }
    AppMethodBeat.o(222833);
  }
  
  private void a(o paramo, MBRuntime paramMBRuntime, final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(222834);
    paramo.evaluateJavascript(";(function(profiler) {return JSON.stringify(profiler.stopProfiling());})(__debug_v8_cpu_profiler);", new ValueCallback() {});
    if (paramMBRuntime != null) {
      paramMBRuntime.bN(false);
    }
    AppMethodBeat.o(222834);
  }
  
  /* Error */
  static boolean ed(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 153
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 158	com/tencent/mm/compatible/util/e:abo	()Z
    //   10: ifne +17 -> 27
    //   13: ldc 42
    //   15: ldc 160
    //   17: invokestatic 50	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 153
    //   22: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aload 6
    //   35: astore 4
    //   37: new 162	com/tencent/mm/vfs/k
    //   40: dup
    //   41: new 164	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   48: invokestatic 171	com/tencent/mm/loader/j/b:asj	()Ljava/lang/String;
    //   51: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 177
    //   56: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 183	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   65: astore 7
    //   67: aload 6
    //   69: astore 4
    //   71: aload 7
    //   73: invokevirtual 186	com/tencent/mm/vfs/k:exists	()Z
    //   76: ifne +13 -> 89
    //   79: aload 6
    //   81: astore 4
    //   83: aload 7
    //   85: invokevirtual 189	com/tencent/mm/vfs/k:mkdirs	()Z
    //   88: pop
    //   89: aload 6
    //   91: astore 4
    //   93: new 191	com/tencent/mm/vfs/r
    //   96: dup
    //   97: new 162	com/tencent/mm/vfs/k
    //   100: dup
    //   101: aload 7
    //   103: aload_0
    //   104: invokespecial 194	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/k;Ljava/lang/String;)V
    //   107: iconst_0
    //   108: invokespecial 197	com/tencent/mm/vfs/r:<init>	(Lcom/tencent/mm/vfs/k;Z)V
    //   111: astore_0
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 200	com/tencent/mm/vfs/r:write	(Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore_2
    //   119: aload_0
    //   120: invokevirtual 203	com/tencent/mm/vfs/r:close	()V
    //   123: ldc 153
    //   125: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iload_2
    //   129: ireturn
    //   130: astore_0
    //   131: ldc 42
    //   133: ldc 205
    //   135: aload_0
    //   136: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokevirtual 215	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokestatic 50	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: goto -22 -> 123
    //   148: astore_1
    //   149: aload 5
    //   151: astore_0
    //   152: aload_0
    //   153: astore 4
    //   155: ldc 42
    //   157: ldc 217
    //   159: aload_1
    //   160: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 215	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 50	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: iload_3
    //   170: istore_2
    //   171: aload_0
    //   172: ifnull -49 -> 123
    //   175: aload_0
    //   176: invokevirtual 203	com/tencent/mm/vfs/r:close	()V
    //   179: iload_3
    //   180: istore_2
    //   181: goto -58 -> 123
    //   184: astore_0
    //   185: ldc 42
    //   187: ldc 205
    //   189: aload_0
    //   190: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokevirtual 215	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 50	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iload_3
    //   200: istore_2
    //   201: goto -78 -> 123
    //   204: astore_0
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 203	com/tencent/mm/vfs/r:close	()V
    //   215: ldc 153
    //   217: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_0
    //   221: athrow
    //   222: astore_1
    //   223: ldc 42
    //   225: ldc 205
    //   227: aload_1
    //   228: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 215	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokestatic 50	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   65	37	7	localk	com.tencent.mm.vfs.k
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.g
 * JD-Core Version:    0.7.0.1
 */