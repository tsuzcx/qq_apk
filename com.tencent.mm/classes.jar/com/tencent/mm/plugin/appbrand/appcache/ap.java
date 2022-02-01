package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.y;

public class ap
  extends c<ao>
{
  public static final String[] nVW;
  private final ISQLiteDatabase qFJ;
  
  static
  {
    AppMethodBeat.i(90563);
    nVW = new String[] { MAutoStorage.getCreateSQLs(ao.nVV, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(90563);
  }
  
  public ap(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ao.nVV, "PredownloadEncryptPkgInfo", ao.INDEX_CREATE);
    this.qFJ = paramISQLiteDatabase;
  }
  
  static boolean a(ao paramao)
  {
    AppMethodBeat.i(90562);
    if (Util.isNullOrNil(paramao.field_pkgPath))
    {
      Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramao.cfO() });
      AppMethodBeat.o(90562);
      return false;
    }
    if (Util.isNullOrNil(paramao.field_pkgMd5))
    {
      Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramao.cfO() });
      AppMethodBeat.o(90562);
      return false;
    }
    String str = y.bub(paramao.field_pkgPath);
    Log.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramao.cfO(), str, paramao.field_pkgMd5 });
    boolean bool = paramao.field_pkgMd5.equals(str);
    AppMethodBeat.o(90562);
    return bool;
  }
  
  public final ao D(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90560);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90560);
      return null;
    }
    ao localao = new ao();
    localao.field_appId = paramString;
    localao.field_type = paramInt1;
    localao.field_version = paramInt2;
    if (get(localao, ao.qDJ))
    {
      AppMethodBeat.o(90560);
      return localao;
    }
    AppMethodBeat.o(90560);
    return null;
  }
  
  public final ao E(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90561);
    paramString = D(paramString, paramInt1, paramInt2);
    if ((paramString != null) && (a(paramString)))
    {
      AppMethodBeat.o(90561);
      return paramString;
    }
    AppMethodBeat.o(90561);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap
 * JD-Core Version:    0.7.0.1
 */