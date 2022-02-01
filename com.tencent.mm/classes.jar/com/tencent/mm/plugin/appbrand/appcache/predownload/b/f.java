package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.fes;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class f
  extends a<Boolean, fes>
{
  public static boolean a(am paramam, a parama)
  {
    AppMethodBeat.i(44398);
    ap localap = (ap)n.W(ap.class);
    String str = paramam.field_appId;
    int i = paramam.field_version;
    ao localao = new ao();
    localao.field_appId = str;
    localao.field_appVersion = i;
    if (localap.get(localao, new String[0])) {}
    while (localao == null)
    {
      Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[] { paramam.toShortString() });
      AppMethodBeat.o(44398);
      return false;
      localao = null;
    }
    boolean bool = a(paramam, localao.field_decryptKey, localao.field_pkgMd5, localao.field_reportId, parama);
    AppMethodBeat.o(44398);
    return bool;
  }
  
  private static boolean a(am paramam, String paramString1, String paramString2, int paramInt, a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(44397);
    Object localObject;
    switch (1.kPK[parama.ordinal()])
    {
    default: 
      i = 127;
      localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
      localObject = ba.aT(paramam.field_appId, paramam.field_version);
      i = MMProtocalJni.aesDecryptFile(paramam.field_pkgPath, (String)localObject, paramString1.getBytes());
      Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[] { paramam.field_appId, Integer.valueOf(paramam.field_version), Integer.valueOf(i) });
      if (i != 0) {
        switch (1.kPK[parama.ordinal()])
        {
        }
      }
      break;
    case 1: 
      for (i = 129;; i = 133)
      {
        paramam = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
        i = 131;
        break;
      }
    }
    paramString1 = s.bhK((String)localObject);
    if (!paramString1.equals(paramString2))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[] { paramString1, paramString2 });
      switch (1.kPK[parama.ordinal()])
      {
      }
      for (i = 130;; i = 134)
      {
        paramam = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
      }
    }
    n.buL().r(paramam.field_appId, paramam.field_version, paramString2);
    boolean bool2 = n.buL().e(paramam.field_appId, 0, paramam.field_version, (String)localObject);
    switch (1.kPK[parama.ordinal()])
    {
    default: 
      if (bool2)
      {
        i = 143;
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        s.deleteFile(paramam.field_pkgPath);
        if (!((an)n.W(an.class)).delete(paramam, new String[0])) {
          break label549;
        }
        i = 139;
        label398:
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        if (parama != a.kPM)
        {
          paramString1 = (ap)n.W(ap.class);
          paramString2 = paramam.field_appId;
          i = paramam.field_version;
          if (!Util.isNullOrNil(paramString2)) {
            break label557;
          }
          label445:
          if (!bool1) {
            break label590;
          }
          i = 141;
          label455:
          paramam = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(paramInt, i);
        }
        switch (1.kPK[parama.ordinal()])
        {
        }
      }
      break;
    }
    for (int i = 128;; i = 132)
    {
      paramam = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
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
      paramam = new ao();
      paramam.field_appId = paramString2;
      paramam.field_appVersion = i;
      bool1 = paramString1.delete(paramam, new String[0]);
      break label445;
      label590:
      i = 142;
      break label455;
    }
  }
  
  final String bwQ()
  {
    return "CmdIssueDecryptKey";
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44396);
      kPL = new a("WXA_LAUNCH", 0);
      kPM = new a("ISSUE_DECRYPT", 1);
      kPN = new a("GET_CODE", 2);
      kPO = new a[] { kPL, kPM, kPN };
      AppMethodBeat.o(44396);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.f
 * JD-Core Version:    0.7.0.1
 */