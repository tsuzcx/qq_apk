package com.tencent.mm.plugin.appbrand.v;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.sdk.platformtools.y;

public final class p
{
  public static String a(com.tencent.mm.plugin.appbrand.i parami, String paramString1, String paramString2)
  {
    y.i("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", new Object[] { paramString1, paramString2 });
    if ((parami == null) || (paramString1 == null) || (paramString1.length() == 0))
    {
      y.w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
      return "";
    }
    if (d.a.kq(parami.ZB().aej()))
    {
      y.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      return "";
    }
    parami = aq.a(parami, paramString1 + ".map");
    if ((parami == null) || (parami.length() == 0))
    {
      y.i("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", new Object[] { paramString1 });
      return "";
    }
    return String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", new Object[] { paramString2 + paramString1, parami });
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.i parami, f paramf)
  {
    y.i("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
    if (parami == null)
    {
      y.w("MicroMsg.SourceMapUtil", "hy: not valid runtime");
      return;
    }
    if (d.a.kq(parami.ZB().aej()))
    {
      y.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
      return;
    }
    k.a(paramf, WxaCommLibRuntimeReader.qX("WASourceMap.js"), new p.1());
    paramf.evaluateJavascript(getSysInfo(), null);
  }
  
  @SuppressLint({"DefaultLocal"})
  public static String getSysInfo()
  {
    return String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", new Object[] { Build.VERSION.RELEASE });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.p
 * JD-Core Version:    0.7.0.1
 */