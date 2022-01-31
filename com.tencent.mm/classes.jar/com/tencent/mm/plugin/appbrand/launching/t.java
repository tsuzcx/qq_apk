package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaCodeLibInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class t
  implements n
{
  final String appId;
  final int hcr;
  List<WxaAttributes.WxaCodeLibInfo> ilB;
  final int iln;
  private final AtomicInteger ilp;
  private volatile boolean ilq;
  LinkedHashMap<String, j<WxaPkgWrappingInfo>> ilw;
  private a ilx;
  List<WxaAttributes.WxaVersionModuleInfo> moduleList;
  
  t(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    AppMethodBeat.i(131876);
    this.ilw = new LinkedHashMap();
    this.ilp = new AtomicInteger(0);
    this.ilq = false;
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibModuleHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.appId = paramString;
    this.hcr = paramInt1;
    this.iln = paramInt2;
    this.moduleList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WxaAttributes.WxaVersionModuleInfo localWxaVersionModuleInfo = (WxaAttributes.WxaVersionModuleInfo)paramList.next();
      if ((!bo.isNullOrNil(localWxaVersionModuleInfo.name)) && (localWxaVersionModuleInfo.name.equals("__APP__"))) {
        this.ilB = localWxaVersionModuleInfo.hkl;
      }
    }
    this.ilx = new a(paramString, paramInt2, paramInt1, this.ilB);
    AppMethodBeat.o(131876);
  }
  
  /* Error */
  private static WxaPkgWrappingInfo T(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 134
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 136	com/tencent/mm/plugin/appbrand/appcache/y
    //   8: dup
    //   9: aload_0
    //   10: ldc 106
    //   12: invokespecial 139	com/tencent/mm/plugin/appbrand/appcache/y:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore 5
    //   17: iload_1
    //   18: invokestatic 145	com/tencent/mm/plugin/appbrand/appcache/j$a:nk	(I)Z
    //   21: ifeq +286 -> 307
    //   24: invokestatic 151	com/tencent/mm/plugin/appbrand/app/g:auM	()Lcom/tencent/mm/plugin/appbrand/appcache/ay;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +10 -> 39
    //   32: ldc 134
    //   34: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: aload_3
    //   40: aload 5
    //   42: invokevirtual 155	com/tencent/mm/plugin/appbrand/appcache/y:toString	()Ljava/lang/String;
    //   45: iload_2
    //   46: iload_1
    //   47: iconst_0
    //   48: anewarray 108	java/lang/String
    //   51: invokevirtual 161	com/tencent/mm/plugin/appbrand/appcache/ay:a	(Ljava/lang/String;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/at;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnonnull +10 -> 68
    //   61: ldc 134
    //   63: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: aload 6
    //   70: getfield 166	com/tencent/mm/plugin/appbrand/appcache/at:field_versionMd5	Ljava/lang/String;
    //   73: invokestatic 104	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   76: ifeq +10 -> 86
    //   79: ldc 134
    //   81: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: aload 6
    //   88: getfield 169	com/tencent/mm/plugin/appbrand/appcache/at:field_pkgPath	Ljava/lang/String;
    //   91: invokestatic 175	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 6
    //   101: getfield 166	com/tencent/mm/plugin/appbrand/appcache/at:field_versionMd5	Ljava/lang/String;
    //   104: aload 4
    //   106: sipush 4096
    //   109: invokestatic 181	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   112: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq +62 -> 177
    //   118: aload 4
    //   120: astore_3
    //   121: ldc 56
    //   123: ldc 183
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_0
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: iload_1
    //   136: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload_2
    //   143: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload 4
    //   152: astore_3
    //   153: aload 6
    //   155: getfield 169	com/tencent/mm/plugin/appbrand/appcache/at:field_pkgPath	Ljava/lang/String;
    //   158: iload_2
    //   159: invokestatic 187	com/tencent/mm/plugin/appbrand/launching/t:bn	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   162: astore 7
    //   164: aload 4
    //   166: invokestatic 190	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   169: ldc 134
    //   171: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload 7
    //   176: areturn
    //   177: aload 4
    //   179: invokestatic 190	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   182: aload 6
    //   184: getfield 169	com/tencent/mm/plugin/appbrand/appcache/at:field_pkgPath	Ljava/lang/String;
    //   187: invokestatic 193	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   190: pop
    //   191: aload 5
    //   193: iload_1
    //   194: iload_2
    //   195: aload 6
    //   197: getfield 166	com/tencent/mm/plugin/appbrand/appcache/at:field_versionMd5	Ljava/lang/String;
    //   200: invokestatic 198	com/tencent/mm/plugin/appbrand/launching/h:a	(Lcom/tencent/mm/plugin/appbrand/appcache/y;IILjava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/at;
    //   203: astore_0
    //   204: aload_0
    //   205: ifnull +176 -> 381
    //   208: aload 5
    //   210: invokevirtual 155	com/tencent/mm/plugin/appbrand/appcache/y:toString	()Ljava/lang/String;
    //   213: iload_2
    //   214: invokestatic 204	com/tencent/mm/plugin/appbrand/appcache/aq:ar	(Ljava/lang/String;I)Ljava/lang/String;
    //   217: astore_3
    //   218: aload_0
    //   219: getfield 169	com/tencent/mm/plugin/appbrand/appcache/at:field_pkgPath	Ljava/lang/String;
    //   222: aload_3
    //   223: invokestatic 208	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   226: pop2
    //   227: invokestatic 151	com/tencent/mm/plugin/appbrand/app/g:auM	()Lcom/tencent/mm/plugin/appbrand/appcache/ay;
    //   230: aload 5
    //   232: invokevirtual 155	com/tencent/mm/plugin/appbrand/appcache/y:toString	()Ljava/lang/String;
    //   235: iload_1
    //   236: iload_2
    //   237: aload_3
    //   238: invokevirtual 212	com/tencent/mm/plugin/appbrand/appcache/ay:d	(Ljava/lang/String;IILjava/lang/String;)Z
    //   241: pop
    //   242: aload_3
    //   243: iload_2
    //   244: invokestatic 187	com/tencent/mm/plugin/appbrand/launching/t:bn	(Ljava/lang/String;I)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   247: astore_0
    //   248: ldc 134
    //   250: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_0
    //   254: areturn
    //   255: astore_3
    //   256: aconst_null
    //   257: astore 4
    //   259: aload 4
    //   261: astore_3
    //   262: ldc 56
    //   264: ldc 214
    //   266: iconst_2
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_0
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: aload 6
    //   278: getfield 169	com/tencent/mm/plugin/appbrand/appcache/at:field_pkgPath	Ljava/lang/String;
    //   281: aastore
    //   282: invokestatic 217	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload 4
    //   287: invokestatic 190	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   290: goto -108 -> 182
    //   293: astore_0
    //   294: aconst_null
    //   295: astore_3
    //   296: aload_3
    //   297: invokestatic 190	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   300: ldc 134
    //   302: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_0
    //   306: athrow
    //   307: aload 5
    //   309: invokevirtual 155	com/tencent/mm/plugin/appbrand/appcache/y:toString	()Ljava/lang/String;
    //   312: iload_1
    //   313: iconst_1
    //   314: invokestatic 223	com/tencent/mm/plugin/appbrand/appcache/as:F	(Ljava/lang/String;II)Landroid/util/Pair;
    //   317: astore_3
    //   318: aload_3
    //   319: getfield 229	android/util/Pair:second	Ljava/lang/Object;
    //   322: ifnull +59 -> 381
    //   325: aload_3
    //   326: getfield 229	android/util/Pair:second	Ljava/lang/Object;
    //   329: checkcast 231	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   332: ldc 106
    //   334: putfield 232	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:name	Ljava/lang/String;
    //   337: ldc 56
    //   339: ldc 234
    //   341: iconst_3
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload_0
    //   348: aastore
    //   349: dup
    //   350: iconst_1
    //   351: iload_1
    //   352: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aastore
    //   356: dup
    //   357: iconst_2
    //   358: iload_2
    //   359: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: invokestatic 69	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   366: aload_3
    //   367: getfield 229	android/util/Pair:second	Ljava/lang/Object;
    //   370: checkcast 231	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   373: astore_0
    //   374: ldc 134
    //   376: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: aload_0
    //   380: areturn
    //   381: ldc 134
    //   383: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   15	293	5	localy	com.tencent.mm.plugin.appbrand.appcache.y
    //   54	223	6	localat	com.tencent.mm.plugin.appbrand.appcache.at
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
  
  private static WxaPkgWrappingInfo bn(String paramString, int paramInt)
  {
    AppMethodBeat.i(131878);
    paramString = WxaPkgWrappingInfo.yL(paramString);
    paramString.gXf = paramInt;
    AppMethodBeat.o(131878);
    return paramString;
  }
  
  private void oE(int paramInt)
  {
    AppMethodBeat.i(131879);
    this.ilx.oL(paramInt);
    AppMethodBeat.o(131879);
  }
  
  public void aGL() {}
  
  public void aGQ() {}
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t
 * JD-Core Version:    0.7.0.1
 */