package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class au$1
  implements n
{
  private void awd()
  {
    AppMethodBeat.i(129426);
    Object localObject1 = new File(ap.avQ());
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      AppMethodBeat.o(129426);
      return;
    }
    localObject1 = ((File)localObject1).listFiles(new au.1.1(this));
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (!com.tencent.mm.plugin.appbrand.app.g.auM().yG(localObject2.getAbsolutePath())) {
        n.a.yo(localObject2.getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(129426);
  }
  
  public final void run()
  {
    AppMethodBeat.i(129427);
    try
    {
      Object localObject1 = com.tencent.mm.plugin.appbrand.app.g.auM().awg();
      if (!bo.es((List)localObject1))
      {
        long l = bo.aox();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (at)((Iterator)localObject1).next();
          if ((((at)localObject3).field_endTime > 0L) && (((at)localObject3).field_endTime <= l) && (((at)localObject3).field_debugType == 999))
          {
            n.a.yo(((at)localObject3).field_pkgPath);
            com.tencent.mm.plugin.appbrand.app.g.auM().a((at)localObject3);
            h.bt(((at)localObject3).field_appId, ((at)localObject3).field_debugType);
          }
        }
      }
      if (!com.tencent.mm.kernel.g.RG()) {
        break label446;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(129427);
      return;
    }
    Object localObject3 = com.tencent.mm.plugin.appbrand.app.g.auM();
    Object localObject2 = ((ay)localObject3).gWU.a(String.format("select distinct %s from %s ", new Object[] { "appId", "AppBrandWxaPkgManifestRecord" }), null, 2);
    Object localObject4 = new ArrayList();
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject4).add(((Cursor)localObject2).getString(0));
    }
    ((Cursor)localObject2).close();
    if (bo.es((List)localObject4)) {
      localObject2 = null;
    }
    for (;;)
    {
      if (!bo.es((List)localObject2))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (at)((Iterator)localObject2).next();
          if ((((at)localObject3).field_appId.indexOf('$') <= 0) && (!h.EZ(((at)localObject3).field_appId)))
          {
            n.a.yo(((at)localObject3).field_pkgPath);
            com.tencent.mm.plugin.appbrand.app.g.auM().a((at)localObject3);
            com.tencent.mm.plugin.appbrand.app.g.auR().ap(((at)localObject3).field_appId, ((at)localObject3).field_version);
            localObject4 = new ca();
            ((ca)localObject4).cZU = 2L;
            localObject3 = ((ca)localObject4).gZ(((at)localObject3).field_appId);
            ((ca)localObject3).cZW = 0L;
            ((ca)localObject3).cZX = 1L;
            ((ca)localObject3).cZS = 0L;
            ((ca)localObject3).ake();
            continue;
            localObject2 = new LinkedList();
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              List localList = ((ay)localObject3).yH((String)((Iterator)localObject4).next());
              if (!bo.es(localList)) {
                ((List)localObject2).addAll(localList);
              }
            }
          }
        }
      }
      label446:
      awd();
      AppMethodBeat.o(129427);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au.1
 * JD-Core Version:    0.7.0.1
 */