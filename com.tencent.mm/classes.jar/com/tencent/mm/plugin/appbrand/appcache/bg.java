package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bg
  implements r
{
  private static final Map<AppBrandRuntime, bg> kNE;
  private final q kNF;
  private final LinkedList<String> kNG;
  private final String mAppId;
  
  static
  {
    AppMethodBeat.i(134709);
    kNE = new HashMap();
    AppMethodBeat.o(134709);
  }
  
  private bg(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134701);
    this.mAppId = paramAppBrandRuntime.mAppId;
    l locall = paramAppBrandRuntime.OT();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaPkgRuntimeReader", "<init> appId[%s] sysConfig.class[%s], stacktrace=%s", new Object[] { this.mAppId, locall.getClass().getName(), android.util.Log.getStackTraceString(new Throwable()) });
    this.kNG = new LinkedList();
    this.kNF = bo.a(paramAppBrandRuntime, this);
    this.kNF.bvy();
    AppMethodBeat.o(134701);
  }
  
  public static void L(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134694);
    b(paramAppBrandRuntime, false).bvy();
    AppMethodBeat.o(134694);
  }
  
  public static r M(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(258640);
    paramAppBrandRuntime = b(paramAppBrandRuntime, false);
    AppMethodBeat.o(258640);
    return paramAppBrandRuntime;
  }
  
  public static boolean N(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219304);
    synchronized (kNE)
    {
      paramAppBrandRuntime = (bg)kNE.remove(paramAppBrandRuntime);
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime.close();
        AppMethodBeat.o(219304);
        return true;
      }
    }
    AppMethodBeat.o(219304);
    return false;
  }
  
  private static boolean Vr(String paramString)
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
    if (d.afC(paramString))
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
    AppMethodBeat.i(219303);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = r.a.kKL;
      AppMethodBeat.o(219303);
      return paramAppBrandRuntime;
    }
    if (paramAppBrandRuntime.OT() == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaPkgRuntimeReader", "obtainReader with runtime(%s) sysConfig(NULL), stack=%s", new Object[] { paramAppBrandRuntime.mAppId, android.util.Log.getStackTraceString(new Throwable()) });
      paramAppBrandRuntime = r.a.kKL;
      AppMethodBeat.o(219303);
      return paramAppBrandRuntime;
    }
    synchronized (kNE)
    {
      bg localbg = (bg)kNE.get(paramAppBrandRuntime);
      if ((localbg == null) || (paramBoolean))
      {
        if (paramBoolean) {
          N(paramAppBrandRuntime);
        }
        localbg = new bg(paramAppBrandRuntime);
        kNE.put(paramAppBrandRuntime, localbg);
      }
      AppMethodBeat.o(219303);
      return localbg;
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
    boolean bool = b(paramAppBrandRuntime, false).UW(paramString);
    AppMethodBeat.o(176544);
    return bool;
  }
  
  public static String h(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134699);
    if (Vr(paramString))
    {
      AppMethodBeat.o(134699);
      return null;
    }
    paramAppBrandRuntime = b(paramAppBrandRuntime, false).UV(paramString);
    if (paramAppBrandRuntime != null)
    {
      paramAppBrandRuntime = ab.a(paramAppBrandRuntime.kKH, paramAppBrandRuntime.fileName);
      AppMethodBeat.o(134699);
      return paramAppBrandRuntime;
    }
    AppMethodBeat.o(134699);
    return null;
  }
  
  public final WxaPkg UT(String paramString)
  {
    AppMethodBeat.i(178550);
    try
    {
      paramString = UX(paramString);
      paramString = this.kNF.UT(paramString);
      AppMethodBeat.o(178550);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178550);
    }
    return null;
  }
  
  public final InputStream UU(String paramString)
  {
    AppMethodBeat.i(134707);
    try
    {
      paramString = UX(paramString);
      paramString = this.kNF.UU(paramString);
      AppMethodBeat.o(134707);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(134707);
    }
    return null;
  }
  
  public final q.a UV(String paramString)
  {
    AppMethodBeat.i(178548);
    try
    {
      paramString = UX(paramString);
      paramString = this.kNF.UV(paramString);
      AppMethodBeat.o(178548);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178548);
    }
    return null;
  }
  
  public final boolean UW(String paramString)
  {
    AppMethodBeat.i(134702);
    try
    {
      paramString = UX(paramString);
      boolean bool = this.kNF.UW(paramString);
      AppMethodBeat.o(134702);
      return bool;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(134702);
    }
    return false;
  }
  
  public final String UX(String paramString)
  {
    AppMethodBeat.i(134705);
    Object localObject = this.kNG.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.startsWith((String)((Iterator)localObject).next()))
      {
        AppMethodBeat.o(134705);
        return paramString;
      }
    }
    if (Vr(paramString))
    {
      paramString = new IllegalArgumentException("Invalid URL");
      AppMethodBeat.o(134705);
      throw paramString;
    }
    localObject = n.We(paramString);
    paramString = (String)localObject;
    if (((String)localObject).startsWith("/__APP__")) {
      paramString = n.We(((String)localObject).substring(8));
    }
    AppMethodBeat.o(134705);
    return paramString;
  }
  
  public final void Vq(String paramString)
  {
    AppMethodBeat.i(178547);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(178547);
      return;
    }
    this.kNG.add(paramString);
    AppMethodBeat.o(178547);
  }
  
  public final List<String> bvA()
  {
    AppMethodBeat.i(219305);
    List localList = this.kNF.bvA();
    AppMethodBeat.o(219305);
    return localList;
  }
  
  public final void bvy()
  {
    AppMethodBeat.i(178551);
    this.kNF.bvy();
    AppMethodBeat.o(178551);
  }
  
  public final List<ModulePkgInfo> bvz()
  {
    AppMethodBeat.i(134703);
    List localList = this.kNF.bvz();
    AppMethodBeat.o(134703);
    return localList;
  }
  
  public final q bwy()
  {
    return this.kNF;
  }
  
  public final void close()
  {
    AppMethodBeat.i(178552);
    this.kNF.close();
    AppMethodBeat.o(178552);
  }
  
  /* Error */
  public final <T> T f(String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: ldc_w 309
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 234	com/tencent/mm/plugin/appbrand/appcache/bg:UX	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 7
    //   13: invokestatic 315	java/lang/System:currentTimeMillis	()J
    //   16: lstore 4
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: aload 7
    //   23: invokevirtual 316	com/tencent/mm/plugin/appbrand/appcache/bg:UU	(Ljava/lang/String;)Ljava/io/InputStream;
    //   26: astore 8
    //   28: aload 8
    //   30: ifnull +158 -> 188
    //   33: aload 8
    //   35: invokevirtual 320	java/io/InputStream:available	()I
    //   38: istore_3
    //   39: getstatic 323	com/tencent/mm/plugin/appbrand/appcache/bg$b$a:kNH	Ljava/util/Map;
    //   42: aload_2
    //   43: invokeinterface 170 2 0
    //   48: checkcast 11	com/tencent/mm/plugin/appbrand/appcache/bg$b
    //   51: aload 7
    //   53: aload 8
    //   55: invokeinterface 326 3 0
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 61	com/tencent/mm/plugin/appbrand/appcache/bg:mAppId	Ljava/lang/String;
    //   65: astore 8
    //   67: aload_1
    //   68: ifnonnull +114 -> 182
    //   71: iconst_1
    //   72: istore 6
    //   74: ldc 67
    //   76: ldc_w 328
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
    //   98: invokestatic 334	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   101: aastore
    //   102: dup
    //   103: iconst_3
    //   104: aload_2
    //   105: invokevirtual 79	java/lang/Class:getName	()Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_4
    //   111: iload_3
    //   112: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_5
    //   118: invokestatic 315	java/lang/System:currentTimeMillis	()J
    //   121: lload 4
    //   123: lsub
    //   124: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aastore
    //   128: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: ldc_w 309
    //   134: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: ldc_w 309
    //   143: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: ldc 67
    //   151: ldc_w 346
    //   154: iconst_3
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: getfield 61	com/tencent/mm/plugin/appbrand/appcache/bg:mAppId	Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload 7
    //   169: aastore
    //   170: dup
    //   171: iconst_2
    //   172: aload_1
    //   173: aastore
    //   174: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	193	0	this	bg
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
  
  static final class a
    implements bg.b<byte[]>
  {}
  
  static abstract interface b<T>
  {
    public abstract T b(String paramString, InputStream paramInputStream);
    
    public static final class a
    {
      static final Map<Class, bg.b> kNH;
      
      static
      {
        AppMethodBeat.i(134691);
        HashMap localHashMap = new HashMap();
        kNH = localHashMap;
        localHashMap.put(InputStream.class, new bg.c((byte)0));
        kNH.put(WebResourceResponse.class, new bg.e((byte)0));
        kNH.put(String.class, new bg.d((byte)0));
        kNH.put([B.class, new bg.a((byte)0));
        AppMethodBeat.o(134691);
      }
    }
  }
  
  static final class c
    implements bg.b<InputStream>
  {}
  
  static final class d
    implements bg.b<String>
  {}
  
  static final class e
    implements bg.b<WebResourceResponse>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bg
 * JD-Core Version:    0.7.0.1
 */