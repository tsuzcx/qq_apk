package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.fts.a.b
{
  m ezf;
  private f fur;
  com.tencent.mm.sdk.b.c mVr;
  String[] mVs;
  List<String> mVt;
  
  public g()
  {
    AppMethodBeat.i(136806);
    this.mVr = new g.1(this);
    this.fur = new g.2(this);
    AppMethodBeat.o(136806);
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136809);
    com.tencent.mm.kernel.g.Rc().b(30, this.fur);
    AppMethodBeat.o(136809);
    return false;
  }
  
  public final a a(i parami)
  {
    AppMethodBeat.i(136808);
    switch (parami.hdl)
    {
    case 65522: 
    default: 
      parami = new g.a(this, (byte)0);
    }
    for (;;)
    {
      parami = this.ezf.a(-65536, parami);
      AppMethodBeat.o(136808);
      return parami;
      parami = new g.f(this, parami.mSR, parami.talker);
      continue;
      parami = new g.g(this, (byte)0);
      continue;
      parami = new g.e(this, parami);
      continue;
      parami = new g.d(this, (byte)0);
    }
  }
  
  public final String getName()
  {
    return "SearchTestLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(136807);
    if (!((n)com.tencent.mm.kernel.g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
      AppMethodBeat.o(136807);
      return false;
    }
    ab.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
    this.ezf = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSTaskDaemon();
    this.mVr.alive();
    AppMethodBeat.o(136807);
    return true;
  }
  
  final class b
    extends a
  {
    private b() {}
    
    private static long bCr()
    {
      AppMethodBeat.i(136797);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[] { "FTS5MetaFavorite", Integer.valueOf(9) });
      localObject1 = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
      try
      {
        if (((Cursor)localObject1).moveToNext())
        {
          long l = ((Cursor)localObject1).getLong(0);
          return l;
        }
        return 0L;
      }
      finally
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(136797);
      }
    }
    
    private static long bCs()
    {
      AppMethodBeat.i(136798);
      Object localObject1 = String.format("SELECT count(docid) FROM %s", new Object[] { "FTS5MetaMessage" });
      localObject1 = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
      try
      {
        if (((Cursor)localObject1).moveToNext())
        {
          long l = ((Cursor)localObject1).getLong(0);
          return l;
        }
        return 0L;
      }
      finally
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(136798);
      }
    }
    
    private static long bCt()
    {
      AppMethodBeat.i(136799);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1) });
      localObject1 = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
      try
      {
        if (((Cursor)localObject1).moveToNext())
        {
          long l = ((Cursor)localObject1).getLong(0);
          return l;
        }
        return 0L;
      }
      finally
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(136799);
      }
    }
    
    private static long bCu()
    {
      AppMethodBeat.i(136800);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38) });
      localObject1 = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
      try
      {
        if (((Cursor)localObject1).moveToNext())
        {
          long l = ((Cursor)localObject1).getLong(0);
          return l;
        }
        return 0L;
      }
      finally
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(136800);
      }
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(136796);
      Object localObject1 = new StringBuffer();
      long l = d.bBP().length();
      com.tencent.mm.plugin.fts.a.e.mRj.mRm = (l / 1048576L);
      ((StringBuffer)localObject1).append("[DBSize]=" + bo.nV(l));
      ((StringBuffer)localObject1).append("\n");
      com.tencent.mm.plugin.fts.a.e.mRj.mRn = bCt();
      com.tencent.mm.plugin.fts.a.e.mRj.mRo = bCu();
      com.tencent.mm.plugin.fts.a.e.mRj.mRq = bCr();
      com.tencent.mm.plugin.fts.a.e.mRj.mRp = bCs();
      ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().M(-301L, com.tencent.mm.plugin.fts.a.e.mRj.mRn);
      ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().M(-302L, com.tencent.mm.plugin.fts.a.e.mRj.mRo);
      ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().M(-303L, com.tencent.mm.plugin.fts.a.e.mRj.mRq);
      ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexDB().M(-304L, com.tencent.mm.plugin.fts.a.e.mRj.mRp);
      ((StringBuffer)localObject1).append("[WXContact]=" + com.tencent.mm.plugin.fts.a.e.mRj.mRn);
      ((StringBuffer)localObject1).append("\n");
      ((StringBuffer)localObject1).append("[WXChatroom]=" + com.tencent.mm.plugin.fts.a.e.mRj.mRo);
      ((StringBuffer)localObject1).append("\n");
      ((StringBuffer)localObject1).append("[Favorite]=" + com.tencent.mm.plugin.fts.a.e.mRj.mRq);
      ((StringBuffer)localObject1).append("\n");
      ((StringBuffer)localObject1).append("[Message]=" + com.tencent.mm.plugin.fts.a.e.mRj.mRp);
      Object localObject2 = ((StringBuffer)localObject1).toString();
      ab.i("MicroMsg.FTS.FTSSearchTestLogic", (String)localObject2);
      localObject1 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fts.a.c.mQV, "FTS5IndexMicroMsgInfo.txt");
      if (((com.tencent.mm.vfs.b)localObject1).exists()) {
        ((com.tencent.mm.vfs.b)localObject1).delete();
      }
      if (!((com.tencent.mm.vfs.b)localObject1).dQI().exists()) {
        ((com.tencent.mm.vfs.b)localObject1).dQI().mkdirs();
      }
      String str = j.p(((com.tencent.mm.vfs.b)localObject1).dQJ());
      localObject2 = ((String)localObject2).getBytes();
      ab.i("MicroMsg.FTS.FTSSearchTestLogic", "write fts info %d %s", new Object[] { Integer.valueOf(com.tencent.mm.vfs.e.b(str, (byte[])localObject2, localObject2.length)), j.p(((com.tencent.mm.vfs.b)localObject1).dQJ()) });
      AppMethodBeat.o(136796);
      return true;
    }
    
    public final String getName()
    {
      return "FTS5DBInfoTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g
 * JD-Core Version:    0.7.0.1
 */