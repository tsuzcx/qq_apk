package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;

public final class a$1
  implements Runnable
{
  private void ay(List<cjb> paramList)
  {
    AppMethodBeat.i(129441);
    com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
    com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(0L, 0L);
    new a(paramList, (byte)0).adl().h(new a.1.1(this));
    AppMethodBeat.o(129441);
  }
  
  public final void run()
  {
    AppMethodBeat.i(129440);
    if ((!com.tencent.mm.kernel.g.RJ().eHg) || (com.tencent.mm.plugin.appbrand.app.g.auB() == null) || (com.tencent.mm.plugin.appbrand.app.g.auM() == null))
    {
      AppMethodBeat.o(129440);
      return;
    }
    long l1 = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDl, Long.valueOf(0L))).longValue();
    long l2 = AppBrandGlobalSystemConfig.ayt().hhX.hir;
    long l3 = bo.aox();
    int i;
    if (l3 >= l1 + l2) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDl, Long.valueOf(l3));
      }
      try
      {
        List localList = a.awl();
        if (bo.es(localList))
        {
          ab.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
          AppMethodBeat.o(129440);
          return;
          i = 0;
          continue;
          AppMethodBeat.o(129440);
          return;
        }
      }
      catch (com.tencent.wcdb.database.SQLiteDiskIOException localSQLiteDiskIOException)
      {
        Object localObject;
        for (;;)
        {
          ab.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit::collectReqInfoList, e=%s", new Object[] { localSQLiteDiskIOException });
          localObject = null;
        }
        int k = AppBrandGlobalSystemConfig.ayt().hhX.hiv;
        i = 0;
        int j = 0;
        while (i < localObject.size() / k)
        {
          int m = i * k;
          j = m + k;
          ay(localObject.subList(m, j));
          i += 1;
        }
        if (j < localObject.size()) {
          ay(localObject.subList(j, localObject.size()));
        }
        AppMethodBeat.o(129440);
        return;
      }
      catch (android.database.sqlite.SQLiteDiskIOException localSQLiteDiskIOException1)
      {
        label145:
        break label145;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.a.1
 * JD-Core Version:    0.7.0.1
 */