package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.mm.h.a.ol;
import com.tencent.mm.h.a.pr;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c
  extends b
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g.a, j.a
{
  com.tencent.mm.plugin.fts.a.m dBO;
  com.tencent.mm.plugin.fts.a.j kal;
  com.tencent.mm.plugin.fts.c.c kyW;
  boolean kyX = false;
  private com.tencent.mm.sdk.b.c kyY = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c kyZ = new c.2(this);
  private com.tencent.mm.sdk.b.c kza = new com.tencent.mm.sdk.b.c() {};
  com.tencent.mm.sdk.b.c kzb = new c.4(this);
  am kzc = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new c.5(this), false);
  com.tencent.mm.plugin.fts.a.a.g.a kzd = new c.6(this);
  
  public static List<String> Ec(String paramString)
  {
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
      y.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[] { localArrayList, str2 });
      return localArrayList;
      i += 3;
    }
  }
  
  protected final boolean BB()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().d(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(this);
    this.kzb.dead();
    this.kza.dead();
    this.kyZ.dead();
    this.kyY.dead();
    this.kyW = null;
    this.dBO = null;
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(i parami)
  {
    switch (parami.kwX)
    {
    default: 
      parami = new c.k(this, parami);
    }
    for (;;)
    {
      return this.dBO.a(-65536, parami);
      parami = new c.h(this, parami);
      continue;
      y.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", new Object[] { Long.valueOf(e.kvw.kvB) });
      if (e.kvw.kvB >= 1000000L)
      {
        parami = new c.i(this, parami);
      }
      else
      {
        parami = new c.k(this, parami);
        continue;
        parami = new j(parami);
        continue;
        parami = new c.g(this, parami);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.g paramg, g.c paramc)
  {
    if (paramc.mdt.equals("insert"))
    {
      paramg = new ArrayList();
      int j = 0;
      if (j < paramc.mdu.size())
      {
        bi localbi = (bi)paramc.mdu.get(j);
        int i;
        if ((localbi == null) || (bk.bl(localbi.field_talker)) || (bk.bl(localbi.field_content))) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            paramg.add(localbi);
          }
          j += 1;
          break;
          if (localbi.field_talker.endsWith("@app")) {
            i = 0;
          } else if (localbi.field_talker.contains("@bottle")) {
            i = 0;
          } else if ((localbi.getType() != 1) && (!localbi.aVK()) && (!localbi.aVM())) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      if (paramg.size() > 0) {
        this.dBO.a(65576, new c.e(this, paramg));
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    paramString = paramString.split(" ");
    if ((paramString == null) || (paramString.length == 0)) {}
    do
    {
      return;
      if (paramString[0].equals("delete_id"))
      {
        long l = bk.getLong(paramString[1], 0L);
        this.dBO.a(65576, new c.c(this, l));
        return;
      }
      if (paramString[0].equals("delete_talker"))
      {
        paramString = paramString[1];
        this.dBO.a(65576, new c.d(this, paramString));
        return;
      }
    } while ((!paramString[0].equals("delete_all")) || (!paramString[1].equals("message")));
    this.dBO.a(65576, new c.b(this, (byte)0));
  }
  
  public final String getName()
  {
    return "FTS5SearchMessageLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)com.tencent.mm.kernel.g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
    this.kyW = ((com.tencent.mm.plugin.fts.c.c)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(4));
    this.dBO = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSTaskDaemon();
    this.kal = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSMainDB();
    this.kzb.cqo();
    this.kza.cqo();
    this.kyZ.cqo();
    this.kyY.cqo();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().c(this);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().a(this, null);
    return true;
  }
  
  private final class j
    extends h
  {
    public j(i parami)
    {
      super();
    }
    
    protected final void a(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      DW("start");
      paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.a(this.kwT.bVk, false, c.this.kzd);
      Object localObject1 = com.tencent.mm.plugin.fts.a.a.g.aF(this.kwT.kwZ, true);
      Object localObject2 = new HashMap();
      Object localObject3 = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, null, com.tencent.mm.plugin.fts.a.c.kuW, com.tencent.mm.plugin.fts.a.c.kva);
      do
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        localObject4 = new com.tencent.mm.plugin.fts.a.a.m();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).kwg = ((Cursor)localObject3).getString(0);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).type = ((Cursor)localObject3).getInt(1);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).kwf = ((Cursor)localObject3).getInt(2);
        ((com.tencent.mm.plugin.fts.a.a.m)localObject4).kwi = ((com.tencent.mm.plugin.fts.a.a.g)localObject1);
        if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.m)localObject4).kwg)) {
          ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.m)localObject4).kwg, localObject4);
        }
      } while (((HashMap)localObject2).size() <= 100);
      ((Cursor)localObject3).close();
      DW("findHitContact");
      Object localObject4 = c.this.kyW.a(paramj.kwi, null, ((HashMap)localObject2).keySet());
      localObject3 = new HashMap();
      if (((Cursor)localObject4).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m().h((Cursor)localObject4);
        localm.kwi = paramj.kwi;
        localm.userData = Integer.valueOf(1);
        label292:
        com.tencent.mm.plugin.fts.a.a.l locall;
        int i;
        if (((HashMap)localObject3).containsKey(localm.talker))
        {
          localObject1 = (HashMap)((HashMap)localObject3).get(localm.talker);
          if (!((HashMap)localObject1).containsKey(localm.kwg)) {
            break label417;
          }
          locall = (com.tencent.mm.plugin.fts.a.a.l)((HashMap)localObject1).get(localm.kwg);
          i = ((Integer)locall.userData).intValue() + 1;
          if (locall.timestamp >= localm.timestamp) {
            break label393;
          }
          localm.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(localm.kwg, localm);
        }
        for (;;)
        {
          ((HashMap)localObject3).put(localm.talker, localObject1);
          break;
          localObject1 = new HashMap();
          break label292;
          label393:
          locall.userData = Integer.valueOf(i);
          ((HashMap)localObject1).put(locall.kwg, locall);
          continue;
          label417:
          ((HashMap)localObject1).put(localm.kwg, localm);
        }
      }
      ((Cursor)localObject4).close();
      paramj.kxh = new ArrayList();
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.l)((Iterator)localObject1).next();
        if (((HashMap)localObject3).containsKey(((com.tencent.mm.plugin.fts.a.a.l)localObject2).kwg))
        {
          localObject4 = new ArrayList();
          ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((com.tencent.mm.plugin.fts.a.a.l)localObject2).kwg)).values());
          Collections.sort((List)localObject4, this.kwT.kxe);
          ((com.tencent.mm.plugin.fts.a.a.l)localObject2).userData = localObject4;
          ((com.tencent.mm.plugin.fts.a.a.l)localObject2).timestamp = ((com.tencent.mm.plugin.fts.a.a.l)((List)localObject4).get(0)).timestamp;
          paramj.kxh.add(localObject2);
        }
      }
      Collections.sort(paramj.kxh, this.kwT.kxe);
      DW("findHitMessage");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c
 * JD-Core Version:    0.7.0.1
 */