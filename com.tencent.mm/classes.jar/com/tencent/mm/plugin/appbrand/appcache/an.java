package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.s;

public class an
  extends c<am>
{
  public static final String[] iBh;
  private final ISQLiteDatabase kLX;
  
  static
  {
    AppMethodBeat.i(90563);
    iBh = new String[] { MAutoStorage.getCreateSQLs(am.iBg, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(90563);
  }
  
  public an(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, am.iBg, "PredownloadEncryptPkgInfo", am.INDEX_CREATE);
    this.kLX = paramISQLiteDatabase;
  }
  
  static boolean a(am paramam)
  {
    AppMethodBeat.i(90562);
    if (Util.isNullOrNil(paramam.field_pkgPath))
    {
      Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramam.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    if (Util.isNullOrNil(paramam.field_pkgMd5))
    {
      Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramam.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    String str = s.bhK(paramam.field_pkgPath);
    Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramam.toShortString(), str, paramam.field_pkgMd5 });
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
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90560);
      return null;
    }
    am localam = new am();
    localam.field_appId = paramString;
    localam.field_type = paramInt1;
    localam.field_version = paramInt2;
    if (get(localam, am.kJX))
    {
      AppMethodBeat.o(90560);
      return localam;
    }
    AppMethodBeat.o(90560);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.an
 * JD-Core Version:    0.7.0.1
 */