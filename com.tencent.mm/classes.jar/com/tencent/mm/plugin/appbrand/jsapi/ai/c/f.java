package com.tencent.mm.plugin.appbrand.jsapi.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.zip.ZipInputStream;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandUnzipLogic;", "", "()V", "APP_BRAND_CACHE_DIRECTORY_NAME", "", "APP_BRAND_UNZIP_CACHE_DIRECTORY_NAME", "PATH_PREFIX_NETWORK", "PATH_PREFIX_TEMP", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "generateUnzipPathName", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "zipPath", "getUnzipDir", "isUnzipDirValid", "", "unzipDir", "unzip", "zipInputStream", "Ljava/util/zip/ZipInputStream;", "unzipIfNeed", "luggage-xweb-ext_release"})
public final class f
{
  private static final kotlin.f pKI;
  public static final f pKJ;
  
  static
  {
    AppMethodBeat.i(224781);
    pKJ = new f();
    pKI = kotlin.g.ar((a)a.pKK);
    AppMethodBeat.o(224781);
  }
  
  public static boolean E(com.tencent.mm.vfs.q paramq)
  {
    AppMethodBeat.i(224775);
    p.k(paramq, "unzipDir");
    d locald = d.pKE;
    boolean bool = d.C(paramq);
    AppMethodBeat.o(224775);
    return bool;
  }
  
  public static com.tencent.mm.vfs.q a(ZipInputStream paramZipInputStream, com.tencent.mm.vfs.q paramq)
  {
    AppMethodBeat.i(224779);
    p.k(paramZipInputStream, "zipInputStream");
    p.k(paramq, "unzipDir");
    int i = o.a(paramZipInputStream, paramq.bOF());
    Log.i("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, unzipRet: ".concat(String.valueOf(i)));
    if (i != 0)
    {
      AppMethodBeat.o(224779);
      return null;
    }
    paramZipInputStream = d.pKE;
    if (!d.B(paramq))
    {
      Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, record fail");
      AppMethodBeat.o(224779);
      return null;
    }
    AppMethodBeat.o(224779);
    return paramq;
  }
  
  public static com.tencent.mm.vfs.q k(e parame, String paramString)
  {
    AppMethodBeat.i(224772);
    p.k(parame, "component");
    p.k(paramString, "zipPath");
    String str = paramString;
    if (!n.M(paramString, "wxfile://", true)) {
      if (!n.M(paramString, "http", true)) {
        break label80;
      }
    }
    label80:
    for (str = paramString;; str = parame.getAppId() + '_' + paramString)
    {
      Log.d("MicroMsg.AppBrand.AppBrandUnzipLogic", "generateUnzipPath, rawUnzipPath: ".concat(String.valueOf(str)));
      parame = kotlin.n.d.UTF_8;
      if (str != null) {
        break;
      }
      parame = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(224772);
      throw parame;
    }
    parame = str.getBytes(parame);
    p.j(parame, "(this as java.lang.String).getBytes(charset)");
    parame = com.tencent.mm.b.g.getMessageDigest(parame);
    paramString = (CharSequence)parame;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "getUnzipDir, unzipPathName is empty");
      AppMethodBeat.o(224772);
      return null;
    }
    parame = new com.tencent.mm.vfs.q((com.tencent.mm.vfs.q)pKI.getValue(), parame);
    AppMethodBeat.o(224772);
    return parame;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<com.tencent.mm.vfs.q>
  {
    public static final a pKK;
    
    static
    {
      AppMethodBeat.i(227486);
      pKK = new a();
      AppMethodBeat.o(227486);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.f
 * JD-Core Version:    0.7.0.1
 */