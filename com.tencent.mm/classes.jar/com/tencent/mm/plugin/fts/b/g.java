package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class g
  extends b
{
  private com.tencent.mm.ak.i gNh;
  private m hgI;
  String[] wZv;
  List<String> wZw;
  
  public g()
  {
    AppMethodBeat.i(52779);
    this.gNh = new g.1(this);
    AppMethodBeat.o(52779);
  }
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(52781);
    switch (paramj.kXb)
    {
    case 65522: 
    default: 
      paramj = new a((byte)0);
    }
    for (;;)
    {
      paramj = this.hgI.a(2147483647, paramj);
      AppMethodBeat.o(52781);
      return paramj;
      paramj = new f(paramj.wWW, paramj.talker);
      continue;
      paramj = new g((byte)0);
      continue;
      paramj = new e(paramj);
      continue;
      paramj = new d((byte)0);
      continue;
      paramj = new b(paramj);
    }
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(52782);
    com.tencent.mm.kernel.g.azz().b(30, this.gNh);
    AppMethodBeat.o(52782);
    return false;
  }
  
  public final String getName()
  {
    return "SearchTestLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52780);
    if (!((n)com.tencent.mm.kernel.g.ah(n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
      AppMethodBeat.o(52780);
      return false;
    }
    Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
    this.hgI = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSTaskDaemon();
    AppMethodBeat.o(52780);
    return true;
  }
  
  final class a
    extends a
  {
    private a() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52767);
      SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("For Test");
      AppMethodBeat.o(52767);
      throw localSQLiteDatabaseCorruptException;
    }
  }
  
  final class b
    extends a
  {
    private j wTn;
    
    public b(j paramj)
    {
      this.wTn = paramj;
    }
    
    private static long dOU()
    {
      AppMethodBeat.i(52770);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[] { "FTS5MetaFavorite", Integer.valueOf(9) });
      localObject1 = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
        AppMethodBeat.o(52770);
      }
    }
    
    private static long dOV()
    {
      AppMethodBeat.i(52771);
      Object localObject1 = String.format("SELECT count(docid) FROM %s", new Object[] { "FTS5MetaMessage" });
      localObject1 = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
        AppMethodBeat.o(52771);
      }
    }
    
    private static long dOW()
    {
      AppMethodBeat.i(52772);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1) });
      localObject1 = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
        AppMethodBeat.o(52772);
      }
    }
    
    private static long dOX()
    {
      AppMethodBeat.i(52773);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38) });
      localObject1 = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
        AppMethodBeat.o(52773);
      }
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52769);
      com.tencent.mm.plugin.fts.a.e.wVl.wVo = (d.dOr().length() / 1048576L);
      com.tencent.mm.plugin.fts.a.e.wVl.wVp = dOW();
      com.tencent.mm.plugin.fts.a.e.wVl.wVq = dOX();
      com.tencent.mm.plugin.fts.a.e.wVl.wVs = dOU();
      com.tencent.mm.plugin.fts.a.e.wVl.wVr = dOV();
      ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-301L, com.tencent.mm.plugin.fts.a.e.wVl.wVp);
      ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-302L, com.tencent.mm.plugin.fts.a.e.wVl.wVq);
      ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-303L, com.tencent.mm.plugin.fts.a.e.wVl.wVs);
      ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-304L, com.tencent.mm.plugin.fts.a.e.wVl.wVr);
      final k localk = new k(this.wTn);
      if (this.wTn.wWZ != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52768);
            g.b.a(g.b.this).wWZ.b(localk);
            AppMethodBeat.o(52768);
          }
        });
      }
      AppMethodBeat.o(52769);
      return true;
    }
    
    public final String getName()
    {
      return "FTS5DBInfoTask";
    }
  }
  
  final class d
    extends a
  {
    private d() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52774);
      com.tencent.mm.kernel.g.aAh().hqK.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
      AppMethodBeat.o(52774);
      return true;
    }
    
    public final String getName()
    {
      return "FTSClearUnReadCountTask";
    }
  }
  
  final class e
    extends a
  {
    j wWO;
    
    public e(j paramj)
    {
      this.wWO = paramj;
    }
    
    public final boolean execute()
    {
      return true;
    }
    
    public final String getName()
    {
      return "FTSTestAddChatroomContactTask";
    }
  }
  
  final class f
    extends a
  {
    private int count;
    private String dFl;
    
    public f(int paramInt, String paramString)
    {
      this.count = paramInt;
      this.dFl = paramString;
    }
    
    private static String K(String[] paramArrayOfString)
    {
      AppMethodBeat.i(52776);
      Random localRandom = new Random();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < 300)
      {
        localStringBuffer.append(paramArrayOfString[localRandom.nextInt(paramArrayOfString.length - 1)]);
        i += 1;
      }
      paramArrayOfString = localStringBuffer.toString();
      AppMethodBeat.o(52776);
      return paramArrayOfString;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52775);
      if (g.this.wZv == null)
      {
        localObject = s.boY("/sdcard/test_insert_msg_words.txt");
        g.this.wZv = ((String)localObject).split(",");
      }
      int i;
      label97:
      String str;
      ca localca;
      if (g.this.wZw == null)
      {
        g.this.wZw = new ArrayList();
        if (!Util.isNullOrNil(this.dFl)) {
          g.this.wZw.add(this.dFl);
        }
      }
      else
      {
        if (g.this.wZv == null) {
          break label364;
        }
        i = 0;
        if (i >= this.count) {
          break label364;
        }
        str = K(g.this.wZv);
        localca = new ca();
        localca.setType(1);
        localca.nv(1);
        localca.setStatus(4);
        localca.setContent(str);
        localObject = g.this.wZw;
        if (((List)localObject).size() <= 1) {
          break label350;
        }
      }
      label350:
      for (Object localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size() - 1));; localObject = (String)((List)localObject).get(0))
      {
        localca.Cy((String)localObject);
        localca.setCreateTime(System.currentTimeMillis() - 250327040L);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
        Log.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(str.length()), Long.valueOf(localca.field_msgId) });
        i += 1;
        break label97;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().gCa();
        while (((Cursor)localObject).moveToNext()) {
          g.this.wZw.add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
        break;
      }
      label364:
      AppMethodBeat.o(52775);
      return true;
    }
  }
  
  final class g
    extends a
  {
    private g() {}
    
    private static String K(String[] paramArrayOfString)
    {
      AppMethodBeat.i(52778);
      Random localRandom = new Random();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < 300)
      {
        localStringBuffer.append(paramArrayOfString[localRandom.nextInt(paramArrayOfString.length - 1)]);
        i += 1;
      }
      paramArrayOfString = localStringBuffer.toString();
      AppMethodBeat.o(52778);
      return paramArrayOfString;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52777);
      Object localObject;
      if (g.this.wZv == null)
      {
        localObject = s.boY("/sdcard/test_insert_msg_words.txt");
        g.this.wZv = ((String)localObject).split(",");
      }
      if (g.this.wZw == null)
      {
        g.this.wZw = new ArrayList();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().gCa();
        while (((Cursor)localObject).moveToNext()) {
          g.this.wZw.add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
      }
      if (g.this.wZv != null)
      {
        localObject = new int[7];
        Object tmp131_130 = localObject;
        tmp131_130[0] = 1000;
        Object tmp137_131 = tmp131_130;
        tmp137_131[1] = 2000;
        Object tmp143_137 = tmp137_131;
        tmp143_137[2] = 5000;
        Object tmp149_143 = tmp143_137;
        tmp149_143[3] = 10000;
        Object tmp155_149 = tmp149_143;
        tmp155_149[4] = 20000;
        Object tmp161_155 = tmp155_149;
        tmp161_155[5] = 50000;
        Object tmp166_161 = tmp161_155;
        tmp166_161[6] = 100000;
        tmp166_161;
        int i = 0;
        while (i < 7)
        {
          int j = 0;
          while (j < localObject[i])
          {
            String str = K(g.this.wZv);
            ca localca = new ca();
            localca.setType(1);
            localca.nv(1);
            localca.setStatus(4);
            localca.setContent(str);
            localca.Cy((String)g.this.wZw.get(i));
            localca.setCreateTime(System.currentTimeMillis());
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
            Log.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localObject[i]), Integer.valueOf(str.length()), Long.valueOf(localca.field_msgId) });
            j += 1;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(52777);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g
 * JD-Core Version:    0.7.0.1
 */