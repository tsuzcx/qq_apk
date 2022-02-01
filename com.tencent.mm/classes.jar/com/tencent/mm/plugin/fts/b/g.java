package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
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
  private m fUc;
  private com.tencent.mm.al.g gWw;
  String[] rsk;
  List<String> rsl;
  
  public g()
  {
    AppMethodBeat.i(52779);
    this.gWw = new com.tencent.mm.al.g()
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
            List localList = paramAnonymousn.BOW;
            if (paramAnonymousInt2 == -44)
            {
              LinkedList localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(1));
              HashMap localHashMap = new HashMap();
              localHashMap.put(localList.get(0), Integer.valueOf(0));
              paramAnonymousn = new g.c(g.this, localList, localLinkedList, "你好，我是珍惜", paramAnonymousn.rso, localHashMap, paramAnonymousn.rso);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousn, 0);
            }
            if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -24) && (!bt.isNullOrNil(paramAnonymousString))) {
              Toast.makeText(aj.getContext(), paramAnonymousString, 1).show();
            }
            AppMethodBeat.o(52766);
            return;
          }
          ad.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[] { paramAnonymousn.BOW.toString() });
        }
        AppMethodBeat.o(52766);
      }
    };
    AppMethodBeat.o(52779);
  }
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(52781);
    switch (paramj.iWB)
    {
    case 65522: 
    default: 
      paramj = new a((byte)0);
    }
    for (;;)
    {
      paramj = this.fUc.a(2147483647, paramj);
      AppMethodBeat.o(52781);
      return paramj;
      paramj = new f(paramj.rpL, paramj.talker);
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
  
  public final boolean acO()
  {
    AppMethodBeat.i(52782);
    com.tencent.mm.kernel.g.aeS().b(30, this.gWw);
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
    this.fUc = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
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
    public String rso = "";
    
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
      com.tencent.mm.kernel.g.afB().gda.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
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
    j rpD;
    
    public e(j paramj)
    {
      this.rpD = paramj;
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
    private String dec;
    
    public f(int paramInt, String paramString)
    {
      this.count = paramInt;
      this.dec = paramString;
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
      if (g.this.rsk == null)
      {
        localObject = i.aMP("/sdcard/test_insert_msg_words.txt");
        g.this.rsk = ((String)localObject).split(",");
      }
      int i;
      label97:
      String str;
      bl localbl;
      if (g.this.rsl == null)
      {
        g.this.rsl = new ArrayList();
        if (!bt.isNullOrNil(this.dec)) {
          g.this.rsl.add(this.dec);
        }
      }
      else
      {
        if (g.this.rsk == null) {
          break label364;
        }
        i = 0;
        if (i >= this.count) {
          break label364;
        }
        str = H(g.this.rsk);
        localbl = new bl();
        localbl.setType(1);
        localbl.jV(1);
        localbl.setStatus(4);
        localbl.setContent(str);
        localObject = g.this.rsl;
        if (((List)localObject).size() <= 1) {
          break label350;
        }
      }
      label350:
      for (Object localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size() - 1));; localObject = (String)((List)localObject).get(0))
      {
        localbl.nY((String)localObject);
        localbl.kY(System.currentTimeMillis() - 250327040L);
        ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().an(localbl);
        ad.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(str.length()), Long.valueOf(localbl.field_msgId) });
        i += 1;
        break label97;
        localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().eKP();
        while (((Cursor)localObject).moveToNext()) {
          g.this.rsl.add(((Cursor)localObject).getString(0));
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
      if (g.this.rsk == null)
      {
        localObject = i.aMP("/sdcard/test_insert_msg_words.txt");
        g.this.rsk = ((String)localObject).split(",");
      }
      if (g.this.rsl == null)
      {
        g.this.rsl = new ArrayList();
        localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().eKP();
        while (((Cursor)localObject).moveToNext()) {
          g.this.rsl.add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
      }
      if (g.this.rsk != null)
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
            String str = H(g.this.rsk);
            bl localbl = new bl();
            localbl.setType(1);
            localbl.jV(1);
            localbl.setStatus(4);
            localbl.setContent(str);
            localbl.nY((String)g.this.rsl.get(i));
            localbl.kY(System.currentTimeMillis());
            ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().an(localbl);
            ad.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localObject[i]), Integer.valueOf(str.length()), Long.valueOf(localbl.field_msgId) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g
 * JD-Core Version:    0.7.0.1
 */