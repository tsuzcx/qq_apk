package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.h.c.ao;
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
  private int kyO = 0;
  private int kyP = 0;
  private int kyQ = 0;
  
  private a$u(a parama) {}
  
  public final String afJ()
  {
    return String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", new Object[] { Integer.valueOf(this.kyO), Integer.valueOf(this.kyP), Integer.valueOf(this.kyQ) });
  }
  
  public final boolean execute()
  {
    DW("start");
    Object localObject1 = a.b(this.kyt).entrySet().iterator();
    int i = 50;
    if (((Iterator)localObject1).hasNext())
    {
      if (Thread.interrupted())
      {
        a.a(this.kyt).commit();
        throw new InterruptedException();
      }
      if (i < 50) {
        break label517;
      }
      a.a(this.kyt).commit();
      a.a(this.kyt).beginTransaction();
      i = 0;
    }
    label517:
    for (;;)
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = ((List)((Map.Entry)localObject2).getValue()).iterator();
      long l;
      while (((Iterator)localObject3).hasNext())
      {
        l = ((Long)((Iterator)localObject3).next()).longValue();
        a.a(this.kyt).h(Long.valueOf(l));
        i += 1;
      }
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = a.d(this.kyt).DK((String)localObject2);
      if ((localObject3 != null) && (((ao)localObject3).field_username.length() > 0) && (this.kyt.G((ad)localObject3))) {
        i += this.kyt.H((ad)localObject3);
      }
      for (;;)
      {
        ((Iterator)localObject1).remove();
        a.c(this.kyt).remove(localObject2);
        this.kyO += 1;
        break;
        DW("dirtyContact");
        localObject1 = a.c(this.kyt).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          if (Thread.interrupted())
          {
            a.a(this.kyt).commit();
            throw new InterruptedException();
          }
          if (i < 50) {
            break label508;
          }
          a.a(this.kyt).commit();
          a.a(this.kyt).beginTransaction();
          i = 0;
          label343:
          localObject2 = (String)((Iterator)localObject1).next();
          l = a.d(this.kyt).DM((String)localObject2);
          localObject3 = a.d(this.kyt).DK((String)localObject2);
          if ((localObject3 == null) || (((ao)localObject3).field_username.length() <= 0) || (!this.kyt.G((ad)localObject3))) {
            break label511;
          }
          a.a(this.kyt).E((String)localObject2, l);
          i += 1;
        }
        label508:
        label511:
        for (;;)
        {
          ((Iterator)localObject1).remove();
          this.kyP += 1;
          break;
          a.a(this.kyt).commit();
          DW("timestampContact");
          localObject1 = ((PluginFTS)g.t(PluginFTS.class)).getTopHitsLogic();
          ((e)localObject1).kzw.clear();
          this.kyQ = ((e)localObject1).kzv.aVT();
          DW("topHits");
          return true;
          break label343;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.u
 * JD-Core Version:    0.7.0.1
 */