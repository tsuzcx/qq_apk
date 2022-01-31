package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$b
  extends a
{
  private String id;
  private String name;
  
  public b$b(b paramb, String paramString)
  {
    this.id = paramString;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(129960);
    String str = String.format("{name: %s id: %s}", new Object[] { this.name, this.id });
    AppMethodBeat.o(129960);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(129959);
    this.hrJ.hrH.beginTransaction();
    this.hrJ.hrH.b(com.tencent.mm.plugin.fts.a.c.mQE, this.id);
    AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = i.Bq(this.id);
    if (localAppBrandRecentTaskInfo != null)
    {
      long l = System.currentTimeMillis();
      String str = bo.nullAsNil(localAppBrandRecentTaskInfo.ese);
      int i = str.hashCode();
      this.hrJ.hrH.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
      this.hrJ.hrH.a(393216, 2, i, str, l, d.aR(localAppBrandRecentTaskInfo.appName, false));
      this.hrJ.hrH.a(393216, 3, i, str, l, d.aR(localAppBrandRecentTaskInfo.appName, true));
      this.name = localAppBrandRecentTaskInfo.appName;
      ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", new Object[] { str });
    }
    this.hrJ.hrH.commit();
    AppMethodBeat.o(129959);
    return true;
  }
  
  public final String getName()
  {
    return "InsertWeAppTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.b
 * JD-Core Version:    0.7.0.1
 */