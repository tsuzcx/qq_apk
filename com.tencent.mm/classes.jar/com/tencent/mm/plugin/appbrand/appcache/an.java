package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.x.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public class an
  extends c<am>
{
  public static final String[] hGX;
  private final e jKa;
  
  static
  {
    AppMethodBeat.i(90563);
    hGX = new String[] { j.getCreateSQLs(am.hGW, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(90563);
  }
  
  public an(e parame)
  {
    super(parame, am.hGW, "PredownloadEncryptPkgInfo", am.INDEX_CREATE);
    this.jKa = parame;
  }
  
  static boolean a(am paramam)
  {
    AppMethodBeat.i(90562);
    if (bu.isNullOrNil(paramam.field_pkgPath))
    {
      ae.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramam.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    if (bu.isNullOrNil(paramam.field_pkgMd5))
    {
      ae.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramam.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    String str = o.aRh(paramam.field_pkgPath);
    ae.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramam.toShortString(), str, paramam.field_pkgMd5 });
    boolean bool = paramam.field_pkgMd5.equals(str);
    AppMethodBeat.o(90562);
    return bool;
  }
  
  public final am A(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90561);
    paramString = z(paramString, paramInt1, paramInt2);
    if ((paramString != null) && (a(paramString)))
    {
      AppMethodBeat.o(90561);
      return paramString;
    }
    AppMethodBeat.o(90561);
    return null;
  }
  
  public final am z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90560);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90560);
      return null;
    }
    am localam = new am();
    localam.field_appId = paramString;
    localam.field_type = paramInt1;
    localam.field_version = paramInt2;
    if (get(localam, am.jHZ))
    {
      AppMethodBeat.o(90560);
      return localam;
    }
    AppMethodBeat.o(90560);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.an
 * JD-Core Version:    0.7.0.1
 */