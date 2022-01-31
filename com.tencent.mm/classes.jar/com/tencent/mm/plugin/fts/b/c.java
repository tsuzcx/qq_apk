package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.fts.a.a.g.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends b
  implements h.a
{
  com.tencent.mm.plugin.fts.a.m ezf;
  com.tencent.mm.plugin.fts.c.c mUM;
  boolean mUN;
  private com.tencent.mm.sdk.b.c mUO;
  private com.tencent.mm.sdk.b.c mUP;
  private com.tencent.mm.sdk.b.c mUQ;
  com.tencent.mm.sdk.b.c mUR;
  ap mUS;
  g.a mUT;
  com.tencent.mm.plugin.fts.a.j muH;
  
  public c()
  {
    AppMethodBeat.i(136761);
    this.mUN = false;
    this.mUO = new com.tencent.mm.sdk.b.c() {};
    this.mUP = new c.2(this);
    this.mUQ = new com.tencent.mm.sdk.b.c() {};
    this.mUR = new c.4(this);
    this.mUS = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new c.5(this), false);
    this.mUT = new c.6(this);
    AppMethodBeat.o(136761);
  }
  
  public static List<String> Pm(String paramString)
  {
    AppMethodBeat.i(136766);
    String str1 = paramString;
    if (paramString.length() > 16) {
      str1 = paramString.substring(0, 16);
    }
    ArrayList localArrayList = new ArrayList();
    String str2 = FTSJNIUtils.icuTokenizer(str1);
    String[] arrayOfString = str2.split(" ");
    paramString = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString.length) {
        localObject1 = paramString;
      }
      try
      {
        int j = Integer.valueOf(arrayOfString[i]).intValue();
        localObject1 = paramString;
        int k = Integer.valueOf(arrayOfString[(i + 1)]).intValue();
        localObject1 = paramString;
        int m = Integer.valueOf(arrayOfString[(i + 2)]).intValue();
        localObject1 = paramString;
        String str3 = str1.substring(j, k);
        Object localObject2;
        if ((m >= 400) && (m < 500))
        {
          if (k - j == 1)
          {
            localObject1 = paramString;
            paramString.append(str3);
          }
          else
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (paramString.length() > 0)
            {
              localObject1 = paramString;
              localArrayList.add(paramString.toString());
              localObject1 = paramString;
              localObject2 = new StringBuffer();
            }
            localObject1 = localObject2;
            localArrayList.add(str3);
            paramString = (String)localObject2;
          }
        }
        else
        {
          localObject2 = paramString;
          localObject1 = paramString;
          if (paramString.length() > 0)
          {
            localObject1 = paramString;
            localArrayList.add(paramString.toString());
            localObject1 = paramString;
            localObject2 = new StringBuffer();
          }
          paramString = (String)localObject2;
          localObject1 = localObject2;
          if (!str3.equals("*"))
          {
            paramString = (String)localObject2;
            localObject1 = localObject2;
            if (!str3.equals(" "))
            {
              localObject1 = localObject2;
              localArrayList.add(str3);
              paramString = (String)localObject2;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = (String)localObject1;
        }
      }
      if (paramString.length() > 0) {
        localArrayList.add(paramString.toString());
      }
      ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[] { localArrayList, str2 });
      AppMethodBeat.o(136766);
      return localArrayList;
      i += 3;
    }
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136764);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(this);
    this.mUR.dead();
    this.mUQ.dead();
    this.mUP.dead();
    this.mUO.dead();
    this.mUM = null;
    this.ezf = null;
    AppMethodBeat.o(136764);
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(i parami)
  {
    AppMethodBeat.i(136762);
    switch (parami.hdl)
    {
    default: 
      parami = new i(parami);
    }
    for (;;)
    {
      parami = this.ezf.a(-65536, parami);
      AppMethodBeat.o(136762);
      return parami;
      parami = new c.f(this, parami);
      continue;
      ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.mRj.mRp) });
      if (e.mRj.mRp >= 1000000L)
      {
        parami = new c.g(this, parami);
      }
      else
      {
        parami = new i(parami);
        continue;
        parami = new h(parami);
        continue;
        parami = new c.e(this, parami);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(136765);
    if (paramc.oDP.equals("insert"))
    {
      paramh = new ArrayList();
      int j = 0;
      if (j < paramc.oDQ.size())
      {
        bi localbi = (bi)paramc.oDQ.get(j);
        int i;
        if ((localbi == null) || (bo.isNullOrNil(localbi.field_talker)) || (bo.isNullOrNil(localbi.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            paramh.add(localbi);
          }
          j += 1;
          break;
          if (localbi.field_talker.endsWith("@app")) {
            i = 0;
          } else if (localbi.field_talker.contains("@bottle")) {
            i = 0;
          } else if ((localbi.getType() != 1) && (!localbi.bCn()) && (!localbi.bCp())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (paramh.size() > 0) {
        this.ezf.a(65576, new c.c(this, paramh));
      }
    }
    AppMethodBeat.o(136765);
  }
  
  public final String getName()
  {
    return "FTS5SearchMessageLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(136763);
    if (!((n)com.tencent.mm.kernel.g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      AppMethodBeat.o(136763);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.mUM = ((com.tencent.mm.plugin.fts.c.c)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(4));
    this.ezf = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSTaskDaemon();
    this.muH = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSMainDB();
    this.mUR.alive();
    this.mUQ.alive();
    this.mUP.alive();
    this.mUO.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(this, null);
    AppMethodBeat.o(136763);
    return true;
  }
  
  final class h
    extends com.tencent.mm.plugin.fts.a.a.h
  {
    public h(i parami)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      AppMethodBeat.i(136758);
      Pg("start");
      paramj.mRX = com.tencent.mm.plugin.fts.a.a.g.a(this.mSJ.query, false, c.this.mUT);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.g.aU(this.mSJ.mSO, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, null, com.tencent.mm.plugin.fts.a.c.mQJ, com.tencent.mm.plugin.fts.a.c.mQN);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).mRV = ((Cursor)localObject3).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).mRU = ((Cursor)localObject3).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).mRX = ((com.tencent.mm.plugin.fts.a.a.g)localObject1);
        if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject4).mRV)) {
          ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.m)localObject4).mRV, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      Pg("findHitContact");
      Object localObject4 = c.this.mUM.a(paramj.mRX, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m().g((Cursor)localObject4);
        localm.mRX = paramj.mRX;
        localm.userData = Integer.valueOf(1);
        label297:
        l locall;
        int i;
        if (((HashMap)localObject3).containsKey(localm.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localm.talker);
          if (!((HashMap)localObject1).containsKey(localm.mRV)) {
            break label422;
          }
          locall = (l)((HashMap)localObject1).get(localm.mRV);
          i = ((Integer)locall.userData).intValue() + 1;
          if (locall.timestamp >= localm.timestamp) {
            break label398;
          }
          localm.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localm.mRV, localm);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localm.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label297;
          label398:
          locall.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(locall.mRV, locall);
          continue;
          label422:
          ((HashMap)localObject1).put(localm.mRV, localm);
        }
      }
      ((Cursor)localObject4).close();
      paramj.mSW = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (l)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((l)localObject2).mRV))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((l)localObject2).mRV)).values());
          Collections.sort((List)localObject4, this.mSJ.mST);
          ((l)localObject2).userData = localObject4;
          ((l)localObject2).timestamp = ((l)((List)localObject4).get(0)).timestamp;
          paramj.mSW.add(localObject2);
        }
      }
      Collections.sort(paramj.mSW, this.mSJ.mST);
      Pg("findHitMessage");
      AppMethodBeat.o(136758);
    }
    
    public final int getId()
    {
      return 28;
    }
    
    public final String getName()
    {
      return "SearchTalkerMessageTask";
    }
  }
  
  final class i
    extends com.tencent.mm.plugin.fts.a.a.h
  {
    private int mVg = 0;
    private int mVh = 0;
    
    public i(i parami)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      AppMethodBeat.i(136759);
      Pg("start");
      paramj.mRX = com.tencent.mm.plugin.fts.a.a.g.a(this.mSJ.query, false, c.this.mUT);
      Object localObject2 = c.this.mUM;
      Object localObject1 = paramj.mRX;
      int i = this.mSJ.mSR;
      String str = ((com.tencent.mm.plugin.fts.a.a.g)localObject1).bBX();
      if (i != 2147483647) {}
      for (localObject1 = " LIMIT " + (i + 1);; localObject1 = "")
      {
        localObject1 = String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.c)localObject2).bBS(), ((com.tencent.mm.plugin.fts.c.c)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.c)localObject2).bBS(), ((com.tencent.mm.plugin.fts.c.c)localObject2).bBS(), str });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject2).mQr.rawQuery((String)localObject1, null);
        paramj.mSW = new LinkedList();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new l();
          ((l)localObject2).type = ((Cursor)localObject1).getInt(0);
          ((l)localObject2).mRU = ((Cursor)localObject1).getInt(1);
          ((l)localObject2).mSZ = ((Cursor)localObject1).getLong(2);
          ((l)localObject2).mRV = ((Cursor)localObject1).getString(3);
          ((l)localObject2).timestamp = ((Cursor)localObject1).getLong(4);
          ((l)localObject2).userData = Integer.valueOf(((Cursor)localObject1).getInt(5));
          paramj.mSW.add(localObject2);
          i = this.mVg;
          this.mVg = (((Integer)((l)localObject2).userData).intValue() + i);
          this.mVh += 1;
        }
      }
      ((Cursor)localObject1).close();
      Pg("groupMessage");
      if (paramj.mRX.mSz.length > 1)
      {
        localObject1 = com.tencent.mm.plugin.fts.a.a.g.aU(paramj.mRX.mSz[0], true);
        localObject1 = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, null, com.tencent.mm.plugin.fts.a.c.mQJ, com.tencent.mm.plugin.fts.a.c.mQN);
        if (((Cursor)localObject1).moveToNext())
        {
          localObject2 = new l();
          ((l)localObject2).mRV = "create_talker_message​";
          paramj.mSW.add(0, localObject2);
        }
        ((Cursor)localObject1).close();
        Pg("findTalkerConversation");
      }
      AppMethodBeat.o(136759);
    }
    
    public final String aAn()
    {
      AppMethodBeat.i(136760);
      String str = String.format("{totalMsgCount: %d conversationCount: %d}", new Object[] { Integer.valueOf(this.mVg), Integer.valueOf(this.mVh) });
      AppMethodBeat.o(136760);
      return str;
    }
    
    public final int getId()
    {
      return 15;
    }
    
    public final String getName()
    {
      return "SearchTopGroupMessageTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */