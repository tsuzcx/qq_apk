package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends b
{
  private m grs;
  com.tencent.mm.plugin.fts.c.d txv;
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(52750);
    paramj = new d(paramj);
    this.grs.a(-65536, paramj);
    AppMethodBeat.o(52750);
    return paramj;
  }
  
  public final void addSOSHistory(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52747);
    a locala = new a();
    locala.key = paramString1;
    locala.content = paramString2;
    locala.timestamp = System.currentTimeMillis();
    if (this.grs != null) {
      this.grs.a(132072, locala);
    }
    AppMethodBeat.o(52747);
  }
  
  public final boolean agA()
  {
    this.txv = null;
    this.grs = null;
    return true;
  }
  
  public final void deleteSOSHistory()
  {
    AppMethodBeat.i(52748);
    b localb = new b();
    if (this.grs != null) {
      this.grs.a(132072, localb);
    }
    AppMethodBeat.o(52748);
  }
  
  public final void deleteSOSHistory(String paramString)
  {
    AppMethodBeat.i(52749);
    c localc = new c();
    localc.key = paramString;
    if (this.grs != null) {
      this.grs.a(132072, localc);
    }
    AppMethodBeat.o(52749);
  }
  
  public final String getName()
  {
    return "FTS5SearchSOSHistoryLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52746);
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ad.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
      AppMethodBeat.o(52746);
      return false;
    }
    ad.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
    this.txv = ((com.tencent.mm.plugin.fts.c.d)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1024));
    this.grs = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    AppMethodBeat.o(52746);
    return true;
  }
  
  public final class a
    extends a
  {
    public String content;
    public String key;
    public long timestamp;
    
    public a() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52742);
      com.tencent.mm.plugin.fts.c.d locald = d.this.txv;
      String str1 = this.key;
      long l = this.timestamp;
      String str2 = this.content;
      locald.tsF.bindString(1, str1);
      locald.tsF.bindLong(2, l);
      locald.tsF.bindString(3, str2);
      locald.tsF.execute();
      AppMethodBeat.o(52742);
      return true;
    }
    
    public final String getName()
    {
      return "AddSOSHistoryTask";
    }
  }
  
  public final class b
    extends a
  {
    public b() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52743);
      com.tencent.mm.plugin.fts.c.d locald = d.this.txv;
      locald.tsD.execSQL(String.format("DELETE FROM %s ;", new Object[] { "FTS5MetaSOSHistory" }));
      locald.tsD.execSQL(String.format("DELETE FROM %s ;", new Object[] { "FTS5IndexSOSHistory" }));
      AppMethodBeat.o(52743);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteSOSHistoryTask";
    }
  }
  
  public final class c
    extends a
  {
    public String key;
    
    public c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52744);
      com.tencent.mm.plugin.fts.c.d locald = d.this.txv;
      String str1 = this.key;
      String str2 = String.format("DELETE FROM %s WHERE key = ?", new Object[] { "FTS5MetaSOSHistory" });
      locald.tsD.execSQL(str2, new String[] { str1 });
      AppMethodBeat.o(52744);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteSOSHistoryTask";
    }
  }
  
  public final class d
    extends i
  {
    public d(j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52745);
      super.a(paramk);
      paramk.tvl = new ArrayList();
      Object localObject = d.this.txv;
      String str = String.format("SELECT content, timestamp FROM %s ORDER BY timestamp desc LIMIT ".concat(String.valueOf(this.tuY.tvg)), new Object[] { "FTS5MetaSOSHistory" });
      localObject = ((com.tencent.mm.plugin.fts.c.d)localObject).tsD.rawQuery(str, null);
      while (((Cursor)localObject).moveToNext())
      {
        str = ((Cursor)localObject).getString(0);
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
        localn.content = str;
        paramk.tvl.add(localn);
      }
      ((Cursor)localObject).close();
      paramk.bZU = 0;
      AppMethodBeat.o(52745);
    }
    
    public final String getName()
    {
      return "SearchSOSHistoryTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d
 * JD-Core Version:    0.7.0.1
 */