package com.tencent.mm.plugin.appbrand;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Locale;

public final class be
{
  public static String a(AppBrandRuntime paramAppBrandRuntime, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146928);
    Log.i("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramAppBrandRuntime == null) || (paramString1 == null) || (paramString1.length() == 0))
    {
      Log.w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
      AppMethodBeat.o(146928);
      return "";
    }
    if (j.a.za(paramAppBrandRuntime.Sp().nYR.nHY))
    {
      Log.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      AppMethodBeat.o(146928);
      return "";
    }
    paramAppBrandRuntime = bl.d(paramAppBrandRuntime, paramString1 + ".map");
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.length() == 0))
    {
      Log.i("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", new Object[] { paramString1 });
      AppMethodBeat.o(146928);
      return "";
    }
    paramAppBrandRuntime = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", new Object[] { paramString2 + paramString1, paramAppBrandRuntime });
    AppMethodBeat.o(146928);
    return paramAppBrandRuntime;
  }
  
  public static void a(g paramg, i parami)
  {
    AppMethodBeat.i(169480);
    u.a(parami, b(paramg), new u.a()
    {
      public final void dL(String paramAnonymousString)
      {
        AppMethodBeat.i(146926);
        Log.e("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", new Object[] { "WASourceMap.js", paramAnonymousString });
        AppMethodBeat.o(146926);
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        AppMethodBeat.i(146925);
        Log.i("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", new Object[] { "WASourceMap.js", paramAnonymousString });
        AppMethodBeat.o(146925);
      }
    });
    parami.evaluateJavascript(getSysInfo(), null);
    AppMethodBeat.o(169480);
  }
  
  public static String b(g paramg)
  {
    AppMethodBeat.i(169481);
    Log.i("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
    if (paramg == null)
    {
      Log.w("MicroMsg.SourceMapUtil", "hy: not valid runtime");
      AppMethodBeat.o(169481);
      return "";
    }
    if (paramg.getRuntime() == null)
    {
      Log.w("MicroMsg.SourceMapUtil", "hy: runtime not prepared. do not try to inject sourcemap.js. maybe preloading");
      AppMethodBeat.o(169481);
      return "";
    }
    if (j.a.za(paramg.getRuntime().ntz.cBI))
    {
      Log.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      AppMethodBeat.o(169481);
      return "";
    }
    paramg = (ICommLibReader)paramg.K(ICommLibReader.class);
    if (paramg == null)
    {
      Log.e("MicroMsg.SourceMapUtil", "execSourceMapScript NULL reader");
      AppMethodBeat.o(169481);
      return "";
    }
    paramg = paramg.acw("WASourceMap.js");
    AppMethodBeat.o(169481);
    return paramg;
  }
  
  public static boolean c(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(169483);
    Log.i("MicroMsg.SourceMapUtil", "is sourcemap exist: %s", new Object[] { paramString });
    if ((paramAppBrandRuntime == null) || (paramString == null) || (paramString.length() == 0))
    {
      Log.w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
      AppMethodBeat.o(169483);
      return false;
    }
    if (j.a.za(paramAppBrandRuntime.Sp().nYR.nHY))
    {
      Log.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      AppMethodBeat.o(169483);
      return false;
    }
    boolean bool = bl.g(paramAppBrandRuntime, paramString + ".map");
    AppMethodBeat.o(169483);
    return bool;
  }
  
  @SuppressLint({"DefaultLocal"})
  public static String getSysInfo()
  {
    AppMethodBeat.i(146929);
    String str = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", new Object[] { Build.VERSION.RELEASE });
    AppMethodBeat.o(146929);
    return str;
  }
  
  public static ArrayList<ScriptPartObject> i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(169482);
    Log.i("MicroMsg.SourceMapUtil", "buildSourceMapAppendList wxapkgPath: %s, filePath: %s", new Object[] { paramString1, paramString2 });
    ArrayList localArrayList = new ArrayList();
    ScriptPartObject localScriptPartObject = new ScriptPartObject();
    localScriptPartObject.type = 1;
    localScriptPartObject.content = String.format(Locale.US, "typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = ", new Object[] { paramString4 });
    localArrayList.add(localScriptPartObject);
    paramString4 = new ScriptPartObject();
    paramString4.type = 2;
    paramString4.wxaPkgPath = paramString1;
    paramString4.wxaFileName = paramString2;
    paramString4.wxaPkgKeyFilePath = paramString3;
    localArrayList.add(paramString4);
    paramString1 = new ScriptPartObject();
    paramString1.type = 1;
    paramString1.content = ")";
    localArrayList.add(paramString1);
    AppMethodBeat.o(169482);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.be
 * JD-Core Version:    0.7.0.1
 */