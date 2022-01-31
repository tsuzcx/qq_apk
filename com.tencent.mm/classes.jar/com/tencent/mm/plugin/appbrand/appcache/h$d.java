package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.mm.h.b.a.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class h$d
  implements h
{
  private static void aby()
  {
    long l1 = bk.UX();
    long l2 = AppBrandGlobalSystemConfig.aec().fOY.fPj;
    Object localObject1 = ((z)com.tencent.mm.plugin.appbrand.app.e.G(z.class)).aAn();
    if ((localObject1 == null) || (((Cursor)localObject1).isClosed())) {}
    for (;;)
    {
      return;
      Object localObject2 = new LinkedList();
      if (((Cursor)localObject1).moveToFirst()) {
        do
        {
          y localy = new y();
          localy.d((Cursor)localObject1);
          ((List)localObject2).add(localy);
        } while (((Cursor)localObject1).moveToNext());
      }
      ((Cursor)localObject1).close();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (y)((Iterator)localObject1).next();
        if ((com.tencent.mm.a.e.bK(((y)localObject2).field_pkgPath)) && (TimeUnit.MILLISECONDS.toSeconds(new File(((y)localObject2).field_pkgPath).lastModified()) < l1 - l2))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", new Object[] { ((y)localObject2).field_appId, Integer.valueOf(((y)localObject2).field_type), Integer.valueOf(((y)localObject2).field_version) });
          ((z)com.tencent.mm.plugin.appbrand.app.e.G(z.class)).a((c)localObject2, new String[0]);
          com.tencent.mm.a.e.bL(((y)localObject2).field_pkgPath);
        }
      }
    }
  }
  
  private void abz()
  {
    Object localObject1 = new File(aj.abZ());
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {}
    for (;;)
    {
      return;
      localObject1 = ((File)localObject1).listFiles(new h.d.1(this));
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!com.tencent.mm.plugin.appbrand.app.e.abb().rj(localObject2.getAbsolutePath())) {
          h.a.qS(localObject2.getAbsolutePath());
        }
        i += 1;
      }
    }
  }
  
  private static void ao(List<String> paramList)
  {
    if (bk.dk(paramList)) {}
    for (;;)
    {
      return;
      long l1 = bk.UX();
      long l2 = AppBrandGlobalSystemConfig.aec().fOY.fPj;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.e.aU(str, 0);
        if ((localWxaPkgWrappingInfo != null) && (TimeUnit.MILLISECONDS.toSeconds(new File(localWxaPkgWrappingInfo.fCl).lastModified()) < l1 - l2))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseWithoutContact, delete record(%s) < %d", new Object[] { str, Integer.valueOf(localWxaPkgWrappingInfo.fEN) });
          com.tencent.mm.plugin.appbrand.app.e.abb().al(str, localWxaPkgWrappingInfo.fEN);
        }
      }
    }
  }
  
  public final void run()
  {
    if (com.tencent.mm.plugin.appbrand.app.e.abb() == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
      return;
    }
    long l1;
    Object localObject3;
    for (;;)
    {
      try
      {
        Object localObject1 = com.tencent.mm.plugin.appbrand.app.e.abb().acp();
        if (bk.dk((List)localObject1)) {
          break;
        }
        l1 = bk.UX();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (an)((Iterator)localObject1).next();
        if (g.wr(((an)localObject3).field_appId))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", new Object[] { ((an)localObject3).field_appId });
          continue;
        }
        if (((an)localObject3).field_endTime <= 0L) {
          break label223;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", new Object[] { localException });
        return;
      }
      if (((an)localObject3).field_endTime <= l1)
      {
        if (((an)localObject3).field_debugType == 999)
        {
          h.a.qS(((an)localObject3).field_pkgPath);
          com.tencent.mm.plugin.appbrand.app.e.abb().a((an)localObject3);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", new Object[] { ((an)localObject3).field_appId, Integer.valueOf(((an)localObject3).field_debugType), Long.valueOf(((an)localObject3).field_startTime), Long.valueOf(((an)localObject3).field_endTime) });
        }
      }
      else {
        label223:
        if (((an)localObject3).field_debugType == 999) {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", new Object[] { Long.valueOf(((an)localObject3).field_startTime), Long.valueOf(((an)localObject3).field_endTime) });
        }
      }
    }
    Object localObject2 = com.tencent.mm.plugin.appbrand.app.e.aaO();
    int j = ac.abM();
    int i = j;
    label386:
    label420:
    long l3;
    long l2;
    label440:
    double d1;
    double d2;
    if (j <= 0)
    {
      localObject3 = com.tencent.mm.plugin.appbrand.launching.e.aU("@LibraryAppId", 0);
      if (localObject3 == null) {
        i = 0;
      }
    }
    else
    {
      if (i > 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.appbrand.app.e.abb().al("@LibraryAppId", i);
      }
      localObject2 = ((com.tencent.mm.cf.h)localObject2).a("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[] { "0", "@LibraryAppId" }, 0);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        break label642;
      }
      aby();
      abz();
      localObject2 = new StatFs(aj.abZ());
      if (Build.VERSION.SDK_INT < 18) {
        break label961;
      }
      l1 = ((StatFs)localObject2).getBlockCountLong();
      l3 = h.b.abw();
      if (Build.VERSION.SDK_INT < 18) {
        break label972;
      }
      l2 = ((StatFs)localObject2).getBlockSizeLong();
      d1 = l3 / l2 / l1;
      d2 = AppBrandGlobalSystemConfig.aec().fOY.fPl / 100.0F;
      if ((d1 <= d2) || (l3 <= AppBrandGlobalSystemConfig.aec().fOY.fPk * 1048576L)) {
        break label1001;
      }
    }
    label642:
    label696:
    label953:
    label961:
    label972:
    label994:
    label1001:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l3), Long.valueOf(AppBrandGlobalSystemConfig.aec().fOY.fPk), Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
      double d3 = l1;
      if (Build.VERSION.SDK_INT >= 18) {}
      for (l1 = ((StatFs)localObject2).getBlockSizeLong();; l1 = ((StatFs)localObject2).getBlockSize())
      {
        l1 = (l1 * (d3 * (d1 - d2)));
        if (l1 >= 0L) {
          break label994;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
        return;
        i = ((WxaPkgWrappingInfo)localObject3).fEN;
        break;
        localObject3 = new LinkedList();
        String str;
        if (((Cursor)localObject2).moveToFirst())
        {
          str = ((Cursor)localObject2).getString(0);
          if (g.wr(str))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", new Object[] { str });
            if (((Cursor)localObject2).moveToNext()) {
              break label813;
            }
          }
        }
        else
        {
          ((Cursor)localObject2).close();
          localObject2 = new LinkedList();
          localObject3 = ((List)localObject3).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label953;
          }
          str = (String)((Iterator)localObject3).next();
          Object localObject4 = com.tencent.mm.plugin.appbrand.app.e.aaT().e(str, new String[] { "versionInfo" });
          if ((localObject4 == null) || (bk.bl(((WxaAttributes)localObject4).field_versionInfo)))
          {
            ((List)localObject2).add(str);
            continue;
            ((List)localObject3).add(str);
            break label696;
            break;
          }
          if (((WxaAttributes)localObject4).aep() == null) {}
          for (i = 0;; i = ((WxaAttributes)localObject4).aep().cau)
          {
            if (i <= 0) {
              break label951;
            }
            j = com.tencent.mm.plugin.appbrand.app.e.abb().al(str, ((WxaAttributes)localObject4).aep().cau);
            if (j <= 0) {
              break;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
            localObject4 = new ad();
            ((ad)localObject4).ckB = 2L;
            ((ad)localObject4).ckC = str;
            ((ad)localObject4).ckD = 0L;
            ((ad)localObject4).ckE = j;
            ((ad)localObject4).ckz = 1L;
            ((ad)localObject4).QX();
            break;
          }
        }
        ao((List)localObject2);
        break label386;
        l1 = ((StatFs)localObject2).getBlockCount();
        break label420;
        l2 = ((StatFs)localObject2).getBlockSize();
        break label440;
      }
      r.cs(l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h.d
 * JD-Core Version:    0.7.0.1
 */