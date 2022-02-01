package com.tencent.mm.plugin.appbrand.page;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.apache.commons.b.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;)V", "checkScriptSerialized", "", "scriptName", "scriptSource", "onScriptCodeCacheProvided", "", "name", "provideScript", "resourceName", "contentMD5", "fileMD5", "stripParentFilePath", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public class bl
  extends bk
{
  private static final String qvm;
  private static final String[] qvn;
  private static final String[] qvo;
  public static final a qvp;
  private final ag qvl;
  
  static
  {
    AppMethodBeat.i(50948);
    qvp = new a((byte)0);
    String str = ad.bOR();
    p.j(str, "V8CodeCachePathRetriever.retrieve()");
    if (n.pu(str, "/")) {}
    for (;;)
    {
      qvm = str;
      qvn = new String[] { "app-wxss.js", "page-frame.html", "common.app.js", "webview.app.js" };
      qvo = new String[] { "page-frame.js", "common.app.js", "webview.app.js" };
      com.tencent.mm.plugin.appbrand.utils.u.anm("//XWEB_SCRIPT:");
      str = ad.bOR() + "/page";
      if (com.tencent.mm.vfs.u.agG(str)) {
        com.tencent.mm.vfs.u.dK(str, true);
      }
      AppMethodBeat.o(50948);
      return;
      str = str + "/";
    }
  }
  
  public bl(ag paramag)
  {
    super((a)paramag);
    AppMethodBeat.i(50947);
    this.qvl = paramag;
    AppMethodBeat.o(50947);
  }
  
  public static final String Cv(int paramInt)
  {
    AppMethodBeat.i(50949);
    String str = a.Cv(paramInt);
    AppMethodBeat.o(50949);
    return str;
  }
  
  /* Error */
  private static String alP(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 155
    //   4: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 161	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   10: astore_2
    //   11: aload_0
    //   12: ifnonnull +20 -> 32
    //   15: new 163	kotlin/t
    //   18: dup
    //   19: ldc 165
    //   21: invokespecial 167	kotlin/t:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: ldc 155
    //   27: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: athrow
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 171	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   37: astore_0
    //   38: aload_0
    //   39: ldc 173
    //   41: invokestatic 71	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   44: new 175	java/io/ByteArrayInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 178	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: checkcast 180	java/io/Closeable
    //   55: astore_2
    //   56: aload_2
    //   57: checkcast 175	java/io/ByteArrayInputStream
    //   60: checkcast 182	java/io/InputStream
    //   63: sipush 16384
    //   66: invokestatic 188	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   69: astore_0
    //   70: aload_0
    //   71: ldc 190
    //   73: invokestatic 71	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload_2
    //   77: aconst_null
    //   78: invokestatic 195	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   81: ldc 155
    //   83: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: ldc 155
    //   91: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: aload_1
    //   99: invokestatic 195	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   102: ldc 155
    //   104: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: goto -13 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramString	String
    //   1	1	1	localObject1	Object
    //   88	11	1	localThrowable	Throwable
    //   10	88	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	76	88	java/lang/Throwable
    //   89	96	96	finally
    //   56	76	109	finally
  }
  
  public static final String cA(String paramString, int paramInt)
  {
    AppMethodBeat.i(50950);
    paramString = a.cA(paramString, paramInt);
    AppMethodBeat.o(50950);
    return paramString;
  }
  
  private final String eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50943);
    Object localObject1 = com.tencent.luggage.sdk.b.a.d.cyu;
    p.j(localObject1, "SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject3;
    String str3;
    String str1;
    String str2;
    if (e.contains((Object[])localObject1, paramString1)) {
      if (p.h(paramString1, "WAWebview.js"))
      {
        localObject1 = new StringBuilder().append(a.Pg()).append('/');
        localObject3 = this.qvl.bBP();
        p.j(localObject3, "renderer.libReader");
        p.k(localObject3, "reader");
        localObject1 = a.Cv(((ICommLibReader)localObject3).bGi());
        com.tencent.mm.vfs.u.bBD((String)localObject1);
        str3 = alP(paramString2);
        localObject3 = new StringBuilder().append((String)localObject1).append('/').append(str3).append('-');
        str1 = com.tencent.mm.compatible.util.q.an(paramString1, "UTF-8");
        p.j(str1, "URLEncoder.encode(this, \"UTF-8\")");
        str2 = str1;
      }
    }
    for (;;)
    {
      String str4;
      try
      {
        if (com.tencent.mm.vfs.u.agG(str2))
        {
          str4 = "check serialized file md5 script[" + paramString1 + "] appId[" + this.qvl.getAppId() + ']';
          l = SystemClock.elapsedRealtime();
          String str5 = WxaPkgWrappingInfo.n(new com.tencent.mm.vfs.q(str2));
          if (str5 == null) {
            break label1252;
          }
          str1 = str5.toString();
          localObject3 = str1;
          if (str1 == null) {
            break label1252;
          }
          bool = com.tencent.mm.plugin.appbrand.utils.ai.Or();
          l = SystemClock.elapsedRealtime() - l;
          if ((l <= 32L) || (!bool)) {
            break label769;
          }
          Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject3 + " isMainThread: " + bool + ' ');
          if (!(p.h(str5, str3) ^ true)) {
            break label1044;
          }
        }
        str3 = "serialize script[" + paramString1 + "] appId[" + this.qvl.getAppId() + ']';
        l = SystemClock.elapsedRealtime();
        com.tencent.mm.vfs.u.deleteFile(str2 + ".utf16");
        localObject3 = kotlin.n.d.UTF_8;
        if (paramString2 != null) {
          break label834;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(50943);
        throw ((Throwable)localObject1);
      }
      catch (IOException localIOException)
      {
        Log.e("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "checkScriptSerialized appId[" + this.qvl.getAppId() + "] scriptName[" + paramString1 + "] e=" + localIOException);
        com.tencent.mm.vfs.u.deleteFile(str2 + ".utf16");
        paramString1 = kotlin.n.d.UTF_8;
        if (paramString2 != null) {
          break label1214;
        }
      }
      paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50943);
      throw paramString1;
      AppMethodBeat.o(50943);
      return null;
      Object localObject2 = this.qvl.getRuntime();
      p.j(localObject2, "renderer.runtime");
      if (!j.a.za(((com.tencent.mm.plugin.appbrand.t)localObject2).bBV()))
      {
        AppMethodBeat.o(50943);
        return null;
      }
      if (e.contains(qvn, paramString1)) {
        i = 1;
      }
      int j;
      while (i == 0)
      {
        AppMethodBeat.o(50943);
        return null;
        localObject3 = qvo;
        j = localObject3.length;
        i = 0;
        label652:
        if (i < j)
        {
          localObject2 = localObject3[i];
          if (!n.pu(paramString1, (String)localObject2)) {}
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label696;
          }
          i = 1;
          break;
          i += 1;
          break label652;
          localObject2 = null;
        }
        label696:
        i = 0;
      }
      localObject2 = new StringBuilder().append(a.Pg()).append('/');
      localObject3 = this.qvl.getAppId();
      p.j(localObject3, "renderer.appId");
      localObject2 = a.cA((String)localObject3, this.qvl.Sg());
      com.tencent.mm.vfs.u.bBD((String)localObject2);
      break;
      label769:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject3 + " isMainThread: " + bool + ' ');
      continue;
      label834:
      localObject3 = paramString2.getBytes((Charset)localObject3);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      int i = com.tencent.mm.vfs.u.H(str2, (byte[])localObject3);
      if (i != 0)
      {
        Log.e("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "serialize script[" + paramString1 + "] appId[" + this.qvl.getAppId() + "], failed " + i);
        AppMethodBeat.o(50943);
        return null;
      }
      str1 = x.aazN.toString();
      localObject3 = str1;
      if (str1 == null) {
        localObject3 = "";
      }
      boolean bool = com.tencent.mm.plugin.appbrand.utils.ai.Or();
      long l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str3 + " cost " + l + " ms result:" + (String)localObject3 + " isMainThread: " + bool + ' ');
        label1044:
        localObject2 = new com.tencent.mm.vfs.q((String)localObject2).ifJ();
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = 0;
          label1070:
          if (i >= j) {
            break label1247;
          }
          paramString2 = localObject2[i];
          p.j(paramString2, "file");
          localObject3 = paramString2.bOF();
          p.j(localObject3, "file.absolutePath");
          if (!n.M((String)localObject3, str2 + ".cachedata", false)) {
            break label1240;
          }
        }
      }
      for (;;)
      {
        if (paramString2 != null) {
          alM(paramString1);
        }
        AppMethodBeat.o(50943);
        return str2;
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str3 + " cost " + l + " ms result:" + (String)localObject3 + " isMainThread: " + bool + ' ');
        break;
        label1214:
        paramString1 = paramString2.getBytes(paramString1);
        p.j(paramString1, "(this as java.lang.String).getBytes(charset)");
        com.tencent.mm.vfs.u.H(str2, paramString1);
        AppMethodBeat.o(50943);
        return null;
        label1240:
        i += 1;
        break label1070;
        label1247:
        paramString2 = null;
      }
      label1252:
      localObject3 = "";
    }
  }
  
  public void alM(String paramString)
  {
    AppMethodBeat.i(50944);
    p.k(paramString, "name");
    AppMethodBeat.o(50944);
  }
  
  public final String alO(String paramString)
  {
    AppMethodBeat.i(50942);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50942);
      return null;
    }
    String str = super.alO(paramString);
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      if (p.h("WAWebview.js", paramString)) {
        h.IzE.el(370, 71);
      }
      AppMethodBeat.o(50942);
      return null;
    }
    localObject = eT(paramString, str);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("provideScript use XWEBScript appId[").append(this.qvl.getAppId()).append("] name[").append(paramString).append("], path[");
      i = n.b((CharSequence)localObject, '/');
      if (i > 0)
      {
        int j = ((String)localObject).length();
        if (localObject == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(50942);
          throw paramString;
        }
        paramString = ((String)localObject).substring(i, j);
        p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        Log.i("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", paramString + ']');
        paramString = new com.tencent.xweb.ai(3, 0, (WebView)this.qvl.cez());
        paramString.oX(com.tencent.mm.vfs.u.n((String)localObject, false), com.tencent.mm.plugin.appbrand.utils.u.cmi());
        paramString.bFq(str);
        paramString = paramString.toString();
        AppMethodBeat.o(50942);
        return paramString;
        paramString = (String)localObject;
      }
    }
    AppMethodBeat.o(50942);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl$Companion;", "", "()V", "DIR_NAME", "", "LIB_MAGIC_WORD", "MAIN_MODULE_APP_SCRIPTS", "", "[Ljava/lang/String;", "MODULE_SHARED_SCRIPTS_SUFFIX", "PARENT_DIR_PATH", "SPLITTER", "", "TAG", "codeCacheDir", "getCodeCacheDir", "()Ljava/lang/String;", "generateAppScriptSerializeNamePrefix", "appId", "version", "", "generateSdkScriptSerializeNamePrefix", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "versionCode", "mkdirs", "path", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static String Cv(int paramInt)
    {
      AppMethodBeat.i(50940);
      Object localObject = new String[2];
      localObject[0] = "LIB";
      localObject[1] = "v".concat(String.valueOf(paramInt));
      localObject = g.a((Object[])localObject, '-', localObject.length);
      p.j(localObject, "StringUtils.join(arrayOf…$versionCode\"), SPLITTER)");
      AppMethodBeat.o(50940);
      return localObject;
    }
    
    public static String Pg()
    {
      AppMethodBeat.i(50939);
      Object localObject = bl.qvp;
      localObject = bl.cfa() + "page_scripts";
      com.tencent.mm.vfs.u.bBD((String)localObject);
      AppMethodBeat.o(50939);
      return localObject;
    }
    
    public static String cA(String paramString, int paramInt)
    {
      AppMethodBeat.i(50941);
      p.k(paramString, "appId");
      String[] arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = "v".concat(String.valueOf(paramInt));
      paramString = g.a(arrayOfString, '-', arrayOfString.length);
      p.j(paramString, "StringUtils.join(arrayOf…, \"v$version\"), SPLITTER)");
      AppMethodBeat.o(50941);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */