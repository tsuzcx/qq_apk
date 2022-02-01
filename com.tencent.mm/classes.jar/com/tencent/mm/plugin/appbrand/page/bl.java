package com.tencent.mm.plugin.appbrand.page;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ae;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import org.apache.commons.b.g;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;)V", "checkScriptSerialized", "", "scriptName", "scriptSource", "onScriptCodeCacheProvided", "", "name", "provideScript", "resourceName", "contentMD5", "fileMD5", "stripParentFilePath", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public class bl
  extends bk
{
  private static final String[] lfl;
  public static final a lfm;
  private final ad lfk;
  
  static
  {
    AppMethodBeat.i(50948);
    lfm = new a((byte)0);
    lfl = new String[] { "app-wxss.js", "page-frame.html" };
    q.No("//XWEB_SCRIPT:");
    String str = ac.aWU() + "/page";
    if (i.eK(str)) {
      i.cO(str, true);
    }
    AppMethodBeat.o(50948);
  }
  
  public bl(ad paramad)
  {
    super((a)paramad);
    AppMethodBeat.i(50947);
    this.lfk = paramad;
    AppMethodBeat.o(50947);
  }
  
  /* Error */
  private static String LK(String paramString)
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
    //   41: invokestatic 145	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
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
    //   73: invokestatic 145	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
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
  private static String LL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 169
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 173	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
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
  
  public static final String bJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(50950);
    paramString = a.bJ(paramString, paramInt);
    AppMethodBeat.o(50950);
    return paramString;
  }
  
  private final String dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50943);
    String str3 = LK(paramString2);
    Object localObject1 = com.tencent.luggage.sdk.b.a.d.cgg;
    k.g(localObject1, "SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    String str1;
    String str2;
    if (d.a.e.contains((Object[])localObject1, paramString1)) {
      if (k.g(paramString1, "WAWebview.js"))
      {
        localObject1 = new StringBuilder().append(a.BM()).append('/');
        localObject2 = this.lfk.aLC();
        k.g(localObject2, "renderer.libReader");
        k.h(localObject2, "reader");
        localObject1 = a.tB(((ICommLibReader)localObject2).aPc());
        i.aMF((String)localObject1);
        localObject2 = new StringBuilder().append((String)localObject1).append('/').append(str3).append('-');
        str1 = p.encode(paramString1, "UTF-8");
        k.g(str1, "URLEncoder.encode(this, \"UTF-8\")");
        str2 = str1;
      }
    }
    for (;;)
    {
      String str4;
      try
      {
        if (i.eK(str2))
        {
          str4 = "check serialized file md5 script[" + paramString1 + "] appId[" + this.lfk.getAppId() + ']';
          l = SystemClock.elapsedRealtime();
          String str5 = LL(str2);
          if (str5 == null) {
            break label1053;
          }
          str1 = str5.toString();
          localObject2 = str1;
          if (str1 == null) {
            break label1053;
          }
          bool = aa.Be();
          l = SystemClock.elapsedRealtime() - l;
          if ((l <= 32L) || (!bool)) {
            break label665;
          }
          com.tencent.mm.sdk.platformtools.ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
          if (!(k.g(str5, str3) ^ true)) {
            break label873;
          }
        }
        str1 = "serialize script[" + paramString1 + "] appId[" + this.lfk.getAppId() + ']';
        l = SystemClock.elapsedRealtime();
        i.deleteFile(str2 + ".utf16");
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
        com.tencent.mm.sdk.platformtools.ad.e("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "checkScriptSerialized appId[" + this.lfk.getAppId() + "] scriptName[" + paramString1 + "] e=" + paramString2);
        AppMethodBeat.o(50943);
        return null;
      }
      AppMethodBeat.o(50943);
      return null;
      localObject1 = this.lfk.getRuntime();
      k.g(localObject1, "renderer.runtime");
      if (!j.a.qD(((o)localObject1).aLI()))
      {
        AppMethodBeat.o(50943);
        return null;
      }
      if ((d.a.e.contains(lfl, paramString1)) || (n.mB(paramString1, "page-frame.js"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(50943);
        return null;
      }
      localObject1 = new StringBuilder().append(a.BM()).append('/');
      localObject2 = this.lfk.getAppId();
      k.g(localObject2, "renderer.appId");
      localObject1 = a.bJ((String)localObject2, this.lfk.DV());
      i.aMF((String)localObject1);
      break;
      label665:
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.Utils.Profile", "runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
      continue;
      label730:
      paramString2 = paramString2.getBytes((Charset)localObject2);
      k.g(paramString2, "(this as java.lang.String).getBytes(charset)");
      localObject2 = Integer.valueOf(i.B(str2, paramString2)).toString();
      paramString2 = (String)localObject2;
      if (localObject2 == null) {
        paramString2 = "";
      }
      boolean bool = aa.Be();
      long l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        com.tencent.mm.sdk.platformtools.ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str1 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        label873:
        localObject1 = new com.tencent.mm.vfs.e((String)localObject1).fhW();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          label899:
          if (i >= j) {
            break label1048;
          }
          paramString2 = localObject1[i];
          k.g(paramString2, "file");
          localObject2 = paramString2.getAbsolutePath();
          k.g(localObject2, "file.absolutePath");
          if (!n.mA((String)localObject2, str2 + ".cachedata")) {
            break label1041;
          }
        }
      }
      for (;;)
      {
        if (paramString2 != null) {
          LH(paramString1);
        }
        AppMethodBeat.o(50943);
        return str2;
        com.tencent.mm.sdk.platformtools.ad.i("Luggage.Utils.Profile", "runProfiled:log:" + str1 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
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
  
  public static final String tB(int paramInt)
  {
    AppMethodBeat.i(50949);
    String str = a.tB(paramInt);
    AppMethodBeat.o(50949);
    return str;
  }
  
  public final String Ky(String paramString)
  {
    AppMethodBeat.i(50942);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50942);
      return null;
    }
    String str = super.Ky(paramString);
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      if (k.g("WAWebview.js", paramString)) {
        h.vKh.dB(370, 71);
      }
      AppMethodBeat.o(50942);
      return null;
    }
    localObject = dN(paramString, str);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("provideScript use XWEBScript appId[").append(this.lfk.getAppId()).append("] name[").append(paramString).append("], path[");
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
        k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", paramString + ']');
        paramString = new ae(3, 0, (WebView)this.lfk.bka());
        paramString.mb((String)localObject, q.bqs());
        paramString.aPi(str);
        paramString = paramString.toString();
        AppMethodBeat.o(50942);
        return paramString;
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(50942);
    return str;
  }
  
  public void LH(String paramString)
  {
    AppMethodBeat.i(50944);
    k.h(paramString, "name");
    AppMethodBeat.o(50944);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl$Companion;", "", "()V", "DIR_NAME", "", "LIB_MAGIC_WORD", "MAIN_MODULE_APP_SCRIPTS", "", "[Ljava/lang/String;", "SPLITTER", "", "TAG", "codeCacheDir", "getCodeCacheDir", "()Ljava/lang/String;", "generateAppScriptSerializeNamePrefix", "appId", "version", "", "generateSdkScriptSerializeNamePrefix", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "versionCode", "mkdirs", "path", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String BM()
    {
      AppMethodBeat.i(50939);
      Object localObject = bl.lfm;
      localObject = ac.aWU() + "/page_scripts";
      i.aMF((String)localObject);
      AppMethodBeat.o(50939);
      return localObject;
    }
    
    public static String bJ(String paramString, int paramInt)
    {
      AppMethodBeat.i(50941);
      k.h(paramString, "appId");
      paramString = g.a(new String[] { paramString, "v".concat(String.valueOf(paramInt)) }, '-', 2);
      k.g(paramString, "StringUtils.join(arrayOf…, \"v$version\"), SPLITTER)");
      AppMethodBeat.o(50941);
      return paramString;
    }
    
    public static String tB(int paramInt)
    {
      AppMethodBeat.i(50940);
      String str = g.a(new String[] { "LIB", "v".concat(String.valueOf(paramInt)) }, '-', 2);
      k.g(str, "StringUtils.join(arrayOf…$versionCode\"), SPLITTER)");
      AppMethodBeat.o(50940);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */