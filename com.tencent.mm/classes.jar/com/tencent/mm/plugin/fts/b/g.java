package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class g
  extends b
{
  private String[] BLu;
  private List<String> BLv;
  private m jSC;
  private com.tencent.mm.an.i jxB;
  
  public g()
  {
    AppMethodBeat.i(52779);
    this.jxB = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(52766);
        if ((paramAnonymousq instanceof g.c))
        {
          paramAnonymousq = (g.c)paramAnonymousq;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            List localList = paramAnonymousq.QVu;
            if (paramAnonymousInt2 == -44)
            {
              LinkedList localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(1));
              HashMap localHashMap = new HashMap();
              localHashMap.put(localList.get(0), Integer.valueOf(0));
              paramAnonymousq = new g.c(g.this, localList, localLinkedList, "你好，我是珍惜", paramAnonymousq.BLy, localHashMap, paramAnonymousq.BLy);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousq, 0);
            }
            if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -24) && (!Util.isNullOrNil(paramAnonymousString))) {
              Toast.makeText(MMApplicationContext.getContext(), paramAnonymousString, 1).show();
            }
            AppMethodBeat.o(52766);
            return;
          }
          Log.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[] { paramAnonymousq.QVu.toString() });
        }
        AppMethodBeat.o(52766);
      }
    };
    AppMethodBeat.o(52779);
  }
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(52781);
    switch (paramj.nRn)
    {
    case 65522: 
    default: 
      paramj = new a((byte)0);
    }
    for (;;)
    {
      paramj = this.jSC.a(2147483647, paramj);
      AppMethodBeat.o(52781);
      return paramj;
      paramj = new f(paramj.BIR, paramj.talker);
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
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52782);
    com.tencent.mm.kernel.h.aGY().b(30, this.jxB);
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
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
      AppMethodBeat.o(52780);
      return false;
    }
    Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
    this.jSC = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    AppMethodBeat.o(52780);
    return true;
  }
  
  final class a
    extends a
  {
    private a() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52767);
      SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("For Test");
      AppMethodBeat.o(52767);
      throw localSQLiteDatabaseCorruptException;
    }
  }
  
  final class c
    extends com.tencent.mm.pluginsdk.model.t
  {
    public String BLy = "";
    
    public c(List<Integer> paramList, String paramString1, String paramString2, Map<String, Integer> paramMap, String paramString3)
    {
      super(paramList, paramString1, paramString2, paramMap, paramString3, str);
    }
  }
  
  final class d
    extends a
  {
    private d() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52774);
      com.tencent.mm.kernel.h.aHG().kcF.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
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
    j BIJ;
    
    public e(j paramj)
    {
      this.BIJ = paramj;
    }
    
    public final boolean aEv()
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
    private String fxT;
    
    public f(int paramInt, String paramString)
    {
      this.count = paramInt;
      this.fxT = paramString;
    }
    
    private static String J(String[] paramArrayOfString)
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
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52775);
      if (g.a(g.this) == null)
      {
        localObject = u.bBS("/sdcard/test_insert_msg_words.txt");
        g.a(g.this, ((String)localObject).split(","));
      }
      int i;
      label99:
      String str;
      ca localca;
      if (g.b(g.this) == null)
      {
        g.a(g.this, new ArrayList());
        if (!Util.isNullOrNil(this.fxT)) {
          g.b(g.this).add(this.fxT);
        }
      }
      else
      {
        if (g.a(g.this) == null) {
          break label366;
        }
        i = 0;
        if (i >= this.count) {
          break label366;
        }
        str = J(g.a(g.this));
        localca = new ca();
        localca.setType(1);
        localca.pJ(1);
        localca.setStatus(4);
        localca.setContent(str);
        localObject = g.b(g.this);
        if (((List)localObject).size() <= 1) {
          break label352;
        }
      }
      label352:
      for (Object localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size() - 1));; localObject = (String)((List)localObject).get(0))
      {
        localca.Jm((String)localObject);
        localca.setCreateTime(System.currentTimeMillis() - 250327040L);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aM(localca);
        Log.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(str.length()), Long.valueOf(localca.field_msgId) });
        i += 1;
        break label99;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().hym();
        while (((Cursor)localObject).moveToNext()) {
          g.b(g.this).add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
        break;
      }
      label366:
      AppMethodBeat.o(52775);
      return true;
    }
  }
  
  final class g
    extends a
  {
    private g() {}
    
    private static String J(String[] paramArrayOfString)
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
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52777);
      Object localObject;
      if (g.a(g.this) == null)
      {
        localObject = u.bBS("/sdcard/test_insert_msg_words.txt");
        g.a(g.this, ((String)localObject).split(","));
      }
      if (g.b(g.this) == null)
      {
        g.a(g.this, new ArrayList());
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().hym();
        while (((Cursor)localObject).moveToNext()) {
          g.b(g.this).add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
      }
      if (g.a(g.this) != null)
      {
        localObject = new int[7];
        Object tmp133_132 = localObject;
        tmp133_132[0] = 1000;
        Object tmp139_133 = tmp133_132;
        tmp139_133[1] = 2000;
        Object tmp145_139 = tmp139_133;
        tmp145_139[2] = 5000;
        Object tmp151_145 = tmp145_139;
        tmp151_145[3] = 10000;
        Object tmp157_151 = tmp151_145;
        tmp157_151[4] = 20000;
        Object tmp163_157 = tmp157_151;
        tmp163_157[5] = 50000;
        Object tmp168_163 = tmp163_157;
        tmp168_163[6] = 100000;
        tmp168_163;
        int i = 0;
        while (i < 7)
        {
          int j = 0;
          while (j < localObject[i])
          {
            String str = J(g.a(g.this));
            ca localca = new ca();
            localca.setType(1);
            localca.pJ(1);
            localca.setStatus(4);
            localca.setContent(str);
            localca.Jm((String)g.b(g.this).get(i));
            localca.setCreateTime(System.currentTimeMillis());
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aM(localca);
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