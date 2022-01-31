package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class f
  extends a<Boolean, dbm>
{
  public static boolean a(ae paramae, f.a parama)
  {
    AppMethodBeat.i(129471);
    boolean bool = a(paramae, parama, null);
    AppMethodBeat.o(129471);
    return bool;
  }
  
  public static boolean a(ae paramae, f.a parama, PLong paramPLong)
  {
    AppMethodBeat.i(129472);
    ag localag = ((ah)com.tencent.mm.plugin.appbrand.app.g.w(ah.class)).aq(paramae.field_appId, paramae.field_version);
    if (localag == null)
    {
      ab.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[] { paramae.toShortString() });
      AppMethodBeat.o(129472);
      return false;
    }
    if (paramPLong != null) {
      paramPLong.value = localag.field_reportId;
    }
    boolean bool = a(paramae, localag.field_decryptKey, localag.field_pkgMd5, localag.field_reportId, parama);
    AppMethodBeat.o(129472);
    return bool;
  }
  
  private static boolean a(ae paramae, String paramString1, String paramString2, int paramInt, f.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(129470);
    Object localObject;
    switch (f.1.gXJ[parama.ordinal()])
    {
    default: 
      i = 127;
      localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramInt, i);
      localObject = aq.ar(paramae.field_appId, paramae.field_version);
      i = MMProtocalJni.aesDecryptFile(paramae.field_pkgPath, (String)localObject, paramString1.getBytes());
      ab.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[] { paramae.field_appId, Integer.valueOf(paramae.field_version), Integer.valueOf(i) });
      if (i != 0) {
        switch (f.1.gXJ[parama.ordinal()])
        {
        }
      }
      break;
    case 1: 
      for (i = 129;; i = 133)
      {
        paramae = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramInt, i);
        AppMethodBeat.o(129470);
        return false;
        i = 131;
        break;
      }
    }
    paramString1 = com.tencent.mm.a.g.getMD5((String)localObject);
    if (!paramString1.equals(paramString2))
    {
      ab.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[] { paramString1, paramString2 });
      switch (f.1.gXJ[parama.ordinal()])
      {
      }
      for (i = 130;; i = 134)
      {
        paramae = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramInt, i);
        AppMethodBeat.o(129470);
        return false;
      }
    }
    com.tencent.mm.plugin.appbrand.app.g.auM().h(paramae.field_appId, paramae.field_version, paramString2);
    boolean bool2 = com.tencent.mm.plugin.appbrand.app.g.auM().d(paramae.field_appId, 0, paramae.field_version, (String)localObject);
    switch (f.1.gXJ[parama.ordinal()])
    {
    default: 
      if (bool2)
      {
        i = 143;
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramInt, i);
        e.deleteFile(paramae.field_pkgPath);
        if (!((af)com.tencent.mm.plugin.appbrand.app.g.w(af.class)).delete(paramae, new String[0])) {
          break label549;
        }
        i = 139;
        label398:
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramInt, i);
        if (parama != f.a.gXL)
        {
          paramString1 = (ah)com.tencent.mm.plugin.appbrand.app.g.w(ah.class);
          paramString2 = paramae.field_appId;
          i = paramae.field_version;
          if (!bo.isNullOrNil(paramString2)) {
            break label557;
          }
          label445:
          if (!bool1) {
            break label590;
          }
          i = 141;
          label455:
          paramae = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramInt, i);
        }
        switch (f.1.gXJ[parama.ordinal()])
        {
        }
      }
      break;
    }
    for (int i = 128;; i = 132)
    {
      paramae = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(paramInt, i);
      AppMethodBeat.o(129470);
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
      paramae = new ag();
      paramae.field_appId = paramString2;
      paramae.field_appVersion = i;
      bool1 = paramString1.delete(paramae, new String[0]);
      break label445;
      label590:
      i = 142;
      break label455;
    }
  }
  
  final String awm()
  {
    return "CmdIssueDecryptKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.f
 * JD-Core Version:    0.7.0.1
 */