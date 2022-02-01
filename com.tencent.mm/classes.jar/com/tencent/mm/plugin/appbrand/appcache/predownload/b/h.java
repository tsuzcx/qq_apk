package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.gmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public class h
  extends a<Boolean, gmv>
{
  public static boolean a(ao paramao, a parama)
  {
    AppMethodBeat.i(44398);
    ar localar = (ar)n.ag(ar.class);
    String str = paramao.field_appId;
    int i = paramao.field_version;
    aq localaq = new aq();
    localaq.field_appId = str;
    localaq.field_appVersion = i;
    if (localar.get(localaq, new String[0])) {}
    while (localaq == null)
    {
      Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[] { paramao.cfO() });
      AppMethodBeat.o(44398);
      return false;
      localaq = null;
    }
    boolean bool = a(paramao, localaq.field_decryptKey, localaq.field_pkgMd5, localaq.field_reportId, parama);
    AppMethodBeat.o(44398);
    return bool;
  }
  
  private static boolean a(ao paramao, String paramString1, String paramString2, int paramInt, a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(44397);
    Object localObject;
    switch (1.qJz[parama.ordinal()])
    {
    default: 
      i = 127;
      localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, i);
      localObject = be.bC(paramao.field_appId, paramao.field_version);
      i = MMProtocalJni.aesDecryptFile(paramao.field_pkgPath, (String)localObject, paramString1.getBytes());
      Log.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[] { paramao.field_appId, Integer.valueOf(paramao.field_version), Integer.valueOf(i) });
      if (i != 0) {
        switch (1.qJz[parama.ordinal()])
        {
        }
      }
      break;
    case 1: 
      for (i = 129;; i = 133)
      {
        paramao = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
        i = 131;
        break;
      }
    }
    paramString1 = y.bub((String)localObject);
    if (!paramString1.equals(paramString2))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[] { paramString1, paramString2 });
      switch (1.qJz[parama.ordinal()])
      {
      }
      for (i = 130;; i = 134)
      {
        paramao = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, i);
        AppMethodBeat.o(44397);
        return false;
      }
    }
    n.cfm().u(paramao.field_appId, paramao.field_version, paramString2);
    boolean bool2 = n.cfm().f(paramao.field_appId, 0, paramao.field_version, (String)localObject);
    switch (1.qJz[parama.ordinal()])
    {
    default: 
      if (bool2)
      {
        i = 143;
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, i);
        y.deleteFile(paramao.field_pkgPath);
        if (!((ap)n.ag(ap.class)).delete(paramao, new String[0])) {
          break label549;
        }
        i = 139;
        label398:
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, i);
        if (parama != a.qJB)
        {
          paramString1 = (ar)n.ag(ar.class);
          paramString2 = paramao.field_appId;
          i = paramao.field_version;
          if (!Util.isNullOrNil(paramString2)) {
            break label557;
          }
          label445:
          if (!bool1) {
            break label590;
          }
          i = 141;
          label455:
          paramao = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, i);
        }
        switch (1.qJz[parama.ordinal()])
        {
        }
      }
      break;
    }
    for (int i = 128;; i = 132)
    {
      paramao = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, i);
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
      paramao = new aq();
      paramao.field_appId = paramString2;
      paramao.field_appVersion = i;
      bool1 = paramString1.delete(paramao, new String[0]);
      break label445;
      label590:
      i = 142;
      break label455;
    }
  }
  
  final String cht()
  {
    return "CmdIssueDecryptKey";
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44396);
      qJA = new a("WXA_LAUNCH", 0);
      qJB = new a("ISSUE_DECRYPT", 1);
      qJC = new a("GET_CODE", 2);
      qJD = new a[] { qJA, qJB, qJC };
      AppMethodBeat.o(44396);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.h
 * JD-Core Version:    0.7.0.1
 */