package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.h.b.a.ad;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ao
{
  static final h fEm = new h()
  {
    private void acn()
    {
      Object localObject1 = new File(aj.abZ());
      if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {}
      for (;;)
      {
        return;
        localObject1 = ((File)localObject1).listFiles(new ao.1.1(this));
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!e.abb().rj(localObject2.getAbsolutePath())) {
            h.a.qS(localObject2.getAbsolutePath());
          }
          i += 1;
        }
      }
    }
    
    public final void run()
    {
      try
      {
        Object localObject1 = e.abb().acp();
        if (!bk.dk((List)localObject1))
        {
          long l = bk.UX();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (an)((Iterator)localObject1).next();
            if ((((an)localObject3).field_endTime > 0L) && (((an)localObject3).field_endTime <= l) && (((an)localObject3).field_debugType == 999))
            {
              h.a.qS(((an)localObject3).field_pkgPath);
              e.abb().a((an)localObject3);
              com.tencent.mm.plugin.appbrand.task.g.aZ(((an)localObject3).field_appId, ((an)localObject3).field_debugType);
            }
          }
        }
        if (!com.tencent.mm.kernel.g.DK()) {
          break label432;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", new Object[] { bk.j(localException) });
        return;
      }
      Object localObject3 = e.abb();
      Object localObject2 = ((ar)localObject3).fEC.a(String.format("select distinct %s from %s ", new Object[] { "appId", "AppBrandWxaPkgManifestRecord" }), null, 2);
      Object localObject4 = new ArrayList();
      while (((Cursor)localObject2).moveToNext()) {
        ((List)localObject4).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      if (bk.dk((List)localObject4)) {
        localObject2 = null;
      }
      for (;;)
      {
        if (!bk.dk((List)localObject2))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (an)((Iterator)localObject2).next();
            if ((((an)localObject3).field_appId.indexOf('$') <= 0) && (!com.tencent.mm.plugin.appbrand.task.g.wr(((an)localObject3).field_appId)))
            {
              h.a.qS(((an)localObject3).field_pkgPath);
              e.abb().a((an)localObject3);
              e.abg().ag(((an)localObject3).field_appId, ((an)localObject3).field_version);
              localObject4 = new ad();
              ((ad)localObject4).ckB = 2L;
              ((ad)localObject4).ckC = ((an)localObject3).field_appId;
              ((ad)localObject4).ckD = 0L;
              ((ad)localObject4).ckE = 1L;
              ((ad)localObject4).ckz = 0L;
              ((ad)localObject4).QX();
              continue;
              localObject2 = new LinkedList();
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                List localList = ((ar)localObject3).rk((String)((Iterator)localObject4).next());
                if (!bk.dk(localList)) {
                  ((List)localObject2).addAll(localList);
                }
              }
            }
          }
        }
        label432:
        acn();
        return;
      }
    }
  };
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ao
 * JD-Core Version:    0.7.0.1
 */