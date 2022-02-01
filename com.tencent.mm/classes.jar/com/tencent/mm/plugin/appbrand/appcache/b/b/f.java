package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public class f
  extends a<Boolean, ecc>
{
  public static boolean a(ak paramak, a parama)
  {
    AppMethodBeat.i(44398);
    boolean bool = a(paramak, parama, null);
    AppMethodBeat.o(44398);
    return bool;
  }
  
  public static boolean a(ak paramak, a parama, PLong paramPLong)
  {
    AppMethodBeat.i(44399);
    am localam = ((an)j.T(an.class)).aI(paramak.field_appId, paramak.field_version);
    if (localam == null)
    {
      ac.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[] { paramak.toShortString() });
      AppMethodBeat.o(44399);
      return false;
    }
    if (paramPLong != null) {
      paramPLong.value = localam.field_reportId;
    }
    boolean bool = a(paramak, localam.field_decryptKey, localam.field_pkgMd5, localam.field_reportId, parama);
    AppMethodBeat.o(44399);
    return bool;
  }
  
  private static boolean a(ak paramak, String paramString1, String paramString2, int paramInt, a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(44397);
    Object localObject;
    switch (1.jqq[parama.ordinal()])
    {
    default: 
      i = 127;
      localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
      localObject = ay.aJ(paramak.field_appId, paramak.field_version);
      i = MMProtocalJni.aesDecryptFile(paramak.field_pkgPath, (String)localObject, paramString1.getBytes());
      ac.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[] { paramak.field_appId, Integer.valueOf(paramak.field_version), Integer.valueOf(i) });
      if (i != 0) {
        switch (1.jqq[parama.ordinal()])
        {
        }
      }
      break;
    case 1: 
      for (i = 129;; i = 133)
      {
        paramak = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
        i = 131;
        break;
      }
    }
    paramString1 = i.aKe((String)localObject);
    if (!paramString1.equals(paramString2))
    {
      ac.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[] { paramString1, paramString2 });
      switch (1.jqq[parama.ordinal()])
      {
      }
      for (i = 130;; i = 134)
      {
        paramak = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
      }
    }
    j.aVC().l(paramak.field_appId, paramak.field_version, paramString2);
    boolean bool2 = j.aVC().e(paramak.field_appId, 0, paramak.field_version, (String)localObject);
    switch (1.jqq[parama.ordinal()])
    {
    default: 
      if (bool2)
      {
        i = 143;
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        i.deleteFile(paramak.field_pkgPath);
        if (!((al)j.T(al.class)).delete(paramak, new String[0])) {
          break label549;
        }
        i = 139;
        label398:
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        if (parama != a.jqs)
        {
          paramString1 = (an)j.T(an.class);
          paramString2 = paramak.field_appId;
          i = paramak.field_version;
          if (!bs.isNullOrNil(paramString2)) {
            break label557;
          }
          label445:
          if (!bool1) {
            break label590;
          }
          i = 141;
          label455:
          paramak = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(paramInt, i);
        }
        switch (1.jqq[parama.ordinal()])
        {
        }
      }
      break;
    }
    for (int i = 128;; i = 132)
    {
      paramak = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
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
      paramak = new am();
      paramak.field_appId = paramString2;
      paramak.field_appVersion = i;
      bool1 = paramString1.delete(paramak, new String[0]);
      break label445;
      label590:
      i = 142;
      break label455;
    }
  }
  
  final String aXD()
  {
    return "CmdIssueDecryptKey";
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44396);
      jqr = new a("WXA_LAUNCH", 0);
      jqs = new a("ISSUE_DECRYPT", 1);
      jqt = new a("GET_CODE", 2);
      jqu = new a[] { jqr, jqs, jqt };
      AppMethodBeat.o(44396);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.f
 * JD-Core Version:    0.7.0.1
 */