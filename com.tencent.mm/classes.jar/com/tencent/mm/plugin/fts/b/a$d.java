package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$d
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private String djD;
  private int kyH = 0;
  
  public a$d(a parama, String paramString)
  {
    this.djD = paramString;
  }
  
  public final String afJ()
  {
    return String.format("{username: %s mDirtyCount: %d}", new Object[] { this.djD, Integer.valueOf(this.kyH) });
  }
  
  public final boolean execute()
  {
    y.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.djD });
    a.a(this.kyt).b(c.kuV, this.djD);
    ((PluginFTS)g.t(PluginFTS.class)).getTopHitsLogic().d(c.kuV, this.djD);
    Object localObject1 = a.a(this.kyt).Ef(this.djD);
    Object localObject2 = new HashSet();
    while (((Cursor)localObject1).moveToNext()) {
      ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
    }
    ((Cursor)localObject1).close();
    localObject1 = ((HashSet)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!a.b(this.kyt).containsKey(localObject2))
      {
        List localList = a.a(this.kyt).c(c.kuV, (String)localObject2);
        a.b(this.kyt).put(localObject2, localList);
        ((PluginFTS)g.t(PluginFTS.class)).getTopHitsLogic().Ed((String)localObject2);
        this.kyH += 1;
      }
    }
    return true;
  }
  
  public final String getName()
  {
    return "DeleteContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.d
 * JD-Core Version:    0.7.0.1
 */