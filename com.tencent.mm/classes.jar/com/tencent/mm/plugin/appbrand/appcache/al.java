package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class al
  extends c<ak>
{
  public static final String[] gLs;
  private final e iMV;
  
  static
  {
    AppMethodBeat.i(90563);
    gLs = new String[] { j.getCreateSQLs(ak.gLr, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(90563);
  }
  
  public al(e parame)
  {
    super(parame, ak.gLr, "PredownloadEncryptPkgInfo", ak.INDEX_CREATE);
    this.iMV = parame;
  }
  
  static boolean a(ak paramak)
  {
    AppMethodBeat.i(90562);
    if (bt.isNullOrNil(paramak.field_pkgPath))
    {
      ad.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramak.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    if (bt.isNullOrNil(paramak.field_pkgMd5))
    {
      ad.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramak.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    String str = i.aEN(paramak.field_pkgPath);
    ad.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramak.toShortString(), str, paramak.field_pkgMd5 });
    boolean bool = paramak.field_pkgMd5.equals(str);
    AppMethodBeat.o(90562);
    return bool;
  }
  
  public final ak y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90560);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90560);
      return null;
    }
    ak localak = new ak();
    localak.field_appId = paramString;
    localak.field_type = paramInt1;
    localak.field_version = paramInt2;
    if (get(localak, ak.iLd))
    {
      AppMethodBeat.o(90560);
      return localak;
    }
    AppMethodBeat.o(90560);
    return null;
  }
  
  public final ak z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90561);
    paramString = y(paramString, paramInt1, paramInt2);
    if ((paramString != null) && (a(paramString)))
    {
      AppMethodBeat.o(90561);
      return paramString;
    }
    AppMethodBeat.o(90561);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */