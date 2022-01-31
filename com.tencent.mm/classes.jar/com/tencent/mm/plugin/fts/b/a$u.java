package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class a$u
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int mUD = 0;
  private int mUE = 0;
  private int mUF = 0;
  
  private a$u(a parama) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(136694);
    String str = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.mUD), Integer.valueOf(this.mUE), Integer.valueOf(this.mUF) });
    AppMethodBeat.o(136694);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136693);
    Pg("start");
    Object localObject1 = a.b(this.mUg).entrySet().iterator();
    int i = 50;
    if (((Iterator)localObject1).hasNext())
    {
      if (Thread.interrupted())
      {
        a.a(this.mUg).commit();
        localObject1 = new InterruptedException();
        AppMethodBeat.o(136693);
        throw ((Throwable)localObject1);
      }
      if (i < 50) {
        break label545;
      }
      a.a(this.mUg).commit();
      a.a(this.mUg).beginTransaction();
      i = 0;
    }
    label536:
    label539:
    label545:
    for (;;)
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      long l;
      while (((Iterator)localObject3).hasNext())
      {
        l = ((Long)((Iterator)localObject3).next()).longValue();
        a.a(this.mUg).g(Long.valueOf(l));
        i += 1;
      }
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = a.d(this.mUg).OT((String)localObject2);
      if ((localObject3 != null) && (((aq)localObject3).field_username.length() > 0) && (this.mUg.H((ad)localObject3))) {
        i += this.mUg.I((ad)localObject3);
      }
      for (;;)
      {
        ((Iterator)localObject1).remove();
        a.c(this.mUg).remove(localObject2);
        this.mUD += 1;
        break;
        Pg("dirtyContact");
        localObject1 = a.c(this.mUg).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          if (Thread.interrupted())
          {
            a.a(this.mUg).commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(136693);
            throw ((Throwable)localObject1);
          }
          if (i < 50) {
            break label536;
          }
          a.a(this.mUg).commit();
          a.a(this.mUg).beginTransaction();
          i = 0;
          label366:
          localObject2 = (String)((Iterator)localObject1).next();
          l = a.d(this.mUg).OV((String)localObject2);
          localObject3 = a.d(this.mUg).OT((String)localObject2);
          if ((localObject3 == null) || (((aq)localObject3).field_username.length() <= 0) || (!this.mUg.H((ad)localObject3))) {
            break label539;
          }
          a.a(this.mUg).W((String)localObject2, l);
          i += 1;
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          this.mUE += 1;
          break;
          a.a(this.mUg).commit();
          Pg("timestampContact");
          localObject1 = ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic();
          ((e)localObject1).mVm.clear();
          this.mUF = ((e)localObject1).mVl.bCw();
          Pg("topHits");
          AppMethodBeat.o(136693);
          return true;
          break label366;
        }
      }
    }
  }
  
  public final int getId()
  {
    return 16;
  }
  
  public final String getName()
  {
    return "UpdateDirtyAndTimestampContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.u
 * JD-Core Version:    0.7.0.1
 */