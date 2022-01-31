package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.cne;
import com.tencent.mm.sdk.platformtools.bk;

public class f
  extends a<Boolean, cne>
{
  public static boolean a(com.tencent.mm.plugin.appbrand.appcache.y paramy, a parama)
  {
    return a(paramy, parama, null);
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.appcache.y paramy, a parama, PLong paramPLong)
  {
    ab localab = (ab)com.tencent.mm.plugin.appbrand.app.e.G(ab.class);
    String str = paramy.field_appId;
    int i = paramy.field_version;
    aa localaa = new aa();
    localaa.field_appId = str;
    localaa.field_appVersion = i;
    if (localab.b(localaa, new String[0])) {}
    while (localaa == null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[] { paramy.toShortString() });
      return false;
      localaa = null;
    }
    if (paramPLong != null) {
      paramPLong.value = localaa.field_reportId;
    }
    return a(paramy, localaa.field_decryptKey, localaa.field_pkgMd5, localaa.field_reportId, parama);
  }
  
  private static boolean a(com.tencent.mm.plugin.appbrand.appcache.y paramy, String paramString1, String paramString2, int paramInt, a parama)
  {
    boolean bool1 = false;
    Object localObject;
    switch (f.1.fFo[parama.ordinal()])
    {
    default: 
      i = 127;
      localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramInt, i);
      localObject = ak.ah(paramy.field_appId, paramy.field_version);
      i = MMProtocalJni.aesDecryptFile(paramy.field_pkgPath, (String)localObject, paramString1.getBytes());
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[] { paramy.field_appId, Integer.valueOf(paramy.field_version), Integer.valueOf(i) });
      if (i != 0) {
        switch (f.1.fFo[parama.ordinal()])
        {
        }
      }
      break;
    case 1: 
      for (i = 129;; i = 133)
      {
        paramy = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramInt, i);
        return false;
        i = 131;
        break;
      }
    }
    paramString1 = g.bQ((String)localObject);
    if (!paramString1.equals(paramString2))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[] { paramString1, paramString2 });
      switch (f.1.fFo[parama.ordinal()])
      {
      }
      for (i = 130;; i = 134)
      {
        paramy = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramInt, i);
        return false;
      }
    }
    com.tencent.mm.plugin.appbrand.app.e.abb().g(paramy.field_appId, paramy.field_version, paramString2);
    boolean bool2 = com.tencent.mm.plugin.appbrand.app.e.abb().d(paramy.field_appId, 0, paramy.field_version, (String)localObject);
    switch (f.1.fFo[parama.ordinal()])
    {
    default: 
      if (bool2)
      {
        i = 143;
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramInt, i);
        com.tencent.mm.a.e.deleteFile(paramy.field_pkgPath);
        if (!((z)com.tencent.mm.plugin.appbrand.app.e.G(z.class)).a(paramy, new String[0])) {
          break label528;
        }
        i = 139;
        label382:
        paramString1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramInt, i);
        if (parama != a.fFq)
        {
          paramString1 = (ab)com.tencent.mm.plugin.appbrand.app.e.G(ab.class);
          paramString2 = paramy.field_appId;
          i = paramy.field_version;
          if (!bk.bl(paramString2)) {
            break label536;
          }
          label429:
          if (!bool1) {
            break label569;
          }
          i = 141;
          label439:
          paramy = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramInt, i);
        }
        switch (f.1.fFo[parama.ordinal()])
        {
        }
      }
      break;
    }
    for (int i = 128;; i = 132)
    {
      paramy = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramInt, i);
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
      label528:
      i = 140;
      break label382;
      label536:
      paramy = new aa();
      paramy.field_appId = paramString2;
      paramy.field_appVersion = i;
      bool1 = paramString1.a(paramy, new String[0]);
      break label429;
      label569:
      i = 142;
      break label439;
    }
  }
  
  final String act()
  {
    return "CmdIssueDecryptKey";
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.f
 * JD-Core Version:    0.7.0.1
 */