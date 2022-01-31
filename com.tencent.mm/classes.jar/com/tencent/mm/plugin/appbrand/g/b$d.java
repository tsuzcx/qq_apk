package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class b$d
  extends a
{
  private int fYw;
  
  b$d(b paramb) {}
  
  public final String afJ()
  {
    return String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.fYw) });
  }
  
  public final boolean execute()
  {
    Object localObject = i.afN();
    if (((List)localObject).isEmpty())
    {
      y.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
      return true;
    }
    this.fYw = ((List)localObject).size();
    this.fYv.fYt.beginTransaction();
    this.fYv.fYt.k(com.tencent.mm.plugin.fts.a.c.kuR);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)((Iterator)localObject).next();
      String str = bk.pm(localAppBrandRecentTaskInfo.dzp);
      int i = str.hashCode();
      long l = System.currentTimeMillis();
      this.fYv.fYt.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
      this.fYv.fYt.a(393216, 2, i, str, l, d.aD(localAppBrandRecentTaskInfo.appName, false));
      this.fYv.fYt.a(393216, 3, i, str, l, d.aD(localAppBrandRecentTaskInfo.appName, true));
    }
    this.fYv.fYt.commit();
    return true;
  }
  
  public final String getName()
  {
    return "UpdateWeAppIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.d
 * JD-Core Version:    0.7.0.1
 */