package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public class al
  extends c<ak>
{
  public static final String[] hlS;
  private final e jnc;
  
  static
  {
    AppMethodBeat.i(90563);
    hlS = new String[] { j.getCreateSQLs(ak.hlR, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(90563);
  }
  
  public al(e parame)
  {
    super(parame, ak.hlR, "PredownloadEncryptPkgInfo", ak.INDEX_CREATE);
    this.jnc = parame;
  }
  
  static boolean a(ak paramak)
  {
    AppMethodBeat.i(90562);
    if (bs.isNullOrNil(paramak.field_pkgPath))
    {
      ac.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramak.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    if (bs.isNullOrNil(paramak.field_pkgMd5))
    {
      ac.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramak.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    String str = i.aKe(paramak.field_pkgPath);
    ac.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramak.toShortString(), str, paramak.field_pkgMd5 });
    boolean bool = paramak.field_pkgMd5.equals(str);
    AppMethodBeat.o(90562);
    return bool;
  }
  
  public final ak x(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90560);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90560);
      return null;
    }
    ak localak = new ak();
    localak.field_appId = paramString;
    localak.field_type = paramInt1;
    localak.field_version = paramInt2;
    if (get(localak, ak.jlk))
    {
      AppMethodBeat.o(90560);
      return localak;
    }
    AppMethodBeat.o(90560);
    return null;
  }
  
  public final ak y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90561);
    paramString = x(paramString, paramInt1, paramInt2);
    if ((paramString != null) && (a(paramString)))
    {
      AppMethodBeat.o(90561);
      return paramString;
    }
    AppMethodBeat.o(90561);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */