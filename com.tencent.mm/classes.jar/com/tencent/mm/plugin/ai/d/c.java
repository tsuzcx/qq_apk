package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a<b>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private LruCache<String, b> cache;
  
  static
  {
    AppMethodBeat.i(267384);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(b.info, "AiFinderRedDotInfo") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(267384);
  }
  
  public c(o.a parama)
  {
    super(parama, b.info, "AiFinderRedDotInfo", INDEX_CREATE);
    AppMethodBeat.i(267375);
    this.cache = new com.tencent.mm.b.h(30);
    AppMethodBeat.o(267375);
  }
  
  public final b TS(String paramString)
  {
    AppMethodBeat.i(267414);
    long l = Util.currentTicks();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267414);
      return null;
    }
    b localb = (b)this.cache.get(paramString);
    if (localb != null)
    {
      AppMethodBeat.o(267414);
      return localb;
    }
    localb = new b(paramString);
    boolean bool = super.get(localb, new String[0]);
    if (bool) {
      this.cache.put(paramString, localb);
    }
    Log.v("MicroMsg.AiFinderRedDotInfoStorage", "get by tipsId flag[%b] cost[%d] tipsId[%s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.ticksToNow(l)), paramString });
    AppMethodBeat.o(267414);
    return localb;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(267421);
    long l = Util.currentTicks();
    if (paramb == null)
    {
      AppMethodBeat.o(267421);
      return false;
    }
    if (paramb.systemRowid <= 0L)
    {
      AppMethodBeat.o(267421);
      return false;
    }
    this.cache.remove(paramb.field_tipsId);
    boolean bool = super.updateNotify(paramb, false, new String[0]);
    if (bool) {
      this.cache.put(paramb.field_tipsId, paramb);
    }
    Log.v("MicroMsg.AiFinderRedDotInfoStorage", "update flag[%b] cost[%d] info[%s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.ticksToNow(l)), paramb });
    AppMethodBeat.o(267421);
    return bool;
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(267428);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267406);
        c.this.a(paramb);
        AppMethodBeat.o(267406);
      }
    }, "Ai_thread");
    AppMethodBeat.o(267428);
  }
  
  public final int cE(List<b> paramList)
  {
    AppMethodBeat.i(267408);
    long l4 = Util.currentTicks();
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(267408);
      return -1;
    }
    int k = 0;
    int i = 0;
    long l2 = 0L;
    int j = k;
    long l1 = l2;
    for (;;)
    {
      boolean bool;
      try
      {
        long l3 = this.qpk.beginTransaction(Thread.currentThread().getId());
        j = k;
        l1 = l3;
        l2 = l3;
        paramList = paramList.iterator();
        j = i;
        l1 = l3;
        l2 = l3;
        if (paramList.hasNext())
        {
          j = i;
          l1 = l3;
          l2 = l3;
          b localb = (b)paramList.next();
          j = i;
          l1 = l3;
          l2 = l3;
          long l5 = Util.currentTicks();
          if (localb == null)
          {
            bool = false;
            break label334;
          }
          j = i;
          l1 = l3;
          l2 = l3;
          bool = super.replace(localb, false);
          if (bool)
          {
            j = i;
            l1 = l3;
            l2 = l3;
            this.cache.put(localb.field_tipsId, localb);
          }
          j = i;
          l1 = l3;
          l2 = l3;
          Log.v("MicroMsg.AiFinderRedDotInfoStorage", "replace flag[%b] cost[%d] info[%s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.ticksToNow(l5)), localb });
          break label334;
        }
        this.qpk.endTransaction(l3);
      }
      catch (Exception paramList)
      {
        l2 = l1;
        Log.printErrStackTrace("MicroMsg.AiFinderRedDotInfoStorage", paramList, "replace error", new Object[0]);
        this.qpk.endTransaction(l1);
        i = j;
        continue;
      }
      finally
      {
        this.qpk.endTransaction(l2);
        AppMethodBeat.o(267408);
      }
      Log.v("MicroMsg.AiFinderRedDotInfoStorage", "AiFinderRedDotInfoStorage replace [%d], cost[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l4)) });
      AppMethodBeat.o(267408);
      return i;
      for (;;)
      {
        break;
        label334:
        if (bool) {
          i += 1;
        }
      }
    }
  }
  
  public final int caF()
  {
    return 14;
  }
  
  public final String caG()
  {
    return "ds";
  }
  
  public final String tableName()
  {
    return "AiFinderRedDotInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.c
 * JD-Core Version:    0.7.0.1
 */