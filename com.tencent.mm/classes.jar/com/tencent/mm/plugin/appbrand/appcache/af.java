package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class af
  extends c<ae>
{
  public static final String[] fkl;
  private final e gVl;
  
  static
  {
    AppMethodBeat.i(59450);
    fkl = new String[] { j.getCreateSQLs(ae.fkk, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(59450);
  }
  
  public af(e parame)
  {
    super(parame, ae.fkk, "PredownloadEncryptPkgInfo", ae.INDEX_CREATE);
    this.gVl = parame;
  }
  
  static boolean a(ae paramae)
  {
    AppMethodBeat.i(59449);
    if (bo.isNullOrNil(paramae.field_pkgPath))
    {
      ab.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramae.toShortString() });
      AppMethodBeat.o(59449);
      return false;
    }
    if (bo.isNullOrNil(paramae.field_pkgMd5))
    {
      ab.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramae.toShortString() });
      AppMethodBeat.o(59449);
      return false;
    }
    String str = g.getMD5(paramae.field_pkgPath);
    ab.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramae.toShortString(), str, paramae.field_pkgMd5 });
    boolean bool = paramae.field_pkgMd5.equals(str);
    AppMethodBeat.o(59449);
    return bool;
  }
  
  public final ae B(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59447);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59447);
      return null;
    }
    ae localae = new ae();
    localae.field_appId = paramString;
    localae.field_type = paramInt1;
    localae.field_version = paramInt2;
    if (get(localae, ae.gUa))
    {
      AppMethodBeat.o(59447);
      return localae;
    }
    AppMethodBeat.o(59447);
    return null;
  }
  
  public final ae C(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59448);
    paramString = B(paramString, paramInt1, paramInt2);
    if ((paramString != null) && (a(paramString)))
    {
      AppMethodBeat.o(59448);
      return paramString;
    }
    AppMethodBeat.o(59448);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.af
 * JD-Core Version:    0.7.0.1
 */