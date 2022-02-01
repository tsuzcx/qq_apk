package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends b
{
  private com.tencent.mm.plugin.fts.c.d BLk;
  private m jSC;
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(52750);
    paramj = new d(paramj);
    this.jSC.a(-65536, paramj);
    AppMethodBeat.o(52750);
    return paramj;
  }
  
  public final boolean aEt()
  {
    this.BLk = null;
    this.jSC = null;
    return true;
  }
  
  public final void addSOSHistory(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52747);
    a locala = new a();
    locala.key = paramString1;
    locala.content = paramString2;
    locala.timestamp = System.currentTimeMillis();
    if (this.jSC != null) {
      this.jSC.a(132072, locala);
    }
    AppMethodBeat.o(52747);
  }
  
  public final void deleteSOSHistory()
  {
    AppMethodBeat.i(52748);
    b localb = new b();
    if (this.jSC != null) {
      this.jSC.a(132072, localb);
    }
    AppMethodBeat.o(52748);
  }
  
  public final void deleteSOSHistory(String paramString)
  {
    AppMethodBeat.i(52749);
    c localc = new c();
    localc.key = paramString;
    if (this.jSC != null) {
      this.jSC.a(132072, localc);
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
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
      AppMethodBeat.o(52746);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
    this.BLk = ((com.tencent.mm.plugin.fts.c.d)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1024));
    this.jSC = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
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
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52742);
      com.tencent.mm.plugin.fts.c.d locald = d.a(d.this);
      String str1 = this.key;
      long l = this.timestamp;
      String str2 = this.content;
      locald.BGr.bindString(1, str1);
      locald.BGr.bindLong(2, l);
      locald.BGr.bindString(3, str2);
      locald.BGr.execute();
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
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52743);
      com.tencent.mm.plugin.fts.c.d locald = d.a(d.this);
      locald.BGp.execSQL(String.format("DELETE FROM %s ;", new Object[] { com.tencent.mm.plugin.fts.c.d.eqI() }));
      locald.BGp.execSQL(String.format("DELETE FROM %s ;", new Object[] { com.tencent.mm.plugin.fts.c.d.eqJ() }));
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
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52744);
      com.tencent.mm.plugin.fts.c.d locald = d.a(d.this);
      String str1 = this.key;
      String str2 = String.format("DELETE FROM %s WHERE key = ?", new Object[] { com.tencent.mm.plugin.fts.c.d.eqI() });
      locald.BGp.execSQL(str2, new String[] { str1 });
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
      paramk.BIW = new ArrayList();
      Object localObject = d.a(d.this);
      String str = String.format("SELECT content, timestamp FROM %s ORDER BY timestamp desc LIMIT ".concat(String.valueOf(this.BIJ.BIR)), new Object[] { com.tencent.mm.plugin.fts.c.d.eqI() });
      localObject = ((com.tencent.mm.plugin.fts.c.d)localObject).BGp.rawQuery(str, null);
      while (((Cursor)localObject).moveToNext())
      {
        str = ((Cursor)localObject).getString(0);
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
        localn.content = str;
        paramk.BIW.add(localn);
      }
      ((Cursor)localObject).close();
      paramk.resultCode = 0;
      AppMethodBeat.o(52745);
    }
    
    public final String getName()
    {
      return "SearchSOSHistoryTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d
 * JD-Core Version:    0.7.0.1
 */