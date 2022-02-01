package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ak
  implements x
{
  final String appId;
  final int gXn;
  final int kJQ;
  List<WxaAttributes.WxaPluginCodeInfo> kJR;
  LinkedHashMap<String, i<WxaPkgWrappingInfo>> kJS;
  private final String kJT;
  private final AtomicInteger kJU;
  private volatile boolean kJV;
  private com.tencent.mm.plugin.appbrand.launching.f.a kJW;
  private PBool kJX;
  List<WxaAttributes.WxaVersionModuleInfo> moduleList;
  
  ak(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaVersionModuleInfo> paramList, List<WxaAttributes.WxaPluginCodeInfo> paramList1, PBool paramPBool)
  {
    AppMethodBeat.i(47231);
    this.kJS = new LinkedHashMap();
    this.kJU = new AtomicInteger(0);
    this.kJV = false;
    ad.i("MicroMsg.AppBrand.LaunchCheckPkgSplitPluginCodeModuleHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.appId = paramString1;
    this.gXn = paramInt1;
    this.kJQ = paramInt2;
    this.moduleList = paramList;
    this.kJR = paramList1;
    this.kJW = new com.tencent.mm.plugin.appbrand.launching.f.a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, this.kJR);
    this.kJX = paramPBool;
    this.kJT = paramString2;
    AppMethodBeat.o(47231);
  }
  
  /* Error */
  private static WxaPkgWrappingInfo P(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 115	com/tencent/mm/plugin/appbrand/appcache/ab
    //   8: dup
    //   9: aload_0
    //   10: ldc 117
    //   12: invokespecial 120	com/tencent/mm/plugin/appbrand/appcache/ab:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore 5
    //   17: iload_1
    //   18: invokestatic 126	com/tencent/mm/plugin/appbrand/appcache/j$a:qD	(I)Z
    //   21: ifeq +286 -> 307
    //   24: invokestatic 132	com/tencent/mm/plugin/appbrand/app/j:aOK	()Lcom/tencent/mm/plugin/appbrand/appcache/bf;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +10 -> 39
    //   32: ldc 113
    //   34: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: aload_3
    //   40: aload 5
    //   42: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ab:toString	()Ljava/lang/String;
    //   45: iload_2
    //   46: iload_1
    //   47: iconst_0
    //   48: anewarray 138	java/lang/String
    //   51: invokevirtual 143	com/tencent/mm/plugin/appbrand/appcache/bf:a	(Ljava/lang/String;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/bb;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnonnull +10 -> 68
    //   61: ldc 113
    //   63: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: aload 6
    //   70: getfield 148	com/tencent/mm/plugin/appbrand/appcache/bb:field_versionMd5	Ljava/lang/String;
    //   73: invokestatic 154	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +10 -> 86
    //   79: ldc 113
    //   81: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: aload 6
    //   88: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bb:field_pkgPath	Ljava/lang/String;
    //   91: invokestatic 163	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 6
    //   101: getfield 148	com/tencent/mm/plugin/appbrand/appcache/bb:field_versionMd5	Ljava/lang/String;
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
    //   155: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bb:field_pkgPath	Ljava/lang/String;
    //   158: iload_2
    //   159: invokestatic 179	com/tencent/mm/plugin/appbrand/launching/ak:bH	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
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
    //   184: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bb:field_pkgPath	Ljava/lang/String;
    //   187: invokestatic 186	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   190: pop
    //   191: aload 5
    //   193: iload_1
    //   194: iload_2
    //   195: aload 6
    //   197: getfield 148	com/tencent/mm/plugin/appbrand/appcache/bb:field_versionMd5	Ljava/lang/String;
    //   200: invokestatic 191	com/tencent/mm/plugin/appbrand/launching/m:a	(Lcom/tencent/mm/plugin/appbrand/appcache/ab;IILjava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/bb;
    //   203: astore_0
    //   204: aload_0
    //   205: ifnull +176 -> 381
    //   208: aload 5
    //   210: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ab:toString	()Ljava/lang/String;
    //   213: iload_2
    //   214: invokestatic 197	com/tencent/mm/plugin/appbrand/appcache/ay:aF	(Ljava/lang/String;I)Ljava/lang/String;
    //   217: astore_3
    //   218: aload_0
    //   219: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bb:field_pkgPath	Ljava/lang/String;
    //   222: aload_3
    //   223: invokestatic 201	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   226: pop2
    //   227: invokestatic 132	com/tencent/mm/plugin/appbrand/app/j:aOK	()Lcom/tencent/mm/plugin/appbrand/appcache/bf;
    //   230: aload 5
    //   232: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ab:toString	()Ljava/lang/String;
    //   235: iload_1
    //   236: iload_2
    //   237: aload_3
    //   238: invokevirtual 204	com/tencent/mm/plugin/appbrand/appcache/bf:d	(Ljava/lang/String;IILjava/lang/String;)Z
    //   241: pop
    //   242: aload_3
    //   243: iload_2
    //   244: invokestatic 179	com/tencent/mm/plugin/appbrand/launching/ak:bH	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   247: astore_0
    //   248: ldc 113
    //   250: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_0
    //   254: areturn
    //   255: astore_3
    //   256: aconst_null
    //   257: astore 4
    //   259: aload 4
    //   261: astore_3
    //   262: ldc 68
    //   264: ldc 206
    //   266: iconst_2
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_0
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: aload 6
    //   278: getfield 157	com/tencent/mm/plugin/appbrand/appcache/bb:field_pkgPath	Ljava/lang/String;
    //   281: aastore
    //   282: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload 4
    //   287: invokestatic 183	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   290: goto -108 -> 182
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_3
    //   296: aload_3
    //   297: invokestatic 183	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   300: ldc 113
    //   302: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_0
    //   306: athrow
    //   307: aload 5
    //   309: invokevirtual 136	com/tencent/mm/plugin/appbrand/appcache/ab:toString	()Ljava/lang/String;
    //   312: iload_1
    //   313: iconst_1
    //   314: invokestatic 215	com/tencent/mm/plugin/appbrand/appcache/WxaPkgIntegrityChecker:C	(Ljava/lang/String;II)Landroid/util/Pair;
    //   317: astore_3
    //   318: aload_3
    //   319: getfield 221	android/util/Pair:second	Ljava/lang/Object;
    //   322: ifnull +59 -> 381
    //   325: aload_3
    //   326: getfield 221	android/util/Pair:second	Ljava/lang/Object;
    //   329: checkcast 223	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   332: ldc 117
    //   334: putfield 226	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:name	Ljava/lang/String;
    //   337: ldc 68
    //   339: ldc 228
    //   341: iconst_3
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload_0
    //   348: aastore
    //   349: dup
    //   350: iconst_1
    //   351: iload_1
    //   352: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aastore
    //   356: dup
    //   357: iconst_2
    //   358: iload_2
    //   359: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   366: aload_3
    //   367: getfield 221	android/util/Pair:second	Ljava/lang/Object;
    //   370: checkcast 223	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   373: astore_0
    //   374: ldc 113
    //   376: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: aload_0
    //   380: areturn
    //   381: ldc 113
    //   383: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: aconst_null
    //   387: areturn
    //   388: astore_0
    //   389: goto -93 -> 296
    //   392: astore_3
    //   393: goto -134 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramString	String
    //   0	396	1	paramInt1	int
    //   0	396	2	paramInt2	int
    //   27	216	3	localObject1	Object
    //   255	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   261	106	3	localObject2	Object
    //   392	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   94	192	4	localInputStream	java.io.InputStream
    //   15	293	5	localab	com.tencent.mm.plugin.appbrand.appcache.ab
    //   54	223	6	localbb	com.tencent.mm.plugin.appbrand.appcache.bb
    //   162	13	7	localWxaPkgWrappingInfo	WxaPkgWrappingInfo
    // Exception table:
    //   from	to	target	type
    //   86	96	255	java/io/FileNotFoundException
    //   86	96	293	finally
    //   99	118	388	finally
    //   121	150	388	finally
    //   153	164	388	finally
    //   262	285	388	finally
    //   99	118	392	java/io/FileNotFoundException
    //   121	150	392	java/io/FileNotFoundException
    //   153	164	392	java/io/FileNotFoundException
  }
  
  private static WxaPkgWrappingInfo bH(String paramString, int paramInt)
  {
    AppMethodBeat.i(47233);
    paramString = WxaPkgWrappingInfo.Er(paramString);
    paramString.pkgVersion = paramInt;
    AppMethodBeat.o(47233);
    return paramString;
  }
  
  private void sI(int paramInt)
  {
    AppMethodBeat.i(47234);
    this.kJW.sV(paramInt);
    AppMethodBeat.o(47234);
  }
  
  public void bgi() {}
  
  public void bgq() {}
  
  public void onDownloadProgress(int paramInt) {}
  
  abstract class a
    implements aa.b
  {
    private int kKd = 0;
    
    private a() {}
    
    public final void b(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      ak.a(ak.this);
      ad.i("MicroMsg.AppBrand.LaunchCheckPkgSplitPluginCodeModuleHandler", bgG() + " progress=" + paramWxaPkgLoadProgress.progress);
      long l = bgF();
      if (l == 0L) {
        ak.b(ak.this).set(100);
      }
      for (;;)
      {
        this.kKd = paramWxaPkgLoadProgress.progress;
        ak.c(ak.this);
        return;
        ak.b(ak.this).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.kKd) / (float)l));
      }
    }
    
    abstract long bgF();
    
    abstract String bgG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ak
 * JD-Core Version:    0.7.0.1
 */