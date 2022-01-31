package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$d
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private String eaX;
  private int mUv = 0;
  
  public a$d(a parama, String paramString)
  {
    this.eaX = paramString;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136671);
    String str = String.format("{username: %s mDirtyCount: %d}", new Object[] { this.eaX, Integer.valueOf(this.mUv) });
    AppMethodBeat.o(136671);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136670);
    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[] { this.eaX });
    a.a(this.mUg).b(c.mQI, this.eaX);
    ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic().d(c.mQI, this.eaX);
    Object localObject1 = a.a(this.mUg).Pp(this.eaX);
    Object localObject2 = new HashSet();
    while (((Cursor)localObject1).moveToNext()) {
      ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
    }
    ((Cursor)localObject1).close();
    localObject1 = ((HashSet)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!a.b(this.mUg).containsKey(localObject2))
      {
        List localList = a.a(this.mUg).c(c.mQI, (String)localObject2);
        a.b(this.mUg).put(localObject2, localList);
        ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic().Pn((String)localObject2);
        this.mUv += 1;
      }
    }
    AppMethodBeat.o(136670);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.d
 * JD-Core Version:    0.7.0.1
 */