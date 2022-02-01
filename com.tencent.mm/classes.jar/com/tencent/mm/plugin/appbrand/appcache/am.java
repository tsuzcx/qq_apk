package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class am
  extends c<al>
{
  public static final String[] hEf;
  private final e jHa;
  
  static
  {
    AppMethodBeat.i(90563);
    hEf = new String[] { j.getCreateSQLs(al.hEe, "PredownloadEncryptPkgInfo") };
    AppMethodBeat.o(90563);
  }
  
  public am(e parame)
  {
    super(parame, al.hEe, "PredownloadEncryptPkgInfo", al.INDEX_CREATE);
    this.jHa = parame;
  }
  
  static boolean a(al paramal)
  {
    AppMethodBeat.i(90562);
    if (bt.isNullOrNil(paramal.field_pkgPath))
    {
      ad.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[] { paramal.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    if (bt.isNullOrNil(paramal.field_pkgMd5))
    {
      ad.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[] { paramal.toShortString() });
      AppMethodBeat.o(90562);
      return false;
    }
    String str = i.aPK(paramal.field_pkgPath);
    ad.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[] { paramal.toShortString(), str, paramal.field_pkgMd5 });
    boolean bool = paramal.field_pkgMd5.equals(str);
    AppMethodBeat.o(90562);
    return bool;
  }
  
  public final al A(String paramString, int paramInt1, int paramInt2)
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
  
  public final al z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90560);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90560);
      return null;
    }
    al localal = new al();
    localal.field_appId = paramString;
    localal.field_type = paramInt1;
    localal.field_version = paramInt2;
    if (get(localal, al.jFa))
    {
      AppMethodBeat.o(90560);
      return localal;
    }
    AppMethodBeat.o(90560);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.am
 * JD-Core Version:    0.7.0.1
 */