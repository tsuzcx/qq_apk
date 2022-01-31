package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.base.l;

public final class i
  extends a
{
  boolean iqD;
  
  public i()
  {
    super(r.iri.ordinal());
    AppMethodBeat.i(143458);
    this.iqD = false;
    AppMethodBeat.o(143458);
  }
  
  /* Error */
  static boolean cJ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 38
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 44	com/tencent/mm/compatible/util/f:Mi	()Z
    //   10: ifne +17 -> 27
    //   13: ldc 46
    //   15: ldc 48
    //   17: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 38
    //   22: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aload 6
    //   35: astore 4
    //   37: new 56	java/io/File
    //   40: dup
    //   41: new 58	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   48: getstatic 66	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
    //   51: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 72
    //   56: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 7
    //   67: aload 6
    //   69: astore 4
    //   71: aload 7
    //   73: invokevirtual 82	java/io/File:exists	()Z
    //   76: ifne +13 -> 89
    //   79: aload 6
    //   81: astore 4
    //   83: aload 7
    //   85: invokevirtual 85	java/io/File:mkdirs	()Z
    //   88: pop
    //   89: aload 6
    //   91: astore 4
    //   93: new 87	java/io/FileWriter
    //   96: dup
    //   97: new 56	java/io/File
    //   100: dup
    //   101: aload 7
    //   103: aload_0
    //   104: invokespecial 90	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   107: iconst_0
    //   108: invokespecial 93	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   111: astore_0
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 96	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore_2
    //   119: aload_0
    //   120: invokevirtual 99	java/io/FileWriter:close	()V
    //   123: ldc 38
    //   125: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iload_2
    //   129: ireturn
    //   130: astore_0
    //   131: ldc 46
    //   133: ldc 101
    //   135: aload_0
    //   136: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: goto -22 -> 123
    //   148: astore_1
    //   149: aload 5
    //   151: astore_0
    //   152: aload_0
    //   153: astore 4
    //   155: ldc 46
    //   157: ldc 113
    //   159: aload_1
    //   160: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: iload_3
    //   170: istore_2
    //   171: aload_0
    //   172: ifnull -49 -> 123
    //   175: aload_0
    //   176: invokevirtual 99	java/io/FileWriter:close	()V
    //   179: iload_3
    //   180: istore_2
    //   181: goto -58 -> 123
    //   184: astore_0
    //   185: ldc 46
    //   187: ldc 101
    //   189: aload_0
    //   190: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   196: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iload_3
    //   200: istore_2
    //   201: goto -78 -> 123
    //   204: astore_0
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 99	java/io/FileWriter:close	()V
    //   215: ldc 38
    //   217: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_0
    //   221: athrow
    //   222: astore_1
    //   223: ldc 46
    //   225: ldc 101
    //   227: aload_1
    //   228: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   35	208	4	localObject1	java.lang.Object
    //   31	119	5	localObject2	java.lang.Object
    //   28	62	6	localObject3	java.lang.Object
    //   65	37	7	localFile	java.io.File
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
  
  public final void a(Context paramContext, v paramv, l paraml, String paramString)
  {
    AppMethodBeat.i(143459);
    if (((((AppBrandSysConfigWC)paramv.U(AppBrandSysConfigWC.class)).hiX.gXe == 1) || (bp.dud()) || (bp.dsd())) && ((paramv.getRuntime() instanceof o)) && (((o)paramv.getRuntime()).vY()))
    {
      if (this.iqD)
      {
        paraml.e(this.irp, "Stop CPU Profile");
        AppMethodBeat.o(143459);
        return;
      }
      paraml.e(this.irp, "Start CPU Profile");
    }
    AppMethodBeat.o(143459);
  }
  
  public final void a(Context paramContext, v paramv, String paramString, q paramq)
  {
    AppMethodBeat.i(143460);
    if ((paramv.getRuntime() instanceof o))
    {
      paramv = (o)paramv.getRuntime();
      if (paramv.vY())
      {
        if (this.iqD)
        {
          paramv.atU().aAO().evaluateJavascript("(function(profiler) {return JSON.stringify(profiler.stopProfiling());})(__debug_v8_cpu_profiler)", new i.1(this, paramString, paramContext));
          AppMethodBeat.o(143460);
          return;
        }
        paramv.atU().aAO().evaluateJavascript("var __debug_v8_cpu_profiler = (function(profiler) {if (typeof profiler === 'undefined') { profiler = new NativeGlobal.CpuProfiler();} profiler.startProfiling(); return profiler;})(__debug_v8_cpu_profiler);", new i.2(this, paramContext));
      }
    }
    AppMethodBeat.o(143460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.i
 * JD-Core Version:    0.7.0.1
 */