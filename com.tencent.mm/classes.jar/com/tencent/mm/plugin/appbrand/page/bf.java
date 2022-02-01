package com.tencent.mm.plugin.appbrand.page;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsruntime.ad;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView;
import d.a.e;
import d.l;
import d.n.n;
import d.v;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;)V", "checkScriptSerialized", "", "scriptName", "scriptSource", "onScriptCodeCacheProvided", "", "name", "provideScript", "resourceName", "contentMD5", "fileMD5", "stripParentFilePath", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public class bf
  extends be
{
  private static final String[] miZ;
  public static final a mja;
  private final ac miY;
  
  static
  {
    AppMethodBeat.i(50948);
    mja = new a((byte)0);
    miZ = new String[] { "app-wxss.js", "page-frame.html" };
    s.VO("//XWEB_SCRIPT:");
    String str = ad.bie() + "/page";
    if (o.fB(str)) {
      o.dd(str, true);
    }
    AppMethodBeat.o(50948);
  }
  
  public bf(ac paramac)
  {
    super((a)paramac);
    AppMethodBeat.i(50947);
    this.miY = paramac;
    AppMethodBeat.o(50947);
  }
  
  /* Error */
  private static String Uf(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 124
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 130	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   10: astore_2
    //   11: aload_0
    //   12: ifnonnull +20 -> 32
    //   15: new 132	d/v
    //   18: dup
    //   19: ldc 134
    //   21: invokespecial 136	d/v:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: ldc 124
    //   27: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: athrow
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 140	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   37: astore_0
    //   38: aload_0
    //   39: ldc 142
    //   41: invokestatic 145	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   44: new 147	java/io/ByteArrayInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 150	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: checkcast 152	java/io/Closeable
    //   55: astore_2
    //   56: aload_2
    //   57: checkcast 147	java/io/ByteArrayInputStream
    //   60: checkcast 154	java/io/InputStream
    //   63: sipush 16384
    //   66: invokestatic 160	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   69: astore_0
    //   70: aload_0
    //   71: ldc 162
    //   73: invokestatic 145	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload_2
    //   77: aconst_null
    //   78: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   81: ldc 124
    //   83: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: ldc 124
    //   91: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: aload_1
    //   99: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   102: ldc 124
    //   104: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: goto -13 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramString	String
    //   1	1	1	localObject1	Object
    //   88	11	1	localThrowable	java.lang.Throwable
    //   10	88	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	76	88	java/lang/Throwable
    //   89	96	96	finally
    //   56	76	109	finally
  }
  
  /* Error */
  private static String Ug(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 169
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 173	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: checkcast 152	java/io/Closeable
    //   14: astore_2
    //   15: aload_2
    //   16: checkcast 154	java/io/InputStream
    //   19: sipush 16384
    //   22: invokestatic 160	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   25: astore_0
    //   26: aload_2
    //   27: aconst_null
    //   28: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   31: ldc 169
    //   33: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: areturn
    //   38: astore_1
    //   39: ldc 169
    //   41: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_1
    //   45: athrow
    //   46: astore_0
    //   47: aload_2
    //   48: aload_1
    //   49: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   52: ldc 169
    //   54: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: goto -13 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramString	String
    //   1	1	1	localObject	Object
    //   38	11	1	localThrowable	java.lang.Throwable
    //   14	34	2	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   15	26	38	java/lang/Throwable
    //   39	46	46	finally
    //   15	26	59	finally
  }
  
  public static final String bU(String paramString, int paramInt)
  {
    AppMethodBeat.i(50950);
    paramString = a.bU(paramString, paramInt);
    AppMethodBeat.o(50950);
    return paramString;
  }
  
  private final String em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50943);
    String str3 = Uf(paramString2);
    Object localObject1 = com.tencent.luggage.sdk.b.a.d.cnw;
    d.g.b.p.g(localObject1, "SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    String str1;
    String str2;
    if (e.contains((Object[])localObject1, paramString1)) {
      if (d.g.b.p.i(paramString1, "WAWebview.js"))
      {
        localObject1 = new StringBuilder().append(a.CS()).append('/');
        localObject2 = this.miY.aWe();
        d.g.b.p.g(localObject2, "renderer.libReader");
        d.g.b.p.h(localObject2, "reader");
        localObject1 = a.uZ(((ICommLibReader)localObject2).aZM());
        o.aZI((String)localObject1);
        localObject2 = new StringBuilder().append((String)localObject1).append('/').append(str3).append('-');
        str1 = q.encode(paramString1, "UTF-8");
        d.g.b.p.g(str1, "URLEncoder.encode(this, \"UTF-8\")");
        str2 = str1;
      }
    }
    for (;;)
    {
      String str4;
      try
      {
        if (o.fB(str2))
        {
          str4 = "check serialized file md5 script[" + paramString1 + "] appId[" + this.miY.getAppId() + ']';
          l = SystemClock.elapsedRealtime();
          String str5 = Ug(str2);
          if (str5 == null) {
            break label1053;
          }
          str1 = str5.toString();
          localObject2 = str1;
          if (str1 == null) {
            break label1053;
          }
          bool = com.tencent.mm.plugin.appbrand.utils.ag.Ck();
          l = SystemClock.elapsedRealtime() - l;
          if ((l <= 32L) || (!bool)) {
            break label665;
          }
          ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
          if (!(d.g.b.p.i(str5, str3) ^ true)) {
            break label873;
          }
        }
        str1 = "serialize script[" + paramString1 + "] appId[" + this.miY.getAppId() + ']';
        l = SystemClock.elapsedRealtime();
        o.deleteFile(str2 + ".utf16");
        localObject2 = d.n.d.UTF_8;
        if (paramString2 != null) {
          break label730;
        }
        paramString2 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(50943);
        throw paramString2;
      }
      catch (FileNotFoundException paramString2)
      {
        ae.e("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "checkScriptSerialized appId[" + this.miY.getAppId() + "] scriptName[" + paramString1 + "] e=" + paramString2);
        AppMethodBeat.o(50943);
        return null;
      }
      AppMethodBeat.o(50943);
      return null;
      localObject1 = this.miY.getRuntime();
      d.g.b.p.g(localObject1, "renderer.runtime");
      if (!j.a.rT(((com.tencent.mm.plugin.appbrand.p)localObject1).aWk()))
      {
        AppMethodBeat.o(50943);
        return null;
      }
      if ((e.contains(miZ, paramString1)) || (n.nG(paramString1, "page-frame.js"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(50943);
        return null;
      }
      localObject1 = new StringBuilder().append(a.CS()).append('/');
      localObject2 = this.miY.getAppId();
      d.g.b.p.g(localObject2, "renderer.appId");
      localObject1 = a.bU((String)localObject2, this.miY.Fc());
      o.aZI((String)localObject1);
      break;
      label665:
      ae.i("Luggage.Utils.Profile", "runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
      continue;
      label730:
      paramString2 = paramString2.getBytes((Charset)localObject2);
      d.g.b.p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
      localObject2 = Integer.valueOf(o.C(str2, paramString2)).toString();
      paramString2 = (String)localObject2;
      if (localObject2 == null) {
        paramString2 = "";
      }
      boolean bool = com.tencent.mm.plugin.appbrand.utils.ag.Ck();
      long l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str1 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        label873:
        localObject1 = new k((String)localObject1).fTj();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          label899:
          if (i >= j) {
            break label1048;
          }
          paramString2 = localObject1[i];
          d.g.b.p.g(paramString2, "file");
          localObject2 = paramString2.getAbsolutePath();
          d.g.b.p.g(localObject2, "file.absolutePath");
          if (!n.nF((String)localObject2, str2 + ".cachedata")) {
            break label1041;
          }
        }
      }
      for (;;)
      {
        if (paramString2 != null) {
          Ud(paramString1);
        }
        AppMethodBeat.o(50943);
        return str2;
        ae.i("Luggage.Utils.Profile", "runProfiled:log:" + str1 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        break;
        label1041:
        i += 1;
        break label899;
        label1048:
        paramString2 = null;
      }
      label1053:
      localObject2 = "";
    }
  }
  
  public static final String uZ(int paramInt)
  {
    AppMethodBeat.i(50949);
    String str = a.uZ(paramInt);
    AppMethodBeat.o(50949);
    return str;
  }
  
  public final String SR(String paramString)
  {
    AppMethodBeat.i(50942);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50942);
      return null;
    }
    String str = super.SR(paramString);
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      if (d.g.b.p.i("WAWebview.js", paramString)) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(370, 71);
      }
      AppMethodBeat.o(50942);
      return null;
    }
    localObject = em(paramString, str);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("provideScript use XWEBScript appId[").append(this.miY.getAppId()).append("] name[").append(paramString).append("], path[");
      i = n.b((CharSequence)localObject, '/');
      if (i > 0)
      {
        int j = ((String)localObject).length();
        if (localObject == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(50942);
          throw paramString;
        }
        paramString = ((String)localObject).substring(i, j);
        d.g.b.p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        ae.i("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", paramString + ']');
        paramString = new com.tencent.xweb.ag(3, 0, (WebView)this.miY.bvC());
        paramString.ng((String)localObject, s.bCo());
        paramString.bcH(str);
        paramString = paramString.toString();
        AppMethodBeat.o(50942);
        return paramString;
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(50942);
    return str;
  }
  
  public void Ud(String paramString)
  {
    AppMethodBeat.i(50944);
    d.g.b.p.h(paramString, "name");
    AppMethodBeat.o(50944);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl$Companion;", "", "()V", "DIR_NAME", "", "LIB_MAGIC_WORD", "MAIN_MODULE_APP_SCRIPTS", "", "[Ljava/lang/String;", "SPLITTER", "", "TAG", "codeCacheDir", "getCodeCacheDir", "()Ljava/lang/String;", "generateAppScriptSerializeNamePrefix", "appId", "version", "", "generateSdkScriptSerializeNamePrefix", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "versionCode", "mkdirs", "path", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String CS()
    {
      AppMethodBeat.i(50939);
      Object localObject = bf.mja;
      localObject = ad.bie() + "/page_scripts";
      o.aZI((String)localObject);
      AppMethodBeat.o(50939);
      return localObject;
    }
    
    public static String bU(String paramString, int paramInt)
    {
      AppMethodBeat.i(50941);
      d.g.b.p.h(paramString, "appId");
      paramString = org.apache.commons.b.g.a(new String[] { paramString, "v".concat(String.valueOf(paramInt)) }, '-', 2);
      d.g.b.p.g(paramString, "StringUtils.join(arrayOf…, \"v$version\"), SPLITTER)");
      AppMethodBeat.o(50941);
      return paramString;
    }
    
    public static String uZ(int paramInt)
    {
      AppMethodBeat.i(50940);
      String str = org.apache.commons.b.g.a(new String[] { "LIB", "v".concat(String.valueOf(paramInt)) }, '-', 2);
      d.g.b.p.g(str, "StringUtils.join(arrayOf…$versionCode\"), SPLITTER)");
      AppMethodBeat.o(50940);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bf
 * JD-Core Version:    0.7.0.1
 */