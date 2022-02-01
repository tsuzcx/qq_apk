package com.tencent.mm.plugin.appbrand.page;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.apache.commons.b.g;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;)V", "checkScriptSerialized", "", "scriptName", "scriptSource", "onScriptCodeCacheProvided", "", "name", "provideScript", "resourceName", "contentMD5", "fileMD5", "stripParentFilePath", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public class bj
  extends bi
{
  private static final String[] ntt;
  public static final a ntu;
  private final af nts;
  
  static
  {
    AppMethodBeat.i(50948);
    ntu = new a((byte)0);
    ntt = new String[] { "app-wxss.js", "page-frame.html" };
    com.tencent.mm.plugin.appbrand.utils.s.afK("//XWEB_SCRIPT:");
    String str = ad.bDt() + "/page";
    if (com.tencent.mm.vfs.s.YS(str)) {
      com.tencent.mm.vfs.s.dy(str, true);
    }
    AppMethodBeat.o(50948);
  }
  
  public bj(af paramaf)
  {
    super((a)paramaf);
    AppMethodBeat.i(50947);
    this.nts = paramaf;
    AppMethodBeat.o(50947);
  }
  
  /* Error */
  private static String adU(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 124
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 130	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   10: astore_2
    //   11: aload_0
    //   12: ifnonnull +20 -> 32
    //   15: new 132	kotlin/t
    //   18: dup
    //   19: ldc 134
    //   21: invokespecial 136	kotlin/t:<init>	(Ljava/lang/String;)V
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
    //   41: invokestatic 145	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
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
    //   73: invokestatic 145	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload_2
    //   77: aconst_null
    //   78: invokestatic 167	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    //   99: invokestatic 167	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
  
  public static final String cc(String paramString, int paramInt)
  {
    AppMethodBeat.i(50950);
    paramString = a.cc(paramString, paramInt);
    AppMethodBeat.o(50950);
    return paramString;
  }
  
  private final String eF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50943);
    String str3 = adU(paramString2);
    Object localObject1 = com.tencent.luggage.sdk.b.a.d.czy;
    p.g(localObject1, "SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    String str1;
    String str2;
    if (e.contains((Object[])localObject1, paramString1)) {
      if (p.j(paramString1, "WAWebview.js"))
      {
        localObject1 = new StringBuilder().append(a.Mo()).append('/');
        localObject2 = this.nts.bqZ();
        p.g(localObject2, "renderer.libReader");
        p.h(localObject2, "reader");
        localObject1 = a.yR(((ICommLibReader)localObject2).bvd());
        com.tencent.mm.vfs.s.boN((String)localObject1);
        localObject2 = new StringBuilder().append((String)localObject1).append('/').append(str3).append('-');
        str1 = com.tencent.mm.compatible.util.q.encode(paramString1, "UTF-8");
        p.g(str1, "URLEncoder.encode(this, \"UTF-8\")");
        str2 = str1;
      }
    }
    for (;;)
    {
      String str4;
      try
      {
        if (com.tencent.mm.vfs.s.YS(str2))
        {
          str4 = "check serialized file md5 script[" + paramString1 + "] appId[" + this.nts.getAppId() + ']';
          l = SystemClock.elapsedRealtime();
          String str5 = WxaPkgWrappingInfo.n(new o(str2));
          if (str5 == null) {
            break label1062;
          }
          str1 = str5.toString();
          localObject2 = str1;
          if (str1 == null) {
            break label1062;
          }
          bool = com.tencent.mm.plugin.appbrand.utils.ag.LB();
          l = SystemClock.elapsedRealtime() - l;
          if ((l <= 32L) || (!bool)) {
            break label673;
          }
          Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
          if (!(p.j(str5, str3) ^ true)) {
            break label881;
          }
        }
        str1 = "serialize script[" + paramString1 + "] appId[" + this.nts.getAppId() + ']';
        l = SystemClock.elapsedRealtime();
        com.tencent.mm.vfs.s.deleteFile(str2 + ".utf16");
        localObject2 = kotlin.n.d.UTF_8;
        if (paramString2 != null) {
          break label738;
        }
        paramString2 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(50943);
        throw paramString2;
      }
      catch (FileNotFoundException paramString2)
      {
        Log.e("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "checkScriptSerialized appId[" + this.nts.getAppId() + "] scriptName[" + paramString1 + "] e=" + paramString2);
        AppMethodBeat.o(50943);
        return null;
      }
      AppMethodBeat.o(50943);
      return null;
      localObject1 = this.nts.getRuntime();
      p.g(localObject1, "renderer.runtime");
      if (!j.a.vP(((com.tencent.mm.plugin.appbrand.q)localObject1).brf()))
      {
        AppMethodBeat.o(50943);
        return null;
      }
      if ((e.contains(ntt, paramString1)) || (n.K(paramString1, "page-frame.js", false))) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(50943);
        return null;
      }
      localObject1 = new StringBuilder().append(a.Mo()).append('/');
      localObject2 = this.nts.getAppId();
      p.g(localObject2, "renderer.appId");
      localObject1 = a.cc((String)localObject2, this.nts.OJ());
      com.tencent.mm.vfs.s.boN((String)localObject1);
      break;
      label673:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
      continue;
      label738:
      paramString2 = paramString2.getBytes((Charset)localObject2);
      p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
      localObject2 = Integer.valueOf(com.tencent.mm.vfs.s.C(str2, paramString2)).toString();
      paramString2 = (String)localObject2;
      if (localObject2 == null) {
        paramString2 = "";
      }
      boolean bool = com.tencent.mm.plugin.appbrand.utils.ag.LB();
      long l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str1 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        label881:
        localObject1 = new o((String)localObject1).het();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          i = 0;
          label907:
          if (i >= j) {
            break label1057;
          }
          paramString2 = localObject1[i];
          p.g(paramString2, "file");
          localObject2 = paramString2.getAbsolutePath();
          p.g(localObject2, "file.absolutePath");
          if (!n.J((String)localObject2, str2 + ".cachedata", false)) {
            break label1050;
          }
        }
      }
      for (;;)
      {
        if (paramString2 != null) {
          adR(paramString1);
        }
        AppMethodBeat.o(50943);
        return str2;
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str1 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        break;
        label1050:
        i += 1;
        break label907;
        label1057:
        paramString2 = null;
      }
      label1062:
      localObject2 = "";
    }
  }
  
  public static final String yR(int paramInt)
  {
    AppMethodBeat.i(50949);
    String str = a.yR(paramInt);
    AppMethodBeat.o(50949);
    return str;
  }
  
  public void adR(String paramString)
  {
    AppMethodBeat.i(50944);
    p.h(paramString, "name");
    AppMethodBeat.o(50944);
  }
  
  public final String adT(String paramString)
  {
    AppMethodBeat.i(50942);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50942);
      return null;
    }
    String str = super.adT(paramString);
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      if (p.j("WAWebview.js", paramString)) {
        h.CyF.dN(370, 71);
      }
      AppMethodBeat.o(50942);
      return null;
    }
    localObject = eF(paramString, str);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("provideScript use XWEBScript appId[").append(this.nts.getAppId()).append("] name[").append(paramString).append("], path[");
      i = n.b((CharSequence)localObject, '/');
      if (i > 0)
      {
        int j = ((String)localObject).length();
        if (localObject == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(50942);
          throw paramString;
        }
        paramString = ((String)localObject).substring(i, j);
        p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        Log.i("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", paramString + ']');
        paramString = new com.tencent.xweb.ag(3, 0, (WebView)this.nts.bRI());
        paramString.ob((String)localObject, com.tencent.mm.plugin.appbrand.utils.s.bZs());
        paramString.bsr(str);
        paramString = paramString.toString();
        AppMethodBeat.o(50942);
        return paramString;
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(50942);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl$Companion;", "", "()V", "DIR_NAME", "", "LIB_MAGIC_WORD", "MAIN_MODULE_APP_SCRIPTS", "", "[Ljava/lang/String;", "SPLITTER", "", "TAG", "codeCacheDir", "getCodeCacheDir", "()Ljava/lang/String;", "generateAppScriptSerializeNamePrefix", "appId", "version", "", "generateSdkScriptSerializeNamePrefix", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "versionCode", "mkdirs", "path", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String Mo()
    {
      AppMethodBeat.i(50939);
      Object localObject = bj.ntu;
      localObject = ad.bDt() + "/page_scripts";
      com.tencent.mm.vfs.s.boN((String)localObject);
      AppMethodBeat.o(50939);
      return localObject;
    }
    
    public static String cc(String paramString, int paramInt)
    {
      AppMethodBeat.i(50941);
      p.h(paramString, "appId");
      String[] arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = "v".concat(String.valueOf(paramInt));
      paramString = g.a(arrayOfString, '-', arrayOfString.length);
      p.g(paramString, "StringUtils.join(arrayOf…, \"v$version\"), SPLITTER)");
      AppMethodBeat.o(50941);
      return paramString;
    }
    
    public static String yR(int paramInt)
    {
      AppMethodBeat.i(50940);
      Object localObject = new String[2];
      localObject[0] = "LIB";
      localObject[1] = "v".concat(String.valueOf(paramInt));
      localObject = g.a((Object[])localObject, '-', localObject.length);
      p.g(localObject, "StringUtils.join(arrayOf…$versionCode\"), SPLITTER)");
      AppMethodBeat.o(50940);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */