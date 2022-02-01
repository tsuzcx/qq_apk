package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class be
  implements r
{
  private static final Map<AppBrandRuntime, be> joH;
  private final q joI;
  private final LinkedList<String> joJ;
  private final String mAppId;
  
  static
  {
    AppMethodBeat.i(134709);
    joH = new HashMap();
    AppMethodBeat.o(134709);
  }
  
  private be(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134701);
    this.mAppId = paramAppBrandRuntime.mAppId;
    k localk = paramAppBrandRuntime.DI();
    ac.i("MicroMsg.WxaPkgRuntimeReader", "<init> appId[%s] sysConfig.class[%s], stacktrace=%s", new Object[] { this.mAppId, localk.getClass().getName(), Log.getStackTraceString(new Throwable()) });
    this.joJ = new LinkedList();
    this.joI = bm.a(paramAppBrandRuntime, this);
    this.joI.aWq();
    AppMethodBeat.o(134701);
  }
  
  private static boolean In(String paramString)
  {
    AppMethodBeat.i(134706);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134706);
      return true;
    }
    if (URLUtil.isAboutUrl(paramString))
    {
      AppMethodBeat.o(134706);
      return true;
    }
    if (d.Rp(paramString))
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
  
  public static void T(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134694);
    U(paramAppBrandRuntime).aWq();
    AppMethodBeat.o(134694);
  }
  
  public static r U(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(178545);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = r.a.jma;
      AppMethodBeat.o(178545);
      return paramAppBrandRuntime;
    }
    synchronized (joH)
    {
      be localbe2 = (be)joH.get(paramAppBrandRuntime);
      be localbe1 = localbe2;
      if (localbe2 == null)
      {
        localbe1 = new be(paramAppBrandRuntime);
        joH.put(paramAppBrandRuntime, localbe1);
        paramAppBrandRuntime.jdK.a(new c.a()
        {
          public final void a(String arg1, b paramAnonymousb)
          {
            AppMethodBeat.i(178544);
            if (b.jqX == paramAnonymousb) {}
            synchronized (be.joH)
            {
              paramAnonymousb = (be)be.joH.remove(this.joK);
              if (paramAnonymousb != null) {
                paramAnonymousb.close();
              }
              AppMethodBeat.o(178544);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(178545);
      return localbe1;
    }
  }
  
  public static String d(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134696);
    paramAppBrandRuntime = bs.nullAsNil((String)U(paramAppBrandRuntime).f(paramString, String.class));
    AppMethodBeat.o(134696);
    return paramAppBrandRuntime;
  }
  
  public static WebResourceResponse e(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134697);
    paramAppBrandRuntime = (WebResourceResponse)U(paramAppBrandRuntime).f(paramString, WebResourceResponse.class);
    AppMethodBeat.o(134697);
    return paramAppBrandRuntime;
  }
  
  public static InputStream f(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134698);
    paramAppBrandRuntime = (InputStream)U(paramAppBrandRuntime).f(paramString, InputStream.class);
    AppMethodBeat.o(134698);
    return paramAppBrandRuntime;
  }
  
  public static boolean g(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(176544);
    boolean bool = U(paramAppBrandRuntime).HU(paramString);
    AppMethodBeat.o(176544);
    return bool;
  }
  
  public static String h(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(134699);
    if (In(paramString))
    {
      AppMethodBeat.o(134699);
      return null;
    }
    paramAppBrandRuntime = U(paramAppBrandRuntime).HT(paramString);
    if (paramAppBrandRuntime != null)
    {
      paramAppBrandRuntime = z.a(paramAppBrandRuntime.jlW, paramAppBrandRuntime.fileName);
      AppMethodBeat.o(134699);
      return paramAppBrandRuntime;
    }
    AppMethodBeat.o(134699);
    return null;
  }
  
  public final WxaPkg HR(String paramString)
  {
    AppMethodBeat.i(178550);
    try
    {
      paramString = HV(paramString);
      paramString = this.joI.HR(paramString);
      AppMethodBeat.o(178550);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178550);
    }
    return null;
  }
  
  public final InputStream HS(String paramString)
  {
    AppMethodBeat.i(134707);
    try
    {
      paramString = HV(paramString);
      paramString = this.joI.HS(paramString);
      AppMethodBeat.o(134707);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(134707);
    }
    return null;
  }
  
  public final q.a HT(String paramString)
  {
    AppMethodBeat.i(178548);
    try
    {
      paramString = HV(paramString);
      paramString = this.joI.HT(paramString);
      AppMethodBeat.o(178548);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178548);
    }
    return null;
  }
  
  public final boolean HU(String paramString)
  {
    AppMethodBeat.i(134702);
    try
    {
      paramString = HV(paramString);
      boolean bool = this.joI.HU(paramString);
      AppMethodBeat.o(134702);
      return bool;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(134702);
    }
    return false;
  }
  
  public final String HV(String paramString)
  {
    AppMethodBeat.i(134705);
    Object localObject = this.joJ.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.startsWith((String)((Iterator)localObject).next()))
      {
        AppMethodBeat.o(134705);
        return paramString;
      }
    }
    if (In(paramString))
    {
      paramString = new IllegalArgumentException("Invalid URL");
      AppMethodBeat.o(134705);
      throw paramString;
    }
    localObject = m.IY(paramString);
    paramString = (String)localObject;
    if (((String)localObject).startsWith("/__APP__")) {
      paramString = m.IY(((String)localObject).substring(8));
    }
    AppMethodBeat.o(134705);
    return paramString;
  }
  
  public final void Im(String paramString)
  {
    AppMethodBeat.i(178547);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(178547);
      return;
    }
    this.joJ.add(paramString);
    AppMethodBeat.o(178547);
  }
  
  public final List<WxaPkg.Info> aWp()
  {
    AppMethodBeat.i(178549);
    List localList = this.joI.aWp();
    AppMethodBeat.o(178549);
    return localList;
  }
  
  public final void aWq()
  {
    AppMethodBeat.i(178551);
    this.joI.aWq();
    AppMethodBeat.o(178551);
  }
  
  public final List<ModulePkgInfo> aWr()
  {
    AppMethodBeat.i(134703);
    List localList = this.joI.aWr();
    AppMethodBeat.o(134703);
    return localList;
  }
  
  public final List<String> aWs()
  {
    AppMethodBeat.i(193379);
    List localList = this.joI.aWs();
    AppMethodBeat.o(193379);
    return localList;
  }
  
  public final q aXo()
  {
    return this.joI;
  }
  
  public final void close()
  {
    AppMethodBeat.i(178552);
    this.joI.close();
    AppMethodBeat.o(178552);
  }
  
  /* Error */
  public final <T> T f(String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: ldc_w 313
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 231	com/tencent/mm/plugin/appbrand/appcache/be:HV	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 7
    //   13: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   16: lstore 4
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: aload 7
    //   23: invokevirtual 320	com/tencent/mm/plugin/appbrand/appcache/be:HS	(Ljava/lang/String;)Ljava/io/InputStream;
    //   26: astore 8
    //   28: aload 8
    //   30: ifnull +158 -> 188
    //   33: aload 8
    //   35: invokevirtual 324	java/io/InputStream:available	()I
    //   38: istore_3
    //   39: getstatic 327	com/tencent/mm/plugin/appbrand/appcache/be$b$a:joL	Ljava/util/Map;
    //   42: aload_2
    //   43: invokeinterface 156 2 0
    //   48: checkcast 13	com/tencent/mm/plugin/appbrand/appcache/be$b
    //   51: aload 7
    //   53: aload 8
    //   55: invokeinterface 330 3 0
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 62	com/tencent/mm/plugin/appbrand/appcache/be:mAppId	Ljava/lang/String;
    //   65: astore 8
    //   67: aload_1
    //   68: ifnonnull +114 -> 182
    //   71: iconst_1
    //   72: istore 6
    //   74: ldc 68
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
    //   105: invokevirtual 80	java/lang/Class:getName	()Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_4
    //   111: iload_3
    //   112: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_5
    //   118: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   121: lload 4
    //   123: lsub
    //   124: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aastore
    //   128: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: ldc_w 313
    //   134: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: ldc_w 313
    //   143: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: ldc 68
    //   151: ldc_w 350
    //   154: iconst_3
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: getfield 62	com/tencent/mm/plugin/appbrand/appcache/be:mAppId	Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload 7
    //   169: aastore
    //   170: dup
    //   171: iconst_2
    //   172: aload_1
    //   173: aastore
    //   174: invokestatic 352	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	193	0	this	be
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
    implements be.b<byte[]>
  {}
  
  static abstract interface b<T>
  {
    public abstract T b(String paramString, InputStream paramInputStream);
    
    public static final class a
    {
      static final Map<Class, be.b> joL;
      
      static
      {
        AppMethodBeat.i(134691);
        HashMap localHashMap = new HashMap();
        joL = localHashMap;
        localHashMap.put(InputStream.class, new be.c((byte)0));
        joL.put(WebResourceResponse.class, new be.e((byte)0));
        joL.put(String.class, new be.d((byte)0));
        joL.put([B.class, new be.a((byte)0));
        AppMethodBeat.o(134691);
      }
    }
  }
  
  static final class c
    implements be.b<InputStream>
  {}
  
  static final class d
    implements be.b<String>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.be
 * JD-Core Version:    0.7.0.1
 */