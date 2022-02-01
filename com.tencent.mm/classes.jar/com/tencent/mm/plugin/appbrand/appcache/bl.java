package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class bl
  implements r
{
  private static final Map<AppBrandRuntime, bl> nHE;
  private final String mAppId;
  private final q nHF;
  private final LinkedList<String> nHG;
  
  static
  {
    AppMethodBeat.i(134709);
    nHE = new HashMap();
    AppMethodBeat.o(134709);
  }
  
  private bl(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134701);
    this.mAppId = paramAppBrandRuntime.mAppId;
    l locall = paramAppBrandRuntime.Sp();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaPkgRuntimeReader", "<init> appId[%s] sysConfig.class[%s], stacktrace=%s", new Object[] { this.mAppId, locall.getClass().getName(), android.util.Log.getStackTraceString(new Throwable()) });
    this.nHG = new LinkedList();
    this.nHF = bv.a(paramAppBrandRuntime, this);
    this.nHF.bGF();
    AppMethodBeat.o(134701);
  }
  
  public static void M(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134694);
    b(paramAppBrandRuntime, false).bGF();
    AppMethodBeat.o(134694);
  }
  
  public static r N(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(292936);
    paramAppBrandRuntime = b(paramAppBrandRuntime, false);
    AppMethodBeat.o(292936);
    return paramAppBrandRuntime;
  }
  
  public static boolean O(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(242774);
    synchronized (nHE)
    {
      paramAppBrandRuntime = (bl)nHE.remove(paramAppBrandRuntime);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime.close();
        AppMethodBeat.o(242774);
        return true;
      }
    }
    AppMethodBeat.o(242774);
    return false;
  }
  
  private static boolean ada(String paramString)
  {
    AppMethodBeat.i(134706);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134706);
      return true;
    }
    if (URLUtil.isAboutUrl(paramString))
    {
      AppMethodBeat.o(134706);
      return true;
    }
    if (d.ane(paramString))
    {
      AppMethodBeat.o(134706);
      return true;
    }
    if (URLUtil.isFileUrl(paramString))
    {
      AppMethodBeat.o(134706);
      return true;
    }
    AppMethodBeat.o(134706);
    return false;
  }
  
  public static r b(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(242773);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.ntU.get()))
    {
      paramAppBrandRuntime = r.a.nEA;
      AppMethodBeat.o(242773);
      return paramAppBrandRuntime;
    }
    if (paramAppBrandRuntime.Sp() == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaPkgRuntimeReader", "obtainReader with runtime(%s) sysConfig(NULL), stack=%s", new Object[] { paramAppBrandRuntime.mAppId, android.util.Log.getStackTraceString(new Throwable()) });
      paramAppBrandRuntime = r.a.nEA;
      AppMethodBeat.o(242773);
      return paramAppBrandRuntime;
    }
    synchronized (nHE)
    {
      bl localbl = (bl)nHE.get(paramAppBrandRuntime);
      if ((localbl == null) || (paramBoolean))
      {
        if (paramBoolean) {
          O(paramAppBrandRuntime);
        }
        localbl = new bl(paramAppBrandRuntime);
        nHE.put(paramAppBrandRuntime, localbl);
      }
      AppMethodBeat.o(242773);
      return localbl;
    }
  }
  
  public static String d(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134696);
    paramAppBrandRuntime = Util.nullAsNil((String)b(paramAppBrandRuntime, false).f(paramString, String.class));
    AppMethodBeat.o(134696);
    return paramAppBrandRuntime;
  }
  
  public static WebResourceResponse e(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134697);
    paramAppBrandRuntime = (WebResourceResponse)b(paramAppBrandRuntime, false).f(paramString, WebResourceResponse.class);
    AppMethodBeat.o(134697);
    return paramAppBrandRuntime;
  }
  
  public static InputStream f(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134698);
    paramAppBrandRuntime = (InputStream)b(paramAppBrandRuntime, false).f(paramString, InputStream.class);
    AppMethodBeat.o(134698);
    return paramAppBrandRuntime;
  }
  
  public static boolean g(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(176544);
    boolean bool = b(paramAppBrandRuntime, false).acG(paramString);
    AppMethodBeat.o(176544);
    return bool;
  }
  
  public static String h(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134699);
    if (ada(paramString))
    {
      AppMethodBeat.o(134699);
      return null;
    }
    paramAppBrandRuntime = b(paramAppBrandRuntime, false).acF(paramString);
    if (paramAppBrandRuntime != null)
    {
      paramAppBrandRuntime = ac.a(paramAppBrandRuntime.nEw, paramAppBrandRuntime.fileName);
      AppMethodBeat.o(134699);
      return paramAppBrandRuntime;
    }
    AppMethodBeat.o(134699);
    return null;
  }
  
  public final WxaPkg acD(String paramString)
  {
    AppMethodBeat.i(178550);
    try
    {
      paramString = acH(paramString);
      paramString = this.nHF.acD(paramString);
      AppMethodBeat.o(178550);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178550);
    }
    return null;
  }
  
  public final InputStream acE(String paramString)
  {
    AppMethodBeat.i(134707);
    try
    {
      paramString = acH(paramString);
      paramString = this.nHF.acE(paramString);
      AppMethodBeat.o(134707);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(134707);
    }
    return null;
  }
  
  public final q.a acF(String paramString)
  {
    AppMethodBeat.i(178548);
    try
    {
      paramString = acH(paramString);
      paramString = this.nHF.acF(paramString);
      AppMethodBeat.o(178548);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178548);
    }
    return null;
  }
  
  public final boolean acG(String paramString)
  {
    AppMethodBeat.i(134702);
    try
    {
      paramString = acH(paramString);
      boolean bool = this.nHF.acG(paramString);
      AppMethodBeat.o(134702);
      return bool;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(134702);
    }
    return false;
  }
  
  public final String acH(String paramString)
  {
    AppMethodBeat.i(134705);
    Object localObject = this.nHG.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.startsWith((String)((Iterator)localObject).next()))
      {
        AppMethodBeat.o(134705);
        return paramString;
      }
    }
    if (ada(paramString))
    {
      paramString = new IllegalArgumentException("Invalid URL");
      AppMethodBeat.o(134705);
      throw paramString;
    }
    localObject = o.adS(paramString);
    paramString = (String)localObject;
    if (((String)localObject).startsWith("/__APP__")) {
      paramString = o.adS(((String)localObject).substring(8));
    }
    AppMethodBeat.o(134705);
    return paramString;
  }
  
  public final void acZ(String paramString)
  {
    AppMethodBeat.i(178547);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(178547);
      return;
    }
    this.nHG.add(paramString);
    AppMethodBeat.o(178547);
  }
  
  public final void bGF()
  {
    AppMethodBeat.i(178551);
    this.nHF.bGF();
    AppMethodBeat.o(178551);
  }
  
  public final List<ModulePkgInfo> bGG()
  {
    AppMethodBeat.i(134703);
    List localList = this.nHF.bGG();
    AppMethodBeat.o(134703);
    return localList;
  }
  
  public final List<String> bGH()
  {
    AppMethodBeat.i(242777);
    List localList = this.nHF.bGH();
    AppMethodBeat.o(242777);
    return localList;
  }
  
  public final q bHE()
  {
    return this.nHF;
  }
  
  public final void close()
  {
    AppMethodBeat.i(178552);
    this.nHF.close();
    AppMethodBeat.o(178552);
  }
  
  /* Error */
  public final <T> T f(String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: ldc_w 311
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 236	com/tencent/mm/plugin/appbrand/appcache/bl:acH	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 7
    //   13: invokestatic 317	java/lang/System:currentTimeMillis	()J
    //   16: lstore 4
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: aload 7
    //   23: invokevirtual 318	com/tencent/mm/plugin/appbrand/appcache/bl:acE	(Ljava/lang/String;)Ljava/io/InputStream;
    //   26: astore 8
    //   28: aload 8
    //   30: ifnull +158 -> 188
    //   33: aload 8
    //   35: invokevirtual 322	java/io/InputStream:available	()I
    //   38: istore_3
    //   39: getstatic 327	com/tencent/mm/plugin/appbrand/appcache/bl$b$a:nHH	Ljava/util/Map;
    //   42: aload_2
    //   43: invokeinterface 171 2 0
    //   48: checkcast 10	com/tencent/mm/plugin/appbrand/appcache/bl$b
    //   51: aload 7
    //   53: aload 8
    //   55: invokeinterface 330 3 0
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 54	com/tencent/mm/plugin/appbrand/appcache/bl:mAppId	Ljava/lang/String;
    //   65: astore 8
    //   67: aload_1
    //   68: ifnonnull +114 -> 182
    //   71: iconst_1
    //   72: istore 6
    //   74: ldc 60
    //   76: ldc_w 332
    //   79: bipush 6
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload 8
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload 7
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: iload 6
    //   98: invokestatic 338	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   101: aastore
    //   102: dup
    //   103: iconst_3
    //   104: aload_2
    //   105: invokevirtual 72	java/lang/Class:getName	()Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_4
    //   111: iload_3
    //   112: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_5
    //   118: invokestatic 317	java/lang/System:currentTimeMillis	()J
    //   121: lload 4
    //   123: lsub
    //   124: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aastore
    //   128: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: ldc_w 311
    //   134: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: ldc_w 311
    //   143: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: ldc 60
    //   151: ldc_w 350
    //   154: iconst_3
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: getfield 54	com/tencent/mm/plugin/appbrand/appcache/bl:mAppId	Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload 7
    //   169: aastore
    //   170: dup
    //   171: iconst_2
    //   172: aload_1
    //   173: aastore
    //   174: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: iconst_m1
    //   178: istore_3
    //   179: goto -140 -> 39
    //   182: iconst_0
    //   183: istore 6
    //   185: goto -111 -> 74
    //   188: iconst_m1
    //   189: istore_3
    //   190: goto -129 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	bl
    //   0	193	1	paramString	String
    //   0	193	2	paramClass	Class<T>
    //   38	152	3	i	int
    //   16	106	4	l	long
    //   72	112	6	bool	boolean
    //   11	157	7	str	String
    //   26	61	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	139	java/lang/IllegalArgumentException
    //   33	39	148	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bl
 * JD-Core Version:    0.7.0.1
 */