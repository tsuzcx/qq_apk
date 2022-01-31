package com.tencent.mm.plugin.appbrand;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.t.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class ag
{
  public static String a(i parami, String paramString1, String paramString2)
  {
    AppMethodBeat.i(140813);
    ab.i("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", new Object[] { paramString1, paramString2 });
    if ((parami == null) || (paramString1 == null) || (paramString1.length() == 0))
    {
      ab.w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
      AppMethodBeat.o(140813);
      return "";
    }
    if (j.a.nk(parami.wY().hiX.gXe))
    {
      ab.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      AppMethodBeat.o(140813);
      return "";
    }
    parami = ax.c(parami, paramString1 + ".map");
    if ((parami == null) || (parami.length() == 0))
    {
      ab.i("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", new Object[] { paramString1 });
      AppMethodBeat.o(140813);
      return "";
    }
    parami = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", new Object[] { paramString2 + paramString1, parami });
    AppMethodBeat.o(140813);
    return parami;
  }
  
  public static void a(i parami, com.tencent.mm.plugin.appbrand.i.i parami1)
  {
    AppMethodBeat.i(140812);
    ab.i("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
    if (parami == null)
    {
      ab.w("MicroMsg.SourceMapUtil", "hy: not valid runtime");
      AppMethodBeat.o(140812);
      return;
    }
    if (j.a.nk(parami.wY().hiX.gXe))
    {
      ab.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      AppMethodBeat.o(140812);
      return;
    }
    n.a(parami1, ax.c(parami, "WASourceMap.js"), new ag.1());
    parami1.evaluateJavascript(getSysInfo(), null);
    AppMethodBeat.o(140812);
  }
  
  @SuppressLint({"DefaultLocal"})
  public static String getSysInfo()
  {
    AppMethodBeat.i(140814);
    String str = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", new Object[] { Build.VERSION.RELEASE });
    AppMethodBeat.o(140814);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag
 * JD-Core Version:    0.7.0.1
 */