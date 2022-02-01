package com.tencent.mm.plugin.appbrand.jsapi.al.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandUnzipLogic;", "", "()V", "APP_BRAND_CACHE_DIRECTORY_NAME", "", "APP_BRAND_UNZIP_CACHE_DIRECTORY_NAME", "PATH_PREFIX_NETWORK", "PATH_PREFIX_TEMP", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "generateUnzipPathName", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "zipPath", "getUnzipDir", "isUnzipDirValid", "", "unzipDir", "unzip", "zipInputStream", "Ljava/util/zip/ZipInputStream;", "unzipIfNeed", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f sPB;
  private static final j sPC;
  
  static
  {
    AppMethodBeat.i(327123);
    sPB = new f();
    sPC = k.cm((a)a.sPD);
    AppMethodBeat.o(327123);
  }
  
  public static boolean E(com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(327115);
    s.u(paramu, "unzipDir");
    d locald = d.sPx;
    boolean bool = d.C(paramu);
    AppMethodBeat.o(327115);
    return bool;
  }
  
  public static com.tencent.mm.vfs.u a(ZipInputStream paramZipInputStream, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(327118);
    s.u(paramZipInputStream, "zipInputStream");
    s.u(paramu, "unzipDir");
    int i = t.a(paramZipInputStream, ah.v(paramu.jKT()));
    Log.i("MicroMsg.AppBrand.AppBrandUnzipLogic", s.X("unzip, unzipRet: ", Integer.valueOf(i)));
    if (i != 0)
    {
      AppMethodBeat.o(327118);
      return null;
    }
    paramZipInputStream = d.sPx;
    if (!d.B(paramu))
    {
      Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, record fail");
      AppMethodBeat.o(327118);
      return null;
    }
    AppMethodBeat.o(327118);
    return paramu;
  }
  
  public static com.tencent.mm.vfs.u j(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(327108);
    s.u(paramf, "component");
    s.u(paramString, "zipPath");
    String str = paramString;
    if (!n.U(paramString, "wxfile://", true)) {
      if (!n.U(paramString, "http", true)) {
        break label77;
      }
    }
    label77:
    for (str = paramString;; str = paramf.getAppId() + '_' + paramString)
    {
      Log.d("MicroMsg.AppBrand.AppBrandUnzipLogic", s.X("generateUnzipPath, rawUnzipPath: ", str));
      paramf = kotlin.n.d.UTF_8;
      if (str != null) {
        break;
      }
      paramf = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(327108);
      throw paramf;
    }
    paramf = str.getBytes(paramf);
    s.s(paramf, "(this as java.lang.String).getBytes(charset)");
    paramf = g.getMessageDigest(paramf);
    paramString = (CharSequence)paramf;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "getUnzipDir, unzipPathName is empty");
      AppMethodBeat.o(327108);
      return null;
    }
    paramf = new com.tencent.mm.vfs.u((com.tencent.mm.vfs.u)sPC.getValue(), paramf);
    AppMethodBeat.o(327108);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<com.tencent.mm.vfs.u>
  {
    public static final a sPD;
    
    static
    {
      AppMethodBeat.i(327129);
      sPD = new a();
      AppMethodBeat.o(327129);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.f
 * JD-Core Version:    0.7.0.1
 */