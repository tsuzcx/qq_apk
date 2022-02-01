package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class i
  extends b
{
  private String[] Hwq;
  private List<String> Hwr;
  private com.tencent.mm.am.h maV;
  private m msU;
  
  public i()
  {
    AppMethodBeat.i(52779);
    this.maV = new i.1(this);
    AppMethodBeat.o(52779);
  }
  
  public final c a(l paraml)
  {
    AppMethodBeat.i(52781);
    switch (paraml.qRb)
    {
    case 65522: 
    default: 
      paraml = new a((byte)0);
    }
    for (;;)
    {
      paraml = this.msU.a(2147483647, paraml);
      AppMethodBeat.o(52781);
      return paraml;
      paraml = new f(paraml.Htz, paraml.talker);
      continue;
      paraml = new g((byte)0);
      continue;
      paraml = new e(paraml);
      continue;
      paraml = new d((byte)0);
      continue;
      paraml = new i.b(this, paraml);
    }
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52782);
    com.tencent.mm.kernel.h.aZW().b(30, this.maV);
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
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
      AppMethodBeat.o(52780);
      return false;
    }
    Log.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
    this.msU = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    AppMethodBeat.o(52780);
    return true;
  }
  
  final class a
    extends c
  {
    private a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52767);
      SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("For Test");
      AppMethodBeat.o(52767);
      throw localSQLiteDatabaseCorruptException;
    }
  }
  
  final class d
    extends c
  {
    private d() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52774);
      com.tencent.mm.kernel.h.baE().mCN.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
      AppMethodBeat.o(52774);
      return true;
    }
    
    public final String getName()
    {
      return "FTSClearUnReadCountTask";
    }
  }
  
  final class e
    extends c
  {
    l Htr;
    
    public e(l paraml)
    {
      this.Htr = paraml;
    }
    
    public final boolean aXz()
    {
      return true;
    }
    
    public final String getName()
    {
      return "FTSTestAddChatroomContactTask";
    }
  }
  
  final class f
    extends c
  {
    private int count;
    private String hCy;
    
    public f(int paramInt, String paramString)
    {
      this.count = paramInt;
      this.hCy = paramString;
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
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52775);
      if (i.a(i.this) == null)
      {
        localObject = y.bEn("/sdcard/test_insert_msg_words.txt");
        i.a(i.this, ((String)localObject).split(","));
      }
      int i;
      label99:
      String str;
      cc localcc;
      if (i.b(i.this) == null)
      {
        i.a(i.this, new ArrayList());
        if (!Util.isNullOrNil(this.hCy)) {
          i.b(i.this).add(this.hCy);
        }
      }
      else
      {
        if (i.a(i.this) == null) {
          break label366;
        }
        i = 0;
        if (i >= this.count) {
          break label366;
        }
        str = K(i.a(i.this));
        localcc = new cc();
        localcc.setType(1);
        localcc.pI(1);
        localcc.setStatus(4);
        localcc.setContent(str);
        localObject = i.b(i.this);
        if (((List)localObject).size() <= 1) {
          break label352;
        }
      }
      label352:
      for (Object localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size() - 1));; localObject = (String)((List)localObject).get(0))
      {
        localcc.BS((String)localObject);
        localcc.setCreateTime(System.currentTimeMillis() - 250327040L);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(localcc);
        Log.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(str.length()), Long.valueOf(localcc.field_msgId) });
        i += 1;
        break label99;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().iZU();
        while (((Cursor)localObject).moveToNext()) {
          i.b(i.this).add(((Cursor)localObject).getString(0));
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
    extends c
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
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52777);
      Object localObject;
      if (i.a(i.this) == null)
      {
        localObject = y.bEn("/sdcard/test_insert_msg_words.txt");
        i.a(i.this, ((String)localObject).split(","));
      }
      if (i.b(i.this) == null)
      {
        i.a(i.this, new ArrayList());
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().iZU();
        while (((Cursor)localObject).moveToNext()) {
          i.b(i.this).add(((Cursor)localObject).getString(0));
        }
        ((Cursor)localObject).close();
      }
      if (i.a(i.this) != null)
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
            String str = K(i.a(i.this));
            cc localcc = new cc();
            localcc.setType(1);
            localcc.pI(1);
            localcc.setStatus(4);
            localcc.setContent(str);
            localcc.BS((String)i.b(i.this).get(i));
            localcc.setCreateTime(System.currentTimeMillis());
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(localcc);
            Log.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localObject[i]), Integer.valueOf(str.length()), Long.valueOf(localcc.field_msgId) });
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
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.i
 * JD-Core Version:    0.7.0.1
 */