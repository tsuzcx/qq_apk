package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends b
{
  private com.tencent.mm.plugin.fts.b.e Hwd;
  private com.tencent.mm.plugin.fts.a.m msU;
  
  public final c a(l paraml)
  {
    AppMethodBeat.i(52750);
    paraml = new d(paraml);
    this.msU.a(-65536, paraml);
    AppMethodBeat.o(52750);
    return paraml;
  }
  
  public final boolean aXx()
  {
    this.Hwd = null;
    this.msU = null;
    return true;
  }
  
  public final void addSOSHistory(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52747);
    a locala = new a();
    locala.key = paramString1;
    locala.content = paramString2;
    locala.timestamp = System.currentTimeMillis();
    if (this.msU != null) {
      this.msU.a(132072, locala);
    }
    AppMethodBeat.o(52747);
  }
  
  public final void deleteSOSHistory()
  {
    AppMethodBeat.i(52748);
    b localb = new b();
    if (this.msU != null) {
      this.msU.a(132072, localb);
    }
    AppMethodBeat.o(52748);
  }
  
  public final void deleteSOSHistory(String paramString)
  {
    AppMethodBeat.i(52749);
    c localc = new c();
    localc.key = paramString;
    if (this.msU != null) {
      this.msU.a(132072, localc);
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
    if (!((n)com.tencent.mm.kernel.h.az(n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
      AppMethodBeat.o(52746);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
    this.Hwd = ((com.tencent.mm.plugin.fts.b.e)((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexStorage(1024));
    this.msU = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSTaskDaemon();
    AppMethodBeat.o(52746);
    return true;
  }
  
  public final class a
    extends c
  {
    public String content;
    public String key;
    public long timestamp;
    
    public a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52742);
      com.tencent.mm.plugin.fts.b.e locale = e.a(e.this);
      String str1 = this.key;
      long l = this.timestamp;
      String str2 = this.content;
      locale.HqT.bindString(1, str1);
      locale.HqT.bindLong(2, l);
      locale.HqT.bindString(3, str2);
      locale.HqT.execute();
      AppMethodBeat.o(52742);
      return true;
    }
    
    public final String getName()
    {
      return "AddSOSHistoryTask";
    }
  }
  
  public final class b
    extends c
  {
    public b() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52743);
      com.tencent.mm.plugin.fts.b.e locale = e.a(e.this);
      locale.HqR.execSQL(String.format("DELETE FROM %s ;", new Object[] { com.tencent.mm.plugin.fts.b.e.fxn() }));
      locale.HqR.execSQL(String.format("DELETE FROM %s ;", new Object[] { com.tencent.mm.plugin.fts.b.e.fxo() }));
      AppMethodBeat.o(52743);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteSOSHistoryTask";
    }
  }
  
  public final class c
    extends c
  {
    public String key;
    
    public c() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52744);
      com.tencent.mm.plugin.fts.b.e locale = e.a(e.this);
      String str1 = this.key;
      String str2 = String.format("DELETE FROM %s WHERE key = ?", new Object[] { com.tencent.mm.plugin.fts.b.e.fxn() });
      locale.HqR.execSQL(str2, new String[] { str1 });
      AppMethodBeat.o(52744);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteSOSHistoryTask";
    }
  }
  
  public final class d
    extends k
  {
    public d(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52745);
      super.a(paramm);
      paramm.HtF = new ArrayList();
      Object localObject = e.a(e.this);
      String str = String.format("SELECT content, timestamp FROM %s ORDER BY timestamp desc LIMIT ".concat(String.valueOf(this.Htr.Htz)), new Object[] { com.tencent.mm.plugin.fts.b.e.fxn() });
      localObject = ((com.tencent.mm.plugin.fts.b.e)localObject).HqR.rawQuery(str, null);
      while ((localObject != null) && (((Cursor)localObject).moveToNext()))
      {
        str = ((Cursor)localObject).getString(0);
        p localp = new p();
        localp.content = str;
        paramm.HtF.add(localp);
      }
      ((Cursor)localObject).close();
      paramm.resultCode = 0;
      AppMethodBeat.o(52745);
    }
    
    public final String getName()
    {
      return "SearchSOSHistoryTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.e
 * JD-Core Version:    0.7.0.1
 */