package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.c.cmj;
import com.tencent.mm.protocal.c.cmk;
import com.tencent.mm.protocal.c.cmy;
import com.tencent.mm.protocal.c.cnd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public class e
  extends a<Boolean, cnd>
{
  private static Boolean a(String paramString1, String paramString2, cnd paramcnd)
  {
    Object localObject1 = null;
    Object localObject2 = paramcnd.tZU;
    if (bk.bl((String)localObject2))
    {
      y.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", new Object[] { paramString1, paramString2 });
      return Boolean.FALSE;
    }
    label232:
    boolean bool2;
    boolean bool1;
    try
    {
      localObject2 = Base64.decode((String)localObject2, 0);
      localObject3 = new cmk();
      ((cmk)localObject3).aH((byte[])localObject2);
      localObject2 = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString1, new String[] { "versionInfo" });
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((WxaAttributes)localObject2).aep())
      {
        localObject4 = ((cmk)localObject3).sCG.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        cmj localcmj = (cmj)((Iterator)localObject4).next();
        if (!"WxaAppVersionInfo".equals(localcmj.sCH)) {
          break label445;
        }
        localObject1 = WxaAttributes.d.sI(localcmj.nFs);
        break label445;
      }
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramcnd.tZH.tZF, 87L);
        return Boolean.FALSE;
      }
      Object localObject4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramcnd.tZH.tZF, 88L);
      if ((localObject2 == null) || (localObject1 == null)) {
        break label448;
      }
      if (((WxaAttributes.d)localObject2).cau >= ((WxaAttributes.d)localObject1).cau) {
        break label454;
      }
    }
    catch (Exception paramcnd)
    {
      Object localObject3;
      label272:
      long l2;
      label311:
      y.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", paramcnd, "call[%s | %s], decode base64", new Object[] { paramString1, paramString2 });
      label410:
      return Boolean.FALSE;
    }
    if (bool2)
    {
      com.tencent.mm.plugin.appbrand.app.e.aaT().a(paramString1, ((cmk)localObject3).sCF, ((cmk)localObject3).sCG);
      if (com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString1, new String[0]) == null) {
        break label460;
      }
      bool1 = true;
      localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
      l2 = paramcnd.tZH.tZF;
      if (!bool1) {
        break label466;
      }
    }
    label445:
    label448:
    label454:
    label460:
    label466:
    for (long l1 = 85L;; l1 = 86L)
    {
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(l2, l1);
      int i;
      if (localObject2 == null)
      {
        i = -1;
        if (localObject1 != null) {
          break label410;
        }
      }
      for (int j = -1;; j = ((WxaAttributes.d)localObject1).cau)
      {
        y.i("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        return Boolean.valueOf(bool1);
        localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(paramcnd.tZH.tZF, 84L);
        bool1 = false;
        break;
        i = ((WxaAttributes.d)localObject2).cau;
        break label311;
      }
      break;
      bool2 = true;
      break label232;
      bool2 = false;
      break label232;
      bool1 = false;
      break label272;
    }
  }
  
  final String act()
  {
    return "CmdIssueContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.e
 * JD-Core Version:    0.7.0.1
 */