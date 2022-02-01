package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h;
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
  private m grs;
  private f hPn;
  String[] txF;
  List<String> txG;
  
  public g()
  {
    AppMethodBeat.i(52779);
    this.hPn = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(52766);
        if ((paramAnonymousn instanceof g.c))
        {
          paramAnonymousn = (g.c)paramAnonymousn;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            List localList = paramAnonymousn.ELU;
            if (paramAnonymousInt2 == -44)
            {
              LinkedList localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(1));
              HashMap localHashMap = new HashMap();
              localHashMap.put(localList.get(0), Integer.valueOf(0));
              paramAnonymousn = new g.c(g.this, localList, localLinkedList, "你好，我是珍惜", paramAnonymousn.txJ, localHashMap, paramAnonymousn.txJ);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousn, 0);
            }
            if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -24) && (!bt.isNullOrNil(paramAnonymousString))) {
              Toast.makeText(aj.getContext(), paramAnonymousString, 1).show();
            }
            AppMethodBeat.o(52766);
            return;
          }
          ad.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[] { paramAnonymousn.ELU.toString() });
        }
        AppMethodBeat.o(52766);
      }
    };
    AppMethodBeat.o(52779);
  }
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(52781);
    switch (paramj.jQN)
    {
    case 65522: 
    default: 
      paramj = new a((byte)0);
    }
    for (;;)
    {
      paramj = this.grs.a(2147483647, paramj);
      AppMethodBeat.o(52781);
      return paramj;
      paramj = new f(paramj.tvg, paramj.talker);
      continue;
      paramj = new g((byte)0);
      continue;
      paramj = new e(paramj);
      continue;
      paramj = new d((byte)0);
      continue;
      paramj = new g.b(this, paramj);
    }
  }
  
  public final boolean agA()
  {
    AppMethodBeat.i(52782);
    com.tencent.mm.kernel.g.aiU().b(30, this.hPn);
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
      ad.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
      AppMethodBeat.o(52780);
      return false;
    }
    ad.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
    this.grs = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
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
  
  final class c
    extends o
  {
    public String txJ = "";
    
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
      com.tencent.mm.kernel.g.ajC().gBq.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
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
    j tuY;
    
    public e(j paramj)
    {
      this.tuY = paramj;
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
    private String dmU;
    
    public f(int paramInt, String paramString)
    {
      this.count = paramInt;
      this.dmU = paramString;
    }
    
    private static String I(String[] paramArrayOfString)
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
      if (g.this.txF == null)
      {
        localObject = com.tencent.mm.vfs.i.aYq("/sdcard/test_insert_msg_words.txt");
        g.this.txF = ((String)localObject).split(",");
      }
      int i;
      label97:
      String str;
      bu localbu;
      if (g.this.txG == null)
      {
        g.this.txG = new ArrayList();
        if (!bt.isNullOrNil(this.dmU)) {
          g.this.txG.add(this.dmU);
        }
      }
      else
      {
        if (g.this.txF == null) {
          break label364;
        }
        i = 0;
        if (i >= this.count) {
          break label364;
        }
        str = I(g.this.txF);
        localbu = new bu();
        localbu.setType(1);
        localbu.kr(1);
        localbu.setStatus(4);
        localbu.setContent(str);
        localObject = g.this.txG;
        if (((List)localObject).size() <= 1) {
          break label350;
        }
      }
      label350:
      for (Object localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size() - 1));; localObject = (String)((List)localObject).get(0))
      {
        localbu.tN((String)localObject);
        localbu.qA(System.currentTimeMillis() - 250327040L);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as(localbu);
        ad.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(str.length()), Long.valueOf(localbu.field_msgId) });
        i += 1;
        break label97;
        localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().fqu();
        while (((Cursor)localObject).moveToNext()) {
          g.this.txG.add(((Cursor)localObject).getString(0));
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
    
    private static String I(String[] paramArrayOfString)
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
      if (g.this.txF == null)
      {
        localObject = com.tencent.mm.vfs.i.aYq("/sdcard/test_insert_msg_words.txt");
        g.this.txF = ((String)localObject).split(",");
      }
      if (g.this.txG == null)
      {
        g.this.txG = new ArrayList();
        localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().fqu();
        while (((Cursor)localObject).moveToNext()) {
          g.this.txG.add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
      }
      if (g.this.txF != null)
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
            String str = I(g.this.txF);
            bu localbu = new bu();
            localbu.setType(1);
            localbu.kr(1);
            localbu.setStatus(4);
            localbu.setContent(str);
            localbu.tN((String)g.this.txG.get(i));
            localbu.qA(System.currentTimeMillis());
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as(localbu);
            ad.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localObject[i]), Integer.valueOf(str.length()), Long.valueOf(localbu.field_msgId) });
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