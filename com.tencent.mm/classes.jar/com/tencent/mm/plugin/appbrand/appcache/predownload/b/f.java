package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.fpt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class f
  extends a<Boolean, fpt>
{
  public static boolean a(an paraman, a parama)
  {
    AppMethodBeat.i(44398);
    aq localaq = (aq)m.W(aq.class);
    String str = paraman.field_appId;
    int i = paraman.field_version;
    ap localap = new ap();
    localap.field_appId = str;
    localap.field_appVersion = i;
    if (localaq.get(localap, new String[0])) {}
    while (localap == null)
    {
      Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[] { paraman.bGo() });
      AppMethodBeat.o(44398);
      return false;
      localap = null;
    }
    boolean bool = a(paraman, localap.field_decryptKey, localap.field_pkgMd5, localap.field_reportId, parama);
    AppMethodBeat.o(44398);
    return bool;
  }
  
  private static boolean a(an paraman, String paramString1, String paramString2, int paramInt, a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(44397);
    Object localObject;
    switch (1.nJQ[parama.ordinal()])
    {
    default: 
      i = 127;
      localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
      localObject = bd.bl(paraman.field_appId, paraman.field_version);
      i = MMProtocalJni.aesDecryptFile(paraman.field_pkgPath, (String)localObject, paramString1.getBytes());
      Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[] { paraman.field_appId, Integer.valueOf(paraman.field_version), Integer.valueOf(i) });
      if (i != 0) {
        switch (1.nJQ[parama.ordinal()])
        {
        }
      }
      break;
    case 1: 
      for (i = 129;; i = 133)
      {
        paraman = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
        i = 131;
        break;
      }
    }
    paramString1 = u.buc((String)localObject);
    if (!paramString1.equals(paramString2))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[] { paramString1, paramString2 });
      switch (1.nJQ[parama.ordinal()])
      {
      }
      for (i = 130;; i = 134)
      {
        paraman = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
      }
    }
    m.bFP().s(paraman.field_appId, paraman.field_version, paramString2);
    boolean bool2 = m.bFP().f(paraman.field_appId, 0, paraman.field_version, (String)localObject);
    switch (1.nJQ[parama.ordinal()])
    {
    default: 
      if (bool2)
      {
        i = 143;
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        u.deleteFile(paraman.field_pkgPath);
        if (!((ao)m.W(ao.class)).delete(paraman, new String[0])) {
          break label549;
        }
        i = 139;
        label398:
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        if (parama != a.nJS)
        {
          paramString1 = (aq)m.W(aq.class);
          paramString2 = paraman.field_appId;
          i = paraman.field_version;
          if (!Util.isNullOrNil(paramString2)) {
            break label557;
          }
          label445:
          if (!bool1) {
            break label590;
          }
          i = 141;
          label455:
          paraman = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        }
        switch (1.nJQ[parama.ordinal()])
        {
        }
      }
      break;
    }
    for (int i = 128;; i = 132)
    {
      paraman = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
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
      paraman = new ap();
      paraman.field_appId = paramString2;
      paraman.field_appVersion = i;
      bool1 = paramString1.delete(paraman, new String[0]);
      break label445;
      label590:
      i = 142;
      break label455;
    }
  }
  
  final String bHX()
  {
    return "CmdIssueDecryptKey";
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44396);
      nJR = new a("WXA_LAUNCH", 0);
      nJS = new a("ISSUE_DECRYPT", 1);
      nJT = new a("GET_CODE", 2);
      nJU = new a[] { nJR, nJS, nJT };
      AppMethodBeat.o(44396);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.f
 * JD-Core Version:    0.7.0.1
 */