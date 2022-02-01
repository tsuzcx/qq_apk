package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.u;

public class ao
  extends c<an>
{
  public static final String[] lqL;
  private final ISQLiteDatabase nFQ;
  
  static
  {
    AppMethodBeat.i(90563);
    lqL = new String[] { MAutoStorage.getCreateSQLs(an.lqK, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(90563);
  }
  
  public ao(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, an.lqK, "PredownloadEncryptPkgInfo", an.INDEX_CREATE);
    this.nFQ = paramISQLiteDatabase;
  }
  
  static boolean a(an paraman)
  {
    AppMethodBeat.i(90562);
    if (Util.isNullOrNil(paraman.field_pkgPath))
    {
      Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paraman.bGo() });
      AppMethodBeat.o(90562);
      return false;
    }
    if (Util.isNullOrNil(paraman.field_pkgMd5))
    {
      Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paraman.bGo() });
      AppMethodBeat.o(90562);
      return false;
    }
    String str = u.buc(paraman.field_pkgPath);
    Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paraman.bGo(), str, paraman.field_pkgMd5 });
    boolean bool = paraman.field_pkgMd5.equals(str);
    AppMethodBeat.o(90562);
    return bool;
  }
  
  public final an A(String paramString, int paramInt1, int paramInt2)
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
  
  public final an z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90560);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90560);
      return null;
    }
    an localan = new an();
    localan.field_appId = paramString;
    localan.field_type = paramInt1;
    localan.field_version = paramInt2;
    if (get(localan, an.nDP))
    {
      AppMethodBeat.o(90560);
      return localan;
    }
    AppMethodBeat.o(90560);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ao
 * JD-Core Version:    0.7.0.1
 */