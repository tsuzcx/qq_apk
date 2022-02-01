package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class g
  extends b
{
  private m fXX;
  private com.tencent.mm.ak.g hwV;
  String[] sBe;
  List<String> sBf;
  
  public g()
  {
    AppMethodBeat.i(52779);
    this.hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(52766);
        if ((paramAnonymousn instanceof g.c))
        {
          paramAnonymousn = (g.c)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            List localList = paramAnonymousn.Dhk;
            if (paramAnonymousInt2 == -44)
            {
              LinkedList localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(1));
              HashMap localHashMap = new HashMap();
              localHashMap.put(localList.get(0), Integer.valueOf(0));
              paramAnonymousn = new g.c(g.this, localList, localLinkedList, "你好，我是珍惜", paramAnonymousn.sBi, localHashMap, paramAnonymousn.sBi);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousn, 0);
            }
            if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -24) && (!bs.isNullOrNil(paramAnonymousString))) {
              Toast.makeText(ai.getContext(), paramAnonymousString, 1).show();
            }
            AppMethodBeat.o(52766);
            return;
          }
          ac.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[] { paramAnonymousn.Dhk.toString() });
        }
        AppMethodBeat.o(52766);
      }
    };
    AppMethodBeat.o(52779);
  }
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(52781);
    switch (paramj.jwR)
    {
    case 65522: 
    default: 
      paramj = new a((byte)0);
    }
    for (;;)
    {
      paramj = this.fXX.a(2147483647, paramj);
      AppMethodBeat.o(52781);
      return paramj;
      paramj = new f(paramj.syF, paramj.talker);
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
  
  public final boolean adU()
  {
    AppMethodBeat.i(52782);
    com.tencent.mm.kernel.g.agi().b(30, this.hwV);
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
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ac.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
      AppMethodBeat.o(52780);
      return false;
    }
    ac.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
    this.fXX = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
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
    private j suU;
    
    public b(j paramj)
    {
      this.suU = paramj;
    }
    
    private static long cKR()
    {
      AppMethodBeat.i(52770);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[] { "FTS5MetaFavorite", Integer.valueOf(9) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
    
    private static long cKS()
    {
      AppMethodBeat.i(52771);
      Object localObject1 = String.format("SELECT count(docid) FROM %s", new Object[] { "FTS5MetaMessage" });
      localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
    
    private static long cKT()
    {
      AppMethodBeat.i(52772);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
    
    private static long cKU()
    {
      AppMethodBeat.i(52773);
      Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38) });
      localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
      com.tencent.mm.plugin.fts.a.e.swU.swX = (d.cKo().length() / 1048576L);
      com.tencent.mm.plugin.fts.a.e.swU.swY = cKT();
      com.tencent.mm.plugin.fts.a.e.swU.swZ = cKU();
      com.tencent.mm.plugin.fts.a.e.swU.sxb = cKR();
      com.tencent.mm.plugin.fts.a.e.swU.sxa = cKS();
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().R(-301L, com.tencent.mm.plugin.fts.a.e.swU.swY);
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().R(-302L, com.tencent.mm.plugin.fts.a.e.swU.swZ);
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().R(-303L, com.tencent.mm.plugin.fts.a.e.swU.sxb);
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexDB().R(-304L, com.tencent.mm.plugin.fts.a.e.swU.sxa);
      final com.tencent.mm.plugin.fts.a.a.k localk = new com.tencent.mm.plugin.fts.a.a.k(this.suU);
      if (this.suU.syI != null) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52768);
            g.b.a(g.b.this).syI.b(localk);
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
  
  final class c
    extends o
  {
    public String sBi = "";
    
    public c(List<Integer> paramList, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
    {
      super(paramString1, paramString2, paramMap, paramString3, str);
    }
  }
  
  final class d
    extends a
  {
    private d() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52774);
      com.tencent.mm.kernel.g.agR().ghG.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
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
    j syx;
    
    public e(j paramj)
    {
      this.syx = paramj;
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
    private String dby;
    
    public f(int paramInt, String paramString)
    {
      this.count = paramInt;
      this.dby = paramString;
    }
    
    private static String H(String[] paramArrayOfString)
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
      if (g.this.sBe == null)
      {
        localObject = i.aSr("/sdcard/test_insert_msg_words.txt");
        g.this.sBe = ((String)localObject).split(",");
      }
      int i;
      label97:
      String str;
      bo localbo;
      if (g.this.sBf == null)
      {
        g.this.sBf = new ArrayList();
        if (!bs.isNullOrNil(this.dby)) {
          g.this.sBf.add(this.dby);
        }
      }
      else
      {
        if (g.this.sBe == null) {
          break label364;
        }
        i = 0;
        if (i >= this.count) {
          break label364;
        }
        str = H(g.this.sBe);
        localbo = new bo();
        localbo.setType(1);
        localbo.jT(1);
        localbo.setStatus(4);
        localbo.setContent(str);
        localObject = g.this.sBf;
        if (((List)localObject).size() <= 1) {
          break label350;
        }
      }
      label350:
      for (Object localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size() - 1));; localObject = (String)((List)localObject).get(0))
      {
        localbo.re((String)localObject);
        localbo.oA(System.currentTimeMillis() - 250327040L);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
        ac.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(str.length()), Long.valueOf(localbo.field_msgId) });
        i += 1;
        break label97;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().far();
        while (((Cursor)localObject).moveToNext()) {
          g.this.sBf.add(((Cursor)localObject).getString(0));
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
    
    private static String H(String[] paramArrayOfString)
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
      if (g.this.sBe == null)
      {
        localObject = i.aSr("/sdcard/test_insert_msg_words.txt");
        g.this.sBe = ((String)localObject).split(",");
      }
      if (g.this.sBf == null)
      {
        g.this.sBf = new ArrayList();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().far();
        while (((Cursor)localObject).moveToNext()) {
          g.this.sBf.add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
      }
      if (g.this.sBe != null)
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
            String str = H(g.this.sBe);
            bo localbo = new bo();
            localbo.setType(1);
            localbo.jT(1);
            localbo.setStatus(4);
            localbo.setContent(str);
            localbo.re((String)g.this.sBf.get(i));
            localbo.oA(System.currentTimeMillis());
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
            ac.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localObject[i]), Integer.valueOf(str.length()), Long.valueOf(localbo.field_msgId) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g
 * JD-Core Version:    0.7.0.1
 */