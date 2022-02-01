package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.util.zip.ZipInputStream;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandUnzipLogic;", "", "()V", "APP_BRAND_CACHE_DIRECTORY_NAME", "", "APP_BRAND_UNZIP_CACHE_DIRECTORY_NAME", "PATH_PREFIX_NETWORK", "PATH_PREFIX_TEMP", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "generateUnzipPathName", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "zipPath", "getUnzipDir", "isUnzipDirValid", "", "unzipDir", "unzip", "zipInputStream", "Ljava/util/zip/ZipInputStream;", "unzipIfNeed", "luggage-xweb-ext_release"})
public final class f
{
  private static final kotlin.f mJQ;
  public static final f mJR;
  
  static
  {
    AppMethodBeat.i(215996);
    mJR = new f();
    mJQ = kotlin.g.ah((a)f.a.mJS);
    AppMethodBeat.o(215996);
  }
  
  public static boolean F(o paramo)
  {
    AppMethodBeat.i(215994);
    p.h(paramo, "unzipDir");
    d locald = d.mJM;
    boolean bool = d.D(paramo);
    AppMethodBeat.o(215994);
    return bool;
  }
  
  public static o a(ZipInputStream paramZipInputStream, o paramo)
  {
    AppMethodBeat.i(215995);
    p.h(paramZipInputStream, "zipInputStream");
    p.h(paramo, "unzipDir");
    int i = com.tencent.mm.plugin.appbrand.appstorage.n.a(paramZipInputStream, paramo.getAbsolutePath());
    Log.i("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, unzipRet: ".concat(String.valueOf(i)));
    if (i != 0)
    {
      AppMethodBeat.o(215995);
      return null;
    }
    paramZipInputStream = d.mJM;
    if (!d.C(paramo))
    {
      Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, record fail");
      AppMethodBeat.o(215995);
      return null;
    }
    AppMethodBeat.o(215995);
    return paramo;
  }
  
  public static o k(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(215993);
    p.h(paramf, "component");
    p.h(paramString, "zipPath");
    String str = paramString;
    if (!kotlin.n.n.J(paramString, "wxfile://", true)) {
      if (!kotlin.n.n.J(paramString, "http", true)) {
        break label80;
      }
    }
    label80:
    for (str = paramString;; str = paramf.getAppId() + '_' + paramString)
    {
      Log.d("MicroMsg.AppBrand.AppBrandUnzipLogic", "generateUnzipPath, rawUnzipPath: ".concat(String.valueOf(str)));
      paramf = kotlin.n.d.UTF_8;
      if (str != null) {
        break;
      }
      paramf = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(215993);
      throw paramf;
    }
    paramf = str.getBytes(paramf);
    p.g(paramf, "(this as java.lang.String).getBytes(charset)");
    paramf = com.tencent.mm.b.g.getMessageDigest(paramf);
    paramString = (CharSequence)paramf;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "getUnzipDir, unzipPathName is empty");
      AppMethodBeat.o(215993);
      return null;
    }
    paramf = new o((o)mJQ.getValue(), paramf);
    AppMethodBeat.o(215993);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.f
 * JD-Core Version:    0.7.0.1
 */