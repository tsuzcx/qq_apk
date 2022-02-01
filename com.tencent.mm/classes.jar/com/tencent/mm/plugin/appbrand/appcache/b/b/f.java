package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class f
  extends a<Boolean, eii>
{
  public static boolean a(al paramal, a parama)
  {
    AppMethodBeat.i(44398);
    boolean bool = a(paramal, parama, null);
    AppMethodBeat.o(44398);
    return bool;
  }
  
  public static boolean a(al paramal, a parama, PLong paramPLong)
  {
    AppMethodBeat.i(44399);
    an localan = ((ao)j.T(ao.class)).aK(paramal.field_appId, paramal.field_version);
    if (localan == null)
    {
      ad.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[] { paramal.toShortString() });
      AppMethodBeat.o(44399);
      return false;
    }
    if (paramPLong != null) {
      paramPLong.value = localan.field_reportId;
    }
    boolean bool = a(paramal, localan.field_decryptKey, localan.field_pkgMd5, localan.field_reportId, parama);
    AppMethodBeat.o(44399);
    return bool;
  }
  
  private static boolean a(al paramal, String paramString1, String paramString2, int paramInt, a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(44397);
    Object localObject;
    switch (1.jKk[parama.ordinal()])
    {
    default: 
      i = 127;
      localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
      localObject = az.aL(paramal.field_appId, paramal.field_version);
      i = MMProtocalJni.aesDecryptFile(paramal.field_pkgPath, (String)localObject, paramString1.getBytes());
      ad.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[] { paramal.field_appId, Integer.valueOf(paramal.field_version), Integer.valueOf(i) });
      if (i != 0) {
        switch (1.jKk[parama.ordinal()])
        {
        }
      }
      break;
    case 1: 
      for (i = 129;; i = 133)
      {
        paramal = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
        i = 131;
        break;
      }
    }
    paramString1 = i.aPK((String)localObject);
    if (!paramString1.equals(paramString2))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[] { paramString1, paramString2 });
      switch (1.jKk[parama.ordinal()])
      {
      }
      for (i = 130;; i = 134)
      {
        paramal = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
      }
    }
    j.aYX().m(paramal.field_appId, paramal.field_version, paramString2);
    boolean bool2 = j.aYX().e(paramal.field_appId, 0, paramal.field_version, (String)localObject);
    switch (1.jKk[parama.ordinal()])
    {
    default: 
      if (bool2)
      {
        i = 143;
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        i.deleteFile(paramal.field_pkgPath);
        if (!((am)j.T(am.class)).delete(paramal, new String[0])) {
          break label549;
        }
        i = 139;
        label398:
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        if (parama != a.jKm)
        {
          paramString1 = (ao)j.T(ao.class);
          paramString2 = paramal.field_appId;
          i = paramal.field_version;
          if (!bt.isNullOrNil(paramString2)) {
            break label557;
          }
          label445:
          if (!bool1) {
            break label590;
          }
          i = 141;
          label455:
          paramal = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        }
        switch (1.jKk[parama.ordinal()])
        {
        }
      }
      break;
    }
    for (int i = 128;; i = 132)
    {
      paramal = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
      AppMethodBeat.o(44397);
      return true;
      if (bool2)
      {
        i = 147;
        break;
      }
      i = 148;
      break;
      i = 144;
      break;
      label549:
      i = 140;
      break label398;
      label557:
      paramal = new an();
      paramal.field_appId = paramString2;
      paramal.field_appVersion = i;
      bool1 = paramString1.delete(paramal, new String[0]);
      break label445;
      label590:
      i = 142;
      break label455;
    }
  }
  
  final String bbb()
  {
    return "CmdIssueDecryptKey";
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44396);
      jKl = new a("WXA_LAUNCH", 0);
      jKm = new a("ISSUE_DECRYPT", 1);
      jKn = new a("GET_CODE", 2);
      jKo = new a[] { jKl, jKm, jKn };
      AppMethodBeat.o(44396);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.f
 * JD-Core Version:    0.7.0.1
 */