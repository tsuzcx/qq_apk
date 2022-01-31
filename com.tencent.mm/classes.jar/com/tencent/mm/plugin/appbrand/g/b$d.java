package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class b$d
  extends a
{
  private int hrK;
  
  b$d(b paramb) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(129963);
    String str = String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.hrK) });
    AppMethodBeat.o(129963);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(129962);
    Object localObject = i.aAq();
    if (((List)localObject).isEmpty())
    {
      ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
      AppMethodBeat.o(129962);
      return true;
    }
    this.hrK = ((List)localObject).size();
    this.hrJ.hrH.beginTransaction();
    this.hrJ.hrH.u(com.tencent.mm.plugin.fts.a.c.mQE);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)((Iterator)localObject).next();
      String str = bo.nullAsNil(localAppBrandRecentTaskInfo.ese);
      int i = str.hashCode();
      long l = System.currentTimeMillis();
      this.hrJ.hrH.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
      this.hrJ.hrH.a(393216, 2, i, str, l, d.aR(localAppBrandRecentTaskInfo.appName, false));
      this.hrJ.hrH.a(393216, 3, i, str, l, d.aR(localAppBrandRecentTaskInfo.appName, true));
    }
    this.hrJ.hrH.commit();
    AppMethodBeat.o(129962);
    return true;
  }
  
  public final String getName()
  {
    return "UpdateWeAppIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.d
 * JD-Core Version:    0.7.0.1
 */