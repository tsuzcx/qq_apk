package com.tencent.mm.plugin.appbrand.page;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.n.ad;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.an;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.f.b;
import kotlin.g.b.s;
import kotlin.n.n;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;)V", "checkScriptSerialized", "", "scriptName", "scriptSource", "onScriptCodeCacheProvided", "", "name", "provideScript", "resourceName", "contentMD5", "fileMD5", "stripParentFilePath", "urlEncode", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class bl
  extends bk
{
  public static final a tAb;
  private static final String tAd;
  private static final String[] tAe;
  private static final String[] tAf;
  private final ag tAc;
  
  static
  {
    AppMethodBeat.i(50948);
    tAb = new a((byte)0);
    String str = ad.cpf();
    s.s(str, "retrieve()");
    if (n.rs(str, "/")) {}
    for (;;)
    {
      tAd = str;
      tAe = new String[] { "app-wxss.js", "page-frame.html", "common.app.js", "webview.app.js" };
      tAf = new String[] { "page-frame.js", "common.app.js", "webview.app.js" };
      z.agG("//XWEB_SCRIPT:");
      str = s.X(ad.cpf(), "/page");
      if (y.ZC(str)) {
        y.ew(str, true);
      }
      AppMethodBeat.o(50948);
      return;
      str = s.X(str, "/");
    }
  }
  
  public bl(ag paramag)
  {
    super((a)paramag);
    AppMethodBeat.i(50947);
    this.tAc = paramag;
    AppMethodBeat.o(50947);
  }
  
  public static final String CL(int paramInt)
  {
    AppMethodBeat.i(50949);
    String str = a.CL(paramInt);
    AppMethodBeat.o(50949);
    return str;
  }
  
  private static String aeV(String paramString)
  {
    AppMethodBeat.i(50945);
    Object localObject1 = kotlin.n.d.UTF_8;
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50945);
      throw paramString;
    }
    paramString = paramString.getBytes((Charset)localObject1);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = (Closeable)new ByteArrayInputStream(paramString);
    try
    {
      localObject1 = g.e((InputStream)paramString, 16384);
      s.s(localObject1, "getMD5(inputStream, 16*1024)");
      b.a(paramString, null);
      AppMethodBeat.o(50945);
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(50945);
        throw localThrowable;
      }
      finally
      {
        b.a(paramString, localThrowable);
        AppMethodBeat.o(50945);
      }
    }
  }
  
  public static final String cY(String paramString, int paramInt)
  {
    AppMethodBeat.i(50950);
    paramString = a.cY(paramString, paramInt);
    AppMethodBeat.o(50950);
    return paramString;
  }
  
  private final String fk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50943);
    Object localObject1 = com.tencent.luggage.sdk.b.a.d.eqO;
    s.s(localObject1, "SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject3;
    String str3;
    String str2;
    if (k.contains((Object[])localObject1, paramString1)) {
      if (s.p(paramString1, "WAWebview.js"))
      {
        localObject1 = new StringBuilder().append(a.apo()).append('/');
        localObject3 = ((ah)this.tAc.aqX()).cbl();
        s.s(localObject3, "renderer.libReader");
        s.u(localObject3, "reader");
        localObject3 = a.CL(((ICommLibReader)localObject3).cfG());
        y.bDX((String)localObject3);
        str3 = aeV(paramString2);
        localObject1 = new StringBuilder().append((String)localObject3).append('/').append(str3).append('-');
        str1 = r.as(paramString1, "UTF-8");
        s.s(str1, "encode(this, \"UTF-8\")");
        str2 = str1;
      }
    }
    int j;
    for (;;)
    {
      String str4;
      String str5;
      try
      {
        if (y.ZC(str2))
        {
          str4 = "check serialized file md5 script[" + paramString1 + "] appId[" + this.tAc.getAppId() + ']';
          localObject1 = com.tencent.luggage.sdk.h.d.evM;
          l = SystemClock.elapsedRealtime();
          str5 = WxaPkgWrappingInfo.n(new u(str2));
          if (str5 != null) {
            break label738;
          }
          localObject1 = "";
          bool = ao.aoz();
          l = SystemClock.elapsedRealtime() - l;
          if ((l <= 32L) || (!bool)) {
            break label762;
          }
          Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
          if (s.p(str5, str3)) {
            break label1040;
          }
        }
        str3 = "serialize script[" + paramString1 + "] appId[" + this.tAc.getAppId() + ']';
        localObject1 = com.tencent.luggage.sdk.h.d.evM;
        l = SystemClock.elapsedRealtime();
        y.deleteFile(s.X(str2, ".utf16"));
        localObject1 = kotlin.n.d.UTF_8;
        if (paramString2 != null) {
          break label827;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(50943);
        throw ((Throwable)localObject1);
      }
      catch (IOException localIOException)
      {
        Log.e("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "checkScriptSerialized appId[" + this.tAc.getAppId() + "] scriptName[" + paramString1 + "] e=" + localIOException);
        y.deleteFile(s.X(str2, ".utf16"));
        paramString1 = kotlin.n.d.UTF_8;
        if (paramString2 != null) {
          break label1193;
        }
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50943);
      throw paramString1;
      AppMethodBeat.o(50943);
      return null;
      if (!k.a.zn(this.tAc.getRuntime().qsh.eul))
      {
        AppMethodBeat.o(50943);
        return null;
      }
      if (k.contains(tAe, paramString1)) {
        i = 1;
      }
      while (i == 0)
      {
        AppMethodBeat.o(50943);
        return null;
        localObject3 = tAf;
        j = localObject3.length;
        i = 0;
        label621:
        if (i < j)
        {
          localObject2 = localObject3[i];
          if (!n.rs(paramString1, (String)localObject2)) {}
        }
        for (;;)
        {
          if (localObject2 == null) {
            break label665;
          }
          i = 1;
          break;
          i += 1;
          break label621;
          localObject2 = null;
        }
        label665:
        i = 0;
      }
      localObject2 = new StringBuilder().append(a.apo()).append('/');
      localObject3 = this.tAc.getAppId();
      s.s(localObject3, "renderer.appId");
      localObject3 = a.cY((String)localObject3, this.tAc.asw());
      y.bDX((String)localObject3);
      break;
      label738:
      str1 = str5.toString();
      localObject2 = str1;
      if (str1 == null)
      {
        localObject2 = "";
        continue;
        label762:
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str4 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
      }
    }
    label827:
    Object localObject2 = paramString2.getBytes((Charset)localObject2);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    int i = y.f(str2, (byte[])localObject2, localObject2.length);
    if (i != 0)
    {
      Log.e("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "serialize script[" + paramString1 + "] appId[" + this.tAc.getAppId() + "], failed " + i);
      AppMethodBeat.o(50943);
      return null;
    }
    String str1 = kotlin.ah.aiuX.toString();
    localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    boolean bool = ao.aoz();
    long l = SystemClock.elapsedRealtime() - l;
    if ((l > 32L) && (bool))
    {
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str3 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
      label1040:
      localObject2 = new u((String)localObject3).jKX();
      if (localObject2 != null)
      {
        j = localObject2.length;
        i = 0;
        label1066:
        if (i >= j) {
          break label1228;
        }
        paramString2 = localObject2[i];
        localObject3 = com.tencent.mm.vfs.ah.v(paramString2.jKT());
        s.s(localObject3, "file.absolutePath");
        if (!n.U((String)localObject3, s.X(str2, ".cachedata"), false)) {
          break label1221;
        }
      }
    }
    for (;;)
    {
      if (paramString2 != null) {
        aeS(paramString1);
      }
      AppMethodBeat.o(50943);
      return str2;
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str3 + " cost " + l + " ms result:" + (String)localObject2 + " isMainThread: " + bool + ' ');
      break;
      label1193:
      paramString1 = paramString2.getBytes(paramString1);
      s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
      y.f(str2, paramString1, paramString1.length);
      AppMethodBeat.o(50943);
      return null;
      label1221:
      i += 1;
      break label1066;
      label1228:
      paramString2 = null;
    }
  }
  
  public void aeS(String paramString)
  {
    AppMethodBeat.i(50944);
    s.u(paramString, "name");
    AppMethodBeat.o(50944);
  }
  
  public final String aeU(String paramString)
  {
    AppMethodBeat.i(50942);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50942);
      return null;
    }
    String str = super.aeU(paramString);
    localObject1 = (CharSequence)str;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      if (s.p("WAWebview.js", paramString)) {
        h.OAn.kJ(370, 71);
      }
      AppMethodBeat.o(50942);
      return null;
    }
    localObject1 = fk(paramString, str);
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder("provideScript use XWEBScript appId[").append(this.tAc.getAppId()).append("] name[").append(paramString).append("], path[");
      i = n.b((CharSequence)localObject1, '/');
      if (i > 0)
      {
        int j = ((String)localObject1).length();
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(50942);
          throw paramString;
        }
        paramString = ((String)localObject1).substring(i, j);
        s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (;;)
      {
        Log.i("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", paramString + ']');
        paramString = new an(3, 0, (WebView)this.tAc.cFc());
        localObject1 = y.n((String)localObject1, false);
        localObject2 = z.cNC();
        paramString.qU((String)localObject1, "path");
        paramString.aigd = ((String)localObject2);
        paramString.aige = str;
        paramString = paramString.toString();
        AppMethodBeat.o(50942);
        return paramString;
        paramString = (String)localObject1;
      }
    }
    AppMethodBeat.o(50942);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderXWebCodeCacheImpl$Companion;", "", "()V", "DIR_NAME", "", "LIB_MAGIC_WORD", "MAIN_MODULE_APP_SCRIPTS", "", "[Ljava/lang/String;", "MODULE_SHARED_SCRIPTS_SUFFIX", "PARENT_DIR_PATH", "SPLITTER", "", "TAG", "codeCacheDir", "getCodeCacheDir", "()Ljava/lang/String;", "generateAppScriptSerializeNamePrefix", "appId", "version", "", "generateSdkScriptSerializeNamePrefix", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "versionCode", "mkdirs", "path", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String CL(int paramInt)
    {
      AppMethodBeat.i(50940);
      String str = i.a(new String[] { "LIB", s.X("v", Integer.valueOf(paramInt)) }, '-', 2);
      s.s(str, "join(arrayOf(LIB_MAGIC_W…$versionCode\"), SPLITTER)");
      AppMethodBeat.o(50940);
      return str;
    }
    
    public static String apo()
    {
      AppMethodBeat.i(50939);
      String str = s.X(bl.cFO(), "page_scripts");
      y.bDX(str);
      AppMethodBeat.o(50939);
      return str;
    }
    
    public static String cY(String paramString, int paramInt)
    {
      AppMethodBeat.i(50941);
      s.u(paramString, "appId");
      paramString = i.a(new String[] { paramString, s.X("v", Integer.valueOf(paramInt)) }, '-', 2);
      s.s(paramString, "join(arrayOf(appId, \"v$version\"), SPLITTER)");
      AppMethodBeat.o(50941);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */