package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.t.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public class z
  extends c<y>
{
  public static final String[] dUb = { i.a(y.dUa, "PredownloadEncryptPkgInfo") };
  private final e fCV;
  
  public z(e parame)
  {
    super(parame, y.dUa, "PredownloadEncryptPkgInfo", y.cqY);
    this.fCV = parame;
  }
  
  static boolean a(y paramy)
  {
    if (bk.bl(paramy.field_pkgPath))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramy.toShortString() });
      return false;
    }
    if (bk.bl(paramy.field_pkgMd5))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramy.toShortString() });
      return false;
    }
    String str = g.bQ(paramy.field_pkgPath);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramy.toShortString(), str, paramy.field_pkgMd5 });
    return paramy.field_pkgMd5.equals(str);
  }
  
  public final y p(String paramString, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString)) {}
    y localy;
    do
    {
      return null;
      localy = new y();
      localy.field_appId = paramString;
      localy.field_type = paramInt1;
      localy.field_version = paramInt2;
    } while (!b(localy, y.fCT));
    return localy;
  }
  
  public final y q(String paramString, int paramInt1, int paramInt2)
  {
    paramString = p(paramString, paramInt1, paramInt2);
    if ((paramString != null) && (a(paramString))) {
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */