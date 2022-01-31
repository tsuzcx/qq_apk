package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bg.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.j;

final class b$2
  extends c<bg>
{
  b$2(b paramb)
  {
    AppMethodBeat.i(136716);
    this.__eventId = bg.class.getName().hashCode();
    AppMethodBeat.o(136716);
  }
  
  private boolean a(bg parambg)
  {
    AppMethodBeat.i(136717);
    b localb;
    Object localObject;
    if ((parambg.coI.coJ == 35) && (parambg.coI.subType == 1))
    {
      ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "CheckResUpdateCacheFileEvent: %s", new Object[] { parambg.coI.filePath });
      localb = this.mUJ;
      localObject = parambg.coI.filePath;
      parambg = new com.tencent.mm.vfs.b(b.bCk(), "temp");
      if (parambg.exists()) {
        com.tencent.mm.vfs.e.O(j.p(parambg.dQJ()), true);
      }
      parambg.mkdirs();
    }
    try
    {
      int i = com.tencent.mm.vfs.e.iH((String)localObject, j.p(parambg.dQJ()));
      ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "unzip %s %d", new Object[] { localObject, Integer.valueOf(i) });
      if (i >= 0)
      {
        localObject = b.bCl();
        parambg = new com.tencent.mm.vfs.b(parambg, "fts_feature");
        i = b.k(parambg);
        int j = b.k((com.tencent.mm.vfs.b)localObject);
        ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateFeatureList: updateVersion %d currentVersion %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (i > j)
        {
          com.tencent.mm.vfs.e.O(j.p(((com.tencent.mm.vfs.b)localObject).dQJ()), true);
          parambg.p((com.tencent.mm.vfs.b)localObject);
          localb.ezf.a(65596, new b.d(localb, j.p(((com.tencent.mm.vfs.b)localObject).dQJ())));
        }
      }
    }
    catch (Exception parambg)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", parambg, "updateFeatureList", new Object[0]);
        com.tencent.mm.plugin.fts.a.e.wq(22);
      }
    }
    AppMethodBeat.o(136717);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b.2
 * JD-Core Version:    0.7.0.1
 */