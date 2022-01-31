package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$b
  extends a
{
  private String id;
  private String name;
  
  public b$b(b paramb, String paramString)
  {
    this.id = paramString;
  }
  
  public final String afJ()
  {
    return String.format("{name: %s id: %s}", new Object[] { this.name, this.id });
  }
  
  public final boolean execute()
  {
    this.fYv.fYt.beginTransaction();
    this.fYv.fYt.b(com.tencent.mm.plugin.fts.a.c.kuR, this.id);
    AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = i.tm(this.id);
    if (localAppBrandRecentTaskInfo != null)
    {
      long l = System.currentTimeMillis();
      String str = bk.pm(localAppBrandRecentTaskInfo.dzp);
      int i = str.hashCode();
      this.fYv.fYt.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
      this.fYv.fYt.a(393216, 2, i, str, l, d.aD(localAppBrandRecentTaskInfo.appName, false));
      this.fYv.fYt.a(393216, 3, i, str, l, d.aD(localAppBrandRecentTaskInfo.appName, true));
      this.name = localAppBrandRecentTaskInfo.appName;
      y.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", new Object[] { str });
    }
    this.fYv.fYt.commit();
    return true;
  }
  
  public final String getName()
  {
    return "InsertWeAppTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.b
 * JD-Core Version:    0.7.0.1
 */