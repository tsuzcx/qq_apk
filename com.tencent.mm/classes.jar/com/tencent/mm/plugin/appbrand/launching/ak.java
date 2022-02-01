package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.launching.report.c;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.c.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ak
  implements x
{
  final String appId;
  final int hQh;
  private c lIA;
  private PBool lIB;
  final int lIu;
  List<WxaAttributes.WxaPluginCodeInfo> lIv;
  LinkedHashMap<String, i<WxaPkgWrappingInfo>> lIw;
  private final String lIx;
  private final AtomicInteger lIy;
  private volatile boolean lIz;
  List<WxaAttributes.WxaVersionModuleInfo> moduleList;
  
  ak(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaVersionModuleInfo> paramList, List<WxaAttributes.WxaPluginCodeInfo> paramList1, PBool paramPBool)
  {
    AppMethodBeat.i(47231);
    this.lIw = new LinkedHashMap();
    this.lIy = new AtomicInteger(0);
    this.lIz = false;
    ad.i("MicroMsg.AppBrand.LaunchCheckPkgSplitPluginCodeModuleHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.appId = paramString1;
    this.hQh = paramInt1;
    this.lIu = paramInt2;
    this.moduleList = paramList;
    this.lIv = paramList1;
    this.lIA = new c(paramString1, paramInt2, paramInt1, paramString2, paramInt3, this.lIv);
    this.lIB = paramPBool;
    this.lIx = paramString2;
    AppMethodBeat.o(47231);
  }
  
  /* Error */
  private static WxaPkgWrappingInfo Q(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 115	com/tencent/mm/plugin/appbrand/appcache/ac
    //   8: dup
    //   9: aload_0
    //   10: ldc 117
    //   12: invokespecial 120	com/tencent/mm/plugin/appbrand/appcache/ac:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore 5
    //   17: iload_1
    //   18: invokestatic 126	com/tencent/mm/plugin/appbrand/appcache/j$a:rQ	(I)Z
    //   21: ifeq +293 -> 314
    //   24: invokestatic 132	com/tencent/mm/plugin/appbrand/app/j:aYX	()Lcom/tencent/mm/plugin/appbrand/appcache/bg;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +10 -> 39
    //   32: ldc 113
    //   34: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: aload_3
    //   40: aload 5
    //   42: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ac:toString	()Ljava/lang/String;
    //   45: iload_2
    //   46: iload_1
    //   47: iconst_0
    //   48: anewarray 138	java/lang/String
    //   51: invokevirtual 143	com/tencent/mm/plugin/appbrand/appcache/bg:a	(Ljava/lang/String;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/bc;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnonnull +10 -> 68
    //   61: ldc 113
    //   63: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: aload 6
    //   70: getfield 148	com/tencent/mm/plugin/appbrand/appcache/bc:field_versionMd5	Ljava/lang/String;
    //   73: invokestatic 154	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +10 -> 86
    //   79: ldc 113
    //   81: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: aload 6
    //   88: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bc:field_pkgPath	Ljava/lang/String;
    //   91: invokestatic 163	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 6
    //   101: getfield 148	com/tencent/mm/plugin/appbrand/appcache/bc:field_versionMd5	Ljava/lang/String;
    //   104: aload 4
    //   106: sipush 4096
    //   109: invokestatic 169	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   112: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq +62 -> 177
    //   118: aload 4
    //   120: astore_3
    //   121: ldc 68
    //   123: ldc 175
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_0
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: iload_1
    //   136: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload_2
    //   143: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload 4
    //   152: astore_3
    //   153: aload 6
    //   155: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bc:field_pkgPath	Ljava/lang/String;
    //   158: iload_2
    //   159: invokestatic 179	com/tencent/mm/plugin/appbrand/launching/ak:bO	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   162: astore 7
    //   164: aload 4
    //   166: invokestatic 183	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   169: ldc 113
    //   171: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload 7
    //   176: areturn
    //   177: aload 4
    //   179: invokestatic 183	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   182: aload 6
    //   184: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bc:field_pkgPath	Ljava/lang/String;
    //   187: invokestatic 186	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   190: pop
    //   191: aload 5
    //   193: iload_1
    //   194: iload_2
    //   195: iconst_1
    //   196: anewarray 138	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: aload 6
    //   203: getfield 148	com/tencent/mm/plugin/appbrand/appcache/bc:field_versionMd5	Ljava/lang/String;
    //   206: aastore
    //   207: invokestatic 191	com/tencent/mm/plugin/appbrand/launching/m:a	(Lcom/tencent/mm/plugin/appbrand/appcache/ac;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/bc;
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +176 -> 388
    //   215: aload 5
    //   217: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ac:toString	()Ljava/lang/String;
    //   220: iload_2
    //   221: invokestatic 197	com/tencent/mm/plugin/appbrand/appcache/az:aL	(Ljava/lang/String;I)Ljava/lang/String;
    //   224: astore_3
    //   225: aload_0
    //   226: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bc:field_pkgPath	Ljava/lang/String;
    //   229: aload_3
    //   230: invokestatic 201	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   233: pop2
    //   234: invokestatic 132	com/tencent/mm/plugin/appbrand/app/j:aYX	()Lcom/tencent/mm/plugin/appbrand/appcache/bg;
    //   237: aload 5
    //   239: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ac:toString	()Ljava/lang/String;
    //   242: iload_1
    //   243: iload_2
    //   244: aload_3
    //   245: invokevirtual 205	com/tencent/mm/plugin/appbrand/appcache/bg:e	(Ljava/lang/String;IILjava/lang/String;)Z
    //   248: pop
    //   249: aload_3
    //   250: iload_2
    //   251: invokestatic 179	com/tencent/mm/plugin/appbrand/launching/ak:bO	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   254: astore_0
    //   255: ldc 113
    //   257: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_0
    //   261: areturn
    //   262: astore_3
    //   263: aconst_null
    //   264: astore 4
    //   266: aload 4
    //   268: astore_3
    //   269: ldc 68
    //   271: ldc 207
    //   273: iconst_2
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload_0
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: aload 6
    //   285: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bc:field_pkgPath	Ljava/lang/String;
    //   288: aastore
    //   289: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: aload 4
    //   294: invokestatic 183	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   297: goto -115 -> 182
    //   300: astore_0
    //   301: aconst_null
    //   302: astore_3
    //   303: aload_3
    //   304: invokestatic 183	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   307: ldc 113
    //   309: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload_0
    //   313: athrow
    //   314: aload 5
    //   316: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ac:toString	()Ljava/lang/String;
    //   319: iload_1
    //   320: iconst_1
    //   321: invokestatic 215	com/tencent/mm/plugin/appbrand/appcache/WxaPkgIntegrityChecker:D	(Ljava/lang/String;II)Landroid/util/Pair;
    //   324: astore_3
    //   325: aload_3
    //   326: getfield 221	android/util/Pair:second	Ljava/lang/Object;
    //   329: ifnull +59 -> 388
    //   332: aload_3
    //   333: getfield 221	android/util/Pair:second	Ljava/lang/Object;
    //   336: checkcast 223	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   339: ldc 117
    //   341: putfield 226	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:name	Ljava/lang/String;
    //   344: ldc 68
    //   346: ldc 228
    //   348: iconst_3
    //   349: anewarray 4	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: aload_0
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: iload_1
    //   359: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: iload_2
    //   366: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: aload_3
    //   374: getfield 221	android/util/Pair:second	Ljava/lang/Object;
    //   377: checkcast 223	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   380: astore_0
    //   381: ldc 113
    //   383: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: aload_0
    //   387: areturn
    //   388: ldc 113
    //   390: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: aconst_null
    //   394: areturn
    //   395: astore_0
    //   396: goto -93 -> 303
    //   399: astore_3
    //   400: goto -134 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramString	String
    //   0	403	1	paramInt1	int
    //   0	403	2	paramInt2	int
    //   27	223	3	localObject1	Object
    //   262	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   268	106	3	localObject2	Object
    //   399	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   94	199	4	localInputStream	java.io.InputStream
    //   15	300	5	localac	com.tencent.mm.plugin.appbrand.appcache.ac
    //   54	230	6	localbc	com.tencent.mm.plugin.appbrand.appcache.bc
    //   162	13	7	localWxaPkgWrappingInfo	WxaPkgWrappingInfo
    // Exception table:
    //   from	to	target	type
    //   86	96	262	java/io/FileNotFoundException
    //   86	96	300	finally
    //   99	118	395	finally
    //   121	150	395	finally
    //   153	164	395	finally
    //   269	292	395	finally
    //   99	118	399	java/io/FileNotFoundException
    //   121	150	399	java/io/FileNotFoundException
    //   153	164	399	java/io/FileNotFoundException
  }
  
  private static WxaPkgWrappingInfo bO(String paramString, int paramInt)
  {
    AppMethodBeat.i(47233);
    paramString = WxaPkgWrappingInfo.LL(paramString);
    paramString.pkgVersion = paramInt;
    AppMethodBeat.o(47233);
    return paramString;
  }
  
  private void ud(int paramInt)
  {
    AppMethodBeat.i(47234);
    this.lIA.uq(paramInt);
    AppMethodBeat.o(47234);
  }
  
  public void bqN() {}
  
  public void bqW() {}
  
  public void onDownloadProgress(int paramInt) {}
  
  abstract class a
    implements aa.b
  {
    private int lIH = 0;
    
    private a() {}
    
    public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      ak.a(ak.this);
      ad.i("MicroMsg.AppBrand.LaunchCheckPkgSplitPluginCodeModuleHandler", brn() + " progress=" + paramWxaPkgLoadProgress.progress);
      long l = brm();
      if (l == 0L) {
        ak.b(ak.this).set(100);
      }
      for (;;)
      {
        this.lIH = paramWxaPkgLoadProgress.progress;
        ak.c(ak.this);
        return;
        ak.b(ak.this).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.lIH) / (float)l));
      }
    }
    
    abstract long brm();
    
    abstract String brn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ak
 * JD-Core Version:    0.7.0.1
 */